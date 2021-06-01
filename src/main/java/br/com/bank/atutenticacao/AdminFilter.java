package br.com.bank.atutenticacao;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AdminFilter
 */

@WebFilter("/*")
public class AdminFilter implements Filter {
	
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		boolean taLogado = (session != null && session.getAttribute("userLogged") != null);
				
		String urlLogin = req.getContextPath() + "/admin/login";
		
		boolean ehPaginaLogin = req.getRequestURI().equals(urlLogin);
		boolean ehRequestLogin =  req.getRequestURI().endsWith("/LoginServlet");
				
//		if(taLogado && (ehPaginaLogin || ehRequestLogin))		
		if(taLogado && ehPaginaLogin) {		
			RequestDispatcher dispacher = request.getRequestDispatcher("/admin/home");
			dispacher.forward(request, response);
			System.out.println("Print teste....");
		}else if (taLogado || ehRequestLogin) {
			System.out.println("Executando Filtro de Login......");
			chain.doFilter(request, response);
		} else {
			
			RequestDispatcher dispacher = request.getRequestDispatcher("/admin/login");
			dispacher.forward(request, response);
			
		}
		
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Iniciando Filtro......");
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

}
