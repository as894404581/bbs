package xyz.zhtdemo.bbs.inter;

import java.util.List;
import java.util.Map;

import xyz.zhtdemo.bbs.entity.PostEnt;
import xyz.zhtdemo.bbs.entity.PlateEnt;
import xyz.zhtdemo.bbs.entity.SearchEnt;
import xyz.zhtdemo.bbs.error.URLException;

public interface PlateService {
	
	
	/**
	 * 根据板块Id获取板块信息
	 * @param id	论坛id
	 * @return
	 */
	public PlateEnt getForumInfo(int fid)throws URLException;
	/**
	 * 根据板块id获取帖子列表
	 * @param id 板块id
	 * @param page1	分页开始
	 * @param page2	分页结束
	 * @return
	 */
	public List<PostEnt> getPost(int fid,int page1);
	/**
	 * 搜索
	 * @param name 搜索信息
	 * @param page 查询第几页
	 * @return
	 */
	public List<SearchEnt> search(String name,int page1);
	

	
	public int updatePlateLast_issue(int fid,Long last_issue);
	
	public int post_countUp(int fid);
	
	public int reply_countUp(int fid);
	
	/**
	 * 获取首页板块列表
	 * @return
	 */
	public Map<PlateEnt, List<PlateEnt>>  getIndexPlateMap();
}
