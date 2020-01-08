package br.com.intraPRO.negocio;

import java.util.Collection;

import br.com.intraPRO.excecoes.ExceptionNegocioPRO;
import br.com.intraPRO.modelo.RelacionamentosTO;
import br.com.intraBSC.persistencia.FabricaDAO;
import br.com.intraPRO.persistencia.RelacionamentosDAO;
import br.com.intraPRO.modelo.ConfigTarefaTO;

import com.ibatis.dao.client.DaoManager;

public class RelacionamentosBO {

	/*Consulta na tabela de relacionamento de mapa com perspectiva*/
    public RelacionamentosTO consultarUmPRO(RelacionamentosTO relacionamentosTO) throws ExceptionNegocioPRO{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		RelacionamentosDAO relacionamentosDAO = (RelacionamentosDAO) daoManager.getDao(RelacionamentosDAO.class);
      		daoManager.startTransaction();
      		RelacionamentosTO resultadoTO = relacionamentosDAO.consultarUmPRO(relacionamentosTO);
      		return resultadoTO;
        }catch (ExceptionNegocioPRO e) {        	
            throw new ExceptionNegocioPRO(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }
    }
    
    /*Consulta na tabela de perspectiva com objetivo*/
    public RelacionamentosTO consultarUmFAS(RelacionamentosTO relacionamentosTO) throws ExceptionNegocioPRO{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		RelacionamentosDAO relacionamentosDAO = (RelacionamentosDAO) daoManager.getDao(RelacionamentosDAO.class);
      		daoManager.startTransaction();
      		RelacionamentosTO resultadoTO = relacionamentosDAO.consultarUmFAS(relacionamentosTO);
      		return resultadoTO;
        }catch (ExceptionNegocioPRO e) {        	
            throw new ExceptionNegocioPRO(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }
    }
    
    
	/*inclusao na tabela de relacionamento de mapa com perspectiva*/
    public void incluirPRO(RelacionamentosTO relacionamentosTO) throws ExceptionNegocioPRO{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		RelacionamentosDAO relacionamentosDAO = (RelacionamentosDAO) daoManager.getDao(RelacionamentosDAO.class);
      		daoManager.startTransaction();
      		relacionamentosDAO.incluirPRO(relacionamentosTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioPRO e) {        	
            throw new ExceptionNegocioPRO(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }
    }
    
    
    /*inclusao na tabela de relacionamento de Cinfiguracao da tarefa com Responsavel*/
    public void incluirCONFIGTASKOWNER(ConfigTarefaTO configTarefaTO) throws ExceptionNegocioPRO{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		RelacionamentosDAO relacionamentosDAO = (RelacionamentosDAO) daoManager.getDao(RelacionamentosDAO.class);
      		daoManager.startTransaction();
      		relacionamentosDAO.incluirRelCONFIGTASKOWNER(configTarefaTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioPRO e) {        	
            throw new ExceptionNegocioPRO(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }
    }
    
    /*inclusao na tabela de relacionamento de mapa com perspectiva*/
    public void incluirFAS(RelacionamentosTO relacionamentosTO) throws ExceptionNegocioPRO{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		RelacionamentosDAO relacionamentosDAO = (RelacionamentosDAO) daoManager.getDao(RelacionamentosDAO.class);
      		daoManager.startTransaction();
      		relacionamentosDAO.incluirFAS(relacionamentosTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioPRO e) {        	
            throw new ExceptionNegocioPRO(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }
    }
    
    
    /*Consulta na tabela de tema com objetivo*/
    public Collection consultarVariosPRO(RelacionamentosTO relacionamentosTO) throws ExceptionNegocioPRO{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		RelacionamentosDAO relacionamentosDAO = (RelacionamentosDAO) daoManager.getDao(RelacionamentosDAO.class);
      		daoManager.startTransaction();
      		return relacionamentosDAO.consultarVariosPRO(relacionamentosTO);
        }catch (ExceptionNegocioPRO e) {        	
            throw new ExceptionNegocioPRO(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }
    }

    
    public void alterarPRO(RelacionamentosTO relacionamentosTO) throws ExceptionNegocioPRO{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		RelacionamentosDAO relacionamentosDAO = (RelacionamentosDAO) daoManager.getDao(RelacionamentosDAO.class);
      		daoManager.startTransaction();
      		relacionamentosDAO.alterarPRO(relacionamentosTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioPRO e) {        	
            throw new ExceptionNegocioPRO(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }
    }
    
    public void alterarFAS(RelacionamentosTO relacionamentosTO) throws ExceptionNegocioPRO{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		RelacionamentosDAO relacionamentosDAO = (RelacionamentosDAO) daoManager.getDao(RelacionamentosDAO.class);
      		daoManager.startTransaction();
      		relacionamentosDAO.alterarFAS(relacionamentosTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioPRO e) {        	
            throw new ExceptionNegocioPRO(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }
    }
    
    
    /*Alterar na tabela de relacionamento de Configuracao da tarefa com Responsavel*/
    public void alterarCONFIGTASKOWNER(ConfigTarefaTO configTarefaTO) throws ExceptionNegocioPRO{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		RelacionamentosDAO relacionamentosDAO = (RelacionamentosDAO) daoManager.getDao(RelacionamentosDAO.class);
      		daoManager.startTransaction();
      		relacionamentosDAO.alterarRelCONFIGTASKOWNER(configTarefaTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioPRO e) {        	
            throw new ExceptionNegocioPRO(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }
    }
    
 
}
