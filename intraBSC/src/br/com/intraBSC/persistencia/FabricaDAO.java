package br.com.intraBSC.persistencia;

import java.io.IOException;
import java.io.Reader;

import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

import com.ibatis.common.resources.Resources;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.DaoManagerBuilder;

public class FabricaDAO implements PlugIn {
	private static Log log = LogFactory.getLog(FabricaDAO.class);
	private static DaoManager daoManager;
	private String daoConfig;

	/**
	 * @return Returns the daoConfig.
	 */
	public String getDaoConfig() {
		return daoConfig;
	}

	/**
	 * @param daoConfig
	 *            The daoConfig to set.
	 */
	public void setDaoConfig(String daoConfig) {
		this.daoConfig = daoConfig;
	}

	/**
	 * @return Returns the daoManager.
	 */
	public static DaoManager getDaoManager() {
		return daoManager;
	}

	/**
	 * @param daoManager
	 *            The daoManager to set.
	 */
	public static void setDaoManager(DaoManager umDaoManager) {
		daoManager = umDaoManager;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts.action.PlugIn#init(org.apache.struts.action.ActionServlet,
	 *      org.apache.struts.config.ModuleConfig)
	 */
	public void init(ActionServlet arg0, ModuleConfig arg1)
			throws ServletException {
		log.info("Iniciando FabricaDAO.");
		try {
			Reader reader = Resources.getResourceAsReader(daoConfig);
			daoManager = new ControleTransacao(DaoManagerBuilder.buildDaoManager(reader));
		} catch (IOException e) {
			log.fatal("Erro ao carregar arquivo de configuração: " + e.getMessage() );
			throw new ServletException(e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts.action.PlugIn#destroy()
	 */
	public void destroy() {
	}
	
}