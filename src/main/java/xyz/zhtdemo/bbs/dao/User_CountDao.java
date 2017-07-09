package xyz.zhtdemo.bbs.dao;


import xyz.zhtdemo.bbs.entity.UserEnt;
import xyz.zhtdemo.bbs.entity.User_CountEnt;

public interface User_CountDao {
	/**
	 * 根据用户id获取积分信息
	 * @param userId 用户id
	 * @return 用户积分
	 */
	public User_CountEnt getUserIntegralByUserId(int userId);
	
	/**
	 * 插入用户积分信息
	 * @param uie 积分信息实体类
	 * @return
	 */
	public int insertUserIntegral(User_CountEnt uie);
	
	/**
	 * 更新会员用户组,可同时更新gid和agid,如果不想更新其中一项只要为null即可
	 * @param ue 用户实体类 
	 * @return
	 */
	public int updateUserGroup(UserEnt ue);
	
	/**
	 * 更新User_Count表
	 * @param uce 表实体类,如果字段为null则不更新该字段
	 * @return
	 */
	public int updateUser_Count(User_CountEnt uce);
}
