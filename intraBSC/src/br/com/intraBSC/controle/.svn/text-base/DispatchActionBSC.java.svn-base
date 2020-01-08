package br.com.intraBSC.controle;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

public class DispatchActionBSC extends DispatchAction {
	    /**
		 * Define uma mensagem para a página de saída.
		 */
		public void setMensagem(String key, HttpServletRequest request) {
				ActionMessages messages = new ActionMessages();
				ActionMessage message = new ActionMessage(key);
				messages.add(ActionMessages.GLOBAL_MESSAGE,message);
				saveMessages(request, messages);
		}
		
		public void setMensagem(String key, String[] values, HttpServletRequest request) {
				ActionMessages messages = new ActionMessages();
				ActionMessage message = new ActionMessage(key,values);
				messages.add(ActionMessages.GLOBAL_MESSAGE,message);
				saveMessages(request, messages);
		}
		
		/**
		 * Define uma mensagem de erro que será apresentada na página de saída.
		 */
		public void setErro(java.lang.String key, javax.servlet.http.HttpServletRequest request) {
				ActionErrors erros = new ActionErrors();
				ActionError erro = new ActionError(key);
				erros.add("ActionErrors.GLOBAL_ERROR",erro);			
				saveErrors(request, erros);
		}

		public void setErro(java.lang.String key, String[] values, HttpServletRequest request) {
				ActionErrors erros = new ActionErrors();
				ActionError erro = new ActionError(key,values);
				erros.add("ActionErrors.GLOBAL_ERROR",erro);			
				saveErrors(request, erros);
		}
		
		public void setErro(java.lang.String key, String values, HttpServletRequest request) {
			ActionErrors erros = new ActionErrors();
			ActionError erro = new ActionError(key,values);
			erros.add("ActionErrors.GLOBAL_ERROR",erro);			
			saveErrors(request, erros);
		}		

}
