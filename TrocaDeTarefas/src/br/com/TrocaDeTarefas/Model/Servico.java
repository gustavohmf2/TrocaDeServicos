package br.com.TrocaDeTarefas.Model;

import java.util.ArrayList;


import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Servico {
	
	private Usuario usuario;
	private String nome;
	private String descricao;
	private ArrayList<Usuario>participantes; 
	private ArrayList<Avaliacao>avaliacao;
	
	
	public ArrayList<Usuario> getParticipantes() {
		return participantes;
	}
	public void setParticipantes(ArrayList<Usuario> participantes) {
		this.participantes = participantes;
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
	public ArrayList<Avaliacao> getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(ArrayList<Avaliacao> avaliacao) {
		this.avaliacao = avaliacao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
