package br.com.TrocaDeTarefas.DAO;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import br.com.TrocaDeTarefas.Model.Grupo;
import br.com.TrocaDeTarefas.Model.Usuario;

public class GrupoDAO extends GenericDAOImplements<Grupo> implements IGrupoDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GrupoDAO() {
		super(br.com.TrocaDeTarefas.Model.Grupo.class);
		// TODO Auto-generated constructor stub
	}
	
	
	@SuppressWarnings("finally")
	@Override
	public String adicionarUsuario(Usuario usuario, String id) {
		
		String mesgErro = "";
		System.out.println("3º passo grupoDAO: "+id);
		try{
			
			System.out.println(id);
			Query query = new Query(Criteria.where("idGrupo").is(id));
			query.fields().include("idGrupo");
			Update update= new Update();
			update.set("usuario", usuario);
			
			mongoOperation.updateFirst(query, update, Grupo.class);
			
			mesgErro = "O Usuario, "+usuario.getNome()+ "foi adicionado ao grupo!";
		}catch(Exception e){
			
			mesgErro = "Erro ao adicionar Usuário ao grupo ! " + e.getMessage();
		}finally{
			
			return mesgErro;
		}
	}
	
	@Override
	public Grupo buscarGrupo(String nomeGrupo){
		
		
		Query query = new Query(Criteria.where("nome").is(nomeGrupo));
		return (Grupo) mongoOperation.findOne(query, Grupo.class);
		
		
	}
	
	@Override
	public Grupo buscarGrupoPorId(String id){
		
		System.out.println("Aqui");
		Query query = new Query(Criteria.where("idGrupo").is(id));
		return (Grupo) mongoOperation.findOne(query, Grupo.class);
		
		
	}
	
	@Override
	public void removerGrupo(String id){
		
		System.out.println(id);
		Query query = new Query(Criteria.where("idGrupo").is(id));
		mongoOperation.remove(query, Grupo.class);
	}
	
	public void adicionarGrupo(Grupo grupo){
		
		
		List<Grupo> lista = mongoOperation.findAll(Grupo.class);
		String aux = "";
		if(lista.size() == 0){
			
			grupo.setIdGrupo("1");
		}else{
			aux = ""+lista.size()+1;
			grupo.setIdGrupo(aux);
		}
		
		mongoOperation.save(grupo);
		
	}
	
}
