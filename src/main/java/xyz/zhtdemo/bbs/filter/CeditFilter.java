package xyz.zhtdemo.bbs.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import xyz.zhtdemo.bbs.entity.UserEnt;
import xyz.zhtdemo.bbs.util.SacheData;


@WebFilter(urlPatterns={"/cedit.go","/updatepost.go","/publish.go","/repUpdate.go","/reply.go"})

public class CeditFilter implements Filter {


	public void destroy() {

	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		int fid = Integer.parseInt(req.getParameter("fid"));
		UserEnt ue = (UserEnt) req.getSession().getAttribute("USER");
		if (ue == null) {
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendRedirect("login.html?type=log");
			return;
		}
		int gid = ue.getGid();
		if (ue.getAgid() != null) {
			gid = ue.getAgid();
		}
		if (SacheData.User_GroupMap.get(gid).getAccess_rights() >= SacheData.PlateMap.get(fid).getAccess_rights()) {
			chain.doFilter(request, response);
		}else{
			request.setAttribute("TITL", "权限不足");
			int PlateAccess_right= SacheData.PlateMap.get(fid).getAccess_rights();
			int UserAccess_right=SacheData.User_GroupMap.get(gid).getAccess_rights();
			request.setAttribute("MSG", "您现所在的用户组无法发帖!"
					+ "该页面需要阅读权限:"+PlateAccess_right+"以上才能发帖,当前阅读权限:"+UserAccess_right);
			request.setAttribute("A_URL", "index.do");
			request.getRequestDispatcher("error.do").forward(request, response);
		}
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
