
package br.com.intraPRO.persistencia.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.intraBSC.persistencia.BscDaoJDBCGenerico;
import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.ConteudoItemTarefaTO;
import br.com.intraPRO.persistencia.ConteudoItemTarefaDAO;

import com.ibatis.dao.client.DaoManager;


public class ConteudoItemTarefaDAOImpl extends BscDaoJDBCGenerico implements ConteudoItemTarefaDAO {
	protected final static String TABELA = "DESCRIPTIONITEMTASK";
    protected final static String TABELA_ITEM_CONFIG_TASK = "ITEMCONFIGURATIONTASK";    
    
    protected final static String TABELA_ATVD = "TASK";
    
	protected final static String ANO_CRIACAO_TASK = "PK_YEAR_START_TASK";
	protected final static String NUMERO_SEQUENCIAL = "PK_SEQUENCE_TASK";
	protected final static String CODIGO_CONFIG_TASK = "PK_CONFIG_TASK";
	protected final static String NUMERO_ORDEM = "PK_ORDER_ITEM";
	protected final static String TEXTO_ITEM_ATVD = "TX_FIELD_ITEM";

    protected final static String NOME_ITEM= "NAME_ITEM";    
    
    protected final static String INDICADOR_ITEM_CRITICO = "FLAG_ITEM_CONTENT";
    protected final static String INDICADOR_ITEM_VIGENTE = "FLAG_ITEM_VALIDITY";
    
	private static Log log = LogFactory.getLog(TarefaDAOImpl.class);

	public ConteudoItemTarefaDAOImpl(DaoManager daoManager) {
		super(daoManager);
	}

	public void incluir(ConteudoItemTarefaTO conteudoItemTarefaTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("INSERT INTO ");
		sql.append(TABELA);
		sql.append(" (");
		if (conteudoItemTarefaTO.getAnoCriacao() != 0) {
			sql.append(ANO_CRIACAO_TASK + ", ");
		}
		if (conteudoItemTarefaTO.getCodTarefa() != 0) {
			sql.append(NUMERO_SEQUENCIAL + ", ");
		}
		if (conteudoItemTarefaTO.getCodConfigTarefa() != 0) {
			sql.append(CODIGO_CONFIG_TASK + ", ");
		}
		if (conteudoItemTarefaTO.getNumeroOrdem() != 0) {
			sql.append(NUMERO_ORDEM + ", ");
		}
		if ((conteudoItemTarefaTO.getTextoItemTarefa() != null) && (!conteudoItemTarefaTO.getTextoItemTarefa().equals(""))) {
			sql.append(TEXTO_ITEM_ATVD);
		}else{
			sql.delete(sql.length() - 2, sql.length());
		}
		sql.append(") VALUES (");
		if (conteudoItemTarefaTO.getAnoCriacao() != 0) {
			sql.append(" ?, ");
		}
		if (conteudoItemTarefaTO.getCodTarefa() != 0) {
			sql.append(" ?, ");
		}
		if (conteudoItemTarefaTO.getCodConfigTarefa() != 0) {
			sql.append(" ?, ");
		}
		if (conteudoItemTarefaTO.getNumeroOrdem() != 0) {
			sql.append(" ?, ");
		}
		if ((conteudoItemTarefaTO.getTextoItemTarefa() != null) && (!conteudoItemTarefaTO.getTextoItemTarefa().equals(""))) {
			sql.append(" ? ");
		}else{
			sql.delete(sql.length() - 2, sql.length());
		}
		sql.append(")");

		PreparedStatement stmt;
		try {
			int i = 0;
			stmt = getConnection().prepareStatement(sql.toString());
			if (conteudoItemTarefaTO.getAnoCriacao() != 0) {
				stmt.setInt(++i, conteudoItemTarefaTO.getAnoCriacao());
			}
			if (conteudoItemTarefaTO.getCodTarefa() != 0) {
				stmt.setInt(++i, conteudoItemTarefaTO.getCodTarefa());
			}
			if (conteudoItemTarefaTO.getCodConfigTarefa() != 0) {
				stmt.setInt(++i, conteudoItemTarefaTO.getCodConfigTarefa());
			}
			if (conteudoItemTarefaTO.getNumeroOrdem() != 0) {
				stmt.setInt(++i, conteudoItemTarefaTO.getNumeroOrdem());
			}
			if ((conteudoItemTarefaTO.getTextoItemTarefa() != null) && (!conteudoItemTarefaTO.getTextoItemTarefa().equals(""))) {
				stmt.setString(++i, conteudoItemTarefaTO.getTextoItemTarefa());
			}
			stmt.executeUpdate();
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
	}


//	public Collection consultarItemCriticos(ConteudoItemTarefaTO conteudoItemTarefaTO) throws ExceptionPersistenciaPRO {
//		StringBuffer sql = new StringBuffer();
//
//		sql.append("SELECT  A."+NOME_ITEM+", ");
//		sql.append("B."+ ANO_CRIACAO_TASK + ", ");
//		sql.append("B."+NUMERO_SEQUENCIAL + ", ");
//		sql.append("B."+CODIGO_CONFIG_TASK+", ");
//		sql.append("A."+NUMERO_ORDEM+", ");
//		sql.append("B."+TEXTO_ITEM_ATVD+", ");
//		sql.append("A."+INDICADOR_ITEM_VIGENTE+", ");
//		sql.append("A."+ItemDAOImpl.CODIGO_TIPO_DADO_ITEM);
//
//		sql.append(" FROM " + TABELA_ITEM_CONFIG_TASK +" A ");
//		sql.append("LEFT JOIN " + TABELA + " B ON( B."+NUMERO_ORDEM+" =  A."+NUMERO_ORDEM+" AND " );
//		sql.append("B."+CODIGO_CONFIG_TASK+" =  A."+CODIGO_CONFIG_TASK);
//		sql.append(" AND B."+ANO_CRIACAO_TASK+" = ? ");
//		sql.append(" AND B."+NUMERO_SEQUENCIAL+" = ? ) ");
//		sql.append("WHERE A."+INDICADOR_ITEM_CRITICO+" = 'S' ");
//	
//		if (conteudoItemTarefaTO.getCodConfigTarefa() != 0) {
//			sql.append("AND A."+CODIGO_CONFIG_TASK+" = ? ");
//		}
//
//		sql.append("ORDER BY  A."+NUMERO_ORDEM);
//
//		int i = 0;
//		PreparedStatement stmt = null;
//		ResultSet resultado = null;
//		Collection itemsCriticos = new ArrayList();
//		try {
//			stmt = getConnection().prepareStatement(sql.toString());
//			if (conteudoItemTarefaTO.getAnoCriacao() != 0) {
//				stmt.setInt(++i, conteudoItemTarefaTO.getAnoCriacao());
//			}
//			if (conteudoItemTarefaTO.getCodTarefa() != 0) {
//				stmt.setInt(++i, conteudoItemTarefaTO.getCodTarefa());
//			}
//			if (conteudoItemTarefaTO.getCodConfigTarefa() != 0) {
//				stmt.setInt(++i, conteudoItemTarefaTO.getCodConfigTarefa());
//			}
//
//			resultado = stmt.executeQuery();
//
//			while (resultado.next()) {
//				itemsCriticos.add(getConteudoItemTarefaTO(resultado));
//			}
//
//		} catch (SQLException e) {
//			log.error(e.getMessage());
//			throw new ExceptionPersistenciaPRO(e.getMessage());
//		}
//		return itemsCriticos;
//	}

	private ConteudoItemTarefaTO getConteudoItemTarefaTO(ResultSet resultado) throws SQLException {
		int i = 0;
		ConteudoItemTarefaTO conteudoItemTarefaTO = new ConteudoItemTarefaTO();
		conteudoItemTarefaTO.setNomeItem(resultado.getString(++i));
		conteudoItemTarefaTO.setAnoCriacao(resultado.getInt(++i));
		conteudoItemTarefaTO.setCodTarefa(resultado.getInt(++i));
		conteudoItemTarefaTO.setCodConfigTarefa(resultado.getInt(++i));
		conteudoItemTarefaTO.setNumeroOrdem(resultado.getInt(++i));
		conteudoItemTarefaTO.setTextoItemTarefa(resultado.getString(++i));
		conteudoItemTarefaTO.setIndVigente(resultado.getString(++i));
		conteudoItemTarefaTO.setCodTipoDadoItem(resultado.getInt(++i));
		

		return conteudoItemTarefaTO;

	}
  
	
    @SuppressWarnings("unchecked")
	public Collection consultarItems(ConteudoItemTarefaTO conteudoItemTarefaTO) throws ExceptionPersistenciaPRO {
        StringBuffer sql = new StringBuffer("SELECT ");
        sql.append("A."+NOME_ITEM);
        sql.append(", ");
        sql.append("B."+ANO_CRIACAO_TASK);        
        sql.append(", ");
        sql.append("B."+NUMERO_SEQUENCIAL);
        sql.append(", ");
        sql.append("A."+CODIGO_CONFIG_TASK);
        sql.append(", ");        
        sql.append("A."+NUMERO_ORDEM);
        sql.append(", ");
        sql.append("B."+TEXTO_ITEM_ATVD);
        sql.append(", ");
        sql.append("A."+INDICADOR_ITEM_VIGENTE + ", ");
        sql.append("A."+ ItemDAOImpl.CODIGO_TIPO_DADO_ITEM);
        sql.append(" FROM ");
        sql.append(TABELA_ITEM_CONFIG_TASK + " A ");
        sql.append("LEFT OUTER JOIN " + TABELA + " B ON( B." + NUMERO_ORDEM + " = A." + NUMERO_ORDEM + 
        		   " AND B." + CODIGO_CONFIG_TASK + " = A." + CODIGO_CONFIG_TASK);
        sql.append(" AND B."+ANO_CRIACAO_TASK+" = ? ");
        sql.append(" AND B."+NUMERO_SEQUENCIAL+" = ? ) ");
        
		
        sql.append("WHERE 1=1 ");

        if (conteudoItemTarefaTO.getCodConfigTarefa() != 0) {
            sql.append(" AND A."+CODIGO_CONFIG_TASK+" = ? ");
        }
        if ((conteudoItemTarefaTO.getIndVigente() != null) && (!conteudoItemTarefaTO.getIndVigente().equals(""))) {
        	sql.append(" AND A."+INDICADOR_ITEM_VIGENTE+" = ?  ");
        }
        
        sql.append(" ORDER BY  A."+NUMERO_ORDEM);

        PreparedStatement stmt = null;
        ResultSet resultado = null;
        Collection listaItems = new ArrayList();
        int i = 0;
        try {
            stmt = getConnection().prepareStatement(sql.toString());
            if (conteudoItemTarefaTO.getAnoCriacao() != 0) {
                stmt.setInt(++i, conteudoItemTarefaTO.getAnoCriacao());
            }
            if (conteudoItemTarefaTO.getCodTarefa() != 0) {
                stmt.setInt(++i, conteudoItemTarefaTO.getCodTarefa());
            }
            if (conteudoItemTarefaTO.getCodConfigTarefa() != 0) {
                stmt.setInt(++i, conteudoItemTarefaTO.getCodConfigTarefa());
            }
            if ((conteudoItemTarefaTO.getIndVigente() != null) && (!conteudoItemTarefaTO.getIndVigente().equals(""))) {
                stmt.setString(++i, conteudoItemTarefaTO.getIndVigente());
            }
            resultado = stmt.executeQuery();

            while (resultado.next()) {
                listaItems.add(getConteudoItemTarefaTO(resultado));
            }

        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new ExceptionPersistenciaPRO(e.getMessage());
        }
        return listaItems;
    }
   
    
    public void excluirItemTarefa(ConteudoItemTarefaTO conteudoItemTarefaTO) throws ExceptionPersistenciaPRO {
        StringBuffer sql = new StringBuffer("DELETE FROM ");
        sql.append(TABELA);
        sql.append(" WHERE 1=1");
        sql.append(" AND ");
        sql.append(ANO_CRIACAO_TASK + "=?");
        sql.append(" AND ");
        sql.append(NUMERO_SEQUENCIAL + "=?");
        sql.append(" AND ");
        sql.append(CODIGO_CONFIG_TASK + "=?");
        sql.append(" AND ");
        sql.append(NUMERO_ORDEM + "=?");        

        PreparedStatement stmt;
        try {
            int i = 0;
            stmt = getConnection().prepareStatement(sql.toString());
            if (conteudoItemTarefaTO.getAnoCriacao() != 0) {
                stmt.setInt(++i, conteudoItemTarefaTO.getAnoCriacao());
            }
            if (conteudoItemTarefaTO.getCodTarefa() != 0) {
                stmt.setInt(++i, conteudoItemTarefaTO.getCodTarefa());
            }
            if (conteudoItemTarefaTO.getCodConfigTarefa() != 0) {
                stmt.setInt(++i, conteudoItemTarefaTO.getCodConfigTarefa());
            }
            if (conteudoItemTarefaTO.getNumeroOrdem() != 0) {
                stmt.setInt(++i, conteudoItemTarefaTO.getNumeroOrdem());
            }
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new ExceptionPersistenciaPRO(e.getMessage());
        }
    }

    public void incluirItemTarefa(ConteudoItemTarefaTO conteudoItemTarefaTO) throws ExceptionPersistenciaPRO {
        StringBuffer sql = new StringBuffer("INSERT INTO ");
        sql.append(TABELA);
        sql.append(" (");
        if (conteudoItemTarefaTO.getAnoCriacao() != 0) {
            sql.append(ANO_CRIACAO_TASK + ", ");
        }
        if (conteudoItemTarefaTO.getCodTarefa() != 0) {
            sql.append(NUMERO_SEQUENCIAL + ", ");
        }
        if (conteudoItemTarefaTO.getCodConfigTarefa() != 0) {
            sql.append(CODIGO_CONFIG_TASK + ", ");
        }
        if (conteudoItemTarefaTO.getNumeroOrdem() != 0) {
            sql.append(NUMERO_ORDEM + ", ");
        }
        if ((conteudoItemTarefaTO.getTextoItemTarefa() != null) && (!conteudoItemTarefaTO.getTextoItemTarefa().equals(""))) {
            sql.append(TEXTO_ITEM_ATVD);
        }
        else {
            sql.delete(sql.length() - 2, sql.length());
        }
        
        sql.append(") VALUES (");
        if (conteudoItemTarefaTO.getAnoCriacao() != 0) {
            sql.append("?" + ", ");
        }
        if (conteudoItemTarefaTO.getCodTarefa() != 0) {
            sql.append("?" + ", ");
        }
        if (conteudoItemTarefaTO.getCodConfigTarefa() != 0) {
            sql.append("?" + ", ");
        }
        if (conteudoItemTarefaTO.getNumeroOrdem() != 0) {
            sql.append("?" + ", ");
        }
        if ((conteudoItemTarefaTO.getTextoItemTarefa() != null) && (!conteudoItemTarefaTO.getTextoItemTarefa().equals(""))) {
            sql.append("?");
        }
        else {
            sql.delete(sql.length() - 2, sql.length());
        }
        sql.append(")");
        

        PreparedStatement stmt;
        try {
            int i = 0;
            stmt = getConnection().prepareStatement(sql.toString());
            if (conteudoItemTarefaTO.getAnoCriacao() != 0) {
                stmt.setInt(++i, conteudoItemTarefaTO.getAnoCriacao());
            }
            if (conteudoItemTarefaTO.getCodTarefa() != 0) {
                stmt.setInt(++i, conteudoItemTarefaTO.getCodTarefa());
            }
            if (conteudoItemTarefaTO.getCodConfigTarefa() != 0) {
                stmt.setInt(++i, conteudoItemTarefaTO.getCodConfigTarefa());
            }
            if (conteudoItemTarefaTO.getNumeroOrdem() != 0) {
                stmt.setInt(++i, conteudoItemTarefaTO.getNumeroOrdem());
            }
            if ((conteudoItemTarefaTO.getTextoItemTarefa() != "") && (!conteudoItemTarefaTO.getTextoItemTarefa().equals(""))) {
                stmt.setString(++i, conteudoItemTarefaTO.getTextoItemTarefa().trim());
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new ExceptionPersistenciaPRO(e.getMessage());
        }
    }

	public void alterar(ConteudoItemTarefaTO conteudoItemTarefaTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("UPDATE ");
        sql.append(TABELA + " SET ");
		if ((conteudoItemTarefaTO.getTextoItemTarefa() != null) && (!conteudoItemTarefaTO.getTextoItemTarefa().equals(""))) {
			sql.append(TEXTO_ITEM_ATVD + " = ? ");
		}
		sql.append(" WHERE 1=1 ");
		sql.append("AND " + ANO_CRIACAO_TASK + " = ? ");	
		sql.append("AND " + NUMERO_SEQUENCIAL + " = ? ");
		sql.append("AND " + CODIGO_CONFIG_TASK + " = ? ");
		sql.append("AND " + NUMERO_ORDEM + " = ? ");
		
		PreparedStatement stmt;
		try {
			int i = 0;
			stmt = getConnection().prepareStatement(sql.toString());
			
			if ((!conteudoItemTarefaTO.getTextoItemTarefa().equals("")) && (conteudoItemTarefaTO.getTextoItemTarefa() != null)) {
				stmt.setString(++i, conteudoItemTarefaTO.getTextoItemTarefa());
			}
			/*Clausula Where*/
			stmt.setInt(++i, conteudoItemTarefaTO.getAnoCriacao());
			stmt.setInt(++i, conteudoItemTarefaTO.getCodTarefa());
			stmt.setInt(++i, conteudoItemTarefaTO.getCodConfigTarefa());
			stmt.setInt(++i, conteudoItemTarefaTO.getNumeroOrdem());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
		
	}

	/*Consulta para verificar se é necessario incluir item critico ou somente alterar o dado*/
	@SuppressWarnings("unchecked")
	public Collection consultarItemCritico(ConteudoItemTarefaTO conteudoItemTarefaTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer();

		sql.append("SELECT ");
		sql.append("A."+ ANO_CRIACAO_TASK + ", ");
		sql.append("A."+NUMERO_SEQUENCIAL + ", ");
		sql.append("A."+CODIGO_CONFIG_TASK+", ");
		sql.append("A."+NUMERO_ORDEM+", ");
		sql.append("A."+TEXTO_ITEM_ATVD+" ");
		sql.append(" FROM " + TABELA +" A ");		
		sql.append(" WHERE 1=1 ");
		sql.append("AND " + ANO_CRIACAO_TASK + " = ? ");	
		sql.append("AND " + NUMERO_SEQUENCIAL + " = ? ");
		sql.append("AND " + CODIGO_CONFIG_TASK + " = ? ");
		sql.append("AND " + NUMERO_ORDEM + " = ? ");

		sql.append("ORDER BY  A."+NUMERO_ORDEM);

		int i = 0;
		PreparedStatement stmt = null;
		ResultSet resultado = null;
		Collection itemsCriticos = new ArrayList();
		try {
			stmt = getConnection().prepareStatement(sql.toString());
			/*Clausula Where*/
			stmt.setInt(++i, conteudoItemTarefaTO.getAnoCriacao());
			stmt.setInt(++i, conteudoItemTarefaTO.getCodTarefa());
			stmt.setInt(++i, conteudoItemTarefaTO.getCodConfigTarefa());
			stmt.setInt(++i, conteudoItemTarefaTO.getNumeroOrdem());
			resultado = stmt.executeQuery();
			while (resultado.next()) {
				int j = 0;
				ConteudoItemTarefaTO conteudoItemTarefaTOResult = new ConteudoItemTarefaTO();
				conteudoItemTarefaTOResult.setAnoCriacao(resultado.getInt(++j));
				conteudoItemTarefaTOResult.setCodTarefa(resultado.getInt(++j));
				conteudoItemTarefaTOResult.setCodConfigTarefa(resultado.getInt(++j));
				conteudoItemTarefaTOResult.setNumeroOrdem(resultado.getInt(++j));
				conteudoItemTarefaTOResult.setTextoItemTarefa(resultado.getString(++j));
				
				itemsCriticos.add(conteudoItemTarefaTOResult);
			}

		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
		return itemsCriticos;
	}

}
