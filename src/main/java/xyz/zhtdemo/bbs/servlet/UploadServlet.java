package xyz.zhtdemo.bbs.servlet;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.LinkedBlockingQueue;
//
//import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import xyz.zhtdemo.bbs.entity.Attachment_UnusedEnt;
import xyz.zhtdemo.bbs.entity.UserEnt;
import xyz.zhtdemo.bbs.enums.AttachmentTypeEnum;
import xyz.zhtdemo.bbs.impl.AttachmentServiceImpl;
import xyz.zhtdemo.bbs.util.Config;
import xyz.zhtdemo.bbs.util.JsonResult;
import xyz.zhtdemo.bbs.util.Util;

/**
 * 上传文件类
 * @author zheng
 *
 */
@Controller
public class UploadServlet {

	@Resource
	AttachmentServiceImpl ii;
	private final String[] imgSuffix={".jpg",".jpeg",".png",".gif"};
	/**
	 * 接收上传的附件
	 * @param files 上传的附件
	 * @param request
	 * @return
	 */
	@RequestMapping("upload.do")
	@ResponseBody
	public Object filesUpload(@RequestParam("files") MultipartFile[] files,HttpSession session) {	
		UserEnt ue=(UserEnt)session.getAttribute("USER");
		List<Attachment_UnusedEnt> imgEnt = new ArrayList<Attachment_UnusedEnt>();
		if (files != null && files.length > 0) {
			// 循环获取file数组中得文件
			for (int i = 0; i < files.length; i++) {
				MultipartFile file = files[i];
				// 保存文件
				imgEnt.add(saveFile(Util.getUUID(), file,ue,session));
			}
		}
		files=null;
		// 重定向
		return new JsonResult(imgEnt);
	}

	
	private SimpleDateFormat y = new SimpleDateFormat("yyyy");
	private SimpleDateFormat m = new SimpleDateFormat("MM");
	private SimpleDateFormat dd = new SimpleDateFormat("dd");
	
	/**
	 * 保存上传的图片
	 * @param uuid 图片名
	 * @param file 路径
	 * @param request
	 * @return
	 */
	private Attachment_UnusedEnt saveFile(String uuid, MultipartFile file,UserEnt ue,HttpSession session) {
		// 判断文件是否为空
		if (!file.isEmpty()) {
			//分割图片名与后缀
			int index=Util.toUTF8(file.getOriginalFilename()).lastIndexOf(".");
			StringBuffer sb=new StringBuffer(file.getOriginalFilename());
			String suffix = sb.substring(index, sb.length());
			try {
				//获取文件日期
				Date d=new Date();
		        String y1 = y.format(d);
		        String m1 =m.format(d);
		        	String d1=dd.format(d);
		        	//上传路径
				String filePath=session.getServletContext().getRealPath(Config.uploadUrl)+"/"+y1+"/"+m1+"/"+d1;
				//上传服务器物理路径
				String FullFilePath=session.getServletContext().getRealPath(Config.uploadUrl)+"/"+y1+"/"+m1+"/"+d1+"/"+uuid+suffix;
				File files = new File(filePath);
				//检查文件夹是否存在
				if(!files.isDirectory())
					//不存在创建文件夹
					files.mkdirs();
				//将file文件路径加上文件名字与后缀
				files=new File(FullFilePath);
				// 转存文件
				file.transferTo(files);
				Attachment_UnusedEnt aue=new Attachment_UnusedEnt();
				aue.setUid(ue.getId());
				aue.setAttachment_formerly(Util.toUTF8(file.getOriginalFilename()));
				aue.setAttachment_url(Config.uploadUrl+"/"+y1+"/"+m1+"/"+d1+"/"+uuid +  suffix);
				aue.setAttachment_size(files.length());
				aue.setUpload_time(System.currentTimeMillis());
				for (String suffixs : imgSuffix) {
					if(suffixs.equalsIgnoreCase(suffix.trim())){
						aue.setA_type(AttachmentTypeEnum.img);
						break;
					}else{
						aue.setA_type(AttachmentTypeEnum.document);
					}
				}
				ii.insertUnusendAttachment(aue);
				//返回图片信息url为浏览器路径
				aue.setUid(null);
				return aue;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	
}
