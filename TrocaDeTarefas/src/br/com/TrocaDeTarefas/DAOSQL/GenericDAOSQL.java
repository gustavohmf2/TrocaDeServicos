package br.com.TrocaDeTarefas.DAOSQL;

import java.io.Serializable;
import java.util.List;

public interface GenericDAOSQL<T> {
	
	public void adicionar(T entidade);
	public List<T> listar();
	public T buscarPorId(Serializable id);
	public void remover(T entidade);
	
}
