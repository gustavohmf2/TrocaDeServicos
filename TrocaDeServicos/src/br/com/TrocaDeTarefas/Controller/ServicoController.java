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

@ManagedBean(name="servicoController")
@SessionScoped
public class ServicoController {

	Servico servico = new Servico();
	ServiceServico servicoS = new ServiceServico();
	@SuppressWarnings("rawtypes")
	DataModel listaServico;
	
	
	public Servico getServico() {
		return servico;
	}



	public void setServico(Servico servico) {
		this.servico = servico;
	}
	
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
   	public DataModel ListaServicos(){
   		
   		List<Servico> lista = new ServiceServico().listarServicos();
   		listaServico = new ListDataModel(lista);
   		return listaServico;
   	}


	public void cadastroDeServico(){
    	
    	System.out.println("aqui");
    	Usuario aux = new Usuario();
    	Endereco end = new Endereco();
    	
    	end.setBairro("azul");
    	end.setCep("12323542");
    	end.setCidade("Natal");
    	end.setComplemento("UFRN");
    	end.setNumero(8);
    	end.setRua("Rua das Palmeiras");
    	end.setIdEndereco(2);
    	
    	aux.setNome("Teste1");
    	aux.setCpf("1357902");
    	aux.setEmail("teste@gmail.com");
    	aux.setIdade(23);
    	aux.setLogin("teste");
    	aux.setSenha("123456");
    	aux.setEndereco(end);
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
