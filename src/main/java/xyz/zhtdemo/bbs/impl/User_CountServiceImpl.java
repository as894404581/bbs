package xyz.zhtdemo.bbs.impl;


import java.util.Map;

import javax.annotation.Resource;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.zhtdemo.bbs.dao.User_CountDao;
import xyz.zhtdemo.bbs.entity.UserEnt;
import xyz.zhtdemo.bbs.entity.User_GroupEnt;
import xyz.zhtdemo.bbs.entity.User_CountEnt;
import xyz.zhtdemo.bbs.inter.UserService;
import xyz.zhtdemo.bbs.inter.User_CountService;
import xyz.zhtdemo.bbs.util.Config;
import xyz.zhtdemo.bbs.util.SacheData;
@Service("user_IntegtalService")
public class User_CountServiceImpl implements User_CountService{
	@Resource
	User_CountDao uid;
	@Resource
	UserService us;
	
	public User_CountEnt getUserIntegralByUserId(int userId) {
		User_CountEnt uie=uid.getUserIntegralByUserId(userId);
		try {
			uie.setTotal_integral(getUserIntegral(userId));
			return uie;
		} catch (ScriptException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@Transactional
	public int updateUserIntegral(int userId) {
		try {
			int integral=getUserIntegral(userId);
			User_CountEnt uce=new User_CountEnt();
			uce.setTotal_integral(integral);
			updateUser_Count(uce);
			Map<Integer, User_GroupEnt> map= SacheData.User_GroupMap;
			int gid=-1;
			for (Integer key : map.keySet()) {
				User_GroupEnt uge=map.get(key);
				if(uge.getGroup_type().equals("member")){
					if(uge.getIntegral_max()>=integral && integral>=uge.getIntegral_mini()){
						UserEnt ue=new UserEnt();
						ue.setId(userId);
						ue.setGid(uge.getGid());
						uid.updateUserGroup(ue);
						gid=uge.getGid();
						break;
					}
				}
			}
			return gid;
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}

	public boolean insertUserIntegral(User_CountEnt uie) {
		return uid.insertUserIntegral(uie)>0?true:false;
	}

	public int getUserIntegral(int userId) throws ScriptException {
		User_CountEnt uie=uid.getUserIntegralByUserId(userId);
		String rule=Config.Rule;
		rule=rule.replaceAll("Integral1", uie.getIntegral1().toString());
		rule=rule.replaceAll("Integral2", uie.getIntegral2().toString());
		rule=rule.replaceAll("Integral3", uie.getIntegral3().toString());
		rule=rule.replaceAll("Integral4", uie.getIntegral4().toString());
		rule=rule.replaceAll("Integral5", uie.getIntegral5().toString());
		rule=rule.replaceAll("Integral6", uie.getIntegral6().toString());
		rule=rule.replaceAll("Integral7", uie.getIntegral7().toString());
		rule=rule.replaceAll("Integral8", uie.getIntegral8().toString());
		ScriptEngine se = new ScriptEngineManager().getEngineByName("js");
		return Integer.parseInt(se.eval(rule).toString().split("\\.")[0]);
	}

	public int updateUser_Count(User_CountEnt uce) {
		
		return uid.updateUser_Count(uce);
	}

}
