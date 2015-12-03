package br.com.TrocaDeTarefas.Model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Avaliacao {

	private int idAvaliacao;
	private Usuario usuario;
	private String tipo;
	private String descricao;
	private Integer estrelas = 0;
	
	public int getIdAvaliacao() {
		return idAvaliacao;
	}
	public void setIdAvaliacao(int idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getEstrelas() {
		return estrelas;
	}
	public void setEstrelas(Integer estrelas) {
		this.estrelas = estrelas;
	}
	
	
	
}
