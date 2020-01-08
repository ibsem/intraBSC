package br.com.intraPRO.item.controle;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.intraPRO.controle.DispatchActionPRO;
import br.com.intraPRO.item.visao.ListaOpcaoItemForm;
import br.com.intraPRO.modelo.ListaOpcaoItemTO;
import br.com.intraPRO.negocio.ListaOpcaoItemBO;

public class ListaOpcaoItemAction extends DispatchActionPRO{
	
	public ListaOpcaoItemAction(){		
	}
	
	
	public ActionForward incluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		try {
			ListaOpcaoItemForm listaOpcaoItemForm  = (ListaOpcaoItemForm) form;
			ListaOpcaoItemTO listaOpcaoItemTO = new ListaOpcaoItemTO();
			listaOpcaoItemForm.setListaOpcaoItemTO(listaOpcaoItemTO);
			ListaOpcaoItemBO listaOpcaoItemBO = new ListaOpcaoItemBO();
			listaOpcaoItemBO.incluir(listaOpcaoItemTO);
			listaOpcaoItemTO.setTexto("");
			listaOpcaoItemTO.setCodigo(0);
			Collection listaOpcao = listaOpcaoItemBO.consultarVarios(listaOpcaoItemTO);
			if (!listaOpcao.isEmpty()){
				request.getSession().setAttribute("listaOpcaoItem",listaOpcao);
			}
		} catch (Exception e) {
			setErro("pro.lista.opcaoItem.incluir.erro", e.getMessage(),request);
			return mapping.findForward("erro");
	   	}
	   	return mapping.findForward("sucesso");
	}

	public ActionForward alterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		try {
			ListaOpcaoItemForm listaOpcaoItemForm  = (ListaOpcaoItemForm) form;
			ListaOpcaoItemTO listaOpcaoItemTO = new ListaOpcaoItemTO();
			listaOpcaoItemForm.setListaOpcaoItemTO(listaOpcaoItemTO);
			ListaOpcaoItemBO listaOpcaoItemBO = new ListaOpcaoItemBO();
			listaOpcaoItemBO.alterar(listaOpcaoItemTO);
			listaOpcaoItemTO.setTexto("");
			listaOpcaoItemTO.setCodigo(0);
			Collection listaOpcao = listaOpcaoItemBO.consultarVarios(listaOpcaoItemTO);
			if (!listaOpcao.isEmpty()){
				request.getSession().setAttribute("listaOpcaoItem",listaOpcao);
			}
		} catch (Exception e) {
			setErro("pro.lista.opcaoItem.incluir.erro", e.getMessage(),request);
			return mapping.findForward("erro");
	   	}
	   	return mapping.findForward("sucesso");
	}
	

	public ActionForward consultarVarios(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		try {
			ListaOpcaoItemForm listaOpcaoItemForm  = (ListaOpcaoItemForm) form;
			ListaOpcaoItemTO listaOpcaoItemTO = new ListaOpcaoItemTO();
			listaOpcaoItemForm.setListaOpcaoItemTO(listaOpcaoItemTO);
			ListaOpcaoItemBO listaOpcaoItemBO = new ListaOpcaoItemBO();
			Collection listaOpcao = listaOpcaoItemBO.consultarVarios(listaOpcaoItemTO);
			if (!listaOpcao.isEmpty()){
				request.getSession().setAttribute("listaOpcaoItem",listaOpcao);
			}
		} catch (Exception e) {
			setErro("pro.lista.opcaoItem.incluir.erro", e.getMessage(),request);
			return mapping.findForward("erro");
	   	}
	   	return mapping.findForward("sucesso");
	}

}
