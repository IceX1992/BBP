package org.unasat.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.unasat.hibernate.dao.HibernateUserDao;
import org.unasat.model.User;
import org.unasat.service.RegisterService;


public class RegisterController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	 response.setContentType("text/html;charset=UTF-8");
	 PrintWriter out = response.getWriter();
	 String email = request.getParameter("email");
	 String userId = request.getParameter("userId");
	 String password = request.getParameter("password");
	 User user = new User(email,userId, password);
			
	 try {	
		 RegisterService registerService = new RegisterService(new HibernateUserDao());
		 boolean result = registerService.register(user);		

		 if(result){
			 response.sendRedirect("login2.jsp");
		 }else{
			 response.sendRedirect("login2.jsp");

		 }

	 } finally {		
		 out.close();
	 }
}

}