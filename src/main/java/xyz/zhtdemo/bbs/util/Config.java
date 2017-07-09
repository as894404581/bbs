package xyz.zhtdemo.bbs.util;

import java.util.Map;

import org.springframework.stereotype.Component;

import xyz.zhtdemo.bbs.entity.IntegralXmlEnt;
import xyz.zhtdemo.bbs.entity.IntergralEnum;

/**
 * 
 * 论坛设置信息
 * @author zheng
 *
 */
@Component
public class Config {
	//public static String LogFile;
	/**
	 * 是否启用邮箱验证
	 */
	public static boolean EmailVerification;

	/**
	 * 发送邮件的用户名
	 */
	public static String EmailUser;

	/**
	 * 发送邮件的密码
	 */
	public static String EmailPassWord;

	/**
	 * 邮件服务器ip
	 */
	public static String EmailIPAddress;

	/**
	 * 邮件服务器端口
	 */
	public static String EmailPort;

	/**
	 * 邮箱是否验证账号
	 */
	public static String EmailAuth;
	/**
	 * 是否开启邮件SSL连接
	 */
	public static String SSLConnt;
	/**
	 * 上传文件的路径
	 */
	public static String uploadUrl;

	/**
	 * 积分规则
	 */
	public static Map<String, IntegralXmlEnt> IntegralXmlMap;
	
	/**
	 * 积分计算规则
	 */
	public static String Rule;
	
	/**
	 * 用于交易的积分
	 * 
	 */
	public static IntergralEnum TradeIntegral;
	
}
