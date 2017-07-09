package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xyz.zhtdemo.bbs.inter.EmailService;
import xyz.zhtdemo.bbs.util.Util;

public class TestEmail {
	ClassPathXmlApplicationContext ctx;
	EmailService e;

	@Before
	public void Init() {
		ctx = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-mybatis.xml");
		e=ctx.getBean("EmailService",EmailService.class);
	}
	/**
	 * 测试邮件发送
	 * @throws Exception
	 */
	@Test
	public void testEmailSend() throws Exception{
		if (Util.send("测试", "894404581@qq.com", "测试")) {
			System.out.println("成功");
		}else{
			System.out.println("失败");
		}
	}
}
