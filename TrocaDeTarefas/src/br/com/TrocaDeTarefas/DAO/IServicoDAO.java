package br.com.TrocaDeTarefas.DAO;



import br.com.TrocaDeTarefas.Model.Servico;
;

public interface IServicoDAO extends GenericDAO<Servico>{
	
	public void update(Servico serv);
	
}
