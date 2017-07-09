package xyz.zhtdemo.bbs.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.zhtdemo.bbs.dao.AttachmentOperationDao;
import xyz.zhtdemo.bbs.entity.Attachment_InfoEnt;
import xyz.zhtdemo.bbs.entity.Attachment_UnusedEnt;
import xyz.zhtdemo.bbs.inter.AttachmentService;

@Service("attachmentService")
public class AttachmentServiceImpl implements AttachmentService{
	@Resource
	AttachmentOperationDao iod;
	
	
	
	public boolean insertImgInfo(Attachment_InfoEnt iie) {
		return iod.insertAttachment_Info(iie)>0?true:false;
	}
	
	public void deleteAttachment(Integer vid,Integer rid) {
		if(rid!=null){
			iod.deleteAttachment(rid);
		}else{
			List<Attachment_InfoEnt> id=iod.getAttachment_InfoEnt(null, vid, rid, null);
			for (Attachment_InfoEnt i : id) {
				iod.deleteAttachment(i.getAid());
			}
		}
		
	}

	public List<Attachment_InfoEnt> getAttachmentList(Integer pid,String type,Integer rid) {
		
		return iod.getAttachment_InfoEnt(null, pid, rid, type);
	}

	public int insertUnusendAttachment(Attachment_UnusedEnt aue) {
		return iod.insertUnusendAttachment(aue);
	}

	public Attachment_UnusedEnt getAueByAid(Integer aid) {
		
		return iod.getAueByAid(aid);
	}

	public int deleteAueByAid(Integer aid) {
		
		return iod.deleteAueByAid(aid);
	}

	public Attachment_InfoEnt getAieByAid(Integer aid) {
		return iod.getAieByAid(aid);
	}

}
