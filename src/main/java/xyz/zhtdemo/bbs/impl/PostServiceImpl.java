package xyz.zhtdemo.bbs.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.zhtdemo.bbs.dao.PostDao;
import xyz.zhtdemo.bbs.entity.PlateEnt;
import xyz.zhtdemo.bbs.entity.PostEnt;
import xyz.zhtdemo.bbs.entity.SettingEnt;
import xyz.zhtdemo.bbs.inter.PlateService;
import xyz.zhtdemo.bbs.inter.PostService;
import xyz.zhtdemo.bbs.inter.SettingService;
import xyz.zhtdemo.bbs.util.SacheData;

@Service
public class PostServiceImpl implements PostService {

	@Resource
	private PostDao pd;
	@Resource
	private SettingService ss;
	@Resource
	private PlateService ps;


	public int addPost(PostEnt pent) {
		pent.setIssue_time(System.currentTimeMillis());
		//设置论坛帖子总数
		SettingEnt se = SacheData.SettingMap.get("forum_post_count");
		se.setValue((Integer.parseInt(se.getValue()) + 1) + "");
		ss.updateSetting(se);
		SacheData.TodayPostCount++;
		//设置今日发帖数
		SettingEnt se1 = SacheData.SettingMap.get("forum_today_post_count");
		se1.setValue((Integer.parseInt(se1.getValue()) + 1) + "");
		ss.updateSetting(se1);
		//增加板块帖子数1
		ps.post_countUp(pent.getPlate_id());
		//更新板块最后发帖时间
		ps.updatePlateLast_issue(pent.getPlate_id(), pent.getIssue_time());
		//更新缓存中的版块帖子总数和最后发表时间
		PlateEnt pe = SacheData.PlateMap.get(pent.getPlate_id());
		pe.setPost_count((pe.getPost_count() + 1));
		pe.setLast_issue(System.currentTimeMillis());
		return pd.addPost(pent);
	}


	public int searchCount(String name) {

		return pd.searchCount("%" + name + "%");
	}


	public PostEnt getUserByVid(int vid) {
		return pd.getUserByVid(vid);
	}


	public PostEnt getPostByVid(int vid) {
		return pd.getPostById(vid);
	}

	public int updatePost(PostEnt postEnt) {
		return pd.updatePost(postEnt);
	}

	public int updatePostReplyCount(int vid) {

		return pd.updatePostReplyCount(vid);
	}

	

	public int addSee_Count(int vid) {

		return pd.addSee_Count(vid);
	}
	

}
