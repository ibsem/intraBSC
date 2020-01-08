package br.com.intraBSC.periodicidade.controle;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.intraBSC.controle.DispatchActionBSC;
import br.com.intraBSC.excecoes.ExceptionNegocioBSC;
import br.com.intraBSC.modelo.PeriodicidadeTO;
import br.com.intraBSC.negocio.PeriodicidadeBO;
import br.com.intraBSC.periodicidade.visao.PeriodicidadeForm;
import br.com.intraPRO.util.Util;

public class PeriodicidadeAction  extends DispatchActionBSC{
	
	  /**
	    * Autor Tiago Trindade Stangarlin
	    * Data 11/10/2005
	    * Metodo de consulta Periodicidade
	    */
	   public ActionForward consultarUm(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		   try {			   
			   PeriodicidadeBO periodicidadeBO = new PeriodicidadeBO();
			   PeriodicidadeTO periodicidadeTO = new PeriodicidadeTO();
			   PeriodicidadeForm periodicidadeForm = (PeriodicidadeForm) form;
			   periodicidadeTO.setId(periodicidadeForm.getId());
			   PeriodicidadeTO retorno = periodicidadeBO.consultarUm(periodicidadeTO);			   
			   request.setAttribute("alterarPeriodicidade",retorno);
			   consultarArvore(request);
			   return mapping.findForward("sucessoEncaminhaAlterar");
		   } catch (Exception e) {
			   setErro("bsc.erro",e.getMessage(),request);
			   return mapping.findForward("erro");
		   }
	   }
	   
	   /**
	    * Autor Tiago Trindade Stangarlin
	    * Data 11/10/2005
	    * Metodo de Incluir Periodicidade
	    */
	   public ActionForward incluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		   try {			   
			   PeriodicidadeBO periodicidadeBO = new PeriodicidadeBO();
			   PeriodicidadeTO periodicidadeTO = new PeriodicidadeTO();
			   PeriodicidadeForm periodicidadeForm = (PeriodicidadeForm) form;
			   periodicidadeTO.setId(periodicidadeForm.getId());
			   periodicidadeTO.setNome(periodicidadeForm.getNome());
			   periodicidadeBO.incluir(periodicidadeTO);
			   setMensagem("bsc.mensagem.sucesso",request);
			   consultarArvore(request);
			   return mapping.findForward("sucessoFinaliza");
		   } catch (Exception e) {
			   setErro("bsc.erro",e.getMessage(),request);
			   return mapping.findForward("erro");
		   }
	   }
	   
	   /**
	    * Autor Tiago Trindade Stangarlin
	    * Data 11/10/2005
	    * Metodo de Alterar Periodicidade
	    */
	   public ActionForward alterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		   try {			   
			   PeriodicidadeBO periodicidadeBO = new PeriodicidadeBO();
			   PeriodicidadeTO periodicidadeTO = new PeriodicidadeTO();
			   PeriodicidadeForm periodicidadeForm = (PeriodicidadeForm) form;
			   periodicidadeTO.setId(periodicidadeForm.getId());
			   periodicidadeTO.setNome(periodicidadeForm.getNome());
			   periodicidadeBO.alterar(periodicidadeTO);
			   setMensagem("bsc.mensagem.sucesso",request);
			   consultarArvore(request);
			   return mapping.findForward("sucessoFinaliza");
		   } catch (Exception e) {
			   setErro("bsc.erro",e.getMessage(),request);
			   return mapping.findForward("erro");
		   }
	   }
	   
	   /**
	    * Autor Tiago Trindade Stangarlin
	    * Data 11/10/2005
	    * Metodo de ConsultarVarios Periodicidade
	    */
	   public ActionForward consultarVarios(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		   try {			   
			   PeriodicidadeBO periodicidadeBO = new PeriodicidadeBO();
			   PeriodicidadeTO periodicidadeTO = new PeriodicidadeTO();
			   PeriodicidadeForm periodicidadeForm = (PeriodicidadeForm) form;
			   periodicidadeTO.setId(periodicidadeForm.getId());
			   periodicidadeTO.setNome(periodicidadeForm.getNome());
			   Collection retorno = periodicidadeBO.consultarVarios(periodicidadeTO);			   
			   request.setAttribute("listaPeriodicidade",retorno);
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
	    * Metodo encaminha para tela de incluir
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
