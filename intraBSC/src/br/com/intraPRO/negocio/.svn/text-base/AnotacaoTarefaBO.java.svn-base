package br.com.intraPRO.negocio;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.intraBSC.modelo.UsuarioTO;
import br.com.intraBSC.negocio.UsuarioBO;
import br.com.intraBSC.persistencia.FabricaDAO;
import br.com.intraBSC.util.DataUtil;
import br.com.intraPRO.excecoes.ExceptionNegocioPRO;
import br.com.intraPRO.modelo.AnotacaoTarefaTO;
import br.com.intraPRO.modelo.TarefaTO;
import br.com.intraPRO.persistencia.AnotacaoTarefaDAO;

import com.ibatis.dao.client.DaoManager;


public class AnotacaoTarefaBO {
	
	private static Log log = LogFactory.getLog(AnotacaoTarefaDAO.class);
	public AnotacaoTarefaBO(){
		
	}
	
	public void incluir(AnotacaoTarefaTO anotacaoTarefaTO)  throws ExceptionNegocioPRO{
		DaoManager daoManager = FabricaDAO.getDaoManager();
		AnotacaoTarefaDAO anotacaoTarefaDAO = (AnotacaoTarefaDAO) daoManager.getDao(AnotacaoTarefaDAO.class);
	
   		try{
   			//pegando o retorno da consulta acrescida de um e setando na TO este resultado
   	   		daoManager.startTransaction();
   	   		anotacaoTarefaTO.setCodTipoAnotacao(1);
   	   		anotacaoTarefaDAO.incluir(anotacaoTarefaTO);
   	   		daoManager.commitTransaction();
   		}
   		catch(ExceptionNegocioPRO e){
			log.error(e.getMessage());
   			throw new ExceptionNegocioPRO(e.getMessage());
   		}
   		finally{
   			daoManager.endTransaction();   			
   		} 			
   	}
	 
	public void incluirJustificativa(AnotacaoTarefaTO anotacaoTarefaTO)  throws ExceptionNegocioPRO{
		DaoManager daoManager = FabricaDAO.getDaoManager();
		
		try{			
			AnotacaoTarefaDAO anotacaoTarefaDAO = (AnotacaoTarefaDAO) daoManager.getDao(AnotacaoTarefaDAO.class);
			DataUtil dataAtual = new DataUtil();
		
			//seta o tipo fixo da justificativa do histórico que é 2
			anotacaoTarefaTO.setCodTipoAnotacao(1);
			//seta o timestamp do anotacao para a data atual
			anotacaoTarefaTO.setTsAnotacao(dataAtual.getTimestamp());
		
   	   		daoManager.startTransaction();
	   		anotacaoTarefaDAO.incluir(anotacaoTarefaTO);	
   	   		daoManager.commitTransaction();
		}catch(ExceptionNegocioPRO e){
			log.error(e.getMessage());
   			throw new ExceptionNegocioPRO(e.getMessage());
   		}
   		finally{
   			daoManager.endTransaction();   			
   		}   			
   	}
	
	
	
	@SuppressWarnings("unchecked")
	public Collection consultarVarios(AnotacaoTarefaTO anotacaoTO)  throws ExceptionNegocioPRO{
		DaoManager daoManager = FabricaDAO.getDaoManager();
		AnotacaoTarefaDAO anotacaoTarefaDAO = (AnotacaoTarefaDAO) daoManager.getDao(AnotacaoTarefaDAO.class);
		Collection listaAnotacao = new ArrayList();
			try {
				daoManager.startTransaction();
				Iterator i = anotacaoTarefaDAO.consultarVarios(anotacaoTO).iterator();
				UsuarioTO usuarioTO = new UsuarioTO();
				while (i.hasNext()) {
					AnotacaoTarefaTO anotacaoTarefaTO = (AnotacaoTarefaTO) i.next();
					usuarioTO.setIdUsuario(anotacaoTarefaTO.getCodUsuario());
					anotacaoTarefaTO.setResponsavel(new UsuarioBO().consultarUm(usuarioTO));
					listaAnotacao.add(anotacaoTarefaTO);
				}
			} catch (Exception e) {
				log.error(e.getMessage());
	   			throw new ExceptionNegocioPRO(e.getMessage());
			}finally{
	   			daoManager.endTransaction();   			
	   		}
		return listaAnotacao;
	}
	
	public AnotacaoTarefaTO consultarUltAnotacao(AnotacaoTarefaTO anotacaoTarefaTO) throws ExceptionNegocioPRO{
		DaoManager daoManager = FabricaDAO.getDaoManager();
		try {
			AnotacaoTarefaDAO anotacaoTarefaDAO = (AnotacaoTarefaDAO) daoManager.getDao(AnotacaoTarefaDAO.class);
			daoManager.startTransaction();
			return anotacaoTarefaDAO.consultarUltAnotacao(anotacaoTarefaTO);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		}finally{
   			daoManager.endTransaction();   			
   		}		
	}
	
	public String verificarAlteracao(TarefaTO tarefaTOAntes, TarefaTO tarefaTODepois){
		String estadoAntes = "";
		String estadoDepois = "";
		String textoAlteracao = "Alterado: ";
		DataUtil dataUtil = new DataUtil();		
		if(tarefaTODepois != null){
			if ((tarefaTOAntes.getCodEstado()) != (tarefaTODepois.getCodEstado())) {//ESTADO DA TAREFA
				if (tarefaTOAntes.getCodEstado() == 1)
					estadoAntes = "Não Iniciada";
				else if (tarefaTOAntes.getCodEstado() == 2)
					estadoAntes = "Iniciada";
				else if (tarefaTOAntes.getCodEstado() == 3)
					estadoAntes = "A Validar";
				else if (tarefaTOAntes.getCodEstado() == 4)
					estadoAntes = "Cancelada";
				else if (tarefaTOAntes.getCodEstado() == 5)
					estadoAntes = "Validada";
					
				if (tarefaTODepois.getCodEstado() == 1)
					estadoDepois = "Não Iniciada";
				else if (tarefaTODepois.getCodEstado() == 2)
					estadoDepois = "Iniciada";
				else if (tarefaTODepois.getCodEstado() == 3)
					estadoDepois = "A Validar";
				else if (tarefaTODepois.getCodEstado() == 4)
					estadoDepois = "Cancelada";
				else if (tarefaTODepois.getCodEstado() == 5)
					estadoDepois = "Validada";
				
				textoAlteracao += " Estado da Tarefa de " + estadoAntes + " para " + estadoDepois + "; ";
			}
			
			if (!tarefaTOAntes.getNome().equals(tarefaTODepois.getNome())) {
				   textoAlteracao+=" Nome da Tarefa; ";
			   }
			   if (!tarefaTOAntes.getTextoSolicitacao().equals(tarefaTODepois.getTextoSolicitacao())) {//SOLICITAÇÃO - campo obrigatório
				   textoAlteracao+=" Solicitação da Tarefa; ";
			   }			   
			   if (tarefaTOAntes.getDtInicio()!= null) {
				   if (!tarefaTOAntes.getDtInicio().equals(tarefaTODepois.getDtInicio())) {
					   if(tarefaTODepois.getDtInicio()== null){
						   textoAlteracao+=" Data Início excluída; ";
					   }else{
						   textoAlteracao+=" Data Início de "+ dataUtil.getData(tarefaTOAntes.getDtInicio())+" para "+dataUtil.getData(tarefaTODepois.getDtInicio()) +"; ";
					   }
				   }
			   } else if(tarefaTODepois.getDtInicio()!= null){
				   textoAlteracao+=" Foi informada a data Início: "+dataUtil.getData(tarefaTODepois.getDtInicio())+"; ";
			   }
			   //FIM
			   if (tarefaTOAntes.getDtFim()!= null) {
				   if (!tarefaTOAntes.getDtFim().equals(tarefaTODepois.getDtFim())) {
					   if(tarefaTODepois.getDtFim()== null){
						   textoAlteracao+=" Data Fim excluída; ";
					   }else{
						   textoAlteracao+=" Data Fim de "+dataUtil.getData(tarefaTOAntes.getDtFim())+" para "+dataUtil.getData(tarefaTODepois.getDtFim()) +"; ";
					   }
				   }
			   } else if(tarefaTODepois.getDtFim()!= null)  {
				   textoAlteracao+=" Foi informada a data Fim: " + dataUtil.getData(tarefaTODepois.getDtFim()) +"; ";
			   }
			   //PREVISÃO INICIO
			  /* if (tarefaTOAntes.getDtPrevisaoInicio()!= null) {
				   if (!tarefaTOAntes.getDtPrevisaoInicio().equals(tarefaTODepois.getDtPrevisaoInicio())) {
					   if(tarefaTODepois.getDtPrevisaoInicio()== null){
						   textoAlteracao+=" Data Previsão excluída; ";
					   }else{
						   textoAlteracao+=" Data Previsão início de "+dataUtil.getData(tarefaTOAntes.getDtPrevisaoInicio())+" para "+dataUtil.getData(tarefaTODepois.getDtPrevisaoInicio()) +"; ";
					   }
				   }
			   } else if(tarefaTODepois.getDtPrevisaoInicio()!= null) {
				   textoAlteracao+=" Foi informada a data de Previsão Início: " + dataUtil.getData(tarefaTODepois.getDtPrevisaoInicio()) + "; ";
			   }*/
			   //PREVISÃO FIM
			   /*if (tarefaTOAntes.getDtPrevisaoFim()!= null) {
				   if (!tarefaTOAntes.getDtPrevisaoFim().equals(tarefaTODepois.getDtPrevisaoFim())) {
					   if(tarefaTODepois.getDtPrevisaoFim()== null){
						   textoAlteracao+=" Data Previsão excluída";
					   }else{
						   textoAlteracao+=" Data Previsão fim de "+dataUtil.getData(tarefaTOAntes.getDtPrevisaoFim())+" para "+dataUtil.getData(tarefaTODepois.getDtPrevisaoFim()) + "; ";   
					   }   
				   }
			   } else if(tarefaTODepois.getDtPrevisaoFim()!= null){
				   textoAlteracao+=" Foi informada a data de Previsão Fim: "+dataUtil.getData(tarefaTODepois.getDtPrevisaoFim()) + "; ";
			   }*/
			   //PRAZO -- para receber o prazo é utilizado o campo DtLimitePrazo - campo obrigatório
			   if (!tarefaTOAntes.getDtLimitePrazo().equals(tarefaTODepois.getDtLimitePrazo())) {
				   if(tarefaTODepois.getDtLimitePrazo()== null){
					   textoAlteracao+=" Data Prazo excluída; ";
				   }else{
					   textoAlteracao+=" Data Prazo "+dataUtil.getData(tarefaTOAntes.getDtLimitePrazo())+" para "+dataUtil.getData(tarefaTODepois.getDtLimitePrazo()) + "; ";
				   }
				   
			   }
			   //SOLICITANTE - campo obrigatorio
			   if (tarefaTOAntes.getCodUsuSolicitante() != tarefaTODepois.getCodUsuSolicitante()) {
				   textoAlteracao+=" Solicitante da Tarefa; ";
			   }
		}
		if (textoAlteracao.equals("Alterado: "))
			textoAlteracao = "";
		return textoAlteracao;
	}
}
