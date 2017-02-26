package org.unasat.filter;

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

/**
 * Servlet Filter implementation class SessionExpiredFilter
 */
public class SessionExpiredFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SessionExpiredFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req= (HttpServletRequest)request;
		HttpServletResponse resp= (HttpServletResponse)response;
		HttpSession session = req.getSession(false);// don't create if it doesn't exist
		try {
			if(session != null && !session.isNew()) {
				chain.doFilter(req, resp);
			} else {
			    resp.sendRedirect("timeout.jsp");
			}
		} catch (IOException io) {
			System.out.println("IOException raised in SimpleFilter");
		} catch (ServletException se) {
			resp.sendRedirect("timeout.jsp");
			System.out.println("ServletException raised in SimpleFilter");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
