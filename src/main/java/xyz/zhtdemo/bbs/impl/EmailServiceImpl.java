package xyz.zhtdemo.bbs.impl;

import java.sql.SQLException;
import java.util.Random;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import xyz.zhtdemo.bbs.dao.EmailDao;
import xyz.zhtdemo.bbs.entity.EmailEnt;
import xyz.zhtdemo.bbs.entity.Look_forpassEnt;
import xyz.zhtdemo.bbs.error.DataBaseException;
import xyz.zhtdemo.bbs.error.ParameterException;
import xyz.zhtdemo.bbs.error.URLException;
import xyz.zhtdemo.bbs.inter.EmailService;
import xyz.zhtdemo.bbs.util.Util;

@Service("EmailService")
public class EmailServiceImpl implements EmailService {
	

	@Resource
	private Util dataBase;

	@Resource
	private EmailDao e;

	/**
	 * 激活邮箱
	 */
	public boolean checkEmail(String emailUrl) throws SQLException {
		
		return e.checkEmail(emailUrl) > 0?true:false;
	}

	/**
	 * 插入邮箱验证信息
	 * 
	 * @param email
	 * @return
	 */
	
	public boolean InsertEmail(int uid,String email, String url) {
		return e.insertEmail(uid,email, url) > 0?true:false;
	}

	/**
	 * 找回密码发送邮件
	 * 
	 * @throws Exception
	 */
	
	public boolean lookForPass(String email, int userid, String url) throws Exception {
		Random r=new Random();
		String md5 = Util.getMD5(email+r.nextInt());
		String mess = "<a href='" + url + "?code=" + md5 + "'>点击此进行修改密码</a>";		
		if (Util.send("修改密码", email, mess) && e.insertLook_forpass(userid, md5) > 0) {
			return true;
		} else {
			throw new ParameterException("参数错误");
		}
	}

	/**
	 * 检查修改密码的url
	 */
	public Integer updatePassCheckEmail(String email_url) throws URLException, DataBaseException {

		Look_forpassEnt u = e.selectPassCheckEmail(email_url);
		if (u != null) {
			return u.getUsers_id();
		} else {
			throw new URLException("提交路径非法");
		}

	}

	/**
	 * 更新用户密码
	 */
	
	public boolean updatePass(String email_url, int userid, String pass) throws URLException, DataBaseException {

		if (e.updatePass(userid, Util.getMD5(pass)) > 0) {
			if (e.updateLook_fropassTrue(userid,email_url)) {
				return true;
			}
			return false;
		} else {
			throw new URLException();
		}

	}

	public EmailEnt getEmailByUid(int uid) {
		
		return e.geEntByUid(uid);
	}
}
