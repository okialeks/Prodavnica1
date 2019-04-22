package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.HibernateMetode;

/**
 * Servlet implementation class RegistracioniServlet
 */
@WebServlet(description = "ovo je servlet za registraciju", urlPatterns = { "/RegistracioniServlet" })
public class RegistracioniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		HibernateMetode hm = new HibernateMetode();
		
		if(hm.ubaciUseraUBazu(userName, password)) {
			//sve ok
			response.sendRedirect("index.html");
		}else {
			//nije ubacio
			response.sendRedirect("registracija.html");
		}
		
	}

}
