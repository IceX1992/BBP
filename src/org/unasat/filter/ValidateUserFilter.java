package org.unasat.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.unasat.model.User;
import org.unasat.service.ValidateService;

/**
 * Servlet Filter implementation class SessionExpiredFilter
 */
public class ValidateUserFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ValidateUserFilter() {
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

		 String email = request.getParameter("email");
		 String userId = request.getParameter("userId");
		 String password = request.getParameter("password");
		 User user = new User(email,userId, password);
		 List<String> errors = ValidateService.validate(user);

	        if (!errors.isEmpty()) {
	        	 ((HttpServletRequest)request).getSession().setAttribute("errMsg", errors);
	            ((HttpServletResponse)response).sendRedirect("validation-error.jsp");
	        } else {
	        	chain.doFilter(request, response);
	        }

	     
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
