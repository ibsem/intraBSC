package br.com.intraPRO.modelo;

import java.util.Collection;


public class ConteudoItemTarefaTO {
	private int anoCriacao;
	
	private int codTarefa;

	private int codConfigTarefa;

	private int numeroOrdem;

	private String textoItemTarefa;

	private String nomeItem;
	
	private String indVigente;
	
	private int codTipoDadoItem;
	
	private Collection listaOpcaoTipoItem;
	

	public ConteudoItemTarefaTO() {

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
	 * @return Returns the textoItemTarefa.
	 */
	public String getTextoItemTarefa() {
		return textoItemTarefa;
	}

	/**
	 * @param textoItemTarefa
	 *            The textoItemTarefa to set.
	 */
	public void setTextoItemTarefa(String textoItemTarefa) {
		this.textoItemTarefa = textoItemTarefa;
	}

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	public String getIndVigente() {
		return indVigente;
	}

	public void setIndVigente(String indVigente) {
		this.indVigente = indVigente;
	}

	public int getCodTipoDadoItem() {
		return codTipoDadoItem;
	}

	public void setCodTipoDadoItem(int codTipoDadoItem) {
		this.codTipoDadoItem = codTipoDadoItem;
	}

	public Collection getListaOpcaoTipoItem() {
		return listaOpcaoTipoItem;
	}

	public void setListaOpcaoTipoItem(Collection listaOpcaoTipoItem) {
		this.listaOpcaoTipoItem = listaOpcaoTipoItem;
	}

}
