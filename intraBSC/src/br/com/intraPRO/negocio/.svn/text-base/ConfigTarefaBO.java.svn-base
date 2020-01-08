
package br.com.intraPRO.negocio;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ibatis.dao.client.DaoManager;

import br.com.intraBSC.excecoes.ExceptionNegocioBSC;
import br.com.intraBSC.negocio.RelacionamentosBO;
import br.com.intraBSC.persistencia.FabricaDAO;
import br.com.intraPRO.excecoes.ExceptionNegocioPRO;
import br.com.intraPRO.modelo.TarefaTO;
import br.com.intraPRO.modelo.ConfigTarefaTO;
import br.com.intraPRO.modelo.ParticipanteTO;
import br.com.intraPRO.persistencia.ConfigTarefaDAO;

public class ConfigTarefaBO {
	private static Log log = LogFactory.getLog(ConfigTarefaBO.class);
	public ConfigTarefaBO(){
   }

	public void incluir(ConfigTarefaTO configTarefaTO) throws ExceptionNegocioPRO, ExceptionNegocioBSC{
   		DaoManager daoManager = FabricaDAO.getDaoManager();
   		ConfigTarefaDAO configTarefaDAO = (ConfigTarefaDAO) daoManager.getDao(ConfigTarefaDAO.class);
   		try{
   			daoManager.startTransaction();
   			configTarefaTO.setCodigoConfigTarefa(consultarMax());  
	   		configTarefaDAO.incluir(configTarefaTO);
	   		RelacionamentosBO relacionamentosBO = new RelacionamentosBO();
	   		relacionamentosBO.incluirCONFIGTASKOWNER(configTarefaTO);
	   		daoManager.commitTransaction();
   		}
   		catch(ExceptionNegocioPRO e){
   			log.error(e.getMessage());
   			throw new ExceptionNegocioPRO(e.getMessage());
   		}finally{
   			daoManager.endTransaction();
   		}
   }
   

	public ConfigTarefaTO consultarUm(ConfigTarefaTO configTarefaTO) throws ExceptionNegocioPRO{
	   	DaoManager daoManager = FabricaDAO.getDaoManager();
	   	ConfigTarefaDAO configTarefaDAO= (ConfigTarefaDAO) daoManager.getDao(ConfigTarefaDAO.class);
	   	ConfigTarefaTO toReturn;
	   	try{	   	    
	   	    daoManager.startTransaction();
	   	    toReturn = configTarefaDAO.consultarUm(configTarefaTO);	   		
	   	}
	   	catch(ExceptionNegocioPRO e){
	   		throw new ExceptionNegocioPRO(e.getMessage());
	   	}finally{
			daoManager.endTransaction();
		}
	   	return toReturn;
   }

   public ConfigTarefaTO alterar(ConfigTarefaTO configTarefaTO) throws ExceptionNegocioPRO, ExceptionNegocioBSC{
	   	DaoManager daoManager = FabricaDAO.getDaoManager();
	   	ConfigTarefaDAO configTarefaDAO= (ConfigTarefaDAO) daoManager.getDao(ConfigTarefaDAO.class);
	   	try{
	   		daoManager.startTransaction();
	   		configTarefaDAO.alterar(configTarefaTO);
	   		RelacionamentosBO relacionamentosBO = new RelacionamentosBO();
	   		relacionamentosBO.alterarCONFIGTASKOWNER(configTarefaTO);
	   		daoManager.commitTransaction();
	   	}
	   	catch(ExceptionNegocioPRO e){
	   		throw new ExceptionNegocioPRO(e.getMessage());
	   	}finally{
	   		daoManager.endTransaction();
	   	}
	   	return null;
   }
   
   
   public Collection consultarVarios(ConfigTarefaTO configTarefaTO) throws ExceptionNegocioPRO{
		DaoManager daoManager = FabricaDAO.getDaoManager();
		ConfigTarefaDAO configTarefaDAO = (ConfigTarefaDAO) daoManager.getDao(ConfigTarefaDAO.class);
		Collection colecao = new ArrayList();
		try {	  
			daoManager.startTransaction();
			colecao = configTarefaDAO.consultarVarios(configTarefaTO);			
		} catch (ExceptionNegocioPRO e) {
			throw new ExceptionNegocioPRO(e.getMessage());
		}finally{
			daoManager.endTransaction();
		}
		return colecao;
   }
   
   public Collection consultarVariosPorGrupo(ConfigTarefaTO configTarefaTO) throws ExceptionNegocioPRO{
		DaoManager daoManager = FabricaDAO.getDaoManager();
		ConfigTarefaDAO configTarefaDAO = (ConfigTarefaDAO) daoManager.getDao(ConfigTarefaDAO.class);
		Collection colecao = new ArrayList();
		try {	  
			daoManager.startTransaction();
			colecao = configTarefaDAO.consultarVariosPorGrupo(configTarefaTO);			
		} catch (ExceptionNegocioPRO e) {
			throw new ExceptionNegocioPRO(e.getMessage());
		}finally{
			daoManager.endTransaction();
		}
		return colecao;
  }
   
   
   public int consultarMax() throws ExceptionNegocioPRO{
		DaoManager daoManager = FabricaDAO.getDaoManager();
		ConfigTarefaDAO configTarefaDAO = (ConfigTarefaDAO) daoManager.getDao(ConfigTarefaDAO.class);
		int retorno = 0;
		try {
			daoManager.startTransaction();
			retorno = configTarefaDAO.consultarMax();
		} catch (ExceptionNegocioPRO e) {
			throw new ExceptionNegocioPRO(e.getMessage());
		} finally{
			daoManager.endTransaction();
		}
		return retorno;
   }
   
   public Collection consultarTiposPorTarefa(TarefaTO tarefaTO, ParticipanteTO participanteTO) throws ExceptionNegocioPRO{
		DaoManager daoManager = FabricaDAO.getDaoManager();
		ConfigTarefaDAO configTarefaDAO = (ConfigTarefaDAO) daoManager.getDao(ConfigTarefaDAO.class);
		Collection colecao = new ArrayList();
		try {	   	
			daoManager.startTransaction();
			colecao = configTarefaDAO.consultarTiposPorTarefa(tarefaTO,participanteTO);			
		} catch (ExceptionNegocioPRO e) {
			throw new ExceptionNegocioPRO(e.getMessage());
		}finally{
			daoManager.endTransaction();
		}
		return colecao;
  }
   
  
   public Collection consultarConfigTarefaAcesso() throws ExceptionNegocioPRO{
   		DaoManager daoManager = FabricaDAO.getDaoManager();
		ConfigTarefaDAO configTarefaDAO = (ConfigTarefaDAO) daoManager.getDao(ConfigTarefaDAO.class);
		Collection result = new ArrayList();
   		try{
	   		ConfigTarefaTO configTarefaTO = new ConfigTarefaTO();
	   				   		
		    configTarefaTO.setIndTipoVigencia("S");
		    configTarefaTO.setIndVisivelPrefixo(1);
  			daoManager.startTransaction();
  			result = configTarefaDAO.consultarVariosVisivel(configTarefaTO);
	  			
	  			
	   		}catch(ExceptionNegocioPRO e){
			log.error(e.getMessage());
   			throw new ExceptionNegocioPRO(e.getMessage());
   		}finally{
			daoManager.endTransaction();
		}
   		return result;	
   }
   
 
   public Collection consultarConfigTarefa() throws ExceptionNegocioPRO{
   		DaoManager daoManager = FabricaDAO.getDaoManager();
		ConfigTarefaDAO configTarefaDAO = (ConfigTarefaDAO) daoManager.getDao(ConfigTarefaDAO.class);
		Collection result = new ArrayList();
   		try{
	   		ConfigTarefaTO configTarefaTO = new ConfigTarefaTO();
		    configTarefaTO.setIndTipoVigencia("S");
		    configTarefaTO.setIndVisivelPrefixo(1);
  			daoManager.startTransaction();
  			result = configTarefaDAO.consultarVariosVisivel(configTarefaTO);
	   	}catch(ExceptionNegocioPRO e){
			log.error(e.getMessage());
   			throw new ExceptionNegocioPRO(e.getMessage());
   		}finally{
			daoManager.endTransaction();
		}
   		return result;
   			
   }
	   
}