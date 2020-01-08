
package br.com.intraPRO.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.intraBSC.persistencia.BscDaoJDBCGenerico;
import br.com.intraBSC.util.DataUtil;
import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.AnotacaoTarefaTO;
import br.com.intraPRO.persistencia.AnotacaoTarefaDAO;

import com.ibatis.dao.client.DaoManager;

/**
 * Classe que implementa os SQL referentes a Anotacao de tarefa
 */
public class AnotacaoTarefaDAOImpl extends BscDaoJDBCGenerico implements AnotacaoTarefaDAO{
	

	protected final static String TABELA = "TASKEVENTDESCRIPTION";
	protected final static String ANO_CRIACAO = "PK_YEAR_START_TASK";	
	protected final static String CODIGO_TAREFA = "PK_NUMBER_SEQUENCE_TASK";
	protected final static String TS_EVENTO_ANOTACAO = "PK_TS_TASKEVENTDESCRIPTION";
	protected final static String CODIGO_TIPO_ANOTACAO = "FK_MODEL_EVENT_DESCRIPTION";
	protected final static String CODIGO_TIPO_TAREFA = "PK_CONFIGTASK";
	protected final static String NUMERO_ORDEM_ETAPA = "NUMBER_ORDER_PHASE";
	protected final static String CODIGO_USUARIO = "FK_ACTOR";
	protected final static String TEXTO_ANOTACAO = "TX_TASKEVENTDESCRIPTION";
	
	
	private static Log log = LogFactory.getLog(AnotacaoTarefaDAOImpl.class);
	
	
   public AnotacaoTarefaDAOImpl(DaoManager daoManager){
   		super(daoManager);
   }

 
	public void incluir(AnotacaoTarefaTO anotacaoTarefaTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("INSERT INTO ");
		sql.append(TABELA + "(");
		if (anotacaoTarefaTO.getAnoCriacao() != 0){
			sql.append(ANO_CRIACAO + ", ");
		}
		if (anotacaoTarefaTO.getCodTarefa() != 0){
			sql.append(CODIGO_TAREFA + ", ");
		}
		//tipo de comparação para valores difeirentes de inteiro
		if (anotacaoTarefaTO.getTsAnotacao() != null && (!anotacaoTarefaTO.getTsAnotacao().equals(""))){
			sql.append(TS_EVENTO_ANOTACAO + ", ");
		}
		if(anotacaoTarefaTO.getCodTipoAnotacao() != 0){
			sql.append(CODIGO_TIPO_ANOTACAO + ", ");
		}
		if(anotacaoTarefaTO.getCodConfigTarefa() != 0){
			sql.append(CODIGO_TIPO_TAREFA + ", ");
		}
		if(anotacaoTarefaTO.getNumeroOrdemEtapa() != 0){
			sql.append(NUMERO_ORDEM_ETAPA + ", ");
		}
		if(anotacaoTarefaTO.getCodUsuario() != 0 ){
			sql.append(CODIGO_USUARIO + ", ");
		}
		if(anotacaoTarefaTO.getTextoAnotacao() != null && (!anotacaoTarefaTO.getTextoAnotacao().equals(""))){
			sql.append(TEXTO_ANOTACAO);
		}
		
		sql.append(") VALUES(");
		
		if (anotacaoTarefaTO.getAnoCriacao() != 0){
			sql.append("?");
		}
		if (anotacaoTarefaTO.getCodTarefa() != 0){
			sql.append(" ,?");
		}
		//tipo de comparação para valores difeirentes de inteiro
		if (anotacaoTarefaTO.getTsAnotacao() != null && (!anotacaoTarefaTO.getTsAnotacao().equals(""))){
			sql.append(" ,?");
		}
		if(anotacaoTarefaTO.getCodTipoAnotacao() != 0){
			sql.append(" ,?");
		}
		if(anotacaoTarefaTO.getCodConfigTarefa() != 0){
			sql.append(" ,?");
		}
		if(anotacaoTarefaTO.getNumeroOrdemEtapa() != 0){
			sql.append(" ,?");
		}
		if(anotacaoTarefaTO.getCodUsuario() != 0){
			sql.append(" ,?");
		}
		if(anotacaoTarefaTO.getTextoAnotacao() != null && (!anotacaoTarefaTO.getTextoAnotacao().equals(""))){
			sql.append(" ,?");
		}
		
		sql.append(")");
		PreparedStatement stmt;
		try {
			int i = 0;
			stmt = getConnection().prepareStatement(sql.toString());

			if(anotacaoTarefaTO.getAnoCriacao() != 0){
				stmt.setInt(++i, anotacaoTarefaTO.getAnoCriacao());
			}
			if(anotacaoTarefaTO.getCodTarefa() != 0){
				stmt.setInt(++i, anotacaoTarefaTO.getCodTarefa());
			}
			if(anotacaoTarefaTO.getTsAnotacao() != null && (!anotacaoTarefaTO.getTsAnotacao().equals(""))){
				stmt.setTimestamp(++i, anotacaoTarefaTO.getTsAnotacao());
			}
			if(anotacaoTarefaTO.getCodTipoAnotacao() != 0){
				stmt.setInt(++i, anotacaoTarefaTO.getCodTipoAnotacao());
			}
			if(anotacaoTarefaTO.getCodConfigTarefa() != 0){
				stmt.setInt(++i, anotacaoTarefaTO.getCodConfigTarefa());
			}
			if(anotacaoTarefaTO.getNumeroOrdemEtapa() != 0){
				stmt.setInt(++i, anotacaoTarefaTO.getNumeroOrdemEtapa());
			}	
			if(anotacaoTarefaTO.getCodUsuario() != 0){
				stmt.setInt(++i, anotacaoTarefaTO.getCodUsuario());
			}
			if(anotacaoTarefaTO.getTextoAnotacao() != null && (!anotacaoTarefaTO.getTextoAnotacao().equals(""))){
				stmt.setString(++i, anotacaoTarefaTO.getTextoAnotacao());
			}
			stmt.executeUpdate();
		} 
		catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
	}


	@SuppressWarnings("unchecked")
	public Collection consultarVarios(AnotacaoTarefaTO anotacaoTarefaTO) throws ExceptionPersistenciaPRO {
		
		PreparedStatement stmt;
		Collection retorno = new ArrayList();
		
		StringBuffer sql = new StringBuffer("SELECT ");
		
		sql.append(ANO_CRIACAO +", ");
		sql.append(CODIGO_TAREFA +", ");
		sql.append(TS_EVENTO_ANOTACAO +", ");
		sql.append(CODIGO_TIPO_ANOTACAO +", ");
		sql.append(NUMERO_ORDEM_ETAPA +", ");
		sql.append(CODIGO_USUARIO +", ");
		sql.append(TEXTO_ANOTACAO +", ");
		sql.append(CODIGO_TIPO_TAREFA);
		sql.append(" FROM "+ TABELA);
		sql.append(" WHERE 1=1");
		
		if(anotacaoTarefaTO.getAnoCriacao() != 0){
			sql.append(" AND "+ ANO_CRIACAO +"=? ");
		}
		
		if(anotacaoTarefaTO.getCodTarefa() != 0){
			sql.append(" AND "+ CODIGO_TAREFA +"=? ");
		}
		
		if(anotacaoTarefaTO.getCodTipoAnotacao() != 0){
			sql.append(" AND "+ CODIGO_TIPO_ANOTACAO +"=? ");
		}
		
		if(anotacaoTarefaTO.getNumeroOrdemEtapa() != 0){
			sql.append(" AND "+ NUMERO_ORDEM_ETAPA +"=? ");
		}
		
		sql.append("ORDER BY "+ CODIGO_TIPO_ANOTACAO + ", " + NUMERO_ORDEM_ETAPA + ", ");
		sql.append(TS_EVENTO_ANOTACAO + " DESC");
		
		try {
			stmt = getConexao().prepareStatement(sql.toString());
			int i = 0;
			
			if(anotacaoTarefaTO.getAnoCriacao() != 0){
				stmt.setInt(++i, anotacaoTarefaTO.getAnoCriacao());
			}
			
			if(anotacaoTarefaTO.getCodTarefa() != 0){
				stmt.setInt(++i, anotacaoTarefaTO.getCodTarefa());
			}
			
			if(anotacaoTarefaTO.getCodTipoAnotacao() != 0){
				stmt.setInt(++i, anotacaoTarefaTO.getCodTipoAnotacao());
			}
			
			if(anotacaoTarefaTO.getNumeroOrdemEtapa() != 0){
				stmt.setInt(++i, anotacaoTarefaTO.getNumeroOrdemEtapa());
			}
			
			ResultSet result = stmt.executeQuery();
			while(result.next()){
				retorno.add(getAnotacaoTO(result));
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
		return retorno;
	}

	
	private AnotacaoTarefaTO getAnotacaoTO(ResultSet result) throws ExceptionPersistenciaPRO {
		
		AnotacaoTarefaTO anotacaoTO = new AnotacaoTarefaTO();
		int i = 1;
		
		try {
			anotacaoTO.setAnoCriacao(result.getInt(i++));
			anotacaoTO.setCodTarefa(result.getInt(i++));
			anotacaoTO.setTsAnotacao(result.getTimestamp(i++));
			anotacaoTO.setCodTipoAnotacao(result.getInt(i++));
			anotacaoTO.setNumeroOrdemEtapa(result.getInt(i++));
			anotacaoTO.setCodUsuario(result.getInt(i++));
			anotacaoTO.setTextoAnotacao(result.getString(i++));
			anotacaoTO.setCodConfigTarefa(result.getInt(i++));
			anotacaoTO.setDataAnotacao(new DataUtil().getTimestampFormatoComum(anotacaoTO.getTsAnotacao()));
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
		return anotacaoTO;
	}

	private Connection getConexao(){
		return getConnection();
	}
	
	
	public AnotacaoTarefaTO consultarUltAnotacao(AnotacaoTarefaTO historicaTarefaTO) throws ExceptionPersistenciaPRO {
		try {			
			PreparedStatement stmt;
			
			StringBuffer sql = new StringBuffer("SELECT ");			
			sql.append(TEXTO_ANOTACAO + " ");			
			sql.append("FROM " + TABELA + " WHERE 1=1 AND " + CODIGO_TIPO_ANOTACAO + " = 1 ");
			
			if (historicaTarefaTO.getAnoCriacao() != 0){
				sql.append("AND " + ANO_CRIACAO + " =? ");				
			}
			if (historicaTarefaTO.getCodTarefa() != 0){
				sql.append("AND " + CODIGO_TAREFA + " =? ");				
			}
			sql.append(" ORDER BY " + TS_EVENTO_ANOTACAO + " DESC ");
			
			stmt = getConexao().prepareStatement(sql.toString());
			int i=0;
			
			if (historicaTarefaTO.getAnoCriacao() != 0){
				stmt.setInt(++i,historicaTarefaTO.getAnoCriacao());				
			}
			if (historicaTarefaTO.getCodTarefa() != 0){
				stmt.setInt(++i,historicaTarefaTO.getCodTarefa());				
			}
			ResultSet result = stmt.executeQuery();
			AnotacaoTarefaTO retornoTO = new AnotacaoTarefaTO();
			while (result.next()) {
				retornoTO.setTextoAnotacao(result.getString(1));
				break;
			}
			return retornoTO;			
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		} 		
	}

}
