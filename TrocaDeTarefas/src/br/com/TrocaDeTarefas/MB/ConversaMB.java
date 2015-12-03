package br.com.TrocaDeTarefas.MB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

import br.com.TrocaDeTarefas.DAO.ConversaDAO;
import br.com.TrocaDeTarefas.DAO.UsuarioDAO;
import br.com.TrocaDeTarefas.Model.Conversa;
import br.com.TrocaDeTarefas.Model.Mensagem;
import br.com.TrocaDeTarefas.Model.Usuario;


@ManagedBean(name = "Conversa")
@SessionScoped
public class ConversaMB {
	private Usuario usuariosessao;
	private List<Usuario> abasBatePapo;
	private Usuario userAba;
	private Conversa conversa;
	
	public Conversa getConversa() {
		return conversa;
	}
	public void setConversa(Conversa conversa) {
		this.conversa = conversa;
	}
	public void showMensagens(){
		Map<String,Object> options = new HashMap<String, Object>();
		options.put("resizable", false);
		options.put("modal",true);
		options.put("width", 900);
        options.put("height", 600);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        RequestContext.getCurrentInstance().openDialog("MensagemVIEW", options, null);
	}
	public Usuario getUserAba() {
		return userAba;
	}
	public void setUserAba(Usuario userAba) {
		this.userAba = userAba;
	}
	public List<Usuario> getAbasBatePapo() {
		return abasBatePapo;
	}

	public void setAbasBatePapo(List<Usuario> abasBatePapo) {
		this.abasBatePapo = abasBatePapo;
	}
	public Usuario getUsuariosessao() {
		return usuariosessao;
	}

	public void setUsuariosessao(Usuario usuariosessao) {
		this.usuariosessao = usuariosessao;
	}
	private void abasBatePapo(Conversa Conv){
		ArrayList<Usuario>user = new ArrayList<Usuario>();
		for(Mensagem msn: Conv.getMensagens()){
			if(existAbaUser(user, msn.getEmissor()) == false){
				user.add(msn.getEmissor());
			}
		}
		abasBatePapo = user;
	}
	private boolean existAbaUser(ArrayList<Usuario>user, Usuario User){
	
			for(Usuario usuario : user){
				if(usuario.getCpf().equals(User.getCpf())){
					return true;
				}			
			}
			return false;
	}
	@PostConstruct
	public void init(){
		usuariosessao = new UsuarioDAO().buscarPorId("12345");
		conversa = new ConversaDAO().buscarPorId(usuariosessao);
		abasBatePapo(conversa);
		
	}
}
