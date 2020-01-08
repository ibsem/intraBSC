package br.com.intraBSC.negocio;

import java.util.Collection;
import br.com.intraBSC.excecoes.ExceptionNegocioBSC;
import br.com.intraBSC.modelo.TipoPerspectivaTO;
import br.com.intraBSC.persistencia.FabricaDAO;
import br.com.intraBSC.persistencia.TipoPerspectivaDAO;

import com.ibatis.dao.client.DaoManager;

public class TipoPerspectivaBO {
	//private static Log log = LogFactory.getLog(TipoPerspectivaBO.class);
    public TipoPerspectivaBO(){       
    }
    
    public Collection consultarVarios(TipoPerspectivaTO tipoPerspectivaTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		TipoPerspectivaDAO tipoPerspectivaDAO = (TipoPerspectivaDAO) daoManager.getDao(TipoPerspectivaDAO.class);
      		daoManager.startTransaction();
      		Collection listaMapaEstrategico = tipoPerspectivaDAO.consultarVarios(tipoPerspectivaTO);
      		return listaMapaEstrategico;
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    
    public void incluir(TipoPerspectivaTO tipoPerspectivaTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		TipoPerspectivaDAO tipoPerspectivaDAO = (TipoPerspectivaDAO) daoManager.getDao(TipoPerspectivaDAO.class);
      		daoManager.startTransaction();
      		tipoPerspectivaTO.setId(consultarMax(tipoPerspectivaTO));
      		tipoPerspectivaDAO.incluir(tipoPerspectivaTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    
    public void alterar(TipoPerspectivaTO tipoPerspectivaTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		TipoPerspectivaDAO tipoPerspectivaDAO = (TipoPerspectivaDAO) daoManager.getDao(TipoPerspectivaDAO.class);
      		daoManager.startTransaction();
      		tipoPerspectivaDAO.alterar(tipoPerspectivaTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    
    public TipoPerspectivaTO consultarUm(TipoPerspectivaTO tipoPerspectivaTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		TipoPerspectivaDAO tipoPerspectivaDAO = (TipoPerspectivaDAO) daoManager.getDao(TipoPerspectivaDAO.class);
      		daoManager.startTransaction();
      		TipoPerspectivaTO retorno = tipoPerspectivaDAO.consultarUm(tipoPerspectivaTO);
      		return retorno;
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    
    public int consultarMax(TipoPerspectivaTO tipoPerspectivaTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
        	TipoPerspectivaDAO tipoPerspectivaDAO = (TipoPerspectivaDAO) daoManager.getDao(TipoPerspectivaDAO.class);
      		daoManager.startTransaction();
      		return tipoPerspectivaDAO.consultarMax(tipoPerspectivaTO);
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
}
