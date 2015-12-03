package br.com.TrocaDeTarefas.MB;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.TrocaDeTarefas.DAO.ConversaDAO;
import br.com.TrocaDeTarefas.Model.Conversa;
import br.com.TrocaDeTarefas.Model.Mensagem;
import br.com.TrocaDeTarefas.Model.Usuario;

@ManagedBean(name = "MensagemMB")
@SessionScoped
public class MensagemMB {
	private Usuario emissorMsg;
	private Conversa batePapo;
	private Mensagem resposta = new Mensagem();
	
	public Mensagem getResposta() {
		return resposta;
	}

	public void setResposta(Mensagem resposta) {
		this.resposta = resposta;
	}

	public Conversa getBatePapo() {
		return batePapo;
	}

	public void setBatePapo(Conversa batePapo) {
		this.batePapo = batePapo;
	}

	public Usuario getEmissorMsg() {
		return emissorMsg;
	}

	public void setEmissorMsg(Usuario emissorMsg) {
		this.emissorMsg = emissorMsg;
	}
	public void responder(){
		Conversa respostaUser = new ConversaDAO().buscarPorId(emissorMsg);
		if(respostaUser == null){
			respostaUser = new Conversa();
			respostaUser.setDestinatario(emissorMsg);
		}
		if(respostaUser.getMensagens()==null){
			ArrayList<Mensagem>msg = new ArrayList<Mensagem>();
			msg.add(resposta);
			respostaUser.setMensagens(msg);
		}else{
			respostaUser.getMensagens().add(resposta);
		}
		new ConversaDAO().adicionar(respostaUser);
	}
	public ArrayList<String> mensagens(){
		ArrayList<String>mensagens = new ArrayList<String>();
		for(Mensagem msg : batePapo.getMensagens()){
			if(msg.getEmissor().getCpf().equals(emissorMsg.getCpf())){
				mensagens.add(msg.getMensagem());
			}
		}
		return mensagens;
	}
}
