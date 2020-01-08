
package br.com.intraPRO.anotacaoTarefa.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.intraBSC.modelo.UsuarioTO;
import br.com.intraBSC.negocio.UsuarioBO;
import br.com.intraPRO.anotacaoTarefa.visao.AnotacaoTarefaForm;
import br.com.intraPRO.controle.DispatchActionPRO;
import br.com.intraPRO.excecoes.ExceptionNegocioPRO;
import br.com.intraPRO.modelo.TarefaTO;
import br.com.intraPRO.modelo.AnotacaoTarefaTO;
import br.com.intraPRO.negocio.TarefaBO;
import br.com.intraPRO.negocio.AnotacaoTarefaBO;
import br.com.intraPRO.util.Util;

/**
 * Classe responsavel pelo controle de anotacao de tarefa
 */
public class AnotacaoTarefaAction extends DispatchActionPRO {

	public AnotacaoTarefaAction() {
	}

	public ActionForward incluir(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			AnotacaoTarefaForm anotacaoTarefaForm = (AnotacaoTarefaForm) form;		
			AnotacaoTarefaTO anotacaoTarefaTO = new AnotacaoTarefaTO();
			AnotacaoTarefaBO anotacaoTarefaBO = new AnotacaoTarefaBO();
			anotacaoTarefaTO.setTextoAnotacao(anotacaoTarefaForm.getTextoAnotacao());
			UsuarioTO usuario = UsuarioBO.getUsuarioTO(response,request);
			anotacaoTarefaTO.setCodUsuario(usuario.getIdUsuario());

            TarefaTO tarefaTO = new TarefaTO();
            TarefaBO tarefaBO = new TarefaBO();
            tarefaTO.setAnoCriacao(Integer.valueOf(request.getParameter("anoCriacao")));
            tarefaTO.setCodigo(Integer.valueOf(request.getParameter("codTarefa")));
            tarefaBO.alterarDataAlteracao(tarefaTO);
            anotacaoTarefaTO.setCodTarefa(tarefaTO.getCodigo());
            anotacaoTarefaTO.setAnoCriacao(tarefaTO.getAnoCriacao());
            anotacaoTarefaTO.setTsAnotacao(tarefaTO.getTsAlteracao());
            anotacaoTarefaBO.incluir(anotacaoTarefaTO);
		} catch (ExceptionNegocioPRO e) {
			setErro("pro.erro.anotacaoTarefa.incluir", e.getMessage(),request);
			return mapping.findForward("erro");
		} 
		setMensagem("pro.sucesso.anotacaoTarefa.incluir",request);		
		return mapping.findForward("sucesso");
	}

	
	public ActionForward encaminharInclusao(ActionMapping mapping,ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {
		try {
			Util.alterarTarefa(request,response);
			TarefaTO tarefaTO = (TarefaTO) request.getSession().getAttribute("tarefaTO");
			AnotacaoTarefaForm anotacaoTarefaForm = (AnotacaoTarefaForm) form;
			AnotacaoTarefaTO anotacaoTarefaTO = new AnotacaoTarefaTO();
			Integer tipoAnotacao = (Integer) request.getAttribute("tipoAnotacao");			
			if (tipoAnotacao == null){
				anotacaoTarefaForm.setTipoAnotacao(request.getParameter("tipoAnotacao"));
			}else{
				anotacaoTarefaForm.setTipoAnotacao(String.valueOf(tipoAnotacao));
			}
			if (anotacaoTarefaForm.getTipoAnotacao() != null && anotacaoTarefaForm.getTipoAnotacao().equals("1")) {
				anotacaoTarefaTO.setAnoCriacao(tarefaTO.getAnoCriacao());
				anotacaoTarefaTO.setCodTarefa(tarefaTO.getCodigo());
				anotacaoTarefaTO.setCodConfigTarefa(tarefaTO.getCodConfigTarefa());
		   }else if ((tipoAnotacao != null)&&(tipoAnotacao.intValue() == 3)){
			   
		   } else {
			    anotacaoTarefaTO.setAnoCriacao(tarefaTO.getAnoCriacao());
				anotacaoTarefaTO.setCodTarefa(tarefaTO.getCodigo());
				anotacaoTarefaTO.setCodConfigTarefa(tarefaTO.getCodConfigTarefa());
				//TarefaTO tarefaTODepois = (TarefaTO) request.getSession().getAttribute("tarefaDepoisAlterar");
				//TarefaTO tarefaTOAntes = (TarefaTO) request.getSession().getAttribute("tarefaTOAntesAlterar");
				/*if (tarefaTOAntes != null && tarefaTODepois != null) {
					if (tarefaTOAntes.getDtLimitePrazo().equals(tarefaTODepois.getDtLimitePrazo())) {
						anotacaoTarefaForm.setVerificaDataPrazo(0);
					} else {
						anotacaoTarefaForm.setVerificaDataPrazo(1);
					}
				}*/
			}
			// preenche o cabeçalho da página com os detalhes da tarefa
			anotacaoTarefaForm.setAnoNumeroNome(tarefaTO.getAnoCriacao() + "/" + tarefaTO.getCodigo() + " - "	+ tarefaTO.getNome());
		} catch (Exception e) {
			log.error(e.getMessage());
			setErro("pro.erro.anotacaoTarefa.incluir", e.getMessage(), request);
			return mapping.findForward("erro");
		}
		
		return mapping.findForward("sucesso");
	}

	
	public ActionForward visualizar(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws Exception {

		AnotacaoTarefaForm anotacaoTarefaForm = (AnotacaoTarefaForm) form;
		TarefaTO tarefaTO = (TarefaTO) request.getSession().getAttribute("tarefaTO");
		AnotacaoTarefaBO anotacaoBO = new AnotacaoTarefaBO();
		AnotacaoTarefaTO anotacaoTO = new AnotacaoTarefaTO();
		anotacaoTarefaForm.setEtapa("");
		anotacaoTO.setAnoCriacao(tarefaTO.getAnoCriacao());
		anotacaoTO.setCodTarefa(tarefaTO.getCodigo());
		anotacaoTO.setCodConfigTarefa(tarefaTO.getCodConfigTarefa());
		anotacaoTarefaForm.setEstado(request.getParameter("codEstado"));
		Collection listaTipoAnotacao = anotacaoBO.consultarVarios(anotacaoTO);
		List listaAnotacaos = (List) listaTipoAnotacao;
		request.getSession().setAttribute("listaAnotacao", listaAnotacaos);		
		request.getSession().setAttribute("listaTipoAnotacao",	listaTipoAnotacao);
		request.setAttribute("visualizar", "visualizar");
		anotacaoTarefaForm.setAnoNumeroNome(tarefaTO.getAnoCriacao() + "/" + tarefaTO.getCodigo() + " - "	+ tarefaTO.getNome());
		request.setAttribute("etapaAbilitar", "nao");// indica se o campo etapa dever vir abilitado ou desabilitado
		return mapping.findForward("sucesso");
	}

	public ActionForward consultarVarios(ActionMapping mapping,ActionForm form, HttpServletRequest request,	HttpServletResponse response) throws Exception {
		AnotacaoTarefaForm anotacaoTarefaForm = (AnotacaoTarefaForm) form;
		TarefaTO tarefaTO = (TarefaTO) request.getSession().getAttribute("tarefaTO");
		AnotacaoTarefaBO anotacaoBO = new AnotacaoTarefaBO();
		AnotacaoTarefaTO anotacaoTO = new AnotacaoTarefaTO();
		anotacaoTO.setCodTarefa(tarefaTO.getCodigo());
		anotacaoTO.setCodTipoAnotacao(Integer.parseInt(anotacaoTarefaForm.getTextoAnotacao()));
		if (!anotacaoTarefaForm.getTextoAnotacao().equals("3")) {
			request.setAttribute("etapaAbilitar", "nao");// indica se o campo etapa dever vir abilitado ou desabilitado
			anotacaoTarefaForm.setEtapa("");
		}
		Collection listaTipoAnotacao = anotacaoBO.consultarVarios(anotacaoTO);
		request.setAttribute("visualizar", "consultar");
		List listaAnotacaos = (List) listaTipoAnotacao;
		request.getSession().setAttribute("listaAnotacao", listaAnotacaos);
		request.getSession().setAttribute("listaTipoAnotacao",listaTipoAnotacao);
		return mapping.findForward("sucesso");
	}
	
	
	
	/* Metodo copiado com algumas modificacoes do incluir anotacao para ser utilziado 
	 * na inclusao de anotacao da alteracao da tarefa */
	public ActionForward incluirAlteracaoTarefa(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws ParseException, SQLException {
		TarefaTO tarefaTODepois = (TarefaTO) request.getSession().getAttribute("tarefaDepoisAlterar");
		TarefaTO tarefaTOAntes = (TarefaTO) request.getSession().getAttribute("tarefaTOAntesAlterar");
		AnotacaoTarefaTO anotacaoTarefaTO = new AnotacaoTarefaTO();
		AnotacaoTarefaBO anotacaoTarefaBO = new AnotacaoTarefaBO();
		String textoAlteracao = "";
		try {
			textoAlteracao = anotacaoTarefaBO.verificarAlteracao(tarefaTOAntes, tarefaTODepois);
			if (!textoAlteracao.equals("")){//Justificativa da Tarefa.
				anotacaoTarefaTO.setTextoAnotacao(textoAlteracao);
				anotacaoTarefaTO.setAnoCriacao(tarefaTODepois.getAnoCriacao());
				anotacaoTarefaTO.setCodTarefa(tarefaTODepois.getCodigo());
				anotacaoTarefaTO.setCodConfigTarefa(tarefaTODepois.getCodConfigTarefa());
				anotacaoTarefaTO.setCodUsuario(tarefaTODepois.getCodUsuAlteracao());
				if (anotacaoTarefaTO.getTextoAnotacao() != null && !anotacaoTarefaTO.getTextoAnotacao().equals("")) {
					anotacaoTarefaBO.incluirJustificativa(anotacaoTarefaTO);
				}
				/*Se alterar item da tarefa, deve alterar o timestamp de alteracao da tarefa.*/
	            TarefaTO tarefaTO = new TarefaTO();
	            TarefaBO tarefaBO = new TarefaBO();
	            tarefaTO.setAnoCriacao(anotacaoTarefaTO.getAnoCriacao());
	            tarefaTO.setCodigo(anotacaoTarefaTO.getCodTarefa());
	            tarefaBO.alterarDataAlteracao(tarefaTO);
			}
		} catch (ExceptionNegocioPRO e) {
			setErro("pro.erro.anotacaoTarefa.incluir", e.getMessage(),request);
			return mapping.findForward("erro");
		}
		setMensagem("pro.sucesso.tarefa.alterar",request);		
		return mapping.findForward("sucesso");
	}
}