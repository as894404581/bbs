package xyz.zhtdemo.bbs.inter;

import java.sql.SQLException;

import xyz.zhtdemo.bbs.entity.UserEnt;

public interface UserService {
	/**
	 * 登录
	 * @param user
	 * @param pass
	 * @return
	 */
	public UserEnt login(String user,String pass,String ip);
	/**
	 * 注册
	 * @param user
	 * @param pass
	 * @param email
	 * @return
	 * @throws SQLException 
	 */
	public boolean register(String user,String pass,String email,String url,String ip) throws SQLException;
	/**
	 * 检查用户是否存在
	 * @param user 用户名
	 * @return
	 */
	public boolean checkUser(String user);
	/**
	 * 检查邮箱
	 * @param email 邮箱
	 * @return
	 */
	public boolean checkEmail(String email);
	/**
	 * 根据用户id获取用户信息
	 * @param id 用户id
	 * @return
	 */
	public UserEnt getUserById(int id);
	public UserEnt getUserByName(String username);
}
