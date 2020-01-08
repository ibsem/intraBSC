package br.com.intraPRO.formulario.controle;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.intraPRO.controle.DispatchActionPRO;
import br.com.intraPRO.formulario.visao.ListaOpcaoFormularioForm;
import br.com.intraPRO.modelo.ListaOpcaoFormularioTO;
import br.com.intraPRO.negocio.ListaOpcaoFormularioBO;

public class ListaOpcaoFormularioAction extends DispatchActionPRO{
	
	public ListaOpcaoFormularioAction(){		
	}
	
	
	public ActionForward incluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		try {
			ListaOpcaoFormularioForm listaOpcaoFormularioForm  = (ListaOpcaoFormularioForm) form;
			ListaOpcaoFormularioTO listaOpcaoFormularioTO = new ListaOpcaoFormularioTO();
			listaOpcaoFormularioForm.setListaOpcaoFormularioTO(listaOpcaoFormularioTO);
			ListaOpcaoFormularioBO listaOpcaoFormularioBO = new ListaOpcaoFormularioBO();
			listaOpcaoFormularioBO.incluir(listaOpcaoFormularioTO);
			listaOpcaoFormularioTO.setTexto("");
			listaOpcaoFormularioTO.setCodigo(0);
			Collection listaOpcao = listaOpcaoFormularioBO.consultarVarios(listaOpcaoFormularioTO);
			if (!listaOpcao.isEmpty()){
				request.getSession().setAttribute("listaOpcaoFormulario",listaOpcao);
			}
		} catch (Exception e) {
			setErro("pro.lista.opcaoFormulario.incluir.erro", e.getMessage(),request);
			return mapping.findForward("erro");
	   	}
	   	return mapping.findForward("sucesso");
	}

	public ActionForward alterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		try {
			ListaOpcaoFormularioForm listaOpcaoFormularioForm  = (ListaOpcaoFormularioForm) form;
			ListaOpcaoFormularioTO listaOpcaoFormularioTO = new ListaOpcaoFormularioTO();
			listaOpcaoFormularioForm.setListaOpcaoFormularioTO(listaOpcaoFormularioTO);
			ListaOpcaoFormularioBO listaOpcaoFormularioBO = new ListaOpcaoFormularioBO();
			listaOpcaoFormularioBO.alterar(listaOpcaoFormularioTO);
			listaOpcaoFormularioTO.setTexto("");
			listaOpcaoFormularioTO.setCodigo(0);
			Collection listaOpcao = listaOpcaoFormularioBO.consultarVarios(listaOpcaoFormularioTO);
			if (!listaOpcao.isEmpty()){
				request.getSession().setAttribute("listaOpcaoFormulario",listaOpcao);
			}
		} catch (Exception e) {
			setErro("pro.lista.opcaoFormulario.incluir.erro", e.getMessage(),request);
			return mapping.findForward("erro");
	   	}
	   	return mapping.findForward("sucesso");
	}
	

	public ActionForward consultarVarios(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		try {
			ListaOpcaoFormularioForm listaOpcaoFormularioForm  = (ListaOpcaoFormularioForm) form;
			ListaOpcaoFormularioTO listaOpcaoFormularioTO = new ListaOpcaoFormularioTO();
			listaOpcaoFormularioForm.setListaOpcaoFormularioTO(listaOpcaoFormularioTO);
			ListaOpcaoFormularioBO listaOpcaoFormularioBO = new ListaOpcaoFormularioBO();
			Collection listaOpcao = listaOpcaoFormularioBO.consultarVarios(listaOpcaoFormularioTO);
			if (!listaOpcao.isEmpty()){
				request.getSession().setAttribute("listaOpcaoFormulario",listaOpcao);
			}
		} catch (Exception e) {
			setErro("pro.lista.opcaoFormulario.incluir.erro", e.getMessage(),request);
			return mapping.findForward("erro");
	   	}
	   	return mapping.findForward("sucesso");
	}

}
