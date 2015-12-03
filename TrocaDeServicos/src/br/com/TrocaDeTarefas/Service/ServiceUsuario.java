package br.com.TrocaDeTarefas.Service;


import java.util.List;
import br.com.TrocaDeTarefas.DAO.UsuarioDAO;
import br.com.TrocaDeTarefas.Model.Usuario; 

public class ServiceUsuario implements IServiceUsuario{

	
	UsuarioDAO usuarioDao = new UsuarioDAO();
	String msgError = ""; 
	@Override
	public Usuario buscarUsuarioId(String cpf){
		
		return  usuarioDao.buscarUsuarioPorLogin(cpf);
	}
	@Override
	public Usuario buscarUsuarioPorLogin(String login){
		
		Usuario aux = usuarioDao.buscarUsuarioPorLogin(login);
		System.out.println("Usuario encontrado: "+aux.getNome());
		return aux;
	}
	@Override
	public void removerUsuario(Usuario usuario){
		System.out.println("removendo usuário, "+ usuario.getCpf()+"!");
		 usuarioDao.removerUsuario(usuario.getCpf());
	}
	@Override
	public void adicionarUsuario(Usuario usuario){
		System.out.println("aqui");
		 usuarioDao.adicionar(usuario);
	}
	@Override
	public List<Usuario> listarUsuarios(){
		
		return  usuarioDao.listar();
	}


	public UsuarioDAO getUsuarioDao() {
		return (UsuarioDAO) usuarioDao;
	}

	public void setUsuarioDao(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	@SuppressWarnings("finally")
	@Override
	public String editarUsuario(String arg1,String arg2,String arg3) {
		
		try{
			usuarioDao.update(arg1, arg2, arg3);
			msgError =  "Usuario atualizado!";
		}catch(Exception e){
			
			msgError = "Não foi possível atualizar usuario! "+e.getMessage();
		}finally{
			return msgError;
		}
		
	}

}
