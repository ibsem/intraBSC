package br.com.intraBSC.persistencia.JDBC;


import br.com.intraBSC.excecoes.ExceptionPersistenciaBSC;
import br.com.intraBSC.modelo.PapelTO;
import br.com.intraBSC.persistencia.BscDaoJDBCGenerico;
import br.com.intraBSC.persistencia.PapelDAO;

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


public class PapelDAOJDBC extends BscDaoJDBCGenerico implements PapelDAO {

    private static Log log = LogFactory.getLog(PapelDAOJDBC.class);

    protected static final String TABELA = "ROLE";
    protected static final String ID = "ID";
    protected static final String NOME = "NAME";

    public PapelDAOJDBC(DaoManager daoManager) {
        super(daoManager);
    }

    private Connection getconexao(){
        return getConnection();
    }

    @SuppressWarnings("unchecked")
	public Collection consultarVarios(PapelTO papelTO) throws ExceptionPersistenciaBSC{
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + ID + ", ");
        sql.append("A." + NOME + " ");
        sql.append("FROM " + TABELA + " A ");
        PreparedStatement stmt;
        try {
          stmt = getconexao().prepareStatement(sql.toString());
             ResultSet resultado = stmt.executeQuery();
             PapelTO retorno = new PapelTO();
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


    public PapelTO consultarUm(PapelTO papelTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + ID + ", ");
        sql.append("A." + NOME + " ");
        sql.append("FROM " + TABELA + " A ");
        sql.append("WHERE 1=1 ");

        if (papelTO.getId() != 0){
            sql.append(" AND A." + ID + " =? ");
        }
                
        if ((papelTO.getNome() != null) && (!papelTO.getNome().equals("")) ){
            sql.append(" AND UCASE(A." + NOME + ") LIKE ? ");
        }
        PreparedStatement stmt;
        try {
			 stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        if (papelTO.getId() != 0){
	            stmt.setInt(++i,papelTO.getId());
	        }
	        if ((papelTO.getNome() != null) && (!papelTO.getNome().equals("")) ){
	           stmt.setString(++i,"%"+ papelTO.getNome()+"%");
	        }

             ResultSet resultado = stmt.executeQuery();
             PapelTO retorno = new PapelTO();
             while (resultado.next()) {
                  retorno = carregaTO(resultado);
             }
             return retorno;
        } catch (Exception e) {
              log.error(e.getMessage());
              throw new DaoException(e.getMessage());
        }
    }


    public void incluir(PapelTO papelTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("INSERT INTO ");
        sql.append(TABELA + "(");
        sql.append( ID+", ");
        sql.append( NOME+" ");
        sql.append(") VALUES (?,?)");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
        int i = 0;
        if (papelTO.getId() != 0){
            stmt.setInt(++i,papelTO.getId());
        }
        if ((papelTO.getNome() != null) && (!papelTO.getNome().equals("")) ){
           stmt.setString(++i,papelTO.getNome());
        }

            stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }


    public void alterar(PapelTO papelTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("UPDATE ");
        sql.append(TABELA + " SET ");
        sql.append( NOME + " = ? ");
        sql.append(" WHERE 1=1 ");
        sql.append("AND " + ID  + " = ? ");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	       
	        if ((papelTO.getNome() != null) && (!papelTO.getNome().equals("")) ){
	           stmt.setString(++i,papelTO.getNome());
	        }
	        if (papelTO.getId() != 0){
	            stmt.setInt(++i,papelTO.getId());
	        }

            stmt.executeUpdate();
         } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
         }
    }


    public void excluir(PapelTO papelTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("DELETE FROM ");
        sql.append(TABELA);
        sql.append(" WHERE 1=1 ");
        if (papelTO.getId() != 0){
            sql.append(" AND " + papelTO.getId() + " =? ");
        }
        PreparedStatement stmt;
        try {
             int i = 0;
             stmt = getconexao().prepareStatement(sql.toString());
             if (papelTO.getId() != 0){
                   stmt.setInt(++i,papelTO.getId());
             }
             stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }


    private PapelTO carregaTO(ResultSet resultado) throws SQLException{
        PapelTO papelTO = new PapelTO();
        int i = 0;
        papelTO.setId(resultado.getInt(++i));
        papelTO.setNome(resultado.getString(++i));
        return papelTO;
    }


	public int consultarMax(PapelTO papelTO) throws ExceptionPersistenciaBSC {
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
