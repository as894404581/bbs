package test;



import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xyz.zhtdemo.bbs.dao.User_CountDao;
import xyz.zhtdemo.bbs.entity.User_CountEnt;
import xyz.zhtdemo.bbs.util.Config;

public class TestIntegral {
	ClassPathXmlApplicationContext ctx;
	User_CountDao uid;

	@Before
	public void Init() {
		ctx = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-mybatis.xml");
		uid = ctx.getBean("user_IntegralDao", User_CountDao.class);
	}
	@Test
	public void test() throws ScriptException{
		//根据用户id获取积分信息
		User_CountEnt uie=uid.getUserIntegralByUserId(12);
		System.out.println(uie);
		String rule=Config.Rule;
		rule=rule.replaceAll("Integral1", uie.getIntegral1().toString());
		rule=rule.replaceAll("Integral2", uie.getIntegral2().toString());
		rule=rule.replaceAll("Integral3", uie.getIntegral3().toString());
		rule=rule.replaceAll("Integral4", uie.getIntegral4().toString());
		rule=rule.replaceAll("Integral5", uie.getIntegral5().toString());
		rule=rule.replaceAll("Integral6", uie.getIntegral6().toString());
		rule=rule.replaceAll("Integral7", uie.getIntegral7().toString());
		rule=rule.replaceAll("Integral8", uie.getIntegral8().toString());
		ScriptEngine se = new ScriptEngineManager().getEngineByName("JavaScript");
        double d = (Double) se.eval(rule);
        System.out.println((int)d);
	}
	@Test
	public void insert(){
		
	}
}
