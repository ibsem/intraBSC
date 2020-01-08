package br.com.intraPRO.persistencia.jdbc;

import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.RelacionamentosTO;
import br.com.intraBSC.persistencia.BscDaoJDBCGenerico;
import br.com.intraPRO.persistencia.RelacionamentosDAO;
import br.com.intraPRO.modelo.ConfigTarefaTO;


import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class RelacionamentosDAOJDBC extends BscDaoJDBCGenerico implements RelacionamentosDAO {

    private static Log log = LogFactory.getLog(RelacionamentosDAOJDBC.class);

    protected static final String TABELA = "RELPROCESS";
    
    protected static final String TABELA_FASE = "RELFASE";
    
      
    protected static final String PROIDPRO = "PRO_ID";
    protected static final String PROIDFAS = "FASE_ID";
    protected static final String FASIDFAS = "FASE_ID";
    protected static final String FASIDATV = "ATIVIDADE_ID";
    protected static final String ATVIDATV = "ATIVIDADE_ID";
    
    
    /*Variaveis referente a tabela de relacionamento de configuracao da tarefa com responsavel*/
    public static final String TABELA_REL_CONFIG_TAREFA = "RELCONFIGTASKOWNER";
    public static final String ID_RESPONSAVEL_REL = "OWNER_ID";
    public static final String ID_CONFIG_TAREFA_REL = "CONFIG_TASK_ID";

    public RelacionamentosDAOJDBC(DaoManager daoManager) {
        super(daoManager);
    }

    private Connection getconexao(){
        return getConnection();
    }

    @SuppressWarnings("unchecked")
	public Collection consultarVariosPRO(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaPRO{
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + PROIDPRO + ", ");
        sql.append("A." + PROIDFAS + " ");        
        sql.append("FROM " + TABELA + " A ");
        sql.append("WHERE 1=1 ");

        if (relacionamentosTO.getPROIDPRO() != 0){
            sql.append(" AND A." + PROIDPRO + " =? ");
        }
        if (relacionamentosTO.getPROIDFAS() != 0){
            sql.append(" AND A." + PROIDFAS + " =? ");
        }
       
        PreparedStatement stmt;
        try {
          stmt = getconexao().prepareStatement(sql.toString());
        int i = 0;
        if (relacionamentosTO.getPROIDPRO() != 0){
            stmt.setInt(++i,relacionamentosTO.getPROIDPRO());
        }
        if (relacionamentosTO.getPROIDFAS() != 0){
            stmt.setInt(++i,relacionamentosTO.getPROIDFAS());
        }
        
             ResultSet resultado = stmt.executeQuery();             
             Collection lista = new ArrayList();
             while (resultado.next()) {
            	  RelacionamentosTO relacionamentosTOReturn = new RelacionamentosTO();
                  int j = 0;
                  relacionamentosTOReturn.setPROIDPRO(resultado.getInt(++j));
                  relacionamentosTOReturn.setPROIDFAS(resultado.getInt(++j));
                  lista.add(relacionamentosTOReturn);
             }
             return lista;
        } catch (Exception e) {
              log.error(e.getMessage());
              throw new DaoException(e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
	public Collection consultarVariosFAS(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaPRO{
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");        
        sql.append("A." + FASIDFAS + ", ");
        sql.append("A." + FASIDATV + " ");        
        sql.append("FROM " + TABELA_FASE + " A ");
        sql.append("WHERE 1=1 ");

        if (relacionamentosTO.getFASIDFAS() != 0){
            sql.append(" AND A." + FASIDFAS + " =? ");
        }
        if (relacionamentosTO.getFASIDATV() != 0){
            sql.append(" AND A." + FASIDATV + " =? ");
        }

        PreparedStatement stmt;
        try {
          stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	
	        if (relacionamentosTO.getFASIDFAS() != 0){
	            stmt.setInt(++i,relacionamentosTO.getFASIDFAS());
	        }
	        if (relacionamentosTO.getFASIDATV() != 0){
	            stmt.setInt(++i,relacionamentosTO.getFASIDATV());
	        }


             ResultSet resultado = stmt.executeQuery();
             Collection lista = new ArrayList();
             while (resultado.next()) {
            	  RelacionamentosTO relacionamentosTOReturn = new RelacionamentosTO();
                  int j = 0;
                  relacionamentosTOReturn.setFASIDFAS(resultado.getInt(++j));
                  relacionamentosTOReturn.setFASIDATV(resultado.getInt(++j));
                  lista.add(relacionamentosTOReturn);
             }
             return lista;
        } catch (Exception e) {
              log.error(e.getMessage());
              throw new DaoException(e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")


    public RelacionamentosTO consultarUmPRO(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaPRO {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + PROIDPRO + ", ");
        sql.append("A." + PROIDFAS + " ");
        sql.append("FROM " + TABELA + " A ");
        sql.append("WHERE 1=1 ");

        if (relacionamentosTO.getPROIDPRO() != 0){
            sql.append(" AND A." + PROIDPRO + " =? ");
        }
        if (relacionamentosTO.getPROIDFAS() != 0){
            sql.append(" AND A." + PROIDFAS + " =? ");
        }
        PreparedStatement stmt;
        try {
			 stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        if (relacionamentosTO.getPROIDPRO() != 0){
	            stmt.setInt(++i,relacionamentosTO.getPROIDPRO());
	        }
	        if (relacionamentosTO.getPROIDFAS() != 0){
	            stmt.setInt(++i,relacionamentosTO.getPROIDFAS());
	        }
             ResultSet resultado = stmt.executeQuery();
             RelacionamentosTO retorno = new RelacionamentosTO();
             while (resultado.next()) {            	 
                 int j = 0;
                 retorno.setPROIDPRO(resultado.getInt(++j));
                 retorno.setPROIDFAS(resultado.getInt(++j));
             }
             return retorno;
        } catch (Exception e) {
              log.error(e.getMessage());
              throw new DaoException(e.getMessage());
        }
    }
    
    public RelacionamentosTO consultarUmFAS(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaPRO {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + FASIDFAS + ", ");
        sql.append("A." + FASIDATV + " ");
        sql.append("FROM " + TABELA_FASE + " A ");
        sql.append("WHERE 1=1 ");
       
        if (relacionamentosTO.getFASIDFAS() != 0){
            sql.append(" AND A." + FASIDFAS + " =? ");
        }
        if (relacionamentosTO.getFASIDATV() != 0){
            sql.append(" AND A." + FASIDATV + " =? ");
        }
        PreparedStatement stmt;
        try {
			 stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        
	        if (relacionamentosTO.getFASIDFAS() != 0){
	            stmt.setInt(++i,relacionamentosTO.getFASIDFAS());
	        }
	        if (relacionamentosTO.getFASIDATV() != 0){
	            stmt.setInt(++i,relacionamentosTO.getFASIDATV());
	        }
             ResultSet resultado = stmt.executeQuery();
             RelacionamentosTO retorno = new RelacionamentosTO();
             while (resultado.next()) {
            	 int j = 0;
            	 retorno.setFASIDFAS(resultado.getInt(++j));
            	 retorno.setFASIDATV(resultado.getInt(++j));
             }
             return retorno;
        } catch (Exception e) {
              log.error(e.getMessage());
              throw new DaoException(e.getMessage());
        }
    }
    
  

    public void incluirPRO(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaPRO {
        StringBuffer sql = new StringBuffer("INSERT INTO ");
        sql.append(TABELA + "(");
        sql.append( PROIDPRO+", ");
        sql.append( PROIDFAS+" ");
        sql.append(") VALUES (?,?)");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        if (relacionamentosTO.getPROIDPRO() != 0){
	            stmt.setInt(++i,relacionamentosTO.getPROIDPRO());
	        }
	        if (relacionamentosTO.getPROIDFAS() != 0){
	            stmt.setInt(++i,relacionamentosTO.getPROIDFAS());
	        }   
            stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }
    
    public void incluirFAS(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaPRO {
        StringBuffer sql = new StringBuffer("INSERT INTO ");
        sql.append(TABELA_FASE + "(");
        sql.append( FASIDFAS+", ");
        sql.append( FASIDATV+" ");
        sql.append(") VALUES (?,?)");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	      
	        if (relacionamentosTO.getFASIDFAS() != 0){
	            stmt.setInt(++i,relacionamentosTO.getFASIDFAS());
	        }
	        if (relacionamentosTO.getFASIDATV() != 0){
	            stmt.setInt(++i,relacionamentosTO.getFASIDATV());
	        }
            stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }
    
  
    public void alterarPRO(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaPRO {
        StringBuffer sql = new StringBuffer("UPDATE ");
        sql.append(TABELA + " SET ");
        //sql.append( PROIDPRO + " = ?, ");
        sql.append( PROIDFAS + " = ? ");
        sql.append(" WHERE 1=1 ");
        sql.append("AND " + PROIDPRO  + " = ? ");
        //sql.append("AND " + PROIDFAS  + " = ? ");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        if (relacionamentosTO.getPROIDFAS() != 0){
	            stmt.setInt(++i,relacionamentosTO.getPROIDFAS());
	        }
	        if (relacionamentosTO.getPROIDPRO() != 0){
	            stmt.setInt(++i,relacionamentosTO.getPROIDPRO());
	        }
            stmt.executeUpdate();
         } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
         }
    }
    
    public void alterarFAS(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaPRO {
        StringBuffer sql = new StringBuffer("UPDATE ");
        sql.append(TABELA_FASE);
       // sql.append( FASIDATV + " = ? ");
        sql.append(" WHERE 1=1 ");
        //sql.append("AND " + FASIDFAS  + " = ? ");
        sql.append("AND " + FASIDATV  + " = ? ");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	       
	        if (relacionamentosTO.getFASIDFAS() != 0){
	            stmt.setInt(++i,relacionamentosTO.getFASIDFAS());
	        }
	        if (relacionamentosTO.getFASIDATV() != 0){
	            stmt.setInt(++i,relacionamentosTO.getFASIDATV());
	        }
            stmt.executeUpdate();
         } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
         }
    }
    
  

   /* public void excluir(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaPRO {
        StringBuffer sql = new StringBuffer("DELETE FROM ");
        sql.append(TABELA);
        sql.append(" WHERE 1=1 ");
        if (relacionamentosTO.getId() != 0){
            sql.append(" AND " + COLOCAR ID + " =? ");
        }
        PreparedStatement stmt;
        try {
             int i = 0;
             stmt = getconexao().prepareStatement(sql.toString());
             if (relacionamentosTO.getId() != 0){
                   stmt.setInt(++i,relacionamentosTO.getId());
             }
             stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }*/

	public void excluir(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaPRO {
		
	}

	
	


	public void incluirRelCONFIGTASKOWNER(ConfigTarefaTO configTarefaTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("INSERT INTO ");
        sql.append(TABELA_REL_CONFIG_TAREFA + "(");
        sql.append( ID_CONFIG_TAREFA_REL+", ");
        sql.append( ID_RESPONSAVEL_REL+" ");
        sql.append(") VALUES (?,?)");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0; 
	        if (configTarefaTO.getCodigoConfigTarefa() != 0){
	            stmt.setInt(++i,configTarefaTO.getCodigoConfigTarefa());
	        }
	        if (configTarefaTO.getIdResponsavel() != 0){
	            stmt.setInt(++i,configTarefaTO.getIdResponsavel());
	        }
            stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
		
	}

	public void alterarRelCONFIGTASKOWNER(ConfigTarefaTO configTarefaTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("UPDATE ");
		sql.append(TABELA_REL_CONFIG_TAREFA + " SET ");
		sql.append( ID_RESPONSAVEL_REL+" = ? ");
        sql.append(" WHERE 1=1 ");
     
        sql.append(" AND "+ ID_CONFIG_TAREFA_REL +" = ? ");
        
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        if (configTarefaTO.getIdResponsavel() != 0){
	            stmt.setInt(++i,configTarefaTO.getIdResponsavel());
	        }
	        stmt.setInt(++i,configTarefaTO.getCodigoConfigTarefa());
	        
            stmt.executeUpdate();
         } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
         }
	}

}
