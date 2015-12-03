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
	private Usuario usuario = new Usuario();
	
	private Requisicao requisicao = new Requisicao();
	private boolean skip;
	private Servico serv = new Servico();
	
	@SuppressWarnings("rawtypes")
	DataModel listaGrupo;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		requisicao.setUsuario(usuario);
		requisicao.setIdRequisicao(1);
		servicoR.adicionarRequisicao(requisicao);
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
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public DataModel ListaUsuarios(){
		
		List<Usuario> lista = new ServiceUsuario().listarUsuarios();
		listaGrupo = new ListDataModel(lista);
		return listaGrupo;
	}
    


}
