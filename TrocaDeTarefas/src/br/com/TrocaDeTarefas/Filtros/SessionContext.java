package br.com.TrocaDeTarefas.Filtros;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * 
 * @author gustavo
 *Padr�o singleton para evitar multiplas inta�ncias no mesmo contexto da aplica��o
 *Classe para retomar a sess�o o criar uma nova, acessar atributos de sess�o e setar esses
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
			
			throw new RuntimeException("O FaceContext n�o pode ser chamado fora da requisi��o HTTP!");
		}else{
			
			return FacesContext.getCurrentInstance().getExternalContext();
		}
	}
	/**
	 * Encerra a sess�o
	 */
	public void endSession(){
		
		currentExternalCOntext().invalidateSession();
	}
	
	/**
	 * 
	 * @param atribute, valor do atributo que deseja acessar da sess�o
	 * @return retorna o objeto do que foi requisistado
	 */
	public Object getAtribute(String atribute){
		/**
		 * getSessionMap(), retorna um map com todos os atributos da sess�o
		 */
		return currentExternalCOntext().getSessionMap().get(atribute);
	}
	
	/**
	 * 
	 * @param atribute, o atributo que deseja acessar da sess�o
	 * @param value, o valor que deseja inserir no atributo
	 */
	public void setAtribute(String atribute, Object value){
		
		currentExternalCOntext().getSessionMap().put(atribute, value);
	}
}
