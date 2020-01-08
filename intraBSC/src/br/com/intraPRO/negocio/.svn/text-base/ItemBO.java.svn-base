
package br.com.intraPRO.negocio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import br.com.intraBSC.persistencia.FabricaDAO;
import br.com.intraPRO.excecoes.ExceptionNegocioPRO;
import br.com.intraPRO.modelo.ItemTO;
import br.com.intraPRO.modelo.ConfigTarefaTO;
import br.com.intraPRO.persistencia.ItemDAO;

import com.ibatis.dao.client.DaoManager;


public class ItemBO {
    private static Log log = LogFactory.getLog(ItemBO.class); 
		
   public ItemBO(){
   }

   
   public void incluir(ItemTO itemTO) throws ExceptionNegocioPRO{
        DaoManager daoManager = FabricaDAO.getDaoManager();
  		ItemDAO itemDAO = (ItemDAO) daoManager.getDao(ItemDAO.class);
  		try{
  			ItemTO itemNumeroOrdem = new ItemTO();
  			itemNumeroOrdem.setCodConfigTarefa(itemTO.getCodConfigTarefa());
  			itemNumeroOrdem.setNumeroOrdem(itemTO.getNumeroOrdem());
  			itemNumeroOrdem = consultarUm(itemNumeroOrdem);
   			if ((itemNumeroOrdem.getNome() != null) && (!itemNumeroOrdem.getNome().equals(""))){
   				throw new ExceptionNegocioPRO("Número de Ordem já existe para este Tipo de Tarefa.");
   			}
  	   		daoManager.startTransaction();
  			itemDAO.incluir(itemTO);   	
  	   		daoManager.commitTransaction();
  		}
  		catch(ExceptionNegocioPRO e){
  		    log.error(e.getMessage());
  			throw new ExceptionNegocioPRO(e.getMessage());
  		}finally{
  		  daoManager.endTransaction();
  		}
   }
  
   
   public void alterar(ItemTO itemTO) throws ExceptionNegocioPRO{
       DaoManager daoManager = FabricaDAO.getDaoManager();
       ItemDAO itemDAO = (ItemDAO) daoManager.getDao(ItemDAO.class);
       try{
    	   if (itemTO.getNumeroOrdem() != itemTO.getNumOrdemAnterior()){
				ItemTO itemNumeroOrdem = new ItemTO();
				itemNumeroOrdem.setCodConfigTarefa(itemTO.getCodConfigTarefa());
				itemNumeroOrdem.setNumeroOrdem(itemTO.getNumeroOrdem());
				itemNumeroOrdem = consultarUm(itemNumeroOrdem);
				if ((itemNumeroOrdem.getNome() != null) && (!itemNumeroOrdem.getNome().equals(""))){
					throw new ExceptionNegocioPRO("Número de Ordem já existe para este Tipo de Tarefa.");
				} 
    	   }
           daoManager.startTransaction();
           itemDAO.alterar(itemTO);
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
public Collection consultarVarios(ItemTO itemTO) throws ExceptionNegocioPRO{
   	   DaoManager daoManager = FabricaDAO.getDaoManager();
	   ItemDAO itemDAO = (ItemDAO) daoManager.getDao(ItemDAO.class);	   
	   ConfigTarefaBO configTarefaBO = new ConfigTarefaBO();
	   Collection resultado = new ArrayList();	
	   ConfigTarefaTO configTarefaTOFinal = new ConfigTarefaTO();
		try {
			daoManager.startTransaction();
			Iterator i = itemDAO.consultarVarios(itemTO).iterator();
			
			while (i.hasNext()) {
				ConfigTarefaTO configTarefaTO = new ConfigTarefaTO();
			    ItemTO itemTOResult = (ItemTO) i.next();			
			    configTarefaTO.setCodigoConfigTarefa(itemTOResult.getCodConfigTarefa());
			    configTarefaTOFinal = configTarefaBO.consultarUm(configTarefaTO);
				itemTOResult.setCodPrefixo(configTarefaTOFinal.getCodigoPrefGestorTipo());
				itemTOResult.setNomeConfigTarefa(configTarefaTOFinal.getTextoConfigTarefa());
				resultado.add(itemTOResult);
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
   
   public Collection consultaItemConfigTarefa(ItemTO itemTO) throws ExceptionNegocioPRO{
       DaoManager daoManager = FabricaDAO.getDaoManager();
   	   ItemDAO itemDAO = (ItemDAO) daoManager.getDao(ItemDAO.class);   	   
   	   Collection resultado = new ArrayList();   	   
   	   try {   
   		   daoManager.startTransaction();
   	       resultado = itemDAO.consultaItemConfigTarefa(itemTO);	        
	       return resultado;
   		}catch (ExceptionNegocioPRO e) {
   		    log.error(e.getMessage());
            throw new ExceptionNegocioPRO(e.getMessage());
   		}finally{
            daoManager.endTransaction();   			
        }
   }
   		

   public ItemTO consultarUm(ItemTO itemTO) throws ExceptionNegocioPRO{ 
       DaoManager daoManager = FabricaDAO.getDaoManager();
	   ItemDAO itemDAO= (ItemDAO) daoManager.getDao(ItemDAO.class);	  
	   try{
		   daoManager.startTransaction();
	       ItemTO itemTOResultado = itemDAO.consultarUm(itemTO);       
	       return itemTOResultado;
	   }
	   catch(ExceptionNegocioPRO e){
	       log.error(e.getMessage());
	       throw new ExceptionNegocioPRO(e.getMessage());
	   }finally{
           daoManager.endTransaction();   			
       }	
   }


}
