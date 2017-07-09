package xyz.zhtdemo.bbs.dao;

import java.util.List;
import java.util.Map;

import xyz.zhtdemo.bbs.entity.SettingEnt;


public interface SettingDao {
	/**
	 * 获取设置信息
	 * @return 设置信息Map
	 */
	public List<Map<String, String>> getSetting();
	
	/**
	 * 更新设置
	 * @param setting 设置实体类
	 * @return
	 */
	public int updateSetting(SettingEnt setting);
}
