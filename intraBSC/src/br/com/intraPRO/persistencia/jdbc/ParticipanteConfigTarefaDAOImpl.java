package br.com.intraPRO.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ibatis.dao.client.DaoManager;

import br.com.intraBSC.persistencia.BscDaoJDBCGenerico;
import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.ParticipanteConfigTarefaTO;
import br.com.intraPRO.persistencia.ParticipanteConfigTarefaDAO;

public class ParticipanteConfigTarefaDAOImpl extends BscDaoJDBCGenerico implements ParticipanteConfigTarefaDAO  {

	public ParticipanteConfigTarefaDAOImpl(DaoManager daoManager) {
		super(daoManager);
	}

	protected final static String TABELA = "CONFIGURATIONTASKACTOR";
	protected final static String NUMERO_SEQUENCIAL_TAREFA = "PK_SEQUENCE_PCT";
	protected final static String CODIGO_TIPO_TAREFA = "PK_CONFIGTASK";
	protected final static String COD_TIPO_PARTICIPACAO = "FK_BASE_MODEL_PRTC";
	protected final static String COD_USUARIO = "FK_BASE_ACTOR";
	protected final static String COD_PAPEL = "FK_ROLE";
	
	private static Log log = LogFactory.getLog(ParticipanteConfigTarefaDAOImpl.class);

	
	private Connection getConexao() {
		return getConnection();
	}

	
	private ParticipanteConfigTarefaTO carregarTO(ResultSet resultado) throws SQLException {
		ParticipanteConfigTarefaTO participanteConfigTarefaTO = new ParticipanteConfigTarefaTO();
		participanteConfigTarefaTO.setCodigo(resultado.getInt(1));
		participanteConfigTarefaTO.setCodConfigTarefa(resultado.getInt(2));
		participanteConfigTarefaTO.setCodTipoParticipacao(resultado.getInt(3));
		participanteConfigTarefaTO.setCodPapel(resultado.getInt(4));
		participanteConfigTarefaTO.setCodUsuario(resultado.getInt(5));
		return participanteConfigTarefaTO;
	}

	
	public void incluir(ParticipanteConfigTarefaTO participanteConfigTarefaTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("INSERT INTO ");
		sql.append(TABELA);
		sql.append(" (");
		
		 if(participanteConfigTarefaTO.getCodigo()!=0){
			 sql.append(NUMERO_SEQUENCIAL_TAREFA + ", ");
		 }
		 if(participanteConfigTarefaTO.getCodConfigTarefa()!=0){
			 sql.append(CODIGO_TIPO_TAREFA + ", ");
		 }
		 if(participanteConfigTarefaTO.getCodConfigTarefa()!=0){
			 sql.append(COD_TIPO_PARTICIPACAO + ", ");
		 }
			
		 if(participanteConfigTarefaTO.getCodPapel()!=0){
			 sql.append(COD_PAPEL + ", ");
		 }
		 if((participanteConfigTarefaTO.getCodUsuario()!=0)){
			 sql.append(COD_USUARIO);
		 }else {
	            sql.delete(sql.length() - 2, sql.length());
	        }
		 
		sql.append(") VALUES (");
		
		 
		 if(participanteConfigTarefaTO.getCodigo()!=0){
			 sql.append(" ?, ");
		 }
		 if(participanteConfigTarefaTO.getCodConfigTarefa()!=0){
			 sql.append(" ?, ");
		 }
		 if(participanteConfigTarefaTO.getCodTipoParticipacao()!=0){
			 sql.append(" ?, ");
		 }
		 if(participanteConfigTarefaTO.getCodPapel()!=0){
			 sql.append(" ?, ");
		 }
		 if(participanteConfigTarefaTO.getCodUsuario()!=0){
			sql.append(" ?");
		 }else {
	            sql.delete(sql.length() - 2, sql.length());
	     }
		 sql.append(")");
		PreparedStatement stmt;

		try {
			int i = 0;
			stmt = getConnection().prepareStatement(sql.toString());
			 			 
			 if(participanteConfigTarefaTO.getCodigo()!=0){
				 stmt.setInt(++i, participanteConfigTarefaTO.getCodigo());
			 }
			 if(participanteConfigTarefaTO.getCodConfigTarefa()!=0){
				 stmt.setInt(++i, participanteConfigTarefaTO.getCodConfigTarefa());
			 }
			 if(participanteConfigTarefaTO.getCodTipoParticipacao()!=0){
				 stmt.setInt(++i, participanteConfigTarefaTO.getCodTipoParticipacao());
			 }
			 if(participanteConfigTarefaTO.getCodPapel()!=0){
				 stmt.setInt(++i, participanteConfigTarefaTO.getCodPapel());
			 }
			 if(participanteConfigTarefaTO.getCodUsuario()!=0){
				 stmt.setInt(++i, participanteConfigTarefaTO.getCodUsuario());
			 }
			stmt.executeUpdate();
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
	}

	
	
	@SuppressWarnings("unchecked")
	public Collection consultarVarios(ParticipanteConfigTarefaTO participanteConfigTarefaTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("SELECT ");
		sql.append(NUMERO_SEQUENCIAL_TAREFA + ", ");
		sql.append(CODIGO_TIPO_TAREFA + ", ");
		sql.append(COD_TIPO_PARTICIPACAO + ", ");
		sql.append(COD_PAPEL + ", ");
		sql.append(COD_USUARIO);
		sql.append(" FROM " + TABELA + " A ");
		sql.append("WHERE 1=1 ");

		if (participanteConfigTarefaTO.getCodigo() != 0) {
			sql.append("AND A." + NUMERO_SEQUENCIAL_TAREFA + "=?");
		}

		if (participanteConfigTarefaTO.getCodConfigTarefa() != 0) {
			sql.append("AND A." + CODIGO_TIPO_TAREFA + "=?");
		}
		if (participanteConfigTarefaTO.getCodTipoParticipacao() != 0) {
			sql.append("AND A." + COD_TIPO_PARTICIPACAO + "=?");
		}
	
		if ((participanteConfigTarefaTO.getCodUsuario() != 0)) {
			sql.append("AND A." + COD_USUARIO + "=?");
		}
		PreparedStatement stmt;
		ResultSet result;
		Collection listaParticipacao = new ArrayList();
		int i = 0;
		try {
			stmt = getConnection().prepareStatement(sql.toString());

			if (participanteConfigTarefaTO.getCodigo() != 0) {
				stmt.setInt(++i, participanteConfigTarefaTO.getCodigo());
			}
			
			if (participanteConfigTarefaTO.getCodConfigTarefa() != 0) {
				stmt.setInt(++i, participanteConfigTarefaTO.getCodConfigTarefa());
			}

			if (participanteConfigTarefaTO.getCodTipoParticipacao() != 0) {
				stmt.setInt(++i, participanteConfigTarefaTO.getCodTipoParticipacao());
			}

			if ((participanteConfigTarefaTO.getCodUsuario() != 0)) {
				stmt.setInt(++i, participanteConfigTarefaTO.getCodUsuario());
			}
			result = stmt.executeQuery();
			while (result.next()) {
				listaParticipacao.add(carregarTO(result));
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
		return listaParticipacao;
	}


	
	public int consultarMax() throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("SELECT MAX(");
		sql.append(NUMERO_SEQUENCIAL_TAREFA);
		sql.append(") AS ");
		sql.append(NUMERO_SEQUENCIAL_TAREFA);
		sql.append(" FROM ");
		sql.append(TABELA);
		sql.append(" WHERE 1=1");

		PreparedStatement stmt;
		ResultSet result;
		try {
			stmt = getConexao().prepareStatement(sql.toString());
			result = stmt.executeQuery();
			while (result.next()) {
				return result.getInt(NUMERO_SEQUENCIAL_TAREFA) + 1;
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
		return 0;
	}

	
	public void excluir(ParticipanteConfigTarefaTO participanteConfigTarefaTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("DELETE ");

		sql.append(" FROM " + TABELA );
		sql.append(" WHERE 1=1 ");
				
		if (participanteConfigTarefaTO.getCodigo() != 0) {
			sql.append(" AND " + NUMERO_SEQUENCIAL_TAREFA + "=?");
		}

		if (participanteConfigTarefaTO.getCodConfigTarefa() != 0) {
			sql.append(" AND " + CODIGO_TIPO_TAREFA + "=?");
		}
		
		if (participanteConfigTarefaTO.getCodTipoParticipacao() != 0) {
			sql.append(" AND " + COD_TIPO_PARTICIPACAO + "=?");
		}
		
		
		if ((participanteConfigTarefaTO.getCodUsuario() != 0)) {
			sql.append(" AND " + COD_USUARIO + "=?");
		}

		PreparedStatement stmt;

		int i = 0;
		try {
			stmt = getConnection().prepareStatement(sql.toString());
			if (participanteConfigTarefaTO.getCodigo() != 0) {
				stmt.setInt(++i, participanteConfigTarefaTO.getCodigo());
			}

			if (participanteConfigTarefaTO.getCodConfigTarefa() != 0) {
				stmt.setInt(++i, participanteConfigTarefaTO.getCodConfigTarefa());
			}

			if (participanteConfigTarefaTO.getCodTipoParticipacao() != 0) {
				stmt.setInt(++i, participanteConfigTarefaTO.getCodTipoParticipacao());
			}
	
			if ((participanteConfigTarefaTO.getCodUsuario() != 0)) {
				stmt.setInt(++i, participanteConfigTarefaTO.getCodUsuario());
			}
			stmt.executeUpdate();
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}

	}

	
	public ParticipanteConfigTarefaTO consultarUm(ParticipanteConfigTarefaTO participanteConfigTarefaTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("SELECT ");
		sql.append(NUMERO_SEQUENCIAL_TAREFA + ", ");
		sql.append(CODIGO_TIPO_TAREFA + ", ");
		sql.append(COD_TIPO_PARTICIPACAO + ", ");
		sql.append(COD_PAPEL + ", ");
		sql.append(COD_USUARIO);
		sql.append(" FROM " + TABELA + " A ");
		sql.append("WHERE 1=1 ");
	
		if (participanteConfigTarefaTO.getCodigo() != 0) {
			sql.append(" AND A." + NUMERO_SEQUENCIAL_TAREFA + "=?");
		}

		if (participanteConfigTarefaTO.getCodConfigTarefa() != 0) {
			sql.append(" AND A." + CODIGO_TIPO_TAREFA + "=?");
		}
		
		if (participanteConfigTarefaTO.getCodTipoParticipacao() != 0) {
			sql.append(" AND A." + COD_TIPO_PARTICIPACAO + "=?");
		}
		
		if ((participanteConfigTarefaTO.getCodUsuario() != 0)) {
			sql.append(" AND A." + COD_USUARIO + "=?");
		}
		sql.append(" ORDER BY " + COD_TIPO_PARTICIPACAO);
		
		PreparedStatement stmt;
		ResultSet result;
		ParticipanteConfigTarefaTO participante = new ParticipanteConfigTarefaTO();
		int i = 0;
		try {
			stmt = getConnection().prepareStatement(sql.toString());

			if (participanteConfigTarefaTO.getCodigo() != 0) {
				stmt.setInt(++i, participanteConfigTarefaTO.getCodigo());
			}

			if (participanteConfigTarefaTO.getCodConfigTarefa() != 0) {
				stmt.setInt(++i, participanteConfigTarefaTO.getCodConfigTarefa());
			}
			
			if (participanteConfigTarefaTO.getCodTipoParticipacao() != 0) {
				stmt.setInt(++i, participanteConfigTarefaTO.getCodTipoParticipacao());
			}

			if ((participanteConfigTarefaTO.getCodUsuario() != 0)) {
				stmt.setInt(++i, participanteConfigTarefaTO.getCodUsuario());
			}
			
			result = stmt.executeQuery();
			while (result.next()) {
				participante = carregarTO(result);
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
		return participante;
	}

}
