package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

//import xyz.zhtdemo.bbs.dao.AttachmentOperationDao;
//import xyz.zhtdemo.bbs.entity.Attachment_InfoEnt;

public class TestImg {
	//ClassPathXmlApplicationContext ctx;
	//AttachmentOperationDao iod;

	@Before
	public void Init() {
		//ctx = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-mybatis.xml");
		//iod = ctx.getBean("imgOperationDao", AttachmentOperationDao.class);
	}

	@Test
	public void testInsert(){
		//System.out.println(iod.insertImgInfo(new Attachment_InfoEnt("/用户/zheng/Downloads/2017/01/25/328627233.jpg", 288, 222, 12, 1)));
	}
	@Test
	public void testImg(){
		String text="asdadsa[img]1212121[/img]dsadasads[img]2[/img]vsdvdv[img]3[/img]sdfsdfcvcxcx[img]4[/img]";
		String regex="(\\[img\\]\\d*\\[/img\\])";
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(text);
		while (matcher.find()) {
			String str=matcher.group(1);
			str=str.replace("[img]", "");
			str=str.replace("[/img]", "");
			System.out.println(str);
		}
	}
}
