
package br.com.intraPRO.item.controle;

import java.util.Arrays;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.intraPRO.controle.DispatchActionPRO;
import br.com.intraPRO.excecoes.ExceptionPRO;
import br.com.intraPRO.item.visao.ItemForm;
import br.com.intraPRO.modelo.ItemTO;
import br.com.intraPRO.modelo.ListaOpcaoItemTO;
import br.com.intraPRO.negocio.ItemBO;
import br.com.intraPRO.negocio.ListaOpcaoItemBO;
import br.com.intraPRO.negocio.ConfigTarefaBO;


public class ItemAction extends DispatchActionPRO{
   
   public ItemAction() {
   }
   
   
   public ActionForward incluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
       	  	ItemForm itemForm = (ItemForm)form;
       	  	String val = (String)request.getSession().getAttribute("codConfigTarefa");
       	  	itemForm.setCodConfigTarefa(Integer.parseInt(val));
       	  	ItemTO itemTO = new ItemTO();
       	  	ItemBO itemBO = new ItemBO();
       	  	itemForm.setItemTO(itemTO);
       	  	try{
      		    itemBO.incluir(itemTO);
		   		setMensagem("pro.sucesso.item.incluir",request);
       	  	}catch(Exception e){
       	  	    setErro("pro.erro.item.incluir",e.getMessage(),request);
       	  	    return mapping.findForward("erro");
       	  	}
       return mapping.findForward("sucesso");	
   }
   
   public ActionForward incluirItemTarefa(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
  	  	ItemForm itemForm = (ItemForm)form;
  	  	String val = (String)request.getSession().getAttribute("codConfigTarefa");
  	  	itemForm.setCodConfigTarefa(Integer.parseInt(val));
  	  	ItemTO itemTO = new ItemTO();
  	  	ItemBO itemBO = new ItemBO();
  	  	itemForm.setItemTO(itemTO);
  	  	try{
 		    itemBO.incluir(itemTO);
	   		setMensagem("pro.sucesso.item.incluir",request);
  	  	}catch(Exception e){
  	  	    setErro("pro.erro.item.incluir",e.getMessage(),request);
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
       	  	    setErro("pro.erro.item.consultar",e.getMessage(),request);
       	  	    return mapping.findForward("erro");
       	  	}
       return mapping.findForward("sucesso");	
   }
   
   
   
   public ActionForward encaminharAlterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
  	   try{
  	       ItemForm itemForm = (ItemForm)form;
  	       ItemTO itemTO = new ItemTO();
	  	   ItemBO itemBO = new ItemBO();
  	       String codConfigTarefa;
	  	   if (request.getParameter("codConfigTarefa") == null){
	  		   codConfigTarefa = (String)request.getSession().getAttribute("codConfigTarefa");
	  	   }else{ 
	  		   codConfigTarefa = (String)request.getParameter("codConfigTarefa");
	  	   }
	  	   request.getSession().setAttribute("codConfigTarefa",codConfigTarefa);
		   itemTO.setCodConfigTarefa(Integer.parseInt(codConfigTarefa));
	  	   itemTO.setNumeroOrdem(Integer.parseInt(request.getParameter("numeroOrdem")));
  	  	   itemForm.setItemForm(itemBO.consultarUm(itemTO));

           request.getSession().setAttribute("listaConfigTarefa",new ConfigTarefaBO().consultarConfigTarefaAcesso());

           ListaOpcaoItemBO listaOpcaoItemBO = new ListaOpcaoItemBO();/*Seta os valores da lista de opções de item*/
           ListaOpcaoItemTO listaOpcaoItemTO =  new ListaOpcaoItemTO();
           listaOpcaoItemTO.setCodConfigTarefa(itemTO.getCodConfigTarefa());
           listaOpcaoItemTO.setNumeroOrdem(itemTO.getNumeroOrdem());
           Collection listaOpcaoItem = listaOpcaoItemBO.consultarVarios(listaOpcaoItemTO);
           request.getSession().setAttribute("listaOpcaoItem",listaOpcaoItem);

           itemForm.setCodConfigTarefa(itemForm.getCodConfigTarefa());
           itemForm.setNomeTextoCombo("");         
  	   }catch (Exception e) {
  	       log.error(e.getMessage());
  	       setErro("pro.erro.item.consultar",e.getMessage(),request);
  	       return mapping.findForward("erro");
  	   }  	       
       return mapping.findForward("sucesso");
   }
  
   public ActionForward alterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
  	   try{
  		   ItemForm itemForm = (ItemForm)form;
    	   ItemTO itemTO = new ItemTO();
    	   ItemBO itemBO = new ItemBO();
    	   itemForm.setItemTO(itemTO);
    	   String codConfig = (String) request.getSession().getAttribute("codConfigTarefa");
    	   itemTO.setCodConfigTarefa(Integer.parseInt(codConfig));
	       itemBO.alterar(itemTO);
	       setMensagem("pro.sucesso.item.alterar", request);
	   }catch (Exception e) {
	      log.error(e.getMessage());
	      setErro("pro.erro.item.alterar",e.getMessage(),request);
	      return mapping.findForward("erro");
	   }
  	   return mapping.findForward("sucesso");
   }
   

   public ActionForward consultarVarios(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
   		try {
   			ItemForm itemForm = (ItemForm) form;
   			ItemTO itemTO = new ItemTO();
   	   		ItemBO itemBO = new ItemBO();
   	   		itemForm.setItemTO(itemTO);

			request.getSession().setAttribute("listaConfigTarefaDepe",new ConfigTarefaBO().consultarConfigTarefaAcesso());
   	   		Collection lista = itemBO.consultarVarios(itemTO);
   	   		Object[] obj = lista.toArray();
   	   		Arrays.sort( obj );
   	   		 
   	   		if ((lista == null) || (lista.isEmpty()) ){
   	   		    setErro("pro.erro.item.consultar.naoExiste", request);
   	   		    return mapping.findForward("erro");
   	   		}
   	   		request.setAttribute("listaItems",obj);// Cria um item no request com os items cadastrados no sistema   	   		
		} 
   		catch (ExceptionPRO e) {
			setErro("pro.erro.listaItem",e.getMessage(),request);
			return mapping.findForward("erro");
		} 
   		return mapping.findForward("sucesso");	
   	
   }

   
   public ActionForward consultarItemConfigTarefa(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
       try {   			
           ItemForm itemForm = (ItemForm) form;
           ItemTO itemTO = new ItemTO();
           ItemBO itemBO = new ItemBO();
           itemForm.setItemTO(itemTO);
           request.getSession().setAttribute("listaConfigTarefaDepe",new ConfigTarefaBO().consultarConfigTarefaAcesso());  
           Collection lista = itemBO.consultaItemConfigTarefa(itemTO);
           if ((lista == null) || (lista.isEmpty()) ){
               setErro("pro.erro.item.consultar.naoExiste", request);
               return mapping.findForward("erro");
           }
           request.setAttribute("listaItems",lista);   	   		
       } 
       catch (ExceptionPRO e) {
           setErro("pro.erro.listaItem",e.getMessage(),request);
           return mapping.findForward("erro");
       } 
       return mapping.findForward("sucesso");	
   }

   
   
   public ActionForward encaminharConsulta(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {   		 
	   try {
  			ItemForm itemForm = (ItemForm) form;
  	   		itemForm.reset(mapping, request);		  	  				  	
  	   		request.getSession().setAttribute("listaConfigTarefaDepe",new ConfigTarefaBO().consultarConfigTarefaAcesso());
  		} 
   		catch (ExceptionPRO e) {
			setErro("pro.erro.listaItem",e.getMessage(),request);
			return mapping.findForward("erro");
		}  		
		return mapping.findForward("sucesso");
   }
   
   
   
   /***************************************************METODOS DA LISTA DE OPÇÕES DE ITENS****************************************************/
      
  
   public ActionForward incluirListaOpcao(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {   		 
 		try {
 			ItemForm itemForm = (ItemForm) form;
	   		ListaOpcaoItemBO listaOpcaoItemBO = new ListaOpcaoItemBO();
	   		ListaOpcaoItemTO listaOpcaoItemTO = new ListaOpcaoItemTO();
	   		listaOpcaoItemTO.setCodConfigTarefa(itemForm.getCodConfigTarefa());
	   		listaOpcaoItemTO.setNumeroOrdem(itemForm.getNumeroOrdem());	   			   		
	   		listaOpcaoItemTO.setTexto(itemForm.getNomeTextoCombo());
	   		listaOpcaoItemBO.incluir(listaOpcaoItemTO);
	   		ItemBO itemBO = new ItemBO();
	   		ItemTO itemTO = new ItemTO();
	   		itemForm.setItemTO(itemTO);
	   		itemBO.alterar(itemTO);
	   		
	   		listaOpcaoItemTO.setCodigo(0);
			Collection listaOpcao = listaOpcaoItemBO.consultarVarios(listaOpcaoItemTO);
			if (!listaOpcao.isEmpty()){
				request.getSession().setAttribute("listaOpcaoItem",listaOpcao);
				itemForm.setNomeTextoCombo("");
				itemForm.setCodigoDadoItem(4);
			}
 		}catch (ExceptionPRO e) {
			setErro("pro.erro.listaItem",e.getMessage(),request);
			return mapping.findForward("erro");
		}  		
		return mapping.findForward("sucesso");
   }
   
   public ActionForward limparListaOpcao(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){   		 
		try {
			ItemForm itemForm = (ItemForm) form;	   	
	   		ListaOpcaoItemBO listaOpcaoItemBO = new ListaOpcaoItemBO();
	   		ListaOpcaoItemTO listaOpcaoItemTO = new ListaOpcaoItemTO();
	   		listaOpcaoItemTO.setCodConfigTarefa(itemForm.getCodConfigTarefa());
	   		listaOpcaoItemTO.setNumeroOrdem(itemForm.getNumeroOrdem());	   			   		
	   		listaOpcaoItemBO.exluir(listaOpcaoItemTO);
 		
		}catch (ExceptionPRO e) {
			setErro("pro.erro.listaItem",e.getMessage(),request);
			return mapping.findForward("erro");
		}  		
		return mapping.findForward("sucesso");
   }
   

   public ActionForward excluirListaOpcao(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {   		 
		try {
			ItemForm itemForm = (ItemForm) form;	   		
	   		ListaOpcaoItemBO listaOpcaoItemBO = new ListaOpcaoItemBO();
	   		ListaOpcaoItemTO listaOpcaoItemTO = new ListaOpcaoItemTO();
	   		listaOpcaoItemTO.setCodConfigTarefa(itemForm.getCodConfigTarefa());
	   		listaOpcaoItemTO.setNumeroOrdem(itemForm.getNumeroOrdem());
	   		int codSel = Integer.parseInt(request.getParameter("codListaOpcao"));
	   		listaOpcaoItemTO.setCodigo(codSel);
	   		
	   		listaOpcaoItemBO.exluir(listaOpcaoItemTO);
		}catch (ExceptionPRO e) {
			setErro("pro.erro.listaItem",e.getMessage(),request);
			return mapping.findForward("erro");
		}  		
		return mapping.findForward("sucesso");
   }
 
}
