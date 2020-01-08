

package br.com.intraBSC.persistencia.JDBC;

import br.com.intraBSC.excecoes.ExceptionPersistenciaBSC;
import br.com.intraBSC.modelo.MetaTO;
import br.com.intraBSC.persistencia.BscDaoJDBCGenerico;
import br.com.intraBSC.persistencia.MetaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;

public class MetaDAOJDBC extends BscDaoJDBCGenerico implements MetaDAO {

	private static Log log = LogFactory.getLog(MetaDAOJDBC.class);
    
    protected static final String TABELA = "TARGET";
    protected static final String ID_META = "ID";
    protected static final String ID_INDICADOR = "MEASURE_ID";
    protected static final String RESPONSAVEL = "OWNER_ID";
    protected static final String NOME_META = "NAME";
    protected static final String DESCRICAO = "DESCRIPTION";
    protected static final String ATIVO = "ACTIVE";
    protected static final String LIMITE_SUPERIOR = "TARGETVALUEUP";
    protected static final String LIMITE_INFERIOR = "TARGETVALUEDOWN";
    protected static final String INVERTER = "INVERT";
	
	public MetaDAOJDBC(DaoManager daoManager) {
		super(daoManager);	
	}
	
	private Connection getconexao(){
		return getConnection();			
	}

	public void incluir(MetaTO metaTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer("INSERT INTO ");
		sql.append(TABELA + "(");
		sql.append(ID_META + ", ");
		sql.append(NOME_META + ", ");
		sql.append(DESCRICAO + ", ");
		sql.append(ID_INDICADOR + ", ");
		sql.append(LIMITE_INFERIOR + ", ");
		sql.append(LIMITE_SUPERIOR + ", ");
		if (metaTO.getResponsavel() != 0){
			sql.append(RESPONSAVEL + ", ");
		}
		sql.append(ATIVO + ", ");
		sql.append(INVERTER);
		sql.append(") VALUES (?,?,?,?,?,?,");
		if (metaTO.getResponsavel() != 0){
			sql.append("?,");
		}
		sql.append("?,?)");
      
		PreparedStatement stmt;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			int i = 0;
			if (metaTO.getId() != 0){
				stmt.setInt(++i,metaTO.getId());
			}
			if ((metaTO.getNome() != null) && (!metaTO.getNome().equals("")) ){
				stmt.setString(++i,metaTO.getNome());
			}
			if ((metaTO.getDescricao() != null) && (!metaTO.getDescricao().equals("")) ){
				stmt.setString(++i,metaTO.getDescricao());
			}
			if (metaTO.getIdIndicador() != 0){
				stmt.setInt(++i,metaTO.getIdIndicador());
			}
			if (metaTO.getLimiteInferior() != 0){
				stmt.setDouble(++i,metaTO.getLimiteInferior());
			}
			if (metaTO.getLimiteSuperior() != 0){
				stmt.setDouble(++i,metaTO.getLimiteSuperior());
			}
			if (metaTO.getResponsavel() != 0){
				stmt.setDouble(++i,metaTO.getResponsavel());
			}
			if ((metaTO.getAtivo() != null) && (!metaTO.getAtivo().equals("")) ){
				stmt.setString(++i,metaTO.getAtivo());
			}
			if ((metaTO.getInversaoSinal() != 0)){
				stmt.setInt(++i,metaTO.getInversaoSinal());
			}			
			stmt.executeUpdate();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DaoException(e.getMessage());
		}
		
	}

	public void excluir(MetaTO metaTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer("DELETE FROM ");
		sql.append(TABELA);
		sql.append(" WHERE 1=1 ");
		
		if (metaTO.getId() != 0){
			sql.append(" AND " + ID_META + " =? ");
		}
        
		PreparedStatement stmt;
		try {
			int i = 0;
			stmt = getconexao().prepareStatement(sql.toString());
			if (metaTO.getId() != 0){
				stmt.setInt(++i,metaTO.getId());
			}
			stmt.executeUpdate();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DaoException(e.getMessage());
		}
		
	}

	public void alterar(MetaTO metaTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer("UPDATE ");
		sql.append(TABELA + " SET ");		
		
		sql.append(NOME_META + " = ?, ");
		sql.append(DESCRICAO + " = ?, ");		
		sql.append(LIMITE_INFERIOR + " = ?, ");
		sql.append(LIMITE_SUPERIOR + " = ?, ");
		sql.append(RESPONSAVEL + " = ?, ");
		sql.append(ATIVO + " = ?, ");
		sql.append(INVERTER + " = ? ");
		sql.append(" WHERE 1=1 ");
		sql.append("AND " + ID_META + " = ? ");

		PreparedStatement stmt;
		try {
			int i = 0;
			stmt = getconexao().prepareStatement(sql.toString());
			
			if ((metaTO.getNome() != null) && (!metaTO.getNome().equals("")) ){
				stmt.setString(++i,metaTO.getNome());
			}
			if ((metaTO.getDescricao() != null) && (!metaTO.getDescricao().equals("")) ){
				stmt.setString(++i,metaTO.getDescricao());
			}
			if (metaTO.getLimiteInferior() != 0){
				stmt.setDouble(++i,metaTO.getLimiteInferior());
			}
			if (metaTO.getLimiteSuperior() != 0){
				stmt.setDouble(++i,metaTO.getLimiteSuperior());
			}
			if (metaTO.getResponsavel() != 0){
				stmt.setInt(++i,metaTO.getResponsavel());
			}
			if ((metaTO.getAtivo() != null) && (!metaTO.getAtivo().equals("")) ){
				stmt.setString(++i,metaTO.getAtivo());
			}
			if ((metaTO.getInversaoSinal() != 0)){
				stmt.setInt(++i,metaTO.getInversaoSinal());
			}
			if (metaTO.getId() != 0){
				stmt.setInt(++i,metaTO.getId());
			}
			
			stmt.executeUpdate();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DaoException(e.getMessage());
		}
		
	}

	public MetaTO consultarUm(MetaTO metaTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("A." + ID_META + ", ");
		sql.append("A." + NOME_META + ", ");
		sql.append("A." + ID_INDICADOR + ", ");
		sql.append("A." + RESPONSAVEL + ", ");
		sql.append("A." + DESCRICAO + ", ");
		sql.append("A." + LIMITE_SUPERIOR + ", ");
		sql.append("A." + LIMITE_INFERIOR + ", ");
		sql.append("A." + ATIVO + ", ");
		sql.append("A." + INVERTER + " ");
		sql.append("FROM " + TABELA + " A ");
		sql.append("WHERE 1=1 ");
		
		if (metaTO.getId() != 0){
			sql.append(" AND A." + ID_META + " =? ");
		}
		if ((metaTO.getNome() != null) && (!metaTO.getNome().equals("")) ){
			sql.append(" AND UCASE(A." + NOME_META + ") LIKE ? ");
		}
		if (metaTO.getIdIndicador() != 0){
			sql.append(" AND A." + ID_INDICADOR + " =? ");
		}
		if (metaTO.getResponsavel() != 0){
			sql.append(" AND A." + RESPONSAVEL + " =? ");
		}
		if (metaTO.getLimiteSuperior() != 0.0){
			sql.append(" AND A." + LIMITE_SUPERIOR + " =? ");
		}
		if (metaTO.getLimiteInferior() != 0){
			sql.append(" AND A." + LIMITE_INFERIOR + " =? ");
		}
		if ((metaTO.getAtivo() != null) && (!metaTO.getAtivo().equals("")) ){
			sql.append(" AND A." + ATIVO + " = ? ");
		}
		if ((metaTO.getInversaoSinal() != 0) ){
			sql.append(" AND A." + INVERTER + " =? ");
		}
		PreparedStatement stmt;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			int i = 0;
			
			if (metaTO.getId() != 0){
				stmt.setInt(++i,metaTO.getId());
			}
			if (metaTO.getIdIndicador() != 0){
				stmt.setInt(++i,metaTO.getIdIndicador());
			}
			if ((metaTO.getAtivo() != null) && (!metaTO.getAtivo().equals("")) ){
				stmt.setString(++i,metaTO.getAtivo());
			}
			ResultSet resultado = stmt.executeQuery();
			MetaTO retorno = new MetaTO();
			while (resultado.next()) {
				retorno = carregaTO(resultado);
			}
			return retorno;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DaoException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public Collection consultarVarios(MetaTO metaTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("A." + ID_META + ", ");
		sql.append("A." + NOME_META + ", ");
		sql.append("A." + ID_INDICADOR + ", ");
		sql.append("A." + RESPONSAVEL + ", ");
		sql.append("A." + DESCRICAO + ", ");
		sql.append("A." + LIMITE_SUPERIOR + ", ");
		sql.append("A." + LIMITE_INFERIOR + ", ");
		sql.append("A." + ATIVO + ", ");
		sql.append("A." + INVERTER + " ");
		sql.append("FROM " + TABELA + " A ");
		sql.append("WHERE 1=1 ");
		
		if (metaTO.getId() != 0){
			sql.append(" AND A." + ID_META + " =? ");
		}
		if ((metaTO.getNome() != null) && (!metaTO.getNome().equals("")) ){
			sql.append(" AND UCASE(A." + NOME_META + ") LIKE ? ");
		}
		if (metaTO.getIdIndicador() != 0){
			sql.append(" AND A." + ID_INDICADOR + " =? ");
		}
		if (metaTO.getResponsavel() != 0){
			sql.append(" AND A." + RESPONSAVEL + " =? ");
		}
		if (metaTO.getLimiteSuperior() != 0.0){
			sql.append(" AND A." + LIMITE_SUPERIOR + " =? ");
		}
		if (metaTO.getLimiteInferior() != 0){
			sql.append(" AND A." + LIMITE_INFERIOR + " =? ");
		}
		if ((metaTO.getAtivo() != null) && (!metaTO.getAtivo().equals("")) ){
			sql.append(" AND A." + ATIVO + " = ? ");
		}
		if ((metaTO.getInversaoSinal() != 0)){
			sql.append(" AND A." + INVERTER + " =? ");
		}
		PreparedStatement stmt;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			int i = 0;
			
			if (metaTO.getId() != 0){
				stmt.setInt(++i,metaTO.getId());
			}
			if ((metaTO.getNome() != null) && (!metaTO.getNome().equals("")) ){
				stmt.setString(++i,"%"+metaTO.getNome().toUpperCase() +"%");
			}
			if (metaTO.getIdIndicador() != 0){
				stmt.setInt(++i,metaTO.getIdIndicador());
			}
			if (metaTO.getResponsavel() != 0){
				stmt.setInt(++i,metaTO.getResponsavel());
			}
			if ((metaTO.getAtivo() != null) && (!metaTO.getAtivo().equals("")) ){
				stmt.setString(++i,metaTO.getAtivo());
			}
			ResultSet resultado = stmt.executeQuery();
			Collection retorno = new ArrayList();
			while (resultado.next()) {
				retorno.add(carregaTO(resultado));
			}
			return retorno;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DaoException(e.getMessage());
		}
	}

	private MetaTO carregaTO(ResultSet resultado) throws SQLException{
		MetaTO metaTO = new MetaTO();
		int i = 0;
		metaTO.setId(resultado.getInt(++i));
		metaTO.setNome(resultado.getString(++i));
		metaTO.setIdIndicador(resultado.getInt(++i));		
		metaTO.setResponsavel(resultado.getInt(++i));
		metaTO.setDescricao(resultado.getString(++i));
		metaTO.setLimiteSuperior(resultado.getDouble(++i));
		metaTO.setLimiteInferior(resultado.getDouble(++i));
		metaTO.setAtivo(resultado.getString(++i));
		metaTO.setInversaoSinal(resultado.getInt(++i));
					
		return metaTO;
	}

	
	public int consultarMax(MetaTO metaTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer("SELECT MAX(");
		sql.append(ID_META);
		sql.append(") AS ");
		sql.append(ID_META);
		sql.append(" FROM ");
		sql.append(TABELA);
		PreparedStatement stmt;
		ResultSet result;		
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			result = stmt.executeQuery();
			while (result.next()) {
				return result.getInt(ID_META) + 1;
			}			
		} 
		catch (SQLException e) {
		    log.error(e.getMessage());
			throw new ExceptionPersistenciaBSC(e.getMessage());
		}		
		return 0;
	}

}
