<%@page import="org.unasat.model.User"%>
<%@page import="org.unasat.hibernate.dao.HibernateUserDao"%>
<%@page import="java.util.List"%>
<%@page import="org.unasat.service.LoginService"%>
<%@page import="java.util.Date"%>
<%@page import="org.unasat.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/style.css"/>
	<title>Result Page</title>
</head>
<body>
<center>
	<div id="container">
		<h1>Result Page</h1>
		<b><%=session.getAttribute("owner") %>
			<b><%=getServletContext().getInitParameter("appName") %>
				(<%=getServletContext().getInitParameter("versieNummer") %>)</b><br/>
				<%=new Date() %></br>
				<%
				 User user = (User) session.getAttribute("user");
			 %>
			<b>Welcome <%= user.getFirstName() + " " + user.getLastName()%> </b>
			<br/>
			<a href="logout.jsp">Logout</a>
			</p>

			<table>
				<thead>
				<tr>
					<th>User ID</th>
					<th>First Name</th>
					<th>Middle Name</th>
					<th>Last Name</th>
					<th>email</th>
				</tr>
				</thead>
				<tbody>
					<%
					 List<User> list = (List<User>) session.getAttribute("listOfUsers");
					 for (User u : list) {
				 %>
				<tr>
					<td><%=u.getUserId()%></td>
					<td><%=u.getFirstName()%></td>
					<td><%=u.getMiddleName()%></td>
					<td><%=u.getLastName()%></td>
					<td><%=u.getEmail()%></td>
				</tr>
					<%}%>
				<tbody>
			</table>
			<br/>
	</div>
</center>
</body>
</html>
