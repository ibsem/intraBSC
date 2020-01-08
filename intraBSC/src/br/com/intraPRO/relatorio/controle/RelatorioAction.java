package br.com.intraPRO.relatorio.controle;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import net.sf.jasperreports.engine.JasperPrint;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.intraPRO.controle.DispatchActionPRO;
import br.com.intraPRO.modelo.RelatorioTO;
import br.com.intraPRO.negocio.RelatorioBO;
import br.com.intraPRO.relatorio.visao.RelatorioForm;
import br.com.intraPRO.util.Arquivo;



public class RelatorioAction  extends DispatchActionPRO{

	public ActionForward listaTarefa(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {				
		try {
			RelatorioForm relatorioForm = (RelatorioForm) form;
   			RelatorioBO relatorioBO = new RelatorioBO();	   			
   			RelatorioTO relatorioTO = new RelatorioTO();
   			relatorioTO.setTransicao(request.getSession().getServletContext().getRealPath("/relatorios/rel_resumo_tarefa_3.jasper"));
   			relatorioTO.setBaseDir(request.getSession().getServletContext().getRealPath(""));
   			relatorioTO.setChaveSolicitante(relatorioForm.getChaveSolicitante().toUpperCase());
   			relatorioTO.setChaveParticipante(relatorioForm.getChaveParticipante().toUpperCase());
   			relatorioTO.setNomeSolicitante(relatorioForm.getNomeSolicitante().toUpperCase());
   			relatorioTO.setNomeParticipante(relatorioForm.getNomeParticipante().toUpperCase());
   			JasperPrint jasperRelatorio = relatorioBO.listaTarefa(relatorioTO);
   			
   			request.getSession().setAttribute("RELATORIO", jasperRelatorio);
   			   			   		   		
		} catch (Exception e) {
			setErro("pro.relatorio.gerenteGeral",e.getMessage(),request);	
			return mapping.findForward("erro");
		}
		return mapping.findForward("sucesso");
		
	}
	
	public ActionForward listaTarefaExecutante(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {				
		try {
			RelatorioForm relatorioForm = (RelatorioForm) form;
   			RelatorioBO relatorioBO = new RelatorioBO();	   			
   			RelatorioTO relatorioTO = new RelatorioTO();
   			relatorioTO.setTransicao(request.getSession().getServletContext().getRealPath("/relatorios/rel_resumo_tarefa_1.jasper"));
   			relatorioTO.setBaseDir(request.getSession().getServletContext().getRealPath(""));
   			relatorioTO.setChaveSolicitante(relatorioForm.getChaveSolicitante().toUpperCase());
   			relatorioTO.setChaveParticipante(relatorioForm.getChaveParticipante().toUpperCase());
   			relatorioTO.setNomeSolicitante(relatorioForm.getNomeSolicitante().toUpperCase());
   			relatorioTO.setNomeParticipante(relatorioForm.getNomeParticipante().toUpperCase());
   			JasperPrint jasperRelatorio = relatorioBO.listaTarefaExecutante(relatorioTO);
   			
   			request.getSession().setAttribute("RELATORIO", jasperRelatorio);
   			   			   		   		
		} catch (Exception e) {
			setErro("pro.relatorio.gerenteGeral",e.getMessage(),request);	
			return mapping.findForward("erro");
		}
		return mapping.findForward("sucesso");
		
	}
	
	public ActionForward listaTarefaParticipante(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {				
		try {
			RelatorioForm relatorioForm = (RelatorioForm) form;
   			RelatorioBO relatorioBO = new RelatorioBO();	   			
   			RelatorioTO relatorioTO = new RelatorioTO();
   			relatorioTO.setTransicao(request.getSession().getServletContext().getRealPath("/relatorios/rel_resumo_tarefa_2.jasper"));
   			relatorioTO.setBaseDir(request.getSession().getServletContext().getRealPath(""));
   			relatorioTO.setChaveSolicitante(relatorioForm.getChaveSolicitante().toUpperCase());
   			relatorioTO.setChaveParticipante(relatorioForm.getChaveParticipante().toUpperCase());
   			relatorioTO.setNomeSolicitante(relatorioForm.getNomeSolicitante().toUpperCase());
   			relatorioTO.setNomeParticipante(relatorioForm.getNomeParticipante().toUpperCase());
   			JasperPrint jasperRelatorio = relatorioBO.listaTarefaParticipante(relatorioTO);
   			
   			request.getSession().setAttribute("RELATORIO", jasperRelatorio);
   			   			   		   		
		} catch (Exception e) {
			setErro("pro.relatorio.gerenteGeral",e.getMessage(),request);	
			return mapping.findForward("erro");
		}
		return mapping.findForward("sucesso");
		
	}
	
	public ActionForward listaTarefaAnotacao(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {				
		try {
			RelatorioForm relatorioForm = (RelatorioForm) form;
   			RelatorioBO relatorioBO = new RelatorioBO();	   			
   			RelatorioTO relatorioTO = new RelatorioTO();
   			relatorioTO.setTransicao(request.getSession().getServletContext().getRealPath("/relatorios/relatorioListaTarefasAnotacao.jasper"));
   			relatorioTO.setBaseDir(request.getSession().getServletContext().getRealPath(""));
   			relatorioTO.setChaveSolicitante(relatorioForm.getChaveSolicitante().toUpperCase());
   			relatorioTO.setChaveParticipante(relatorioForm.getChaveParticipante().toUpperCase());
   			relatorioTO.setNomeSolicitante(relatorioForm.getNomeSolicitante().toUpperCase());
   			relatorioTO.setNomeParticipante(relatorioForm.getNomeParticipante().toUpperCase());
   			JasperPrint jasperRelatorio = relatorioBO.listaTarefa(relatorioTO);
   			
   			request.getSession().setAttribute("RELATORIO", jasperRelatorio);
   			   			   		   		
		} catch (Exception e) {
			setErro("pro.relatorio.gerenteGeral",e.getMessage(),request);	
			return mapping.findForward("erro");
		}
		return mapping.findForward("sucesso");
		
	}
	
	public ActionForward listaTarefaAnotacaoExecutante(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {				
		try {
			RelatorioForm relatorioForm = (RelatorioForm) form;
   			RelatorioBO relatorioBO = new RelatorioBO();	   			
   			RelatorioTO relatorioTO = new RelatorioTO();
   			relatorioTO.setTransicao(request.getSession().getServletContext().getRealPath("/relatorios/relatorioListaTarefasAnotacaoExecutante.jasper"));
   			relatorioTO.setBaseDir(request.getSession().getServletContext().getRealPath(""));
   			relatorioTO.setChaveSolicitante(relatorioForm.getChaveSolicitante().toUpperCase());
   			relatorioTO.setChaveParticipante(relatorioForm.getChaveParticipante().toUpperCase());
   			relatorioTO.setNomeSolicitante(relatorioForm.getNomeSolicitante().toUpperCase());
   			relatorioTO.setNomeParticipante(relatorioForm.getNomeParticipante().toUpperCase());
   			JasperPrint jasperRelatorio = relatorioBO.listaTarefaExecutante(relatorioTO);
   			
   			request.getSession().setAttribute("RELATORIO", jasperRelatorio);
   			   			   		   		
		} catch (Exception e) {
			setErro("pro.relatorio.gerenteGeral",e.getMessage(),request);	
			return mapping.findForward("erro");
		}
		return mapping.findForward("sucesso");
		
	}
	
	public ActionForward listaTarefaAnotacaoParticipante(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {				
		try {
			RelatorioForm relatorioForm = (RelatorioForm) form;
   			RelatorioBO relatorioBO = new RelatorioBO();	   			
   			RelatorioTO relatorioTO = new RelatorioTO();
   			relatorioTO.setTransicao(request.getSession().getServletContext().getRealPath("/relatorios/relatorioListaTarefasAnotacaoParticipante.jasper"));
   			relatorioTO.setBaseDir(request.getSession().getServletContext().getRealPath(""));
   			relatorioTO.setChaveSolicitante(relatorioForm.getChaveSolicitante().toUpperCase());
   			relatorioTO.setChaveParticipante(relatorioForm.getChaveParticipante().toUpperCase());
   			relatorioTO.setNomeSolicitante(relatorioForm.getNomeSolicitante().toUpperCase());
   			relatorioTO.setNomeParticipante(relatorioForm.getNomeParticipante().toUpperCase());
   			JasperPrint jasperRelatorio = relatorioBO.listaTarefaParticipante(relatorioTO);
   			
   			request.getSession().setAttribute("RELATORIO", jasperRelatorio);
   			   			   		   		
		} catch (Exception e) {
			setErro("pro.relatorio.gerenteGeral",e.getMessage(),request);	
			return mapping.findForward("erro");
		}
		return mapping.findForward("sucessoResumo");
		
	}

	public ActionForward agendaTarefa(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {				
		try {
			RelatorioForm relatorioForm = (RelatorioForm) form;
   			RelatorioBO relatorioBO = new RelatorioBO();	   			
   			RelatorioTO relatorioTO = new RelatorioTO();
   			relatorioTO.setChaveSolicitante(relatorioForm.getChaveSolicitante().toUpperCase());
   			relatorioTO.setChaveParticipante(relatorioForm.getChaveParticipante().toUpperCase());
   			relatorioTO.setNomeSolicitante(relatorioForm.getNomeSolicitante().toUpperCase());
   			relatorioTO.setNomeParticipante(relatorioForm.getNomeParticipante().toUpperCase());
   			
   			
   			if ((!relatorioTO.getChaveSolicitante().equals("")) && (relatorioTO.getChaveParticipante().equals("")))
   				relatorioTO.setTransicao(request.getSession().getServletContext().getRealPath("/relatorios/rel_planejamento_agenda_1.jasper"));   			
   			else if ((relatorioTO.getChaveSolicitante().equals("")) && (!relatorioTO.getChaveParticipante().equals("")))
   				relatorioTO.setTransicao(request.getSession().getServletContext().getRealPath("/relatorios/rel_planejamento_agenda_2.jasper"));
   			else if ((!relatorioTO.getChaveSolicitante().equals("")) && (!relatorioTO.getChaveParticipante().equals("")))
   				relatorioTO.setTransicao(request.getSession().getServletContext().getRealPath("/relatorios/rel_planejamento_agenda_3.jasper"));
   			
   			relatorioTO.setBaseDir(request.getSession().getServletContext().getRealPath(""));
   		   	
   			JasperPrint jasperRelatorio = relatorioBO.agendaTarefa(relatorioTO);
   			
   			request.getSession().setAttribute("RELATORIO", jasperRelatorio);
   			   			   		   		
		} catch (Exception e) {
			setErro("pro.relatorio.gerenteGeral",e.getMessage(),request);	
			return mapping.findForward("erro");
		}
		return mapping.findForward("sucesso");
		
	}

	public ActionForward ganttTarefa(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {				
		try {
			RelatorioForm relatorioForm = (RelatorioForm) form;
   			RelatorioBO relatorioBO = new RelatorioBO();	   			
   			RelatorioTO relatorioTO = new RelatorioTO();
   			relatorioTO.setChaveSolicitante(relatorioForm.getChaveSolicitante().toUpperCase());
   			relatorioTO.setChaveParticipante(relatorioForm.getChaveParticipante().toUpperCase());
   			relatorioTO.setNomeSolicitante(relatorioForm.getNomeSolicitante().toUpperCase());
   			relatorioTO.setNomeParticipante(relatorioForm.getNomeParticipante().toUpperCase());
   			relatorioTO.setDataPrazo(relatorioForm.getDataPrazo());
   			
   			relatorioTO.setTransicao(request.getSession().getServletContext().getRealPath("/relatorios/rel_planejamento_gantt_1.jasper"));   			
   			
   			relatorioTO.setBaseDir(request.getSession().getServletContext().getRealPath(""));
   			
   			//request.getSession().setAttribute("BASEDIR", relatorioTO.getBaseDir());
   		   	
   			JasperPrint jasperRelatorio = relatorioBO.ganttTarefa(relatorioTO);
   			
   			request.getSession().setAttribute("RELATORIO", jasperRelatorio);
   			   			   		   		
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			setErro("pro.relatorio.gerenteGeral",e.getMessage(),request);	
			return mapping.findForward("erro");
		}
		return mapping.findForward("sucesso");
		
	}
	
	public ActionForward downloadFolderGrupo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {				
		try {
			String transicao = request.getSession().getServletContext().getRealPath("/arquivos/IntraBSCGrupo.pdf");
			File arquivo = new File(transicao);			
			Arquivo.download(arquivo,arquivo.getName(),response);
 			   			   		   		
		} catch (Exception e) {
			setErro("pro.relatorio.gerenteGeral",e.getMessage(),request);	
			return mapping.findForward("erro");
		}
		return mapping.findForward("sucesso");
	}
	public ActionForward downloadFolderTecnico(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {				
		try {
			String transicao = request.getSession().getServletContext().getRealPath("/arquivos/IntraBSCTecnico.pdf");
			File arquivo = new File(transicao);			
			Arquivo.download(arquivo,arquivo.getName(),response);
 			   			   		   		
		} catch (Exception e) {
			setErro("pro.relatorio.gerenteGeral",e.getMessage(),request);	
			return mapping.findForward("erro");
		}
		return mapping.findForward("sucesso");
	}
	public ActionForward downloadManualOperacao(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {				
		try {
			String transicao = request.getSession().getServletContext().getRealPath("/arquivos/IntraBSCManualdeOperacao.pdf");
			File arquivo = new File(transicao);			
			Arquivo.download(arquivo,arquivo.getName(),response);
 			   			   		   		
		} catch (Exception e) {
			setErro("pro.relatorio.gerenteGeral",e.getMessage(),request);	
			return mapping.findForward("erro");
		}
		return mapping.findForward("sucesso");
	}
	public ActionForward downloadFolderProduto(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {				
		try {
			String transicao = request.getSession().getServletContext().getRealPath("/arquivos/IntraBSCProduto.pdf");
			File arquivo = new File(transicao);			
			Arquivo.download(arquivo,arquivo.getName(),response);
 			   			   		   		
		} catch (Exception e) {
			setErro("pro.relatorio.gerenteGeral",e.getMessage(),request);	
			return mapping.findForward("erro");
		}
		return mapping.findForward("sucesso");
	}
	

	
	public ActionForward encaminharPesquisa(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {				
		try{			
			
			request.getSession().removeAttribute("relatorioForm");
			
		} catch (Exception e) {
			setErro("pro.erro.tarefa.pesquisa",e.getMessage(),request);	
			return mapping.findForward("erro");
		}
		return mapping.findForward("sucesso");
		
	}
	
}
