

package br.com.intraBSC.negocio;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ibatis.dao.client.DaoManager;

import br.com.intraBSC.excecoes.ExceptionNegocioBSC;
import br.com.intraBSC.modelo.MapaEstrategicoTO;
import br.com.intraBSC.modelo.TemaTO;
import br.com.intraBSC.persistencia.FabricaDAO;
import br.com.intraBSC.persistencia.TemaDAO;



public class TemaBO{
	private static Log log = LogFactory.getLog(TemaBO.class);
   public TemaBO(){    
   }

   @SuppressWarnings("unchecked")
public Collection consultarVariosTema(TemaTO temaTO, Collection listaMapa) throws ExceptionNegocioBSC{	   	  
	   DaoManager daoManager = FabricaDAO.getDaoManager();
	   Collection lista = new ArrayList();
       try{        	
    	    TemaDAO temaDAO = (TemaDAO) daoManager.getDao(TemaDAO.class);
     		daoManager.startTransaction();     		     	
     		Iterator iter = listaMapa.iterator();
     		while (iter.hasNext()) {
				MapaEstrategicoTO element = (MapaEstrategicoTO) iter.next();
				temaTO.setIdMapa(element.getId());
				lista.addAll(temaDAO.consultarVariosMapa(temaTO));
			}     		
     		
       }catch (ExceptionNegocioBSC e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }    
       return lista;
   }
   
   public TemaTO consultarUm(TemaTO temaTO) throws ExceptionNegocioBSC{	   	  
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	    TemaDAO temaDAO = (TemaDAO) daoManager.getDao(TemaDAO.class);
     		daoManager.startTransaction();     		     	
     		return temaDAO.consultarUm(temaTO);	
       }catch (ExceptionNegocioBSC e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }
   }
   
   public Collection consultarVarios(TemaTO temaTO) throws ExceptionNegocioBSC{	   	  
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	    TemaDAO temaDAO = (TemaDAO) daoManager.getDao(TemaDAO.class);
     		daoManager.startTransaction();     		     	
     		return temaDAO.consultarVarios(temaTO);	
       }catch (ExceptionNegocioBSC e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }
   }
   
   /**
    * Recupera todos os temas de um determinado mapa
    * 
    * @param temaTO tema com o id do mapa selecionado
    * 
    * @return Lista de temas
    * 
    * @throws ExceptionNegocioBSC
    */
   @SuppressWarnings("unchecked")
   public TemaTO consultarUmPorObjetivo(TemaTO temaTO) throws ExceptionNegocioBSC{	   	  
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	    TemaDAO temaDAO = (TemaDAO) daoManager.getDao(TemaDAO.class);
     		daoManager.startTransaction();     		     	
     		return temaDAO.consultarUmPorObjetivo(temaTO);	
       }catch (ExceptionNegocioBSC e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }
   }

   
   public void incluir(TemaTO temaTO) throws ExceptionNegocioBSC{	   	  
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	    TemaDAO temaDAO = (TemaDAO) daoManager.getDao(TemaDAO.class);
     		daoManager.startTransaction();
     		temaTO.setIdTema(consultarMax(temaTO));
     		temaDAO.incluir(temaTO);
     		daoManager.commitTransaction();
       }catch (ExceptionNegocioBSC e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }
   }
   
   public void alterar(TemaTO temaTO) throws ExceptionNegocioBSC{	   	  
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	    TemaDAO temaDAO = (TemaDAO) daoManager.getDao(TemaDAO.class);
     		daoManager.startTransaction();
     		temaDAO.alterar(temaTO);
     		daoManager.commitTransaction();
       }catch (ExceptionNegocioBSC e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }
   }
   
   public int consultarMax(TemaTO temaTO) throws ExceptionNegocioBSC{	   	  
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	    TemaDAO temaDAO = (TemaDAO) daoManager.getDao(TemaDAO.class);
     		daoManager.startTransaction();
     		return temaDAO.consultarMax(temaTO);
       }catch (ExceptionNegocioBSC e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }
   }
   
   public JasperPrint temaRelatorioDetalha(TemaTO temaTO) throws ExceptionNegocioBSC{
	   	try {
				//Carrega o Relat?rio
		        File reportFile = new File(temaTO.getCaminhoRel());
		        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile.getPath());	        
		        		
		        temaTO.setJasperReport(jasperReport);
		        
		        DaoManager daoManager = FabricaDAO.getDaoManager();
		        TemaDAO relatorioDAO = (TemaDAO) daoManager.getDao(TemaDAO.class);			
				return relatorioDAO.temaRelatorioDetalha(temaTO);
			} catch (JRException e) {
				log.error(e.getMessage());
				throw new ExceptionNegocioBSC(e.getMessage());
			}
	   }
}
