package br.com.intraBSC.negocio;

import java.util.Collection;

import br.com.intraBSC.excecoes.ExceptionNegocioBSC;
import br.com.intraBSC.modelo.RelacionamentosTO;
import br.com.intraBSC.persistencia.FabricaDAO;
import br.com.intraBSC.persistencia.RelacionamentosDAO;
import br.com.intraPRO.modelo.ConfigTarefaTO;

import com.ibatis.dao.client.DaoManager;

public class RelacionamentosBO {

	/*Consulta na tabela de relacionamento de mapa com perspectiva*/
    public RelacionamentosTO consultarUmBSC(RelacionamentosTO relacionamentosTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		RelacionamentosDAO relacionamentosDAO = (RelacionamentosDAO) daoManager.getDao(RelacionamentosDAO.class);
      		daoManager.startTransaction();
      		RelacionamentosTO resultadoTO = relacionamentosDAO.consultarUmBSC(relacionamentosTO);
      		return resultadoTO;
        }catch (ExceptionNegocioBSC e) {        	
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }
    }
    
    /*Consulta na tabela de perspectiva com objetivo*/
    public RelacionamentosTO consultarUmPERS(RelacionamentosTO relacionamentosTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		RelacionamentosDAO relacionamentosDAO = (RelacionamentosDAO) daoManager.getDao(RelacionamentosDAO.class);
      		daoManager.startTransaction();
      		RelacionamentosTO resultadoTO = relacionamentosDAO.consultarUmPERS(relacionamentosTO);
      		return resultadoTO;
        }catch (ExceptionNegocioBSC e) {        	
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }
    }
    
    /*Consulta na tabela de tema com objetivo*/
    public RelacionamentosTO consultarUmTHEME(RelacionamentosTO relacionamentosTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		RelacionamentosDAO relacionamentosDAO = (RelacionamentosDAO) daoManager.getDao(RelacionamentosDAO.class);
      		daoManager.startTransaction();
      		RelacionamentosTO resultadoTO = relacionamentosDAO.consultarUmTHEME(relacionamentosTO);
      		return resultadoTO;
        }catch (ExceptionNegocioBSC e) {        	
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }
    }
    
	/*inclusao na tabela de relacionamento de mapa com perspectiva*/
    public void incluirBSC(RelacionamentosTO relacionamentosTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		RelacionamentosDAO relacionamentosDAO = (RelacionamentosDAO) daoManager.getDao(RelacionamentosDAO.class);
      		daoManager.startTransaction();
      		relacionamentosDAO.incluirBSC(relacionamentosTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioBSC e) {        	
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }
    }
    
    
    /*inclusao na tabela de relacionamento de Cinfiguracao da tarefa com Responsavel*/
    public void incluirCONFIGTASKOWNER(ConfigTarefaTO configTarefaTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		RelacionamentosDAO relacionamentosDAO = (RelacionamentosDAO) daoManager.getDao(RelacionamentosDAO.class);
      		daoManager.startTransaction();
      		relacionamentosDAO.incluirRelCONFIGTASKOWNER(configTarefaTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioBSC e) {        	
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }
    }
    
    /*inclusao na tabela de relacionamento de mapa com perspectiva*/
    public void incluirPERS(RelacionamentosTO relacionamentosTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		RelacionamentosDAO relacionamentosDAO = (RelacionamentosDAO) daoManager.getDao(RelacionamentosDAO.class);
      		daoManager.startTransaction();
      		relacionamentosDAO.incluirPERS(relacionamentosTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioBSC e) {        	
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }
    }
    
    /*inclusao na tabela de relacionamento de mapa com perspectiva*/
    public void incluirTHEME(RelacionamentosTO relacionamentosTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		RelacionamentosDAO relacionamentosDAO = (RelacionamentosDAO) daoManager.getDao(RelacionamentosDAO.class);
      		daoManager.startTransaction();
      		relacionamentosDAO.incluirTHEME(relacionamentosTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioBSC e) {        	
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }
    }
    
    /*Consulta na tabela de tema com objetivo*/
    public Collection consultarVariosBSC(RelacionamentosTO relacionamentosTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		RelacionamentosDAO relacionamentosDAO = (RelacionamentosDAO) daoManager.getDao(RelacionamentosDAO.class);
      		daoManager.startTransaction();
      		return relacionamentosDAO.consultarVariosBSC(relacionamentosTO);
        }catch (ExceptionNegocioBSC e) {        	
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }
    }

    
    public void alterarBSC(RelacionamentosTO relacionamentosTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		RelacionamentosDAO relacionamentosDAO = (RelacionamentosDAO) daoManager.getDao(RelacionamentosDAO.class);
      		daoManager.startTransaction();
      		relacionamentosDAO.alterarBSC(relacionamentosTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioBSC e) {        	
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }
    }
    
    public void alterarPERS(RelacionamentosTO relacionamentosTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		RelacionamentosDAO relacionamentosDAO = (RelacionamentosDAO) daoManager.getDao(RelacionamentosDAO.class);
      		daoManager.startTransaction();
      		relacionamentosDAO.alterarPERS(relacionamentosTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioBSC e) {        	
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }
    }
    
    
    /*Alterar na tabela de relacionamento de Configuracao da tarefa com Responsavel*/
    public void alterarCONFIGTASKOWNER(ConfigTarefaTO configTarefaTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		RelacionamentosDAO relacionamentosDAO = (RelacionamentosDAO) daoManager.getDao(RelacionamentosDAO.class);
      		daoManager.startTransaction();
      		relacionamentosDAO.alterarRelCONFIGTASKOWNER(configTarefaTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioBSC e) {        	
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }
    }
    
    public void alterarTHEME(RelacionamentosTO relacionamentosTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		RelacionamentosDAO relacionamentosDAO = (RelacionamentosDAO) daoManager.getDao(RelacionamentosDAO.class);
      		daoManager.startTransaction();
      		relacionamentosDAO.alterarTHEME(relacionamentosTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioBSC e) {        	
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }
    }
}
