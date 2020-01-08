

package br.com.intraBSC.negocio;

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

import br.com.intraBSC.excecoes.ExceptionNegocioBSC;
import br.com.intraBSC.modelo.ObjetivoTO;
import br.com.intraBSC.modelo.RelacionamentosTO;
import br.com.intraBSC.persistencia.FabricaDAO;
import br.com.intraBSC.persistencia.ObjetivoDAO;
import br.com.intraPRO.excecoes.ExceptionNegocioPRO;
import br.com.intraPRO.modelo.TarefaTO;
import br.com.intraPRO.negocio.TarefaBO;

import com.ibatis.dao.client.DaoManager;



/**
 * @author Tiago Trindade Stangarlin
 */
public class ObjetivoBO{
	private static Log log = LogFactory.getLog(ObjetivoBO.class);
   public ObjetivoBO(){    
   }
   
   @SuppressWarnings("unchecked")
   public Collection consultarObjetivosVarios(ObjetivoTO objetivoTO, Integer codMapa) throws ExceptionNegocioBSC{	   
	   DaoManager daoManager = FabricaDAO.getDaoManager();
	   Collection listaObejtivos = new ArrayList();
       try{        	
    	    ObjetivoDAO objetivoDAO = (ObjetivoDAO) daoManager.getDao(ObjetivoDAO.class);
     		daoManager.startTransaction();
			objetivoTO.setIdMapa(codMapa.intValue());
			listaObejtivos.addAll(objetivoDAO.consultarVarios(objetivoTO));			
       }catch (ExceptionNegocioBSC e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }    
       return listaObejtivos;
   }
   
   /*Tiago Trindade Stangarlin
    * Metodo para ativar o relatorio chamado MapaEstrategicoPrincipal.jasper*/
   public JasperPrint objetivoRelatorioDetalha(ObjetivoTO objetivoTO) throws ExceptionNegocioBSC{
   		try {
			//Carrega o Relatório
	        File reportFile = new File(objetivoTO.getCaminhoRel());
	        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile.getPath());	        
	        		
	        objetivoTO.setJasperReport(jasperReport);
	        
	        DaoManager daoManager = FabricaDAO.getDaoManager();
	        ObjetivoDAO relatorioDAO = (ObjetivoDAO) daoManager.getDao(ObjetivoDAO.class);			
			return relatorioDAO.objetivoRelatorioDetalha(objetivoTO);
		} catch (JRException e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioBSC(e.getMessage());
		}
   }
   
   public void incluir(ObjetivoTO objetivoTO) throws ExceptionNegocioBSC{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	    ObjetivoDAO objetivoDAO = (ObjetivoDAO) daoManager.getDao(ObjetivoDAO.class);
     		daoManager.startTransaction();
			objetivoTO.setId(consultarMax(objetivoTO));
			objetivoDAO.incluir(objetivoTO);
			
			/*Realiza a inclusao na entidade de relacionamento de objetivo para perspectiva*/
     		RelacionamentosBO relacionamentosBO = new RelacionamentosBO();
     		RelacionamentosTO relacionamentosTO = new RelacionamentosTO();
     		relacionamentosTO.setPERSIDPERS(objetivoTO.getIdPerspectiva());
     		relacionamentosTO.setPERSIDOBJ(objetivoTO.getId());
     		relacionamentosBO.incluirPERS(relacionamentosTO);
     		/*Realiza a inclusao na entidade de relacionamento de objetivo para Tema*/
     		relacionamentosTO.setOBJIDOBJ(objetivoTO.getId());
     		relacionamentosTO.setOBJIDTHEME(objetivoTO.getIdTema());
     		relacionamentosBO.incluirTHEME(relacionamentosTO);
     		
			daoManager.commitTransaction();
       }catch (ExceptionNegocioBSC e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }
  }

   
   public void alterar(ObjetivoTO objetivoTO) throws ExceptionNegocioBSC{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	    ObjetivoDAO objetivoDAO = (ObjetivoDAO) daoManager.getDao(ObjetivoDAO.class);
     		daoManager.startTransaction();			
			objetivoDAO.alterar(objetivoTO);
			
			/*altera relacionamentos de perspectiva e tema*/
			RelacionamentosBO relacionamentosBO = new RelacionamentosBO();
			RelacionamentosTO relacionamentosTO = new RelacionamentosTO();
			relacionamentosTO.setPERSIDOBJ(objetivoTO.getId());
			relacionamentosTO.setPERSIDPERS(objetivoTO.getIdPerspectiva());
			
			relacionamentosBO.alterarPERS(relacionamentosTO);
			relacionamentosTO.setOBJIDOBJ(objetivoTO.getId());
			if (relacionamentosBO.consultarUmTHEME(relacionamentosTO).getOBJIDTHEME() == 0){
				relacionamentosTO.setOBJIDTHEME(objetivoTO.getIdTema());
				relacionamentosBO.incluirTHEME(relacionamentosTO);
			}else{
				relacionamentosTO.setOBJIDTHEME(objetivoTO.getIdTema());
				relacionamentosBO.alterarTHEME(relacionamentosTO);
			}
			
			daoManager.commitTransaction();
       }catch (ExceptionNegocioBSC e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }
   }
   
   public int consultarMax(ObjetivoTO objetivoTO) throws ExceptionNegocioBSC{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	    ObjetivoDAO objetivoDAO = (ObjetivoDAO) daoManager.getDao(ObjetivoDAO.class);
     		daoManager.startTransaction();			
			return objetivoDAO.consultarMax(objetivoTO);
       }catch (ExceptionNegocioBSC e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }
   }
   
   public Collection consultarVarios(ObjetivoTO objetivoTO) throws ExceptionNegocioBSC{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	    ObjetivoDAO objetivoDAO = (ObjetivoDAO) daoManager.getDao(ObjetivoDAO.class);
     		daoManager.startTransaction();			
			return objetivoDAO.consultarVarios(objetivoTO);
       }catch (ExceptionNegocioBSC e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }
   }
   
   public ObjetivoTO consultarUm(ObjetivoTO objetivoTO) throws ExceptionNegocioBSC{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	    ObjetivoDAO objetivoDAO = (ObjetivoDAO) daoManager.getDao(ObjetivoDAO.class);
     		daoManager.startTransaction();
     		ObjetivoTO retorno = new ObjetivoTO();
     		retorno = objetivoDAO.consultarUm(objetivoTO);
     		
     		/*Consultar nas entidades de relacionamento o idPErspectiva e idTema*/
     		RelacionamentosBO relacionamentosBO = new RelacionamentosBO();
     		RelacionamentosTO relacionamentosTO = new RelacionamentosTO();
     		relacionamentosTO.setPERSIDOBJ(objetivoTO.getId());
     		retorno.setIdPerspectiva(relacionamentosBO.consultarUmPERS(relacionamentosTO).getPERSIDPERS());
     		
     		/*Realiza a inclusao na entidade de relacionamento de objetivo para Tema*/
     		relacionamentosTO.setOBJIDOBJ(objetivoTO.getId());
     		retorno.setIdTema(relacionamentosBO.consultarUmTHEME(relacionamentosTO).getOBJIDTHEME());
     		
			return retorno;
       }catch (ExceptionNegocioBSC e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }
   }

   /*Consulta que retorna os objetivos de um mapa para completar a lista utilizada
    * na tela de Causa e Efeito*/
   @SuppressWarnings("unchecked")
public Collection consultarObjetivoMapa(ObjetivoTO objetivoTO) throws ExceptionNegocioBSC{	   
	   DaoManager daoManager = FabricaDAO.getDaoManager();
	   Collection listaObjetivos = new ArrayList();
       try{        	
    	    ObjetivoDAO objetivoDAO = (ObjetivoDAO) daoManager.getDao(ObjetivoDAO.class);
     		daoManager.startTransaction();
			listaObjetivos.addAll(objetivoDAO.consultarObjetivoMapa(objetivoTO));			
       }catch (ExceptionNegocioBSC e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }    
       return listaObjetivos;
   }
   @SuppressWarnings("unchecked")
   public Collection consultarObjetivosMapaGrafico(ObjetivoTO objetivoTO) throws ExceptionNegocioBSC{	   
	   DaoManager daoManager = FabricaDAO.getDaoManager();
	   Collection listaObjetivos = new ArrayList();
       try{        	
    	    ObjetivoDAO objetivoDAO = (ObjetivoDAO) daoManager.getDao(ObjetivoDAO.class);
     		daoManager.startTransaction();
			listaObjetivos.addAll(objetivoDAO.consultarObjetivosMapaGrafico(objetivoTO));			
       }catch (ExceptionNegocioBSC e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }    
       return listaObjetivos;
   }
   
   /**
    * Metodo que consulta o codigo do mapa pelo o Obejtivo
    * @param indicadorTO
    * @return
    * @throws ExceptionNegocioBSC 
    */
   public Integer consultarMapaPorObjetivo(ObjetivoTO objetivoTO) throws ExceptionNegocioBSC{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	   	ObjetivoDAO obejtivoDAO = (ObjetivoDAO) daoManager.getDao(ObjetivoDAO.class);
     		daoManager.startTransaction();
			return obejtivoDAO.consultarMapaPorObjetivo(objetivoTO);
       }catch (ExceptionNegocioBSC e) {
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }
   }
   
   public Collection consultarTarefaFerramentaConfiguracao(TarefaTO tarefaTO) throws ExceptionNegocioBSC, ExceptionNegocioPRO, ParseException{
 	   TarefaBO tarefaBO = new TarefaBO(); 
 	   return tarefaBO.consultarTarefaFerramentaConfiguracao(tarefaTO);
   }
   
}
