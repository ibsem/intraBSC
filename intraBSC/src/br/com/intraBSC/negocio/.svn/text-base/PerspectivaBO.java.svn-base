

package br.com.intraBSC.negocio;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import com.ibatis.dao.client.DaoManager;

import br.com.intraBSC.excecoes.ExceptionNegocioBSC;
import br.com.intraBSC.modelo.PerspectivaTO;
import br.com.intraBSC.modelo.RelacionamentosTO;
import br.com.intraBSC.persistencia.FabricaDAO;
import br.com.intraBSC.persistencia.PerspectivaDAO;
import br.com.intraPRO.excecoes.ExceptionNegocioPRO;
import br.com.intraPRO.modelo.TarefaTO;
import br.com.intraPRO.negocio.TarefaBO;


public class PerspectivaBO{
   
   public PerspectivaBO(){    
   }
   private static Log log = LogFactory.getLog(PerspectivaBO.class);
   
   public Collection consultarVarios(PerspectivaTO perspectivaTO) throws ExceptionNegocioBSC{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	    PerspectivaDAO perspectivaDAO = (PerspectivaDAO) daoManager.getDao(PerspectivaDAO.class);
     		daoManager.startTransaction();
     		Collection listaPerspectiva = perspectivaDAO.consultarVarios(perspectivaTO);
     		return listaPerspectiva;
       }catch (ExceptionNegocioBSC e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }       
   }
   
   public PerspectivaTO consultarUm(PerspectivaTO perspectivaTO) throws ExceptionNegocioBSC{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	    PerspectivaDAO perspectivaDAO = (PerspectivaDAO) daoManager.getDao(PerspectivaDAO.class);
     		daoManager.startTransaction();
     		return perspectivaDAO.consultarUm(perspectivaTO);     		
       }catch (ExceptionNegocioBSC e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }       
   }
   
   /*Esta pesquisa recebe uma colecao de mapas para trazer as perspectivas*/
   @SuppressWarnings("unchecked")
public Collection consultarPerspectivaMapa(PerspectivaTO perspectivaTO, Integer codMapa) throws ExceptionNegocioBSC{	   
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	    PerspectivaDAO perspectivaDAO = (PerspectivaDAO) daoManager.getDao(PerspectivaDAO.class);
     		daoManager.startTransaction();
     		Collection listaPerspectiva = new ArrayList();
     		perspectivaTO.setIdMapa(codMapa.intValue());
			listaPerspectiva.addAll(perspectivaDAO.consultarVarios(perspectivaTO));
			
     		return listaPerspectiva;
       }catch (ExceptionNegocioBSC e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }       
   }
   @SuppressWarnings("unchecked")
   public Collection consultarPerspectivaMapaGrafico(PerspectivaTO perspectivaTO, Integer codMapa) throws ExceptionNegocioBSC{	   
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	    PerspectivaDAO perspectivaDAO = (PerspectivaDAO) daoManager.getDao(PerspectivaDAO.class);
     		daoManager.startTransaction();
     		Collection listaPerspectiva = new ArrayList();
     		perspectivaTO.setIdMapa(codMapa.intValue());
			listaPerspectiva.addAll(perspectivaDAO.consultarVariosMapa(perspectivaTO));
			
     		return listaPerspectiva;
       }catch (ExceptionNegocioBSC e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }       
   }
 
   
   /*Tiago Trindade Stangarlin
    * Metodo para ativar o relatorio chamado MapaEstrategicoPrincipal.jasper*/
   public JasperPrint perspectivaRelatorioDetalha(PerspectivaTO perspectivaTO) throws ExceptionNegocioBSC{
   	try {
			//Carrega o Relatório
	        File reportFile = new File(perspectivaTO.getCaminhoRel());
	        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile.getPath());	        
	        		
	        perspectivaTO.setJasperReport(jasperReport);
	        
	        DaoManager daoManager = FabricaDAO.getDaoManager();
	        PerspectivaDAO relatorioDAO = (PerspectivaDAO) daoManager.getDao(PerspectivaDAO.class);			
			return relatorioDAO.perspectivaRelatorioDetalha(perspectivaTO);
		} catch (JRException e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioBSC(e.getMessage());
		}
   }
   
   public void alterar(PerspectivaTO perspectivaTO) throws ExceptionNegocioBSC{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	    PerspectivaDAO perspectivaDAO = (PerspectivaDAO) daoManager.getDao(PerspectivaDAO.class);
     		
     		/*Verifica se foi alterado o campo ordem e valida campo. Campo é unico.*/
    	    PerspectivaTO consultaOrdem = new PerspectivaTO();
    	    consultaOrdem.setIdMapa(perspectivaTO.getIdMapa());
     		if (verificaOrdemValida(consultarVarios(consultaOrdem),perspectivaTO)){
     			daoManager.startTransaction();
     			perspectivaDAO.alterar(perspectivaTO);
         		daoManager.commitTransaction();
     		}else{
     			throw new ExceptionNegocioBSC("Ordem já existe.");
     		}
       }catch (ExceptionNegocioBSC e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }       
   }

   private boolean verificaOrdem(PerspectivaTO perspectivaTO) throws ExceptionNegocioBSC{
	   	RelacionamentosBO relacionamentosBO = new RelacionamentosBO();
		RelacionamentosTO relacionamentosTO = new RelacionamentosTO();
		relacionamentosTO.setBSCIDBSC(perspectivaTO.getIdMapa());
		Collection listaRel = relacionamentosBO.consultarVariosBSC(relacionamentosTO);
		if (listaRel.isEmpty()){
			return true;
		}
		Iterator  i = listaRel.iterator();
		while (i.hasNext()) {
			RelacionamentosTO element = (RelacionamentosTO) i.next();
			PerspectivaTO persRetornoTO = new PerspectivaTO();
			persRetornoTO.setId(element.getBSCIDPERS());
			if (consultarUm(persRetornoTO).getOrdem() == perspectivaTO.getOrdem()){			
				throw new ExceptionNegocioBSC("Numero de Ordem ja existe para este Mapa.");
			}
		}
		return true;
   }
   
   public void incluir(PerspectivaTO perspectivaTO) throws ExceptionNegocioBSC{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	    PerspectivaDAO perspectivaDAO = (PerspectivaDAO) daoManager.getDao(PerspectivaDAO.class);
    	    if (verificaOrdem(perspectivaTO)){
    	    	daoManager.startTransaction();
         		perspectivaTO.setId(consultarMax(perspectivaTO));
         		perspectivaDAO.incluir(perspectivaTO);
         		
         		/*Realiza a inclusao na entidade de relacionamento*/
         		RelacionamentosBO relacionamentosBO = new RelacionamentosBO();
         		RelacionamentosTO relacionamentosTO = new RelacionamentosTO();
         		relacionamentosTO.setBSCIDBSC(perspectivaTO.getIdMapa());
         		relacionamentosTO.setBSCIDPERS(perspectivaTO.getId());
         		relacionamentosBO.incluirBSC(relacionamentosTO);
         		daoManager.commitTransaction();
    	    }     		
       }catch (ExceptionNegocioBSC e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }       
   }
   
   public int consultarMax(PerspectivaTO perspectivaTO) throws ExceptionNegocioBSC{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	    PerspectivaDAO perspectivaDAO = (PerspectivaDAO) daoManager.getDao(PerspectivaDAO.class);
     		daoManager.startTransaction();
     		return perspectivaDAO.consultarMax(perspectivaTO);         	
       }catch (ExceptionNegocioBSC e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }       
   }
   
   private boolean verificaOrdemValida(Collection lista,PerspectivaTO perspectivaTO) throws ExceptionNegocioBSC{
	   Iterator iter = lista.iterator();
	   boolean retorno = true;
	   while (iter.hasNext()) {
		   PerspectivaTO element = (PerspectivaTO) iter.next();
		   if (element.getId() != perspectivaTO.getId()){
			   if ((element.getOrdem() == perspectivaTO.getOrdem())){
				   return false;
			   }else{
				   retorno = true;
			   }
		   }
	   }
	   return retorno;
   }
   
   /**
    * Metodo que consulta o codigo do mapa pelo o Perspectiva
    * @param indicadorTO
    * @return
    * @throws ExceptionNegocioBSC 
    */
   public Integer consultarMapaPorPerspectiva(PerspectivaTO perspectivaTO) throws ExceptionNegocioBSC{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	   PerspectivaDAO perspectivaDAO = (PerspectivaDAO) daoManager.getDao(PerspectivaDAO.class);
     		daoManager.startTransaction();
			return perspectivaDAO.consultarMapaPorPerspectiva(perspectivaTO);
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
