package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Timestamp;

import java.util.TimeZone;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xyz.zhtdemo.bbs.dao.AttachmentOperationDao;
import xyz.zhtdemo.bbs.dao.PostDao;
import xyz.zhtdemo.bbs.entity.PostEnt;
//import xyz.zhtdemo.bbs.entity.Attachment_InfoEnt;
//import xyz.zhtdemo.bbs.entity.PostEnt;
import xyz.zhtdemo.bbs.util.Util;

public class TestPost {

	ClassPathXmlApplicationContext ctx;
	AttachmentOperationDao ao;
	PostDao pd;

	@Before
	public void Init() {
		ctx = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-mybatis.xml");
		ao = ctx.getBean("attachmentOperationDao", AttachmentOperationDao.class);
		pd = ctx.getBean("postDao", PostDao.class);
	}

	@Test
	public void getAttachment_InfoEnt() {

		// for (Attachment_InfoEnt ai : ao.getAttachment_InfoEnt(1, null)) {
		// System.out.println(ai);
		// }

	}

	/**
	 * 删除附件
	 */
	@Test
	public void deleteImg() {
		if (Util.DeleteFolder("/Users/zheng/Downloads/2017/02/11/0e831590-a93d-4dc7-aa31-981ec5523a92.jpg")) {
			System.out.println("成功");
		} else {
			System.out.println("失败");
		}
	}

	@Test
	public void getList() {

		for (PostEnt pe : pd.getPostList(1, 1)) {
			System.out.println(pe);
		}
	}

	@Test
	public void updatePostReplyCount() {
		pd.updatePostReplyCount(69);
	}

	@Test
	public void testDate() {

		long current = System.currentTimeMillis();// 当前时间毫秒数
		long zero = current / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();// 今天零点零分零秒的毫秒数
		long twelve = zero + 24 * 60 * 60 * 1000 - 1;// 今天23点59分59秒的毫秒数
		long yesterday = (current / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset())
				- 86400000;// 昨天的这一时间的毫秒数
		System.out.println(new Timestamp(1491148800000L));// 当前时间
		System.out.println(yesterday);// 昨天这一时间点
		System.out.println(new Timestamp(twelve));// 今天23点59分59秒
	}

	@Test
	public void insertPost() throws Exception {
		String path = "/Volumes/Untitled/百度云/小说/";
		File file = new File(path);
		File[] tempList = file.listFiles();
		BufferedReader reader;
		System.out.println("该目录下对象个数：" + tempList.length);
		for (int i = 0; i < tempList.length; i++) {
			if (tempList[i].isFile()) {
				File f=tempList[i];
				 reader = new BufferedReader(new InputStreamReader(new FileInputStream(f), "GBK"));
				String line;
				String text="";
				while ((line=reader.readLine())!=null) {
					text=text+line+"\n";
				}
				PostEnt pe=new PostEnt();
				pe.setTitle(f.getName());
				pe.setContent(text);
				pe.setIssue_time(System.currentTimeMillis());
				pe.setIssue_userid(12);
				pe.setPlate_id(2);
				pe.setSee_count(0);
				try {
					pd.addPost(pe);
				} catch (Exception e) {
					continue;
				}
				
				System.out.println(i);
				reader.close();
			}
		}
		
		
	}

}
