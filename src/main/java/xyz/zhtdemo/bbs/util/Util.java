package xyz.zhtdemo.bbs.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.Security;
import java.util.Properties;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;


@Component
public class Util {

	/**
	 * MD5加密
	 * 
	 * @param str
	 *            需要加密的字符串
	 * @return
	 */
	public static String getMD5(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			return new BigInteger(1, md.digest()).toString(16);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 邮件发送
	 * 
	 * @param email
	 *            目标邮箱地址
	 * @param content
	 *            发送内容
	 * @return
	 * @throws Exception
	 */
	public static boolean send(String tit, String email, String content) throws Exception {
		// 配置发送邮件的环境属性
		final Properties props = new Properties();
		
		// 表示SMTP发送邮件，需要进行身份验证
		props.put("mail.smtp.auth", Config.EmailAuth);
		props.put("mail.smtp.host", Config.EmailIPAddress);
		if("true".equals(Config.SSLConnt)){
			Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());  
	        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory"; 
			props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		}
		props.setProperty("mail.smtp.port", Config.EmailPort);
		// 发件人的账号
		props.put("mail.user", Config.EmailUser);
		// 访问SMTP服务时需要提供的密码
		props.put("mail.password", Config.EmailPassWord);

		// 构建授权信息，用于进行SMTP进行身份验证
		Authenticator authenticator = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// 用户名、密码
				String userName = props.getProperty("mail.user");
				String password = props.getProperty("mail.password");
				return new PasswordAuthentication(userName, password);
			}
		};
		// 使用环境属性和授权信息，创建邮件会话
		Session mailSession = Session.getInstance(props, authenticator);
		// 创建邮件消息
		MimeMessage message = new MimeMessage(mailSession);
		// 设置发件人
		InternetAddress form;

		form = new InternetAddress(props.getProperty("mail.user"));

		message.setFrom(form);

		// 设置收件人
		InternetAddress to = new InternetAddress(email);
		message.setRecipient(RecipientType.TO, to);

		// 设置邮件标题
		message.setSubject(MimeUtility.encodeText(tit, "UTF-8", "B"));

		
		// 设置邮件的内容体

		message.setContent(content, "text/html;charset=UTF-8");

		// 发送邮件
		Transport.send(message);
		return true;

	}

	/**
	 * 获取请求ip地址
	 * @param request 请求
	 * @return
	 */
	public static String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	/**
	 * 获取uuid
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString();
	}
	
	/**
	 * 删除文件
	 * @param sPath 文件路径,支持绝对与相对路径
	 * @return
	 */
	public static boolean DeleteFolder(String sPath) {  
	    boolean flag = false;  
	    File file = new File(sPath);  
	    // 判断目录或文件是否存在  
	    if (!file.exists()) {  // 不存在返回 false  
	        return flag;  
	    } else {  
	        // 判断是否为文件  
	        if (file.isFile()) {  // 为文件时调用删除文件方法  
	        		file.delete();
	            return true;  
	        }  
	    }  
	    return false;
	}  
	/**
	 * 将传入的0和1转换为boolean类型
	 * @param pString 0或1 0:false 1:true
	 * @return
	 */
	public static boolean parseBoolean(String pString){
		
		return  Integer.parseInt(pString)!=0;
	}
	
	
	/**
	 * 将ISO-8859-1转UTF-8
	 * @param str 要转的字符串
	 * @return
	 */
	public static String toUTF8(String str) {
		try {
			String[] encodes = {"ISO-8859-1","UTF-8"};
			for (String encode : encodes) {
				if (str.equals(new String(str.getBytes(encode), encode))) 
					return new String(str.getBytes(encode),"UTF-8");
//				else if (str.equals(new String(str.getBytes("UTF-8"), "UTF-8")))
//					return str;
			}
			return str;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}
	/**
	 * 
	 * @param myString
	 * @return
	 */
	public static String upBr(String myString){  
        String newString=null;  
        Pattern CRLF = Pattern.compile("(\r\n|\r|\n|\n\r)");  
        Matcher m = CRLF.matcher(myString);  
        if (m.find()) {  
          newString = m.replaceAll("<br>");  
        }  
        if(newString==null){
        		newString=myString;
        }
        return newString;  
    } 

}
