package br.com.TrocaDeTarefas.DAO;

import java.io.Serializable;

import br.com.TrocaDeTarefas.Model.Grupo;
import br.com.TrocaDeTarefas.Model.Usuario;

public interface IGrupoDAO extends GenericDAO<Grupo>, Serializable{

	public String adicionarUsuario(Usuario usuario, String idGrupo);
	public Grupo buscarGrupo(String nomeGrupo);
	public void removerGrupo(String id);
	Grupo buscarGrupoPorId(String id);
	
}
