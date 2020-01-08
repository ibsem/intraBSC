package br.com.intraPRO.transicao.controle;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.intraPRO.transicao.visao.TransicaoForm;
import br.com.intraPRO.controle.DispatchActionPRO;
import br.com.intraPRO.modelo.TransicaoTO;
import br.com.intraPRO.modelo.AtividadeTO;
import br.com.intraPRO.negocio.TransicaoBO;
import br.com.intraPRO.negocio.AtividadeBO;
import br.com.intraPRO.util.Util;

public class TransicaoAction extends DispatchActionPRO{

		/*
	    * Autor Tiago Trindade Stangarlin
	    * Data 11/10/2005
	    * Metodo de consulta Transicao
	    */
	   public ActionForward consultarVarios(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		   try {			   
			   TransicaoBO transicaoBO = new TransicaoBO();
			   TransicaoTO transicaoTO = new TransicaoTO();
			   TransicaoForm transicaoForm = (TransicaoForm) form;
			   transicaoTO.setPreCondicaoId(transicaoForm.getPreCondicaoId());
			   Collection retorno = transicaoBO.consultarVarios(transicaoTO);			   
			   request.setAttribute("listaTransicao",retorno);			   
			   return mapping.findForward("sucesso");
		   } catch (Exception e) {
			  // setErro("bsc.erro.consultar.mapaEstrategico",e.getMessage(),request);
			   return mapping.findForward("erro");
		   }
	   }
	   
	   public ActionForward encaminhaInclusao(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		   try {
			   atualizaTransicao(request,form);
			   Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
			   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
			   return mapping.findForward("sucesso");
		   } catch (Exception e) {
			   return mapping.findForward("erro");
		   }
	   }
	   
	   /*Inclusao do quadro de preCondicao*/
	   public ActionForward incluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		   try {	
			   int codAtividade = Integer.valueOf(request.getParameter("idAtividade")).intValue();
			   TransicaoBO transicaoBO = new TransicaoBO();
			   TransicaoTO transicaoTO = new TransicaoTO();
			   TransicaoForm transicaoForm = (TransicaoForm) form;
			   
			   if (transicaoForm.getPreCondicaoId() == 0){
				   transicaoTO.setPreCondicaoId(codAtividade);
				   transicaoTO.setPosCondicaoId(transicaoForm.getPosCondicaoId());
				   transicaoTO.setIntensidade(transicaoForm.getIntensidadePosCondicao());
				   transicaoTO.setInteracao(transicaoForm.getInteracaoPosCondicao());
			   }else if (transicaoForm.getPosCondicaoId() == 0){
				   transicaoTO.setPosCondicaoId(codAtividade);
				   transicaoTO.setPreCondicaoId(transicaoForm.getPreCondicaoId());
				   transicaoTO.setIntensidade(transicaoForm.getIntensidadePreCondicao());
				   transicaoTO.setInteracao(transicaoForm.getInteracaoPreCondicao());
			   }
			   transicaoBO.incluir(transicaoTO);
			   atualizaTransicao(request,form);
			   Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
			   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
			   return mapping.findForward("sucesso");
		   } catch (Exception e) {
			  // setErro("bsc.erro.consultar.mapaEstrategico",e.getMessage(),request);
			   return mapping.findForward("erro");
		   }
	   }
	   
	   /*Metodo que atualiza dados da tela de preCondicao e efeito*/
	   private void atualizaTransicao(HttpServletRequest request,ActionForm form) throws Exception{
		   int codAtividade = Integer.valueOf(request.getParameter("idAtividade")).intValue();
		   TransicaoForm transicaoForm = (TransicaoForm) form;
		   transicaoForm.setNomeAtividade(request.getParameter("nomeAtividade"));
		   transicaoForm.setIdAtividade(codAtividade);
		   	
		   
		   TransicaoBO transicaoBO = new TransicaoBO();
		   TransicaoTO transicaoTO = new TransicaoTO();
		   
		   /*Pesquisa PreCondicao*/
		   transicaoTO.setPosCondicaoId(codAtividade);
		   request.getSession().setAttribute("listaPreCondicao",transicaoBO.consultarVarios(transicaoTO));
		   
		   /*Pesquisa PosCondicao*/
		   transicaoTO.setPreCondicaoId(codAtividade);
		   transicaoTO.setPosCondicaoId(0);
		   request.getSession().setAttribute("listaPosCondicao",transicaoBO.consultarVarios(transicaoTO));
		   
		   /*Consulta Lista de Atividades*/
		   Integer codProcesso = (Integer) request.getSession().getAttribute("codProcessoArvoreConfiguracao");
		   AtividadeTO objetivoTO = new AtividadeTO();
		   AtividadeBO objetivoBO = new AtividadeBO();
		   objetivoTO.setIdProcesso(codProcesso.intValue());
		   request.getSession().setAttribute("listaAtividadeTransicao",objetivoBO.consultarAtividadeProcesso(objetivoTO));
	   }
	   
	   /*Inclusao do quadro de preCondicao*/
	   public ActionForward excluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		   try {	
			   int codAtividade = Integer.valueOf(request.getParameter("idAtividade")).intValue();
			   TransicaoBO transicaoBO = new TransicaoBO();
			   TransicaoTO transicaoTO = new TransicaoTO();
			   TransicaoForm transicaoForm = (TransicaoForm) form;
			   
			   if (transicaoForm.getPreCondicaoId() == 0){
				   transicaoTO.setPreCondicaoId(codAtividade);
				   transicaoTO.setPosCondicaoId(transicaoForm.getPosCondicaoId());
			   }else if (transicaoForm.getPosCondicaoId() == 0){
				   transicaoTO.setPosCondicaoId(codAtividade);
				   transicaoTO.setPreCondicaoId(transicaoForm.getPreCondicaoId());				   
			   }
			   transicaoBO.excluir(transicaoTO);
			   atualizaTransicao(request,form);
			   Integer codProcesso = (Integer) request.getSession().getAttribute("codProcessoArvoreConfiguracao");
			   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codProcesso);
			   return mapping.findForward("sucesso");
		   } catch (Exception e) {
			   return mapping.findForward("erro");
		   }
	   }
	   
	   /*Alteracao do quadro de preCondicao*/
	   public ActionForward alterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		   try {	
			   int codAtividade = Integer.valueOf(request.getParameter("idAtividade")).intValue();
			   TransicaoBO transicaoBO = new TransicaoBO();
			   TransicaoTO transicaoTO = new TransicaoTO();
			   TransicaoForm transicaoForm = (TransicaoForm) form;
			   
			   if (transicaoForm.getPreCondicaoId() == 0){
				   transicaoTO.setPreCondicaoId(codAtividade);
				   transicaoTO.setPosCondicaoId(transicaoForm.getPosCondicao());
				   transicaoTO.setIntensidade(transicaoForm.getIntensidadePosCondicao());
				   transicaoTO.setInteracao(transicaoForm.getInteracaoPosCondicao());
			   }else if (transicaoForm.getPosCondicaoId() == 0){
				   transicaoTO.setPosCondicaoId(codAtividade);
				   transicaoTO.setPreCondicaoId(transicaoForm.getPreCondicao());
				   transicaoTO.setIntensidade(transicaoForm.getIntensidadePreCondicao());
				   transicaoTO.setInteracao(transicaoForm.getInteracaoPreCondicao());
			   }
			   transicaoBO.alterar(transicaoTO);
			   atualizaTransicao(request,form);
			   Integer codProcesso = (Integer) request.getSession().getAttribute("codProcessoArvoreConfiguracao");
			   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codProcesso);
			   return mapping.findForward("sucesso");
		   } catch (Exception e) {
			   return mapping.findForward("erro");
		   }
	   }

}
