package br.com.intraBSC.negocio;

import java.util.Collection;
import br.com.intraBSC.excecoes.ExceptionNegocioBSC;
import br.com.intraBSC.modelo.PeriodicidadeTO;
import br.com.intraBSC.persistencia.FabricaDAO;
import br.com.intraBSC.persistencia.PeriodicidadeDAO;

import com.ibatis.dao.client.DaoManager;

public class PeriodicidadeBO {
	//private static Log log = LogFactory.getLog(PeriodicidadeBO.class);
    public PeriodicidadeBO(){       
    }
    
    public Collection consultarVarios(PeriodicidadeTO periodicidadeTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		PeriodicidadeDAO periodicidadeDAO = (PeriodicidadeDAO) daoManager.getDao(PeriodicidadeDAO.class);
      		daoManager.startTransaction();
      		Collection listaMapaEstrategico = periodicidadeDAO.consultarVarios(periodicidadeTO);
      		return listaMapaEstrategico;
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    
    public void incluir(PeriodicidadeTO periodicidadeTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		PeriodicidadeDAO periodicidadeDAO = (PeriodicidadeDAO) daoManager.getDao(PeriodicidadeDAO.class);
      		daoManager.startTransaction();
      		periodicidadeTO.setId(consultarMax(periodicidadeTO));
      		periodicidadeDAO.incluir(periodicidadeTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    
    public void alterar(PeriodicidadeTO periodicidadeTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		PeriodicidadeDAO periodicidadeDAO = (PeriodicidadeDAO) daoManager.getDao(PeriodicidadeDAO.class);
      		daoManager.startTransaction();
      		periodicidadeDAO.alterar(periodicidadeTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    
    public PeriodicidadeTO consultarUm(PeriodicidadeTO periodicidadeTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		PeriodicidadeDAO periodicidadeDAO = (PeriodicidadeDAO) daoManager.getDao(PeriodicidadeDAO.class);
      		daoManager.startTransaction();
      		PeriodicidadeTO retorno = periodicidadeDAO.consultarUm(periodicidadeTO);
      		return retorno;
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    
    public int consultarMax(PeriodicidadeTO periodicidadeTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
        	PeriodicidadeDAO periodicidadeDAO = (PeriodicidadeDAO) daoManager.getDao(PeriodicidadeDAO.class);
      		daoManager.startTransaction();
      		return periodicidadeDAO.consultarMax(periodicidadeTO);
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
}
