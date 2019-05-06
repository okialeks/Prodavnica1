package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Admin;
import service.LoginMetode;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "servlet za log in", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		LoginMetode login = new LoginMetode();
		Admin admin = new Admin();
		
		if(login.daLiPostojiUser(userName)) {
			if(login.daLiJeDobarPass(userName, password)) {
				if(userName.equals(admin.getAdminUserName()) && password.equals(admin.getAdminPassword())) {
					response.sendRedirect("jsp/admin.jsp");
				}else {
					response.sendRedirect("jsp/user.jsp");
				}
				
			}else {
				response.sendRedirect("index.html");

			}
		}else {
			response.sendRedirect("error.html");
		}
		
		
	}

}
