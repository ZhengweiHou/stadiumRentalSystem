package com.hzw.StadiumRentalSystem.filter;
import java.io.IOException;

import javax.servlet.Filter; 
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author HZW_922
 *
 */
public class ToBack  implements Filter {

	private String path;
	public ToBack(){
	
		super();
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.path=filterConfig.getInitParameter("path");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher(path).forward(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

		
	}

}
