package br.com.intraBSC.grupo.controle;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.intraBSC.controle.DispatchActionBSC;
import br.com.intraBSC.grupo.visao.GrupoForm;
import br.com.intraBSC.negocio.GrupoBO;
import br.com.intraBSC.modelo.GrupoTO;

public class GrupoAction  extends DispatchActionBSC{
	
	public ActionForward consultarVarios(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			   
			GrupoBO grupoBO = new GrupoBO();
			GrupoTO grupoTO = new GrupoTO();
			GrupoForm grupoForm = (GrupoForm) form;
			grupoTO.setDescricao(grupoForm.getDescricao());
			grupoTO.setAtivo(grupoForm.getAtivo());
			Collection retorno = grupoBO.consultarVarios(grupoTO);
			request.setAttribute("listaGrupo",retorno);
			return mapping.findForward("sucesso");
	   } catch (Exception e) {
		   setErro("bsc.erro",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }		
	}
	public ActionForward incluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			   
		   GrupoBO grupoBO = new GrupoBO();
		   GrupoTO grupoTO = new GrupoTO();
		   GrupoForm grupoForm = (GrupoForm) form;
		   grupoForm.setGrupoTO(grupoTO);
		   grupoBO.incluir(grupoTO);
		   grupoForm.setAtivo(1);
		   setMensagem("bsc.mensagem.sucesso",request);
		   return mapping.findForward("sucesso");
	   } catch (Exception e) {
		   setErro("bsc.erro",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
	}

	public ActionForward alterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		   try {			   
			   GrupoBO grupoBO = new GrupoBO();
			   GrupoTO grupoTO = new GrupoTO();
			   GrupoForm grupoForm = (GrupoForm) form;
			   grupoForm.setGrupoTO(grupoTO);
			   grupoTO.setCodigo(grupoForm.getCodigo());
			   grupoBO.alterar(grupoTO);
			   setMensagem("bsc.mensagem.sucesso",request);
			   return mapping.findForward("sucesso");
		   } catch (Exception e) {
			   setErro("bsc.erro",e.getMessage(),request);
			   return mapping.findForward("erro");
		   }	
	}
	
	public ActionForward consultarUm(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			   
		   GrupoBO grupoBO = new GrupoBO();
		   GrupoTO grupoTO = new GrupoTO();
		   GrupoForm grupoForm = (GrupoForm) form;
		   grupoTO.setCodigo(grupoForm.getCodigo());
		   GrupoTO retorno = grupoBO.consultarUm(grupoTO);
		   request.setAttribute("grupoForm",retorno);			   
		   return mapping.findForward("sucesso");
	    } catch (Exception e) {
		   setErro("bsc.erro",e.getMessage(),request);
		   return mapping.findForward("erro");
	    }
	}
	public ActionForward encaminharAlterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			   
		   GrupoBO grupoBO = new GrupoBO();
		   GrupoTO grupoTO = new GrupoTO();
		   Integer codigo = (new Integer(request.getParameter("codigo").toString()));
		   grupoTO.setCodigo(codigo.intValue());
		   GrupoTO retorno = grupoBO.consultarUm(grupoTO);
		   GrupoForm grupoForm = (GrupoForm) form;
		   grupoForm.setGrupoForm(retorno);
		   return mapping.findForward("sucesso");
	    } catch (Exception e) {
		   setErro("bsc.erro",e.getMessage(),request);
		   return mapping.findForward("erro");
	    }
	}
	
	public ActionForward encaminharIncluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		return mapping.findForward("sucesso");
	}
	
	public ActionForward encaminharConsultar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		return mapping.findForward("sucesso");
	}
}
