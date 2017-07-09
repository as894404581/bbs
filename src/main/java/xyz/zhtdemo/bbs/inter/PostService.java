package xyz.zhtdemo.bbs.inter;


import xyz.zhtdemo.bbs.entity.PostEnt;

public interface PostService {
	/**
	 * 插入一个帖子
	 * @param pent 要插入的帖子实体类
	 * @return
	 */
	public int addPost(PostEnt pent);
	/**
	 * 搜索功能查询搜索结果数
	 * @param name 搜索内容
	 * @return
	 */
	public int searchCount(String name);
	/**
	 * 根据vid获取发帖用户
	 * @param vid 帖子id
	 * @return
	 */
	public PostEnt getUserByVid(int vid);
	/**
	 * 根据帖子id获取帖子详细内容
	 * @param vid 帖子id
	 * @return
	 */
	public PostEnt getPostByVid(int vid);
	/**
	 * 修改帖子内容
	 * @param postEnt
	 * @return
	 */
	public int updatePost(PostEnt postEnt);
	/**
	 * 根据帖子id增加帖子回复数
	 * @param vid 帖子id
	 * @return
	 */
	public int updatePostReplyCount(int vid);
	
	/**
	 * 增加帖子查看数
	 * @param vid 帖子id
	 * @return
	 */
	public int addSee_Count(int vid);
	
}
