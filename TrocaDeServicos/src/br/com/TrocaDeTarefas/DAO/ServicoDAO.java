package br.com.TrocaDeTarefas.DAO;

import br.com.TrocaDeTarefas.Model.Servico;

public class ServicoDAO extends GenericDAOImplements<Servico> implements IServicoDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServicoDAO() {
		super(br.com.TrocaDeTarefas.Model.Servico.class);
		// TODO Auto-generated constructor stub
	}
}
