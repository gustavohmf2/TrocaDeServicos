package br.com.TrocaDeTarefas.DAO;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.transaction.annotation.Transactional;

import br.com.TrocaDeTarefas.SpringMongoConfig;

@Transactional
public class GenericDAOImplements<T>  implements GenericDAO<T> {
	

	private ApplicationContext ctx;
	
	protected MongoOperations mongoOperation;
	private Class<T> objeto;
	
	public GenericDAOImplements(){
		super();
	}
	
	public  GenericDAOImplements(Class<T> ct){
		
		ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
		this.objeto = ct;
	}
	
	@Override
	public void adicionar(T entidade) {
		mongoOperation.save(entidade);
		
	}

	@Override
	public void remover(T entidade) {
		Query query = new Query(Criteria.where("id").is(entidade));
		mongoOperation.remove(query, entidade.getClass());
	}

	@Override
	public List<T> listar() {
		
		List<T> lista = (List<T>) mongoOperation.findAll(objeto);
		return lista;
	}

	@Override
	public T buscarPorId(String id) {
		Query query = new Query(Criteria.where("cpf").is(id));
		return mongoOperation.findOne(query, objeto);
	}
	@Override
	/**
	 * argumento1 o valor do campo a ser procurado
	 * argumento2 o campo a ser mudado
	 * argumento3 o valor para atualizar
	 * os valores devem se corresponder
	 */
	public void update(String argumento1, String argumento2, String argumento3) {
		// TODO Auto-generated method stub
		Query query = new Query(Criteria.where("id").is(argumento1));
		query.fields().include(argumento1);
	
		Update update = new Update();
		update.set(argumento2, argumento3);
		
		mongoOperation.updateFirst(query, update, objeto);
		
		
		
	}
}
