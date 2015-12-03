package br.com.TrocaDeTarefas.DAO;



import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import br.com.TrocaDeTarefas.Model.Conversa;
import br.com.TrocaDeTarefas.Model.Usuario;

public class ConversaDAO extends GenericDAOImplements<Conversa> implements IConversa{

	public ConversaDAO() {
		super(Conversa.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Conversa buscarPorId(Usuario user) {
		
			Query query = new Query(Criteria.where("_id").is(user));
			return mongoOperation.findOne(query, Conversa.class);
		
	}	
}
