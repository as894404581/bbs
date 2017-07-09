package xyz.zhtdemo.bbs.dao;

import java.util.List;

import xyz.zhtdemo.bbs.entity.PlateEnt;

public interface PlateDao {
	/**
	 * 获取所有板块信息
	 * @return 板块列表
	 */
	List<PlateEnt> getListPlateEnt();
	
	
	/**
	 * 根据板块id更改板块信息,实体类id为必须值,
	 * 其它如需更改需要将需要更改的值进行赋值,
	 * 如果无须更改属性直接为null.
	 * @param pe 板块实体类
	 * @return
	 */
	public int updatePlateById(PlateEnt pe);
}
