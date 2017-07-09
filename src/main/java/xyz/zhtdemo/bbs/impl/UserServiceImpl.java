package xyz.zhtdemo.bbs.impl;

import java.sql.SQLException;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.zhtdemo.bbs.dao.UserDao;
import xyz.zhtdemo.bbs.entity.EmailEnt;
import xyz.zhtdemo.bbs.entity.SettingEnt;
import xyz.zhtdemo.bbs.entity.UserEnt;
import xyz.zhtdemo.bbs.entity.User_CountEnt;
import xyz.zhtdemo.bbs.error.EmailException;
import xyz.zhtdemo.bbs.inter.EmailService;
import xyz.zhtdemo.bbs.inter.SettingService;
import xyz.zhtdemo.bbs.inter.UserService;
import xyz.zhtdemo.bbs.inter.User_CountService;
import xyz.zhtdemo.bbs.util.Config;
import xyz.zhtdemo.bbs.util.SacheData;
import xyz.zhtdemo.bbs.util.Util;

@Service("userService")
public class UserServiceImpl implements UserService {
	

	@Resource
	EmailService eImpl;

	@Resource
	UserDao u;
	
	@Resource
	User_CountService uis;
	
	@Resource
	SettingService ss;
	
	@Transactional
	public UserEnt login(String user, String pass,String ip) throws EmailException {
		UserEnt ue=new UserEnt();
		ue.setUser(user);
		ue.setPassword(Util.getMD5(pass));
		ue.setEmail(user);
		UserEnt users  = u.Login(ue);
		if (users == null) {
			return null;
		}
		//判断是否需要激活邮箱
		if (Config.EmailVerification) {
			EmailEnt eEnt = eImpl.getEmailByUid(users.getId());
			if (!eEnt.getEmail_check().equals("true")) {
				throw new EmailException("邮箱未激活");
			}
		}
		//更新用户登录信息
		u.updateUserSignInInfo(users.getId(), ip);
		//更新用户积分与用户组信息
		users.setGid(uis.updateUserIntegral(users.getId()));
		return users;
	}

	@Transactional
	public boolean register(String user, String pass, String email,String url,String ip) throws SQLException {

		// 验证邮箱和用户名是否已被使用
		UserEnt uEnt = u.checkUser(user);
		UserEnt uEnt2 = u.checkEmail(email);
		if (uEnt == null && uEnt2 == null) {
			// 插入用户信息
			UserEnt ue=new UserEnt();
			ue.setUser(user);
			ue.setPassword(Util.getMD5(pass));
			ue.setEmail(email);
			// 插入邮箱验证信息
			if (u.insertUser(ue) > 0) {
				
				if (eImpl.InsertEmail(ue.getId(),email,url)) {
					//插入用户登录信息
					u.insertUserSignInInfo(u.checkUser(user).getId(), ip);
					//插入用户积分信息
					User_CountEnt uce=new User_CountEnt();
					uce.setUser_id(ue.getId());
					uis.insertUserIntegral(uce);
					SettingEnt se=SacheData.SettingMap.get("forum_user_count");
					se.setValue((Integer.parseInt(se.getValue())+1)+"");
					ss.updateSetting(se);
					return true;
				}
			}
		}
		return false;
	}

	public boolean checkUser(String user) {
		return u.checkUser(user)==null;
	}

	public boolean checkEmail(String email) {
		return u.checkEmail(email)==null;
	}

	public UserEnt getUserById(int id) {
		UserEnt ue=u.getUserById(id);
		return ue==null?null:ue;
	}
	
	public UserEnt getUserByName(String userName){
		UserEnt ue=u.checkUser(userName);
		return ue==null?null:ue;
	}
}
