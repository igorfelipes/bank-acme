package br.com.bank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.bank.service.UserServiceImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserServiceImpl userService;

	public LoginServlet() {
		this.userService = new UserServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("logout")) {
			HttpSession session = request.getSession();
			session.invalidate();

			RequestDispatcher rd = request.getRequestDispatcher("admin/login.jsp");
			rd.forward(request, response);
		}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("LOGIN SERVLET");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		RequestDispatcher requestDispatcher;
		HttpSession session = request.getSession();

		
		boolean matchCredentialsUser = userService.isValidUser(username, password);

		if (!matchCredentialsUser) {
			requestDispatcher = request.getRequestDispatcher("/admin/login.jsp");
			request.setAttribute("error", "username or password invalid");
			requestDispatcher.forward(request, response);
		}

		session.setAttribute("userLogged", username);
		response.sendRedirect("/acme-bank/admin/home");
	
		
	}

}
