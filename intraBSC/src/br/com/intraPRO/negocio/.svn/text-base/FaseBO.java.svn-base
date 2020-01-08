

package br.com.intraPRO.negocio;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.intraBSC.persistencia.FabricaDAO;
import br.com.intraPRO.excecoes.ExceptionNegocioPRO;
import br.com.intraPRO.modelo.FaseTO;
import br.com.intraPRO.modelo.RelacionamentosTO;
import br.com.intraPRO.modelo.TarefaTO;
import br.com.intraPRO.persistencia.FaseDAO;

import com.ibatis.dao.client.DaoManager;


public class FaseBO{
   
   public FaseBO(){    
   }
   private static Log log = LogFactory.getLog(FaseBO.class);
   
   public Collection consultarVarios(FaseTO faseTO) throws ExceptionNegocioPRO{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	    FaseDAO faseDAO = (FaseDAO) daoManager.getDao(FaseDAO.class);
     		daoManager.startTransaction();
     		Collection listaFase = faseDAO.consultarVarios(faseTO);
     		return listaFase;
       }catch (ExceptionNegocioPRO e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioPRO(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }       
   }
   
   public FaseTO consultarUm(FaseTO faseTO) throws ExceptionNegocioPRO{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	    FaseDAO faseDAO = (FaseDAO) daoManager.getDao(FaseDAO.class);
     		daoManager.startTransaction();
     		return faseDAO.consultarUm(faseTO);     		
       }catch (ExceptionNegocioPRO e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioPRO(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }       
   }
   
   /*Esta pesquisa recebe uma colecao de mapas para trazer as fases*/
   @SuppressWarnings("unchecked")
public Collection consultarFaseProcesso(FaseTO faseTO, Integer codProcesso) throws ExceptionNegocioPRO{	   
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	    FaseDAO faseDAO = (FaseDAO) daoManager.getDao(FaseDAO.class);
     		daoManager.startTransaction();
     		Collection listaFase = new ArrayList();
     		faseTO.setIdProcesso(codProcesso.intValue());
			listaFase.addAll(faseDAO.consultarVarios(faseTO));
			
     		return listaFase;
       }catch (ExceptionNegocioPRO e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioPRO(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }       
   }
   @SuppressWarnings("unchecked")
   public Collection consultarFaseProcessoGrafico(FaseTO faseTO, Integer codProcesso) throws ExceptionNegocioPRO{	   
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	    FaseDAO faseDAO = (FaseDAO) daoManager.getDao(FaseDAO.class);
     		daoManager.startTransaction();
     		Collection listaFase = new ArrayList();
     		faseTO.setIdProcesso(codProcesso.intValue());
			listaFase.addAll(faseDAO.consultarVariosProcesso(faseTO));
			
     		return listaFase;
       }catch (ExceptionNegocioPRO e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioPRO(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }       
   }
 
   
   /*Tiago Trindade Stangarlin
    * Metodo para ativar o relatorio chamado ProcessoPrincipal.jasper*/
   public JasperPrint faseRelatorioDetalha(FaseTO faseTO) throws ExceptionNegocioPRO{
   	try {
			//Carrega o Relatório
	        File reportFile = new File(faseTO.getTransicaoRel());
	        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile.getPath());	        
	        		
	        faseTO.setJasperReport(jasperReport);
	        
	        DaoManager daoManager = FabricaDAO.getDaoManager();
	        FaseDAO relatorioDAO = (FaseDAO) daoManager.getDao(FaseDAO.class);			
			return relatorioDAO.faseRelatorioDetalha(faseTO);
		} catch (JRException e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		}
   }
   
   public void alterar(FaseTO faseTO) throws ExceptionNegocioPRO{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	    FaseDAO faseDAO = (FaseDAO) daoManager.getDao(FaseDAO.class);
     		
     		/*Verifica se foi alterado o campo ordem e valida campo. Campo é unico.*/
    	    FaseTO consultaOrdem = new FaseTO();
    	    consultaOrdem.setIdProcesso(faseTO.getIdProcesso());
     		if (verificaOrdemValida(consultarVarios(consultaOrdem),faseTO)){
     			daoManager.startTransaction();
     			faseDAO.alterar(faseTO);
         		daoManager.commitTransaction();
     		}else{
     			throw new ExceptionNegocioPRO("Ordem já existe.");
     		}
       }catch (ExceptionNegocioPRO e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioPRO(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }       
   }

   private boolean verificaOrdem(FaseTO faseTO) throws ExceptionNegocioPRO{
	   	RelacionamentosBO relacionamentosBO = new RelacionamentosBO();
		RelacionamentosTO relacionamentosTO = new RelacionamentosTO();
		relacionamentosTO.setPROIDPRO(faseTO.getIdProcesso());
		Collection listaRel = relacionamentosBO.consultarVariosPRO(relacionamentosTO);
		if (listaRel.isEmpty()){
			return true;
		}
		Iterator  i = listaRel.iterator();
		while (i.hasNext()) {
			RelacionamentosTO element = (RelacionamentosTO) i.next();
			FaseTO persRetornoTO = new FaseTO();
			persRetornoTO.setId(element.getPROIDFAS());
			if (consultarUm(persRetornoTO).getOrdem() == faseTO.getOrdem()){			
				throw new ExceptionNegocioPRO("Numero de Ordem ja existe para este Processo.");
			}
		}
		return true;
   }
   
   public void incluir(FaseTO faseTO) throws ExceptionNegocioPRO{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	    FaseDAO faseDAO = (FaseDAO) daoManager.getDao(FaseDAO.class);
    	    if (verificaOrdem(faseTO)){
    	    	daoManager.startTransaction();
         		faseTO.setId(consultarMax(faseTO));
         		faseDAO.incluir(faseTO);
         		
         		/*Realiza a inclusao na entidade de relacionamento*/
         		RelacionamentosBO relacionamentosBO = new RelacionamentosBO();
         		RelacionamentosTO relacionamentosTO = new RelacionamentosTO();
         		relacionamentosTO.setPROIDPRO(faseTO.getIdProcesso());
         		relacionamentosTO.setPROIDFAS(faseTO.getId());
         		relacionamentosBO.incluirPRO(relacionamentosTO);
         		daoManager.commitTransaction();
    	    }     		
       }catch (ExceptionNegocioPRO e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioPRO(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }       
   }
   
   public int consultarMax(FaseTO faseTO) throws ExceptionNegocioPRO{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	    FaseDAO faseDAO = (FaseDAO) daoManager.getDao(FaseDAO.class);
     		daoManager.startTransaction();
     		return faseDAO.consultarMax(faseTO);         	
       }catch (ExceptionNegocioPRO e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioPRO(e.getMessage());
       }finally{
       	daoManager.endTransaction();
       }       
   }
   
   private boolean verificaOrdemValida(Collection lista,FaseTO faseTO) throws ExceptionNegocioPRO{
	   Iterator iter = lista.iterator();
	   boolean retorno = true;
	   while (iter.hasNext()) {
		   FaseTO element = (FaseTO) iter.next();
		   if (element.getId() != faseTO.getId()){
			   if ((element.getOrdem() == faseTO.getOrdem())){
				   return false;
			   }else{
				   retorno = true;
			   }
		   }
	   }
	   return retorno;
   }
   
   /**
    * Metodo que consulta o codigo do mapa pelo o Fase
    * @param indicadorTO
    * @return
    * @throws ExceptionNegocioPRO 
    */
   public Integer consultarProcessoPorFase(FaseTO faseTO) throws ExceptionNegocioPRO{
	   DaoManager daoManager = FabricaDAO.getDaoManager();
       try{        	
    	   FaseDAO faseDAO = (FaseDAO) daoManager.getDao(FaseDAO.class);
     		daoManager.startTransaction();
			return faseDAO.consultarProcessoPorFase(faseTO);
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
