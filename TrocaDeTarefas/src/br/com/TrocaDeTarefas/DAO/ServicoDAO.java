package br.com.TrocaDeTarefas.DAO;




import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;


import br.com.TrocaDeTarefas.Model.Servico;



@Repository
public class ServicoDAO extends GenericDAOImplements<Servico> implements IServicoDAO {

	

	public ServicoDAO() {
		super(Servico.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Servico serv) {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("usuario").is(serv.getUsuario()));
		query.addCriteria(Criteria.where("nome").is(serv.getNome()));
		
	
		Update update = new Update();
		update.set("usuario", serv.getUsuario());
		update.set("nome", serv.getNome());
		update.set("descricao", serv.getDescricao());
		update.set("participantes", serv.getParticipantes());
		update.set("avaliacao", serv.getAvaliacao());
		
		mongoOperation.updateFirst(query, update, Servico.class);
		
	}

}
