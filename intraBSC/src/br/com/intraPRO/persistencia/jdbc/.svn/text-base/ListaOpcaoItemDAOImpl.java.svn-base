package br.com.intraPRO.persistencia.jdbc;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;

import br.com.intraBSC.persistencia.BscDaoJDBCGenerico;
import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.ListaOpcaoItemTO;
import br.com.intraPRO.persistencia.ListaOpcaoItemDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ListaOpcaoItemDAOImpl extends BscDaoJDBCGenerico implements ListaOpcaoItemDAO {

    private static Log log = LogFactory.getLog(ListaOpcaoItemDAOImpl.class);

    protected static final String TABELA = "OPTIONLISTITEM";
    protected static final String CODIGO_TIPO_TAREFA = "PK_CONFIGTASK";
    protected static final String NUM_ORDEM_ITEM = "PK_ORDER_FIELD";
    protected static final String CODIGO = "PK_SEQUENCE_LS_OPTION";
    protected static final String TEXTO_OPCAO = "TX_OPTIONLISTFIELD";

    public ListaOpcaoItemDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

    private Connection getConexao(){
        return getConnection();
    }

    @SuppressWarnings("unchecked")
	public Collection consultarVarios(ListaOpcaoItemTO listaOpcaoItemTO) throws ExceptionPersistenciaPRO{
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + CODIGO_TIPO_TAREFA + ", ");
        sql.append("A." + NUM_ORDEM_ITEM + ", ");
        sql.append("A." + CODIGO + ", ");
        sql.append("A." + TEXTO_OPCAO + " ");
        sql.append("FROM " + TABELA + " A ");
        

        clausulaWhereConsulta(listaOpcaoItemTO,sql);
        int i = 0; 
        PreparedStatement stmt;
        try {
			 stmt = getConexao().prepareStatement(sql.toString());
             
			 if (listaOpcaoItemTO.getCodConfigTarefa() != 0){
				 stmt.setInt(++i, listaOpcaoItemTO.getCodConfigTarefa());				
			 }
			 if (listaOpcaoItemTO.getNumeroOrdem() != 0){
				 stmt.setInt(++i, listaOpcaoItemTO.getNumeroOrdem());
			 }
			 if (listaOpcaoItemTO.getCodigo() != 0){
				 stmt.setInt(++i, listaOpcaoItemTO.getCodigo());
			 }
			 if ((listaOpcaoItemTO.getTexto() != null) && (!listaOpcaoItemTO.getTexto().equals("")) ){
				 stmt.setString(++i, listaOpcaoItemTO.getTexto());
			 }
			 
             ResultSet resultado = stmt.executeQuery();
             ListaOpcaoItemTO retorno = new ListaOpcaoItemTO();
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


    public ListaOpcaoItemTO consultarUm(ListaOpcaoItemTO listaOpcaoItemTO) throws ExceptionPersistenciaPRO{
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + CODIGO_TIPO_TAREFA + ", ");
        sql.append("A." + NUM_ORDEM_ITEM + ", ");
        sql.append("A." + CODIGO + ", ");
        sql.append("A." + TEXTO_OPCAO + " ");
        sql.append("FROM " + TABELA + " A ");

        clausulaWhereConsulta(listaOpcaoItemTO,sql);

        PreparedStatement stmt;
        try {
        	 int i = 0;	
			 stmt = getConexao().prepareStatement(sql.toString());
			 if (listaOpcaoItemTO.getCodConfigTarefa() != 0){
				 stmt.setInt(++i, listaOpcaoItemTO.getCodConfigTarefa());				
			 }
			 if (listaOpcaoItemTO.getNumeroOrdem() != 0){
				 stmt.setInt(++i, listaOpcaoItemTO.getNumeroOrdem());
			 }
			 if (listaOpcaoItemTO.getCodigo() != 0){
				 stmt.setInt(++i, listaOpcaoItemTO.getCodigo());
			 }
			 if ((listaOpcaoItemTO.getTexto() != null) && (!listaOpcaoItemTO.getTexto().equals("")) ){
				 stmt.setString(++i, listaOpcaoItemTO.getTexto());
			 }
             ResultSet resultado = stmt.executeQuery();
             ListaOpcaoItemTO retorno = new ListaOpcaoItemTO();
             while (resultado.next()) {
                  retorno = carregaTO(resultado);                  
             }
             return retorno;
        } catch (Exception e) {
              log.error(e.getMessage());
              throw new DaoException(e.getMessage());
        }
    }


    public void incluir(ListaOpcaoItemTO listaOpcaoItemTO) throws ExceptionPersistenciaPRO{
        StringBuffer sql = new StringBuffer("INSERT INTO ");
        sql.append(TABELA + "(");
        sql.append(CODIGO_TIPO_TAREFA+", ");
        sql.append(NUM_ORDEM_ITEM+", ");
        sql.append(CODIGO+", ");
        sql.append(TEXTO_OPCAO+" ");
        sql.append(") VALUES (");
        if (listaOpcaoItemTO.getCodConfigTarefa() != 0){
            sql.append(" ?, ");
        }
        if (listaOpcaoItemTO.getNumeroOrdem() != 0){
        	sql.append(" ?, ");
        }
        if (listaOpcaoItemTO.getCodigo() != 0){
        	sql.append(" ?, ");
        }
        if ((listaOpcaoItemTO.getTexto() != null) && (!listaOpcaoItemTO.getTexto().equals("")) ){
            sql.append(" ? ");
        }else {
            sql.delete(sql.length() - 2, sql.length());
        }
        sql.append(")");
        PreparedStatement stmt;
        try {
            stmt = getConexao().prepareStatement(sql.toString());
            int i = 0;
            if (listaOpcaoItemTO.getCodConfigTarefa() != 0){
				 stmt.setInt(++i, listaOpcaoItemTO.getCodConfigTarefa());				
			 }
			 if (listaOpcaoItemTO.getNumeroOrdem() != 0){
				 stmt.setInt(++i, listaOpcaoItemTO.getNumeroOrdem());
			 }
			 if (listaOpcaoItemTO.getCodigo() != 0){
				 stmt.setInt(++i, listaOpcaoItemTO.getCodigo());
			 }
			 if ((listaOpcaoItemTO.getTexto() != null) && (!listaOpcaoItemTO.getTexto().equals("")) ){
				 stmt.setString(++i, listaOpcaoItemTO.getTexto().trim());
			 }
            stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }


    public void alterar(ListaOpcaoItemTO listaOpcaoItemTO) throws ExceptionPersistenciaPRO{
        StringBuffer sql = new StringBuffer("UPDATE ");
        sql.append(TABELA + " SET ");
        sql.append(CODIGO_TIPO_TAREFA+" = ?, ");
        sql.append(NUM_ORDEM_ITEM+" = ?, ");
        sql.append(CODIGO+" = ?, ");
        sql.append(TEXTO_OPCAO+" = ? ");
        sql.append(" WHERE 1=1 ");
        sql.append("AND " + CODIGO  + " = ? ");
        PreparedStatement stmt;
        try {
            int i = 0;
            stmt = getConexao().prepareStatement(sql.toString());

            stmt.setInt(++i,listaOpcaoItemTO.getCodConfigTarefa());
            stmt.setInt(++i,listaOpcaoItemTO.getNumeroOrdem());
            stmt.setInt(++i,listaOpcaoItemTO.getCodigo());
            stmt.setString(++i,listaOpcaoItemTO.getTexto().trim());

            stmt.setInt(++i,listaOpcaoItemTO.getCodigo());
            stmt.executeUpdate();
         } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
         }
    }


    public void excluir(ListaOpcaoItemTO listaOpcaoItemTO) throws ExceptionPersistenciaPRO{
        StringBuffer sql = new StringBuffer("DELETE FROM ");
        sql.append(TABELA);
        sql.append(" WHERE 1=1 ");
        if (listaOpcaoItemTO.getCodigo() != 0){
            sql.append(" AND " + CODIGO + " =? ");
        }
        if (listaOpcaoItemTO.getCodConfigTarefa() != 0){
            sql.append(" AND " + CODIGO_TIPO_TAREFA + " =? ");
        }
        if (listaOpcaoItemTO.getNumeroOrdem() != 0){
            sql.append(" AND " + NUM_ORDEM_ITEM + " =? ");
        }
        PreparedStatement stmt;
        try {
             int i = 0;
             stmt = getConexao().prepareStatement(sql.toString());
             if (listaOpcaoItemTO.getCodigo() != 0){
                   stmt.setInt(++i,listaOpcaoItemTO.getCodigo());
             }
             if (listaOpcaoItemTO.getCodConfigTarefa() != 0){
            	 stmt.setInt(++i,listaOpcaoItemTO.getCodConfigTarefa());
             }
             if (listaOpcaoItemTO.getNumeroOrdem() != 0){
            	 stmt.setInt(++i,listaOpcaoItemTO.getNumeroOrdem());
             }
             stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }


    private void clausulaWhereConsulta(ListaOpcaoItemTO listaOpcaoItemTO, StringBuffer sql){
    	sql.append(" WHERE 1=1 ");
        if (listaOpcaoItemTO.getCodConfigTarefa() != 0){
            sql.append(" AND " + CODIGO_TIPO_TAREFA + " =? ");
        }
        if (listaOpcaoItemTO.getNumeroOrdem() != 0){
            sql.append(" AND " + NUM_ORDEM_ITEM + " =? ");
        }
        if (listaOpcaoItemTO.getCodigo() != 0){
            sql.append(" AND " + CODIGO + " =? ");
        }
        if ((listaOpcaoItemTO.getTexto() != null) && (!listaOpcaoItemTO.getTexto().equals("")) ){
            sql.append(" AND " + TEXTO_OPCAO + " = ? ");
        }
    }


    private ListaOpcaoItemTO carregaTO(ResultSet resultado) throws SQLException{
    	 int i = 0;
        ListaOpcaoItemTO listaOpcaoItemTO = new ListaOpcaoItemTO(); 
        listaOpcaoItemTO.setCodConfigTarefa(resultado.getInt(++i));
        listaOpcaoItemTO.setNumeroOrdem(resultado.getInt(++i));
        listaOpcaoItemTO.setCodigo(resultado.getInt(++i));
        listaOpcaoItemTO.setTexto(resultado.getString(++i));
        return listaOpcaoItemTO;
    }

	public int consultarMax() throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("SELECT MAX(");		
		sql.append(CODIGO);		
		sql.append(") AS ");
		sql.append(CODIGO);
		sql.append(" FROM ");
		sql.append(TABELA);				

		PreparedStatement stmt;
		ResultSet result;		
		try {
			stmt = getConexao().prepareStatement(sql.toString());
			result = stmt.executeQuery();
			while (result.next()) {
				return result.getInt(CODIGO)+1;
			}
		} 
		catch (SQLException e) {
		    log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
		return 0;
	}


}

