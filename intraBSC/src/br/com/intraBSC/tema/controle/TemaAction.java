package br.com.intraBSC.tema.controle;

import java.util.Collection;

import br.com.intraBSC.controle.DispatchActionBSC;
import br.com.intraBSC.modelo.TemaTO;
import br.com.intraBSC.modelo.UsuarioTO;
import br.com.intraBSC.negocio.TemaBO;
import br.com.intraBSC.negocio.UsuarioBO;
import br.com.intraBSC.tema.visao.TemaForm;
import br.com.intraPRO.util.Util;

import net.sf.jasperreports.engine.JasperPrint;

import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TemaAction extends DispatchActionBSC{
   
   public TemaAction() 
   {
    
   }
   
   public ActionForward consultarVarios(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {	  	  
	   try {
		   TemaBO temaBO = new TemaBO();
		   TemaTO temaTO = new TemaTO();
		   TemaForm temaForm = (TemaForm) form;
		   temaTO.setNomeTema(temaForm.getNomeTema());
		   temaTO.setUsuario(UsuarioBO.getUsuarioTO());
		   Collection lista = temaBO.consultarVarios(temaTO);
		   if (lista.isEmpty()){
			   setMensagem("bsc.lista.vazia.tema",request);
		   }
		   request.setAttribute("listaTemas",lista);
		   Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
		   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
		   return mapping.findForward("sucesso");
	   } catch (Exception e) {
		   
		   return mapping.findForward("erro");
	   }	   
   }
   
   public ActionForward incluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {	  	  
	   try {
		   TemaBO temaBO = new TemaBO();
		   TemaTO temaTO = new TemaTO();
		   TemaForm temaForm = (TemaForm) form;
		   temaForm.setTemaTO(temaTO);
		   temaBO.incluir(temaTO);
		   Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
		   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
		   setMensagem("bsc.mensagem.sucesso",request);
		   return mapping.findForward("sucessoIncluir");
	   } catch (Exception e) {
		   setErro("bsc.erro",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }	   
   }
   
   public ActionForward alterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {	  	  
	   try {
		   TemaBO temaBO = new TemaBO();
		   TemaTO temaTO = new TemaTO();
		   TemaForm temaForm = (TemaForm) form;
		   temaForm.setTemaTO(temaTO);
		   temaBO.alterar(temaTO);
		   Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
		   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
		   setMensagem("bsc.mensagem.sucesso",request);
		   return mapping.findForward("sucessoAlterar");
	   } catch (Exception e) {
		   setErro("bsc.erro",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }	   
   }
   
   public ActionForward consultarUm(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {	  	  
	   try {
		   int codigo = Integer.parseInt(request.getParameter("codigo"));
		   TemaBO temaBO = new TemaBO();
		   TemaTO temaTO = new TemaTO();
		   temaTO.setIdTema(codigo);
		   TemaForm temaForm = (TemaForm) form;
		   temaForm.setTemaForm(temaBO.consultarUm(temaTO));
		   
		   /*Realiza a pesquisa de usuario(Responsavel para completar combo)*/
		   UsuarioBO usuarioBO = new UsuarioBO();
		   UsuarioTO usuarioTO = new UsuarioTO();
		   usuarioTO.setGrupoTO(UsuarioBO.getUsuarioTO().getGrupoTO());
		   request.setAttribute("listaResponsavel",usuarioBO.consultarVarios(usuarioTO));
		   Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
		   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
		   return mapping.findForward("sucessoAlterar");
	   } catch (Exception e) {
		   setErro("bsc.erro.consultar.tema",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }	   
   }
   
   
   public ActionForward encaminharIncluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {	  	  
	   try {
		   /*Realiza a pesquisa de usuario(Responsavel para completar combo)*/
		   UsuarioBO usuarioBO = new UsuarioBO();
		   UsuarioTO usuarioTO = new UsuarioTO();
		   usuarioTO.setGrupoTO(UsuarioBO.getUsuarioTO().getGrupoTO());
		   request.setAttribute("listaResponsavel",usuarioBO.consultarVarios(usuarioTO));
		   Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
		   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
		   return mapping.findForward("sucessoIncluir");
	   } catch (Exception e) {
		   setErro("bsc.erro",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }	   
   }
   
   public ActionForward encaminharAlterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {	  	  
	   try {
		   /*Realiza a pesquisa de usuario(Responsavel para completar combo)*/
		   UsuarioBO usuarioBO = new UsuarioBO();
		   UsuarioTO usuarioTO = new UsuarioTO();
		   usuarioTO.setGrupoTO(UsuarioBO.getUsuarioTO().getGrupoTO());
		   request.setAttribute("listaResponsavel",usuarioBO.consultarVarios(usuarioTO));
		   Integer codTema  = Integer.valueOf(request.getParameter("codTema"));
		   TemaBO temaBO = new TemaBO();
		   TemaTO temaTO = new TemaTO();
		   temaTO.setIdTema(codTema.intValue());
		   request.setAttribute("temaForm",temaBO.consultarUm(temaTO));
		   Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
		   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
		   return mapping.findForward("sucessoAlterar");
	   } catch (Exception e) {
		   setErro("bsc.erro",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }	   
   }
   
   public ActionForward temaRelatorioDetalha(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   try {		   	
		   	String codMapaEstrategico = request.getParameter("codMapa");
		   	String codTema = request.getParameter("codTema");
		   	TemaBO temaBO = new TemaBO();	   			
		   	TemaTO temaTO = new TemaTO();
		   	temaTO.setCaminhoRel(request.getSession().getServletContext().getRealPath("/relatorios/TemaPrincipal.jasper"));
		   	temaTO.setBaseDir(request.getSession().getServletContext().getRealPath(""));
		   	temaTO.setIdTema(Integer.parseInt(codTema));
		   	temaTO.setIdMapa(Integer.parseInt(codMapaEstrategico));
  			JasperPrint jasperRelatorio = temaBO.temaRelatorioDetalha(temaTO);
  			
  			request.getSession().setAttribute("relatorio", jasperRelatorio);
  			return mapping.findForward("sucesso");
	   } catch (Exception e) {
		   setErro("bsc.erro.consultar.relatorio.tema",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
	   
   }
   
   public ActionForward encaminharConsultar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {	  	  
	   try {
		   Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
		   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
		   return mapping.findForward("sucesso");
	   } catch (Exception e) {
		   setErro("bsc.erro",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }	   
   }

   
}
