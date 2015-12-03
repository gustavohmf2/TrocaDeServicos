package br.com.TrocaDeTarefas.DAO;

import br.com.TrocaDeTarefas.Model.Usuario;

public interface IUsuarioDAO extends GenericDAO<Usuario>{
	
	public Usuario buscarUsuarioPorId(String id);
	public Usuario buscarUsuarioPorLogin(String login);
}
