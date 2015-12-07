package br.com.TrocaDeTarefas.Service;



import java.util.List;

import org.springframework.stereotype.Service;

import br.com.TrocaDeTarefas.DAO.ServicoDAO;
import br.com.TrocaDeTarefas.Model.Servico;


@Service
public class ServiceServico {
	
	private ServicoDAO dao = new ServicoDAO();
	private String msgErro;
	
	public List<Servico> findALL(){
			
		return dao.listar();
	}
	
	public void AtualizarServico(Servico serv)
	{
		new ServicoDAO().update(serv);
	}
	
	@SuppressWarnings("finally")
	public String CadastrarServico(Servico servico){
		try{
			
			dao.adicionar(servico);
			msgErro = "Adicionado !";
		}catch(Exception e){
			
			msgErro = "Não foi possivel adicionar o servico"+e.getMessage();
		}finally{
			return msgErro;
		}
		
		
	}
}
