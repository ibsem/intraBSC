
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
import br.com.intraPRO.modelo.ItemTO;
import br.com.intraPRO.persistencia.ItemDAO;

import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;

/**
Classe que contem a implimentação da DAO de Item.
Ele realiza os SQLs.
*/
public class ItemDAOImpl extends BscDaoJDBCGenerico implements ItemDAO{
	
	   protected final static String TABELA = "ITEMCONFIGURATIONTASK";
	   protected final static String TABELAATV = "CONFIGURATIONTASK";
	   protected final static String CODIGO = "PK_CONFIG_TASK";
	   protected final static String NUMERO_ORDEM = "PK_ORDER_ITEM";
	   protected final static String NOME = "NAME_ITEM";
	   protected final static String IND_ITEM_CRITICO = "FLAG_ITEM_CONTENT";
	   protected final static String IND_ITEM_VIGENTE = "FLAG_ITEM_VALIDITY";
	   protected final static String CODIGO_TIPO_DADO_ITEM = "ID_TYPE_DATA_ITEM";
	   
	   protected final static String NOMETAREFA = "TX_CONFIGTASK";
	   
	   private static Log log = LogFactory.getLog(ItemDAOImpl.class);   
	   
	   
	   public ItemDAOImpl(DaoManager daoManager){
	   		super(daoManager);
	   }


		public void incluir(ItemTO itemTO) throws ExceptionPersistenciaPRO {
		    StringBuffer sql = new StringBuffer("INSERT INTO ");
	   		sql.append(TABELA + " (");   		

	   		if (itemTO.getCodConfigTarefa() != 0){
				sql.append(CODIGO + ", ");
	   		}
	   		if (itemTO.getNumeroOrdem() != 0){
				sql.append(NUMERO_ORDEM + ", ");	
	   		}
	   		if ((itemTO.getNome() != null) && !(itemTO.getNome().trim().equalsIgnoreCase(""))){
				sql.append(NOME + ", ");
	   		}
	   		if ((itemTO.getIndItemCritico() != null) && !(itemTO.getIndItemCritico().trim().equalsIgnoreCase(""))){
				sql.append(IND_ITEM_CRITICO + ", ");
	   		}
	   		if ((itemTO.getCodTipoDadoItem()!= 0)){
				sql.append(CODIGO_TIPO_DADO_ITEM + ", ");
	   		}
	   		if ((itemTO.getIndItemVigente() != null) && !(itemTO.getIndItemVigente().trim().equalsIgnoreCase(""))){
		   		sql.append(IND_ITEM_VIGENTE);
	   		}
	        else {
	            sql.delete(sql.length() - 2, sql.length());
	        }
	   		
	   		
	   		sql.append(") VALUES (");
	   		
			if (itemTO.getCodConfigTarefa() != 0){
				sql.append("?, ");
			}
			if(itemTO.getNumeroOrdem() != 0){
				sql.append("?, ");
			}
			if ((itemTO.getNome() != null) && !(itemTO.getNome().trim().equalsIgnoreCase(""))){
				sql.append("?, ");
			}
			if ((itemTO.getIndItemCritico() != null) && !(itemTO.getIndItemCritico().trim().equalsIgnoreCase(""))){
				sql.append("?, ");
			}
			if ((itemTO.getCodTipoDadoItem()!= 0)){
				sql.append("?, ");
	   		}
			if ((itemTO.getIndItemVigente()!= null) && !(itemTO.getIndItemVigente().trim().equalsIgnoreCase(""))){
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
				
				if (itemTO.getCodConfigTarefa() != 0)
					stmt.setInt(++i, itemTO.getCodConfigTarefa());

				if (itemTO.getNumeroOrdem() != 0);
					stmt.setInt(++i, itemTO.getNumeroOrdem());
				
				if ((itemTO.getNome() != null) && !(itemTO.getNome().trim().equalsIgnoreCase("")))		
					stmt.setString(++i, itemTO.getNome());
				
				if ((itemTO.getIndItemCritico() != null) && !(itemTO.getIndItemCritico().trim().equalsIgnoreCase("")));
					stmt.setString(++i, itemTO.getIndItemCritico());
					
				if ((itemTO.getCodTipoDadoItem()!= 0)){
					stmt.setInt(++i, itemTO.getCodTipoDadoItem());
		   		}
				
				if ((itemTO.getIndItemVigente()!= null) && !(itemTO.getIndItemVigente().trim().equalsIgnoreCase("")));
					stmt.setString(++i, itemTO.getIndItemVigente());
					
				stmt.executeUpdate();
			} 
			catch (SQLException e) {
			    log.error(e.getMessage());
				throw new ExceptionPersistenciaPRO(e.getMessage());
			}		
		}
		
		

		public void alterar(ItemTO itemTO) throws ExceptionPersistenciaPRO {
		    StringBuffer sql = new StringBuffer("UPDATE ");
			sql.append(TABELA);
			sql.append(" SET ");
			
			if (itemTO.getNumeroOrdem() != 0)
				{sql.append(NUMERO_ORDEM + " = "); 	
			    sql.append(" ?, ");}
			if ((itemTO.getNome() != null) && !(itemTO.getNome().equalsIgnoreCase("")))
				{sql.append(NOME + " = ");
			    sql.append(" ?, ");}
			if ((itemTO.getIndItemCritico() != null) && !(itemTO.getIndItemCritico().equalsIgnoreCase("")))
				{sql.append(IND_ITEM_CRITICO + " = ");
				sql.append(" ?, ");}
			if ((itemTO.getCodTipoDadoItem()!= 0)){
				sql.append(CODIGO_TIPO_DADO_ITEM + " = ");
				sql.append(" ?, ");}
			if ((itemTO.getIndItemVigente() != null) && !(itemTO.getIndItemVigente().equalsIgnoreCase("")))
				{sql.append(IND_ITEM_VIGENTE + " = ");
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
				
				if (itemTO.getNumeroOrdem() != 0)
				    stmt.setInt(++i, itemTO.getNumeroOrdem());
				
				if ((itemTO.getNome() != null) && !(itemTO.getNome().trim().equalsIgnoreCase("")))
				    stmt.setString(++i, itemTO.getNome().trim());
				if ((itemTO.getIndItemCritico() != null) && !(itemTO.getIndItemCritico().trim().equalsIgnoreCase("")))
				    stmt.setString(++i, itemTO.getIndItemCritico().trim().toUpperCase());
				if ((itemTO.getCodTipoDadoItem()!= 0))
					stmt.setInt(++i, itemTO.getCodTipoDadoItem());
				if ((itemTO.getIndItemVigente() != null) && !(itemTO.getIndItemVigente().trim().equalsIgnoreCase("")))
				    stmt.setString(++i, itemTO.getIndItemVigente().trim().toUpperCase());			
				if (itemTO.getCodConfigTarefa() != 0)
				    stmt.setInt(++i, itemTO.getCodConfigTarefa());
				if (itemTO.getNumeroOrdem() != 0){
					if (itemTO.getNumeroOrdem() == itemTO.getNumOrdemAnterior()){
						stmt.setInt(++i, itemTO.getNumeroOrdem());
					} else {
						stmt.setInt(++i, itemTO.getNumOrdemAnterior());
					}
				}
				
				stmt.executeUpdate();			
			} catch (SQLException e) {		    
			    log.error(e.getMessage());
				throw new ExceptionPersistenciaPRO(e.getMessage());
			}		
		}

		@SuppressWarnings("unchecked")
		public Collection consultarVarios(ItemTO itemTO) throws ExceptionPersistenciaPRO {
			StringBuffer sql = new StringBuffer("SELECT ");
			sql.append(CODIGO + ", ");
			sql.append(NUMERO_ORDEM + ", ");
			sql.append(NOME  + ", ");
			sql.append(IND_ITEM_CRITICO + ", ");
			sql.append(CODIGO_TIPO_DADO_ITEM + ", ");
			sql.append(IND_ITEM_VIGENTE);
			sql.append(" FROM ");
			sql.append(TABELA + " A ");
			sql.append("WHERE 1=1 ");
			
			
			if (itemTO.getCodConfigTarefa() != 0)				    
			    sql.append(" AND A." + CODIGO + " =?");
			if ((itemTO.getNome() != null) && !(itemTO.getNome().trim().equals("")))		
			    sql.append(" AND UPPER(A." + NOME + ") LIKE ?");	
			if ((itemTO.getIndItemVigente() != null) && !(itemTO.getIndItemVigente().equals("")))		
			    sql.append(" AND A." + IND_ITEM_VIGENTE + " = ?");	
			sql.append(" ORDER BY " + CODIGO + ", " + NUMERO_ORDEM + ", " + NOME + ", " + IND_ITEM_CRITICO + ", " + IND_ITEM_VIGENTE);
			PreparedStatement stmt;
			Collection listaItems = new ArrayList();
			try {
				int i=1;
				stmt = getConexao().prepareStatement(sql.toString());
				
				// Conclui a montagem da StringBuffer dinamica informando os campos e os valors a serem utilizados como filtro na pesquisa
				if (itemTO.getCodConfigTarefa() != 0){
				    stmt.setInt(i, itemTO.getCodConfigTarefa());
				    i++;
				}
				if ((itemTO.getNome() != null) && !(itemTO.getNome().trim().equals(""))){
				    stmt.setString(i, "%" +  itemTO.getNome().toUpperCase() + "%");
				}
				if ((itemTO.getIndItemVigente() != null) && !(itemTO.getIndItemVigente().equals(""))){
				    stmt.setString(i, itemTO.getIndItemVigente());
				}
				
				
				ResultSet resultado = stmt.executeQuery();
				while (resultado.next()) {
					listaItems.add(carregarTO(resultado));				
				}			
			} catch (SQLException e) {
				log.error(e.getMessage());
				throw new DaoException(e.getMessage());
			}
			
			return listaItems;
		}
		
		
		public ItemTO consultarUm(ItemTO itemTO) throws ExceptionPersistenciaPRO {
			StringBuffer sql = new StringBuffer("SELECT ");
			sql.append(CODIGO);
			sql.append(", ");
			sql.append(NUMERO_ORDEM);
			sql.append(", ");			
			sql.append(NOME);
			sql.append(", ");
			sql.append(IND_ITEM_CRITICO);
			sql.append(", ");
			sql.append(CODIGO_TIPO_DADO_ITEM + ", ");
			sql.append(IND_ITEM_VIGENTE);		
			sql.append(" FROM ");
			sql.append(TABELA);
			sql.append(" A ");
			sql.append(" WHERE 1 = 1");

			if (itemTO.getCodConfigTarefa() != 0)
				sql.append(" AND " + CODIGO + " = " + ("" + itemTO.getCodConfigTarefa()) );

			if (itemTO.getNumeroOrdem() != 0)
				sql.append(" AND " + NUMERO_ORDEM + " = " + ("" + itemTO.getNumeroOrdem()));

			PreparedStatement stmt;
			ResultSet result;
			
			ItemTO returnTO = new ItemTO();
			
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
		
		
		private ItemTO carregarTO(ResultSet resultado) throws SQLException{
		    ItemTO itemTO = new ItemTO();
		    itemTO.setCodConfigTarefa(resultado.getInt(1));
		    itemTO.setNumeroOrdem(resultado.getInt(2));
		    itemTO.setNome(resultado.getString(3));
		    itemTO.setIndItemCritico(resultado.getString(4));
		    itemTO.setCodTipoDadoItem(resultado.getInt(5));
		    itemTO.setIndItemVigente(resultado.getString(6));
		    return itemTO;
		}
		
		
		private ItemTO carregarTOItemConfigTarefa(ResultSet resultado) throws SQLException{
		    ItemTO itemTO = new ItemTO();
		    itemTO.setCodPrefixo(resultado.getInt(1));
		    itemTO.setNomeConfigTarefa(resultado.getString(2));
		    itemTO.setCodConfigTarefa(resultado.getInt(3));
		    itemTO.setNumeroOrdem(resultado.getInt(4));
		    itemTO.setNome(resultado.getString(5));
		    itemTO.setIndItemCritico(resultado.getString(6));
		    itemTO.setCodConfigTarefa(resultado.getInt(7));
		    itemTO.setIndItemVigente(resultado.getString(8));
		    return itemTO;
		}
		
		private Connection getConexao(){
			return getConnection();
		}
		
		
		public int consultarMaxNumeroOrdem(ItemTO itemTO) throws ExceptionPersistenciaPRO {
		    StringBuffer sql = new StringBuffer("SELECT MAX(");
			if(itemTO.getCodConfigTarefa() != 0){
				sql.append(NUMERO_ORDEM);
			}
			sql.append(") AS ");
			sql.append(NUMERO_ORDEM);
			sql.append(" FROM ");
			sql.append(TABELA);		
			sql.append(" WHERE 1=1");

			if(itemTO.getCodConfigTarefa() != 0){
				sql.append(" AND " + CODIGO);
			}
			if(itemTO.getCodConfigTarefa() != 0){		
				sql.append("=?");
			}

			PreparedStatement stmt;
			ResultSet result;		
			try {
				stmt = getConexao().prepareStatement(sql.toString());
				if(itemTO.getCodConfigTarefa() != 0){
					stmt.setInt(1,itemTO.getCodConfigTarefa());
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
		public Collection consultaItemConfigTarefa(ItemTO itemTO) throws ExceptionPersistenciaPRO {
	        StringBuffer sql = new StringBuffer("SELECT ");
	        sql.append("B." + NOMETAREFA + ", ");
			sql.append("A." + CODIGO + ", ");
			sql.append("A." + NUMERO_ORDEM + ", ");
			sql.append("A." + NOME  + ", ");
			sql.append("A." + IND_ITEM_CRITICO + ", ");
			sql.append("A." + CODIGO_TIPO_DADO_ITEM + ", ");
			sql.append("A." + IND_ITEM_VIGENTE);
			
			sql.append(" FROM ");
			sql.append(TABELA + " A " + ", ");
			sql.append(TABELAATV + " B ");
			sql.append("WHERE ");
			sql.append("A." + CODIGO + " = " + "B." + CODIGO);		
			
			if (itemTO.getCodConfigTarefa() != 0)				    
			    sql.append(" AND A." + CODIGO + " =?");
			if ((itemTO.getNome() != null) && !(itemTO.getNome().trim().equals("")))		
			    sql.append(" AND UPPER(A." + NOME + ") LIKE ?");		
			
			sql.append(" ORDER BY " + "UPPER(B." + NOMETAREFA + "), " + "A." + NUMERO_ORDEM + ", " + 
			           "A." + NOME + ", " + "A." + IND_ITEM_CRITICO + ", " + "A." + IND_ITEM_VIGENTE);
			
			PreparedStatement stmt;
			Collection listaItems = new ArrayList();
			
			try {
				int i=1;
				stmt = getConexao().prepareStatement(sql.toString());
				
				// Conclui a montagem da StringBuffer dinamica informando os campos e os valors a serem utilizados como filtro na pesquisa
				if (itemTO.getCodConfigTarefa() != 0){
				    stmt.setInt(i, itemTO.getCodConfigTarefa());
				    i++;
				}
				if ((itemTO.getNome() != null) && !(itemTO.getNome().trim().equals("")))
				    stmt.setString(i, "%" +  itemTO.getNome().toUpperCase() + "%");
				
				
				ResultSet resultado = stmt.executeQuery();
				while (resultado.next()) {
					listaItems.add(carregarTOItemConfigTarefa(resultado));				
				}			
			} catch (SQLException e) {
				log.error(e.getMessage());
				throw new DaoException(e.getMessage());
			}
			
			return listaItems;
	    }
}
