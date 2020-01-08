package br.com.intraBSC.persistencia.JDBC;


import br.com.intraBSC.excecoes.ExceptionPersistenciaBSC;
import br.com.intraBSC.modelo.UnidadeTO;
import br.com.intraBSC.persistencia.BscDaoJDBCGenerico;
import br.com.intraBSC.persistencia.UnidadeDAO;

import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class UnidadeDAOJDBC extends BscDaoJDBCGenerico implements UnidadeDAO {

    private static Log log = LogFactory.getLog(UnidadeDAOJDBC.class);

    protected static final String TABELA = "UNIDADE";
    protected static final String ID = "ID";
    protected static final String NOME = "NAME";

    public UnidadeDAOJDBC(DaoManager daoManager) {
        super(daoManager);
    }

    private Connection getconexao(){
        return getConnection();
    }

    @SuppressWarnings("unchecked")
	public Collection consultarVarios(UnidadeTO unidadeTO) throws ExceptionPersistenciaBSC{
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + ID + ", ");
        sql.append("A." + NOME + " ");
        sql.append("FROM " + TABELA + " A ");
        sql.append("WHERE 1=1 ");

        if (unidadeTO.getId() != 0){
            sql.append(" AND A." + ID + " =? ");
        }
        //if ((unidadeTO.getNome() != null) && (!unidadeTO.getNome().equals("")) ){
            sql.append(" AND UCASE(A." + NOME + ") LIKE ? ");
        //}
        PreparedStatement stmt;
        try {
          stmt = getconexao().prepareStatement(sql.toString());
        int i = 0;
        if (unidadeTO.getId() != 0){
            stmt.setInt(++i,unidadeTO.getId());
        }
        //if ((unidadeTO.getNome() != null) && (!unidadeTO.getNome().equals("")) ){
           stmt.setString(++i,"%"+ unidadeTO.getNome()+"%");
        //}

             ResultSet resultado = stmt.executeQuery();
             UnidadeTO retorno = new UnidadeTO();
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


    public UnidadeTO consultarUm(UnidadeTO unidadeTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + ID + ", ");
        sql.append("A." + NOME + " ");
        sql.append("FROM " + TABELA + " A ");
        sql.append("WHERE 1=1 ");

        if (unidadeTO.getId() != 0){
            sql.append(" AND A." + ID + " =? ");
        }
        if ((unidadeTO.getNome() != null) && (!unidadeTO.getNome().equals("")) ){
            sql.append(" AND UCASE(A." + NOME + ") LIKE ? ");
        }
        PreparedStatement stmt;
        try {
			 stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        if (unidadeTO.getId() != 0){
	            stmt.setInt(++i,unidadeTO.getId());
	        }
	        if ((unidadeTO.getNome() != null) && (!unidadeTO.getNome().equals("")) ){
	           stmt.setString(++i,"%"+ unidadeTO.getNome()+"%");
	        }

             ResultSet resultado = stmt.executeQuery();
             UnidadeTO retorno = new UnidadeTO();
             while (resultado.next()) {
                  retorno = carregaTO(resultado);
             }
             return retorno;
        } catch (Exception e) {
              log.error(e.getMessage());
              throw new DaoException(e.getMessage());
        }
    }


    public void incluir(UnidadeTO unidadeTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("INSERT INTO ");
        sql.append(TABELA + "(");
        sql.append( ID+", ");
        sql.append( NOME+" ");
        sql.append(") VALUES (?,?)");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
        int i = 0;
        if (unidadeTO.getId() != 0){
            stmt.setInt(++i,unidadeTO.getId());
        }
        if ((unidadeTO.getNome() != null) && (!unidadeTO.getNome().equals("")) ){
           stmt.setString(++i,unidadeTO.getNome());
        }

            stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }


    public void alterar(UnidadeTO unidadeTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("UPDATE ");
        sql.append(TABELA + " SET ");
        sql.append( NOME + " = ? ");
        sql.append(" WHERE 1=1 ");
        sql.append("AND " + ID  + " = ? ");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	       
	        if ((unidadeTO.getNome() != null) && (!unidadeTO.getNome().equals("")) ){
	           stmt.setString(++i,unidadeTO.getNome());
	        }
	        if (unidadeTO.getId() != 0){
	            stmt.setInt(++i,unidadeTO.getId());
	        }

            stmt.executeUpdate();
         } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
         }
    }


    public void excluir(UnidadeTO unidadeTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("DELETE FROM ");
        sql.append(TABELA);
        sql.append(" WHERE 1=1 ");
        if (unidadeTO.getId() != 0){
            sql.append(" AND " + unidadeTO.getId() + " =? ");
        }
        PreparedStatement stmt;
        try {
             int i = 0;
             stmt = getconexao().prepareStatement(sql.toString());
             if (unidadeTO.getId() != 0){
                   stmt.setInt(++i,unidadeTO.getId());
             }
             stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }


    private UnidadeTO carregaTO(ResultSet resultado) throws SQLException{
        UnidadeTO unidadeTO = new UnidadeTO();
        int i = 0;
        unidadeTO.setId(resultado.getInt(++i));
        unidadeTO.setNome(resultado.getString(++i));
        return unidadeTO;
    }


	public int consultarMax(UnidadeTO unidadeTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer("SELECT MAX(");
		sql.append(ID);
		sql.append(") AS ");
		sql.append(ID);
		sql.append(" FROM ");
		sql.append(TABELA);
		PreparedStatement stmt;
		ResultSet result;		
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			result = stmt.executeQuery();
			while (result.next()) {
				return result.getInt(ID) + 1;
			}			
		} 
		catch (SQLException e) {
		    log.error(e.getMessage());
			throw new ExceptionPersistenciaBSC(e.getMessage());
		}		
		return 0;
	}
    
}
