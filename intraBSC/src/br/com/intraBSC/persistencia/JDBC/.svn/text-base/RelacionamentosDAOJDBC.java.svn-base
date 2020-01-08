package br.com.intraBSC.persistencia.JDBC;

import br.com.intraBSC.excecoes.ExceptionPersistenciaBSC;
import br.com.intraBSC.modelo.RelacionamentosTO;
import br.com.intraBSC.persistencia.BscDaoJDBCGenerico;
import br.com.intraBSC.persistencia.RelacionamentosDAO;
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

    protected static final String TABELA = "RELBSC";
    
    protected static final String TABELA_PERSPECTIVE = "RELPERSPECTIVE";
    
    protected static final String TABELA_THEME = "RELTHEME";
    
    protected static final String BSCIDBSC = "BSC_ID";
    protected static final String BSCIDPERS = "PERSPECTIVE_ID";
    protected static final String PERSIDPERS = "PERSPECTIVE_ID";
    protected static final String PERSIDOBJ = "OBJECTIVE_ID";
    protected static final String OBJIDTHEME = "THEME_ID";
    protected static final String OBJIDOBJ = "OBJECTIVE_ID";
    
    
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
	public Collection consultarVariosBSC(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaBSC{
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + BSCIDBSC + ", ");
        sql.append("A." + BSCIDPERS + " ");        
        sql.append("FROM " + TABELA + " A ");
        sql.append("WHERE 1=1 ");

        if (relacionamentosTO.getBSCIDBSC() != 0){
            sql.append(" AND A." + BSCIDBSC + " =? ");
        }
        if (relacionamentosTO.getBSCIDPERS() != 0){
            sql.append(" AND A." + BSCIDPERS + " =? ");
        }
       
        PreparedStatement stmt;
        try {
          stmt = getconexao().prepareStatement(sql.toString());
        int i = 0;
        if (relacionamentosTO.getBSCIDBSC() != 0){
            stmt.setInt(++i,relacionamentosTO.getBSCIDBSC());
        }
        if (relacionamentosTO.getBSCIDPERS() != 0){
            stmt.setInt(++i,relacionamentosTO.getBSCIDPERS());
        }
        
             ResultSet resultado = stmt.executeQuery();             
             Collection lista = new ArrayList();
             while (resultado.next()) {
            	  RelacionamentosTO relacionamentosTOReturn = new RelacionamentosTO();
                  int j = 0;
                  relacionamentosTOReturn.setBSCIDBSC(resultado.getInt(++j));
                  relacionamentosTOReturn.setBSCIDPERS(resultado.getInt(++j));
                  lista.add(relacionamentosTOReturn);
             }
             return lista;
        } catch (Exception e) {
              log.error(e.getMessage());
              throw new DaoException(e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
	public Collection consultarVariosPERS(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaBSC{
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");        
        sql.append("A." + PERSIDPERS + ", ");
        sql.append("A." + PERSIDOBJ + " ");        
        sql.append("FROM " + TABELA_PERSPECTIVE + " A ");
        sql.append("WHERE 1=1 ");

        if (relacionamentosTO.getPERSIDPERS() != 0){
            sql.append(" AND A." + PERSIDPERS + " =? ");
        }
        if (relacionamentosTO.getPERSIDOBJ() != 0){
            sql.append(" AND A." + PERSIDOBJ + " =? ");
        }

        PreparedStatement stmt;
        try {
          stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	
	        if (relacionamentosTO.getPERSIDPERS() != 0){
	            stmt.setInt(++i,relacionamentosTO.getPERSIDPERS());
	        }
	        if (relacionamentosTO.getPERSIDOBJ() != 0){
	            stmt.setInt(++i,relacionamentosTO.getPERSIDOBJ());
	        }


             ResultSet resultado = stmt.executeQuery();
             Collection lista = new ArrayList();
             while (resultado.next()) {
            	  RelacionamentosTO relacionamentosTOReturn = new RelacionamentosTO();
                  int j = 0;
                  relacionamentosTOReturn.setPERSIDPERS(resultado.getInt(++j));
                  relacionamentosTOReturn.setPERSIDOBJ(resultado.getInt(++j));
                  lista.add(relacionamentosTOReturn);
             }
             return lista;
        } catch (Exception e) {
              log.error(e.getMessage());
              throw new DaoException(e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
	public Collection consultarVariosTHEME(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaBSC{
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + OBJIDTHEME + ", ");
        sql.append("A." + OBJIDOBJ + " ");
        sql.append("FROM " + TABELA_THEME + " A ");
        sql.append("WHERE 1=1 ");


        if (relacionamentosTO.getOBJIDTHEME() != 0){
            sql.append(" AND A." + OBJIDTHEME + " =? ");
        }
        if (relacionamentosTO.getOBJIDOBJ() != 0){
            sql.append(" AND A." + OBJIDOBJ + " =? ");
        }


        PreparedStatement stmt;
        try {
          stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	
	        if (relacionamentosTO.getOBJIDTHEME() != 0){
	            stmt.setInt(++i,relacionamentosTO.getOBJIDTHEME());
	        }
	        if (relacionamentosTO.getOBJIDOBJ() != 0){
	            stmt.setInt(++i,relacionamentosTO.getOBJIDOBJ());
	        }

             ResultSet resultado = stmt.executeQuery();
             Collection lista = new ArrayList();
             while (resultado.next()) {
            	  RelacionamentosTO relacionamentosTOReturn = new RelacionamentosTO();
                  int j = 0;                  
                  relacionamentosTOReturn.setOBJIDTHEME(resultado.getInt(++j));
                  relacionamentosTOReturn.setOBJIDOBJ(resultado.getInt(++j));
                  lista.add(relacionamentosTOReturn);
             }
             return lista;
        } catch (Exception e) {
              log.error(e.getMessage());
              throw new DaoException(e.getMessage());
        }
    }


    public RelacionamentosTO consultarUmBSC(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + BSCIDBSC + ", ");
        sql.append("A." + BSCIDPERS + " ");
        sql.append("FROM " + TABELA + " A ");
        sql.append("WHERE 1=1 ");

        if (relacionamentosTO.getBSCIDBSC() != 0){
            sql.append(" AND A." + BSCIDBSC + " =? ");
        }
        if (relacionamentosTO.getBSCIDPERS() != 0){
            sql.append(" AND A." + BSCIDPERS + " =? ");
        }
        PreparedStatement stmt;
        try {
			 stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        if (relacionamentosTO.getBSCIDBSC() != 0){
	            stmt.setInt(++i,relacionamentosTO.getBSCIDBSC());
	        }
	        if (relacionamentosTO.getBSCIDPERS() != 0){
	            stmt.setInt(++i,relacionamentosTO.getBSCIDPERS());
	        }
             ResultSet resultado = stmt.executeQuery();
             RelacionamentosTO retorno = new RelacionamentosTO();
             while (resultado.next()) {            	 
                 int j = 0;
                 retorno.setBSCIDBSC(resultado.getInt(++j));
                 retorno.setBSCIDPERS(resultado.getInt(++j));
             }
             return retorno;
        } catch (Exception e) {
              log.error(e.getMessage());
              throw new DaoException(e.getMessage());
        }
    }
    
    public RelacionamentosTO consultarUmPERS(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + PERSIDPERS + ", ");
        sql.append("A." + PERSIDOBJ + " ");
        sql.append("FROM " + TABELA_PERSPECTIVE + " A ");
        sql.append("WHERE 1=1 ");
       
        if (relacionamentosTO.getPERSIDPERS() != 0){
            sql.append(" AND A." + PERSIDPERS + " =? ");
        }
        if (relacionamentosTO.getPERSIDOBJ() != 0){
            sql.append(" AND A." + PERSIDOBJ + " =? ");
        }
        PreparedStatement stmt;
        try {
			 stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        
	        if (relacionamentosTO.getPERSIDPERS() != 0){
	            stmt.setInt(++i,relacionamentosTO.getPERSIDPERS());
	        }
	        if (relacionamentosTO.getPERSIDOBJ() != 0){
	            stmt.setInt(++i,relacionamentosTO.getPERSIDOBJ());
	        }
             ResultSet resultado = stmt.executeQuery();
             RelacionamentosTO retorno = new RelacionamentosTO();
             while (resultado.next()) {
            	 int j = 0;
            	 retorno.setPERSIDPERS(resultado.getInt(++j));
            	 retorno.setPERSIDOBJ(resultado.getInt(++j));
             }
             return retorno;
        } catch (Exception e) {
              log.error(e.getMessage());
              throw new DaoException(e.getMessage());
        }
    }
    
    public RelacionamentosTO consultarUmTHEME(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + OBJIDTHEME + ", ");
        sql.append("A." + OBJIDOBJ + " ");
        sql.append("FROM " + TABELA_THEME + " A ");
        sql.append("WHERE 1=1 ");       
        if (relacionamentosTO.getOBJIDTHEME() != 0){
            sql.append(" AND A." + OBJIDTHEME + " =? ");
        }
        if (relacionamentosTO.getOBJIDOBJ() != 0){
            sql.append(" AND A." + OBJIDOBJ + " =? ");
        }
        PreparedStatement stmt;
        try {
			 stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        
	        if (relacionamentosTO.getOBJIDTHEME() != 0){
	            stmt.setInt(++i,relacionamentosTO.getOBJIDTHEME());
	        }
	        if (relacionamentosTO.getOBJIDOBJ() != 0){
	            stmt.setInt(++i,relacionamentosTO.getOBJIDOBJ());
	        }
             ResultSet resultado = stmt.executeQuery();
             RelacionamentosTO retorno = new RelacionamentosTO();
             while (resultado.next()) {
            	 int j = 0;                  
            	 retorno.setOBJIDTHEME(resultado.getInt(++j));
            	 retorno.setOBJIDOBJ(resultado.getInt(++j));
             }
             return retorno;
        } catch (Exception e) {
              log.error(e.getMessage());
              throw new DaoException(e.getMessage());
        }
    }


    public void incluirBSC(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("INSERT INTO ");
        sql.append(TABELA + "(");
        sql.append( BSCIDBSC+", ");
        sql.append( BSCIDPERS+" ");
        sql.append(") VALUES (?,?)");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        if (relacionamentosTO.getBSCIDBSC() != 0){
	            stmt.setInt(++i,relacionamentosTO.getBSCIDBSC());
	        }
	        if (relacionamentosTO.getBSCIDPERS() != 0){
	            stmt.setInt(++i,relacionamentosTO.getBSCIDPERS());
	        }   
            stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }
    
    public void incluirPERS(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("INSERT INTO ");
        sql.append(TABELA_PERSPECTIVE + "(");
        sql.append( PERSIDPERS+", ");
        sql.append( PERSIDOBJ+" ");
        sql.append(") VALUES (?,?)");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	      
	        if (relacionamentosTO.getPERSIDPERS() != 0){
	            stmt.setInt(++i,relacionamentosTO.getPERSIDPERS());
	        }
	        if (relacionamentosTO.getPERSIDOBJ() != 0){
	            stmt.setInt(++i,relacionamentosTO.getPERSIDOBJ());
	        }
            stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }
    
    public void incluirTHEME(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("INSERT INTO ");
        sql.append(TABELA_THEME + "(");
        sql.append( OBJIDTHEME+", ");
        sql.append( OBJIDOBJ+" ");
        sql.append(") VALUES (?,?)");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0; 
	        if (relacionamentosTO.getOBJIDTHEME() != 0){
	            stmt.setInt(++i,relacionamentosTO.getOBJIDTHEME());
	        }
	        if (relacionamentosTO.getOBJIDOBJ() != 0){
	            stmt.setInt(++i,relacionamentosTO.getOBJIDOBJ());
	        }
            stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }


    public void alterarBSC(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("UPDATE ");
        sql.append(TABELA + " SET ");
        //sql.append( BSCIDBSC + " = ?, ");
        sql.append( BSCIDPERS + " = ? ");
        sql.append(" WHERE 1=1 ");
        sql.append("AND " + BSCIDBSC  + " = ? ");
        //sql.append("AND " + BSCIDPERS  + " = ? ");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        if (relacionamentosTO.getBSCIDPERS() != 0){
	            stmt.setInt(++i,relacionamentosTO.getBSCIDPERS());
	        }
	        if (relacionamentosTO.getBSCIDBSC() != 0){
	            stmt.setInt(++i,relacionamentosTO.getBSCIDBSC());
	        }
            stmt.executeUpdate();
         } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
         }
    }
    
    public void alterarPERS(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("UPDATE ");
        sql.append(TABELA_PERSPECTIVE + " SET ");
        sql.append( PERSIDPERS + " = ? ");
       // sql.append( PERSIDOBJ + " = ? ");
        sql.append(" WHERE 1=1 ");
        //sql.append("AND " + PERSIDPERS  + " = ? ");
        sql.append("AND " + PERSIDOBJ  + " = ? ");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	       
	        if (relacionamentosTO.getPERSIDPERS() != 0){
	            stmt.setInt(++i,relacionamentosTO.getPERSIDPERS());
	        }
	        if (relacionamentosTO.getPERSIDOBJ() != 0){
	            stmt.setInt(++i,relacionamentosTO.getPERSIDOBJ());
	        }
            stmt.executeUpdate();
         } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
         }
    }
    
    public void alterarTHEME(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("UPDATE ");
        sql.append(TABELA_THEME + " SET ");
        sql.append( OBJIDTHEME + " = ? ");
       // sql.append( OBJIDOBJ + " = ? ");
        sql.append(" WHERE 1=1 ");
       // sql.append("AND " + OBJIDTHEME  + " = ? ");
        sql.append("AND " + OBJIDOBJ  + " = ? ");
        
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        if (relacionamentosTO.getOBJIDTHEME() != 0){
	            stmt.setInt(++i,relacionamentosTO.getOBJIDTHEME());
	        }
	        if (relacionamentosTO.getOBJIDOBJ() != 0){
	            stmt.setInt(++i,relacionamentosTO.getOBJIDOBJ());
	        }
	        
            stmt.executeUpdate();
         } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
         }
    }


   /* public void excluir(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaBSC {
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

	public void excluir(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaBSC {
		
	}

	
	


	public void incluirRelCONFIGTASKOWNER(ConfigTarefaTO configTarefaTO) throws ExceptionPersistenciaBSC {
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

	public void alterarRelCONFIGTASKOWNER(ConfigTarefaTO configTarefaTO) throws ExceptionPersistenciaBSC {
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
