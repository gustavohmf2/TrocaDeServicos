package br.com.TrocaDeTarefas.Filtros;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		
		System.out.println("Sess�o: "+event.getSession().getId());
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {

		 String ultimoAcesso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")).format(new Date(event.getSession().getLastAccessedTime()));
         System.out.println("Sess�o expirada "+event.getSession().getId()+". Ultimo Acesso = "+ultimoAcesso);
		//redireciona para uma tela que mostra que a sess�o foi encerrada e voltar para a tela de login
	}

}
