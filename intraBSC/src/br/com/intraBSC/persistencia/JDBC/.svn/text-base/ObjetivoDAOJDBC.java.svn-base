package br.com.intraBSC.persistencia.JDBC;

import br.com.intraBSC.excecoes.ExceptionPersistenciaBSC;
import br.com.intraBSC.modelo.ObjetivoTO;
import br.com.intraBSC.persistencia.BscDaoJDBCGenerico;
import br.com.intraBSC.persistencia.ObjetivoDAO;

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
public class ObjetivoDAOJDBC extends BscDaoJDBCGenerico implements ObjetivoDAO{

	private static Log log = LogFactory.getLog(ObjetivoDAOJDBC.class);
	
	protected static final String TABELA = "OBJECTIVE";
	protected static final String ID_OBJETIVO = "ID";
	protected static final String DESCRICAO_OBJETIVO = "DESCRIPTION";	
	protected static final String USUARIO_OBJETIVO = "OWNER_ID";
	protected static final String NOME_OBJETIVO = "NAME";
	protected static final String ATIVO = "ACTIVE";
	protected static final String LINHA = "LINHA";
	protected static final String COLUNA = "COL";
	
	public ObjetivoDAOJDBC(DaoManager daoManager) {
		super(daoManager);
	}
	
	private Connection getconexao(){
		return getConnection();			
	}
	
	public void alterar(ObjetivoTO objetivoTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer("UPDATE ");
        sql.append(TABELA + " SET ");
        sql.append( DESCRICAO_OBJETIVO + " = ?, ");
        sql.append( USUARIO_OBJETIVO + " = ?, ");
        sql.append( ATIVO + " = ?, ");
        sql.append( NOME_OBJETIVO + " = ?, ");
        sql.append( LINHA + " = ?, ");
        sql.append( COLUNA + " = ? ");
        sql.append(" WHERE 1=1 ");
        sql.append("AND " + ID_OBJETIVO  + " = ? ");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());

        int i = 0;
        if ((objetivoTO.getDescricao() != null) && (!objetivoTO.getDescricao().equals("")) ){
            stmt.setString(++i,objetivoTO.getDescricao().trim());
        }
        if (objetivoTO.getResponsavel() != 0){
            stmt.setInt(++i,objetivoTO.getResponsavel());
        }
        if (objetivoTO.getAtivo() != 0){
            stmt.setInt(++i,objetivoTO.getAtivo());
        }
        if ((objetivoTO.getNome() != null) && (!objetivoTO.getNome().equals("")) ){
           stmt.setString(++i,objetivoTO.getNome().trim());
        }
        if (objetivoTO.getLinha() != -3){
            stmt.setInt(++i,objetivoTO.getLinha());
        }
        if (objetivoTO.getColuna() != 0){
            stmt.setInt(++i,objetivoTO.getColuna());
        }
        if (objetivoTO.getId() != 0){
            stmt.setInt(++i,objetivoTO.getId());
        }
        
        
            stmt.executeUpdate();
         } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
         }
	}
	
	public void incluir(ObjetivoTO objetivoTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer("INSERT INTO ");
        sql.append(TABELA + "(");
        sql.append( ID_OBJETIVO+", ");
        sql.append( DESCRICAO_OBJETIVO+", ");
        if (objetivoTO.getResponsavel() != 0){
        	sql.append( USUARIO_OBJETIVO+", ");
        }
        sql.append( ATIVO+", ");
        sql.append( NOME_OBJETIVO+", ");
        sql.append( LINHA+", ");
        sql.append( COLUNA+" ");
        sql.append(") VALUES (?,?,");
        if (objetivoTO.getResponsavel() != 0){
        	sql.append("?,");
        }
        sql.append("?,?,?,?)");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
        int i = 0;
        if (objetivoTO.getId() != 0){
            stmt.setInt(++i,objetivoTO.getId());
        }
        if ((objetivoTO.getDescricao() != null) && (!objetivoTO.getDescricao().equals("")) ){
            stmt.setString(++i,objetivoTO.getDescricao().trim());
        }
        if (objetivoTO.getResponsavel() != 0){
            stmt.setInt(++i,objetivoTO.getResponsavel());
        }
        if (objetivoTO.getAtivo() != 0){
            stmt.setInt(++i,objetivoTO.getAtivo());
        }
        if ((objetivoTO.getNome() != null) && (!objetivoTO.getNome().equals("")) ){
           stmt.setString(++i,objetivoTO.getNome().trim());
        }
        if (objetivoTO.getLinha() != -3){
            stmt.setInt(++i,objetivoTO.getLinha());
        }
        if (objetivoTO.getColuna() != 0){
            stmt.setInt(++i,objetivoTO.getColuna());
        }
            stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
	}
	
	@SuppressWarnings("unchecked")
	public Collection consultarVarios(ObjetivoTO objetivoTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("E." + ID_OBJETIVO + ", ");
		sql.append("E." + DESCRICAO_OBJETIVO + ", ");
		sql.append("E." + USUARIO_OBJETIVO + ", ");
		sql.append("E." + ATIVO + ", ");
		sql.append("E." + NOME_OBJETIVO + ", ");
		sql.append("E." + LINHA + ", ");
		sql.append("E." + COLUNA + ", ");
		sql.append("A." + MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO + ", ");
		sql.append("A." + MapaEstrategicoDAOJDBC.NOME_MAPA_ESTRATEGICO + ", ");
		sql.append("C." + PerspectivaDAOJDBC.ID_PERSPECTIVA + ", ");			
		sql.append("C." + PerspectivaDAOJDBC.NOME_PERSPECTIVA + " ");
		sql.append("FROM " + MapaEstrategicoDAOJDBC.TABELA + " A, " + MapaEstrategicoDAOJDBC.TABELA_RELBSC + " B, ");
		sql.append(PerspectivaDAOJDBC.TABELA + " C, " + PerspectivaDAOJDBC.TABELA_REL + " D, ");
		sql.append(TABELA + " E ");
		sql.append("WHERE 1=1 ");
		
		if (objetivoTO.getIdMapa() != 0){
			sql.append(" AND A." + MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO + " = ? ");
			sql.append(" AND A." + MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO + " = B." + MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO_REL);
			sql.append(" AND B." + MapaEstrategicoDAOJDBC.ID_PERSPECTIVA_REL + " = C." + PerspectivaDAOJDBC.ID_PERSPECTIVA);
			sql.append(" AND C." + PerspectivaDAOJDBC.ID_PERSPECTIVA + " = D." + PerspectivaDAOJDBC.ID_PERSPECTIVA_REL);
			sql.append(" AND D." + PerspectivaDAOJDBC.ID_OBJETIVO_REL + " = E." + ID_OBJETIVO);
			
		}
		sql.append(" ORDER BY E." + NOME_OBJETIVO);
	
		PreparedStatement stmt;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			int i = 0;
			
			if (objetivoTO.getIdMapa() != 0){
				stmt.setInt(++i,objetivoTO.getIdMapa());
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
	
	
	private ObjetivoTO carregaTO(ResultSet resultado) throws SQLException{
		ObjetivoTO objetivoTO = new ObjetivoTO();
		int i = 0;
		objetivoTO.setId(resultado.getInt(++i));
		objetivoTO.setDescricao(resultado.getString(++i));		
		objetivoTO.setResponsavel(resultado.getInt(++i));
		objetivoTO.setAtivo(resultado.getInt(++i));
		objetivoTO.setNome(resultado.getString(++i));
		objetivoTO.setLinha(resultado.getInt(++i));
		objetivoTO.setColuna(resultado.getInt(++i));
		objetivoTO.setIdMapa(resultado.getInt(++i));
		objetivoTO.setNomeMapa(resultado.getString(++i));
		objetivoTO.setIdPerspectiva(resultado.getInt(++i));
		objetivoTO.setNomePerspectiva(resultado.getString(++i));
		return objetivoTO;
	}

	@SuppressWarnings("unchecked")
	public JasperPrint objetivoRelatorioDetalha(ObjetivoTO objetivoTO) throws ExceptionPersistenciaBSC {		
		try {
			Map parameters = new HashMap();
			//Parametros do relatorio
	        Locale locale = new Locale("pt" , "BR");
			parameters.put(JRParameter.REPORT_LOCALE, locale);
			parameters.put("objetivo", new Integer(objetivoTO.getId()));
			parameters.put("bsc", new Integer(objetivoTO.getIdMapa()));
			parameters.put("baseDir", objetivoTO.getBaseDir());	
			JasperPrint relatorioFinal = JasperFillManager.fillReport(objetivoTO.getJasperReport(),parameters, getconexao());
			return relatorioFinal;
		} catch (JRException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaBSC(e.getMessage());
		}
	}

	public ObjetivoTO consultarUm(ObjetivoTO objetivoTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + ID_OBJETIVO + ", ");
        sql.append("A." + DESCRICAO_OBJETIVO + ", ");
        sql.append("A." + USUARIO_OBJETIVO + ", ");
        sql.append("A." + ATIVO + ", ");
        sql.append("A." + NOME_OBJETIVO + ", ");
        sql.append("A." + LINHA + ", ");
        sql.append("A." + COLUNA + " ");
        sql.append("FROM " + TABELA + " A ");
        sql.append("WHERE 1=1 ");

        if (objetivoTO.getId() != 0){
            sql.append(" AND A." + ID_OBJETIVO + " =? ");
        }
        if ((objetivoTO.getNome() != null) && (!objetivoTO.getNome().equals("")) ){
            sql.append(" AND A." + NOME_OBJETIVO + " LIKE ? ");
        }
        if (objetivoTO.getResponsavel() != 0){
            sql.append(" AND A." + USUARIO_OBJETIVO + " = ? ");
        }
        PreparedStatement stmt;
        try {
			 stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        if (objetivoTO.getId() != 0){
	            stmt.setInt(++i,objetivoTO.getId());
	        }
	        if ((objetivoTO.getNome() != null) && (!objetivoTO.getNome().equals("")) ){
	           stmt.setString(++i,"%"+ objetivoTO.getNome()+"%");
	        }
	        if (objetivoTO.getResponsavel() != 0){
	            stmt.setInt(++i,objetivoTO.getResponsavel());
	        }
             ResultSet resultado = stmt.executeQuery();
             ObjetivoTO retorno = new ObjetivoTO();
             while (resultado.next()) {
            	ObjetivoTO objetivoTOReturn = new ObjetivoTO();
	         	int j = 0;
	         	objetivoTOReturn.setId(resultado.getInt(++j));
	         	objetivoTOReturn.setDescricao(resultado.getString(++j));		
	         	objetivoTOReturn.setResponsavel(resultado.getInt(++j));
	         	objetivoTOReturn.setAtivo(resultado.getInt(++j));
	         	objetivoTOReturn.setNome(resultado.getString(++j));
	         	objetivoTOReturn.setLinha(resultado.getInt(++j));
	         	objetivoTOReturn.setColuna(resultado.getInt(++j));
	         	retorno = objetivoTOReturn;
             }
             return retorno;
        } catch (Exception e) {
              log.error(e.getMessage());
              throw new DaoException(e.getMessage());
        }
	}
	
	public int consultarMax(ObjetivoTO objetivoTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer("SELECT MAX(");
		sql.append(ID_OBJETIVO);
		sql.append(") AS ");
		sql.append(ID_OBJETIVO);
		sql.append(" FROM ");
		sql.append(TABELA);
		PreparedStatement stmt;
		ResultSet result;		
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			result = stmt.executeQuery();
			while (result.next()) {
				return result.getInt(ID_OBJETIVO) + 1;
			}
		}
		catch (SQLException e) {
		    log.error(e.getMessage());
			throw new ExceptionPersistenciaBSC(e.getMessage());
		}		
		return 0;
	}
	
	/*Consulta Utiliza para retornar os objetivos de um determinado mapa*/
	@SuppressWarnings("unchecked")
	public Collection consultarObjetivoMapa(ObjetivoTO objetivoTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT DISTINCT ");
		
		//sql.append("A."+ MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO +", A."+MapaEstrategicoDAOJDBC.NOME_MAPA_ESTRATEGICO+",");
		//sql.append("C."+PerspectivaDAOJDBC.ID_PERSPECTIVA+", C."+ PerspectivaDAOJDBC.NOME_PERSPECTIVA+",");
		sql.append("E."+ObjetivoDAOJDBC.ID_OBJETIVO+", E."+ObjetivoDAOJDBC.NOME_OBJETIVO+" ");
		//sql.append("F."+ IndicadorDAOJDBC.ID_INDICADOR+", F."+IndicadorDAOJDBC.NOME_INDICADOR+",");
		
		/*sql.append("B."+ MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO_REL+", B."+ MapaEstrategicoDAOJDBC.ID_PERSPECTIVA_REL +",");
		sql.append(" C."+PerspectivaDAOJDBC.ORDEM_PERSPECTIVA+",");
		sql.append("D."+PerspectivaDAOJDBC.ID_OBJETIVO_REL +", D."+PerspectivaDAOJDBC.ID_PERSPECTIVA_REL+" ");
		*/
		sql.append(" FROM " + MapaEstrategicoDAOJDBC.TABELA + " A LEFT JOIN " + MapaEstrategicoDAOJDBC.TABELA_RELBSC + " B  ON (A.ID = B.BSC_ID) ");
		sql.append(" LEFT JOIN "+ PerspectivaDAOJDBC.TABELA + " C ON (B.PERSPECTIVE_ID = C.ID)");
		sql.append(" LEFT JOIN " + PerspectivaDAOJDBC.TABELA_REL + " D ON (D.PERSPECTIVE_ID = C.ID)");
		sql.append(" LEFT JOIN " + ObjetivoDAOJDBC.TABELA + " E ON (E.ID = D.OBJECTIVE_ID)");
		sql.append(" LEFT JOIN " + IndicadorDAOJDBC.TABELA + " F ON (F.OBJECTIVE_ID = E.ID)");
		sql.append(" WHERE 1=1 ");
		
		if (objetivoTO.getIdMapa() != 0){
			sql.append(" AND A."+ MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO  +" = ?");
		}
		
		sql.append(" ORDER BY C.SORTORDER,D.OBJECTIVE_ID,D.PERSPECTIVE_ID");
		PreparedStatement stmt;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			int i = 0;
			
			if (objetivoTO.getIdMapa() != 0){
				stmt.setInt(++i,objetivoTO.getIdMapa());
			}			

			
			ResultSet resultado = stmt.executeQuery();
			Collection retorno = new ArrayList();
			while (resultado.next()) {
				ObjetivoTO objetivoTOReturn = new ObjetivoTO();
				int j = 0;
				objetivoTOReturn.setId(resultado.getInt(++j));
				objetivoTOReturn.setNome(resultado.getString(++j));
				retorno.add(objetivoTOReturn);
			}
			return retorno;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DaoException(e.getMessage());
		}
	}
	
	
	// Consulta para buscar os objetivos ordenando-os por perspectiva e tema
	@SuppressWarnings("unchecked")
	public Collection consultarObjetivosMapaGrafico(ObjetivoTO objetivoTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("E."+ObjetivoDAOJDBC.ID_OBJETIVO+", E."+ObjetivoDAOJDBC.NOME_OBJETIVO+" ,E."+ObjetivoDAOJDBC.LINHA+" ,"+ObjetivoDAOJDBC.COLUNA+" ,");
		sql.append(" C."+PerspectivaDAOJDBC.ID_PERSPECTIVA+" ,");
		sql.append(" G."+TemaDAOJDBC.ID_TEMA);
		sql.append(" FROM " + MapaEstrategicoDAOJDBC.TABELA + " A LEFT JOIN " + MapaEstrategicoDAOJDBC.TABELA_RELBSC + " B  ON (A.ID = B.BSC_ID) ");
		sql.append(" LEFT JOIN "+ PerspectivaDAOJDBC.TABELA + " C ON (B.PERSPECTIVE_ID = C.ID AND C.ACTIVE=1)");
		sql.append(" LEFT JOIN " + PerspectivaDAOJDBC.TABELA_REL + " D ON (D.PERSPECTIVE_ID = C.ID)");
		sql.append(" LEFT JOIN " + ObjetivoDAOJDBC.TABELA + " E ON (E.ID = D.OBJECTIVE_ID AND E.ACTIVE=1)");
		sql.append(" LEFT JOIN " + TemaDAOJDBC.TABELA_REL + " F ON (F.OBJECTIVE_ID = E.ID)");
		sql.append(" LEFT JOIN " + TemaDAOJDBC.TABELA + " G ON (G.ID = F.THEME_ID)");
		sql.append(" WHERE 1=1 ");
		
		if (objetivoTO.getIdMapa() != 0){
			sql.append(" AND A."+ MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO  +" = ?");
		}
		
		sql.append(" ORDER BY C.SORTORDER,E.COL,E.NAME,G.ID");
		PreparedStatement stmt;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			int i = 0;
			
			if (objetivoTO.getIdMapa() != 0){
				stmt.setInt(++i,objetivoTO.getIdMapa());
			}			

			ResultSet resultado = stmt.executeQuery();
			Collection retorno = new ArrayList();
			
			while (resultado.next()) {
				ObjetivoTO objetivoTOReturn = new ObjetivoTO();
				int j = 0;
				objetivoTOReturn.setId(resultado.getInt(++j));
				objetivoTOReturn.setNome(resultado.getString(++j));
				objetivoTOReturn.setLinha(resultado.getInt(++j));
				objetivoTOReturn.setColuna(resultado.getInt(++j));
				objetivoTOReturn.setIdPerspectiva(resultado.getInt(++j));
				objetivoTOReturn.setIdTema(resultado.getInt(++j));
				
				if (objetivoTOReturn.getId() != 0 && objetivoTOReturn.getIdPerspectiva()!=0) {
				retorno.add(objetivoTOReturn);}
			}
			return retorno;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DaoException(e.getMessage());
		}
	}
	
	
	
	public Integer consultarMapaPorObjetivo(ObjetivoTO objetivoTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer("SELECT A.");
		sql.append(MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO);
		sql.append(" FROM ");
		sql.append(MapaEstrategicoDAOJDBC.TABELA + " A ,");
		sql.append(RelacionamentosDAOJDBC.TABELA + " B ,");
		sql.append(PerspectivaDAOJDBC.TABELA  + " C ,");
		sql.append(PerspectivaDAOJDBC.TABELA_REL + " D ,");
		sql.append(ObjetivoDAOJDBC.TABELA + " E ");
		sql.append(" WHERE 1=1 AND E."+ ID_OBJETIVO +" = ? AND ");
		sql.append(" E." + ObjetivoDAOJDBC.ID_OBJETIVO + " = D." + PerspectivaDAOJDBC.ID_OBJETIVO_REL +" AND ");
		sql.append(" D." + PerspectivaDAOJDBC.ID_PERSPECTIVA_REL + " = C." + PerspectivaDAOJDBC.ID_PERSPECTIVA +" AND ");
		sql.append(" C." + PerspectivaDAOJDBC.ID_PERSPECTIVA + " = B." + RelacionamentosDAOJDBC.BSCIDPERS +" AND ");
		sql.append(" B." + RelacionamentosDAOJDBC.BSCIDBSC + " = A." + MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO);
		
		PreparedStatement stmt;
		ResultSet result;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			stmt.setInt(1,objetivoTO.getId());
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
