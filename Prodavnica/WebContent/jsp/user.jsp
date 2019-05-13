<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "model.User" %>
<%@ page import = "model.Product" %>
<%@ page import = "service.HibernateMetode" %>
<%@ page import = "java.util.*" %>
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
	
	<form method="get" action="../KupiProizvodServlet">
		<table>
			<tr>
				<th>ime proizvoda</th>
				<th>cena</th>
				<th>popust</th>
				<th>cekiraj proizvod</th>
				<th>koliko komada</th>
			</tr>
			<%
				HibernateMetode hm = new HibernateMetode();
				List<Product> listaProizvoda = new ArrayList<Product>();
					listaProizvoda = hm.vratiSveProizvode();
				
				for(Product p: listaProizvoda){
			%>
			<tr>
				<td> <%=p.getProductName() %></td>
				<td> <%=p.getPrice() %></td>
				<td> <%=p.getDiscount() %></td>
				<td> <input type="checkbox" name = "check" value = "<%=p.getIdProduct()%>"></td>
				<td> <select name="selekti">
						<% for(int i =0; i<= p.getStock(); i++){ 
						
						%>
							<option value = "<%=i%>"><%=i%></option>
						<%} %>
					 </select>
				</td>
			</tr>
			<%
				}
			%>
			<tr><input type="submit" value = "kupi"></tr>
		</table>
	</form>

</body>
</html>