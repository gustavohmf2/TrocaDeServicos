package br.com.TrocaDeTarefas.MB;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;



import br.com.TrocaDeTarefas.Model.Avaliacao;
import br.com.TrocaDeTarefas.Model.Servico;
import br.com.TrocaDeTarefas.Service.ServiceServico;


@ManagedBean(name = "avaliazao")
public class AvaliazaoMB {
	private Servico servicoSelecionado = new Servico();
	private List<Avaliacao> Avaliacao;
	private Integer media = 3;
	private Avaliacao comentario = new Avaliacao();
	
	
	public Avaliacao getComentario() {
		return comentario;
	}
	public void setComentario(Avaliacao comentario) {
		this.comentario = comentario;
	}
	public void avaliar(Servico serv){
		ArrayList<Avaliacao>aux = new ArrayList<Avaliacao>();
		aux = serv.getAvaliacao();
		aux.add(comentario);
		serv.setAvaliacao(aux);
		new ServiceServico().AtualizarServico(serv);
	}
	public void setMedia(Integer media) {
		this.media = media;
	}

	public Integer getMedia() {
		return media;
	}

	public List<Avaliacao> getAvaliacao() {
		return Avaliacao;
	}

	public void setAvaliacao(List<Avaliacao> avaliacao) {
		Avaliacao = avaliacao;
	}

	public Servico getServicoSelecionado() {
		return servicoSelecionado;
	}

	public void setServicoSelecionado(Servico servicoSelecionado) {
		this.servicoSelecionado = servicoSelecionado;
	}
	public void SelecionarTarefa(Servico serv){		
		servicoSelecionado = serv;
	
	}
	
	@PostConstruct
	public void init() {
		Avaliacao = servicoSelecionado.getAvaliacao();
	}

}
