package br.com.TrocaDeTarefas.Service;

import java.util.List;

import br.com.TrocaDeTarefas.Model.Usuario;

public interface IServiceUsuario {
	
	public Usuario buscarUsuarioId(String cpf);
	public void removerUsuario(Usuario usuario);
	public void adicionarUsuario(Usuario usuario);
	public List<Usuario> listarUsuarios();
	public String editarUsuario(String arg1,String arg2,String arg3);
	Usuario buscarUsuarioPorLogin(String login);
}
