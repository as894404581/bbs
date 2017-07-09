package xyz.zhtdemo.bbs.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.zhtdemo.bbs.entity.EmailEnt;
import xyz.zhtdemo.bbs.entity.UserEnt;
import xyz.zhtdemo.bbs.entity.User_GroupEnt;
import xyz.zhtdemo.bbs.entity.User_CountEnt;
import xyz.zhtdemo.bbs.error.DataBaseException;
import xyz.zhtdemo.bbs.error.EmailException;
import xyz.zhtdemo.bbs.error.ParameterException;
import xyz.zhtdemo.bbs.error.URLException;
import xyz.zhtdemo.bbs.inter.EmailService;
import xyz.zhtdemo.bbs.inter.UserService;
import xyz.zhtdemo.bbs.inter.User_CountService;
import xyz.zhtdemo.bbs.util.Config;
import xyz.zhtdemo.bbs.util.JsonResult;
import xyz.zhtdemo.bbs.util.SacheData;
import xyz.zhtdemo.bbs.util.Util;

/**
 * 用户基本操作类
 * @author zheng
 *
 */
@Controller
public class UserServlet {

	@Resource
	UserService us;
	@Resource
	EmailService es;
	@Resource
	User_CountService uis;
	/**
	 * 用户登出
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("logOut.do")
	private String loginOut(HttpSession session) {
		if(((UserEnt)session.getAttribute("USER"))!=null){
			session.setAttribute("USER", null);
			SacheData.OnlineUsercount--;
		}
		return "redirect:/index.do";
	}

	

	/**
	 * 验证邮箱地址
	 * @param id 验证邮箱url
	 * @param session
	 * @return
	 */
	@RequestMapping("EmailCheck.do")
	@Transactional
	protected String EmailCheck(String id,ModelMap map) {
		try {
			if (es.checkEmail(id)) {
				map.put("TITL", "激活成功");
				map.put("MSG", "激活成功请重新登录");
				map.put("A_URL", "login.html?type=log");
				return "prompt";
			} else {
				throw new URLException("errorCode:01 路径非法");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataBaseException("errorCode04:数据库异常");
		}
	}

	/**
	 * 找回密码发送邮件
	 * @param user 用户名
	 * @param email 邮箱
	 * @param request 
	 * @param session
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("lookForPass.do")
	@Transactional
	protected String LookForPass(String code,HttpSession session,String user, String email, HttpServletRequest request,ModelMap map)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		String rightcode = (String) session.getAttribute("rCode");
		session.setAttribute("rCode", "");
		if(!rightcode.equalsIgnoreCase(code)){
			throw new ParameterException("验证码不正确!");
		}
		String url = request.getScheme() + "://";
		url += request.getHeader("host");
		url += request.getContextPath() + "/alter.do";
		int userID=us.getUserByName(user).getId();
		try {
			if (es.lookForPass(email, userID, url)) {
				map.put("TITL", "发送成功");
				map.put("MSG", "重置邮件已发送到邮箱(未收到邮件请检查是否被系统拦截),请登录邮箱修改密码");
				map.put("A_URL", "index.do");
				return "prompt";
			} else {
				throw new EmailException("errorCode:02 发送邮件异常");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataBaseException("errorCode04:数据库异常");
		} catch (ParameterException e) {
			e.printStackTrace();
			throw new ParameterException("errorCode03:参数错误");
		}

	}

	/**
	 * 验证找回密码url
	 * @param code	找回密码url
	 * @param session
	 * @param response
	 * @return
	 */
	@RequestMapping("alter.do")
	@Transactional
	protected String alter(String code, HttpServletResponse response,ModelMap map) {

		Integer userId = null;
		try {
			if ((userId = es.updatePassCheckEmail(code)) == null) {
				throw new URLException("errorCode:01 路径非法");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataBaseException("errorCode04:数据库异常");
		} catch (URLException e) {
			e.printStackTrace();
			throw new URLException("errorCode01:请求路径非法");
		}
		map.put("email_url", code);
		map.put("userId", userId);
		return "updatePass";

	}

	/**
	 * 更改密码
	 * @param session
	 * @param pass 新密码
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("alterPassworld.do")
	@Transactional
	protected String alterPassworld(int userId,String email_url, String pass,ModelMap map){
		int userID=us.getUserById(userId).getId();
		try {
			if (es.updatePass(email_url, userID, pass)) {
				map.put("TITL", "更改成功");
				map.put("MSG", "更改成功请重新登录");
				map.put("A_URL", "login.html?type=log");
				return "prompt";
			} else {
				throw new ParameterException("errorCode:03 参数错误");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataBaseException("errorCode:04 数据库异常");
		} catch (URLException e) {
			e.printStackTrace();
			throw new ParameterException("errorCode:02 请求路径非法");
		}
	}

	
	/**
	 * 检查用户名是否被占用
	 * @param user 用户名
	 * @return
	 */
	@RequestMapping("/ajax/checkUser.do")
	@ResponseBody
	public Object checkUser(String user) {
		return us.checkUser(user);
	}

	/**
	 * 检查邮箱是否被占用
	 * @param email 邮箱
	 * @return
	 */
	@RequestMapping("/ajax/checkEmail.do")
	@ResponseBody
	public Object checkPass(String email) {
		return us.checkEmail(email);
	}

	/**
	 * 登录验证
	 * @param session
	 * @param user 用户名	
	 * @param pwd 密码
	 * @param code 验证码
	 * @return
	 * @throws InterruptedException 
	 */
	@RequestMapping("/ajax/log.do")
	@ResponseBody
	public Object login(HttpServletRequest request,HttpSession session,String user,String pwd,String code) throws InterruptedException{
		String rightcode = (String) session.getAttribute("rCode");
		session.setAttribute("rCode", "");
		//获取ip地址
		String ip=Util.getIpAddress(request);
		//验证验证码是否正确
		boolean b=rightcode != null &&code!=null&& code.equalsIgnoreCase(rightcode);
		if(!b){
			return new JsonResult(new RuntimeException("验证码不正确"),0000);
		}
		UserEnt u=null;
		//获取用户
		try {
			u=us.login(user, pwd,ip);
		} catch (EmailException e) {
			return new JsonResult(e,05);
		}
		
		if(u==null)
			return new JsonResult(new RuntimeException("用户名或密码错误"),000);
		User_CountEnt uie=uis.getUserIntegralByUserId(u.getId());
		if(uie==null)
			return new JsonResult(new RuntimeException("服务器错误:积分获取失败"),500);
		u.setUie(uie);
		User_GroupEnt uge;
		if(u.getAgid()!=null)
			uge=SacheData.User_GroupMap.get(u.getAgid());
		else
			uge=SacheData.User_GroupMap.get(u.getGid());
		session.setAttribute("UGE", uge);
		session.setAttribute("USER", u);
		//增加在线会员数
		SacheData.OnlineUsercount++;
		return new JsonResult(u);
		
	}
	/**
	 * 用户注册
	 * @param request
	 * @param reguser 注册用户名
	 * @param regpwd 注册密码
	 * @param regemail 注册邮箱
	 * @param code 注册验证码
	 * @param session
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/ajax/regUser.do")
	@ResponseBody
	public Object regUser(HttpServletRequest request, String reguser, String regpwd, String regemail, String code,
			HttpSession session) throws Exception {
		String rightcode = (String) session.getAttribute("rCode");
		session.setAttribute("rCode", "");
		boolean rc=rightcode != null &&code!=null&& code.equalsIgnoreCase(rightcode);
		if (!rc) {
			return new JsonResult(new RuntimeException("验证码错误"),0000);
		}
		String url = request.getScheme() + "://";
		url += request.getHeader("host");
		url += request.getContextPath();
		//获取ip地址
		String ip=Util.getIpAddress(request);
		try {
			String urlid=Util.getMD5(regemail+new Random().nextInt());
			String sed = "<a href=\"" + url + "/EmailCheck.do?id=" + urlid + "\">点击此激活邮箱</a>";
			regpwd=regpwd.split("\\,")[0];
			if (us.register(reguser, regpwd, regemail,urlid,ip)) {
				
				if(Config.EmailVerification){
					Util.send("激活账号", regemail, sed);
					return new JsonResult("注册成功请登录邮箱进行激活,未收到邮件请检查是否被系统拦截！");
				}
				return new JsonResult("注册成功请登录");
			}else{
				return new JsonResult("注册失败!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return new JsonResult(new DataBaseException("errorCode04 数据库异常"),0000);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(e);
		}
	}
	@RequestMapping("resendEmail.do")
	@ResponseBody
	public Object resendEmail(HttpServletRequest request,String user){
		String url = request.getScheme() + "://";
		url += request.getHeader("host");
		url += request.getContextPath();
		System.out.println(user);
		UserEnt ues=us.getUserByName(user);
		if(null==ues){
			return new JsonResult(new ParameterException("用户名不存在"), 03);
		}
		int uid=ues.getId();
		EmailEnt ee=es.getEmailByUid(uid);
		String sed = "<a href=\"" + url + "/EmailCheck.do?id="  +ee.getEmail_url()+ "\">点击此激活邮箱</a>";
		try {
			Util.send("激活账号", ee.getEmail(), sed);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(e,02);
		}
		return new JsonResult("success");
	}
	
}
