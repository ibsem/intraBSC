package br.com.intraBSC.perspectiva.controle;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperPrint;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.intraBSC.controle.DispatchActionBSC;
import br.com.intraBSC.modelo.MapaEstrategicoTO;
import br.com.intraBSC.modelo.PerspectivaTO;
import br.com.intraBSC.modelo.TipoPerspectivaTO;
import br.com.intraBSC.modelo.UsuarioTO;
import br.com.intraBSC.negocio.MapaEstrategicoBO;
import br.com.intraBSC.negocio.PerspectivaBO;
import br.com.intraBSC.negocio.TipoPerspectivaBO;
import br.com.intraBSC.negocio.UsuarioBO;
import br.com.intraBSC.perspectiva.visao.PerspectivaForm;
import br.com.intraBSC.util.ValidaUsuario;
import br.com.intraPRO.modelo.TarefaTO;
import br.com.intraPRO.negocio.TarefaBO;
import br.com.intraPRO.util.Util;

public class PerspectivaAction extends DispatchActionBSC{
   
   public PerspectivaAction(){    
   }    
   
   /*Tiago Trindade Stangarlin 
    * Data 20/12/2005
    * Metodo utilizado para pesquisa de perspectivas por mapas estrategicos
    */
   public ActionForward consultarPerspectivaMapa(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	   try {
		   PerspectivaBO perspectivaBO = new PerspectivaBO();
		   PerspectivaTO perspectivaTO = new PerspectivaTO();
		   Integer codMapa = (Integer) request.getSession().getAttribute("codMapaSelecionado");
		   request.getSession().setAttribute("listaPerspectiva",perspectivaBO.consultarPerspectivaMapa(perspectivaTO,codMapa));
		   return mapping.findForward("sucesso");
	   } catch (Exception e) {
		   setErro("bsc.erro.consultar.perspectiva",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   /*Tiago 
    * Data 23/9/2006
    * Metodo de Incluisao de uma perspectiva para a ferramenta de configuracao*/
   public ActionForward incluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	   try {
		   PerspectivaBO perspectivaBO = new PerspectivaBO();
		   PerspectivaTO perspectivaTO = new PerspectivaTO();
		   PerspectivaForm perspectivaForm = (PerspectivaForm) form;
		   perspectivaForm.setPerspectivaTO(perspectivaTO);
		   Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
		   perspectivaTO.setIdMapa(codMapa.intValue());
		   perspectivaBO.incluir(perspectivaTO);
		   request.getSession().removeAttribute("arvoreConfiguracao");
		   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
		   
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
   public ActionForward perspectivaRelatorioDetalha(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   try {		   	
		   	String codMapaEstrategico = request.getParameter("codMapa");
		   	String codPerspectiva = request.getParameter("codPerspectiva");
		   	PerspectivaBO perspectivaBO = new PerspectivaBO();	   			
		   	PerspectivaTO perspectivaTO = new PerspectivaTO();
		   	perspectivaTO.setCaminhoRel(request.getSession().getServletContext().getRealPath("/relatorios/PerspectivaPrincipal.jasper"));
		   	perspectivaTO.setBaseDir(request.getSession().getServletContext().getRealPath(""));
		   	perspectivaTO.setId(Integer.parseInt(codPerspectiva));
		   	perspectivaTO.setIdMapa(Integer.parseInt(codMapaEstrategico));
  			
		   	/*Valida se usuário pertence ao Mapa ou tarefa */
			boolean UsuarioValidado;
			TarefaTO tarefaTO = new TarefaTO();	
			tarefaTO.setCodigo(-99);
			MapaEstrategicoTO mapaEstrategicoTO = new MapaEstrategicoTO();
			mapaEstrategicoTO.setId(Integer.parseInt(codMapaEstrategico));
			UsuarioValidado = ValidaUsuario.Autoriza(UsuarioBO.getUsuarioTO(response,request) ,mapaEstrategicoTO, tarefaTO );
			
			if (UsuarioValidado == true){
		   	JasperPrint jasperRelatorio = perspectivaBO.perspectivaRelatorioDetalha(perspectivaTO);
  			request.getSession().setAttribute("relatorio", jasperRelatorio);
  			return mapping.findForward("sucesso");}
  			else{
  				setErro("bsc.erro.naoAutorizado", request);
  				return mapping.findForward("erro");
  			}
	   } catch (Exception e) {
		   setErro("bsc.erro.consultar.relatorio.perspectiva",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
	   
   }

   /*Tiago Trindade Stangarlin 
    * Data 20/12/2005
    * Metodo utilizado para alterar uma perspectiva na ferramente de configuracao
    */
   public ActionForward alterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	   try {
		   PerspectivaBO perspectivaBO = new PerspectivaBO();
		   PerspectivaTO perspectivaTO = new PerspectivaTO();
		   PerspectivaForm perspectivaForm = (PerspectivaForm) form;
		   perspectivaForm.setPerspectivaTO(perspectivaTO);
		   Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
		   perspectivaTO.setIdMapa(codMapa.intValue());
		   perspectivaBO.alterar(perspectivaTO);
		   
		   
		   
		   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
 /* Pesquisa da Arvore completa */
		   
		   MapaEstrategicoBO mapaEstrategicoBO = new MapaEstrategicoBO();			
		   MapaEstrategicoTO mapaEstrategicoTO = new MapaEstrategicoTO();
		   mapaEstrategicoTO.setId(codMapa.intValue());
		   request.getSession().removeAttribute("arvoreConfiguracao");
		   
		   request.getSession().setAttribute("arvoreConfiguracao",mapaEstrategicoBO.consultarArvoreConfiguracao(mapaEstrategicoTO));
		   
		   
		   setMensagem("bsc.mensagem.sucesso",request);
		   request.setAttribute("codPerspectiva", perspectivaTO.getId());
		   return mapping.findForward("sucessoAlterar");
	   } catch (Exception e) {
		   setErro("bsc.erro",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   /*Tiago Trindade Stangarlin 
    * Data 20/12/2005
    * Metodo utilizado para encaminhar para a tela de inclusao ou alteracao de perspectiva
    * realizando a pesquisa de tipo de perspectiva e responsavel para completar o combo 
    * da pagina
    */
   public ActionForward encaminhaIncluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	   try {
		   /*Realiza a pesquisa de tipo de perspectiva para completar combo*/
		   TipoPerspectivaBO tipoPerspectivaBO = new TipoPerspectivaBO();
		   TipoPerspectivaTO tipoPerspectivaTO = new TipoPerspectivaTO();
		   tipoPerspectivaTO.setNome("");
		   request.setAttribute("listaTipoPerspectiva",tipoPerspectivaBO.consultarVarios(tipoPerspectivaTO));
		   Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
		   /*Realiza a pesquisa de usuario(Responsavel para completar combo)*/
		   UsuarioBO usuarioBO = new UsuarioBO();
		   UsuarioTO usuarioTO = new UsuarioTO();	
		   usuarioTO.setNome("");
		   usuarioTO.setGrupoTO(UsuarioBO.getUsuarioTO().getGrupoTO());
		   request.setAttribute("listaResponsavel",usuarioBO.consultarVarios(usuarioTO));
		   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
		   return mapping.findForward("sucessoIncluir");
		   
	   } catch (Exception e) {
		   setErro("bsc.erro",e.getMessage(),request);
		   return mapping.findForward("erro");
	   }
   }
   
   /*Tiago Trindade Stangarlin 
    * Data 20/12/2005
    * Metodo utilizado para encaminhar para a tela de inclusao ou alteracao de perspectiva
    * realizando a pesquisa de tipo de perspectiva e responsavel para completar o combo 
    * da pagina
    */
   public ActionForward encaminhaAlterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	   try {
		   String codPerspectiva = request.getParameter("codPerspectiva");
		   if (codPerspectiva == null){
			   codPerspectiva = request.getAttribute("codPerspectiva").toString();
		   }
		   PerspectivaBO perspectivaBO = new PerspectivaBO();
		   PerspectivaTO perspectivaTO = new PerspectivaTO();
		   perspectivaTO.setId(Integer.valueOf(codPerspectiva).intValue());
		   PerspectivaForm perspectivaForm = (PerspectivaForm) form;
		   perspectivaForm.setPerspectivaForm(perspectivaBO.consultarUm(perspectivaTO));
		   
		   //Se usuario nao 'e participante nao pode acessar a atividade.
		   if ((perspectivaForm.getResponsavel() != UsuarioBO.getUsuarioTO().getIdUsuario())&&(!UsuarioBO.getUsuarioTO().getPerfil().equals("administrador"))
				   &&(!UsuarioBO.getUsuarioTO().getPerfil().equals("gerentegeral"))) {
			   setErro("pro.mensagem.autorizacao", "", request);
				return mapping.findForward("erro");
		   }
		   
		   /*Realiza a pesquisa de tipo de perspectiva para completar combo*/
		   TipoPerspectivaBO tipoPerspectivaBO = new TipoPerspectivaBO();
		   TipoPerspectivaTO tipoPerspectivaTO = new TipoPerspectivaTO();	
		   tipoPerspectivaTO.setNome("");
		   request.setAttribute("listaTipoPerspectiva",tipoPerspectivaBO.consultarVarios(tipoPerspectivaTO));
		   Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
		   /*Realiza a pesquisa de usuario(Responsavel para completar combo)*/
		   UsuarioBO usuarioBO = new UsuarioBO();
		   UsuarioTO usuarioTO = new UsuarioTO();
		   usuarioTO.setNome("");
		   usuarioTO.setGrupoTO(UsuarioBO.getUsuarioTO().getGrupoTO());
		   request.setAttribute("listaResponsavel",usuarioBO.consultarVarios(usuarioTO));
		   codMapa = perspectivaBO.consultarMapaPorPerspectiva(perspectivaTO);
		   Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
		   
		   /*Recupera Tarefas do usuario logado*/
		   UsuarioTO usuario = UsuarioBO.getUsuarioTO(response,request);
		   TarefaTO tarefaTO = new TarefaTO();
		   tarefaTO.setCodUsuSolicitante(usuario.getIdUsuario());
		   Util.consultarTarefaMapaConfiguracao(tarefaTO, request, response);
		   
		    /*Recupera Tarefas vinculadas a um determinado perspectiva*/
			tarefaTO.setCodPerspectiva(perspectivaTO.getId());
			request.getSession().setAttribute("listaTarefasPerspectiva",perspectivaBO.consultarTarefaFerramentaConfiguracao(tarefaTO));
		   
		   return mapping.findForward("sucessoAlterar");
	   } catch (Exception e) {
		   setErro("bsc.erro.consultar.perspectiva",e.getMessage(),request);
		   return mapping.findForward("erro");
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
			   tarefaTO.setCodPerspectiva(codPerspectiva);
			   tarefaTO.setCodMapa(codMapa);
			   tarefaTO.setCodPerspectiva(codPerspectiva);
			   tarefaTO.setCodObjetivo(codObjetivo);
			   tarefaTO.setCodIndicador(codInd);
			   tarefaBO.verificaTarefaEstaVinculada(tarefaTO);
			   tarefaBO.alterar(tarefaTO);
			   
			   request.setAttribute("codPerspectiva",new Integer(codPerspectiva));
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
		   int codPerspectiva = Integer.parseInt(request.getParameter("codPerspectiva"));
		   TarefaBO tarefaBO = new TarefaBO();
		   TarefaTO tarefaTO = new TarefaTO();
		   tarefaTO.setCodigo(codTarefa);
		   tarefaTO.setAnoCriacao(ano);
		   tarefaBO.excluirTarefaPerpesctiva(tarefaTO);
		   request.setAttribute("codPerspectiva",new Integer(codPerspectiva));
		   return mapping.findForward("sucesso");
	   } catch (Exception e) {
		   String lista[] = {"incluir",e.getMessage()};
		   setErro("bsc.erro.indicador",lista,request);
		   return mapping.findForward("erro");
	   }
   }
   
   
   	
   
}