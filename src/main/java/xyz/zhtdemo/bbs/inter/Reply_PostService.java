package xyz.zhtdemo.bbs.inter;

import java.util.List;

import xyz.zhtdemo.bbs.entity.Reply_PostEnt;

public interface Reply_PostService {
	/**
	 * 插入回复信息
	 * @param r 回复信息实体类
	 * @return 是否成功
	 */
	boolean insertReply(Reply_PostEnt r);
	
	/**
	 * 根据帖子id获取回复列表
	 * @param vid 帖子id
	 * @return 回复列表
	 */
	List<Reply_PostEnt> getReplyById(int vid,int page);
	
	/**
	 * 根据帖子id分页查询帖子回复信息
	 * @param vid 帖子id
	 * @return
	 */
	int getReplyPageCountByVid(int vid);
	
	/**
	 * 根据回复id获取回复信息
	 * @param rid 回复信息
	 * @return
	 */
	Reply_PostEnt getReplyInfoByVid(int rid);
	
	/**
	 * 更新回复
	 * @param rid 回复id
	 * @param vid 帖子id
	 * @param text 回复内容
	 * @return
	 */
	int updateReply(Reply_PostEnt rpe);
}
