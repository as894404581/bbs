package xyz.zhtdemo.bbs.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.zhtdemo.bbs.dao.SettingDao;
import xyz.zhtdemo.bbs.entity.SettingEnt;
import xyz.zhtdemo.bbs.inter.SettingService;

@Service("settingService")
public class SettingServiceImpl implements SettingService{
	@Resource
	SettingDao sd;
	public Map<String, SettingEnt> getSettingMap() {
		List<Map<String, String>> list=sd.getSetting();
		Map<String, SettingEnt> map=new HashMap<String, SettingEnt>();
		for (Map<String, String> m : list) {
			
			map.put(m.get("key"), new SettingEnt(m.get("key"), m.get("value")));
		}
		return map;
	}
	public boolean updateSetting(SettingEnt se) {
		
		return sd.updateSetting(se)>0?true:false;
	}

}
