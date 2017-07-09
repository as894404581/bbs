package xyz.zhtdemo.bbs.inter;

import java.util.Map;

import xyz.zhtdemo.bbs.entity.User_GroupEnt;

public interface User_GroupService {
	/**
	 * 获取用户组权限信息
	 * @return map key:Gid value:User_GroupEnt
	 */
	public Map<Integer, User_GroupEnt> getUser_GroupMap();
	
	
}
