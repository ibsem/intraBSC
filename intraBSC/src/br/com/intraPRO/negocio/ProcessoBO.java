/*
 * Created on 14/02/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package br.com.intraPRO.negocio;


import java.io.File;
import java.text.ParseException;
import java.util.Collection;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.intraBSC.persistencia.FabricaDAO;
import br.com.intraPRO.excecoes.ExceptionNegocioPRO;
import br.com.intraPRO.modelo.ProcessoTO;
import br.com.intraPRO.modelo.TarefaTO;
import br.com.intraPRO.persistencia.ProcessoDAO;

import com.ibatis.dao.client.DaoManager;

/**
 * @author Tiago Trindade Stangarlin
 */
public class ProcessoBO {
        
    
	private static Log log = LogFactory.getLog(ProcessoBO.class);
    public ProcessoBO(){       
    }
    
    public Collection consultarVarios(ProcessoTO processoTO) throws ExceptionNegocioPRO{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		ProcessoDAO processoDAO = (ProcessoDAO) daoManager.getDao(ProcessoDAO.class);
      		daoManager.startTransaction();
      		Collection listaProcesso = processoDAO.consultarVarios(processoTO);
      		return listaProcesso;
        }catch (ExceptionNegocioPRO e) {
            throw new ExceptionNegocioPRO(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    
    public ProcessoTO consultarUm(ProcessoTO processoTO) throws ExceptionNegocioPRO{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		ProcessoDAO processoDAO = (ProcessoDAO) daoManager.getDao(ProcessoDAO.class);
      		daoManager.startTransaction();
      		ProcessoTO resultadoTO = processoDAO.consultarUm(processoTO);
      		return resultadoTO;
        }catch (ExceptionNegocioPRO e) {
        	log.error(e.getMessage());
            throw new ExceptionNegocioPRO(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }
    }
    
    public ProcessoTO contarFases(ProcessoTO processoTO) throws ExceptionNegocioPRO{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		ProcessoDAO processoDAO = (ProcessoDAO) daoManager.getDao(ProcessoDAO.class);
      		daoManager.startTransaction();
      		ProcessoTO resultadoTO = processoDAO.contarFases(processoTO);
      		return resultadoTO;
        }catch (ExceptionNegocioPRO e) {
        	log.error(e.getMessage());
            throw new ExceptionNegocioPRO(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }
    } 
    public Collection contarAtividades(ProcessoTO processoTO) throws ExceptionNegocioPRO{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		ProcessoDAO processoDAO = (ProcessoDAO) daoManager.getDao(ProcessoDAO.class);
      		daoManager.startTransaction();
      		Collection resultadoTO = processoDAO.contarAtividades(processoTO);
      		return resultadoTO;
        }catch (ExceptionNegocioPRO e) {
        	log.error(e.getMessage());
            throw new ExceptionNegocioPRO(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }
    }  
    
    
    public Collection consultarProcessoUsuario(ProcessoTO processoTO) throws ExceptionNegocioPRO{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		ProcessoDAO processoDAO = (ProcessoDAO) daoManager.getDao(ProcessoDAO.class);
      		daoManager.startTransaction();
      		Collection listaProcesso = processoDAO.consultarProcessoUsuario(processoTO);
      		return listaProcesso;
        }catch (ExceptionNegocioPRO e) {
        	log.error(e.getMessage());
            throw new ExceptionNegocioPRO(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }
    }
    
    
    /*Tiago Trindade Stangarlin
     * Metodo para ativar o relatorio chamado ProcessoPrincipal.jasper*/
    public JasperPrint processoRelatorioDetalha(ProcessoTO processoTO) throws ExceptionNegocioPRO{
    	try {
			//Carrega o Relatório
	        File reportFile = new File(processoTO.getTransicaoRel());
	        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile.getPath());	        
	        		
	        processoTO.setJasperReport(jasperReport);
	        
	        DaoManager daoManager = FabricaDAO.getDaoManager();
	        ProcessoDAO relatorioDAO = (ProcessoDAO) daoManager.getDao(ProcessoDAO.class);			
			return relatorioDAO.processoRelatorioDetalha(processoTO);
		} catch (JRException e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		}
    }
    
    public void incluir(ProcessoTO processoTO) throws ExceptionNegocioPRO{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		ProcessoDAO processoDAO = (ProcessoDAO) daoManager.getDao(ProcessoDAO.class);
      		daoManager.startTransaction();
      		processoTO.setId(consultarMax(processoTO));
      		processoDAO.incluir(processoTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioPRO e) {
            throw new ExceptionNegocioPRO(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    
    public void alterar(ProcessoTO processoTO) throws ExceptionNegocioPRO{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		ProcessoDAO processoDAO = (ProcessoDAO) daoManager.getDao(ProcessoDAO.class);
      		daoManager.startTransaction();
      		processoDAO.alterar(processoTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioPRO e) {
            throw new ExceptionNegocioPRO(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    
    public int consultarMax(ProcessoTO processoTO) throws ExceptionNegocioPRO{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		ProcessoDAO processoDAO = (ProcessoDAO) daoManager.getDao(ProcessoDAO.class);
      		daoManager.startTransaction();
      		return processoDAO.consultarMax(processoTO);
        }catch (ExceptionNegocioPRO e) {
            throw new ExceptionNegocioPRO(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    
    /*Metodo que consulta toda a arvore da ferramenta de configuracao*/
    public Collection consultarArvoreConfiguracao(ProcessoTO processoTO) throws ExceptionNegocioPRO{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		ProcessoDAO processoDAO = (ProcessoDAO) daoManager.getDao(ProcessoDAO.class);
      		daoManager.startTransaction();
      		return processoDAO.consultarArvoreConfiguracao(processoTO);
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
