package br.com.TrocaDeTarefas.DAO;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import br.com.TrocaDeTarefas.Model.Requisicao;

public class RequisicaoDAO extends GenericDAOImplements<Requisicao> implements IRequisicaoDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Requisicao buscarPorIdRequisicao(int id){
		
		Query query = new Query(Criteria.where("idRequisicao").is(id));
		return mongoOperation.findOne(query, Requisicao.class);

		
	}
	
}
