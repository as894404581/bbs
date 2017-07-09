package xyz.zhtdemo.bbs.servlet;


import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import xyz.zhtdemo.bbs.error.DataBaseException;
import xyz.zhtdemo.bbs.inter.Index_Head_PliotService;
import xyz.zhtdemo.bbs.inter.PlateService;
import xyz.zhtdemo.bbs.util.SacheData;
import xyz.zhtdemo.bbs.util.UpdateSacheData;

/**
 * 论坛首页类
 * @author zheng
 *
 */
@Controller
public class IndexServlet {
	@Resource
	private Index_Head_PliotService ihps;
	@Resource
	private PlateService ps;
	@Resource
	private UpdateSacheData usd;
	/**
	 * 转发到论坛首页
	 * @param map
	 * @param session
	 * @return
	 */
	@RequestMapping("/index.do")
	protected String service(ModelMap map, HttpSession session) throws DataBaseException {
        if(SacheData.PlateMap==null){
        		usd.Init();
        		if (SacheData.PlateMap==null)
        			throw new DataBaseException("数据库连接出错!");
		}
        ServletContext sc= session.getServletContext();
		if(sc.getAttribute("INDEX_HEAD")==null){
			sc.setAttribute("INDEX_HEAD", ihps.getIndex_Head_Pliot());
		}
		//板块列表
		map.put("PLATE", SacheData.IndexPlateMap);
		//论坛会员人数
		map.put("BBS_USER_COUNT", SacheData.SettingMap.get("forum_user_count").getValue());
		//论坛帖子人数
		map.put("BBS_FORUM_POST_COUNT", SacheData.SettingMap.get("forum_post_count").getValue());
		//论坛名称人数
		map.put("BBS_FORUM_NAME", SacheData.SettingMap.get("forum_name").getValue());
		//在线人数
		map.put("count", SacheData.Onlinecount);
		//在线登录会员人数
		map.put("UserCount", SacheData.OnlineUsercount);
		//今日帖子总数
		map.put("ToDayPostCount", SacheData.TodayPostCount);
		//昨日帖子总数
		map.put("YesterdayPostCount", SacheData.YesterdayPostCount);
		return "index";
	}
	
}
