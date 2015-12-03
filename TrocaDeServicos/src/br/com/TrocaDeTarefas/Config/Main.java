package br.com.TrocaDeTarefas.Config;

import br.com.TrocaDeTarefas.DAO.EnderecoDAO;
import br.com.TrocaDeTarefas.DAO.UsuarioDAO;
import br.com.TrocaDeTarefas.Model.Endereco;
import br.com.TrocaDeTarefas.Model.Usuario;

public class Main {

	public static void main(String args[]){
		
		Usuario teste;
		UsuarioDAO dao;
		
		EnderecoDAO daoE;
		Endereco endereco;
		
		teste = new Usuario();
		endereco = new Endereco();
		
		daoE = new EnderecoDAO();
		dao = new UsuarioDAO();
		
		endereco.setCidade("cidade");
		endereco.setCep("cep");
		endereco.setBairro("bairro");
		endereco.setRua("rua");
		endereco.setNumero(10);
		endereco.setComplemento("complemento");
		endereco.setIdEndereco(1);
		
		daoE.adicionar(endereco);
		
		//teste.setNome("gustavo");
		//teste.setNome("gustavo");
		//teste.setCpf("09232578450");
//		teste.setEmail("mu2ra3@yahoo.com.br");
//		teste.setIdade(23);
//		teste.setLogin("guga");
//		teste.setSenha("123456");
//		teste.setTelefone("96670251");
///		teste.setEndereco(endereco);
		
		
//		dao.adicionar(teste);
		
		//System.out.println(dao.listar().get(0).getNome());
		
	}
}
