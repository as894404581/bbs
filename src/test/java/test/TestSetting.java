package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xyz.zhtdemo.bbs.dao.SettingDao;



public class TestSetting {
	ClassPathXmlApplicationContext ctx;
	SettingDao sd;

	@Before
	public void Init() {
		ctx = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-mybatis.xml");
		sd=ctx.getBean("settingDao",SettingDao.class);
	}
	/**
	 * 获取设置表中的设置信息
	 */
	@Test
	public void getSetting(){
		List<Map<String, String>> list=sd.getSetting();
		Map<String, String> setting=new HashMap<String, String>();
		for (Map<String,String> m:list) {
			setting.put(m.get("KEY"), m.get("VALUE"));
		}
		System.out.println(setting);
	}
	
}
