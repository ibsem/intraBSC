package br.com.intraPRO.negocio;

import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.intraBSC.modelo.PapelTO;
import br.com.intraBSC.modelo.UsuarioTO;
import br.com.intraBSC.negocio.PapelBO;
import br.com.intraBSC.negocio.UsuarioBO;
import br.com.intraBSC.persistencia.FabricaDAO;
import br.com.intraPRO.excecoes.ExceptionNegocioPRO;
import br.com.intraPRO.modelo.ParticipanteTO;
import br.com.intraPRO.modelo.TarefaTO;
import br.com.intraPRO.persistencia.ParticipanteDAO;

import com.ibatis.dao.client.DaoManager;


public class ParticipanteBO {
	private static Log log = LogFactory.getLog(TarefaBO.class);

	public ParticipanteBO() {
	}


	public void incluir(ParticipanteTO participanteTO) throws ExceptionNegocioPRO {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		ParticipanteDAO participanteDAO = (ParticipanteDAO) daoManager.getDao(ParticipanteDAO.class);
		try {
			ParticipanteTO participanteTO2 = new ParticipanteTO();
			participanteTO2 = participanteDAO.consultarUm(participanteTO);
			daoManager.startTransaction();
			if (participanteTO2.getCodUsuario() == 0	|| participanteTO.getCodUsuario() != participanteTO2.getCodUsuario()) {
				participanteTO.setCodigo(participanteDAO.consultarMax());
				participanteDAO.incluir(participanteTO);
				daoManager.commitTransaction();
			}
		} catch (ExceptionNegocioPRO e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		} finally {
			daoManager.endTransaction();
		}
	}
	
	public void alterar(ParticipanteTO participanteTO) throws ExceptionNegocioPRO {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		ParticipanteDAO participanteDAO = (ParticipanteDAO) daoManager.getDao(ParticipanteDAO.class);
		try {
				daoManager.startTransaction();
				participanteDAO.alterar(participanteTO);
				daoManager.commitTransaction();
		} catch (ExceptionNegocioPRO e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		} finally {
			daoManager.endTransaction();
		}
	}

	public void incluirListaParticipante(ParticipanteTO participanteTO)throws ExceptionNegocioPRO {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		ParticipanteDAO participanteDAO = (ParticipanteDAO) daoManager.getDao(ParticipanteDAO.class);
		try {
			ParticipanteTO participanteTOConsulta = new ParticipanteTO();
			participanteTOConsulta.setAnoCriacao(participanteTO.getAnoCriacao());
			participanteTOConsulta.setCodTarefa(participanteTO.getCodTarefa());
			int cont = participanteDAO.consultarMax();			
			daoManager.startTransaction();
			if ((participanteTO.getListaParticipante() != null)){
				for (int i = 0; i < participanteTO.getListaParticipante().length; i++) {
					participanteTO.setCodigo(cont);
					participanteTO.setCodUsuario(participanteTO.getListaParticipante()[i]);
					participanteTOConsulta.setCodUsuario(participanteTO.getListaParticipante()[i]);
					participanteTOConsulta.setCodTipoParticipacao(participanteTO.getCodTipoParticipacao());
					
					if (participanteDAO.consultarUm(participanteTOConsulta).getCodigo() == 0) {
						/*Campo utilizado como flag para modificado ou nao modificado. 1 para visualizado a modificacao e 2 para nao visualizado a modificacao.*/
						participanteTO.setCodNivel(2);
						participanteDAO.incluir(participanteTO);
						cont++;
					}
				}
			}else{
				participanteTOConsulta.setCodTipoParticipacao(participanteTO.getCodTipoParticipacao());
				participanteTOConsulta.setAnoCriacao(participanteTO.getAnoCriacao());
				participanteTOConsulta.setCodTarefa(participanteTO.getCodTarefa());
				if (participanteDAO.consultarUm(participanteTOConsulta).getCodUsuario() == 0){
					participanteTO.setCodigo(cont);
					participanteDAO.incluir(participanteTO);
				}
			}
			daoManager.commitTransaction();
		} catch (ExceptionNegocioPRO e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		} finally {
			daoManager.endTransaction();
		}
	}

	
	public Collection consultarVarios(ParticipanteTO participanteTO)throws ExceptionNegocioPRO {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		ParticipanteDAO participanteDAO = (ParticipanteDAO) daoManager.getDao(ParticipanteDAO.class);
		Collection resultado = null;
		try {
			daoManager.startTransaction();
			resultado = participanteDAO.consultarVarios(participanteTO);

			UsuarioTO usuarioTO = new UsuarioTO();
			Iterator iteracao = resultado.iterator();
			while (iteracao.hasNext()) {
				ParticipanteTO participanteTO2 = (ParticipanteTO) iteracao.next();
				String nomeDepartamento = "";
				if (!nomeDepartamento.equals("")){
					participanteTO2.setNome(nomeDepartamento);
					participanteTO2.setCodUsuario(participanteTO2.getCodigo());
				}else{
					
					if (participanteTO2.getCodUsuario() != 0) {
						usuarioTO.setIdUsuario(participanteTO2.getCodUsuario());
					}
				}
			}

		} catch (ExceptionNegocioPRO e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		}finally {
			daoManager.endTransaction();
		}
		return resultado;

	}

	
	public int consultaMax(ParticipanteTO participanteTO)throws ExceptionNegocioPRO {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		ParticipanteDAO participanteDAO = (ParticipanteDAO) daoManager.getDao(ParticipanteDAO.class);
		try {
			daoManager.startTransaction();
			int resultNumOrdemParticipante = participanteDAO.consultarMax();
			participanteTO.setCodigo(resultNumOrdemParticipante);
			return resultNumOrdemParticipante;
		} catch (ExceptionNegocioPRO e) {
			throw new ExceptionNegocioPRO(e.getMessage());
		}finally {
			daoManager.endTransaction();
		}
	}

	public ParticipanteTO consultaUm(ParticipanteTO participanteTO)	throws ExceptionNegocioPRO {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		ParticipanteDAO participanteDAO = (ParticipanteDAO) daoManager.getDao(ParticipanteDAO.class);
		try {
			daoManager.startTransaction();
			return participanteDAO.consultarUm(participanteTO);
		} catch (ExceptionNegocioPRO e) {
			throw new ExceptionNegocioPRO(e.getMessage());
		}finally {
			daoManager.endTransaction();
		}
	}

	public void excluir(ParticipanteTO participanteTO)throws ExceptionNegocioPRO {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		ParticipanteDAO participanteDAO = (ParticipanteDAO) daoManager.getDao(ParticipanteDAO.class);
		try {
			daoManager.startTransaction();
			participanteDAO.excluir(participanteTO);
			daoManager.commitTransaction();
		} catch (ExceptionNegocioPRO e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		} finally {
			daoManager.endTransaction();
		}
	}
	
	/**
	 * Metodo que verifica se participante e o solicitante, caso sim nao deixa excluir
	 * @param participanteTO
	 * @throws ExceptionNegocioPRO
	 */
	public void verificaSeUltimoParticipante(ParticipanteTO participanteTO, int codSolicitante) throws ExceptionNegocioPRO{
		try {
			if (consultaUm(participanteTO).getCodUsuario() == codSolicitante){
				throw new ExceptionNegocioPRO("O solicitante da Tarefa não pode ser excluído.");
			}
		} catch (ExceptionNegocioPRO e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		}
	}

	public void limpar(ParticipanteTO participanteTO)throws ExceptionNegocioPRO {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		ParticipanteDAO participanteDAO = (ParticipanteDAO) daoManager.getDao(ParticipanteDAO.class);
		try {
			daoManager.startTransaction();
			participanteDAO.excluir(participanteTO);
			TarefaBO tarefaBO = new TarefaBO();
			TarefaTO tarefaTO = new TarefaTO();
			tarefaTO.setAnoCriacao(participanteTO.getAnoCriacao());
			tarefaTO.setCodigo(participanteTO.getCodTarefa());
			tarefaBO.alterarDataAlteracao(tarefaTO);
			daoManager.commitTransaction();
		} catch (ExceptionNegocioPRO e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		} finally {
			daoManager.endTransaction();
		}
	}
	
	
	public Collection consultarVariosExecutante(ParticipanteTO participanteTO)throws ExceptionNegocioPRO {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		ParticipanteDAO participanteDAO = (ParticipanteDAO) daoManager.getDao(ParticipanteDAO.class);
		Collection resultado = null;
		try {
			daoManager.startTransaction();
			resultado = participanteDAO.consultarVarios(participanteTO);
			UsuarioBO usuarioBO = new UsuarioBO();
			UsuarioTO usuarioTO = new UsuarioTO();
			PapelBO papelBO = new PapelBO();
			PapelTO papelTO = new PapelTO();
			Iterator iteracao = resultado.iterator();
			while (iteracao.hasNext()) {
				ParticipanteTO participanteTO2 = (ParticipanteTO) iteracao.next();
				Collection usuario;
				usuarioTO = new UsuarioTO();
				if (participanteTO2.getCodUsuario() != 0 ) {
					papelTO = new PapelTO();
					usuarioTO.setIdUsuario(participanteTO2.getCodUsuario());
					usuarioTO.setGrupoTO(UsuarioBO.getUsuarioTO().getGrupoTO());
					usuario = usuarioBO.consultarVarios(usuarioTO);
					Iterator i = usuario.iterator();
					while (i.hasNext()) {
						papelTO.setId(participanteTO2.getCodPapel());
						if (papelTO.getId() != 0)
							{papelTO = papelBO.consultarUm(papelTO);}
						else{
							papelTO.setNome(" ");
						}
						usuarioTO = (UsuarioTO) i.next();
						participanteTO2.setNome(usuarioTO.getIdUsuario() + " - " + usuarioTO.getNome()+ " - " + papelTO.getNome() + " - " + usuarioTO.getEmail());
					}
				}
			}
		} catch (Exception e) {
			 throw new ExceptionNegocioPRO(e.getMessage());
		}finally {
			daoManager.endTransaction();
		}
		return resultado;

	}
	
}