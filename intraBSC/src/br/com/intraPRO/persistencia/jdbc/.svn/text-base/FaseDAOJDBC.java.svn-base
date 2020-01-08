

package br.com.intraPRO.persistencia.jdbc;

import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.FaseTO;
import br.com.intraBSC.persistencia.BscDaoJDBCGenerico;
import br.com.intraPRO.persistencia.FaseDAO;

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

public class FaseDAOJDBC extends BscDaoJDBCGenerico implements FaseDAO {
	
	protected static final String TABELA = "FASE";
	protected static final String ID_FASE = "ID";
	protected static final String DESCRICAO_FASE = "DESCRIPTION";
	protected static final String USUARIO_FASE = "OWNER_ID";
	protected static final String NOME_FASE = "NAME";
	protected static final String ORDEM_FASE = "SORTORDER";
	protected static final String ATIVO = "ACTIVE";
	
	protected static final String TABELA_REL = "RELFASE";
	protected static final String ID_FASE_REL = "FASE_ID";
	protected static final String ID_ATIVIDADE_REL = "ATIVIDADE_ID";
	
	private static Log log = LogFactory.getLog(FaseDAOJDBC.class);

	private Connection getconexao(){
		return getConnection();			
	}
	
	public FaseDAOJDBC(DaoManager daoManager) {
		super(daoManager);		
	}
	
	public void excluir(FaseTO faseTO) throws ExceptionPersistenciaPRO {
		
	}
	
	public void incluir(FaseTO faseTO) throws ExceptionPersistenciaPRO {
        StringBuffer sql = new StringBuffer("INSERT INTO ");
        sql.append(TABELA + "(");
        sql.append( ID_FASE+", ");
        sql.append( DESCRICAO_FASE+", ");
        sql.append( USUARIO_FASE+", ");
        sql.append( NOME_FASE+", ");
        sql.append( ATIVO+", ");
        sql.append( ORDEM_FASE+" ");
        sql.append(") VALUES (?,?,?,?,?,?)");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
        int i = 0;
        if (faseTO.getId() != 0){
            stmt.setInt(++i,faseTO.getId());
        }
        if ((faseTO.getDescricao() != null) && (!faseTO.getDescricao().equals("")) ){
            stmt.setString(++i,faseTO.getDescricao());
        }
        if (faseTO.getResponsavel() != 0){
            stmt.setInt(++i,faseTO.getResponsavel());
        }        
        if ((faseTO.getNome() != null) && (!faseTO.getNome().equals("")) ){
           stmt.setString(++i,faseTO.getNome());
        }
        if (faseTO.getAtivo() != 0){
            stmt.setInt(++i,faseTO.getAtivo());
        }
        if (faseTO.getOrdem() != 0){
            stmt.setInt(++i,faseTO.getOrdem());
        }
            stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
	}
	
	public void alterar(FaseTO faseTO) throws ExceptionPersistenciaPRO {
        StringBuffer sql = new StringBuffer("UPDATE ");
        sql.append(TABELA + " SET ");
        sql.append( DESCRICAO_FASE + " = ?, ");
        sql.append( USUARIO_FASE + " = ?, ");
        sql.append( NOME_FASE + " = ?, ");
        sql.append( ATIVO + " = ?, ");
        sql.append( ORDEM_FASE + " = ? ");
        sql.append(" WHERE 1=1 ");
        sql.append("AND " + ID_FASE  + " = ? ");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
            int i = 0;
	       
	        if ((faseTO.getDescricao() != null) && (!faseTO.getDescricao().equals("")) ){
	            stmt.setString(++i,faseTO.getDescricao());
	        }
	        if (faseTO.getResponsavel() != 0){
	            stmt.setInt(++i,faseTO.getResponsavel());
	        }        
	        if ((faseTO.getNome() != null) && (!faseTO.getNome().equals("")) ){
	           stmt.setString(++i,faseTO.getNome());
	        }
	        if (faseTO.getAtivo() != 0){
	            stmt.setInt(++i,faseTO.getAtivo());
	        }
	        if (faseTO.getOrdem() != 0){
	            stmt.setInt(++i,faseTO.getOrdem());
	        }
	        if (faseTO.getId() != 0){
	            stmt.setInt(++i,faseTO.getId());
	        }
            stmt.executeUpdate();
         } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
         }
	}

	@SuppressWarnings("unchecked")
	public Collection consultarVarios(FaseTO faseTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("B." + ID_FASE + ", ");
		sql.append("B." + DESCRICAO_FASE + ", ");
		sql.append("B." + ATIVO + ", ");
		sql.append("B." + USUARIO_FASE + ", ");
		sql.append("B." + NOME_FASE + ", ");
		sql.append("B." + ORDEM_FASE + ", ");
		sql.append("A." + ProcessoDAOJDBC.NOME_PROCESSO + ", ");
		sql.append("A." + ProcessoDAOJDBC.ID_PROCESSO + " ");
		sql.append("FROM " + ProcessoDAOJDBC.TABELA + " A, " + TABELA + " B, " + ProcessoDAOJDBC.TABELA_RELPRO + " C ");
		sql.append("WHERE 1=1 ");
		
		if (faseTO.getIdProcesso() != 0){
			sql.append(" AND A." + ProcessoDAOJDBC.ID_PROCESSO + " = ? ");
			sql.append(" AND A." + ProcessoDAOJDBC.ID_PROCESSO + " = C." + ProcessoDAOJDBC.ID_PROCESSO_REL);
			sql.append(" AND C." + ProcessoDAOJDBC.ID_FASE_REL + " = B." + ID_FASE);
		}
		sql.append(" ORDER BY B."+ ORDEM_FASE);
		PreparedStatement stmt;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			int i = 0;
			
			if (faseTO.getIdProcesso() != 0){
				stmt.setInt(++i,faseTO.getIdProcesso());
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
	public Collection consultarVariosProcesso(FaseTO faseTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("B." + ID_FASE + ", ");
		sql.append("B." + DESCRICAO_FASE + ", ");
		sql.append("B." + ATIVO + ", ");
		sql.append("B." + USUARIO_FASE + ", ");
		sql.append("B." + NOME_FASE + ", ");
		sql.append("B." + ORDEM_FASE + ", ");
		sql.append("A." + ProcessoDAOJDBC.NOME_PROCESSO + ", ");
		sql.append("A." + ProcessoDAOJDBC.ID_PROCESSO + " ");
		sql.append("FROM " + ProcessoDAOJDBC.TABELA + " A, " + TABELA + " B, " + ProcessoDAOJDBC.TABELA_RELPRO + " C ");
		sql.append("WHERE 1=1 ");
		
		if (faseTO.getIdProcesso() != 0){
			sql.append(" AND A." + ProcessoDAOJDBC.ID_PROCESSO + " = ? ");
			sql.append(" AND A." + ProcessoDAOJDBC.ID_PROCESSO + " = C." + ProcessoDAOJDBC.ID_PROCESSO_REL);
			sql.append(" AND C." + ProcessoDAOJDBC.ID_FASE_REL + " = B." + ID_FASE);
			sql.append(" AND B." + FaseDAOJDBC.ATIVO + " = 1");
		}
		sql.append(" ORDER BY B."+ ORDEM_FASE);
		PreparedStatement stmt;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			int i = 0;
			
			if (faseTO.getIdProcesso() != 0){
				stmt.setInt(++i,faseTO.getIdProcesso());
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

	
	private FaseTO carregaTO(ResultSet resultado) throws SQLException{
		FaseTO faseTO = new FaseTO();
		int i = 0;
		faseTO.setId(resultado.getInt(++i));
		faseTO.setDescricao(resultado.getString(++i));
		faseTO.setAtivo(resultado.getInt(++i));
		faseTO.setTipoFase(resultado.getInt(++i));
		faseTO.setResponsavel(resultado.getInt(++i));
		faseTO.setNome(resultado.getString(++i));
		faseTO.setOrdem(resultado.getInt(++i));
		faseTO.setNomeProcesso(resultado.getString(++i));
		faseTO.setIdProcesso(resultado.getInt(++i));
		return faseTO;
	}

	@SuppressWarnings("unchecked")
	public JasperPrint faseRelatorioDetalha(FaseTO faseTO) throws ExceptionPersistenciaPRO {
		try {
			Map parameters = new HashMap();
			//Parametros do relatorio
	        Locale locale = new Locale("pt" , "BR");
			parameters.put(JRParameter.REPORT_LOCALE, locale);
			parameters.put("fase", new Integer(faseTO.getId()));
			parameters.put("bsc", new Integer(faseTO.getIdProcesso()));
			parameters.put("baseDir", faseTO.getBaseDir());	
			JasperPrint relatorioFinal = JasperFillManager.fillReport(faseTO.getJasperReport(),parameters, getconexao());
			return relatorioFinal;
		} catch (JRException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
	}
	
	public int consultarMax(FaseTO faseTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("SELECT MAX(");
		sql.append(ID_FASE);
		sql.append(") AS ");
		sql.append(ID_FASE);
		sql.append(" FROM ");
		sql.append(TABELA);
		PreparedStatement stmt;
		ResultSet result;		
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			result = stmt.executeQuery();
			while (result.next()) {
				return result.getInt(ID_FASE) + 1;
			}			
		} 
		catch (SQLException e) {
		    log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}		
		return 0;
	}

	public FaseTO consultarUm(FaseTO faseTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + ID_FASE + ", ");
        sql.append("A." + DESCRICAO_FASE + ", ");
        sql.append("A." + ATIVO + ", ");
        sql.append("A." + USUARIO_FASE + ", ");
        sql.append("A." + ORDEM_FASE + ", ");
        sql.append("A." + NOME_FASE + " ");
        sql.append("FROM " + TABELA + " A ");
        sql.append("WHERE 1=1 ");

        if (faseTO.getId() != 0){
            sql.append(" AND A." + ID_FASE + " =? ");
        }        

        PreparedStatement stmt;
        try {
			 stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        if (faseTO.getId() != 0){
	            stmt.setInt(++i,faseTO.getId());
	        }

             ResultSet resultado = stmt.executeQuery();
             FaseTO retorno = new FaseTO();
             while (resultado.next()) {
                  retorno = carregaTOFase(resultado);
             }
             return retorno;
        } catch (Exception e) {
              log.error(e.getMessage());
              throw new DaoException(e.getMessage());
        }
	}
		
	private FaseTO carregaTOFase(ResultSet resultado) throws SQLException{
		FaseTO faseTO = new FaseTO();

		faseTO.setId(resultado.getInt(1));
		faseTO.setDescricao(resultado.getString(2));
		faseTO.setAtivo(resultado.getInt(3));
		faseTO.setTipoFase(resultado.getInt(4));
		faseTO.setResponsavel(resultado.getInt(5));
		faseTO.setOrdem(resultado.getInt(6));
		faseTO.setNome(resultado.getString(7));		
		return faseTO;
	}
	
	public Integer consultarProcessoPorFase(FaseTO faseTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("SELECT A.");
		sql.append(ProcessoDAOJDBC.ID_PROCESSO);
		sql.append(" FROM ");
		sql.append(ProcessoDAOJDBC.TABELA + " A ,");
		sql.append(RelacionamentosDAOJDBC.TABELA + " B ,");
		sql.append(FaseDAOJDBC.TABELA  + " C ");
		sql.append(" WHERE 1=1 AND C."+ ID_FASE +" = ? AND ");
		sql.append(" C." + FaseDAOJDBC.ID_FASE + " = B." + RelacionamentosDAOJDBC.PROIDFAS +" AND ");
		sql.append(" B." + RelacionamentosDAOJDBC.PROIDPRO + " = A." + ProcessoDAOJDBC.ID_PROCESSO);
		
		PreparedStatement stmt;
		ResultSet result;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			stmt.setInt(1,faseTO.getId());
			result = stmt.executeQuery();
			while (result.next()) {
				return result.getInt(ProcessoDAOJDBC.ID_PROCESSO);
			}
		}
		catch (SQLException e) {
		    log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}		
		return null;
	}




	
}

