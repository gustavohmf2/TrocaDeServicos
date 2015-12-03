package br.com.TrocaDeTarefas.DAO;

import java.io.Serializable;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import br.com.TrocaDeTarefas.Model.Usuario;

public interface IUsuarioDAO extends GenericDAO<Usuario>, Serializable{
		
	public Usuario buscarUsuarioPorId(String id);

	public Usuario buscarUsuarioPorLogin(String login);
}
