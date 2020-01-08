package br.com.intraBSC.persistencia.JDBC;

import br.com.intraBSC.excecoes.ExceptionPersistenciaBSC;
import br.com.intraBSC.modelo.CausaEfeitoTO;
import br.com.intraBSC.persistencia.BscDaoJDBCGenerico;
import br.com.intraBSC.persistencia.CausaEfeitoDAO;

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


public class CausaEfeitoDAOJDBC extends BscDaoJDBCGenerico implements CausaEfeitoDAO {

    public CausaEfeitoDAOJDBC(DaoManager daoManager) {
		super(daoManager);		
	}


	private static Log log = LogFactory.getLog(CausaEfeitoDAOJDBC.class);

    protected static final String TABELA = "LINKAGE";
    protected static final String efeitoId = "EFFECTREF";
    protected static final String causaId = "CAUSEREF";
    protected static final String interacao = "INTERACTION";
    protected static final String intensidade = "DEGREESTRENGTH";


    private Connection getconexao(){
        return getConnection();
    }

    @SuppressWarnings("unchecked")
	public Collection consultarVarios(CausaEfeitoTO causaEfeitoTO) throws ExceptionPersistenciaBSC{
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT DISTINCT ");
        sql.append("A." + efeitoId + ", ");
        sql.append("A." + causaId + ", ");
        sql.append("A." + interacao + ", ");
        sql.append("A." + intensidade + ", ");
        sql.append("B." + ObjetivoDAOJDBC.NOME_OBJETIVO + " ");
        sql.append("FROM " + TABELA + " A, ");
        sql.append( ObjetivoDAOJDBC.TABELA + " B ");
        sql.append("WHERE 1=1 ");

        if (causaEfeitoTO.getEfeitoId() != 0){
            sql.append(" AND A." + efeitoId + " = ? ");
            sql.append(" AND B." + ObjetivoDAOJDBC.ID_OBJETIVO + " = A. "+ causaId);
        }
        if (causaEfeitoTO.getCausaId() != 0){
            sql.append(" AND A." + causaId + " = ? ");
            sql.append(" AND B." + ObjetivoDAOJDBC.ID_OBJETIVO + " = A. "+ efeitoId);
        }
        if ((causaEfeitoTO.getInteracao() != null) && (!causaEfeitoTO.getInteracao().equals("")) ){
            sql.append(" AND UCASE(A." + interacao + ") LIKE ? ");
        }
        if ((causaEfeitoTO.getIntensidade() != null) && (!causaEfeitoTO.getIntensidade().equals("")) ){
            sql.append(" AND UCASE(A." + intensidade + ") LIKE ? ");
        }


        PreparedStatement stmt;
        try {
          stmt = getconexao().prepareStatement(sql.toString());
        int i = 0;
        if (causaEfeitoTO.getEfeitoId() != 0){
            stmt.setInt(++i,causaEfeitoTO.getEfeitoId());
        }
        if (causaEfeitoTO.getCausaId() != 0){
            stmt.setInt(++i,causaEfeitoTO.getCausaId());
        }
        if ((causaEfeitoTO.getInteracao() != null) && (!causaEfeitoTO.getInteracao().equals("")) ){
           stmt.setString(++i,"%"+ causaEfeitoTO.getInteracao()+"%");
        }
        if ((causaEfeitoTO.getIntensidade() != null) && (!causaEfeitoTO.getIntensidade().equals("")) ){
           stmt.setString(++i,"%"+ causaEfeitoTO.getIntensidade()+"%");
        }

             ResultSet resultado = stmt.executeQuery();
             CausaEfeitoTO retorno = new CausaEfeitoTO();
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


    public CausaEfeitoTO consultarUm(CausaEfeitoTO causaEfeitoTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + efeitoId + ", ");
        sql.append("A." + causaId + ", ");
        sql.append("A." + interacao + ", ");
        sql.append("A." + intensidade + " ");
        sql.append("FROM " + TABELA + " A ");
        sql.append("WHERE 1=1 ");

        if (causaEfeitoTO.getEfeitoId() != 0){
            sql.append(" AND A." + efeitoId + " =? ");
        }
        if (causaEfeitoTO.getCausaId() != 0){
            sql.append(" AND A." + causaId + " =? ");
        }
        if ((causaEfeitoTO.getInteracao() != null) && (!causaEfeitoTO.getInteracao().equals("")) ){
            sql.append(" AND A." + interacao + " LIKE ? ");
        }
        if ((causaEfeitoTO.getIntensidade() != null) && (!causaEfeitoTO.getIntensidade().equals("")) ){
            sql.append(" AND A." + intensidade + " LIKE ? ");
        }


        PreparedStatement stmt;
        try {
			 stmt = getconexao().prepareStatement(sql.toString());
        int i = 0;
        if (causaEfeitoTO.getEfeitoId() != 0){
            stmt.setInt(++i,causaEfeitoTO.getEfeitoId());
        }
        if (causaEfeitoTO.getCausaId() != 0){
            stmt.setInt(++i,causaEfeitoTO.getCausaId());
        }
        if ((causaEfeitoTO.getInteracao() != null) && (!causaEfeitoTO.getInteracao().equals("")) ){
           stmt.setString(++i,"%"+ causaEfeitoTO.getInteracao()+"%");
        }
        if ((causaEfeitoTO.getIntensidade() != null) && (!causaEfeitoTO.getIntensidade().equals("")) ){
           stmt.setString(++i,"%"+ causaEfeitoTO.getIntensidade()+"%");
        }

             ResultSet resultado = stmt.executeQuery();
             CausaEfeitoTO retorno = new CausaEfeitoTO();
             while (resultado.next()) {
            	 retorno.setEfeitoId(resultado.getInt(1));
                 retorno.setCausaId(resultado.getInt(2));
                 retorno.setInteracao(resultado.getString(3));
                 retorno.setIntensidade(resultado.getString(4));
             }
             return retorno;
        } catch (Exception e) {
              log.error(e.getMessage());
              throw new DaoException(e.getMessage());
        }
    }


    public void incluir(CausaEfeitoTO causaEfeitoTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("INSERT INTO ");
        sql.append(TABELA + "(");
        sql.append( efeitoId+", ");
        sql.append( causaId+", ");
        sql.append( interacao+", ");
        sql.append( intensidade+" ");
        sql.append(") VALUES (?,?,?,?)");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
        int i = 0;
        if (causaEfeitoTO.getEfeitoId() != 0){
            stmt.setInt(++i,causaEfeitoTO.getEfeitoId());
        }
        if (causaEfeitoTO.getCausaId() != 0){
            stmt.setInt(++i,causaEfeitoTO.getCausaId());
        }
        if ((causaEfeitoTO.getInteracao() != null) && (!causaEfeitoTO.getInteracao().equals("")) ){
           stmt.setString(++i, causaEfeitoTO.getInteracao());
        }
        if ((causaEfeitoTO.getIntensidade() != null) && (!causaEfeitoTO.getIntensidade().equals("")) ){
           stmt.setString(++i,causaEfeitoTO.getIntensidade());
        }

            stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }


    public void alterar(CausaEfeitoTO causaEfeitoTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("UPDATE ");
        sql.append(TABELA + " SET ");
        sql.append( interacao + " = ?, ");
        sql.append( intensidade + " = ? ");
        sql.append(" WHERE 1=1 ");
        sql.append("AND " + causaId  + " = ? ");
        sql.append("AND " + efeitoId  + " = ? ");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());

	        int i = 0;
	        
	        
	        if ((causaEfeitoTO.getInteracao() != null) && (!causaEfeitoTO.getInteracao().equals("")) ){
	           stmt.setString(++i,causaEfeitoTO.getInteracao());
	        }
	        if ((causaEfeitoTO.getIntensidade() != null) && (!causaEfeitoTO.getIntensidade().equals("")) ){
	           stmt.setString(++i,causaEfeitoTO.getIntensidade());
	        }
	        if (causaEfeitoTO.getCausaId() != 0){
	            stmt.setInt(++i,causaEfeitoTO.getCausaId());
	        }
	        if (causaEfeitoTO.getEfeitoId() != 0){
	            stmt.setInt(++i,causaEfeitoTO.getEfeitoId());
	        }
  

            stmt.executeUpdate();
         } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
         }
    }


    public void excluir(CausaEfeitoTO causaEfeitoTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("DELETE FROM ");
        sql.append(TABELA);
        sql.append(" WHERE 1=1 ");
        if (causaEfeitoTO.getCausaId() != 0){
            sql.append(" AND " + causaId + " = ? ");
        }
        if (causaEfeitoTO.getEfeitoId() != 0){
            sql.append(" AND " + efeitoId + " = ? ");
        }
        PreparedStatement stmt;
        try {
             int i = 0;
             stmt = getconexao().prepareStatement(sql.toString());
             if (causaEfeitoTO.getCausaId() != 0){
                   stmt.setInt(++i,causaEfeitoTO.getCausaId());
             }
             if (causaEfeitoTO.getEfeitoId() != 0){
                 stmt.setInt(++i,causaEfeitoTO.getEfeitoId());
             }
             stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }


    private CausaEfeitoTO carregaTO(ResultSet resultado) throws SQLException{
        CausaEfeitoTO causaEfeitoTO = new CausaEfeitoTO();
        int i = 0;
        causaEfeitoTO.setEfeitoId(resultado.getInt(++i));
        causaEfeitoTO.setCausaId(resultado.getInt(++i));
        causaEfeitoTO.setInteracao(resultado.getString(++i));
        causaEfeitoTO.setIntensidade(resultado.getString(++i));
        causaEfeitoTO.setNomeObjetivo(resultado.getString(++i));
    return causaEfeitoTO;
    }

	public int consultarMax(CausaEfeitoTO causaEfeitoTO) throws ExceptionPersistenciaBSC {
		return 0;
	}
}