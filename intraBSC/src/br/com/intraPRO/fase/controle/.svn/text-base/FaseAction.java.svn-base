package br.com.intraPRO.fase.controle;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperPrint;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.intraPRO.controle.DispatchActionPRO;
import br.com.intraPRO.modelo.FaseTO;
import br.com.intraBSC.modelo.UsuarioTO;
import br.com.intraPRO.negocio.FaseBO;
import br.com.intraBSC.negocio.UsuarioBO;
import br.com.intraPRO.fase.visao.FaseForm;
import br.com.intraPRO.modelo.TarefaTO;
import br.com.intraPRO.negocio.TarefaBO;
import br.com.intraPRO.util.Util;

public class FaseAction extends DispatchActionPRO{
   
   public FaseAction(){    
   }    
   
   /*Tiago Trindade Stangarlin 
    * Data 20/12/2005
    * Metodo utilizado para pesquisa de fases por mapas estrategicos
    */
   public ActionForward consultarFaseProcesso(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	   try {
		   FaseBO faseBO = new FaseBO();
		   FaseTO faseTO = new FaseTO();
		   Integer codProcesso = (Integer) request.getSession().getAttribute("codProcessoSelecionado");
		   request.getSession().setAttribute("listaFase",faseBO.consultarFaseProcesso(faseTO,codProcesso));
		   return mapping.findForward("sucesso");
	   } catch (Exception e) {
		   setErro("bsc.erro.consultar.fase",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   /*Tiago 
    * Data 23/9/2006
    * Metodo de Incluisao de uma fase para a ferramenta de configuracao*/
   public ActionForward incluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	   try {
		   FaseBO faseBO = new FaseBO();
		   FaseTO faseTO = new FaseTO();
		   FaseForm faseForm = (FaseForm) form;
		   faseForm.setFaseTO(faseTO);
		   Integer codProcesso = (Integer) request.getSession().getAttribute("codProcessoArvoreConfiguracao");
		   faseTO.setIdProcesso(codProcesso.intValue());
		   faseBO.incluir(faseTO);
		   request.getSession().removeAttribute("arvoreConfiguracao");
		   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codProcesso);
		   
		   setMensagem("bsc.mensagem.sucesso",request);
		   return mapping.findForward("sucessoIncluir");
	   } catch (Exception e) {
		   setErro("bsc.erro",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   /* Autor Tiago Trindade Stangarlin
    * Data 11/10/2005
    * Metodo de consulta mapa estrategico
    */
   public ActionForward faseRelatorioDetalha(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   try {		   	
		   	String codProcessoEstrategico = request.getParameter("codProcesso");
		   	String codFase = request.getParameter("codFase");
		   	FaseBO faseBO = new FaseBO();	   			
		   	FaseTO faseTO = new FaseTO();
		   	faseTO.setTransicaoRel(request.getSession().getServletContext().getRealPath("/relatorios/FasePrincipal.jasper"));
		   	faseTO.setBaseDir(request.getSession().getServletContext().getRealPath(""));
		   	faseTO.setId(Integer.parseInt(codFase));
		   	faseTO.setIdProcesso(Integer.parseInt(codProcessoEstrategico));
  			JasperPrint jasperRelatorio = faseBO.faseRelatorioDetalha(faseTO);
  			
  			request.getSession().setAttribute("relatorio", jasperRelatorio);
  			return mapping.findForward("sucesso");
	   } catch (Exception e) {
		   setErro("bsc.erro.consultar.relatorio.fase",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
	   
   }

   /*Tiago Trindade Stangarlin 
    * Data 20/12/2005
    * Metodo utilizado para alterar uma fase na ferramente de configuracao
    */
   public ActionForward alterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	   try {
		   FaseBO faseBO = new FaseBO();
		   FaseTO faseTO = new FaseTO();
		   FaseForm faseForm = (FaseForm) form;
		   faseForm.setFaseTO(faseTO);
		   Integer codProcesso = (Integer) request.getSession().getAttribute("codProcessoArvoreConfiguracao");
		   faseTO.setIdProcesso(codProcesso.intValue());
		   faseBO.alterar(faseTO);
		   
		   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codProcesso);
		   setMensagem("bsc.mensagem.sucesso",request);
		   return mapping.findForward("sucessoAlterar");
	   } catch (Exception e) {
		   setErro("bsc.erro",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   /*Tiago Trindade Stangarlin 
    * Data 20/12/2005
    * Metodo utilizado para encaminhar para a tela de inclusao ou alteracao de fase
    * realizando a pesquisa de tipo de fase e responsavel para completar o combo 
    * da pagina
    */
   public ActionForward encaminhaIncluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	   try {
		   
		   Integer codProcesso = (Integer) request.getSession().getAttribute("codProcessoArvoreConfiguracao");
		   /*Realiza a pesquisa de usuario(Responsavel para completar combo)*/
		   UsuarioBO usuarioBO = new UsuarioBO();
		   UsuarioTO usuarioTO = new UsuarioTO();	
		   usuarioTO.setNome("");
		   usuarioTO.setGrupoTO(UsuarioBO.getUsuarioTO().getGrupoTO());
		   request.setAttribute("listaResponsavel",usuarioBO.consultarVarios(usuarioTO));
		   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codProcesso);
		   return mapping.findForward("sucessoIncluir");
	   } catch (Exception e) {
		   setErro("bsc.erro",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   /*Tiago Trindade Stangarlin 
    * Data 20/12/2005
    * Metodo utilizado para encaminhar para a tela de inclusao ou alteracao de fase
    * realizando a pesquisa de tipo de fase e responsavel para completar o combo 
    * da pagina
    */
   public ActionForward encaminhaAlterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	   try {
		   Integer codFase = Integer.valueOf(request.getParameter("codFase"));
		   FaseBO faseBO = new FaseBO();
		   FaseTO faseTO = new FaseTO();
		   faseTO.setId(codFase.intValue());
		   FaseForm faseForm = (FaseForm) form;
		   faseForm.setFaseForm(faseBO.consultarUm(faseTO));
		   
		   //Se usuario nao 'e participante nao pode acessar a atividade.
		   if ((faseForm.getResponsavel() != UsuarioBO.getUsuarioTO().getIdUsuario())&&(!UsuarioBO.getUsuarioTO().getPerfil().equals("administrador"))) {
			   setErro("pro.mensagem.autorizacao", "", request);
				return mapping.findForward("erro");
		   }
		   
		   Integer codProcesso = (Integer) request.getSession().getAttribute("codProcessoArvoreConfiguracao");
		   /*Realiza a pesquisa de usuario(Responsavel para completar combo)*/
		   UsuarioBO usuarioBO = new UsuarioBO();
		   UsuarioTO usuarioTO = new UsuarioTO();
		   usuarioTO.setNome("");
		   usuarioTO.setGrupoTO(UsuarioBO.getUsuarioTO().getGrupoTO());
		   request.setAttribute("listaResponsavel",usuarioBO.consultarVarios(usuarioTO));
		   codProcesso = faseBO.consultarProcessoPorFase(faseTO);
		   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codProcesso);
		   
		   /*Recupera Tarefas do usuario logado*/
		   UsuarioTO usuario = UsuarioBO.getUsuarioTO(response,request);
		   TarefaTO tarefaTO = new TarefaTO();
		   tarefaTO.setCodUsuSolicitante(usuario.getIdUsuario());
		   Util.consultarTarefaProcessoConfiguracao(tarefaTO, request, response);
		   
		    /*Recupera Tarefas vinculadas a um determinado fase*/
			tarefaTO.setCodFase(faseTO.getId());
			request.getSession().setAttribute("listaTarefasFase",faseBO.consultarTarefaFerramentaConfiguracao(tarefaTO));
		   
		   return mapping.findForward("sucessoAlterar");
	   } catch (Exception e) {
		   setErro("bsc.erro.consultar.fase",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
	public ActionForward vincularTarefa(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		   try {
			   int codTarefa = Integer.parseInt(request.getParameter("codTarefa"));
			   int codFase = Integer.parseInt(request.getParameter("codFase"));
			   int codProcesso = Integer.parseInt(request.getParameter("codProcesso"));
			   TarefaBO tarefaBO = new TarefaBO();
			   TarefaTO tarefaTO = new TarefaTO();
			   tarefaTO.setCodigo(codTarefa);
			   tarefaTO.setAnoCriacao(tarefaBO.consultarUm(tarefaTO).getAnoCriacao());
			   tarefaTO.setCodFase(codFase);
			   tarefaTO.setCodProc(codProcesso);
			   tarefaBO.verificaTarefaEstaVinculada(tarefaTO);
			   tarefaBO.alterar(tarefaTO);
			   
			   request.setAttribute("codFase",new Integer(codFase));
			   return mapping.findForward("sucesso");
		   } catch (Exception e) {
			   setErro("bsc.erro.consultar.indicador",e.getMessage(),request);
			   return mapping.findForward("erro");
		   }
	   }
   
   /*Metodo exclui tarefa relacionada do Fase*/
   public ActionForward excluirTarefa(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   try {
		   int codTarefa = Integer.parseInt(request.getParameter("codTarefa"));
		   int ano = Integer.parseInt(request.getParameter("ano"));
		   int codFase = Integer.parseInt(request.getParameter("codFase"));
		   TarefaBO tarefaBO = new TarefaBO();
		   TarefaTO tarefaTO = new TarefaTO();
		   tarefaTO.setCodigo(codTarefa);
		   tarefaTO.setAnoCriacao(ano);
		   tarefaBO.excluirTarefaFase(tarefaTO);
		   request.setAttribute("codFase",new Integer(codFase));
		   return mapping.findForward("sucesso");
	   } catch (Exception e) {
		   String lista[] = {"incluir",e.getMessage()};
		   setErro("bsc.erro.indicador",lista,request);
		   return mapping.findForward("erro");
	   }
   }
   
   
   	
   
}