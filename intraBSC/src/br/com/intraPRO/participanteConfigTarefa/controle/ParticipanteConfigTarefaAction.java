package br.com.intraPRO.participanteConfigTarefa.controle;


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

import br.com.intraPRO.modelo.ConfigTarefaTO;
import br.com.intraPRO.modelo.ParticipanteConfigTarefaTO;
import br.com.intraPRO.modelo.SolicitanteTO;
import br.com.intraPRO.negocio.ParticipanteConfigTarefaBO;
import br.com.intraPRO.participanteConfigTarefa.visao.ParticipanteConfigTarefaForm;


public class ParticipanteConfigTarefaAction  extends DispatchActionPRO {
	
	public ParticipanteConfigTarefaAction(){		
	}

	public ActionForward incluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		try {			
			int tipoParticipacao = Integer.parseInt(request.getParameter("tipoParticipacao"));
			ConfigTarefaTO configTarefaTO = (ConfigTarefaTO) request.getSession().getAttribute("configTarefaTO");
			ParticipanteConfigTarefaForm participanteconfigTarefaForm = (ParticipanteConfigTarefaForm) form;
			ParticipanteConfigTarefaBO participanteconfigTarefaBO = new ParticipanteConfigTarefaBO();
			ParticipanteConfigTarefaTO participanteconfigTarefaTO = new ParticipanteConfigTarefaTO();
			participanteconfigTarefaTO.setCodConfigTarefa(configTarefaTO.getCodigoConfigTarefa());
			participanteconfigTarefaTO.setCodTipoParticipacao(tipoParticipacao);
			participanteconfigTarefaTO.setCodPapel(participanteconfigTarefaForm.getCodPapel());
			participanteconfigTarefaForm.setParticipanteTO(participanteconfigTarefaTO);
			participanteconfigTarefaBO.incluirListaParticipante(participanteconfigTarefaTO);

			setMensagem("pro.sucesso.vinculacao", request);
			return mapping.findForward("sucesso");
		} catch (Exception e) {
			setErro("pro.erro.participante.incluir", e.getMessage(), request);
			return mapping.findForward("erro");
		}
	}

	public ActionForward excluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		try {
			String chaveSelecionada = request.getParameter("chaveSelecionada");
			int tipoParticipacao = Integer.parseInt(request.getParameter("tipoParticipacao"));
			int configTarefa = Integer.parseInt(request.getParameter("codigoConfigTarefa"));
			
			ParticipanteConfigTarefaBO participanteconfigTarefaBO = new ParticipanteConfigTarefaBO();
			ParticipanteConfigTarefaTO participanteconfigTarefaTO = new ParticipanteConfigTarefaTO();
			participanteconfigTarefaTO.setCodUsuario(Integer.parseInt(chaveSelecionada));
			participanteconfigTarefaTO.setCodTipoParticipacao(tipoParticipacao);
			participanteconfigTarefaTO.setCodConfigTarefa(configTarefa);
			participanteconfigTarefaBO.excluir(participanteconfigTarefaTO);

			return mapping.findForward("sucessoLimpar");
		} catch (Exception e) {
			setErro("pro.erro.participante.excluir", e.getMessage(), request);
			return mapping.findForward("erro");
		}
	}

	public ActionForward limpar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

		try {			
			int tipoParticipacao = Integer.parseInt(request.getParameter("tipoParticipacao"));
			int configTarefa = Integer.parseInt(request.getParameter("codigoConfigTarefa"));
			
			ParticipanteConfigTarefaBO participanteconfigTarefaBO = new ParticipanteConfigTarefaBO();
			ParticipanteConfigTarefaTO participanteconfigTarefaTO = new ParticipanteConfigTarefaTO();
			participanteconfigTarefaTO.setCodTipoParticipacao(tipoParticipacao);
			participanteconfigTarefaTO.setCodConfigTarefa(configTarefa);
			participanteconfigTarefaBO.limpar(participanteconfigTarefaTO);
			return mapping.findForward("sucessoLimpar");
		} catch (Exception e) {
			setErro("pro.erro.participante.limpar", e.getMessage(), request);
			return mapping.findForward("erro");
		}
	}

	

	@SuppressWarnings("unchecked")
	public ActionForward consultarParticipanteChave(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			// Lista os papeis existentes
			PapelBO papelBO = new PapelBO();
			PapelTO papelTO = new PapelTO();
			Collection listaRole = papelBO.consultarVarios(papelTO);
			request.setAttribute("listaRole",listaRole);
			// Lista usuarios da pesquisa
			
			ParticipanteConfigTarefaForm participanteconfigTarefaForm = (ParticipanteConfigTarefaForm) form;
			UsuarioBO usuarioBO = new UsuarioBO();
			UsuarioTO usuarioTO = new UsuarioTO();
			usuarioTO.setIdUsuario(participanteconfigTarefaForm.getCodUsuario());
			usuarioTO.setGrupoTO(UsuarioBO.getUsuarioTO().getGrupoTO());
			Iterator i = usuarioBO.consultarVarios(usuarioTO).iterator();
			Collection listaSolicitante = new ArrayList();
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
			// Lista os usuarios 
			ParticipanteConfigTarefaForm participanteconfigTarefaForm = (ParticipanteConfigTarefaForm) form;
			UsuarioBO usuarioBO = new UsuarioBO();
			UsuarioTO usuarioTO = new UsuarioTO();
			usuarioTO.setNome(participanteconfigTarefaForm.getNomeParticipante().toUpperCase());
			usuarioTO.setGrupoTO(UsuarioBO.getUsuarioTO().getGrupoTO());
			Iterator i = usuarioBO.consultarVarios(usuarioTO).iterator();
			Collection listaSolicitante = new ArrayList();
			while (i.hasNext()) {
				UsuarioTO usuarioToResult = (UsuarioTO) i.next();
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

	public ActionForward encaminharConsulta(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		try {
			//Metodo de redirecionamento.
			return mapping.findForward("sucesso");
		} catch (Exception e) {
			setErro("pro.erro.participante.encaminhar.vincular", e.getMessage(), request);
			return mapping.findForward("erro");
		}
	}

}
