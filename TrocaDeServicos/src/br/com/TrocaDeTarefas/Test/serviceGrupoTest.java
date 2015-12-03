package br.com.TrocaDeTarefas.Test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import br.com.TrocaDeTarefas.DAO.UsuarioDAO;
import br.com.TrocaDeTarefas.Model.Endereco;
import br.com.TrocaDeTarefas.Model.Usuario;


public class serviceGrupoTest {
	
	UsuarioDAO dao;
	String sequencia = "";
	
	
	@BeforeGroups("grupoTeste2")
	public void afterGroups() {
		
		UsuarioDAO uDao = new UsuarioDAO();
		Usuario u = uDao.buscarUsuarioPorId("123456789");
		u.setNome("Rafael");
		uDao.editarUsuario("123456789", "JGustavo Henrique", "nome");
		sequencia = "3";

	}
	
	@BeforeClass
	public void beforeClass(){
		
		System.out.println("Criando o Usuário!");
		
		dao = new UsuarioDAO();
		
		Endereco endereco = new Endereco();
		endereco.setCidade("Parnamirim");
		endereco.setCep("59140800");
		endereco.setBairro("Bela Vista");
		endereco.setComplemento("perto do ponto de ônibus");
		endereco.setNumero(27);
		endereco.setRua("Rua Vermelha");
		
		Usuario usuario = new Usuario();
		
		usuario.setNome("Gilberto Gil");
		usuario.setCpf("12435687");
		usuario.setEmail("gil@teste.com");
		usuario.setIdade(27);
		usuario.setLogin("gil123");
		usuario.setSenha("1234");
		usuario.setTelefone("8973486");
		usuario.setEndereco(endereco);
		dao.adicionar(usuario);
	}
	@AfterClass
	public void afterClass(){
		
		System.out.println("Teste finalizado!");
		
	}

	@Test(groups = "grupoTeste")
	public void runTest1() {
		UsuarioDAO dao2 = new UsuarioDAO();
		Assert.assertEquals(dao2.buscarUsuarioPorId("12435687").getNome(), "Gilberto Gil");
		sequencia = "2";
	}

	@Test(groups = "grupoTeste2")
	public void runTest2() {
		Assert.assertEquals(sequencia, "2");
	}
	@Test(groups = "grupoTeste3")
	public void runTest3() {
		UsuarioDAO dao2 = new UsuarioDAO();
		Assert.assertFalse((dao2.buscarUsuarioPorId("123456789").getNome() == "Rafael"));
		Assert.assertEquals(sequencia, "3");
		System.out.println(sequencia);
	}
}
