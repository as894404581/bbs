package xyz.zhtdemo.bbs.inter;


import javax.script.ScriptException;

import org.springframework.stereotype.Service;

import xyz.zhtdemo.bbs.entity.User_CountEnt;

@Service
public interface User_CountService {
	/**
	 * 插入会员积分信息
	 * @param uie 会员积分实体类
	 * @return
	 */
	public boolean insertUserIntegral(User_CountEnt uie);
	/**
	 * 根据用户id获取用户积分信息
	 * @param userId 用户id
	 * @return
	 */
	public User_CountEnt getUserIntegralByUserId(int userId);
	
	/**
	 * 更新用户用户组
	 * @param userId 用户id
	 * @return 用户组id 更新失败为-1
	 */
	public int updateUserIntegral(int userId);
	
	/**
	 * 根据用户id获取用户积分信息
	 * @param userId
	 * @return
	 */
	public int getUserIntegral(int userId) throws ScriptException;
	/**
	 * 更新User_Count表
	 * @param uce 表实体类,如果字段为null则不更新该字段
	 * @return
	 */
	public int updateUser_Count(User_CountEnt uce);
}
