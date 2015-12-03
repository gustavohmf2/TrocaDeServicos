package br.com.TrocaDeTarefas.Service;

import java.util.List;

import br.com.TrocaDeTarefas.DAO.GrupoDAO;
import br.com.TrocaDeTarefas.DAO.MuralGrupoDAO;
import br.com.TrocaDeTarefas.Model.Anotacao;
import br.com.TrocaDeTarefas.Model.Grupo;
import br.com.TrocaDeTarefas.Model.Usuario;

public class GrupoService implements IGrupoService{

	protected GrupoDAO meuGrupo;
	protected MuralGrupoDAO meuMural;

	String msgError;
	String nomeGrupo;
	
	
	
	public String getMsgError() {
		return msgError;
	}

	public void setMsgError(String msgError) {
		this.msgError = msgError;
	}

	public String getNomeGrupo() {
		return nomeGrupo;
	}

	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}

	public GrupoService(){
		meuGrupo = new GrupoDAO();
		meuMural = new MuralGrupoDAO();
		msgError = "";
	}
	
	public GrupoDAO getMeuGrupo() {
		return meuGrupo;
	}

	public void setMeuGrupo(GrupoDAO meuGrupo) {
		this.meuGrupo = meuGrupo;
	}

	public MuralGrupoDAO getMeuMural() {
		return meuMural;
	}

	public void setMeuMural(MuralGrupoDAO meuMural) {
		this.meuMural = meuMural;
	}
	
	public String adicionarAnotacaoMural(Anotacao anaotacao){
		
		
		return msgError;
		
	}
	
	@SuppressWarnings("finally")
	@Override
	public String adicionarParticipante(Usuario usuario, Grupo grupo) {
		
		System.out.println("Segundo passo grupo servico");
		System.out.println(usuario.getNome()+" - "+grupo.getNome());
		try{
			System.out.println("2º passo grupoServico");
			
			msgError = meuGrupo.adicionarUsuario(usuario, grupo.getIdGrupo());
			grupo.setIdGrupo(grupo.getIdGrupo()+1);
			meuGrupo.adicionar(grupo);
		}catch(Exception e){
			
			msgError = "Não foi possível adicionar usuario ao grupo! "+e.getMessage();
		}finally{
			System.out.println(msgError);
			return msgError;
		}
	
	}

	@Override
	public String removerParticipante(String cpf) {
		// TODO Auto-generated method stub
		return msgError;
	}

	@Override
	public String criarNota(Anotacao anotacao) {
		return msgError;
		// TODO Auto-generated method stub
		
	}

	@Override
	public String apagarNota(Anotacao anotacao) {
		return msgError;
		// TODO Auto-generated method stub
		
	}
	@SuppressWarnings("finally")
	@Override
	public String criarGrupo(Grupo grupo) {
		// TODO Auto-generated method stub
		try{
			//meuGrupo.adicionar(grupo);
			meuGrupo.adicionarGrupo(grupo);
			msgError =  "Novo grupo criado!";
		}catch(Exception e){
			
			msgError = "Não foi possível Criar o grupo! "+e.getMessage();
		}finally{
			return msgError;
		}
	}
	@SuppressWarnings("finally")
	@Override
	public String removerGrupo(Grupo grupo) {
		// TODO Auto-generated method stub
		try{
			meuGrupo.removerGrupo(grupo.getIdGrupo());
			msgError =  "Grupo removido!";
		}catch(Exception e){
			
			msgError = "Não foi possível remover! "+e.getMessage();
		}finally{
			return msgError;
		}
		
	}
	@Override
	public List<Grupo> listarGrupos() {
		
		return meuGrupo.listar();
	}

	@Override
	public Grupo buscarGrupo(String nomeGrupo) {
		// TODO Auto-generated method stub
		return meuGrupo.buscarGrupo(nomeGrupo);
	}
	@Override
	public Grupo buscarGrupoPorId(String id) {
		// TODO Auto-generated method stub
		
		Grupo aux = meuGrupo.buscarGrupoPorId(id);
		System.out.println(aux);
		return aux;
	}

	@SuppressWarnings("finally")
	@Override
	public String editarGrupo(String arg1, String arg2, String arg3) {
		
		try{
			meuGrupo.update(arg1, arg2, arg3);
			msgError =  "Grupo atualizados!";
		}catch(Exception e){
			
			msgError = "Não foi possível atualizar o grupo! "+e.getMessage();
		}finally{
			return msgError;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public String editarGrupo(Grupo grupo) {
		
		try{
			meuGrupo.adicionar(grupo);
			msgError =  "Grupo atualizados!";
		}catch(Exception e){
			
			msgError = "Não foi possível atualizar o grupo! "+e.getMessage();
		}finally{
			return msgError;
		}
	}

}
