package xyz.zhtdemo.bbs.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import xyz.zhtdemo.bbs.entity.UserEnt;

public interface UserDao {
	/**
	 * 登录验证
	 * @param user	用户名
	 * @param pass	md5加密的密码
	 * @param email	邮箱
	 * @return
	 */
	UserEnt Login(UserEnt ue);
	/**
	 * 注册时检查用户名和邮箱是否被使用
	 * @param user 
	 * @param email
	 * @return
	 */
	UserEnt checkUser(@Param("user")String user);
	/**
	 * 插入用户
	 * @param user	用户名
	 * @param pass	密码
	 * @param email	邮箱
	 * @return
	 */
	int insertUser(UserEnt ue);
	
	/**
	 * 检查用户名是否被注册
	 * @param user 注册用户名
	 * @return
	 */
	UserEnt checkEmail(@Param("email")String email);
	
	/**
	 * 获取注册用户列表
	 * @return 注册用户列表
	 */
	List<UserEnt> getUserList();
	
	/**
	 * 根据用户id查找用户
	 * @param id 用户id
	 * @return
	 */
	UserEnt getUserById(@Param("id")int id);
	
	/**
	 * 插入用户登录信息
	 * @param userid 用户id
	 * @param ip ip地址
	 * @return
	 */
	int insertUserSignInInfo(@Param("userid")int userid,@Param("ip")String ip);
	
	/**
	 * 更新用户登录信息
	 * @param userid 用户id
	 * @param ip ip地址
	 * @return
	 */
	int updateUserSignInInfo(@Param("userid")int userid,@Param("ip")String ip);
}
