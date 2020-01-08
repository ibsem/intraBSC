
package br.com.intraPRO.formulario.visao;


import org.apache.struts.validator.ValidatorForm;

import br.com.intraPRO.modelo.FormularioTO;

/**
 * Classe que implementa os dados do formulario de formulario.
 */
public class FormularioForm extends ValidatorForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int codConfigTarefa;

	private int numeroOrdem;

	private String nome;

	private String indFormularioCritico = "S";

	private String indFormularioVigente;
		
	private int numeroOrdemDadoFormulario;
	private String nomeTextoCombo;
	private String[] listaTextoCombo;
	private int codigoDadoFormulario;

	
	/*Variavel criada para caso o usuario queria trocar o valor do numero de ordem.
	    * Desta forma deve-se guardar o valor anterior, por este campo fazer parte da chave primaria  */
	private int numOrdemAnterior;

	public FormularioForm() {

	}

	/**
	 * Metodo que deve setar os dados do form para a TO
	 */
	public void setFormularioTO(FormularioTO formularioTO) {
		formularioTO.setCodConfigTarefa(getCodConfigTarefa());
		formularioTO.setIndFormularioCritico(getIndFormularioCritico());
		formularioTO.setIndFormularioVigente(getIndFormularioVigente());
		formularioTO.setNome(getNome());
		formularioTO.setNumeroOrdem(getNumeroOrdem());
		formularioTO.setNumOrdemAnterior(getNumOrdemAnterior());
		formularioTO.setCodTipoDadoFormulario(getCodigoDadoFormulario());
	}

	public void setFormularioForm(FormularioTO formularioTO) {
		setCodConfigTarefa(formularioTO.getCodConfigTarefa());
		setNome(formularioTO.getNome().trim());
		setNumeroOrdem(formularioTO.getNumeroOrdem());
		setIndFormularioCritico(formularioTO.getIndFormularioCritico().trim());
		setIndFormularioVigente(formularioTO.getIndFormularioVigente().trim());
		setCodigoDadoFormulario(formularioTO.getCodTipoDadoFormulario());
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
	 * @return Returns the indFormularioCritico.
	 */
	public String getIndFormularioCritico() {
		return indFormularioCritico;
	}

	/**
	 * @param indFormularioCritico
	 *            The indFormularioCritico to set.
	 */
	public void setIndFormularioCritico(String indFormularioCritico) {
		this.indFormularioCritico = indFormularioCritico;
	}

	/**
	 * @return Returns the indFormularioVigente.
	 */
	public String getIndFormularioVigente() {
		return indFormularioVigente;
	}

	/**
	 * @param indFormularioVigente
	 *            The indFormularioVigente to set.
	 */
	public void setIndFormularioVigente(String indFormularioVigente) {
		this.indFormularioVigente = indFormularioVigente;
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

	public int getCodigoDadoFormulario() {
		return codigoDadoFormulario;
	}

	public void setCodigoDadoFormulario(int codigoDadoFormulario) {
		this.codigoDadoFormulario = codigoDadoFormulario;
	}


	public String[] getListaTextoCombo() {
		return listaTextoCombo;
	}

	public void setListaTextoCombo(String[] listaTextoCombo) {
		this.listaTextoCombo = listaTextoCombo;
	}

	public int getNumeroOrdemDadoFormulario() {
		return numeroOrdemDadoFormulario;
	}

	public void setNumeroOrdemDadoFormulario(int numeroOrdemDadoFormulario) {
		this.numeroOrdemDadoFormulario = numeroOrdemDadoFormulario;
	}


	
}
