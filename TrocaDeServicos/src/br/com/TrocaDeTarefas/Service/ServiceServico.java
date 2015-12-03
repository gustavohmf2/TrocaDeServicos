package br.com.TrocaDeTarefas.Service;

import java.util.List;

import br.com.TrocaDeTarefas.DAO.ServicoDAO;
import br.com.TrocaDeTarefas.Model.Servico;

public class ServiceServico {

	private ServicoDAO dao;
	private String msgErro;
	
	public ServiceServico(){
		
		dao = new ServicoDAO();
		msgErro = "";
	}
	
	@SuppressWarnings("finally")
	public String CadastrarServico(Servico servico){
		try{
			
			dao.adicionar(servico);
			msgErro = "Adicionado !";
		}catch(Exception e){
			
			msgErro = "Não foi possível adicionar o serviço"+e.getMessage();
		}finally{
			return msgErro;
		}
		
		
	}
	
	public List<Servico>listarServicos(){
		
		return dao.listar();
	}
}
