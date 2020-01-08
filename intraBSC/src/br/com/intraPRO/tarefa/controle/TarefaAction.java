package br.com.intraPRO.tarefa.controle;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.intraBSC.excecoes.ExceptionNegocioBSC;
import br.com.intraBSC.modelo.IndicadorTO;
import br.com.intraBSC.modelo.MapaEstrategicoTO;
import br.com.intraBSC.modelo.ObjetivoTO;
import br.com.intraBSC.modelo.PerspectivaTO;
import br.com.intraBSC.modelo.UsuarioTO;
import br.com.intraBSC.negocio.MapaEstrategicoBO;
import br.com.intraBSC.negocio.UsuarioBO;
import br.com.intraBSC.util.DataUtil;
import br.com.intraBSC.util.ImprimirRelatorioAction;
import br.com.intraPRO.controle.DispatchActionPRO;
import br.com.intraPRO.modelo.AnexoTO;
import br.com.intraPRO.modelo.AnotacaoTarefaTO;
import br.com.intraPRO.modelo.ConfigTarefaTO;
import br.com.intraPRO.modelo.ConteudoFormularioTarefaTO;
import br.com.intraPRO.modelo.ConteudoItemTarefaTO;
import br.com.intraPRO.modelo.ParticipanteTO;
import br.com.intraPRO.modelo.TarefaTO;
import br.com.intraPRO.negocio.AnexoBO;
import br.com.intraPRO.negocio.AnotacaoTarefaBO;
import br.com.intraPRO.negocio.ConfigTarefaBO;
import br.com.intraPRO.negocio.ConteudoFormularioTarefaBO;
import br.com.intraPRO.negocio.ConteudoItemTarefaBO;
import br.com.intraPRO.negocio.ParticipanteBO;
import br.com.intraPRO.negocio.TarefaBO;
import br.com.intraPRO.tarefa.visao.TarefaForm;
import br.com.intraPRO.util.QSortAlgorithm;
import br.com.intraPRO.util.Util;

/**
 * Classe de controle da tarefa.
 */
public class TarefaAction extends DispatchActionPRO {

	public TarefaAction() {
	}

	
	public ActionForward alterarStatusModificado(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {		
		try{
			TarefaTO tarefaTO = new TarefaTO();
			if (request.getAttribute("codigo") != null) {
				tarefaTO.setCodigo(Integer.parseInt(request.getAttribute("codigo").toString()));
				tarefaTO.setAnoCriacao(Integer.parseInt(request.getAttribute("anoCriacao").toString()));
			} else if(request.getParameter("codigo")!=null) {
				tarefaTO.setCodigo(Integer.parseInt(request.getParameter("codigo")));
				tarefaTO.setAnoCriacao(Integer.parseInt(request.getParameter("anoCriacao")));
			}
			TarefaBO tarefaBO = new TarefaBO();
			if (tarefaBO.consultarUm(tarefaTO).getCodConfigTarefa() == 0){
				throw new Exception("pro.configTarefa.listaVaiza");
			}
			ParticipanteTO participanteTO = new ParticipanteTO();
			ParticipanteBO participanteBO = new ParticipanteBO();
			participanteTO.setAnoCriacao(tarefaTO.getAnoCriacao());
			participanteTO.setCodTarefa(tarefaTO.getCodigo());
			
			Collection listaParticipante = participanteBO.consultarVarios(participanteTO);
			Iterator iter = listaParticipante.iterator();
			boolean usuParticipante = true;
			while (iter.hasNext()){
				ParticipanteTO element = (ParticipanteTO) iter.next();
				participanteTO.setCodigo(element.getCodigo());
				if (element.getCodUsuario() == UsuarioBO.getUsuarioTO().getIdUsuario()){
					participanteTO.setCodNivel(1);
					participanteBO.alterar(participanteTO);
					usuParticipante = true;
					break;
				} else {
					usuParticipante = false;
				}
			}
			//Se usuario nao 'e participante nao pode acessar a atividade.
			if (usuParticipante == false) {
				setErro("pro.mensagem.autorizacao", "", request);
				return mapping.findForward("erro");
			}
			//encaminharAlterar(mapping,form,request,response);Estava chamando o encaminharAlterar 2x
		} catch (Exception e) {
			log.error(e.getMessage());
			setErro("pro.erro.tarefa.encaminhar.alterar", e.getMessage(), request);
			return mapping.findForward("erro");
		}
		return mapping.findForward("sucesso");
	}
	
	private void removerTarefaSessao(HttpServletRequest request){
		request.getSession().removeAttribute("executantes");
		request.getSession().removeAttribute("listaCritica");
		request.getSession().removeAttribute("itemsCriticos");
		request.getSession().removeAttribute("formulariosCriticos");
		request.getSession().removeAttribute("tarefaDepoisAlterar");
		request.getSession().removeAttribute("tarefaTO");
		request.getSession().removeAttribute("listaAnexos");
		request.getSession().removeAttribute("listaAnotacao");
	}
	
	public ActionForward encaminharAlterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			removerTarefaSessao(request);
			Boolean usuarioAutorizado;
			TarefaForm tarefaForm = (TarefaForm) form;
			TarefaTO tarefaTO = new TarefaTO();
			TarefaBO tarefaBO = new TarefaBO();
			
			if (request.getAttribute("codigo") != null) {
				tarefaTO.setCodigo(Integer.parseInt(request.getAttribute("codigo").toString()));
				tarefaTO.setAnoCriacao(Integer.parseInt(request.getAttribute("anoCriacao").toString()));
			} else if(request.getParameter("codigo")!=null) {
				tarefaTO.setCodigo(Integer.parseInt(request.getParameter("codigo")));
				tarefaTO.setAnoCriacao(Integer.parseInt(request.getParameter("anoCriacao")));
			}else{
				tarefaTO.setCodigo(tarefaForm.getCodigo());
				tarefaTO.setAnoCriacao(tarefaForm.getAnoCriacao());
			}
			ConfigTarefaBO configTarefaBO = new ConfigTarefaBO(); 
			
			Collection result = configTarefaBO.consultarConfigTarefaAcesso();
			request.getSession().setAttribute("listaConfigTarefa", result);
			TarefaTO tarefaConTO = new TarefaTO();
			try {

				tarefaConTO = tarefaBO.consultarUm(tarefaTO);
			} catch (Exception e) {
				log.error(e.getMessage());
				setErro("pro.listaVazia.pesquisar",request);
				throw new Exception(e.getMessage());
			}
			tarefaForm.setTarefaForm(tarefaConTO);
			
			/*Consulta de nome de Usuario de alteracao e inclusao*/
			UsuarioTO usuarioTO = new UsuarioTO();
			usuarioTO.setIdUsuario(tarefaConTO.getCodUsuSolicitante());
			tarefaForm.setNomeUsuSolicitante(new UsuarioBO().consultarUm(usuarioTO).getNome());
			
			ParticipanteBO participanteBO = new ParticipanteBO();
			ParticipanteTO participanteTO2=new ParticipanteTO();
			participanteTO2.setAnoCriacao(tarefaForm.getAnoCriacao());
			participanteTO2.setCodTarefa(tarefaForm.getCodigo());
			participanteTO2.setCodTipoParticipacao(1);
			Collection listaExecutante = participanteBO.consultarVariosExecutante(participanteTO2);
			request.getSession().setAttribute("executantes",listaExecutante);
		
			request.setAttribute("tarefaForm", tarefaForm);
			request.setAttribute("dataCriacao", DataUtil.formataData(tarefaConTO.getTsCriacao()));
			request.getSession().setAttribute("tarefaTO", tarefaConTO);
			consultarItemsCriticos(tarefaConTO, request);
			consultarFormulariosCriticos(tarefaConTO, request);
			
		    DataUtil dataUtil = new DataUtil();
		    request.getSession().setAttribute("dataAtual",dataUtil.getData());
		    
		    
		    request.setAttribute("dataCriacao",dataUtil.getTimestampFormatoSemHora(tarefaConTO.getTsCriacao()));
		    AnotacaoTarefaBO anotacaoBO = new AnotacaoTarefaBO();
			AnotacaoTarefaTO anotacaoTO = new AnotacaoTarefaTO();
			
			anotacaoTO.setAnoCriacao(tarefaTO.getAnoCriacao());
			anotacaoTO.setCodTarefa(tarefaTO.getCodigo());
			anotacaoTO.setCodTipoAnotacao(1);
			Collection listaTipoAnotacao = anotacaoBO.consultarVarios(anotacaoTO);

			request.getSession().setAttribute("listaAnotacao", listaTipoAnotacao);
		    
		    /*Pesquisa os anexos para colocar visível na ateração*/
			AnexoTO anexoTO = new AnexoTO();
			AnexoBO anexoBO = new AnexoBO();
			
			anexoTO.setAnoCriacao(String.valueOf(tarefaTO.getAnoCriacao()));
			anexoTO.setNumeroSequencialTarefa(tarefaTO.getCodigo());
			Collection colecaoAnexos = anexoBO.consultarVarios(anexoTO);
			
			List listaAnexos = (List) colecaoAnexos;
			anexoBO.getEspacoUtilizado(listaAnexos);
			request.getSession().setAttribute("listaAnexos", listaAnexos);

			pesquisarDadosBSCTarefa(tarefaConTO, tarefaBO, request);
			
			Util.atualizaArvoreTarefa(request,response);
			
			// Consulta ID do mapa e atualiza o form para retornar para relatórios de Plano de Açoes
			PerspectivaTO perspectivaTO = new PerspectivaTO();
			ObjetivoTO objetivoTO = new ObjetivoTO();
			IndicadorTO indicadorTO = new IndicadorTO();
			perspectivaTO.setId(tarefaForm.getCodPerspectiva());
			objetivoTO.setId(tarefaForm.getCodObjetivo());
			indicadorTO.setId(tarefaForm.getCodIndicador());
			tarefaForm.setCodMapa(new MapaEstrategicoBO().consultarIdMapa(perspectivaTO, objetivoTO, indicadorTO).getId());
					
			
			return mapping.findForward("sucesso");
			
		} catch (Exception e) {
			log.error(e.getMessage());
			setErro("pro.erro.tarefa.alterar", e.getMessage(), request);
			return mapping.findForward("erro");
		}
	}

	
	private void pesquisarDadosBSCTarefa(TarefaTO tarefaConTO, TarefaBO tarefaBO, HttpServletRequest request ) throws ExceptionNegocioBSC{
		/*Consulta nome do Mapa, pers, Obj ou ind.*/
		if (tarefaConTO.getCodIndicador() != 0){
			request.getSession().setAttribute("nomeIndicador",tarefaBO.consultarNomeIndicador(tarefaConTO.getCodIndicador()));
		}else if (tarefaConTO.getCodObjetivo() != 0){
			request.getSession().setAttribute("nomeObjetivo",tarefaBO.consultarNomeObjetivo(tarefaConTO.getCodObjetivo()));
		}else if (tarefaConTO.getCodPerspectiva() != 0){
			request.getSession().setAttribute("nomePerspectiva",tarefaBO.consultarNomePerspectiva(tarefaConTO.getCodPerspectiva()));
		}else if (tarefaConTO.getCodMapa() != 0){
			request.getSession().setAttribute("nomeMapa",tarefaBO.consultarNomeMapa(tarefaConTO.getCodMapa()));
		} 
	}
	
	public ActionForward alterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		TarefaForm tarefaForm = (TarefaForm) form;
		TarefaTO tarefaTO = new TarefaTO();
		TarefaBO tarefaBO = new TarefaBO();
		TarefaTO tarefaTOCons = (TarefaTO) request.getSession().getAttribute("tarefaTO");
		tarefaTO.setTsCriacao(tarefaTOCons.getTsCriacao());
		tarefaForm.setTarefaTO(tarefaTO);
		try {
			request.getSession().setAttribute("tarefaTO", tarefaTO);
			UsuarioTO usuario = UsuarioBO.getUsuarioTO(response,request);
			tarefaTO.setCodUsuAlteracao(usuario.getIdUsuario());
			tarefaBO.alterar(tarefaTO);
			setMensagem("pro.sucesso.tarefa.alterar", request);
			
			request.getSession().setAttribute("tarefaDepoisAlterar", tarefaTO);
			
			ParticipanteTO participanteTO = new ParticipanteTO();
			participanteTO.setAnoCriacao(tarefaTO.getAnoCriacao());
			participanteTO.setCodTarefa(tarefaTO.getCodigo());
			
			/*Consulta de nome de Usuario de alteracao e inclusao*/
			UsuarioTO usuarioTO = new UsuarioTO();
			usuarioTO.setIdUsuario(tarefaTO.getCodUsuSolicitante());
			tarefaForm.setNomeUsuSolicitante(new UsuarioBO().consultarUm(usuarioTO).getNome());
			tarefaForm.setTsCriacao(new DataUtil().getTimestampFormatoComum(tarefaTO.getTsCriacao()));
			tarefaTO = tarefaBO.consultarUm(tarefaTO);
			tarefaForm.setTarefaForm(tarefaTO);
			pesquisarDadosBSCTarefa(tarefaTO, tarefaBO, request);
			Util.atualizaArvoreTarefa(request,response);
			// Consulta ID do mapa e atualiza o form
			PerspectivaTO perspectivaTO = new PerspectivaTO();
			ObjetivoTO objetivoTO = new ObjetivoTO();
			IndicadorTO indicadorTO = new IndicadorTO();
			perspectivaTO.setId(tarefaForm.getCodPerspectiva());
			objetivoTO.setId(tarefaForm.getCodObjetivo());
			indicadorTO.setId(tarefaForm.getCodIndicador());
			tarefaForm.setCodMapa(new MapaEstrategicoBO().consultarIdMapa(perspectivaTO, objetivoTO, indicadorTO).getId());
						
			//EnviarEmail.email(usuario.getEmail(), usuario.getEmail(), "teste de envio", "texto de envio");
			
		} catch (Exception e) {
			log.error(e.getMessage());
			setErro("pro.erro.tarefa.alterar", e.getMessage(), request);
			return mapping.findForward("erro");
		}
		return mapping.findForward("sucesso");
	}

	
	public ActionForward encaminharInclusao(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			request.getSession().removeAttribute("tarefaForm");
			request.getSession().removeAttribute("tarefaTO");
			request.getSession().removeAttribute("codMapa");
			request.getSession().removeAttribute("codPerspectiva");
			request.getSession().removeAttribute("codObjetivo");
			request.getSession().removeAttribute("codIndicador");
			request.getSession().removeAttribute("nomeMapa");
			request.getSession().removeAttribute("nomePerspectiva");
			request.getSession().removeAttribute("nomeObjetivo");
			request.getSession().removeAttribute("nomeIndicador");
			
			request.getSession().removeAttribute("listaConfigTarefa");
			request.getSession().removeAttribute("listaAnotacao");
			request.getSession().removeAttribute("executantes");
			
			saveToken(request);
			ConfigTarefaBO configTarefaBO = new ConfigTarefaBO();
			ConfigTarefaTO configTarefaTO = new ConfigTarefaTO();
			configTarefaTO.setUsuarioTO(UsuarioBO.getUsuarioTO());
			Collection result = configTarefaBO.consultarVariosPorGrupo(configTarefaTO);
			request.getSession().setAttribute("listaConfigTarefa", result);

			/*Busca a data atual e joga na requisição para a realização da*/			
			DataUtil dataUtil = new DataUtil();
			request.getSession().setAttribute("dataAtual", dataUtil.getData());
			request.setAttribute("dataCriacao", dataUtil.getData());
			Util.atualizaArvoreTarefa(request,response);
			
		} catch (Exception e) {
			setErro("pro.erro.configTarefa.pesquisar", e.getMessage(), request);
			return mapping.findForward("erro");
		}
		return mapping.findForward("sucesso");
	}

	public ActionForward calcularDataPrazo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		TarefaForm tarefaForm = (TarefaForm) form;
		TarefaTO tarefaTO = new TarefaTO();
		TarefaBO tarefaBO = new TarefaBO();
		try {
			tarefaTO.setCodConfigTarefa(tarefaForm.getCodConfigTarefa());
			
			tarefaBO.calcularDataPrazo(tarefaTO);			
			tarefaForm.setDtLimitePrazo(tarefaTO.getDtPrazo());
			tarefaForm.setCodCriticidade(tarefaTO.getCodCriticidade());
			tarefaForm.setCodEstado(tarefaTO.getCodEstado());
			if (tarefaTO.getTextoSolicitacao() != null)
				tarefaForm.setTextoSolicitacao(tarefaTO.getTextoSolicitacao().trim());
			if (tarefaTO.getNome() != null)
				tarefaForm.setNome(tarefaTO.getNome().trim());
			
			DataUtil dataUtil = new DataUtil();
			request.setAttribute("dataAtual", dataUtil.getData());
			request.setAttribute("tarefaForm",tarefaForm);

		} catch (Exception e) {
			setErro("pro.erro.configTarefa.pesquisar", e.getMessage(), request);
			return mapping.findForward("erro");
		}		
		return mapping.findForward("sucessoCalcularPrazo");
		
	}

	public ActionForward incluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
					
			request.getSession().removeAttribute("listaAnexos");
			TarefaForm tarefaForm = (TarefaForm) form;
			TarefaTO tarefaTO = new TarefaTO();
			TarefaBO tarefaBO = new TarefaBO();
			removerTarefaSessao(request);
			String codMapa = (String)request.getSession().getAttribute("codMapa");
			if (codMapa != null)
				tarefaTO.setCodMapa(Integer.parseInt(codMapa));
			
			String codPerspectiva = (String)request.getSession().getAttribute("codPerspectiva");
			if (codPerspectiva != null)
				tarefaTO.setCodPerspectiva(Integer.parseInt(codPerspectiva));
			
			String codObjetivo = (String)request.getSession().getAttribute("codObjetivo");
			if (codObjetivo != null)
				tarefaTO.setCodObjetivo(Integer.parseInt(codObjetivo));
			
			String codIndicador = (String)request.getSession().getAttribute("codIndicador");
			if (codIndicador != null)
				tarefaTO.setCodIndicador(Integer.parseInt(codIndicador));
			
			
			tarefaForm.setTarefaTO(tarefaTO);
			UsuarioTO usuarioTO = UsuarioBO.getUsuarioTO(response,request);
			tarefaTO.setCodUsuSolicitante(usuarioTO.getIdUsuario());
			tarefaTO.setCodUsuCriador(usuarioTO.getIdUsuario());
			tarefaTO.setCodUsuAlteracao(usuarioTO.getIdUsuario());
			tarefaBO.incluir(tarefaTO);
			request.setAttribute("codigo", new Integer(tarefaTO.getCodigo()));
			request.setAttribute("anoCriacao", new Integer(tarefaTO.getAnoCriacao()));
			request.setAttribute("codigoConfigTarefa", new Integer(tarefaTO.getCodConfigTarefa()));
			setMensagem("pro.sucesso.tarefa.incluir", request);
			tarefaForm.setTarefaForm(tarefaTO);
			request.getSession().setAttribute("tarefaTO", tarefaTO);
			Util.atualizaArvoreTarefa(request,response);
			
			ParticipanteBO participanteBO = new ParticipanteBO();
			ParticipanteTO participanteTO = new ParticipanteTO();
			participanteTO.setAnoCriacao(tarefaForm.getAnoCriacao());
			participanteTO.setCodTarefa(tarefaForm.getCodigo());
			participanteTO.setCodTipoParticipacao(1);
			Collection listaExecutante = participanteBO.consultarVariosExecutante(participanteTO);
			request.getSession().setAttribute("executantes",listaExecutante);
			
			/*Consulta de nome de Usuario de alteracao e inclusao*/
			UsuarioTO solicit = new UsuarioTO();
			solicit.setIdUsuario(tarefaTO.getCodUsuSolicitante());
			tarefaForm.setNomeUsuSolicitante(new UsuarioBO().consultarUm(solicit).getNome());
			tarefaForm.setTsCriacao(DataUtil.formataData(tarefaTO.getTsCriacao()));
			request.setAttribute("dataCriacao", DataUtil.formataData(tarefaTO.getTsCriacao()));
			consultarFormulariosCriticos(tarefaTO, request);
			consultarItemsCriticos(tarefaTO, request);
			return mapping.findForward("sucesso");
		} catch (Exception e) {
			setErro("pro.erro.tarefa.incluir", e.getMessage(), request);
			return mapping.findForward("erro");
		}
		
	}
	
	public ActionForward visualizar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			TarefaBO tarefaBO = new TarefaBO();
			TarefaTO tarefaTO = new TarefaTO();
			ParticipanteTO participanteTO = new ParticipanteTO();
			request.getSession().setAttribute("listaAcompanhamento", tarefaBO.visualizar(tarefaTO, participanteTO));
		} catch (Exception e) {
			setErro("pro.erro.tarefa.visualizar", e.getMessage(), request);
			return mapping.findForward("erro");
		}
		return mapping.findForward("sucesso");

	}

	public void consultarItemsCriticos(TarefaTO tarefaParamTO, HttpServletRequest request) throws Exception {
		try {
			ConteudoItemTarefaTO conteudoItemTarefaTO = new ConteudoItemTarefaTO();
		    ConteudoItemTarefaBO conteudoItemTarefaBO = new ConteudoItemTarefaBO();
		    conteudoItemTarefaTO.setAnoCriacao(tarefaParamTO.getAnoCriacao());
            conteudoItemTarefaTO.setCodTarefa(tarefaParamTO.getCodigo());
            conteudoItemTarefaTO.setCodConfigTarefa(tarefaParamTO.getCodConfigTarefa());
            conteudoItemTarefaTO.setIndVigente("S");
			Collection listaItems = conteudoItemTarefaBO.consultarItemsPRO(conteudoItemTarefaTO);
	        request.getSession().setAttribute("itemsCriticos",listaItems);
			
		} catch (Exception e) {
			log.error(e.getMessage());
			setErro("pro.erro.items.criticos", e.getMessage(), request);
		}
	}

	public void consultarFormulariosCriticos(TarefaTO tarefaParamTO, HttpServletRequest request) throws Exception {
		try {
			ConteudoFormularioTarefaTO conteudoFormularioTarefaTO = new ConteudoFormularioTarefaTO();
		    ConteudoFormularioTarefaBO conteudoFormularioTarefaBO = new ConteudoFormularioTarefaBO();
		    conteudoFormularioTarefaTO.setAnoCriacao(tarefaParamTO.getAnoCriacao());
            conteudoFormularioTarefaTO.setCodTarefa(tarefaParamTO.getCodigo());
            conteudoFormularioTarefaTO.setCodConfigTarefa(tarefaParamTO.getCodConfigTarefa());
            conteudoFormularioTarefaTO.setIndVigente("S");
			Collection listaFormularios = conteudoFormularioTarefaBO.consultarFormulariosPRO(conteudoFormularioTarefaTO);
	        request.getSession().setAttribute("formulariosCriticos",listaFormularios);
			
		} catch (Exception e) {
			log.error(e.getMessage());
			setErro("pro.erro.formularios.criticos", e.getMessage(), request);
		}
	}
	
	 public ActionForward encaminharConsultar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception { 
	   		try {
	   			request.getSession().removeAttribute("tarefaFormConsulta");
	   			TarefaForm tarefaForm = (TarefaForm) form;
	   			TarefaTO tarefaReset = new TarefaTO();
	   			tarefaForm.setTarefaForm(tarefaReset);
	   			request.getSession().removeAttribute("listaTarefa");
	   			tarefaForm.setChkNome(true);
	   			tarefaForm.setChkSolicitacao(true);
	   			tarefaForm.setChkConfigTarefa(true);
	   			tarefaForm.setChkPrazo(true);
	   			tarefaForm.setChkUltAnotacao(true);
	   			request.setAttribute("tarefaFormConsulta",tarefaForm);

	   			ConfigTarefaBO configTarefaBO = new ConfigTarefaBO();
	   			request.getSession().setAttribute("listaConfigTarefa",configTarefaBO.consultarConfigTarefaAcesso());
	   			Util.atualizaArvoreTarefa(request,response);
			} catch (Exception e) {
				setErro("pro.erro.tarefa.consutlarSolicitanteChave",e.getMessage(),request);	
				return mapping.findForward("erro");
			}
			return mapping.findForward("sucesso");
	   		
	   }

	  
	   public ActionForward consultarVarios(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception { 
	   		try {
	   			TarefaForm tarefaForm = (TarefaForm) form;
	   			TarefaBO tarefaBO = new TarefaBO();
	   			TarefaTO tarefaTO = new TarefaTO();
	   			tarefaForm.setTarefaTOPesquisa(tarefaTO);
	   			tarefaTO.setCodUsuario(UsuarioBO.getUsuarioTO().getIdUsuario());
	   			Collection listaTarefa = tarefaBO.consultarTarefa(tarefaTO);
	   			if (!listaTarefa.isEmpty()){
	   				request.setAttribute("listaTarefa",listaTarefa);
	   			}else{
	   				request.setAttribute("listaVazia",new Integer(1));
	   			}
	   			   			   		   		
			} catch (Exception e) {
				setErro("pro.erro.tarefa.pesquisa",e.getMessage(),request);	
				return mapping.findForward("erro");
			}
			return mapping.findForward("sucesso");
	   		
	   }
	   
	   
	   public ActionForward encaminharConsultaSolicitante(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception { 
	   		try {
	   			TarefaForm tarefaForm = (TarefaForm) form;
	   			request.getSession().setAttribute("tarefaFormConsulta",tarefaForm);
	   			request.getSession().setAttribute("tarefaForm",tarefaForm);
			} catch (Exception e) {
				setErro("pro.erro.tarefa.pesquisa",e.getMessage(),request);	
				return mapping.findForward("erro");
			}
			return mapping.findForward("sucesso");
	   		
	   }
	   
	   
	   @SuppressWarnings("unchecked")
	public ActionForward consultaOrdenar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception { 
	   		try {
	   			String campoOrdenar = request.getParameter("ordenador");
	   			String tipoOrdenar = request.getParameter("tipoOrdenador");
	   			String tipoListaOrdenador = request.getParameter("tipoListaOrdenador");
	   				   			
	   			QSortAlgorithm sort = new QSortAlgorithm();
	   			
	   			Vector listaExecucao = new Vector(); 
	   			Vector listaAcompanhamento = new Vector();
	   			
	   			if (request.getSession().getAttribute("listaAcompanhamento") != null){	
   					listaAcompanhamento = new Vector((Collection)request.getSession().getAttribute("listaAcompanhamento"));
   				}	   			
	   			if (request.getSession().getAttribute("listaExecucao") != null){
	   				listaExecucao = new Vector((Collection)request.getSession().getAttribute("listaExecucao"));
	   				
	   			}else{
	   				listaExecucao = new Vector((Collection)request.getSession().getAttribute("listaTarefa"));
	   				listaAcompanhamento = new Vector((Collection)request.getSession().getAttribute("listaTarefa"));
	   			}
	   			
	   			if (tipoOrdenar.equals("string")){
	   				if (tipoListaOrdenador.equals("executante")){
	   					sort.sortString(listaExecucao,campoOrdenar);
	   					//Collection lista	   					
	   					request.getSession().setAttribute("listaExecucao",listaExecucao);
	   					
	   				}
	   				if (tipoListaOrdenador.equals("acompanhamento")){
	   					sort.sortString(listaAcompanhamento,campoOrdenar);
	   					request.getSession().setAttribute("listaAcompanhamento",listaAcompanhamento);
	   				}
	   			}
	   			if (tipoOrdenar.equals("data")){
	   				if (tipoListaOrdenador.equals("executante")){
	   					sort.sortDate(listaExecucao,campoOrdenar);
	   					request.getSession().setAttribute("listaExecucao",listaExecucao);
	   				}
	   				if (tipoListaOrdenador.equals("acompanhamento")){
	   					sort.sortDate(listaAcompanhamento,campoOrdenar);
	   					request.getSession().setAttribute("listaAcompanhamento",listaAcompanhamento);
	   				}
	   			}
	   				
	   			   			   		   		
			} catch (Exception e) {
				setErro("pro.erro.tarefa.pesquisa",e.getMessage(),request);	
				return mapping.findForward("erro");
			}
			return mapping.findForward("sucesso");
	   		
	   }
	   
	  
	public ActionForward consultarArvore(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {										
		try {
			/*Consultar Responsavel*/
		    UsuarioBO usuarioBO = new UsuarioBO();
		    UsuarioTO usuarioTO = new UsuarioTO();
		    usuarioTO.setGrupoTO(UsuarioBO.getUsuarioTO().getGrupoTO());
		    // só pode retornar usuarios do grupo
		    request.setAttribute("listaResponsavel",usuarioBO.consultarUsuarioGrupo(usuarioTO));
			Util.atualizaArvoreTarefa(request,response);
			} catch (Exception e) {
				log.error(e.getMessage());
				setErro("pro.erro.tarefa.alterar", e.getMessage(), request);
				return mapping.findForward("erro");
			}
			return mapping.findForward("sucesso");
	}
		
		
	public ActionForward consultarTarefasTipos(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {	
		try {
			request.getSession().removeAttribute("listaTarefa");
			request.setAttribute("nomeConfigTarefa",(String) request.getParameter("nomeConfigTarefa"));
			TarefaBO tarefaBO = new TarefaBO();
			TarefaTO tarefaTO = new TarefaTO();
			ParticipanteTO participanteTO = new ParticipanteTO();
			int tipoParticipacao = Integer.parseInt(request.getParameter("tipoParticipacao"));
			Collection listaTarefa = null;
			if (tipoParticipacao == 1){
				participanteTO.setCodTipoParticipacao(tipoParticipacao);			
				listaTarefa = tarefaBO.visualizar(tarefaTO, participanteTO);
				request.getSession().setAttribute("listaTarefa",listaTarefa);
			}else if (tipoParticipacao == 2){
				participanteTO.setCodTipoParticipacao(2);				
				listaTarefa = tarefaBO.visualizar(tarefaTO, participanteTO);
				request.getSession().setAttribute("listaTarefa",listaTarefa);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			setErro("pro.erro.tarefa.alterar", e.getMessage(), request);
			return mapping.findForward("erro");
		}
		return mapping.findForward("sucessoListaTarefa");
	}
	
	
	
	public ActionForward encaminharInclusaoMapa(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			request.getSession().removeAttribute("tarefaForm");
			saveToken(request);
			ConfigTarefaBO configTarefaBO = new ConfigTarefaBO();
			ConfigTarefaTO configTarefaTO = new ConfigTarefaTO();
			configTarefaTO.setUsuarioTO(UsuarioBO.getUsuarioTO());
			Collection result = configTarefaBO.consultarVariosPorGrupo(configTarefaTO);
			request.getSession().setAttribute("listaConfigTarefa", result);
			String codMapa = request.getParameter("codMapa");
			String codPers = request.getParameter("codPerspectiva");
			String codObj = request.getParameter("codObjetivo");
			String codInd = request.getParameter("codIndicador");
			request.getSession().setAttribute("codMapa",codMapa);
			request.getSession().setAttribute("codPerspectiva",codPers);
			request.getSession().setAttribute("codObjetivo",codObj);
			request.getSession().setAttribute("codIndicador",codInd);
			
			TarefaBO tarefaBO = new TarefaBO();
			
			if (!codInd.equals("0")){
				request.getSession().setAttribute("nomeIndicador",tarefaBO.consultarNomeIndicador(Integer.parseInt(codInd)));
			}else if (!codObj.equals("0")){
				request.getSession().setAttribute("nomeObjetivo",tarefaBO.consultarNomeObjetivo(Integer.parseInt(codObj)));
			}else if (!codPers.equals("0")){
				request.getSession().setAttribute("nomePerspectiva",tarefaBO.consultarNomePerspectiva(Integer.parseInt(codPers)));
			}else{
				request.getSession().setAttribute("nomeMapa",tarefaBO.consultarNomeMapa(Integer.parseInt(codMapa)));
			} 
			Util.atualizaArvoreTarefa(request,response);
					
			DataUtil dataUtil = new DataUtil();
			request.getSession().setAttribute("dataAtual", dataUtil.getData());
			request.setAttribute("dataCriacao", dataUtil.getData());
			
		} catch (Exception e) {
			setErro("pro.erro.configTarefa.pesquisar", e.getMessage(), request);
			return mapping.findForward("erro");
		}
		return mapping.findForward("sucessoMapaTarefa");
	}
	
	public ActionForward relatorioGrupoTarefa(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {	
		try {
			String transicaoRelatorio = request.getSession().getServletContext().getRealPath("/relatorios/pro/grupoTarefasParticipanteGeral.jasper");
			String baseDir = request.getSession().getServletContext().getRealPath("");
			TarefaTO tarefaTO = new TarefaTO();
			TarefaBO tarefaBO = new TarefaBO();
			tarefaTO.setTransicaoRel(transicaoRelatorio);
			tarefaTO.setBaseDir(baseDir);
			tarefaTO.setCodUsuario(UsuarioBO.getUsuarioTO().getIdUsuario());
			request.getSession().setAttribute("relatorio",tarefaBO.relatorioGrupoTarefa(tarefaTO));
		} catch (Exception e) {
			log.error(e.getMessage());
			setErro("pro.erro.tarefa.alterar", e.getMessage(), request);
			return mapping.findForward("erro");
		}
		return mapping.findForward("sucesso");
	}
	
	public ActionForward relatorioGMesTarefas(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {	
		try {
			String transicaoRelatorio = request.getSession().getServletContext().getRealPath("/relatorios/pro/agendaTarefasParticipanteDetalhada.jasper");
			String baseDir = request.getSession().getServletContext().getRealPath("");
			TarefaTO tarefaTO = new TarefaTO();
			TarefaBO tarefaBO = new TarefaBO();
			tarefaTO.setTransicaoRel(transicaoRelatorio);
			tarefaTO.setBaseDir(baseDir);
			DataUtil dataUtil = new DataUtil();
			tarefaTO.setMes(dataUtil.getMes() + 1);//Nao sei pq traz um mes a menos
			tarefaTO.setAno(dataUtil.getAnoDataAtual());
			tarefaTO.setCodUsuario(UsuarioBO.getUsuarioTO().getIdUsuario());
			request.getSession().setAttribute("relatorio",tarefaBO.relatorioGMesTarefas(tarefaTO));
		} catch (Exception e) {
			log.error(e.getMessage());
			setErro("pro.erro.tarefa.alterar", e.getMessage(), request);
			return mapping.findForward("erro");
		}
		return mapping.findForward("sucesso");
	}
	
	public ActionForward imprimirAgendaTarefas(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {	
		try {
			String transicaoRelatorio = request.getSession().getServletContext().getRealPath("/relatorios/pro/agendaTarefasParticipanteGeral.jasper");
			String baseDir = request.getSession().getServletContext().getRealPath("");
			TarefaTO tarefaTO = new TarefaTO();
			TarefaBO tarefaBO = new TarefaBO();
			tarefaTO.setTransicaoRel(transicaoRelatorio);
			tarefaTO.setBaseDir(baseDir);
			tarefaTO.setCodUsuario(UsuarioBO.getUsuarioTO().getIdUsuario());
			ImprimirRelatorioAction imprimirRelatorioAction = new ImprimirRelatorioAction();
			imprimirRelatorioAction.imprimiJasper(tarefaBO.imprimirAgenda(tarefaTO), response);
		} catch (Exception e) {
			log.error(e.getMessage());
			setErro("pro.erro.tarefa.alterar", e.getMessage(), request);
			return mapping.findForward("erro");
		}
		return null;
	}
	
	
	public ActionForward imprimirTarefas(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {	
		try {
			String transicaoRelatorio = request.getSession().getServletContext().getRealPath("/relatorios/pro/relatorioTarefa.jasper");
			String baseDir = request.getSession().getServletContext().getRealPath("");
			TarefaTO tarefaTO = (TarefaTO) request.getSession().getAttribute("tarefaTO");
			TarefaBO tarefaBO = new TarefaBO();
			tarefaTO.setTransicaoRel(transicaoRelatorio);
			tarefaTO.setBaseDir(baseDir);
			tarefaTO.setAno(tarefaTO.getAnoCriacao());
			tarefaTO.setCodigo(tarefaTO.getCodigo());
			ImprimirRelatorioAction imprimirRelatorioAction = new ImprimirRelatorioAction();
			imprimirRelatorioAction.imprimiJasper(tarefaBO.imprimirTarefa(tarefaTO), response);
		} catch (Exception e) {
			log.error(e.getMessage());
			setErro("pro.erro.tarefa.alterar", e.getMessage(), request);
			return mapping.findForward("erro");
		}
		return null;
	}
	

}
	   