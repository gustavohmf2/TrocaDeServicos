package br.com.TrocaDeTarefas.DAO;




import br.com.TrocaDeTarefas.Model.Conversa;
import br.com.TrocaDeTarefas.Model.Usuario;


public interface IConversa extends GenericDAO<Conversa> {
	
	public Conversa buscarPorId(Usuario user);
}
