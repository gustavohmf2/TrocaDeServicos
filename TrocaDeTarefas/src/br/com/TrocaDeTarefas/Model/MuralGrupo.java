package br.com.TrocaDeTarefas.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class MuralGrupo {

	
	
	private String idMural;
	private Anotacao anotacao;
	
	public String getIdMural() {
		return idMural;
	}
	public void setIdMural(String idMural) {
		this.idMural = idMural;
	}
	public Anotacao getAnotacao() {
		return anotacao;
	}
	public void setAnotacao(Anotacao anotacao) {
		this.anotacao = anotacao;
	}
	
	
}
