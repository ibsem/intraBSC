package br.com.intraBSC.persistencia.JDBC;

import br.com.intraBSC.excecoes.ExceptionPersistenciaBSC;
import br.com.intraBSC.modelo.TipoPerspectivaTO;
import br.com.intraBSC.persistencia.BscDaoJDBCGenerico;
import br.com.intraBSC.persistencia.TipoPerspectivaDAO;

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


public class TipoPerspectivaDAOJDBC extends BscDaoJDBCGenerico implements TipoPerspectivaDAO {

    private static Log log = LogFactory.getLog(TipoPerspectivaDAOJDBC.class);

    protected static final String TABELA = "PERSPECTIVETYPE";
    protected static final String id = "ID";
    protected static final String NOME = "NAME";
    protected static final String DESCRICAO = "DESCRIPTION";

    public TipoPerspectivaDAOJDBC(DaoManager daoManager) {
        super(daoManager);
    }

    private Connection getconexao(){
        return getConnection();
    }

    @SuppressWarnings("unchecked")
	public Collection consultarVarios(TipoPerspectivaTO tipoperspectivaTO) throws ExceptionPersistenciaBSC{
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + id + ", ");
        sql.append("A." + NOME + ", ");
        sql.append("A." + DESCRICAO + " ");
        sql.append("FROM " + TABELA + " A ");
        sql.append("WHERE 1=1 ");

        if (tipoperspectivaTO.getId() != 0){
            sql.append(" AND A." + id + " =? ");
        }
       // if ((tipoperspectivaTO.getNome() != null) && (!tipoperspectivaTO.getNome().equals("")) ){
            sql.append(" AND UCASE(A." + NOME + ") LIKE ? ");
      //  }
        if ((tipoperspectivaTO.getDescricao() != null) && (!tipoperspectivaTO.getDescricao().equals("")) ){
            sql.append(" AND UCASE(A." + DESCRICAO + ") LIKE ? ");
        }

        sql.append(" ORDER BY "+ NOME);
        PreparedStatement stmt;
        try {
          stmt = getconexao().prepareStatement(sql.toString());
        int i = 0;
        if (tipoperspectivaTO.getId() != 0){
            stmt.setInt(++i,tipoperspectivaTO.getId());
        }
     //   if ((tipoperspectivaTO.getNome() != null) && (!tipoperspectivaTO.getNome().equals("")) ){
           stmt.setString(++i,"%"+ tipoperspectivaTO.getNome()+"%");
    //    }
        if ((tipoperspectivaTO.getDescricao() != null) && (!tipoperspectivaTO.getDescricao().equals("")) ){
           stmt.setString(++i,"%"+ tipoperspectivaTO.getDescricao()+"%");
        }

             ResultSet resultado = stmt.executeQuery();
             TipoPerspectivaTO retorno = new TipoPerspectivaTO();
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


    public TipoPerspectivaTO consultarUm(TipoPerspectivaTO tipoperspectivaTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + id + ", ");
        sql.append("A." + NOME + ", ");
        sql.append("A." + DESCRICAO + " ");
        sql.append("FROM " + TABELA + " A ");
        sql.append("WHERE 1=1 ");

        if (tipoperspectivaTO.getId() != 0){
            sql.append(" AND A." + id + " =? ");
        }
        if ((tipoperspectivaTO.getNome() != null) && (!tipoperspectivaTO.getNome().equals("")) ){
            sql.append(" AND UCASE(A." + NOME + ") LIKE ? ");
        }
        if ((tipoperspectivaTO.getDescricao() != null) && (!tipoperspectivaTO.getDescricao().equals("")) ){
            sql.append(" AND UCASE(A." + DESCRICAO + ") LIKE ? ");
        }


        PreparedStatement stmt;
        try {
			 stmt = getconexao().prepareStatement(sql.toString());
        int i = 0;
        if (tipoperspectivaTO.getId() != 0){
            stmt.setInt(++i,tipoperspectivaTO.getId());
        }
        if ((tipoperspectivaTO.getNome() != null) && (!tipoperspectivaTO.getNome().equals("")) ){
           stmt.setString(++i,"%"+ tipoperspectivaTO.getNome()+"%");
        }
        if ((tipoperspectivaTO.getDescricao() != null) && (!tipoperspectivaTO.getDescricao().equals("")) ){
           stmt.setString(++i,"%"+ tipoperspectivaTO.getDescricao()+"%");
        }

             ResultSet resultado = stmt.executeQuery();
             TipoPerspectivaTO retorno = new TipoPerspectivaTO();
             while (resultado.next()) {
                  retorno = carregaTO(resultado);
             }
             return retorno;
        } catch (Exception e) {
              log.error(e.getMessage());
              throw new DaoException(e.getMessage());
        }
    }


    public void incluir(TipoPerspectivaTO tipoperspectivaTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("INSERT INTO ");
        sql.append(TABELA + "(");
        sql.append( id+", ");
        sql.append( NOME+", ");
        sql.append( DESCRICAO+" ");
        sql.append(") VALUES (?,?,?)");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
        int i = 0;
        if (tipoperspectivaTO.getId() != 0){
            stmt.setInt(++i,tipoperspectivaTO.getId());
        }
        if ((tipoperspectivaTO.getNome() != null) && (!tipoperspectivaTO.getNome().equals("")) ){
           stmt.setString(++i,tipoperspectivaTO.getNome());
        }
        if ((tipoperspectivaTO.getDescricao() != null) && (!tipoperspectivaTO.getDescricao().equals("")) ){
           stmt.setString(++i,tipoperspectivaTO.getDescricao());
        }

            stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }


    public void alterar(TipoPerspectivaTO tipoperspectivaTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("UPDATE ");
        sql.append(TABELA + " SET ");
        sql.append( NOME + " = ?, ");
        sql.append( DESCRICAO + " = ? ");
        sql.append(" WHERE 1=1 ");
        sql.append("AND " + id  + " = ? ");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        if ((tipoperspectivaTO.getNome() != null) && (!tipoperspectivaTO.getNome().equals("")) ){
	           stmt.setString(++i,tipoperspectivaTO.getNome());
	        }
	        if ((tipoperspectivaTO.getDescricao() != null) && (!tipoperspectivaTO.getDescricao().equals("")) ){
	           stmt.setString(++i,tipoperspectivaTO.getDescricao());
	        }
	        if (tipoperspectivaTO.getId() != 0){
	            stmt.setInt(++i,tipoperspectivaTO.getId());
	        }
            stmt.executeUpdate();
         } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
         }
    }


    public void excluir(TipoPerspectivaTO tipoperspectivaTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("DELETE FROM ");
        sql.append(TABELA);
        sql.append(" WHERE 1=1 ");
        if (tipoperspectivaTO.getId() != 0){
            sql.append(" AND " + tipoperspectivaTO.getId() + " =? ");
        }
        PreparedStatement stmt;
        try {
             int i = 0;
             stmt = getconexao().prepareStatement(sql.toString());
             if (tipoperspectivaTO.getId() != 0){
                   stmt.setInt(++i,tipoperspectivaTO.getId());
             }
             stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }


    private TipoPerspectivaTO carregaTO(ResultSet resultado) throws SQLException{
        TipoPerspectivaTO tipoperspectivaTO = new TipoPerspectivaTO();
        int i = 0;
        tipoperspectivaTO.setId(resultado.getInt(++i));
        tipoperspectivaTO.setNome(resultado.getString(++i));
        tipoperspectivaTO.setDescricao(resultado.getString(++i));
    return tipoperspectivaTO;
    }

	public int consultarMax(TipoPerspectivaTO tipoPerspectivaTO) throws ExceptionPersistenciaBSC {
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
