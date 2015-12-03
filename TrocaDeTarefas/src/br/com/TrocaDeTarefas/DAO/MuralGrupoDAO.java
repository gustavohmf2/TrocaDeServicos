package br.com.TrocaDeTarefas.DAO;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import br.com.TrocaDeTarefas.Model.Grupo;
import br.com.TrocaDeTarefas.Model.MuralGrupo;

public class MuralGrupoDAO extends GenericDAOImplements<MuralGrupo> implements IMuralGrupoDAO{

	public MuralGrupoDAO() {
		super(br.com.TrocaDeTarefas.Model.MuralGrupo.class);
		// TODO Auto-generated constructor stub
	}
	
	public MuralGrupo getMuralPorId(String id){
		
		System.out.println("Aqui");
		Query query = new Query(Criteria.where("id").is(id));
		return (MuralGrupo) mongoOperation.findOne(query, MuralGrupo.class);
		
		
	}
}
