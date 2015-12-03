package br.com.TrocaDeTarefas.Model;



public class Mensagem {
	
	private Usuario emissor;
	private String mensagem;
	public Usuario getEmissor() {
		return emissor;
	}
	public void setEmissor(Usuario emissor) {
		this.emissor = emissor;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
