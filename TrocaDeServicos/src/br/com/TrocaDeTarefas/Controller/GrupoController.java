package br.com.TrocaDeTarefas.Controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import com.mongodb.MongoException;

import br.com.TrocaDeTarefas.Model.Anotacao;
import br.com.TrocaDeTarefas.Model.Grupo;
import br.com.TrocaDeTarefas.Model.MuralGrupo;
import br.com.TrocaDeTarefas.Model.Usuario;
import br.com.TrocaDeTarefas.Service.GrupoService;
import br.com.TrocaDeTarefas.Service.ServiceUsuario;

@ManagedBean(name="grupoController")
@SessionScoped
public class GrupoController {
		
	Usuario usuario = new Usuario();
	Grupo grupo = new Grupo();
	MuralGrupo mural = new MuralGrupo();
	Anotacao anotacao = new Anotacao();

	@SuppressWarnings("rawtypes")
	DataModel listaGrupo;
	@SuppressWarnings("rawtypes")
	DataModel listaUsuario;
	
	GrupoService service = new GrupoService();
	ServiceUsuario uService = new ServiceUsuario();
	String login =  new String();
	String grupoNome =  new String();

	public String getGrupoNome() {
		return grupoNome;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataModel getListaUsuario() {
		
		listaUsuario = null;
		try{
			Usuario aux = uService.buscarUsuarioPorLogin(login);
			
			List<Usuario> lista = uService.listarUsuarios();
			listaUsuario = new ListDataModel(lista);
			return listaUsuario;
		}catch(ExceptionInInitializerError e){
			e.printStackTrace();
			return listaUsuario;
		}
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataModel getListaGrupo(){
		
		listaGrupo = null;
		
		try{
			List<Grupo> lista = new GrupoService().listarGrupos();
			listaGrupo = new ListDataModel(lista);
			return listaGrupo;
		}catch(ExceptionInInitializerError e){
			e.printStackTrace();
			return listaGrupo;
		}
	}

	public void setListaUsuario(DataModel listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public void setGrupoNome(String grupoNome) {
		this.grupoNome = grupoNome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	
	public String visualizarGrupo(){
		
		Grupo grupoTemp = (Grupo)(listaGrupo.getRowData());
		return "acessoGrupo?idGrupo="+grupoTemp.getIdGrupo();
	}
	
	public void criarGrupo(){
		
		
		String idGrupo = "";
		System.out.println(uService.buscarUsuarioId("123456789"));
		Usuario aux = uService.buscarUsuarioId("123456789");
		if(service.listarGrupos().size() > 0){ 
			idGrupo += 1+service.listarGrupos().size();
			System.out.println(idGrupo);
		}else{
			idGrupo += '1';
		}
		try{
			grupo.setModerador("123456789");
			grupo.setUsuario(aux);
			grupo.setIdGrupo(idGrupo);
			grupo.setQtdUsuario(3);
			System.out.println(service.criarGrupo(grupo));
			FacesContext.getCurrentInstance().addMessage(null,
	                new FacesMessage("Grupo criado!"));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	public void removerGrupo(){
		
		Grupo grupoTemp = (Grupo)(listaGrupo.getRowData());
		System.out.println(service.removerGrupo(grupoTemp));
		
	}
	
	public void editarGrupo(){
		
		Grupo grupoTemp = (Grupo)(listaGrupo.getRowData());
		grupoTemp.setNome("testando atualizacao");
		System.out.println(service.editarGrupo(grupoTemp));
		
	}
	
	public void removerUsuario(){
		System.out.println("aqui!");
		try{
			Usuario usuarioTemp = (Usuario)(listaUsuario.getRowData());
			System.out.println(usuarioTemp.getCpf());
			uService.removerUsuario(usuarioTemp);
		}catch(MongoException me){
			me.printStackTrace();
		}
		
	}
	
	public void adicionarParticipante(){
		
		System.out.println("aqui");
		System.out.println(login+" - "+grupoNome);
		Grupo aux = service.buscarGrupo(grupoNome);
		String idAux = aux.getIdGrupo();
		System.out.println(idAux+" - "+aux.getIdGrupo());
		service.adicionarParticipante(uService.buscarUsuarioPorLogin(login), aux);
		
		
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public GrupoService getService() {
		return service;
	}

	public void setService(GrupoService service) {
		this.service = service;
	}

	public ServiceUsuario getuService() {
		return uService;
	}

	public void setuService(ServiceUsuario uService) {
		this.uService = uService;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
