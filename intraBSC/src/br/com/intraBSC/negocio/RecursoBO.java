

package br.com.intraBSC.negocio;

import java.util.Collection;

import br.com.intraBSC.excecoes.ExceptionNegocioBSC;
import br.com.intraBSC.modelo.RecursoTO;
import br.com.intraBSC.persistencia.FabricaDAO;
import br.com.intraBSC.persistencia.RecursoDAO;

import com.ibatis.dao.client.DaoManager;

public class RecursoBO{
   
   public RecursoBO(){    
   }

   public Collection consultarVarios(RecursoTO recursoTO) throws ExceptionNegocioBSC{
   	DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
     		RecursoDAO recursoDAO = (RecursoDAO) daoManager.getDao(RecursoDAO.class);
     		daoManager.startTransaction();
     		Collection listaRecurso = recursoDAO.consultarVarios(recursoTO);
     		return listaRecurso;
       }catch (ExceptionNegocioBSC e) {
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }       
   }
   
   public void incluir(RecursoTO recursoTO) throws ExceptionNegocioBSC{
   	DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
     		RecursoDAO recursoDAO = (RecursoDAO) daoManager.getDao(RecursoDAO.class);
     		daoManager.startTransaction();
     		recursoTO.setId(consultarMax(recursoTO));
     		recursoDAO.incluir(recursoTO);
     		daoManager.commitTransaction();
       }catch (ExceptionNegocioBSC e) {
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }       
   }
   
   public void excluir(RecursoTO recursoTO) throws ExceptionNegocioBSC{
	   	DaoManager daoManager = FabricaDAO.getDaoManager();
	       try{        	
	     		RecursoDAO recursoDAO = (RecursoDAO) daoManager.getDao(RecursoDAO.class);
	     		daoManager.startTransaction();
	     		recursoDAO.excluir(recursoTO);
	     		daoManager.commitTransaction();
	       }catch (ExceptionNegocioBSC e) {
	           throw new ExceptionNegocioBSC(e.getMessage());
	       }finally{
	       	daoManager.endTransaction();
	       }       
	   }
   
   public void alterar(RecursoTO recursoTO) throws ExceptionNegocioBSC{
   	DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
     		RecursoDAO recursoDAO = (RecursoDAO) daoManager.getDao(RecursoDAO.class);
     		daoManager.startTransaction();
     		recursoDAO.alterar(recursoTO);
     		daoManager.commitTransaction();
       }catch (ExceptionNegocioBSC e) {
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }       
   }
   
   public RecursoTO consultarUm(RecursoTO recursoTO) throws ExceptionNegocioBSC{
   	DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
     		RecursoDAO recursoDAO = (RecursoDAO) daoManager.getDao(RecursoDAO.class);
     		daoManager.startTransaction();
     		RecursoTO retorno = recursoDAO.consultarUm(recursoTO);
     		return retorno;
       }catch (ExceptionNegocioBSC e) {
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }       
   }

   public int consultarMax(RecursoTO recursoTO) throws ExceptionNegocioBSC{
   	DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
     		RecursoDAO recursoDAO = (RecursoDAO) daoManager.getDao(RecursoDAO.class);
     		daoManager.startTransaction();
     		return recursoDAO.consultarMax(recursoTO);
       }catch (ExceptionNegocioBSC e) {
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }       
   }
   
}
