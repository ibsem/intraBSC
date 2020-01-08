//Source file: C:\\Java\\workspace\\IntraBSC\\WEB-INF\\src\\br\\com\\intraBSC\\modelo\\br\\com\\intraBSC\\negocio\\MetaBO.java

package br.com.intraBSC.negocio;

import java.util.Collection;

import br.com.intraBSC.excecoes.ExceptionNegocioBSC;
import br.com.intraBSC.modelo.IndicadorTO;
import br.com.intraBSC.modelo.MetaTO;
import br.com.intraBSC.persistencia.FabricaDAO;
import br.com.intraBSC.persistencia.MetaDAO;

import com.ibatis.dao.client.DaoManager;


public class MetaBO{
   
   public MetaBO(){
   }
   
   public Collection consultarVarios(MetaTO metaTO) throws ExceptionNegocioBSC{
   	DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	   	MetaDAO metaDAO = (MetaDAO) daoManager.getDao(MetaDAO.class);
     		daoManager.startTransaction();
     		Collection listaMeta = metaDAO.consultarVarios(metaTO);
     		return listaMeta;
       }catch (ExceptionNegocioBSC e) {
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }       
   }
   
   public MetaTO consultarUm(MetaTO metaTO) throws ExceptionNegocioBSC{
   	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	   	MetaDAO metaDAO = (MetaDAO) daoManager.getDao(MetaDAO.class);
     		daoManager.startTransaction();
     		return metaDAO.consultarUm(metaTO);
       }catch (ExceptionNegocioBSC e) {
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }       
   }
   
   public void incluir(MetaTO metaTO) throws ExceptionNegocioBSC{
   	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	   	MetaDAO metaDAO = (MetaDAO) daoManager.getDao(MetaDAO.class);
     		daoManager.startTransaction();
     		metaTO.setId(consultarMax(metaTO));
     		metaDAO.incluir(metaTO);
     		daoManager.commitTransaction();
       }catch (ExceptionNegocioBSC e) {
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }       
   }
   
   public void excluir(MetaTO metaTO) throws ExceptionNegocioBSC{
   	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	   	MetaDAO metaDAO = (MetaDAO) daoManager.getDao(MetaDAO.class);
     		daoManager.startTransaction();
     		metaDAO.excluir(metaTO);
     		daoManager.commitTransaction();
       }catch (ExceptionNegocioBSC e) {
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }       
   }
   
   public void alterar(MetaTO metaTO) throws ExceptionNegocioBSC{
   	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	   	MetaDAO metaDAO = (MetaDAO) daoManager.getDao(MetaDAO.class);
     		daoManager.startTransaction();
     		metaDAO.alterar(metaTO);
     		daoManager.commitTransaction();
       }catch (ExceptionNegocioBSC e) {
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }       
   }
   
   public IndicadorTO consultarUmIndicador(MetaTO metaTO) throws ExceptionNegocioBSC{   	   
       try{
    	   	IndicadorBO indicadorBO = new IndicadorBO();
    	   	IndicadorTO indicadorTO = new IndicadorTO();
    	   	indicadorTO.setId(metaTO.getIdIndicador());
     		return indicadorBO.consultarUm(indicadorTO);
       }catch (ExceptionNegocioBSC e) {
           throw new ExceptionNegocioBSC(e.getMessage());
       }      
   }
   
   public int consultarMax(MetaTO metaTO) throws ExceptionNegocioBSC{
   	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	   	MetaDAO metaDAO = (MetaDAO) daoManager.getDao(MetaDAO.class);
     		daoManager.startTransaction();
     		return metaDAO.consultarMax(metaTO);
       }catch (ExceptionNegocioBSC e) {
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }       
   }

}
