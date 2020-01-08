package br.com.intraBSC.papel.controle;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.intraBSC.controle.DispatchActionBSC;
import br.com.intraBSC.excecoes.ExceptionNegocioBSC;
import br.com.intraBSC.modelo.PapelTO;
import br.com.intraBSC.negocio.PapelBO;
import br.com.intraBSC.papel.visao.PapelForm;
import br.com.intraPRO.util.Util;

public class PapelAction  extends DispatchActionBSC{
	
   /**
    * Autor Tiago Trindade Stangarlin
    * Data 11/10/2005
    * Metodo de consulta Papel
    */
   public ActionForward consultarUm(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	   try {			   
		   PapelBO papelBO = new PapelBO();
		   PapelTO papelTO = new PapelTO();
		   PapelForm papelForm = (PapelForm) form;
		   papelTO.setId(papelForm.getId());
		   PapelTO retorno = papelBO.consultarUm(papelTO);			   
		   request.setAttribute("alterarPapel",retorno);
		   consultarArvore(request);
		   return mapping.findForward("sucesso");
	   } catch (Exception e) {
		   setErro("bsc.erro",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   /**
    * Autor Tiago Trindade Stangarlin
    * Data 11/10/2005
    * Metodo de Incluir Papel
    */
   public ActionForward incluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	   try {			   
		   PapelBO papelBO = new PapelBO();
		   PapelTO papelTO = new PapelTO();
		   PapelForm papelForm = (PapelForm) form;
		   papelTO.setId(papelForm.getId());
		   papelTO.setNome(papelForm.getNome());
		   papelBO.incluir(papelTO);
		   consultarArvore(request);
		   setMensagem("bsc.mensagem.sucesso",request);
		   return mapping.findForward("sucessoFinaliza");
	   } catch (Exception e) {
		   setErro("bsc.erro",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   /**
    * Autor Tiago Trindade Stangarlin
    * Data 11/10/2005
    * Metodo de Alterar Papel
    */
   public ActionForward alterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	   try {			   
		   PapelBO papelBO = new PapelBO();
		   PapelTO papelTO = new PapelTO();
		   PapelForm papelForm = (PapelForm) form;
		   papelTO.setId(papelForm.getId());
		   papelTO.setNome(papelForm.getNome());
		   papelBO.alterar(papelTO);
		   consultarArvore(request);
		   setMensagem("bsc.mensagem.sucesso",request);
		   return mapping.findForward("sucessoFinaliza");
	   } catch (Exception e) {
		   setErro("bsc.erro",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   /**
    * Autor Tiago Trindade Stangarlin
    * Data 11/10/2005
    * Metodo de ConsultarVarios Papel
    */
   public ActionForward consultarVarios(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	   try {			   
		   PapelBO papelBO = new PapelBO();
		   PapelTO papelTO = new PapelTO();
		   PapelForm papelForm = (PapelForm) form;
		   papelTO.setNome(papelForm.getNome());
		   Collection retorno = papelBO.consultarVarios(papelTO);			   
		   request.setAttribute("listaPapel",retorno);
		   consultarArvore(request);
		   return mapping.findForward("sucessoConsultar");
	   } catch (Exception e) {
		   setErro("bsc.erro",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }

   
   /**
    * Autor Tiago Trindade Stangarlin
    * Data 11/10/2005
    * Metodo de consulta Papel
    */
   public ActionForward encaminharIncluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	   try {			   
		   consultarArvore(request);
		   return mapping.findForward("sucesso");
	   } catch (Exception e) {
		   setErro("bsc.erro",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   /**
    * Metodo de atualizar arvore de configuracao
    * @param request
    * @throws ExceptionNegocioBSC
    */
   private void consultarArvore(HttpServletRequest request) throws ExceptionNegocioBSC{
	   Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
	   if (codMapa != null) {
		   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
	   }
   }
   
}
