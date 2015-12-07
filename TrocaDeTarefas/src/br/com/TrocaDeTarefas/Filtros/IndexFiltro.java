package br.com.TrocaDeTarefas.Filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IndexFiltro implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		try{
			
			HttpSession session = ((HttpServletRequest) request).getSession(false);
			HttpServletRequest requisicao = (HttpServletRequest ) request;
			HttpServletResponse resposta = (HttpServletResponse) response;
			
			//flag que define se o usuário está logado
			boolean logado = (Boolean) session.getAttribute("logado");
			//Uri que fez a requisição 
			String URI = requisicao.getRequestURI();
			System.out.println("Filtrando requisição");
			System.out.println((String) URI);
			
		    String contextPath = ((HttpServletRequest) request).getContextPath();

			System.out.println(URI);
			if(URI.contains("/views") && !logado){
				
				redireciona(contextPath+"/index.jsf", resposta);
				
			}else{
				
				chain.doFilter(requisicao, resposta);
			}
		}catch(Throwable t){
			
			System.out.println(t.getMessage());
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	public void redireciona(String url, ServletResponse resp) 
			throws IOException{
		
		HttpServletResponse res = (HttpServletResponse) resp;
		res.sendRedirect(url);
	}
	

}
