package br.com.TrocaDeTarefas.Service;

import java.util.List;

import br.com.TrocaDeTarefas.Model.Requisicao;


public interface IServicoRequisicao {

	public Requisicao buscarRequisicaoID(int id);
	public void removerRequisicao(Requisicao requisiscao);
	public void adicionarRequisicao(Requisicao requisiscao);
	public List<Requisicao> listarUsuarios();
	
}
