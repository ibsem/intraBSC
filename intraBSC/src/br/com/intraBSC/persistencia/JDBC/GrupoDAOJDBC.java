package br.com.intraBSC.persistencia.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;

import br.com.intraBSC.excecoes.ExceptionPersistenciaBSC;
import br.com.intraBSC.modelo.GrupoTO;
import br.com.intraBSC.persistencia.BscDaoJDBCGenerico;
import br.com.intraBSC.persistencia.GrupoDAO;

public class GrupoDAOJDBC  extends BscDaoJDBCGenerico implements GrupoDAO{

	 public GrupoDAOJDBC(DaoManager daoManager) {
		super(daoManager);		
	}

	private static Log log = LogFactory.getLog(GrupoDAOJDBC.class);

    protected static final String TABELA = "GROUPOWNER";
    protected static final String CODIGO = "ID_GROUP";
    protected static final String DESCRICAO = "DESCRIPTION";
    protected static final String ATIVO = "ACTIVE";
    protected static final String DATE_USO = "DATE_USE";

    private Connection getconexao(){
        return getConnection();
    }
	    
	@SuppressWarnings("unchecked")
	public Collection consultarVarios(GrupoTO grupoTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + CODIGO + ", ");
        sql.append("A." + DESCRICAO + ", ");
        sql.append("A." + ATIVO + ", ");
        sql.append("A." + DATE_USO + " ");
        sql.append("FROM " + TABELA + " A ");
        sql.append("WHERE 1=1 ");

        if (grupoTO.getCodigo() != 0){
            sql.append(" AND A." + CODIGO + " =? ");
        }
        if ((grupoTO.getDescricao() != null) && (!grupoTO.getDescricao().equals("")) ){
            sql.append(" AND UCASE(A." + DESCRICAO + ") LIKE ? ");
        }
        if (grupoTO.getAtivo() != 0){
            sql.append(" AND A." + ATIVO + " =? ");
        }
        if (grupoTO.getDataUso() != null){
            sql.append(" AND A." + DATE_USO + " =? ");
        }
        sql.append("ORDER BY " + DESCRICAO );
        
        PreparedStatement stmt;
        try {
        	stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        if (grupoTO.getCodigo() != 0){
	            stmt.setInt(++i,grupoTO.getCodigo());
	        }
	        if ((grupoTO.getDescricao() != null) && (!grupoTO.getDescricao().equals("")) ){
	           stmt.setString(++i,"%"+ grupoTO.getDescricao()+"%");
	        }
	        if (grupoTO.getAtivo() != 0){
	        	stmt.setInt(++i,grupoTO.getAtivo());
	        }
	        if (grupoTO.getDataUso() != null){
	        	stmt.setDate(++i,grupoTO.getDataUso());
	        }

             ResultSet resultado = stmt.executeQuery();
             GrupoTO retorno = new GrupoTO();
             Collection lista = new ArrayList();
             while (resultado.next()) {
                  retorno = carregaTO(resultado);
                  lista.add(retorno);
             }
             return lista;
        } catch (Exception e) {
              log.error(e.getMessage());
              throw new DaoException(e.getMessage());
        }
	}

	public GrupoTO consultarUm(GrupoTO grupoTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + CODIGO + ", ");
        sql.append("A." + DESCRICAO + ", ");
        sql.append("A." + ATIVO + ", ");
        sql.append("A." + DATE_USO + " ");
        sql.append("FROM " + TABELA + " A ");
        sql.append("WHERE 1=1 ");

        if (grupoTO.getCodigo() != 0){
            sql.append(" AND A." + CODIGO + " =? ");
        }
        if ((grupoTO.getDescricao() != null) && (!grupoTO.getDescricao().equals("")) ){
            sql.append(" AND UCASE(A." + DESCRICAO + ") LIKE ? ");
        }
        if (grupoTO.getAtivo() != 0){
            sql.append(" AND A." + ATIVO + " =? ");
        }
        if (grupoTO.getDataUso() != null){
            sql.append(" AND A." + DATE_USO + " =? ");
        }
        PreparedStatement stmt;
        try {
			 stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        if (grupoTO.getCodigo() != 0){
	            stmt.setInt(++i,grupoTO.getCodigo());
	        }
	        if ((grupoTO.getDescricao() != null) && (!grupoTO.getDescricao().equals("")) ){
	           stmt.setString(++i,"%"+ grupoTO.getDescricao()+"%");
	        }
	        if (grupoTO.getAtivo() != 0){
	        	stmt.setInt(++i,grupoTO.getAtivo());
	        }
	        if (grupoTO.getDataUso() != null){
	        	stmt.setDate(++i,grupoTO.getDataUso());
	        }
             ResultSet resultado = stmt.executeQuery();
             GrupoTO retorno = new GrupoTO();
             while (resultado.next()) {
                  retorno = carregaTO(resultado);
             }
             return retorno;
        } catch (Exception e) {
              log.error(e.getMessage());
              throw new DaoException(e.getMessage());
        }
	}

	public void incluir(GrupoTO grupoTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer("INSERT INTO ");
        sql.append(TABELA + "(");
        sql.append( CODIGO+", ");
        sql.append( DESCRICAO+", ");
        sql.append( ATIVO+", ");
        sql.append( DATE_USO+" ");
        sql.append(") VALUES (?,?,?,?)");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        if (grupoTO.getCodigo() != 0){
	            stmt.setInt(++i,grupoTO.getCodigo());
	        }
	        if ((grupoTO.getDescricao() != null) && (!grupoTO.getDescricao().equals("")) ){
	           stmt.setString(++i,grupoTO.getDescricao());
	        }
	        if (grupoTO.getAtivo() != 0){
	        	stmt.setInt(++i,grupoTO.getAtivo());
	        }
	        
	        stmt.setDate(++i,grupoTO.getDataUso());
	        
            stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
	}

	public void alterar(GrupoTO grupoTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer("UPDATE ");
        sql.append(TABELA + " SET ");
        sql.append( DESCRICAO + " = ?, ");
        sql.append( ATIVO + " = ?, ");
        sql.append( DATE_USO + " = ? ");
        sql.append(" WHERE 1=1 ");
        sql.append("AND " + CODIGO  + " = ? ");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        if ((grupoTO.getDescricao() != null) && (!grupoTO.getDescricao().equals("")) ){
	           stmt.setString(++i,grupoTO.getDescricao());
	        }
	        if (grupoTO.getAtivo() != 0){
	        	stmt.setInt(++i,grupoTO.getAtivo());
	        }
	        
	        if ((grupoTO.getDataUso() != null) && (!grupoTO.getDataUso().equals("")))
	        	stmt.setDate(++i,grupoTO.getDataUso());
	        else{
	        	grupoTO.setDataUso(null);
	        	stmt.setDate(++i,grupoTO.getDataUso());
	        }
	        if (grupoTO.getCodigo() != 0){
	            stmt.setInt(++i,grupoTO.getCodigo());
	        }
	        
	        stmt.executeUpdate();
	     } catch (Exception e) {
	        log.error(e.getMessage());
	        throw new DaoException(e.getMessage());
	     }
	}
	private GrupoTO carregaTO(ResultSet resultado) throws SQLException, ParseException{
        GrupoTO grupoTO = new GrupoTO();
        int i = 0;
        grupoTO.setCodigo(resultado.getInt(++i));
        grupoTO.setDescricao(resultado.getString(++i));
        grupoTO.setAtivo(resultado.getInt(++i));
        grupoTO.setDataUso(resultado.getDate(++i));
        return grupoTO;
    }
	
	public int consultarMax(GrupoTO grupoTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer("SELECT MAX(");
		sql.append(CODIGO);
		sql.append(") AS ");
		sql.append(CODIGO);
		sql.append(" FROM ");
		sql.append(TABELA);
		PreparedStatement stmt;
		ResultSet result;		
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			result = stmt.executeQuery();
			while (result.next()) {
				return result.getInt(CODIGO) + 1;
			}			
		} 
		catch (SQLException e) {
		    log.error(e.getMessage());
			throw new ExceptionPersistenciaBSC(e.getMessage());
		}		
		return 0;
	}
}
