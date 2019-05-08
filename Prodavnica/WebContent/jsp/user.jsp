<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "model.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>user strana</title>
</head>
<body>
	<%
		User user = (User)session.getAttribute("valter");
	
	%>
	<h1> Dobrodosli USER <%=user.getUserName() %></h1>
	<%
		int x = 5;
		int y = 2;
		
		int zbir = x+y;
		
		System.out.println(zbir);
	%>
	
	<p>Zbir brojeva je : <%=zbir %></p>
</body>
</html>