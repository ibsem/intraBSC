package br.com.intraPRO.atividade.controle;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperPrint;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.intraBSC.modelo.UsuarioTO;
import br.com.intraBSC.negocio.UsuarioBO;
import br.com.intraPRO.atividade.visao.AtividadeForm;
import br.com.intraPRO.controle.DispatchActionPRO;
import br.com.intraPRO.modelo.AtividadeTO;
import br.com.intraPRO.modelo.FaseTO;
import br.com.intraPRO.modelo.TarefaTO;
import br.com.intraPRO.negocio.AtividadeBO;
import br.com.intraPRO.negocio.FaseBO;
import br.com.intraPRO.negocio.TarefaBO;
import br.com.intraPRO.util.Util;

public class AtividadeAction extends DispatchActionPRO{
   
	
	
   public AtividadeAction(){    
   }
    
   /*Tiago Trindade Stangarlin 
    * Data 20/12/2005
    * Metodo utilizado para pesquisa de perspectivas por mapas estrategicos
    */
   public ActionForward consultarAtividadesFases(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	   try {
		   AtividadeBO atividadeBO = new AtividadeBO();
		   AtividadeTO atividadeTO = new AtividadeTO();		   
		   Integer codProcesso = (Integer) request.getSession().getAttribute("codProcessoSelecionado");
		   request.getSession().setAttribute("listaAtividade",atividadeBO.consultarAtividadesVarios(atividadeTO,codProcesso));
		   return mapping.findForward("sucesso");
	   } catch (Exception e) {
		   setErro("bsc.erro.consultar.atividade",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }

   /*
    * Autor Tiago Trindade Stangarlin
    * Data 11/10/2005
    * Metodo de consulta para gerar relatorio Atividade
    */
   public ActionForward atividadeRelatorioDetalha(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   try {		   	
		   	String codProcessoEstrategico = request.getParameter("codProcesso");
		   	String codAtividade = request.getParameter("codAtividade");
		   	AtividadeBO atividadeBO = new AtividadeBO();	   			
		   	AtividadeTO atividadeTO = new AtividadeTO();
		   	atividadeTO.setTransicaoRel(request.getSession().getServletContext().getRealPath("/relatorios/AtividadePrincipal.jasper"));
		   	atividadeTO.setBaseDir(request.getSession().getServletContext().getRealPath(""));
		   	atividadeTO.setId(Integer.parseInt(codAtividade));
		   	atividadeTO.setIdProcesso(Integer.parseInt(codProcessoEstrategico));
  			JasperPrint jasperRelatorio = atividadeBO.atividadeRelatorioDetalha(atividadeTO);
  			request.getSession().setAttribute("relatorio", jasperRelatorio);
  			return mapping.findForward("sucesso");
	   } catch (Exception e) {
		   setErro("bsc.erro.consultar.relatorio.atividade",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
	   
   }
   
   /*Tiago Trindade Stangarlin 
    * Data 20/12/2005
    * Metodo utilizado para encaminhar inclusao Atividade
    */
   public ActionForward encaminharIncluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	   try {
		   /*Realiza a pesquisa de usuario(Responsavel para completar combo)*/
		   UsuarioBO usuarioBO = new UsuarioBO();
		   UsuarioTO usuarioTO = new UsuarioTO();
		   usuarioTO.setGrupoTO(UsuarioBO.getUsuarioTO().getGrupoTO());
		   request.setAttribute("listaResponsavel",usuarioBO.consultarVarios(usuarioTO));
		   
		   /*Consulta perspectiva*/
		   FaseBO perspectivaBO = new FaseBO();
		   FaseTO perspectivaTO = new FaseTO();
		   Integer codProcesso = (Integer) request.getSession().getAttribute("codProcessoArvoreConfiguracao");
		   perspectivaTO.setIdProcesso(codProcesso.intValue());
		   request.setAttribute("listaFase",perspectivaBO.consultarVarios(perspectivaTO));
		   		   
		   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codProcesso);
		   return mapping.findForward("sucessoIncluir");
	   } catch (Exception e) {
		   setErro("bsc.erro.consultar.atividade",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   /*Tiago Trindade Stangarlin 
    * Data 20/12/2005
    * Metodo utilizado para incluir Atividade
    */
   public ActionForward incluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	   try {
		   AtividadeBO atividadeBO = new AtividadeBO();
		   AtividadeTO atividadeTO = new AtividadeTO();
		   AtividadeForm atividadeForm = (AtividadeForm) form; 
		   atividadeForm.setAtividadeTO(atividadeTO);
		   atividadeBO.incluir(atividadeTO);
		   Integer codProcesso = (Integer) request.getSession().getAttribute("codProcessoArvoreConfiguracao");
		   request.getSession().removeAttribute("arvoreConfiguracao");
		   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codProcesso);
		   setMensagem("bsc.mensagem.sucesso",request);
		   return mapping.findForward("sucessoIncluir");
	   } catch (Exception e) {
		   setErro("bsc.erro",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   /*Tiago Trindade Stangarlin 
    * Data 20/12/2005
    * Metodo utilizado para Encaminhar Alteracao Atividade
    */
   public ActionForward encaminharAlterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	   try {
		   
		   AtividadeBO atividadeBO = new AtividadeBO();
		   AtividadeTO atividadeTO = new AtividadeTO();
		   AtividadeForm atividadeForm = (AtividadeForm) form;
		   Integer codAtividade = Integer.valueOf(request.getParameter("codAtividade"));
		   atividadeTO.setId(codAtividade.intValue());
		   atividadeForm.setAtividadeForm(atividadeBO.consultarUm(atividadeTO));
		   Integer codProcesso = atividadeBO.consultarProcessoPorAtividade(atividadeTO);
		   
		   //Se usuario nao 'e participante nao pode acessar a atividade.
		   if ((atividadeForm.getResponsavel() != UsuarioBO.getUsuarioTO().getIdUsuario())&&(!UsuarioBO.getUsuarioTO().getPerfil().equals("administrador"))) {
			   setErro("pro.mensagem.autorizacao", "", request);
				return mapping.findForward("erro");
		   }
		   
		   /*Realiza a pesquisa de usuario(Responsavel para completar combo)*/
		   UsuarioBO usuarioBO = new UsuarioBO();
		   UsuarioTO usuarioTO = new UsuarioTO();
		   usuarioTO.setGrupoTO(UsuarioBO.getUsuarioTO().getGrupoTO());
		   request.setAttribute("listaResponsavel",usuarioBO.consultarVarios(usuarioTO));
		   
		   /*Consulta perspectiva*/
		   FaseBO perspectivaBO = new FaseBO();
		   FaseTO perspectivaTO = new FaseTO();
		   perspectivaTO.setIdProcesso(codProcesso.intValue());
		   request.setAttribute("listaFase",perspectivaBO.consultarVarios(perspectivaTO));

		   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codProcesso);
		   
		   /*Recupera Tarefas do usuario logado*/
		   UsuarioTO usuario = UsuarioBO.getUsuarioTO(response,request);
		   TarefaTO tarefaTO = new TarefaTO();
		   tarefaTO.setCodUsuSolicitante(usuario.getIdUsuario());
		   Util.consultarTarefaProcessoConfiguracao(tarefaTO, request, response);
		   
		   /*Recupera Tarefas vinculadas a um determinado perspectiva*/
			tarefaTO.setCodAtividade(atividadeTO.getId());
			request.getSession().setAttribute("listaTarefasObejtivo",atividadeBO.consultarTarefaFerramentaConfiguracao(tarefaTO));
		   
		   return mapping.findForward("sucessoAlterar");
	   } catch (Exception e) {
		   setErro("bsc.erro",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   /*Tiago Trindade Stangarlin 
    * Data 20/12/2005
    * Metodo utilizado para Consutlar um Atividade
    */
   public ActionForward consultarUm(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	   try {
		   AtividadeBO atividadeBO = new AtividadeBO();
		   AtividadeTO atividadeTO = new AtividadeTO();
		   AtividadeForm atividadeForm = (AtividadeForm) form;
		   Integer codAtividade = Integer.valueOf(request.getParameter("codAtividade"));
		   atividadeTO.setId(codAtividade.intValue());
		   atividadeForm.setAtividadeForm(atividadeBO.consultarUm(atividadeTO));
		   return mapping.findForward("sucesso");
	   } catch (Exception e) {
		   setErro("bsc.erro",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   /*Tiago Trindade Stangarlin 
    * Data 20/12/2005
    * Metodo utilizado para consultar Varios Atividade
    */
   public ActionForward consultarVarios(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	   try {
		   AtividadeBO atividadeBO = new AtividadeBO();
		   AtividadeTO atividadeTO = new AtividadeTO();
		   Integer codAtividade = Integer.valueOf(request.getParameter("codAtividade"));
		   atividadeTO.setId(codAtividade.intValue());
		   request.setAttribute("lsitaAtividade",atividadeBO.consultarVarios(atividadeTO));
		   return mapping.findForward("sucesso");
	   } catch (Exception e) {
		   setErro("bsc.erro",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   /*Tiago Trindade Stangarlin 
    * Data 20/12/2005
    * Metodo utilizado para Alterar Atividade
    */
   public ActionForward alterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	   try {
		   AtividadeBO atividadeBO = new AtividadeBO();
		   AtividadeTO atividadeTO = new AtividadeTO();
		   AtividadeForm atividadeForm = (AtividadeForm) form;
		   Integer codProcesso = (Integer) request.getSession().getAttribute("codProcessoArvoreConfiguracao");
		   atividadeForm.setAtividadeTO(atividadeTO);
		   atividadeBO.alterar(atividadeTO);
		   request.getSession().removeAttribute("arvoreConfiguracao");
		   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codProcesso);
		   setMensagem("bsc.mensagem.sucesso",request);
		   return mapping.findForward("sucessoAlterar");
	   } catch (Exception e) {
		   setErro("bsc.erro",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
      
   public ActionForward vincularTarefa(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   try {
		   int codTarefa = Integer.parseInt(request.getParameter("codTarefa"));
		   int codAtividade = Integer.parseInt(request.getParameter("codAtividade"));
		   int codProcesso = Integer.parseInt(request.getParameter("codProcesso"));
		   TarefaBO tarefaBO = new TarefaBO();
		   TarefaTO tarefaTO = new TarefaTO();
		   tarefaTO.setCodigo(codTarefa);
		   tarefaTO.setAnoCriacao(tarefaBO.consultarUm(tarefaTO).getAnoCriacao());
		   tarefaTO.setCodAtividade(codAtividade);
		   tarefaTO.setCodProc(codProcesso);
		   tarefaBO.verificaTarefaEstaVinculada(tarefaTO);
		   tarefaBO.alterar(tarefaTO);
		   
		   request.setAttribute("codAtividade",new Integer(codAtividade));
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
		   int codAtividade = Integer.parseInt(request.getParameter("codAtividade"));
		   TarefaBO tarefaBO = new TarefaBO();
		   TarefaTO tarefaTO = new TarefaTO();
		   tarefaTO.setCodigo(codTarefa);
		   tarefaTO.setAnoCriacao(ano);
		   tarefaBO.excluirTarefaAtividade(tarefaTO);
		   request.setAttribute("codAtividade",new Integer(codAtividade));
		   return mapping.findForward("sucesso");
	   } catch (Exception e) {
		   String lista[] = {"incluir",e.getMessage()};
		   setErro("bsc.erro.indicador",lista,request);
		   return mapping.findForward("erro");
	   }
	}
	
	
   
}
