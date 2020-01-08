package br.com.intraPRO.negocio;

import java.util.Collection;

import br.com.intraPRO.excecoes.ExceptionNegocioPRO;
import br.com.intraPRO.modelo.TransicaoTO;
import br.com.intraPRO.persistencia.TransicaoDAO;
import br.com.intraBSC.persistencia.FabricaDAO;

import com.ibatis.dao.client.DaoManager;

public class TransicaoBO {
	
	public TransicaoBO(){		
	}
	
    public Collection consultarVarios(TransicaoTO transicaoTO) throws ExceptionNegocioPRO{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		TransicaoDAO transicaoDAO = (TransicaoDAO) daoManager.getDao(TransicaoDAO.class);
      		daoManager.startTransaction();
      		Collection listaTransicao = transicaoDAO.consultarVarios(transicaoTO);
      		return listaTransicao;
        }catch (ExceptionNegocioPRO e) {
            throw new ExceptionNegocioPRO(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    public Collection consultarPosCondicaosAtividade(TransicaoTO transicaoTO) throws ExceptionNegocioPRO{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		TransicaoDAO transicaoDAO = (TransicaoDAO) daoManager.getDao(TransicaoDAO.class);
      		daoManager.startTransaction();
      		Collection listaTransicao = transicaoDAO.consultarVarios(transicaoTO);
      		return listaTransicao;
        }catch (ExceptionNegocioPRO e) {
            throw new ExceptionNegocioPRO(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    
    
    public void incluir(TransicaoTO transicaoTO) throws ExceptionNegocioPRO{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		TransicaoDAO transicaoDAO = (TransicaoDAO) daoManager.getDao(TransicaoDAO.class);
      		daoManager.startTransaction();
      		transicaoDAO.incluir(transicaoTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioPRO e) {
            throw new ExceptionNegocioPRO(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    
    public void alterar(TransicaoTO transicaoTO) throws ExceptionNegocioPRO{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		TransicaoDAO transicaoDAO = (TransicaoDAO) daoManager.getDao(TransicaoDAO.class);
      		daoManager.startTransaction();
      		transicaoDAO.alterar(transicaoTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioPRO e) {
            throw new ExceptionNegocioPRO(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    
    public void excluir(TransicaoTO transicaoTO) throws ExceptionNegocioPRO{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		TransicaoDAO transicaoDAO = (TransicaoDAO) daoManager.getDao(TransicaoDAO.class);
      		daoManager.startTransaction();
      		transicaoDAO.excluir(transicaoTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioPRO e) {
            throw new ExceptionNegocioPRO(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
}
