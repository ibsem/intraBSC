

package br.com.intraPRO.negocio;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.intraBSC.persistencia.FabricaDAO;
import br.com.intraPRO.excecoes.ExceptionNegocioPRO;
import br.com.intraPRO.modelo.AtividadeTO;
import br.com.intraPRO.modelo.RelacionamentosTO;
import br.com.intraPRO.modelo.TarefaTO;
import br.com.intraPRO.persistencia.AtividadeDAO;

import com.ibatis.dao.client.DaoManager;



/**
 * @author Tiago Trindade Stangarlin
 */
public class AtividadeBO{
	private static Log log = LogFactory.getLog(AtividadeBO.class);
   public AtividadeBO(){    
   }
   
   @SuppressWarnings("unchecked")
   public Collection consultarAtividadesVarios(AtividadeTO atividadeTO, Integer codProcesso) throws ExceptionNegocioPRO{	   
	   DaoManager daoManager = FabricaDAO.getDaoManager();
	   Collection listaObejtivos = new ArrayList();
       try{        	
    	    AtividadeDAO atividadeDAO = (AtividadeDAO) daoManager.getDao(AtividadeDAO.class);
     		daoManager.startTransaction();
			atividadeTO.setIdProcesso(codProcesso.intValue());
			listaObejtivos.addAll(atividadeDAO.consultarVarios(atividadeTO));			
       }catch (ExceptionNegocioPRO e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioPRO(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }    
       return listaObejtivos;
   }
   
   /*Tiago Trindade Stangarlin
    * Metodo para ativar o relatorio chamado ProcessoEstrategicoPrincipal.jasper*/
   public JasperPrint atividadeRelatorioDetalha(AtividadeTO atividadeTO) throws ExceptionNegocioPRO{
   		try {
			//Carrega o Relatório
	        File reportFile = new File(atividadeTO.getTransicaoRel());
	        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile.getPath());	        
	        		
	        atividadeTO.setJasperReport(jasperReport);
	        
	        DaoManager daoManager = FabricaDAO.getDaoManager();
	        AtividadeDAO relatorioDAO = (AtividadeDAO) daoManager.getDao(AtividadeDAO.class);			
			return relatorioDAO.atividadeRelatorioDetalha(atividadeTO);
		} catch (JRException e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		}
   }
   
   public void incluir(AtividadeTO atividadeTO) throws ExceptionNegocioPRO{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	    AtividadeDAO atividadeDAO = (AtividadeDAO) daoManager.getDao(AtividadeDAO.class);
     		daoManager.startTransaction();
			atividadeTO.setId(consultarMax(atividadeTO));
			atividadeDAO.incluir(atividadeTO);
			
			/*Realiza a inclusao na entidade de relacionamento de atividade para perspectiva*/
     		RelacionamentosBO relacionamentosBO = new RelacionamentosBO();
     		RelacionamentosTO relacionamentosTO = new RelacionamentosTO();
     		relacionamentosTO.setFASIDFAS(atividadeTO.getIdFase());
     		relacionamentosTO.setFASIDATV(atividadeTO.getId());
     		relacionamentosBO.incluirFAS(relacionamentosTO);
     		/*Realiza a inclusao na entidade de relacionamento de atividade para Tema*/
     		relacionamentosTO.setATVIDATV(atividadeTO.getId());

  
     		
			daoManager.commitTransaction();
       }catch (ExceptionNegocioPRO e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioPRO(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }
  }

   
   public void alterar(AtividadeTO atividadeTO) throws ExceptionNegocioPRO{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	    AtividadeDAO atividadeDAO = (AtividadeDAO) daoManager.getDao(AtividadeDAO.class);
     		daoManager.startTransaction();			
			atividadeDAO.alterar(atividadeTO);
			
			/*altera relacionamentos de perspectiva e tema*/
			RelacionamentosBO relacionamentosBO = new RelacionamentosBO();
			RelacionamentosTO relacionamentosTO = new RelacionamentosTO();
			relacionamentosTO.setFASIDATV(atividadeTO.getId());
			relacionamentosTO.setFASIDFAS(atividadeTO.getIdFase());
			
			relacionamentosBO.alterarFAS(relacionamentosTO);
			relacionamentosTO.setATVIDATV(atividadeTO.getId());
			
			daoManager.commitTransaction();
       }catch (ExceptionNegocioPRO e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioPRO(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }
   }
   
   public int consultarMax(AtividadeTO atividadeTO) throws ExceptionNegocioPRO{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	    AtividadeDAO atividadeDAO = (AtividadeDAO) daoManager.getDao(AtividadeDAO.class);
     		daoManager.startTransaction();			
			return atividadeDAO.consultarMax(atividadeTO);
       }catch (ExceptionNegocioPRO e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioPRO(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }
   }
   
   public Collection consultarVarios(AtividadeTO atividadeTO) throws ExceptionNegocioPRO{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	    AtividadeDAO atividadeDAO = (AtividadeDAO) daoManager.getDao(AtividadeDAO.class);
     		daoManager.startTransaction();			
			return atividadeDAO.consultarVarios(atividadeTO);
       }catch (ExceptionNegocioPRO e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioPRO(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }
   }
   
   public AtividadeTO consultarUm(AtividadeTO atividadeTO) throws ExceptionNegocioPRO{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	    AtividadeDAO atividadeDAO = (AtividadeDAO) daoManager.getDao(AtividadeDAO.class);
     		daoManager.startTransaction();
     		AtividadeTO retorno = new AtividadeTO();
     		retorno = atividadeDAO.consultarUm(atividadeTO);
     		
     		/*Consultar nas entidades de relacionamento o idPErspectiva e idTema*/
     		RelacionamentosBO relacionamentosBO = new RelacionamentosBO();
     		RelacionamentosTO relacionamentosTO = new RelacionamentosTO();
     		relacionamentosTO.setFASIDATV(atividadeTO.getId());
     		retorno.setIdFase(relacionamentosBO.consultarUmFAS(relacionamentosTO).getFASIDFAS());
     		
     		/*Realiza a inclusao na entidade de relacionamento de atividade para Tema*/
     		relacionamentosTO.setATVIDATV(atividadeTO.getId());

     		
			return retorno;
       }catch (ExceptionNegocioPRO e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioPRO(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }
   }

   /*Consulta que retorna os atividades de um mapa para completar a lista utilizada
    * na tela de Causa e Efeito*/
   @SuppressWarnings("unchecked")
public Collection consultarAtividadeProcesso(AtividadeTO atividadeTO) throws ExceptionNegocioPRO{	   
	   DaoManager daoManager = FabricaDAO.getDaoManager();
	   Collection listaAtividades = new ArrayList();
       try{        	
    	    AtividadeDAO atividadeDAO = (AtividadeDAO) daoManager.getDao(AtividadeDAO.class);
     		daoManager.startTransaction();
			listaAtividades.addAll(atividadeDAO.consultarAtividadeProcesso(atividadeTO));			
       }catch (ExceptionNegocioPRO e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioPRO(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }    
       return listaAtividades;
   }
   @SuppressWarnings("unchecked")
   public Collection consultarAtividadesProcessoGrafico(AtividadeTO atividadeTO) throws ExceptionNegocioPRO{	   
	   DaoManager daoManager = FabricaDAO.getDaoManager();
	   Collection listaAtividades = new ArrayList();
       try{        	
    	    AtividadeDAO atividadeDAO = (AtividadeDAO) daoManager.getDao(AtividadeDAO.class);
     		daoManager.startTransaction();
			listaAtividades.addAll(atividadeDAO.consultarAtividadesProcessoGrafico(atividadeTO));			
       }catch (ExceptionNegocioPRO e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioPRO(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }    
       return listaAtividades;
   }
   
   /**
    * Metodo que consulta o codigo do mapa pelo o Obejtivo
    * @param indicadorTO
    * @return
    * @throws ExceptionNegocioPRO 
    */
   public Integer consultarProcessoPorAtividade(AtividadeTO atividadeTO) throws ExceptionNegocioPRO{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	   	AtividadeDAO obejtivoDAO = (AtividadeDAO) daoManager.getDao(AtividadeDAO.class);
     		daoManager.startTransaction();
			return obejtivoDAO.consultarProcessoPorAtividade(atividadeTO);
       }catch (ExceptionNegocioPRO e) {
           throw new ExceptionNegocioPRO(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }
   }
   
   public Collection consultarTarefaFerramentaConfiguracao(TarefaTO tarefaTO) throws ExceptionNegocioPRO, ExceptionNegocioPRO, ParseException{
 	   TarefaBO tarefaBO = new TarefaBO(); 
 	   return tarefaBO.consultarTarefaFerramentaConfiguracao(tarefaTO);
   }
   
}
