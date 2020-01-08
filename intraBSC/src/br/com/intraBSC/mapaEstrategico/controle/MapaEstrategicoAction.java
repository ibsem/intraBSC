
package br.com.intraBSC.mapaEstrategico.controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperPrint;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.intraBSC.XML.ExportarXML;
import br.com.intraBSC.XML.ImportarXml;
import br.com.intraBSC.controle.DispatchActionBSC;
import br.com.intraBSC.mapaEstrategico.visao.MapaEstrategicoForm;
import br.com.intraBSC.modelo.CausaEfeitoTO;
import br.com.intraBSC.modelo.IndicadorTO;
import br.com.intraBSC.modelo.MapaEstrategicoTO;
import br.com.intraBSC.modelo.ObjetivoTO;
import br.com.intraBSC.modelo.PerspectivaTO;
import br.com.intraBSC.modelo.UsuarioTO;
import br.com.intraBSC.negocio.CausaEfeitoBO;
import br.com.intraBSC.negocio.IndicadorBO;
import br.com.intraBSC.negocio.MapaEstrategicoBO;
import br.com.intraBSC.negocio.ObjetivoBO;
import br.com.intraBSC.negocio.PerspectivaBO;
import br.com.intraBSC.negocio.UsuarioBO;
import br.com.intraBSC.util.ValidaUsuario;
import br.com.intraPRO.modelo.TarefaTO;
import br.com.intraPRO.negocio.TarefaBO;
import br.com.intraPRO.util.Util;

/**
 * @author Tiago Trindade Stangarlin 04/02/2005
 */
public class MapaEstrategicoAction extends DispatchActionBSC {
	
	/**
	 * Autor Tiago Trindade Stangarlin Data 11/10/2005 Metodo de consulta mapa
	 * estrategico (Utilizado na 1 tela.)
	 */
	public ActionForward consultarMapaUsuario(ActionMapping mapping,ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {
		try {
			//Remove da sessao a lista de arvore da ferramenta de configuracao
			request.getSession().removeAttribute("arvoreConfiguracao");
			request.getSession().removeAttribute("listaMapaEstrategico");
			MapaEstrategicoBO mapaEstrategicoBO = new MapaEstrategicoBO();
			MapaEstrategicoTO mapaEstrategicoTO = new MapaEstrategicoTO();
			UsuarioTO usuario = UsuarioBO.getUsuarioTO(response,request);
			mapaEstrategicoTO.setIdUsuario(usuario.getIdUsuario());
			Collection listaMapa = mapaEstrategicoBO.consultarMapaUsuario(mapaEstrategicoTO);
			if (!listaMapa.isEmpty())
				request.getSession().setAttribute("listaMapaEstrategico",listaMapa);
			else
				setMensagem("bsc.mapaEstrategico.vazio", request);
			return mapping.findForward("sucesso");
		} catch (Exception e) {
			setErro("bsc.erro.consultar.mapaEstrategico", e.getMessage(),request);
			return mapping.findForward("erro");
		}

	}

	/**
	 * Autor Tiago Trindade Stangarlin Data 11/10/2005 Metodo de consulta mapa
	 * estrategico
	 */
	public ActionForward mapaUsuarioRelatorioDetalha(ActionMapping mapping,ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {
		try {
			
			request.getSession().removeAttribute("codMapaSelecionado");
			String codMapaEstrategico = request.getParameter("codMapaEstrategico");
			request.getSession().setAttribute("codMapaSelecionado",	new Integer(codMapaEstrategico));
			MapaEstrategicoBO mapaEstrategicoBO = new MapaEstrategicoBO();
			MapaEstrategicoTO mapaEstrategicoTO = new MapaEstrategicoTO();
			mapaEstrategicoTO.setCaminhoRel(request.getSession().getServletContext().getRealPath("/relatorios/MapaEstrategicoPrincipal.jasper"));
			mapaEstrategicoTO.setBaseDir(request.getSession().getServletContext().getRealPath(""));
			mapaEstrategicoTO.setId(Integer.parseInt(codMapaEstrategico));
			/*Valida se usuário pertence ao Mapa ou tarefa */
			boolean UsuarioValidado;
			TarefaTO tarefaTO = new TarefaTO();	
			tarefaTO.setCodigo(-99);
			UsuarioValidado = ValidaUsuario.Autoriza(UsuarioBO.getUsuarioTO(response,request) ,mapaEstrategicoTO, tarefaTO );
			
			if (UsuarioValidado == true){
			/* Pesquisa da Arvore completa */
			IndicadorBO indicadorBO = new IndicadorBO();
			IndicadorTO indicadorTO = new IndicadorTO();
			Integer codMapa = (Integer) request.getSession().getAttribute("codMapaSelecionado");
			indicadorTO.setIdMapa(codMapa.intValue());
			request.getSession().setAttribute("listaIndicador",indicadorBO.consultarArvoreVisualizacao(indicadorTO));
			JasperPrint jasperRelatorio = mapaEstrategicoBO.mapaEstrategicoRelatorioDetalha(mapaEstrategicoTO);
			request.getSession().setAttribute("relatorio",jasperRelatorio);
			return mapping.findForward("sucesso");}
			else {
			setErro("bsc.erro.naoAutorizado", request);
			return mapping.findForward("erro");
			}
		} catch (Exception e) {
			setErro("bsc.erro.consultar.mapaEstrategico", e.getMessage(),request);
			return mapping.findForward("erro");
		}

	}
	/**
	 * Autor IBsem Agrello Dias Data 01/02/2011 Metodo desempenho
	 * estrategico
	 */
	public ActionForward mapaDesempenho(ActionMapping mapping,ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {
		try {
			
			request.getSession().removeAttribute("codMapaSelecionado");
			String codMapaEstrategico = request.getParameter("codMapaEstrategico");
			request.getSession().setAttribute("codMapaSelecionado",	new Integer(codMapaEstrategico));
			MapaEstrategicoBO mapaEstrategicoBO = new MapaEstrategicoBO();
			MapaEstrategicoTO mapaEstrategicoTO = new MapaEstrategicoTO();
			mapaEstrategicoTO.setCaminhoRel(request.getSession().getServletContext().getRealPath("/relatorios/MapaDesempenho.jasper"));
			mapaEstrategicoTO.setBaseDir(request.getSession().getServletContext().getRealPath(""));
			mapaEstrategicoTO.setId(Integer.parseInt(codMapaEstrategico));
			/*Valida se usuário pertence ao Mapa ou tarefa */
			boolean UsuarioValidado;
			TarefaTO tarefaTO = new TarefaTO();	
			tarefaTO.setCodigo(-99);
			UsuarioValidado = ValidaUsuario.Autoriza(UsuarioBO.getUsuarioTO(response,request) ,mapaEstrategicoTO, tarefaTO );
			
			if (UsuarioValidado == true){
			/* Pesquisa da Arvore completa */
			IndicadorBO indicadorBO = new IndicadorBO();
			IndicadorTO indicadorTO = new IndicadorTO();
			Integer codMapa = (Integer) request.getSession().getAttribute("codMapaSelecionado");
			indicadorTO.setIdMapa(codMapa.intValue());
			request.getSession().setAttribute("listaIndicador",indicadorBO.consultarArvoreVisualizacao(indicadorTO));
			JasperPrint jasperRelatorio = mapaEstrategicoBO.mapaEstrategicoRelatorioDetalha(mapaEstrategicoTO);
			request.getSession().setAttribute("relatorio",jasperRelatorio);
			return mapping.findForward("sucesso");}
			else {
			setErro("bsc.erro.naoAutorizado", request);
			return mapping.findForward("erro");
			}
		} catch (Exception e) {
			setErro("bsc.erro.consultar.mapaEstrategico", e.getMessage(),request);
			return mapping.findForward("erro");
		}

	}

	/**
	 * Autor IBsem Agrello Dias Data 01/02/2011 Metodo desempenho
	 * estrategico
	 */
	public ActionForward mapaDesempenhoNoMes(ActionMapping mapping,ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {
		try {
			
			request.getSession().removeAttribute("codMapaSelecionado");
			String codMapaEstrategico = request.getParameter("codMapaEstrategico");
			request.getSession().setAttribute("codMapaSelecionado",	new Integer(codMapaEstrategico));
			MapaEstrategicoBO mapaEstrategicoBO = new MapaEstrategicoBO();
			MapaEstrategicoTO mapaEstrategicoTO = new MapaEstrategicoTO();
			mapaEstrategicoTO.setCaminhoRel(request.getSession().getServletContext().getRealPath("/relatorios/MapaDesempenhoNoMes.jasper"));
			mapaEstrategicoTO.setBaseDir(request.getSession().getServletContext().getRealPath(""));
			mapaEstrategicoTO.setId(Integer.parseInt(codMapaEstrategico));
			/*Valida se usuário pertence ao Mapa ou tarefa */
			boolean UsuarioValidado;
			TarefaTO tarefaTO = new TarefaTO();	
			tarefaTO.setCodigo(-99);
			UsuarioValidado = ValidaUsuario.Autoriza(UsuarioBO.getUsuarioTO(response,request) ,mapaEstrategicoTO, tarefaTO );
			
			if (UsuarioValidado == true){
			/* Pesquisa da Arvore completa */
			IndicadorBO indicadorBO = new IndicadorBO();
			IndicadorTO indicadorTO = new IndicadorTO();
			Integer codMapa = (Integer) request.getSession().getAttribute("codMapaSelecionado");
			indicadorTO.setIdMapa(codMapa.intValue());
			request.getSession().setAttribute("listaIndicador",indicadorBO.consultarArvoreVisualizacao(indicadorTO));
			JasperPrint jasperRelatorio = mapaEstrategicoBO.mapaEstrategicoRelatorioDetalha(mapaEstrategicoTO);
			request.getSession().setAttribute("relatorio",jasperRelatorio);
			return mapping.findForward("sucesso");}
			else {
			setErro("bsc.erro.naoAutorizado", request);
			return mapping.findForward("erro");
			}
		} catch (Exception e) {
			setErro("bsc.erro.consultar.mapaEstrategico", e.getMessage(),request);
			return mapping.findForward("erro");
		}

	}
	
	
	/**
	 * Autor Tiago Trindade Stangarlin Data 11/10/2005 Metodo de consulta mapa
	 * estrategico
	 */
	public ActionForward incluir(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
		try {
			request.getSession().removeAttribute("codMapaSelecionado");
			request.getSession().removeAttribute("listaMapaEstrategico");
			MapaEstrategicoBO mapaEstrategicoBO = new MapaEstrategicoBO();
			MapaEstrategicoTO mapaEstrategicoTO = new MapaEstrategicoTO();
			MapaEstrategicoForm mapaEstrategicoForm = (MapaEstrategicoForm) form;
			mapaEstrategicoTO.setId(mapaEstrategicoForm.getId());
			mapaEstrategicoTO.setAtivo(mapaEstrategicoForm.getAtivo());
			mapaEstrategicoTO.setNome(mapaEstrategicoForm.getNome());
			mapaEstrategicoTO.setIdResponsavel(mapaEstrategicoForm.getIdResponsavel());
			mapaEstrategicoTO.setMissao(mapaEstrategicoForm.getMissao());
			mapaEstrategicoTO.setVisao(mapaEstrategicoForm.getVisao());
			mapaEstrategicoTO.setFatoresSucesso(mapaEstrategicoForm.getFatoresSucesso());
			mapaEstrategicoBO.incluir(mapaEstrategicoTO);
			setMensagem("bsc.mensagem.sucesso",request);
			//alteração para corrigir problema apos inclusao
			request.getSession().setAttribute(("nomeMapaIncluido"),mapaEstrategicoTO.getNome());
			request.getSession().setAttribute(("codMapaIncluido"),mapaEstrategicoTO.getId());
			request.getSession().setAttribute(("itemSelecionado"),mapaEstrategicoTO.getId());
			Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),mapaEstrategicoTO.getId());
			return mapping.findForward("sucesso");
		} catch (Exception e) {
			String erros[] = {"Incluir",e.getMessage()};
			setErro("bsc.erro.mapaEstrategico",erros,request);
			return mapping.findForward("erro");
		}
	}

	/**
	 * Autor Tiago Trindade Stangarlin Data 11/10/2005 Metodo de consulta mapa
	 * estrategico
	 */
	public ActionForward alterar(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
		try {
			request.getSession().removeAttribute("codMapaSelecionado");
			request.getSession().removeAttribute("listaMapaEstrategico");
			MapaEstrategicoBO mapaEstrategicoBO = new MapaEstrategicoBO();
			MapaEstrategicoTO mapaEstrategicoTO = new MapaEstrategicoTO();
			MapaEstrategicoForm mapaEstrategicoForm = (MapaEstrategicoForm) form;
			mapaEstrategicoTO.setId(mapaEstrategicoForm.getId());
			mapaEstrategicoTO.setAtivo(mapaEstrategicoForm.getAtivo());
			mapaEstrategicoTO.setIdResponsavel(mapaEstrategicoForm.getIdResponsavel());
			mapaEstrategicoTO.setNome(mapaEstrategicoForm.getNome());
			mapaEstrategicoTO.setMissao(mapaEstrategicoForm.getMissao());
			mapaEstrategicoTO.setVisao(mapaEstrategicoForm.getVisao());
			mapaEstrategicoTO.setFatoresSucesso(mapaEstrategicoForm.getFatoresSucesso());
			mapaEstrategicoBO.alterar(mapaEstrategicoTO);
			
			/* Pesquisa da Arvore completa */
			mapaEstrategicoTO.setId(mapaEstrategicoForm.getId());
			request.getSession().removeAttribute("arvoreConfiguracao");
			Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),mapaEstrategicoForm.getId());
			setMensagem("bsc.mensagem.sucesso",request);
			request.setAttribute("codMapa", mapaEstrategicoTO.getId());
			return mapping.findForward("sucessoAlterar");
		} catch (Exception e) {
			 setErro("bsc.erro",e.getMessage(),request);
			return mapping.findForward("erro");
		}
	}
	
	/**
	 * Autor Tiago Trindade Stangarlin Data 11/10/2005 Metodo de consulta mapa
	 * estrategico
	 */
	public ActionForward consultarVarios(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
		try {
			request.getSession().removeAttribute("codMapaSelecionado");
			MapaEstrategicoBO mapaEstrategicoBO = new MapaEstrategicoBO();
			MapaEstrategicoTO mapaEstrategicoTO = new MapaEstrategicoTO();
			MapaEstrategicoForm mapaEstrategicoForm = (MapaEstrategicoForm) form;
			mapaEstrategicoTO.setNome(mapaEstrategicoForm.getNome());
			mapaEstrategicoTO.setAtivo(mapaEstrategicoForm.getAtivo());
			mapaEstrategicoTO.setIdResponsavel(UsuarioBO.getUsuarioTO().getIdUsuario());
			request.setAttribute("listaMapa",mapaEstrategicoBO.consultarVarios(mapaEstrategicoTO));
			return mapping.findForward("sucessoConsulta");
		} catch (Exception e) {
			setErro("bsc.erro",e.getMessage(),request);
			return mapping.findForward("erro");
		}
	}
	

	/**
	 * Autor Tiago Trindade Stangarlin Data 11/10/2005 Metodo de consulta mapa
	 * estrategico
	 */
	public ActionForward consultarUm(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
		try {
			Integer mapa;
			request.getSession().getAttribute("itemSelecionado");
			request.getSession().removeAttribute("codMapaSelecionado");
			request.getSession().removeAttribute("listaMapaEstrategico");
			MapaEstrategicoBO mapaEstrategicoBO = new MapaEstrategicoBO();
			MapaEstrategicoTO mapaEstrategicoTO = new MapaEstrategicoTO();
			MapaEstrategicoForm mapaEstrategicoForm = (MapaEstrategicoForm) form;
			mapaEstrategicoTO.setId(mapaEstrategicoForm.getId());
						
			request.setAttribute("mapaEstrategicoForm",mapaEstrategicoBO.consultarUm(mapaEstrategicoTO));
			// erro 
			//Se usuario nao 'e participante nao pode acessar a atividade.
			  if ((mapaEstrategicoTO.getIdUsuario() != UsuarioBO.getUsuarioTO().getIdUsuario())&&(!UsuarioBO.getUsuarioTO().getPerfil().equals("administrador"))
					  &&(!UsuarioBO.getUsuarioTO().getPerfil().equals("gerentegeral"))) {
				   setErro("pro.mensagem.autorizacao", "", request);
					return mapping.findForward("erro");
			  }
			
			/*Consultar Responsavel*/
		    UsuarioBO usuarioBO = new UsuarioBO();
		    UsuarioTO usuarioTO = new UsuarioTO();
		    usuarioTO.setGrupoTO(UsuarioBO.getUsuarioTO().getGrupoTO());
		    request.setAttribute("listaResponsavel",usuarioBO.consultarVarios(usuarioTO));
		    
		    Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),mapaEstrategicoForm.getId());
		    
		    /*Recupera Tarefas do usuario logado*/
		    UsuarioTO usuario = UsuarioBO.getUsuarioTO(response,request);
		    TarefaTO tarefaTO = new TarefaTO();
		    tarefaTO.setCodUsuSolicitante(usuario.getIdUsuario());
		    Util.consultarTarefaMapaConfiguracao(tarefaTO, request, response);
		    
		    /*Recupera Tarefas vinculadas a um determinado Mapa*/
			tarefaTO.setCodMapa(mapaEstrategicoTO.getId());
			request.getSession().setAttribute("listaTarefasMapa",mapaEstrategicoBO.consultarTarefaFerramentaConfiguracao(tarefaTO));
		    
			return mapping.findForward("sucesso");
		} catch (Exception e) {
			setErro("bsc.erro",e.getMessage(),request);
			return mapping.findForward("erro");
		}
	}
	
	/*
	 * Autor Tiago Trindade Stangarlin Data 11/10/2005 
	 * Metodo de 
	 */
	public ActionForward consultarArvoreConfiguracao(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
		try {
			Integer codMapa;
			String nomeMapa;
			//somente para inclusao
			request.getSession().removeAttribute("codMapaSelecionado");
			request.getSession().removeAttribute("listaMapaEstrategico");
			/* Pesquisa da Arvore completa */
			if (request.getSession().getAttribute("codMapaIncluido")!= null ){
			codMapa = (Integer) request.getSession().getAttribute("codMapaIncluido");
			nomeMapa = (String) request.getSession().getAttribute("nomeMapaIncluido");
			}else{
			codMapa = Integer.valueOf(request.getParameter("codMapa"));
			nomeMapa = request.getParameter("nomeMapa");
			}
			request.getSession().setAttribute("codMapaArvoreConfiguracao",codMapa);
			request.getSession().setAttribute("nomeMapaVigente",nomeMapa);
			//somente para inclusao
			request.getSession().removeAttribute("codMapaIncluido");
			request.getSession().removeAttribute("nomeMapaIncluido");
			/*Valida se usuário pertence ao Mapa ou tarefa */
			TarefaTO tarefaTO = new TarefaTO();	
			tarefaTO.setCodigo(-99);
			MapaEstrategicoTO mapaEstrategicoTO = new MapaEstrategicoTO();
			mapaEstrategicoTO.setId(codMapa);
			boolean UsuarioValidado;
			UsuarioValidado = ValidaUsuario.Autoriza(UsuarioBO.getUsuarioTO(response,request) ,mapaEstrategicoTO, tarefaTO );
			if (UsuarioValidado == true){
			Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
			request.getSession().setAttribute("codMapaSelecionadoRetorno", codMapa);
			return mapping.findForward("sucessoArvore");}
			else{
				setErro("bsc.erro.naoAutorizado", request);
				return mapping.findForward("erro");			
			}
		} catch (Exception e) {
			setErro("bsc.erro",e.getMessage(),request);
			return mapping.findForward("erro");
		}
	}
	
	//Metodo referente a tela principal do sistema.	
	public ActionForward telaPrincipal(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
		try {
			
			/*Parte referente aos Mapa do usuario*/
			request.getSession().removeAttribute("arvoreConfiguracao");
			request.getSession().removeAttribute("listaMapaEstrategico");
			MapaEstrategicoBO mapaEstrategicoBO = new MapaEstrategicoBO();
			MapaEstrategicoTO mapaEstrategicoTO = new MapaEstrategicoTO();
			UsuarioTO usuario = UsuarioBO.getUsuarioTO(response,request);
			mapaEstrategicoTO.setAtivo(1);
			mapaEstrategicoTO.setIdUsuario(usuario.getIdUsuario());
			Collection listaMapa = mapaEstrategicoBO.consultarMapaUsuario(mapaEstrategicoTO);
			if (!listaMapa.isEmpty())
				request.getSession().setAttribute("listaMapaEstrategico",listaMapa);
			else
				setMensagem("bsc.mapaEstrategico.vazio", request);
			
			/*Parte referente as Tarefas do usuario*/
			Util.atualizaArvoreTarefa(request,response);
			
			/*Parte referente os Indicadores do usuario*/
			IndicadorBO indicadorBO = new IndicadorBO();
			IndicadorTO indicadorTO = new IndicadorTO();		   
			indicadorTO.setResponsavelIndicador(usuario.getIdUsuario());
			request.getSession().setAttribute("codUsuarioSelecionado",new Integer(usuario.getIdUsuario()));
			request.getSession().setAttribute("listaIndicador",indicadorBO.consultarIndicadorUsuario(indicadorTO));
			
			return mapping.findForward("sucesso");
		} catch (Exception e) {
			setErro("bsc.erro",e.getMessage(),request);
			return mapping.findForward("erro");
		}
	}
	
	public ActionForward encaminhaIncluir(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
		try {
			/*Consultar Responsavel*/
		    UsuarioBO usuarioBO = new UsuarioBO();
		    UsuarioTO usuarioTO = new UsuarioTO();
		    usuarioTO.setGrupoTO(UsuarioBO.getUsuarioTO().getGrupoTO());
		    request.setAttribute("listaResponsavel",usuarioBO.consultarVarios(usuarioTO));
			return mapping.findForward("sucesso");
		} catch (Exception e) {
			setErro("bsc.erro",e.getMessage(),request);
			return mapping.findForward("erro");
		}
	}
	
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward mapaEstrategicoCrossTable(ActionMapping mapping,ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {
		try {
			request.getSession().removeAttribute("codMapaSelecionado");
			String codMapaEstrategico = request.getParameter("codMapaEstrategico");
			request.getSession().setAttribute("codMapaSelecionado",	new Integer(codMapaEstrategico));
			MapaEstrategicoBO mapaEstrategicoBO = new MapaEstrategicoBO();
			MapaEstrategicoTO mapaEstrategicoTO = new MapaEstrategicoTO();
			mapaEstrategicoTO.setCaminhoRel(request.getSession().getServletContext().getRealPath("/relatorios/MapaEstrategicoPrincipal.jasper"));
			mapaEstrategicoTO.setBaseDir(request.getSession().getServletContext().getRealPath(""));
			mapaEstrategicoTO.setId(Integer.parseInt(codMapaEstrategico));
						
			/* Pesquisa da Arvore completa */
			IndicadorBO indicadorBO = new IndicadorBO();
			IndicadorTO indicadorTO = new IndicadorTO();
			Integer codMapa = (Integer) request.getSession().getAttribute("codMapaSelecionado");
			indicadorTO.setIdMapa(codMapa.intValue());
			request.getSession().setAttribute("listaIndicador",indicadorBO.consultarArvoreVisualizacao(indicadorTO));
			JasperPrint jasperRelatorio = mapaEstrategicoBO.mapaEstrategicoRelatorioDetalha(mapaEstrategicoTO);
			request.getSession().setAttribute("relatorio",jasperRelatorio);
			return mapping.findForward("sucesso");
		} catch (Exception e) {
			setErro("bsc.erro.consultar.mapaEstrategico", e.getMessage(),request);
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
			   tarefaTO.setCodMapa(codMapa);
			   tarefaTO.setCodPerspectiva(codPerspectiva);
			   tarefaTO.setCodObjetivo(codObjetivo);
			   tarefaTO.setCodIndicador(codInd);
			   tarefaBO.verificaTarefaEstaVinculada(tarefaTO);
			   tarefaBO.alterar(tarefaTO);
			   
			   request.setAttribute("codMapa",new Integer(codMapa));
			   return mapping.findForward("sucesso");
		   } catch (Exception e) {
			   setErro("bsc.erro.consultar.indicador",e.getMessage(),request);
			   return mapping.findForward("erro");
		   }
	   }
	
	 /*Metodo exclui tarefa relacionada do indicador*/
	 public ActionForward excluirTarefa(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		   try {
			   int codTarefa = Integer.parseInt(request.getParameter("codTarefa"));
			   int ano = Integer.parseInt(request.getParameter("ano"));
			   int codMapa = Integer.parseInt(request.getParameter("codMapa"));
			   TarefaBO tarefaBO = new TarefaBO();
			   TarefaTO tarefaTO = new TarefaTO();
			   tarefaTO.setCodigo(codTarefa);
			   tarefaTO.setAnoCriacao(ano);
			   tarefaBO.excluirTarefaMapa(tarefaTO);
			   request.setAttribute("codMapa",new Integer(codMapa));
			   return mapping.findForward("sucesso");
		   } catch (Exception e) {
			   String lista[] = {"incluir",e.getMessage()};
			   setErro("bsc.erro.indicador",lista,request);
			   return mapping.findForward("erro");
		   }
	   }
	   
		/**
		 * Autor Tiago Trindade Stangarlin Data 11/10/2005 Metodo de consulta mapa
		 * estrategico
		 */
		public ActionForward relatorioMapaCrossTable(ActionMapping mapping,ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {
			try {
				Integer codMapaEstrategico = (Integer) request.getSession().getAttribute("codMapaSelecionado");
				request.getSession().setAttribute("codMapaSelecionado",	new Integer(codMapaEstrategico));
				MapaEstrategicoBO mapaEstrategicoBO = new MapaEstrategicoBO();
				MapaEstrategicoTO mapaEstrategicoTO = new MapaEstrategicoTO();
				mapaEstrategicoTO.setCaminhoRel(request.getSession().getServletContext().getRealPath("/relatorios/MapaEstrategicoPrincipalcrosstable.jasper"));
				mapaEstrategicoTO.setBaseDir(request.getSession().getServletContext().getRealPath(""));
				mapaEstrategicoTO.setId(codMapaEstrategico);
				/*Valida se usuário pertence ao Mapa ou tarefa */
				boolean UsuarioValidado;
				TarefaTO tarefaTO = new TarefaTO();	
				tarefaTO.setCodigo(-99);
				UsuarioValidado = ValidaUsuario.Autoriza(UsuarioBO.getUsuarioTO(response,request) ,mapaEstrategicoTO, tarefaTO );
				
				if (UsuarioValidado == true){
				JasperPrint jasperRelatorio = mapaEstrategicoBO.mapaEstrategicoRelatorioDetalha(mapaEstrategicoTO);
				request.getSession().setAttribute("relatorio",jasperRelatorio);
				return mapping.findForward("sucesso");
				}else{
					setErro("bsc.erro.naoAutorizado", request);
					return mapping.findForward("erro");
				}
			} catch (Exception e) {
				setErro("bsc.erro.consultar.mapaEstrategico", e.getMessage(),request);
				return mapping.findForward("erro");
			}

		}
		
		/**
		 * Autor Tiago Trindade Stangarlin Data 11/10/2005 Metodo de consulta mapa
		 * estrategico
		 */
		public ActionForward relatorioMapaAcoes(ActionMapping mapping,ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {
			try {
				request.getSession().removeAttribute("codMapaSelecionado");
				String codMapaEstrategico = request.getParameter("codMapaEstrategico");
				request.getSession().setAttribute("codMapaSelecionado",	new Integer(codMapaEstrategico));
				MapaEstrategicoBO mapaEstrategicoBO = new MapaEstrategicoBO();
				MapaEstrategicoTO mapaEstrategicoTO = new MapaEstrategicoTO();
				mapaEstrategicoTO.setCaminhoRel(request.getSession().getServletContext().getRealPath("/relatorios/pro/planoAcoes.jasper"));
				mapaEstrategicoTO.setBaseDir(request.getSession().getServletContext().getRealPath(""));
				mapaEstrategicoTO.setId(Integer.parseInt(codMapaEstrategico));
				/*Valida se usuário pertence ao Mapa ou tarefa */
				TarefaTO tarefaTO = new TarefaTO();	
				tarefaTO.setCodigo(-99);
				boolean UsuarioValidado;
				UsuarioValidado = ValidaUsuario.Autoriza(UsuarioBO.getUsuarioTO(response,request) ,mapaEstrategicoTO, tarefaTO );
				if (UsuarioValidado == true){
				JasperPrint jasperRelatorio = mapaEstrategicoBO.mapaEstrategicoRelatorioDetalha(mapaEstrategicoTO);
				request.getSession().setAttribute("relatorio",jasperRelatorio);
				return mapping.findForward("sucesso");
				}else{
					setErro("bsc.erro.naoAutorizado", request);
					return mapping.findForward("erro");
				}
			
				
			} catch (Exception e) {
				setErro("bsc.erro.consultar.mapaEstrategico", e.getMessage(),request);
				return mapping.findForward("erro");
			}

		}
		
		public ActionForward relatorioMapaCronograma(ActionMapping mapping,ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {
			try {
				Integer codMapaEstrategico = (Integer) request.getSession().getAttribute("codMapaSelecionado");
				request.getSession().setAttribute("codMapaSelecionado",	new Integer(codMapaEstrategico));
				MapaEstrategicoBO mapaEstrategicoBO = new MapaEstrategicoBO();
				MapaEstrategicoTO mapaEstrategicoTO = new MapaEstrategicoTO();
				mapaEstrategicoTO.setCaminhoRel(request.getSession().getServletContext().getRealPath("/relatorios/pro/cronograma.jasper"));
				mapaEstrategicoTO.setBaseDir(request.getSession().getServletContext().getRealPath(""));
				mapaEstrategicoTO.setId(codMapaEstrategico);
				/*Valida se usuário pertence ao Mapa ou tarefa */
				boolean UsuarioValidado;
				TarefaTO tarefaTO = new TarefaTO();	
				tarefaTO.setCodigo(-99);
				UsuarioValidado = ValidaUsuario.Autoriza(UsuarioBO.getUsuarioTO(response,request) ,mapaEstrategicoTO, tarefaTO );
				
				if (UsuarioValidado == true){
				JasperPrint jasperRelatorio = mapaEstrategicoBO.mapaEstrategicoRelatorioDetalha(mapaEstrategicoTO);
				request.getSession().setAttribute("relatorio",jasperRelatorio);
				return mapping.findForward("sucesso");
				}else{
					setErro("bsc.erro.naoAutorizado", request);
					return mapping.findForward("erro");
				}
			} catch (Exception e) {
				setErro("bsc.erro.consultar.mapaEstrategico", e.getMessage(),request);
				return mapping.findForward("erro");
			}

		}

        	@SuppressWarnings({ "unused", "unchecked" })
		public ActionForward relatorioMapaGrafico(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
			try {
				
				Integer codMapaEstrategico = (Integer) request.getSession().getAttribute("codMapaSelecionado");
				request.getSession().setAttribute("codMapaSelecionado",	new Integer(codMapaEstrategico));
				MapaEstrategicoBO mapaEstrategicoBO = new MapaEstrategicoBO();
				MapaEstrategicoTO mapaEstrategicoTO = new MapaEstrategicoTO();
				// Conta o número de perspectivas
				mapaEstrategicoTO.setId(codMapaEstrategico);
				MapaEstrategicoTO nomeMapa = mapaEstrategicoBO.consultarUm(mapaEstrategicoTO);
				request.setAttribute("idMapa", nomeMapa.getId());
				request.setAttribute("nomeMapa", nomeMapa.getNome());
				/*Valida se usuário pertence ao Mapa ou tarefa */
				boolean UsuarioValidado;
				TarefaTO tarefaTO = new TarefaTO();	
				tarefaTO.setCodigo(-99);
				UsuarioValidado = ValidaUsuario.Autoriza(UsuarioBO.getUsuarioTO(response,request) ,mapaEstrategicoTO, tarefaTO );
				
				if (UsuarioValidado == true){
				
				mapaEstrategicoTO.setNumPerspectivas(mapaEstrategicoBO.contarPerspectivas(mapaEstrategicoTO).getNumPerspectivas());
				// Calcula as coordenadas x e y das perspectivas
				PerspectivaBO perspectivaBO =  new PerspectivaBO();
				PerspectivaTO perspectivaTO = new PerspectivaTO();
				Collection listaPerspectivas = perspectivaBO.consultarPerspectivaMapaGrafico(perspectivaTO, mapaEstrategicoTO.getId());
				ObjetivoBO objetivoBO = new ObjetivoBO();
				ObjetivoTO objetivoTO = new ObjetivoTO();
				objetivoTO.setIdMapa(codMapaEstrategico);
				Collection listaObjetivos = objetivoBO.consultarObjetivosMapaGrafico(objetivoTO);
				// para melhorar pode modificar-se a maneira de calcular o número de objetivos por pesperctiva
				Collection numeroObjetivos = mapaEstrategicoBO.contarObjetivos(mapaEstrategicoTO);
				Iterator j = numeroObjetivos.iterator();
				Iterator  i = listaPerspectivas.iterator();
				Iterator o = listaObjetivos.iterator();
				int ordem = 0;
				int totalObjetivos = 0;
				int cores[]= {200,0,357,250,20,65,110,150,225};
				HashMap temasAnteriores = new HashMap();
				Iterator j2 = numeroObjetivos.iterator();
				int temasAnterioresn [] = new int[totalObjetivos];
				int proximaCor = 0;
				int larguraMapa = 900;
				int alturaMapa = 1000;
				while (i.hasNext()){
					ordem = ordem +1;
					MapaEstrategicoTO numObjetivo = (MapaEstrategicoTO) j2.next();
					PerspectivaTO perspectiva = (PerspectivaTO) i.next();
					perspectiva.setOrdem(ordem); 
					perspectiva.setXInicialPerspectiva(0);
					perspectiva.setYInicialPerspectiva(((alturaMapa/mapaEstrategicoTO.getNumPerspectivas())*perspectiva.getOrdem())-(alturaMapa/mapaEstrategicoTO.getNumPerspectivas()));
					perspectiva.setXFinalPerspectiva(larguraMapa);
					perspectiva.setYFinalPerspectiva((alturaMapa/mapaEstrategicoTO.getNumPerspectivas())*perspectiva.getOrdem());
					perspectiva.setNumeroObjetivos(numObjetivo.getNumObjetivos());
									
					//Calcula as coordenadas X e Y dos Objetivos
					int idTema = 0;
					int fatorObjetivoInicial = 0;
					int fatorObjetivo = 0;
					
					int verificaCor = -1;
					fatorObjetivoInicial = perspectiva.getXFinalPerspectiva()/(perspectiva.getNumeroObjetivos()+1);
					for (int contador = 0; contador < perspectiva.getNumeroObjetivos(); contador++ ) {
						Boolean jaSetou = false;
						ObjetivoTO objetivo;
						if (perspectiva.getNumeroObjetivos()< 5){
						fatorObjetivo = fatorObjetivo + fatorObjetivoInicial;
						objetivo = (ObjetivoTO) o.next();
						objetivo.setXInicialObjetivo(fatorObjetivo - (600/(perspectiva.getNumeroObjetivos()* 2)));
						objetivo.setYInicialObjetivo(perspectiva.getYInicialPerspectiva()+ ((alturaMapa+800)/(mapaEstrategicoTO.getNumPerspectivas()*5))+(objetivo.getLinha()*15));
						objetivo.setXFinalObjetivo(fatorObjetivo + (600/(perspectiva.getNumeroObjetivos()* 2)));
						objetivo.setYFinalObjetivo(perspectiva.getYFinalPerspectiva()-((alturaMapa+800)/(mapaEstrategicoTO.getNumPerspectivas()*5))+(objetivo.getLinha()*15));
						objetivo.setXCausaEfeito(fatorObjetivo);
						objetivo.setYCausaEfeito(((perspectiva.getYFinalPerspectiva()-perspectiva.getYInicialPerspectiva())/2)+perspectiva.getYInicialPerspectiva()+(objetivo.getLinha()*15));
						idTema = objetivo.getIdTema();
						objetivo.setTamanhoFonte(12);
						}
						else{
						fatorObjetivo = fatorObjetivo + fatorObjetivoInicial;
						objetivo = (ObjetivoTO) o.next();
						objetivo.setXInicialObjetivo(fatorObjetivo - (700/(perspectiva.getNumeroObjetivos()* 2)));
						objetivo.setYInicialObjetivo(perspectiva.getYInicialPerspectiva()+((alturaMapa+800)/(mapaEstrategicoTO.getNumPerspectivas()*5))+(objetivo.getLinha()*15));
						objetivo.setXFinalObjetivo(fatorObjetivo + (700/(perspectiva.getNumeroObjetivos()* 2)));
						objetivo.setYFinalObjetivo(perspectiva.getYFinalPerspectiva()-((alturaMapa+800)/(mapaEstrategicoTO.getNumPerspectivas()*5))+(objetivo.getLinha()*15));
						objetivo.setXCausaEfeito(fatorObjetivo);
						objetivo.setYCausaEfeito(((perspectiva.getYFinalPerspectiva()-perspectiva.getYInicialPerspectiva())/2)+perspectiva.getYInicialPerspectiva()+(objetivo.getLinha()*15));
						idTema = objetivo.getIdTema();
						objetivo.setTamanhoFonte(11);
						}
						if (temasAnteriores.containsKey(String.valueOf(idTema))){
						objetivo.setCorTema(Integer.parseInt((String) temasAnteriores.get(String.valueOf(idTema))));	
						}else{
							int corTema;
							if (proximaCor >= cores.length){
								corTema = cores[0] + proximaCor*3; 
							}else{
							corTema = cores[proximaCor];
							}
							proximaCor++;
							
							objetivo.setCorTema(corTema);						
							temasAnteriores.put(String.valueOf(idTema), String.valueOf(corTema));
						}
					}
				}
				//Cria a coleção dos temas 
				Iterator o2 = listaObjetivos.iterator();
				CausaEfeitoBO causaEfeitoBO = new CausaEfeitoBO();
				CausaEfeitoTO causaEfeitoTO = new CausaEfeitoTO();
				int numCausaEfeitos = 0;
				Collection listaDestinoCausaEfeito = new ArrayList();
				while (o2.hasNext()){
					ObjetivoTO objetivo = (ObjetivoTO) o2.next();
					causaEfeitoTO.setCausaId(objetivo.getId());
					Collection listaCausaEfeito = causaEfeitoBO.consultarEfeitosObjetivo(causaEfeitoTO);
					Iterator c = listaCausaEfeito.iterator();
					while (c.hasNext()){
					CausaEfeitoTO causaEfeito = (CausaEfeitoTO) c.next();
					CausaEfeitoTO destinoTO = new CausaEfeitoTO();
					destinoTO.setCausaId(causaEfeito.getCausaId());
					destinoTO.setEfeitoId(causaEfeito.getEfeitoId());
					destinoTO.setIntensidade(causaEfeito.getIntensidade());
					destinoTO.setInteracao(causaEfeito.getInteracao());
					destinoTO.setNomeObjetivo(causaEfeito.getNomeObjetivo());
					listaDestinoCausaEfeito.add(destinoTO);
					numCausaEfeitos = numCausaEfeitos +1;
					}
				}
					// Retorna as listas como parametro para o jsp que executara o applet
					if (!listaDestinoCausaEfeito.isEmpty()){
		   				request.setAttribute("listaCausaEfeito",listaDestinoCausaEfeito);
		   				request.setAttribute("numCauEfe", numCausaEfeitos);
		   			}else{
		   				request.setAttribute("listaVaziaCausaefeito",new Integer(1));
		   				request.setAttribute("numCauEfe", numCausaEfeitos);
		   			}
					if (!listaObjetivos.isEmpty()){
		   				request.setAttribute("listaObjetivos",listaObjetivos);
		   			}else{
		   				request.setAttribute("listaVaziaObjetivos",new Integer(1));
		   			}
					if (!listaPerspectivas.isEmpty()){
		   				request.setAttribute("listaPerspectivas",listaPerspectivas);
		   				request.setAttribute("numeroPerspectivas",mapaEstrategicoTO.getNumPerspectivas());
		   			}else{
		   				request.setAttribute("listaVaziaPerspectivas",new Integer(1));
		   			}
				return mapping.findForward("applet");
				}else{
					setErro("bsc.erro.naoAutorizado", request);
					return mapping.findForward("erro");		
				}
				
			} catch (Exception e) {
				setErro("bsc.erro",e.getMessage(),request);
				return mapping.findForward("erro");
			}
		}
		
            /**
             * Metodo que executa a exportação do XML de uma determinado MapaEstrategico 
             */
            @SuppressWarnings({"unchecked" })
        	public ActionForward exportarXml(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
            	ExportarXML exportXML = new ExportarXML();
            	MapaEstrategicoTO to = new MapaEstrategicoTO();
            	MapaEstrategicoForm mapaForm = (MapaEstrategicoForm) form;
            	to.setId(mapaForm.getId());
            	to = new MapaEstrategicoBO().consultarUm(to);
            	response.setContentType("text/xml");
            	response.setHeader("Content-Disposition", "attachment; filename=\""+ to.getNome()+"\"");
            	exportXML.exportarXML(to, response.getOutputStream());
    			
            	return null;
            }
            
            /**
             * Metodo de importar um Mapa 
             * @throws IOException 
             */
            public ActionForward importarXml(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws IOException{
            	MapaEstrategicoForm mapaForm = (MapaEstrategicoForm) form;
            	try {
					new ImportarXml(mapaForm.getFileImportar().getInputStream());
				} catch (Exception e) {
					PrintWriter out = response.getWriter();
					out.print("errojson - "+e.getMessage());
					return null;
				}
            	return mapping.findForward("sucesso");
				
            }
    }
