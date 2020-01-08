package br.com.intraPRO.negocio;

import java.io.File;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
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

import br.com.intraBSC.excecoes.ExceptionNegocioBSC;
import br.com.intraBSC.modelo.IndicadorTO;
import br.com.intraBSC.modelo.MapaEstrategicoTO;
import br.com.intraBSC.modelo.ObjetivoTO;
import br.com.intraBSC.modelo.PerspectivaTO;
import br.com.intraBSC.modelo.UsuarioTO;
import br.com.intraBSC.negocio.IndicadorBO;
import br.com.intraBSC.negocio.MapaEstrategicoBO;
import br.com.intraBSC.negocio.ObjetivoBO;
import br.com.intraBSC.negocio.PerspectivaBO;
import br.com.intraBSC.negocio.UsuarioBO;
import br.com.intraBSC.persistencia.FabricaDAO;
import br.com.intraBSC.util.DataUtil;
import br.com.intraPRO.excecoes.ExceptionNegocioPRO;
import br.com.intraPRO.modelo.ConfigTarefaTO;
import br.com.intraPRO.modelo.ConteudoItemTarefaTO;
import br.com.intraPRO.modelo.ItemTO;
import br.com.intraPRO.modelo.ConteudoFormularioTarefaTO;
import br.com.intraPRO.modelo.FormularioTO;
import br.com.intraPRO.modelo.ParticipanteConfigTarefaTO;
import br.com.intraPRO.modelo.ParticipanteTO;
import br.com.intraPRO.modelo.TarefaTO;
import br.com.intraPRO.persistencia.TarefaDAO;
import br.com.intraPRO.util.Util;

import com.ibatis.dao.client.DaoManager;

public class TarefaBO {
	private static Log log = LogFactory.getLog(TarefaBO.class);

	public TarefaBO() {
	}

	public void incluir(TarefaTO tarefaTO) throws ExceptionNegocioPRO, Exception, ParseException, SQLException {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		TarefaDAO tarefaDAO = (TarefaDAO) daoManager.getDao(TarefaDAO.class);
		try {			
			Collection codDepeSolicitante = new ArrayList();
			UsuarioTO usuarioTO = new UsuarioTO();
			usuarioTO.setIdUsuario(tarefaTO.getCodUsuSolicitante());
			ItemTO itemTO = new ItemTO();
			FormularioTO formularioTO = new FormularioTO();
			Iterator i = codDepeSolicitante.iterator();
			while (i.hasNext()) {
				usuarioTO = (UsuarioTO) i.next();
			}
			daoManager.startTransaction();
			consultarMax(tarefaTO);
			
			DataUtil dataUtil = new DataUtil();
			Timestamp dataHora = dataUtil.getTimestamp();
	   		tarefaTO.setTsCriacao(dataHora);
	   		tarefaTO.setTsAlteracao(dataHora);
	   		
			tarefaDAO.incluir(tarefaTO);
			incluirParticipante(tarefaTO);
			incluirConteudoItemTarefa(itemTO, tarefaTO);
			incluirConteudoFormularioTarefa(formularioTO, tarefaTO);
			daoManager.commitTransaction();
		} catch (ExceptionNegocioPRO e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		} finally {
			daoManager.endTransaction();
		}
	}

	
	public void alterar(TarefaTO tarefaTO) throws ExceptionNegocioPRO, ParseException {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		TarefaDAO tarefaDAO = (TarefaDAO) daoManager.getDao(TarefaDAO.class);	
		try {
			daoManager.startTransaction();
	        tarefaTO.setTsAlteracao(new DataUtil().getTimestamp());
			tarefaDAO.alterar(tarefaTO);
			alterarDataAlteracao(tarefaTO);
			daoManager.commitTransaction();
		} catch (ExceptionNegocioPRO e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		} finally {
			daoManager.endTransaction();
		}
	}

	/**
	 * Metodo para validacao. Verifica se uma tarefa ja nao esta vinculada a um Mapa, Perspectiva, Objetivo ou Indicador
	 * @param _tarefaTO
	 * @throws ExceptionNegocioPRO
	 * @throws ParseException
	 */
	public void verificaTarefaEstaVinculada(TarefaTO _tarefaTO) throws ExceptionNegocioPRO, ParseException{
		TarefaTO tarefaTO = new TarefaTO();
		tarefaTO = consultarUm(_tarefaTO);
		if (_tarefaTO.getCodIndicador() != 0) {
			if ((tarefaTO.getCodMapa() != 0) || (tarefaTO.getCodPerspectiva() != 0) || (tarefaTO.getCodObjetivo() != 0)) {
				throw new ExceptionNegocioPRO("Tarefa já Vinculada.");
			}
		} else if (_tarefaTO.getCodObjetivo() != 0) {
			if ((tarefaTO.getCodMapa() != 0) || (tarefaTO.getCodPerspectiva() != 0) || (tarefaTO.getCodIndicador() != 0)) {
				throw new ExceptionNegocioPRO("Tarefa já Vinculada.");
			}
		} else if (_tarefaTO.getCodPerspectiva() != 0) {
			if ((tarefaTO.getCodMapa() != 0) || (tarefaTO.getCodIndicador() != 0) || (tarefaTO.getCodIndicador() != 0)) {
				throw new ExceptionNegocioPRO("Tarefa já Vinculada.");
			}
		} else if (_tarefaTO.getCodMapa() != 0){
			if ((tarefaTO.getCodObjetivo() != 0) || (tarefaTO.getCodPerspectiva() != 0) || (tarefaTO.getCodIndicador() != 0)) {
				throw new ExceptionNegocioPRO("Tarefa já Vinculada.");
			}
		}
	}
	
	public void calcularDataPrazo(TarefaTO tarefaTO) throws ExceptionNegocioPRO {
		ConfigTarefaTO configTarefaTO = new ConfigTarefaTO();
		ConfigTarefaBO configTarefaBO = new ConfigTarefaBO();
		DataUtil dataUtil = new DataUtil();
		configTarefaTO.setCodigoConfigTarefa(tarefaTO.getCodConfigTarefa());
		configTarefaTO = configTarefaBO.consultarUm(configTarefaTO);
		dataUtil.soma(configTarefaTO.getNumDiasPrevistos()).toString();			
		tarefaTO.setDtPrazo(dataUtil.getData());
		tarefaTO.setCodCriticidade(configTarefaTO.getCodCriticidadeIniTarefa());
		tarefaTO.setCodEstado(configTarefaTO.getCodEstadoIniTarefa());
		tarefaTO.setTextoSolicitacao(configTarefaTO.getTxtSolicitacaoIniTarefa());
		tarefaTO.setNome(configTarefaTO.getNomeIniTarefa());
	}

	
	public TarefaTO consultarUm(TarefaTO tarefaTO) throws ExceptionNegocioPRO, ParseException  {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		TarefaDAO tarefaDAO = (TarefaDAO) daoManager.getDao(TarefaDAO.class);
		try {
			daoManager.startTransaction();
			TarefaTO tarefaTOResult = tarefaDAO.consultarUm(tarefaTO);
			return tarefaTOResult;
		} catch (ExceptionNegocioPRO e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		}finally {
			daoManager.endTransaction();
		}
	}

	
	public JasperPrint imprimirAgenda(TarefaTO tarefaTO) throws ExceptionNegocioPRO, ParseException, JRException  {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		TarefaDAO tarefaDAO = (TarefaDAO) daoManager.getDao(TarefaDAO.class);
		try {
	        File reportFile = new File(tarefaTO.getTransicaoRel());
	        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile.getPath());
	        tarefaTO.setJasperReport(jasperReport);
			return tarefaDAO.imprimirAgenda(tarefaTO);
		} catch (ExceptionNegocioPRO e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		}
	}
	
	public JasperPrint imprimirTarefa(TarefaTO tarefaTO) throws ExceptionNegocioPRO, ParseException, JRException  {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		TarefaDAO tarefaDAO = (TarefaDAO) daoManager.getDao(TarefaDAO.class);
		try {
	        File reportFile = new File(tarefaTO.getTransicaoRel());
	        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile.getPath());
	        tarefaTO.setJasperReport(jasperReport);
			return tarefaDAO.imprimirTarefa(tarefaTO);
		} catch (ExceptionNegocioPRO e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		}
	}
	
	public JasperPrint relatorioGrupoTarefa(TarefaTO tarefaTO) throws ExceptionNegocioPRO, ParseException, JRException  {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		TarefaDAO tarefaDAO = (TarefaDAO) daoManager.getDao(TarefaDAO.class);
		try {
	        File reportFile = new File(tarefaTO.getTransicaoRel());
	        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile.getPath());
	        tarefaTO.setJasperReport(jasperReport);
			return tarefaDAO.relatorioGrupoTarefa(tarefaTO);
		} catch (ExceptionNegocioPRO e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		}
	}
	
	public JasperPrint relatorioGMesTarefas(TarefaTO tarefaTO) throws ExceptionNegocioPRO, ParseException, JRException  {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		TarefaDAO tarefaDAO = (TarefaDAO) daoManager.getDao(TarefaDAO.class);
		try {
	        File reportFile = new File(tarefaTO.getTransicaoRel());
	        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile.getPath());
	        tarefaTO.setJasperReport(jasperReport);
			return tarefaDAO.relatorioGMesTarefas(tarefaTO);
		} catch (ExceptionNegocioPRO e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		}
	}

	/*Valor da Sinalizacao * Vermelho 3 * Verde 1*/
	public TarefaTO verificaSinalizacao(TarefaTO tarefaTO) throws Exception {
		DataUtil dataUtil = new DataUtil();
		long sinalizacao = 0;
		if (dataUtil.getDataFormatoDB2(dataUtil.getDataAtual()).equals(dataUtil.getDataFormatoDB2(tarefaTO.getDtLimitePrazo()))) {
			tarefaTO.setSinalizacaoTarefa(1);
			return tarefaTO;
		}
		if (dataUtil.comparaDatas(tarefaTO.getDtLimitePrazo())) {
			tarefaTO.setSinalizacaoTarefa(3);
			return tarefaTO;
		}
		if (dataUtil.getDiferencaEmDias(tarefaTO.getTsCriacao(), tarefaTO.getDtLimitePrazo()) >= 0) {
			tarefaTO.setSinalizacaoTarefa(1);
			return tarefaTO;
		}
		//if (sinalizacao >= 0) {
		//	tarefaTO.setSinalizacaoTarefa(1);
		//} else {
		//	if (sinalizacao < 0)
		//		tarefaTO.setSinalizacaoTarefa(3);
		//	else 
		//		tarefaTO.setSinalizacaoTarefa(2);
	//	} 

		return tarefaTO;
	}

	
	@SuppressWarnings("unchecked")
	public Collection visualizar(TarefaTO tarefaTO, ParticipanteTO participanteTO) throws ExceptionNegocioPRO {
			DaoManager daoManager = FabricaDAO.getDaoManager();
		try {
			daoManager.startTransaction();
			TarefaDAO tarefaDAO = (TarefaDAO) daoManager.getDao(TarefaDAO.class);
			Collection listaTarefa = new ArrayList();
			Iterator i = tarefaDAO.visualizar(tarefaTO, participanteTO).iterator();
			while (i.hasNext()) {
				TarefaTO tarefaTOResult = (TarefaTO) i.next();
				tarefaTOResult.setTsAlteracaoS(new DataUtil().getTimestampFormatoSemHora(tarefaTOResult.getTsAlteracao()));
				tarefaTOResult.setTsCriacaoS(new DataUtil().getTimestampFormatoSemHora(tarefaTOResult.getTsCriacao()));
				tarefaTOResult.setDtPrazo(new DataUtil().getData(tarefaTOResult.getDtLimitePrazo()));
				listaTarefa.add(verificaSinalizacao(tarefaTOResult));
			}
			return listaTarefa;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		}finally {
			daoManager.endTransaction();
		}
	}

	public Collection consultarVarios(TarefaTO atividateTO) throws ExceptionNegocioPRO {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		TarefaDAO tarefaDAO = (TarefaDAO) daoManager.getDao(TarefaDAO.class);
		try {
			daoManager.startTransaction();
			return tarefaDAO.consultarVarios(atividateTO);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		}finally {
			daoManager.endTransaction();
		}
	}

	
	@SuppressWarnings("unchecked")
	public Collection consultarTarefa(TarefaTO tarefaTO) throws ExceptionNegocioPRO {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		TarefaDAO tarefaDAO = (TarefaDAO) daoManager.getDao(TarefaDAO.class);
		try {
			ParticipanteTO participanteTO = new ParticipanteTO();
			tarefaTO.setCodUsuCriador(UsuarioBO.getUsuarioTO().getIdUsuario());
			participanteTO.setCodUsuario(UsuarioBO.getUsuarioTO().getIdUsuario());
			participanteTO.setCodTipoParticipacao(1);
			Collection listaTarefa = tarefaDAO.consultarTarefa(tarefaTO, participanteTO);
			daoManager.startTransaction();
			Iterator iter = listaTarefa.iterator();
			Collection retorno = new ArrayList();
			ConfigTarefaBO configTarefaBO = new ConfigTarefaBO();
			int codigoAnt = 0;
			int anoAnt = 0;
			while (iter.hasNext()) {
				TarefaTO tarefaTOLista = (TarefaTO) iter.next();				
				ConfigTarefaTO configTarefaTO = new ConfigTarefaTO();				
				configTarefaTO.setCodigoConfigTarefa(tarefaTOLista.getCodConfigTarefa());
				tarefaTOLista.setNomeConfigTarefa(configTarefaBO.consultarUm(configTarefaTO).getTextoConfigTarefa());
				
				boolean participante = false;
				ParticipanteBO participanteBO = new ParticipanteBO();
				participanteTO.setAnoCriacao(tarefaTOLista.getAnoCriacao());
				participanteTO.setCodTarefa(tarefaTOLista.getCodigo());
				Collection listaParticipante = participanteBO.consultarVarios(participanteTO);
				Iterator i = listaParticipante.iterator();
				while (i.hasNext()) {
					ParticipanteTO participanteRetornoTO = (ParticipanteTO) i.next();
					if (participanteRetornoTO.getCodUsuario() == tarefaTO.getCodUsuario()){
						participante = true;
					}
				}
				
				if ((codigoAnt != tarefaTOLista.getCodigo()) || (anoAnt != tarefaTOLista.getAnoCriacao())){
										  /*Verifica se o participante é do mesmo grupo do usuario Logado*/	
					if ((participante) && (consultarTarefaPertenceGrupo(tarefaTO, listaParticipante))){
						retorno.add(tarefaTOLista);
					}
				}
				codigoAnt = tarefaTOLista.getCodigo();
				anoAnt = tarefaTOLista.getAnoCriacao();
				
			}
			return retorno;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		}finally {
			daoManager.endTransaction();
		}
	}
	
	@SuppressWarnings("unused")
	private boolean consultarTarefaPertenceGrupo(TarefaTO _tarefaTO, Collection listaParticipante) throws ExceptionNegocioBSC{
		UsuarioBO usuarioBO = new UsuarioBO();
	    UsuarioTO usuarioTOLogado = new UsuarioTO();
	    usuarioTOLogado.setGrupoTO(UsuarioBO.getUsuarioTO().getGrupoTO());
	    Iterator iter = listaParticipante.iterator();
	    while (iter.hasNext()) {
			ParticipanteTO element = (ParticipanteTO) iter.next();
			UsuarioTO usuarioTO = new UsuarioTO();
			usuarioTO.setIdUsuario(element.getCodUsuario());
			if (usuarioBO.consultarUm(usuarioTO).getGrupoTO().getCodigo() == usuarioTOLogado.getGrupoTO().getCodigo()) {
				return true;
			}
		}
		return false;
	}
	
	public int consultarMax(TarefaTO tarefaTO) throws ExceptionNegocioPRO {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		TarefaDAO tarefaDAO = (TarefaDAO) daoManager.getDao(TarefaDAO.class);
		try {
			daoManager.startTransaction();
			int resultNumOrdemIncrementado = tarefaDAO.consultarMax(tarefaTO);

			tarefaTO.setCodigo(resultNumOrdemIncrementado);
			return resultNumOrdemIncrementado;
		} catch (ExceptionNegocioPRO e) {
			throw new ExceptionNegocioPRO(e.getMessage());
		}finally {
			daoManager.endTransaction();
		}
	}


	/*Metodo utilizado na inclusao de uma tarefa, onde deve incluir o solicitante como executante e os cadastrados na tarefa de configuracao*/
	 private void incluirParticipante(TarefaTO tarefaTO) throws ExceptionNegocioPRO {
		
		ParticipanteBO participanteBO = new ParticipanteBO();
		try {			
			incluirSolicitanteParticipante(tarefaTO);
			ParticipanteConfigTarefaTO participanteConfigTarefaTO = new ParticipanteConfigTarefaTO();
			ParticipanteConfigTarefaBO participanteConfigTarefaBO = new ParticipanteConfigTarefaBO();
			participanteConfigTarefaTO.setCodConfigTarefa(tarefaTO.getCodConfigTarefa());
			Iterator iter = participanteConfigTarefaBO.consultarVarios(participanteConfigTarefaTO).iterator();
			while (iter.hasNext()) {
				ParticipanteConfigTarefaTO element = (ParticipanteConfigTarefaTO) iter.next();
				ParticipanteTO participanteTO = new ParticipanteTO();
				participanteTO.setAnoCriacao(tarefaTO.getAnoCriacao());			
				participanteTO.setCodTipoParticipacao(1);
				participanteTO.setCodTarefa(tarefaTO.getCodigo());
				participanteTO.setCodUsuario(element.getCodUsuario());
				participanteTO.setCodNivel(2);
				participanteBO.incluir(participanteTO);
			}
		} catch (ExceptionNegocioPRO e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		}
	}
	 /**
	  * Este metodo inclui o soicitante da tarefa como Participante.
	  * @param tarefaTO
	  * @throws ExceptionNegocioPRO
	  */
	 private void incluirSolicitanteParticipante(TarefaTO tarefaTO) throws ExceptionNegocioPRO {
		 ParticipanteBO participanteBO = new ParticipanteBO();
			try {	
				ParticipanteTO participanteTO = new ParticipanteTO();
				participanteTO.setAnoCriacao(tarefaTO.getAnoCriacao());			
				participanteTO.setCodTipoParticipacao(1);
				participanteTO.setCodTarefa(tarefaTO.getCodigo());
				participanteTO.setCodUsuario(tarefaTO.getCodUsuSolicitante());
				participanteTO.setCodNivel(2);
				participanteBO.incluir(participanteTO);
			} catch (ExceptionNegocioPRO e) {
				log.error(e.getMessage());
				throw new ExceptionNegocioPRO(e.getMessage());
			}
	 }

	 public void incluirConteudoFormularioTarefa(FormularioTO formularioTO, TarefaTO tarefaTO) throws ExceptionNegocioPRO {
			try {
				formularioTO.setCodConfigTarefa(tarefaTO.getCodConfigTarefa());
				formularioTO.setIndFormularioVigente("S");
				FormularioBO formularioBO = new FormularioBO();
				Collection resultado = formularioBO.consultarVarios(formularioTO);
				if (!resultado.isEmpty()) {
					ConteudoFormularioTarefaBO conteudoFormularioTarefaBO = new ConteudoFormularioTarefaBO();
					ConteudoFormularioTarefaTO conteudoFormularioTarefaTO = new ConteudoFormularioTarefaTO();			

					conteudoFormularioTarefaTO.setAnoCriacao(tarefaTO.getAnoCriacao());
					conteudoFormularioTarefaTO.setCodTarefa(tarefaTO.getCodigo());
					conteudoFormularioTarefaTO.setCodConfigTarefa(tarefaTO.getCodConfigTarefa());

					Iterator i = resultado.iterator();
					while (i.hasNext()) {
						FormularioTO resultTO = (FormularioTO) i.next();
						conteudoFormularioTarefaTO.setNumeroOrdem(resultTO.getNumeroOrdem());
						conteudoFormularioTarefaBO.incluir(conteudoFormularioTarefaTO);
					}
				}
			} catch (ExceptionNegocioPRO e) {
				log.error(e.getMessage());
				throw new ExceptionNegocioPRO(e.getMessage());
			}
		}
	 
	 
	public void incluirConteudoItemTarefa(ItemTO itemTO, TarefaTO tarefaTO) throws ExceptionNegocioPRO {
		try {
			itemTO.setCodConfigTarefa(tarefaTO.getCodConfigTarefa());
			itemTO.setIndItemVigente("S");
			ItemBO itemBO = new ItemBO();
			Collection resultado = itemBO.consultarVarios(itemTO);
			if (!resultado.isEmpty()) {
				ConteudoItemTarefaBO conteudoItemTarefaBO = new ConteudoItemTarefaBO();
				ConteudoItemTarefaTO conteudoItemTarefaTO = new ConteudoItemTarefaTO();			

				conteudoItemTarefaTO.setAnoCriacao(tarefaTO.getAnoCriacao());
				conteudoItemTarefaTO.setCodTarefa(tarefaTO.getCodigo());
				conteudoItemTarefaTO.setCodConfigTarefa(tarefaTO.getCodConfigTarefa());

				Iterator i = resultado.iterator();
				while (i.hasNext()) {
					ItemTO resultTO = (ItemTO) i.next();
					conteudoItemTarefaTO.setNumeroOrdem(resultTO.getNumeroOrdem());
					conteudoItemTarefaBO.incluir(conteudoItemTarefaTO);
				}
			}
		} catch (ExceptionNegocioPRO e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		}
	}

	/*Valor da Sinalizacao * Vermelho 3 * Amarelo 2	 * Verde 1*/
	public Collection consultarArvore(TarefaTO tarefaTO, ParticipanteTO participanteTO) throws Exception{
		DaoManager daoManager = FabricaDAO.getDaoManager();
	try {			
		TarefaDAO tarefaDAO = (TarefaDAO) daoManager.getDao(TarefaDAO.class);
		Collection listaTarefa = tarefaDAO.consultarArvore(tarefaTO, participanteTO);
		Iterator iterator = listaTarefa.iterator();
		Integer sinalizacaoGrupo = 0;
		String grupoMesAnoAnterior = "";
		while (iterator.hasNext()) {
			TarefaTO tarefa = (TarefaTO) iterator.next();	
			tarefaTO = verificaSinalizacao(tarefa);
			if(!grupoMesAnoAnterior.equals(tarefa.getGrupoMesAno())){
				sinalizacaoGrupo = 0;
			}
			// aqui esta o erro
			if (tarefa.getSinalizacaoTarefa() > sinalizacaoGrupo){
				sinalizacaoGrupo = tarefa.getSinalizacaoTarefa();  
				tarefa.setSinalizacaoGrupo(sinalizacaoGrupo);
				}
			tarefa.setDiasFaltam(calculaDiasFaltam(tarefa.getDtLimitePrazo()));
			tarefa.setNome(Util.substituiCaracter(tarefa.getNome()));
			grupoMesAnoAnterior = tarefa.getGrupoMesAno();
			}
		return listaTarefa;
	} catch (ExceptionNegocioPRO e) {
		log.error(e.getMessage());
		throw new ExceptionNegocioPRO(e.getMessage());
	} 
}
	
//	public Collection consultarArvore(TarefaTO tarefaTO, ParticipanteTO participanteTO) throws ExceptionNegocioPRO, ParseException{		
//		try {			
//			ConfigTarefaBO configTarefaBO = new ConfigTarefaBO();
//			Collection listaResultado = configTarefaBO.consultarTiposPorTarefa(tarefaTO,participanteTO);
//			
//			Iterator iter = listaResultado.iterator();
//			while (iter.hasNext()) {
//				ConfigTarefaTO element = (ConfigTarefaTO) iter.next();
//				tarefaTO.setCodConfigTarefa(element.getCodigoConfigTarefa());
//				Collection listaTarefa = visualizar(tarefaTO,participanteTO);
//				Iterator iterator = listaTarefa.iterator();
//				int valorSinal = 4;
//				while (iterator.hasNext()) {
//					TarefaTO tarefa = (TarefaTO) iterator.next();
//					if (tarefa.getSinalizacao() < valorSinal){
//						valorSinal = tarefa.getSinalizacao();  
//						element.setValorSinal(valorSinal);	
//					}
//					tarefa.setDiasFaltam(calculaDiasFaltam(tarefa.getDtLimitePrazo()));
//					tarefa.setNome(Util.substituiCaracter(tarefa.getNome()));
//				}
//				element.setListaTarefas(listaTarefa);
//			}
//			return listaResultado;
//		} catch (ExceptionNegocioPRO e) {
//			log.error(e.getMessage());
//			throw new ExceptionNegocioPRO(e.getMessage());
//		} 
//	}
	
	
	
	public void alterarDataAlteracao(TarefaTO tarefaTO) throws ExceptionNegocioPRO{
		DaoManager daoManager = FabricaDAO.getDaoManager();
		try {
			daoManager.startTransaction();		
			TarefaDAO tarefaDAO = (TarefaDAO) daoManager.getDao(TarefaDAO.class);
			tarefaTO.setTsAlteracao(new DataUtil().getTimestamp());
			tarefaDAO.alterarDataAtualizacao(tarefaTO);
			try {
				ParticipanteTO participanteTO = new ParticipanteTO();
				participanteTO.setAnoCriacao(tarefaTO.getAnoCriacao());
				participanteTO.setCodTarefa(tarefaTO.getCodigo());
				participanteTO.setCodTipoParticipacao(1);		
				alterarParticipanteStatuAtividade(participanteTO);
			} catch (Exception e) {
				log.error(e.getMessage());
				throw new ExceptionNegocioPRO(e.getMessage());
			}
			
			daoManager.commitTransaction();
		} catch (ExceptionNegocioPRO e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		} finally {
			daoManager.endTransaction();
		}
	}
	
	private void alterarParticipanteStatuAtividade(ParticipanteTO participanteTO) throws ExceptionNegocioPRO{
		ParticipanteBO participanteBO = new ParticipanteBO();
		Collection listaParticipante = participanteBO.consultarVarios(participanteTO);
		Iterator iter = listaParticipante.iterator();
		while (iter.hasNext()){
			ParticipanteTO element = (ParticipanteTO) iter.next();
			participanteTO.setCodUsuario(element.getCodUsuario());
			participanteTO.setCodigo(element.getCodigo());
			if (element.getCodUsuario() == UsuarioBO.getUsuarioTO().getIdUsuario()){
				participanteTO.setCodNivel(1);
				participanteBO.alterar(participanteTO);
			}else{
				participanteTO.setCodNivel(2);
				participanteBO.alterar(participanteTO);
			}
		}
	}

	public String montaMensagemEmail(TarefaTO tarefaTO,Collection listaExecutante,String texto){
		
		StringBuffer mensagemEmail = new StringBuffer(); 
		Iterator iter = listaExecutante.iterator();
		mensagemEmail.append("De: " + tarefaTO.getCodUsuSolicitante() + " - " + tarefaTO.getNomeUsuSolicitante() + "\n");
		mensagemEmail.append("Para: ");
			while (iter.hasNext()) {
				ParticipanteTO element = (ParticipanteTO) iter.next();
				mensagemEmail.append(element.getNome() + " ("+ element.getEmail() + ") \n");
			}
		mensagemEmail.append("\n");
		mensagemEmail.append("\n");			
		mensagemEmail.append("Informações Adicionais: \n");
		
		mensagemEmail.append(texto);
						
		mensagemEmail.append("Foi criada a tarefa "+tarefaTO.getNome()+", Para acessá-la clique em: \n");
		mensagemEmail.append("http://localhost:8080/intraPRO/APPS/tarefa/encaminhar/alterar.do?");
		mensagemEmail.append("op=alterarStatusModificado&anoCriacao="+tarefaTO.getAnoCriacao()+"&codigo=" +tarefaTO.getCodigo() + " \n");
		mensagemEmail.append("\n");
		mensagemEmail.append("\n");
		mensagemEmail.append("Tarefa: "+ tarefaTO.getCodigoAno()+ " - " + tarefaTO.getNome() + "\n");
		mensagemEmail.append("\n");
		mensagemEmail.append("Solicitação: " + tarefaTO.getTextoSolicitacao() + "\n");		
		mensagemEmail.append("\n");
		mensagemEmail.append("Prazo: " + tarefaTO.getDtPrazo() + "\n");
		mensagemEmail.append("\n");
		return mensagemEmail.toString();
	} 
	
	public boolean contemParticipante(Collection lista, UsuarioTO usuario){
		Iterator iter = lista.iterator();
		while (iter.hasNext()) {
			ParticipanteTO element = (ParticipanteTO) iter.next();
			if (element.getCodUsuario() == usuario.getIdUsuario()){
				return true;
			}
		}
		return false;
	}

	public String consultarNomeMapa(int codigo) throws ExceptionNegocioBSC{
		MapaEstrategicoBO mapaEstrategicoBO = new MapaEstrategicoBO();
		MapaEstrategicoTO mapaEstrategicoTO = new MapaEstrategicoTO();
		mapaEstrategicoTO.setId(codigo);
		return mapaEstrategicoBO.consultarUm(mapaEstrategicoTO).getNome();
	}
	public String consultarNomePerspectiva(int codigo) throws ExceptionNegocioBSC{
		PerspectivaBO perspectivaBO = new PerspectivaBO();
		PerspectivaTO perspectivaTO = new PerspectivaTO();
		perspectivaTO.setId(codigo);
		return perspectivaBO.consultarUm(perspectivaTO).getNome();	
	}
	public String consultarNomeObjetivo(int codigo) throws ExceptionNegocioBSC{
		ObjetivoBO objetivoBO = new ObjetivoBO();
		ObjetivoTO objetivoTO = new ObjetivoTO();
		objetivoTO.setId(codigo);
		return objetivoBO.consultarUm(objetivoTO).getNome();
	}
	public String consultarNomeIndicador(int codigo) throws ExceptionNegocioBSC{
		IndicadorBO indicadorBO = new IndicadorBO();
		IndicadorTO indicadorTO = new IndicadorTO();
		indicadorTO.setId(codigo);
		return indicadorBO.consultarUm(indicadorTO).getNome();
	}
	public int calculaDiasFaltam(Date dtPrazo) throws ExceptionNegocioPRO{
		DataUtil dataUtil = new DataUtil();
		return Math.round(dataUtil.getDiferencaEmDias(dataUtil.getDataAtual(),dtPrazo));
	}
	
	public Collection consultarTarefaFerramentaConfiguracao(TarefaTO tarefaTO) throws ExceptionNegocioPRO, ParseException{
		DaoManager daoManager = FabricaDAO.getDaoManager();
		TarefaDAO tarefaDAO = (TarefaDAO) daoManager.getDao(TarefaDAO.class);
		try {
			return tarefaDAO.consultarTarefaFerramentaConfiguracao(tarefaTO);
		} catch (ExceptionNegocioPRO e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		} 
	}
	
	public void excluirTarefaIndicador(TarefaTO tarefaTO) throws ExceptionNegocioPRO, ParseException {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		TarefaDAO tarefaDAO = (TarefaDAO) daoManager.getDao(TarefaDAO.class);	
		try {
			daoManager.startTransaction();
			tarefaDAO.excluirTarefaIndicador(tarefaTO);
			daoManager.commitTransaction();
		} catch (ExceptionNegocioPRO e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		} finally {
			daoManager.endTransaction();
		}
	}
	
	public void excluirTarefaObjetivo(TarefaTO tarefaTO) throws ExceptionNegocioPRO, ParseException {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		TarefaDAO tarefaDAO = (TarefaDAO) daoManager.getDao(TarefaDAO.class);	
		try {
			daoManager.startTransaction();
			tarefaDAO.excluirTarefaObjetivo(tarefaTO);
			daoManager.commitTransaction();
		} catch (ExceptionNegocioPRO e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		} finally {
			daoManager.endTransaction();
		}
	}
	
	public void excluirTarefaPerpesctiva(TarefaTO tarefaTO) throws ExceptionNegocioPRO, ParseException {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		TarefaDAO tarefaDAO = (TarefaDAO) daoManager.getDao(TarefaDAO.class);	
		try {
			daoManager.startTransaction();
			tarefaDAO.excluirTarefaPerspectiva(tarefaTO);
			daoManager.commitTransaction();
		} catch (ExceptionNegocioPRO e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		} finally {
			daoManager.endTransaction();
		}
	}
	
	public void excluirTarefaMapa(TarefaTO tarefaTO) throws ExceptionNegocioPRO, ParseException {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		TarefaDAO tarefaDAO = (TarefaDAO) daoManager.getDao(TarefaDAO.class);	
		try {
			daoManager.startTransaction();
			tarefaDAO.excluirTarefaMapa(tarefaTO);
			daoManager.commitTransaction();
		} catch (ExceptionNegocioPRO e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		} finally {
			daoManager.endTransaction();
		}
	}

	public void excluirTarefaAtividade(TarefaTO tarefaTO) throws ExceptionNegocioPRO, ParseException {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		TarefaDAO tarefaDAO = (TarefaDAO) daoManager.getDao(TarefaDAO.class);	
		try {
			daoManager.startTransaction();
			tarefaDAO.excluirTarefaAtividade(tarefaTO);
			daoManager.commitTransaction();
		} catch (ExceptionNegocioPRO e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		} finally {
			daoManager.endTransaction();
		}
	}
	
	public void excluirTarefaFase(TarefaTO tarefaTO) throws ExceptionNegocioPRO, ParseException {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		TarefaDAO tarefaDAO = (TarefaDAO) daoManager.getDao(TarefaDAO.class);	
		try {
			daoManager.startTransaction();
			tarefaDAO.excluirTarefaFase(tarefaTO);
			daoManager.commitTransaction();
		} catch (ExceptionNegocioPRO e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		} finally {
			daoManager.endTransaction();
		}
	}
	
	public void excluirTarefaProcesso(TarefaTO tarefaTO) throws ExceptionNegocioPRO, ParseException {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		TarefaDAO tarefaDAO = (TarefaDAO) daoManager.getDao(TarefaDAO.class);	
		try {
			daoManager.startTransaction();
			tarefaDAO.excluirTarefaProcesso(tarefaTO);
			daoManager.commitTransaction();
		} catch (ExceptionNegocioPRO e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		} finally {
			daoManager.endTransaction();
		}
	}
	
	
	
	
	
	
	/**
	 * Esta consulta esta sendo utilizada para recuperar as tarefas para as combos de Mapa, Perspectiva, Objetivo e Indicador.
	 * @param tarefaTO
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Collection consultarTarefas(TarefaTO tarefaTO) throws Exception{        	
	   /*Consulta todas as tarefas relacionadas a um indicador*/
	   TarefaBO tarefaBO = new TarefaBO();
	   ParticipanteTO participanteTO = new ParticipanteTO();
	   participanteTO.setCodTipoParticipacao(1);
	   participanteTO.setCodUsuario(tarefaTO.getCodUsuSolicitante());
	   return tarefaBO.consultarArvore(tarefaTO, participanteTO); 
	}
	
}