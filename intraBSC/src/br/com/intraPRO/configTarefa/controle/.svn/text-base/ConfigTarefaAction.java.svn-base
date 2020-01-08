package br.com.intraPRO.configTarefa.controle;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.intraBSC.modelo.UsuarioTO;
import br.com.intraBSC.negocio.UsuarioBO;
import br.com.intraPRO.configTarefa.visao.ConfigTarefaForm;
import br.com.intraPRO.controle.DispatchActionPRO;
import br.com.intraPRO.modelo.ConfigTarefaTO;
import br.com.intraPRO.modelo.FormularioTO;
import br.com.intraPRO.modelo.ItemTO;
import br.com.intraPRO.modelo.ParticipanteConfigTarefaTO;
import br.com.intraPRO.negocio.ConfigTarefaBO;
import br.com.intraPRO.negocio.FormularioBO;
import br.com.intraPRO.negocio.ItemBO;
import br.com.intraPRO.negocio.ParticipanteConfigTarefaBO;
import br.com.intraPRO.util.Util;

public class ConfigTarefaAction extends DispatchActionPRO{
  
   
   public ConfigTarefaAction(){
   }
		
	   public ActionForward incluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
			try{
				ConfigTarefaForm configTarefaForm = (ConfigTarefaForm) form;
			   	ConfigTarefaTO configTarefaTO = new ConfigTarefaTO();
			   	ConfigTarefaBO configTarefaBO = new ConfigTarefaBO();
			   	configTarefaForm.setConfigTarefaTO(configTarefaTO);
			   	configTarefaTO.setIdResponsavel(configTarefaForm.getIdResponsavel());
				configTarefaBO.incluir(configTarefaTO);
				configTarefaForm.setConfigTarefaForm(configTarefaTO);
				request.getSession().setAttribute("codConfigTarefa",new Integer(configTarefaTO.getCodigoConfigTarefa()));				
			}
		   	catch (Exception e) {
				setErro("pro.erro.configTarefa.incluir", e.getMessage(),request);
				return mapping.findForward("erro");
		   	}
		   	setMensagem("pro.sucesso.configTarefa.incluir",request);
		   	return mapping.findForward("sucesso");
	   }
   
	   public ActionForward consultarUm(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		   	try{
		   		/*Consultar Responsavel*/
			    UsuarioBO usuarioBO = new UsuarioBO();
			    UsuarioTO usuarioTO = new UsuarioTO();
			    usuarioTO.setGrupoTO(UsuarioBO.getUsuarioTO().getGrupoTO());
			    request.setAttribute("listaResponsavel",usuarioBO.consultarUsuarioGrupo(usuarioTO));
		   		ConfigTarefaForm configTarefaForm = (ConfigTarefaForm) form;
			   	ConfigTarefaTO configTarefaTO = new ConfigTarefaTO();
			   	ConfigTarefaBO configTarefaBO = new ConfigTarefaBO();
			   	if (configTarefaForm.getCodigoConfigTarefa() != 0){
			   		configTarefaTO.setCodigoConfigTarefa(configTarefaForm.getCodigoConfigTarefa());
			   	}else if (request.getSession().getAttribute("codConfigTarefa") != null){
			   		configTarefaTO.setCodigoConfigTarefa(Integer.parseInt(request.getSession().getAttribute("codConfigTarefa").toString()));
			   		request.getSession().removeAttribute("codConfigTarefa");
			   	}
			   	configTarefaTO.setIdResponsavel(configTarefaForm.getIdResponsavel());
			   	ConfigTarefaTO resultado = configTarefaBO.consultarUm(configTarefaTO);
		   	   	configTarefaForm.setConfigTarefaForm(resultado);
		   	   	request.getSession().setAttribute("configTarefaForm",configTarefaForm);
		   	   	ItemBO itemBO = new ItemBO();/*Consulta de Item relacionado a um determinado tipo de tarefa*/
		   	   	ItemTO itemTO = new ItemTO();
		   	   	itemTO.setCodConfigTarefa(configTarefaForm.getCodigoConfigTarefa());
		   	   	request.setAttribute("listaItems",itemBO.consultarVarios(itemTO));
		   	   	
		   	   	FormularioBO formularioBO = new FormularioBO();/*Consulta de Formulario relacionado a um determinado tipo de tarefa*/
		   	   	FormularioTO formularioTO = new FormularioTO();
		   	   	formularioTO.setCodConfigTarefa(configTarefaForm.getCodigoConfigTarefa());
		   	   	request.setAttribute("listaFormularios",formularioBO.consultarVarios(formularioTO));
		   	   	
		   	   	
		   	   	
		   	   	request.getSession().setAttribute("configTarefaTO",configTarefaTO);
		   	   	
		   	   	ParticipanteConfigTarefaBO participanteConfigTarefaBO = new ParticipanteConfigTarefaBO();/*Executa a pesquisa de participande de tipo de tarefa(Executante)*/
		   	   	ParticipanteConfigTarefaTO participanteConfigTarefaTO = new ParticipanteConfigTarefaTO();
		   	   	participanteConfigTarefaTO.setCodConfigTarefa(configTarefaForm.getCodigoConfigTarefa());
		   	   	request.setAttribute("listaTipoParticipanteExecutante",participanteConfigTarefaBO.consultarVarios(participanteConfigTarefaTO));
		   	   	
		   	} catch(Exception e){
		   		setErro("pro.erro.configTarefa.pesquisar", e.getMessage(),request);
				return mapping.findForward("erro");
		   	}
		   	return mapping.findForward("sucesso");
	   }
	   
	  
	   public ActionForward alterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		   	ConfigTarefaForm configTarefaForm = (ConfigTarefaForm) form;
		   	ConfigTarefaTO configTarefaTO = new ConfigTarefaTO();
		   	ConfigTarefaBO configTarefaBO = new ConfigTarefaBO();
		   	configTarefaForm.setConfigTarefaTO(configTarefaTO);
		   	try{
		   		configTarefaTO.setIdResponsavel(configTarefaForm.getIdResponsavel());
		   	   	configTarefaBO.alterar(configTarefaTO);   		
		   		setMensagem("pro.configTarefa.alterar.sucesso",request);
		   	}
		   	catch(Exception e){
				setErro("pro.erro.configTarefa.incluir", e.getMessage(),request);
				return mapping.findForward("erro");
		   	}
			ItemBO itemBO = new ItemBO();/*Consulta de Item relacionado a um determinado tipo de tarefa*/
	   	   	ItemTO itemTO = new ItemTO();
	   	   	itemTO.setCodConfigTarefa(configTarefaForm.getCodigoConfigTarefa());
	   	   	request.setAttribute("listaItems",itemBO.consultarVarios(itemTO));
	   	
	   		FormularioBO formularioBO = new FormularioBO();/*Consulta de Item relacionado a um determinado tipo de tarefa*/
	   	   	FormularioTO formularioTO = new FormularioTO();
	   	   	formularioTO.setCodConfigTarefa(configTarefaForm.getCodigoConfigTarefa());
	   	   	request.setAttribute("listaFormularios",formularioBO.consultarVarios(formularioTO));
	   	
	   	   	
	   	   	
	   	   	ParticipanteConfigTarefaBO participanteConfigTarefaBO = new ParticipanteConfigTarefaBO();/*Executa a pesquisa de participande de tipo de tarefa(Executante)*/
	   	   	ParticipanteConfigTarefaTO participanteConfigTarefaTO = new ParticipanteConfigTarefaTO();
	   	   	participanteConfigTarefaTO.setCodConfigTarefa(configTarefaForm.getCodigoConfigTarefa());
	   	   	request.setAttribute("listaTipoParticipanteExecutante",participanteConfigTarefaBO.consultarVarios(participanteConfigTarefaTO));
	   	   	
	   	   	/*Consultar Responsavel*/
		    UsuarioBO usuarioBO = new UsuarioBO();
		    UsuarioTO usuarioTO = new UsuarioTO();
		    usuarioTO.setGrupoTO(UsuarioBO.getUsuarioTO().getGrupoTO());
		    request.setAttribute("listaResponsavel",usuarioBO.consultarVarios(usuarioTO));
	   	   	
		   	return mapping.findForward("sucesso");
	   }

	   
	   public ActionForward consultarVarios(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		   	ConfigTarefaForm configTarefaForm = (ConfigTarefaForm) form;
		   	ConfigTarefaTO configTarefaTO = new ConfigTarefaTO();
		   	ConfigTarefaBO configTarefaBO = new ConfigTarefaBO();
		   	configTarefaForm.setConfigTarefaTO(configTarefaTO);
		   	configTarefaTO.setUsuarioTO(UsuarioBO.getUsuarioTO());
		   	try {
		   		Collection result = configTarefaBO.consultarVariosPorGrupo(configTarefaTO);
		   		if (!result.isEmpty()){
		   			request.setAttribute("listaConfigTarefa",result);		   		
		   		}else{
		   			setMensagem("pro.configTarefa.listaVaiza",request);
		   		}
		   		return mapping.findForward("sucesso");
			} catch (Exception e) {
				setErro("pro.erro.configTarefa.pesquisar",e.getMessage(),request);		
				return mapping.findForward("erro");
			} 			
	   }
	   
	   public ActionForward encaminharConsultaParticipante(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {		   	
		   	try {
		   		/*Metodo somente para redicionar tela de pesquisa.*/
		   		return mapping.findForward("sucesso");
			} catch (Exception e) {
				setErro("pro.erro.configTarefa.pesquisar",e.getMessage(),request);		
				return mapping.findForward("erro");
			} 
			
	   }
	   
	   public ActionForward encaminharIncluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {										
			try {
				/*Consultar Responsavel*/
			    UsuarioBO usuarioBO = new UsuarioBO();
			    UsuarioTO usuarioTO = new UsuarioTO();
			    usuarioTO.setGrupoTO(UsuarioBO.getUsuarioTO().getGrupoTO());
			    request.setAttribute("listaResponsavel",usuarioBO.consultarUsuarioGrupo(usuarioTO));
				Util.atualizaArvoreTarefa(request,response);
				} catch (Exception e) {
					log.error(e.getMessage());
					setErro("pro.erro.tarefa.alterar", e.getMessage(), request);
					return mapping.findForward("erro");
				}
			return mapping.findForward("sucesso");
		}
	   
	   public ActionForward encaminharConsultar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {										
			try {
				/*Consultar Responsavel*/
//			    UsuarioBO usuarioBO = new UsuarioBO();
//			    UsuarioTO usuarioTO = new UsuarioTO();
//			    request.setAttribute("listaResponsavel",usuarioBO.consultarUsuarioGrupo(usuarioTO));
				Util.atualizaArvoreTarefa(request,response);
				} catch (Exception e) {
					log.error(e.getMessage());
					setErro("pro.erro.tarefa.alterar", e.getMessage(), request);
					return mapping.findForward("erro");
				}
			return mapping.findForward("sucesso");
		}
	   
	   
}
