package br.com.intraBSC.recurso.controle;


import java.util.Collection;

import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;

import br.com.intraBSC.controle.DispatchActionBSC;
import br.com.intraBSC.modelo.RecursoTO;
import br.com.intraBSC.negocio.RecursoBO;
import br.com.intraBSC.recurso.visao.RecursoForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RecursoAction extends DispatchActionBSC{
   
   public RecursoAction(){
    
   }
   
   /**
    * Autor Tiago Trindade Stangarlin
    * Data 11/10/2005
    * Metodo de consulta Recurso
    */
   public ActionForward consultarUm(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	   try {			   
		   RecursoBO recursoBO = new RecursoBO();
		   RecursoTO recursoTO = new RecursoTO();
		   RecursoForm recursoForm = (RecursoForm) form;
		   recursoTO.setId(recursoForm.getId());
		   RecursoTO retorno = recursoBO.consultarUm(recursoTO);			   
		   request.setAttribute("alterarRecurso",retorno);			   
		   return mapping.findForward("sucesso");
	   } catch (Exception e) {
		  // setErro("bsc.erro.consultar.mapaEstrategico",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   /**
    * Autor Tiago Trindade Stangarlin
    * Data 11/10/2005
    * Metodo de Incluir Recurso
    */
   public ActionForward incluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	   try {			   
		   RecursoBO recursoBO = new RecursoBO();
		   RecursoTO recursoTO = new RecursoTO();
		   RecursoForm recursoForm = (RecursoForm) form;
		   recursoForm.setRecursoTO(recursoTO);
		   recursoBO.incluir(recursoTO);
		   return mapping.findForward("sucessoIncluir");
	   } catch (Exception e) {
		  // setErro("bsc.erro.consultar.mapaEstrategico",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   /**
    * Autor Tiago Trindade Stangarlin
    * Data 11/10/2005
    * Metodo de Alterar Recurso
    */
   public ActionForward alterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	   try {			   
		   RecursoBO recursoBO = new RecursoBO();
		   RecursoTO recursoTO = new RecursoTO();
		   RecursoForm recursoForm = (RecursoForm) form;
		   recursoForm.setRecursoTO(recursoTO);
		   recursoBO.alterar(recursoTO);
		   return mapping.findForward("sucessoAlterar");
	   } catch (Exception e) {
		  // setErro("bsc.erro.consultar.mapaEstrategico",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   public ActionForward excluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	   try {			   
		   RecursoBO recursoBO = new RecursoBO();
		   RecursoTO recursoTO = new RecursoTO();
 		   RecursoForm recursoForm = (RecursoForm) form;
		   recursoTO.setId(recursoForm.getId());
		   recursoTO.setNome(recursoForm.getNome());
		   recursoBO.excluir(recursoTO);
		   return mapping.findForward("sucessoExcluir");
	   } catch (Exception e) {
		  // setErro("bsc.erro.consultar.mapaEstrategico",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   /**
    * Autor Tiago Trindade Stangarlin
    * Data 11/10/2005
    * Metodo de ConsultarVarios Recurso
    */
   public ActionForward consultarVarios(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	   try {			   
		   RecursoBO recursoBO = new RecursoBO();
		   RecursoTO recursoTO = new RecursoTO();
		   RecursoForm recursoForm = (RecursoForm) form;
		   recursoTO.setNome(recursoForm.getNome());
		   recursoTO.setIdIniciativa(recursoForm.getIdIniciativa());
		   Collection retorno = recursoBO.consultarVarios(recursoTO);			   
		   request.setAttribute("listaRecurso",retorno);			   
		   return mapping.findForward("sucessoConsultar");
	   } catch (Exception e) {
		  // setErro("bsc.erro.consultar.mapaEstrategico",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   public ActionForward encaminhaIncluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	   try {
		   RecursoForm recursoForm = (RecursoForm) form;
		   recursoForm.setIdIniciativa(Integer.parseInt(request.getParameter("codIniciativa")));
		   recursoForm.setNome("");
		   recursoForm.setDescricao("");
		   return mapping.findForward("sucessoIncluir");
	   } catch (Exception e) {
		  // setErro("bsc.erro.consultar.mapaEstrategico",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   public ActionForward encaminhaConsultarVarios(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	   try {
		   RecursoForm recursoForm = (RecursoForm) form;
		   recursoForm.setIdIniciativa(Integer.parseInt(request.getParameter("codIniciativa")));
		   recursoForm.setNome("");
		   return mapping.findForward("sucessoConsultar");
	   } catch (Exception e) {
		  // setErro("bsc.erro.consultar.mapaEstrategico",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   public ActionForward encaminhaAlterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	   try {
		   RecursoForm recursoForm = (RecursoForm) form;
		   recursoForm.setIdIniciativa(Integer.parseInt(request.getParameter("codIniciativa")));
		   recursoForm.setId(Integer.parseInt(request.getParameter("codRecurso")));
		   RecursoBO recursoBO = new RecursoBO();
		   RecursoTO recursoTO = new RecursoTO();
		   recursoForm.setRecursoForm(recursoBO.consultarUm(recursoTO));
		   return mapping.findForward("sucessoAlterar");
	   } catch (Exception e) {
		  // setErro("bsc.erro.consultar.mapaEstrategico",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
}
