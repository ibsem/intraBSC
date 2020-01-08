package br.com.intraBSC.objetivo.controle;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperPrint;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.intraBSC.controle.DispatchActionBSC;
import br.com.intraBSC.modelo.MapaEstrategicoTO;
import br.com.intraBSC.modelo.ObjetivoTO;
import br.com.intraBSC.modelo.PerspectivaTO;
import br.com.intraBSC.modelo.TemaTO;
import br.com.intraBSC.modelo.UsuarioTO;
import br.com.intraBSC.negocio.MapaEstrategicoBO;
import br.com.intraBSC.negocio.ObjetivoBO;
import br.com.intraBSC.negocio.PerspectivaBO;
import br.com.intraBSC.negocio.TemaBO;
import br.com.intraBSC.negocio.UsuarioBO;
import br.com.intraBSC.objetivo.visao.ObjetivoForm;
import br.com.intraBSC.util.Constantes;
import br.com.intraBSC.util.ValidaUsuario;
import br.com.intraPRO.modelo.TarefaTO;
import br.com.intraPRO.negocio.TarefaBO;
import br.com.intraPRO.util.Util;

public class ObjetivoAction extends DispatchActionBSC{
   
	
	
   public ObjetivoAction(){    
   }
    
   /*Tiago Trindade Stangarlin 
    * Data 20/12/2005
    * Metodo utilizado para pesquisa de perspectivas por mapas estrategicos
    */
   public ActionForward consultarObjetivosPerspectivas(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	   try {
		   ObjetivoBO objetivoBO = new ObjetivoBO();
		   ObjetivoTO objetivoTO = new ObjetivoTO();		   
		   Integer codMapa = (Integer) request.getSession().getAttribute("codMapaSelecionado");
		   request.getSession().setAttribute("listaObjetivo",objetivoBO.consultarObjetivosVarios(objetivoTO,codMapa));
		   return mapping.findForward("sucesso");
	   } catch (Exception e) {
		   setErro("bsc.erro.consultar.objetivo",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }

   /*
    * Autor Tiago Trindade Stangarlin
    * Data 11/10/2005
    * Metodo de consulta para gerar relatorio Objetivo
    */
   public ActionForward objetivoRelatorioDetalha(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   try {		   	
		   	String codMapaEstrategico = request.getParameter("codMapa");
		   	String codObjetivo = request.getParameter("codObjetivo");
		   	ObjetivoBO objetivoBO = new ObjetivoBO();	   			
		   	ObjetivoTO objetivoTO = new ObjetivoTO();
		   	objetivoTO.setCaminhoRel(request.getSession().getServletContext().getRealPath("/relatorios/ObjetivoPrincipal.jasper"));
		   	objetivoTO.setBaseDir(request.getSession().getServletContext().getRealPath(""));
		   	objetivoTO.setId(Integer.parseInt(codObjetivo));
		   	objetivoTO.setIdMapa(Integer.parseInt(codMapaEstrategico));
			/*Valida se usuário pertence ao Mapa ou tarefa */
			boolean UsuarioValidado;
			TarefaTO tarefaTO = new TarefaTO();	
			tarefaTO.setCodigo(-99);
			MapaEstrategicoTO mapaEstrategicoTO = new MapaEstrategicoTO();
			mapaEstrategicoTO.setId(Integer.parseInt(codMapaEstrategico));
			UsuarioValidado = ValidaUsuario.Autoriza(UsuarioBO.getUsuarioTO(response,request) ,mapaEstrategicoTO, tarefaTO );
			
			if (UsuarioValidado == true){
		   	
  			JasperPrint jasperRelatorio = objetivoBO.objetivoRelatorioDetalha(objetivoTO);
  			request.getSession().setAttribute("relatorio", jasperRelatorio);
  			return mapping.findForward("sucesso");}
			else{
				setErro("bsc.erro.naoAutorizado", request);
  				return mapping.findForward("erro");
			}
	   } catch (Exception e) {
		   setErro("bsc.erro.consultar.relatorio.objetivo",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
	   
   }
   
   /*Tiago Trindade Stangarlin 
    * Data 20/12/2005
    * Metodo utilizado para encaminhar inclusao Objetivo
    */
   public ActionForward encaminharIncluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	   try {
		   /*Realiza a pesquisa de usuario(Responsavel para completar combo)*/
		   UsuarioBO usuarioBO = new UsuarioBO();
		   UsuarioTO usuarioTO = new UsuarioTO();
		   usuarioTO.setGrupoTO(UsuarioBO.getUsuarioTO().getGrupoTO());
		   request.setAttribute("listaResponsavel",usuarioBO.consultarVarios(usuarioTO));
		   
		   /*Consulta perspectiva*/
		   PerspectivaBO perspectivaBO = new PerspectivaBO();
		   PerspectivaTO perspectivaTO = new PerspectivaTO();
		   Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
		   perspectivaTO.setIdMapa(codMapa.intValue());
		   request.setAttribute("listaPerspectiva",perspectivaBO.consultarVarios(perspectivaTO));
		   
		   TemaBO temaBO = new TemaBO();
		   TemaTO temaTO = new TemaTO();
		   temaTO.setUsuario(UsuarioBO.getUsuarioTO());
		   request.setAttribute("listaTema",temaBO.consultarVarios(temaTO));
		   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
		   return mapping.findForward("sucessoIncluir");
	   } catch (Exception e) {
		   setErro("bsc.erro.consultar.objetivo",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   /*Tiago Trindade Stangarlin 
    * Data 20/12/2005
    * Metodo utilizado para incluir Objetivo
    */
   public ActionForward incluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	   try {
		   ObjetivoBO objetivoBO = new ObjetivoBO();
		   ObjetivoTO objetivoTO = new ObjetivoTO();
		   ObjetivoForm objetivoForm = (ObjetivoForm) form; 
		   objetivoForm.setObjetivoTO(objetivoTO);
		   validarColuna(objetivoForm);
		   objetivoBO.incluir(objetivoTO);
		   Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
		   request.getSession().removeAttribute("arvoreConfiguracao");
		   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
		   setMensagem("bsc.mensagem.sucesso",request);
		   return mapping.findForward("sucessoIncluir");
	   } catch (Exception e) {
		   setErro("bsc.erro",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   /*Tiago Trindade Stangarlin 
    * Data 20/12/2005
    * Metodo utilizado para Encaminhar Alteracao Objetivo
    */
   public ActionForward encaminharAlterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	   try {
		   String codObjetivo = request.getParameter("codObjetivo");
		   if (codObjetivo == null){
			   codObjetivo = request.getAttribute("codObjetivo").toString();
		   }
		   ObjetivoBO objetivoBO = new ObjetivoBO();
		   ObjetivoTO objetivoTO = new ObjetivoTO();
		   ObjetivoForm objetivoForm = (ObjetivoForm) form;
		   objetivoTO.setId(Integer.valueOf(codObjetivo).intValue());
		   objetivoForm.setObjetivoForm(objetivoBO.consultarUm(objetivoTO));
		   Integer codMapa = objetivoBO.consultarMapaPorObjetivo(objetivoTO);
		   
		   //Se usuario nao 'e participante nao pode acessar a atividade.
		   if ((objetivoForm.getResponsavel() != UsuarioBO.getUsuarioTO().getIdUsuario())&&(!UsuarioBO.getUsuarioTO().getPerfil().equals("administrador"))
				   &&(!UsuarioBO.getUsuarioTO().getPerfil().equals("gerentegeral"))) {
			   setErro("pro.mensagem.autorizacao", "", request);
				return mapping.findForward("erro");
		   }
		   
		   /*Realiza a pesquisa de usuario(Responsavel para completar combo)*/
		   UsuarioBO usuarioBO = new UsuarioBO();
		   UsuarioTO usuarioTO = new UsuarioTO();
		   usuarioTO.setGrupoTO(UsuarioBO.getUsuarioTO().getGrupoTO());
		   request.setAttribute("listaResponsavel",usuarioBO.consultarVarios(usuarioTO));
		   
		   /*Consulta perspectiva*/
		   PerspectivaBO perspectivaBO = new PerspectivaBO();
		   PerspectivaTO perspectivaTO = new PerspectivaTO();
		   perspectivaTO.setIdMapa(codMapa.intValue());
		   request.setAttribute("listaPerspectiva",perspectivaBO.consultarVarios(perspectivaTO));
		   
		   TemaBO temaBO = new TemaBO();
		   TemaTO temaTO = new TemaTO();
		   temaTO.setUsuario(UsuarioBO.getUsuarioTO());
		   request.setAttribute("listaTema",temaBO.consultarVarios(temaTO));
		   
		   
		   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
		   
		   /*Recupera Tarefas do usuario logado*/
		   UsuarioTO usuario = UsuarioBO.getUsuarioTO(response,request);
		   TarefaTO tarefaTO = new TarefaTO();
		   tarefaTO.setCodUsuSolicitante(usuario.getIdUsuario());
		   Util.consultarTarefaMapaConfiguracao(tarefaTO, request, response);
		   
		   /*Recupera Tarefas vinculadas a um determinado perspectiva*/
			tarefaTO.setCodObjetivo(objetivoTO.getId());
			request.getSession().setAttribute("listaTarefasObejtivo",objetivoBO.consultarTarefaFerramentaConfiguracao(tarefaTO));
		   
		   return mapping.findForward("sucessoAlterar");
	   } catch (Exception e) {
		   setErro("bsc.erro",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   /*Tiago Trindade Stangarlin 
    * Data 20/12/2005
    * Metodo utilizado para Consutlar um Objetivo
    */
   public ActionForward consultarUm(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	   try {
		   ObjetivoBO objetivoBO = new ObjetivoBO();
		   ObjetivoTO objetivoTO = new ObjetivoTO();
		   ObjetivoForm objetivoForm = (ObjetivoForm) form;
		   Integer codObjetivo = Integer.valueOf(request.getParameter("codObjetivo"));
		   objetivoTO.setId(codObjetivo.intValue());
		   objetivoForm.setObjetivoForm(objetivoBO.consultarUm(objetivoTO));
		   return mapping.findForward("sucesso");
	   } catch (Exception e) {
		   setErro("bsc.erro",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   /*Tiago Trindade Stangarlin 
    * Data 20/12/2005
    * Metodo utilizado para consultar Varios Objetivo
    */
   public ActionForward consultarVarios(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	   try {
		   ObjetivoBO objetivoBO = new ObjetivoBO();
		   ObjetivoTO objetivoTO = new ObjetivoTO();
		   Integer codObjetivo = Integer.valueOf(request.getParameter("codObjetivo"));
		   objetivoTO.setId(codObjetivo.intValue());
		   request.setAttribute("lsitaObjetivo",objetivoBO.consultarVarios(objetivoTO));
		   return mapping.findForward("sucesso");
	   } catch (Exception e) {
		   setErro("bsc.erro",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   /*Tiago Trindade Stangarlin 
    * Data 20/12/2005
    * Metodo utilizado para Alterar Objetivo
    */
   public ActionForward alterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	   try {
		   ObjetivoBO objetivoBO = new ObjetivoBO();
		   ObjetivoTO objetivoTO = new ObjetivoTO();
		   ObjetivoForm objetivoForm = (ObjetivoForm) form;
		   validarColuna(objetivoForm);
		   objetivoForm.setObjetivoTO(objetivoTO);
		   objetivoTO.setId(objetivoForm.getId());
		   objetivoBO.alterar(objetivoTO);
		   
		   Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
		   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
		   
		   MapaEstrategicoBO mapaEstrategicoBO = new MapaEstrategicoBO();			
		   MapaEstrategicoTO mapaEstrategicoTO = new MapaEstrategicoTO();
		   mapaEstrategicoTO.setId(codMapa.intValue());
		   request.getSession().removeAttribute("arvoreConfiguracao");
		   
		   request.getSession().setAttribute("arvoreConfiguracao",mapaEstrategicoBO.consultarArvoreConfiguracao(mapaEstrategicoTO));
		   setMensagem("bsc.mensagem.sucesso",request);
		   request.setAttribute("codObjetivo", objetivoTO.getId());
		   return mapping.findForward("sucessoAlterar");
	   } catch (Exception e) {
		   String lista[] = {"alterar",e.getMessage()};
		   setErro("bsc.erro",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   private void validarColuna(ObjetivoForm form) throws Exception {
	   if (form.getColuna() == 0) {
		   throw new Exception(Constantes.ERRO_COLUNA);
	   }
   }
   
   public ActionForward vincularTarefa(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   try {
		   int codTarefa = Integer.parseInt(request.getParameter("codTarefa"));
		   int codMapa = Integer.parseInt(request.getParameter("codMapa"));
		   int codPerspectiva = Integer.parseInt(request.getParameter("codPerspectiva"));
		   int codObjetivo = Integer.parseInt(request.getParameter("codObjetivo"));
		   int codInd = Integer.parseInt(request.getParameter("codIndicador"));
		   TarefaBO tarefaBO = new TarefaBO();
		   TarefaTO tarefaTO = new TarefaTO();
		   tarefaTO.setCodigo(codTarefa);
		   tarefaTO.setAnoCriacao(tarefaBO.consultarUm(tarefaTO).getAnoCriacao());
		   tarefaTO.setCodMapa(codMapa);
		   tarefaTO.setCodPerspectiva(codPerspectiva);
		   tarefaTO.setCodObjetivo(codObjetivo);
		   tarefaTO.setCodIndicador(codInd);
		   tarefaBO.verificaTarefaEstaVinculada(tarefaTO);
		   tarefaBO.alterar(tarefaTO);
		   
		   request.setAttribute("codObjetivo",new Integer(codObjetivo));
		   return mapping.findForward("sucesso");
	   } catch (Exception e) {
		   setErro("bsc.erro.consultar.indicador",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }

	/*Metodo exclui tarefa relacionada do Perspectiva*/
	public ActionForward excluirTarefa(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   try {
		   int codTarefa = Integer.parseInt(request.getParameter("codTarefa"));
		   int ano = Integer.parseInt(request.getParameter("ano"));
		   int codObjetivo = Integer.parseInt(request.getParameter("codObjetivo"));
		   TarefaBO tarefaBO = new TarefaBO();
		   TarefaTO tarefaTO = new TarefaTO();
		   tarefaTO.setCodigo(codTarefa);
		   tarefaTO.setAnoCriacao(ano);
		   tarefaBO.excluirTarefaObjetivo(tarefaTO);
		   request.setAttribute("codObjetivo",new Integer(codObjetivo));
		   return mapping.findForward("sucesso");
	   } catch (Exception e) {
		   String lista[] = {"incluir",e.getMessage()};
		   setErro("bsc.erro.indicador",lista,request);
		   return mapping.findForward("erro");
	   }
	}
	
	
   
}
