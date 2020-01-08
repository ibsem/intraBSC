package br.com.intraPRO.negocio;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ibatis.dao.client.DaoManager;

import br.com.intraBSC.persistencia.FabricaDAO;
import br.com.intraPRO.excecoes.ExceptionNegocioPRO;
import br.com.intraPRO.modelo.RelatorioTO;
import br.com.intraPRO.persistencia.RelatorioDAO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class RelatorioBO {
	
	private static Log log = LogFactory.getLog(TarefaBO.class);
	
	
	public JasperPrint listaTarefa(RelatorioTO relatorioTO) throws ExceptionNegocioPRO, JRException {
		try {
			//Carrega o Relatório
	        File reportFile = new File(relatorioTO.getTransicao());
	        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile.getPath());	        
	        		
	        relatorioTO.setJasperReport(jasperReport);
	        
	        DaoManager daoManager = FabricaDAO.getDaoManager();
			RelatorioDAO relatorioDAO = (RelatorioDAO) daoManager.getDao(RelatorioDAO.class);			
			return relatorioDAO.listaTarefa(relatorioTO);
		} catch (JRException e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		}
	}
	
	
	public JasperPrint listaTarefaExecutante(RelatorioTO relatorioTO) throws ExceptionNegocioPRO, JRException {
		try {
			//Carrega o Relatório
	        File reportFile = new File(relatorioTO.getTransicao());
	        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile.getPath());	        
	        relatorioTO.setJasperReport(jasperReport);
	        DaoManager daoManager = FabricaDAO.getDaoManager();
			RelatorioDAO relatorioDAO = (RelatorioDAO) daoManager.getDao(RelatorioDAO.class);			
			return relatorioDAO.listaTarefaExecutante(relatorioTO);
		} catch (JRException e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		}
	}
	
	
	public JasperPrint listaTarefaParticipante(RelatorioTO relatorioTO) throws ExceptionNegocioPRO, JRException {
		try {
			//Carrega o Relatório
	        File reportFile = new File(relatorioTO.getTransicao());
	        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile.getPath());	        
	        		
	        relatorioTO.setJasperReport(jasperReport);
	        
	        DaoManager daoManager = FabricaDAO.getDaoManager();
			RelatorioDAO relatorioDAO = (RelatorioDAO) daoManager.getDao(RelatorioDAO.class);			
			return relatorioDAO.listaTarefaParticipante(relatorioTO);
		} catch (JRException e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		}
	}
	
	
	public JasperPrint agendaTarefa(RelatorioTO relatorioTO) throws ExceptionNegocioPRO, JRException {
		try {
			//Carrega o Relatório
	        File reportFile = new File(relatorioTO.getTransicao());
	        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile.getPath());	        
	        		
	        relatorioTO.setJasperReport(jasperReport);
	        
	        DaoManager daoManager = FabricaDAO.getDaoManager();
			RelatorioDAO relatorioDAO = (RelatorioDAO) daoManager.getDao(RelatorioDAO.class);			
			return relatorioDAO.agendaTarefa(relatorioTO);
		} catch (JRException e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		}
	}
	

	public JasperPrint ganttTarefa(RelatorioTO relatorioTO) throws ExceptionNegocioPRO, JRException {
		try {
			//Carrega o Relatório
	        File reportFile = new File(relatorioTO.getTransicao());
	        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile.getPath());	        
	        		
	        relatorioTO.setJasperReport(jasperReport);
	        
	        DaoManager daoManager = FabricaDAO.getDaoManager();
			RelatorioDAO relatorioDAO = (RelatorioDAO) daoManager.getDao(RelatorioDAO.class);			
			return relatorioDAO.ganttTarefa(relatorioTO);
		} catch (JRException e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		}
	}
}
