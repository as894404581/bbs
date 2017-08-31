package xyz.zhtdemo.bbs.inter;


import java.util.List;

import xyz.zhtdemo.bbs.entity.Attachment_InfoEnt;
import xyz.zhtdemo.bbs.entity.Attachment_UnusedEnt;
import xyz.zhtdemo.bbs.enums.ArticleTypeEnum;

public interface AttachmentService {
	public static final String  ATTACHMENT_TYPE_POST="post";
	public static final String ATTACHMENT_TYPE_REP="rep";
	/**
	 * 插入附件信息
	 * @param iie 附件信息实体类
	 * @return
	 */
	public boolean insertImgInfo(Attachment_InfoEnt iie);
	/**
	 * 删除帖子
	 * @param vid 帖子id
	 * @param rid 回复贴id,如果删除帖子所有附件rid为null
	 */
	public void deleteAttachment(Integer vid,Integer rid);
	/**
	 * 根据帖子id获取附件信息,
	 * @param id 帖子id
	 * @param type type属性值:post为主题帖附件信息,rep为回复贴附件信息,为null则获取这个帖子中所有附件的id
	 * @return
	 */
	public List<Attachment_InfoEnt> getAttachmentList(Integer id,ArticleTypeEnum type,Integer rid);
	/**
	 * 插入未使用附件信息
	 * @param aue 未使用附件信息实体类
	 * @return
	 */
	public int insertUnusendAttachment(Attachment_UnusedEnt aue);
	/**
	 * 根据id获取未使用附件信息
	 * @param aid 附件id
	 * @return
	 */
	public Attachment_UnusedEnt getAueByAid(Integer aid);
	/**
	 * 删除未使用附件信息
	 * @param aid 附件id
	 * @return
	 */
	public int deleteAueByAid(Integer aid);
	/**
	 * 根据附件id 获取已使用附件信息
	 * @param aid
	 * @return
	 */
	public Attachment_InfoEnt getAieByAid(Integer aid);
}
