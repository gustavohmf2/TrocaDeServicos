package br.com.TrocaDeTarefas.Model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Grupo {
	
	@Id
	private String idGrupo;
	private String nome;
	private String moderador;
	private String descricao;
	@DBRef
	private List<Usuario> usuario = new ArrayList<Usuario>();
	@DBRef
	private MuralGrupo mural;
	private int qtdUsuario;
	
	public String getModerador() {
		return moderador;
	}
	public void setModerador(String moderador) {
		this.moderador = moderador;
	}
	public String getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(String idGrupo) {
		this.idGrupo = idGrupo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Usuario> getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario user) {
		this.usuario.add(user);
	}
	public int getQtdUsuario() {
		return qtdUsuario;
	}
	public void setQtdUsuario(int qtdUsuario) {
		this.qtdUsuario = this.usuario.size();
	}
	
	
	
	
}
