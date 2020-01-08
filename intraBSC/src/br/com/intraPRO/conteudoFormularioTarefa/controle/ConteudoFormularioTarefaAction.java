package br.com.intraPRO.conteudoFormularioTarefa.controle;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.intraPRO.controle.DispatchActionPRO;
import br.com.intraPRO.excecoes.ExceptionPRO;
import br.com.intraPRO.modelo.TarefaTO;
import br.com.intraPRO.modelo.ConteudoFormularioTarefaTO;
import br.com.intraPRO.negocio.ConteudoFormularioTarefaBO;
import br.com.intraPRO.util.Util;

public class ConteudoFormularioTarefaAction extends DispatchActionPRO {

	public ConteudoFormularioTarefaAction() {

	}

	// public ActionForward encaminharIncluir(ActionMapping mapping, ActionForm
	// form, HttpServletRequest request, HttpServletResponse response) throws
	// ExceptionPRO, ParseException, IOException{
	//	   
	// ConteudoFormularioTarefaForm conteudoFormularioTarefaForm = new
	// ConteudoFormularioTarefaForm();
	// ConteudoFormularioTarefaTO conteudoFormularioTarefaTO = new ConteudoFormularioTarefaTO();
	// ConteudoFormularioTarefaBO conteudoFormularioTarefaBO = new ConteudoFormularioTarefaBO();
	// try{
	// TarefaTO tarefaTO = (TarefaTO)
	// request.getSession().getAttribute("tarefaTO");//setando codigo do tipo de
	// tarefa
	// conteudoFormularioTarefaForm.setAnoNome(tarefaTO.getAnoCriacao() + "/" +
	// tarefaTO.getCodigo() + " - " + tarefaTO.getNome());
	// conteudoFormularioTarefaTO.setAnoCriacao(tarefaTO.getAnoCriacao());
	// conteudoFormularioTarefaTO.setCodTarefa(tarefaTO.getCodigo());
	// conteudoFormularioTarefaTO.setCodConfigTarefa(tarefaTO.getCodConfigTarefa());
	// Collection listaFormularios;
	// listaFormularios =
	// conteudoFormularioTarefaBO.consultarFormulariosPRO(conteudoFormularioTarefaTO);
	// request.getSession().setAttribute("listaFormularios",listaFormularios);
	// return mapping.findForward("sucesso");
	// }
	// catch (Exception e) {
	// setErro("pro.erro.formulario.incluir", e.getMessage(),request);
	// return mapping.findForward("erro");
	// }
	// }
	//   
	// public ActionForward incluir(ActionMapping mapping, ActionForm form,
	// HttpServletRequest request, HttpServletResponse response) throws
	// ExceptionPRO{
	// try {
	// TarefaTO tarefaTO = (TarefaTO)
	// request.getSession().getAttribute("tarefaTO");
	// ConteudoFormularioTarefaBO conteudoFormularioTarefaBO = new ConteudoFormularioTarefaBO();
	// ConteudoFormularioTarefaForm conteudoFormularioTarefaForm = (ConteudoFormularioTarefaForm)
	// form;
	// Collection lista = (Collection)
	// request.getSession().getAttribute("listaFormularios");
	// Iterator iter = lista.iterator();
	// int i=0;
	// while (iter.hasNext()) {
	// ConteudoFormularioTarefaTO conteudoFormularioTarefaTO = new ConteudoFormularioTarefaTO();
	// ConteudoFormularioTarefaTO conteudoFormularioTarefaTOIter = (ConteudoFormularioTarefaTO)
	// iter.next();
	// if (i<conteudoFormularioTarefaForm.getAnoCriacao().length){
	// conteudoFormularioTarefaTO.setAnoCriacao(conteudoFormularioTarefaForm.getAnoCriacao()[i]);
	// conteudoFormularioTarefaTO.setCodConfigTarefa(conteudoFormularioTarefaForm.getCodConfigTarefa()[i]);
	// conteudoFormularioTarefaTO.setNumeroOrdem(conteudoFormularioTarefaForm.getNumeroOrdem()[i]);
	// conteudoFormularioTarefaTO.setTextoFormularioTarefa(conteudoFormularioTarefaForm.getTextoFormularioTarefa()[i]);
	// conteudoFormularioTarefaTO.setAnoCriacao(conteudoFormularioTarefaTOIter.getAnoCriacao());
	// conteudoFormularioTarefaTO.setCodTarefa(conteudoFormularioTarefaTOIter.getCodTarefa());
	// conteudoFormularioTarefaBO.excluirFormularioTarefa(conteudoFormularioTarefaTO,tarefaTO);
	// }
	// i++;
	// }
	// TarefaBO tarefaBO = new TarefaBO();/*Se alterar formulario da tarefa, deve
	// alterar o timestamp de alteracao da tarefa.*/
	// tarefaBO.alterarDataAlteracao(tarefaTO);
	// setMensagem("pro.sucesso.formulario.incluir",request);
	// return mapping.findForward("sucesso");
	// }
	// catch (Exception e) {
	// setErro("pro.erro.formulario.incluir", e.getMessage(),request);
	// return mapping.findForward("erro");
	// }
	// }

	public ActionForward alterar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws ExceptionPRO {
		try {
			Util.alterarTarefa(request, response);
			TarefaTO tarefaTO = (TarefaTO) request.getSession().getAttribute(
					"tarefaTO");
			int numOrdem = Integer.parseInt(request.getParameter("numOrdem"));
			String texto = request.getParameter("txtCampo");
			ConteudoFormularioTarefaTO conteudoFormularioTarefaTO = new ConteudoFormularioTarefaTO();
			conteudoFormularioTarefaTO.setNumeroOrdem(numOrdem);
			conteudoFormularioTarefaTO.setAnoCriacao(tarefaTO.getAnoCriacao());
			conteudoFormularioTarefaTO.setCodTarefa(tarefaTO.getCodigo());
			conteudoFormularioTarefaTO.setCodConfigTarefa(tarefaTO.getCodConfigTarefa());
			ConteudoFormularioTarefaBO conteudoFormularioTarefaBO = new ConteudoFormularioTarefaBO();
			conteudoFormularioTarefaTO.setTextoFormularioTarefa(texto);
			if (conteudoFormularioTarefaBO.consultarFormularioCritico(conteudoFormularioTarefaTO).isEmpty()) {
				conteudoFormularioTarefaBO.incluir(conteudoFormularioTarefaTO);
			} else {
				conteudoFormularioTarefaBO.alterar(conteudoFormularioTarefaTO);
			}

			response.sendRedirect(request.getContextPath()
							+ "/tarefa/encaminhar/alterar.do?op=encaminharAlterar&anoCriacao="
							+ tarefaTO.getAnoCriacao() + "&codigo="
							+ tarefaTO.getCodigo());
			return null;
		} catch (Exception e) {
			setErro("pro.erro.formulario.incluir", e.getMessage(), request);
			return mapping.findForward("erro");
		}
	}

}
