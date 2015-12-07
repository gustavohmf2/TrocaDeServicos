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

public class GrupoFiltro implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		try{
			
			HttpServletRequest requisicao = (HttpServletRequest ) request;
			HttpServletResponse resposta = (HttpServletResponse) response;
			
			String URI = requisicao.getRequestURI();
			if(URI.indexOf("/painelGrupo.xhtml") >= 0){
						resposta.sendRedirect(requisicao.getContextPath()+"/painelUsuario.jsf");
			}else{
				
				chain.doFilter(request, response);
			}
		}catch(Throwable t){
			
			System.out.println(t.getMessage());
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public void filtroGrupo(ServletRequest request, ServletResponse response, FilterChain chain, String idGrupo)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		try{
			
			HttpServletRequest requisicao = (HttpServletRequest ) request;
			HttpServletResponse resposta = (HttpServletResponse) response;
			
			String URI = requisicao.getRequestURI();
			if(URI.indexOf("/painelGrupo.xhtml") >= 0){
						resposta.sendRedirect(requisicao.getContextPath()+"/grupo/acessoGrupo.jsf?idGrupo="+idGrupo);
			}else{
				
				chain.doFilter(request, response);
			}
		}catch(Throwable t){
			
			System.out.println(t.getMessage());
		}
		
	}

}
