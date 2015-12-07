package br.com.TrocaDeTarefas.Filtros;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * 
 * @author gustavo
 *Padrão singleton para evitar multiplas intaâncias no mesmo contexto da aplicação
 *Classe para retomar a sessão o criar uma nova, acessar atributos de sessão e setar esses
 *atributos
 */
public class SessionContext {

	private static SessionContext instance;
	
	public static SessionContext getInstance(){
		
		if(instance == null){
			
			instance = new SessionContext();
		}
		
		return instance;
	}
	
	public SessionContext(){}
	
	private ExternalContext currentExternalCOntext(){
		
		if(FacesContext.getCurrentInstance() == null){
			
			throw new RuntimeException("O FaceContext não pode ser chamado fora da requisição HTTP!");
		}else{
			
			return FacesContext.getCurrentInstance().getExternalContext();
		}
	}
	/**
	 * Encerra a sessão
	 */
	public void endSession(){
		
		currentExternalCOntext().invalidateSession();
	}
	
	/**
	 * 
	 * @param atribute, valor do atributo que deseja acessar da sessão
	 * @return retorna o objeto do que foi requisistado
	 */
	public Object getAtribute(String atribute){
		/**
		 * getSessionMap(), retorna um map com todos os atributos da sessão
		 */
		return currentExternalCOntext().getSessionMap().get(atribute);
	}
	
	/**
	 * 
	 * @param atribute, o atributo que deseja acessar da sessão
	 * @param value, o valor que deseja inserir no atributo
	 */
	public void setAtribute(String atribute, Object value){
		
		currentExternalCOntext().getSessionMap().put(atribute, value);
	}
}
