/*
 * Created on 15/02/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package br.com.intraBSC.persistencia.JDBC;



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

import br.com.intraBSC.excecoes.ExceptionPersistenciaBSC;
import br.com.intraBSC.modelo.IndicadorTO;
import br.com.intraBSC.modelo.MapaEstrategicoTO;
import br.com.intraBSC.modelo.ObjetivoTO;
import br.com.intraBSC.modelo.PerspectivaTO;
import br.com.intraBSC.persistencia.BscDaoJDBCGenerico;
import br.com.intraBSC.persistencia.MapaEstrategicoDAO;

/**
 * @author Tiago
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class MapaEstrategicoDAOJDBC extends BscDaoJDBCGenerico implements MapaEstrategicoDAO{
        
    public MapaEstrategicoDAOJDBC(DaoManager daoManager) {
        super(daoManager);
    }
    private static Log log = LogFactory.getLog(MapaEstrategicoDAOJDBC.class);
    
    protected static final String TABELA = "BSC";
    protected static final String ID_MAPA_ESTRATEGICO = "ID";
    protected static final String NOME_MAPA_ESTRATEGICO = "NAME";  
    protected static final String ATIVO = "ACTIVE";
    protected static final String ID_RESPONSAVEL = "ID_OWNER";
    protected static final String MISSAO = "MISSION";  
    protected static final String VISAO = "VISION";
    protected static final String FATORES_SUCESSO = "SUCCESS";
    
    
    /*Variaveis de Relacionamento de Mapa com Perspectiva*/
    protected static final String TABELA_RELBSC = "RELBSC";
    protected static final String ID_MAPA_ESTRATEGICO_REL = "BSC_ID";
    protected static final String ID_PERSPECTIVA_REL = "PERSPECTIVE_ID";
    
    /*Variaveis de Relacionamento de Perspectiva com Objetivo*/
    protected static final String TABELA_RELPERSPECTIVA = "RELPERSPECTIVE";
    protected static final String TABELA_OBJETIVO = "OBJECTIVE";
    protected static final String TABELA_INDICADOR = "MEASURE";
    protected static final String ID_OBJETIVO_REL = "OBJECTIVE_ID";
    
    
    /*Variaveis referentes a tabela de relacionamento de Mapa com Responsavel.*/
    //protected static final String TABELA_REL_RESPONSAVEL = "relbscowner";
    
    
    
	private Connection getconexao(){
		return getConnection();			
	}

	@SuppressWarnings("unchecked")
	public Collection consultarVarios(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT DISTINCT ");
		sql.append("A." + ID_MAPA_ESTRATEGICO + ", ");
		sql.append("A." + ATIVO + ", ");
		sql.append("A." + NOME_MAPA_ESTRATEGICO + ", ");
		sql.append("A." + ID_RESPONSAVEL + ", ");
		sql.append("A." + MISSAO + ", ");
		sql.append("A." + VISAO + ", ");
		sql.append("A." + FATORES_SUCESSO + " ");
		sql.append("FROM " + TABELA + " A ");
		sql.append("WHERE 1=1 ");
		sql.append(" AND A." + ID_RESPONSAVEL + " = ? ");
		
		
		if (mapaEstrategicoTO.getId() != 0){
			sql.append(" AND A." + ID_MAPA_ESTRATEGICO + " =? ");
		}
		if (mapaEstrategicoTO.getAtivo() != 0){
			sql.append(" AND A." + ATIVO + " =? ");
		}
		
		sql.append(" AND UCASE(A." + NOME_MAPA_ESTRATEGICO + ") LIKE ? ");
		
		sql.append(" ORDER BY "+ NOME_MAPA_ESTRATEGICO);
		
		PreparedStatement stmt;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			int i = 0;
			
			stmt.setInt(++i,mapaEstrategicoTO.getIdResponsavel());
			
			if (mapaEstrategicoTO.getId() != 0){
				stmt.setInt(++i,mapaEstrategicoTO.getId());
			}
			
			if (mapaEstrategicoTO.getAtivo() != 0){
				stmt.setInt(++i,mapaEstrategicoTO.getAtivo());
			}
			
			stmt.setString(++i,"%" + mapaEstrategicoTO.getNome().toUpperCase() + "%");
						
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

	public MapaEstrategicoTO consultarUm(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + ID_MAPA_ESTRATEGICO + ", ");
        sql.append("A." + ATIVO + ", ");
        sql.append("A." + NOME_MAPA_ESTRATEGICO + ", ");
        sql.append("A." + ID_RESPONSAVEL + ", ");
        sql.append("A." + MISSAO + ", ");
		sql.append("A." + VISAO + ", ");
		sql.append("A." + FATORES_SUCESSO + " ");
        sql.append("FROM " + TABELA + " A ");
        sql.append(" WHERE 1=1 ");

        if (mapaEstrategicoTO.getId() != 0){
            sql.append(" AND A." + ID_MAPA_ESTRATEGICO + " =? ");
        }
        if ((mapaEstrategicoTO.getNome() != null) && (!mapaEstrategicoTO.getNome().equals("")) ){
            sql.append(" AND A." + NOME_MAPA_ESTRATEGICO + " LIKE? ");
        }
        PreparedStatement stmt;
        try {
			 stmt = getconexao().prepareStatement(sql.toString());
        int i = 0;
        if (mapaEstrategicoTO.getId() != 0){
            stmt.setInt(++i,mapaEstrategicoTO.getId());
        }
        if ((mapaEstrategicoTO.getNome() != null) && (!mapaEstrategicoTO.getNome().equals("")) ){
           stmt.setString(++i,"%"+ mapaEstrategicoTO.getNome()+"%");
        }

             ResultSet resultado = stmt.executeQuery();
             MapaEstrategicoTO retorno = new MapaEstrategicoTO();
             while (resultado.next()) {
                  retorno = carregaTOConsulta(resultado);
             }
             return retorno;
        } catch (Exception e) {
              log.error(e.getMessage());
              throw new DaoException(e.getMessage());
        }
	}

	// retorna o ID do mapa no qual pertence uma perspectiva, objetivo ou indicador
	
	public MapaEstrategicoTO consultarIdMapa(PerspectivaTO perspectivaTO, ObjetivoTO objetivoTO, IndicadorTO indicadorTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT DISTINCT ");
		sql.append("A." + ID_MAPA_ESTRATEGICO);
		sql.append(" FROM ");
		sql.append(TABELA + " A LEFT JOIN " + TABELA_RELBSC + " B ON (A.");
		sql.append(MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO +" = B."+MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO_REL+") ");
		
		sql.append(" LEFT JOIN "+ PerspectivaDAOJDBC.TABELA +" C ON (B.");
		sql.append(PerspectivaDAOJDBC.ID_PERSPECTIVA_REL+" = C."+PerspectivaDAOJDBC.ID_PERSPECTIVA+") ");
		
		sql.append(" LEFT JOIN "+ PerspectivaDAOJDBC.TABELA_REL +" D ON (C.");
		sql.append(PerspectivaDAOJDBC.ID_PERSPECTIVA+" = D."+PerspectivaDAOJDBC.ID_PERSPECTIVA_REL+") ");
		
		
		sql.append(" LEFT JOIN "+ ObjetivoDAOJDBC.TABELA +" E ON (D.");
		sql.append(PerspectivaDAOJDBC.ID_OBJETIVO_REL+" = E."+ObjetivoDAOJDBC.ID_OBJETIVO+") ");
		
		sql.append(" LEFT JOIN "+ IndicadorDAOJDBC.TABELA +" F ON (E.");
		sql.append(ObjetivoDAOJDBC.ID_OBJETIVO+" = F."+IndicadorDAOJDBC.ID_OBJETIVO+") ");
						
		sql.append("WHERE 1=1 ");
		
	
        if (perspectivaTO.getId() != 0){
            sql.append(" AND C." + PerspectivaDAOJDBC.ID_PERSPECTIVA + " =? ");
        }
        if (objetivoTO.getId() != 0){
            sql.append(" AND E." + ObjetivoDAOJDBC.ID_OBJETIVO + " =? ");
        }
        if (indicadorTO.getId() != 0){
            sql.append(" AND F." + IndicadorDAOJDBC.ID_INDICADOR + " =? ");
        }
        PreparedStatement stmt;
        try {
			 stmt = getconexao().prepareStatement(sql.toString());
        int i = 0;
        if (perspectivaTO.getId() != 0){
        	stmt.setInt(++i,perspectivaTO.getId());
        }
        if (objetivoTO.getId() != 0){
        	stmt.setInt(++i,objetivoTO.getId());
        }
        if (indicadorTO.getId() != 0){
        	stmt.setInt(++i,indicadorTO.getId());
        }
        
        ResultSet resultado = stmt.executeQuery();
             MapaEstrategicoTO retorno = new MapaEstrategicoTO();
             while (resultado.next()) {
            	 int j = 0;
            	 retorno.setId(resultado.getInt(++j));
             }
             return retorno;
        } catch (Exception e) {
              log.error(e.getMessage());
              throw new DaoException(e.getMessage());
        }
	}

	
	public void incluirXml(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("INSERT INTO ");
        sql.append(TABELA + "(");
        sql.append( ID_MAPA_ESTRATEGICO+", ");
        sql.append( ATIVO+", ");
        sql.append( ID_RESPONSAVEL+", ");
        sql.append( NOME_MAPA_ESTRATEGICO+" ");
        sql.append(") VALUES (?,?,?,?)");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        if (mapaEstrategicoTO.getId() != 0){
	            stmt.setInt(++i,mapaEstrategicoTO.getId());
	        }
	        if (mapaEstrategicoTO.getAtivo() != 0){
	            stmt.setInt(++i,mapaEstrategicoTO.getAtivo());
	        }
	        if (mapaEstrategicoTO.getIdResponsavel() != 0){
	            stmt.setInt(++i,mapaEstrategicoTO.getIdResponsavel());
	        }
	        if ((mapaEstrategicoTO.getNome() != null) && (!mapaEstrategicoTO.getNome().equals("")) ){
	           stmt.setString(++i,mapaEstrategicoTO.getNome().trim());
	        }
            stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
		
	}
	
	public void incluir(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("INSERT INTO ");
        sql.append(TABELA + "(");
        sql.append( ID_MAPA_ESTRATEGICO+", ");
        sql.append( ATIVO+", ");
        sql.append( ID_RESPONSAVEL+", ");
        sql.append( MISSAO + ", ");
		sql.append( VISAO + ", ");
		sql.append( FATORES_SUCESSO + ", ");
        sql.append( NOME_MAPA_ESTRATEGICO+" ");
        sql.append(") VALUES (?,?,?,?,?,?,?)");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        if (mapaEstrategicoTO.getId() != 0){
	            stmt.setInt(++i,mapaEstrategicoTO.getId());
	        }
	        if (mapaEstrategicoTO.getAtivo() != 0){
	            stmt.setInt(++i,mapaEstrategicoTO.getAtivo());
	        }
	        if (mapaEstrategicoTO.getIdResponsavel() != 0){
	            stmt.setInt(++i,mapaEstrategicoTO.getIdResponsavel());
	        }
	        if ((mapaEstrategicoTO.getMissao() != null)&& (!mapaEstrategicoTO.getMissao().equals(""))){
	            stmt.setString(++i,mapaEstrategicoTO.getMissao());
	        }
	        if ((mapaEstrategicoTO.getVisao() != null)&& (!mapaEstrategicoTO.getVisao().equals(""))){
	            stmt.setString(++i,mapaEstrategicoTO.getVisao());
	        }
	        if ((mapaEstrategicoTO.getFatoresSucesso() != null) && (!mapaEstrategicoTO.getFatoresSucesso().equals(""))){
	            stmt.setString(++i,mapaEstrategicoTO.getFatoresSucesso());
	        }
	        if ((mapaEstrategicoTO.getNome() != null) && (!mapaEstrategicoTO.getNome().equals("")) ){
	           stmt.setString(++i,mapaEstrategicoTO.getNome().trim());
	        }

            stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
		
	}

	public void alterar(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("UPDATE ");
        sql.append(TABELA + " SET ");
        sql.append( NOME_MAPA_ESTRATEGICO + " = ?, ");
        sql.append( ID_RESPONSAVEL + " = ?, ");
        sql.append( MISSAO + " = ?, ");
		sql.append( VISAO + " = ?, ");
		sql.append( FATORES_SUCESSO + " = ?, ");
        sql.append( ATIVO + " = ? ");
        sql.append(" WHERE 1=1 ");
        sql.append("AND " + ID_MAPA_ESTRATEGICO + " = ? ");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        if ((mapaEstrategicoTO.getNome() != null) && (!mapaEstrategicoTO.getNome().equals("")) ){
	           stmt.setString(++i,mapaEstrategicoTO.getNome());
	        }
	        if (mapaEstrategicoTO.getIdResponsavel() != 0){
	            stmt.setInt(++i,mapaEstrategicoTO.getIdResponsavel());
	        }
	        if (mapaEstrategicoTO.getMissao() != null && !mapaEstrategicoTO.getMissao().equals("")){
	            stmt.setString(++i,mapaEstrategicoTO.getMissao());
	        }
	        if (mapaEstrategicoTO.getVisao() != null && !mapaEstrategicoTO.getVisao().equals("")){
	            stmt.setString(++i,mapaEstrategicoTO.getVisao());
	        }
	        if (mapaEstrategicoTO.getFatoresSucesso() != null && !mapaEstrategicoTO.getFatoresSucesso().equals("")){
	            stmt.setString(++i,mapaEstrategicoTO.getFatoresSucesso());
	        }
	        if (mapaEstrategicoTO.getAtivo() != 0){
	            stmt.setInt(++i,mapaEstrategicoTO.getAtivo());
	        }
	        if (mapaEstrategicoTO.getId() != 0){
	            stmt.setInt(++i,mapaEstrategicoTO.getId());
	        }
            stmt.executeUpdate();
         } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
         }
	}

	public void excluir(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("DELETE FROM ");
        sql.append(TABELA);
        sql.append(" WHERE 1=1 ");
        if (mapaEstrategicoTO.getId() != 0){
            sql.append(" AND " + mapaEstrategicoTO.getId()+ " =? ");
        }
        PreparedStatement stmt;
        try {
             int i = 0;
             stmt = getconexao().prepareStatement(sql.toString());
             if (mapaEstrategicoTO.getId() != 0){
                   stmt.setInt(++i,mapaEstrategicoTO.getId());
             }
             stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }		
	}

	private MapaEstrategicoTO carregaTO(ResultSet resultado) throws SQLException{
		MapaEstrategicoTO mapaEstrategicoTO = new MapaEstrategicoTO();
		int i = 0;
		mapaEstrategicoTO.setId(resultado.getInt(++i));
		mapaEstrategicoTO.setAtivo(resultado.getInt(++i));
		mapaEstrategicoTO.setNome(resultado.getString(++i));
		return mapaEstrategicoTO;
	}
	
	private MapaEstrategicoTO carregaTOConsulta(ResultSet resultado) throws SQLException{
		MapaEstrategicoTO mapaEstrategicoTO = new MapaEstrategicoTO();
		int i = 0;
		mapaEstrategicoTO.setId(resultado.getInt(++i));
		mapaEstrategicoTO.setAtivo(resultado.getInt(++i));
		mapaEstrategicoTO.setNome(resultado.getString(++i));
		mapaEstrategicoTO.setIdResponsavel(resultado.getInt(++i));
		mapaEstrategicoTO.setMissao(resultado.getString(++i));
		mapaEstrategicoTO.setVisao(resultado.getString(++i));
		mapaEstrategicoTO.setFatoresSucesso(resultado.getString(++i));
		return mapaEstrategicoTO;
	}

	@SuppressWarnings("unchecked")
	public Collection consultarMapaUsuario(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer();		 
		/*sql.append("SELECT DISTINCT ");
		sql.append("A." + ID_MAPA_ESTRATEGICO + ", ");
		sql.append("A." + ATIVO + ", ");
		sql.append("A." + NOME_MAPA_ESTRATEGICO + " ");		
		sql.append("FROM " + TABELA + " A, " + TABELA_RELBSC + " B, " + PerspectivaDAOJDBC.TABELA + " C, ");
		sql.append(UsuarioDAOJDBC.TABELA + " D, " + TABELA_RELPERSPECTIVA + " E," + TABELA_OBJETIVO + " F," );
		sql.append(TABELA_INDICADOR + " G " );
		sql.append("WHERE 1=1 ");		
		sql.append(" AND A." + ID_MAPA_ESTRATEGICO + " = " + "B."+ ID_MAPA_ESTRATEGICO_REL);
		sql.append(" AND B." + ID_PERSPECTIVA_REL + " = " + "C."+ PerspectivaDAOJDBC.ID_PERSPECTIVA);
		sql.append(" AND C." + PerspectivaDAOJDBC.ID_PERSPECTIVA + " = " + "E."+ PerspectivaDAOJDBC.ID_PERSPECTIVA_REL);
		sql.append(" AND E." + ID_OBJETIVO_REL + " = " + "F."+ ObjetivoDAOJDBC.ID_OBJETIVO);
		sql.append(" AND G." + ID_OBJETIVO_REL + " = " + "F."+ ObjetivoDAOJDBC.ID_OBJETIVO);
		
		sql.append(" AND (C." + PerspectivaDAOJDBC.USUARIO_PERSPECTIVA + " = " + "? ");
		sql.append(" OR F." + ObjetivoDAOJDBC.USUARIO_OBJETIVO + " = " + "? ");
		sql.append(" OR G." + IndicadorDAOJDBC.RESPONSAVEL + " = " + "? )");
	*/
		sql.append("SELECT DISTINCT ");
		sql.append("A." + ID_MAPA_ESTRATEGICO + ", ");
		sql.append("A." + ATIVO + ", ");
		sql.append("A." + NOME_MAPA_ESTRATEGICO);	
		sql.append(" FROM ");
		sql.append(TABELA + " A LEFT JOIN " + TABELA_RELBSC + " B ON (A.");
		sql.append(MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO +" = B."+MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO_REL+") ");
		
		sql.append(" LEFT JOIN "+ PerspectivaDAOJDBC.TABELA +" C ON (B.");
		sql.append(PerspectivaDAOJDBC.ID_PERSPECTIVA_REL+" = C."+PerspectivaDAOJDBC.ID_PERSPECTIVA+") ");
		
		sql.append(" LEFT JOIN "+ PerspectivaDAOJDBC.TABELA_REL +" D ON (C.");
		sql.append(PerspectivaDAOJDBC.ID_PERSPECTIVA+" = D."+PerspectivaDAOJDBC.ID_PERSPECTIVA_REL+") ");
		
		
		sql.append(" LEFT JOIN "+ ObjetivoDAOJDBC.TABELA +" E ON (D.");
		sql.append(PerspectivaDAOJDBC.ID_OBJETIVO_REL+" = E."+ObjetivoDAOJDBC.ID_OBJETIVO+") ");
		
		sql.append(" LEFT JOIN "+ IndicadorDAOJDBC.TABELA +" F ON (E.");
		sql.append(ObjetivoDAOJDBC.ID_OBJETIVO+" = F."+IndicadorDAOJDBC.ID_OBJETIVO+") ");
		
		sql.append(", "+UsuarioDAOJDBC.TABELA+" Z ");
		
		sql.append("WHERE 1=1 AND");
		sql.append(" Z."+UsuarioDAOJDBC.ID_USUARIO+" = ? AND  ");
		sql.append(" (A."+ID_RESPONSAVEL+" = Z."+UsuarioDAOJDBC.ID_USUARIO+" OR ");
		sql.append(" C."+PerspectivaDAOJDBC.USUARIO_PERSPECTIVA+" = Z."+UsuarioDAOJDBC.ID_USUARIO+" OR ");
		sql.append(" E."+ObjetivoDAOJDBC.USUARIO_OBJETIVO+" = Z."+UsuarioDAOJDBC.ID_USUARIO+" OR ");
		sql.append(" F."+IndicadorDAOJDBC.RESPONSAVEL+" = Z."+UsuarioDAOJDBC.ID_USUARIO + ")");
		
		if (mapaEstrategicoTO.getAtivo() != 0){
			sql.append(" AND A." + ATIVO + " =? ");
		}
		sql.append(" ORDER BY A." + NOME_MAPA_ESTRATEGICO);
		PreparedStatement stmt;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			int i = 0;
			
			stmt.setInt(++i,mapaEstrategicoTO.getIdUsuario());
			
			if (mapaEstrategicoTO.getAtivo() != 0){
				stmt.setInt(++i,mapaEstrategicoTO.getAtivo());
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
	public JasperPrint mapaEstrategicoRelatorioDetalha(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionPersistenciaBSC {
		try {
			Map parameters = new HashMap();
			//Parametros do relatorio
	        Locale locale = new Locale("pt" , "BR");
			parameters.put(JRParameter.REPORT_LOCALE, locale);
			parameters.put("bsc", new Integer(mapaEstrategicoTO.getId()));
			parameters.put("baseDir", mapaEstrategicoTO.getBaseDir());	
			JasperPrint relatorioFinal = JasperFillManager.fillReport(mapaEstrategicoTO.getJasperReport(),parameters, getconexao());
			return relatorioFinal;
		} catch (JRException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaBSC(e.getMessage());
		}
		
	}

	
	
	public int consultarMax(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer("SELECT MAX(");
		sql.append(ID_MAPA_ESTRATEGICO);
		sql.append(") AS ");
		sql.append(ID_MAPA_ESTRATEGICO);
		sql.append(" FROM ");
		sql.append(TABELA);
		PreparedStatement stmt;
		ResultSet result;		
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			result = stmt.executeQuery();
			while (result.next()) {
				return result.getInt(ID_MAPA_ESTRATEGICO) + 1;
			}			
		} 
		catch (SQLException e) {
		    log.error(e.getMessage());
			throw new ExceptionPersistenciaBSC(e.getMessage());
		}		
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	public Collection consultarArvoreConfiguracao(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		
		sql.append("A."+ MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO +", A."+MapaEstrategicoDAOJDBC.NOME_MAPA_ESTRATEGICO+",");
		sql.append("C."+PerspectivaDAOJDBC.ID_PERSPECTIVA+", C."+ PerspectivaDAOJDBC.NOME_PERSPECTIVA+",");
		sql.append("E."+ObjetivoDAOJDBC.COLUNA+",");
		sql.append("E."+ObjetivoDAOJDBC.ID_OBJETIVO+", E."+ObjetivoDAOJDBC.NOME_OBJETIVO+",");
		sql.append("F."+ IndicadorDAOJDBC.ID_INDICADOR+", F."+IndicadorDAOJDBC.NOME_INDICADOR+",");
		
		sql.append("B."+ MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO_REL+", B."+ MapaEstrategicoDAOJDBC.ID_PERSPECTIVA_REL +",");
		sql.append(" C."+PerspectivaDAOJDBC.ORDEM_PERSPECTIVA+",");
		sql.append("D."+PerspectivaDAOJDBC.ID_OBJETIVO_REL +", D."+PerspectivaDAOJDBC.ID_PERSPECTIVA_REL+", ");
		
		sql.append(" C."+PerspectivaDAOJDBC.ATIVO+",");
		sql.append(" E."+ObjetivoDAOJDBC.ATIVO+",");
		sql.append(" F."+IndicadorDAOJDBC.ATIVO+", ");
		sql.append(" A."+ATIVO+" ");
		
		sql.append(" FROM " + MapaEstrategicoDAOJDBC.TABELA + " A LEFT JOIN " + MapaEstrategicoDAOJDBC.TABELA_RELBSC + " B  ON (A.ID = B.BSC_ID) ");
		sql.append(" LEFT JOIN "+ PerspectivaDAOJDBC.TABELA + " C ON (B.PERSPECTIVE_ID = C.ID)");
		sql.append(" LEFT JOIN " + PerspectivaDAOJDBC.TABELA_REL + " D ON (D.PERSPECTIVE_ID = C.ID)");
		sql.append(" LEFT JOIN " + ObjetivoDAOJDBC.TABELA + " E ON (E.ID = D.OBJECTIVE_ID)");
		sql.append(" LEFT JOIN " + IndicadorDAOJDBC.TABELA + " F ON (F.OBJECTIVE_ID = E.ID)");
		sql.append(" WHERE 1=1 ");
		
		if (mapaEstrategicoTO.getId() != 0){
			sql.append(" AND A."+ MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO  +" = ?");
		}
		
		sql.append(" ORDER BY C.SORTORDER,E.COL,D.OBJECTIVE_ID,D.PERSPECTIVE_ID");
		PreparedStatement stmt;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			int i = 0;
			
			if (mapaEstrategicoTO.getId() != 0){
				stmt.setInt(++i,mapaEstrategicoTO.getId());
			}			

			
			ResultSet resultado = stmt.executeQuery();
			Collection retorno = new ArrayList();
			while (resultado.next()) {
				MapaEstrategicoTO mapaEstrategicoTOReturn = new MapaEstrategicoTO();
				int j = 0;
				mapaEstrategicoTOReturn.setId(resultado.getInt(++j));
				mapaEstrategicoTOReturn.setNome(resultado.getString(++j));
                mapaEstrategicoTOReturn.setIdPerspectiva(resultado.getInt(++j));
				mapaEstrategicoTOReturn.setNomePerspectiva(resultado.getString(++j));
				mapaEstrategicoTOReturn.setColuna(resultado.getInt(++j));
				mapaEstrategicoTOReturn.setIdObjetivo(resultado.getInt(++j));
				mapaEstrategicoTOReturn.setNomeObjetivo(resultado.getString(++j));
				mapaEstrategicoTOReturn.setIdIndicador(resultado.getInt(++j));
				mapaEstrategicoTOReturn.setNomeIndicador(resultado.getString(++j));
				mapaEstrategicoTOReturn.setAtivoPers(resultado.getInt(15));
				mapaEstrategicoTOReturn.setAtivoObj(resultado.getInt(16));
				mapaEstrategicoTOReturn.setAtivoInd(resultado.getInt(17));
				mapaEstrategicoTOReturn.setAtivo(resultado.getInt(18));
				
				retorno.add(mapaEstrategicoTOReturn);
			}
			return retorno;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DaoException(e.getMessage());
		}
	}	
	
	public MapaEstrategicoTO contarPerspectivas(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer("SELECT distinct A.");
		sql.append(MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO + ",");
		sql.append(" COUNT(DISTINCT C." + PerspectivaDAOJDBC.ID_PERSPECTIVA + ")");
		sql.append(" FROM ");
		sql.append(MapaEstrategicoDAOJDBC.TABELA + " A ");
		sql.append(" LEFT OUTER JOIN ");
		sql.append(RelacionamentosDAOJDBC.TABELA  + " B ");
		sql.append(" ON B."+ RelacionamentosDAOJDBC.BSCIDBSC + " = A." + MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO );
		sql.append(" LEFT OUTER JOIN ");
		sql.append(PerspectivaDAOJDBC.TABELA + " C ");
		sql.append(" ON C."+ PerspectivaDAOJDBC.ID_PERSPECTIVA + " = B." + RelacionamentosDAOJDBC.BSCIDPERS );
		sql.append(" AND C." + PerspectivaDAOJDBC.ATIVO + "= 1");
		sql.append(" LEFT OUTER JOIN ");
		sql.append(RelacionamentosDAOJDBC.TABELA_PERSPECTIVE + " D ");
		sql.append(" ON D."+ RelacionamentosDAOJDBC.BSCIDPERS + " = C." + PerspectivaDAOJDBC.ID_PERSPECTIVA );
		sql.append(" WHERE A." + MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO + " = ?");
		sql.append(" GROUP BY A." + MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO);
			
		PreparedStatement stmt;
		ResultSet result;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			stmt.setInt(1,mapaEstrategicoTO.getId());
			result = stmt.executeQuery();
			while (result.next()) {
				mapaEstrategicoTO.setNumPerspectivas(result.getInt(2));
				return mapaEstrategicoTO;
			}
		}
		catch (SQLException e) {
		    log.error(e.getMessage());
			throw new ExceptionPersistenciaBSC(e.getMessage());
		}		
		return null;
	}
	private MapaEstrategicoTO carregaObjetivos(ResultSet resultado) throws SQLException{
		MapaEstrategicoTO mapaEstrategicoTO = new MapaEstrategicoTO();
		int i = 0;
		mapaEstrategicoTO.setId(resultado.getInt(++i));
		mapaEstrategicoTO.setIdPerspectiva(resultado.getInt(++i));
		mapaEstrategicoTO.setNumObjetivos(resultado.getInt(++i));
		return mapaEstrategicoTO;
	}	
	
	@SuppressWarnings("unchecked")
	public Collection contarObjetivos(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer("SELECT distinct A.");
		sql.append(MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO + ", C.");
		sql.append(PerspectivaDAOJDBC.ID_PERSPECTIVA + ",");
		sql.append(" COUNT(DISTINCT E." + ObjetivoDAOJDBC.ID_OBJETIVO + ")");
		sql.append(" FROM ");
		sql.append(MapaEstrategicoDAOJDBC.TABELA + " A ");
		sql.append(" INNER JOIN ");
		sql.append(RelacionamentosDAOJDBC.TABELA  + " B ");
		sql.append(" ON B."+ RelacionamentosDAOJDBC.BSCIDBSC + " = A." + MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO );
		sql.append(" INNER JOIN ");
		sql.append(PerspectivaDAOJDBC.TABELA + " C ");
		sql.append(" ON C."+ PerspectivaDAOJDBC.ID_PERSPECTIVA + " = B." + RelacionamentosDAOJDBC.BSCIDPERS );
		sql.append(" AND C." + PerspectivaDAOJDBC.ATIVO + "= 1");
		sql.append(" LEFT OUTER JOIN ");
		sql.append(RelacionamentosDAOJDBC.TABELA_PERSPECTIVE + " D ");
		sql.append(" ON D."+ RelacionamentosDAOJDBC.BSCIDPERS + " = C." + PerspectivaDAOJDBC.ID_PERSPECTIVA );
		sql.append(" LEFT OUTER JOIN ");
		sql.append(ObjetivoDAOJDBC.TABELA + " E ");
		sql.append(" ON E."+ ObjetivoDAOJDBC.ID_OBJETIVO + " = D." + RelacionamentosDAOJDBC.OBJIDOBJ );
		sql.append(" AND E." + ObjetivoDAOJDBC.ATIVO + "= 1");
		sql.append(" WHERE A." + MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO + " = ?");
		sql.append(" GROUP BY A." + MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO + ", C." + PerspectivaDAOJDBC.ORDEM_PERSPECTIVA);
			
		PreparedStatement stmt;
		ResultSet result;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			stmt.setInt(1,mapaEstrategicoTO.getId());
			result = stmt.executeQuery();
		
			Collection retorno = new ArrayList();
			while (result.next()) {
				retorno.add(carregaObjetivos(result));
			}
			return retorno;
				}
		catch (SQLException e) {
		    log.error(e.getMessage());
			throw new ExceptionPersistenciaBSC(e.getMessage());
		}		
	}

}