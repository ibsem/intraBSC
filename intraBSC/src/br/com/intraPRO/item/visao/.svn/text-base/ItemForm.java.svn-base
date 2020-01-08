
package br.com.intraPRO.item.visao;


import org.apache.struts.validator.ValidatorForm;

import br.com.intraPRO.modelo.ItemTO;

/**
 * Classe que implementa os dados do formulario de item.
 */
public class ItemForm extends ValidatorForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int codConfigTarefa;

	private int numeroOrdem;

	private String nome;

	private String indItemCritico = "S";

	private String indItemVigente;
		
	private int numeroOrdemDadoItem;
	private String nomeTextoCombo;
	private String[] listaTextoCombo;
	private int codigoDadoItem;

	
	/*Variavel criada para caso o usuario queria trocar o valor do numero de ordem.
	    * Desta forma deve-se guardar o valor anterior, por este campo fazer parte da chave primaria  */
	private int numOrdemAnterior;

	public ItemForm() {

	}

	/**
	 * Metodo que deve setar os dados do form para a TO
	 */
	public void setItemTO(ItemTO itemTO) {
		itemTO.setCodConfigTarefa(getCodConfigTarefa());
		itemTO.setIndItemCritico(getIndItemCritico());
		itemTO.setIndItemVigente(getIndItemVigente());
		itemTO.setNome(getNome());
		itemTO.setNumeroOrdem(getNumeroOrdem());
		itemTO.setNumOrdemAnterior(getNumOrdemAnterior());
		itemTO.setCodTipoDadoItem(getCodigoDadoItem());
	}

	public void setItemForm(ItemTO itemTO) {
		setCodConfigTarefa(itemTO.getCodConfigTarefa());
		setNome(itemTO.getNome().trim());
		setNumeroOrdem(itemTO.getNumeroOrdem());
		setIndItemCritico(itemTO.getIndItemCritico().trim());
		setIndItemVigente(itemTO.getIndItemVigente().trim());
		setCodigoDadoItem(itemTO.getCodTipoDadoItem());
	}

	/**
	 * @return Returns the codigoConfigTarefa.
	 */
	public int getCodConfigTarefa() {
		return codConfigTarefa;
	}

	/**
	 * @param codigoConfigTarefa
	 *            The codigoConfigTarefa to set.
	 */
	public void setCodConfigTarefa(int codConfigTarefa) {
		this.codConfigTarefa = codConfigTarefa;
	}

	/**
	 * @return Returns the indItemCritico.
	 */
	public String getIndItemCritico() {
		return indItemCritico;
	}

	/**
	 * @param indItemCritico
	 *            The indItemCritico to set.
	 */
	public void setIndItemCritico(String indItemCritico) {
		this.indItemCritico = indItemCritico;
	}

	/**
	 * @return Returns the indItemVigente.
	 */
	public String getIndItemVigente() {
		return indItemVigente;
	}

	/**
	 * @param indItemVigente
	 *            The indItemVigente to set.
	 */
	public void setIndItemVigente(String indItemVigente) {
		this.indItemVigente = indItemVigente;
	}

	/**
	 * @return Returns the nome.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            The nome to set.
	 */
	public void setNome(String nome) {
		this.nome = nome;
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

	public int getNumOrdemAnterior() {
		return numOrdemAnterior;
	}

	public void setNumOrdemAnterior(int numOrdemAnterior) {
		this.numOrdemAnterior = numOrdemAnterior;
	}



	public String getNomeTextoCombo() {
		return nomeTextoCombo;
	}

	public void setNomeTextoCombo(String nomeTextoCombo) {
		this.nomeTextoCombo = nomeTextoCombo;
	}

	public int getCodigoDadoItem() {
		return codigoDadoItem;
	}

	public void setCodigoDadoItem(int codigoDadoItem) {
		this.codigoDadoItem = codigoDadoItem;
	}


	public String[] getListaTextoCombo() {
		return listaTextoCombo;
	}

	public void setListaTextoCombo(String[] listaTextoCombo) {
		this.listaTextoCombo = listaTextoCombo;
	}

	public int getNumeroOrdemDadoItem() {
		return numeroOrdemDadoItem;
	}

	public void setNumeroOrdemDadoItem(int numeroOrdemDadoItem) {
		this.numeroOrdemDadoItem = numeroOrdemDadoItem;
	}


	
}
