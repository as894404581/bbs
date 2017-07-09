package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xyz.zhtdemo.bbs.dao.AttachmentOperationDao;
import xyz.zhtdemo.bbs.entity.Attachment_InfoEnt;

public class Attachment {
	ClassPathXmlApplicationContext ctx;
	AttachmentOperationDao ad;

	@Before
	public void Init() {
		ctx = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-mybatis.xml");
		ad=ctx.getBean("attachmentOperationDao",AttachmentOperationDao.class);
	}
	
	@Test
	public void test(){
		System.out.println(ad.getAttachment_InfoEnt(null, 154, null, Attachment_InfoEnt.TYPE_POST));
	}
	@Test
	public void test1(){
		System.out.println(System.getProperty("evan.webapp"));
	}
}
