package br.com.intraPRO.anexo.controle;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.intraBSC.modelo.UsuarioTO;
import br.com.intraBSC.negocio.UsuarioBO;
import br.com.intraPRO.anexo.visao.AnexoForm;
import br.com.intraPRO.controle.DispatchActionPRO;
import br.com.intraPRO.excecoes.ExceptionPRO;
import br.com.intraPRO.excecoes.ExceptionNegocioPRO;
import br.com.intraPRO.modelo.AnexoTO;
import br.com.intraPRO.modelo.TarefaTO;
import br.com.intraPRO.negocio.AnexoBO;
import br.com.intraPRO.negocio.TarefaBO;
import br.com.intraPRO.util.Util;

/**
 * Classe que faz o controle das chamadas de metodos para a BO. Controle de
 * Anexos.
 */
public class AnexoAction extends DispatchActionPRO {

	private static final int TAMANHO_MAXIMO_ARQUIVO = 1024 * 1000 * 10;

	private static final int CAPACIDADE_MAXIMA_ARQUIVO_TAREFA = 1024 * 1000 * 50;

	public AnexoAction() {
	}

	public ActionForward incluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws ExceptionNegocioPRO {
		try {
			AnexoForm anexoForm = (AnexoForm) form;
			AnexoTO anexoTO = new AnexoTO();
			AnexoBO anexoBO = new AnexoBO();
			anexoForm.setAnexoTO(anexoTO);
			UsuarioTO usuarioTO = UsuarioBO.getUsuarioTO(response,request);
			anexoTO.setCodUsuario(usuarioTO.getIdUsuario());
			AnexoTO anexoTOConsulta = new AnexoTO();
			anexoTOConsulta.setAnoCriacao(anexoTO.getAnoCriacao());
			anexoTOConsulta.setNumeroSequencialTarefa(anexoTO.getNumeroSequencialTarefa());
			if (anexoTO.getArquivo() != null) {
				String nomeArq = anexoTO.getArquivo().getFileName();
				String extensao = nomeArq.substring(nomeArq.indexOf(".")+1,nomeArq.length());
				if (extensao.equalsIgnoreCase("exe") || extensao.equalsIgnoreCase("PIF") || extensao.equalsIgnoreCase("BAT") || extensao.equalsIgnoreCase("COM")) {
					setErro("pro.anexo.erro.anexoInvalido", extensao, request);
					Collection anexos = anexoBO.consultarVarios(anexoTOConsulta);
					request.setAttribute("listaAnexos", anexos);
					return mapping.findForward("erro");
				}
			}
			validaTamanhoArquivo(form);
			anexoBO.incluir(anexoTO);
			TarefaTO tarefaTO = (TarefaTO) request.getSession().getAttribute("tarefaTO");
			anexoForm.setNumeroNomeTarefa("Tarefa: " + tarefaTO.getCodigoAno() + " - " + tarefaTO.getNome());
			Collection anexos = anexoBO.consultarVarios(anexoTOConsulta);
			
			double tamanhoDisponivel = ((double) ((CAPACIDADE_MAXIMA_ARQUIVO_TAREFA - getEspacoUtilizado(anexos)) / 1024));
			if(tamanhoDisponivel>1000){
				DecimalFormat formato = new DecimalFormat("0");
				anexoForm.setCapacidadeDisponivel("Espaço disponível na tarefa: " + formato.format(tamanhoDisponivel/1000) + " Mb");
			}else{
				DecimalFormat formato = new DecimalFormat("0");
				anexoForm.setCapacidadeDisponivel("Espaço disponível na tarefa: " + formato.format(tamanhoDisponivel) + " Kb");
			}
			if (!anexos.isEmpty())
				request.getSession().setAttribute("listaAnexos", anexos);
			 /*Se alterar item da tarefa, deve alterar o timestamp de alteracao da tarefa.*/
            TarefaBO tarefaBO = new TarefaBO();            
            tarefaBO.alterarDataAlteracao(tarefaTO);
			
		} catch (Exception e) {
			setErro("pro.anexo.erro.anexo.tamanho.invalido", e.getMessage(), request);
			return mapping.findForward("erro");
		}
		setMensagem("pro.sucesso.anexo.incluir", request);	
		return mapping.findForward("sucesso");
	}

	public ActionForward encaminharIncluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		try {
			Util.alterarTarefa(request,response);
			AnexoForm anexoForm = (AnexoForm) form;
			AnexoBO anexoBO = new AnexoBO();
			AnexoTO anexoTO = new AnexoTO();

			request.getSession().removeAttribute("listaAnexos");
			
			TarefaTO tarefaTO = (TarefaTO) request.getSession().getAttribute("tarefaTO");

			anexoForm.setAnoCriacao(String.valueOf(tarefaTO.getAnoCriacao()));
			anexoForm.setNumeroSequencialTarefa(tarefaTO.getCodigo());
			anexoForm.setNomeTarefa(tarefaTO.getNome());

			anexoForm.setAnexoTO(anexoTO);
			anexoForm.setEstado(request.getParameter("codEstado"));

			anexoForm.setNumeroNomeTarefa("Tarefa: " + tarefaTO.getCodigoAno() + " - " + tarefaTO.getNome());

			anexoTO.setAnoCriacao(String.valueOf(tarefaTO.getAnoCriacao()));
			anexoTO.setNumeroSequencialTarefa(tarefaTO.getCodigo());

			Collection anexos = anexoBO.consultarVarios(anexoTO);

			double tamanhoDisponivel = ((double) ((CAPACIDADE_MAXIMA_ARQUIVO_TAREFA - getEspacoUtilizado(anexos)) / 1024));
			if(tamanhoDisponivel>1000){
				DecimalFormat formato = new DecimalFormat("0");
				anexoForm.setCapacidadeDisponivel("Espaço disponível na tarefa: " + formato.format(tamanhoDisponivel/1000) + " Mb");
			}else{
				DecimalFormat formato = new DecimalFormat("0");
				anexoForm.setCapacidadeDisponivel("Espaço disponível na tarefa: " + formato.format(tamanhoDisponivel) + " Kb");
			}
			if (!anexos.isEmpty())
				request.getSession().setAttribute("listaAnexos", anexos);

		} catch (ExceptionNegocioPRO e) {
			setErro("pro.anexo.erro.buscarDados", request);
			log.error(e.getMessage());
			return mapping.findForward("erro");
		} catch (Exception e) {
			setErro("pro.anexo.erro.buscarDados", request);
			log.error(e.getMessage());
			return mapping.findForward("erro");
		}

		return mapping.findForward("sucesso");
	}

	public ActionForward consultarVarios(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return mapping.findForward("sucesso");
	}

	public ActionForward consultarUm(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return mapping.findForward("sucesso");
	}

	public ActionForward excluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		try {
			AnexoForm anexoForm = (AnexoForm) form;
			AnexoBO anexoBO = new AnexoBO();
			AnexoTO anexoTO = new AnexoTO();
			anexoTO.setAnoCriacao(anexoForm.getAnoCriacao());
			anexoTO.setNumeroSequencialTarefa(anexoForm.getNumeroSequencialTarefa());
			for (int i = 0; i < anexoForm.getListaExcluir().length; i++) {
				if (anexoForm.getListaExcluir()[i] > 0) {
					anexoTO.setNumeroSequencialArquivo(anexoForm.getListaExcluir()[i]);
					anexoBO.excluir(anexoTO);
				}
			}
			anexoTO.setNumeroSequencialArquivo(0);
			
			Collection anexos = anexoBO.consultarVarios(anexoTO);

			if (!anexos.isEmpty())
				request.getSession().setAttribute("listaAnexos", anexos);
			
			 /*Se alterar item da tarefa, deve alterar o timestamp de alteracao da tarefa.*/
            TarefaBO tarefaBO = new TarefaBO(); 
            TarefaTO tarefaTO = new TarefaTO();
            tarefaTO.setAnoCriacao(Integer.parseInt(anexoTO.getAnoCriacao()));
            tarefaTO.setCodigo(anexoTO.getNumeroSequencialTarefa());
            tarefaBO.alterarDataAlteracao(tarefaTO);
            
		} catch (ExceptionPRO e) {
			setErro("pro.anexo.erro.anexo.selecione.arquivo", e.getMessage(), request);
			log.error(e.getMessage());
			return mapping.findForward("erro");
		}
		return encaminharIncluir(mapping, form, request, response);
	}

	
	public ActionForward download(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws ExceptionNegocioPRO {
		try {
			AnexoForm anexoForm = (AnexoForm) form;
			AnexoTO anexoTO = new AnexoTO();
			anexoForm.setAnexoTO(anexoTO);
			AnexoBO anexoBO = new AnexoBO();

			AnexoTO anexoTO2 = new AnexoTO();// Define na anexoTO os dados do arquivo
			anexoTO2 = anexoBO.download(anexoTO);
			if (anexoTO2.getByteAnexo().length == 0) {
				throw new ExceptionPRO("Anexo não encontrado.");
			}			
			response.reset();// Limpando o conteúdo do response
			response.setHeader("Content-Disposition", "attachment; filename=" + anexoTO2.getNome());// Tamanho em bytes do binário
			response.setContentType("application/download");// Definindo o contentType do arquivo para sempre realizar o download, não abrir diretamente
			response.getOutputStream().write(anexoTO2.getByteAnexo());// Enviando os bytes do arquivo para o response
			response.getOutputStream().close();// Fechado a outputstream do response

		} catch (ExceptionNegocioPRO e) {
			setErro("pro.anexo.erro.anexo.download", e.getMessage(), request);
			log.error(e.getMessage());
			return mapping.findForward("erro");
		} catch (IOException e) {
			setErro("pro.anexo.erro.anexo.download", e.getMessage(), request);
			log.error(e.getMessage());
			return mapping.findForward("erro");
		} catch (Exception e) {
			setErro("pro.anexo.erro.anexo.download", e.getMessage(), request);
			log.error(e.getMessage());
			return mapping.findForward("erro");
		}
		
		
		
		return mapping.findForward("sucesso");
	}

	private void validaTamanhoArquivo(ActionForm form) throws Exception {
		AnexoForm anexoForm = (AnexoForm) form;
		AnexoTO anexoTO = new AnexoTO();
		anexoTO.setAnoCriacao(anexoForm.getAnoCriacao());
		anexoTO.setNumeroSequencialTarefa(anexoForm.getNumeroSequencialTarefa());
		AnexoBO anexoBO = new AnexoBO();

		int tamanhoArquivo = 0;
		int tamanhoTodosAquivos = 0;
		tamanhoArquivo = anexoForm.getArquivo().getFileSize();
		if (tamanhoArquivo > TAMANHO_MAXIMO_ARQUIVO) {
			throw new ExceptionPRO("Tamanho máximo do anexo é 10 Mb.");
		}
		Collection anexos = anexoBO.consultarVarios(anexoTO);
		tamanhoTodosAquivos = tamanhoArquivo + getEspacoUtilizado(anexos);
		int tamanhoDisponivel = CAPACIDADE_MAXIMA_ARQUIVO_TAREFA - tamanhoTodosAquivos;
		double tamanhoMega = tamanhoDisponivel / 1024;
		DecimalFormat formato = new DecimalFormat("0");
		if (tamanhoTodosAquivos > CAPACIDADE_MAXIMA_ARQUIVO_TAREFA) {
			throw new ExceptionPRO("O espaço disponível para a inclusão de anexos é de " + formato.format(tamanhoMega) + " Mb.");
		}

	}

	private int getEspacoUtilizado(Collection anexos) {
		int tamanhoTodosAquivos = 0;
		double tamanhoArquivo = 0;
		Iterator iteracao = anexos.iterator();

		while (iteracao.hasNext()) {
			AnexoTO anexoTO = (AnexoTO) iteracao.next();
			tamanhoArquivo = anexoTO.getQuantByteAnexo();
			DecimalFormat formato = new DecimalFormat("0");
			anexoTO.setTamanho(formato.format((tamanhoArquivo / 1024)) + "Kb");
			tamanhoTodosAquivos += tamanhoArquivo;
		}
		return tamanhoTodosAquivos;
	}

}