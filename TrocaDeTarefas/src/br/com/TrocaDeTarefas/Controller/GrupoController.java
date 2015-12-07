package br.com.TrocaDeTarefas.Controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import com.mongodb.MongoException;

import br.com.TrocaDeTarefas.Filtros.SessionContext;
import br.com.TrocaDeTarefas.Model.Anotacao;
import br.com.TrocaDeTarefas.Model.Grupo;
import br.com.TrocaDeTarefas.Model.MuralGrupo;
import br.com.TrocaDeTarefas.Model.Usuario;
import br.com.TrocaDeTarefas.Service.GrupoService;
import br.com.TrocaDeTarefas.Service.ServiceUsuario;

@ManagedBean(name="grupoController")
@SessionScoped
public class GrupoController {
		
	Usuario usuario;
	Grupo grupo;
	MuralGrupo mural;
	Anotacao anotacao;
	SessionContext session;

	GrupoService service;
	ServiceUsuario uService;
	String login;
	String grupoNome;

	@SuppressWarnings("rawtypes")
	DataModel listaGrupo;
	@SuppressWarnings("rawtypes")
	DataModel listaUsuario;
	
	public GrupoController(){
		
		session = SessionContext.getInstance();
		service = new GrupoService();
		uService = new ServiceUsuario();
		login =  new String();
		grupoNome =  new String();
		usuario = new Usuario();
		grupo = new Grupo();
		mural = new MuralGrupo();
		anotacao = new Anotacao();
	}
	
	
	public String getGrupoNome() {
		return grupoNome;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataModel getListaUsuario() {
		
		listaUsuario = null;
		try{
			
			Grupo aux = (Grupo) session.getAtribute("grupoAcessado");		
			listaUsuario = new ListDataModel(aux.getUsuario());
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
			
			Usuario userTemp = (Usuario) session.getAtribute("usuario"); 
			grupo.setModerador(userTemp.getCpf());
			grupo.setUsuario(userTemp);
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
		
		try{
			
			Grupo grupoTemp = (Grupo) session.getAtribute("grupoAcessado");
			Usuario usuarioTemp = (Usuario)(listaUsuario.getRowData());
			int count = 0;
			
			for(Usuario u: grupoTemp.getUsuario()){
				
				if(u.getCpf().equals(grupoTemp.getUsuario().get(count).getCpf())){
					
					grupoTemp.getUsuario().remove(count);
				}
				count++;
			}
			
			service.editarGrupo(grupoTemp);
			
		}catch(MongoException me){
			me.printStackTrace();
		}
		
	}
	
	public void adicionarParticipante(){
		
		
		Grupo grupoTemp = (Grupo) session.getAtribute("grupoAcessado");
		service.adicionarParticipante(uService.buscarUsuarioPorLogin(login), grupoTemp);
		
		
	}
	
	public String acessarGrupo(){
		
		Grupo grupoTemp = (Grupo)(listaGrupo.getRowData());
		session.setAtribute("grupoAcessado", grupoTemp);
		return "/views/Grupo/acessoGrupo.jsf?faces-redirect=true";
		
	}
	
	public Grupo grupoAcessado(){
		
		return (Grupo) session.getAtribute("grupoAcessado");
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
