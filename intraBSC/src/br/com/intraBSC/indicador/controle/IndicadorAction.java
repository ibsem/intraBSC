package br.com.intraBSC.indicador.controle;


import java.util.Collection;

import br.com.intraBSC.controle.DispatchActionBSC;
import br.com.intraBSC.indicador.visao.IndicadorForm;
import br.com.intraBSC.modelo.IndicadorFatoTO;
import br.com.intraBSC.modelo.IndicadorTO;
import br.com.intraBSC.modelo.MapaEstrategicoTO;
import br.com.intraBSC.modelo.MetaTO;
import br.com.intraBSC.modelo.ObjetivoTO;
import br.com.intraBSC.modelo.PeriodicidadeTO;
import br.com.intraBSC.modelo.UnidadeTO;
import br.com.intraBSC.modelo.UsuarioTO;
import br.com.intraBSC.negocio.IndicadorBO;
import br.com.intraBSC.negocio.IndicadorFatoBO;
import br.com.intraBSC.negocio.MapaEstrategicoBO;
import br.com.intraBSC.negocio.MetaBO;
import br.com.intraBSC.negocio.ObjetivoBO;
import br.com.intraBSC.negocio.PeriodicidadeBO;
import br.com.intraBSC.negocio.UnidadeBO;
import br.com.intraBSC.negocio.UsuarioBO;
import br.com.intraBSC.util.DataUtil;
import br.com.intraBSC.util.ValidaUsuario;
import br.com.intraPRO.modelo.TarefaTO;
import br.com.intraPRO.negocio.TarefaBO;
import br.com.intraPRO.util.Util;

import net.sf.jasperreports.engine.JasperPrint;

import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndicadorAction extends DispatchActionBSC{
   
   public IndicadorAction(){
    
   }
   
   
   public ActionForward consultarVarios(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   try {
		   IndicadorBO indicadorBO = new IndicadorBO();
		   IndicadorTO indicadorTO = new IndicadorTO();		   
		   Integer codMapa = (Integer) request.getSession().getAttribute("codMapaSelecionado");
		   indicadorTO.setIdMapa(codMapa.intValue());
		   request.getSession().setAttribute("listaIndicador",indicadorBO.consultarArvoreVisualizacao(indicadorTO));
		   return mapping.findForward("sucesso");
	   } catch (Exception e) {
		   setErro("bsc.erro.consultar.indicador",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   public ActionForward consultarIndicadorUsuario(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   try {
		   UsuarioTO usuario = UsuarioBO.getUsuarioTO(response,request);
		   IndicadorBO indicadorBO = new IndicadorBO();
		   IndicadorTO indicadorTO = new IndicadorTO();		   
		   indicadorTO.setResponsavelIndicador(usuario.getIdUsuario());
		   request.getSession().setAttribute("codUsuarioSelecionado",new Integer(usuario.getIdUsuario()));
		   request.getSession().setAttribute("listaIndicador",indicadorBO.consultarIndicadorUsuario(indicadorTO));
		   return mapping.findForward("sucesso");
	   } catch (Exception e) {
		   setErro("bsc.erro.consultar.indicador",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   
   /**
    * Autor Tiago Trindade Stangarlin
    * Data 11/10/2005
    * Metodo de consulta para gerar relatorio Objetivo
    */
   public ActionForward indicadorRelatorioDetalha(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   try {
		   String codMapaEstrategico;
		   String codPerspectiva;
		   if (request.getParameter("codMapa") == "0"){
			codMapaEstrategico = (String) request.getSession().getAttribute("codMapa");   
		   }else{
		    codMapaEstrategico = request.getParameter("codMapa");
		   }
		   if (request.getParameter("codPerspectiva") == "0"){
			codPerspectiva = (String) request.getSession().getAttribute("codPerspectiva");   
		   }else{
			codPerspectiva = request.getParameter("codPerspectiva");
		   }  	
		   	String codIndicador = request.getParameter("codIndicador"); 	
		    IndicadorBO indicadorBO = new IndicadorBO();
			IndicadorTO indicadorTO = new IndicadorTO();
			indicadorTO.setCaminhoRel(request.getSession().getServletContext().getRealPath("/relatorios/IndicadorPrincipal.jasper"));
			indicadorTO.setBaseDir(request.getSession().getServletContext().getRealPath(""));
			indicadorTO.setId(Integer.parseInt(codIndicador));
			indicadorTO.setIdPerspectiva(Integer.parseInt(codPerspectiva));
			indicadorTO.setIdMapa(Integer.parseInt(codMapaEstrategico));
			
			/*Valida se usuário pertence ao Mapa ou tarefa */
			boolean UsuarioValidado;
			TarefaTO tarefaTO = new TarefaTO();	
			tarefaTO.setCodigo(-99);
			MapaEstrategicoTO mapaEstrategicoTO = new MapaEstrategicoTO();
			mapaEstrategicoTO.setId(Integer.parseInt(codMapaEstrategico));
			UsuarioValidado = ValidaUsuario.Autoriza(UsuarioBO.getUsuarioTO(response,request) ,mapaEstrategicoTO, tarefaTO );
			if (UsuarioValidado == true){
			request.getSession().removeAttribute("relatorio");
			try{
				JasperPrint jasperRelatorio = indicadorBO.indicadorRelatorioDetalha(indicadorTO);
				request.getSession().setAttribute("relatorio", jasperRelatorio);
			}catch (NullPointerException nul){
				indicadorTO.setCaminhoRel(request.getSession().getServletContext().getRealPath("/relatorios/IndicadorSemValorPrincipal.jasper"));
				JasperPrint jasperRelatorio = indicadorBO.indicadorRelatorioDetalhaSemValor(indicadorTO);
				request.getSession().setAttribute("relatorio", jasperRelatorio);
			}
  			request.getSession().setAttribute("codIndicadorSelecionado",codIndicador);
  			request.getSession().setAttribute("codPerspectiva",codPerspectiva);
  			request.getSession().setAttribute("codMapa",codMapaEstrategico);
  			request.getSession().setAttribute("codMapaSelecionadoRetorno",codMapaEstrategico);
  			return mapping.findForward("sucesso");
			}else{
				setErro("bsc.erro.naoAutorizado", request);
  				return mapping.findForward("erro");
			}
	   } catch (Exception e) {
		   setErro("bsc.erro.consultar.relatorio.indicador",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }

   public ActionForward meusIndicadoresRelatorioDetalha(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   try {		   	
		   	
		   UsuarioTO usuario = UsuarioBO.getUsuarioTO(response,request);
		   IndicadorBO indicadorBO = new IndicadorBO();
		   IndicadorTO indicadorTO = new IndicadorTO();		   
		   indicadorTO.setResponsavelIndicador(usuario.getIdUsuario());
		   request.getSession().setAttribute("codUsuarioSelecionado",new Integer(usuario.getIdUsuario()));
		   request.getSession().setAttribute("listaIndicador",indicadorBO.consultarIndicadorUsuario(indicadorTO));
		   return mapping.findForward("sucesso");
	   } catch (Exception e) {
		   setErro("bsc.erro.consultar.relatorio.indicador",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   /*Metodo que encaminha para inclusao de indicador*/
   public ActionForward encaminharIncluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   try {
		   /*Consultar Objetivo*/
		   Integer codMapa = null;
		   codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
		   if (codMapa==null){		  
		   codMapa = Integer.valueOf(request.getParameter("codMapa"));
			   }
		   ObjetivoBO objetivoBO = new ObjetivoBO();
		   ObjetivoTO objetivoTO = new ObjetivoTO();
		   objetivoTO.setIdMapa(codMapa.intValue());
		   request.setAttribute("ultimaData",new DataUtil().getData());
		   request.setAttribute("listaObjetivo",objetivoBO.consultarVarios(objetivoTO));
		   
		   /*Consultar Responsavel*/
		   UsuarioBO usuarioBO = new UsuarioBO();
		   UsuarioTO usuarioTO = new UsuarioTO();
		   usuarioTO.setGrupoTO(UsuarioBO.getUsuarioTO().getGrupoTO());
		   request.setAttribute("listaResponsavel",usuarioBO.consultarVarios(usuarioTO));
		   /*Consultar Unidade*/
		   UnidadeBO unidadeBO = new UnidadeBO();
		   UnidadeTO unidadeTO = new UnidadeTO();
		   unidadeTO.setNome("");
		   request.setAttribute("listaUnidade",unidadeBO.consultarVarios(unidadeTO));
		   /*Consultar Periodicidade*/
		   PeriodicidadeBO periodicidadeBO = new PeriodicidadeBO();
		   PeriodicidadeTO periodicidadeTO = new PeriodicidadeTO();
		   periodicidadeTO.setNome("");
		   request.setAttribute("listaPeriodicidade",periodicidadeBO.consultarVarios(periodicidadeTO));
		   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
		   
		   return mapping.findForward("sucessoIncluir");
	   } catch (Exception e) {
		   String lista[] = {"Encaminhar Incluir",e.getMessage()};
		   setErro("bsc.erro.indicador",lista,request);
		   return mapping.findForward("erro");
	   }
   }
   
   /*Metodo que encaminha para inclusao de indicador*/
   public ActionForward encaminharAlterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   try {
		   String codIndicador = request.getParameter("codIndicador");
		   if (codIndicador == null){
			   codIndicador = request.getAttribute("codIndicador").toString();
		   }
		   IndicadorForm indicadorForm = (IndicadorForm) form;
		   IndicadorBO indicadorBO = new IndicadorBO();
		   IndicadorTO indicadorTO = new IndicadorTO();
		   indicadorTO.setId(Integer.valueOf(codIndicador).intValue());
		   indicadorForm.setIndicadorForm(indicadorBO.consultarUm(indicadorTO));
		   indicadorTO.setResponsavelIndicador(indicadorForm.getIdResponsavel());
		   
		   //Se usuario nao 'e participante nao pode acessar indicador.
		   if ((indicadorForm.getIdResponsavel() != UsuarioBO.getUsuarioTO().getIdUsuario())&&(!UsuarioBO.getUsuarioTO().getPerfil().equals("administrador"))
				   &&(!UsuarioBO.getUsuarioTO().getPerfil().equals("gerentegeral"))) {
			   setErro("pro.mensagem.autorizacao", "", request);
				return mapping.findForward("erro");
		   }
			
		   
		   Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
	   
		   
		   codMapa = indicadorBO.consultarMapaPorIndicador(indicadorTO);
		   
		   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
		   
		   /*Consultar Objetivo*/
		   ObjetivoBO objetivoBO = new ObjetivoBO();
		   ObjetivoTO objetivoTO = new ObjetivoTO();
		   objetivoTO.setIdMapa(codMapa.intValue());
		   request.setAttribute("listaObjetivo",objetivoBO.consultarVarios(objetivoTO));
		   
		   /*Recupera o id da perspectiva do objetivo que o indicador esta relacionado. Utilizado para vincular tarefa*/
		   objetivoTO.setId(indicadorForm.getIdObjetivo());
		   indicadorForm.setIdPerspectiva(objetivoBO.consultarUm(objetivoTO).getIdPerspectiva());
		   
		   
		   /*Consultar Responsavel*/
		   UsuarioBO usuarioBO = new UsuarioBO();
		   UsuarioTO usuarioTO = new UsuarioTO();
		   usuarioTO.setGrupoTO(UsuarioBO.getUsuarioTO().getGrupoTO());
		   request.setAttribute("listaResponsavel",usuarioBO.consultarVarios(usuarioTO));
		   /*Consultar Unidade*/
		   UnidadeBO unidadeBO = new UnidadeBO();
		   UnidadeTO unidadeTO = new UnidadeTO();
		   unidadeTO.setNome("");
		   request.setAttribute("listaUnidade",unidadeBO.consultarVarios(unidadeTO));
		   /*Consultar Periodicidade*/
		   PeriodicidadeBO periodicidadeBO = new PeriodicidadeBO();
		   PeriodicidadeTO periodicidadeTO = new PeriodicidadeTO();
		   periodicidadeTO.setNome("");
		   request.setAttribute("listaPeriodicidade",periodicidadeBO.consultarVarios(periodicidadeTO));
		   
		   /*Recupera Tarefas do usuario logado*/
		   UsuarioTO usuario = UsuarioBO.getUsuarioTO(response,request);
		   TarefaTO tarefaTO = new TarefaTO();
		   tarefaTO.setCodUsuSolicitante(usuario.getIdUsuario());
		   Util.consultarTarefaMapaConfiguracao(tarefaTO, request, response);
		   
		   /*Recupera Tarefas vinculadas a um determinado indicador*/
		   tarefaTO.setCodIndicador(indicadorTO.getId());
		   request.getSession().setAttribute("listaTarefasIndicador",indicadorBO.consultarTarefaFerramentaConfiguracao(tarefaTO));
		   
		   
		   /*Consultar meta*/
		   MetaBO metaBO = new MetaBO();
		   MetaTO metaTO = new MetaTO();
		   metaTO.setIdIndicador(indicadorTO.getId());
		   metaTO.setAtivo("1");
		   request.setAttribute("listaMetas",metaBO.consultarVarios(metaTO));
		   
		   return mapping.findForward("sucessoAlterar");
	   } catch (Exception e) {
		   String lista[] = {"Encaminhar Alterar",e.getMessage()};
		   setErro("bsc.erro.indicador",lista,request);
		   return mapping.findForward("erro");
	   }
   }
   
   /*Metodo que encaminha para inclusao de indicador*/
   public ActionForward incluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   try {
		   IndicadorForm indicadorForm = (IndicadorForm) form;
		   IndicadorBO indicadorBO = new IndicadorBO();
		   IndicadorTO indicadorTO = new IndicadorTO();
		   indicadorForm.setIndicadorTO(indicadorTO);
		   indicadorBO.incluir(indicadorTO);
		   Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
		   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
		   /* Pesquisa da Arvore completa */
		   
		   MapaEstrategicoBO mapaEstrategicoBO = new MapaEstrategicoBO();			
		   MapaEstrategicoTO mapaEstrategicoTO = new MapaEstrategicoTO();
		   mapaEstrategicoTO.setId(codMapa.intValue());
		   request.getSession().removeAttribute("arvoreConfiguracao");
		   request.getSession().setAttribute("arvoreConfiguracao",mapaEstrategicoBO.consultarArvoreConfiguracao(mapaEstrategicoTO));
		   setMensagem("bsc.mensagem.sucesso",request);
		   
		   /*incluir na entidade de dimensao do indicador*/
		   indicadorTO.setIdDimensao(indicadorTO.getId());
		   indicadorBO.incluirDimensao(indicadorTO);
		   
		   return mapping.findForward("sucesso");
	   } catch (Exception e) {
		   String lista[] = {"incluir",e.getMessage()};
		   setErro("bsc.erro.indicador",lista,request);
		   return mapping.findForward("erro");
	   }
   }
   
   /*Metodo que encaminha para inclusao de indicador*/
   public ActionForward alterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   try {
		   IndicadorForm indicadorForm = (IndicadorForm) form;
		   IndicadorBO indicadorBO = new IndicadorBO();
		   IndicadorTO indicadorTO = new IndicadorTO();
		   indicadorForm.setIndicadorTO(indicadorTO);
		   indicadorTO.setId(indicadorForm.getIdIndicador());
		   indicadorBO.alterar(indicadorTO);
		   
		   Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
		   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
		   /* Pesquisa da Arvore completa */
		   
		   MapaEstrategicoBO mapaEstrategicoBO = new MapaEstrategicoBO();			
		   MapaEstrategicoTO mapaEstrategicoTO = new MapaEstrategicoTO();
		   mapaEstrategicoTO.setId(codMapa.intValue());
		   request.getSession().removeAttribute("arvoreConfiguracao");
		   
		   request.getSession().setAttribute("arvoreConfiguracao",mapaEstrategicoBO.consultarArvoreConfiguracao(mapaEstrategicoTO));
		   setMensagem("bsc.mensagem.sucesso",request);
		   request.setAttribute("codIndicador", indicadorTO.getId());
		   return mapping.findForward("sucessoAlterar");
	   } catch (Exception e) {
		   String lista[] = {"alterar",e.getMessage()};
		   setErro("bsc.erro.indicador",lista,request);
		   return mapping.findForward("erro");
	   }
   }
   
   /*Metodo que Inclui valores para os campos de Data e valor do indicador*/
   public ActionForward incluirIndicadorFato(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   /*Atualiza o relatorio*/
	   String codMapaEstrategico = request.getParameter("codMapa");
	   String codPerspectiva = request.getParameter("codPerspectiva");
	   request.setAttribute("codPerspectiva",codPerspectiva);
	   request.setAttribute("codMapa",codMapaEstrategico);
	   IndicadorFatoTO indicadorFatoTO = new IndicadorFatoTO();
	   IndicadorTO indicadorTO = new IndicadorTO();
	   IndicadorBO indicadorBO = new IndicadorBO();
	   try {
		   String codIndicador = (String)request.getSession().getAttribute("codIndicadorSelecionado");
		   IndicadorForm indicadorForm = (IndicadorForm) form;
		   
		   indicadorFatoTO.setData(new DataUtil().getSQLDate(indicadorForm.getUltimaData()));
		   indicadorFatoTO.setId(Integer.parseInt(codIndicador));
		  
		   IndicadorFatoBO indicadorFatoBO = new IndicadorFatoBO();
		   if (indicadorForm.getUltimoValor() == 0){
			   setErro("errors.valorInvalido","",request);
			   return mapping.findForward("sucesso");
		   }
		   indicadorFatoTO.setValor(indicadorForm.getUltimoValor());
		   indicadorFatoBO.verificaInclusao(indicadorFatoTO);
		   request.getSession().setAttribute("indicadorPrincipal", request.getSession().getAttribute("indicadorPrincipal"));
		   indicadorForm.setUltimaData("");
		   
		   indicadorTO.setCaminhoRel(request.getSession().getServletContext().getRealPath("/relatorios/IndicadorPrincipal.jasper"));
		   indicadorTO.setBaseDir(request.getSession().getServletContext().getRealPath(""));
		   indicadorTO.setId(Integer.parseInt(codIndicador));
		   indicadorTO.setIdPerspectiva(Integer.parseInt(codPerspectiva));
		   indicadorTO.setIdMapa(Integer.parseInt(codMapaEstrategico));
		   JasperPrint jasperRelatorio = indicadorBO.indicadorRelatorioDetalha(indicadorTO);
		   request.getSession().setAttribute("relatorio", jasperRelatorio);
		   
		   return mapping.findForward("sucesso");
	   	}catch (NullPointerException nul){
			indicadorTO.setCaminhoRel(request.getSession().getServletContext().getRealPath("/relatorios/IndicadorSemValorPrincipal.jasper"));
			JasperPrint jasperRelatorio = indicadorBO.indicadorRelatorioDetalhaSemValor(indicadorTO);
			request.getSession().setAttribute("relatorio", jasperRelatorio);
			return mapping.findForward("sucesso");
	   	}
   }
   
   /*Metodo que Inclui valores para os campos de Data e valor do indicador*/
   public ActionForward encaminharListarIndicadorFato(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   try {
		   
		   Integer codMapa = Integer.valueOf(request.getParameter("codMapa")); 
		   
		   if (codMapa==null || codMapa==0){
			   codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
			     }
		   IndicadorTO indicadorTO = new IndicadorTO();
		   IndicadorBO indicadorBO = new IndicadorBO();
		   indicadorTO.setIdMapa(codMapa.intValue());
		   request.getSession().setAttribute("listaIndicador",Util.sortCollection(indicadorBO.consultarArvoreVisualizacao(indicadorTO),"nome"));
		  
		   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
		   return mapping.findForward("sucessoConfiguracao");
	   } catch (Exception e) {
		   setErro("bsc.erro",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   /*Metodo que Inclui valores para os campos de Data e valor do indicador*/
   public ActionForward listarIndicadorFato(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   try {
		   IndicadorForm indicadorForm = (IndicadorForm) form;
		   IndicadorFatoTO indicadorFatoTO = new IndicadorFatoTO();
		   IndicadorFatoBO indicadorFatoBO = new IndicadorFatoBO();
		   indicadorFatoTO.setData(new DataUtil().getSQLDate(indicadorForm.getUltimaData()));
		   indicadorFatoTO.setId(indicadorForm.getIdIndicador());
		   indicadorFatoTO.setNome(indicadorForm.getNome());
		   Collection lista = indicadorFatoBO.consultarVariosIndicador(indicadorFatoTO);
		   if (!lista.isEmpty()){
			   request.setAttribute("listaIndicadorFato",lista);
		   }
		   Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
		   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
		   return mapping.findForward("sucessoConfiguracao");
	   } catch (Exception e) {
		   setErro("bsc.erro.consultar.indicador",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   /*Metodo que Inclui valores para os campos de Data e valor do indicador*/
   public ActionForward alterarIndicadorFato(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   try {
		   IndicadorForm indicadorForm = (IndicadorForm) form;
		   IndicadorFatoTO indicadorFatoTO = new IndicadorFatoTO();
		   IndicadorFatoBO indicadorFatoBO = new IndicadorFatoBO();
		   
		   for (int i = 0; i < indicadorForm.getListaId().length; i++) {
			   indicadorFatoTO.setData(new DataUtil().getSQLDate(indicadorForm.getListaDatas()[i]));
			   indicadorFatoTO.setId(Integer.parseInt(indicadorForm.getListaId()[i]));
			   indicadorFatoTO.setValor(Float.parseFloat(indicadorForm.getListaValores()[i]));
			   indicadorFatoBO.alterar(indicadorFatoTO);
		   }
		   Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
		   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
		   return mapping.findForward("sucessoConfiguracao");
	   } catch (Exception e) {
		   setErro("bsc.erro.consultar.indicador",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   /*Metodo que Inclui valores para os campos de Data e valor do indicador*/
   public ActionForward excluirIndicadorFato(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   try {
		   IndicadorForm indicadorForm = (IndicadorForm) form;
		   IndicadorFatoTO indicadorFatoTO = new IndicadorFatoTO();
		   IndicadorFatoBO indicadorFatoBO = new IndicadorFatoBO();
		   indicadorFatoTO.setData(new DataUtil().getSQLDate(indicadorForm.getUltimaData()));
		   indicadorFatoTO.setId(indicadorForm.getIdIndicador());		   
		   indicadorFatoBO.excluir(indicadorFatoTO);
		   indicadorFatoTO.setData(null);
		   indicadorForm.setUltimaData("");
		   Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
		   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
		   return mapping.findForward("sucessoConfiguracao");
	   } catch (Exception e) {
		   setErro("bsc.erro",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   /*Metodo que Inclui valores para os campos de Data e valor do indicador*/
   public ActionForward incluirIndicadorFatoConfiguracao(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   try {
		   IndicadorForm indicadorForm = (IndicadorForm) form;
		   IndicadorFatoTO indicadorFatoTO = new IndicadorFatoTO();
		   indicadorFatoTO.setData(new DataUtil().getSQLDate(indicadorForm.getUltimaData()));
		   
		   indicadorFatoTO.setId(indicadorForm.getIdIndicador());
		   if (indicadorForm.getUltimoValor() == 0){
			   setErro("errors.valorInvalido","",request);
			   return mapping.findForward("erro");
		   }
		   IndicadorFatoBO indicadorFatoBO = new IndicadorFatoBO();
		   indicadorFatoTO.setValor(indicadorForm.getUltimoValor());
		   indicadorFatoBO.verificaInclusao(indicadorFatoTO);
		   request.getSession().setAttribute("indicadorPrincipal", request.getSession().getAttribute("indicadorPrincipal"));
		   indicadorForm.setUltimaData("");
		   Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
		   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
		   setMensagem("bsc.mensagem.sucesso",request);
		   return mapping.findForward("sucesso");
	   } catch (Exception e) {
		   setErro("bsc.erro",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   /*Metodo exclui tarefa relacionada do indicador*/
   public ActionForward excluirTarefa(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   try {
		   int codTarefa = Integer.parseInt(request.getParameter("codTarefa"));
		   int ano = Integer.parseInt(request.getParameter("ano"));
		   int codInd = Integer.parseInt(request.getParameter("codInd"));
		   TarefaBO tarefaBO = new TarefaBO();
		   TarefaTO tarefaTO = new TarefaTO();
		   tarefaTO.setCodigo(codTarefa);
		   tarefaTO.setAnoCriacao(ano);
		   tarefaBO.excluirTarefaIndicador(tarefaTO);
		   request.setAttribute("codIndicador",new Integer(codInd));
		   return mapping.findForward("sucesso");
	   } catch (Exception e) {
		   String lista[] = {"incluir",e.getMessage()};
		   setErro("bsc.erro.indicador",lista,request);
		   return mapping.findForward("erro");
	   }
   }

   public ActionForward vincularTarefa(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   try {
		   int codTarefa = Integer.parseInt(request.getParameter("codTarefa"));
		   int codInd = Integer.parseInt(request.getParameter("codIndicador"));
		   int codMapa = Integer.parseInt(request.getParameter("codMapa"));
		   int codPerspectiva = Integer.parseInt(request.getParameter("codPerspectiva"));
		   int codObjetivo = Integer.parseInt(request.getParameter("codObjetivo"));
		   TarefaBO tarefaBO = new TarefaBO();
		   TarefaTO tarefaTO = new TarefaTO();
		   tarefaTO.setCodigo(codTarefa);
		   tarefaTO.setAnoCriacao(tarefaBO.consultarUm(tarefaTO).getAnoCriacao());
		   tarefaTO.setCodIndicador(codInd);
		   tarefaTO.setCodMapa(codMapa);
		   tarefaTO.setCodPerspectiva(codPerspectiva);
		   tarefaTO.setCodObjetivo(codObjetivo);
		   tarefaBO.verificaTarefaEstaVinculada(tarefaTO);
		   tarefaBO.alterar(tarefaTO);
		   
		   request.setAttribute("codIndicador",new Integer(codInd));
		   return mapping.findForward("sucesso");
	   } catch (Exception e) {
		   setErro("bsc.erro.consultar.indicador",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
}
