package br.com.intraPRO.negocio;


import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.intraBSC.modelo.UsuarioTO;
import br.com.intraBSC.modelo.PapelTO;
import br.com.intraBSC.negocio.PapelBO;
import br.com.intraBSC.negocio.UsuarioBO;
import br.com.intraBSC.persistencia.FabricaDAO;
import br.com.intraPRO.excecoes.ExceptionNegocioPRO;
import br.com.intraPRO.modelo.ParticipanteConfigTarefaTO;
import br.com.intraPRO.persistencia.ParticipanteConfigTarefaDAO;

import com.ibatis.dao.client.DaoManager;

public class ParticipanteConfigTarefaBO {
	
	private static Log log = LogFactory.getLog(TarefaBO.class);

	public ParticipanteConfigTarefaBO() {
	}


	public void incluir(ParticipanteConfigTarefaTO participanteConfigTarefaTO)throws ExceptionNegocioPRO {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		ParticipanteConfigTarefaDAO participanteConfigTarefaDAO = (ParticipanteConfigTarefaDAO) daoManager.getDao(ParticipanteConfigTarefaDAO.class);
		try {
			ParticipanteConfigTarefaTO participanteConfigTarefaTOConsulta = new ParticipanteConfigTarefaTO();
			participanteConfigTarefaTOConsulta = participanteConfigTarefaDAO.consultarUm(participanteConfigTarefaTO);
			if (participanteConfigTarefaTOConsulta.getCodUsuario() == 0	|| participanteConfigTarefaTO.getCodUsuario() != participanteConfigTarefaTOConsulta.getCodUsuario()) {
				participanteConfigTarefaTO.setCodigo(participanteConfigTarefaDAO.consultarMax());
				daoManager.startTransaction();
				participanteConfigTarefaDAO.incluir(participanteConfigTarefaTO);
				daoManager.commitTransaction();
			}
		} catch (ExceptionNegocioPRO e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		} finally {
			daoManager.endTransaction();
		}
	}

	public void incluirListaParticipante(ParticipanteConfigTarefaTO participanteConfigTarefaTO)throws ExceptionNegocioPRO {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		ParticipanteConfigTarefaDAO participanteConfigTarefaDAO = (ParticipanteConfigTarefaDAO) daoManager.getDao(ParticipanteConfigTarefaDAO.class);
		try {
			ParticipanteConfigTarefaTO participanteConfigTarefaTOConsulta = new ParticipanteConfigTarefaTO();			
			int cont = participanteConfigTarefaDAO.consultarMax();			
			daoManager.startTransaction();
			if ((participanteConfigTarefaTO.getListaParticipante() != null))
			{
				for (int i = 0; i < participanteConfigTarefaTO.getListaParticipante().length; i++) {
					participanteConfigTarefaTO.setCodigo(cont);
					participanteConfigTarefaTO.setCodUsuario(participanteConfigTarefaTO.getListaParticipante()[i]);
					participanteConfigTarefaTOConsulta.setCodUsuario(participanteConfigTarefaTO.getListaParticipante()[i]);
					participanteConfigTarefaTOConsulta.setCodTipoParticipacao(participanteConfigTarefaTO.getCodTipoParticipacao());
					participanteConfigTarefaTOConsulta.setCodConfigTarefa(participanteConfigTarefaTO.getCodConfigTarefa());
					
					if (participanteConfigTarefaDAO.consultarUm(participanteConfigTarefaTOConsulta).getCodigo() == 0) {
						participanteConfigTarefaDAO.incluir(participanteConfigTarefaTO);
						cont++;
					}
				}
				}else{
												
				participanteConfigTarefaTOConsulta.setCodTipoParticipacao(participanteConfigTarefaTO.getCodTipoParticipacao());
				participanteConfigTarefaTOConsulta.setCodConfigTarefa(participanteConfigTarefaTO.getCodConfigTarefa());
				if (participanteConfigTarefaDAO.consultarUm(participanteConfigTarefaTOConsulta).getCodigo() == 0) {
					participanteConfigTarefaTO.setCodigo(cont);
					participanteConfigTarefaDAO.incluir(participanteConfigTarefaTO);
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


	public Collection consultarVarios(ParticipanteConfigTarefaTO participanteConfigTarefaTO)throws ExceptionNegocioPRO {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		ParticipanteConfigTarefaDAO participanteConfigTarefaDAO = (ParticipanteConfigTarefaDAO) daoManager.getDao(ParticipanteConfigTarefaDAO.class);
		Collection resultado = null;
		try {
			daoManager.startTransaction();
			resultado = participanteConfigTarefaDAO.consultarVarios(participanteConfigTarefaTO);
			UsuarioBO usuarioBO = new UsuarioBO();
			UsuarioTO usuarioTO = new UsuarioTO();
			PapelBO papelBO = new PapelBO();
			PapelTO papelTO = new PapelTO();
			Iterator iteracao = resultado.iterator();
			while (iteracao.hasNext())	{
				ParticipanteConfigTarefaTO participanteConfigTarefaTOIter = (ParticipanteConfigTarefaTO) iteracao.next();
				Collection usuario;
				if (participanteConfigTarefaTOIter.getCodUsuario() != 0 ) {
					usuarioTO = new UsuarioTO();
					papelTO = new PapelTO();
					usuarioTO.setIdUsuario(participanteConfigTarefaTOIter.getCodUsuario());
					usuarioTO.setGrupoTO(UsuarioBO.getUsuarioTO().getGrupoTO());
					usuario = usuarioBO.consultarVarios(usuarioTO);
					Iterator i = usuario.iterator();
					while (i.hasNext()) {
						usuarioTO = (UsuarioTO) i.next();
						papelTO.setId(participanteConfigTarefaTOIter.getCodPapel());
						if (papelTO.getId() != 0)
							{papelTO = papelBO.consultarUm(papelTO);}
						else{
							papelTO.setNome("");
						}
						
						participanteConfigTarefaTOIter.setNome(usuarioTO.getIdUsuario() + " - " + usuarioTO.getNome() + " - " + papelTO.getNome() + " - " + usuarioTO.getEmail());
					}
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		}finally {
			daoManager.endTransaction();
		}
		return resultado;
	}

	
	public void consultaMax(ParticipanteConfigTarefaTO participanteConfigTarefaTO)throws ExceptionNegocioPRO {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		ParticipanteConfigTarefaDAO participanteConfigTarefaDAO = (ParticipanteConfigTarefaDAO) daoManager.getDao(ParticipanteConfigTarefaDAO.class);
		try {
			daoManager.startTransaction();			
			participanteConfigTarefaTO.setCodigo(participanteConfigTarefaDAO.consultarMax());
		} catch (ExceptionNegocioPRO e) {
			throw new ExceptionNegocioPRO(e.getMessage());
		}finally {
			daoManager.endTransaction();
		}
	}


	public ParticipanteConfigTarefaTO consultaUm(ParticipanteConfigTarefaTO participanteConfigTarefaTO)	throws ExceptionNegocioPRO {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		ParticipanteConfigTarefaDAO participanteConfigTarefaDAO = (ParticipanteConfigTarefaDAO) daoManager.getDao(ParticipanteConfigTarefaDAO.class);
		try {
			daoManager.startTransaction();
			return participanteConfigTarefaDAO.consultarUm(participanteConfigTarefaTO);
		} catch (ExceptionNegocioPRO e) {
			throw new ExceptionNegocioPRO(e.getMessage());
		}finally {
			daoManager.endTransaction();
		}
	}

	public void excluir(ParticipanteConfigTarefaTO participanteConfigTarefaTO)throws ExceptionNegocioPRO {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		ParticipanteConfigTarefaDAO participanteConfigTarefaDAO = (ParticipanteConfigTarefaDAO) daoManager.getDao(ParticipanteConfigTarefaDAO.class);
		try {
			daoManager.startTransaction();
			participanteConfigTarefaDAO.excluir(participanteConfigTarefaTO);
			daoManager.commitTransaction();
		} catch (ExceptionNegocioPRO e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		} finally {
			daoManager.endTransaction();
		}
	}

	public void limpar(ParticipanteConfigTarefaTO participanteConfigTarefaTO)throws ExceptionNegocioPRO {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		ParticipanteConfigTarefaDAO participanteConfigTarefaDAO = (ParticipanteConfigTarefaDAO) daoManager.getDao(ParticipanteConfigTarefaDAO.class);
		try {

			daoManager.startTransaction();
			participanteConfigTarefaDAO.excluir(participanteConfigTarefaTO);
			daoManager.commitTransaction();

		} catch (ExceptionNegocioPRO e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		} finally {
			daoManager.endTransaction();
		}
	}

}
