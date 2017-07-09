package xyz.zhtdemo.bbs.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.zhtdemo.bbs.dao.PlateDao;
import xyz.zhtdemo.bbs.dao.UserDao;
import xyz.zhtdemo.bbs.entity.PlateEnt;
import xyz.zhtdemo.bbs.entity.UserEnt;
import xyz.zhtdemo.bbs.inter.UpdateSacheDataService;

@Service("updateSacheDataService")
public class UpdateSacheDataImpl implements UpdateSacheDataService{

	@Resource
	PlateDao h;
	
	@Resource
	UserDao u;
	
	/**
	 * 获取板块列表
	 * @return 板块列表
	 */
	public Map<Integer, PlateEnt> getMapPlateEnt(){
		List<PlateEnt> list= h.getListPlateEnt();
		Map<Integer, PlateEnt> map=new HashMap<Integer, PlateEnt>();
		for (PlateEnt plateEnt : list) {
			map.put(plateEnt.getId(), plateEnt);
		}
		return map;
	}
	
	
	public Map<Integer, UserEnt> getUserList(){
		List<UserEnt> list=u.getUserList();
		Map<Integer, UserEnt> map=new HashMap<Integer, UserEnt>();
		for (UserEnt usEnt : list) {
			map.put(usEnt.getId(), usEnt);
		}
		return map;
	}


	

}
