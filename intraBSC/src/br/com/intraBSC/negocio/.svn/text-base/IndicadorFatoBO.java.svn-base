package br.com.intraBSC.negocio;

import java.util.Collection;

import br.com.intraBSC.excecoes.ExceptionNegocioBSC;
import br.com.intraBSC.modelo.IndicadorFatoTO;
import br.com.intraBSC.modelo.IndicadorTO;
import br.com.intraBSC.persistencia.FabricaDAO;
import br.com.intraBSC.persistencia.IndicadorFatoDAO;

import com.ibatis.dao.client.DaoManager;

public class IndicadorFatoBO {

	/*Metodo de consulta varios registros de indicadorFato*/
	public Collection consultarVarios(IndicadorFatoTO indicadorFatoTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		IndicadorFatoDAO indicadorFatoDAO = (IndicadorFatoDAO) daoManager.getDao(IndicadorFatoDAO.class);
      		daoManager.startTransaction();
      		Collection listaUnidade = indicadorFatoDAO.consultarVarios(indicadorFatoTO);
      		return listaUnidade;
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
	
	/*Metodo de consulta um registro de indicadorFato*/
	public IndicadorFatoTO consultarUm(IndicadorFatoTO indicadorFatoTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		IndicadorFatoDAO indicadorFatoDAO = (IndicadorFatoDAO) daoManager.getDao(IndicadorFatoDAO.class);
      		daoManager.startTransaction();
      		return indicadorFatoDAO.consultarUm(indicadorFatoTO);
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
	public IndicadorFatoTO consultarUltimoIndicadorFato(IndicadorFatoTO indicadorFatoTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		IndicadorFatoDAO indicadorFatoDAO = (IndicadorFatoDAO) daoManager.getDao(IndicadorFatoDAO.class);
      		daoManager.startTransaction();
      		return indicadorFatoDAO.consultarUltimoIndicadorFato(indicadorFatoTO);
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
	
	
	
	
	
	/*Metodo de Inclusao de indicadorFato*/
	public void incluir(IndicadorFatoTO indicadorFatoTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		IndicadorFatoDAO indicadorFatoDAO = (IndicadorFatoDAO) daoManager.getDao(IndicadorFatoDAO.class);
      		daoManager.startTransaction();
      		indicadorFatoDAO.incluir(indicadorFatoTO);
      		
      		/*Altera a data na entidade de MEASURE*/
      		IndicadorBO indicadorBO = new IndicadorBO();
      		IndicadorTO indicadorTO = new IndicadorTO();
      		indicadorTO.setId(indicadorFatoTO.getId());
      		indicadorTO.setUltimaData(indicadorFatoTO.getData());
      		
      		indicadorBO.alterar(indicadorTO);
      		
      		
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
	
	/*Metodo de altera??o de indicadorFato*/
	public void alterar(IndicadorFatoTO indicadorFatoTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		IndicadorFatoDAO indicadorFatoDAO = (IndicadorFatoDAO) daoManager.getDao(IndicadorFatoDAO.class);
      		daoManager.startTransaction();
      		indicadorFatoDAO.alterar(indicadorFatoTO);
      		
      		/*Altera a data na entidade de MEASURE*/
      		IndicadorBO indicadorBO = new IndicadorBO();
      		IndicadorTO indicadorTO = new IndicadorTO();
      		indicadorTO.setId(indicadorFatoTO.getId());
      		indicadorTO.setUltimaData(indicadorFatoTO.getData());
      		indicadorBO.alterar(indicadorTO);
      		
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
	
	/*Metodo de exclusao de indicadorFato*/
	public void excluir(IndicadorFatoTO indicadorFatoTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		IndicadorFatoDAO indicadorFatoDAO = (IndicadorFatoDAO) daoManager.getDao(IndicadorFatoDAO.class);
      		daoManager.startTransaction();
      		indicadorFatoDAO.excluir(indicadorFatoTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
	
	/*Este metodo verifica se deve ser incluido um novo valor ou somente alterar um valor ja existente*/
	public void verificaInclusao(IndicadorFatoTO indicadorFatoTO) throws ExceptionNegocioBSC{    	
        try{        	
        	IndicadorFatoTO fatoTO = new IndicadorFatoTO();
        	fatoTO.setData(indicadorFatoTO.getData());
        	fatoTO.setId(indicadorFatoTO.getId());
        	if (consultarUm(fatoTO).getData() != null){
        		alterar(indicadorFatoTO);
        	}else{
        		incluir(indicadorFatoTO);
        	}
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }    
    }
	
	/*Metodo de consulta varios registros de indicadorFato*/
	public Collection consultarVariosIndicador(IndicadorFatoTO indicadorFatoTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		IndicadorFatoDAO indicadorFatoDAO = (IndicadorFatoDAO) daoManager.getDao(IndicadorFatoDAO.class);
      		daoManager.startTransaction();
      		Collection listaUnidade = indicadorFatoDAO.consultarVariosIndicador(indicadorFatoTO);
      		return listaUnidade;
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }

}
