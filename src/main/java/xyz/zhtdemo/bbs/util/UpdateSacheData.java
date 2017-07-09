package xyz.zhtdemo.bbs.util;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import xyz.zhtdemo.bbs.entity.SettingEnt;
import xyz.zhtdemo.bbs.inter.PlateService;
import xyz.zhtdemo.bbs.inter.SettingService;
import xyz.zhtdemo.bbs.inter.UpdateSacheDataService;
import xyz.zhtdemo.bbs.inter.User_GroupService;

/**
 * 检查更新论坛信息
 * 
 * @author zheng
 *
 */
@Component
public class UpdateSacheData {
	@Resource
	private UpdateSacheDataService usd;
	@Resource
	private User_GroupService ugs;
	@Resource
	private SettingService ss;
	@Resource
	private PlateService ps;

	@Scheduled(fixedRate = 5000)
	public void updateSacheData() throws SQLException {
		if (SacheData.state == 1) {
			Init();
		}
	}

	public void Init() {
		if (SacheData.PlateMap == null) {
			// 获取板块列表
			SacheData.PlateMap = usd.getMapPlateEnt();
		}
		// 获取板块列表
		SacheData.PlateMap = usd.getMapPlateEnt();
		//获取首页版块列表
		SacheData.IndexPlateMap = ps.getIndexPlateMap();
		// 获取用户组权限信息
		SacheData.User_GroupMap = ugs.getUser_GroupMap();
		//获取论坛设置
		SacheData.SettingMap = ss.getSettingMap();
		// 获取今日发帖数
		SacheData.TodayPostCount = Integer.parseInt(SacheData.SettingMap.get("forum_today_post_count").getValue());
		// 获取昨日发帖数
		SacheData.YesterdayPostCount = Integer.parseInt(SacheData.SettingMap.get("forum_today_yesterday_count").getValue());
		
		// 修改更新状态
		SacheData.state = 0;
	}

	@Scheduled(cron = "0 0 00 * * ?")
	public void update() throws SQLException {
		// 获取昨日发帖数
		SacheData.YesterdayPostCount = SacheData.TodayPostCount;
		SettingEnt se = SacheData.SettingMap.get("forum_today_yesterday_count");
		se.setValue(SacheData.TodayPostCount + "");
		ss.updateSetting(se);
		// 获取今日发帖数
		SacheData.TodayPostCount = 0;
		SettingEnt se1 = SacheData.SettingMap.get("forum_today_post_count");
		se1.setValue(0 + "");
		ss.updateSetting(se1);

	}

}
