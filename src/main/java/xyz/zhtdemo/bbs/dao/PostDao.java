package xyz.zhtdemo.bbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xyz.zhtdemo.bbs.entity.PostEnt;
import xyz.zhtdemo.bbs.entity.SearchEnt;

public interface PostDao {
	/**
	 * 根据板块id获取帖子列表
	 * @param id 板块id
	 * @return 帖子列表
	 */
	public List<PostEnt> getPostList(@Param("id")int id,@Param("page1")int page1);
	
	/**
	 * 根据帖子id获取帖子详细内容
	 * @param id	帖子id
	 * @return 帖子详细内容
	 */
	public PostEnt getPostById(@Param("id")int id);
	
	/**
	 * 根据id增加帖子查看次数
	 * @param id
	 * @return 受影响的行数
	 */
	public int addSee_Count(@Param("id")int id);
	
	/**
	 * 增加帖子
	 * @param placedEnt 帖子封装类
	 * @return 受影响行数
	 */
	public int addPost(PostEnt placedEnt);
	
	/**
	 * 根据帖子标题模糊查询贴子
	 * @param name 查询条件
	 * @param page1	分页开始下标
	 * @param page2	分页结束下标
	 * @return 帖子列表
	 */
	public List<SearchEnt> search(@Param("name")String name,@Param("page1")int page1);
	
	/**
	 * 根据帖子标题模糊查询帖子
	 * @param name	查询条件
	 * @return 查询出来的帖子总行数
	 */
	public int searchCount(@Param("name")String name);
	
	/**
	 * 根据vid获取发帖用户
	 * @param vid 帖子id
	 * @return
	 */
	public PostEnt getUserByVid(@Param("vid")int vid);
	
	/**
	 * 更新帖子
	 * @param pe 帖子实体类
	 * @return
	 */
	public  int updatePost(PostEnt pe);
	
	/**
	 * 根据帖子id增加帖子回复数
	 * @return
	 */
	public int updatePostReplyCount(@Param("vid")int vid);
	
	
	
}
