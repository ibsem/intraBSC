

package br.com.intraBSC.negocio;

import java.io.File;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import com.ibatis.dao.client.DaoManager;

import br.com.intraBSC.excecoes.ExceptionNegocioBSC;
import br.com.intraBSC.modelo.IndicadorTO;
import br.com.intraBSC.persistencia.FabricaDAO;
import br.com.intraBSC.persistencia.IndicadorDAO;
import br.com.intraPRO.excecoes.ExceptionNegocioPRO;
import br.com.intraPRO.modelo.TarefaTO;
import br.com.intraPRO.negocio.TarefaBO;



/**
 * @author Tiago Trindade Stangarlin
 */
public class IndicadorBO{
	private static Log log = LogFactory.getLog(IndicadorBO.class);
   
   public IndicadorBO(){    
   }
   
   @SuppressWarnings("unchecked")
   public Collection consultarArvoreVisualizacao(IndicadorTO indicadorTO) throws ExceptionNegocioBSC{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
	   Collection listaIndicador = new ArrayList();
       try{        	
    	   	IndicadorDAO indicadorDAO = (IndicadorDAO) daoManager.getDao(IndicadorDAO.class);
     		daoManager.startTransaction();
			listaIndicador.addAll(indicadorDAO.consultarArvoreVisualizacao(indicadorTO));
       }catch (ExceptionNegocioBSC e) {
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }
       return listaIndicador;
   }
   
   @SuppressWarnings("unchecked")
   public Collection consultarIndicadorUsuario(IndicadorTO indicadorTO) throws ExceptionNegocioBSC{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
	   Collection listaIndicador = new ArrayList();
       try{        	
    	   	IndicadorDAO indicadorDAO = (IndicadorDAO) daoManager.getDao(IndicadorDAO.class);
     		daoManager.startTransaction();
			listaIndicador.addAll(indicadorDAO.consultarIndicadorUsuario(indicadorTO));
       }catch (ExceptionNegocioBSC e) {
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }
       return listaIndicador;
   }
   
   
   /**
    * Metodo que consulta o codigo do mapa pelo o indicador
    * @param indicadorTO
    * @return
	* @throws ExceptionNegocioBSC 
    */
   public Integer consultarMapaPorIndicador(IndicadorTO indicadorTO) throws ExceptionNegocioBSC{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	   	IndicadorDAO indicadorDAO = (IndicadorDAO) daoManager.getDao(IndicadorDAO.class);
     		daoManager.startTransaction();
			return indicadorDAO.consultarMapaPorIndicador(indicadorTO);
       }catch (ExceptionNegocioBSC e) {
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }
   }
   
   /*Tiago Trindade Stangarlin
    * Metodo para ativar o relatorio chamado MapaEstrategicoPrincipal.jasper*/
   public JasperPrint indicadorRelatorioDetalha(IndicadorTO indicadorTO) throws ExceptionNegocioBSC{
   		try {
			//Carrega o Relat?rio
	        File reportFile = new File(indicadorTO.getCaminhoRel());
	        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile.getPath());	        
	        		
	        indicadorTO.setJasperReport(jasperReport);
	        
	        DaoManager daoManager = FabricaDAO.getDaoManager();
	        IndicadorDAO relatorioDAO = (IndicadorDAO) daoManager.getDao(IndicadorDAO.class);			
			return relatorioDAO.indicadorRelatorioDetalha(indicadorTO);
		} catch (JRException e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioBSC(e.getMessage());
		}
   }
   
   /*Metodo utilizado para gerar relatorio de indicador sem valor de Fato*/
   public JasperPrint indicadorRelatorioDetalhaSemValor(IndicadorTO indicadorTO) throws ExceptionNegocioBSC{
  		try {
			//Carrega o Relatorio
	        File reportFile = new File(indicadorTO.getCaminhoRel());
	        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile.getPath());	        
	        		
	        indicadorTO.setJasperReport(jasperReport);
	        
	        DaoManager daoManager = FabricaDAO.getDaoManager();
	        IndicadorDAO relatorioDAO = (IndicadorDAO) daoManager.getDao(IndicadorDAO.class);			
			return relatorioDAO.indicadorRelatorioDetalhaSemValor(indicadorTO);
		} catch (JRException e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioBSC(e.getMessage());
		}
  }
   
   public JasperPrint meusIndicadoresRelatorioDetalha(IndicadorTO indicadorTO) throws ExceptionNegocioBSC{
  		try {
			//Carrega o Relat?rio
	        File reportFile = new File(indicadorTO.getCaminhoRel());
	        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile.getPath());	        
	        indicadorTO.setJasperReport(jasperReport);
	        DaoManager daoManager = FabricaDAO.getDaoManager();
	        IndicadorDAO relatorioDAO = (IndicadorDAO) daoManager.getDao(IndicadorDAO.class);			
			return relatorioDAO.meusIndicadoresRelatorioDetalha(indicadorTO);
		} catch (JRException e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioBSC(e.getMessage());
		}
  }
   
   
   
   public IndicadorTO consultarUm(IndicadorTO indicadorTO) throws ExceptionNegocioBSC{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
	   IndicadorTO retorno = new IndicadorTO();
       try{        	
    	   	IndicadorDAO indicadorDAO = (IndicadorDAO) daoManager.getDao(IndicadorDAO.class);
     		daoManager.startTransaction();
			retorno = indicadorDAO.consultarUm(indicadorTO);
       }catch (ExceptionNegocioBSC e) {
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }
       return retorno;
   }
   
   public void incluir(IndicadorTO indicadorTO) throws ExceptionNegocioBSC{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	   	IndicadorDAO indicadorDAO = (IndicadorDAO) daoManager.getDao(IndicadorDAO.class);
     		daoManager.startTransaction();
     		indicadorTO.setId(consultarMax(indicadorTO));
			indicadorDAO.incluir(indicadorTO);
			daoManager.commitTransaction();
       }catch (ExceptionNegocioBSC e) {
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }
   }
   
   /*Incluir na entidade de dimensao do indicador*/
   public void incluirDimensao(IndicadorTO indicadorTO) throws ExceptionNegocioBSC{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	   	IndicadorDAO indicadorDAO = (IndicadorDAO) daoManager.getDao(IndicadorDAO.class);
     		daoManager.startTransaction();
			indicadorDAO.incluirDimensao(indicadorTO);
			daoManager.commitTransaction();
       }catch (ExceptionNegocioBSC e) {
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }
   }
   
   public void alterar(IndicadorTO indicadorTO) throws ExceptionNegocioBSC{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	   	IndicadorDAO indicadorDAO = (IndicadorDAO) daoManager.getDao(IndicadorDAO.class);
     		daoManager.startTransaction();
			indicadorDAO.alterar(indicadorTO);
			daoManager.commitTransaction();
       }catch (ExceptionNegocioBSC e) {
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }
   }
   
   public int consultarMax(IndicadorTO indicadorTO) throws ExceptionNegocioBSC{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	   	IndicadorDAO indicadorDAO = (IndicadorDAO) daoManager.getDao(IndicadorDAO.class);
     		daoManager.startTransaction();
			return indicadorDAO.consultarMax(indicadorTO);
       }catch (ExceptionNegocioBSC e) {
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }
   }
   
   private Date consultarUltimaData(IndicadorTO indicadorTO) throws ExceptionNegocioBSC{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	   	IndicadorDAO indicadorDAO = (IndicadorDAO) daoManager.getDao(IndicadorDAO.class);
     		daoManager.startTransaction();
			return indicadorDAO.consultarUltimaData(indicadorTO);
       }catch (ExceptionNegocioBSC e) {
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }
   }
   
   
   public boolean verificaUltimaData(IndicadorTO indicadorTO) throws ExceptionNegocioBSC{	   
       try{        	
			Date data = consultarUltimaData(indicadorTO);
			if ((data != null)&&(data.before(indicadorTO.getUltimaData()))){
				return true;
			}else{
				return false;
			}
       }catch (ExceptionNegocioBSC e) {
           throw new ExceptionNegocioBSC(e.getMessage());
       }
   }
   
   
   
   public Collection consultarTarefaFerramentaConfiguracao(TarefaTO tarefaTO) throws ExceptionNegocioBSC, ExceptionNegocioPRO, ParseException{
	   TarefaBO tarefaBO = new TarefaBO(); 
	   return tarefaBO.consultarTarefaFerramentaConfiguracao(tarefaTO);
   }
}
