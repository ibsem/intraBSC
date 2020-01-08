
package br.com.intraPRO.negocio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import br.com.intraBSC.persistencia.FabricaDAO;
import br.com.intraPRO.excecoes.ExceptionNegocioPRO;
import br.com.intraPRO.modelo.FormularioTO;
import br.com.intraPRO.modelo.ConfigTarefaTO;
import br.com.intraPRO.persistencia.FormularioDAO;

import com.ibatis.dao.client.DaoManager;


public class FormularioBO {
    private static Log log = LogFactory.getLog(FormularioBO.class); 
		
   public FormularioBO(){
   }

   
   public void incluir(FormularioTO formularioTO) throws ExceptionNegocioPRO{
        DaoManager daoManager = FabricaDAO.getDaoManager();
  		FormularioDAO formularioDAO = (FormularioDAO) daoManager.getDao(FormularioDAO.class);
  		try{
  			FormularioTO formularioNumeroOrdem = new FormularioTO();
  			formularioNumeroOrdem.setCodConfigTarefa(formularioTO.getCodConfigTarefa());
  			formularioNumeroOrdem.setNumeroOrdem(formularioTO.getNumeroOrdem());
  			formularioNumeroOrdem = consultarUm(formularioNumeroOrdem);
   			if ((formularioNumeroOrdem.getNome() != null) && (!formularioNumeroOrdem.getNome().equals(""))){
   				throw new ExceptionNegocioPRO("Número de Ordem já existe para este Tipo de Tarefa.");
   			}
  	   		daoManager.startTransaction();
  			formularioDAO.incluir(formularioTO);   	
  	   		daoManager.commitTransaction();
  		}
  		catch(ExceptionNegocioPRO e){
  		    log.error(e.getMessage());
  			throw new ExceptionNegocioPRO(e.getMessage());
  		}finally{
  		  daoManager.endTransaction();
  		}
   }
  
   
   public void alterar(FormularioTO formularioTO) throws ExceptionNegocioPRO{
       DaoManager daoManager = FabricaDAO.getDaoManager();
       FormularioDAO formularioDAO = (FormularioDAO) daoManager.getDao(FormularioDAO.class);
       try{
    	   if (formularioTO.getNumeroOrdem() != formularioTO.getNumOrdemAnterior()){
				FormularioTO formularioNumeroOrdem = new FormularioTO();
				formularioNumeroOrdem.setCodConfigTarefa(formularioTO.getCodConfigTarefa());
				formularioNumeroOrdem.setNumeroOrdem(formularioTO.getNumeroOrdem());
				formularioNumeroOrdem = consultarUm(formularioNumeroOrdem);
				if ((formularioNumeroOrdem.getNome() != null) && (!formularioNumeroOrdem.getNome().equals(""))){
					throw new ExceptionNegocioPRO("Número de Ordem já existe para este Tipo de Tarefa.");
				} 
    	   }
           daoManager.startTransaction();
           formularioDAO.alterar(formularioTO);
           daoManager.commitTransaction();
       }
       catch(ExceptionNegocioPRO e){
           log.error(e.getMessage());
           throw new ExceptionNegocioPRO(e.getMessage());
       }
       finally{
           daoManager.endTransaction();   			
       }
   }
      
   @SuppressWarnings("unchecked")
public Collection consultarVarios(FormularioTO formularioTO) throws ExceptionNegocioPRO{
   	   DaoManager daoManager = FabricaDAO.getDaoManager();
	   FormularioDAO formularioDAO = (FormularioDAO) daoManager.getDao(FormularioDAO.class);	   
	   ConfigTarefaBO configTarefaBO = new ConfigTarefaBO();
	   Collection resultado = new ArrayList();	
	   ConfigTarefaTO configTarefaTOFinal = new ConfigTarefaTO();
		try {
			daoManager.startTransaction();
			Iterator i = formularioDAO.consultarVarios(formularioTO).iterator();
			
			while (i.hasNext()) {
				ConfigTarefaTO configTarefaTO = new ConfigTarefaTO();
			    FormularioTO formularioTOResult = (FormularioTO) i.next();			
			    configTarefaTO.setCodigoConfigTarefa(formularioTOResult.getCodConfigTarefa());
			    configTarefaTOFinal = configTarefaBO.consultarUm(configTarefaTO);
				formularioTOResult.setCodPrefixo(configTarefaTOFinal.getCodigoPrefGestorTipo());
				formularioTOResult.setNomeConfigTarefa(configTarefaTOFinal.getTextoConfigTarefa());
				resultado.add(formularioTOResult);
			}
			Object[] obj = resultado.toArray();
			Arrays.sort( obj );
		} 

		catch (ExceptionNegocioPRO e) {
   			log.error(e.getMessage());
            throw new ExceptionNegocioPRO(e.getMessage());
		}finally{
	           daoManager.endTransaction();   			
	    }
	   	return resultado;     
   }
   
   public Collection consultaFormularioConfigTarefa(FormularioTO formularioTO) throws ExceptionNegocioPRO{
       DaoManager daoManager = FabricaDAO.getDaoManager();
   	   FormularioDAO formularioDAO = (FormularioDAO) daoManager.getDao(FormularioDAO.class);   	   
   	   Collection resultado = new ArrayList();   	   
   	   try {   
   		   daoManager.startTransaction();
   	       resultado = formularioDAO.consultaFormularioConfigTarefa(formularioTO);	        
	       return resultado;
   		}catch (ExceptionNegocioPRO e) {
   		    log.error(e.getMessage());
            throw new ExceptionNegocioPRO(e.getMessage());
   		}finally{
            daoManager.endTransaction();   			
        }
   }
   		

   public FormularioTO consultarUm(FormularioTO formularioTO) throws ExceptionNegocioPRO{ 
       DaoManager daoManager = FabricaDAO.getDaoManager();
	   FormularioDAO formularioDAO= (FormularioDAO) daoManager.getDao(FormularioDAO.class);	  
	   try{
		   daoManager.startTransaction();
	       FormularioTO formularioTOResultado = formularioDAO.consultarUm(formularioTO);       
	       return formularioTOResultado;
	   }
	   catch(ExceptionNegocioPRO e){
	       log.error(e.getMessage());
	       throw new ExceptionNegocioPRO(e.getMessage());
	   }finally{
           daoManager.endTransaction();   			
       }	
   }


}
