package br.com.intraBSC.negocio;

import java.util.Collection;

import br.com.intraBSC.excecoes.ExceptionNegocioBSC;
import br.com.intraBSC.modelo.CausaEfeitoTO;
import br.com.intraBSC.persistencia.CausaEfeitoDAO;
import br.com.intraBSC.persistencia.FabricaDAO;

import com.ibatis.dao.client.DaoManager;

public class CausaEfeitoBO {
	
	public CausaEfeitoBO(){		
	}
	
    public Collection consultarVarios(CausaEfeitoTO causaEfeitoTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		CausaEfeitoDAO causaEfeitoDAO = (CausaEfeitoDAO) daoManager.getDao(CausaEfeitoDAO.class);
      		daoManager.startTransaction();
      		Collection listaCausaEfeito = causaEfeitoDAO.consultarVarios(causaEfeitoTO);
      		return listaCausaEfeito;
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    public Collection consultarEfeitosObjetivo(CausaEfeitoTO causaEfeitoTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		CausaEfeitoDAO causaEfeitoDAO = (CausaEfeitoDAO) daoManager.getDao(CausaEfeitoDAO.class);
      		daoManager.startTransaction();
      		Collection listaCausaEfeito = causaEfeitoDAO.consultarVarios(causaEfeitoTO);
      		return listaCausaEfeito;
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    
    
    public void incluir(CausaEfeitoTO causaEfeitoTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		CausaEfeitoDAO causaEfeitoDAO = (CausaEfeitoDAO) daoManager.getDao(CausaEfeitoDAO.class);
      		daoManager.startTransaction();
      		causaEfeitoDAO.incluir(causaEfeitoTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    
    public void alterar(CausaEfeitoTO causaEfeitoTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		CausaEfeitoDAO causaEfeitoDAO = (CausaEfeitoDAO) daoManager.getDao(CausaEfeitoDAO.class);
      		daoManager.startTransaction();
      		causaEfeitoDAO.alterar(causaEfeitoTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    
    public void excluir(CausaEfeitoTO causaEfeitoTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		CausaEfeitoDAO causaEfeitoDAO = (CausaEfeitoDAO) daoManager.getDao(CausaEfeitoDAO.class);
      		daoManager.startTransaction();
      		causaEfeitoDAO.excluir(causaEfeitoTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
}
