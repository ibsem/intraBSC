package br.com.intraBSC.negocio;

import java.util.Collection;

import br.com.intraBSC.excecoes.ExceptionNegocioBSC;
import br.com.intraBSC.modelo.PapelTO;
import br.com.intraBSC.persistencia.FabricaDAO;
import br.com.intraBSC.persistencia.PapelDAO;

import com.ibatis.dao.client.DaoManager;

public class PapelBO {
	
	//private static Log log = LogFactory.getLog(PapelBO.class);
    public PapelBO(){       
    }
    
    public Collection consultarVarios(PapelTO papelTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		PapelDAO papelDAO = (PapelDAO) daoManager.getDao(PapelDAO.class);
      		daoManager.startTransaction();
      		Collection listaPapel = papelDAO.consultarVarios(papelTO);
      		return listaPapel;
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    
    public void incluir(PapelTO papelTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		PapelDAO papelDAO = (PapelDAO) daoManager.getDao(PapelDAO.class);
      		daoManager.startTransaction();
      		papelTO.setId(consultarMax(papelTO));
      		papelDAO.incluir(papelTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    
    public void alterar(PapelTO papelTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		PapelDAO papelDAO = (PapelDAO) daoManager.getDao(PapelDAO.class);
      		daoManager.startTransaction();
      		papelDAO.alterar(papelTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    
    public PapelTO consultarUm(PapelTO papelTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		PapelDAO papelDAO = (PapelDAO) daoManager.getDao(PapelDAO.class);
      		daoManager.startTransaction();
      		PapelTO retorno = papelDAO.consultarUm(papelTO);
      		return retorno;
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }

    public int consultarMax(PapelTO papelTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		PapelDAO papelDAO = (PapelDAO) daoManager.getDao(PapelDAO.class);
      		daoManager.startTransaction();
      		return papelDAO.consultarMax(papelTO);
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    
}
