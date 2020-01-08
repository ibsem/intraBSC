/*
 * Created on 15/02/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package br.com.intraPRO.persistencia.jdbc;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;

import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.ProcessoTO;
import br.com.intraBSC.persistencia.BscDaoJDBCGenerico;
import br.com.intraBSC.persistencia.JDBC.UsuarioDAOJDBC;
import br.com.intraPRO.persistencia.ProcessoDAO;

/**
 * @author Tiago
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ProcessoDAOJDBC extends BscDaoJDBCGenerico implements ProcessoDAO{
        
    public ProcessoDAOJDBC(DaoManager daoManager) {
        super(daoManager);
    }
    private static Log log = LogFactory.getLog(ProcessoDAOJDBC.class);
    
    protected static final String TABELA = "PROCESS";
    protected static final String ID_PROCESSO = "ID";
    protected static final String NOME_PROCESSO = "NAME";  
    protected static final String ATIVO = "ACTIVE";
    protected static final String ID_RESPONSAVEL = "FK_OWNER_START";
    
    /*Variaveis de Relacionamento de Mapa com Perspectiva*/
    protected static final String TABELA_RELPRO = "relprocess";
    protected static final String ID_PROCESSO_REL = "PROCESS_ID";
    protected static final String ID_FASE_REL = "FASE_ID";
    
    /*Variaveis de Relacionamento de Perspectiva com Objetivo*/
    protected static final String TABELA_RELFASE = "relfase";
    protected static final String TABELA_ATIVIDADE = "atividade";
    protected static final String ID_ATIVIDADE_REL = "ATIVIDADE_ID";
    
    
    /*Variaveis referentes a tabela de relacionamento de Mapa com Responsavel.*/
    //protected static final String TABELA_REL_RESPONSAVEL = "relbscowner";
    
    
    
	private Connection getconexao(){
		return getConnection();			
	}

	@SuppressWarnings("unchecked")
	public Collection consultarVarios(ProcessoTO processoTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT DISTINCT ");
		sql.append("A." + ID_PROCESSO + ", ");
		sql.append("A." + ATIVO + ", ");
		sql.append("A." + NOME_PROCESSO + ", ");
		sql.append("A." + ID_RESPONSAVEL + " ");
		sql.append("FROM " + TABELA + " A ");
		sql.append("WHERE 1=1 ");
		sql.append(" AND A." + ID_RESPONSAVEL + " = ? ");
		
		if (processoTO.getId() != 0){
			sql.append(" AND A." + ID_PROCESSO + " =? ");
		}
		if (processoTO.getAtivo() != 0){
			sql.append(" AND A." + ATIVO + " =? ");
		}
		
		sql.append(" AND UCASE(A." + NOME_PROCESSO + ") LIKE ? ");
		
		sql.append(" ORDER BY "+ NOME_PROCESSO);
		
		PreparedStatement stmt;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			int i = 0;
			
			stmt.setInt(++i,processoTO.getIdResponsavel());
			
			if (processoTO.getId() != 0){
				stmt.setInt(++i,processoTO.getId());
			}
			
			if (processoTO.getAtivo() != 0){
				stmt.setInt(++i,processoTO.getAtivo());
			}
			
			stmt.setString(++i,"%" + processoTO.getNome().toUpperCase() + "%");
						
			ResultSet resultado = stmt.executeQuery();
			Collection retorno = new ArrayList();
			while (resultado.next()) {
				retorno.add(carregaTOConsulta(resultado));
			}
			return retorno;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DaoException(e.getMessage());
		}
	}

	public ProcessoTO consultarUm(ProcessoTO processoTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + ID_PROCESSO + ", ");
        sql.append("A." + ATIVO + ", ");
        sql.append("A." + NOME_PROCESSO + ", ");
        sql.append("A." + ID_RESPONSAVEL + " ");
        sql.append("FROM " + TABELA + " A ");
        sql.append(" WHERE 1=1 ");

        if (processoTO.getId() != 0){
            sql.append(" AND A." + ID_PROCESSO + " =? ");
        }
        if ((processoTO.getNome() != null) && (!processoTO.getNome().equals("")) ){
            sql.append(" AND A." + NOME_PROCESSO + " LIKE? ");
        }
        PreparedStatement stmt;
        try {
			 stmt = getconexao().prepareStatement(sql.toString());
        int i = 0;
        if (processoTO.getId() != 0){
            stmt.setInt(++i,processoTO.getId());
        }
        if ((processoTO.getNome() != null) && (!processoTO.getNome().equals("")) ){
           stmt.setString(++i,"%"+ processoTO.getNome()+"%");
        }

             ResultSet resultado = stmt.executeQuery();
             ProcessoTO retorno = new ProcessoTO();
             while (resultado.next()) {
                  retorno = carregaTOConsulta(resultado);
             }
             return retorno;
        } catch (Exception e) {
              log.error(e.getMessage());
              throw new DaoException(e.getMessage());
        }
	}

	
	
	public void incluir(ProcessoTO processoTO) throws ExceptionPersistenciaPRO {
        StringBuffer sql = new StringBuffer("INSERT INTO ");
        sql.append(TABELA + "(");
        sql.append( ID_PROCESSO+", ");
        sql.append( ATIVO+", ");
        sql.append( ID_RESPONSAVEL+", ");
        sql.append( NOME_PROCESSO+" ");
        sql.append(") VALUES (?,?,?,?)");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        if (processoTO.getId() != 0){
	            stmt.setInt(++i,processoTO.getId());
	        }
	        if (processoTO.getAtivo() != 0){
	            stmt.setInt(++i,processoTO.getAtivo());
	        }
	        if (processoTO.getIdResponsavel() != 0){
	            stmt.setInt(++i,processoTO.getIdResponsavel());
	        }
	        if ((processoTO.getNome() != null) && (!processoTO.getNome().equals("")) ){
	           stmt.setString(++i,processoTO.getNome().trim());
	        }

            stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
		
	}

	public void alterar(ProcessoTO processoTO) throws ExceptionPersistenciaPRO {
        StringBuffer sql = new StringBuffer("UPDATE ");
        sql.append(TABELA + " SET ");
        sql.append( NOME_PROCESSO + " = ?, ");
        sql.append( ID_RESPONSAVEL + " = ?, ");
        sql.append( ATIVO + " = ? ");
        sql.append(" WHERE 1=1 ");
        sql.append("AND " + ID_PROCESSO + " = ? ");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        if ((processoTO.getNome() != null) && (!processoTO.getNome().equals("")) ){
	           stmt.setString(++i,processoTO.getNome());
	        }
	        if (processoTO.getIdResponsavel() != 0){
	            stmt.setInt(++i,processoTO.getIdResponsavel());
	        }
	        if (processoTO.getAtivo() != 0){
	            stmt.setInt(++i,processoTO.getAtivo());
	        }
	        if (processoTO.getId() != 0){
	            stmt.setInt(++i,processoTO.getId());
	        }
            stmt.executeUpdate();
         } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
         }
	}

	public void excluir(ProcessoTO processoTO) throws ExceptionPersistenciaPRO {
        StringBuffer sql = new StringBuffer("DELETE FROM ");
        sql.append(TABELA);
        sql.append(" WHERE 1=1 ");
        if (processoTO.getId() != 0){
            sql.append(" AND " + processoTO.getId()+ " =? ");
        }
        PreparedStatement stmt;
        try {
             int i = 0;
             stmt = getconexao().prepareStatement(sql.toString());
             if (processoTO.getId() != 0){
                   stmt.setInt(++i,processoTO.getId());
             }
             stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }		
	}

	private ProcessoTO carregaTO(ResultSet resultado) throws SQLException{
		ProcessoTO processoTO = new ProcessoTO();
		int i = 0;
		processoTO.setId(resultado.getInt(++i));
		processoTO.setAtivo(resultado.getInt(++i));
		processoTO.setNome(resultado.getString(++i));
		return processoTO;
	}
	
	private ProcessoTO carregaTOConsulta(ResultSet resultado) throws SQLException{
		ProcessoTO processoTO = new ProcessoTO();
		int i = 0;
		processoTO.setId(resultado.getInt(++i));
		processoTO.setAtivo(resultado.getInt(++i));
		processoTO.setNome(resultado.getString(++i));
		processoTO.setIdResponsavel(resultado.getInt(++i));
		return processoTO;
	}

	@SuppressWarnings("unchecked")
	public Collection consultarProcessoUsuario(ProcessoTO processoTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer();		 
		/*sql.append("SELECT DISTINCT ");
		sql.append("A." + ID_PROCESSO + ", ");
		sql.append("A." + ATIVO + ", ");
		sql.append("A." + NOME_PROCESSO + " ");		
		sql.append("FROM " + TABELA + " A, " + TABELA_RELPRO + " B, " + PerspectivaDAOJDBC.TABELA + " C, ");
		sql.append(UsuarioDAOJDBC.TABELA + " D, " + TABELA_RELFASE + " E," + TABELA_ATIVIDADE + " F," );
		sql.append(TABELA_INDICADOR + " G " );
		sql.append("WHERE 1=1 ");		
		sql.append(" AND A." + ID_PROCESSO + " = " + "B."+ ID_PROCESSO_REL);
		sql.append(" AND B." + ID_FASE_REL + " = " + "C."+ PerspectivaDAOJDBC.ID_FASE);
		sql.append(" AND C." + PerspectivaDAOJDBC.ID_FASE + " = " + "E."+ PerspectivaDAOJDBC.ID_FASE_REL);
		sql.append(" AND E." + ID_ATIVIDADE_REL + " = " + "F."+ ObjetivoDAOJDBC.ID_ATIVIDADE);
		sql.append(" AND G." + ID_ATIVIDADE_REL + " = " + "F."+ ObjetivoDAOJDBC.ID_ATIVIDADE);
		
		sql.append(" AND (C." + PerspectivaDAOJDBC.USUARIO_FASE + " = " + "? ");
		sql.append(" OR F." + ObjetivoDAOJDBC.USUARIO_ATIVIDADE + " = " + "? ");
		sql.append(" OR G." + IndicadorDAOJDBC.RESPONSAVEL + " = " + "? )");
	*/
		sql.append("SELECT DISTINCT ");
		sql.append("A." + ID_PROCESSO + ", ");
		sql.append("A." + ATIVO + ", ");
		sql.append("A." + NOME_PROCESSO);	
		sql.append(" FROM ");
		sql.append(TABELA + " A LEFT JOIN " + TABELA_RELPRO + " B ON (A.");
		sql.append(ProcessoDAOJDBC.ID_PROCESSO +" = B."+ProcessoDAOJDBC.ID_PROCESSO_REL+") ");
		
		sql.append(" LEFT JOIN "+ FaseDAOJDBC.TABELA +" C ON (B.");
		sql.append(FaseDAOJDBC.ID_FASE_REL+" = C."+FaseDAOJDBC.ID_FASE+") ");
		
		sql.append(" LEFT JOIN "+ FaseDAOJDBC.TABELA_REL +" D ON (C.");
		sql.append(FaseDAOJDBC.ID_FASE+" = D."+FaseDAOJDBC.ID_FASE_REL+") ");
		
		
		sql.append(" LEFT JOIN "+ AtividadeDAOJDBC.TABELA +" E ON (D.");
		sql.append(FaseDAOJDBC.ID_ATIVIDADE_REL+" = E."+AtividadeDAOJDBC.ID_ATIVIDADE+") ");
		
		sql.append(", "+UsuarioDAOJDBC.TABELA+" Z ");
		
		sql.append("WHERE 1=1 AND");
		sql.append(" Z."+UsuarioDAOJDBC.ID_USUARIO+" = ? AND  ");
		sql.append(" (A."+ID_RESPONSAVEL+" = Z."+UsuarioDAOJDBC.ID_USUARIO+" OR ");
		sql.append(" C."+FaseDAOJDBC.USUARIO_FASE+" = Z."+UsuarioDAOJDBC.ID_USUARIO+" OR ");
		sql.append(" E."+AtividadeDAOJDBC.USUARIO_ATIVIDADE+" = Z."+UsuarioDAOJDBC.ID_USUARIO);
				
		if (processoTO.getAtivo() != 0){
			sql.append(" AND A." + ATIVO + " =? ");
		}

		PreparedStatement stmt;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			int i = 0;
			
			stmt.setInt(++i,processoTO.getIdUsuario());
			
			if (processoTO.getAtivo() != 0){
				stmt.setInt(++i,processoTO.getAtivo());
			}
			
			ResultSet resultado = stmt.executeQuery();
			Collection retorno = new ArrayList();
			while (resultado.next()) {
				retorno.add(carregaTO(resultado));
			}
			return retorno;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DaoException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public JasperPrint processoRelatorioDetalha(ProcessoTO processoTO) throws ExceptionPersistenciaPRO {
		try {
			Map parameters = new HashMap();
			//Parametros do relatorio
	        Locale locale = new Locale("pt" , "BR");
			parameters.put(JRParameter.REPORT_LOCALE, locale);
			parameters.put("processo", new Integer(processoTO.getId()));
			parameters.put("baseDir", processoTO.getBaseDir());	
			JasperPrint relatorioFinal = JasperFillManager.fillReport(processoTO.getJasperReport(),parameters, getconexao());
			return relatorioFinal;
		} catch (JRException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
		
	}

	
	
	public int consultarMax(ProcessoTO processoTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("SELECT MAX(");
		sql.append(ID_PROCESSO);
		sql.append(") AS ");
		sql.append(ID_PROCESSO);
		sql.append(" FROM ");
		sql.append(TABELA);
		PreparedStatement stmt;
		ResultSet result;		
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			result = stmt.executeQuery();
			while (result.next()) {
				return result.getInt(ID_PROCESSO) + 1;
			}			
		} 
		catch (SQLException e) {
		    log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}		
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	public Collection consultarArvoreConfiguracao(ProcessoTO processoTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		
		sql.append("A."+ ProcessoDAOJDBC.ID_PROCESSO +", A."+ProcessoDAOJDBC.NOME_PROCESSO+",");
		sql.append("C."+FaseDAOJDBC.ID_FASE+", C."+ FaseDAOJDBC.NOME_FASE+",");
		sql.append("E."+AtividadeDAOJDBC.ID_ATIVIDADE+", E."+AtividadeDAOJDBC.NOME_ATIVIDADE+",");
		
		sql.append("B."+ ProcessoDAOJDBC.ID_PROCESSO_REL+", B."+ ProcessoDAOJDBC.ID_FASE_REL +",");
		sql.append(" C."+FaseDAOJDBC.ORDEM_FASE+",");
		sql.append("D."+FaseDAOJDBC.ID_ATIVIDADE_REL +", D."+FaseDAOJDBC.ID_FASE_REL+", ");
		
		sql.append(" C."+FaseDAOJDBC.ATIVO+",");
		sql.append(" E."+AtividadeDAOJDBC.ATIVO+",");
		sql.append(" A."+ATIVO+" ");
		
		sql.append(" FROM " + ProcessoDAOJDBC.TABELA + " A LEFT JOIN " + ProcessoDAOJDBC.TABELA_RELPRO + " B  ON (A.ID = B.PRO_ID) ");
		sql.append(" LEFT JOIN "+ FaseDAOJDBC.TABELA + " C ON (B.FASE_ID = C.ID)");
		sql.append(" LEFT JOIN " + FaseDAOJDBC.TABELA_REL + " D ON (D.FASE_ID = C.ID)");
		sql.append(" LEFT JOIN " + AtividadeDAOJDBC.TABELA + " E ON (E.ID = D.OBJECTIVE_ID)");

		sql.append(" WHERE 1=1 ");
		
		if (processoTO.getId() != 0){
			sql.append(" AND A."+ ProcessoDAOJDBC.ID_PROCESSO  +" = ?");
		}
		
		sql.append(" ORDER BY C.SORTORDER,D.ATIVIDADE_ID,D.FASE_ID");
		PreparedStatement stmt;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			int i = 0;
			
			if (processoTO.getId() != 0){
				stmt.setInt(++i,processoTO.getId());
			}			

			
			ResultSet resultado = stmt.executeQuery();
			Collection retorno = new ArrayList();
			while (resultado.next()) {
				ProcessoTO processoTOReturn = new ProcessoTO();
				int j = 0;
				processoTOReturn.setId(resultado.getInt(++j));
				processoTOReturn.setNome(resultado.getString(++j));
                processoTOReturn.setIdFase(resultado.getInt(++j));
				processoTOReturn.setNomeFase(resultado.getString(++j));
				processoTOReturn.setIdAtividade(resultado.getInt(++j));
				processoTOReturn.setNomeAtividade(resultado.getString(++j));
				processoTOReturn.setAtivoFas(resultado.getInt(15));
				processoTOReturn.setAtivoAtv(resultado.getInt(16));
				processoTOReturn.setAtivo(resultado.getInt(18));
				
				retorno.add(processoTOReturn);
			}
			return retorno;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DaoException(e.getMessage());
		}
	}	
	
	public ProcessoTO contarFases(ProcessoTO processoTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("SELECT distinct A.");
		sql.append(ProcessoDAOJDBC.ID_PROCESSO + ",");
		sql.append(" COUNT(DISTINCT C." + FaseDAOJDBC.ID_FASE + ")");
		sql.append(" FROM ");
		sql.append(ProcessoDAOJDBC.TABELA + " A ");
		sql.append(" LEFT OUTER JOIN ");
		sql.append(RelacionamentosDAOJDBC.TABELA  + " B ");
		sql.append(" ON B."+ RelacionamentosDAOJDBC.PROIDPRO + " = A." + ProcessoDAOJDBC.ID_PROCESSO );
		sql.append(" LEFT OUTER JOIN ");
		sql.append(FaseDAOJDBC.TABELA + " C ");
		sql.append(" ON C."+ FaseDAOJDBC.ID_FASE + " = B." + RelacionamentosDAOJDBC.PROIDFAS );
		sql.append(" AND C." + FaseDAOJDBC.ATIVO + "= 1");
		sql.append(" LEFT OUTER JOIN ");
		sql.append(RelacionamentosDAOJDBC.TABELA_FASE + " D ");
		sql.append(" ON D."+ RelacionamentosDAOJDBC.PROIDFAS + " = C." + FaseDAOJDBC.ID_FASE );
		sql.append(" WHERE A." + ProcessoDAOJDBC.ID_PROCESSO + " = ?");
		sql.append(" GROUP BY A." + ProcessoDAOJDBC.ID_PROCESSO);
			
		PreparedStatement stmt;
		ResultSet result;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			stmt.setInt(1,processoTO.getId());
			result = stmt.executeQuery();
			while (result.next()) {
				processoTO.setNumFases(result.getInt(2));
				return processoTO;
			}
		}
		catch (SQLException e) {
		    log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}		
		return null;
	}
	private ProcessoTO carregaAtividades(ResultSet resultado) throws SQLException{
		ProcessoTO processoTO = new ProcessoTO();
		int i = 0;
		processoTO.setId(resultado.getInt(++i));
		processoTO.setIdFase(resultado.getInt(++i));
		processoTO.setNumAtividades(resultado.getInt(++i));
		return processoTO;
	}	
	
	@SuppressWarnings("unchecked")
	public Collection contarAtividades(ProcessoTO processoTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("SELECT distinct A.");
		sql.append(ProcessoDAOJDBC.ID_PROCESSO + ", C.");
		sql.append(FaseDAOJDBC.ID_FASE + ",");
		sql.append(" COUNT(DISTINCT E." + AtividadeDAOJDBC.ID_ATIVIDADE + ")");
		sql.append(" FROM ");
		sql.append(ProcessoDAOJDBC.TABELA + " A ");
		sql.append(" INNER JOIN ");
		sql.append(RelacionamentosDAOJDBC.TABELA  + " B ");
		sql.append(" ON B."+ RelacionamentosDAOJDBC.PROIDPRO + " = A." + ProcessoDAOJDBC.ID_PROCESSO );
		sql.append(" INNER JOIN ");
		sql.append(FaseDAOJDBC.TABELA + " C ");
		sql.append(" ON C."+ FaseDAOJDBC.ID_FASE + " = B." + RelacionamentosDAOJDBC.PROIDFAS );
		sql.append(" AND C." + FaseDAOJDBC.ATIVO + "= 1");
		sql.append(" LEFT OUTER JOIN ");
		sql.append(RelacionamentosDAOJDBC.TABELA_FASE + " D ");
		sql.append(" ON D."+ RelacionamentosDAOJDBC.PROIDFAS + " = C." + FaseDAOJDBC.ID_FASE );
		sql.append(" LEFT OUTER JOIN ");
		sql.append(AtividadeDAOJDBC.TABELA + " E ");
		sql.append(" ON E."+ AtividadeDAOJDBC.ID_ATIVIDADE + " = D." + RelacionamentosDAOJDBC.ATVIDATV );
		sql.append(" AND E." + AtividadeDAOJDBC.ATIVO + "= 1");
		sql.append(" WHERE A." + ProcessoDAOJDBC.ID_PROCESSO + " = ?");
		sql.append(" GROUP BY A." + ProcessoDAOJDBC.ID_PROCESSO + ", C." + FaseDAOJDBC.ORDEM_FASE);
			
		PreparedStatement stmt;
		ResultSet result;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			stmt.setInt(1,processoTO.getId());
			result = stmt.executeQuery();
		
			Collection retorno = new ArrayList();
			while (result.next()) {
				retorno.add(carregaAtividades(result));
			}
			return retorno;
				}
		catch (SQLException e) {
		    log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}		
	}

}