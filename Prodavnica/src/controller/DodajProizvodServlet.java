package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DodajProizvodServlet
 */
@WebServlet(description = "dodavanje proizvoda", urlPatterns = { "/DodajProizvodServlet" })
public class DodajProizvodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productName = request.getParameter("productName");
		String price = request.getParameter("price");
		String stock = request.getParameter("stock");
		String discount = request.getParameter("discount");
		
		
	}

}
