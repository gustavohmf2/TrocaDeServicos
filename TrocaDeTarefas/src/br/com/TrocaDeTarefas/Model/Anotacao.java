package br.com.TrocaDeTarefas.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Anotacao {

	
	
	public int idAnotacao;
	public String anotacao;
	public String Usuario;
	
	public int getIdAnotacao() {
		return idAnotacao;
	}
	public void setIdAnotacao(int idAnotacao) {
		this.idAnotacao = idAnotacao;
	}
	public String getAnotacao() {
		return anotacao;
	}
	public void setAnotacao(String anotacao) {
		this.anotacao = anotacao;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	
	
}
