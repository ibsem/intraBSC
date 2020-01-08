
package br.com.intraPRO.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.intraBSC.persistencia.BscDaoJDBCGenerico;
import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.FormularioTO;
import br.com.intraPRO.persistencia.FormularioDAO;

import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;

/**
Classe que contem a implimentação da DAO de Formulario.
Ele realiza os SQLs.
*/
public class FormularioDAOImpl extends BscDaoJDBCGenerico implements FormularioDAO{
	
	   protected final static String TABELA = "FORMULARIOCONFIGURATIONTASK";
	   protected final static String TABELAATV = "CONFIGURATIONTASK";
	   protected final static String CODIGO = "PK_CONFIG_TASK";
	   protected final static String NUMERO_ORDEM = "PK_ORDER_FORMULARIO";
	   protected final static String NOME = "NAME_FORMULARIO";
	   protected final static String IND_FORMULARIO_CRITICO = "FLAG_FORMULARIO_CONTENT";
	   protected final static String IND_FORMULARIO_VIGENTE = "FLAG_FORMULARIO_VALIDITY";
	   protected final static String CODIGO_TIPO_DADO_FORMULARIO = "ID_TYPE_DATA_FORMULARIO";
	   
	   protected final static String NOMETAREFA = "TX_CONFIGTASK";
	   
	   private static Log log = LogFactory.getLog(FormularioDAOImpl.class);   
	   
	   
	   public FormularioDAOImpl(DaoManager daoManager){
	   		super(daoManager);
	   }


		public void incluir(FormularioTO formularioTO) throws ExceptionPersistenciaPRO {
		    StringBuffer sql = new StringBuffer("INSERT INTO ");
	   		sql.append(TABELA + " (");   		

	   		if (formularioTO.getCodConfigTarefa() != 0){
				sql.append(CODIGO + ", ");
	   		}
	   		if (formularioTO.getNumeroOrdem() != 0){
				sql.append(NUMERO_ORDEM + ", ");	
	   		}
	   		if ((formularioTO.getNome() != null) && !(formularioTO.getNome().trim().equalsIgnoreCase(""))){
				sql.append(NOME + ", ");
	   		}
	   		if ((formularioTO.getIndFormularioCritico() != null) && !(formularioTO.getIndFormularioCritico().trim().equalsIgnoreCase(""))){
				sql.append(IND_FORMULARIO_CRITICO + ", ");
	   		}
	   		if ((formularioTO.getCodTipoDadoFormulario()!= 0)){
				sql.append(CODIGO_TIPO_DADO_FORMULARIO + ", ");
	   		}
	   		if ((formularioTO.getIndFormularioVigente() != null) && !(formularioTO.getIndFormularioVigente().trim().equalsIgnoreCase(""))){
		   		sql.append(IND_FORMULARIO_VIGENTE);
	   		}
	        else {
	            sql.delete(sql.length() - 2, sql.length());
	        }
	   		
	   		
	   		sql.append(") VALUES (");
	   		
			if (formularioTO.getCodConfigTarefa() != 0){
				sql.append("?, ");
			}
			if(formularioTO.getNumeroOrdem() != 0){
				sql.append("?, ");
			}
			if ((formularioTO.getNome() != null) && !(formularioTO.getNome().trim().equalsIgnoreCase(""))){
				sql.append("?, ");
			}
			if ((formularioTO.getIndFormularioCritico() != null) && !(formularioTO.getIndFormularioCritico().trim().equalsIgnoreCase(""))){
				sql.append("?, ");
			}
			if ((formularioTO.getCodTipoDadoFormulario()!= 0)){
				sql.append("?, ");
	   		}
			if ((formularioTO.getIndFormularioVigente()!= null) && !(formularioTO.getIndFormularioVigente().trim().equalsIgnoreCase(""))){
				sql.append("?");
			}
	        else {
	            sql.delete(sql.length() - 2, sql.length());
	        }
	        sql.append(")");

			
			PreparedStatement stmt;
			try {
				int i=0;
				stmt = getConnection().prepareStatement(sql.toString());
				
				if (formularioTO.getCodConfigTarefa() != 0)
					stmt.setInt(++i, formularioTO.getCodConfigTarefa());

				if (formularioTO.getNumeroOrdem() != 0);
					stmt.setInt(++i, formularioTO.getNumeroOrdem());
				
				if ((formularioTO.getNome() != null) && !(formularioTO.getNome().trim().equalsIgnoreCase("")))		
					stmt.setString(++i, formularioTO.getNome());
				
				if ((formularioTO.getIndFormularioCritico() != null) && !(formularioTO.getIndFormularioCritico().trim().equalsIgnoreCase("")));
					stmt.setString(++i, formularioTO.getIndFormularioCritico());
					
				if ((formularioTO.getCodTipoDadoFormulario()!= 0)){
					stmt.setInt(++i, formularioTO.getCodTipoDadoFormulario());
		   		}
				
				if ((formularioTO.getIndFormularioVigente()!= null) && !(formularioTO.getIndFormularioVigente().trim().equalsIgnoreCase("")));
					stmt.setString(++i, formularioTO.getIndFormularioVigente());
					
				stmt.executeUpdate();
			} 
			catch (SQLException e) {
			    log.error(e.getMessage());
				throw new ExceptionPersistenciaPRO(e.getMessage());
			}		
		}
		
		

		public void alterar(FormularioTO formularioTO) throws ExceptionPersistenciaPRO {
		    StringBuffer sql = new StringBuffer("UPDATE ");
			sql.append(TABELA);
			sql.append(" SET ");
			
			if (formularioTO.getNumeroOrdem() != 0)
				{sql.append(NUMERO_ORDEM + " = "); 	
			    sql.append(" ?, ");}
			if ((formularioTO.getNome() != null) && !(formularioTO.getNome().equalsIgnoreCase("")))
				{sql.append(NOME + " = ");
			    sql.append(" ?, ");}
			if ((formularioTO.getIndFormularioCritico() != null) && !(formularioTO.getIndFormularioCritico().equalsIgnoreCase("")))
				{sql.append(IND_FORMULARIO_CRITICO + " = ");
				sql.append(" ?, ");}
			if ((formularioTO.getCodTipoDadoFormulario()!= 0)){
				sql.append(CODIGO_TIPO_DADO_FORMULARIO + " = ");
				sql.append(" ?, ");}
			if ((formularioTO.getIndFormularioVigente() != null) && !(formularioTO.getIndFormularioVigente().equalsIgnoreCase("")))
				{sql.append(IND_FORMULARIO_VIGENTE + " = ");
				sql.append(" ? ");}
			else {
	            sql.delete(sql.length() - 2, sql.length());
	        }
			sql.append(" WHERE ");
			sql.append(CODIGO + " = ? ");
			sql.append(" AND ");
			sql.append(NUMERO_ORDEM + " = ? ");
			int i = 0; 
			PreparedStatement stmt;
			try {		    
				stmt = getConexao().prepareStatement(sql.toString());
				
				if (formularioTO.getNumeroOrdem() != 0)
				    stmt.setInt(++i, formularioTO.getNumeroOrdem());
				
				if ((formularioTO.getNome() != null) && !(formularioTO.getNome().trim().equalsIgnoreCase("")))
				    stmt.setString(++i, formularioTO.getNome().trim());
				if ((formularioTO.getIndFormularioCritico() != null) && !(formularioTO.getIndFormularioCritico().trim().equalsIgnoreCase("")))
				    stmt.setString(++i, formularioTO.getIndFormularioCritico().trim().toUpperCase());
				if ((formularioTO.getCodTipoDadoFormulario()!= 0))
					stmt.setInt(++i, formularioTO.getCodTipoDadoFormulario());
				if ((formularioTO.getIndFormularioVigente() != null) && !(formularioTO.getIndFormularioVigente().trim().equalsIgnoreCase("")))
				    stmt.setString(++i, formularioTO.getIndFormularioVigente().trim().toUpperCase());			
				if (formularioTO.getCodConfigTarefa() != 0)
				    stmt.setInt(++i, formularioTO.getCodConfigTarefa());
				if (formularioTO.getNumeroOrdem() != 0){
					if (formularioTO.getNumeroOrdem() == formularioTO.getNumOrdemAnterior()){
						stmt.setInt(++i, formularioTO.getNumeroOrdem());
					} else {
						stmt.setInt(++i, formularioTO.getNumOrdemAnterior());
					}
				}
				
				stmt.executeUpdate();			
			} catch (SQLException e) {		    
			    log.error(e.getMessage());
				throw new ExceptionPersistenciaPRO(e.getMessage());
			}		
		}

		@SuppressWarnings("unchecked")
		public Collection consultarVarios(FormularioTO formularioTO) throws ExceptionPersistenciaPRO {
			StringBuffer sql = new StringBuffer("SELECT ");
			sql.append(CODIGO + ", ");
			sql.append(NUMERO_ORDEM + ", ");
			sql.append(NOME  + ", ");
			sql.append(IND_FORMULARIO_CRITICO + ", ");
			sql.append(CODIGO_TIPO_DADO_FORMULARIO + ", ");
			sql.append(IND_FORMULARIO_VIGENTE);
			sql.append(" FROM ");
			sql.append(TABELA + " A ");
			sql.append("WHERE 1=1 ");
			
			
			if (formularioTO.getCodConfigTarefa() != 0)				    
			    sql.append(" AND A." + CODIGO + " =?");
			if ((formularioTO.getNome() != null) && !(formularioTO.getNome().trim().equals("")))		
			    sql.append(" AND UPPER(A." + NOME + ") LIKE ?");	
			if ((formularioTO.getIndFormularioVigente() != null) && !(formularioTO.getIndFormularioVigente().equals("")))		
			    sql.append(" AND A." + IND_FORMULARIO_VIGENTE + " = ?");	
			sql.append(" ORDER BY " + CODIGO + ", " + NUMERO_ORDEM + ", " + NOME + ", " + IND_FORMULARIO_CRITICO + ", " + IND_FORMULARIO_VIGENTE);
			PreparedStatement stmt;
			Collection listaFormularios = new ArrayList();
			try {
				int i=1;
				stmt = getConexao().prepareStatement(sql.toString());
				
				// Conclui a montagem da StringBuffer dinamica informando os campos e os valors a serem utilizados como filtro na pesquisa
				if (formularioTO.getCodConfigTarefa() != 0){
				    stmt.setInt(i, formularioTO.getCodConfigTarefa());
				    i++;
				}
				if ((formularioTO.getNome() != null) && !(formularioTO.getNome().trim().equals(""))){
				    stmt.setString(i, "%" +  formularioTO.getNome().toUpperCase() + "%");
				}
				if ((formularioTO.getIndFormularioVigente() != null) && !(formularioTO.getIndFormularioVigente().equals(""))){
				    stmt.setString(i, formularioTO.getIndFormularioVigente());
				}
				
				
				ResultSet resultado = stmt.executeQuery();
				while (resultado.next()) {
					listaFormularios.add(carregarTO(resultado));				
				}			
			} catch (SQLException e) {
				log.error(e.getMessage());
				throw new DaoException(e.getMessage());
			}
			
			return listaFormularios;
		}
		
		
		public FormularioTO consultarUm(FormularioTO formularioTO) throws ExceptionPersistenciaPRO {
			StringBuffer sql = new StringBuffer("SELECT ");
			sql.append(CODIGO);
			sql.append(", ");
			sql.append(NUMERO_ORDEM);
			sql.append(", ");			
			sql.append(NOME);
			sql.append(", ");
			sql.append(IND_FORMULARIO_CRITICO);
			sql.append(", ");
			sql.append(CODIGO_TIPO_DADO_FORMULARIO + ", ");
			sql.append(IND_FORMULARIO_VIGENTE);		
			sql.append(" FROM ");
			sql.append(TABELA);
			sql.append(" A ");
			sql.append(" WHERE 1 = 1");

			if (formularioTO.getCodConfigTarefa() != 0)
				sql.append(" AND " + CODIGO + " = " + ("" + formularioTO.getCodConfigTarefa()) );

			if (formularioTO.getNumeroOrdem() != 0)
				sql.append(" AND " + NUMERO_ORDEM + " = " + ("" + formularioTO.getNumeroOrdem()));

			PreparedStatement stmt;
			ResultSet result;
			
			FormularioTO returnTO = new FormularioTO();
			
			try {
				stmt = getConexao().prepareStatement(sql.toString());
				
				result = stmt.executeQuery();
				while (result.next()) {
					returnTO = carregarTO(result);
				}
				
			} catch (SQLException e) {
				log.error(e.getMessage());
				throw new ExceptionPersistenciaPRO(e.getMessage());
			}
			return returnTO;
		}
		
		
		private FormularioTO carregarTO(ResultSet resultado) throws SQLException{
		    FormularioTO formularioTO = new FormularioTO();
		    formularioTO.setCodConfigTarefa(resultado.getInt(1));
		    formularioTO.setNumeroOrdem(resultado.getInt(2));
		    formularioTO.setNome(resultado.getString(3));
		    formularioTO.setIndFormularioCritico(resultado.getString(4));
		    formularioTO.setCodTipoDadoFormulario(resultado.getInt(5));
		    formularioTO.setIndFormularioVigente(resultado.getString(6));
		    return formularioTO;
		}
		
		
		private FormularioTO carregarTOFormularioConfigTarefa(ResultSet resultado) throws SQLException{
		    FormularioTO formularioTO = new FormularioTO();
		    formularioTO.setCodPrefixo(resultado.getInt(1));
		    formularioTO.setNomeConfigTarefa(resultado.getString(2));
		    formularioTO.setCodConfigTarefa(resultado.getInt(3));
		    formularioTO.setNumeroOrdem(resultado.getInt(4));
		    formularioTO.setNome(resultado.getString(5));
		    formularioTO.setIndFormularioCritico(resultado.getString(6));
		    formularioTO.setCodConfigTarefa(resultado.getInt(7));
		    formularioTO.setIndFormularioVigente(resultado.getString(8));
		    return formularioTO;
		}
		
		private Connection getConexao(){
			return getConnection();
		}
		
		
		public int consultarMaxNumeroOrdem(FormularioTO formularioTO) throws ExceptionPersistenciaPRO {
		    StringBuffer sql = new StringBuffer("SELECT MAX(");
			if(formularioTO.getCodConfigTarefa() != 0){
				sql.append(NUMERO_ORDEM);
			}
			sql.append(") AS ");
			sql.append(NUMERO_ORDEM);
			sql.append(" FROM ");
			sql.append(TABELA);		
			sql.append(" WHERE 1=1");

			if(formularioTO.getCodConfigTarefa() != 0){
				sql.append(" AND " + CODIGO);
			}
			if(formularioTO.getCodConfigTarefa() != 0){		
				sql.append("=?");
			}

			PreparedStatement stmt;
			ResultSet result;		
			try {
				stmt = getConexao().prepareStatement(sql.toString());
				if(formularioTO.getCodConfigTarefa() != 0){
					stmt.setInt(1,formularioTO.getCodConfigTarefa());
				}
				result = stmt.executeQuery();
				while (result.next()) {
					return result.getInt(NUMERO_ORDEM)+1;
				}			
			} 
			catch (SQLException e) {
			    log.error(e.getMessage());
				throw new ExceptionPersistenciaPRO(e.getMessage());
			}		
			return 0;
		}

	  
	    @SuppressWarnings({ "unchecked", "unchecked" })
		public Collection consultaFormularioConfigTarefa(FormularioTO formularioTO) throws ExceptionPersistenciaPRO {
	        StringBuffer sql = new StringBuffer("SELECT ");
	        sql.append("B." + NOMETAREFA + ", ");
			sql.append("A." + CODIGO + ", ");
			sql.append("A." + NUMERO_ORDEM + ", ");
			sql.append("A." + NOME  + ", ");
			sql.append("A." + IND_FORMULARIO_CRITICO + ", ");
			sql.append("A." + CODIGO_TIPO_DADO_FORMULARIO + ", ");
			sql.append("A." + IND_FORMULARIO_VIGENTE);
			
			sql.append(" FROM ");
			sql.append(TABELA + " A " + ", ");
			sql.append(TABELAATV + " B ");
			sql.append("WHERE ");
			sql.append("A." + CODIGO + " = " + "B." + CODIGO);		
			
			if (formularioTO.getCodConfigTarefa() != 0)				    
			    sql.append(" AND A." + CODIGO + " =?");
			if ((formularioTO.getNome() != null) && !(formularioTO.getNome().trim().equals("")))		
			    sql.append(" AND UPPER(A." + NOME + ") LIKE ?");		
			
			sql.append(" ORDER BY " + "UPPER(B." + NOMETAREFA + "), " + "A." + NUMERO_ORDEM + ", " + 
			           "A." + NOME + ", " + "A." + IND_FORMULARIO_CRITICO + ", " + "A." + IND_FORMULARIO_VIGENTE);
			
			PreparedStatement stmt;
			Collection listaFormularios = new ArrayList();
			
			try {
				int i=1;
				stmt = getConexao().prepareStatement(sql.toString());
				
				// Conclui a montagem da StringBuffer dinamica informando os campos e os valors a serem utilizados como filtro na pesquisa
				if (formularioTO.getCodConfigTarefa() != 0){
				    stmt.setInt(i, formularioTO.getCodConfigTarefa());
				    i++;
				}
				if ((formularioTO.getNome() != null) && !(formularioTO.getNome().trim().equals("")))
				    stmt.setString(i, "%" +  formularioTO.getNome().toUpperCase() + "%");
				
				
				ResultSet resultado = stmt.executeQuery();
				while (resultado.next()) {
					listaFormularios.add(carregarTOFormularioConfigTarefa(resultado));				
				}			
			} catch (SQLException e) {
				log.error(e.getMessage());
				throw new DaoException(e.getMessage());
			}
			
			return listaFormularios;
	    }
}
