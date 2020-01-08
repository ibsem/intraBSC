
package br.com.intraPRO.persistencia.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.intraBSC.persistencia.BscDaoJDBCGenerico;
import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.ParticipanteTO;
import br.com.intraPRO.persistencia.ParticipanteDAO;

import java.sql.Connection;

import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;


public class ParticipanteDAOImpl extends BscDaoJDBCGenerico implements ParticipanteDAO {
	
	protected final static String TABELA = "TASKACTOR";
	protected final static String ANO_CRIACAO = "PK_YEAR_START_TASK";
	protected final static String NUMERO_SEQUENCIAL_TAREFA = "PK_NUMBER_SEQUENCE_TASK";
	protected final static String CODIGO = "NR_SEQL_ACTOR_TASK";
	protected final static String COD_TIPO_PARTICIPACAO = "ID_TYPE_PRTC";
	protected final static String COD_PAPEL = "FK_ROLE";
	protected final static String COD_NIVEL = "FK_NVL_RSPB_FUNL";

	protected final static String COD_USUARIO = "FK_ACTOR";


	private static Log log = LogFactory.getLog(ParticipanteDAOImpl.class);

	public ParticipanteDAOImpl(DaoManager daoManager) {
		super(daoManager);
	}


	private ParticipanteTO carregarTO(ResultSet resultado) throws SQLException {
		ParticipanteTO participanteTO = new ParticipanteTO();
		participanteTO.setAnoCriacao(resultado.getInt(1));		
		participanteTO.setCodTarefa(resultado.getInt(2));
		participanteTO.setCodigo(resultado.getInt(3));
		participanteTO.setCodTipoParticipacao(resultado.getInt(4));
		participanteTO.setCodPapel(resultado.getInt(5));
		participanteTO.setCodUsuario(resultado.getInt(6));
		return participanteTO;
	}

	
	public void incluir(ParticipanteTO participanteTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("INSERT INTO ");
		sql.append(TABELA);
		sql.append(" (");
		
		 if(participanteTO.getAnoCriacao()!=0){
			 sql.append(ANO_CRIACAO + ", ");
		 }
		 if(participanteTO.getCodTarefa()!=0){
			 sql.append(NUMERO_SEQUENCIAL_TAREFA + ", ");
		 }
		 if(participanteTO.getCodigo()!=0){
			 sql.append(CODIGO + ", ");
		 }
		 if(participanteTO.getCodTipoParticipacao()!=0){
			 sql.append(COD_TIPO_PARTICIPACAO + ", ");
		 }
		 if(participanteTO.getCodPapel()!=0){
			 sql.append(COD_PAPEL + ", ");
		 }
		 if(participanteTO.getCodNivel()!=0){
			 sql.append(COD_NIVEL + ", ");
		 }
		 if(participanteTO.getCodUsuario()!=0){
			 sql.append(COD_USUARIO);
		 }else {
	            sql.delete(sql.length() - 2, sql.length());
	        }
		 
		sql.append(") VALUES (");
		
		 if(participanteTO.getAnoCriacao()!=0){
			 sql.append(" ?, ");
		 }
		 if(participanteTO.getCodTarefa()!=0){
			 sql.append(" ?, ");
		 }
		 if(participanteTO.getCodigo()!=0){
			 sql.append(" ?, ");
		 }
		 if(participanteTO.getCodTipoParticipacao()!=0){
			 sql.append(" ?, ");
		 }
		 if(participanteTO.getCodPapel()!=0){
			 sql.append(" ?, ");
		 }
		 if(participanteTO.getCodNivel()!=0){
			 sql.append(" ?, ");
		 }
		 if((participanteTO.getCodUsuario()!=0) ){
			sql.append(" ?");
		 }else {
	            sql.delete(sql.length() - 2, sql.length());
	     }
		 sql.append(")");
		PreparedStatement stmt;

		try {
			int i = 0;
			stmt = getConnection().prepareStatement(sql.toString());
			 if(participanteTO.getAnoCriacao()!=0){
				 stmt.setInt(++i, participanteTO.getAnoCriacao());
			 }
			 if(participanteTO.getCodTarefa()!=0){
				 stmt.setInt(++i, participanteTO.getCodTarefa());
			 }
			 if(participanteTO.getCodigo()!=0){
				 stmt.setInt(++i, participanteTO.getCodigo());
			 }
			 if(participanteTO.getCodTipoParticipacao()!=0){
				 stmt.setInt(++i, participanteTO.getCodTipoParticipacao());
			 }
			 if(participanteTO.getCodPapel()!=0){
				 stmt.setInt(++i, participanteTO.getCodPapel());
			 }
			 if(participanteTO.getCodNivel()!=0){
				 stmt.setInt(++i, participanteTO.getCodNivel());
			 }
			 if((participanteTO.getCodUsuario()!=0)){
				 stmt.setInt(++i, participanteTO.getCodUsuario());
			 }
			stmt.executeUpdate();
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
	}


	
	@SuppressWarnings("unchecked")
	public Collection consultarVarios(ParticipanteTO participanteTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("SELECT ");
		sql.append(ANO_CRIACAO + ", ");
		sql.append(NUMERO_SEQUENCIAL_TAREFA + ", ");
		sql.append(CODIGO + ", ");
		sql.append(COD_TIPO_PARTICIPACAO + ", ");
		sql.append(COD_PAPEL + ", ");
		sql.append(COD_USUARIO );
		sql.append(" FROM " + TABELA + " A ");
		sql.append("WHERE 1=1 ");
		if (participanteTO.getAnoCriacao() != 0) {
			sql.append("AND A." + ANO_CRIACAO + "=? ");
		}

		if (participanteTO.getCodTarefa() != 0) {
			sql.append("AND A." + NUMERO_SEQUENCIAL_TAREFA + "=? ");
		}

		if (participanteTO.getCodigo() != 0) {
			sql.append("AND A." + CODIGO + "=? ");
		}

		if (participanteTO.getCodTipoParticipacao() != 0) {
			sql.append("AND A." + COD_TIPO_PARTICIPACAO + "=? ");
		}

		if ((participanteTO.getCodUsuario() != 0) ) {
			sql.append("AND A." + COD_USUARIO + "=? ");
		}
		sql.append(" ORDER BY " + COD_TIPO_PARTICIPACAO);
		PreparedStatement stmt;
		ResultSet result;
		Collection listaParticipacao = new ArrayList();
		int i = 0;
		try {
			stmt = getConnection().prepareStatement(sql.toString());
			if (participanteTO.getAnoCriacao() != 0) {
				stmt.setInt(++i, participanteTO.getAnoCriacao());
			}

			if (participanteTO.getCodTarefa() != 0) {
				stmt.setInt(++i, participanteTO.getCodTarefa());
			}

			if (participanteTO.getCodigo() != 0) {
				stmt.setInt(++i, participanteTO.getCodigo());
			}

			if (participanteTO.getCodTipoParticipacao() != 0) {
				stmt.setInt(++i, participanteTO.getCodTipoParticipacao());
			}

			if ((participanteTO.getCodUsuario() != 0) ) {
				stmt.setInt(++i, participanteTO.getCodUsuario());
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

	

	private Connection getConexao(){
		return getConnection();
	}

	public int consultarMax() throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("SELECT MAX(");
		sql.append(CODIGO);
		sql.append(") AS ");
		sql.append(CODIGO);
		sql.append(" FROM ");
		sql.append(TABELA);
		sql.append(" WHERE 1=1");

		PreparedStatement stmt;
		ResultSet result;
		try {
			stmt = getConexao().prepareStatement(sql.toString());
			result = stmt.executeQuery();
			while (result.next()) {
				return result.getInt(CODIGO) + 1;
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
		return 0;
	}

	
	public void excluir(ParticipanteTO participanteTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("DELETE ");

		sql.append(" FROM " + TABELA );
		sql.append(" WHERE 1=1 ");
		if (participanteTO.getAnoCriacao() != 0) {
			sql.append(" AND " + ANO_CRIACAO + "=?");
		}

		if (participanteTO.getCodTarefa() != 0) {
			sql.append(" AND " + NUMERO_SEQUENCIAL_TAREFA + "=?");
		}

		if (participanteTO.getCodigo() != 0) {
			sql.append(" AND " + CODIGO + "=?");
		}

		if (participanteTO.getCodTipoParticipacao() != 0) {
			sql.append(" AND " + COD_TIPO_PARTICIPACAO + "=?");
		}


		if ((participanteTO.getCodUsuario() != 0) ) {
			sql.append(" AND " + COD_USUARIO + "=?");
		}

		PreparedStatement stmt;

		int i = 0;
		try {
			stmt = getConnection().prepareStatement(sql.toString());
			if (participanteTO.getAnoCriacao() != 0) {
				stmt.setInt(++i, participanteTO.getAnoCriacao());
			}

			if (participanteTO.getCodTarefa() != 0) {
				stmt.setInt(++i, participanteTO.getCodTarefa());
			}

			if (participanteTO.getCodigo() != 0) {
				stmt.setInt(++i, participanteTO.getCodigo());
			}

			if (participanteTO.getCodTipoParticipacao() != 0) {
				stmt.setInt(++i, participanteTO.getCodTipoParticipacao());
			}

			if ((participanteTO.getCodUsuario() != 0)) {
				stmt.setInt(++i, participanteTO.getCodUsuario());
			}
			stmt.executeUpdate();
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}

	}

	
	public ParticipanteTO consultarUm(ParticipanteTO participanteTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("SELECT ");
		sql.append(ANO_CRIACAO + ", ");
		sql.append(NUMERO_SEQUENCIAL_TAREFA + ", ");
		sql.append(CODIGO + ", ");
		sql.append(COD_TIPO_PARTICIPACAO + ", ");
		sql.append(COD_PAPEL + ", ");
		sql.append(COD_USUARIO);
		sql.append(" FROM " + TABELA + " A ");
		sql.append("WHERE 1=1 ");
		if (participanteTO.getAnoCriacao() != 0) {
			sql.append(" AND A." + ANO_CRIACAO + "=?");
		}

		if (participanteTO.getCodTarefa() != 0) {
			sql.append(" AND A." + NUMERO_SEQUENCIAL_TAREFA + "=?");
		}

		if (participanteTO.getCodigo() != 0) {
			sql.append(" AND A." + CODIGO + "=?");
		}

		if (participanteTO.getCodTipoParticipacao() != 0) {
			sql.append(" AND A." + COD_TIPO_PARTICIPACAO + "=?");
		}

		if ((participanteTO.getCodUsuario() != 0)) {
			sql.append(" AND A." + COD_USUARIO + "=?");
		}
		sql.append(" ORDER BY " + COD_TIPO_PARTICIPACAO);
		PreparedStatement stmt;
		ResultSet result;
		ParticipanteTO participante = new ParticipanteTO();
		int i = 0;
		try {
			stmt = getConnection().prepareStatement(sql.toString());
			if (participanteTO.getAnoCriacao() != 0) {
				stmt.setInt(++i, participanteTO.getAnoCriacao());
			}

			if (participanteTO.getCodTarefa() != 0) {
				stmt.setInt(++i, participanteTO.getCodTarefa());
			}

			if (participanteTO.getCodigo() != 0) {
				stmt.setInt(++i, participanteTO.getCodigo());
			}

			if (participanteTO.getCodTipoParticipacao() != 0) {
				stmt.setInt(++i, participanteTO.getCodTipoParticipacao());
			}


			if ((participanteTO.getCodUsuario() != 0)) {
				stmt.setInt(++i, participanteTO.getCodUsuario());
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
	
	public void alterar(ParticipanteTO participanteTO) throws ExceptionPersistenciaPRO {
        StringBuffer sql = new StringBuffer("UPDATE ");
        sql.append(TABELA + " SET ");
        sql.append( COD_NIVEL + " = ? ");
        sql.append(" WHERE 1=1 ");
        sql.append("AND " + NUMERO_SEQUENCIAL_TAREFA  + " = ? ");
        sql.append("AND " + ANO_CRIACAO  + " = ? ");
        if (participanteTO.getCodUsuario() != 0)
        	sql.append("AND " + COD_USUARIO  + " = ? ");
        PreparedStatement stmt;
        try {
            stmt = getConexao().prepareStatement(sql.toString());
	        int i = 0;
	        
	        if (participanteTO.getCodNivel() != 0){
	            stmt.setInt(++i,participanteTO.getCodNivel());
	        }
	        
	        if (participanteTO.getCodTarefa() != 0){
	            stmt.setInt(++i,participanteTO.getCodTarefa());
	        }
	        if (participanteTO.getAnoCriacao() != 0){
	            stmt.setInt(++i,participanteTO.getAnoCriacao());
	        }
	        if (participanteTO.getCodUsuario() != 0)
	        	stmt.setInt(++i,participanteTO.getCodUsuario());
            stmt.executeUpdate();
         } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
         }
    }
	
}
