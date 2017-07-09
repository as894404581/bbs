package xyz.zhtdemo.bbs.util;

import java.util.HashMap;

import javax.annotation.Resource;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import xyz.zhtdemo.bbs.entity.IntegralXmlEnt;
import xyz.zhtdemo.bbs.entity.IntergralEnum;
import xyz.zhtdemo.bbs.inter.PlateService;
import xyz.zhtdemo.bbs.inter.SettingService;

/**
 * 初始化论坛设置
 * 
 * @author zheng
 *
 */
@Component
public class InitializationConfig implements ApplicationListener<ContextRefreshedEvent> {

	@Resource
	private SettingService ss;
	@Resource
	private PlateService ps;

	private SAXReader reader = new SAXReader();

	private Element root;

	public void onApplicationEvent(ContextRefreshedEvent event) {
		try {

			Document doc = reader.read(this.getClass().getResource("/config.xml").getFile());
			root = doc.getRootElement();
			// 加载邮件服务信息
			UpdateEmailXmlConfig();
			// 加载积分信息
			UpdateIntegralXmlConfigs();
			// 加载上传目录信息
			UpdateUploadShowUrl();
			
			// 写出XML
			// XMLWriter writer=new XMLWriter();
			// FileOutputStream fos=new
			// FileOutputStream(this.getClass().getResource("/config.xml").getFile());
			// writer.setOutputStream(fos);
			// writer.write(doc);
			// writer.close();
			// Element log=root.element("Log");
			// Config.LogFile=log.element("LogUrl").getText();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("解析配置文件失败:" + e.getMessage());
		}
		System.out.println("初始化完成");
	}

	/**
	 * 更新积分配置信息
	 * 
	 * @throws DocumentException
	 */
	public void UpdateIntegralXmlConfigs() throws DocumentException {
		Element integral = root.element("Integral");
		Config.IntegralXmlMap = new HashMap<String, IntegralXmlEnt>();
		for (int i = 1; i <= 8; i++) {
			Element in = integral.element("Integral" + i);
			boolean exchangeEnableOut = Util.parseBoolean(in.elementText("ExchangeEnableOut"));
			boolean exchangeEnableIn = Util.parseBoolean(in.elementText("ExchangeEnableIn"));
			boolean enable = Util.parseBoolean(in.elementText("Enable"));
			Config.IntegralXmlMap.put("Integral" + i, new IntegralXmlEnt(in.elementText("Name"),
					Double.valueOf(in.elementText("ExchangeRate")), exchangeEnableOut, exchangeEnableIn, enable));
		}
		Config.Rule = integral.elementText("Rule");

		IntergralEnum typeEnum;
		String type = integral.elementText("TradeIntegral");
		if (!IntergralEnum.contains(type)) {
			typeEnum = IntergralEnum.Integral1;
		} else {
			typeEnum = IntergralEnum.valueOf(type);
		}
		Config.TradeIntegral=typeEnum;
		System.out.println(Config.TradeIntegral);
	}

	/**
	 * 更新Email配置信息
	 * 
	 * @throws DocumentException
	 */
	public void UpdateEmailXmlConfig() throws DocumentException {
		Element email = root.element("Email");
		Config.EmailVerification = Util.parseBoolean(email.elementText("Email_Verification"));
		Config.EmailIPAddress = email.elementText("Email_Server");
		Config.EmailUser = email.elementText("Email_User");
		Config.EmailPassWord = email.elementText("Email_Password");
		Config.EmailPort = email.elementText("Email_Prot");
		Config.EmailAuth = email.elementText("Email_Auth");
		Config.SSLConnt = email.elementText("SSLConnt");
	}

	/**
	 * 更新上传文件范围路径
	 */
	public void UpdateUploadShowUrl() {
		Element upload = root.element("Upload");
		Config.uploadUrl = upload.elementText("Upload_Url");
	}

	

}
