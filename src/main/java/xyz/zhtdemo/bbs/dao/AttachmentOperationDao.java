package xyz.zhtdemo.bbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xyz.zhtdemo.bbs.entity.Attachment_InfoEnt;
import xyz.zhtdemo.bbs.entity.Attachment_UnusedEnt;
import xyz.zhtdemo.bbs.enums.ArticleTypeEnum;

public interface AttachmentOperationDao {
	/**
	 * 插入图片信息
	 * @param iie 图片信息实体类
	 * @return
	 */
	int insertAttachment_Info(Attachment_InfoEnt iie);
	
	/**
	 * 删除帖子时删除已使用附件信息
	 * @param id 帖子id
	 * @return
	 */
	int deleteAttachment(@Param("aid")int aid);
	
	
	/**
	 * 根据附件id获取附件信息
	 * @param id 附件id
	 * @return
	 */
	public List<Attachment_InfoEnt> getAttachment_InfoEnt(@Param("aid")Integer aid,@Param("pid")Integer pid,@Param("rid")Integer rid,@Param("f_type")ArticleTypeEnum f_type);
	
	public int insertUnusendAttachment(Attachment_UnusedEnt aue);
	
	public Attachment_UnusedEnt getAueByAid(@Param("aid")Integer aid);
	/**
	 *删除已使用附件信息
	 * @param aid
	 * @return
	 */
	public int deleteAueByAid(@Param("aid")Integer aid);
	
	public Attachment_InfoEnt getAieByAid(@Param("aid")Integer aid);
}
