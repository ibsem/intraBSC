package br.com.intraBSC.persistencia.JDBC;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.intraBSC.excecoes.ExceptionPersistenciaBSC;
import br.com.intraBSC.modelo.UsuarioTO;
import br.com.intraBSC.persistencia.BscDaoJDBCGenerico;
import br.com.intraBSC.persistencia.UsuarioDAO;
import br.com.intraBSC.util.Criptografia;

import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;

public class UsuarioDAOJDBC extends BscDaoJDBCGenerico implements UsuarioDAO{

	private static Log log = LogFactory.getLog(UsuarioDAOJDBC.class);
	
	public final static String TABELA = "OWNER";
	public final static String  ID_USUARIO = "ID";
	public final static String  NOME_USUARIO = "NAME";
	public final static String  PHONE_USUARIO = "PHONE";
	public final static String  EMAIL_USUARIO = "EMAILADRESS";
	public final static String  PASS_USUARIO = "PASSWORD";
	public final static String  COFIRMPASS_USUARIO = "CONFIRMPASSWORD";
	public final static String  LOGIN_USUARIO = "LOGIN";
	public final static String  TIPO_USUARIO = "TYPE_OWNER";
	public final static String  GRUPO_USUARIO = "ID_GROUP";
	public final static String  USUARIO_ONLINE = "ONLINE";
    
	
	public UsuarioDAOJDBC(DaoManager daoManager) {
		super(daoManager);		
	}

	private Connection getconexao(){
		return getConnection();			
	}
		

	/**
	 * Autor Tiago Trindade Stangarlin
	 * Data 11/10/2005
	 * Metodo de implementacao do SQL para consulta de usuario
	 * */
	public UsuarioTO consultarUm(UsuarioTO usuarioTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer();
	
		sql.append("SELECT ");
		sql.append("A." + ID_USUARIO + ", ");
		sql.append("A." + NOME_USUARIO + ", ");
		sql.append("A." + PHONE_USUARIO + ", ");
		sql.append("A." + EMAIL_USUARIO + ", ");
		sql.append("A." + PASS_USUARIO + ", ");
		sql.append("A." + COFIRMPASS_USUARIO + ", ");
		sql.append("A." + LOGIN_USUARIO + ", ");
		sql.append("A." + 	TIPO_USUARIO + ", ");
		sql.append("A." + 	GRUPO_USUARIO + " ");
		sql.append("FROM " + TABELA + " A ");
		sql.append("WHERE 1=1 ");
		
		clausulaWhereConsulta(usuarioTO,sql);
		
		PreparedStatement stmt;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			
			completeStatementConsulta(usuarioTO,stmt);
			
			ResultSet resultado = stmt.executeQuery();
			UsuarioTO retorno = new UsuarioTO();
			while (resultado.next()) {
				retorno = carregaTO(resultado);
			}
			return retorno;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DaoException(e.getMessage());
		}
	}
	
	public int consultarMax(UsuarioTO usuarioTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer("SELECT MAX(");
		sql.append(ID_USUARIO);
		sql.append(") AS ");
		sql.append(ID_USUARIO);
		sql.append(" FROM ");
		sql.append(TABELA);
		PreparedStatement stmt;
		ResultSet result;		
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			result = stmt.executeQuery();
			while (result.next()) {
				return result.getInt(ID_USUARIO) + 1;
			}			
		} 
		catch (SQLException e) {
		    log.error(e.getMessage());
			throw new ExceptionPersistenciaBSC(e.getMessage());
		}		
		return 0;
	}
	
	public Collection consultarVarios(UsuarioTO usuarioTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("A." + ID_USUARIO + ", ");
		sql.append("A." + NOME_USUARIO + ", ");
		sql.append("A." + PHONE_USUARIO + ", ");
		sql.append("A." + EMAIL_USUARIO + ", ");
		sql.append("A." + PASS_USUARIO + ", ");
		sql.append("A." + COFIRMPASS_USUARIO + ", ");
		sql.append("A." + LOGIN_USUARIO + ", ");
		sql.append("A." + 	TIPO_USUARIO + ", ");
		sql.append("A." + 	GRUPO_USUARIO + " ");
		sql.append("FROM " + TABELA + " A "); 
		
		if (usuarioTO.getGrupoTO().getCodigo() != 0){
			sql.append(" , " + GrupoDAOJDBC.TABELA + " B ");
		}
		
		sql.append(" WHERE 1=1 ");
		
		if (usuarioTO.getGrupoTO().getCodigo() != 0){
			sql.append(" AND A."+GRUPO_USUARIO + " = ? ");
			sql.append(" AND A."+GRUPO_USUARIO + " = B." + GrupoDAOJDBC.CODIGO);
		}
		
		if (usuarioTO.getIdUsuario() != 0){
			sql.append(" AND A." + ID_USUARIO + " =? ");
		}
		if ((usuarioTO.getNome() != null) && (!usuarioTO.getNome().equals("")) ){
			sql.append(" AND UCASE(A." + NOME_USUARIO + ") LIKE ? ");
		}
		if ((usuarioTO.getTelefone() != null) && (!usuarioTO.getTelefone().equals("")) ){
			sql.append(" AND A." + PHONE_USUARIO + " LIKE ? ");
		}
		if ((usuarioTO.getEmail() != null) && (!usuarioTO.getEmail().equals("")) ){
			sql.append(" AND A." + EMAIL_USUARIO + " LIKE ? ");
		}
		if ((usuarioTO.getLogin() != null) && (!usuarioTO.getLogin().equals("")) ){
			sql.append(" AND A." + LOGIN_USUARIO + " = ? ");
		}
		if ((usuarioTO.getPerfil() != null) && (!usuarioTO.getPerfil().equals("")) ){
			sql.append(" AND A." + TIPO_USUARIO + " = ? ");
		}
		if ((usuarioTO.getGrupoTO().getCodigo() != 0)){
			sql.append(" AND A." + GRUPO_USUARIO + " = ? ");
		}
		if ((usuarioTO.getOnline() != 0)){
			sql.append(" AND A." + USUARIO_ONLINE + " = ? ");
		}
		sql.append(" ORDER BY "+ NOME_USUARIO);
		PreparedStatement stmt;
		try {		
			stmt = getconexao().prepareStatement(sql.toString());
		
			int i = 0;
			if (usuarioTO.getGrupoTO().getCodigo() != 0){
				stmt.setInt(++i,usuarioTO.getGrupoTO().getCodigo());
			}
			if (usuarioTO.getIdUsuario() != 0){
				stmt.setInt(++i,usuarioTO.getIdUsuario());
			}
			if ((usuarioTO.getNome() != null) && (!usuarioTO.getNome().equals("")) ){
				stmt.setString(++i,"%" + usuarioTO.getNome().toUpperCase() + "%");
			}
			if ((usuarioTO.getTelefone() != null) && (!usuarioTO.getTelefone().equals("")) ){
				stmt.setString(++i,"%" + usuarioTO.getTelefone() + "%");
			}
			if ((usuarioTO.getEmail() != null) && (!usuarioTO.getEmail().equals("")) ){
				stmt.setString(++i,"%" + usuarioTO.getEmail().toUpperCase() + "%");
			}
			if ((usuarioTO.getLogin() != null) && (!usuarioTO.getLogin().equals("")) ){
				stmt.setString(++i,usuarioTO.getLogin());
			}
			if ((usuarioTO.getPerfil() != null) && (!usuarioTO.getPerfil().equals("")) ){
				stmt.setString(++i,usuarioTO.getPerfil());
			}
			if (usuarioTO.getGrupoTO().getCodigo() != 0){
				stmt.setInt(++i,usuarioTO.getGrupoTO().getCodigo());
			}
			if ((usuarioTO.getOnline() != 0)){
				stmt.setInt(++i,usuarioTO.getOnline());
			}
			
			ResultSet resultado = stmt.executeQuery();
			Collection<UsuarioTO> lista = new ArrayList<UsuarioTO>();
			while (resultado.next()) {
				lista.add(carregaTO(resultado));
			}	
			return lista;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DaoException(e.getMessage());
		}		
	}

	public void incluir(UsuarioTO usuarioTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer("INSERT INTO ");
		sql.append(TABELA + "(");
		sql.append(NOME_USUARIO + ", ");
		sql.append(PHONE_USUARIO + ", ");
		sql.append(EMAIL_USUARIO + ", ");
		sql.append(PASS_USUARIO + ", ");
		sql.append(COFIRMPASS_USUARIO + ", ");
		sql.append(LOGIN_USUARIO + ", ");
		sql.append(TIPO_USUARIO + ", ");
		sql.append(GRUPO_USUARIO);
		sql.append(") VALUES (?,?,?,?,?,?,?,?");
		sql.append(")");
        
		PreparedStatement stmt;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			completeStatement(usuarioTO,stmt);
			stmt.executeUpdate();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DaoException(e.getMessage());
		}
	}
	
	public void incluirXml(UsuarioTO usuarioTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer("INSERT INTO ");
		sql.append(TABELA + "(");
		sql.append(NOME_USUARIO + ", ");
		sql.append(EMAIL_USUARIO);
		sql.append(") VALUES (?,?");
		sql.append(")");
        
		PreparedStatement stmt;
		try {
			
			int i = 0;
			stmt = getconexao().prepareStatement(sql.toString());
			if ((usuarioTO.getNome() != null) && (!usuarioTO.getNome().equals("")) ){
				stmt.setString(++i,usuarioTO.getNome());
			}
			if ((usuarioTO.getEmail() != null) && (!usuarioTO.getEmail().equals("")) ){
				stmt.setString(++i,usuarioTO.getEmail());
			}
			stmt.executeUpdate();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DaoException(e.getMessage());
		}
	}


	public void excluir(UsuarioTO usuarioTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer("DELETE FROM ");
		sql.append(TABELA);
		sql.append(" WHERE 1=1 ");
		
		if (usuarioTO.getIdUsuario() != 0){
			sql.append(" AND " + ID_USUARIO + " =? ");
		}
        
		PreparedStatement stmt;
		try {
			int i = 0;
			stmt = getconexao().prepareStatement(sql.toString());
			if (usuarioTO.getIdUsuario() != 0){
				stmt.setInt(++i,usuarioTO.getIdUsuario());
			}
			stmt.executeUpdate();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DaoException(e.getMessage());
		}
		
	}
	
	
	/**
	 * Autor Tiago Trindade Stangarlin
	 * Data 10/10/2005
	 * Metodo para carregar o retorno da consulta na base de dados`
	 * */
	private UsuarioTO carregaTO(ResultSet resultado) throws SQLException{
		UsuarioTO usuarioTO = new UsuarioTO();
		int i = 0;
		usuarioTO.setIdUsuario(resultado.getInt(++i));
		usuarioTO.setNome(resultado.getString(++i));
		usuarioTO.setTelefone(resultado.getString(++i));
		usuarioTO.setEmail(resultado.getString(++i));
		usuarioTO.setSenha(resultado.getString(++i));
		usuarioTO.setConfirmaSenha(resultado.getString(++i));
		usuarioTO.setLogin(resultado.getString(++i));
		usuarioTO.setPerfil(resultado.getString(++i));
		usuarioTO.getGrupoTO().setCodigo(resultado.getInt(++i));	
		return usuarioTO;
	}

	public void alterar(UsuarioTO usuarioTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer("UPDATE ");
		sql.append(TABELA + " SET ");
		if ((usuarioTO.getNome() != null) && (!usuarioTO.getNome().equals("")) )
			sql.append(NOME_USUARIO + " = ?, ");
		if ((usuarioTO.getLogin() != null) && (!usuarioTO.getLogin().equals("")) )
			sql.append( LOGIN_USUARIO + " = ?, ");
		if ((usuarioTO.getTelefone() != null) && (!usuarioTO.getTelefone().equals("")) )
			sql.append(PHONE_USUARIO + " = ?, ");
		if ((usuarioTO.getEmail() != null) && (!usuarioTO.getEmail().equals("")) )
			sql.append(EMAIL_USUARIO + " = ?, ");
		if ((usuarioTO.getSenha() != null) && (!usuarioTO.getSenha().equals("")) )
			sql.append(PASS_USUARIO + " = ?, ");
		if ((usuarioTO.getConfirmaSenha() != null) && (!usuarioTO.getConfirmaSenha().equals("")) )
			sql.append(COFIRMPASS_USUARIO + " = ?, ");
		if ((usuarioTO.getPerfil() != null) && (!usuarioTO.getPerfil().equals("")) )
			sql.append(TIPO_USUARIO + " = ?, ");
		if ((usuarioTO.getGrupoTO().getCodigo() != 0)){
			sql.append(GRUPO_USUARIO + " = ? ");
		}else{
			sql.delete(sql.length()-2,sql.length());
		}
		sql.append(" WHERE 1=1 ");
		sql.append("AND " + ID_USUARIO + " = ? ");
		        
		PreparedStatement stmt;
		try {
			int i = 0;
			stmt = getconexao().prepareStatement(sql.toString());
			
			if ((usuarioTO.getNome() != null) && (!usuarioTO.getNome().equals("")) ){
				stmt.setString(++i,usuarioTO.getNome());
			}
			if ((usuarioTO.getLogin() != null) && (!usuarioTO.getLogin().equals("")) ){
				stmt.setString(++i,usuarioTO.getLogin());
			}
			if ((usuarioTO.getTelefone() != null) && (!usuarioTO.getTelefone().equals("")) ){
				stmt.setString(++i,usuarioTO.getTelefone());
			}
			if ((usuarioTO.getEmail() != null) && (!usuarioTO.getEmail().equals("")) ){
				stmt.setString(++i,usuarioTO.getEmail());
			}
			if ((usuarioTO.getSenha() != null) && (!usuarioTO.getSenha().equals("")) ){
				stmt.setString(++i,Criptografia.criptografar(usuarioTO.getSenha()));
			}
			if ((usuarioTO.getConfirmaSenha() != null) && (!usuarioTO.getConfirmaSenha().equals("")) ){
				stmt.setString(++i,Criptografia.criptografar(usuarioTO.getConfirmaSenha()));
			}
			if ((usuarioTO.getPerfil() != null) && (!usuarioTO.getPerfil().equals("")) ){
				stmt.setString(++i,usuarioTO.getPerfil());
			}
			if (usuarioTO.getGrupoTO().getCodigo() != 0){
				stmt.setInt(++i,usuarioTO.getGrupoTO().getCodigo());
			}
			if (usuarioTO.getIdUsuario() != 0){
				stmt.setInt(++i,usuarioTO.getIdUsuario());
			}
			stmt.executeUpdate();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DaoException(e.getMessage());
		}
	}

	
	private void clausulaWhereConsulta(UsuarioTO usuarioTO, StringBuffer sql){
		if (usuarioTO.getIdUsuario() != 0){
			sql.append(" AND A." + ID_USUARIO + " =? ");
		}
		if ((usuarioTO.getNome() != null) && (!usuarioTO.getNome().equals("")) ){
			sql.append(" AND UCASE(A." + NOME_USUARIO + ") LIKE ? ");
		}
		if ((usuarioTO.getTelefone() != null) && (!usuarioTO.getTelefone().equals("")) ){
			sql.append(" AND A." + PHONE_USUARIO + " LIKE ? ");
		}
		if ((usuarioTO.getEmail() != null) && (!usuarioTO.getEmail().equals("")) ){
			sql.append(" AND A." + EMAIL_USUARIO + " LIKE ? ");
		}
		if ((usuarioTO.getSenha() != null) && (!usuarioTO.getSenha().equals("")) ){
			sql.append(" AND A." + PASS_USUARIO + " = ? ");
		}
		if ((usuarioTO.getConfirmaSenha() != null) && (!usuarioTO.getConfirmaSenha().equals("")) ){
			sql.append(" AND A." + COFIRMPASS_USUARIO + " = ? ");
		}
		if ((usuarioTO.getLogin() != null) && (!usuarioTO.getLogin().equals("")) ){
			sql.append(" AND A." + LOGIN_USUARIO + " = ? ");
		}
		if ((usuarioTO.getPerfil() != null) && (!usuarioTO.getPerfil().equals("")) ){
			sql.append(" AND A." + TIPO_USUARIO + " = ? ");
		}
		if ((usuarioTO.getGrupoTO().getCodigo() != 0)){
			sql.append(" AND A." + GRUPO_USUARIO + " = ? ");
		}
	}
	
	private void completeStatementConsulta(UsuarioTO usuarioTO,PreparedStatement stmt) throws SQLException{
		int i = 0;
		if (usuarioTO.getIdUsuario() != 0){
			stmt.setInt(++i,usuarioTO.getIdUsuario());
		}
		if ((usuarioTO.getNome() != null) && (!usuarioTO.getNome().equals("")) ){
			stmt.setString(++i,"%" + usuarioTO.getNome().toUpperCase() + "%");
		}
		if ((usuarioTO.getTelefone() != null) && (!usuarioTO.getTelefone().equals("")) ){
			stmt.setString(++i,"%" + usuarioTO.getTelefone() + "%");
		}
		if ((usuarioTO.getEmail() != null) && (!usuarioTO.getEmail().equals("")) ){
			stmt.setString(++i,"%" + usuarioTO.getEmail().toUpperCase() + "%");
		}
		if ((usuarioTO.getSenha() != null) && (!usuarioTO.getSenha().equals("")) ){
			stmt.setString(++i,"");
		}
		if ((usuarioTO.getConfirmaSenha() != null) && (!usuarioTO.getConfirmaSenha().equals("")) ){
			stmt.setString(++i,"");
		}
		if ((usuarioTO.getLogin() != null) && (!usuarioTO.getLogin().equals("")) ){
			stmt.setString(++i,usuarioTO.getLogin());
		}
		if ((usuarioTO.getPerfil() != null) && (!usuarioTO.getPerfil().equals("")) ){
			stmt.setString(++i,usuarioTO.getPerfil());
		}
		if ((usuarioTO.getGrupoTO().getCodigo() != 0)){
			stmt.setInt(++i,usuarioTO.getGrupoTO().getCodigo());
		}
	}
	
	
	private void completeStatement(UsuarioTO usuarioTO,PreparedStatement stmt) throws SQLException, NoSuchAlgorithmException{
		int i = 0;
		if (usuarioTO.getIdUsuario() != 0){
			stmt.setInt(++i,usuarioTO.getIdUsuario());
		}
		if ((usuarioTO.getNome() != null) && (!usuarioTO.getNome().equals("")) ){
			stmt.setString(++i,usuarioTO.getNome());
		}
		if ((usuarioTO.getTelefone() != null) && (!usuarioTO.getTelefone().equals("")) ){
			stmt.setString(++i,usuarioTO.getTelefone());
		}
		if ((usuarioTO.getEmail() != null) && (!usuarioTO.getEmail().equals("")) ){
			stmt.setString(++i,usuarioTO.getEmail());
		}
		if ((usuarioTO.getSenha() != null) && (!usuarioTO.getSenha().equals("")) ){
			stmt.setString(++i,Criptografia.criptografar(usuarioTO.getSenha()));
		}
		if ((usuarioTO.getConfirmaSenha() != null) && (!usuarioTO.getConfirmaSenha().equals("")) ){
			stmt.setString(++i,Criptografia.criptografar(usuarioTO.getConfirmaSenha()));
		}
		if ((usuarioTO.getLogin() != null) && (!usuarioTO.getLogin().equals("")) ){
			stmt.setString(++i,usuarioTO.getLogin());
		}
		if ((usuarioTO.getPerfil() != null) && (!usuarioTO.getPerfil().equals("")) ){
			stmt.setString(++i,usuarioTO.getPerfil());
		}
		if (usuarioTO.getGrupoTO().getCodigo() != 0){
			stmt.setInt(++i,usuarioTO.getGrupoTO().getCodigo());
		}
	}
	/* Pesquisa utilizada somente para logar no sistema, serve para identificar o usuario*/
	public UsuarioTO consultarLogon(UsuarioTO usuarioTO) throws ExceptionPersistenciaBSC {
	//	StringBuffer sql0 = new StringBuffer();
	//	sql0.append("SET SCHEMA INTRABSC1;");
	//	PreparedStatement stmt0;
	//	try {
	//	stmt0 = getconexao().prepareStatement(sql0.toString());
	//	stmt0.execute();
	//	} catch (SQLException e1) {
			// TODO Auto-generated catch block
	//		e1.printStackTrace();
	//	}
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT ");
		sql.append("A." + ID_USUARIO + ", ");
		sql.append("A." + NOME_USUARIO + ", ");
		sql.append("A." + PHONE_USUARIO + ", ");
		sql.append("A." + EMAIL_USUARIO + ", ");
		sql.append("A." + PASS_USUARIO + ", ");
		sql.append("A." + COFIRMPASS_USUARIO + ", ");
		sql.append("A." + LOGIN_USUARIO + ", ");
		sql.append("A." + 	TIPO_USUARIO + ", ");
		sql.append("A." + 	GRUPO_USUARIO + " ");
		sql.append("FROM " + TABELA + " A ");
		sql.append("WHERE 1=1");
				
		sql.append(" AND A." + LOGIN_USUARIO + " = ? ");
		PreparedStatement stmt;
		try {
			
			stmt = getconexao().prepareStatement(sql.toString());
			//stmt.clearParameters();
			//System.out.println(usuarioTO.getLogin());
			stmt.setString(1,usuarioTO.getLogin());
			
			ResultSet resultado = stmt.executeQuery();
			UsuarioTO retorno = new UsuarioTO();
			while (resultado.next()) {
				retorno = carregaTO(resultado);
				if (usuarioTO.getSenha() != null){
					if (!retorno.getSenha().equalsIgnoreCase(Criptografia.descritografar(usuarioTO.getSenha()))){
						retorno = new UsuarioTO();
					}
				}
			}
			return retorno;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DaoException(e.getMessage());
		}
	}

	public Collection consultarUsuarioGrupo(UsuarioTO usuarioTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("A." + ID_USUARIO + ", ");
		sql.append("A." + NOME_USUARIO + ", ");
		sql.append("A." + PHONE_USUARIO + ", ");
		sql.append("A." + EMAIL_USUARIO + ", ");
		sql.append("A." + PASS_USUARIO + ", ");
		sql.append("A." + COFIRMPASS_USUARIO + ", ");
		sql.append("A." + LOGIN_USUARIO + ", ");
		sql.append("A." + TIPO_USUARIO + ", ");
		sql.append("A." + GRUPO_USUARIO + " ");
		sql.append("FROM " + TABELA + " A, " + GrupoDAOJDBC.TABELA + " B ");
		sql.append("WHERE 1=1 ");
		
		sql.append(" AND A."+GRUPO_USUARIO + " = ? ");
		sql.append(" AND A."+GRUPO_USUARIO + " = B." + GrupoDAOJDBC.CODIGO);
		
		sql.append(" ORDER BY "+ NOME_USUARIO);
		PreparedStatement stmt;
		try {		
			stmt = getconexao().prepareStatement(sql.toString());
						
			int i = 0;
		
			stmt.setInt(++i,usuarioTO.getGrupoTO().getCodigo());
			
			ResultSet resultado = stmt.executeQuery();
			UsuarioTO retorno = new UsuarioTO();
			Collection<UsuarioTO> lista = new ArrayList<UsuarioTO>();
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
	
	public void alterarOnline(UsuarioTO usuarioTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer("UPDATE ");
		sql.append(TABELA + " SET ");
		sql.append(USUARIO_ONLINE + " = ? ");		
		sql.append(" WHERE 1=1 ");
		sql.append("AND " + ID_USUARIO + " = ? ");

		PreparedStatement stmt;
		try {
			int i = 0;
			stmt = getconexao().prepareStatement(sql.toString());
			stmt.setInt(++i,usuarioTO.getOnline());
			stmt.setInt(++i,usuarioTO.getIdUsuario());
			stmt.executeUpdate();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DaoException(e.getMessage());
		}
	}
	

}
