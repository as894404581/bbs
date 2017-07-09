package xyz.zhtdemo.bbs.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.zhtdemo.bbs.dao.User_GroupDao;
import xyz.zhtdemo.bbs.entity.User_GroupEnt;
import xyz.zhtdemo.bbs.inter.User_GroupService;

@Service("user_GroupService")
public class User_GroupServiceImpl implements User_GroupService{

	@Resource
	private User_GroupDao ugd;
	
	public Map<Integer, User_GroupEnt> getUser_GroupMap() {
		List<User_GroupEnt> list=ugd.getUserGroupList();
		Map<Integer, User_GroupEnt> map=new HashMap<Integer, User_GroupEnt>();
		for (User_GroupEnt uge : list) {
			map.put(uge.getGid(), uge);
		}
		return map;
	}
}
