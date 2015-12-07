package br.com.TrocaDeTarefas.Model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Favorito {

	private int idFavorito;
	private List<Servico> servico;
	private String comentario;
	
	public int getIdFavorito() {
		return idFavorito;
	}
	public void setIdFavorito(int idFavorito) {
		this.idFavorito = idFavorito;
	}
	public List<Servico> getServico() {
		return servico;
	}
	public void setServico(List<Servico> servico) {
		this.servico = servico;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
}
