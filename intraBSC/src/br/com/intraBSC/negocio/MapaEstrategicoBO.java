/*
 * Created on 14/02/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package br.com.intraBSC.negocio;


import java.io.File;
import java.text.ParseException;
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
import br.com.intraBSC.modelo.MapaEstrategicoTO;
import br.com.intraBSC.modelo.ObjetivoTO;
import br.com.intraBSC.modelo.PerspectivaTO;
import br.com.intraBSC.persistencia.FabricaDAO;
import br.com.intraBSC.persistencia.MapaEstrategicoDAO;
import br.com.intraPRO.excecoes.ExceptionNegocioPRO;
import br.com.intraPRO.modelo.TarefaTO;
import br.com.intraPRO.negocio.TarefaBO;

/**
 * @author Tiago Trindade Stangarlin
 */
public class MapaEstrategicoBO {
        
    
	private static Log log = LogFactory.getLog(MapaEstrategicoBO.class);
    public MapaEstrategicoBO(){       
    }
    
    public Collection consultarVarios(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		MapaEstrategicoDAO mapaEstrategicoDAO = (MapaEstrategicoDAO) daoManager.getDao(MapaEstrategicoDAO.class);
      		daoManager.startTransaction();
      		Collection listaMapaEstrategico = mapaEstrategicoDAO.consultarVarios(mapaEstrategicoTO);
      		return listaMapaEstrategico;
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    
    public MapaEstrategicoTO consultarUm(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		MapaEstrategicoDAO mapaEstrategicoDAO = (MapaEstrategicoDAO) daoManager.getDao(MapaEstrategicoDAO.class);
      		daoManager.startTransaction();
      		MapaEstrategicoTO resultadoTO = mapaEstrategicoDAO.consultarUm(mapaEstrategicoTO);
      		return resultadoTO;
        }catch (ExceptionNegocioBSC e) {
        	log.error(e.getMessage());
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }
    }
    
    public MapaEstrategicoTO consultarIdMapa(PerspectivaTO perspectivaTO, ObjetivoTO objetivoTO, IndicadorTO indicadorTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		MapaEstrategicoDAO mapaEstrategicoDAO = (MapaEstrategicoDAO) daoManager.getDao(MapaEstrategicoDAO.class);
      		daoManager.startTransaction();
      		MapaEstrategicoTO resultadoTO = mapaEstrategicoDAO.consultarIdMapa(perspectivaTO,objetivoTO, indicadorTO);
      		return resultadoTO;
        }catch (ExceptionNegocioBSC e) {
        	log.error(e.getMessage());
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }
    }
    
    
    public MapaEstrategicoTO contarPerspectivas(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		MapaEstrategicoDAO mapaEstrategicoDAO = (MapaEstrategicoDAO) daoManager.getDao(MapaEstrategicoDAO.class);
      		daoManager.startTransaction();
      		MapaEstrategicoTO resultadoTO = mapaEstrategicoDAO.contarPerspectivas(mapaEstrategicoTO);
      		return resultadoTO;
        }catch (ExceptionNegocioBSC e) {
        	log.error(e.getMessage());
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }
    } 
    public Collection contarObjetivos(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		MapaEstrategicoDAO mapaEstrategicoDAO = (MapaEstrategicoDAO) daoManager.getDao(MapaEstrategicoDAO.class);
      		daoManager.startTransaction();
      		Collection resultadoTO = mapaEstrategicoDAO.contarObjetivos(mapaEstrategicoTO);
      		return resultadoTO;
        }catch (ExceptionNegocioBSC e) {
        	log.error(e.getMessage());
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }
    }  
    
    
    public Collection consultarMapaUsuario(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		MapaEstrategicoDAO mapaEstrategicoDAO = (MapaEstrategicoDAO) daoManager.getDao(MapaEstrategicoDAO.class);
      		daoManager.startTransaction();
      		Collection listaMapaEstrategico = mapaEstrategicoDAO.consultarMapaUsuario(mapaEstrategicoTO);
      		return listaMapaEstrategico;
        }catch (ExceptionNegocioBSC e) {
        	log.error(e.getMessage());
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }
    }
    
    
    /*Tiago Trindade Stangarlin
     * Metodo para ativar o relatorio chamado MapaEstrategicoPrincipal.jasper*/
    public JasperPrint mapaEstrategicoRelatorioDetalha(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionNegocioBSC{
    	try {
			//Carrega o Relatório
	        File reportFile = new File(mapaEstrategicoTO.getCaminhoRel());
	        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile.getPath());	        
	        		
	        mapaEstrategicoTO.setJasperReport(jasperReport);
	        
	        DaoManager daoManager = FabricaDAO.getDaoManager();
	        MapaEstrategicoDAO relatorioDAO = (MapaEstrategicoDAO) daoManager.getDao(MapaEstrategicoDAO.class);			
			return relatorioDAO.mapaEstrategicoRelatorioDetalha(mapaEstrategicoTO);
		} catch (JRException e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioBSC(e.getMessage());
		}
    }
    
    public void incluir(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		MapaEstrategicoDAO mapaEstrategicoDAO = (MapaEstrategicoDAO) daoManager.getDao(MapaEstrategicoDAO.class);
      		daoManager.startTransaction();
      		mapaEstrategicoTO.setId(consultarMax(mapaEstrategicoTO));
      		mapaEstrategicoDAO.incluir(mapaEstrategicoTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    
    public void incluirXml(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		MapaEstrategicoDAO mapaEstrategicoDAO = (MapaEstrategicoDAO) daoManager.getDao(MapaEstrategicoDAO.class);
      		daoManager.startTransaction();
      		mapaEstrategicoTO.setId(consultarMax(mapaEstrategicoTO));
      		mapaEstrategicoDAO.incluirXml(mapaEstrategicoTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    
    public void alterar(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		MapaEstrategicoDAO mapaEstrategicoDAO = (MapaEstrategicoDAO) daoManager.getDao(MapaEstrategicoDAO.class);
      		daoManager.startTransaction();
      		mapaEstrategicoDAO.alterar(mapaEstrategicoTO);
      		daoManager.commitTransaction();
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    
    public int consultarMax(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		MapaEstrategicoDAO mapaEstrategicoDAO = (MapaEstrategicoDAO) daoManager.getDao(MapaEstrategicoDAO.class);
      		daoManager.startTransaction();
      		return mapaEstrategicoDAO.consultarMax(mapaEstrategicoTO);
        }catch (ExceptionNegocioBSC e) {
            throw new ExceptionNegocioBSC(e.getMessage());
        }finally{
        	daoManager.endTransaction();
        }       
    }
    
    /*Metodo que consulta toda a arvore da ferramenta de configuracao*/
    public Collection consultarArvoreConfiguracao(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionNegocioBSC{
    	DaoManager daoManager = FabricaDAO.getDaoManager();
        try{        	
      		MapaEstrategicoDAO mapaEstrategicoDAO = (MapaEstrategicoDAO) daoManager.getDao(MapaEstrategicoDAO.class);
      		daoManager.startTransaction();
      		return mapaEstrategicoDAO.consultarArvoreConfiguracao(mapaEstrategicoTO);
      		      		
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
