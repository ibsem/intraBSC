package br.com.intraPRO.conteudoItemTarefa.controle;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.intraPRO.controle.DispatchActionPRO;
import br.com.intraPRO.excecoes.ExceptionPRO;
import br.com.intraPRO.modelo.TarefaTO;
import br.com.intraPRO.modelo.ConteudoItemTarefaTO;
import br.com.intraPRO.negocio.ConteudoItemTarefaBO;
import br.com.intraPRO.util.Util;

public class ConteudoItemTarefaAction extends DispatchActionPRO {

	public ConteudoItemTarefaAction() {

	}

	// public ActionForward encaminharIncluir(ActionMapping mapping, ActionForm
	// form, HttpServletRequest request, HttpServletResponse response) throws
	// ExceptionPRO, ParseException, IOException{
	//	   
	// ConteudoItemTarefaForm conteudoItemTarefaForm = new
	// ConteudoItemTarefaForm();
	// ConteudoItemTarefaTO conteudoItemTarefaTO = new ConteudoItemTarefaTO();
	// ConteudoItemTarefaBO conteudoItemTarefaBO = new ConteudoItemTarefaBO();
	// try{
	// TarefaTO tarefaTO = (TarefaTO)
	// request.getSession().getAttribute("tarefaTO");//setando codigo do tipo de
	// tarefa
	// conteudoItemTarefaForm.setAnoNome(tarefaTO.getAnoCriacao() + "/" +
	// tarefaTO.getCodigo() + " - " + tarefaTO.getNome());
	// conteudoItemTarefaTO.setAnoCriacao(tarefaTO.getAnoCriacao());
	// conteudoItemTarefaTO.setCodTarefa(tarefaTO.getCodigo());
	// conteudoItemTarefaTO.setCodConfigTarefa(tarefaTO.getCodConfigTarefa());
	// Collection listaItems;
	// listaItems =
	// conteudoItemTarefaBO.consultarItemsPRO(conteudoItemTarefaTO);
	// request.getSession().setAttribute("listaItems",listaItems);
	// return mapping.findForward("sucesso");
	// }
	// catch (Exception e) {
	// setErro("pro.erro.item.incluir", e.getMessage(),request);
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
	// ConteudoItemTarefaBO conteudoItemTarefaBO = new ConteudoItemTarefaBO();
	// ConteudoItemTarefaForm conteudoItemTarefaForm = (ConteudoItemTarefaForm)
	// form;
	// Collection lista = (Collection)
	// request.getSession().getAttribute("listaItems");
	// Iterator iter = lista.iterator();
	// int i=0;
	// while (iter.hasNext()) {
	// ConteudoItemTarefaTO conteudoItemTarefaTO = new ConteudoItemTarefaTO();
	// ConteudoItemTarefaTO conteudoItemTarefaTOIter = (ConteudoItemTarefaTO)
	// iter.next();
	// if (i<conteudoItemTarefaForm.getAnoCriacao().length){
	// conteudoItemTarefaTO.setAnoCriacao(conteudoItemTarefaForm.getAnoCriacao()[i]);
	// conteudoItemTarefaTO.setCodConfigTarefa(conteudoItemTarefaForm.getCodConfigTarefa()[i]);
	// conteudoItemTarefaTO.setNumeroOrdem(conteudoItemTarefaForm.getNumeroOrdem()[i]);
	// conteudoItemTarefaTO.setTextoItemTarefa(conteudoItemTarefaForm.getTextoItemTarefa()[i]);
	// conteudoItemTarefaTO.setAnoCriacao(conteudoItemTarefaTOIter.getAnoCriacao());
	// conteudoItemTarefaTO.setCodTarefa(conteudoItemTarefaTOIter.getCodTarefa());
	// conteudoItemTarefaBO.excluirItemTarefa(conteudoItemTarefaTO,tarefaTO);
	// }
	// i++;
	// }
	// TarefaBO tarefaBO = new TarefaBO();/*Se alterar item da tarefa, deve
	// alterar o timestamp de alteracao da tarefa.*/
	// tarefaBO.alterarDataAlteracao(tarefaTO);
	// setMensagem("pro.sucesso.item.incluir",request);
	// return mapping.findForward("sucesso");
	// }
	// catch (Exception e) {
	// setErro("pro.erro.item.incluir", e.getMessage(),request);
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
			ConteudoItemTarefaTO conteudoItemTarefaTO = new ConteudoItemTarefaTO();
			conteudoItemTarefaTO.setNumeroOrdem(numOrdem);
			conteudoItemTarefaTO.setAnoCriacao(tarefaTO.getAnoCriacao());
			conteudoItemTarefaTO.setCodTarefa(tarefaTO.getCodigo());
			conteudoItemTarefaTO.setCodConfigTarefa(tarefaTO.getCodConfigTarefa());
			ConteudoItemTarefaBO conteudoItemTarefaBO = new ConteudoItemTarefaBO();
			conteudoItemTarefaTO.setTextoItemTarefa(texto);
			if (conteudoItemTarefaBO.consultarItemCritico(conteudoItemTarefaTO).isEmpty()) {
				conteudoItemTarefaBO.incluir(conteudoItemTarefaTO);
			} else {
				conteudoItemTarefaBO.alterar(conteudoItemTarefaTO);
			}

			response.sendRedirect(request.getContextPath()
							+ "/tarefa/encaminhar/alterar.do?op=encaminharAlterar&anoCriacao="
							+ tarefaTO.getAnoCriacao() + "&codigo="
							+ tarefaTO.getCodigo());
			return null;
		} catch (Exception e) {
			setErro("pro.erro.item.incluir", e.getMessage(), request);
			return mapping.findForward("erro");
		}
	}

}
