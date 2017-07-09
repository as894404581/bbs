package xyz.zhtdemo.bbs.inter;

import java.sql.SQLException;

import xyz.zhtdemo.bbs.entity.EmailEnt;
import xyz.zhtdemo.bbs.error.URLException;


public interface EmailService {
	/**
	 * 激活邮箱
	 * @param emailUrl 激活链接
	 * @return
	 * @throws SQLException
	 */
	public boolean checkEmail(String emailUrl) throws SQLException ;
	/**
	 * 插入邮箱信息
	 * @param email 邮箱
	 * @return
	 */
	public boolean InsertEmail(int uid,String email,String url) ;
	/**
	 * 找回密码
	 * @param email 邮箱
	 * @param user 用户
	 * @param url 找回密码url
	 * @return
	 * @throws Exception
	 */
	public boolean lookForPass(String email, int userId, String url) throws Exception ;
	/**
	 * 检查更新密码请求Url
	 * @param email_url 更新密码请求路径
	 * @return
	 * @throws URLException
	 * @throws SQLException
	 */
	public Integer updatePassCheckEmail(String email_url) throws URLException,SQLException,RuntimeException;
	/**
	 * 更新密码
	 * @param email_url 请求url
	 * @param user	用户名
	 * @param pass	密码
	 * @return
	 * @throws URLException
	 * @throws SQLException
	 */
	public boolean updatePass(String email_url, int userId, String pass) throws URLException,SQLException;
	public EmailEnt getEmailByUid(int uid);
}
