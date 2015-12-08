package br.com.TrocaDeTarefas.MB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

import br.com.TrocaDeTarefas.Filtros.SessionContext;
import br.com.TrocaDeTarefas.Model.Avaliacao;
import br.com.TrocaDeTarefas.Model.Servico;
import br.com.TrocaDeTarefas.Model.Usuario;
import br.com.TrocaDeTarefas.Service.ServiceServico;

@ManagedBean(name = "servico")
@SessionScoped
public class ServicoMB implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Servico> Tarefas;

	private Avaliacao avaliacaouser = new Avaliacao();
	private Servico servicoSelecionado;

	public Servico getServicoSelecionado() {
		return servicoSelecionado;
	}

	public void setServicoSelecionado(Servico servicoSelecionado) {
		this.servicoSelecionado = servicoSelecionado;
	}
	public void SelecionarTarefa(Servico serv){		
		servicoSelecionado = serv;
	
	}

	public Avaliacao getAvaliacaouser() {
		return avaliacaouser;
	}
	
	public void showAvaliacao() {
		Map<String,Object> options = new HashMap<String, Object>();
		options.put("resizable", false);
		options.put("modal",true);
		options.put("width", 900);
        options.put("height", 600);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        RequestContext.getCurrentInstance().openDialog("AvaliazaoServico", options, null);
    }
	public void showDetalhes() {
		Map<String,Object> options = new HashMap<String, Object>();
		options.put("resizable", false);
		options.put("modal",true);
		options.put("width", 900);
        options.put("height", 600);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        RequestContext.getCurrentInstance().openDialog("ServicoDetalhado", options, null);
    }
	
	public void setAvaliacaouser(Avaliacao avaliacaouser) {
		this.avaliacaouser = avaliacaouser;
	}

	public void participar(Servico serv) {

		ArrayList<Usuario> aux = new ArrayList<Usuario>();
		if (serv.getParticipantes() != null) {
			aux = serv.getParticipantes();
		}

		if (existUser(aux, (Usuario) SessionContext.getInstance().getAtribute("usuario")) == false) {
			aux.add((Usuario) SessionContext.getInstance().getAtribute("usuario"));
		}
		serv.setParticipantes(aux);
		new ServiceServico().AtualizarServico(serv);

	}

	private boolean existUser(ArrayList<Usuario> aux, Usuario user) {

		for (Usuario participante : aux) {
			if (participante.getCpf().equals(user.getCpf())) {
				return true;
			}
		}
		return false;
	}
	public List<Avaliacao> getAvalicao() {
		ArrayList<Avaliacao> aval = new ArrayList<Avaliacao>();
//		aval = servicoSelecionado.getAvaliacao();
		Avaliacao ei = new Avaliacao();
		ei.setComentario("asdasdasdasdasd");
		aval.add(ei);
		
		return aval;
	}
	@PostConstruct
	public void init() {
		Tarefas = new ServiceServico().findALL();
	}

	public List<Servico> getTarefas() {
		return Tarefas;
	}

	public void setTarefas(List<Servico> tarefas) {
		Tarefas = tarefas;
	}

}
