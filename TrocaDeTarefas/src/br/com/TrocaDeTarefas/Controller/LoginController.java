package br.com.TrocaDeTarefas.Controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.TrocaDeTarefas.DAO.UsuarioDAO;


@ManagedBean(name="loginController")
@SessionScoped
public class LoginController {

	private String login;
	private String senha;
	
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
		String loginValidation = dao.buscarPorId(login).getLogin();
		String senhaValidation = dao.buscarPorId(login).getLogin();
		
		if(loginValidation == login && senhaValidation == senha){
			return "pass";
		}else{
			return "block";
		}
			
	}
	
}
