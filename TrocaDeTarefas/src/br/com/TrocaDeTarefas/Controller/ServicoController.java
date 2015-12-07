package br.com.TrocaDeTarefas.Controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.TrocaDeTarefas.Model.Endereco;
import br.com.TrocaDeTarefas.Model.Servico;
import br.com.TrocaDeTarefas.Model.Usuario;
import br.com.TrocaDeTarefas.Service.ServiceServico;
import br.com.TrocaDeTarefas.Service.ServiceUsuario;

@ManagedBean(name="servicoController")
@SessionScoped
public class ServicoController {

	Servico servico;
	Usuario usuario;
	String login;
	
	ServiceUsuario servicoU;
	ServiceServico servicoS;
	@SuppressWarnings("rawtypes")
	DataModel listaServico;
	
	public ServicoController(){
		
		servico = new Servico();
		usuario = new Usuario();
		servicoU = new ServiceUsuario();
		servicoS = new ServiceServico();
	}
	
	public Servico getServico() {
		return servico;
	}



	public DataModel getListaServico() {
		
		List<Servico> lista = servicoS.findALL();
   		listaServico = new ListDataModel(lista);
   		return listaServico;
	
	}

	public void setListaServico(DataModel listaServico) {
		this.listaServico = listaServico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}
	
    
  

	public void cadastroDeServico(){
    	
    	System.out.println("aqui");
    	
    	servico.setUsuario(aux);
    	
    	servicoS.CadastrarServico(servico);
    	
    }


	public ServiceServico getServicoS() {
		return servicoS;
	}


	public void setServicoS(ServiceServico servicoS) {
		this.servicoS = servicoS;
	}
}
