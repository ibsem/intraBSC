
package br.com.intraPRO.modelo;


public class ItemTO implements Comparable {
   private int codConfigTarefa;
   private int numeroOrdem;
   private String nome;
   private String indItemCritico;
   private String indItemVigente;
   private int codPrefixo;
   private String nomeConfigTarefa;
   private int codTipoDadoItem;
   
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
   public ItemTO(){
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
	 * @return Returns the indItemCritico.
	 */
	public String getIndItemCritico() {
	    return indItemCritico;
	}
	/**
	 * @param indItemCritico The indItemCritico to set.
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
	 * @param indItemVigente The indItemVigente to set.
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
        return String.valueOf(this.getCodPrefixo()).compareTo( ( String.valueOf( ( (ItemTO) arg0).getCodPrefixo() ) ) );
    }
	public int getNumOrdemAnterior() {
		return numOrdemAnterior;
	}
	public void setNumOrdemAnterior(int numOrdemAnterior) {
		this.numOrdemAnterior = numOrdemAnterior;
	}
	public int getCodTipoDadoItem() {
		return codTipoDadoItem;
	}
	public void setCodTipoDadoItem(int codTipoDadoItem) {
		this.codTipoDadoItem = codTipoDadoItem;
	}
	
}
