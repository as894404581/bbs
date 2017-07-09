package xyz.zhtdemo.bbs.servlet;



import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.zhtdemo.bbs.entity.Attachment_InfoEnt;
import xyz.zhtdemo.bbs.entity.PostEnt;
import xyz.zhtdemo.bbs.entity.Reply_PostEnt;
import xyz.zhtdemo.bbs.entity.TardelogEnt;
import xyz.zhtdemo.bbs.entity.UserEnt;
import xyz.zhtdemo.bbs.enums.T_typeEnum;
import xyz.zhtdemo.bbs.enums.TradeIntegralTypesEnum;
import xyz.zhtdemo.bbs.enums.TradeTypeEnum;
import xyz.zhtdemo.bbs.error.LengthOutException;
import xyz.zhtdemo.bbs.error.ParameterException;
import xyz.zhtdemo.bbs.error.SessionException;
import xyz.zhtdemo.bbs.inter.AttachmentService;
import xyz.zhtdemo.bbs.inter.PostService;
import xyz.zhtdemo.bbs.inter.Reply_PostService;
import xyz.zhtdemo.bbs.inter.TardelogService;
import xyz.zhtdemo.bbs.inter.UserService;
import xyz.zhtdemo.bbs.util.AttachmentUtil;
import xyz.zhtdemo.bbs.util.IntegralUtil;
import xyz.zhtdemo.bbs.util.JsonResult;
import xyz.zhtdemo.bbs.util.SacheData;
import xyz.zhtdemo.bbs.util.Util;

@Controller
public class PostServlet {
	@Resource
	private PostService ps;
	@Resource
	private UserService us;
	@Resource
	private Reply_PostService rs;
	@Resource
	private AttachmentUtil au;
	@Resource
	private TardelogService ts;
	@Resource
	private IntegralUtil iu;
	@Resource
	private AttachmentService as;
	
	/**
	 * 更新帖子内容
	 * 
	 * @param text
	 *            帖子文本
	 * @param titl帖子标题
	 * @param session
	 * @param fid
	 *            板块id
	 * @param vid
	 *            帖子id
	 * @return
	 */
	@RequestMapping("updatepost.go")
	@ResponseBody
	@Transactional
	public Object updatePost(String text, String titl, HttpSession session, int fid, int vid,Integer[] aArr,Integer gIndex,Integer price) {
		UserEnt uEnt = (UserEnt) session.getAttribute("USER");
		if (ps.getUserByVid(vid).getIssue_userid().intValue() != uEnt.getId().intValue()) 
			return new JsonResult(new SessionException("请求非法"),01);
		if (titl.length() > 50) 
			return new JsonResult(new LengthOutException("标题超出长度!"),03);
		PostEnt pe=new PostEnt();
		pe.setId(vid);
		pe.setIssue_userid(uEnt.getId());
		au.ReplacePostAttachmentIn(pe,aArr);
		titl=Util.toUTF8(titl);
		text=Util.toUTF8(text);
		if (ps.updatePost(new PostEnt(vid, fid, titl, text, uEnt.getId(), null, null, null, null, null, price,0==gIndex?SacheData.PlateMap.get(fid).getAccess_rights():SacheData.User_GroupMap.get(gIndex).getAccess_rights(),null, null)) > 0) {
			SacheData.state = 1;
			return new JsonResult("success");
		}

		return new JsonResult(new ParameterException("更新失败"),500);
	}

	/**
	 * 根据帖子id删除帖子
	 * 
	 * @param vid
	 *            帖子id
	 */
	@RequestMapping("postdelete.do")
	@Transactional
	public void postdelete(int vid) {

	}

	/**
	 * 发表主题帖子
	 * 
	 * @param text
	 *            帖子内容
	 * @param titl
	 *            帖子标题
	 * @param session
	 * @param fid
	 *            板块id
	 * @return
	 */
	@RequestMapping("publish.go")
	@ResponseBody
	public Object publish(String text, String titl, HttpSession session, int fid,Integer[] aArr,Integer gIndex,Integer price) {
		if (titl.length() > 50) 
			return new JsonResult(new LengthOutException("标题超出长度!"),03);
		UserEnt ue = (UserEnt) session.getAttribute("USER");
		titl=Util.toUTF8(titl);
		text=Util.toUTF8(text);
		// 插入帖子到数据库
		PostEnt pe = new PostEnt();
		pe.setPlate_id(fid);
		pe.setTitle(titl);
		pe.setContent(text);
		pe.setIssue_userid(ue.getId());
		pe.setSee_count(0);
		pe.setReply_count(0);
		pe.setPrice(price);
		pe.setAccess_rights(0==gIndex?SacheData.PlateMap.get(fid).getAccess_rights():SacheData.User_GroupMap.get(gIndex).getAccess_rights());
		ps.addPost(pe);
		au.ReplacePostAttachmentIn(pe,aArr);
		
		return new JsonResult(pe.getId());

	}

	/**
	 * 转发到显示主题页面
	 * 
	 * @param id
	 *            主题帖id
	 * @param map
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping("viewthread.go")
	public String view(HttpServletResponse response,HttpSession session, HttpServletRequest request, int fid, int vid, int page,
			ModelMap map) throws ServletException, IOException {
		if (page < 1)
			throw new ParameterException("pageError");
		// 获取cookie
		Cookie[] cookies = request.getCookies();
		boolean see = false;
		if (cookies != null) {
			for (Cookie c : cookies) {
				// 对比该帖子是否看过
				if (c.getName().equals("vvid") && c.getValue().equals(vid + "")) {
					see = true;
					break;
				}
			}
		}
		UserEnt ue=(UserEnt)session.getAttribute("USER");
		
		int gid=4;
		if(null!=ue){
			if(ue.getAgid()!=null)
				gid=ue.getAgid();
			else
				gid=ue.getGid();
		}
		// 获取帖子
		PostEnt pe = ps.getPostByVid(vid);
		if(null==pe)
			return "error404";
		
		if(SacheData.User_GroupMap.get(gid).getAccess_rights()< pe.getAccess_rights() && pe.getIssue_userid()!=(null==ue?0:ue.getId())){
			request.setAttribute("TITL", "无权访问");
			int postAccess_right=pe.getAccess_rights() ;
			int userAccess_right=SacheData.User_GroupMap.get(gid).getAccess_rights();
			request.setAttribute("MSG", "您现所在的用户组无权访问该帖子!"
					+ "该帖子需要阅读权限:"+postAccess_right+"以上才能查看,当前阅读权限:"+userAccess_right);
			request.setAttribute("A_URL", "index.do");
			request.getRequestDispatcher("error.do").forward(request, response);
		}
		
		if(pe.getPrice()!=0){
			if(null==ue || (ts.getTardelog(new TardelogEnt(null, ue.getId(), vid, null, null, null, T_typeEnum.post,null,TradeTypeEnum.buy))==null && pe.getIssue_userid().intValue()!=ue.getId().intValue())){
				pe.setContent("当前主题需要购买,价格:"+pe.getPrice()+"  <a href='javascript:;' onclick=buy("+vid+","+pe.getPrice()+",'post') >购买主题!</a>");
			}else{
				pe.setContent(au.ReplacePostAttachmentOut(ue.getId(),pe.getContent() ,vid,AttachmentUtil.mode.VIEW));
			}
		}else{
			pe.setContent(au.ReplacePostAttachmentOut(ue==null?-1:ue.getId(),pe.getContent() ,vid,AttachmentUtil.mode.VIEW));
		}
		// 如果没看过则增加这个帖子的查看数
		if (!see) {
			Cookie cookie = new Cookie("vvid", vid + "");
			response.addCookie(cookie);
			ps.addSee_Count(vid);
		}
		
		// 判断如果帖子数不是第一页则不需要将主题帖内容发送
		if (page != 1) 
			pe.setContent(null);
		if (pe.getReply_count() == 0) 
			pe.setReply_count(1);
		page = page - 1;
		int start = page * 10;
		List<Reply_PostEnt> lrpe=rs.getReplyById(vid, start);
		for (Reply_PostEnt rpe : lrpe) {
			rpe.setContent(au.ReplaceRepAttachmentOut(ue==null?-1:ue.getId(),rpe.getContent(),vid,rpe.getId(),AttachmentUtil.mode.VIEW));
		}
		map.put("PLATE_NAME", SacheData.PlateMap.get(fid));
		map.put("PC_NAME", SacheData.PlateMap.get(SacheData.PlateMap.get(fid).getPup()));
		map.put("VIEW", pe);
		map.put("ACTION", us.getUserById(pe.getIssue_userid()));
		map.put("REPLY", lrpe);

		return "viewthread";
	}
	/**
	 * 购买主题帖
	 * @param vid 主题帖id
	 * @param session 当前会话
	 * @return
	 */
	@RequestMapping("/buy.go")
	@ResponseBody
	@Transactional
	public JsonResult buyPost(int vid,String mod,HttpSession session,HttpServletRequest req){
		//购买附件用户
		UserEnt byUe=(UserEnt)session.getAttribute("USER");
		if(byUe==null)	
			return new JsonResult(new SessionException("请先登录!"),1);
		//附件金币
		int price;
		//卖附件用户
		UserEnt sellUe;
		//买信息
		TardelogEnt buyTL;
		//卖信息
		TardelogEnt sellTl;
		//判断购买附件或帖子
		if (mod.equals("post")) {
			if ((ts.getTardelog(new TardelogEnt(null, byUe.getId(), vid, null, null, null, T_typeEnum.post,null,TradeTypeEnum.buy))!=null))
				return new JsonResult(mod);
			//获取帖子
			PostEnt pe=ps.getPostByVid(vid);
			//根据帖子发帖人的uid获取发帖人
			sellUe=us.getUserById(pe.getIssue_userid());
			//获取帖子售价
			price=pe.getPrice();
			buyTL=new TardelogEnt(null, byUe.getId(), vid, null, null, -price, T_typeEnum.post,System.currentTimeMillis(),TradeTypeEnum.buy);
			sellTl=new TardelogEnt(null, sellUe.getId(), vid, null, null, price, T_typeEnum.post,System.currentTimeMillis(),TradeTypeEnum.sell);
		}else{
			//获取回复id
			String ridStr=req.getParameter("rid");
			//获取附件详细信息
			Attachment_InfoEnt aie= as.getAieByAid(Integer.parseInt(req.getParameter("aid")));
			if ((ts.getTardelog(new TardelogEnt(null, byUe.getId(), vid, aie.getAid(), ridStr!=null?!ridStr.trim().equals("")?Integer.parseInt(ridStr):null:null, null, T_typeEnum.attachment,null,TradeTypeEnum.buy))!=null)) 
				return new JsonResult(mod);
			//获取附件价格
			price=aie.getPrice();
			//获取上传附件的用户
			sellUe=us.getUserById(aie.getUid());
			buyTL=new TardelogEnt(null, byUe.getId(), vid, aie.getAid(), null, -price, T_typeEnum.attachment,System.currentTimeMillis(),TradeTypeEnum.buy);
			sellTl=new TardelogEnt(null, sellUe.getId(), vid, aie.getAid(), null, price, T_typeEnum.attachment,System.currentTimeMillis(),TradeTypeEnum.sell);
			//判断是否是回复中的附件
			if (ridStr!=null&& !ridStr.trim().equals("")) {
				int rid=Integer.parseInt(ridStr);
				buyTL.setRid(rid);
				sellTl.setRid(rid);
			}
		}
		//获取购买者的交易积分信息
		int userIntegralCount= iu.getUserTradeIntegralCount(byUe.getId());
		if(userIntegralCount<price)
			return new JsonResult(new RuntimeException("积分不足!"),1);
		//插入购买记录与售出记录
		if(ts.insertTarde(buyTL)&&ts.insertTarde(sellTl)){
			//更新积分数量
			iu.Trade(byUe.getId(), price,TradeIntegralTypesEnum.reduce);
			iu.Trade(sellUe.getId(), price,TradeIntegralTypesEnum.increase);
			return new JsonResult(mod);
		}else{
			return new JsonResult(new ParameterException(), 1);
		}
		
	}

}
