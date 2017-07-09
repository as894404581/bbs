package xyz.zhtdemo.bbs.inter;

import java.util.Map;

import xyz.zhtdemo.bbs.entity.SettingEnt;

public interface SettingService {
	/**
	 * 获取设置Map 
	 * @return Map key为设置属性名 
	 */
	public Map<String, SettingEnt> getSettingMap();
	
	public boolean updateSetting(SettingEnt se);
}
