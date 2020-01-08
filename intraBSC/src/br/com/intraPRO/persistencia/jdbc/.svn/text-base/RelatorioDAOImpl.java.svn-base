package br.com.intraPRO.persistencia.jdbc;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.intraBSC.persistencia.BscDaoJDBCGenerico;
import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.RelatorioTO;
import br.com.intraPRO.persistencia.RelatorioDAO;

import com.ibatis.dao.client.DaoManager;

public class RelatorioDAOImpl  extends BscDaoJDBCGenerico implements RelatorioDAO {

	
	public RelatorioDAOImpl(DaoManager daoManager) {
		super(daoManager);		
	}
	
	private static Log log = LogFactory.getLog(RelatorioDAOImpl.class);

	
	@SuppressWarnings("unchecked")
	public JasperPrint listaTarefa(RelatorioTO relatorioTO) throws ExceptionPersistenciaPRO {
		try {
			Map parameters = new HashMap();
			//Parametros do relatorio
	        Locale locale = new Locale("pt" , "BR");
			parameters.put(JRParameter.REPORT_LOCALE, locale);
			parameters.put("chaveSolicitante", relatorioTO.getChaveSolicitante());
			parameters.put("chaveParticipante", relatorioTO.getChaveParticipante());
			parameters.put("nomeParticipante", relatorioTO.getNomeParticipante());
			parameters.put("nomeSolicitante", relatorioTO.getNomeSolicitante());
			parameters.put("BaseDir", relatorioTO.getBaseDir());
			JasperPrint relatorioFinal = JasperFillManager.fillReport(relatorioTO.getJasperReport(),parameters, getConexao());
			return relatorioFinal;
		} catch (JRException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
	}
	
	private Connection getConexao(){
		return getConnection();
	}

	
	@SuppressWarnings("unchecked")
	public JasperPrint listaTarefaExecutante(RelatorioTO relatorioTO) throws ExceptionPersistenciaPRO {
		try {
			Map parameters = new HashMap();
			//Parametros do relatorio
	        Locale locale = new Locale("pt" , "BR");
			parameters.put(JRParameter.REPORT_LOCALE, locale);
			parameters.put("chaveExecutante", relatorioTO.getChaveSolicitante());	
			parameters.put("nomeSolicitante", relatorioTO.getNomeSolicitante());
			parameters.put("BaseDir", relatorioTO.getBaseDir());
			
			JasperPrint relatorioFinal = JasperFillManager.fillReport(relatorioTO.getJasperReport(),parameters, getConexao());
			return relatorioFinal;
		} catch (JRException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public JasperPrint listaTarefaParticipante(RelatorioTO relatorioTO) throws ExceptionPersistenciaPRO {
		try {
			Map parameters = new HashMap();
			//Parametros do relatorio
	        Locale locale = new Locale("pt" , "BR");
			parameters.put(JRParameter.REPORT_LOCALE, locale);			
			parameters.put("chaveParticipante", relatorioTO.getChaveParticipante());
			parameters.put("nomeParticipante", relatorioTO.getNomeParticipante());
			parameters.put("BaseDir", relatorioTO.getBaseDir());
			JasperPrint relatorioFinal = JasperFillManager.fillReport(relatorioTO.getJasperReport(),parameters, getConexao());
			return relatorioFinal;
		} catch (JRException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
	}

//	 Implementação de Relatório com Jasper Repots Responsável: Ibsem Agrello Dias 06/06/2006
	
	@SuppressWarnings("unchecked")
	public JasperPrint agendaTarefa(RelatorioTO relatorioTO) throws ExceptionPersistenciaPRO {
		try {
			Map parameters = new HashMap();
			//Parametros do relatorio
	        Locale locale = new Locale("pt" , "BR");
			parameters.put(JRParameter.REPORT_LOCALE, locale);
			if (!relatorioTO.getChaveSolicitante().equals("")){
				parameters.put("chaveSolicitante", relatorioTO.getChaveSolicitante());
				parameters.put("nomeSolicitante", relatorioTO.getNomeSolicitante());
			}
			if (!relatorioTO.getChaveParticipante().equals("")){
				parameters.put("chaveParticipante", relatorioTO.getChaveParticipante());
				parameters.put("nomeParticipante", relatorioTO.getNomeParticipante());
			}
			parameters.put("BaseDir", relatorioTO.getBaseDir());
			JasperPrint relatorioFinal = JasperFillManager.fillReport(relatorioTO.getJasperReport(),parameters, getConexao());
			return relatorioFinal;
		} catch (JRException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public JasperPrint ganttTarefa(RelatorioTO relatorioTO) throws ExceptionPersistenciaPRO {
		try {
			Map parameters = new HashMap();
			
	        Locale locale = new Locale("pt" , "BR");
			parameters.put(JRParameter.REPORT_LOCALE, locale);
			parameters.put("dataPrazo",relatorioTO.getDataPrazo());			
			parameters.put("chaveSolicitante", relatorioTO.getChaveSolicitante());
			parameters.put("nomeSolicitante", relatorioTO.getNomeSolicitante());				
			
			parameters.put("chaveParticipante", relatorioTO.getChaveParticipante());
			parameters.put("nomeParticipante", relatorioTO.getNomeParticipante());
				
			parameters.put("BaseDir", relatorioTO.getBaseDir());
			JasperPrint relatorioFinal = JasperFillManager.fillReport(relatorioTO.getJasperReport(),parameters, getConexao());
			return relatorioFinal;
		} catch (JRException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
	}
}
