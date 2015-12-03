package br.com.TrocaDeTarefas.DAO;

import java.io.Serializable;

import br.com.TrocaDeTarefas.Model.Requisicao;

public interface IRequisicaoDAO extends GenericDAO<Requisicao>, Serializable{
	
	public Requisicao buscarPorIdRequisicao(int id);
}
