
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
import br.com.intraPRO.modelo.ConteudoFormularioTarefaTO;
import br.com.intraPRO.persistencia.ConteudoFormularioTarefaDAO;

import com.ibatis.dao.client.DaoManager;


public class ConteudoFormularioTarefaDAOImpl extends BscDaoJDBCGenerico implements ConteudoFormularioTarefaDAO {
	protected final static String TABELA = "DESCRIPTIONFORMULARIOTASK";
    protected final static String TABELA_FORMULARIO_CONFIG_TASK = "FORMULARIOCONFIGURATIONTASK";    
    
    protected final static String TABELA_ATVD = "task";
    
	protected final static String ANO_CRIACAO_TASK = "PK_YEAR_START_TASK";
	protected final static String NUMERO_SEQUENCIAL = "PK_SEQUENCE_TASK";
	protected final static String CODIGO_CONFIG_TASK = "PK_CONFIG_TASK";
	protected final static String NUMERO_ORDEM = "PK_ORDER_FORMULARIO";
	protected final static String TEXTO_FORMULARIO_ATVD = "TX_FIELD_FORMULARIO";

    protected final static String NOME_FORMULARIO= "NAME_FORMULARIO";    
    
    protected final static String INDICADOR_FORMULARIO_CRITICO = "FLAG_FORMULARIO_CONTENT";
    protected final static String INDICADOR_FORMULARIO_VIGENTE = "FLAG_FORMULARIO_VALIDITY";
    
	private static Log log = LogFactory.getLog(TarefaDAOImpl.class);

	public ConteudoFormularioTarefaDAOImpl(DaoManager daoManager) {
		super(daoManager);
	}

	public void incluir(ConteudoFormularioTarefaTO conteudoFormularioTarefaTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("INSERT INTO ");
		sql.append(TABELA);
		sql.append(" (");
		if (conteudoFormularioTarefaTO.getAnoCriacao() != 0) {
			sql.append(ANO_CRIACAO_TASK + ", ");
		}
		if (conteudoFormularioTarefaTO.getCodTarefa() != 0) {
			sql.append(NUMERO_SEQUENCIAL + ", ");
		}
		if (conteudoFormularioTarefaTO.getCodConfigTarefa() != 0) {
			sql.append(CODIGO_CONFIG_TASK + ", ");
		}
		if (conteudoFormularioTarefaTO.getNumeroOrdem() != 0) {
			sql.append(NUMERO_ORDEM + ", ");
		}
		if ((conteudoFormularioTarefaTO.getTextoFormularioTarefa() != null) && (!conteudoFormularioTarefaTO.getTextoFormularioTarefa().equals(""))) {
			sql.append(TEXTO_FORMULARIO_ATVD);
		}else{
			sql.delete(sql.length() - 2, sql.length());
		}
		sql.append(") VALUES (");
		if (conteudoFormularioTarefaTO.getAnoCriacao() != 0) {
			sql.append(" ?, ");
		}
		if (conteudoFormularioTarefaTO.getCodTarefa() != 0) {
			sql.append(" ?, ");
		}
		if (conteudoFormularioTarefaTO.getCodConfigTarefa() != 0) {
			sql.append(" ?, ");
		}
		if (conteudoFormularioTarefaTO.getNumeroOrdem() != 0) {
			sql.append(" ?, ");
		}
		if ((conteudoFormularioTarefaTO.getTextoFormularioTarefa() != null) && (!conteudoFormularioTarefaTO.getTextoFormularioTarefa().equals(""))) {
			sql.append(" ? ");
		}else{
			sql.delete(sql.length() - 2, sql.length());
		}
		sql.append(")");

		PreparedStatement stmt;
		try {
			int i = 0;
			stmt = getConnection().prepareStatement(sql.toString());
			if (conteudoFormularioTarefaTO.getAnoCriacao() != 0) {
				stmt.setInt(++i, conteudoFormularioTarefaTO.getAnoCriacao());
			}
			if (conteudoFormularioTarefaTO.getCodTarefa() != 0) {
				stmt.setInt(++i, conteudoFormularioTarefaTO.getCodTarefa());
			}
			if (conteudoFormularioTarefaTO.getCodConfigTarefa() != 0) {
				stmt.setInt(++i, conteudoFormularioTarefaTO.getCodConfigTarefa());
			}
			if (conteudoFormularioTarefaTO.getNumeroOrdem() != 0) {
				stmt.setInt(++i, conteudoFormularioTarefaTO.getNumeroOrdem());
			}
			if ((conteudoFormularioTarefaTO.getTextoFormularioTarefa() != null) && (!conteudoFormularioTarefaTO.getTextoFormularioTarefa().equals(""))) {
				stmt.setString(++i, conteudoFormularioTarefaTO.getTextoFormularioTarefa());
			}
			stmt.executeUpdate();
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
	}


//	public Collection consultarFormularioCriticos(ConteudoFormularioTarefaTO conteudoFormularioTarefaTO) throws ExceptionPersistenciaPRO {
//		StringBuffer sql = new StringBuffer();
//
//		sql.append("SELECT  A."+NOME_FORMULARIO+", ");
//		sql.append("B."+ ANO_CRIACAO_TASK + ", ");
//		sql.append("B."+NUMERO_SEQUENCIAL + ", ");
//		sql.append("B."+CODIGO_CONFIG_TASK+", ");
//		sql.append("A."+NUMERO_ORDEM+", ");
//		sql.append("B."+TEXTO_FORMULARIO_ATVD+", ");
//		sql.append("A."+INDICADOR_FORMULARIO_VIGENTE+", ");
//		sql.append("A."+FormularioDAOImpl.CODIGO_TIPO_DADO_FORMULARIO);
//
//		sql.append(" FROM " + TABELA_FORMULARIO_CONFIG_TASK +" A ");
//		sql.append("LEFT JOIN " + TABELA + " B ON( B."+NUMERO_ORDEM+" =  A."+NUMERO_ORDEM+" AND " );
//		sql.append("B."+CODIGO_CONFIG_TASK+" =  A."+CODIGO_CONFIG_TASK);
//		sql.append(" AND B."+ANO_CRIACAO_TASK+" = ? ");
//		sql.append(" AND B."+NUMERO_SEQUENCIAL+" = ? ) ");
//		sql.append("WHERE A."+INDICADOR_FORMULARIO_CRITICO+" = 'S' ");
//	
//		if (conteudoFormularioTarefaTO.getCodConfigTarefa() != 0) {
//			sql.append("AND A."+CODIGO_CONFIG_TASK+" = ? ");
//		}
//
//		sql.append("ORDER BY  A."+NUMERO_ORDEM);
//
//		int i = 0;
//		PreparedStatement stmt = null;
//		ResultSet resultado = null;
//		Collection formulariosCriticos = new ArrayList();
//		try {
//			stmt = getConnection().prepareStatement(sql.toString());
//			if (conteudoFormularioTarefaTO.getAnoCriacao() != 0) {
//				stmt.setInt(++i, conteudoFormularioTarefaTO.getAnoCriacao());
//			}
//			if (conteudoFormularioTarefaTO.getCodTarefa() != 0) {
//				stmt.setInt(++i, conteudoFormularioTarefaTO.getCodTarefa());
//			}
//			if (conteudoFormularioTarefaTO.getCodConfigTarefa() != 0) {
//				stmt.setInt(++i, conteudoFormularioTarefaTO.getCodConfigTarefa());
//			}
//
//			resultado = stmt.executeQuery();
//
//			while (resultado.next()) {
//				formulariosCriticos.add(getConteudoFormularioTarefaTO(resultado));
//			}
//
//		} catch (SQLException e) {
//			log.error(e.getMessage());
//			throw new ExceptionPersistenciaPRO(e.getMessage());
//		}
//		return formulariosCriticos;
//	}

	private ConteudoFormularioTarefaTO getConteudoFormularioTarefaTO(ResultSet resultado) throws SQLException {
		int i = 0;
		ConteudoFormularioTarefaTO conteudoFormularioTarefaTO = new ConteudoFormularioTarefaTO();
		conteudoFormularioTarefaTO.setNomeFormulario(resultado.getString(++i));
		conteudoFormularioTarefaTO.setAnoCriacao(resultado.getInt(++i));
		conteudoFormularioTarefaTO.setCodTarefa(resultado.getInt(++i));
		conteudoFormularioTarefaTO.setCodConfigTarefa(resultado.getInt(++i));
		conteudoFormularioTarefaTO.setNumeroOrdem(resultado.getInt(++i));
		conteudoFormularioTarefaTO.setTextoFormularioTarefa(resultado.getString(++i));
		conteudoFormularioTarefaTO.setIndVigente(resultado.getString(++i));
		conteudoFormularioTarefaTO.setCodTipoDadoFormulario(resultado.getInt(++i));
		

		return conteudoFormularioTarefaTO;

	}
  
	
    @SuppressWarnings("unchecked")
	public Collection consultarFormularios(ConteudoFormularioTarefaTO conteudoFormularioTarefaTO) throws ExceptionPersistenciaPRO {
        StringBuffer sql = new StringBuffer("SELECT ");
        sql.append("A."+NOME_FORMULARIO);
        sql.append(", ");
        sql.append("B."+ANO_CRIACAO_TASK);        
        sql.append(", ");
        sql.append("B."+NUMERO_SEQUENCIAL);
        sql.append(", ");
        sql.append("A."+CODIGO_CONFIG_TASK);
        sql.append(", ");        
        sql.append("A."+NUMERO_ORDEM);
        sql.append(", ");
        sql.append("B."+TEXTO_FORMULARIO_ATVD);
        sql.append(", ");
        sql.append("A."+INDICADOR_FORMULARIO_VIGENTE + ", ");
        sql.append("A."+ FormularioDAOImpl.CODIGO_TIPO_DADO_FORMULARIO);
        sql.append(" FROM ");
        sql.append(TABELA_FORMULARIO_CONFIG_TASK + " A ");
        sql.append("LEFT OUTER JOIN " + TABELA + " B ON( B." + NUMERO_ORDEM + " = A." + NUMERO_ORDEM + 
        		   " AND B." + CODIGO_CONFIG_TASK + " = A." + CODIGO_CONFIG_TASK);
        sql.append(" AND B."+ANO_CRIACAO_TASK+" = ? ");
        sql.append(" AND B."+NUMERO_SEQUENCIAL+" = ? ) ");
        
		
        sql.append("WHERE 1=1 ");

        if (conteudoFormularioTarefaTO.getCodConfigTarefa() != 0) {
            sql.append(" AND A."+CODIGO_CONFIG_TASK+" = ? ");
        }
        if ((conteudoFormularioTarefaTO.getIndVigente() != null) && (!conteudoFormularioTarefaTO.getIndVigente().equals(""))) {
        	sql.append(" AND A."+INDICADOR_FORMULARIO_VIGENTE+" = ?  ");
        }
        
        sql.append(" ORDER BY  A."+NUMERO_ORDEM);

        PreparedStatement stmt = null;
        ResultSet resultado = null;
        Collection listaFormularios = new ArrayList();
        int i = 0;
        try {
            stmt = getConnection().prepareStatement(sql.toString());
            if (conteudoFormularioTarefaTO.getAnoCriacao() != 0) {
                stmt.setInt(++i, conteudoFormularioTarefaTO.getAnoCriacao());
            }
            if (conteudoFormularioTarefaTO.getCodTarefa() != 0) {
                stmt.setInt(++i, conteudoFormularioTarefaTO.getCodTarefa());
            }
            if (conteudoFormularioTarefaTO.getCodConfigTarefa() != 0) {
                stmt.setInt(++i, conteudoFormularioTarefaTO.getCodConfigTarefa());
            }
            if ((conteudoFormularioTarefaTO.getIndVigente() != null) && (!conteudoFormularioTarefaTO.getIndVigente().equals(""))) {
                stmt.setString(++i, conteudoFormularioTarefaTO.getIndVigente());
            }
            resultado = stmt.executeQuery();

            while (resultado.next()) {
                listaFormularios.add(getConteudoFormularioTarefaTO(resultado));
            }

        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new ExceptionPersistenciaPRO(e.getMessage());
        }
        return listaFormularios;
    }
   
    
    public void excluirFormularioTarefa(ConteudoFormularioTarefaTO conteudoFormularioTarefaTO) throws ExceptionPersistenciaPRO {
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
            if (conteudoFormularioTarefaTO.getAnoCriacao() != 0) {
                stmt.setInt(++i, conteudoFormularioTarefaTO.getAnoCriacao());
            }
            if (conteudoFormularioTarefaTO.getCodTarefa() != 0) {
                stmt.setInt(++i, conteudoFormularioTarefaTO.getCodTarefa());
            }
            if (conteudoFormularioTarefaTO.getCodConfigTarefa() != 0) {
                stmt.setInt(++i, conteudoFormularioTarefaTO.getCodConfigTarefa());
            }
            if (conteudoFormularioTarefaTO.getNumeroOrdem() != 0) {
                stmt.setInt(++i, conteudoFormularioTarefaTO.getNumeroOrdem());
            }
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new ExceptionPersistenciaPRO(e.getMessage());
        }
    }

    public void incluirFormularioTarefa(ConteudoFormularioTarefaTO conteudoFormularioTarefaTO) throws ExceptionPersistenciaPRO {
        StringBuffer sql = new StringBuffer("INSERT INTO ");
        sql.append(TABELA);
        sql.append(" (");
        if (conteudoFormularioTarefaTO.getAnoCriacao() != 0) {
            sql.append(ANO_CRIACAO_TASK + ", ");
        }
        if (conteudoFormularioTarefaTO.getCodTarefa() != 0) {
            sql.append(NUMERO_SEQUENCIAL + ", ");
        }
        if (conteudoFormularioTarefaTO.getCodConfigTarefa() != 0) {
            sql.append(CODIGO_CONFIG_TASK + ", ");
        }
        if (conteudoFormularioTarefaTO.getNumeroOrdem() != 0) {
            sql.append(NUMERO_ORDEM + ", ");
        }
        if ((conteudoFormularioTarefaTO.getTextoFormularioTarefa() != null) && (!conteudoFormularioTarefaTO.getTextoFormularioTarefa().equals(""))) {
            sql.append(TEXTO_FORMULARIO_ATVD);
        }
        else {
            sql.delete(sql.length() - 2, sql.length());
        }
        
        sql.append(") VALUES (");
        if (conteudoFormularioTarefaTO.getAnoCriacao() != 0) {
            sql.append("?" + ", ");
        }
        if (conteudoFormularioTarefaTO.getCodTarefa() != 0) {
            sql.append("?" + ", ");
        }
        if (conteudoFormularioTarefaTO.getCodConfigTarefa() != 0) {
            sql.append("?" + ", ");
        }
        if (conteudoFormularioTarefaTO.getNumeroOrdem() != 0) {
            sql.append("?" + ", ");
        }
        if ((conteudoFormularioTarefaTO.getTextoFormularioTarefa() != null) && (!conteudoFormularioTarefaTO.getTextoFormularioTarefa().equals(""))) {
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
            if (conteudoFormularioTarefaTO.getAnoCriacao() != 0) {
                stmt.setInt(++i, conteudoFormularioTarefaTO.getAnoCriacao());
            }
            if (conteudoFormularioTarefaTO.getCodTarefa() != 0) {
                stmt.setInt(++i, conteudoFormularioTarefaTO.getCodTarefa());
            }
            if (conteudoFormularioTarefaTO.getCodConfigTarefa() != 0) {
                stmt.setInt(++i, conteudoFormularioTarefaTO.getCodConfigTarefa());
            }
            if (conteudoFormularioTarefaTO.getNumeroOrdem() != 0) {
                stmt.setInt(++i, conteudoFormularioTarefaTO.getNumeroOrdem());
            }
            if ((conteudoFormularioTarefaTO.getTextoFormularioTarefa() != "") && (!conteudoFormularioTarefaTO.getTextoFormularioTarefa().equals(""))) {
                stmt.setString(++i, conteudoFormularioTarefaTO.getTextoFormularioTarefa().trim());
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new ExceptionPersistenciaPRO(e.getMessage());
        }
    }

	public void alterar(ConteudoFormularioTarefaTO conteudoFormularioTarefaTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("UPDATE ");
        sql.append(TABELA + " SET ");
		if ((conteudoFormularioTarefaTO.getTextoFormularioTarefa() != null) && (!conteudoFormularioTarefaTO.getTextoFormularioTarefa().equals(""))) {
			sql.append(TEXTO_FORMULARIO_ATVD + " = ? ");
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
			
			if ((!conteudoFormularioTarefaTO.getTextoFormularioTarefa().equals("")) && (conteudoFormularioTarefaTO.getTextoFormularioTarefa() != null)) {
				stmt.setString(++i, conteudoFormularioTarefaTO.getTextoFormularioTarefa());
			}
			/*Clausula Where*/
			stmt.setInt(++i, conteudoFormularioTarefaTO.getAnoCriacao());
			stmt.setInt(++i, conteudoFormularioTarefaTO.getCodTarefa());
			stmt.setInt(++i, conteudoFormularioTarefaTO.getCodConfigTarefa());
			stmt.setInt(++i, conteudoFormularioTarefaTO.getNumeroOrdem());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
		
	}

	/*Consulta para verificar se é necessario incluir formulario critico ou somente alterar o dado*/
	@SuppressWarnings("unchecked")
	public Collection consultarFormularioCritico(ConteudoFormularioTarefaTO conteudoFormularioTarefaTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer();

		sql.append("SELECT ");
		sql.append("A."+ ANO_CRIACAO_TASK + ", ");
		sql.append("A."+NUMERO_SEQUENCIAL + ", ");
		sql.append("A."+CODIGO_CONFIG_TASK+", ");
		sql.append("A."+NUMERO_ORDEM+", ");
		sql.append("A."+TEXTO_FORMULARIO_ATVD+" ");
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
		Collection formulariosCriticos = new ArrayList();
		try {
			stmt = getConnection().prepareStatement(sql.toString());
			/*Clausula Where*/
			stmt.setInt(++i, conteudoFormularioTarefaTO.getAnoCriacao());
			stmt.setInt(++i, conteudoFormularioTarefaTO.getCodTarefa());
			stmt.setInt(++i, conteudoFormularioTarefaTO.getCodConfigTarefa());
			stmt.setInt(++i, conteudoFormularioTarefaTO.getNumeroOrdem());
			resultado = stmt.executeQuery();
			while (resultado.next()) {
				int j = 0;
				ConteudoFormularioTarefaTO conteudoFormularioTarefaTOResult = new ConteudoFormularioTarefaTO();
				conteudoFormularioTarefaTOResult.setAnoCriacao(resultado.getInt(++j));
				conteudoFormularioTarefaTOResult.setCodTarefa(resultado.getInt(++j));
				conteudoFormularioTarefaTOResult.setCodConfigTarefa(resultado.getInt(++j));
				conteudoFormularioTarefaTOResult.setNumeroOrdem(resultado.getInt(++j));
				conteudoFormularioTarefaTOResult.setTextoFormularioTarefa(resultado.getString(++j));
				
				formulariosCriticos.add(conteudoFormularioTarefaTOResult);
			}

		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
		return formulariosCriticos;
	}

}
