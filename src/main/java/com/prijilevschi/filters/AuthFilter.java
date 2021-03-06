package com.prijilevschi.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;


public class AuthFilter implements Filter{

	private static final Logger logger = Logger.getLogger(AuthFilter.class);
	
	public AuthFilter(){
		
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try{
			// check wherher session variable is set
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;
			HttpSession ses = req.getSession(false);
			//  allow user to proccede if url is login.xhtml or user logged in or user is accessing any page in //public folder
			String reqURI = req.getRequestURI();
            if ( reqURI.indexOf("/login.xhtml") >= 0 || (ses != null && ses.getAttribute("username") != null)
                                       || reqURI.indexOf("/") >= 0 || reqURI.contains("javax.faces.resource") )
                   chain.doFilter(request, response);
            else   // user didn't log in but asking for a page that is not allowed so take user to login page
                   res.sendRedirect(req.getContextPath() + "/login.xhtml");  // Anonymous user. Redirect to login page
      
		} catch(Throwable e){
			logger.error(e.getMessage());
		}		
	}
	
}
