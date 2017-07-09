package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xyz.zhtdemo.bbs.dao.TardelogDao;
import xyz.zhtdemo.bbs.entity.TardelogEnt;
import xyz.zhtdemo.bbs.enums.T_typeEnum;
import xyz.zhtdemo.bbs.enums.TradeTypeEnum;

public class TestTardelog {
	ClassPathXmlApplicationContext ctx;
	TardelogDao td;

	@Before
	public void Init() {
		ctx = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-mybatis.xml");
		td=ctx.getBean("tardelogDao",TardelogDao.class);
	}
	
	@Test
	public void test1(){
		System.out.println(td.insertTarde(new TardelogEnt(null, 12, 12, 1, 1, 1,T_typeEnum.post,System.currentTimeMillis(),TradeTypeEnum.buy)));
	}
	@Test
	public void test2(){
		System.out.println(td.getTardelogList(new TardelogEnt(null, 12, null, null, null, null, T_typeEnum.post,null,TradeTypeEnum.buy)));
	}
	@Test
	public void test3(){
		System.out.println(td.getTardelog(new TardelogEnt(null, 12, null, null, null, null, T_typeEnum.post,null,TradeTypeEnum.buy)));
	}
}
