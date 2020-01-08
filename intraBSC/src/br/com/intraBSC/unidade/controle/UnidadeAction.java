package br.com.intraBSC.unidade.controle;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.intraBSC.controle.DispatchActionBSC;
import br.com.intraBSC.excecoes.ExceptionNegocioBSC;
import br.com.intraBSC.modelo.UnidadeTO;
import br.com.intraBSC.negocio.UnidadeBO;
import br.com.intraBSC.unidade.visao.UnidadeForm;
import br.com.intraPRO.util.Util;

public class UnidadeAction  extends DispatchActionBSC{
	
   /**
    * Autor Tiago Trindade Stangarlin
    * Data 11/10/2005
    * Metodo de consulta Unidade
    */
   public ActionForward consultarUm(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	   try {			   
		   UnidadeBO unidadeBO = new UnidadeBO();
		   UnidadeTO unidadeTO = new UnidadeTO();
		   UnidadeForm unidadeForm = (UnidadeForm) form;
		   unidadeTO.setId(unidadeForm.getId());
		   UnidadeTO retorno = unidadeBO.consultarUm(unidadeTO);			   
		   request.setAttribute("alterarUnidade",retorno);
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
    * Metodo de Incluir Unidade
    */
   public ActionForward incluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	   try {			   
		   UnidadeBO unidadeBO = new UnidadeBO();
		   UnidadeTO unidadeTO = new UnidadeTO();
		   UnidadeForm unidadeForm = (UnidadeForm) form;
		   unidadeTO.setId(unidadeForm.getId());
		   unidadeTO.setNome(unidadeForm.getNome());
		   unidadeBO.incluir(unidadeTO);
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
    * Metodo de Alterar Unidade
    */
   public ActionForward alterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	   try {			   
		   UnidadeBO unidadeBO = new UnidadeBO();
		   UnidadeTO unidadeTO = new UnidadeTO();
		   UnidadeForm unidadeForm = (UnidadeForm) form;
		   unidadeTO.setId(unidadeForm.getId());
		   unidadeTO.setNome(unidadeForm.getNome());
		   unidadeBO.alterar(unidadeTO);
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
    * Metodo de ConsultarVarios Unidade
    */
   public ActionForward consultarVarios(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	   try {			   
		   UnidadeBO unidadeBO = new UnidadeBO();
		   UnidadeTO unidadeTO = new UnidadeTO();
		   UnidadeForm unidadeForm = (UnidadeForm) form;
		   unidadeTO.setNome(unidadeForm.getNome());
		   Collection retorno = unidadeBO.consultarVarios(unidadeTO);			   
		   request.setAttribute("listaUnidade",retorno);
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
    * Metodo de consulta Unidade
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
