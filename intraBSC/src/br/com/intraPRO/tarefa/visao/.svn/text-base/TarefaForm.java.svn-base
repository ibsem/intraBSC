
package br.com.intraPRO.tarefa.visao;

import java.text.ParseException;

import org.apache.struts.validator.ValidatorForm;

import br.com.intraBSC.util.DataUtil;
import br.com.intraPRO.modelo.TarefaTO;


public class TarefaForm extends ValidatorForm{
   
   
   private int anoCriacao;
   private int codigo;
   private String nome;
   private int codDependencia;
   //setando estado para "não iniciado" como solicitado no use case 
   private int codEstado=1;
   private int codEstadoDesabilitado = 1;
   //setando criticidade para "baixa" como solicitado no use case
   private int codCriticidade=3;
   private int codConfigTarefa;
   private int numAgendamento;
   private int numOrdemAgendada;
   private String dtLimitePrazo;
   private String dtInicio;
   private String dtFim;
   private int codUsuSolicitante;
   private String nomeUsuSolicitante;   
   private int codUsuCriador;
   private String textoSolicitacao;
   private String execucao;
   private String acompanhamento;
   private String codigoAno;
   private String EstadoSimNao = "S";
   private String dtPrevisaoInicio;
   private String dtPrevisaoFim;
   
   private String tsCriacao;
   private int codUsuAlteracao;
   private String tsAlteracao;
   private String nomeUsuAlteracao;
   private String nomeUsuCriacao;
   
   /*Esta variavel vai informar qual o campo o usuario podera alterar.
    * Ela diz quais campo estarao habilitados e desabilitados para alteracao*/
   private int tipoParticipacao;
   
   /*
    * Campos especificamente utilizados na pesquisa de tarefa*/
   private String dtPrazoInicioPesq;
   private String dtPrazoFimPesq;
   private String dtPeriodoInicioPesq;
   private String dtPeriodoFimPesq;
   private String relativo;
   private String codUsuResponsavel;
   private boolean chkPrazo;
   private boolean chkNome;
   private boolean chkEstado;
   private boolean chkSolicitacao;
   private boolean chkCriticidade;
   private boolean chkConfigTarefa;
   private boolean chkUltAnotacao;
   private boolean chkChaveSolicitante;
   private boolean chkAvisoAnexo;
   private boolean chkDependencia;
   private boolean chkTarefaPeriodica;
   private boolean chkChaveResponsanvel;
   private boolean chkPeriodo;
   private int optEstado;
   
   /*Variavel de Vinculacao com mapa*/
   private int codMapa;
   private int codPerspectiva;
   private int codObjetivo;
   private int codIndicador;
   
   /*Variaveis do Email*/
   private String titulo;
   private String mensagemDe;
   private String[] mensagemPara;
   private String textoEmail;
   

   private int servico;
   
	/**
	 * @return Returns the nomeUsuAlteracao.
	 */
	public String getNomeUsuAlteracao() {
		return nomeUsuAlteracao;
	}
	/**
	 * @param nomeUsuAlteracao The nomeUsuAlteracao to set.
	 */
	public void setNomeUsuAlteracao(String nomeUsuAlteracao) {
		this.nomeUsuAlteracao = nomeUsuAlteracao;
	}
	/**
	 * @return Returns the nomeUsuCriacao.
	 */
	public String getNomeUsuCriacao() {
		return nomeUsuCriacao;
	}
	/**
	 * @param nomeUsuCriacao The nomeUsuCriacao to set.
	 */
	public void setNomeUsuCriacao(String nomeUsuCriacao) {
		this.nomeUsuCriacao = nomeUsuCriacao;
	}
   public TarefaForm(){
		
   }
   
   /**
   @throws ParseException
 * @roseuid 3B2384BC03B6
   */
   public void setTarefaTO(TarefaTO tarefaTO) throws ParseException{
	    tarefaTO.setAnoCriacao(getAnoCriacao());
	    tarefaTO.setCodigo(getCodigo());
   		tarefaTO.setCodConfigTarefa(getCodConfigTarefa());
   		tarefaTO.setCodEstado(getCodEstado());   		
   		tarefaTO.setCodEstadoDesabilitado(getCodEstadoDesabilitado());
   		tarefaTO.setCodCriticidade(getCodCriticidade());
   		tarefaTO.setCodUsuCriador(getCodUsuCriador());
   		tarefaTO.setCodUsuSolicitante(getCodUsuSolicitante());
   		tarefaTO.setNome(getNome());
   		tarefaTO.setNumAgendamento(getNumAgendamento());
   		tarefaTO.setNumOrdemAgendada(getNumOrdemAgendada());   		
   		tarefaTO.setTextoSolicitacao(getTextoSolicitacao());
   		
   		//setando datas
 		DataUtil dataUtil = new DataUtil();
 		
   		//setando o ano da data atual caso não exista
 		if (tarefaTO.getAnoCriacao() == 0){
 			tarefaTO.setAnoCriacao(dataUtil.getAnoDataAtual());
 		}
   		//convertendo e setando datas do form na TO
   		dataUtil.setData(getDtInicio());
   		tarefaTO.setDtInicio(dataUtil.getSQLDate(getDtInicio()));
   		
   		dataUtil.setData(getDtFim());
  		tarefaTO.setDtFim(dataUtil.getSQLDate(getDtFim()));

  		dataUtil.setData(getDtLimitePrazo());
   		tarefaTO.setDtLimitePrazo(dataUtil.getSQLDate(getDtLimitePrazo()));
   		
   		/*		if(getDtPrevisaoInicio() != null){
   			dataUtil.setData(getDtPrevisaoInicio());
   			tarefaTO.setDtPrevisaoInicio(dataUtil.getSQLDate(getDtPrevisaoInicio()));
   		}

   		if(getDtPrevisaoFim() != null){
   			dataUtil.setData(getDtPrevisaoFim());
   			tarefaTO.setDtPrevisaoFim(dataUtil.getSQLDate(getDtPrevisaoFim()));
   		}*/
   		
   		//convertendo data de hoje para timestamp e setando-a na TO
   		//buscando a data de hoje para setar a DataUtil
   		dataUtil.setData(dataUtil.getDataAtual());   		
   		
   		//setar a chave do usuário logado no sistema temporariamente para testes
   		tarefaTO.setExecucao(getExecucao());
   }
   

   public void setTarefaForm(TarefaTO tarefaTO) throws ParseException {
   		setAnoCriacao(tarefaTO.getAnoCriacao());
   		setCodigo(tarefaTO.getCodigo());
   		setCodigoAno(tarefaTO.getAnoCriacao()+"/"+tarefaTO.getCodigo());
   		setCodCriticidade(tarefaTO.getCodCriticidade());
   		setCodEstado(tarefaTO.getCodEstado());
   		setCodEstadoDesabilitado(tarefaTO.getCodEstadoDesabilitado());
   		setNome(tarefaTO.getNome());
   		setTextoSolicitacao(tarefaTO.getTextoSolicitacao());
   		setCodConfigTarefa(tarefaTO.getCodConfigTarefa());
   		setDtFim(DataUtil.formataDataSql(tarefaTO.getDtFim()));
   		setDtInicio(DataUtil.formataDataSql(tarefaTO.getDtInicio()));
   		setDtLimitePrazo(DataUtil.formataDataSql(tarefaTO.getDtLimitePrazo()));
   		setCodUsuSolicitante(tarefaTO.getCodUsuSolicitante());
   		setNomeUsuSolicitante(tarefaTO.getNomeUsuSolicitante());
   		setCodUsuAlteracao(tarefaTO.getCodUsuAlteracao());
   		setTsAlteracao(tarefaTO.getTsAlteracaoS());
   		setCodUsuCriador(tarefaTO.getCodUsuCriador());
   		setTsCriacao(tarefaTO.getTsCriacaoS());
   		//setDtPrevisaoFim(DataUtil.formataDataSql(tarefaTO.getDtPrevisaoFim()));
   		//setDtPrevisaoInicio(DataUtil.formataDataSql(tarefaTO.getDtPrevisaoInicio()));
   		setCodMapa(tarefaTO.getCodMapa());
   		setCodPerspectiva(tarefaTO.getCodPerspectiva());
   		setCodObjetivo(tarefaTO.getCodObjetivo());
   		setCodIndicador(tarefaTO.getCodIndicador());
  }
   
	/**
	 * @return Returns the anoCriacao.
	 */
	public int getAnoCriacao() {
		return anoCriacao;
	}
	/**
	 * @param anoCriacao The anoCriacao to set.
	 */
	public void setAnoCriacao(int anoCriacao) {
		this.anoCriacao = anoCriacao;
	}
	/**
	 * @return Returns the codCriticidade.
	 */
	public int getCodCriticidade() {
		return codCriticidade;
	}
	/**
	 * @param codCriticidade The codCriticidade to set.
	 */
	public void setCodCriticidade(int codCriticidade) {
		this.codCriticidade = codCriticidade;
	}
	/**
	 * @return Returns the codDependencia.
	 */
	public int getCodDependencia() {
		return codDependencia;
	}
	/**
	 * @param codDependencia The codDependencia to set.
	 */
	public void setCodDependencia(int codDependencia) {
		this.codDependencia = codDependencia;
	}
	/**
	 * @return Returns the codEstado.
	 */
	public int getCodEstado() {
		return codEstado;
	}
	/**
	 * @param codEstado The codEstado to set.
	 */
	public void setCodEstado(int codEstado) {
		this.codEstado = codEstado;
	}
	/**
	 * @return Returns the codigo.
	 */
	public int getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo The codigo to set.
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * @return Returns the codUsuCriador.
	 */
	public int getCodUsuCriador() {
		return codUsuCriador;
	}
	/**
	 * @param codUsuCriador The codUsuCriador to set.
	 */
	public void setCodUsuCriador(int codUsuCriador) {
		this.codUsuCriador = codUsuCriador;
	}
	/**
	 * @return Returns the codUsuSolicitante.
	 */
	public int getCodUsuSolicitante() {
		return codUsuSolicitante;
	}
	/**
	 * @param codUsuSolicitante The codUsuSolicitante to set.
	 */
	public void setCodUsuSolicitante(int codUsuSolicitante) {
		this.codUsuSolicitante = codUsuSolicitante;
	}
	/**
	 * @return Returns the dtFim.
	 */
	public String getDtFim() {
		return dtFim;
	}
	/**
	 * @param dtFim The dtFim to set.
	 */
	public void setDtFim(String dtFim) {
	     this.dtFim = dtFim;
	}
	/**
	 * @return Returns the dtInicio.
	 */
	public String getDtInicio() {
		return dtInicio;
	}
	/**
	 * @param dtInicio The dtInicio to set.
	 */
	public void setDtInicio(String dtInicio) {
		this.dtInicio = dtInicio;
	}
	/**
	 * @return Returns the nome.
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome The nome to set.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return Returns the numAgendamento.
	 */
	public int getNumAgendamento() {
		return numAgendamento;
	}
	/**
	 * @param numAgendamento The numAgendamento to set.
	 */
	public void setNumAgendamento(int numAgendamento) {
		this.numAgendamento = numAgendamento;
	}
	/**
	 * @return Returns the numOrdemAgendada.
	 */
	public int getNumOrdemAgendada() {
		return numOrdemAgendada;
	}
	/**
	 * @param numOrdemAgendada The numOrdemAgendada to set.
	 */
	public void setNumOrdemAgendada(int numOrdemAgendada) {
		this.numOrdemAgendada = numOrdemAgendada;
	}
	/**
	 * @return Returns the textoSolicitacao.
	 */
	public String getTextoSolicitacao() {
		return textoSolicitacao;
	}
	/**
	 * @param textoSolicitacao The textoSolicitacao to set.
	 */
	public void setTextoSolicitacao(String textoSolicitacao) {
		this.textoSolicitacao = textoSolicitacao;
	}
	/**
	 * @return Returns the nomeUsuSolicitante.
	 */
	public String getNomeUsuSolicitante() {
		return nomeUsuSolicitante;
	}
	/**
	 * @param nomeUsuSolicitante The nomeUsuSolicitante to set.
	 */
	public void setNomeUsuSolicitante(String nomeUsuSolicitante) {
		this.nomeUsuSolicitante = nomeUsuSolicitante;
	}
		
	/**
	 * @return Returns the dtLimitePrazo.
	 */
	public String getDtLimitePrazo() {
	    return dtLimitePrazo;
	}
	/**
	 * @param dtLimitePrazo The dtLimitePrazo to set.
	 */
	public void setDtLimitePrazo(String dtLimitePrazo) {
	    this.dtLimitePrazo = dtLimitePrazo;
	}
	/**
	 * @return Returns the execucao.
	 */
	public String getExecucao() {
	    return execucao;
	}
	/**
	 * @param execucao The execucao to set.
	 */
	public void setExecucao(String execucao) {
	    this.execucao = execucao;
	}
	/**
	 * @return Returns the acompanhamento.
	 */
	public String getAcompanhamento() {
	    return acompanhamento;
	}
	/**
	 * @param acompanhamento The acompanhamento to set.
	 */
	public void setAcompanhamento(String acompanhamento) {
	    this.acompanhamento = acompanhamento;
	}
	/**
	 * @return Returns the codigoAno.
	 */
	public String getCodigoAno() {
	    return codigoAno;
	}
	/**
	 * @param codigoAno The codigoAno to set.
	 */
	public void setCodigoAno(String codigoAno) {
	    this.codigoAno = codigoAno;
	}
	
	/**
	 * @return Returns the codUsuAlteracao.
	 */
	public int getCodUsuAlteracao() {
		return codUsuAlteracao;
	}
	/**
	 * @param codUsuAlteracao The codUsuAlteracao to set.
	 */
	public void setCodUsuAlteracao(int codUsuAlteracao) {
		this.codUsuAlteracao = codUsuAlteracao;
	}
	
	/**
	 * @return Returns the tsAlteracao.
	 */
	public String getTsAlteracao() {
		return tsAlteracao;
	}
	/**
	 * @param tsAlteracao The tsAlteracao to set.
	 */
	public void setTsAlteracao(String tsAlteracao) {
		this.tsAlteracao = tsAlteracao;
	}
	/**
	 * @return Returns the tsCriacao.
	 */
	public String getTsCriacao() {
		return tsCriacao;
	}
	/**
	 * @param tsCriacao The tsCriacao to set.
	 */
	public void setTsCriacao(String tsCriacao) {
		this.tsCriacao = tsCriacao;
	}
	/**
	 * @return Returns the tipoParticipacao.
	 */
	public int getTipoParticipacao() {
		return tipoParticipacao;
	}
	/**
	 * @param tipoParticipacao The tipoParticipacao to set.
	 */
	public void setTipoParticipacao(int tipoParticipacao) {
		this.tipoParticipacao = tipoParticipacao;
	}
	/*Metodos para pesquisa da tarefa
	 * */
	public boolean isChkTarefaPeriodica() {
		return chkTarefaPeriodica;
	}
	public void setChkTarefaPeriodica(boolean chkTarefaPeriodica) {
		this.chkTarefaPeriodica = chkTarefaPeriodica;
	}
	public boolean isChkChaveResponsanvel() {
		return chkChaveResponsanvel;
	}
	public void setChkChaveResponsanvel(boolean chkChaveResponsanvel) {
		this.chkChaveResponsanvel = chkChaveResponsanvel;
	}
	public boolean isChkCriticidade() {
		return chkCriticidade;
	}
	public void setChkCriticidade(boolean chkCriticidade) {
		this.chkCriticidade = chkCriticidade;
	}
	public boolean isChkDependencia() {
		return chkDependencia;
	}
	public void setChkDependencia(boolean chkDependencia) {
		this.chkDependencia = chkDependencia;
	}
	public boolean isChkEstado() {
		return chkEstado;
	}
	public void setChkEstado(boolean chkEstado) {
		this.chkEstado = chkEstado;
	}
	public boolean isChkNome() {
		return chkNome;
	}
	public void setChkNome(boolean chkNome) {
		this.chkNome = chkNome;
	}
	public boolean isChkPeriodo() {
		return chkPeriodo;
	}
	public void setChkPeriodo(boolean chkPeriodo) {
		this.chkPeriodo = chkPeriodo;
	}
	public boolean isChkPrazo() {
		return chkPrazo;
	}
	public void setChkPrazo(boolean chkPrazo) {
		this.chkPrazo = chkPrazo;
	}
	public boolean isChkSolicitacao() {
		return chkSolicitacao;
	}
	public void setChkSolicitacao(boolean chkSolicitacao) {
		this.chkSolicitacao = chkSolicitacao;
	}
	
	public boolean isChkUltAnotacao() {
		return chkUltAnotacao;
	}
	public void setChkUltAnotacao(boolean chkUltAnotacao) {
		this.chkUltAnotacao = chkUltAnotacao;
	}
	public String getCodUsuResponsavel() {
		return codUsuResponsavel;
	}
	public void setCodUsuResponsavel(String codUsuResponsavel) {
		this.codUsuResponsavel = codUsuResponsavel;
	}
	public String getDtPeriodoFimPesq() {
		return dtPeriodoFimPesq;
	}
	public void setDtPeriodoFimPesq(String dtPeriodoFimPesq) {
		this.dtPeriodoFimPesq = dtPeriodoFimPesq;
	}
	public String getDtPeriodoInicioPesq() {
		return dtPeriodoInicioPesq;
	}
	public void setDtPeriodoInicioPesq(String dtPeriodoInicioPesq) {
		this.dtPeriodoInicioPesq = dtPeriodoInicioPesq;
	}
	public String getDtPrazoFimPesq() {
		return dtPrazoFimPesq;
	}
	public void setDtPrazoFimPesq(String dtPrazoFimPesq) {
		this.dtPrazoFimPesq = dtPrazoFimPesq;
	}
	public String getDtPrazoInicioPesq() {
		return dtPrazoInicioPesq;
	}
	public void setDtPrazoInicioPesq(String dtPrazoInicioPesq) {
		this.dtPrazoInicioPesq = dtPrazoInicioPesq;
	}
	public String getRelativo() {
		return relativo;
	}
	public void setRelativo(String relativo) {
		this.relativo = relativo;
	}
	public int getOptEstado() {
		return optEstado;
	}
	public void setOptEstado(int optEstado) {
		this.optEstado = optEstado;
	}
	public boolean isChkChaveSolicitante() {
		return chkChaveSolicitante;
	}
	public void setChkChaveSolicitante(boolean chkChaveSolicitante) {
		this.chkChaveSolicitante = chkChaveSolicitante;
	}
	public boolean isChkAvisoAnexo() {
		return chkAvisoAnexo;
	}
	public void setChkAvisoAnexo(boolean chkAvisoAnexo) {
		this.chkAvisoAnexo = chkAvisoAnexo;
	}
	

	public void setTarefaTOPesquisa(TarefaTO tarefaTO) {
		DataUtil dataUtil = new DataUtil();
		tarefaTO.setCodigo(getCodigo());
		tarefaTO.setNome(getNome());
		tarefaTO.setTextoSolicitacao(getTextoSolicitacao());		
		tarefaTO.setCodConfigTarefa(getCodConfigTarefa());
		tarefaTO.setDtPrazoInicio(dataUtil.getSQLDate(getDtPrazoInicioPesq()));
   		tarefaTO.setDtPrazoFim(dataUtil.getSQLDate(getDtPrazoFimPesq()));
   		tarefaTO.setCodEstado(getCodEstado());
   		tarefaTO.setCodEstadoDesabilitado(getCodEstadoDesabilitado()); 
   		tarefaTO.setCodCriticidade(getCodCriticidade());
   		tarefaTO.setUltAnotacao(isChkUltAnotacao());
   		tarefaTO.setEstadoSimNao(getEstadoSimNao());
	}
	public String getEstadoSimNao() {
		return EstadoSimNao;
	}
	public void setEstadoSimNao(String estadoSimNao) {
		EstadoSimNao = estadoSimNao;
	}
	public int getCodEstadoDesabilitado() {
		return codEstadoDesabilitado;
	}
	public void setCodEstadoDesabilitado(int codEstadoDesabilitado) {
		this.codEstadoDesabilitado = codEstadoDesabilitado;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getMensagemDe() {
		return mensagemDe;
	}
	public void setMensagemDe(String mensagemDe) {
		this.mensagemDe = mensagemDe;
	}
	public String[] getMensagemPara() {
		return mensagemPara;
	}
	public void setMensagemPara(String[] mensagemPara) {
		this.mensagemPara = mensagemPara;
	}
	public String getTextoEmail() {
		return textoEmail;
	}
	public void setTextoEmail(String textoEmail) {
		this.textoEmail = textoEmail;
	}
	public int getCodConfigTarefa() {
		return codConfigTarefa;
	}
	public void setCodConfigTarefa(int codConfigTarefa) {
		this.codConfigTarefa = codConfigTarefa;
	}
	public int getServico() {
		return servico;
	}
	public void setServico(int servico) {
		this.servico = servico;
	}
	public boolean isChkConfigTarefa() {
		return chkConfigTarefa;
	}
	public void setChkConfigTarefa(boolean chkConfigTarefa) {
		this.chkConfigTarefa = chkConfigTarefa;
	}
	public String getDtPrevisaoFim() {
		return dtPrevisaoFim;
	}
	public void setDtPrevisaoFim(String dtPrevisaoFim) {
		this.dtPrevisaoFim = dtPrevisaoFim;
	}
	public String getDtPrevisaoInicio() {
		return dtPrevisaoInicio;
	}
	public void setDtPrevisaoInicio(String dtPrevisaoInicio) {
		this.dtPrevisaoInicio = dtPrevisaoInicio;
	}
	public int getCodIndicador() {
		return codIndicador;
	}
	public void setCodIndicador(int codIndicador) {
		this.codIndicador = codIndicador;
	}
	public int getCodMapa() {
		return codMapa;
	}
	public void setCodMapa(int codMapa) {
		this.codMapa = codMapa;
	}
	public int getCodObjetivo() {
		return codObjetivo;
	}
	public void setCodObjetivo(int codObjetivo) {
		this.codObjetivo = codObjetivo;
	}
	public int getCodPerspectiva() {
		return codPerspectiva;
	}
	public void setCodPerspectiva(int codPerspectiva) {
		this.codPerspectiva = codPerspectiva;
	}

		
	
	
}
