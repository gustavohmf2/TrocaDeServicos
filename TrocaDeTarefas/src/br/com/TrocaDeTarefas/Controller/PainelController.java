package br.com.TrocaDeTarefas.Controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.primefaces.event.FlowEvent;

import br.com.TrocaDeTarefas.Model.Endereco;
import br.com.TrocaDeTarefas.Model.Requisicao;
import br.com.TrocaDeTarefas.Model.Servico;
import br.com.TrocaDeTarefas.Model.Usuario;
import br.com.TrocaDeTarefas.Service.ServiceUsuario;
import br.com.TrocaDeTarefas.Service.ServicoRequisicao;

@ManagedBean(name="painelController")
@SessionScoped
public class PainelController {

		
	private ServicoRequisicao servicoR = new ServicoRequisicao();
	private ServiceUsuario servicoU = new ServiceUsuario();
	private Usuario user = new Usuario();
	
	private Requisicao requisicao = new Requisicao();
	private boolean skip;
	private Servico serv = new Servico();
	
	@SuppressWarnings("rawtypes")
	DataModel listaGrupo ;
	@SuppressWarnings("rawtypes")
	DataModel listaUsuario;
	
	public ServicoRequisicao getServicoR() {
		return servicoR;
	}

	public ServiceUsuario getServicoU() {
		return servicoU;
	}

	public void setServicoU(ServiceUsuario servicoU) {
		this.servicoU = servicoU;
	}

	public Servico getServ() {
		return serv;
	}

	public void setServ(Servico serv) {
		this.serv = serv;
	}

	public void setServicoR(ServicoRequisicao servico) {
		this.servicoR = servico;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario usuario) {
		this.user = usuario;
	}
	
	public Requisicao getRequisicao() {
		return requisicao;
	}

	public void setRequisicao(Requisicao requisicao) {
		this.requisicao = requisicao;
	}
	public Usuario usuarioLogado(String login){
		
		return servicoU.buscarUsuarioId(login);
	}
	
	public void cadastrarInteresse(){
		
		requisicao.setData("10/02/2015");
		requisicao.setUsuario(user);
		requisicao.setIdRequisicao(1);
		servicoR.adicionarRequisicao(requisicao);
	}

	public DataModel getListaGrupo() {
		return listaGrupo;
	}

	public void setListaGrupo(DataModel listaGrupo) {
		this.listaGrupo = listaGrupo;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataModel getListaUsuario() {
		
		//List<Usuario> lista = servicoU.listarUsuarios();
		
		listaUsuario = new ListDataModel(servicoU.listarUsuarios());
		if(listaUsuario == null){
			
			System.out.println("Error!");
		}
		return listaUsuario;
	}

	public void setListaUsuario(DataModel listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public boolean isSkip() {
        return skip;
    }
 
    public void setSkip(boolean skip) {
        this.skip = skip;
    }
     
    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
    
    
    


}
