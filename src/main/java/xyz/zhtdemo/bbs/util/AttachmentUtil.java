package xyz.zhtdemo.bbs.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import xyz.zhtdemo.bbs.entity.Attachment_InfoEnt;
import xyz.zhtdemo.bbs.entity.Attachment_UnusedEnt;
import xyz.zhtdemo.bbs.entity.PostEnt;
import xyz.zhtdemo.bbs.entity.Reply_PostEnt;
import xyz.zhtdemo.bbs.entity.TardelogEnt;
import xyz.zhtdemo.bbs.enums.T_typeEnum;
import xyz.zhtdemo.bbs.enums.TradeTypeEnum;
import xyz.zhtdemo.bbs.inter.AttachmentService;
import xyz.zhtdemo.bbs.inter.TardelogService;

/**
 * 此类为附件工具类, 包含替换附件标签,将未使用附件修改为已使用附件的方法
 * 
 * @author zheng
 */
@Component
public class AttachmentUtil {
	@Resource
	AttachmentService as;
	@Resource
	TardelogService ts;
	/**
	 * 替换帖子内容中的标签模式 mode.EDIT:编辑模式,不替换document标签 mode.VIEW:显示模式,全部替换
	 * 
	 * @author zheng
	 *
	 */
	public static enum mode {
		EDIT, VIEW
	}

	/**
	 * 在发表帖子时调用,将上传的附件信息从未使用附件表添加到以使用附件表
	 * 
	 * @param pe
	 *            帖子实体类
	 * @param a
	 *            附件aid数组
	 * @return
	 */
	public boolean ReplacePostAttachmentIn(PostEnt pe, Integer[] a) {
		if (a == null) {
			return true;
		}
		for (Integer aid : a) {
			Attachment_UnusedEnt aue = as.getAueByAid(aid);
			Attachment_InfoEnt aie = new Attachment_InfoEnt();
			aie.setAid(aue.getAid());
			aie.setAttachment_url(aue.getAttachment_url());
			aie.setUid(pe.getIssue_userid());
			aie.setPid(pe.getId());
			aie.setAttachment_formerly(aue.getAttachment_formerly());
			aie.setAttachment_size(aue.getAttachment_size());
			aie.setUpload_time(System.currentTimeMillis());
			aie.setF_type(Attachment_InfoEnt.TYPE_POST);
			aie.setA_type(aue.getA_type());
			aie.setAccess_rights(aue.getAccess_rights());
			aie.setPrice(aue.getPrice());
			as.insertImgInfo(aie);
			as.deleteAueByAid(aie.getAid());
		}
		return true;
	}

	/**
	 * 在发表回复时调用,将上传的附件信息从未使用附件表添加到以使用附件表
	 * 
	 * @param rpe
	 *            回复实体类
	 * @param a
	 *            附件aid数组
	 * @return
	 */
	public boolean ReplaceRepAttachmentIn(Reply_PostEnt rpe, Integer[] a) {
		if (a == null) {
			return true;
		}
		for (Integer aid : a) {
			Attachment_UnusedEnt aue = as.getAueByAid(aid);
			Attachment_InfoEnt aie = new Attachment_InfoEnt();
			aie.setAid(aue.getAid());
			aie.setAttachment_url(aue.getAttachment_url());
			aie.setUid(rpe.getReply_userid());
			aie.setPid(rpe.getPlaced_id());
			aie.setRid(rpe.getId());
			aie.setAttachment_formerly(aue.getAttachment_formerly());
			aie.setAttachment_size(aue.getAttachment_size());
			aie.setUpload_time(System.currentTimeMillis());
			aie.setF_type(Attachment_InfoEnt.TYPE_REP);
			aie.setA_type(aue.getA_type());
			as.insertImgInfo(aie);
			as.deleteAueByAid(aie.getAid());
			aie.setAccess_rights(aue.getAccess_rights());
			aie.setPrice(aue.getPrice());
		}
		return true;
	}

	/**
	 * 在要显示帖子内容时进行调用,此方法有两种模式 1:mode.EDIT 编辑模式,不替换document标签,和追加没添加到帖子内容的图片
	 * 2:mode.VIEW 显示模式,替换所有标签,并追加没添加到帖子里的图片到末尾
	 * 
	 * @param text
	 *            帖子内容
	 * @param vid
	 *            帖子id
	 * @param mode
	 *            显示模式
	 * @return
	 */
	public String ReplacePostAttachmentOut(int uid,String text, int vid, AttachmentUtil.mode mode) {
		text = Util.upBr(text);
		text = ReplaceAttachmentLable(text, as.getAttachmentList(vid, Attachment_InfoEnt.TYPE_POST, null), mode,ts.getTardelogMap(new TardelogEnt(null, uid, vid, null, null, null, T_typeEnum.attachment, null, TradeTypeEnum.buy)));
		return text;
	}

	/**
	 * 在要显示回复内容时进行调用,此方法有两种模式 1:mode.EDIT 编辑模式,不替换document标签,和追加没添加到回复内容的图片
	 * 2:mode.VIEW 显示模式,替换所有标签,并追加没添加到回复里的图片到末尾
	 * 
	 * @param text
	 *            帖子内容
	 * @param vid
	 *            帖子id
	 * @param rid
	 *            回复id
	 * @param mode
	 *            显示模式
	 * @return
	 */
	public String ReplaceRepAttachmentOut(int uid,String text, int vid, int rid, AttachmentUtil.mode mode) {
		text = Util.upBr(text);
		text = ReplaceAttachmentLable(text, as.getAttachmentList(vid, Attachment_InfoEnt.TYPE_REP, rid), mode,ts.getTardelogMap(new TardelogEnt(null, uid, vid, null, rid, null, T_typeEnum.attachment, null, TradeTypeEnum.buy)));
		return text;
	}

	/**
	 * 替换文本文本中的附件标签,两种显示方式: 1:mode.EDIT 编辑模式,不替换document标签,和追加没添加到回复内容的图片
	 * 2:mode.VIEW 显示模式,替换所有标签,并追加没添加到回复里的图片到末尾
	 * 
	 * @param t
	 *            文本
	 * @param l
	 *            文本对应的附件列表
	 * @param mode
	 *            显示模式
	 * @return
	 */
	private String ReplaceAttachmentLable(String t, List<Attachment_InfoEnt> l, AttachmentUtil.mode mode,Map<Integer,TardelogEnt> tmap) {
		if (null == l)
			return t;
		List<Attachment_InfoEnt> imgList = new ArrayList<Attachment_InfoEnt>();
		List<Attachment_InfoEnt> docList = new ArrayList<Attachment_InfoEnt>();
		for (Attachment_InfoEnt ai : l) {
			if (ai.getA_type().equals(Attachment_InfoEnt.TYPE_IMG)) 
				imgList.add(ai);
			else 
				docList.add(ai);
		}
		StringBuffer text = new StringBuffer(t);
		for (Attachment_InfoEnt ai : imgList) {
			String rep_text = "[img]" + ai.getAid() + "[/img]";
			int index = text.indexOf(rep_text);
			
			String repStr = "<div><img style='width:60%;height:60%;' src=" + ai.getAttachment_url() + " name='"+ ai.getAid() + "' class='imgs'/></div>";
			if (index == -1 && !AttachmentUtil.mode.EDIT.equals(mode)) 
				text.append(repStr);
			else if (index != -1) 
				text.replace(index, index + rep_text.length(), repStr);
		}
		for (Attachment_InfoEnt ai : docList) {
			if (!AttachmentUtil.mode.EDIT.equals(mode)) {
				String rep_text = "[document]" + ai.getAid() + "[/document]";
				int index = text.indexOf(rep_text);
				
				String repStr;
				System.out.println(ai);
				if (tmap.get(ai.getAid())!=null) {
					repStr="<dl class='attachment'><dt><img src='static/image/Document.png' width='80' height='80'/></dt><dd>"
							+ "<a href='AttachmentDownload.do?aid="+ai.getAid()+"&vid="+ai.getPid()+"'>"+ ai.getAttachment_formerly() + "</a></dd></dl>";
				}else {
					repStr= "<dl class='attachment'><dt><img src='static/image/Document.png' width='80' height='80'/></dt><dd>"
							+ "<a href=javascript:; onclick=buy("+ai.getPid()+","+ai.getPrice()+",'attachment',"+ai.getAid()+","+ai.getRid()+")  >"+ ai.getAttachment_formerly() + "</a></dd><dd>"
							+ "价格:"+ai.getPrice()+"</dd></dl>";
				}
				if (index == -1) 
					text.append(repStr);
				 else 
					text.replace(index, index + rep_text.length(), repStr);
			}
		}
		return text.toString();
	}
}
