package br.com.TrocaDeTarefas.DAO;

import java.util.List;



public interface GenericDAO<T> {

	public void adicionar(T entidade);
	public List<T> listar();
	public T buscarPorId(String id);
	public void remover(T entidade);
	void update(String argumento1, String argumento2, String argumento3);
	
}
