

package br.com.intraBSC.persistencia.JDBC;

import br.com.intraBSC.excecoes.ExceptionPersistenciaBSC;
import br.com.intraBSC.modelo.IndicadorTO;
import br.com.intraBSC.persistencia.BscDaoJDBCGenerico;
import br.com.intraBSC.persistencia.IndicadorDAO;

import java.sql.Connection;
import java.sql.Date;
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
public class IndicadorDAOJDBC extends BscDaoJDBCGenerico implements IndicadorDAO {   
   
	
	private static Log log = LogFactory.getLog(IndicadorDAOJDBC.class);
    
    protected static final String TABELA = "MEASURE";
    protected static final String ID_INDICADOR = "ID";
    protected static final String ID_OBJETIVO = "OBJECTIVE_ID";
    protected static final String RESPONSAVEL = "OWNER_ID";
    protected static final String NOME_INDICADOR = "NAME";
    protected static final String DESCRICAO = "DESCRIPTION";
    protected static final String PERIODICIDADE = "UPDATEFREQUENCY";
    protected static final String UNIDADE = "UNITS";
    protected static final String ATIVO = "ACTIVE";
    protected static final String ULTIMA_DATA = "LAST_DATE"; 
  
    
    /*variavel utilizada para entidade de MEASUREDIMENSION*/
    protected static final String TABELA_DIMENSAO = "MEASUREDIMENSION";
    protected static final String ID_INDICADOR_DIMENSAO = "ID";

	public IndicadorDAOJDBC(DaoManager daoManager) {
		super(daoManager);		
	}

	private Connection getconexao(){
		return getConnection();			
	}
	
	/*Consulta Utilizada para a ferramente de visualizacao, este metodo monta a arvore*/
	@SuppressWarnings("unchecked")
	public Collection consultarArvoreVisualizacao(IndicadorTO indicadorTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("F." + ID_INDICADOR + ", ");
		sql.append("F." + NOME_INDICADOR + ", ");
		sql.append("F." + ID_OBJETIVO + ", ");
		sql.append("F." + RESPONSAVEL + ", ");
		sql.append("F." + DESCRICAO + ", ");
		sql.append("F." + PERIODICIDADE + ", ");
		sql.append("F." + UNIDADE + ", ");
		sql.append("F." + ATIVO + ", ");
		sql.append("A." + MapaEstrategicoDAOJDBC.NOME_MAPA_ESTRATEGICO + ", ");
		sql.append("A." + MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO + ", ");
		sql.append("C." + PerspectivaDAOJDBC.NOME_PERSPECTIVA + ", ");
		sql.append("C." + PerspectivaDAOJDBC.ID_PERSPECTIVA + ", ");
		sql.append("E." + ObjetivoDAOJDBC.NOME_OBJETIVO + " ");
		sql.append("FROM " + MapaEstrategicoDAOJDBC.TABELA + " A, " + MapaEstrategicoDAOJDBC.TABELA_RELBSC + " B, ");
		sql.append(PerspectivaDAOJDBC.TABELA + " C, " + PerspectivaDAOJDBC.TABELA_REL + " D, ");		
		sql.append(ObjetivoDAOJDBC.TABELA + " E, " + TABELA + " F ");
		sql.append("WHERE 1=1 ");
		
		if (indicadorTO.getIdMapa() != 0){
			sql.append(" AND A." + MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO + " = ? ");
			sql.append(" AND A." + MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO + " = B." + MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO_REL);
			sql.append(" AND B." + MapaEstrategicoDAOJDBC.ID_PERSPECTIVA_REL + " = C." + PerspectivaDAOJDBC.ID_PERSPECTIVA);
			sql.append(" AND C." + PerspectivaDAOJDBC.ID_PERSPECTIVA + " = D." + PerspectivaDAOJDBC.ID_PERSPECTIVA_REL);
			sql.append(" AND D." + PerspectivaDAOJDBC.ID_OBJETIVO_REL + " = E." + ObjetivoDAOJDBC.ID_OBJETIVO);
			sql.append(" AND E." + ObjetivoDAOJDBC.ID_OBJETIVO + " = F." + ID_OBJETIVO);
		}
		if (indicadorTO.getId() != 0){
			sql.append(" AND A." + ID_INDICADOR + " =? ");
		}
		if ((indicadorTO.getNome() != null) && (!indicadorTO.getNome().equals("")) ){
			sql.append(" AND UCASE(A." + NOME_INDICADOR + ") =? ");
		}
		if (indicadorTO.getIdObjetivo() != 0){
			sql.append(" AND A." + ID_OBJETIVO + " =? ");
		}
		if (indicadorTO.getResponsavelIndicador() != 0){
			sql.append(" AND A." + RESPONSAVEL + " =? ");
		}
		if (indicadorTO.getPeriodicidade() != 0){
			sql.append(" AND A." + PERIODICIDADE + " =? ");
		}
		if (indicadorTO.getUnidade() != 0){
			sql.append(" AND A." + UNIDADE + " =? ");
		}
		sql.append(" ORDER BY C.ID,F.OBJECTIVE_ID ");
		PreparedStatement stmt;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			int i = 0;
			
			if (indicadorTO.getIdMapa() != 0){
				stmt.setInt(++i,indicadorTO.getIdMapa());
			}			
			if (indicadorTO.getId() != 0){
				stmt.setInt(++i,indicadorTO.getId());
			}
			if ((indicadorTO.getNome() != null) && (!indicadorTO.getNome().equals("")) ){
				stmt.setString(++i,indicadorTO.getNome().toUpperCase());
			}
			if (indicadorTO.getIdObjetivo() != 0){
				stmt.setInt(++i,indicadorTO.getIdObjetivo());
			}
			if (indicadorTO.getResponsavelIndicador() != 0){
				stmt.setInt(++i,indicadorTO.getResponsavelIndicador());
			}
			if (indicadorTO.getPeriodicidade() != 0){
				stmt.setInt(++i,indicadorTO.getPeriodicidade());
			}
			if (indicadorTO.getUnidade() != 0){
				stmt.setInt(++i,indicadorTO.getUnidade());
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

	
	
	private IndicadorTO carregaTO(ResultSet resultado) throws SQLException{
		IndicadorTO indicadorTO = new IndicadorTO();
		int i = 0;
		indicadorTO.setId(resultado.getInt(++i));
		indicadorTO.setNome(resultado.getString(++i));
		indicadorTO.setIdObjetivo(resultado.getInt(++i));		
		indicadorTO.setResponsavelIndicador(resultado.getInt(++i));
		indicadorTO.setDescricao(resultado.getString(++i));
		indicadorTO.setPeriodicidade(resultado.getInt(++i));
		indicadorTO.setUnidade(resultado.getInt(++i));	
		indicadorTO.setAtivo(resultado.getInt(++i));	
		indicadorTO.setNomeMapa(resultado.getString(++i));
		indicadorTO.setIdMapa(resultado.getInt(++i));
		indicadorTO.setNomePerspectiva(resultado.getString(++i));
		indicadorTO.setIdPerspectiva(resultado.getInt(++i));
		indicadorTO.setNomeObjetivo(resultado.getString(++i));	
		return indicadorTO;
	}
	
	private IndicadorTO carregaMeusIndicadoresTO(ResultSet resultado) throws SQLException{
		IndicadorTO indicadorTO = new IndicadorTO();
		int i = 0;
		indicadorTO.setId(resultado.getInt(++i));
		indicadorTO.setIdMapa(resultado.getInt(++i));
		indicadorTO.setNomeMapa(resultado.getString(++i));
		indicadorTO.setResponsavelIndicador(resultado.getInt(++i));
		indicadorTO.setNomeResponsavel(resultado.getString(++i));
		indicadorTO.setOrdemPerspectiva(resultado.getInt(++i));
		indicadorTO.setIdPerspectiva(resultado.getInt(++i));
		indicadorTO.setNomePerspectiva(resultado.getString(++i));
		indicadorTO.setIdObjetivo(resultado.getInt(++i));
		indicadorTO.setNomeObjetivo(resultado.getString(++i));
		indicadorTO.setNome(resultado.getString(++i));
		indicadorTO.setDescricao(resultado.getString(++i));
		indicadorTO.setUltimoValor(resultado.getFloat(++i));
		indicadorTO.setUltimaData(resultado.getDate(++i));
		indicadorTO.setNomeUnidade(resultado.getString(++i));
		indicadorTO.setLimiteInferior(resultado.getFloat(++i));
		indicadorTO.setLimiteSuperior(resultado.getFloat(++i));	
		indicadorTO.setSinal(resultado.getInt(++i));
		indicadorTO.setInversaoLimite(resultado.getInt(++i));
		indicadorTO.setDesvio(resultado.getFloat(++i));
		return indicadorTO;
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	public JasperPrint indicadorRelatorioDetalha(IndicadorTO indicadorTO) throws ExceptionPersistenciaBSC{
		try {
			Map parameters = new HashMap();
			//Parametros do relatorio
	        Locale locale = new Locale("pt" , "BR");
			parameters.put(JRParameter.REPORT_LOCALE, locale);
			parameters.put("indicador", new Integer(indicadorTO.getId()));
			parameters.put("perspectiva", new Integer(indicadorTO.getIdPerspectiva()));
			parameters.put("bsc", new Integer(indicadorTO.getIdMapa()));
			parameters.put("baseDir", indicadorTO.getBaseDir());	
			JasperPrint relatorioFinal = JasperFillManager.fillReport(indicadorTO.getJasperReport(),parameters, getconexao());
			return relatorioFinal;
		} catch (JRException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaBSC(e.getMessage());
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public JasperPrint indicadorRelatorioDetalhaSemValor(IndicadorTO indicadorTO) throws ExceptionPersistenciaBSC{
		try {
			Map parameters = new HashMap();
			//Parametros do relatorio
	        Locale locale = new Locale("pt" , "BR");
			parameters.put(JRParameter.REPORT_LOCALE, locale);
			parameters.put("indicador", new Integer(indicadorTO.getId()));
			parameters.put("perspectiva", new Integer(indicadorTO.getIdPerspectiva()));
			parameters.put("bsc", new Integer(indicadorTO.getIdMapa()));
			parameters.put("baseDir", indicadorTO.getBaseDir());	
			JasperPrint relatorioFinal = JasperFillManager.fillReport(indicadorTO.getJasperReport(),parameters, getconexao());
			return relatorioFinal;
		} catch (JRException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaBSC(e.getMessage());
		}
		
	}

	@SuppressWarnings("unchecked")
	public JasperPrint meusIndicadoresRelatorioDetalha(IndicadorTO indicadorTO) throws ExceptionPersistenciaBSC{
		try {
			Map parameters = new HashMap();
			//Parametros do relatorio
	        Locale locale = new Locale("pt" , "BR");
			parameters.put(JRParameter.REPORT_LOCALE, locale);
			parameters.put("responsavel", new Integer(indicadorTO.getResponsavelIndicador()));
			parameters.put("baseDir", indicadorTO.getBaseDir());
			System.out.println(indicadorTO.getResponsavelIndicador());
			System.out.println(indicadorTO.getIdMapa());
			System.out.println(indicadorTO.getBaseDir());
			JasperPrint relatorioFinal = JasperFillManager.fillReport(indicadorTO.getJasperReport(),parameters, getconexao());
			return relatorioFinal;
		} catch (JRException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaBSC(e.getMessage());
		}
		
	}

	
	
	
	public IndicadorTO consultarUm(IndicadorTO indicadorTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + ID_INDICADOR + ", ");
        sql.append("A." + ID_OBJETIVO + ", ");
        sql.append("A." + RESPONSAVEL + ", ");
        sql.append("A." + NOME_INDICADOR + ", ");
        sql.append("A." + DESCRICAO + ", ");
        sql.append("A." + PERIODICIDADE + ", ");
        sql.append("A." + UNIDADE + ", ");
        sql.append("A." + ATIVO + " ");
        sql.append("FROM " + TABELA + " A ");
        sql.append("WHERE 1=1 ");

        if (indicadorTO.getId() != 0){
            sql.append(" AND A." + ID_INDICADOR + " =? ");
        }
        if (indicadorTO.getIdObjetivo() != 0){
            sql.append(" AND A." + ID_OBJETIVO + " =? ");
        }
        if ((indicadorTO.getResponsavelIndicador() != 0)){
            sql.append(" AND A." + RESPONSAVEL + " =? ");
        }
        if ((indicadorTO.getNome() != null) && (!indicadorTO.getNome().equals("")) ){
            sql.append(" AND UCASE(A." + NOME_INDICADOR + ") LIKE ? ");
        }
        if ((indicadorTO.getDescricao() != null) && (!indicadorTO.getDescricao().equals("")) ){
            sql.append(" AND UCASE(A." + DESCRICAO + ") LIKE ? ");
        }
        if (indicadorTO.getPeriodicidade() != 0){
            sql.append(" AND A." + PERIODICIDADE + " =? ");
        }
        if (indicadorTO.getUnidade() != 0){
            sql.append(" AND A." + UNIDADE + " =? ");
        }
        if ((indicadorTO.getAtivo() != 0)){
            sql.append(" AND A." + ATIVO + " = ? ");
        }

        PreparedStatement stmt;
        try {
			 stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        if (indicadorTO.getId() != 0){
	            stmt.setInt(++i,indicadorTO.getId());
	        }
	        if (indicadorTO.getIdObjetivo() != 0){
	            stmt.setInt(++i,indicadorTO.getIdObjetivo());
	        }
	        if ((indicadorTO.getResponsavelIndicador() != 0)){
	           stmt.setInt(++i,indicadorTO.getResponsavelIndicador());
	        }
	        if ((indicadorTO.getNome() != null) && (!indicadorTO.getNome().equals("")) ){
	           stmt.setString(++i,"%"+ indicadorTO.getNome().toUpperCase()+"%");
	        }
	        if ((indicadorTO.getDescricao() != null) && (!indicadorTO.getDescricao().equals("")) ){
	           stmt.setString(++i,"%"+ indicadorTO.getDescricao().toUpperCase()+"%");
	        }
	        if (indicadorTO.getPeriodicidade() != 0){
	            stmt.setInt(++i,indicadorTO.getPeriodicidade());
	        }
	        if (indicadorTO.getUnidade() != 0){
	            stmt.setInt(++i,indicadorTO.getUnidade());
	        }
	        if ((indicadorTO.getAtivo() != 0)){
	           stmt.setInt(++i,indicadorTO.getAtivo());
	        }        
        

             ResultSet resultado = stmt.executeQuery();
             IndicadorTO retorno = new IndicadorTO();
             while (resultado.next()) {
                  retorno = carregaTOConsutaUm(resultado);
             }
             return retorno;
        } catch (Exception e) {
              log.error(e.getMessage());
              throw new DaoException(e.getMessage());
        }
	}
	private IndicadorTO carregaTOConsutaUm(ResultSet resultado) throws SQLException{
		IndicadorTO indicadorTO = new IndicadorTO();
		int i = 0;
		indicadorTO.setId(resultado.getInt(++i));
		indicadorTO.setIdObjetivo(resultado.getInt(++i));
		indicadorTO.setResponsavelIndicador(resultado.getInt(++i));
		indicadorTO.setNome(resultado.getString(++i));
		indicadorTO.setDescricao(resultado.getString(++i));
		indicadorTO.setPeriodicidade(resultado.getInt(++i));
		indicadorTO.setUnidade(resultado.getInt(++i));
		indicadorTO.setAtivo(resultado.getInt(++i));
		return indicadorTO;
	}
	
	public int consultarMax(IndicadorTO indicadorTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer("SELECT MAX(");
		sql.append(ID_INDICADOR);
		sql.append(") AS ");
		sql.append(ID_INDICADOR);
		sql.append(" FROM ");
		sql.append(TABELA);
		PreparedStatement stmt;
		ResultSet result;		
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			result = stmt.executeQuery();
			while (result.next()) {
				return result.getInt(ID_INDICADOR) + 1;
			}
		}
		catch (SQLException e) {
		    log.error(e.getMessage());
			throw new ExceptionPersistenciaBSC(e.getMessage());
		}		
		return 0;
	}

	@SuppressWarnings("unchecked")
	public Collection consultarIndicadorUsuario(IndicadorTO indicadorTO) throws ExceptionPersistenciaBSC{
        StringBuffer sql = new StringBuffer();
       
        sql.append("SELECT "); 
       	sql.append("MEASURE.ID AS NUM, BSC.ID AS IDMAPA, ");
       	sql.append("BSC.NAME AS MAPA, OWNER.ID AS IDRESP, ");
       	sql.append("OWNER.NAME AS RESP, PERSPECTIVE.SORTORDER AS ORDEM, ");
       	sql.append("PERSPECTIVE.ID AS IDPERSPECTIVA, PERSPECTIVE.NAME AS PERSPECTIVA, ");
       	sql.append("OBJECTIVE.ID AS NUMOBJETIVO, OBJECTIVE.NAME AS OBJETIVO, ");
       	sql.append("MEASURE.NAME AS INDICADOR, MEASURE.DESCRIPTION AS DESCRICAO, ");
       	sql.append("MEASUREFACT.VALUE AS ULTIMOVALOR, MEASURE.LAST_DATE AS ULTIMADATA, ");
       	sql.append("UNID.NAME AS UNIDADE, TARGET.TARGETVALUEDOWN AS LIMITEINFERIOR, ");
       	sql.append("TARGET.TARGETVALUEUP AS LIMITESUPERIOR, ");
       	sql.append("CASE WHEN MEASUREFACT.VALUE < TARGET.TARGETVALUEDOWN THEN 0 ");
       	sql.append("WHEN MEASUREFACT.VALUE > TARGET.TARGETVALUEUP THEN 1 ");
       	sql.append("ELSE -1 END AS SINAL, TARGET.INVERT AS INVERSAOLIMITE, ");
       	sql.append("CASE WHEN TARGET.INVERT = 2 THEN ((MEASUREFACT.VALUE/TARGET.TARGETVALUEUP)-1) ");
       	sql.append("WHEN TARGET.INVERT = 1 THEN ((TARGET.TARGETVALUEDOWN/MEASUREFACT.VALUE)-1) END AS DESVIO ");        
       	sql.append("FROM  BSC ");
       	sql.append("LEFT OUTER JOIN RELBSC "); 
       	sql.append("ON RELBSC.BSC_ID = BSC.ID ");
       	sql.append("LEFT OUTER JOIN	OWNER ");
       	sql.append("ON  OWNER.ID = BSC.ID_OWNER AND BSC.ACTIVE = 1 ");
       	sql.append("LEFT OUTER JOIN	PERSPECTIVE ");
       	sql.append("ON  PERSPECTIVE.ID = RELBSC.PERSPECTIVE_ID AND PERSPECTIVE.ACTIVE = 1 ");
       	sql.append("LEFT OUTER JOIN	RELPERSPECTIVE ");
       	sql.append("ON PERSPECTIVE.ID = RELPERSPECTIVE.PERSPECTIVE_ID "); 
       	sql.append("LEFT OUTER JOIN	OBJECTIVE ");
       	sql.append("ON OBJECTIVE.ID = RELPERSPECTIVE.OBJECTIVE_ID AND OBJECTIVE.ACTIVE = 1 ");
       	sql.append("LEFT OUTER JOIN MEASURE ");
       	sql.append("ON MEASURE.OBJECTIVE_ID = OBJECTIVE.ID AND MEASURE.ACTIVE = 1 ");
       	sql.append("LEFT OUTER JOIN MEASUREFACT ");
       	sql.append("ON MEASUREFACT.ID_MEASURE = MEASURE.ID AND MEASUREFACT.DATE = MEASURE.LAST_DATE ");
       	sql.append("LEFT OUTER JOIN TARGET ");
       	sql.append("ON TARGET.MEASURE_ID = MEASURE.ID AND TARGET.ACTIVE = 1 ");
       	sql.append("LEFT OUTER JOIN UNIDADE AS UNID ");
       	sql.append("ON UNID.ID = MEASURE.UNITS ");
       	sql.append("WHERE 1=1 "); 
       	       	
        if (indicadorTO.getResponsavelIndicador()!= 0){
            sql.append("AND MEASURE.OWNER_ID =? ");
        }
        sql.append(" AND BSC.ACTIVE = 1 ");
        // Retirado para o HSQLDB sql.append("GROUP by perspective.sortorder,objective.id,measure.id ");
		sql.append("ORDER BY MEASURE.NAME,PERSPECTIVE.SORTORDER,OBJECTIVE.COL,OBJECTIVE.NAME ASC");
        
        PreparedStatement stmt;
        try {
          stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        if (indicadorTO.getResponsavelIndicador() != 0){
	            stmt.setInt(++i,indicadorTO.getResponsavelIndicador());
	        }
	        
             ResultSet resultado = stmt.executeQuery();
             IndicadorTO retorno = new IndicadorTO();
             Collection listaMeusIndicadores = new ArrayList();
             while (resultado.next()) {
                  retorno = carregaMeusIndicadoresTO(resultado);
                  listaMeusIndicadores.add(retorno);
             }
             return listaMeusIndicadores;
        } catch (Exception e) {
              log.error(e.getMessage());
              throw new DaoException(e.getMessage());
        }
    }
	
	
	
	@SuppressWarnings("unchecked")
	public Collection consultarVarios(IndicadorTO indicadorTO) throws ExceptionPersistenciaBSC{
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("A." + ID_INDICADOR + ", ");
        sql.append("A." + ID_OBJETIVO + ", ");
        sql.append("A." + NOME_INDICADOR + ", ");
        sql.append("A." + RESPONSAVEL + ", ");
        sql.append("A." + PERIODICIDADE + ", ");
        sql.append("A." + UNIDADE + ", ");
        sql.append("A." + DESCRICAO + ", ");
        sql.append("A." + ATIVO + " ");
        sql.append("FROM " + TABELA + " A ");
        sql.append("WHERE 1=1 ");

        if (indicadorTO.getId() != 0){
            sql.append(" AND A." + ID_INDICADOR + " =? ");
        }
        if (indicadorTO.getIdObjetivo() != 0){
            sql.append(" AND A." + ID_OBJETIVO + " =? ");
        }
        if ((indicadorTO.getNome() != null) && (!indicadorTO.getNome().equals("")) ){
            sql.append(" AND A." + NOME_INDICADOR + " LIKE? ");
        }
        if (indicadorTO.getResponsavelIndicador() != 0){
            sql.append(" AND A." + RESPONSAVEL + " =? ");
        }
        if (indicadorTO.getPeriodicidade() != 0){
            sql.append(" AND A." + PERIODICIDADE + " =? ");
        }
        if (indicadorTO.getUnidade() != 0){
            sql.append(" AND A." + UNIDADE + " =? ");
        }
        if ((indicadorTO.getDescricao() != null) && (!indicadorTO.getDescricao().equals("")) ){
            sql.append(" AND A." + DESCRICAO + " LIKE ? ");
        }
        if ((indicadorTO.getAtivo() != 0)){
            sql.append(" AND A." + ATIVO + " = ? ");
        }
        sql.append(" ORDER BY "+ NOME_INDICADOR);
        PreparedStatement stmt;
        try {
          stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        if (indicadorTO.getId() != 0){
	            stmt.setInt(++i,indicadorTO.getId());
	        }
	        if (indicadorTO.getIdObjetivo() != 0){
	            stmt.setInt(++i,indicadorTO.getIdObjetivo());
	        }
	        if ((indicadorTO.getNome() != null) && (!indicadorTO.getNome().equals("")) ){
	           stmt.setString(++i,"%"+ indicadorTO.getNome()+"%");
	        }
	        if (indicadorTO.getResponsavelIndicador() != 0){
	            stmt.setInt(++i,indicadorTO.getResponsavelIndicador());
	        }
	        if (indicadorTO.getPeriodicidade() != 0){
	            stmt.setInt(++i,indicadorTO.getPeriodicidade());
	        }
	        if (indicadorTO.getUnidade() != 0){
	            stmt.setInt(++i,indicadorTO.getUnidade());
	        }
	        if ((indicadorTO.getDescricao() != null) && (!indicadorTO.getDescricao().equals("")) ){
	           stmt.setString(++i,indicadorTO.getDescricao());
	        }
	        if ((indicadorTO.getAtivo() != 0)){
	           stmt.setInt(++i,indicadorTO.getAtivo());
	        }

             ResultSet resultado = stmt.executeQuery();
             IndicadorTO retorno = new IndicadorTO();
             Collection lista = new ArrayList();
             while (resultado.next()) {
                  retorno = carregaTO(resultado);
                  lista.add(retorno);
             }
             return lista;
        } catch (Exception e) {
              log.error(e.getMessage());
              throw new DaoException(e.getMessage());
        }
    }
	
	
	
	
	public void incluir(IndicadorTO indicadorTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("INSERT INTO ");
        sql.append(TABELA + "(");
        sql.append( ID_INDICADOR+", ");
        sql.append( ID_OBJETIVO+", ");
        sql.append( NOME_INDICADOR+", ");
        if (indicadorTO.getResponsavelIndicador() != 0){
        	sql.append( RESPONSAVEL+", ");
        }
        sql.append( PERIODICIDADE+", ");
        if (indicadorTO.getUnidade() != 0) {
        	sql.append( UNIDADE+", ");
        }
        sql.append( DESCRICAO+", ");
        sql.append( ATIVO+" ");
        sql.append(") VALUES (?,?,?,");
        if (indicadorTO.getResponsavelIndicador() != 0){
        	sql.append("?,");
        }
        sql.append("?,");
		if (indicadorTO.getUnidade() != 0) {
			sql.append("?,");
		}
        sql.append("?,?)");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        if (indicadorTO.getId() != 0){
	            stmt.setInt(++i,indicadorTO.getId());
	        }
	        if (indicadorTO.getIdObjetivo() != 0){
	            stmt.setInt(++i,indicadorTO.getIdObjetivo());
	        }
	        if ((indicadorTO.getNome() != null) && (!indicadorTO.getNome().equals("")) ){
	           stmt.setString(++i,indicadorTO.getNome());
	        }
	        if (indicadorTO.getResponsavelIndicador() != 0){
	            stmt.setInt(++i,indicadorTO.getResponsavelIndicador());
	        }
	        if (indicadorTO.getPeriodicidade() != 0){
	            stmt.setInt(++i,indicadorTO.getPeriodicidade());
	        }
	        if (indicadorTO.getUnidade() != 0){
	            stmt.setInt(++i,indicadorTO.getUnidade());
	        }
	        if ((indicadorTO.getDescricao() != null) && (!indicadorTO.getDescricao().equals("")) ){
	           stmt.setString(++i,indicadorTO.getDescricao());
	        }
	        if ((indicadorTO.getAtivo() != 0)){
	           stmt.setInt(++i,indicadorTO.getAtivo());
	        }

            stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }

	public void incluirDimensao(IndicadorTO indicadorTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("INSERT INTO ");
        sql.append(TABELA_DIMENSAO + "(");
        sql.append( ID_INDICADOR_DIMENSAO+" ");
        sql.append(") VALUES (?)");
        PreparedStatement stmt;
        try {
            stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        if (indicadorTO.getIdDimensao() != 0){
	            stmt.setInt(++i,indicadorTO.getIdDimensao());
	        }
	        stmt.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }

    public void alterar(IndicadorTO indicadorTO) throws ExceptionPersistenciaBSC {
        StringBuffer sql = new StringBuffer("UPDATE ");
        sql.append(TABELA + " SET ");
        if (indicadorTO.getId() != 0)
        	sql.append( ID_INDICADOR + " = ?, ");
        if (indicadorTO.getIdObjetivo() != 0)
        	sql.append( ID_OBJETIVO + " = ?, ");
        if ((indicadorTO.getNome() != null) && (!indicadorTO.getNome().equals("")) )
        	sql.append( NOME_INDICADOR + " = ?, ");
        if (indicadorTO.getResponsavelIndicador() != 0)
        	sql.append( RESPONSAVEL + " = ?, ");
        if (indicadorTO.getPeriodicidade() != 0)
        	sql.append( PERIODICIDADE + " = ?, ");
        if (indicadorTO.getUnidade() != 0)
        	sql.append( UNIDADE + " = ?, ");
        if ((indicadorTO.getDescricao() != null) && (!indicadorTO.getDescricao().equals("")) )
        	sql.append( DESCRICAO + " = ?, ");
        if ((indicadorTO.getAtivo() != 0))
        	sql.append( ATIVO + " = ?, ");
        if ((indicadorTO.getUltimaData() != null)){
        	sql.append(ULTIMA_DATA + " = ? ");
        }else{
        	sql.delete(sql.length() - 2, sql.length());
        }
        sql.append(" WHERE 1=1 ");
        sql.append("AND " + ID_INDICADOR  + " = ? ");
        PreparedStatement stmt;
        try {
        	stmt = getconexao().prepareStatement(sql.toString());
	        int i = 0;
	        if (indicadorTO.getId() != 0){
	            stmt.setInt(++i,indicadorTO.getId());
	        }
	        if (indicadorTO.getIdObjetivo() != 0){
	            stmt.setInt(++i,indicadorTO.getIdObjetivo());
	        }
	        if ((indicadorTO.getNome() != null) && (!indicadorTO.getNome().equals("")) ){
	           stmt.setString(++i,indicadorTO.getNome());
	        }
	        if (indicadorTO.getResponsavelIndicador() != 0){
	            stmt.setInt(++i,indicadorTO.getResponsavelIndicador());
	        }
	        if (indicadorTO.getPeriodicidade() != 0){
	            stmt.setInt(++i,indicadorTO.getPeriodicidade());
	        }
	        if (indicadorTO.getUnidade() != 0){
	            stmt.setInt(++i,indicadorTO.getUnidade());
	        }
	        if ((indicadorTO.getDescricao() != null) && (!indicadorTO.getDescricao().equals("")) ){
	           stmt.setString(++i,indicadorTO.getDescricao());
	        }
	        if ((indicadorTO.getAtivo() != 0)){
	           stmt.setInt(++i,indicadorTO.getAtivo());
	        }
	        if (indicadorTO.getUltimaData() != null){
	            stmt.setDate(++i,indicadorTO.getUltimaData());
	        }
	        
	        if (indicadorTO.getId() != 0){
	            stmt.setInt(++i,indicadorTO.getId());
	        }
	       
  
            stmt.executeUpdate();
         } catch (Exception e) {
            log.error(e.getMessage());
            throw new DaoException(e.getMessage());
         }
    }

	public Date consultarUltimaData(IndicadorTO indicadorTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer("SELECT ");
		sql.append(ULTIMA_DATA);
		sql.append(" FROM ");
		sql.append(TABELA);
		sql.append(" WHERE 1=1 AND "+ ID_INDICADOR +" = ? ");
		PreparedStatement stmt;
		ResultSet result;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			stmt.setInt(1,indicadorTO.getId());
			result = stmt.executeQuery();
			while (result.next()) {
				return result.getDate(ULTIMA_DATA);
			}
		}
		catch (SQLException e) {
		    log.error(e.getMessage());
			throw new ExceptionPersistenciaBSC(e.getMessage());
		}		
		return null;
	}

	public Integer consultarMapaPorIndicador(IndicadorTO indicadorTO) throws ExceptionPersistenciaBSC {
		StringBuffer sql = new StringBuffer("SELECT A.");
		sql.append(MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO);
		sql.append(" FROM ");
		sql.append(MapaEstrategicoDAOJDBC.TABELA + " A ,");
		sql.append(RelacionamentosDAOJDBC.TABELA + " B ,");
		sql.append(PerspectivaDAOJDBC.TABELA  + " C ,");
		sql.append(PerspectivaDAOJDBC.TABELA_REL + " D ,");
		sql.append(ObjetivoDAOJDBC.TABELA + " E ,");
		sql.append(TABELA + " F ");
		sql.append(" WHERE 1=1 AND F."+ ID_INDICADOR +" = ? AND ");
		sql.append(" F." + ID_OBJETIVO + " = E." + ID_INDICADOR +" AND ");
		sql.append(" E." + ObjetivoDAOJDBC.ID_OBJETIVO + " = D." + PerspectivaDAOJDBC.ID_OBJETIVO_REL +" AND ");
		sql.append(" D." + PerspectivaDAOJDBC.ID_PERSPECTIVA_REL + " = C." + PerspectivaDAOJDBC.ID_PERSPECTIVA +" AND ");
		sql.append(" C." + PerspectivaDAOJDBC.ID_PERSPECTIVA + " = B." + RelacionamentosDAOJDBC.BSCIDPERS +" AND ");
		sql.append(" B." + RelacionamentosDAOJDBC.BSCIDBSC + " = A." + MapaEstrategicoDAOJDBC.ID_MAPA_ESTRATEGICO);
		
		PreparedStatement stmt;
		ResultSet result;
		try {
			stmt = getconexao().prepareStatement(sql.toString());
			stmt.setInt(1,indicadorTO.getId());
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
