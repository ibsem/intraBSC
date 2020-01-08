
package br.com.intraPRO.modelo;


public class FormularioTO implements Comparable {
   private int codConfigTarefa;
   private int numeroOrdem;
   private String nome;
   private String indFormularioCritico;
   private String indFormularioVigente;
   private int codPrefixo;
   private String nomeConfigTarefa;
   private int codTipoDadoFormulario;
   
   /*Variavel criada para caso o usuario queria trocar o valor do numero de ordem.
    * Desta forma deve-se guardar o valor anterior, por este campo fazer parte da chave primaria  */
   private int numOrdemAnterior;
   
   
	public String getNomeConfigTarefa() {
		return nomeConfigTarefa;
	}
	public void setNomeConfigTarefa(String nomeConfigTarefa) {
		this.nomeConfigTarefa = nomeConfigTarefa;
	}
	/**
	 * @return Returns the codPrefixo.
	 */
	public int getCodPrefixo() {
		return codPrefixo;
	}
	/**
	 * @param codPrefixo The codPrefixo to set.
	 */
	public void setCodPrefixo(int codPrefixo) {
		this.codPrefixo = codPrefixo;
	}
   public FormularioTO(){
   }
   
	/**
	 * @return Returns the codigoConfigTarefa.
	 */
	public int getCodConfigTarefa() {
	    return codConfigTarefa;
	}
	/**
	 * @param codigoConfigTarefa The codigoConfigTarefa to set.
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
	 * @param indFormularioCritico The indFormularioCritico to set.
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
	 * @param indFormularioVigente The indFormularioVigente to set.
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
	 * @param nome The nome to set.
	 */
	public void setNome(String nome) {
	    this.nome = nome;
	}

	public int getNumeroOrdem() {
	    return numeroOrdem;
	}

	public void setNumeroOrdem(int numeroOrdem) {
	    this.numeroOrdem = numeroOrdem;
	}

    public int compareTo(Object arg0) {
        return String.valueOf(this.getCodPrefixo()).compareTo( ( String.valueOf( ( (FormularioTO) arg0).getCodPrefixo() ) ) );
    }
	public int getNumOrdemAnterior() {
		return numOrdemAnterior;
	}
	public void setNumOrdemAnterior(int numOrdemAnterior) {
		this.numOrdemAnterior = numOrdemAnterior;
	}
	public int getCodTipoDadoFormulario() {
		return codTipoDadoFormulario;
	}
	public void setCodTipoDadoFormulario(int codTipoDadoFormulario) {
		this.codTipoDadoFormulario = codTipoDadoFormulario;
	}
	
}
