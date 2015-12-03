package br.com.TrocaDeTarefas.DAOSQL;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class GenericDAOSQLimplements<T> implements  GenericDAOSQL<T>{

	private Class<T> classEntity;
	protected static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("MySQL"); 
	
	
	public GenericDAOSQLimplements() {
		super();
		// TODO Auto-generated constructor stub
		this.classEntity = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void adicionar(T entidade) {
		// TODO Auto-generated method stub
		EntityManager manager = factory.createEntityManager();
		try{
			manager.getTransaction().begin();;
			manager.persist(entidade);
			manager.getTransaction().commit();
		}finally{
			if(manager != null){
				manager.close();
			}
		}
		
	}

	@Override
	public List<T> listar() {
		// TODO Auto-generated method stub
		EntityManager manager = factory.createEntityManager();
		try{
			String query = "from" + classEntity.getSimpleName();
			return manager.createQuery(query).getResultList();
		}finally{
			if(manager != null){
				manager.close();
			}
		}
	}

	@Override
	public T buscarPorId(Serializable id) {
		// TODO Auto-generated method stub
		EntityManager manager = factory.createEntityManager();
		try{
			return manager.find(classEntity, id);
		}finally{
			if(manager != null){
				manager.close();
			}
		}
	}

	@Override
	public void remover(T entidade) {
		// TODO Auto-generated method stub
		EntityManager manager = factory.createEntityManager();
		try{
			manager.remove(entidade);
		}finally{
			if(manager != null){
				manager.close();
			}
		}
	}

}
