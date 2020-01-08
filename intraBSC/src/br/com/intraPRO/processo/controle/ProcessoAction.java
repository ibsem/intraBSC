
package br.com.intraPRO.processo.controle;

import java.io.File;
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
import org.wfmc.xpdl.v2.PackageDocument;
import org.wfmc.xpdl.v2.PackageType;
import org.wfmc.xpdl.v2.ProcessType;
import org.wfmc.xpdl.v2.ActivityDocument.Activity;
import org.wfmc.xpdl.v2.ActivitySetDocument.ActivitySet;
import org.wfmc.xpdl.v2.ActivitySetsDocument.ActivitySets;
import org.wfmc.xpdl.v2.PoolDocument.Pool;
import org.wfmc.xpdl.v2.TransitionDocument.Transition;
import org.wfmc.xpdl.v2.WorkflowProcessesDocument.WorkflowProcesses;
import org.wfmc.xpdl.v2.impl.PackageDocumentImpl;

import br.com.intraBSC.XML.ExportarXML;
import br.com.intraBSC.mapaEstrategico.visao.MapaEstrategicoForm;
import br.com.intraBSC.modelo.MapaEstrategicoTO;
import br.com.intraBSC.modelo.UsuarioTO;
import br.com.intraBSC.negocio.MapaEstrategicoBO;
import br.com.intraBSC.negocio.UsuarioBO;
import br.com.intraPRO.controle.DispatchActionPRO;
import br.com.intraPRO.modelo.AtividadeTO;
import br.com.intraPRO.modelo.ConfigTarefaTO;
import br.com.intraPRO.modelo.FaseTO;
import br.com.intraPRO.modelo.ProcessoTO;
import br.com.intraPRO.modelo.TarefaTO;
import br.com.intraPRO.modelo.TransicaoTO;
import br.com.intraPRO.negocio.AtividadeBO;
import br.com.intraPRO.negocio.FaseBO;
import br.com.intraPRO.negocio.ProcessoBO;
import br.com.intraPRO.negocio.TarefaBO;
import br.com.intraPRO.negocio.TransicaoBO;
import br.com.intraPRO.processo.visao.ProcessoForm;
import br.com.intraPRO.util.Util;

/**
 * @author Tiago Trindade Stangarlin 04/02/2005
 */
public class ProcessoAction extends DispatchActionPRO {
	
	/**
	 * Autor Tiago Trindade Stangarlin Data 11/10/2005 Metodo de consulta processo
	 * estrategico (Utilizado na 1 tela.)
	 */
	public ActionForward consultarProcessoUsuario(ActionMapping mapping,ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {
		try {
			//Remove da sessao a lista de arvore da ferramenta de configuracao
			request.getSession().removeAttribute("arvoreConfiguracao");
			request.getSession().removeAttribute("listaProcesso");
			ProcessoBO processoBO = new ProcessoBO();
			ProcessoTO processoTO = new ProcessoTO();
			UsuarioTO usuario = UsuarioBO.getUsuarioTO(response,request);
			processoTO.setIdUsuario(usuario.getIdUsuario());
			Collection listaProcesso = processoBO.consultarProcessoUsuario(processoTO);
			if (!listaProcesso.isEmpty())
				request.getSession().setAttribute("listaProcesso",listaProcesso);
			else
				setMensagem("bsc.processo.vazio", request);
			return mapping.findForward("sucesso");
		} catch (Exception e) {
			setErro("bsc.erro.consultar.processo", e.getMessage(),request);
			return mapping.findForward("erro");
		}

	}

	/**
	 * Autor Tiago Trindade Stangarlin Data 11/10/2005 Metodo de consulta processo
	 * estrategico
	 */
	public ActionForward processoUsuarioRelatorioDetalha(ActionMapping mapping,ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {
		try {
			request.getSession().removeAttribute("codProcessoSelecionado");
			String codProcesso = request.getParameter("codProcesso");
			request.getSession().setAttribute("codProcessoSelecionado",	new Integer(codProcesso));
			ProcessoBO processoBO = new ProcessoBO();
			ProcessoTO processoTO = new ProcessoTO();
			processoTO.setTransicaoRel(request.getSession().getServletContext().getRealPath("/relatorios/ProcessoPrincipal.jasper"));
			processoTO.setBaseDir(request.getSession().getServletContext().getRealPath(""));
			processoTO.setId(Integer.parseInt(codProcesso));
			
			/* Pesquisa da Arvore completa */
			Integer codProc = (Integer) request.getSession().getAttribute("codProcessoSelecionado");

			JasperPrint jasperRelatorio = processoBO.processoRelatorioDetalha(processoTO);
			request.getSession().setAttribute("relatorio",jasperRelatorio);
			return mapping.findForward("sucesso");
		} catch (Exception e) {
			setErro("bsc.erro.consultar.processo", e.getMessage(),request);
			return mapping.findForward("erro");
		}

	}
    /**
     * Metodo que executa a importação do XML de uma determinado Processo criado em padrão XPDL
     */
    @SuppressWarnings({ "unused", "unchecked" })
public ActionForward importarXPDL(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
    	ConfigTarefaTO configTarefaTO = new ConfigTarefaTO();
    	ProcessoForm processoForm = (ProcessoForm) form;
    	String nomeArquivo = processoForm.getCaminho();
     	PackageDocument pkg = PackageDocument.Factory.parse(new File(nomeArquivo));
    	ProcessType[] processos =pkg.getPackage().getWorkflowProcesses().getWorkflowProcessArray();
    	final Pool[] pools = pkg.getPackage().getPools().getPoolArray();
    	ProcessoBO processoBO = new ProcessoBO();
		AtividadeBO atividadeBO = new AtividadeBO();
		// Lê o array e grava nas tabelas de processo, atividade e transição
    	for (int i = 1; i < processos.length; i++) {
    		ProcessoTO processoTO = new ProcessoTO();
    		for (int j = 0; j < pools.length; j++) {
				if (processos[i].getId().equals(pools[j].getProcess())) {
					processoTO.setNome(pools[j].getName());
					break;
				}
			}
    		processoTO.setAtivo(1);
    		processoTO.setIdResponsavel(processoForm.getIdResponsavel());
    		processoBO.incluir(processoTO);
    		processoTO = processoBO.consultarUm(processoTO);
			ActivitySet[] sets= processos[i].getActivitySets().getActivitySetArray();
			for (int j = 0; j < sets.length; j++) {
				Activity[] atividades=sets[j].getActivities().getActivityArray();
				for (int k = 0; k < atividades.length; k++) {
					AtividadeTO atividadeTO = new AtividadeTO();
					atividadeTO.setNome(atividades[k].getName());
					atividadeTO.setIdProcesso(processoTO.getId());
					atividadeTO.setAtivo(1);
					atividadeTO.setDescricao(atividades[k].getDescription().getStringValue());
					atividadeTO.setResponsavel(1);
					atividadeBO.incluir(atividadeTO);
				}
			}
			Transition[] transicoes=processos[i].getTransitions().getTransitionArray();
			for (int l = 0; l < sets.length; l++) {
				TransicaoTO transicaoTO = new TransicaoTO();
				
			}
		
    	
    	}
    	//atividadeTO.setNome(pkg.getPackage().getWorkflowProcesses().getWorkflowProcessArray(1).getActivitySets().getActivitySetArray(0).getActivities().getActivityArray(0).getName());
    	
    	
    	return null;
    }
    	

	
	
	/**
	 * Autor Tiago Trindade Stangarlin Data 11/10/2005 Metodo de consulta processo
	 * estrategico
	 */
	public ActionForward incluir(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
		try {
			request.getSession().removeAttribute("codProcessoSelecionado");
			request.getSession().removeAttribute("listaProcesso");
			ProcessoBO processoBO = new ProcessoBO();
			ProcessoTO processoTO = new ProcessoTO();
			ProcessoForm processoForm = (ProcessoForm) form;
			processoTO.setId(processoForm.getId());
			processoTO.setAtivo(processoForm.getAtivo());
			processoTO.setNome(processoForm.getNome());
			processoTO.setIdResponsavel(processoForm.getIdResponsavel());
			processoBO.incluir(processoTO);
			setMensagem("pro.mensagem.incluir",request);
			Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),processoTO.getId());
			return mapping.findForward("sucesso");
		} catch (Exception e) {
			String erros[] = {"Incluir",e.getMessage()};
			setErro("bsc.erro.processo",erros,request);
			return mapping.findForward("erro");
		}
	}

	/**
	 * Autor Tiago Trindade Stangarlin Data 11/10/2005 Metodo de consulta processo
	 * estrategico
	 */
	public ActionForward alterar(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
		try {
			request.getSession().removeAttribute("codProcessoSelecionado");
			request.getSession().removeAttribute("listaProcesso");
			ProcessoBO processoBO = new ProcessoBO();
			ProcessoTO processoTO = new ProcessoTO();
			ProcessoForm processoForm = (ProcessoForm) form;
			processoTO.setId(processoForm.getId());
			processoTO.setAtivo(processoForm.getAtivo());
			processoTO.setIdResponsavel(processoForm.getIdResponsavel());
			processoTO.setNome(processoForm.getNome());
			processoBO.alterar(processoTO);
			
			/* Pesquisa da Arvore completa */
			processoTO.setId(processoForm.getId());
			request.getSession().removeAttribute("arvoreConfiguracao");
			Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),processoForm.getId());
			setMensagem("bsc.mensagem.sucesso",request);
			return mapping.findForward("sucesso");
		} catch (Exception e) {
			 setErro("bsc.erro",e.getMessage(),request);
			return mapping.findForward("erro");
		}
	}
	
	/**
	 * Autor Tiago Trindade Stangarlin Data 11/10/2005 Metodo de consulta processo
	 * estrategico
	 */
	public ActionForward consultarVarios(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
		try {
			request.getSession().removeAttribute("codProcessoSelecionado");
			ProcessoBO processoBO = new ProcessoBO();
			ProcessoTO processoTO = new ProcessoTO();
			ProcessoForm processoForm = (ProcessoForm) form;
			processoTO.setNome(processoForm.getNome());
			processoTO.setAtivo(processoForm.getAtivo());
			processoTO.setIdResponsavel(UsuarioBO.getUsuarioTO().getIdUsuario());
			request.setAttribute("listaProcesso",processoBO.consultarVarios(processoTO));
			return mapping.findForward("sucessoConsulta");
		} catch (Exception e) {
			setErro("bsc.erro",e.getMessage(),request);
			return mapping.findForward("erro");
		}
	}
	

	/**
	 * Autor Tiago Trindade Stangarlin Data 11/10/2005 Metodo de consulta processo
	 * estrategico
	 */
	public ActionForward consultarUm(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
		try {
			request.getSession().removeAttribute("codProcessoSelecionado");
			request.getSession().removeAttribute("listaProcesso");
			ProcessoBO processoBO = new ProcessoBO();
			ProcessoTO processoTO = new ProcessoTO();
			ProcessoForm processoForm = (ProcessoForm) form;
			processoTO.setId(processoForm.getId());
			request.setAttribute("processoForm",processoBO.consultarUm(processoTO));
			// erro 
			//Se usuario nao 'e participante nao pode acessar a atividade.
			  if ((processoTO.getIdUsuario() != UsuarioBO.getUsuarioTO().getIdUsuario())&&(!UsuarioBO.getUsuarioTO().getPerfil().equals("administrador"))) {
				   setErro("pro.mensagem.autorizacao", "", request);
					return mapping.findForward("erro");
			  }
			
			/*Consultar Responsavel*/
		    UsuarioBO usuarioBO = new UsuarioBO();
		    UsuarioTO usuarioTO = new UsuarioTO();
		    usuarioTO.setGrupoTO(UsuarioBO.getUsuarioTO().getGrupoTO());
		    request.setAttribute("listaResponsavel",usuarioBO.consultarVarios(usuarioTO));
		    Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),processoForm.getId());
		    
		    /*Recupera Tarefas do usuario logado*/
		    UsuarioTO usuario = UsuarioBO.getUsuarioTO(response,request);
		    TarefaTO tarefaTO = new TarefaTO();
		    tarefaTO.setCodUsuSolicitante(usuario.getIdUsuario());
		    Util.consultarTarefaProcessoConfiguracao(tarefaTO, request, response);
		    
		    /*Recupera Tarefas vinculadas a um determinado Processo*/
			tarefaTO.setCodProc(processoTO.getId());
			request.getSession().setAttribute("listaTarefasProcesso",processoBO.consultarTarefaFerramentaConfiguracao(tarefaTO));
		    
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
			request.getSession().removeAttribute("codProcessoSelecionado");
			request.getSession().removeAttribute("listaProcesso");
			/* Pesquisa da Arvore completa */
			Integer codProcesso = Integer.valueOf(request.getParameter("codProcesso"));
			String nomeProcesso = request.getParameter("nomeProcesso");
			request.getSession().setAttribute("codProcessoArvoreConfiguracao",codProcesso);
			request.getSession().setAttribute("nomeProcessoVigente",nomeProcesso);
			
			Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codProcesso);
			return mapping.findForward("sucessoArvore");
		} catch (Exception e) {
			setErro("bsc.erro",e.getMessage(),request);
			return mapping.findForward("erro");
		}
	}
	
	//Metodo referente a tela principal do sistema.	
	public ActionForward telaPrincipal(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
		try {
			
			/*Parte referente aos Processo do usuario*/
			request.getSession().removeAttribute("arvoreConfiguracao");
			request.getSession().removeAttribute("listaProcesso");
			ProcessoBO processoBO = new ProcessoBO();
			ProcessoTO processoTO = new ProcessoTO();
			UsuarioTO usuario = UsuarioBO.getUsuarioTO(response,request);
			processoTO.setAtivo(1);
			processoTO.setIdUsuario(usuario.getIdUsuario());
			Collection listaProcesso = processoBO.consultarProcessoUsuario(processoTO);
			if (!listaProcesso.isEmpty())
				request.getSession().setAttribute("listaProcesso",listaProcesso);
			else
				setMensagem("bsc.processo.vazio", request);
			
			/*Parte referente as Tarefas do usuario*/
			Util.atualizaArvoreTarefa(request,response);
			
			/*Parte referente os Indicadores do usuario*/
			request.getSession().setAttribute("codUsuarioSelecionado",new Integer(usuario.getIdUsuario()));
			
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
	
	public ActionForward encaminhaImportarXPDL(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
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
	public ActionForward processoCrossTable(ActionMapping mapping,ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {
		try {
			request.getSession().removeAttribute("codProcessoSelecionado");
			String codProcesso = request.getParameter("codProcesso");
			request.getSession().setAttribute("codProcessoSelecionado",	new Integer(codProcesso));
			ProcessoBO processoBO = new ProcessoBO();
			ProcessoTO processoTO = new ProcessoTO();
			processoTO.setTransicaoRel(request.getSession().getServletContext().getRealPath("/relatorios/ProcessoPrincipal.jasper"));
			processoTO.setBaseDir(request.getSession().getServletContext().getRealPath(""));
			processoTO.setId(Integer.parseInt(codProcesso));
			
			/* Pesquisa da Arvore completa */
			Integer codProc = (Integer) request.getSession().getAttribute("codProcessoSelecionado");
			JasperPrint jasperRelatorio = processoBO.processoRelatorioDetalha(processoTO);
			request.getSession().setAttribute("relatorio",jasperRelatorio);
			return mapping.findForward("sucesso");
		} catch (Exception e) {
			setErro("bsc.erro.consultar.processo", e.getMessage(),request);
			return mapping.findForward("erro");
		}

	}
	
	public ActionForward vincularTarefa(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		   try {
			   int codTarefa = Integer.parseInt(request.getParameter("codTarefa"));
			   int codProcesso = Integer.parseInt(request.getParameter("codProcesso"));
			   TarefaBO tarefaBO = new TarefaBO();
			   TarefaTO tarefaTO = new TarefaTO();
			   tarefaTO.setCodigo(codTarefa);
			   tarefaTO.setAnoCriacao(tarefaBO.consultarUm(tarefaTO).getAnoCriacao());
			   tarefaTO.setCodProc(codProcesso);
			   tarefaBO.verificaTarefaEstaVinculada(tarefaTO);
			   tarefaBO.alterar(tarefaTO);
			   
			   request.setAttribute("codProcesso",new Integer(codProcesso));
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
			   int codProcesso = Integer.parseInt(request.getParameter("codProcesso"));
			   TarefaBO tarefaBO = new TarefaBO();
			   TarefaTO tarefaTO = new TarefaTO();
			   tarefaTO.setCodigo(codTarefa);
			   tarefaTO.setAnoCriacao(ano);
			   tarefaBO.excluirTarefaProcesso(tarefaTO);
			   request.setAttribute("codProcesso",new Integer(codProcesso));
			   return mapping.findForward("sucesso");
		   } catch (Exception e) {
			   String lista[] = {"incluir",e.getMessage()};
			   setErro("bsc.erro.indicador",lista,request);
			   return mapping.findForward("erro");
		   }
	   }
	   
		/**
		 * Autor Tiago Trindade Stangarlin Data 11/10/2005 Metodo de consulta processo
		 * estrategico
		 */
		public ActionForward relatorioProcessoCrossTable(ActionMapping mapping,ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {
			try {
				Integer codProcesso = (Integer) request.getSession().getAttribute("codProcessoSelecionado");
				request.getSession().setAttribute("codProcessoSelecionado",	new Integer(codProcesso));
				ProcessoBO processoBO = new ProcessoBO();
				ProcessoTO processoTO = new ProcessoTO();
				processoTO.setTransicaoRel(request.getSession().getServletContext().getRealPath("/relatorios/ProcessoPrincipalcrosstable.jasper"));
				processoTO.setBaseDir(request.getSession().getServletContext().getRealPath(""));
				processoTO.setId(codProcesso);
			
				JasperPrint jasperRelatorio = processoBO.processoRelatorioDetalha(processoTO);
				request.getSession().setAttribute("relatorio",jasperRelatorio);
				return mapping.findForward("sucesso");
			} catch (Exception e) {
				setErro("bsc.erro.consultar.processo", e.getMessage(),request);
				return mapping.findForward("erro");
			}

		}
		
		/**
		 * Autor Tiago Trindade Stangarlin Data 11/10/2005 Metodo de consulta processo
		 * estrategico
		 */
		public ActionForward relatorioProcessoAcoes(ActionMapping mapping,ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {
			try {
				Integer codProcesso = (Integer) request.getSession().getAttribute("codProcessoSelecionado");
				request.getSession().setAttribute("codProcessoSelecionado",	new Integer(codProcesso));
				ProcessoBO processoBO = new ProcessoBO();
				ProcessoTO processoTO = new ProcessoTO();
				processoTO.setTransicaoRel(request.getSession().getServletContext().getRealPath("/relatorios/pro/planoAcoes.jasper"));
				processoTO.setBaseDir(request.getSession().getServletContext().getRealPath(""));
				processoTO.setId(codProcesso);
			
				JasperPrint jasperRelatorio = processoBO.processoRelatorioDetalha(processoTO);
				request.getSession().setAttribute("relatorio",jasperRelatorio);
				return mapping.findForward("sucesso");
			} catch (Exception e) {
				setErro("bsc.erro.consultar.processo", e.getMessage(),request);
				return mapping.findForward("erro");
			}

		}
		
		public ActionForward relatorioProcessoCronograma(ActionMapping mapping,ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {
			try {
				Integer codProcesso = (Integer) request.getSession().getAttribute("codProcessoSelecionado");
				request.getSession().setAttribute("codProcessoSelecionado",	new Integer(codProcesso));
				ProcessoBO processoBO = new ProcessoBO();
				ProcessoTO processoTO = new ProcessoTO();
				processoTO.setTransicaoRel(request.getSession().getServletContext().getRealPath("/relatorios/pro/cronograma.jasper"));
				processoTO.setBaseDir(request.getSession().getServletContext().getRealPath(""));
				processoTO.setId(codProcesso);
			
				JasperPrint jasperRelatorio = processoBO.processoRelatorioDetalha(processoTO);
				request.getSession().setAttribute("relatorio",jasperRelatorio);
				return mapping.findForward("sucesso");
			} catch (Exception e) {
				setErro("bsc.erro.consultar.processo", e.getMessage(),request);
				return mapping.findForward("erro");
			}

		}

        	@SuppressWarnings({ "unused", "unchecked" })
		public ActionForward relatorioProcessoGrafico(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
			try {
				
				Integer codProcesso = (Integer) request.getSession().getAttribute("codProcessoSelecionado");
				request.getSession().setAttribute("codProcessoSelecionado",	new Integer(codProcesso));
				ProcessoBO processoBO = new ProcessoBO();
				ProcessoTO processoTO = new ProcessoTO();
				// Conta o número de fases
				processoTO.setId(codProcesso);
				ProcessoTO nomeProcesso = processoBO.consultarUm(processoTO);
				request.setAttribute("idProcesso", nomeProcesso.getId());
				request.setAttribute("nomeProcesso", nomeProcesso.getNome());
				processoTO.setNumFases(processoBO.contarFases(processoTO).getNumFases());
				// Calcula as coordenadas x e y das fases
				FaseBO faseBO =  new FaseBO();
				FaseTO faseTO = new FaseTO();
				Collection listaFases = faseBO.consultarFaseProcessoGrafico(faseTO, processoTO.getId());
				AtividadeBO atividadeBO = new AtividadeBO();
				AtividadeTO atividadeTO = new AtividadeTO();
				atividadeTO.setIdProcesso(codProcesso);
				Collection listaAtividades = atividadeBO.consultarAtividadesProcessoGrafico(atividadeTO);
				// para melhorar pode modificar-se a maneira de calcular o número de atividades por pesperctiva
				Collection numeroAtividades = processoBO.contarAtividades(processoTO);
				Iterator j = numeroAtividades.iterator();
				Iterator  i = listaFases.iterator();
				Iterator o = listaAtividades.iterator();
				int ordem = 0;
				int totalAtividades = 0;
				int cores[]= {200,0,357,250,20,65,110,150,225};
				HashMap temasAnteriores = new HashMap();
				Iterator j2 = numeroAtividades.iterator();
				int temasAnterioresn [] = new int[totalAtividades];
				int proximaCor = 0;
				int larguraProcesso = 794;
				int alturaProcesso = 500;
				while (i.hasNext()){
					ordem = ordem +1;
					ProcessoTO numAtividade = (ProcessoTO) j2.next();
					FaseTO fase = (FaseTO) i.next();
					fase.setOrdem(ordem); 
					fase.setXInicialFase(0);
					fase.setYInicialFase(((alturaProcesso/processoTO.getNumFases())*fase.getOrdem())-(alturaProcesso/processoTO.getNumFases()));
					fase.setXFinalFase(larguraProcesso);
					fase.setYFinalFase((alturaProcesso/processoTO.getNumFases())*fase.getOrdem());
					fase.setNumeroAtividades(numAtividade.getNumAtividades());
									
					//Calcula as coordenadas X e Y dos Atividades
					int idTema = 0;
					int fatorAtividadeInicial = 0;
					int fatorAtividade = 0;
					
					int verificaCor = -1;
					fatorAtividadeInicial = fase.getXFinalFase()/(fase.getNumeroAtividades()+1);
					for (int contador = 0; contador < fase.getNumeroAtividades(); contador++ ) {
						Boolean jaSetou = false;
						AtividadeTO atividade;
						if (fase.getNumeroAtividades()< 5){
						fatorAtividade = fatorAtividade + fatorAtividadeInicial;
						atividade = (AtividadeTO) o.next();
						atividade.setXInicialAtividade(fatorAtividade - (500/(fase.getNumeroAtividades()* 2)));
						atividade.setYInicialAtividade(fase.getYInicialFase()+ ((alturaProcesso+300)/(processoTO.getNumFases()*5))+(atividade.getLinha()*15));
						atividade.setXFinalAtividade(fatorAtividade + (500/(fase.getNumeroAtividades()* 2)));
						atividade.setYFinalAtividade(fase.getYFinalFase()-((alturaProcesso+300)/(processoTO.getNumFases()*5))+(atividade.getLinha()*15));
						atividade.setXTransicao(fatorAtividade);
						atividade.setYTransicao(((fase.getYFinalFase()-fase.getYInicialFase())/2)+fase.getYInicialFase()+(atividade.getLinha()*15));
						//idTema = atividade.getIdTema();
						atividade.setTamanhoFonte(10);
						}
						else{
						fatorAtividade = fatorAtividade + fatorAtividadeInicial;
						atividade = (AtividadeTO) o.next();
						atividade.setXInicialAtividade(fatorAtividade - (600/(fase.getNumeroAtividades()* 2)));
						atividade.setYInicialAtividade(fase.getYInicialFase()+((alturaProcesso+400)/(processoTO.getNumFases()*5))+(atividade.getLinha()*15));
						atividade.setXFinalAtividade(fatorAtividade + (600/(fase.getNumeroAtividades()* 2)));
						atividade.setYFinalAtividade(fase.getYFinalFase()-((alturaProcesso+400)/(processoTO.getNumFases()*5))+(atividade.getLinha()*15));
						atividade.setXTransicao(fatorAtividade);
						atividade.setYTransicao(((fase.getYFinalFase()-fase.getYInicialFase())/2)+fase.getYInicialFase()+(atividade.getLinha()*15));
						//idTema = atividade.getIdTema();
						atividade.setTamanhoFonte(9);
						}
						if (temasAnteriores.containsKey(String.valueOf(idTema))){
						atividade.setCorTema(Integer.parseInt((String) temasAnteriores.get(String.valueOf(idTema))));	
						}else{
							int corTema;
							if (proximaCor >= cores.length){
								corTema = cores[0] + proximaCor*3; 
							}else{
							corTema = cores[proximaCor];
							}
							proximaCor++;
							
							atividade.setCorTema(corTema);						
							temasAnteriores.put(String.valueOf(idTema), String.valueOf(corTema));
						}
					}
				}
				//Cria a coleção dos temas 
				Iterator o2 = listaAtividades.iterator();
				TransicaoBO transicaoBO = new TransicaoBO();
				TransicaoTO transicaoTO = new TransicaoTO();
				int numTransicaos = 0;
				Collection listaDestinoTransicao = new ArrayList();
				while (o2.hasNext()){
					AtividadeTO atividade = (AtividadeTO) o2.next();
					transicaoTO.setPreCondicaoId(atividade.getId());
					Collection listaTransicao = transicaoBO.consultarPosCondicaosAtividade(transicaoTO);
					Iterator c = listaTransicao.iterator();
					while (c.hasNext()){
					TransicaoTO transicao = (TransicaoTO) c.next();
					TransicaoTO destinoTO = new TransicaoTO();
					destinoTO.setPreCondicaoId(transicao.getPreCondicaoId());
					destinoTO.setPosCondicaoId(transicao.getPosCondicaoId());
					destinoTO.setIntensidade(transicao.getIntensidade());
					destinoTO.setInteracao(transicao.getInteracao());
					destinoTO.setNomeAtividade(transicao.getNomeAtividade());
					listaDestinoTransicao.add(destinoTO);
					numTransicaos = numTransicaos +1;
					}
				}
					// Retorna as listas como parametro para o jsp que executara o applet
					if (!listaDestinoTransicao.isEmpty()){
		   				request.setAttribute("listaTransicao",listaDestinoTransicao);
		   				request.setAttribute("numCauEfe", numTransicaos);
		   			}else{
		   				request.setAttribute("listaVaziaPreCondicaoefeito",new Integer(1));
		   				request.setAttribute("numCauEfe", numTransicaos);
		   			}
					if (!listaAtividades.isEmpty()){
		   				request.setAttribute("listaAtividades",listaAtividades);
		   			}else{
		   				request.setAttribute("listaVaziaAtividades",new Integer(1));
		   			}
					if (!listaFases.isEmpty()){
		   				request.setAttribute("listaFases",listaFases);
		   				request.setAttribute("numeroFases",processoTO.getNumFases());
		   			}else{
		   				request.setAttribute("listaVaziaFases",new Integer(1));
		   			}
				return mapping.findForward("applet");
			} catch (Exception e) {
				setErro("bsc.erro",e.getMessage(),request);
				return mapping.findForward("erro");
			}
		}
		
            	
    }
		

