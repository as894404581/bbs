package xyz.zhtdemo.bbs.servlet;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import xyz.zhtdemo.bbs.entity.Attachment_InfoEnt;
import xyz.zhtdemo.bbs.entity.TardelogEnt;
import xyz.zhtdemo.bbs.entity.UserEnt;
import xyz.zhtdemo.bbs.entity.User_GroupEnt;
import xyz.zhtdemo.bbs.enums.T_typeEnum;
import xyz.zhtdemo.bbs.enums.TradeTypeEnum;
import xyz.zhtdemo.bbs.error.URLException;
import xyz.zhtdemo.bbs.inter.AttachmentService;
import xyz.zhtdemo.bbs.inter.TardelogService;
import xyz.zhtdemo.bbs.util.SacheData;

@Controller
public class DownloadServlet {
	@Resource
	AttachmentService as;
	@Resource
	private TardelogService ts;
	@RequestMapping("/AttachmentDownload.do")
	public ResponseEntity<byte[]> DownloadDoucment(int aid,int vid,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception{
		try {
			UserEnt ue=(UserEnt)session.getAttribute("USER");
			//默认为游客
			int gid=4;
			//如果登录获取用户Gid
			if(null!=ue){
				if(ue.getAgid()!=null){
					gid=ue.getAgid();
				}else{
					gid=ue.getGid();
				}
			}
			User_GroupEnt uge=SacheData.User_GroupMap.get(gid);
			Attachment_InfoEnt ai=as.getAieByAid(aid);
			if(uge.getAccess_rights()<ai.getAccess_rights()){
				request.setAttribute("TITL", "无权访问");
				int attachmentAccess_right=ai.getAccess_rights() ;
				int userAccess_right=uge.getAccess_rights();
				request.setAttribute("MSG", "您现所在的用户组无权下载该文件!"
						+ "该附件需要阅读权限:"+attachmentAccess_right+"以上才能下载,当前阅读权限:"+userAccess_right);
				request.setAttribute("A_URL", "index.do");
				request.getRequestDispatcher("error.do").forward(request, response);
			}
			if (ai.getPrice()!=0) {
				if (ue!=null&&(ts.getTardelog(new TardelogEnt(null, ue.getId(), vid, aid, null, null, T_typeEnum.attachment,null,TradeTypeEnum.buy))==null && ai.getUid().intValue()!=ue.getId().intValue())) {
					
				}
			}
			
			String path = session.getServletContext().getRealPath("/")+ai.getAttachment_url();
			File file = new File(path);
			if(!file.exists()){
				throw new URLException("文件不存在!");
			}
			HttpHeaders headers = new HttpHeaders();
			String fileName = new String(ai.getAttachment_formerly().getBytes("UTF-8"), "iso-8859-1");// 为了解决中文名称乱码问题
			headers.setContentDispositionFormData("attachment", fileName);
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			response.setContentLength((int) file.length()); 
		
			return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
