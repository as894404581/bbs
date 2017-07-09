package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xyz.zhtdemo.bbs.dao.Reply_PostDao;
import xyz.zhtdemo.bbs.entity.Reply_PostEnt;

public class TestReply_Placed {

	ClassPathXmlApplicationContext ctx;
	Reply_PostDao r;

	@Before
	public void Init() {
		ctx = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-mybatis.xml");
		r=ctx.getBean("reply_PlacedDao",Reply_PostDao.class);
	}
	
	@Test
	public void testInsert(){
		Reply_PostEnt s=new Reply_PostEnt(null, 1, "dsadsfadsdsaf", 12, null,null);
		System.out.println(r.insertReply(s));
	}
	
}
