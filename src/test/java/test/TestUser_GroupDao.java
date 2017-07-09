package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.zhtdemo.bbs.dao.User_GroupDao;
import xyz.zhtdemo.bbs.entity.User_GroupEnt;

public class TestUser_GroupDao {
	ClassPathXmlApplicationContext ctx;
	User_GroupDao ugd;
	@Before
	public void init(){
		ctx=new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-mybatis.xml");
		ugd=ctx.getBean("user_GroupDao",User_GroupDao.class);
	}
	@Test
	public void testGetUser_GroupList(){
		List<User_GroupEnt> list=ugd.getUserGroupList();
		Map<Integer, User_GroupEnt> map=new HashMap<Integer, User_GroupEnt>();
		for (User_GroupEnt uge : list) {
			map.put(uge.getGid(), uge);
		}
		System.out.println(map);
	}
}
