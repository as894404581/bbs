package xyz.zhtdemo.bbs.handler;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import xyz.zhtdemo.bbs.entity.PlateEnt;
import xyz.zhtdemo.bbs.entity.UserEnt;
import xyz.zhtdemo.bbs.entity.User_GroupEnt;
import xyz.zhtdemo.bbs.util.SacheData;

/**
 * Servlet Filter implementation class IndexFilter
 */
@WebFilter(urlPatterns={"/forum.go","/forumAjaxPost.go"})

public class ForumgoFilters implements Filter {

	
    /**
     * Default constructor. 
     */
    public ForumgoFilters() {
       
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest r=(HttpServletRequest) request;
		int fid=Integer.parseInt(r.getParameter("fid"));
		HttpSession session=r.getSession();
		UserEnt ue=(UserEnt)session.getAttribute("USER");
		//默认为游客
		int gid=4;
		//如果登录获取用户Gid
		if(null!=ue){
			if(ue.getAgid()!=null){
				gid=ue.getAgid();
			}else{
				gid=ue.getGid();
			}
		}
		User_GroupEnt uge=SacheData.User_GroupMap.get(gid);
		PlateEnt pe=SacheData.PlateMap.get(fid);
		if(null==uge || null==pe){
			r.getRequestDispatcher("/WEB-INF/jsp/404error.jsp").forward(request, response);
			return;
		}
		
		if(uge.getAccess_rights()>=pe.getAccess_rights()){
			chain.doFilter(request, response);
		}else{
			request.setAttribute("TITL", "无权访问");
			int PlateAccess_right= SacheData.PlateMap.get(fid).getAccess_rights();
			int UserAccess_right=SacheData.User_GroupMap.get(gid).getAccess_rights();
			request.setAttribute("MSG", "您现所在的用户组无权访问该页面!"
					+ "该页面需要阅读权限:"+PlateAccess_right+"以上才能访问,当前阅读权限:"+UserAccess_right);
			request.setAttribute("A_URL", "index.do");
			r.getRequestDispatcher("error.do").forward(request, response);
		}
 		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
		
	}

}
