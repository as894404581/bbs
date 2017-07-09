package xyz.zhtdemo.bbs.dao;

import java.util.List;

import xyz.zhtdemo.bbs.entity.User_GroupEnt;

public interface User_GroupDao {
	/**
	 * 获取用户组信息
	 * @return
	 */
	public List<User_GroupEnt> getUserGroupList();
}
