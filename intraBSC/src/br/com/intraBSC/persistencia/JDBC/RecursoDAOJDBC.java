package br.com.intraBSC.persistencia.JDBC;


import br.com.intraBSC.excecoes.ExceptionPersistenciaBSC;
import br.com.intraBSC.modelo.RecursoTO;
import br.com.intraBSC.persistencia.BscDaoJDBCGenerico;
import br.com.intraBSC.persistencia.RecursoDAO;

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


public class RecursoDAOJDBC extends BscDaoJDBCGenerico implements RecursoDAO {

    private static Log log = LogFactory.getLog(RecursoDAOJDBC.class);

    protected static final String TABELA = "RESOURCE";
    protected static final String ID = "ID";
    protected static final String ID_INICIATIVA = "INITIATIVE_ID";
    protected static final String NOME = "NAME";
    protected static final String DESCRICAO = "DESCRIPTION";

    public RecursoDAOJDBC(DaoManager daoManager) {
        super(daoManager);
    }

    private Connection getconexao(){
        return getConnection();
    }

    @SuppressWarnings("unchecked")
	public Collection consultarVarios(RecursoTO recursoTO) throws ExceptionPersistenciaBSC{
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + ID + ", ");
        sql.append("A." + ID_INICIATIVA + ", ");
        sql.append("A." + NOME + ", ");
        sql.append("A." + DESCRICAO + " ");
        sql.append("FROM " + TABELA + " A ");
        sql.append("WHERE 1=1 ");

        if (recursoTO.getId() != 0){
            sql.append(" AND A." + ID + " =? ");
        }
        if (recursoTO.getIdIniciativa() != 0){
            sql.append(" AND A." + ID_INICIATIVA + " =? ");
        }
        if ((recursoTO.getNome() != null) && (!recursoTO.getNome().equals("")) ){
            sql.append(" AND UCASE(A." + NOME + ") LIKE ? ");
        }

        PreparedStatement stmt;
        try {
          stmt = getconexao().prepareStatement(sql.toString());
        int i = 0;
        if (recursoTO.getId() != 0){
            stmt.setInt(++i,recursoTO.getId());
        }
        if (recursoTO.getIdIniciativa() != 0){
            stmt.setInt(++i,recursoTO.getIdIniciativa());
        }
        if ((recursoTO.getNome() != null) && (!recursoTO.getNome().equals("")) ){
           stmt.setString(++i,"%"+ recursoTO.getNome().toUpperCase()+"%");
        }
        

             ResultSet resultado = stmt.executeQuery();
             RecursoTO retorno = new RecursoTO();
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


    public RecursoTO consultarUm(RecursoTO recursoTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + ID + ", ");
        sql.append("A." + ID_INICIATIVA + ", ");
        sql.append("A." + NOME + ", ");
        sql.append("A." + DESCRICAO + " ");
        sql.append("FROM " + TABELA + " A ");
        sql.append("WHERE 1=1 ");

        if (recursoTO.getId() != 0){
            sql.append(" AND A." + ID + " =? ");
        }
        if (recursoTO.getIdIniciativa() != 0){
            sql.append(" AND A." + ID_INICIATIVA + " =? ");
        }
        if ((recursoTO.getNome() != null) && (!recursoTO.getNome().equals("")) ){
        	 sql.append(" AND UCASE(A." + NOME + ") LIKE ? ");
        }        


        PreparedStatement stmt;
        try {
			 stmt = getconexao().prepareStatement(sql.toString());
        int i = 0;
        if (recursoTO.getId() != 0){
            stmt.setInt(++i,recursoTO.getId());
        }
        if (recursoTO.getIdIniciativa() != 0){
            stmt.setInt(++i,recursoTO.getIdIniciativa());
        }
        if ((recursoTO.getNome() != null) && (!recursoTO.getNome().equals("")) ){
           stmt.setString(++i,"%"+ recursoTO.getNome().toUpperCase()+"%");
        }
        
             ResultSet resultado = stmt.executeQuery();
             RecursoTO retorno = new RecursoTO();
             while (resultado.next()) {
                  retorno = carregaTO(resultado);
             }
             return retorno;
        } catch (Exception e) {
              log.error(e.getMessage());
              throw new DaoException(e.getMessage());
        }
    }


    public void incluir(RecursoTO recursoTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("INSERT INTO ");
        sql.append(TABELA + "(");
        sql.append( ID+", ");
        sql.append( ID_INICIATIVA+", ");
        sql.append( NOME+", ");
        sql.append( DESCRICAO+" ");
        sql.append(") VALUES (?,?,?,?)");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
        int i = 0;
        if (recursoTO.getId() != 0){
            stmt.setInt(++i,recursoTO.getId());
        }
        if (recursoTO.getIdIniciativa() != 0){
            stmt.setInt(++i,recursoTO.getIdIniciativa());
        }
        if ((recursoTO.getNome() != null) && (!recursoTO.getNome().equals("")) ){
           stmt.setString(++i,recursoTO.getNome());
        }
        if ((recursoTO.getDescricao() != null) && (!recursoTO.getDescricao().equals("")) ){
           stmt.setString(++i, recursoTO.getDescricao());
        }

            stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }


    public void alterar(RecursoTO recursoTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("UPDATE ");
        sql.append(TABELA + " SET ");
        sql.append( ID_INICIATIVA + " = ?, ");
        sql.append( NOME + " = ?, ");
        sql.append( DESCRICAO + " = ? ");
        sql.append(" WHERE 1=1 ");
        sql.append("AND " + ID  + " = ? ");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());

        int i = 0;
        
        if (recursoTO.getIdIniciativa() != 0){
            stmt.setInt(++i,recursoTO.getIdIniciativa());
        }
        if ((recursoTO.getNome() != null) && (!recursoTO.getNome().equals("")) ){
           stmt.setString(++i, recursoTO.getNome());
        }
        if ((recursoTO.getDescricao() != null) && (!recursoTO.getDescricao().equals("")) ){
           stmt.setString(++i,recursoTO.getDescricao());
        }
        if (recursoTO.getId() != 0){
            stmt.setInt(++i,recursoTO.getId());
        }

            stmt.executeUpdate();
         } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
         }
    }


    public void excluir(RecursoTO recursoTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("DELETE FROM ");
        sql.append(TABELA);
        sql.append(" WHERE 1=1 ");
        if (recursoTO.getId() != 0){
            sql.append(" AND " + ID + " =? ");
        }
        PreparedStatement stmt;
        try {
             int i = 0;
             stmt = getconexao().prepareStatement(sql.toString());
             if (recursoTO.getId() != 0){
                   stmt.setInt(++i,recursoTO.getId());
             }
             stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }


    private RecursoTO carregaTO(ResultSet resultado) throws SQLException{
        RecursoTO recursoTO = new RecursoTO();
        int i = 0;
        recursoTO.setId(resultado.getInt(++i));
        recursoTO.setIdIniciativa(resultado.getInt(++i));
        recursoTO.setNome(resultado.getString(++i));
        recursoTO.setDescricao(resultado.getString(++i));
        return recursoTO;
    }

	public int consultarMax(RecursoTO RecursoTO) throws ExceptionPersistenciaBSC {
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
