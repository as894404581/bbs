package xyz.zhtdemo.bbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xyz.zhtdemo.bbs.entity.Reply_PostEnt;

public interface Reply_PostDao {
	
	/**
	 * 插入回复信息
	 * @param p 回复信息实体类
	 * @return
	 */
	int insertReply(Reply_PostEnt r);
	
	/**
	 * 通过帖子id获取回复的元素
	 * @param vid
	 * @return
	 */
	List<Reply_PostEnt> getReply_Post(@Param("vid")int vid,@Param("start")int start);
	/**
	 * 根据帖子id分页查询帖子回复信息
	 * @param vid 帖子id
	 * @return
	 */
	int getReplyPageCountByVid(@Param("vid")int vid);
	
	/**
	 * 根据回复id获取回复信息
	 * @param rid 回复信息
	 * @return
	 */
	Reply_PostEnt getReplyInfoByVid(@Param("rid")int rid);
	
	int updateReply(Reply_PostEnt rep);
}
