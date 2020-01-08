package br.com.intraPRO.persistencia.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;

import br.com.intraBSC.persistencia.BscDaoJDBCGenerico;
import br.com.intraBSC.persistencia.JDBC.RelacionamentosDAOJDBC;
import br.com.intraBSC.persistencia.JDBC.UsuarioDAOJDBC;
import br.com.intraPRO.persistencia.jdbc.ParticipanteDAOImpl;
import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.TarefaTO;
import br.com.intraPRO.modelo.ConfigTarefaTO;
import br.com.intraPRO.modelo.ParticipanteTO;
import br.com.intraPRO.persistencia.ConfigTarefaDAO;


public class ConfigTarefaDAOImpl extends BscDaoJDBCGenerico implements ConfigTarefaDAO {
	private static Log log = LogFactory.getLog(ConfigTarefaDAOImpl.class);
	protected final static String TABELA = "CONFIGURATIONTASK";
	protected final static String CODIGO = "PK_CONFIGTASK";
	protected final static String NUMERO_DIAS_PREVISTOS = "NUMBER_DAY_PREVISIONT_TASK";
	protected final static String VIGENTE = "IN_CONFIGTASK_EFFECTIVE";
	protected final static String NOME = "TX_CONFIGTASK";
	protected final static String INDVISIVELPREFIXO = "FK_BASE_ADMC";
	protected final static String CODIGO_CRITICIDADE_INI_TAREFA = "FK_PRIORITY_BEGIN_TASK";
	protected final static String CODIGO_ESTADO_INI_TAREFA = "FK_STATUS_BEGIN_TASK";
	protected final static String TEXTO_SOLICITACAO_INI_TAREFA = "TX_BEGIN_DESCRIPTION_TASK";
	protected final static String NOME_TAREFA_INI_TAREFA = "NAME_BEGIN_TASK";
	
	
	protected final static String TABELA_PARTICIPANTE = "taskactor";
	protected final static String CODIGO_USU_EXECUTANTE = "FK_ACTOR";	
	protected final static String CODIGO_TIPO_PARTICIPACAO = "ID_TYPE_PRTC";	
	
	
	protected final static String TABELA_TIPO_TAREFA = "configurationtask";
	
	
    protected final static String TABELA_TAREFA = "task";
    protected final static String ANO = "PK_YEAR_START_TASK";
    protected final static String CODIGO_ATVD = "PK_NUMBER_SEQUENCE_TASK";
    protected final static String NOME_ATVD = "NAME_TASK";
    protected final static String CODIGO_ESTADO = "FK_STATUS_TASK";
    protected final static String CODIGO_CRITICIADADE = "FK_PRIORITY_TASK";
    protected final static String CODIGO_TIPO = "PK_CONFIGTASK";
    protected final static String DATA_LIMITE_FINALIZACAO = "DT_LIMIT_END_TASK";
    protected final static String DATA_INICIO = "DT_BEGIN_TASK";
    protected final static String DATA_FIM = "DT_END_TASK";
    protected final static String DATA_PREVISAO_INICIO = "DT_PREVISION_BEGIN_TASK";
    protected final static String DATA_PREVISAO_FIM = "DT_PREVISION_END_TASK";
    protected final static String CODIGO_USUARIO_SOLICITANTE = "FK_CODE_ACTOR_SEND";
    protected final static String TS_CRIC_ATVD = "TS_START_TASK";
    protected final static String TS_ALT_ATVD = "TS_MODIFY_TASK";
    protected final static String CODIGO_USUARIO_CRIADOR = "FK_ACTOR_INIT_TASK";
    protected final static String CODIGO_USUARIO_ALTERADOR = "FK_ACTOR_MODIFY_TASK";
    protected final static String TEXTO_SOLICITACAO = "TX_DESCRIPTION_TASK";
    
    /*Variaveis referente a tabela de relacionamento de configuracao da tarefa com responsavel*/
    protected static final String TABELA_REL_CONFIG_TAREFA = "RELCONFIGTASKOWNER";
    protected static final String ID_RESPONSAVEL_REL = "OWNER_ID";
    protected static final String ID_CONFIG_TAREFA_REL = "CONFIG_TASK_ID";
	
	

	public ConfigTarefaDAOImpl(DaoManager daoManager) {
		super(daoManager);
	}

	/*
	 * Método utilizado para incluir um tipo de tarefa. Ele está preparado para receber ou não, qualquer um
	 * dos parametros enviados pela jsp.
	 */
	public void incluir(ConfigTarefaTO configTarefaTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("INSERT INTO ");
		sql.append(TABELA + "(");
		if (configTarefaTO.getCodigoConfigTarefa() != 0){
			sql.append(CODIGO + ", ");
		}
		if (configTarefaTO.getNumDiasPrevistos() != 0){
			sql.append(NUMERO_DIAS_PREVISTOS + ", ");
		}
		if ((configTarefaTO.getIndTipoVigencia() != null) && (!configTarefaTO.getIndTipoVigencia().equals(""))){
			sql.append(VIGENTE + ", ");
		}
		if ((configTarefaTO.getTextoConfigTarefa() != null) && (!configTarefaTO.getTextoConfigTarefa().equals(""))){
			sql.append(NOME + ", ");
		}
		if (configTarefaTO.getCodCriticidadeIniTarefa() != 0){
			sql.append(CODIGO_CRITICIDADE_INI_TAREFA + ", ");
		}
		if (configTarefaTO.getCodEstadoIniTarefa() != 0){
			sql.append(CODIGO_ESTADO_INI_TAREFA + ", ");
		}
		if (configTarefaTO.getTxtSolicitacaoIniTarefa() != null){
			sql.append(TEXTO_SOLICITACAO_INI_TAREFA + ", ");
		}
		if (configTarefaTO.getNomeIniTarefa() != null){
			sql.append(NOME_TAREFA_INI_TAREFA + ", ");
		}
		if (configTarefaTO.getIndVisivelPrefixo() != 0){
			sql.append(INDVISIVELPREFIXO);
		}
        else {
            sql.delete(sql.length() - 2, sql.length());
        }
		sql.append(") VALUES (");

		if (configTarefaTO.getCodigoConfigTarefa() != 0){
			sql.append("?, ");
		}
		if (configTarefaTO.getCodigoPrefGestorTipo() != 0){
			sql.append("?, ");
		}
		if (configTarefaTO.getNumDiasPrevistos() != 0){
			sql.append("?, ");
		}
		if ((configTarefaTO.getIndTipoVigencia() != null) && (!configTarefaTO.getIndTipoVigencia().equals(""))){
			sql.append("?, ");
		}
		if ((configTarefaTO.getTextoConfigTarefa() != null) && (!configTarefaTO.getTextoConfigTarefa().equals(""))){
			sql.append("?, ");
		}
		if (configTarefaTO.getCodCriticidadeIniTarefa() != 0){
			sql.append("?, ");
		}
		if (configTarefaTO.getCodEstadoIniTarefa() != 0){
			sql.append("?, ");
		}
		if (configTarefaTO.getTxtSolicitacaoIniTarefa() != null){
			sql.append("?, ");
		}
		if (configTarefaTO.getNomeIniTarefa() != null){
			sql.append("?, ");
		}
		if (configTarefaTO.getIndVisivelPrefixo() != 0){
			sql.append("? ");
		}
        else {
            sql.delete(sql.length() - 2, sql.length());
        }
        sql.append(")");
        
		PreparedStatement stmt;
		try {
			int i = 0;
			stmt = getConnection().prepareStatement(sql.toString());

			if (configTarefaTO.getCodigoConfigTarefa() != 0){
				stmt.setInt(++i, configTarefaTO.getCodigoConfigTarefa());
			}
			if (configTarefaTO.getCodigoPrefGestorTipo() != 0){
				stmt.setInt(++i, configTarefaTO.getCodigoPrefGestorTipo());
			}
			if ((configTarefaTO.getNumDiasPrevistos() != 0)){
				stmt.setInt(++i, configTarefaTO.getNumDiasPrevistos());
			}
			if ((configTarefaTO.getIndTipoVigencia() != null) && (!configTarefaTO.getIndTipoVigencia().equals(""))){
				stmt.setString(++i, configTarefaTO.getIndTipoVigencia());
			}
			if ((configTarefaTO.getTextoConfigTarefa() != null) && (!configTarefaTO.getTextoConfigTarefa().equals(""))){
				stmt.setString(++i, configTarefaTO.getTextoConfigTarefa().trim());
			}
			
			if (configTarefaTO.getCodCriticidadeIniTarefa() != 0){
				stmt.setInt(++i, configTarefaTO.getCodCriticidadeIniTarefa());
			}
			if (configTarefaTO.getCodEstadoIniTarefa() != 0){
				stmt.setInt(++i, configTarefaTO.getCodEstadoIniTarefa());
			}
			if (configTarefaTO.getTxtSolicitacaoIniTarefa() != null){
				stmt.setString(++i, configTarefaTO.getTxtSolicitacaoIniTarefa().trim());
			}
			if (configTarefaTO.getNomeIniTarefa() != null){
				stmt.setString(++i, configTarefaTO.getNomeIniTarefa().trim());
			}
			
			if (configTarefaTO.getIndVisivelPrefixo() != 0){
				stmt.setInt(++i,configTarefaTO.getIndVisivelPrefixo());
			}
			stmt.executeUpdate();
		} 
		catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
	}
	/*
	 * Metodo que lista os tipos de tarefas utilizados para popular os combo box na jsp de pesquisa e alterção de 
	 * Etapa e Tarefa
	 */
	@SuppressWarnings("unchecked")
	public Collection consultarVarios(ConfigTarefaTO configTarefaTO)throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("SELECT DISTINCT ");
		sql.append(CODIGO + ", ");
		sql.append(NUMERO_DIAS_PREVISTOS + ", ");
		sql.append(VIGENTE + ", ");
		sql.append(CODIGO_CRITICIDADE_INI_TAREFA + ", ");
		sql.append(CODIGO_ESTADO_INI_TAREFA + ", ");
		sql.append(TEXTO_SOLICITACAO_INI_TAREFA + ", ");
		sql.append(NOME_TAREFA_INI_TAREFA + ", ");
		sql.append(NOME + ", ");
		sql.append("B."+ID_RESPONSAVEL_REL + ", ");
		sql.append(INDVISIVELPREFIXO);
		sql.append(" FROM " + TABELA + " A, " + TABELA_REL_CONFIG_TAREFA + " B ");
		sql.append("WHERE 1=1");
		sql.append(" AND A." + CODIGO + " = B." + ID_CONFIG_TAREFA_REL + " AND B." + ID_RESPONSAVEL_REL + " = ? ");
		

		if ((configTarefaTO.getTextoConfigTarefa() != null) && (!configTarefaTO.getTextoConfigTarefa().equals("")))			
			sql.append(" AND  UPPER(A." + NOME + ") LIKE ?");


		if ((configTarefaTO.getIndTipoVigencia() != null)
				&& (!configTarefaTO.getIndTipoVigencia().equals("")))
			sql.append(" AND A." + VIGENTE + " =?");

		if (configTarefaTO.getCodigoConfigTarefa() != 0)
			sql.append(" AND A." + CODIGO + " =?"); 

		if ((configTarefaTO.getNumDiasPrevistos() != 0))
			sql.append(" AND A." + NUMERO_DIAS_PREVISTOS + " =?");
		
		
		if (configTarefaTO.getCodCriticidadeIniTarefa() != 0){
			sql.append(" AND A." + CODIGO_CRITICIDADE_INI_TAREFA + " =? ");
		}
		if (configTarefaTO.getCodEstadoIniTarefa() != 0){
			sql.append(" AND A." + CODIGO_ESTADO_INI_TAREFA + " =? ");
		}
		if (configTarefaTO.getTxtSolicitacaoIniTarefa() != null){
			sql.append(" AND A." + TEXTO_SOLICITACAO_INI_TAREFA + " =? ");
		}
		if (configTarefaTO.getNomeIniTarefa() != null){
			sql.append(" AND A." + NOME_TAREFA_INI_TAREFA + "=? ");
		}
		if (configTarefaTO.getIndVisivelPrefixo() != 0){
			sql.append(" AND A." + INDVISIVELPREFIXO + " =? ");
		}

	
		PreparedStatement stmt;
		Collection listaConfigTarefa = new ArrayList();
		try {
			stmt = getConexao().prepareStatement(sql.toString());
			int i = 0;
			
			stmt.setInt(++i, configTarefaTO.getIdResponsavel());
			
			//UPPER do db2 util. para prever comparações de maiusculas e
			// minusculas com a string que vier da TO
			if ((configTarefaTO.getTextoConfigTarefa() != null)&& (!configTarefaTO.getTextoConfigTarefa().equals(""))){
				stmt.setString(++i, "%" + configTarefaTO.getTextoConfigTarefa().trim().toUpperCase() + "%");
			}
			if (configTarefaTO.getCodigoPrefGestorTipo() != 0){
				stmt.setInt(++i, configTarefaTO.getCodigoPrefGestorTipo());
			}
			if ((configTarefaTO.getIndTipoVigencia() != null)&& (!configTarefaTO.getIndTipoVigencia().equals(""))){
				stmt.setString(++i, configTarefaTO.getIndTipoVigencia());
			}
			if (configTarefaTO.getCodigoConfigTarefa() != 0){
				stmt.setInt(++i, configTarefaTO.getCodigoConfigTarefa());
			}
			if ((configTarefaTO.getNumDiasPrevistos() != 0)){
				stmt.setInt(++i, configTarefaTO.getCodigoConfigTarefa());
			}
			
			if (configTarefaTO.getCodCriticidadeIniTarefa() != 0){
				stmt.setInt(++i, configTarefaTO.getCodCriticidadeIniTarefa());
			}
			if (configTarefaTO.getCodEstadoIniTarefa() != 0){
				stmt.setInt(++i, configTarefaTO.getCodEstadoIniTarefa());
			}
			if (configTarefaTO.getTxtSolicitacaoIniTarefa() != null){
				stmt.setString(++i, configTarefaTO.getTxtSolicitacaoIniTarefa());
			}
			if (configTarefaTO.getNomeIniTarefa() != null){
				stmt.setString(++i, configTarefaTO.getNomeIniTarefa());
			}
			
			if (configTarefaTO.getIndVisivelPrefixo() != 0){
				stmt.setInt(++i,configTarefaTO.getIndVisivelPrefixo());
			}
			ResultSet resultado = stmt.executeQuery();

			while (resultado.next()) {
				listaConfigTarefa.add(carregarTOUmVarios(resultado));
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new DaoException(e.getMessage());
		}
		return listaConfigTarefa;
	}

	/*
	 * metodo para carregar a TO com os dados recuperados aqui na IMPL
	 */
	private ConfigTarefaTO carregarTO(ResultSet resultado) throws SQLException {
		ConfigTarefaTO result = new ConfigTarefaTO();
		result.setCodigoConfigTarefa(resultado.getInt(CODIGO));
		result.setNumDiasPrevistos(resultado.getInt(NUMERO_DIAS_PREVISTOS));
		result.setIndTipoVigencia(resultado.getString(VIGENTE));
		result.setCodCriticidadeIniTarefa(resultado.getInt(CODIGO_CRITICIDADE_INI_TAREFA));
		result.setCodEstadoIniTarefa(resultado.getInt(CODIGO_ESTADO_INI_TAREFA));
		result.setTxtSolicitacaoIniTarefa(resultado.getString(TEXTO_SOLICITACAO_INI_TAREFA));
		result.setNomeIniTarefa(resultado.getString(NOME_TAREFA_INI_TAREFA));
		result.setTextoConfigTarefa(resultado.getString(NOME));
		result.setIndVisivelPrefixo(resultado.getInt(INDVISIVELPREFIXO));
		
		return result;
	}
	
	/*
	 * metodo para carregar a TO com os dados recuperados aqui na IMPL
	 */
	private ConfigTarefaTO carregarTOUmVarios(ResultSet resultado) throws SQLException {
		ConfigTarefaTO result = new ConfigTarefaTO();
		result.setCodigoConfigTarefa(resultado.getInt(CODIGO));
		result.setNumDiasPrevistos(resultado.getInt(NUMERO_DIAS_PREVISTOS));
		result.setIndTipoVigencia(resultado.getString(VIGENTE));
		result.setCodCriticidadeIniTarefa(resultado.getInt(CODIGO_CRITICIDADE_INI_TAREFA));
		result.setCodEstadoIniTarefa(resultado.getInt(CODIGO_ESTADO_INI_TAREFA));
		result.setTxtSolicitacaoIniTarefa(resultado.getString(TEXTO_SOLICITACAO_INI_TAREFA));
		result.setNomeIniTarefa(resultado.getString(NOME_TAREFA_INI_TAREFA));
		result.setTextoConfigTarefa(resultado.getString(NOME));
		result.setIdResponsavel(resultado.getInt(ID_RESPONSAVEL_REL));
		result.setIndVisivelPrefixo(resultado.getInt(INDVISIVELPREFIXO));
		
		return result;
	}
	/**
	 * @return um objeto da classe Conection com a conexão a base de dados.
	 */
	private Connection getConexao() {
		return getConnection();
	}
	/*
	 *Consulta na tabela o maior valor para o campo código do tipo de tarefa e acrescenta 1 a este campo.
	 *O resultado desta operação é setado, posteriormente na TO, para servir de Identificador do tipo de tarefa. 
	 */	
	public int consultarMax() throws ExceptionPersistenciaPRO {
		String sqlMax = "SELECT MAX(" + CODIGO + ") AS " + CODIGO + " FROM " + TABELA;
		PreparedStatement stmt;
		ResultSet result;
		try {
			stmt = getConexao().prepareStatement(sqlMax);
			result = stmt.executeQuery();
			while (result.next()) {
				return result.getInt(CODIGO) + 1;
			}
		} 
		catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
		return 0;
	}
	/*
	 *Quando o usuário faz a pesquisa, uma página com uma tabela e o resultado dessa pesquisa é mostrada.
	 * Quando o usuário clicar em uma das linhas dessa tabela, este método fará a consulta desse registro selecionado, 
	 * através do seu código, na cláusula WHERE.
	 * A action, então, setrá este resultado na sessao para que a página de alteração possa ser montada.
	 */
	public ConfigTarefaTO consultarUm(ConfigTarefaTO configTarefaTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("SELECT ");
		sql.append(CODIGO + ", ");
		sql.append(NUMERO_DIAS_PREVISTOS + ", ");
		sql.append(VIGENTE + ", ");
		sql.append(CODIGO_CRITICIDADE_INI_TAREFA + ", ");
		sql.append(CODIGO_ESTADO_INI_TAREFA + ", ");
		sql.append(TEXTO_SOLICITACAO_INI_TAREFA + ", ");
		sql.append(NOME_TAREFA_INI_TAREFA + ", ");
		sql.append(NOME + ", ");
		sql.append("B."+ID_RESPONSAVEL_REL + ", ");
		sql.append(INDVISIVELPREFIXO);
		sql.append(" FROM " + TABELA + " A, " + TABELA_REL_CONFIG_TAREFA + " B ");
		sql.append(" WHERE 1=1");
		sql.append(" AND A." + CODIGO + " = B." + ID_CONFIG_TAREFA_REL);

		//UPPER do db2 util. para prever comparações de maiusculas e minusculas
		// com a string que vier da TO
		if ((configTarefaTO.getTextoConfigTarefa() != null) && (!configTarefaTO.getTextoConfigTarefa().equals("")))
			sql.append(" AND  UPPER(A." + NOME + ") = ?");

		if ((configTarefaTO.getIndTipoVigencia() != null) && (!configTarefaTO.getIndTipoVigencia().equals("")))
			sql.append(" AND A." + VIGENTE + " =?");
		
		if (configTarefaTO.getCodCriticidadeIniTarefa() != 0){
			sql.append(" AND A." + CODIGO_CRITICIDADE_INI_TAREFA + " =?");
		}
		if (configTarefaTO.getCodEstadoIniTarefa() != 0){
			sql.append(" AND A." + CODIGO_ESTADO_INI_TAREFA + " =?");
		}
		if (configTarefaTO.getTxtSolicitacaoIniTarefa() != null){
			sql.append(" AND A." + TEXTO_SOLICITACAO_INI_TAREFA + " =?");
		}
		if (configTarefaTO.getNomeIniTarefa() != null){
			sql.append(" AND A." + NOME_TAREFA_INI_TAREFA + " =?");
		}

		if (configTarefaTO.getCodigoConfigTarefa() != 0)
			sql.append(" AND A." + CODIGO + " =?");

		if ((configTarefaTO.getNumDiasPrevistos() != 0))
			sql.append(" AND A." + NUMERO_DIAS_PREVISTOS + " =?");

		if ((configTarefaTO.getIndVisivelPrefixo() != 0))
			sql.append(" AND A." + INDVISIVELPREFIXO + " =?");
	

		PreparedStatement stmt;
		ResultSet result;
		ConfigTarefaTO returnTO = new ConfigTarefaTO();
		try {
			stmt = getConexao().prepareStatement(sql.toString());
			int i = 0;

			//UPPER do db2 util. para prever comparações de maiusculas e
			// minusculas com a string que vier da TO
			if ((configTarefaTO.getTextoConfigTarefa() != null) && (!configTarefaTO.getTextoConfigTarefa().equals("")))
				stmt.setString(++i, "%" + configTarefaTO.getTextoConfigTarefa().trim().toUpperCase() + "%");

			if (configTarefaTO.getCodigoPrefGestorTipo() != 0)
				stmt.setInt(++i, configTarefaTO.getCodigoPrefGestorTipo());

			if ((configTarefaTO.getIndTipoVigencia() != null)&& (!configTarefaTO.getIndTipoVigencia().equals("")))
				stmt.setString(++i, configTarefaTO.getIndTipoVigencia());

			if (configTarefaTO.getCodCriticidadeIniTarefa() != 0){
				stmt.setInt(++i, configTarefaTO.getCodCriticidadeIniTarefa());
			}
			if (configTarefaTO.getCodEstadoIniTarefa() != 0){
				stmt.setInt(++i, configTarefaTO.getCodEstadoIniTarefa());
			}
			if (configTarefaTO.getTxtSolicitacaoIniTarefa() != null){
				stmt.setString(++i, configTarefaTO.getTxtSolicitacaoIniTarefa());
			}
			if (configTarefaTO.getNomeIniTarefa() != null){
				stmt.setString(++i, configTarefaTO.getNomeIniTarefa());
			}
			
			if (configTarefaTO.getCodigoConfigTarefa() != 0)
				stmt.setInt(++i, configTarefaTO.getCodigoConfigTarefa());

			if ((configTarefaTO.getNumDiasPrevistos() != 0))
				stmt.setInt(++i, configTarefaTO.getCodigoConfigTarefa());

			if ((configTarefaTO.getIndVisivelPrefixo() != 0))
				stmt.setInt(++i, configTarefaTO.getIndVisivelPrefixo());
			
			result = stmt.executeQuery();
			while (result.next()) {
				returnTO = carregarTOUmVarios(result);
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
		return returnTO;
	}

	/*
	 *Este método é utlizado quando o usuário clicar no botão salvar, na página de alteração do tipo de tarefa. 
	 */
	public void alterar(ConfigTarefaTO configTarefaTO)throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("UPDATE ");
		sql.append(TABELA);
		sql.append(" SET ");
		if ((configTarefaTO.getNumDiasPrevistos() != 0)){
			sql.append(NUMERO_DIAS_PREVISTOS + " =");
			sql.append(" ?, ");
		}
		if ((configTarefaTO.getIndTipoVigencia() != null)&& (!configTarefaTO.getIndTipoVigencia().equals(""))){
			sql.append(VIGENTE + " =");
			sql.append(" ?, ");
		}
		if (configTarefaTO.getCodCriticidadeIniTarefa() != 0){
			sql.append(CODIGO_CRITICIDADE_INI_TAREFA + " =");
			sql.append(" ?, ");
		}
		if (configTarefaTO.getCodEstadoIniTarefa() != 0){
			sql.append(CODIGO_ESTADO_INI_TAREFA + " =");
			sql.append(" ?, ");
		}
		if (configTarefaTO.getTxtSolicitacaoIniTarefa() != null){
			sql.append(TEXTO_SOLICITACAO_INI_TAREFA + " =");
			sql.append(" ?, ");
		}
		if (configTarefaTO.getNomeIniTarefa() != null){
			sql.append(NOME_TAREFA_INI_TAREFA + " =");
			sql.append(" ?, ");
		}
				
		if ((configTarefaTO.getTextoConfigTarefa() != null)&& (!configTarefaTO.getTextoConfigTarefa().equals(""))){
			sql.append(NOME + " =");
			sql.append("? ");
		}						
        else {
            sql.delete(sql.length() - 2, sql.length());
        }
		sql.append(" WHERE 1=1 ");

		sql.append("AND " + CODIGO + "=?");

		PreparedStatement stmt;		

		try {
			stmt = getConnection().prepareStatement(sql.toString());
			int i = 0;	
			if ((configTarefaTO.getNumDiasPrevistos() != 0)){
				stmt.setInt(++i, configTarefaTO.getNumDiasPrevistos());
 			}
			if ((configTarefaTO.getIndTipoVigencia() != null)&& (!configTarefaTO.getIndTipoVigencia().equals(""))){
				stmt.setString(++i, configTarefaTO.getIndTipoVigencia());
			}
			
			if (configTarefaTO.getCodCriticidadeIniTarefa() != 0){
				stmt.setInt(++i, configTarefaTO.getCodCriticidadeIniTarefa());
			}
			if (configTarefaTO.getCodEstadoIniTarefa() != 0){
				stmt.setInt(++i, configTarefaTO.getCodEstadoIniTarefa());
			}
			if (configTarefaTO.getTxtSolicitacaoIniTarefa() != null){
				stmt.setString(++i, configTarefaTO.getTxtSolicitacaoIniTarefa().trim());
			}
			if (configTarefaTO.getNomeIniTarefa() != null){
				stmt.setString(++i, configTarefaTO.getNomeIniTarefa().trim());
			}
 			if ((configTarefaTO.getTextoConfigTarefa() != null) && (!configTarefaTO.getTextoConfigTarefa().equals(""))){
				stmt.setString(++i, configTarefaTO.getTextoConfigTarefa());
			}
			if (configTarefaTO.getCodigoConfigTarefa() != 0){
				stmt.setInt(++i, configTarefaTO.getCodigoConfigTarefa());
			}
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public Collection consultarTiposPorTarefa(TarefaTO tarefaTO,ParticipanteTO participanteTO)throws ExceptionPersistenciaPRO {
		try{
		Collection listaTarefa = new ArrayList();
		PreparedStatement stmt;			
		StringBuffer sql = new StringBuffer("SELECT DISTINCT ");
		sql.append(" C." + CODIGO + ", ");		
		sql.append(" C." + NOME + " ");
		sql.append(" FROM " + TABELA_TAREFA + " A INNER JOIN " + TABELA + " C ON ");
		sql.append(" A." + CODIGO + " = C." + CODIGO);
		sql.append(" LEFT JOIN " + ParticipanteDAOImpl.TABELA + " B ");
		sql.append("ON (A." + ANO + " = " + "B." + ParticipanteDAOImpl.ANO_CRIACAO + " AND A." + CODIGO_ATVD + "=" + "B." + ParticipanteDAOImpl.NUMERO_SEQUENCIAL_TAREFA +")");
		sql.append(" WHERE 1=1 ");
		sql.append(" AND A." + CODIGO_ESTADO + "<=3 ");
		
	    int i=0;
		//Clausula where para campos de Participante
		if (participanteTO.getCodTipoParticipacao() == 1){
			sql.append(" AND (A."+ CODIGO_USUARIO_SOLICITANTE + "=?");
			if((participanteTO.getCodUsuario() != 0))
				sql.append(" OR B."+ ParticipanteDAOImpl.COD_USUARIO + "=? ) ");
				sql.append(" AND B." + ParticipanteDAOImpl.COD_TIPO_PARTICIPACAO + "=? ");
		}
		sql.append(" ORDER BY C." + NOME);
					
		stmt = getConexao().prepareStatement(sql.toString());
		
		//Clausula whrere para campos de Participante
		if (participanteTO.getCodTipoParticipacao() == 1){
			stmt.setInt(++i,tarefaTO.getCodUsuSolicitante());
			if((participanteTO.getCodUsuario() != 0)){
				stmt.setInt(++i,participanteTO.getCodUsuario());
				stmt.setInt(++i,participanteTO.getCodTipoParticipacao());
			}
			
		}
									
		ResultSet result = stmt.executeQuery();
		while (result.next()) {
			i=0;
			ConfigTarefaTO configTarefaTO = new ConfigTarefaTO();
			configTarefaTO.setCodigoConfigTarefa(result.getInt(++i));
			configTarefaTO.setTextoConfigTarefa(result.getString(++i));
			
			listaTarefa.add(configTarefaTO);
		}
		return listaTarefa;
	}catch (SQLException e) {
	    log.error(e.getMessage());
		throw new ExceptionPersistenciaPRO(e.getMessage());
	}		
	

	}
	
	/*
	 * Metodo que lista os tipos de tarefas utilizados para popular os combo box na jsp de pesquisa e alterção de 
	 * Etapa e Tarefa
	 */
	@SuppressWarnings("unchecked")
	public Collection consultarVariosVisivel(ConfigTarefaTO configTarefaTO)throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("SELECT ");
		sql.append(CODIGO + ", ");
		sql.append(NUMERO_DIAS_PREVISTOS + ", ");
		sql.append(VIGENTE + ", ");
		sql.append(CODIGO_CRITICIDADE_INI_TAREFA + ", ");
		sql.append(CODIGO_ESTADO_INI_TAREFA + ", ");
		sql.append(TEXTO_SOLICITACAO_INI_TAREFA + ", ");
		sql.append(NOME_TAREFA_INI_TAREFA + ", ");
		sql.append(NOME+", "+INDVISIVELPREFIXO);	
		sql.append(" FROM " + TABELA + " A ");
		sql.append("WHERE 1=1");


		if ((configTarefaTO.getIndTipoVigencia() != null)
				&& (!configTarefaTO.getIndTipoVigencia().equals("")))
			sql.append(" AND A." + VIGENTE + " =?");

	
		if ((configTarefaTO.getIndVisivelPrefixo() != 0) && ((configTarefaTO.getIndTipoVigencia() != null)&& (!configTarefaTO.getIndTipoVigencia().equals("")))){
			sql.append(" OR (A." + INDVISIVELPREFIXO + " =? ");
			sql.append(" AND A." + VIGENTE + " = ? )");
		}


		PreparedStatement stmt;
		Collection listaConfigTarefa = new ArrayList();
		try {
			stmt = getConexao().prepareStatement(sql.toString());
			int i = 0;

			
			if (configTarefaTO.getCodigoPrefGestorTipo() != 0){
				stmt.setInt(++i, configTarefaTO.getCodigoPrefGestorTipo());
			}
			if ((configTarefaTO.getIndTipoVigencia() != null)&& (!configTarefaTO.getIndTipoVigencia().equals(""))){
				stmt.setString(++i, configTarefaTO.getIndTipoVigencia());
			}
			
			if ((configTarefaTO.getIndVisivelPrefixo() != 0) && ((configTarefaTO.getIndTipoVigencia() != null)&& (!configTarefaTO.getIndTipoVigencia().equals("")))){
				stmt.setInt(++i,configTarefaTO.getIndVisivelPrefixo());
				stmt.setString(++i, configTarefaTO.getIndTipoVigencia());
			}
			
			ResultSet resultado = stmt.executeQuery();

			while (resultado.next()) {
				listaConfigTarefa.add(carregarTO(resultado));
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new DaoException(e.getMessage());
		}
		return listaConfigTarefa;
	}

	@SuppressWarnings("unchecked")
	public Collection consultarVariosPorGrupo(ConfigTarefaTO configTarefaTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("SELECT DISTINCT ");
		sql.append(" A." + CODIGO + ", ");
		sql.append(" A." + NUMERO_DIAS_PREVISTOS + ", ");
		sql.append(" A." + VIGENTE + ", ");
		sql.append(" A." + CODIGO_CRITICIDADE_INI_TAREFA + ", ");
		sql.append(" A." + CODIGO_ESTADO_INI_TAREFA + ", ");
		sql.append(" A." + TEXTO_SOLICITACAO_INI_TAREFA + ", ");
		sql.append(" A." + NOME_TAREFA_INI_TAREFA + ", ");
		sql.append(" A." + NOME + ", ");
		sql.append(" A." + INDVISIVELPREFIXO);
		sql.append(" FROM " + TABELA + " A, " + UsuarioDAOJDBC.TABELA + " B, "+ RelacionamentosDAOJDBC.TABELA_REL_CONFIG_TAREFA + " C ");
		sql.append("WHERE 1=1");
		sql.append(" AND B." + UsuarioDAOJDBC.GRUPO_USUARIO + " = ? ");
		sql.append(" AND B." + UsuarioDAOJDBC.ID_USUARIO + " = C." + RelacionamentosDAOJDBC.ID_RESPONSAVEL_REL);
		sql.append(" AND A." + CODIGO + " = C." + RelacionamentosDAOJDBC.ID_CONFIG_TAREFA_REL);
		
		if ((configTarefaTO.getTextoConfigTarefa() != null) && (!configTarefaTO.getTextoConfigTarefa().equals("")))			
			sql.append(" AND  UPPER(A." + NOME + ") LIKE ?");


		if ((configTarefaTO.getIndTipoVigencia() != null)
				&& (!configTarefaTO.getIndTipoVigencia().equals("")))
			sql.append(" AND A." + VIGENTE + " =?");
		
		PreparedStatement stmt;
		Collection listaConfigTarefa = new ArrayList();
		try {
			stmt = getConexao().prepareStatement(sql.toString());
			int i = 0;
			
			stmt.setInt(++i, configTarefaTO.getUsuarioTO().getGrupoTO().getCodigo());
			
			if ((configTarefaTO.getTextoConfigTarefa() != null)&& (!configTarefaTO.getTextoConfigTarefa().equals(""))){
				stmt.setString(++i, "%" + configTarefaTO.getTextoConfigTarefa().trim().toUpperCase() + "%");
			}
			if ((configTarefaTO.getIndTipoVigencia() != null) && (!configTarefaTO.getIndTipoVigencia().equals(""))){
				stmt.setString(++i, configTarefaTO.getIndTipoVigencia());
			}
			
			ResultSet resultado = stmt.executeQuery();

			while (resultado.next()) {
				listaConfigTarefa.add(carregarTO(resultado));
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new DaoException(e.getMessage());
		}
		return listaConfigTarefa;
	}
	
	
}