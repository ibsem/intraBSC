
package br.com.intraPRO.formulario.controle;

import java.util.Arrays;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.intraPRO.controle.DispatchActionPRO;
import br.com.intraPRO.excecoes.ExceptionPRO;
import br.com.intraPRO.formulario.visao.FormularioForm;
import br.com.intraPRO.modelo.FormularioTO;
import br.com.intraPRO.modelo.ListaOpcaoFormularioTO;
import br.com.intraPRO.negocio.FormularioBO;
import br.com.intraPRO.negocio.ListaOpcaoFormularioBO;
import br.com.intraPRO.negocio.ConfigTarefaBO;


public class FormularioAction extends DispatchActionPRO{
   
   public FormularioAction() {
   }
   
   
   public ActionForward incluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
       	  	FormularioForm formularioForm = (FormularioForm)form;
       	  	String val = (String)request.getSession().getAttribute("codConfigTarefa");
       	  	formularioForm.setCodConfigTarefa(Integer.parseInt(val));
       	  	FormularioTO formularioTO = new FormularioTO();
       	  	FormularioBO formularioBO = new FormularioBO();
       	  	formularioForm.setFormularioTO(formularioTO);
       	  	try{
      		    formularioBO.incluir(formularioTO);
		   		setMensagem("pro.sucesso.formulario.incluir",request);
       	  	}catch(Exception e){
       	  	    setErro("pro.erro.formulario.incluir",e.getMessage(),request);
       	  	    return mapping.findForward("erro");
       	  	}
       return mapping.findForward("sucesso");	
   }
   
   public ActionForward incluirFormularioTarefa(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
  	  	FormularioForm formularioForm = (FormularioForm)form;
  	  	String val = (String)request.getSession().getAttribute("codConfigTarefa");
  	  	formularioForm.setCodConfigTarefa(Integer.parseInt(val));
  	  	FormularioTO formularioTO = new FormularioTO();
  	  	FormularioBO formularioBO = new FormularioBO();
  	  	formularioForm.setFormularioTO(formularioTO);
  	  	try{
 		    formularioBO.incluir(formularioTO);
	   		setMensagem("pro.sucesso.formulario.incluir",request);
  	  	}catch(Exception e){
  	  	    setErro("pro.erro.formulario.incluir",e.getMessage(),request);
  	  	    return mapping.findForward("erro");
  	  	}
  	  	return mapping.findForward("sucesso");	
   }
   
   
   public ActionForward encaminharInclusao(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   try{
       	  	String codConfigTarefa = request.getParameter("codConfigTarefa");
       	  	request.getSession().setAttribute("codConfigTarefa",codConfigTarefa);
	        request.getSession().setAttribute("listaConfigTarefa",new ConfigTarefaBO().consultarConfigTarefaAcesso());
       	  	}catch(Exception e){
       	  	    setErro("pro.erro.formulario.consultar",e.getMessage(),request);
       	  	    return mapping.findForward("erro");
       	  	}
       return mapping.findForward("sucesso");	
   }
   
   
   
   public ActionForward encaminharAlterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
  	   try{
  	       FormularioForm formularioForm = (FormularioForm)form;
  	       FormularioTO formularioTO = new FormularioTO();
	  	   FormularioBO formularioBO = new FormularioBO();
  	       String codConfigTarefa;
	  	   if (request.getParameter("codConfigTarefa") == null){
	  		   codConfigTarefa = (String)request.getSession().getAttribute("codConfigTarefa");
	  	   }else{ 
	  		   codConfigTarefa = (String)request.getParameter("codConfigTarefa");
	  	   }
	  	   request.getSession().setAttribute("codConfigTarefa",codConfigTarefa);
		   formularioTO.setCodConfigTarefa(Integer.parseInt(codConfigTarefa));
	  	   formularioTO.setNumeroOrdem(Integer.parseInt(request.getParameter("numeroOrdem")));
  	  	   formularioForm.setFormularioForm(formularioBO.consultarUm(formularioTO));

           request.getSession().setAttribute("listaConfigTarefa",new ConfigTarefaBO().consultarConfigTarefaAcesso());

           ListaOpcaoFormularioBO listaOpcaoFormularioBO = new ListaOpcaoFormularioBO();/*Seta os valores da lista de opções de formulario*/
           ListaOpcaoFormularioTO listaOpcaoFormularioTO =  new ListaOpcaoFormularioTO();
           listaOpcaoFormularioTO.setCodConfigTarefa(formularioTO.getCodConfigTarefa());
           listaOpcaoFormularioTO.setNumeroOrdem(formularioTO.getNumeroOrdem());
           Collection listaOpcaoFormulario = listaOpcaoFormularioBO.consultarVarios(listaOpcaoFormularioTO);
           request.getSession().setAttribute("listaOpcaoFormulario",listaOpcaoFormulario);

           formularioForm.setCodConfigTarefa(formularioForm.getCodConfigTarefa());
           formularioForm.setNomeTextoCombo("");         
  	   }catch (Exception e) {
  	       log.error(e.getMessage());
  	       setErro("pro.erro.formulario.consultar",e.getMessage(),request);
  	       return mapping.findForward("erro");
  	   }  	       
       return mapping.findForward("sucesso");
   }
  
   public ActionForward alterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
  	   try{
  		   FormularioForm formularioForm = (FormularioForm)form;
    	   FormularioTO formularioTO = new FormularioTO();
    	   FormularioBO formularioBO = new FormularioBO();
    	   formularioForm.setFormularioTO(formularioTO);
    	   String codConfig = (String) request.getSession().getAttribute("codConfigTarefa");
    	   formularioTO.setCodConfigTarefa(Integer.parseInt(codConfig));
	       formularioBO.alterar(formularioTO);
	       setMensagem("pro.sucesso.formulario.alterar", request);
	   }catch (Exception e) {
	      log.error(e.getMessage());
	      setErro("pro.erro.formulario.alterar",e.getMessage(),request);
	      return mapping.findForward("erro");
	   }
  	   return mapping.findForward("sucesso");
   }
   

   public ActionForward consultarVarios(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
   		try {
   			FormularioForm formularioForm = (FormularioForm) form;
   			FormularioTO formularioTO = new FormularioTO();
   	   		FormularioBO formularioBO = new FormularioBO();
   	   		formularioForm.setFormularioTO(formularioTO);

			request.getSession().setAttribute("listaConfigTarefaDepe",new ConfigTarefaBO().consultarConfigTarefaAcesso());
   	   		Collection lista = formularioBO.consultarVarios(formularioTO);
   	   		Object[] obj = lista.toArray();
   	   		Arrays.sort( obj );
   	   		 
   	   		if ((lista == null) || (lista.isEmpty()) ){
   	   		    setErro("pro.erro.formulario.consultar.naoExiste", request);
   	   		    return mapping.findForward("erro");
   	   		}
   	   		request.setAttribute("listaFormularios",obj);// Cria um formulario no request com os formularios cadastrados no sistema   	   		
		} 
   		catch (ExceptionPRO e) {
			setErro("pro.erro.listaFormulario",e.getMessage(),request);
			return mapping.findForward("erro");
		} 
   		return mapping.findForward("sucesso");	
   	
   }

   
   public ActionForward consultarFormularioConfigTarefa(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
       try {   			
           FormularioForm formularioForm = (FormularioForm) form;
           FormularioTO formularioTO = new FormularioTO();
           FormularioBO formularioBO = new FormularioBO();
           formularioForm.setFormularioTO(formularioTO);
           request.getSession().setAttribute("listaConfigTarefaDepe",new ConfigTarefaBO().consultarConfigTarefaAcesso());  
           Collection lista = formularioBO.consultaFormularioConfigTarefa(formularioTO);
           if ((lista == null) || (lista.isEmpty()) ){
               setErro("pro.erro.formulario.consultar.naoExiste", request);
               return mapping.findForward("erro");
           }
           request.setAttribute("listaFormularios",lista);   	   		
       } 
       catch (ExceptionPRO e) {
           setErro("pro.erro.listaFormulario",e.getMessage(),request);
           return mapping.findForward("erro");
       } 
       return mapping.findForward("sucesso");	
   }

   
   
   public ActionForward encaminharConsulta(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {   		 
	   try {
  			FormularioForm formularioForm = (FormularioForm) form;
  	   		formularioForm.reset(mapping, request);		  	  				  	
  	   		request.getSession().setAttribute("listaConfigTarefaDepe",new ConfigTarefaBO().consultarConfigTarefaAcesso());
  		} 
   		catch (ExceptionPRO e) {
			setErro("pro.erro.listaFormulario",e.getMessage(),request);
			return mapping.findForward("erro");
		}  		
		return mapping.findForward("sucesso");
   }
   
   
   
   /***************************************************METODOS DA LISTA DE OPÇÕES DE ITENS****************************************************/
      
  
   public ActionForward incluirListaOpcao(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {   		 
 		try {
 			FormularioForm formularioForm = (FormularioForm) form;
	   		ListaOpcaoFormularioBO listaOpcaoFormularioBO = new ListaOpcaoFormularioBO();
	   		ListaOpcaoFormularioTO listaOpcaoFormularioTO = new ListaOpcaoFormularioTO();
	   		listaOpcaoFormularioTO.setCodConfigTarefa(formularioForm.getCodConfigTarefa());
	   		listaOpcaoFormularioTO.setNumeroOrdem(formularioForm.getNumeroOrdem());	   			   		
	   		listaOpcaoFormularioTO.setTexto(formularioForm.getNomeTextoCombo());
	   		listaOpcaoFormularioBO.incluir(listaOpcaoFormularioTO);
	   		FormularioBO formularioBO = new FormularioBO();
	   		FormularioTO formularioTO = new FormularioTO();
	   		formularioForm.setFormularioTO(formularioTO);
	   		formularioBO.alterar(formularioTO);
	   		
	   		listaOpcaoFormularioTO.setCodigo(0);
			Collection listaOpcao = listaOpcaoFormularioBO.consultarVarios(listaOpcaoFormularioTO);
			if (!listaOpcao.isEmpty()){
				request.getSession().setAttribute("listaOpcaoFormulario",listaOpcao);
				formularioForm.setNomeTextoCombo("");
				formularioForm.setCodigoDadoFormulario(4);
			}
 		}catch (ExceptionPRO e) {
			setErro("pro.erro.listaFormulario",e.getMessage(),request);
			return mapping.findForward("erro");
		}  		
		return mapping.findForward("sucesso");
   }
   
   public ActionForward limparListaOpcao(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){   		 
		try {
			FormularioForm formularioForm = (FormularioForm) form;	   	
	   		ListaOpcaoFormularioBO listaOpcaoFormularioBO = new ListaOpcaoFormularioBO();
	   		ListaOpcaoFormularioTO listaOpcaoFormularioTO = new ListaOpcaoFormularioTO();
	   		listaOpcaoFormularioTO.setCodConfigTarefa(formularioForm.getCodConfigTarefa());
	   		listaOpcaoFormularioTO.setNumeroOrdem(formularioForm.getNumeroOrdem());	   			   		
	   		listaOpcaoFormularioBO.exluir(listaOpcaoFormularioTO);
 		
		}catch (ExceptionPRO e) {
			setErro("pro.erro.listaFormulario",e.getMessage(),request);
			return mapping.findForward("erro");
		}  		
		return mapping.findForward("sucesso");
   }
   

   public ActionForward excluirListaOpcao(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {   		 
		try {
			FormularioForm formularioForm = (FormularioForm) form;	   		
	   		ListaOpcaoFormularioBO listaOpcaoFormularioBO = new ListaOpcaoFormularioBO();
	   		ListaOpcaoFormularioTO listaOpcaoFormularioTO = new ListaOpcaoFormularioTO();
	   		listaOpcaoFormularioTO.setCodConfigTarefa(formularioForm.getCodConfigTarefa());
	   		listaOpcaoFormularioTO.setNumeroOrdem(formularioForm.getNumeroOrdem());
	   		int codSel = Integer.parseInt(request.getParameter("codListaOpcao"));
	   		listaOpcaoFormularioTO.setCodigo(codSel);
	   		
	   		listaOpcaoFormularioBO.exluir(listaOpcaoFormularioTO);
		}catch (ExceptionPRO e) {
			setErro("pro.erro.listaFormulario",e.getMessage(),request);
			return mapping.findForward("erro");
		}  		
		return mapping.findForward("sucesso");
   }
 
}
