package br.com.intraPRO.participante.visao;

import org.apache.struts.validator.ValidatorForm;

import br.com.intraPRO.modelo.ParticipanteTO;

public class ParticipanteForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

	private int anoCriacao;
	private int codTarefa;
	private int codigo;
	private int codTipoParticipacao;
	private int codPapel;
	private int codCargo;

	private int codUsuario;
	private int[] listaIncluir;
	private String nomeFuncionario;
	private int matricula;

	private String nomeParticipante;
	private ParticipanteTO participanteTO;
	
	
	
	/*Variaveis que verifica quais as checks estao marcadas*/
	private boolean chkDependencia;
	private boolean chkDivisao;
	private boolean chkNucleo;
	private boolean chkFuncao;
	
	
	
	
	
	public ParticipanteTO getParticipanteTO() {
		return participanteTO;
	}
	public void setParticipanteTO(ParticipanteTO participanteTO) {
		
		participanteTO.setListaParticipante(getListaIncluir());
				
	}
	public int getAnoCriacao() {
		return anoCriacao;
	}
	public void setAnoCriacao(int anoCriacao) {
		this.anoCriacao = anoCriacao;
	}
	public int getCodTarefa() {
		return codTarefa;
	}
	public void setCodTarefa(int codTarefa) {
		this.codTarefa = codTarefa;
	}
	public int getCodCargo() {
		return codCargo;
	}
	public void setCodCargo(int codCargo) {
		this.codCargo = codCargo;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodTipoParticipacao() {
		return codTipoParticipacao;
	}
	public void setCodTipoParticipacao(int codTipoParticipacao) {
		this.codTipoParticipacao = codTipoParticipacao;
	}
	public int getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}
	public String getNomeParticipante() {
		return nomeParticipante;
	}
	public void setNomeParticipante(String nomeParticipante) {
		this.nomeParticipante = nomeParticipante;
	}
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public int[] getListaIncluir() {
		return listaIncluir;
	}
	public void setListaIncluir(int[] listaIncluir) {
		this.listaIncluir = listaIncluir;
	}

	/**
	 * @return Returns the serialVersionUID.
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}


	/**
	 * @return Returns the chkDependencia.
	 */
	public boolean isChkDependencia() {
		return chkDependencia;
	}
	/**
	 * @param chkDependencia The chkDependencia to set.
	 */
	public void setChkDependencia(boolean chkDependencia) {
		this.chkDependencia = chkDependencia;
	}
	/**
	 * @return Returns the chkDivisao.
	 */
	public boolean isChkDivisao() {
		return chkDivisao;
	}
	/**
	 * @param chkDivisao The chkDivisao to set.
	 */
	public void setChkDivisao(boolean chkDivisao) {
		this.chkDivisao = chkDivisao;
	}
	/**
	 * @return Returns the chkFuncao.
	 */
	public boolean isChkFuncao() {
		return chkFuncao;
	}
	/**
	 * @param chkFuncao The chkFuncao to set.
	 */
	public void setChkFuncao(boolean chkFuncao) {
		this.chkFuncao = chkFuncao;
	}
	/**
	 * @return Returns the chkNucleo.
	 */
	public boolean isChkNucleo() {
		return chkNucleo;
	}
	/**
	 * @param chkNucleo The chkNucleo to set.
	 */
	public void setChkNucleo(boolean chkNucleo) {
		this.chkNucleo = chkNucleo;
	}
	public int getCodPapel() {
		return codPapel;
	}
	public void setCodPapel(int codPapel) {
		this.codPapel = codPapel;
	}
}
