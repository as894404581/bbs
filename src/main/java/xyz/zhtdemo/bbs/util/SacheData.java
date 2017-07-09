package xyz.zhtdemo.bbs.util;

import java.util.List;
import java.util.Map;

import xyz.zhtdemo.bbs.entity.PlateEnt;
import xyz.zhtdemo.bbs.entity.SettingEnt;
import xyz.zhtdemo.bbs.entity.User_GroupEnt;

public class SacheData {
	/**
	 * 更新状态
	 */
	public static int state=1;

	/**
	 * 板块列表
	 */
	public static Map<Integer, PlateEnt> PlateMap;

	/**
	 *在线人数
	 */
	public static Integer Onlinecount=0;
	/**
	 * 在线登录会员人数
	 */
	public static Integer OnlineUsercount=0;
	/**
	 * 今日发帖数
	 */
	public static int TodayPostCount=0;
	/**
	 * 昨日发帖数
	 */
	public static int YesterdayPostCount=0;
	
	/**
	 * 论坛设置
	 */
	public static Map<String, SettingEnt> SettingMap;
	
	/**
	 * 用户组权限信息
	 * map key:Gid value:User_GroupEnt
	 */
	public static Map<Integer, User_GroupEnt> User_GroupMap;
	
	/**
	 * 首页用plate map
	 */
	public static Map<PlateEnt, List<PlateEnt>> IndexPlateMap;
}
