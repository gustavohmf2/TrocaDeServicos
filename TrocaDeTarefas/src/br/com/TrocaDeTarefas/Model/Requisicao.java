package br.com.TrocaDeTarefas.Model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Requisicao {

	private int idRequisicao;
	private Usuario usuario;
	private Servico servico;
	private String descricao;
	private String data;
	private String aferta;
	private int periodo;
	
	
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	public int getIdRequisicao() {
		return idRequisicao;
	}
	public void setIdRequisicao(int idRequisicao) {
		this.idRequisicao = idRequisicao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getAferta() {
		return aferta;
	}
	public void setAferta(String aferta) {
		this.aferta = aferta;
	}
	public int getPeriodo() {
		return periodo;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	
	
	
}
