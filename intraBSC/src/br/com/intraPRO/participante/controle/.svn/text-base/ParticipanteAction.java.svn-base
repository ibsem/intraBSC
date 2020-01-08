package br.com.intraPRO.participante.controle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import br.com.intraBSC.modelo.PapelTO;
import br.com.intraBSC.modelo.UsuarioTO;
import br.com.intraBSC.negocio.PapelBO;
import br.com.intraBSC.negocio.UsuarioBO;
import br.com.intraPRO.controle.DispatchActionPRO;
import br.com.intraPRO.modelo.TarefaTO;
import br.com.intraPRO.modelo.ParticipanteTO;
import br.com.intraPRO.modelo.SolicitanteTO;
import br.com.intraPRO.negocio.ParticipanteBO;
import br.com.intraPRO.participante.visao.ParticipanteForm;
import br.com.intraPRO.util.Util;


public class ParticipanteAction extends DispatchActionPRO {
	
	
	
	public ActionForward encaminharConsulta(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		try {
			Util.alterarTarefa(request,response);
			return mapping.findForward("sucesso");
		} catch (Exception e) {
			setErro("pro.erro.participante.encaminhar.vincular", e.getMessage(), request);
			return mapping.findForward("erro");
		}
	}
	

	public ActionForward consultarParticipanteChave(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			// Lista os papeis existentes
			PapelBO papelBO = new PapelBO();
			PapelTO papelTO = new PapelTO();
			Collection listaRole = papelBO.consultarVarios(papelTO);
			request.setAttribute("listaRole",listaRole);
			
			ParticipanteForm participanteForm = (ParticipanteForm) form;
			UsuarioBO usuarioBO = new UsuarioBO();
			UsuarioTO usuarioTO = new UsuarioTO();
			usuarioTO.setIdUsuario(participanteForm.getCodUsuario());
			usuarioTO.setGrupoTO(UsuarioBO.getUsuarioTO().getGrupoTO());
			Iterator i = usuarioBO.consultarVarios(usuarioTO).iterator();
			Collection<SolicitanteTO> listaSolicitante = new ArrayList<SolicitanteTO>();
			while (i.hasNext()) {
				UsuarioTO usuarioToResult = (UsuarioTO) i.next();
				SolicitanteTO solicitanteTO = new SolicitanteTO();
				solicitanteTO.setChaveFuncionario(usuarioToResult.getIdUsuario());
				solicitanteTO.setNomeFuncionario(usuarioToResult.getNome());				
				listaSolicitante.add(solicitanteTO);
			}
			request.setAttribute("listarParticipantes",listaSolicitante);
		} catch (Exception e) {
			setErro("pro.erro.tarefa.consutlarSolicitanteChave", e.getMessage(), request);
			return mapping.findForward("erro");
		}
		return mapping.findForward("sucesso");
    }
	
	@SuppressWarnings("unchecked")
	public ActionForward consultarParticipanteNome(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {	
			// Lista os papeis existentes
			PapelBO papelBO = new PapelBO();
			PapelTO papelTO = new PapelTO();
			Collection listaRole = papelBO.consultarVarios(papelTO);
			request.setAttribute("listaRole",listaRole);
			
			ParticipanteForm participanteForm = (ParticipanteForm) form;
			UsuarioBO usuarioBO = new UsuarioBO();
			UsuarioTO usuarioTO = new UsuarioTO();
			usuarioTO.setNome(participanteForm.getNomeParticipante().toUpperCase());
			Collection listaSolicitante = new ArrayList();
			usuarioTO.setGrupoTO(UsuarioBO.getUsuarioTO().getGrupoTO());
			Iterator iter = usuarioBO.consultarVarios(usuarioTO).iterator();
			while (iter.hasNext()) {
				UsuarioTO usuarioToResult = (UsuarioTO) iter.next();
				SolicitanteTO solicitanteTO = new SolicitanteTO();
				solicitanteTO.setChaveFuncionario(usuarioToResult.getIdUsuario());
				solicitanteTO.setNomeFuncionario(usuarioToResult.getNome());				
				listaSolicitante.add(solicitanteTO);
			}

			request.setAttribute("listarParticipantes",listaSolicitante);
			
		} catch (Exception e) {			
			setErro("pro.erro.participante.consulta.solicitante", e.getMessage(), request);
			return mapping.findForward("erro");
		}
		return mapping.findForward("sucesso");
    }

	
	
	
	
	public ActionForward incluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

		try {
			TarefaTO tarefaTO = (TarefaTO) request.getSession().getAttribute("tarefaTO");
			int tipoParticipacao = Integer.parseInt(request.getParameter("tipoParticipacao"));
			ParticipanteForm participanteForm = (ParticipanteForm) form;
			ParticipanteBO participanteBO = new ParticipanteBO();
			ParticipanteTO participanteTO = new ParticipanteTO();
			participanteTO.setAnoCriacao(tarefaTO.getAnoCriacao());
			participanteTO.setCodTarefa(tarefaTO.getCodigo());
			participanteTO.setCodTipoParticipacao(tipoParticipacao);
			participanteTO.setCodPapel(participanteForm.getCodPapel());
			participanteForm.setParticipanteTO(participanteTO);
			participanteBO.incluirListaParticipante(participanteTO);
			setMensagem("pro.sucesso.vinculacao", request);
			return mapping.findForward("sucesso");
			
		} catch (Exception e) {
			setErro("pro.erro.participante.incluir", e.getMessage(), request);
			return mapping.findForward("erro");
		}
	}

	public ActionForward excluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		try {
			Util.alterarTarefa(request,response);
			String chaveSelecionada = request.getParameter("chaveSelecionada");
			int tipoParticipacao = Integer.parseInt(request.getParameter("tipoParticipacao"));
			TarefaTO tarefaTO=(TarefaTO)request.getSession().getAttribute("tarefaTO");
			ParticipanteBO participanteBO = new ParticipanteBO();
			ParticipanteTO participanteTO = new ParticipanteTO();
			participanteTO.setAnoCriacao(tarefaTO.getAnoCriacao());
			participanteTO.setCodTarefa(tarefaTO.getCodigo());
			participanteTO.setCodUsuario(Integer.parseInt(chaveSelecionada));
			participanteTO.setCodTipoParticipacao(tipoParticipacao);
			participanteBO.verificaSeUltimoParticipante(participanteTO, tarefaTO.getCodUsuSolicitante());
			participanteBO.excluir(participanteTO);
			return mapping.findForward("sucesso");
		} catch (Exception e) {
			setErro("pro.erro.participante.excluir", e.getMessage(), request);
			return mapping.findForward("erro");
		}
	}

	public ActionForward limpar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		try {
			Util.alterarTarefa(request,response);
			TarefaTO tarefaTO=(TarefaTO)request.getSession().getAttribute("tarefaTO");
			int tipoParticipacao = Integer.parseInt(request.getParameter("tipoParticipacao"));
			
			ParticipanteBO participanteBO = new ParticipanteBO();
			ParticipanteTO participanteTO = new ParticipanteTO();
			participanteTO.setAnoCriacao(tarefaTO.getAnoCriacao());
			participanteTO.setCodTarefa(tarefaTO.getCodigo());
			participanteTO.setCodTipoParticipacao(tipoParticipacao);
			participanteBO.limpar(participanteTO);
			return mapping.findForward("sucessoLimpar");
		} catch (Exception e) {
			setErro("pro.erro.participante.limpar", e.getMessage(), request);
			return mapping.findForward("erro");
		}
	}

	public ActionForward visualizar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		try {
			return mapping.findForward("sucesso");
		} catch (Exception e) {
			setErro("pro.erro.participante.visualizar", e.getMessage(), request);
			return mapping.findForward("erro");
		}
	}
	
}
