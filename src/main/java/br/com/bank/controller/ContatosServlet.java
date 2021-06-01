package br.com.bank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bank.model.Contact;
import br.com.bank.service.ContatoServiceImpl;

/**
 * Servlet implementation class ContatoServlet
 */
@WebServlet("/contatosServlet")
public class ContatosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private Contact contato;
	private ContatoServiceImpl service;
	
	public ContatosServlet() {
		this.service = new ContatoServiceImpl();
		this.contato = new Contact();
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		switch (acao) {
		
		case "remover":
			// processar a remoção do contato
			String id = request.getParameter("id");
			System.out.println(id);
			// criar o metodo de remocão no dao, e no service
			// chamar o service aqui, passando o id (da request) como parametro para executar a remoção do contato
			
		case "editar":
			
		case "listar":
			RequestDispatcher rd = request.getRequestDispatcher("/admin/pages/list_contatos.jsp");
			request.setAttribute("contatos", this.service.list());
			rd.forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			this.contato = new Contact();
			this.contato.setNome(request.getParameter("nome"));
			this.contato.setEmail(request.getParameter("email"));
			
			this.service.salvar(contato);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/pages/list_contatos.jsp");
			request.setAttribute("sucesso", "Contato "+ contato.getNome() +"salvo com sucesso");
			request.setAttribute("contatos", this.service.list());
			rd.forward(request, response);
	}

}
