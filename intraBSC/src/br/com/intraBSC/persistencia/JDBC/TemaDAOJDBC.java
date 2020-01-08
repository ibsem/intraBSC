

package br.com.intraBSC.persistencia.JDBC;

import br.com.intraBSC.excecoes.ExceptionPersistenciaBSC;
import br.com.intraBSC.modelo.TemaTO;
import br.com.intraBSC.persistencia.BscDaoJDBCGenerico;
import br.com.intraBSC.persistencia.TemaDAO;

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

public class TemaDAOJDBC extends BscDaoJDBCGenerico implements TemaDAO{

	private static Log log = LogFactory.getLog(TemaDAOJDBC.class);
	
	protected static final String TABELA = "THEME";
	protected static final String ID_TEMA = "ID";
	protected static final String NOME_TEMA = "NAME";
	protected static final String RESPONSAVEL_TEMA = "ID_OWNER";
	protected static final String DESCRICAO_TEMA = "DESCRIPTION";
	protected static final String MAPA_TEMA = "BSCREF";
	
	protected static final String TABELA_REL = "RELTHEME";
	protected static final String ID_REL_TEMA = "THEME_ID";
	protected static final String ID_REL_OBJETIVO = "OBJECTIVE_ID";

	private Connection getconexao(){
		return getConnection();			
	}
	
	public TemaDAOJDBC(DaoManager daoManager) {
		super(daoManager);
	}

	public TemaTO consultarUmPorObjetivo(TemaTO temaTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("B." + ID_TEMA + ", ");
		sql.append("B." + DESCRICAO_TEMA + ", ");
		sql.append("B." + RESPONSAVEL_TEMA + ", ");
		sql.append("B." + NOME_TEMA + " ");
		sql.append("FROM " + TABELA + " B, " + TABELA_REL + " C, " + ObjetivoDAOJDBC.TABELA + " D ");		
		sql.append("WHERE 1=1 ");
		
		if (temaTO.getIdObjetivo() != 0){
			sql.append(" AND D." + ObjetivoDAOJDBC.ID_OBJETIVO + " = ? ");
			sql.append(" AND D." + ObjetivoDAOJDBC.ID_OBJETIVO + " = C." + ID_REL_OBJETIVO);
			sql.append(" AND C." + ID_REL_TEMA + " = B." + ID_TEMA);
		}
			
		PreparedStatement stmt;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			int i = 0;
			
			if (temaTO.getIdObjetivo() != 0){
				stmt.setInt(++i,temaTO.getIdObjetivo());
			}
					
			ResultSet resultado = stmt.executeQuery();
			TemaTO retorno = new TemaTO();
			while (resultado.next()) {
				int j = 0;
				retorno.setIdTema(resultado.getInt(++j));
				retorno.setDescricaoTema(resultado.getString(++j));		
				retorno.getUsuario().setIdUsuario(resultado.getInt(++j));
				retorno.setNomeTema(resultado.getString(++j));
			}
			return retorno;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DaoException(e.getMessage());
		}
	}

	
	public TemaTO consultarUm(TemaTO temaTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("B." + ID_TEMA + ", ");
		sql.append("B." + DESCRICAO_TEMA + ", ");
		sql.append("B." + RESPONSAVEL_TEMA + ", ");
		sql.append("B." + NOME_TEMA + " ");
		sql.append("FROM " + TABELA + " B ");		
		sql.append("WHERE 1=1 ");
		
		if (temaTO.getIdTema() != 0){
			sql.append(" AND B." + ID_TEMA + " = ? ");
		}
			
		PreparedStatement stmt;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			int i = 0;
			
			if (temaTO.getIdTema() != 0){
				stmt.setInt(++i,temaTO.getIdTema());
			}
					
			ResultSet resultado = stmt.executeQuery();
			TemaTO retorno = new TemaTO();
			while (resultado.next()) {
				int j = 0;
				retorno.setIdTema(resultado.getInt(++j));
				retorno.setDescricaoTema(resultado.getString(++j));		
				retorno.getUsuario().setIdUsuario(resultado.getInt(++j));
				retorno.setNomeTema(resultado.getString(++j));
			}
			return retorno;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DaoException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public Collection consultarVariosMapa(TemaTO temaTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("B." + ID_TEMA + ", ");
		sql.append("B." + DESCRICAO_TEMA + ", ");
		sql.append("B." + RESPONSAVEL_TEMA + ", ");
		sql.append("B." + NOME_TEMA + ", ");
		sql.append("A." + MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO + ", ");
		sql.append("A." + MapaEstrategicoDAOJDBC.NOME_MAPA_ESTRATEGICO + ", ");
		sql.append("D." + ObjetivoDAOJDBC.ID_OBJETIVO + ", ");			
		sql.append("D." + ObjetivoDAOJDBC.NOME_OBJETIVO + " ");
		sql.append("FROM " + MapaEstrategicoDAOJDBC.TABELA + " A, " + TABELA + " B, ");
		sql.append(TABELA_REL + " C, " + ObjetivoDAOJDBC.TABELA + " D ");		
		sql.append("WHERE 1=1 ");
		
		if (temaTO.getIdMapa() != 0){
			sql.append(" AND A." + MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO + " = ? ");
			sql.append(" AND A." + MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO + " = B." + MAPA_TEMA);
			sql.append(" AND B." + ID_TEMA + " = C." + ID_REL_TEMA);
			sql.append(" AND C." + ID_REL_OBJETIVO + " = D." + ObjetivoDAOJDBC.ID_OBJETIVO);			
			
		}
		sql.append(" ORDER BY D." + ObjetivoDAOJDBC.ID_OBJETIVO );
	
		PreparedStatement stmt;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			int i = 0;
			
			if (temaTO.getIdMapa() != 0){
				stmt.setInt(++i,temaTO.getIdMapa());
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
	
	private TemaTO carregaTO(ResultSet resultado) throws SQLException{
		TemaTO temaTO = new TemaTO();
		int i = 0;
		temaTO.setIdTema(resultado.getInt(++i));
		temaTO.setDescricaoTema(resultado.getString(++i));		
		temaTO.getUsuario().setIdUsuario(resultado.getInt(++i));
		temaTO.setNomeTema(resultado.getString(++i));
		temaTO.setIdMapa(resultado.getInt(++i));
		temaTO.setNomeMapa(resultado.getString(++i));
		temaTO.setIdObjetivo(resultado.getInt(++i));
		temaTO.setNomeObjetivo(resultado.getString(++i));
		return temaTO;
	}

	public void alterar(TemaTO temaTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer("UPDATE ");
        sql.append(TABELA + " SET ");
        if ((temaTO.getNomeTema() != null) && (!temaTO.getNomeTema().equals("")) ){
        	sql.append( NOME_TEMA + " = ?, ");
        }
        if ((temaTO.getNomeTema() != null) && (!temaTO.getNomeTema().equals("")) ){
        	sql.append( DESCRICAO_TEMA + " = ?, ");
        }
        if (temaTO.getUsuario().getIdUsuario() != 0){
        	sql.append( RESPONSAVEL_TEMA + " = ? ");
        }
        sql.append(" WHERE 1=1 ");
        if (temaTO.getIdTema() != 0){
        	sql.append("AND " + ID_TEMA + " = ? ");
        }
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        if ((temaTO.getNomeTema() != null) && (!temaTO.getNomeTema().equals("")) ){
	           stmt.setString(++i,temaTO.getNomeTema());
	        }
	        if ((temaTO.getDescricaoTema() != null) && (!temaTO.getDescricaoTema().equals("")) ){
		           stmt.setString(++i,temaTO.getDescricaoTema());
		    }
	        if (temaTO.getUsuario().getIdUsuario() != 0){
	            stmt.setInt(++i,temaTO.getUsuario().getIdUsuario());
	        }
	        if (temaTO.getIdTema() != 0){
	            stmt.setInt(++i,temaTO.getIdTema());
	        }
            stmt.executeUpdate();
         } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
         }
	}

	public void incluir(TemaTO temaTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer("INSERT INTO ");
        sql.append(TABELA + "(");
        sql.append( ID_TEMA+", ");
        sql.append( DESCRICAO_TEMA+", ");
        if (temaTO.getUsuario().getIdUsuario() != 0){
        	sql.append( RESPONSAVEL_TEMA+", ");
        }
        sql.append( NOME_TEMA+" ");
        sql.append(") VALUES (?,?,");
        if (temaTO.getUsuario().getIdUsuario() != 0){
        	sql.append("?,");
        }	
        sql.append("?)");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        if (temaTO.getIdTema() != 0){
	            stmt.setInt(++i,temaTO.getIdTema());
	        }
	        if ((temaTO.getDescricaoTema() != null) && (!temaTO.getDescricaoTema().equals("")) ){
	            stmt.setString(++i,temaTO.getDescricaoTema().trim());
	         }
	        if (temaTO.getUsuario().getIdUsuario() != 0){
	            stmt.setInt(++i,temaTO.getUsuario().getIdUsuario());
	        }
	        if ((temaTO.getNomeTema() != null) && (!temaTO.getNomeTema().equals("")) ){
	           stmt.setString(++i,temaTO.getNomeTema().trim());
	        }
            stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
	}

	public int consultarMax(TemaTO temaTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer("SELECT MAX(");
		sql.append(ID_TEMA);
		sql.append(") AS ");
		sql.append(ID_TEMA);
		sql.append(" FROM ");
		sql.append(TABELA);
		PreparedStatement stmt;
		ResultSet result;		
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			result = stmt.executeQuery();
			while (result.next()) {
				return result.getInt(ID_TEMA) + 1;
			}			
		} 
		catch (SQLException e) {
		    log.error(e.getMessage());
			throw new ExceptionPersistenciaBSC(e.getMessage());
		}
		return 0;
	}

	public void excluir(TemaTO temaTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer("DELETE FROM ");
        sql.append(TABELA);
        sql.append(" WHERE 1=1 ");
        if (temaTO.getIdTema() != 0){
            sql.append(" AND " + temaTO.getIdTema()+ " =? ");
        }
        PreparedStatement stmt;
        try {
             int i = 0;
             stmt = getconexao().prepareStatement(sql.toString());
             if (temaTO.getIdTema() != 0){
                   stmt.setInt(++i,temaTO.getIdTema());
             }
             stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
	}
	
	@SuppressWarnings("unchecked")
	public JasperPrint temaRelatorioDetalha(TemaTO temaTO) throws ExceptionPersistenciaBSC {
		try {
			Map parameters = new HashMap();
			//Parametros do relatorio
	        Locale locale = new Locale("pt" , "BR");
			parameters.put(JRParameter.REPORT_LOCALE, locale);
			parameters.put("tema", new Integer(temaTO.getIdTema()));
			parameters.put("bsc", new Integer(temaTO.getIdMapa()));
			parameters.put("baseDir", temaTO.getBaseDir());	
			JasperPrint relatorioFinal = JasperFillManager.fillReport(temaTO.getJasperReport(),parameters, getconexao());
			return relatorioFinal;
		} catch (JRException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaBSC(e.getMessage());
		}
	}


	@SuppressWarnings("unchecked")
	public Collection consultarVarios(TemaTO temaTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("B." + ID_TEMA + ", ");
		sql.append("B." + DESCRICAO_TEMA + ", ");
		sql.append("B." + RESPONSAVEL_TEMA + ", ");
		sql.append("B." + NOME_TEMA + " ");
		sql.append("FROM " + TABELA + " B, " + GrupoDAOJDBC.TABELA + " A, " + UsuarioDAOJDBC.TABELA + " C ");		
		sql.append("WHERE 1=1 ");
		
		if (temaTO.getUsuario().getGrupoTO() != null){
			sql.append(" AND C." + UsuarioDAOJDBC.GRUPO_USUARIO + " = A." + GrupoDAOJDBC.CODIGO);
			sql.append(" AND A." + GrupoDAOJDBC.CODIGO + " = ? ");
			sql.append(" AND C." + UsuarioDAOJDBC.ID_USUARIO + " = B." + RESPONSAVEL_TEMA);
		}
		
		if (temaTO.getIdTema() != 0){
			sql.append(" AND B." + ID_TEMA + " = ? ");
		}
		if ((temaTO.getNomeTema() != null) && (!temaTO.getNomeTema().equals(""))){
			sql.append(" AND UCASE(B." + NOME_TEMA + ") LIKE ? ");
		}
//		if (temaTO.getUsuario().getIdUsuario() != 0){
//			sql.append(" AND B." + RESPONSAVEL_TEMA + " = ? ");
//		}
		
		sql.append(" ORDER BY " + NOME_TEMA);
		PreparedStatement stmt;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			int i = 0;
			
			if (temaTO.getIdMapa() != 0){
				stmt.setInt(++i,temaTO.getIdMapa());
			}
			if ((temaTO.getNomeTema() != null) && (!temaTO.getNomeTema().equals(""))){
				stmt.setString(++i,"%"+temaTO.getNomeTema().toUpperCase()+"%");
			}
						
			if (temaTO.getUsuario().getGrupoTO() != null){
				stmt.setInt(++i,temaTO.getUsuario().getGrupoTO().getCodigo());
			}
			
//			if (temaTO.getUsuario().getIdUsuario() != 0){
//				stmt.setInt(++i,temaTO.getUsuario().getIdUsuario());
//			}
			
			ResultSet resultado = stmt.executeQuery();
			Collection<TemaTO> retorno = new ArrayList();
			while (resultado.next()) {
				TemaTO temaTOReturn = new TemaTO();
				int j = 0;
				temaTOReturn.setIdTema(resultado.getInt(++j));
				temaTOReturn.setDescricaoTema(resultado.getString(++j));		
				temaTOReturn.getUsuario().setIdUsuario(resultado.getInt(++j));
				temaTOReturn.setNomeTema(resultado.getString(++j));
				retorno.add(temaTOReturn);
			}
			return retorno;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DaoException(e.getMessage());
		}
	}
      
}
