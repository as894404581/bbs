package xyz.zhtdemo.bbs.servlet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.zhtdemo.bbs.entity.PostEnt;
import xyz.zhtdemo.bbs.entity.Reply_PostEnt;
import xyz.zhtdemo.bbs.entity.UserEnt;
import xyz.zhtdemo.bbs.entity.User_GroupEnt;
import xyz.zhtdemo.bbs.error.ParameterException;
import xyz.zhtdemo.bbs.error.SessionException;
import xyz.zhtdemo.bbs.inter.AttachmentService;
import xyz.zhtdemo.bbs.inter.PlateService;
import xyz.zhtdemo.bbs.inter.PostService;
import xyz.zhtdemo.bbs.inter.Reply_PostService;
import xyz.zhtdemo.bbs.util.AttachmentUtil;
import xyz.zhtdemo.bbs.util.JsonResult;
import xyz.zhtdemo.bbs.util.SacheData;
import xyz.zhtdemo.bbs.util.Util;

/**
 * 板块操作类
 * @author zheng
 *
 */
@Controller
public class ForumServlet {

	@Resource
	private PostService ps;
	@Resource
	private PlateService fs;
	@Resource
	private Reply_PostService rps;
	@Resource
	private AttachmentUtil au;

	/**
	 * 转发到帖子列表页面
	 * 
	 * @return
	 */
	@RequestMapping("forum.go")
	protected String forum(ModelMap map,int fid) {
		map.put("PAGE_COUNT", ((SacheData.PlateMap.get(fid).getPost_count() - 1) / 15) + 1);
		map.put("FORUM_INFO", fs.getForumInfo(fid));
		map.put("PC_NAME", SacheData.PlateMap.get(SacheData.PlateMap.get(fid).getPup()));
		return "forum";
	}
	@Resource
	private AttachmentService as;
	/**
	 * 转发到发帖页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("cedit.go")
	public String Post(HttpServletRequest req,ModelMap map,HttpSession session) {
		String type=req.getParameter("type");
		List<String> ugel=new ArrayList<String>();
		Map<Integer, User_GroupEnt> ugm=SacheData.User_GroupMap;
		ugel.add("不限");
		for (Integer key : ugm.keySet()) {
			ugel.add(ugm.get(key).getGname());
		}	
		
		map.put("USER_GROUP", ugel);
		if(type==null){
			return "cedit";
		}
		int vid=Integer.parseInt(req.getParameter("vid"));
		UserEnt ue = (UserEnt) session.getAttribute("USER");
		if(type.equals("post")){
			PostEnt pe=ps.getPostByVid(vid);
			if (ps.getPostByVid(vid).getIssue_userid().intValue() == ue.getId().intValue()) {			
				pe.setContent(au.ReplacePostAttachmentOut(ue.getId(),pe.getContent(),vid,AttachmentUtil.mode.EDIT));
				map.put("POST", pe);
			}
			for (Integer key : ugm.keySet()) {
				if(ugm.get(key).getAccess_rights()==pe.getAccess_rights()){
					map.put("ACCESS_NAME", ugm.get(key).getGname());
					break;
				}
				
			}	
		}else if(type.equals("rep")){
			int rid=Integer.parseInt(req.getParameter("rid"));
			Reply_PostEnt rpe= rps.getReplyInfoByVid(rid);
			rpe.setContent(au.ReplaceRepAttachmentOut(ue.getId(),rpe.getContent(),vid,rid,AttachmentUtil.mode.EDIT));
			if(ue.getId().intValue()==rpe.getReply_userid().intValue()){
				map.put("REPLY_POST", rpe);
			}else{
				throw new SessionException("登录过期");
			}
		}
		
		return "cedit";
	}
	/**
	 * 根据帖子标题查询
	 * 
	 * @param name
	 *            查询内容
	 * @param page
	 *            页数
	 * @param map
	 * @return
	 */
	@RequestMapping("search.go")
	public String refSearch(String name,int page, ModelMap map) {
		System.out.println(name);
		name=Util.toUTF8(name);
		if("".equals(name.trim()))
			throw new ParameterException("无效搜索参数!");
		System.out.println(name);
		page = page - 1;
		int start = page * 14;
		map.put("SEARCH_RES", fs.search(name, start));
		map.put("NAME", name);
		map.put("PAGE_COUNT",((ps.searchCount(name) - 1) / 15) + 1 );
		return "search";
	}
	/**
	 * 通过ajax实现帖子列表分页
	 * 
	 * @param num
	 *            第几页
	 * @param fid
	 *            板块id
	 * @param map
	 * @return
	 * @throws InterruptedException
	 */
	@RequestMapping("forumAjaxPost.go")
	@ResponseBody
	public Object forumAjaxPlaced(int fid, int page) throws InterruptedException {

		page = page - 1;
		int start = page * 15;
		List<PostEnt> list = fs.getPost(fid, start);

		if (list != null) {
			return new JsonResult(list);
		} else {
			return new JsonResult(new ParameterException("errorCode03:参数错误"),03);
		}

	}
	/**
	 * 错误页面
	 * @param TITL 错误页面浏览器标签名
	 * @param MSG 错误信息
	 * @param A_URL 继续跳转a标签链接
	 * @return
	 */
	@RequestMapping("error.do")
	public String error(){
		return "prompt";
	}

}
