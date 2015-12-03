package br.com.TrocaDeTarefas;

import java.util.ArrayList;

import br.com.TrocaDeTarefas.DAO.ConversaDAO;
import br.com.TrocaDeTarefas.DAO.UsuarioDAO;
import br.com.TrocaDeTarefas.Model.Avaliacao;
import br.com.TrocaDeTarefas.Model.Conversa;
import br.com.TrocaDeTarefas.Model.Mensagem;
import br.com.TrocaDeTarefas.Model.Servico;
import br.com.TrocaDeTarefas.Model.Usuario;


public class Main {
 
	public static void main(String args[]){
		Conversa conv = new Conversa();
		conv.setDestinatario(new UsuarioDAO().buscarPorId("12345"));
		
		ArrayList<Mensagem>list = new ArrayList<Mensagem>();
		
		Mensagem msn = new Mensagem();
		msn.setEmissor(new UsuarioDAO().buscarPorId("12344333"));
		msn.setMensagem("ei maluco");
		list.add(msn);
		
		msn = new Mensagem();
		msn.setEmissor(new UsuarioDAO().buscarPorId("12344333"));
		msn.setMensagem("ei doido,responde ai");
		list.add(msn);
		
		conv.setMensagens(list);
		new ConversaDAO().adicionar(conv);
	}
}
