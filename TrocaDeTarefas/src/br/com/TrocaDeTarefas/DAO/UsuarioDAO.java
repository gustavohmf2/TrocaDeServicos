package br.com.TrocaDeTarefas.DAO;



import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.MongoException;

import br.com.TrocaDeTarefas.Model.Usuario;


@Repository
public class UsuarioDAO extends GenericDAOImplements<Usuario> implements IUsuarioDAO{
	
	
	public UsuarioDAO() {
		super(br.com.TrocaDeTarefas.Model.Usuario.class);
		// TODO Auto-generated constructor stub
	}
	@Override
	public Usuario buscarUsuarioPorId(String id) {
		Query query = new Query(Criteria.where("cpf").is(id));
		return mongoOperation.findOne(query, Usuario.class);
	}
	
	@Override
	public Usuario buscarUsuarioPorLogin(String login) {
		Query query = new Query(Criteria.where("login").is(login));
		return mongoOperation.findOne(query, Usuario.class);
	}
	
	public void editarUsuario(String id, String modificar, String campo){
		
		Query query = new Query(Criteria.where("id").is(id));
		query.fields().include("id");
		Update update= new Update();
		update.set(campo, modificar);
		
		mongoOperation.updateFirst(query, update, Usuario.class);
		System.out.println("Aqui");
	}
	
	
	public void removerUsuario(String idUsuario) {
		//Query query = new Query(Criteria.where("id").is(entidade));
		try{
			Query query = new Query(Criteria.where("cpf").is(idUsuario));
			mongoOperation.remove(query, Usuario.class);
		}catch(MongoException me){
			me.printStackTrace();
		}
	}
	

}
