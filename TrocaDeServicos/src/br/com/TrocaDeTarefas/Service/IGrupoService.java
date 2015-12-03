package br.com.TrocaDeTarefas.Service;


import java.util.List;
import br.com.TrocaDeTarefas.Model.Anotacao;
import br.com.TrocaDeTarefas.Model.Grupo;
import br.com.TrocaDeTarefas.Model.Usuario;

public interface IGrupoService{

	public String criarGrupo(Grupo grupo);
	public String removerGrupo(Grupo grupo);
	public List<Grupo> listarGrupos();
	public String adicionarParticipante(Usuario usuario, Grupo grupo);
	public String removerParticipante(String cpf);
	public String criarNota(Anotacao anotacao);
	public String apagarNota(Anotacao anotacao);
	public Grupo buscarGrupo(String nomeGrupo);
	public String editarGrupo(String arg1,String arg2,String arg3);
	public String editarGrupo(Grupo grupo);
	public Grupo buscarGrupoPorId(String id);
	
}
