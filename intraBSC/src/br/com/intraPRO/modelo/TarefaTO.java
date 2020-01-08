
package br.com.intraPRO.modelo;

import java.sql.Date;
import java.sql.Timestamp;

import net.sf.jasperreports.engine.JasperReport;
/**
Classe que possui os items de Tarefa.
*/
public class TarefaTO{
   private int anoCriacao;
   private String codigoAno;
   private int codigo;
   private String nome;
   private int codDependencia;
   private int codEstado;
   private int codEstadoDesabilitado;
   private int codCriticidade;
   private int codConfigTarefa;
   private int numAgendamento;
   private int numOrdemAgendada;
   private Date dtLimitePrazo;   
   private Date dtInicio;
   private Date dtFim;
   private String nomeUsuSolicitante;   
   private int codUsuSolicitante;
   private int codUsuCriador;
   private String textoSolicitacao;      
   private Timestamp tsCriacao;
   private Timestamp tsAlteracao;
   private int codUsuAlteracao;
   private String estadoSimNao;
   
   private int codMapa;
   private int codPerspectiva;
   private int codObjetivo;
   private int codIndicador;
   
   private int codProc;
   private int codFase;
   private int codAtividade;
 
   //Variaveis para exibicao dos TimeStamp
   private String tsCriacaoS = "";
   private String tsAlteracaoS = "";
   private String dtPrazo = "";
   private int diasFaltam;//Varivel que indica quantos dias faltam para o final da tarefa
   
   //Variaveis criadas somente para utilizacao na pesquisa
   private String codUsuExecucao;
   private Date dtPeriodoInicio;
   private Date dtPeriodoFim;
   private Date dtPrazoInicio;
   private Date dtPrazoFim;
   
   private String relativo;
   private String ultAnotacaoTexto;
   private boolean ultAnotacao;
   private boolean anexo;
   private boolean ativPeriodica;
   private boolean chaveResponsavelExe;
   private String nomeConfigTarefa;
   private String nomeDependencia;
   private String execucao;
   private int codUsuario;
   
   private int statusModificado;
   
   private String grupoMesAno;
   /*Variavel utilizada para setar o valor da sinalização da pior tarefa. Esta variavel é utilizada na tela principal*/
   private int sinalizacaoGrupo;
   private int sinalizacaoTarefa;
   
   /*Variavel utiliza para passagem de parametros para os Relatorios*/
   private String transicaoRel;
   private String baseDir;
   private JasperReport jasperReport;
   private Integer mes;
   private Integer ano;
   
	/**
	 * @return Returns the dtPrazo.
	 */
	public String getDtPrazo() {
		return dtPrazo;
	}
	/**
	 * @param dtPrazo The dtPrazo to set.
	 */
	public void setDtPrazo(String dtPrazo) {
		this.dtPrazo = dtPrazo;
	}

	/**
	 * @return Returns the tsCriacaoS.
	 */
	public String getTsCriacaoS() {
		return tsCriacaoS;
	}
	/**
	 * @param tsCriacaoS The tsCriacaoS to set.
	 */
	public void setTsCriacaoS(String tsCriacaoS) {
		this.tsCriacaoS = tsCriacaoS;
	}
	/**
	 * @return Returns the tsAlteracaoS.
	 */
	public String getTsAlteracaoS() {
		return tsAlteracaoS;
	}
	/**
	 * @param tsAlteracaoS The tsAlteracaoS to set.
	 */
	public void setTsAlteracaoS(String tsAlteracaoS) {
		this.tsAlteracaoS = tsAlteracaoS;
	}


   public TarefaTO(){
   	
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
	public void setCodigoAno() {
		this.codigoAno =   getAnoCriacao() + "/" + getCodigo();
	}
	
	/**
	 * @return Returns the codigoAno.
	 */
	public String getCodigoAno() {	    
	    return codigoAno;
	}
	/**
	 * @param codigo The codigo to set.
	 */
	public void setCodigo(int codigo) {
	    this.codigo = codigo;
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
	public Date getDtFim() {
		return dtFim;
	}
	/**
	 * @param dtFim The dtFim to set.
	 */
	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}
	/**
	 * @return Returns the dtInicio.
	 */
	public Date getDtInicio() {
		return dtInicio;
	}
	/**
	 * @param dtInicio The dtInicio to set.
	 */
	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}
	/**
	 * @return Returns the dtLimite.
	 */
	public Date getDtLimitePrazo() {
		return dtLimitePrazo;
	}
	/**
	 * @param dtLimite The dtLimite to set.
	 */
	public void setDtLimitePrazo(Date dtLimite) {
		this.dtLimitePrazo = dtLimite;
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
	 * @return Returns the tsAlteracao.
	 */
	public Timestamp getTsAlteracao() {
		return tsAlteracao;
	}
	/**
	 * @param tsAlteracao The tsAlteracao to set.
	 */
	public void setTsAlteracao(Timestamp tsAlteracao) {
		this.tsAlteracao = tsAlteracao;
	}
	/**
	 * @return Returns the tsCriacao.
	 */
	public Timestamp getTsCriacao() {
		return tsCriacao;
	}
	/**
	 * @param tsCriacao The tsCriacao to set.
	 */
	public void setTsCriacao(Timestamp tsCriacao) {
		this.tsCriacao = tsCriacao;
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
	 * @return Returns the nomeUsuSolicitante.
	 */
	public String getNomeUsuSolicitante() {
		return nomeUsuSolicitante;
	}
	public String getCodUsuExecucao() {
		return codUsuExecucao;
	}
	public void setCodUsuExecucao(String codUsuExecucao) {
		this.codUsuExecucao = codUsuExecucao;
	}
	public Date getDtPeriodoFim() {
		return dtPeriodoFim;
	}
	public void setDtPeriodoFim(Date dtPeriodoFim) {
		this.dtPeriodoFim = dtPeriodoFim;
	}
	public Date getDtPeriodoInicio() {
		return dtPeriodoInicio;
	}
	public void setDtPeriodoInicio(Date dtPeriodoInicio) {
		this.dtPeriodoInicio = dtPeriodoInicio;
	}
	public Date getDtPrazoFim() {
		return dtPrazoFim;
	}
	public void setDtPrazoFim(Date dtPrazoFim) {
		this.dtPrazoFim = dtPrazoFim;
	}
	public Date getDtPrazoInicio() {
		return dtPrazoInicio;
	}
	public void setDtPrazoInicio(Date dtPrazoInicio) {
		this.dtPrazoInicio = dtPrazoInicio;
	}
	public boolean isAnexo() {
		return anexo;
	}
	public void setAnexo(boolean anexo) {
		this.anexo = anexo;
	}
	public boolean isAtivPeriodica() {
		return ativPeriodica;
	}
	public void setAtivPeriodica(boolean ativPeriodica) {
		this.ativPeriodica = ativPeriodica;
	}
	public String getRelativo() {
		return relativo;
	}
	public void setRelativo(String relativo) {
		this.relativo = relativo;
	}
	public void setCodigoAno(String codigoAno) {
		this.codigoAno = codigoAno;
	}
	public void setNomeUsuSolicitante(String nomeUsuSolicitante) {
		this.nomeUsuSolicitante = nomeUsuSolicitante;
	}
	public boolean isUltAnotacao() {
		return ultAnotacao;
	}
	public void setUltAnotacao(boolean ultAnotacao) {
		this.ultAnotacao = ultAnotacao;
	}
	public String getUltAnotacaoTexto() {
		return ultAnotacaoTexto;
	}
	public void setUltAnotacaoTexto(String ultAnotacaoTexto) {
		this.ultAnotacaoTexto = ultAnotacaoTexto;
	}
	public String getNomeConfigTarefa() {
		return nomeConfigTarefa;
	}
	public void setNomeConfigTarefa(String nomeConfigTarefa) {
		this.nomeConfigTarefa = nomeConfigTarefa;
	}
	public String getNomeDependencia() {
		return nomeDependencia;
	}
	public void setNomeDependencia(String nomeDependencia) {
		this.nomeDependencia = nomeDependencia;
	}
	public String getExecucao() {
		return execucao;
	}
	public void setExecucao(String execucao) {
		this.execucao = execucao;
	}
	
	public String getEstadoSimNao() {
		return estadoSimNao;
	}
	public void setEstadoSimNao(String estadoSimNao) {
		this.estadoSimNao = estadoSimNao;
	}
	public int getCodEstadoDesabilitado() {
		return codEstadoDesabilitado;
	}
	public void setCodEstadoDesabilitado(int codEstadoDesabilitado) {
		this.codEstadoDesabilitado = codEstadoDesabilitado;
	}
	public boolean isChaveResponsavelExe() {
		return chaveResponsavelExe;
	}
	public void setChaveResponsavelExe(boolean chaveResponsavelExe) {
		this.chaveResponsavelExe = chaveResponsavelExe;
	}
	public int getStatusModificado() {
		return statusModificado;
	}
	public void setStatusModificado(int statusModificado) {
		this.statusModificado = statusModificado;
	}
	public int getCodConfigTarefa() {
		return codConfigTarefa;
	}
	public void setCodConfigTarefa(int codConfigTarefa) {
		this.codConfigTarefa = codConfigTarefa;
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
	public int getDiasFaltam() {
		return diasFaltam;
	}
	public void setDiasFaltam(int diasFaltam) {
		this.diasFaltam = diasFaltam;
	}
	public int getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}
	public String getGrupoMesAno() {
		return grupoMesAno;
	}
	public void setGrupoMesAno(String grupoMesAno) {
		this.grupoMesAno = grupoMesAno;
	}
	public int getSinalizacaoGrupo() {
		return sinalizacaoGrupo;
	}
	public void setSinalizacaoGrupo(int sinalizacaoGrupo) {
		this.sinalizacaoGrupo = sinalizacaoGrupo;
	}
	public int getSinalizacaoTarefa() {
		return sinalizacaoTarefa;
	}
	public void setSinalizacaoTarefa(int sinalizacaoTarefa) {
		this.sinalizacaoTarefa = sinalizacaoTarefa;
	}
	public String getBaseDir() {
		return baseDir;
	}
	public void setBaseDir(String baseDir) {
		this.baseDir = baseDir;
	}
	public String getTransicaoRel() {
		return transicaoRel;
	}
	public void setTransicaoRel(String transicaoRel) {
		this.transicaoRel = transicaoRel;
	}
	public JasperReport getJasperReport() {
		return jasperReport;
	}
	public void setJasperReport(JasperReport jasperReport) {
		this.jasperReport = jasperReport;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public Integer getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	public int getCodProc() {
		return codProc;
	}
	public void setCodProc(int codProc) {
		this.codProc = codProc;
	}
	public int getCodFase() {
		return codFase;
	}
	public void setCodFase(int codFase) {
		this.codFase = codFase;
	}
	public int getCodAtividade() {
		return codAtividade;
	}
	public void setCodAtividade(int codAtividade) {
		this.codAtividade = codAtividade;
	}

}
