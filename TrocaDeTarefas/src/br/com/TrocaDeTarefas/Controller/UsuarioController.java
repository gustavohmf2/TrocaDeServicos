package br.com.TrocaDeTarefas.Controller;



import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.TrocaDeTarefas.Filtros.SessionContext;
import br.com.TrocaDeTarefas.Model.Endereco;
import br.com.TrocaDeTarefas.Model.Usuario;
import br.com.TrocaDeTarefas.Service.ServiceUsuario;

@ManagedBean(name="usuarioController")
@SessionScoped
public class UsuarioController {
	
	
	ServiceUsuario servicoUsuario = new ServiceUsuario();
	SessionContext session;
	Endereco endereco = new Endereco();
	Usuario usuario = new Usuario();
	String msg = new String();
	
	
	
	public UsuarioController(){
		
		session = SessionContext.getInstance();
	}
	
	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}



	public ServiceUsuario getServicoUsuario() {
		return servicoUsuario;
	}



	public void setServicoUsuario(ServiceUsuario servicoUsuario) {
		this.servicoUsuario = servicoUsuario;
	}



	public Endereco getEndereco() {
		return endereco;
	}



	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}



	public Usuario getUsuario() {
		
		return (Usuario)session.getAtribute("usuario");
	}



	public void setUsuario(Usuario usuario) {
		
		
		this.usuario = usuario;
	}



	public void cadastrar(){
		
		usuario.setEndereco(endereco);
		servicoUsuario.adicionarUsuario(usuario);
		
		FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Cadastro Realizado!"));
	}
}
