package xyz.zhtdemo.bbs.listener;

import java.util.Date;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import xyz.zhtdemo.bbs.util.SacheData;


/**
 * 监听器由tomcat实例化
 * 
 * @author zheng
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {

	/*
	 * 监听session创建
	 */
	public void sessionCreated(HttpSessionEvent event) {
		Integer count = SacheData.Onlinecount;
		if (count == null) {
			count = new Integer(1);
		} else {
			int co = count.intValue();
			count = new Integer(co + 1);
		}
		SacheData.Onlinecount= count;// 保存人数

	}

	/*
	 * 监听session销毁
	 */
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.print("销毁时间:"+new Date());
		
		if(event.getSession().getAttribute("USER")!=null && SacheData.OnlineUsercount>0){
			SacheData.OnlineUsercount--;
		}
		
		Integer count = SacheData.Onlinecount;
		if (count != null) {
			int co = count.intValue();
			count = new Integer(co - 1);
			if(count<=0){
				count=0;
			}
			SacheData.Onlinecount= count;
		}
	}
}
