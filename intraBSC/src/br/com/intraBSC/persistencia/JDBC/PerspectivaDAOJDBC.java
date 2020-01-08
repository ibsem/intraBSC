

package br.com.intraBSC.persistencia.JDBC;

import br.com.intraBSC.excecoes.ExceptionPersistenciaBSC;
import br.com.intraBSC.modelo.PerspectivaTO;
import br.com.intraBSC.persistencia.BscDaoJDBCGenerico;
import br.com.intraBSC.persistencia.PerspectivaDAO;

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

public class PerspectivaDAOJDBC extends BscDaoJDBCGenerico implements PerspectivaDAO {
	
	protected static final String TABELA = "PERSPECTIVE";
	protected static final String ID_PERSPECTIVA = "ID";
	protected static final String DESCRICAO_PERSPECTIVA = "DESCRIPTION";
	protected static final String TIPO_PERSPECTIVA = "PERSPECTIVETYPE_ID";
	protected static final String USUARIO_PERSPECTIVA = "OWNER_ID";
	protected static final String NOME_PERSPECTIVA = "NAME";
	protected static final String ORDEM_PERSPECTIVA = "SORTORDER";
	protected static final String ATIVO = "ACTIVE";
	
	protected static final String TABELA_REL = "RELPERSPECTIVE";
	protected static final String ID_PERSPECTIVA_REL = "PERSPECTIVE_ID";
	protected static final String ID_OBJETIVO_REL = "OBJECTIVE_ID";
	
	private static Log log = LogFactory.getLog(PerspectivaDAOJDBC.class);

	private Connection getconexao(){
		return getConnection();			
	}
	
	public PerspectivaDAOJDBC(DaoManager daoManager) {
		super(daoManager);		
	}
	
	public void excluir(PerspectivaTO perspectivaTO) throws ExceptionPersistenciaBSC {
		
	}
	
	public void incluir(PerspectivaTO perspectivaTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("INSERT INTO ");
        sql.append(TABELA + "(");
        sql.append( ID_PERSPECTIVA+", ");
        sql.append( DESCRICAO_PERSPECTIVA+", ");
        sql.append( TIPO_PERSPECTIVA+", ");
        if (perspectivaTO.getResponsavel() != 0){
        	sql.append( USUARIO_PERSPECTIVA+", ");
        }
        sql.append( NOME_PERSPECTIVA+", ");
        sql.append( ATIVO+", ");
        sql.append( ORDEM_PERSPECTIVA+" ");
        sql.append(") VALUES (?,?,?,");
        if (perspectivaTO.getResponsavel() != 0){
        	sql.append("?,");
        }
        sql.append("?,?,?)");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
        int i = 0;
        if (perspectivaTO.getId() != 0){
            stmt.setInt(++i,perspectivaTO.getId());
        }
        if ((perspectivaTO.getDescricao() != null) && (!perspectivaTO.getDescricao().equals("")) ){
            stmt.setString(++i,perspectivaTO.getDescricao());
        }
        if (perspectivaTO.getTipoPerspectiva() != 0){
            stmt.setInt(++i,perspectivaTO.getTipoPerspectiva());
        }
        if (perspectivaTO.getResponsavel() != 0){
            stmt.setInt(++i,perspectivaTO.getResponsavel());
        }        
        if ((perspectivaTO.getNome() != null) && (!perspectivaTO.getNome().equals("")) ){
           stmt.setString(++i,perspectivaTO.getNome());
        }
        if (perspectivaTO.getAtivo() != 0){
            stmt.setInt(++i,perspectivaTO.getAtivo());
        }
        if (perspectivaTO.getOrdem() != 0){
            stmt.setInt(++i,perspectivaTO.getOrdem());
        }
            stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
	}
	
	public void alterar(PerspectivaTO perspectivaTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("UPDATE ");
        sql.append(TABELA + " SET ");
        sql.append( DESCRICAO_PERSPECTIVA + " = ?, ");
        sql.append( TIPO_PERSPECTIVA + " = ?, ");
        sql.append( USUARIO_PERSPECTIVA + " = ?, ");
        sql.append( NOME_PERSPECTIVA + " = ?, ");
        sql.append( ATIVO + " = ?, ");
        sql.append( ORDEM_PERSPECTIVA + " = ? ");
        sql.append(" WHERE 1=1 ");
        sql.append("AND " + ID_PERSPECTIVA  + " = ? ");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
            int i = 0;
	       
	        if ((perspectivaTO.getDescricao() != null) && (!perspectivaTO.getDescricao().equals("")) ){
	            stmt.setString(++i,perspectivaTO.getDescricao());
	        }
	        if (perspectivaTO.getTipoPerspectiva() != 0){
	            stmt.setInt(++i,perspectivaTO.getTipoPerspectiva());
	        }
	        if (perspectivaTO.getResponsavel() != 0){
	            stmt.setInt(++i,perspectivaTO.getResponsavel());
	        }        
	        if ((perspectivaTO.getNome() != null) && (!perspectivaTO.getNome().equals("")) ){
	           stmt.setString(++i,perspectivaTO.getNome());
	        }
	        if (perspectivaTO.getAtivo() != 0){
	            stmt.setInt(++i,perspectivaTO.getAtivo());
	        }
	        if (perspectivaTO.getOrdem() != 0){
	            stmt.setInt(++i,perspectivaTO.getOrdem());
	        }
	        if (perspectivaTO.getId() != 0){
	            stmt.setInt(++i,perspectivaTO.getId());
	        }
            stmt.executeUpdate();
         } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
         }
	}

	@SuppressWarnings("unchecked")
	public Collection consultarVarios(PerspectivaTO perspectivaTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("B." + ID_PERSPECTIVA + ", ");
		sql.append("B." + DESCRICAO_PERSPECTIVA + ", ");
		sql.append("B." + ATIVO + ", ");
		sql.append("B." + TIPO_PERSPECTIVA + ", ");
		sql.append("B." + USUARIO_PERSPECTIVA + ", ");
		sql.append("B." + NOME_PERSPECTIVA + ", ");
		sql.append("B." + ORDEM_PERSPECTIVA + ", ");
		sql.append("A." + MapaEstrategicoDAOJDBC.NOME_MAPA_ESTRATEGICO + ", ");
		sql.append("A." + MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO + " ");
		sql.append("FROM " + MapaEstrategicoDAOJDBC.TABELA + " A, " + TABELA + " B, " + MapaEstrategicoDAOJDBC.TABELA_RELBSC + " C ");
		sql.append("WHERE 1=1 ");
		
		if (perspectivaTO.getIdMapa() != 0){
			sql.append(" AND A." + MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO + " = ? ");
			sql.append(" AND A." + MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO + " = C." + MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO_REL);
			sql.append(" AND C." + MapaEstrategicoDAOJDBC.ID_PERSPECTIVA_REL + " = B." + ID_PERSPECTIVA);
		}
		sql.append(" ORDER BY B."+ ORDEM_PERSPECTIVA);
		PreparedStatement stmt;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			int i = 0;
			
			if (perspectivaTO.getIdMapa() != 0){
				stmt.setInt(++i,perspectivaTO.getIdMapa());
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
	public Collection consultarVariosMapa(PerspectivaTO perspectivaTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("B." + ID_PERSPECTIVA + ", ");
		sql.append("B." + DESCRICAO_PERSPECTIVA + ", ");
		sql.append("B." + ATIVO + ", ");
		sql.append("B." + TIPO_PERSPECTIVA + ", ");
		sql.append("B." + USUARIO_PERSPECTIVA + ", ");
		sql.append("B." + NOME_PERSPECTIVA + ", ");
		sql.append("B." + ORDEM_PERSPECTIVA + ", ");
		sql.append("A." + MapaEstrategicoDAOJDBC.NOME_MAPA_ESTRATEGICO + ", ");
		sql.append("A." + MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO + " ");
		sql.append("FROM " + MapaEstrategicoDAOJDBC.TABELA + " A, " + TABELA + " B, " + MapaEstrategicoDAOJDBC.TABELA_RELBSC + " C ");
		sql.append("WHERE 1=1 ");
		
		if (perspectivaTO.getIdMapa() != 0){
			sql.append(" AND A." + MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO + " = ? ");
			sql.append(" AND A." + MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO + " = C." + MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO_REL);
			sql.append(" AND C." + MapaEstrategicoDAOJDBC.ID_PERSPECTIVA_REL + " = B." + ID_PERSPECTIVA);
			sql.append(" AND B." + PerspectivaDAOJDBC.ATIVO + " = 1");
		}
		sql.append(" ORDER BY B."+ ORDEM_PERSPECTIVA);
		PreparedStatement stmt;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			int i = 0;
			
			if (perspectivaTO.getIdMapa() != 0){
				stmt.setInt(++i,perspectivaTO.getIdMapa());
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

	
	private PerspectivaTO carregaTO(ResultSet resultado) throws SQLException{
		PerspectivaTO perspectivaTO = new PerspectivaTO();
		int i = 0;
		perspectivaTO.setId(resultado.getInt(++i));
		perspectivaTO.setDescricao(resultado.getString(++i));
		perspectivaTO.setAtivo(resultado.getInt(++i));
		perspectivaTO.setTipoPerspectiva(resultado.getInt(++i));
		perspectivaTO.setResponsavel(resultado.getInt(++i));
		perspectivaTO.setNome(resultado.getString(++i));
		perspectivaTO.setOrdem(resultado.getInt(++i));
		perspectivaTO.setNomeMapa(resultado.getString(++i));
		perspectivaTO.setIdMapa(resultado.getInt(++i));
		return perspectivaTO;
	}

	@SuppressWarnings("unchecked")
	public JasperPrint perspectivaRelatorioDetalha(PerspectivaTO perspectivaTO) throws ExceptionPersistenciaBSC {
		try {
			Map parameters = new HashMap();
			//Parametros do relatorio
	        Locale locale = new Locale("pt" , "BR");
			parameters.put(JRParameter.REPORT_LOCALE, locale);
			parameters.put("perspectiva", new Integer(perspectivaTO.getId()));
			parameters.put("bsc", new Integer(perspectivaTO.getIdMapa()));
			parameters.put("baseDir", perspectivaTO.getBaseDir());	
			JasperPrint relatorioFinal = JasperFillManager.fillReport(perspectivaTO.getJasperReport(),parameters, getconexao());
			return relatorioFinal;
		} catch (JRException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaBSC(e.getMessage());
		}
	}
	
	public int consultarMax(PerspectivaTO perspectivaTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer("SELECT MAX(");
		sql.append(ID_PERSPECTIVA);
		sql.append(") AS ");
		sql.append(ID_PERSPECTIVA);
		sql.append(" FROM ");
		sql.append(TABELA);
		PreparedStatement stmt;
		ResultSet result;		
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			result = stmt.executeQuery();
			while (result.next()) {
				return result.getInt(ID_PERSPECTIVA) + 1;
			}			
		} 
		catch (SQLException e) {
		    log.error(e.getMessage());
			throw new ExceptionPersistenciaBSC(e.getMessage());
		}		
		return 0;
	}

	public PerspectivaTO consultarUm(PerspectivaTO perspectivaTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + ID_PERSPECTIVA + ", ");
        sql.append("A." + DESCRICAO_PERSPECTIVA + ", ");
        sql.append("A." + ATIVO + ", ");
        sql.append("A." + TIPO_PERSPECTIVA + ", ");
        sql.append("A." + USUARIO_PERSPECTIVA + ", ");
        sql.append("A." + ORDEM_PERSPECTIVA + ", ");
        sql.append("A." + NOME_PERSPECTIVA + " ");
        sql.append("FROM " + TABELA + " A ");
        sql.append("WHERE 1=1 ");

        if (perspectivaTO.getId() != 0){
            sql.append(" AND A." + ID_PERSPECTIVA + " =? ");
        }        

        PreparedStatement stmt;
        try {
			 stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        if (perspectivaTO.getId() != 0){
	            stmt.setInt(++i,perspectivaTO.getId());
	        }

             ResultSet resultado = stmt.executeQuery();
             PerspectivaTO retorno = new PerspectivaTO();
             while (resultado.next()) {
                  retorno = carregaTOPerspectiva(resultado);
             }
             return retorno;
        } catch (Exception e) {
              log.error(e.getMessage());
              throw new DaoException(e.getMessage());
        }
	}
		
	private PerspectivaTO carregaTOPerspectiva(ResultSet resultado) throws SQLException{
		PerspectivaTO perspectivaTO = new PerspectivaTO();

		perspectivaTO.setId(resultado.getInt(1));
		perspectivaTO.setDescricao(resultado.getString(2));
		perspectivaTO.setAtivo(resultado.getInt(3));
		perspectivaTO.setTipoPerspectiva(resultado.getInt(4));
		perspectivaTO.setResponsavel(resultado.getInt(5));
		perspectivaTO.setOrdem(resultado.getInt(6));
		perspectivaTO.setNome(resultado.getString(7));		
		return perspectivaTO;
	}
	
	public Integer consultarMapaPorPerspectiva(PerspectivaTO perspectivaTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer("SELECT A.");
		sql.append(MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO);
		sql.append(" FROM ");
		sql.append(MapaEstrategicoDAOJDBC.TABELA + " A ,");
		sql.append(RelacionamentosDAOJDBC.TABELA + " B ,");
		sql.append(PerspectivaDAOJDBC.TABELA  + " C ");
		sql.append(" WHERE 1=1 AND C."+ ID_PERSPECTIVA +" = ? AND ");
		sql.append(" C." + PerspectivaDAOJDBC.ID_PERSPECTIVA + " = B." + RelacionamentosDAOJDBC.BSCIDPERS +" AND ");
		sql.append(" B." + RelacionamentosDAOJDBC.BSCIDBSC + " = A." + MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO);
		
		PreparedStatement stmt;
		ResultSet result;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			stmt.setInt(1,perspectivaTO.getId());
			result = stmt.executeQuery();
			while (result.next()) {
				return result.getInt(MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO);
			}
		}
		catch (SQLException e) {
		    log.error(e.getMessage());
			throw new ExceptionPersistenciaBSC(e.getMessage());
		}		
		return null;
	}




	
}

