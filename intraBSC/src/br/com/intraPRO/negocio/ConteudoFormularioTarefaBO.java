
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
import br.com.intraPRO.modelo.ConteudoFormularioTarefaTO;
import br.com.intraPRO.modelo.ListaOpcaoFormularioTO;
import br.com.intraPRO.persistencia.ConteudoFormularioTarefaDAO;
import br.com.intraPRO.persistencia.jdbc.ConteudoFormularioTarefaDAOImpl;

public class ConteudoFormularioTarefaBO{
   private static Log log = LogFactory.getLog(ConteudoFormularioTarefaDAOImpl.class);
	
   public ConteudoFormularioTarefaBO(){
   	
   }
   
   public void alterar(ConteudoFormularioTarefaTO conteudoFormularioTarefaTO) throws ExceptionNegocioPRO{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
	   	ConteudoFormularioTarefaDAO conteudoFormularioTarefaDAO = (ConteudoFormularioTarefaDAO) daoManager.getDao(ConteudoFormularioTarefaDAO.class);
	   	try{
	 		daoManager.startTransaction();
	 		conteudoFormularioTarefaDAO.alterar(conteudoFormularioTarefaTO);   	
	 	   	daoManager.commitTransaction();
	 	}catch(ExceptionNegocioPRO e){
	 	    log.error(e.getMessage());
	 		throw new ExceptionNegocioPRO(e.getMessage());
	 	}finally{
	 	  daoManager.endTransaction();
	 	}
   }
  
   public void incluir(ConteudoFormularioTarefaTO conteudoFormularioTarefaTO) throws ExceptionNegocioPRO{
    DaoManager daoManager = FabricaDAO.getDaoManager();
   	ConteudoFormularioTarefaDAO conteudoFormularioTarefaDAO = (ConteudoFormularioTarefaDAO) daoManager.getDao(ConteudoFormularioTarefaDAO.class);
   	try{
 		daoManager.startTransaction();
 		conteudoFormularioTarefaDAO.incluir(conteudoFormularioTarefaTO);   	
 	   	daoManager.commitTransaction();
 		}
 		catch(ExceptionNegocioPRO e){
 		    log.error(e.getMessage());
 			throw new ExceptionNegocioPRO(e.getMessage());
 		}finally{
 		  daoManager.endTransaction();
 		}
   }

   
   public void excluirFormularioTarefa(ConteudoFormularioTarefaTO conteudoFormularioTarefaTO, TarefaTO tarefaTO) throws ExceptionNegocioPRO{
       DaoManager daoManager = FabricaDAO.getDaoManager();
       ConteudoFormularioTarefaDAO conteudoFormularioTarefaDAO = (ConteudoFormularioTarefaDAO) daoManager.getDao(ConteudoFormularioTarefaDAO.class);
       try{
            daoManager.startTransaction();
            if (conteudoFormularioTarefaTO.getCodTarefa() != 0)
            	conteudoFormularioTarefaDAO.excluirFormularioTarefa(conteudoFormularioTarefaTO);
            if (conteudoFormularioTarefaTO.getCodTarefa() == 0){
            	conteudoFormularioTarefaTO.setAnoCriacao(tarefaTO.getAnoCriacao());
            	conteudoFormularioTarefaTO.setCodTarefa(tarefaTO.getCodigo());
            	conteudoFormularioTarefaTO.setCodConfigTarefa(tarefaTO.getCodConfigTarefa());
            }
            incluirFormularioTarefa(conteudoFormularioTarefaTO);
            daoManager.commitTransaction();
            }
            catch(ExceptionNegocioPRO e){
                log.error(e.getMessage());
                throw new ExceptionNegocioPRO(e.getMessage());
            }finally{
              daoManager.endTransaction();
            }
      }
   
   
   public void incluirFormularioTarefa(ConteudoFormularioTarefaTO conteudoFormularioTarefaTO) throws ExceptionNegocioPRO{
       DaoManager daoManager = FabricaDAO.getDaoManager();
       ConteudoFormularioTarefaDAO conteudoFormularioTarefaDAO = (ConteudoFormularioTarefaDAO) daoManager.getDao(ConteudoFormularioTarefaDAO.class);
        try{
            daoManager.startTransaction();
            conteudoFormularioTarefaDAO.incluirFormularioTarefa(conteudoFormularioTarefaTO);      
            daoManager.commitTransaction();
            }
            catch(ExceptionNegocioPRO e){
                log.error(e.getMessage());
                throw new ExceptionNegocioPRO(e.getMessage());
            }finally{
              daoManager.endTransaction();
            }
      }

 
   public Collection consultarFormulariosPRO(ConteudoFormularioTarefaTO conteudoFormularioTarefaTO) throws ExceptionNegocioPRO{       
       try{
    	   DaoManager daoManager = FabricaDAO.getDaoManager();
           ConteudoFormularioTarefaDAO conteudoFormularioTarefaDAO = (ConteudoFormularioTarefaDAO) daoManager.getDao(ConteudoFormularioTarefaDAO.class);
           Collection listaResult = new ArrayList();
           listaResult = conteudoFormularioTarefaDAO.consultarFormularios(conteudoFormularioTarefaTO);
           
           ListaOpcaoFormularioBO listaOpcaoFormularioBO = new ListaOpcaoFormularioBO();
           ListaOpcaoFormularioTO listaOpcaoFormularioTO = new ListaOpcaoFormularioTO();
           
           Iterator iter = listaResult.iterator();
           while (iter.hasNext()) {
			ConteudoFormularioTarefaTO element = (ConteudoFormularioTarefaTO) iter.next();
			if (element.getCodTipoDadoFormulario() == 4){
				listaOpcaoFormularioTO.setCodConfigTarefa(element.getCodConfigTarefa());
				listaOpcaoFormularioTO.setNumeroOrdem(element.getNumeroOrdem());
				Collection lista = listaOpcaoFormularioBO.consultarVarios(listaOpcaoFormularioTO);
				
				element.setListaOpcaoTipoFormulario(lista);
			}
		}
           return listaResult;
       }
       catch(ExceptionNegocioPRO e){
           log.error(e.getMessage());
           throw new ExceptionNegocioPRO(e.getMessage());
        }
   }

   
	/*Consulta para verificar se é necessario incluir formulario critico ou somente alterar o dado*/
	public Collection consultarFormularioCritico(ConteudoFormularioTarefaTO conteudoFormularioTarefaTO) throws ExceptionNegocioPRO{
		DaoManager daoManager = FabricaDAO.getDaoManager();
        ConteudoFormularioTarefaDAO conteudoFormularioTarefaDAO = (ConteudoFormularioTarefaDAO) daoManager.getDao(ConteudoFormularioTarefaDAO.class);
	    try{
	        return conteudoFormularioTarefaDAO.consultarFormularioCritico(conteudoFormularioTarefaTO); 	        
	    }catch(ExceptionNegocioPRO e){
	           log.error(e.getMessage());
	           throw new ExceptionNegocioPRO(e.getMessage());
	 	}
	}
   
}
