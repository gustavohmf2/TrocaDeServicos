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
		Usuario user = new Usuario();
		user.setNome("anderson araujo");
		user.setCpf("123234345");
		user.setLogin("anderson");
		user.setSenha("anderson");
		
		new UsuarioDAO().adicionar(user);
	}
}
