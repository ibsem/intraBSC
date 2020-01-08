package br.com.intraPRO.persistencia.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
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

import br.com.intraBSC.persistencia.BscDaoJDBCGenerico;
import br.com.intraBSC.persistencia.JDBC.UsuarioDAOJDBC;
import br.com.intraBSC.util.DataUtil;
import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.TarefaTO;
import br.com.intraPRO.modelo.ParticipanteTO;
import br.com.intraPRO.persistencia.TarefaDAO;


import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;



public class TarefaDAOImpl extends BscDaoJDBCGenerico implements TarefaDAO {	
	
	protected final static String TABELA_TIPO_TAREFA = "CONFIGURATIONTASK";
	protected final static String CODIGO_TIPO_TAREFA = "PK_CONFIGTASK";
	
    protected final static String TABELA = "TASK";
    protected final static String ANO = "PK_YEAR_START_TASK";
    protected final static String CODIGO = "PK_NUMBER_SEQUENCE_TASK";
    protected final static String NOME = "NAME_TASK";
    protected final static String CODIGO_ESTADO = "FK_STATUS_TASK";
    protected final static String PRIORIDADE = "FK_PRIORITY_TASK";
    protected final static String CODIGO_TIPO = "PK_CONFIGTASK";
    protected final static String DATA_LIMITE_FINALIZACAO = "DT_LIMIT_END_TASK";
    protected final static String DATA_INICIO = "DT_BEGIN_TASK";
    protected final static String DATA_FIM = "DT_END_TASK";
    protected final static String TS_CRIC_ATVD = "TS_START_TASK";
    protected final static String TS_ALT_ATVD = "TS_MODIFY_TASK";
    protected final static String CODIGO_USUARIO_CRIADOR = "FK_ACTOR_INIT_TASK";
    protected final static String CODIGO_USUARIO_ALTERADOR = "FK_ACTOR_MODIFY_TASK";
    protected final static String TEXTO_SOLICITACAO = "TX_DESCRIPTION_TASK";
    protected final static String CODIGO_SOLICITANTE = "FK_CODE_ACTOR_SEND";
    
    protected final static String CODIGO_MAPA = "ID_BSC";
    protected final static String CODIGO_PERSPECTIVA = "ID_PERSPECTIVE";
    protected final static String CODIGO_OBJETIVO = "ID_OBJECTIVE";
    
    protected final static String CODIGO_PROCESSO = "ID_PROCESSO";
    protected final static String CODIGO_FASE = "ID_FASE";
    protected final static String CODIGO_ATIVIDADE = "ID_ATIVIVIDADE";
    
    
    
    protected final static String CODIGO_INDICADOR = "ID_MEASURE";
    
    protected final static String PRIORIDADE_BAIXA = "BAIXA";
    protected final static String PRIORIDADE_MEDIA = "MÉDIA";
    protected final static String PRIORIDADE_ALTA = "ALTA";
    
    protected final static String ESTADO_INICIADA = "INICIADA";
    protected final static String ESTADO_CRIADA = "CRIADA";
    protected final static String ESTADO_CONCLUIDA = "CONCLUÍDA";
    
    
    private static Log log = LogFactory.getLog(TarefaDAOImpl.class);
    
   public TarefaDAOImpl(DaoManager daoManager)throws ExceptionPersistenciaPRO{
   		super(daoManager);
   }
 
   public void incluir(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("INSERT INTO ");
		sql.append(TABELA);
		sql.append(" (");
		if(tarefaTO.getAnoCriacao()!=0){
		    sql.append(ANO + ", ");
		}
		//if(tarefaTO.getCodigo()!=0){
		//    sql.append(CODIGO + ", ");
		//}
		if((tarefaTO.getNome()!=null) && (!tarefaTO.getNome().equals(""))){
		    sql.append(NOME + ", ");
		}
		if(tarefaTO.getCodEstado()!=0){
		    sql.append(CODIGO_ESTADO + ", ");
		}
		if(tarefaTO.getCodCriticidade()!=0){
		    sql.append(PRIORIDADE + ", ");
		}
		if(tarefaTO.getCodConfigTarefa()!=0){
		    sql.append(CODIGO_TIPO + ", ");
		}
		if((tarefaTO.getDtLimitePrazo()!=null) && (!tarefaTO.getDtLimitePrazo().equals(""))){
		    sql.append(DATA_LIMITE_FINALIZACAO + ", ");
		}
		if((tarefaTO.getDtInicio()!=null) && (!tarefaTO.getDtInicio().equals(""))){		
		    sql.append(DATA_INICIO + ", ");
		}
		if((tarefaTO.getDtFim()!=null) && (!tarefaTO.getDtFim().equals(""))){		
		    sql.append(DATA_FIM + ", ");
		}
		/*if((tarefaTO.getDtPrevisaoInicio()!=null) && (!tarefaTO.getDtPrevisaoInicio().equals(""))){
		    sql.append(DATA_PREVISAO_INICIO + ", ");
		}
		if((tarefaTO.getDtPrevisaoFim()!=null) && (!tarefaTO.getDtPrevisaoFim().equals(""))){
		    sql.append(DATA_PREVISAO_FIM + ", ");
		}*/
		if((tarefaTO.getCodUsuSolicitante()!=0)){
			sql.append(CODIGO_SOLICITANTE + ", ");
		}
		if((tarefaTO.getTsCriacao()!=null) && (!tarefaTO.getTsCriacao().equals(""))){
		    sql.append(TS_CRIC_ATVD + ", ");
		}
		if((tarefaTO.getTsAlteracao()!=null) && (!tarefaTO.getTsAlteracao().equals(""))){
			sql.append(TS_ALT_ATVD + ", ");		    
		}
		if((tarefaTO.getCodUsuCriador()!=0)){
		    sql.append(CODIGO_USUARIO_CRIADOR + ", ");
		}
		if((tarefaTO.getCodUsuAlteracao()!=0)){		
		    sql.append(CODIGO_USUARIO_ALTERADOR + ", ");
		}
		
	
		if((tarefaTO.getCodMapa()!=0)){		
		    sql.append(CODIGO_MAPA + ", ");
		}
		if((tarefaTO.getCodPerspectiva()!=0)){		
		    sql.append(CODIGO_PERSPECTIVA + ", ");
		}
		if((tarefaTO.getCodObjetivo()!=0)){		
		    sql.append(CODIGO_OBJETIVO + ", ");
		}
		if((tarefaTO.getCodIndicador()!=0)){		
		    sql.append(CODIGO_INDICADOR + ", ");
		}
		
		if((tarefaTO.getTextoSolicitacao()!=null) && (!tarefaTO.getTextoSolicitacao().equals(""))){
		    sql.append(TEXTO_SOLICITACAO);
		}
        else {
            sql.delete(sql.length() - 2, sql.length());
        }
        
		sql.append(") VALUES (");
		if(tarefaTO.getAnoCriacao()!=0){
			sql.append("?, ");
		}
		//if(tarefaTO.getCodigo()!=0){
		//	sql.append("?, ");
		//}
		if((tarefaTO.getNome()!=null) && (!tarefaTO.getNome().equals(""))){
			sql.append("?, ");
		}
		if(tarefaTO.getCodEstado()!=0){
			sql.append("?, ");
		}
		if(tarefaTO.getCodCriticidade()!=0){
			sql.append("?, ");
		}
		if(tarefaTO.getCodConfigTarefa()!=0){
			sql.append("?, ");
		}
		if((tarefaTO.getDtLimitePrazo()!=null) && (!tarefaTO.getDtLimitePrazo().equals(""))){
			sql.append("?, ");
		}
		if((tarefaTO.getDtInicio()!=null) && (!tarefaTO.getDtInicio().equals(""))){		
			sql.append("?, ");
		}
		if((tarefaTO.getDtFim()!=null) && (!tarefaTO.getDtFim().equals(""))){		
			sql.append("?, ");
		}
		/*if((tarefaTO.getDtPrevisaoInicio()!=null) && (!tarefaTO.getDtPrevisaoInicio().equals(""))){
			sql.append("?, ");
		}
		if((tarefaTO.getDtPrevisaoFim()!=null) && (!tarefaTO.getDtPrevisaoFim().equals(""))){
			sql.append("?, ");
		}*/
		if((tarefaTO.getCodUsuSolicitante()!=0)){
			sql.append("?, ");
		}
		if((tarefaTO.getTsCriacao()!=null) && (!tarefaTO.getTsCriacao().equals(""))){
			sql.append("?, ");
		}
		if((tarefaTO.getTsAlteracao()!=null) && (!tarefaTO.getTsAlteracao().equals(""))){
			sql.append("?, ");		    
		}
		if((tarefaTO.getCodUsuCriador()!=0)){
			sql.append("?, ");
		}
		if((tarefaTO.getCodUsuAlteracao()!=0)){		
			sql.append("?, ");
		}
		
		if((tarefaTO.getCodMapa()!=0)){		
		    sql.append("?, ");
		}
		if((tarefaTO.getCodPerspectiva()!=0)){		
		    sql.append("?, ");
		}
		if((tarefaTO.getCodObjetivo()!=0)){		
		    sql.append("?, ");
		}
		if((tarefaTO.getCodIndicador()!=0)){		
		    sql.append("?, ");
		}
		
		if((tarefaTO.getTextoSolicitacao()!=null) && (!tarefaTO.getTextoSolicitacao().equals(""))){
			sql.append("?");
		}
        else {
            sql.delete(sql.length() - 2, sql.length());
        }
        sql.append(")");

		PreparedStatement stmt;
		try{
			int i=0;
			stmt = getConnection().prepareStatement(sql.toString());
			if(tarefaTO.getAnoCriacao()!=0){
			    stmt.setInt(++i,tarefaTO.getAnoCriacao());
			}
			//if(tarefaTO.getCodigo()!=0){
			//    stmt.setInt(++i,tarefaTO.getCodigo());
			//}
			if((tarefaTO.getNome()!=null) && (!tarefaTO.getNome().equals(""))){
			    stmt.setString(++i,tarefaTO.getNome());
			}
			if(tarefaTO.getCodEstado()!=0){
			    stmt.setInt(++i,tarefaTO.getCodEstado());
			}
			if(tarefaTO.getCodCriticidade()!=0){
			    stmt.setInt(++i,tarefaTO.getCodCriticidade());
			}
			if(tarefaTO.getCodConfigTarefa()!=0){
			    stmt.setInt(++i,tarefaTO.getCodConfigTarefa());
			}
			if((tarefaTO.getDtLimitePrazo()!=null) && (!tarefaTO.getDtLimitePrazo().equals(""))){
			    stmt.setDate(++i,(Date)tarefaTO.getDtLimitePrazo());
			}
			if((tarefaTO.getDtInicio()!=null) && (!tarefaTO.getDtInicio().equals(""))){
			    stmt.setDate(++i,(Date)tarefaTO.getDtInicio());			
			}
			if((tarefaTO.getDtFim()!=null) && (!tarefaTO.getDtFim().equals(""))){			
			    stmt.setDate(++i,(Date)tarefaTO.getDtFim());
			}
			/*if((tarefaTO.getDtPrevisaoInicio()!=null) && (!tarefaTO.getDtPrevisaoInicio().equals(""))){
			    stmt.setDate(++i,(Date)tarefaTO.getDtPrevisaoInicio());			
			}
			if((tarefaTO.getDtPrevisaoFim()!=null) && (!tarefaTO.getDtPrevisaoFim().equals(""))){
			    stmt.setDate(++i,(Date)tarefaTO.getDtPrevisaoFim());			
			}*/
			if((tarefaTO.getCodUsuSolicitante()!=0)){
			    stmt.setInt(++i, tarefaTO.getCodUsuSolicitante());
			}
			if((tarefaTO.getTsCriacao()!=null) && (!tarefaTO.getTsCriacao().equals(""))){
			    stmt.setTimestamp(++i,tarefaTO.getTsCriacao());//timestamp			
			}
			if((tarefaTO.getTsAlteracao()!=null) && (!tarefaTO.getTsAlteracao().equals(""))){
			    stmt.setTimestamp(++i,tarefaTO.getTsAlteracao());//timestamp			
			}
			if(tarefaTO.getCodUsuCriador()!= 0){			
			    stmt.setInt(++i,tarefaTO.getCodUsuCriador());
			}			    
			if((tarefaTO.getCodUsuAlteracao()!=0)){			
			    stmt.setInt(++i,tarefaTO.getCodUsuAlteracao());
			}
			
			if((tarefaTO.getCodMapa()!=0)){		
				stmt.setInt(++i,tarefaTO.getCodMapa());
			}
			if((tarefaTO.getCodPerspectiva()!=0)){		
				stmt.setInt(++i,tarefaTO.getCodPerspectiva());
			}
			if((tarefaTO.getCodObjetivo()!=0)){		
				stmt.setInt(++i,tarefaTO.getCodObjetivo());
			}
			if((tarefaTO.getCodIndicador()!=0)){		
				stmt.setInt(++i,tarefaTO.getCodIndicador());
			}
			
			if((tarefaTO.getTextoSolicitacao()!=null) && (!tarefaTO.getTextoSolicitacao().equals(""))){			
			    stmt.setString(++i,tarefaTO.getTextoSolicitacao());
			}
			stmt.executeUpdate();
		}
		catch(SQLException e){
		    log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
	}
	
	public void alterar(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO, ParseException {			
		StringBuffer sql = new StringBuffer("UPDATE " + TABELA + " SET ");
		
		if((tarefaTO.getNome()!=null)&&(!tarefaTO.getNome().equals("")))
			sql.append(NOME + "= ?,");
		if(tarefaTO.getCodEstado()!=0)		
			sql.append(CODIGO_ESTADO + "= ?,");
		if((tarefaTO.getCodCriticidade()!=0))
			sql.append(PRIORIDADE + "= ?,");
		if((tarefaTO.getDtLimitePrazo()!=null)&&(!tarefaTO.getDtLimitePrazo().equals("")))
			sql.append(DATA_LIMITE_FINALIZACAO + "= ?,");
		if((tarefaTO.getTextoSolicitacao()!=null)&&(!tarefaTO.getTextoSolicitacao().equals("")))
			sql.append(TEXTO_SOLICITACAO + "= ?,");
		if(tarefaTO.getCodIndicador()!=0)		
			sql.append(CODIGO_INDICADOR + "= ?,");
		if(tarefaTO.getCodObjetivo()!=0)		
			sql.append(CODIGO_OBJETIVO + "= ?,");
		if(tarefaTO.getCodPerspectiva()!=0)		
			sql.append(CODIGO_PERSPECTIVA + "= ?,");
		if(tarefaTO.getCodMapa()!=0)		
			sql.append(CODIGO_MAPA + "= ?,");
		sql.append(DATA_INICIO + "= ?,");
		sql.append(DATA_FIM + "= ?,");
		sql.append(CODIGO_USUARIO_ALTERADOR + "= ? ");
		
		sql.append(" WHERE 1=1 ");
		sql.append("AND " + ANO + " =? ");	
		sql.append("AND " + CODIGO + " =? ");
		PreparedStatement stmt = null;
		
		try{
			int i=0;
			stmt = getConnection().prepareStatement(sql.toString());
			if((tarefaTO.getNome()!=null)&&(!tarefaTO.getNome().equals(""))){
				stmt.setString(++i, tarefaTO.getNome().trim());
			}
			if(tarefaTO.getCodEstado()!=0){		
				stmt.setInt(++i, tarefaTO.getCodEstado());
			}
			if((tarefaTO.getCodCriticidade()!=0)){
				stmt.setInt(++i, tarefaTO.getCodCriticidade());
			}
			if((tarefaTO.getDtLimitePrazo()!=null)&&(!tarefaTO.getDtLimitePrazo().equals(""))){
				stmt.setDate(++i, tarefaTO.getDtLimitePrazo());
			}
			if((tarefaTO.getTextoSolicitacao()!=null)&&(!tarefaTO.getTextoSolicitacao().equals(""))){
				stmt.setString(++i, tarefaTO.getTextoSolicitacao());
			}
				
			if(tarefaTO.getCodIndicador()!=0)		
				stmt.setInt(++i, tarefaTO.getCodIndicador());
			if(tarefaTO.getCodObjetivo()!=0)		
				stmt.setInt(++i, tarefaTO.getCodObjetivo());
			if(tarefaTO.getCodPerspectiva()!=0)		
				stmt.setInt(++i, tarefaTO.getCodPerspectiva());
			if(tarefaTO.getCodMapa()!=0)		
				stmt.setInt(++i, tarefaTO.getCodMapa());
			
			stmt.setDate(++i, tarefaTO.getDtInicio());
			stmt.setDate(++i, tarefaTO.getDtFim());
			//Sempre guarda a Chave do usuario e a hora que esta sendo executada a alteracao da tarefa.
			stmt.setInt(++i, tarefaTO.getCodUsuAlteracao());
			stmt.setInt(++i, tarefaTO.getAnoCriacao());
			stmt.setInt(++i, tarefaTO.getCodigo());
			stmt.executeUpdate();
		}
		catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
	}
	

	@SuppressWarnings("unchecked")
	public Collection consultarVarios(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO, ParseException {
		StringBuffer sql = new StringBuffer("SELECT ");
        sql.append(ANO + ", ");
        sql.append(CODIGO + ", ");
        sql.append(NOME + ", ");
        sql.append(CODIGO_ESTADO + ", ");
        sql.append(PRIORIDADE + ", ");
        sql.append(CODIGO_TIPO + ", ");
        sql.append(DATA_LIMITE_FINALIZACAO + ", ");
        sql.append(DATA_INICIO + ", ");
        sql.append(DATA_FIM + ", ");
        //sql.append(DATA_PREVISAO_INICIO + ", ");
        //sql.append(DATA_PREVISAO_FIM + ", ");
        sql.append(TS_CRIC_ATVD + ", ");
        sql.append(TS_ALT_ATVD + ", ");
        sql.append(CODIGO_USUARIO_CRIADOR + ", ");
        sql.append(CODIGO_USUARIO_ALTERADOR + ", ");
        sql.append(TEXTO_SOLICITACAO);

		sql.append(" FROM " + TABELA + " A ");
		sql.append("WHERE 1=1");
		if (tarefaTO.getAnoCriacao() !=0){
			sql.append(" AND " + ANO + "=?");				
		}
		if (tarefaTO.getCodigo() !=0){
			sql.append(" AND " + CODIGO + "=?");
		}		
		if((tarefaTO.getNome() != null) && (!tarefaTO.getNome().equals(""))){
			sql.append(" AND UPPER(" + NOME + ") LIKE ?");
		}
		if (tarefaTO.getCodEstado() != 0){
			sql.append(" AND " + CODIGO_ESTADO + "=?");
		}
		if (tarefaTO.getCodCriticidade() !=0) {
			sql.append(" AND " + PRIORIDADE + "=?");
		}		
		if(tarefaTO.getCodConfigTarefa()!=0){
			sql.append(" AND " + CODIGO_TIPO + "=?");
		}
		if ((tarefaTO.getDtLimitePrazo()!=null)&&(!tarefaTO.getDtLimitePrazo().equals(""))){
			sql.append(" AND " + DATA_LIMITE_FINALIZACAO + "=?");
		}
		if ((tarefaTO.getDtInicio()!=null)&&(!tarefaTO.getDtInicio().equals(""))){
			sql.append(" AND " + DATA_INICIO + "=?");
		}
		if ((tarefaTO.getDtFim()!=null)&&(!tarefaTO.getDtFim().equals(""))) {
			sql.append(" AND " + DATA_FIM + "=?");
		}
		/*if ((tarefaTO.getDtPrevisaoInicio()!=null)&&(!tarefaTO.getDtPrevisaoInicio().equals(""))) {
			sql.append(" AND " + DATA_PREVISAO_INICIO + "=?");
		} 
		if ((tarefaTO.getDtPrevisaoFim()!=null)&&(!tarefaTO.getDtPrevisaoFim().equals(""))) {
			sql.append(" AND " + DATA_PREVISAO_FIM + "=?");
		} */
	
		if(tarefaTO.getTsCriacao()!=null) {
			sql.append(" AND " + TS_CRIC_ATVD + "=?");
		}
		if(tarefaTO.getTsAlteracao()!=null) {
			sql.append(" AND " + TS_ALT_ATVD + "=?");
		}
		if(tarefaTO.getCodUsuCriador()!=0){
			sql.append(" AND " + CODIGO_USUARIO_CRIADOR + "=?");
		}
		if(tarefaTO.getCodUsuAlteracao()!=0){
			sql.append(" AND " + CODIGO_USUARIO_ALTERADOR + "=?");
		}
		if(tarefaTO.getTextoSolicitacao()!=null){
			sql.append(" AND " + TEXTO_SOLICITACAO + "=?");
		}
        
		//sql.append(" ORDER BY " + NOME);
		PreparedStatement stmt;
		ResultSet resultado;
		Collection listaTarefa = new ArrayList();
		int i=0;
		try{
			stmt = getConexao().prepareStatement(sql.toString());
			
			if ((tarefaTO.getAnoCriacao()!=0)){
				stmt.setInt(++i, tarefaTO.getAnoCriacao());
			}
			
			if ((tarefaTO.getCodigo()!=0)){
				stmt.setInt(++i, tarefaTO.getCodigo());
			}
			
			if((tarefaTO.getNome()!=null)&&(!tarefaTO.getNome().equals(""))){
				stmt.setString(++i, tarefaTO.getNome());
			}
			
			if(tarefaTO.getCodEstado()!=0){		
				stmt.setInt(++i, tarefaTO.getCodEstado());
			}
			if((tarefaTO.getCodCriticidade()!=0)){
				stmt.setInt(++i, tarefaTO.getCodCriticidade());
			}
			if((tarefaTO.getCodConfigTarefa()!=0)){
				stmt.setInt(++i, tarefaTO.getCodConfigTarefa());
			}

			if((tarefaTO.getDtLimitePrazo()!=null)&&(!tarefaTO.getDtLimitePrazo().equals(""))){
				stmt.setDate(++i, tarefaTO.getDtLimitePrazo());
			} 
			
			if((tarefaTO.getDtInicio()!=null)&&(!tarefaTO.getDtInicio().equals(""))){
			    stmt.setDate(++i, tarefaTO.getDtInicio());
			} 
			if((tarefaTO.getDtFim()!=null)&&(!tarefaTO.getDtFim().equals(""))){
			    stmt.setDate(++i, tarefaTO.getDtFim());
			} 
			/*if((tarefaTO.getDtPrevisaoInicio()!=null)&&(!tarefaTO.getDtPrevisaoInicio().equals(""))){
			    stmt.setDate(++i, tarefaTO.getDtPrevisaoInicio());
			} 
			if((tarefaTO.getDtPrevisaoFim()!=null)&&(!tarefaTO.getDtPrevisaoFim().equals(""))){
			    stmt.setDate(++i, tarefaTO.getDtPrevisaoFim());
			}*/
			if((tarefaTO.getCodUsuSolicitante()!=0)){
				stmt.setInt(++i, tarefaTO.getCodUsuSolicitante());
			}
			if((tarefaTO.getTsCriacao()!=null)){
				stmt.setTimestamp(++i, tarefaTO.getTsCriacao());
			}
			if((tarefaTO.getTsAlteracao()!=null)){
				stmt.setTimestamp(++i, tarefaTO.getTsAlteracao());
			}
			if((tarefaTO.getCodUsuCriador()!=0)){
				stmt.setInt(++i, tarefaTO.getCodUsuCriador());
			}
			if((tarefaTO.getCodUsuAlteracao()!=0)){
				stmt.setInt(++i, tarefaTO.getCodUsuAlteracao());
			}
			if((tarefaTO.getTextoSolicitacao()!=null)){
				stmt.setString(++i, tarefaTO.getTextoSolicitacao());
			}
			resultado = stmt.executeQuery();
			while(resultado.next()){
				listaTarefa.add(carregarTO(resultado));
			}
		}
		catch(SQLException e){
			log.error(e.getMessage());
			throw new DaoException(e.getMessage());
		}
		return listaTarefa;
	}
	
	public TarefaTO consultarUm(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO, ParseException {
        StringBuffer sql = new StringBuffer("SELECT ");
        sql.append(ANO + ", ");
        sql.append(CODIGO + ", ");	
        sql.append(NOME + ", ");
        sql.append(CODIGO_ESTADO + ", ");
        sql.append(PRIORIDADE + ", ");
        sql.append(CODIGO_TIPO + ", ");
        sql.append(DATA_LIMITE_FINALIZACAO + ", ");
        sql.append(DATA_INICIO + ", ");
        sql.append(DATA_FIM + ", ");
        //sql.append(DATA_PREVISAO_INICIO + ", ");
        //sql.append(DATA_PREVISAO_FIM + ", ");
        sql.append(TS_CRIC_ATVD + ", ");
        sql.append(TS_ALT_ATVD + ", ");
        sql.append(CODIGO_USUARIO_CRIADOR + ", ");
        sql.append(CODIGO_SOLICITANTE + ", ");
        sql.append(CODIGO_MAPA + ", ");
        sql.append(CODIGO_PERSPECTIVA + ", ");
        sql.append(CODIGO_OBJETIVO + ", ");
        sql.append(CODIGO_INDICADOR + ", ");
        sql.append(TEXTO_SOLICITACAO);
        
		sql.append(" FROM ");
		sql.append(TABELA);
		sql.append(" A ");
		sql.append(" WHERE 1 = 1");

		if (tarefaTO.getCodigo() != 0)
			sql.append(" AND " + CODIGO + " = " + "" + tarefaTO.getCodigo() );
		if (tarefaTO.getAnoCriacao() != 0)
			sql.append(" AND " + ANO + " = " + "" + tarefaTO.getAnoCriacao() );
		if (tarefaTO.getCodConfigTarefa() != 0)
			sql.append(" AND " + CODIGO_TIPO + " = " + "" + tarefaTO.getCodConfigTarefa());

		PreparedStatement stmt;
		ResultSet result;
		
		TarefaTO returnTO = new TarefaTO();
		
		try {
			stmt = getConexao().prepareStatement(sql.toString());
			
			result = stmt.executeQuery();
			while (result.next()) {
				returnTO = carregarTO(result);
			}
			
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
		return returnTO;
	}
	
	private TarefaTO carregarTO(ResultSet resultado) throws ParseException, SQLException{	    
		TarefaTO tarefaTO = new TarefaTO();
	    tarefaTO.setAnoCriacao(resultado.getInt(1));
	    tarefaTO.setCodigo(resultado.getInt(2));
	    tarefaTO.setNome(resultado.getString(3).trim());
	    tarefaTO.setCodEstado(resultado.getInt(4));
	    tarefaTO.setCodEstadoDesabilitado(resultado.getInt(4));
	    tarefaTO.setCodCriticidade(resultado.getInt(5));
	    tarefaTO.setCodConfigTarefa(resultado.getInt(6));
	    tarefaTO.setDtLimitePrazo(resultado.getDate(7));
        tarefaTO.setDtInicio(resultado.getDate(8));
	    tarefaTO.setDtFim(resultado.getDate(9));
	    /*tarefaTO.setDtPrevisaoInicio(resultado.getDate(10));
	    tarefaTO.setDtPrevisaoFim(resultado.getDate(11));
	    if (tarefaTO.getDtPrevisaoInicio()!= null)
	    	tarefaTO.setDtPrevisaoInicioS(new DataUtil().getData(tarefaTO.getDtPrevisaoInicio()));
	    if (tarefaTO.getDtPrevisaoFim()!= null)
	    	tarefaTO.setDtPrevisaoFimS(new DataUtil().getData(tarefaTO.getDtPrevisaoFim()));*/
	    tarefaTO.setTsCriacao(resultado.getTimestamp(10));
	    tarefaTO.setTsAlteracao(resultado.getTimestamp(11));
	    tarefaTO.setCodUsuSolicitante(resultado.getInt(13));
	    
	    tarefaTO.setCodigoAno();
		tarefaTO.setTsCriacaoS(new DataUtil().getTimestampFormatoComum(tarefaTO.getTsCriacao()));
		tarefaTO.setDtPrazo(new DataUtil().getData(tarefaTO.getDtLimitePrazo()));
		tarefaTO.setTsAlteracaoS(new DataUtil().getTimestampFormatoComum(tarefaTO.getTsAlteracao()));
		tarefaTO.setCodMapa(resultado.getInt(14));
		tarefaTO.setCodPerspectiva(resultado.getInt(15));
		tarefaTO.setCodObjetivo(resultado.getInt(16));
		tarefaTO.setCodIndicador(resultado.getInt(17));
		tarefaTO.setTextoSolicitacao(resultado.getString(18).trim());
	    return tarefaTO;
	}
	
	private Connection getConexao(){		
		return  getConnection();
	}


	public int consultarMax(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("SELECT MAX(");
		sql.append(CODIGO);
		sql.append(") AS ");
		sql.append(CODIGO);
		sql.append(" FROM ");
		sql.append(TABELA);		
		sql.append(" WHERE 1=1");
		sql.append(" AND ");		
		sql.append(ANO + "=?");		

		PreparedStatement stmt;
		ResultSet result;		
		try {
		    int i=0;
			stmt = getConexao().prepareStatement(sql.toString());
			stmt.setInt(++i,tarefaTO.getAnoCriacao());
			result = stmt.executeQuery();
			while (result.next()) {
				return result.getInt(CODIGO)+1;
			}			
		} 
		catch (SQLException e) {
		    log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}		
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	public Collection consultarArvore(TarefaTO tarefaTO, ParticipanteTO participanteTO) throws ExceptionPersistenciaPRO, ParseException {
		try {					
			Collection listaTarefa = new ArrayList();
			PreparedStatement stmt;
			StringBuffer sql = new StringBuffer();
			
			sql.append("SELECT ");  
			sql.append(" concat(A." + ANO + ",concat('/',A." + CODIGO + ")) AS codigoAno,");
			sql.append("A." + ANO + ", ");
			sql.append("A." + CODIGO + ", ");
			sql.append("A." + NOME + ", ");
			sql.append("A." + PRIORIDADE + ", ");
			sql.append("A." + CODIGO_ESTADO + ", ");
		    sql.append(" concat(CASE WHEN (MONTH(A."+DATA_LIMITE_FINALIZACAO+") = 1) THEN 'Janeiro'"); 
		    sql.append("             WHEN (MONTH(A."+DATA_LIMITE_FINALIZACAO+") = 2) THEN 'Fevereiro'"); 
		    sql.append("  			 WHEN (MONTH(A."+DATA_LIMITE_FINALIZACAO+") = 3) THEN 'Marco'"); 
		    sql.append("  			 WHEN (MONTH(A."+DATA_LIMITE_FINALIZACAO+") = 4) THEN 'Abril'"); 
		    sql.append(" 			 WHEN (MONTH(A."+DATA_LIMITE_FINALIZACAO+") = 5) THEN 'Maio'"); 
		    sql.append(" 			 WHEN (MONTH(A."+DATA_LIMITE_FINALIZACAO+") = 6) THEN 'Junho'"); 
		    sql.append(" 			 WHEN (MONTH(A."+DATA_LIMITE_FINALIZACAO+") = 7) THEN 'Julho'"); 
		    sql.append(" 			 WHEN (MONTH(A."+DATA_LIMITE_FINALIZACAO+") = 8) THEN 'Agosto'"); 
		    sql.append(" 			 WHEN (MONTH(A."+DATA_LIMITE_FINALIZACAO+") = 9) THEN 'Setembro'");
		    sql.append(" 			 WHEN (MONTH(A."+DATA_LIMITE_FINALIZACAO+") = 10) THEN 'Outubro'");  
		    sql.append(" 			 WHEN (MONTH(A."+DATA_LIMITE_FINALIZACAO+") = 11) THEN 'Novembro'"); 
		    sql.append(" 			 WHEN (MONTH(A."+DATA_LIMITE_FINALIZACAO+") = 12) THEN 'Dezembro'"); 			
		    sql.append(" END,concat(' / ', YEAR(A."+DATA_LIMITE_FINALIZACAO+"))) AS grupoMesAno,");
		    sql.append("A." + DATA_INICIO + ", ");
			sql.append("A." + DATA_FIM + ", ");
			sql.append("A." + DATA_LIMITE_FINALIZACAO + ", ");
			sql.append("A." + TS_CRIC_ATVD + ", ");
			sql.append("A." + TS_ALT_ATVD );
			sql.append(" FROM " + TABELA + " A ");
			sql.append(" INNER JOIN " + ParticipanteDAOImpl.TABELA + " B ");
			sql.append(" ON B." + ParticipanteDAOImpl.NUMERO_SEQUENCIAL_TAREFA +" = A."+ CODIGO );
			sql.append(" AND B." + ParticipanteDAOImpl.ANO_CRIACAO +" = A."+ ANO);
			sql.append(" INNER JOIN " + UsuarioDAOJDBC.TABELA + " AS C ");
			sql.append(" ON " + UsuarioDAOJDBC.ID_USUARIO +"="+ ParticipanteDAOImpl.COD_USUARIO);
			sql.append(" WHERE  1=1 AND B."+ ParticipanteDAOImpl.COD_TIPO_PARTICIPACAO + " = ? ");
			sql.append(" AND A." + CODIGO_ESTADO + "<3 ");
			sql.append("AND B."+ParticipanteDAOImpl.COD_USUARIO +"=?");
			sql.append(" ORDER BY A."+DATA_LIMITE_FINALIZACAO);
		
			int i=0;
			stmt = getConexao().prepareStatement(sql.toString());
			
			stmt.setInt(++i,participanteTO.getCodTipoParticipacao());
			stmt.setInt(++i,participanteTO.getCodUsuario());
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				listaTarefa.add(carregarTOConsultaArvore(result));
			}
			return listaTarefa;
			
		}		
		catch (SQLException e) {
		    log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	public Collection visualizar(TarefaTO tarefaTO,ParticipanteTO participanteTO) throws ExceptionPersistenciaPRO, ParseException {
		try {
			Collection listaTarefa = new ArrayList();
			PreparedStatement stmt;			
			StringBuffer sql = new StringBuffer("SELECT DISTINCT ");
			sql.append("A." + ANO + ", ");
			sql.append("A." + CODIGO + ", ");
			sql.append("A." + NOME + ", ");
			sql.append("A." + CODIGO_ESTADO + ", ");
			sql.append("A." + PRIORIDADE + ", ");
			sql.append("A." + CODIGO_TIPO + ", ");
			sql.append("A." + DATA_LIMITE_FINALIZACAO + ", ");
			sql.append("A." + DATA_INICIO + ", ");
			sql.append("A." + DATA_FIM + ", ");
			//sql.append("A." + DATA_PREVISAO_INICIO + ", ");
			//sql.append("A." + DATA_PREVISAO_FIM + ", ");
			sql.append("A." + TS_CRIC_ATVD + ", ");
			sql.append("A." + TS_ALT_ATVD + ", ");
			sql.append("A." + CODIGO_USUARIO_CRIADOR + ", ");
			sql.append("A." + CODIGO_USUARIO_ALTERADOR + ", " );
			sql.append("A." + TEXTO_SOLICITACAO + ", ");
			sql.append("B." + ParticipanteDAOImpl.COD_NIVEL);
			
			sql.append(" FROM "  + TABELA + " A INNER JOIN " + TABELA_TIPO_TAREFA + " C ON (A." + CODIGO_TIPO_TAREFA  + " = " +"C."+CODIGO_TIPO_TAREFA+") ");
			
			
			if ((tarefaTO.getCodConfigTarefa() != 0)){
				sql.append(" AND A." + CODIGO_ESTADO + "<=3 AND A."+ CODIGO_TIPO_TAREFA + " = ? ");
			}else{
				sql.append(" AND A." + CODIGO_ESTADO + "<=3 ");
			}
			
			sql.append("LEFT JOIN " + ParticipanteDAOImpl.TABELA + " B ON (A." + ParticipanteDAOImpl.ANO_CRIACAO + " = B." + ANO + " AND ");
			if (participanteTO.getCodTipoParticipacao() == 1){
				sql.append("A."+ CODIGO + " = B." + CODIGO + " AND B."+ ParticipanteDAOImpl.COD_TIPO_PARTICIPACAO +" = ? AND B."+ParticipanteDAOImpl.COD_USUARIO +"=? )");
			}else{
				sql.append("A."+ CODIGO + " = B." + CODIGO + " AND B."+ ParticipanteDAOImpl.COD_TIPO_PARTICIPACAO +" = ?)");
			}
			sql.append(" WHERE 1=1 ");			
			sql.append("AND (B."+ParticipanteDAOImpl.COD_USUARIO +"=? OR A."+ CODIGO_SOLICITANTE + " = ?)");
		    int i=0;
			
			sql.append(" ORDER BY A."+DATA_LIMITE_FINALIZACAO);					
			stmt = getConexao().prepareStatement(sql.toString());
			
			if ((tarefaTO.getCodConfigTarefa() != 0)){
				stmt.setInt(++i,tarefaTO.getCodConfigTarefa());
			}
			stmt.setInt(++i,participanteTO.getCodTipoParticipacao());
			stmt.setInt(++i,participanteTO.getCodUsuario());
			stmt.setInt(++i,participanteTO.getCodUsuario());
			stmt.setInt(++i,participanteTO.getCodUsuario());
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				listaTarefa.add(carregarTOVisualizar(result));
			}
			return listaTarefa;
		}		
		catch (SQLException e) {
		    log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}		
		
	}


	@SuppressWarnings("unchecked")
	public Collection consultarTarefa(TarefaTO tarefaTO, ParticipanteTO participanteTO) throws ExceptionPersistenciaPRO {
		try {					
			Collection listaTarefa = new ArrayList();
			PreparedStatement stmt;
			StringBuffer sql = new StringBuffer("SELECT DISTINCT ");
			
			//Campo de Tarefa
			sql.append("A." + ANO + ", ");
			sql.append("A." + CODIGO + ", ");
			sql.append("A." + NOME + ", ");
			sql.append("A." + TEXTO_SOLICITACAO + ", ");
			sql.append("A." + CODIGO_TIPO + ", ");
			sql.append("A." + DATA_INICIO + ", ");
			sql.append("A." + DATA_FIM + ", ");
			sql.append("A." + DATA_LIMITE_FINALIZACAO + ", ");
			sql.append("A." + CODIGO_ESTADO + ", ");
			sql.append("A." + PRIORIDADE + ", ");
			sql.append("A." + TS_CRIC_ATVD + ", ");
			sql.append("A." + TS_ALT_ATVD );
			sql.append(" FROM " + TABELA + " A ");
			sql.append(", " + ParticipanteDAOImpl.TABELA + " B ");
			sql.append(", " + TABELA_TIPO_TAREFA + " C ");
			sql.append(" WHERE 1=1 ");
			sql.append(" AND C." + CODIGO_TIPO + " = A." + CODIGO_TIPO);
			sql.append(" AND A." + CODIGO + " = B." + ParticipanteDAOImpl.NUMERO_SEQUENCIAL_TAREFA);
			sql.append(" AND ( A." +CODIGO_USUARIO_CRIADOR+ " = ? ");
			sql.append(" OR  B."+ ParticipanteDAOImpl.COD_USUARIO + " = ? )");
			//sql.append(" AND ");
			 int i=0;
			    if (tarefaTO.getCodigo() != 0){
					sql.append(" AND A." + CODIGO + " = ?");
				}
			    if((tarefaTO.getNome() != null) && (!tarefaTO.getNome().equals(""))){
					sql.append(" AND UPPER(A." + NOME + ") LIKE ?");
				}
			    if (tarefaTO.getCodConfigTarefa() != 0){
					sql.append(" AND A." + CODIGO_TIPO + " = ?");
				}
			    if(((tarefaTO.getDtPrazoInicio()!=null)&&(!tarefaTO.getDtPrazoInicio().equals(""))) && ((tarefaTO.getDtPrazoFim()!=null)&&(!tarefaTO.getDtPrazoFim().equals("")))){
			    	sql.append(" AND A." + DATA_LIMITE_FINALIZACAO  + " BETWEEN ? AND ?");
			    }
			    if (tarefaTO.getCodEstado() != 0){
			    	if (tarefaTO.getEstadoSimNao().equals("S"))
			    		sql.append(" AND A." + CODIGO_ESTADO + " = ?");
			    	else if (tarefaTO.getEstadoSimNao().equals("N"))
			    		sql.append(" AND A." + CODIGO_ESTADO + " <> ?");
				}
			    
			    stmt = getConexao().prepareStatement(sql.toString());
			    
			    stmt.setInt(++i,tarefaTO.getCodUsuCriador());
			    stmt.setInt(++i,participanteTO.getCodUsuario());
			    
			    if (tarefaTO.getCodigo() != 0){
					stmt.setInt(++i,tarefaTO.getCodigo());							
				}		    
			    if((tarefaTO.getNome() != null) && (!tarefaTO.getNome().equals(""))){
			    	stmt.setString(++i,"%" + tarefaTO.getNome().toUpperCase()+ "%");
				}
			    if (tarefaTO.getCodConfigTarefa() != 0){
			    	stmt.setInt(++i,tarefaTO.getCodConfigTarefa());
				}
			    if(((tarefaTO.getDtPrazoInicio()!=null)&&(!tarefaTO.getDtPrazoInicio().equals(""))) && ((tarefaTO.getDtPrazoFim()!=null)&&(!tarefaTO.getDtPrazoFim().equals("")))){
			    	stmt.setDate(++i,tarefaTO.getDtPrazoInicio());
			    	stmt.setDate(++i,tarefaTO.getDtPrazoFim());
			    }
			    if (tarefaTO.getCodEstado() != 0){
			    	stmt.setInt(++i,tarefaTO.getCodEstado());
				}
			    
			    ResultSet result = stmt.executeQuery();		    
				while (result.next()) {
					listaTarefa.add(carregarTOPesquisa(result,tarefaTO.getRelativo()));
				}
				return listaTarefa;
				
			} catch (Exception e) {
				log.error(e.getMessage());
				throw new ExceptionPersistenciaPRO(e.getMessage());
			}
	}
	


	public TarefaTO carregarTOPesquisa(ResultSet resultado, String relativo) throws ExceptionPersistenciaPRO, SQLException{
		TarefaTO tarefaTO = new TarefaTO();
					
		tarefaTO.setAnoCriacao(resultado.getInt(1));
	    tarefaTO.setCodigo(resultado.getInt(2));	    
	    tarefaTO.setNome(resultado.getString(3).trim());
	    tarefaTO.setTextoSolicitacao(resultado.getString(4).trim());
	    tarefaTO.setCodConfigTarefa(resultado.getInt(5));     	    	   
	    tarefaTO.setDtLimitePrazo(resultado.getDate(8));
	    tarefaTO.setDtPrazo(new DataUtil().getData(tarefaTO.getDtLimitePrazo()));
	    tarefaTO.setCodEstado(resultado.getInt(9));
	    tarefaTO.setCodCriticidade(resultado.getInt(10));

		return tarefaTO;				
	}
	
	
	private TarefaTO carregarTOVisualizar(ResultSet resultado) throws ParseException, SQLException{

		TarefaTO tarefaTO = new TarefaTO();
	    tarefaTO.setAnoCriacao(resultado.getInt(1));
	    tarefaTO.setCodigo(resultado.getInt(2));
	    tarefaTO.setNome(resultado.getString(3).trim());
	    tarefaTO.setCodEstado(resultado.getInt(4));
	    tarefaTO.setCodCriticidade(resultado.getInt(5));
	    tarefaTO.setCodConfigTarefa(resultado.getInt(6));
	    tarefaTO.setDtLimitePrazo(resultado.getDate(7));
	    tarefaTO.setDtInicio(resultado.getDate(8));
	    tarefaTO.setDtFim(resultado.getDate(9));
	    /*tarefaTO.setDtPrevisaoInicio(resultado.getDate(10));
	    tarefaTO.setDtPrevisaoFim(resultado.getDate(11));*/
	    tarefaTO.setTsCriacao(resultado.getTimestamp(10));	    
	    tarefaTO.setTsAlteracao(resultado.getTimestamp(11));	   
	    tarefaTO.setCodUsuCriador(resultado.getInt(12));
	    tarefaTO.setCodUsuAlteracao(resultado.getInt(13));
	    tarefaTO.setTextoSolicitacao(resultado.getString(14));
	    tarefaTO.setStatusModificado(resultado.getInt(15));
	    
	    return tarefaTO;
	}
	
	private TarefaTO carregarTOConsultaArvore(ResultSet resultado) throws ParseException, SQLException{

		TarefaTO tarefaTO = new TarefaTO();
		tarefaTO.setCodigoAno(resultado.getString(1));
	    tarefaTO.setAnoCriacao(resultado.getInt(2));
	    tarefaTO.setCodigo(resultado.getInt(3));
	    tarefaTO.setNome(resultado.getString(4).trim());
	    tarefaTO.setCodCriticidade(resultado.getInt(5));
	    tarefaTO.setCodEstado(resultado.getInt(6));
	    tarefaTO.setGrupoMesAno(resultado.getString(7));
	    tarefaTO.setDtInicio(resultado.getDate(8));
	    tarefaTO.setDtFim(resultado.getDate(9));
	    tarefaTO.setDtLimitePrazo(resultado.getDate(10));
	    tarefaTO.setDtPrazo(new DataUtil().getData(resultado.getDate(10)));
	    tarefaTO.setTsCriacao(resultado.getTimestamp(11));	    
	    tarefaTO.setTsAlteracao(resultado.getTimestamp(12));
	    tarefaTO.setTsCriacaoS(new DataUtil().getTimestampFormatoSemHora(resultado.getTimestamp(11)));	    
	    tarefaTO.setTsAlteracaoS(new DataUtil().getTimestampFormatoSemHora(resultado.getTimestamp(12)));
	    return tarefaTO;
	}
	
	
	
	public void alterarDataAtualizacao(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO{			
		StringBuffer sql = new StringBuffer("UPDATE " + TABELA + " SET ");
				
		//Sempre guarda a Chave do usuario e a hora que esta sendo executada a alteracao da tarefa.
		sql.append(CODIGO_USUARIO_ALTERADOR + " = ?, ");
		sql.append(TS_ALT_ATVD + "  =? ");		
		sql.append(" WHERE 1=1 ");
		
		if(tarefaTO.getAnoCriacao()!=0){
			sql.append("AND " + ANO + " =? ");
		}
		if(tarefaTO.getCodigo()!=0){
			sql.append("AND " + CODIGO + " =? ");
		}
		PreparedStatement stmt;
		
		try{
			int i=0;
			stmt = getConnection().prepareStatement(sql.toString());			
			//Sempre guarda a Chave do usuario e a hora que esta sendo executada a alteracao da tarefa.
			stmt.setInt(++i, tarefaTO.getCodUsuAlteracao());
			stmt.setTimestamp(++i, tarefaTO.getTsAlteracao());
			
			if(tarefaTO.getAnoCriacao()!=0){		
				stmt.setInt(++i, tarefaTO.getAnoCriacao());
			}
			if(tarefaTO.getCodigo()!=0){
				stmt.setInt(++i, tarefaTO.getCodigo());
			}
			stmt.executeUpdate();
		}catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
	}
	
	@SuppressWarnings({ "unchecked", "unchecked" })
	public Collection consultarTarefaFerramentaConfiguracao(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO, ParseException {
		StringBuffer sql = new StringBuffer("SELECT ");
		sql.append(ANO + ", ");
        sql.append(CODIGO + ", ");	
        sql.append(NOME + ", ");
        sql.append(CODIGO_ESTADO + ", ");
        sql.append(PRIORIDADE + ", ");
        sql.append(CODIGO_TIPO + ", ");
        sql.append(DATA_LIMITE_FINALIZACAO + ", ");
        sql.append(DATA_INICIO + ", ");
        sql.append(DATA_FIM + ", ");
        sql.append(TS_CRIC_ATVD + ", ");
        sql.append(TS_ALT_ATVD + ", ");
        sql.append(CODIGO_USUARIO_CRIADOR + ", ");
        sql.append(CODIGO_SOLICITANTE + ", ");
        sql.append(CODIGO_MAPA + ", ");
        sql.append(CODIGO_PERSPECTIVA + ", ");
        sql.append(CODIGO_OBJETIVO + ", ");
        sql.append(CODIGO_INDICADOR + ", ");
        sql.append(TEXTO_SOLICITACAO);
		sql.append(" FROM ");
		sql.append(TABELA);		
		sql.append(" WHERE 1=1 and ");
		if (tarefaTO.getCodIndicador() != 0) {
			sql.append(CODIGO_INDICADOR + " = ? ");
		}
		if (tarefaTO.getCodObjetivo() != 0) {
			sql.append(CODIGO_OBJETIVO + " = ? ");
		}
		if (tarefaTO.getCodPerspectiva() != 0) {
			sql.append(CODIGO_PERSPECTIVA + " = ? ");
		}
		if (tarefaTO.getCodMapa() != 0) {
			sql.append(CODIGO_MAPA + " = ? AND (" 
					+ CODIGO_INDICADOR + " IS NULL OR " + CODIGO_INDICADOR + "=0) AND("
					+ CODIGO_OBJETIVO + " IS NULL OR " + CODIGO_OBJETIVO + "=0) AND("
					+ CODIGO_PERSPECTIVA + " IS NULL OR " + CODIGO_PERSPECTIVA + "=0) ");
		}
		if (tarefaTO.getCodMapa() == 0 || tarefaTO.getCodPerspectiva() == 0 || tarefaTO.getCodObjetivo() == 0 || tarefaTO.getCodIndicador() ==0)
		sql.append(" ORDER BY " + NOME);
	
		PreparedStatement stmt;
		ResultSet result;		
		try {
		    int i=0;
			stmt = getConexao().prepareStatement(sql.toString());
			if (tarefaTO.getCodIndicador() != 0) {
				stmt.setInt(++i,tarefaTO.getCodIndicador());
			}
			if (tarefaTO.getCodObjetivo() != 0) {
				stmt.setInt(++i,tarefaTO.getCodObjetivo());
			}
			if (tarefaTO.getCodPerspectiva() != 0) {
				stmt.setInt(++i,tarefaTO.getCodPerspectiva());
			}
			if (tarefaTO.getCodMapa() != 0) {
				stmt.setInt(++i,tarefaTO.getCodMapa());
			}
			
			result = stmt.executeQuery();
			Collection listaTarefa = new ArrayList();
			while (result.next()) {
				listaTarefa.add(carregarTO(result));
			}
			return listaTarefa;
		} 
		catch (SQLException e) {
		    log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
	}
	
	public void excluirTarefaIndicador(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO, ParseException {			
		StringBuffer sql = new StringBuffer("UPDATE " + TABELA + " SET ");
		sql.append(CODIGO_INDICADOR + " = ? ," );
		sql.append(CODIGO_MAPA + " = 0 " );
		sql.append(" WHERE 1=1 ");
		sql.append("AND " + ANO + " = ? ");	
		sql.append("AND " + CODIGO + " = ? ");
		PreparedStatement stmt = null;
		
		try{
			int i=0;
			stmt = getConnection().prepareStatement(sql.toString());		
			stmt.setInt(++i, tarefaTO.getCodIndicador());/*Para excluir o relacionamento de indicador com tarefa. Deve-se alterar a tabela para o campo referente ao indicador para ZERo*/
			stmt.setInt(++i, tarefaTO.getAnoCriacao());
			stmt.setInt(++i, tarefaTO.getCodigo());
			stmt.executeUpdate();
		}
		catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public JasperPrint relatorioGrupoTarefa(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO {
		try {
			Map parameters = new HashMap();
			//Parametros do relatorio
	        Locale locale = new Locale("pt" , "BR");
			parameters.put(JRParameter.REPORT_LOCALE, locale);
			parameters.put("chaveParticipante", new Integer(tarefaTO.getCodUsuario()));
			parameters.put("baseDir", tarefaTO.getBaseDir());	
			JasperPrint relatorioFinal = JasperFillManager.fillReport(tarefaTO.getJasperReport(),parameters, getConexao());
			return relatorioFinal;
		} catch (JRException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public JasperPrint imprimirTarefa(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO {
		try {
			Map parameters = new HashMap();
			//Parametros do relatorio
	        Locale locale = new Locale("pt" , "BR");
			parameters.put(JRParameter.REPORT_LOCALE, locale);
			parameters.put("ano", new Integer(tarefaTO.getAno()));
			parameters.put("numero", new Integer(tarefaTO.getCodigo()));
			parameters.put("BaseDir", tarefaTO.getBaseDir());	
			JasperPrint relatorioFinal = JasperFillManager.fillReport(tarefaTO.getJasperReport(),parameters, getConexao());
			return relatorioFinal;
		} catch (JRException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public JasperPrint relatorioGMesTarefas(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO {
		try {
			Map parameters = new HashMap();
			//Parametros do relatorio
	        Locale locale = new Locale("pt" , "BR");
			parameters.put(JRParameter.REPORT_LOCALE, locale);
			parameters.put("chaveParticipante", new Integer(tarefaTO.getCodUsuario()));
			parameters.put("baseDir", tarefaTO.getBaseDir());
			parameters.put("ano", tarefaTO.getAno());	
			parameters.put("mes", tarefaTO.getMes());	
			JasperPrint relatorioFinal = JasperFillManager.fillReport(tarefaTO.getJasperReport(),parameters, getConexao());
			return relatorioFinal;
		} catch (JRException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public JasperPrint imprimirAgenda(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO {
		try {
			Map parameters = new HashMap();
			//Parametros do relatorio
	        Locale locale = new Locale("pt" , "BR");
			parameters.put(JRParameter.REPORT_LOCALE, locale);
			parameters.put("chaveParticipante", new Integer(tarefaTO.getCodUsuario()));
			parameters.put("baseDir", tarefaTO.getBaseDir());
			JasperPrint relatorioFinal = JasperFillManager.fillReport(tarefaTO.getJasperReport(),parameters, getConexao());
			return relatorioFinal;
		} catch (JRException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
	}

	public void excluirTarefaMapa(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO, ParseException {
		StringBuffer sql = new StringBuffer("UPDATE " + TABELA + " SET ");
		sql.append(CODIGO_MAPA + " = ? " );
		sql.append(" WHERE 1=1 ");
		sql.append("AND " + ANO + " = ? ");	
		sql.append("AND " + CODIGO + " = ? ");
		PreparedStatement stmt = null;
		
		try{
			int i=0;
			stmt = getConnection().prepareStatement(sql.toString());		
			stmt.setInt(++i, tarefaTO.getCodMapa());/*Para excluir o relacionamento de indicador com tarefa. Deve-se alterar a tabela para o campo referente ao indicador para ZERo*/
			stmt.setInt(++i, tarefaTO.getAnoCriacao());
			stmt.setInt(++i, tarefaTO.getCodigo());
			stmt.executeUpdate();
		}
		catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
		
	}

	public void excluirTarefaObjetivo(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO, ParseException {
		StringBuffer sql = new StringBuffer("UPDATE " + TABELA + " SET ");
		sql.append(CODIGO_OBJETIVO + " = ? ," );
		sql.append(CODIGO_MAPA + " = 0 " );
		sql.append(" WHERE 1=1 ");
		sql.append("AND " + ANO + " = ? ");	
		sql.append("AND " + CODIGO + " = ? ");
		PreparedStatement stmt = null;
		
		try{
			int i=0;
			stmt = getConnection().prepareStatement(sql.toString());		
			stmt.setInt(++i, tarefaTO.getCodObjetivo());/*Para excluir o relacionamento de indicador com tarefa. Deve-se alterar a tabela para o campo referente ao indicador para ZERo*/
			stmt.setInt(++i, tarefaTO.getAnoCriacao());
			stmt.setInt(++i, tarefaTO.getCodigo());
			stmt.executeUpdate();
		}
		catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
		
	}

	public void excluirTarefaPerspectiva(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO, ParseException {
		StringBuffer sql = new StringBuffer("UPDATE " + TABELA + " SET ");
		sql.append(CODIGO_PERSPECTIVA + " = ? ," );
		sql.append(CODIGO_MAPA + " = 0 " );
		sql.append(" WHERE 1=1 ");
		sql.append("AND " + ANO + " = ? ");	
		sql.append("AND " + CODIGO + " = ? ");
		PreparedStatement stmt = null;
		
		try{
			int i=0;
			stmt = getConnection().prepareStatement(sql.toString());		
			stmt.setInt(++i, tarefaTO.getCodPerspectiva());/*Para excluir o relacionamento de indicador com tarefa. Deve-se alterar a tabela para o campo referente ao indicador para ZERo*/
			stmt.setInt(++i, tarefaTO.getAnoCriacao());
			stmt.setInt(++i, tarefaTO.getCodigo());
			stmt.executeUpdate();
		}
		catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
		
	}

// Excluir tarefas dos processos
	
	public void excluirTarefaProcesso(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO, ParseException {
		StringBuffer sql = new StringBuffer("UPDATE " + TABELA + " SET ");
		sql.append(CODIGO_PROCESSO + " = ? " );
		sql.append(" WHERE 1=1 ");
		sql.append("AND " + ANO + " = ? ");	
		sql.append("AND " + CODIGO + " = ? ");
		PreparedStatement stmt = null;
		
		try{
			int i=0;
			stmt = getConnection().prepareStatement(sql.toString());		
			stmt.setInt(++i, tarefaTO.getCodProc());/*Para excluir o relacionamento de indicador com tarefa. Deve-se alterar a tabela para o campo referente ao indicador para ZERo*/
			stmt.setInt(++i, tarefaTO.getAnoCriacao());
			stmt.setInt(++i, tarefaTO.getCodigo());
			stmt.executeUpdate();
		}
		catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
		
	}

	public void excluirTarefaAtividade(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO, ParseException {
		StringBuffer sql = new StringBuffer("UPDATE " + TABELA + " SET ");
		sql.append(CODIGO_ATIVIDADE + " = ? ," );
		sql.append(CODIGO_PROCESSO + " = 0 " );
		sql.append(" WHERE 1=1 ");
		sql.append("AND " + ANO + " = ? ");	
		sql.append("AND " + CODIGO + " = ? ");
		PreparedStatement stmt = null;
		
		try{
			int i=0;
			stmt = getConnection().prepareStatement(sql.toString());		
			stmt.setInt(++i, tarefaTO.getCodAtividade());/*Para excluir o relacionamento de indicador com tarefa. Deve-se alterar a tabela para o campo referente ao indicador para ZERo*/
			stmt.setInt(++i, tarefaTO.getAnoCriacao());
			stmt.setInt(++i, tarefaTO.getCodigo());
			stmt.executeUpdate();
		}
		catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
		
	}

	public void excluirTarefaFase(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO, ParseException {
		StringBuffer sql = new StringBuffer("UPDATE " + TABELA + " SET ");
		sql.append(CODIGO_FASE + " = ? ," );
		sql.append(CODIGO_PROCESSO + " = 0 " );
		sql.append(" WHERE 1=1 ");
		sql.append("AND " + ANO + " = ? ");	
		sql.append("AND " + CODIGO + " = ? ");
		PreparedStatement stmt = null;
		
		try{
			int i=0;
			stmt = getConnection().prepareStatement(sql.toString());		
			stmt.setInt(++i, tarefaTO.getCodFase());/*Para excluir o relacionamento de indicador com tarefa. Deve-se alterar a tabela para o campo referente ao indicador para ZERo*/
			stmt.setInt(++i, tarefaTO.getAnoCriacao());
			stmt.setInt(++i, tarefaTO.getCodigo());
			stmt.executeUpdate();
		}
		catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
		
	}
	
}
