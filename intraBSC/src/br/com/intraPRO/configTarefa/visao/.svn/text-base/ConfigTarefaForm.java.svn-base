
package br.com.intraPRO.configTarefa.visao;

import org.apache.struts.validator.ValidatorForm;

import br.com.intraPRO.modelo.ConfigTarefaTO;
public class ConfigTarefaForm extends ValidatorForm {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigoConfigTarefa;
    private int numDiasPrevistos;
    private String indTipoVigencia;
    private String textoConfigTarefa;

    
    private int codCriticidadeIniTarefa;
    private int codEstadoIniTarefa;
    private String txtSolicitacaoIniTarefa;   
    private String nomeIniTarefa;
   
    private int idResponsavel;
   
    /*Variaveis utilizadas para setar valores quando for selecionada os executantes ou acompanhamento na pagina de alterar tipo de tarefa*/
    private String executante;
    private String acompanhamento;
    
   public ConfigTarefaForm(){
   }
   
   /**
   *Metodo que deve setar os valores do Form na TO
   */
   public void setConfigTarefaTO(ConfigTarefaTO configTarefaTO){
   		configTarefaTO.setCodigoConfigTarefa(getCodigoConfigTarefa());
   		configTarefaTO.setNumDiasPrevistos(getNumDiasPrevistos());
   		if (getIndTipoVigencia() != null)
   			configTarefaTO.setIndTipoVigencia(getIndTipoVigencia().trim());
   		if (getTextoConfigTarefa() != null)
   			configTarefaTO.setTextoConfigTarefa(getTextoConfigTarefa().trim());
  
   		
   		configTarefaTO.setCodCriticidadeIniTarefa(getCodCriticidadeIniTarefa());
   		configTarefaTO.setCodEstadoIniTarefa(getCodEstadoIniTarefa());
   		configTarefaTO.setTxtSolicitacaoIniTarefa(getTxtSolicitacaoIniTarefa());
   		configTarefaTO.setNomeIniTarefa(getNomeIniTarefa());
   }
   /**
    *Metodo que deve setar os valores da TO no Form
    */
    public void setConfigTarefaForm(ConfigTarefaTO configTarefaTO){
		setCodigoConfigTarefa(configTarefaTO.getCodigoConfigTarefa());
    	setNumDiasPrevistos(configTarefaTO.getNumDiasPrevistos());
    	if ((configTarefaTO.getIndTipoVigencia()!=(null)))
    		setIndTipoVigencia(configTarefaTO.getIndTipoVigencia().trim());
    	if ((configTarefaTO.getTextoConfigTarefa()!=(null)))
    		setTextoConfigTarefa(configTarefaTO.getTextoConfigTarefa().trim());

   		
   		setCodCriticidadeIniTarefa(configTarefaTO.getCodCriticidadeIniTarefa());
   		setCodEstadoIniTarefa(configTarefaTO.getCodEstadoIniTarefa());
   		setTxtSolicitacaoIniTarefa(configTarefaTO.getTxtSolicitacaoIniTarefa());
   		if ((configTarefaTO.getNomeIniTarefa()!=(null)))
   			setNomeIniTarefa(configTarefaTO.getNomeIniTarefa().trim());
   		setIdResponsavel(configTarefaTO.getIdResponsavel());
    }
   	
	/**
	 * @return Returns the codigoConfigTarefa.
	 */
	public int getCodigoConfigTarefa() {
		return codigoConfigTarefa;
	}
	/**
	 * @param codigoConfigTarefa The codigoConfigTarefa to set.
	 */
	public void setCodigoConfigTarefa(int codigoConfigTarefa) {
		this.codigoConfigTarefa = codigoConfigTarefa;
	}
	/**
	 * @return Returns the indTipoVigencia.
	 */
	public String getIndTipoVigencia() {
		return indTipoVigencia;
	}
	/**
	 * @param indTipoVigencia The indTipoVigencia to set.
	 */
	public void setIndTipoVigencia(String indTipoVigencia) {
		this.indTipoVigencia = indTipoVigencia;
	}
	/**
	 * @return Returns the numDiasPrevistos.
	 */
	public int getNumDiasPrevistos() {
		return numDiasPrevistos;
	}
	/**
	 * @param numDiasPrevistos The numDiasPrevistos to set.
	 */
	public void setNumDiasPrevistos(int numDiasPrevistos) {
		this.numDiasPrevistos = numDiasPrevistos;
	}
	/**
	 * @return Returns the textoTipTarefa.
	 */
	public String getTextoConfigTarefa() {
		return textoConfigTarefa;
	}
	/**
	 * @param textoTipTarefa The textoTipTarefa to set.
	 */
	public void setTextoConfigTarefa(String textoConfigTarefa) {
		this.textoConfigTarefa = textoConfigTarefa;
	}

	
	public int getCodCriticidadeIniTarefa() {
		return codCriticidadeIniTarefa;
	}

	public void setCodCriticidadeIniTarefa(int codCriticidadeIniTarefa) {
		this.codCriticidadeIniTarefa = codCriticidadeIniTarefa;
	}

	public int getCodEstadoIniTarefa() {
		return codEstadoIniTarefa;
	}

	public void setCodEstadoIniTarefa(int codEstadoIniTarefa) {
		this.codEstadoIniTarefa = codEstadoIniTarefa;
	}

	public String getNomeIniTarefa() {
		return nomeIniTarefa;
	}

	public void setNomeIniTarefa(String nomeIniTarefa) {
		this.nomeIniTarefa = nomeIniTarefa;
	}

	public String getTxtSolicitacaoIniTarefa() {
		return txtSolicitacaoIniTarefa;
	}

	public void setTxtSolicitacaoIniTarefa(String txtSolicitacaoIniTarefa) {
		this.txtSolicitacaoIniTarefa = txtSolicitacaoIniTarefa;
	}
	
	public String getAcompanhamento() {
		return acompanhamento;
	}
	public void setAcompanhamento(String acompanhamento) {
		this.acompanhamento = acompanhamento;
	}
	public String getExecutante() {
		return executante;
	}
	public void setExecutante(String executante) {
		this.executante = executante;
	}

	public int getIdResponsavel() {
		return idResponsavel;
	}

	public void setIdResponsavel(int idResponsavel) {
		this.idResponsavel = idResponsavel;
	}

}
