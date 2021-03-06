package br.com.TrocaDeTarefas.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.TrocaDeTarefas.DAO.UsuarioDAO;
import br.com.TrocaDeTarefas.Filtros.SessionContext;
import br.com.TrocaDeTarefas.Model.Usuario;


@ManagedBean(name="loginController")
@SessionScoped
public class LoginController {

	private String login;
	private String senha;
	private SessionContext session;
	String msg = new String();
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public LoginController(){
		
		session = SessionContext.getInstance();
		
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String validaLogin(){
		
		UsuarioDAO dao = new UsuarioDAO();
		System.out.println("Validando...");
		
		Usuario userTemp = dao.buscarUsuarioPorLogin(login);
		
		
		if(userTemp.getLogin().equals(login) && userTemp.getSenha().equals(senha)){
			
			System.out.println("Logando..");
			session.setAtribute("usuario", userTemp);
			session.setAtribute("logado", true);
			
			
			return "/views/telaUsuario.jsf?faces-redirect=true";
			
		}else{
			
			session.setAtribute("msg", "login ou senha inv�lido!");
			
			FacesContext.getCurrentInstance().addMessage(null,
	                new FacesMessage("Usu�rio ou senha incorretos"));
			
			return "index.jsf?faces-redirect=true";
		}
			
	}
	
}
