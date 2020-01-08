package br.com.intraBSC.persistencia.JDBC;

import br.com.intraBSC.excecoes.ExceptionPersistenciaBSC;
import br.com.intraBSC.modelo.PeriodicidadeTO;
import br.com.intraBSC.persistencia.BscDaoJDBCGenerico;
import br.com.intraBSC.persistencia.PeriodicidadeDAO;

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


public class PeriodicidadeDAOJDBC extends BscDaoJDBCGenerico implements PeriodicidadeDAO {

    private static Log log = LogFactory.getLog(PeriodicidadeDAOJDBC.class);

    protected static final String TABELA = "PERIODICIDADE";
    protected static final String id = "ID";
    protected static final String NOME = "NAME";

    public PeriodicidadeDAOJDBC(DaoManager daoManager) {
        super(daoManager);
    }

    private Connection getconexao(){
        return getConnection();
    }

    @SuppressWarnings("unchecked")
	public Collection consultarVarios(PeriodicidadeTO periodicidadeTO) throws ExceptionPersistenciaBSC{
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + id + ", ");
        sql.append("A." + NOME + " ");
        sql.append("FROM " + TABELA + " A ");
        sql.append("WHERE 1=1 ");
        
        if (periodicidadeTO.getId() != 0){
            sql.append(" AND A." + id + " =? ");
        }
      //  if ((periodicidadeTO.getNome() != null) && (!periodicidadeTO.getNome().equals("")) ){
            sql.append(" AND UCASE(A." + NOME + ") LIKE ? ");
      //  
        sql.append(" ORDER BY " + NOME);
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        if (periodicidadeTO.getId() != 0){
	            stmt.setInt(++i,periodicidadeTO.getId());
	        }
	     //   if ((periodicidadeTO.getNome() != null) && (!periodicidadeTO.getNome().equals("")) ){
	           stmt.setString(++i,"%"+ periodicidadeTO.getNome()+"%");
	     //   }
             ResultSet resultado = stmt.executeQuery();
             PeriodicidadeTO retorno = new PeriodicidadeTO();
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


    public PeriodicidadeTO consultarUm(PeriodicidadeTO periodicidadeTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + id + ", ");
        sql.append("A." + NOME + " ");
        sql.append("FROM " + TABELA + " A ");
        sql.append("WHERE 1=1 ");

        if (periodicidadeTO.getId() != 0){
            sql.append(" AND A." + id + " =? ");
        }
        if ((periodicidadeTO.getNome() != null) && (!periodicidadeTO.getNome().equals("")) ){
            sql.append(" AND UCASE(A." + NOME + ") LIKE ? ");
        }
        PreparedStatement stmt;
        try {
			 stmt = getconexao().prepareStatement(sql.toString());
        int i = 0;
        if (periodicidadeTO.getId() != 0){
            stmt.setInt(++i,periodicidadeTO.getId());
        }
        if ((periodicidadeTO.getNome() != null) && (!periodicidadeTO.getNome().equals("")) ){
           stmt.setString(++i,"%"+ periodicidadeTO.getNome().toUpperCase()+"%");
        }

             ResultSet resultado = stmt.executeQuery();
             PeriodicidadeTO retorno = new PeriodicidadeTO();
             while (resultado.next()) {
                  retorno = carregaTO(resultado);
             }
             return retorno;
        } catch (Exception e) {
              log.error(e.getMessage());
              throw new DaoException(e.getMessage());
        }
    }


    public void incluir(PeriodicidadeTO periodicidadeTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("INSERT INTO ");
        sql.append(TABELA + "(");
        sql.append( id+", ");
        sql.append( NOME+" ");
        sql.append(") VALUES (?,?)");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
        int i = 0;
        if (periodicidadeTO.getId() != 0){
            stmt.setInt(++i,periodicidadeTO.getId());
        }
        if ((periodicidadeTO.getNome() != null) && (!periodicidadeTO.getNome().equals("")) ){
           stmt.setString(++i,periodicidadeTO.getNome());
        }

            stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }


    public void alterar(PeriodicidadeTO periodicidadeTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("UPDATE ");
        sql.append(TABELA + " SET ");
        sql.append( NOME + " = ? ");
        sql.append(" WHERE 1=1 ");
        sql.append("AND " + id + " = ? ");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	       
	        if ((periodicidadeTO.getNome() != null) && (!periodicidadeTO.getNome().equals("")) ){
	           stmt.setString(++i,periodicidadeTO.getNome());
	        }
	        if (periodicidadeTO.getId() != 0){
	            stmt.setInt(++i,periodicidadeTO.getId());
	        }

            stmt.executeUpdate();
         } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
         }
    }


    public void excluir(PeriodicidadeTO periodicidadeTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("DELETE FROM ");
        sql.append(TABELA);
        sql.append(" WHERE 1=1 ");
        if (periodicidadeTO.getId() != 0){
            sql.append(" AND " + periodicidadeTO.getId()+ " =? ");
        }
        PreparedStatement stmt;
        try {
             int i = 0;
             stmt = getconexao().prepareStatement(sql.toString());
             if (periodicidadeTO.getId() != 0){
                   stmt.setInt(++i,periodicidadeTO.getId());
             }
             stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }


    private PeriodicidadeTO carregaTO(ResultSet resultado) throws SQLException{
        PeriodicidadeTO periodicidadeTO = new PeriodicidadeTO();
        int i = 0;
        periodicidadeTO.setId(resultado.getInt(++i));
        periodicidadeTO.setNome(resultado.getString(++i));
    return periodicidadeTO;
    }

	public int consultarMax(PeriodicidadeTO periodicidadeTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer("SELECT MAX(");
		sql.append(id);
		sql.append(") AS ");
		sql.append(id);
		sql.append(" FROM ");
		sql.append(TABELA);
		PreparedStatement stmt;
		ResultSet result;		
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			result = stmt.executeQuery();
			while (result.next()) {
				return result.getInt(id) + 1;
			}			
		} 
		catch (SQLException e) {
		    log.error(e.getMessage());
			throw new ExceptionPersistenciaBSC(e.getMessage());
		}		
		return 0;
	}
    
}
