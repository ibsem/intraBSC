package br.com.intraBSC.causaEfeito.controle;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.intraBSC.causaEfeito.visao.CausaEfeitoForm;
import br.com.intraBSC.controle.DispatchActionBSC;
import br.com.intraBSC.modelo.CausaEfeitoTO;
import br.com.intraBSC.modelo.ObjetivoTO;
import br.com.intraBSC.negocio.CausaEfeitoBO;
import br.com.intraBSC.negocio.ObjetivoBO;
import br.com.intraPRO.util.Util;

public class CausaEfeitoAction extends DispatchActionBSC{

		/*
	    * Autor Tiago Trindade Stangarlin
	    * Data 11/10/2005
	    * Metodo de consulta CausaEfeito
	    */
	   public ActionForward consultarVarios(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		   try {			   
			   CausaEfeitoBO causaEfeitoBO = new CausaEfeitoBO();
			   CausaEfeitoTO causaEfeitoTO = new CausaEfeitoTO();
			   CausaEfeitoForm causaEfeitoForm = (CausaEfeitoForm) form;
			   causaEfeitoTO.setCausaId(causaEfeitoForm.getCausaId());
			   Collection retorno = causaEfeitoBO.consultarVarios(causaEfeitoTO);			   
			   request.setAttribute("listaCausaEfeito",retorno);			   
			   return mapping.findForward("sucesso");
		   } catch (Exception e) {
			  // setErro("bsc.erro.consultar.mapaEstrategico",e.getMessage(),request);
			   return mapping.findForward("erro");
		   }
	   }
	   
	   public ActionForward encaminhaInclusao(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		   try {
			   atulizaCausaEfeito(request,form);
			   Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
			   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
			   return mapping.findForward("sucesso");
		   } catch (Exception e) {
			   return mapping.findForward("erro");
		   }
	   }
	   
	   /*Inclusao do quadro de causa*/
	   public ActionForward incluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		   try {	
			   int codObjetivo = Integer.valueOf(request.getParameter("idObjetivo")).intValue();
			   CausaEfeitoBO causaEfeitoBO = new CausaEfeitoBO();
			   CausaEfeitoTO causaEfeitoTO = new CausaEfeitoTO();
			   CausaEfeitoForm causaEfeitoForm = (CausaEfeitoForm) form;
			   
			   if (causaEfeitoForm.getCausaId() == 0){
				   causaEfeitoTO.setCausaId(codObjetivo);
				   causaEfeitoTO.setEfeitoId(causaEfeitoForm.getEfeitoId());
				   causaEfeitoTO.setIntensidade(causaEfeitoForm.getIntensidadeEfeito());
				   causaEfeitoTO.setInteracao(causaEfeitoForm.getInteracaoEfeito());
			   }else if (causaEfeitoForm.getEfeitoId() == 0){
				   causaEfeitoTO.setEfeitoId(codObjetivo);
				   causaEfeitoTO.setCausaId(causaEfeitoForm.getCausaId());
				   causaEfeitoTO.setIntensidade(causaEfeitoForm.getIntensidadeCausa());
				   causaEfeitoTO.setInteracao(causaEfeitoForm.getInteracaoCausa());
			   }
			   causaEfeitoBO.incluir(causaEfeitoTO);
			   atulizaCausaEfeito(request,form);
			   Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
			   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
			   return mapping.findForward("sucesso");
		   } catch (Exception e) {
			  // setErro("bsc.erro.consultar.mapaEstrategico",e.getMessage(),request);
			   return mapping.findForward("erro");
		   }
	   }
	   
	   /*Metodo que atualiza dados da tela de causa e efeito*/
	   private void atulizaCausaEfeito(HttpServletRequest request,ActionForm form) throws Exception{
		   int codObjetivo = Integer.valueOf(request.getParameter("idObjetivo")).intValue();
		   CausaEfeitoForm causaEfeitoForm = (CausaEfeitoForm) form;
		   causaEfeitoForm.setNomeObjetivo(request.getParameter("nomeObjetivo"));
		   causaEfeitoForm.setIdObjetivo(codObjetivo);
		   	
		   
		   CausaEfeitoBO causaEfeitoBO = new CausaEfeitoBO();
		   CausaEfeitoTO causaEfeitoTO = new CausaEfeitoTO();
		   
		   /*Pesquisa Causa*/
		   causaEfeitoTO.setEfeitoId(codObjetivo);
		   request.getSession().setAttribute("listaCausa",causaEfeitoBO.consultarVarios(causaEfeitoTO));
		   
		   /*Pesquisa Efeito*/
		   causaEfeitoTO.setCausaId(codObjetivo);
		   causaEfeitoTO.setEfeitoId(0);
		   request.getSession().setAttribute("listaEfeito",causaEfeitoBO.consultarVarios(causaEfeitoTO));
		   
		   /*Consulta Lista de Objetivos*/
		   Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
		   ObjetivoTO objetivoTO = new ObjetivoTO();
		   ObjetivoBO objetivoBO = new ObjetivoBO();
		   objetivoTO.setIdMapa(codMapa.intValue());
		   request.getSession().setAttribute("listaObjetivoCausaEfeito",objetivoBO.consultarObjetivoMapa(objetivoTO));
	   }
	   
	   /*Inclusao do quadro de causa*/
	   public ActionForward excluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		   try {	
			   int codObjetivo = Integer.valueOf(request.getParameter("idObjetivo")).intValue();
			   CausaEfeitoBO causaEfeitoBO = new CausaEfeitoBO();
			   CausaEfeitoTO causaEfeitoTO = new CausaEfeitoTO();
			   CausaEfeitoForm causaEfeitoForm = (CausaEfeitoForm) form;
			   
			   if (causaEfeitoForm.getCausaId() == 0){
				   causaEfeitoTO.setCausaId(codObjetivo);
				   causaEfeitoTO.setEfeitoId(causaEfeitoForm.getEfeitoId());
			   }else if (causaEfeitoForm.getEfeitoId() == 0){
				   causaEfeitoTO.setEfeitoId(codObjetivo);
				   causaEfeitoTO.setCausaId(causaEfeitoForm.getCausaId());				   
			   }
			   causaEfeitoBO.excluir(causaEfeitoTO);
			   atulizaCausaEfeito(request,form);
			   Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
			   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
			   return mapping.findForward("sucesso");
		   } catch (Exception e) {
			   return mapping.findForward("erro");
		   }
	   }
	   
	   /*Alteracao do quadro de causa*/
	   public ActionForward alterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		   try {	
			   int codObjetivo = Integer.valueOf(request.getParameter("idObjetivo")).intValue();
			   CausaEfeitoBO causaEfeitoBO = new CausaEfeitoBO();
			   CausaEfeitoTO causaEfeitoTO = new CausaEfeitoTO();
			   CausaEfeitoForm causaEfeitoForm = (CausaEfeitoForm) form;
			   
			   if (causaEfeitoForm.getCausaId() == 0){
				   causaEfeitoTO.setCausaId(codObjetivo);
				   causaEfeitoTO.setEfeitoId(causaEfeitoForm.getEfeito());
				   causaEfeitoTO.setIntensidade(causaEfeitoForm.getIntensidadeEfeito());
				   causaEfeitoTO.setInteracao(causaEfeitoForm.getInteracaoEfeito());
			   }else if (causaEfeitoForm.getEfeitoId() == 0){
				   causaEfeitoTO.setEfeitoId(codObjetivo);
				   causaEfeitoTO.setCausaId(causaEfeitoForm.getCausa());
				   causaEfeitoTO.setIntensidade(causaEfeitoForm.getIntensidadeCausa());
				   causaEfeitoTO.setInteracao(causaEfeitoForm.getInteracaoCausa());
			   }
			   causaEfeitoBO.alterar(causaEfeitoTO);
			   atulizaCausaEfeito(request,form);
			   Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
			   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
			   return mapping.findForward("sucesso");
		   } catch (Exception e) {
			   return mapping.findForward("erro");
		   }
	   }

}
