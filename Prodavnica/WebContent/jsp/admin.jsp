<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "model.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>admin strana</title>
</head>
<body>
	<%
		User user = (User)session.getAttribute("valter");
	
	%>
	<h1> Dobrodosli ADMIN!!!! <%=user.getUserName() %></h1>
	
	<form action="../DodajProizvodServlet" method="get">
		<input type="text" placeholder = "Product Name" name = "productName">
		<input type="text" placeholder = "Price" name = "price">
		<input type="text" placeholder = "Stock" name = "stock">
		<input type="text" placeholder = "Discount" name = "discount">
		<input type="submit" value="dodaj proizvod">
	</form>
</body>
</html>