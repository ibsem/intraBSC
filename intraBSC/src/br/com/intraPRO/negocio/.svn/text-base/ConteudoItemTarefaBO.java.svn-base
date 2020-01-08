
package br.com.intraPRO.negocio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ibatis.dao.client.DaoManager;

import br.com.intraBSC.persistencia.FabricaDAO;
import br.com.intraPRO.excecoes.ExceptionNegocioPRO;
import br.com.intraPRO.modelo.TarefaTO;
import br.com.intraPRO.modelo.ConteudoItemTarefaTO;
import br.com.intraPRO.modelo.ListaOpcaoItemTO;
import br.com.intraPRO.persistencia.ConteudoItemTarefaDAO;
import br.com.intraPRO.persistencia.jdbc.ConteudoItemTarefaDAOImpl;

public class ConteudoItemTarefaBO{
   private static Log log = LogFactory.getLog(ConteudoItemTarefaDAOImpl.class);
	
   public ConteudoItemTarefaBO(){
   	
   }
   
   public void alterar(ConteudoItemTarefaTO conteudoItemTarefaTO) throws ExceptionNegocioPRO{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
	   	ConteudoItemTarefaDAO conteudoItemTarefaDAO = (ConteudoItemTarefaDAO) daoManager.getDao(ConteudoItemTarefaDAO.class);
	   	try{
	 		daoManager.startTransaction();
	 		conteudoItemTarefaDAO.alterar(conteudoItemTarefaTO);   	
	 	   	daoManager.commitTransaction();
	 	}catch(ExceptionNegocioPRO e){
	 	    log.error(e.getMessage());
	 		throw new ExceptionNegocioPRO(e.getMessage());
	 	}finally{
	 	  daoManager.endTransaction();
	 	}
   }
  
   public void incluir(ConteudoItemTarefaTO conteudoItemTarefaTO) throws ExceptionNegocioPRO{
    DaoManager daoManager = FabricaDAO.getDaoManager();
   	ConteudoItemTarefaDAO conteudoItemTarefaDAO = (ConteudoItemTarefaDAO) daoManager.getDao(ConteudoItemTarefaDAO.class);
   	try{
 		daoManager.startTransaction();
 		conteudoItemTarefaDAO.incluir(conteudoItemTarefaTO);   	
 	   	daoManager.commitTransaction();
 		}
 		catch(ExceptionNegocioPRO e){
 		    log.error(e.getMessage());
 			throw new ExceptionNegocioPRO(e.getMessage());
 		}finally{
 		  daoManager.endTransaction();
 		}
   }

   
   public void excluirItemTarefa(ConteudoItemTarefaTO conteudoItemTarefaTO, TarefaTO tarefaTO) throws ExceptionNegocioPRO{
       DaoManager daoManager = FabricaDAO.getDaoManager();
       ConteudoItemTarefaDAO conteudoItemTarefaDAO = (ConteudoItemTarefaDAO) daoManager.getDao(ConteudoItemTarefaDAO.class);
       try{
            daoManager.startTransaction();
            if (conteudoItemTarefaTO.getCodTarefa() != 0)
            	conteudoItemTarefaDAO.excluirItemTarefa(conteudoItemTarefaTO);
            if (conteudoItemTarefaTO.getCodTarefa() == 0){
            	conteudoItemTarefaTO.setAnoCriacao(tarefaTO.getAnoCriacao());
            	conteudoItemTarefaTO.setCodTarefa(tarefaTO.getCodigo());
            	conteudoItemTarefaTO.setCodConfigTarefa(tarefaTO.getCodConfigTarefa());
            }
            incluirItemTarefa(conteudoItemTarefaTO);
            daoManager.commitTransaction();
            }
            catch(ExceptionNegocioPRO e){
                log.error(e.getMessage());
                throw new ExceptionNegocioPRO(e.getMessage());
            }finally{
              daoManager.endTransaction();
            }
      }
   
   
   public void incluirItemTarefa(ConteudoItemTarefaTO conteudoItemTarefaTO) throws ExceptionNegocioPRO{
       DaoManager daoManager = FabricaDAO.getDaoManager();
       ConteudoItemTarefaDAO conteudoItemTarefaDAO = (ConteudoItemTarefaDAO) daoManager.getDao(ConteudoItemTarefaDAO.class);
        try{
            daoManager.startTransaction();
            conteudoItemTarefaDAO.incluirItemTarefa(conteudoItemTarefaTO);      
            daoManager.commitTransaction();
            }
            catch(ExceptionNegocioPRO e){
                log.error(e.getMessage());
                throw new ExceptionNegocioPRO(e.getMessage());
            }finally{
              daoManager.endTransaction();
            }
      }

 
   public Collection consultarItemsPRO(ConteudoItemTarefaTO conteudoItemTarefaTO) throws ExceptionNegocioPRO{       
       try{
    	   DaoManager daoManager = FabricaDAO.getDaoManager();
           ConteudoItemTarefaDAO conteudoItemTarefaDAO = (ConteudoItemTarefaDAO) daoManager.getDao(ConteudoItemTarefaDAO.class);
           Collection listaResult = new ArrayList();
           listaResult = conteudoItemTarefaDAO.consultarItems(conteudoItemTarefaTO);
           
           ListaOpcaoItemBO listaOpcaoItemBO = new ListaOpcaoItemBO();
           ListaOpcaoItemTO listaOpcaoItemTO = new ListaOpcaoItemTO();
           
           Iterator iter = listaResult.iterator();
           while (iter.hasNext()) {
			ConteudoItemTarefaTO element = (ConteudoItemTarefaTO) iter.next();
			if (element.getCodTipoDadoItem() == 4){
				listaOpcaoItemTO.setCodConfigTarefa(element.getCodConfigTarefa());
				listaOpcaoItemTO.setNumeroOrdem(element.getNumeroOrdem());
				Collection lista = listaOpcaoItemBO.consultarVarios(listaOpcaoItemTO);
				
				element.setListaOpcaoTipoItem(lista);
			}
		}
           return listaResult;
       }
       catch(ExceptionNegocioPRO e){
           log.error(e.getMessage());
           throw new ExceptionNegocioPRO(e.getMessage());
        }
   }

   
	/*Consulta para verificar se é necessario incluir item critico ou somente alterar o dado*/
	public Collection consultarItemCritico(ConteudoItemTarefaTO conteudoItemTarefaTO) throws ExceptionNegocioPRO{
		DaoManager daoManager = FabricaDAO.getDaoManager();
        ConteudoItemTarefaDAO conteudoItemTarefaDAO = (ConteudoItemTarefaDAO) daoManager.getDao(ConteudoItemTarefaDAO.class);
	    try{
	        return conteudoItemTarefaDAO.consultarItemCritico(conteudoItemTarefaTO); 	        
	    }catch(ExceptionNegocioPRO e){
	           log.error(e.getMessage());
	           throw new ExceptionNegocioPRO(e.getMessage());
	 	}
	}
   
}
