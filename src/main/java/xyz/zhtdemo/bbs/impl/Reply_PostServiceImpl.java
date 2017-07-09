package xyz.zhtdemo.bbs.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.zhtdemo.bbs.dao.Reply_PostDao;
import xyz.zhtdemo.bbs.entity.Reply_PostEnt;
import xyz.zhtdemo.bbs.error.ParameterException;
import xyz.zhtdemo.bbs.inter.Reply_PostService;


@Service("reply_PlacedService")
public class Reply_PostServiceImpl implements Reply_PostService{

	@Resource
	Reply_PostDao rDao;
	
	public boolean insertReply(Reply_PostEnt r) {
		
		return rDao.insertReply(r)>0;
	}
	public List<Reply_PostEnt> getReplyById(int vid,int page)throws ParameterException{
		
		return rDao.getReply_Post(vid,page);
	}
	public int getReplyPageCountByVid(int vid) {
		
		return rDao.getReplyPageCountByVid(vid);
	}
	public Reply_PostEnt getReplyInfoByVid(int rid) {
		
		return rDao.getReplyInfoByVid(rid);
	}
	public int updateReply(Reply_PostEnt rpe) {
		
		return rDao.updateReply(rpe);
	}

}
