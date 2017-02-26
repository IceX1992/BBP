package org.unasat.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.unasat.hibernate.dao.HibernateUserDao;
import org.unasat.model.User;
import org.unasat.service.LoginService;

public class LoginController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		LoginService loginService = new LoginService(new HibernateUserDao());
		boolean result = loginService.authenticateUser(userId, password);
		
		if (result == true) {
			HttpSession session = request.getSession();
			
			User user = loginService.getUserByUserId(userId);
			session.setAttribute("user", user);
			
			List<User> list = loginService.getListOfUsers();
			session.setAttribute("listOfUsers", list);
			
			ServletContext ctx = getServletContext();      
			session.setAttribute("owner", ctx.getAttribute("owner"));
			
			session.setMaxInactiveInterval(10);
			response.sendRedirect("home.jsp");
		} else {
			response.sendRedirect("error.jsp");
		}
	}

}