package br.com.TrocaDeTarefas.Service;

import java.util.List;

import br.com.TrocaDeTarefas.DAO.IRequisicaoDAO;
import br.com.TrocaDeTarefas.DAO.RequisicaoDAO;
import br.com.TrocaDeTarefas.DAO.ServicoDAO;
import br.com.TrocaDeTarefas.Model.Requisicao;
import br.com.TrocaDeTarefas.Model.Servico;

public class ServicoRequisicao implements IServicoRequisicao{

	private RequisicaoDAO servicoRequisicao = new RequisicaoDAO();
	private ServicoDAO servico = new ServicoDAO();
	private String msgErro = "";
	
	@Override
	public Requisicao buscarRequisicaoID(int id) {
		 
		return servicoRequisicao.buscarPorIdRequisicao(id);
	}

	@Override
	public void removerRequisicao(Requisicao requisiscao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Requisicao> listarUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void adicionarRequisicao(Requisicao requisiscao) {
		// TODO Auto-generated method stub
		
	}

	public RequisicaoDAO getServicoRequisicao() {
		return servicoRequisicao;
	}

	public void setServicoRequisicao(RequisicaoDAO servicoRequisicao) {
		this.servicoRequisicao = servicoRequisicao;
	}
	
	

}
