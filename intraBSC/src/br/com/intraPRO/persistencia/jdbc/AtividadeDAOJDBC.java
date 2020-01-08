package br.com.intraPRO.persistencia.jdbc;

import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.AtividadeTO;
import br.com.intraBSC.persistencia.BscDaoJDBCGenerico;
import br.com.intraPRO.persistencia.AtividadeDAO;

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

/**
 * @author Tiago Trindade Stangarlin
 */
public class AtividadeDAOJDBC extends BscDaoJDBCGenerico implements AtividadeDAO{

	private static Log log = LogFactory.getLog(AtividadeDAOJDBC.class);
	
	protected static final String TABELA = "ATIVIDADE";
	protected static final String ID_ATIVIDADE = "ID";
	protected static final String DESCRICAO_ATIVIDADE = "DESCRIPTION";	
	protected static final String USUARIO_ATIVIDADE = "OWNER_ID";
	protected static final String NOME_ATIVIDADE = "NAME";
	protected static final String ATIVO = "ACTIVE";
		
	public AtividadeDAOJDBC(DaoManager daoManager) {
		super(daoManager);
	}
	
	private Connection getconexao(){
		return getConnection();			
	}
	
	public void alterar(AtividadeTO atividadeTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("UPDATE ");
        sql.append(TABELA + " SET ");
        sql.append( DESCRICAO_ATIVIDADE + " = ?, ");
        sql.append( USUARIO_ATIVIDADE + " = ?, ");
        sql.append( ATIVO + " = ?, ");
        sql.append( NOME_ATIVIDADE + " = ?, ");
        sql.append(" WHERE 1=1 ");
        sql.append("AND " + ID_ATIVIDADE  + " = ? ");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());

        int i = 0;
        if ((atividadeTO.getDescricao() != null) && (!atividadeTO.getDescricao().equals("")) ){
            stmt.setString(++i,atividadeTO.getDescricao().trim());
        }
        if (atividadeTO.getResponsavel() != 0){
            stmt.setInt(++i,atividadeTO.getResponsavel());
        }
        if (atividadeTO.getAtivo() != 0){
            stmt.setInt(++i,atividadeTO.getAtivo());
        }
        if ((atividadeTO.getNome() != null) && (!atividadeTO.getNome().equals("")) ){
           stmt.setString(++i,atividadeTO.getNome().trim());
        }
        if (atividadeTO.getId() != 0){
            stmt.setInt(++i,atividadeTO.getId());
        }
        
            stmt.executeUpdate();
         } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
         }
	}
	
	public void incluir(AtividadeTO atividadeTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("INSERT INTO ");
        sql.append(TABELA + "(");
        sql.append( ID_ATIVIDADE+", ");
        sql.append( DESCRICAO_ATIVIDADE+", ");
        sql.append( USUARIO_ATIVIDADE+", ");
        sql.append( ATIVO+", ");
        sql.append( NOME_ATIVIDADE+", ");
        sql.append(") VALUES (?,?,?,?,?)");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
        int i = 0;
        if (atividadeTO.getId() != 0){
            stmt.setInt(++i,atividadeTO.getId());
        }
        if ((atividadeTO.getDescricao() != null) && (!atividadeTO.getDescricao().equals("")) ){
            stmt.setString(++i,atividadeTO.getDescricao().trim());
        }
        if (atividadeTO.getResponsavel() != 0){
            stmt.setInt(++i,atividadeTO.getResponsavel());
        }
        if (atividadeTO.getAtivo() != 0){
            stmt.setInt(++i,atividadeTO.getAtivo());
        }
        if ((atividadeTO.getNome() != null) && (!atividadeTO.getNome().equals("")) ){
           stmt.setString(++i,atividadeTO.getNome().trim());
        }
        
        stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
	}
	
	@SuppressWarnings("unchecked")
	public Collection consultarVarios(AtividadeTO atividadeTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("E." + ID_ATIVIDADE + ", ");
		sql.append("E." + DESCRICAO_ATIVIDADE + ", ");
		sql.append("E." + USUARIO_ATIVIDADE + ", ");
		sql.append("E." + ATIVO + ", ");
		sql.append("E." + NOME_ATIVIDADE + ", ");
		sql.append("A." + ProcessoDAOJDBC.ID_PROCESSO + ", ");
		sql.append("A." + ProcessoDAOJDBC.NOME_PROCESSO + ", ");
		sql.append("C." + FaseDAOJDBC.ID_FASE + ", ");			
		sql.append("C." + FaseDAOJDBC.NOME_FASE + " ");
		sql.append("FROM " + ProcessoDAOJDBC.TABELA + " A, " + ProcessoDAOJDBC.TABELA_RELPRO + " B, ");
		sql.append(FaseDAOJDBC.TABELA + " C, " + FaseDAOJDBC.TABELA_REL + " D, ");
		sql.append(TABELA + " E ");
		sql.append("WHERE 1=1 ");
		
		if (atividadeTO.getIdProcesso() != 0){
			sql.append(" AND A." + ProcessoDAOJDBC.ID_PROCESSO + " = ? ");
			sql.append(" AND A." + ProcessoDAOJDBC.ID_PROCESSO + " = B." + ProcessoDAOJDBC.ID_PROCESSO_REL);
			sql.append(" AND B." + ProcessoDAOJDBC.ID_FASE_REL + " = C." + FaseDAOJDBC.ID_FASE);
			sql.append(" AND C." + FaseDAOJDBC.ID_FASE + " = D." + FaseDAOJDBC.ID_FASE_REL);
			sql.append(" AND D." + FaseDAOJDBC.ID_ATIVIDADE_REL + " = E." + ID_ATIVIDADE);
			
		}
		sql.append(" ORDER BY E." + NOME_ATIVIDADE);
	
		PreparedStatement stmt;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			int i = 0;
			
			if (atividadeTO.getIdProcesso() != 0){
				stmt.setInt(++i,atividadeTO.getIdProcesso());
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
	
	
	private AtividadeTO carregaTO(ResultSet resultado) throws SQLException{
		AtividadeTO atividadeTO = new AtividadeTO();
		int i = 0;
		atividadeTO.setId(resultado.getInt(++i));
		atividadeTO.setDescricao(resultado.getString(++i));		
		atividadeTO.setResponsavel(resultado.getInt(++i));
		atividadeTO.setAtivo(resultado.getInt(++i));
		atividadeTO.setNome(resultado.getString(++i));
		atividadeTO.setLinha(resultado.getInt(++i));
		atividadeTO.setColuna(resultado.getInt(++i));
		atividadeTO.setIdProcesso(resultado.getInt(++i));
		atividadeTO.setNomeProcesso(resultado.getString(++i));
		atividadeTO.setIdFase(resultado.getInt(++i));
		atividadeTO.setNomeFase(resultado.getString(++i));
		return atividadeTO;
	}

	@SuppressWarnings("unchecked")
	public JasperPrint atividadeRelatorioDetalha(AtividadeTO atividadeTO) throws ExceptionPersistenciaPRO {		
		try {
			Map parameters = new HashMap();
			//Parametros do relatorio
	        Locale locale = new Locale("pt" , "BR");
			parameters.put(JRParameter.REPORT_LOCALE, locale);
			parameters.put("atividade", new Integer(atividadeTO.getId()));
			parameters.put("bsc", new Integer(atividadeTO.getIdProcesso()));
			parameters.put("baseDir", atividadeTO.getBaseDir());	
			JasperPrint relatorioFinal = JasperFillManager.fillReport(atividadeTO.getJasperReport(),parameters, getconexao());
			return relatorioFinal;
		} catch (JRException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
	}

	public AtividadeTO consultarUm(AtividadeTO atividadeTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + ID_ATIVIDADE + ", ");
        sql.append("A." + DESCRICAO_ATIVIDADE + ", ");
        sql.append("A." + USUARIO_ATIVIDADE + ", ");
        sql.append("A." + ATIVO + ", ");
        sql.append("A." + NOME_ATIVIDADE + ", ");
        sql.append("FROM " + TABELA + " A ");
        sql.append("WHERE 1=1 ");

        if (atividadeTO.getId() != 0){
            sql.append(" AND A." + ID_ATIVIDADE + " =? ");
        }
        if ((atividadeTO.getNome() != null) && (!atividadeTO.getNome().equals("")) ){
            sql.append(" AND A." + NOME_ATIVIDADE + " LIKE ? ");
        }
        if (atividadeTO.getResponsavel() != 0){
            sql.append(" AND A." + USUARIO_ATIVIDADE + " = ? ");
        }
        PreparedStatement stmt;
        try {
			 stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        if (atividadeTO.getId() != 0){
	            stmt.setInt(++i,atividadeTO.getId());
	        }
	        if ((atividadeTO.getNome() != null) && (!atividadeTO.getNome().equals("")) ){
	           stmt.setString(++i,"%"+ atividadeTO.getNome()+"%");
	        }
	        if (atividadeTO.getResponsavel() != 0){
	            stmt.setInt(++i,atividadeTO.getResponsavel());
	        }
             ResultSet resultado = stmt.executeQuery();
             AtividadeTO retorno = new AtividadeTO();
             while (resultado.next()) {
            	AtividadeTO atividadeTOReturn = new AtividadeTO();
	         	int j = 0;
	         	atividadeTOReturn.setId(resultado.getInt(++j));
	         	atividadeTOReturn.setDescricao(resultado.getString(++j));		
	         	atividadeTOReturn.setResponsavel(resultado.getInt(++j));
	         	atividadeTOReturn.setAtivo(resultado.getInt(++j));
	         	atividadeTOReturn.setNome(resultado.getString(++j));
	         	atividadeTOReturn.setLinha(resultado.getInt(++j));
	         	atividadeTOReturn.setColuna(resultado.getInt(++j));
	         	retorno = atividadeTOReturn;
             }
             return retorno;
        } catch (Exception e) {
              log.error(e.getMessage());
              throw new DaoException(e.getMessage());
        }
	}
	
	public int consultarMax(AtividadeTO atividadeTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("SELECT MAX(");
		sql.append(ID_ATIVIDADE);
		sql.append(") AS ");
		sql.append(ID_ATIVIDADE);
		sql.append(" FROM ");
		sql.append(TABELA);
		PreparedStatement stmt;
		ResultSet result;		
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			result = stmt.executeQuery();
			while (result.next()) {
				return result.getInt(ID_ATIVIDADE) + 1;
			}
		}
		catch (SQLException e) {
		    log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}		
		return 0;
	}
	
	/*Consulta Utiliza para retornar os atividades de um determinado mapa*/
	@SuppressWarnings("unchecked")
	public Collection consultarAtividadeProcesso(AtividadeTO atividadeTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		
		//sql.append("A."+ ProcessoDAOJDBC.ID_PROCESSO +", A."+ProcessoDAOJDBC.NOME_PROCESSO+",");
		//sql.append("C."+FaseDAOJDBC.ID_FASE+", C."+ FaseDAOJDBC.NOME_FASE+",");
		sql.append("E."+AtividadeDAOJDBC.ID_ATIVIDADE+", E."+AtividadeDAOJDBC.NOME_ATIVIDADE+" ");
		//sql.append("F."+ IndicadorDAOJDBC.ID_INDICADOR+", F."+IndicadorDAOJDBC.NOME_INDICADOR+",");
		
		/*sql.append("B."+ ProcessoDAOJDBC.ID_PROCESSO_REL+", B."+ ProcessoDAOJDBC.ID_FASE_REL +",");
		sql.append(" C."+FaseDAOJDBC.ORDEM_FASE+",");
		sql.append("D."+FaseDAOJDBC.ID_ATIVIDADE_REL +", D."+FaseDAOJDBC.ID_FASE_REL+" ");
		*/
		sql.append(" FROM " + ProcessoDAOJDBC.TABELA + " A LEFT JOIN " + ProcessoDAOJDBC.TABELA_RELPRO + " B  ON (A.ID = B.PROCESS_ID) ");
		sql.append(" LEFT JOIN "+ FaseDAOJDBC.TABELA + " C ON (B.PERSPECTIVE_ID = C.ID)");
		sql.append(" LEFT JOIN " + FaseDAOJDBC.TABELA_REL + " D ON (D.PERSPECTIVE_ID = C.ID)");
		sql.append(" LEFT JOIN " + AtividadeDAOJDBC.TABELA + " E ON (E.ID = D.OBJECTIVE_ID)");
		sql.append(" WHERE 1=1 ");
		
		if (atividadeTO.getIdProcesso() != 0){
			sql.append(" AND A."+ ProcessoDAOJDBC.ID_PROCESSO  +" = ?");
		}
		
		sql.append(" ORDER BY C.SORTORDER,D.ATIVIDADE_ID,D.FASE_ID");
		PreparedStatement stmt;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			int i = 0;
			
			if (atividadeTO.getIdProcesso() != 0){
				stmt.setInt(++i,atividadeTO.getIdProcesso());
			}			

			
			ResultSet resultado = stmt.executeQuery();
			Collection retorno = new ArrayList();
			while (resultado.next()) {
				AtividadeTO atividadeTOReturn = new AtividadeTO();
				int j = 0;
				atividadeTOReturn.setId(resultado.getInt(++j));
				atividadeTOReturn.setNome(resultado.getString(++j));
				retorno.add(atividadeTOReturn);
			}
			return retorno;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DaoException(e.getMessage());
		}
	}
	
	
	// Consulta para buscar os atividades ordenando-os por perspectiva e tema
	@SuppressWarnings("unchecked")
	public Collection consultarAtividadesProcessoGrafico(AtividadeTO atividadeTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("E."+AtividadeDAOJDBC.ID_ATIVIDADE+", E."+AtividadeDAOJDBC.NOME_ATIVIDADE+" ,");
		sql.append(" C."+FaseDAOJDBC.ID_FASE);
		sql.append(" FROM " + ProcessoDAOJDBC.TABELA + " A LEFT JOIN " + ProcessoDAOJDBC.TABELA_RELPRO + " B  ON (A.ID = B.PRO_ID) ");
		sql.append(" LEFT JOIN "+ FaseDAOJDBC.TABELA + " C ON (B.FASE_ID = C.ID AND C.ACTIVE=1)");
		sql.append(" LEFT JOIN " + FaseDAOJDBC.TABELA_REL + " D ON (D.FASE_ID = C.ID)");
		sql.append(" LEFT JOIN " + AtividadeDAOJDBC.TABELA + " E ON (E.ID = D.ATIVIDADE_ID AND E.ACTIVE=1)");
		sql.append(" WHERE 1=1 ");
		
		if (atividadeTO.getIdProcesso() != 0){
			sql.append(" AND A."+ ProcessoDAOJDBC.ID_PROCESSO  +" = ?");
		}
		
		sql.append(" ORDER BY C.SORTORDER,E.NAME");
		PreparedStatement stmt;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			int i = 0;
			
			if (atividadeTO.getIdProcesso() != 0){
				stmt.setInt(++i,atividadeTO.getIdProcesso());
			}			

			ResultSet resultado = stmt.executeQuery();
			Collection retorno = new ArrayList();
			
			while (resultado.next()) {
				AtividadeTO atividadeTOReturn = new AtividadeTO();
				int j = 0;
				atividadeTOReturn.setId(resultado.getInt(++j));
				atividadeTOReturn.setNome(resultado.getString(++j));
				atividadeTOReturn.setIdFase(resultado.getInt(++j));
								
				if (atividadeTOReturn.getId() != 0 && atividadeTOReturn.getIdFase()!=0) {
				retorno.add(atividadeTOReturn);}
			}
			return retorno;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DaoException(e.getMessage());
		}
	}
	
	
	
	public Integer consultarProcessoPorAtividade(AtividadeTO atividadeTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("SELECT A.");
		sql.append(ProcessoDAOJDBC.ID_PROCESSO);
		sql.append(" FROM ");
		sql.append(ProcessoDAOJDBC.TABELA + " A ,");
		sql.append(RelacionamentosDAOJDBC.TABELA + " B ,");
		sql.append(FaseDAOJDBC.TABELA  + " C ,");
		sql.append(FaseDAOJDBC.TABELA_REL + " D ,");
		sql.append(AtividadeDAOJDBC.TABELA + " E ");
		sql.append(" WHERE 1=1 AND E."+ ID_ATIVIDADE +" = ? AND ");
		sql.append(" E." + AtividadeDAOJDBC.ID_ATIVIDADE + " = D." + FaseDAOJDBC.ID_ATIVIDADE_REL +" AND ");
		sql.append(" D." + FaseDAOJDBC.ID_FASE_REL + " = C." + FaseDAOJDBC.ID_FASE +" AND ");
		sql.append(" C." + FaseDAOJDBC.ID_FASE + " = B." + RelacionamentosDAOJDBC.PROIDFAS +" AND ");
		sql.append(" B." + RelacionamentosDAOJDBC.PROIDPRO + " = A." + ProcessoDAOJDBC.ID_PROCESSO);
		
		PreparedStatement stmt;
		ResultSet result;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			stmt.setInt(1,atividadeTO.getId());
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
