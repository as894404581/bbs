package test;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xyz.zhtdemo.bbs.dao.EmailDao;
import xyz.zhtdemo.bbs.entity.Look_forpassEnt;

public class TestCase {
	ClassPathXmlApplicationContext ctx;
	EmailDao e;

	@Before
	public void Init() {
		ctx = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-mybatis.xml");
		e=ctx.getBean("emailDao",EmailDao.class);
	}

	@Test
	public void testCheckEmail() {
		int n=e.checkEmail("ae4c9d9af3de79a43c5d3eb08d33dfdd");
		System.out.println(n);
	}
	
	@Test
	public void testselectForPassByUser(){
		Look_forpassEnt emailEnt=e.selectForPassByUser("43343434");
		System.out.println(emailEnt);
		
	}
//	@Test 
//	public void testinsertLook_forpass(){
//		String email="894404581@qq.com";
//		String user="894404581";
//		Random r=new Random();
//		int n = e.insertLook_forpass(user, Util.getMD5(email+r.nextInt()+user+r.nextInt()));
//		System.out.println(n);
//	}
//	@Test
//	public void testdeleteLook_forpass(){
//		int n=e.deleteLook_forpass("894404581");
//		System.out.println(n);
//	}
//	@Test
//	public void testselectPassCheckEmail(){
//		Look_forpassEnt l=e.selectPassCheckEmail("23jdskhfkrgherkighrhwe");
//		System.out.println(l);
//	}
//	@Test
//	public void testupdatePass(){
//		int n=e.updatePass("894404581","as77889900");
//		System.out.println(n);
//	}
//	@Test
//	public void testdeleteLOOK_FORPASS(){
//		int n=e.deleteLook_forpass_url("23jdskhfkrgherkighrhwe");
//		System.out.println(n);
//	}
}
