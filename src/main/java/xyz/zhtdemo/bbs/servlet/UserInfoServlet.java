package xyz.zhtdemo.bbs.servlet;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import xyz.zhtdemo.bbs.error.ParameterException;

@Controller
public class UserInfoServlet {

	@RequestMapping("userInfo.do")
	public String userInfo() {
		return "UserInfo";
	}

	@RequestMapping("loadUserSetting.do")
	public String getInfo(String mods,ModelMap map) {
		if (mods == null)
			throw new ParameterException("参数错误!");
		switch (mods) {
			case "info":
			case "integral":
			case "message":
			case "group":
				break;
			default:
				throw new ParameterException("参数错误!");
		}
		return "/UserInfo/"+mods;
	}
}
