package br.com.intraPRO.modelo;

import java.util.Collection;


public class ConteudoFormularioTarefaTO {
	private int anoCriacao;
	
	private int codTarefa;

	private int codConfigTarefa;

	private int numeroOrdem;

	private String textoFormularioTarefa;

	private String nomeFormulario;
	
	private String indVigente;
	
	private int codTipoDadoFormulario;
	
	private Collection listaOpcaoTipoFormulario;
	

	public ConteudoFormularioTarefaTO() {

	}

	/**
	 * @return Returns the anoCriacao.
	 */
	public int getAnoCriacao() {
		return anoCriacao;
	}

	/**
	 * @param anoCriacao
	 *            The anoCriacao to set.
	 */
	public void setAnoCriacao(int anoCriacao) {
		this.anoCriacao = anoCriacao;
	}

	/**
	 * @return Returns the codTarefa.
	 */
	public int getCodTarefa() {
		return codTarefa;
	}

	/**
	 * @param codTarefa
	 *            The codTarefa to set.
	 */
	public void setCodTarefa(int codTarefa) {
		this.codTarefa = codTarefa;
	}

	/**
	 * @return Returns the codConfigTarefa.
	 */
	public int getCodConfigTarefa() {
		return codConfigTarefa;
	}

	/**
	 * @param codConfigTarefa
	 *            The codConfigTarefa to set.
	 */
	public void setCodConfigTarefa(int codConfigTarefa) {
		this.codConfigTarefa = codConfigTarefa;
	}

	/**
	 * @return Returns the numeroOrdem.
	 */
	public int getNumeroOrdem() {
		return numeroOrdem;
	}

	/**
	 * @param numeroOrdem
	 *            The numeroOrdem to set.
	 */
	public void setNumeroOrdem(int numeroOrdem) {
		this.numeroOrdem = numeroOrdem;
	}

	/**
	 * @return Returns the textoFormularioTarefa.
	 */
	public String getTextoFormularioTarefa() {
		return textoFormularioTarefa;
	}

	/**
	 * @param textoFormularioTarefa
	 *            The textoFormularioTarefa to set.
	 */
	public void setTextoFormularioTarefa(String textoFormularioTarefa) {
		this.textoFormularioTarefa = textoFormularioTarefa;
	}

	public String getNomeFormulario() {
		return nomeFormulario;
	}

	public void setNomeFormulario(String nomeFormulario) {
		this.nomeFormulario = nomeFormulario;
	}

	public String getIndVigente() {
		return indVigente;
	}

	public void setIndVigente(String indVigente) {
		this.indVigente = indVigente;
	}

	public int getCodTipoDadoFormulario() {
		return codTipoDadoFormulario;
	}

	public void setCodTipoDadoFormulario(int codTipoDadoFormulario) {
		this.codTipoDadoFormulario = codTipoDadoFormulario;
	}

	public Collection getListaOpcaoTipoFormulario() {
		return listaOpcaoTipoFormulario;
	}

	public void setListaOpcaoTipoFormulario(Collection listaOpcaoTipoFormulario) {
		this.listaOpcaoTipoFormulario = listaOpcaoTipoFormulario;
	}

}
