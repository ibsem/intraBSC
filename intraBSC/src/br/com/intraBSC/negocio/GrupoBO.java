package br.com.intraBSC.negocio;

import java.util.Collection;

import br.com.intraBSC.excecoes.ExceptionNegocioBSC;
import br.com.intraBSC.modelo.GrupoTO;
import br.com.intraBSC.persistencia.FabricaDAO;
import br.com.intraBSC.persistencia.GrupoDAO;

import com.ibatis.dao.client.DaoManager;

public class GrupoBO {

	public Collection consultarVarios(GrupoTO grupoTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		GrupoDAO grupoDAO = (GrupoDAO) daoManager.getDao(GrupoDAO.class);
      		daoManager.startTransaction();
      		Collection listaUnidade = grupoDAO.consultarVarios(grupoTO);
      		return listaUnidade;
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
	    
    public void incluir(GrupoTO grupoTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
        	GrupoDAO grupoDAO = (GrupoDAO) daoManager.getDao(GrupoDAO.class);
      		daoManager.startTransaction();
      		grupoTO.setCodigo(consultarMax(grupoTO));
      		grupoDAO.incluir(grupoTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    
    public void alterar(GrupoTO grupoTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
        	GrupoDAO grupoDAO = (GrupoDAO) daoManager.getDao(GrupoDAO.class);
      		daoManager.startTransaction();
      		grupoDAO.alterar(grupoTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    
    public GrupoTO consultarUm(GrupoTO grupoTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
        	GrupoDAO grupoDAO = (GrupoDAO) daoManager.getDao(GrupoDAO.class);
      		daoManager.startTransaction();
      		GrupoTO retorno = grupoDAO.consultarUm(grupoTO);
      		return retorno;
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }

    public int consultarMax(GrupoTO grupoTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
        	GrupoDAO grupoDAO = (GrupoDAO) daoManager.getDao(GrupoDAO.class);
      		daoManager.startTransaction();
      		return grupoDAO.consultarMax(grupoTO);
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
	
}
