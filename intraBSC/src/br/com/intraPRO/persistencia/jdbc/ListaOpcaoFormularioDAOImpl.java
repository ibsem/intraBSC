package br.com.intraPRO.persistencia.jdbc;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;

import br.com.intraBSC.persistencia.BscDaoJDBCGenerico;
import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.ListaOpcaoFormularioTO;
import br.com.intraPRO.persistencia.ListaOpcaoFormularioDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ListaOpcaoFormularioDAOImpl extends BscDaoJDBCGenerico implements ListaOpcaoFormularioDAO {

    private static Log log = LogFactory.getLog(ListaOpcaoFormularioDAOImpl.class);

    protected static final String TABELA = "OPTIONLISTFORMULARIO";
    protected static final String CODIGO_TIPO_TAREFA = "PK_CONFIGTASK";
    protected static final String NUM_ORDEM_FORMULARIO = "PK_ORDER_FIELD";
    protected static final String CODIGO = "PK_SEQUENCE_LS_OPTION";
    protected static final String TEXTO_OPCAO = "TX_OPTIONLISTFIELD";

    public ListaOpcaoFormularioDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

    private Connection getConexao(){
        return getConnection();
    }

    @SuppressWarnings("unchecked")
	public Collection consultarVarios(ListaOpcaoFormularioTO listaOpcaoFormularioTO) throws ExceptionPersistenciaPRO{
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + CODIGO_TIPO_TAREFA + ", ");
        sql.append("A." + NUM_ORDEM_FORMULARIO + ", ");
        sql.append("A." + CODIGO + ", ");
        sql.append("A." + TEXTO_OPCAO + " ");
        sql.append("FROM " + TABELA + " A ");
        

        clausulaWhereConsulta(listaOpcaoFormularioTO,sql);
        int i = 0; 
        PreparedStatement stmt;
        try {
			 stmt = getConexao().prepareStatement(sql.toString());
             
			 if (listaOpcaoFormularioTO.getCodConfigTarefa() != 0){
				 stmt.setInt(++i, listaOpcaoFormularioTO.getCodConfigTarefa());				
			 }
			 if (listaOpcaoFormularioTO.getNumeroOrdem() != 0){
				 stmt.setInt(++i, listaOpcaoFormularioTO.getNumeroOrdem());
			 }
			 if (listaOpcaoFormularioTO.getCodigo() != 0){
				 stmt.setInt(++i, listaOpcaoFormularioTO.getCodigo());
			 }
			 if ((listaOpcaoFormularioTO.getTexto() != null) && (!listaOpcaoFormularioTO.getTexto().equals("")) ){
				 stmt.setString(++i, listaOpcaoFormularioTO.getTexto());
			 }
			 
             ResultSet resultado = stmt.executeQuery();
             ListaOpcaoFormularioTO retorno = new ListaOpcaoFormularioTO();
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


    public ListaOpcaoFormularioTO consultarUm(ListaOpcaoFormularioTO listaOpcaoFormularioTO) throws ExceptionPersistenciaPRO{
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + CODIGO_TIPO_TAREFA + ", ");
        sql.append("A." + NUM_ORDEM_FORMULARIO + ", ");
        sql.append("A." + CODIGO + ", ");
        sql.append("A." + TEXTO_OPCAO + " ");
        sql.append("FROM " + TABELA + " A ");

        clausulaWhereConsulta(listaOpcaoFormularioTO,sql);

        PreparedStatement stmt;
        try {
        	 int i = 0;	
			 stmt = getConexao().prepareStatement(sql.toString());
			 if (listaOpcaoFormularioTO.getCodConfigTarefa() != 0){
				 stmt.setInt(++i, listaOpcaoFormularioTO.getCodConfigTarefa());				
			 }
			 if (listaOpcaoFormularioTO.getNumeroOrdem() != 0){
				 stmt.setInt(++i, listaOpcaoFormularioTO.getNumeroOrdem());
			 }
			 if (listaOpcaoFormularioTO.getCodigo() != 0){
				 stmt.setInt(++i, listaOpcaoFormularioTO.getCodigo());
			 }
			 if ((listaOpcaoFormularioTO.getTexto() != null) && (!listaOpcaoFormularioTO.getTexto().equals("")) ){
				 stmt.setString(++i, listaOpcaoFormularioTO.getTexto());
			 }
             ResultSet resultado = stmt.executeQuery();
             ListaOpcaoFormularioTO retorno = new ListaOpcaoFormularioTO();
             while (resultado.next()) {
                  retorno = carregaTO(resultado);                  
             }
             return retorno;
        } catch (Exception e) {
              log.error(e.getMessage());
              throw new DaoException(e.getMessage());
        }
    }


    public void incluir(ListaOpcaoFormularioTO listaOpcaoFormularioTO) throws ExceptionPersistenciaPRO{
        StringBuffer sql = new StringBuffer("INSERT INTO ");
        sql.append(TABELA + "(");
        sql.append(CODIGO_TIPO_TAREFA+", ");
        sql.append(NUM_ORDEM_FORMULARIO+", ");
        sql.append(CODIGO+", ");
        sql.append(TEXTO_OPCAO+" ");
        sql.append(") VALUES (");
        if (listaOpcaoFormularioTO.getCodConfigTarefa() != 0){
            sql.append(" ?, ");
        }
        if (listaOpcaoFormularioTO.getNumeroOrdem() != 0){
        	sql.append(" ?, ");
        }
        if (listaOpcaoFormularioTO.getCodigo() != 0){
        	sql.append(" ?, ");
        }
        if ((listaOpcaoFormularioTO.getTexto() != null) && (!listaOpcaoFormularioTO.getTexto().equals("")) ){
            sql.append(" ? ");
        }else {
            sql.delete(sql.length() - 2, sql.length());
        }
        sql.append(")");
        PreparedStatement stmt;
        try {
            stmt = getConexao().prepareStatement(sql.toString());
            int i = 0;
            if (listaOpcaoFormularioTO.getCodConfigTarefa() != 0){
				 stmt.setInt(++i, listaOpcaoFormularioTO.getCodConfigTarefa());				
			 }
			 if (listaOpcaoFormularioTO.getNumeroOrdem() != 0){
				 stmt.setInt(++i, listaOpcaoFormularioTO.getNumeroOrdem());
			 }
			 if (listaOpcaoFormularioTO.getCodigo() != 0){
				 stmt.setInt(++i, listaOpcaoFormularioTO.getCodigo());
			 }
			 if ((listaOpcaoFormularioTO.getTexto() != null) && (!listaOpcaoFormularioTO.getTexto().equals("")) ){
				 stmt.setString(++i, listaOpcaoFormularioTO.getTexto().trim());
			 }
            stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }


    public void alterar(ListaOpcaoFormularioTO listaOpcaoFormularioTO) throws ExceptionPersistenciaPRO{
        StringBuffer sql = new StringBuffer("UPDATE ");
        sql.append(TABELA + " SET ");
        sql.append(CODIGO_TIPO_TAREFA+" = ?, ");
        sql.append(NUM_ORDEM_FORMULARIO+" = ?, ");
        sql.append(CODIGO+" = ?, ");
        sql.append(TEXTO_OPCAO+" = ? ");
        sql.append(" WHERE 1=1 ");
        sql.append("AND " + CODIGO  + " = ? ");
        PreparedStatement stmt;
        try {
            int i = 0;
            stmt = getConexao().prepareStatement(sql.toString());

            stmt.setInt(++i,listaOpcaoFormularioTO.getCodConfigTarefa());
            stmt.setInt(++i,listaOpcaoFormularioTO.getNumeroOrdem());
            stmt.setInt(++i,listaOpcaoFormularioTO.getCodigo());
            stmt.setString(++i,listaOpcaoFormularioTO.getTexto().trim());

            stmt.setInt(++i,listaOpcaoFormularioTO.getCodigo());
            stmt.executeUpdate();
         } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
         }
    }


    public void excluir(ListaOpcaoFormularioTO listaOpcaoFormularioTO) throws ExceptionPersistenciaPRO{
        StringBuffer sql = new StringBuffer("DELETE FROM ");
        sql.append(TABELA);
        sql.append(" WHERE 1=1 ");
        if (listaOpcaoFormularioTO.getCodigo() != 0){
            sql.append(" AND " + CODIGO + " =? ");
        }
        if (listaOpcaoFormularioTO.getCodConfigTarefa() != 0){
            sql.append(" AND " + CODIGO_TIPO_TAREFA + " =? ");
        }
        if (listaOpcaoFormularioTO.getNumeroOrdem() != 0){
            sql.append(" AND " + NUM_ORDEM_FORMULARIO + " =? ");
        }
        PreparedStatement stmt;
        try {
             int i = 0;
             stmt = getConexao().prepareStatement(sql.toString());
             if (listaOpcaoFormularioTO.getCodigo() != 0){
                   stmt.setInt(++i,listaOpcaoFormularioTO.getCodigo());
             }
             if (listaOpcaoFormularioTO.getCodConfigTarefa() != 0){
            	 stmt.setInt(++i,listaOpcaoFormularioTO.getCodConfigTarefa());
             }
             if (listaOpcaoFormularioTO.getNumeroOrdem() != 0){
            	 stmt.setInt(++i,listaOpcaoFormularioTO.getNumeroOrdem());
             }
             stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }


    private void clausulaWhereConsulta(ListaOpcaoFormularioTO listaOpcaoFormularioTO, StringBuffer sql){
    	sql.append(" WHERE 1=1 ");
        if (listaOpcaoFormularioTO.getCodConfigTarefa() != 0){
            sql.append(" AND " + CODIGO_TIPO_TAREFA + " =? ");
        }
        if (listaOpcaoFormularioTO.getNumeroOrdem() != 0){
            sql.append(" AND " + NUM_ORDEM_FORMULARIO + " =? ");
        }
        if (listaOpcaoFormularioTO.getCodigo() != 0){
            sql.append(" AND " + CODIGO + " =? ");
        }
        if ((listaOpcaoFormularioTO.getTexto() != null) && (!listaOpcaoFormularioTO.getTexto().equals("")) ){
            sql.append(" AND " + TEXTO_OPCAO + " = ? ");
        }
    }


    private ListaOpcaoFormularioTO carregaTO(ResultSet resultado) throws SQLException{
    	 int i = 0;
        ListaOpcaoFormularioTO listaOpcaoFormularioTO = new ListaOpcaoFormularioTO(); 
        listaOpcaoFormularioTO.setCodConfigTarefa(resultado.getInt(++i));
        listaOpcaoFormularioTO.setNumeroOrdem(resultado.getInt(++i));
        listaOpcaoFormularioTO.setCodigo(resultado.getInt(++i));
        listaOpcaoFormularioTO.setTexto(resultado.getString(++i));
        return listaOpcaoFormularioTO;
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

