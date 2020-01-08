package br.com.intraBSC.negocio;

import java.util.Collection;

import br.com.intraBSC.excecoes.ExceptionNegocioBSC;
import br.com.intraBSC.modelo.UnidadeTO;
import br.com.intraBSC.persistencia.FabricaDAO;
import br.com.intraBSC.persistencia.UnidadeDAO;

import com.ibatis.dao.client.DaoManager;

public class UnidadeBO {
	
	//private static Log log = LogFactory.getLog(UnidadeBO.class);
    public UnidadeBO(){       
    }
    
    public Collection consultarVarios(UnidadeTO unidadeTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		UnidadeDAO unidadeDAO = (UnidadeDAO) daoManager.getDao(UnidadeDAO.class);
      		daoManager.startTransaction();
      		Collection listaUnidade = unidadeDAO.consultarVarios(unidadeTO);
      		return listaUnidade;
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    
    public void incluir(UnidadeTO unidadeTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		UnidadeDAO unidadeDAO = (UnidadeDAO) daoManager.getDao(UnidadeDAO.class);
      		daoManager.startTransaction();
      		unidadeTO.setId(consultarMax(unidadeTO));
      		unidadeDAO.incluir(unidadeTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    
    public void alterar(UnidadeTO unidadeTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		UnidadeDAO unidadeDAO = (UnidadeDAO) daoManager.getDao(UnidadeDAO.class);
      		daoManager.startTransaction();
      		unidadeDAO.alterar(unidadeTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    
    public UnidadeTO consultarUm(UnidadeTO unidadeTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		UnidadeDAO unidadeDAO = (UnidadeDAO) daoManager.getDao(UnidadeDAO.class);
      		daoManager.startTransaction();
      		UnidadeTO retorno = unidadeDAO.consultarUm(unidadeTO);
      		return retorno;
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }

    public int consultarMax(UnidadeTO unidadeTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		UnidadeDAO unidadeDAO = (UnidadeDAO) daoManager.getDao(UnidadeDAO.class);
      		daoManager.startTransaction();
      		return unidadeDAO.consultarMax(unidadeTO);
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    
}
