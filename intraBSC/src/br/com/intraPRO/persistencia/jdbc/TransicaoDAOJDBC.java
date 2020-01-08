package br.com.intraPRO.persistencia.jdbc;

import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.TransicaoTO;
import br.com.intraBSC.persistencia.BscDaoJDBCGenerico;
import br.com.intraPRO.persistencia.TransicaoDAO;

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


public class TransicaoDAOJDBC extends BscDaoJDBCGenerico implements TransicaoDAO {

    public TransicaoDAOJDBC(DaoManager daoManager) {
		super(daoManager);		
	}


	private static Log log = LogFactory.getLog(TransicaoDAOJDBC.class);

    protected static final String TABELA = "LINKAGE";
    protected static final String posCondicaoId = "EFFECTREF";
    protected static final String preCondicaoId = "CAUSEREF";
    protected static final String interacao = "INTERACTION";
    protected static final String intensidade = "DEGREESTRENGTH";


    private Connection getconexao(){
        return getConnection();
    }

    @SuppressWarnings("unchecked")
	public Collection consultarVarios(TransicaoTO transicaoTO) throws ExceptionPersistenciaPRO{
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + posCondicaoId + ", ");
        sql.append("A." + preCondicaoId + ", ");
        sql.append("A." + interacao + ", ");
        sql.append("A." + intensidade + ", ");
        sql.append("B." + AtividadeDAOJDBC.NOME_ATIVIDADE + " ");
        sql.append("FROM " + TABELA + " A, ");
        sql.append( AtividadeDAOJDBC.TABELA + " B ");
        sql.append("WHERE 1=1 ");

        if (transicaoTO.getPosCondicaoId() != 0){
            sql.append(" AND A." + posCondicaoId + " = ? ");
            sql.append(" AND B." + AtividadeDAOJDBC.ID_ATIVIDADE + " = A. "+ preCondicaoId);
        }
        if (transicaoTO.getPreCondicaoId() != 0){
            sql.append(" AND A." + preCondicaoId + " = ? ");
            sql.append(" AND B." + AtividadeDAOJDBC.ID_ATIVIDADE + " = A. "+ posCondicaoId);
        }
        if ((transicaoTO.getInteracao() != null) && (!transicaoTO.getInteracao().equals("")) ){
            sql.append(" AND UCASE(A." + interacao + ") LIKE ? ");
        }
        if ((transicaoTO.getIntensidade() != null) && (!transicaoTO.getIntensidade().equals("")) ){
            sql.append(" AND UCASE(A." + intensidade + ") LIKE ? ");
        }


        PreparedStatement stmt;
        try {
          stmt = getconexao().prepareStatement(sql.toString());
        int i = 0;
        if (transicaoTO.getPosCondicaoId() != 0){
            stmt.setInt(++i,transicaoTO.getPosCondicaoId());
        }
        if (transicaoTO.getPreCondicaoId() != 0){
            stmt.setInt(++i,transicaoTO.getPreCondicaoId());
        }
        if ((transicaoTO.getInteracao() != null) && (!transicaoTO.getInteracao().equals("")) ){
           stmt.setString(++i,"%"+ transicaoTO.getInteracao()+"%");
        }
        if ((transicaoTO.getIntensidade() != null) && (!transicaoTO.getIntensidade().equals("")) ){
           stmt.setString(++i,"%"+ transicaoTO.getIntensidade()+"%");
        }

             ResultSet resultado = stmt.executeQuery();
             TransicaoTO retorno = new TransicaoTO();
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


    public TransicaoTO consultarUm(TransicaoTO transicaoTO) throws ExceptionPersistenciaPRO {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + posCondicaoId + ", ");
        sql.append("A." + preCondicaoId + ", ");
        sql.append("A." + interacao + ", ");
        sql.append("A." + intensidade + " ");
        sql.append("FROM " + TABELA + " A ");
        sql.append("WHERE 1=1 ");

        if (transicaoTO.getPosCondicaoId() != 0){
            sql.append(" AND A." + posCondicaoId + " =? ");
        }
        if (transicaoTO.getPreCondicaoId() != 0){
            sql.append(" AND A." + preCondicaoId + " =? ");
        }
        if ((transicaoTO.getInteracao() != null) && (!transicaoTO.getInteracao().equals("")) ){
            sql.append(" AND A." + interacao + " LIKE ? ");
        }
        if ((transicaoTO.getIntensidade() != null) && (!transicaoTO.getIntensidade().equals("")) ){
            sql.append(" AND A." + intensidade + " LIKE ? ");
        }


        PreparedStatement stmt;
        try {
			 stmt = getconexao().prepareStatement(sql.toString());
        int i = 0;
        if (transicaoTO.getPosCondicaoId() != 0){
            stmt.setInt(++i,transicaoTO.getPosCondicaoId());
        }
        if (transicaoTO.getPreCondicaoId() != 0){
            stmt.setInt(++i,transicaoTO.getPreCondicaoId());
        }
        if ((transicaoTO.getInteracao() != null) && (!transicaoTO.getInteracao().equals("")) ){
           stmt.setString(++i,"%"+ transicaoTO.getInteracao()+"%");
        }
        if ((transicaoTO.getIntensidade() != null) && (!transicaoTO.getIntensidade().equals("")) ){
           stmt.setString(++i,"%"+ transicaoTO.getIntensidade()+"%");
        }

             ResultSet resultado = stmt.executeQuery();
             TransicaoTO retorno = new TransicaoTO();
             while (resultado.next()) {
            	 retorno.setPosCondicaoId(resultado.getInt(1));
                 retorno.setPreCondicaoId(resultado.getInt(2));
                 retorno.setInteracao(resultado.getString(3));
                 retorno.setIntensidade(resultado.getString(4));
             }
             return retorno;
        } catch (Exception e) {
              log.error(e.getMessage());
              throw new DaoException(e.getMessage());
        }
    }


    public void incluir(TransicaoTO transicaoTO) throws ExceptionPersistenciaPRO {
        StringBuffer sql = new StringBuffer("INSERT INTO ");
        sql.append(TABELA + "(");
        sql.append( posCondicaoId+", ");
        sql.append( preCondicaoId+", ");
        sql.append( interacao+", ");
        sql.append( intensidade+" ");
        sql.append(") VALUES (?,?,?,?)");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
        int i = 0;
        if (transicaoTO.getPosCondicaoId() != 0){
            stmt.setInt(++i,transicaoTO.getPosCondicaoId());
        }
        if (transicaoTO.getPreCondicaoId() != 0){
            stmt.setInt(++i,transicaoTO.getPreCondicaoId());
        }
        if ((transicaoTO.getInteracao() != null) && (!transicaoTO.getInteracao().equals("")) ){
           stmt.setString(++i, transicaoTO.getInteracao());
        }
        if ((transicaoTO.getIntensidade() != null) && (!transicaoTO.getIntensidade().equals("")) ){
           stmt.setString(++i,transicaoTO.getIntensidade());
        }

            stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }


    public void alterar(TransicaoTO transicaoTO) throws ExceptionPersistenciaPRO {
        StringBuffer sql = new StringBuffer("UPDATE ");
        sql.append(TABELA + " SET ");
        sql.append( interacao + " = ?, ");
        sql.append( intensidade + " = ? ");
        sql.append(" WHERE 1=1 ");
        sql.append("AND " + preCondicaoId  + " = ? ");
        sql.append("AND " + posCondicaoId  + " = ? ");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());

	        int i = 0;
	        
	        
	        if ((transicaoTO.getInteracao() != null) && (!transicaoTO.getInteracao().equals("")) ){
	           stmt.setString(++i,transicaoTO.getInteracao());
	        }
	        if ((transicaoTO.getIntensidade() != null) && (!transicaoTO.getIntensidade().equals("")) ){
	           stmt.setString(++i,transicaoTO.getIntensidade());
	        }
	        if (transicaoTO.getPreCondicaoId() != 0){
	            stmt.setInt(++i,transicaoTO.getPreCondicaoId());
	        }
	        if (transicaoTO.getPosCondicaoId() != 0){
	            stmt.setInt(++i,transicaoTO.getPosCondicaoId());
	        }
  

            stmt.executeUpdate();
         } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
         }
    }


    public void excluir(TransicaoTO transicaoTO) throws ExceptionPersistenciaPRO {
        StringBuffer sql = new StringBuffer("DELETE FROM ");
        sql.append(TABELA);
        sql.append(" WHERE 1=1 ");
        if (transicaoTO.getPreCondicaoId() != 0){
            sql.append(" AND " + preCondicaoId + " = ? ");
        }
        if (transicaoTO.getPosCondicaoId() != 0){
            sql.append(" AND " + posCondicaoId + " = ? ");
        }
        PreparedStatement stmt;
        try {
             int i = 0;
             stmt = getconexao().prepareStatement(sql.toString());
             if (transicaoTO.getPreCondicaoId() != 0){
                   stmt.setInt(++i,transicaoTO.getPreCondicaoId());
             }
             if (transicaoTO.getPosCondicaoId() != 0){
                 stmt.setInt(++i,transicaoTO.getPosCondicaoId());
             }
             stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }


    private TransicaoTO carregaTO(ResultSet resultado) throws SQLException{
        TransicaoTO transicaoTO = new TransicaoTO();
        int i = 0;
        transicaoTO.setPosCondicaoId(resultado.getInt(++i));
        transicaoTO.setPreCondicaoId(resultado.getInt(++i));
        transicaoTO.setInteracao(resultado.getString(++i));
        transicaoTO.setIntensidade(resultado.getString(++i));
        transicaoTO.setNomeAtividade(resultado.getString(++i));
    return transicaoTO;
    }

	public int consultarMax(TransicaoTO transicaoTO) throws ExceptionPersistenciaPRO {
		return 0;
	}
}