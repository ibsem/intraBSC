package br.com.intraBSC.persistencia.JDBC;


import br.com.intraBSC.excecoes.ExceptionPersistenciaBSC;
import br.com.intraBSC.modelo.IndicadorFatoTO;
import br.com.intraBSC.persistencia.BscDaoJDBCGenerico;
import br.com.intraBSC.persistencia.IndicadorFatoDAO;
import br.com.intraBSC.util.SQLDate;

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


public class IndicadorFatoDAOJDBC extends BscDaoJDBCGenerico implements IndicadorFatoDAO {

    private static Log log = LogFactory.getLog(IndicadorFatoDAOJDBC.class);

    protected static final String TABELA = "MEASUREFACT";
    protected static final String ID = "ID_MEASURE";
    protected static final String DATA = "DATE";
    protected static final String VALOR = "VALUE";

    public IndicadorFatoDAOJDBC(DaoManager daoManager) {
        super(daoManager);
    }

    private Connection getconexao(){
        return getConnection();
    }

    @SuppressWarnings("unchecked")
	public Collection consultarVarios(IndicadorFatoTO indicadorFatoTO) throws ExceptionPersistenciaBSC{
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + ID + ", ");
        sql.append("A." + DATA + ", ");
        sql.append("A." + VALOR + " ");
        sql.append("FROM " + TABELA + " A ");
        sql.append("WHERE 1=1 ");

        if (indicadorFatoTO.getId() != 0){
            sql.append(" AND A." + ID + " =? ");
        }
        if (indicadorFatoTO.getData() != null){
            sql.append(" AND A." + DATA + " =? ");
        }
        if (indicadorFatoTO.getValor() != 0.0){
            sql.append(" AND A." + VALOR + " =? ");
        }

        PreparedStatement stmt;
        try {
          stmt = getconexao().prepareStatement(sql.toString());
        int i = 0;
        if (indicadorFatoTO.getId() != 0){
            stmt.setInt(++i,indicadorFatoTO.getId());
        }
        if (indicadorFatoTO.getData() != null){
           stmt.setDate(++i,indicadorFatoTO.getData());
        }
        if (indicadorFatoTO.getValor() != 0.0){
           stmt.setDouble(++i,indicadorFatoTO.getValor());
        }
             ResultSet resultado = stmt.executeQuery();
             IndicadorFatoTO retorno = new IndicadorFatoTO();
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


    public IndicadorFatoTO consultarUm(IndicadorFatoTO indicadorFatoTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + ID + ", ");
        sql.append("A." + DATA + ", ");
        sql.append("A." + VALOR + " ");
        sql.append("FROM " + TABELA + " A ");
        sql.append("WHERE 1=1 ");

        if (indicadorFatoTO.getId() != 0){
            sql.append(" AND A." + ID + " =? ");
        }
        if (indicadorFatoTO.getData() != null){
            sql.append(" AND A." + DATA + " =? ");
        }
        if (indicadorFatoTO.getValor() != 0.0){
            sql.append(" AND A." + VALOR + " =? ");
        }


        PreparedStatement stmt;
        try {
			 stmt = getconexao().prepareStatement(sql.toString());
        int i = 0;
        if (indicadorFatoTO.getId() != 0){
            stmt.setInt(++i,indicadorFatoTO.getId());
        }
        if (indicadorFatoTO.getData() != null){
           stmt.setDate(++i,indicadorFatoTO.getData());
        }
        if (indicadorFatoTO.getValor() != 0.0){
           stmt.setDouble(++i,indicadorFatoTO.getValor());
        }

             ResultSet resultado = stmt.executeQuery();
             IndicadorFatoTO retorno = new IndicadorFatoTO();
             while (resultado.next()) {
                  retorno = carregaTO(resultado);
             }
             return retorno;
        } catch (Exception e) {
              log.error(e.getMessage());
              throw new DaoException(e.getMessage());
        }
    }

    public IndicadorFatoTO consultarUltimoIndicadorFato(IndicadorFatoTO indicadorFatoTO) 
	throws ExceptionPersistenciaBSC {
StringBuffer sql = new StringBuffer();
sql.append("SELECT ");
sql.append("A." + ID + ", ");
sql.append("MAX(A." + DATA + "), ");
sql.append("A." + VALOR);
sql.append(" FROM " + TABELA + " A ");
sql.append("WHERE 1=1 ");

if (indicadorFatoTO.getId() != 0){
sql.append(" AND A." + ID + " =? ");
}
if (indicadorFatoTO.getData() != null){
sql.append(" AND A." + DATA + " =  ");
}
sql.append("GROUP BY " + "A." + ID + ", " + "A." + VALOR);

PreparedStatement stmt;
try {
stmt = getconexao().prepareStatement(sql.toString());
int i = 0;
if (indicadorFatoTO.getId() != 0){
stmt.setInt(++i,indicadorFatoTO.getId());
}
if (indicadorFatoTO.getData() != null){
stmt.setDate(++i,indicadorFatoTO.getData());
}

ResultSet resultado = stmt.executeQuery();
IndicadorFatoTO retorno = new IndicadorFatoTO();
while (resultado.next()) {
retorno = carregaTO(resultado);
}
return retorno;
} catch (Exception e) {
log.error(e.getMessage());
throw new DaoException(e.getMessage());
}
}

    

    public void incluir(IndicadorFatoTO indicadorFatoTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("INSERT INTO ");
        sql.append(TABELA + "(");
        sql.append( ID+", ");
        sql.append( DATA+", ");
        sql.append( VALOR+" ");
        sql.append(") VALUES (?,?,?)");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
        int i = 0;
        if (indicadorFatoTO.getId() != 0){
            stmt.setInt(++i,indicadorFatoTO.getId());
        }
        if (indicadorFatoTO.getData() != null){
           stmt.setDate(++i,indicadorFatoTO.getData());
        }
        if (indicadorFatoTO.getValor() != 0.0){
           stmt.setDouble(++i,indicadorFatoTO.getValor());
        }

            stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }


    public void alterar(IndicadorFatoTO indicadorFatoTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("UPDATE ");
        sql.append(TABELA + " SET ");        
        sql.append( VALOR + " = ? ");
        sql.append(" WHERE 1=1 ");
        sql.append("AND " + ID  + " = ? ");
        sql.append("AND " + DATA  + " = ? ");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());

	        int i = 0;
	        
	        if (indicadorFatoTO.getValor() != 0.0){
	           stmt.setDouble(++i,indicadorFatoTO.getValor());
	        }
	        if (indicadorFatoTO.getId() != 0){
	            stmt.setInt(++i,indicadorFatoTO.getId());
	        }
	        if (indicadorFatoTO.getData() != null){
	           stmt.setDate(++i,indicadorFatoTO.getData());
	        }
  

            stmt.executeUpdate();
         } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
         }
    }


    public void excluir(IndicadorFatoTO indicadorFatoTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("DELETE FROM ");
        sql.append(TABELA);
        sql.append(" WHERE 1=1 ");
        if (indicadorFatoTO.getId() != 0){
            sql.append(" AND " + ID + " = ? ");
        }
        if (indicadorFatoTO.getData() != null){
        	 sql.append(" AND " + DATA + " = ? ");
        }
        PreparedStatement stmt;
        try {
             int i = 0;
             stmt = getconexao().prepareStatement(sql.toString());
             if (indicadorFatoTO.getId() != 0){
                   stmt.setInt(++i,indicadorFatoTO.getId());
             }
             if (indicadorFatoTO.getData() != null){
  	           stmt.setDate(++i,indicadorFatoTO.getData());
  	         }
             stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }


    private IndicadorFatoTO carregaTO(ResultSet resultado) throws SQLException{
        IndicadorFatoTO indicadorFatoTO = new IndicadorFatoTO();
        int i = 0;
        indicadorFatoTO.setId(resultado.getInt(++i));
        indicadorFatoTO.setData(resultado.getDate(++i));
        indicadorFatoTO.setValor(resultado.getFloat(++i));
    return indicadorFatoTO;
    }

	@SuppressWarnings("unchecked")
	public Collection consultarVariosIndicador(IndicadorFatoTO indicadorFatoTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + ID + ", ");
        sql.append("A." + DATA + ", ");
        sql.append("A." + VALOR + ", ");
        sql.append("B." + IndicadorDAOJDBC.NOME_INDICADOR + " ");
        sql.append("FROM " + TABELA + " A, " + IndicadorDAOJDBC.TABELA + " B ");
        sql.append("WHERE 1=1 AND A." + ID + " = " + "B." + IndicadorDAOJDBC.ID_INDICADOR );

        if (indicadorFatoTO.getId() != 0){
            sql.append(" AND A." + ID + " =? ");
        }
        if (indicadorFatoTO.getData() != null){
            sql.append(" AND A." + DATA + " =? ");
        }
        if ((indicadorFatoTO.getNome() != null) && (!indicadorFatoTO.getNome().equals(""))){
            sql.append(" AND B." + IndicadorDAOJDBC.NOME_INDICADOR + " =? ");
        }
        sql.append(" ORDER BY B."+ IndicadorDAOJDBC.NOME_INDICADOR);
        PreparedStatement stmt;
        try {
          stmt = getconexao().prepareStatement(sql.toString());
        int i = 0;
        if (indicadorFatoTO.getId() != 0){
            stmt.setInt(++i,indicadorFatoTO.getId());
        }
        if (indicadorFatoTO.getData() != null){
           stmt.setDate(++i,indicadorFatoTO.getData());
        }
        if ((indicadorFatoTO.getNome() != null) && (!indicadorFatoTO.getNome().equals(""))){
           stmt.setString(++i,indicadorFatoTO.getNome());
        }

             ResultSet resultado = stmt.executeQuery();
             
             Collection lista = new ArrayList();
             while (resultado.next()) {
            	 IndicadorFatoTO retorno = new IndicadorFatoTO();
            	 int j = 0;
            	 retorno.setId(resultado.getInt(++j));
            	 SQLDate data = new SQLDate(resultado.getDate(++j)); 
            	 retorno.setData(data.getSQLDateFormat());
            	 retorno.setStrData(data.getData());
            	 retorno.setValor(resultado.getFloat(++j));
            	 retorno.setNome(resultado.getString(++j));
                 lista.add(retorno);
             }
             return lista;
        } catch (Exception e) {
              log.error(e.getMessage());
              throw new DaoException(e.getMessage());
        }
	}


}
