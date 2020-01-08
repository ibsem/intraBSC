package br.com.intraBSC.tipoPerspectiva.controle;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.intraBSC.controle.DispatchActionBSC;
import br.com.intraBSC.excecoes.ExceptionNegocioBSC;
import br.com.intraBSC.modelo.TipoPerspectivaTO;
import br.com.intraBSC.negocio.TipoPerspectivaBO;
import br.com.intraBSC.tipoPerspectiva.visao.TipoPerspectivaForm;
import br.com.intraPRO.util.Util;

public class TipoPerspectivaAction extends DispatchActionBSC{
	
	  /**
	    * Autor Tiago Trindade Stangarlin
	    * Data 11/10/2005
	    * Metodo de consulta TipoPerspectiva
	    */
	   public ActionForward consultarUm(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		   try {			   
			   TipoPerspectivaBO tipoPerspetivaBO = new TipoPerspectivaBO();
			   TipoPerspectivaTO tipoPerspetivaTO = new TipoPerspectivaTO();
			   TipoPerspectivaForm tipoPerspetivaForm = (TipoPerspectivaForm) form;
			   tipoPerspetivaTO.setId(tipoPerspetivaForm.getId());
			   TipoPerspectivaTO retorno = tipoPerspetivaBO.consultarUm(tipoPerspetivaTO);			   
			   request.setAttribute("alterarTipoPerspectiva",retorno);
			   consultarArvore(request);
			   return mapping.findForward("sucessoConsultarUm");
		   } catch (Exception e) {
			   setErro("bsc.erro",e.getMessage(),request);
			   return mapping.findForward("erro");
		   }
	   }
	   
	   /**
	    * Autor Tiago Trindade Stangarlin
	    * Data 11/10/2005
	    * Metodo de Incluir TipoPerspectiva
	    */
	   public ActionForward incluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		   try {			   
			   TipoPerspectivaBO tipoPerspetivaBO = new TipoPerspectivaBO();
			   TipoPerspectivaTO tipoPerspetivaTO = new TipoPerspectivaTO();
			   TipoPerspectivaForm tipoPerspetivaForm = (TipoPerspectivaForm) form;
			   tipoPerspetivaTO.setId(tipoPerspetivaForm.getId());
			   tipoPerspetivaTO.setNome(tipoPerspetivaForm.getNome());
			   tipoPerspetivaTO.setDescricao(tipoPerspetivaForm.getDescricao());
			   tipoPerspetivaBO.incluir(tipoPerspetivaTO);
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
	    * Metodo de Alterar TipoPerspectiva
	    */
	   public ActionForward alterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		   try {			   
			   TipoPerspectivaBO tipoPerspetivaBO = new TipoPerspectivaBO();
			   TipoPerspectivaTO tipoPerspetivaTO = new TipoPerspectivaTO();
			   TipoPerspectivaForm tipoPerspetivaForm = (TipoPerspectivaForm) form;
			   tipoPerspetivaTO.setId(tipoPerspetivaForm.getId());
			   tipoPerspetivaTO.setNome(tipoPerspetivaForm.getNome());
			   tipoPerspetivaTO.setDescricao(tipoPerspetivaForm.getDescricao());
			   tipoPerspetivaBO.alterar(tipoPerspetivaTO);
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
	    * Metodo de ConsultarVarios TipoPerspectiva
	    */
	   public ActionForward consultarVarios(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		   try {			   
			   TipoPerspectivaBO tipoPerspetivaBO = new TipoPerspectivaBO();
			   TipoPerspectivaTO tipoPerspetivaTO = new TipoPerspectivaTO();
			   TipoPerspectivaForm tipoPerspetivaForm = (TipoPerspectivaForm) form;
			   tipoPerspetivaTO.setNome(tipoPerspetivaForm.getNome());
			   tipoPerspetivaTO.setDescricao(tipoPerspetivaForm.getDescricao());
			   Collection retorno = tipoPerspetivaBO.consultarVarios(tipoPerspetivaTO);			   
			   request.setAttribute("listaTipoPerspectiva",retorno);
			   consultarArvore(request);
			   return mapping.findForward("sucessoConsultarVarios");
		   } catch (Exception e) {
			   setErro("bsc.erro",e.getMessage(),request);
			   return mapping.findForward("erro");
		   }
	   }
	   
	   /**
	    * Autor Tiago Trindade Stangarlin
	    * Data 11/10/2005
	    * Metodo de ConsultarVarios TipoPerspectiva
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
