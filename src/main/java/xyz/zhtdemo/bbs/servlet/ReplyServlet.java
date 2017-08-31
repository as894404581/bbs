package xyz.zhtdemo.bbs.servlet;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.zhtdemo.bbs.entity.PostEnt;
import xyz.zhtdemo.bbs.entity.Reply_PostEnt;
import xyz.zhtdemo.bbs.entity.UserEnt;
import xyz.zhtdemo.bbs.error.DataBaseException;
import xyz.zhtdemo.bbs.error.ParameterException;
import xyz.zhtdemo.bbs.error.SessionException;
import xyz.zhtdemo.bbs.handler.CeditHandlerInterface;
import xyz.zhtdemo.bbs.inter.PlateService;
import xyz.zhtdemo.bbs.inter.PostService;
import xyz.zhtdemo.bbs.inter.Reply_PostService;
import xyz.zhtdemo.bbs.util.AttachmentUtil;
import xyz.zhtdemo.bbs.util.JsonResult;
import xyz.zhtdemo.bbs.util.SacheData;
import xyz.zhtdemo.bbs.util.Util;
@Controller
public class ReplyServlet {
	@Resource
	private Reply_PostService rps;

	@Resource
	private PlateService pls;
	@Resource
	private PostService pos;
	@Resource
	AttachmentUtil au;

	/**
	 * 更新回复
	 * @param vid 帖子id
	 * @param rid 回复id
	 * @param text 回复内容
	 * @param session 会话
	 * @return
	 */
	@RequestMapping("repUpdate.go")
	@ResponseBody
	@CeditHandlerInterface
	public Object repUpdate(int vid,int rid,String text,Integer aArr[],HttpSession session){
		
		UserEnt uEnt = (UserEnt) session.getAttribute("USER");
		if (null==uEnt) {
			return new JsonResult(new SessionException("会话过期"),0000);
		}
		if(rps.getReplyInfoByVid(rid).getReply_userid().intValue()!=uEnt.getId().intValue()){
			return new JsonResult(new SessionException("请求非法"),01);
		}
		
		if ("".equals(text.trim())) {
			return new JsonResult(new ParameterException("回复内容为空"),03);
		}
		
		text=Util.toUTF8(text);
		Reply_PostEnt rpe=new Reply_PostEnt(rid, vid, text, null, null, null);
		au.ReplaceRepAttachmentIn(rpe, aArr);
		
		if(rps.updateReply(rpe)>0){
			return new JsonResult("success");
		}
		return new JsonResult(new DataBaseException("更新失败"),500);
	}
	
	/**
	 * 根据rid删除回复
	 * @param rid 回复序号id
	 */
	@RequestMapping("replydelete.do")
	@Transactional
	public void replydelete(int rid){
		System.out.println(rid);
		
	}
	
	/**
	 * 回复主题
	 * 
	 * @param endit
	 *            回复内容
	 * @param vid
	 *            帖子id
	 * @param session
	 * @return
	 */
	@RequestMapping("reply.go")
	@ResponseBody
	@Transactional
	@CeditHandlerInterface
	public Object Reply_Post(int fid,String endit, int vid, HttpSession session,Integer[] aArr) {
		if ("".equals(endit.trim()) || "".equals((vid+"").trim())) {
			return new JsonResult(new ParameterException("errorCode03 参数错误"),03);
		}
		UserEnt u = (UserEnt) session.getAttribute("USER");
		
		if (u == null) {
			return new JsonResult(new SessionException("会话超时"),0000);
		}
		
		endit=Util.toUTF8(endit);
		Reply_PostEnt rpe = new Reply_PostEnt(null, vid, endit, u.getId(), System.currentTimeMillis(),null);
		
		if (rps.insertReply(rpe)) {
			au.ReplaceRepAttachmentIn(rpe, aArr);
			pos.updatePostReplyCount(vid);
			pls.reply_countUp(fid);
			SacheData.PlateMap.get(fid).setReply_count(SacheData.PlateMap.get(fid).getReply_count()+1);
			pos.updatePost(new PostEnt(vid, null, null, null, null, null, null, null, u.getId(), System.currentTimeMillis(), null,null,null, null));
			return new JsonResult("success");
		} else {
			return new JsonResult(new DataBaseException("errorCode04 数据库异常"),04);
		}
	}
	
	
}
