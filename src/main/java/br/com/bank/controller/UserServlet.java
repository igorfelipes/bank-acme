package br.com.bank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bank.model.User;
import br.com.bank.service.UserServiceImpl;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserServiceImpl userService;
       
    public UserServlet() {
    		this.userService = new UserServiceImpl();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher requestDispatcher;
		String action = request.getParameter("action");

			switch(action) {
			
				case "list":
					request.setAttribute("users", this.userService.getAll());
					requestDispatcher = request.getRequestDispatcher("admin/pages/listar_usuarios.jsp");
					requestDispatcher.forward(request, response);
					break;
				case "delete":
					
					String idUsuario = request.getParameter("id");
					this.userService.deleteUser(Long.parseLong(idUsuario));
					
					request.setAttribute("removed", "User removed successfully!");
					requestDispatcher = request.getRequestDispatcher("/UserServlet?&action=list");
					requestDispatcher.forward(request, response);
					break;
				case "register":
					requestDispatcher = request.getRequestDispatcher("admin/pages/registro_usuarios.jsp");
					requestDispatcher.forward(request, response);
					break;
					
				case "edit":
					
					User usuarioEdit = new User();
					usuarioEdit.setId(Long.parseLong(request.getParameter("id")));
					usuarioEdit.setUsername(request.getParameter("user"));
					usuarioEdit.setPassword(request.getParameter("password"));
		
					request.setAttribute("usuario", usuarioEdit);
					requestDispatcher = request.getRequestDispatcher("admin/pages/editar_usuarios.jsp");
					requestDispatcher.forward(request, response);
					break;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String userId = request.getParameter("id");
		String action = request.getParameter("action");
		
		RequestDispatcher requestDispatcher;
		
		switch(action) {
		
		case "edit":
			
			
			User userEdited = User.builder()
				.username(username)
				.password(password)
				.id(Long.parseLong(userId)).build();
			
			this.userService.editUser(userEdited);
			requestDispatcher = request.getRequestDispatcher("admin/pages/listar_usuarios.jsp");
			request.setAttribute("success", "User "+ userEdited.getUsername() +" edited successfully");
			request.setAttribute("users", this.userService.getAll());
			requestDispatcher.forward(request, response);
			break;
			
		case "register":
			
			boolean userAlreadyExists = userService.usernameAlreadyExists(username);
			
			if(userAlreadyExists) {
				request.setAttribute("errorRegister", "Username already exists. Try again!");
				requestDispatcher = request.getRequestDispatcher("admin/pages/registro_usuarios.jsp");
				requestDispatcher.forward(request, response);
				break;
			}
			
			User userRegister = User.builder()
				.username(username)
				.password(password).build();
			
			userService.registerUser(userRegister);
			requestDispatcher = request.getRequestDispatcher("admin/pages/listar_usuarios.jsp");
			request.setAttribute("success", "User "+ userRegister.getUsername() +" Registered successfully");
			request.setAttribute("users", this.userService.getAll());
			requestDispatcher.forward(request, response);
			break;

		}
		
	}

}
