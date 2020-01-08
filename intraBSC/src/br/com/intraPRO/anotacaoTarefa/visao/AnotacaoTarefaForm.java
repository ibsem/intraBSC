
package br.com.intraPRO.anotacaoTarefa.visao;

import java.sql.Timestamp;
import java.text.ParseException;

import org.apache.struts.validator.ValidatorForm;

import br.com.intraPRO.modelo.TarefaTO;
import br.com.intraPRO.modelo.AnotacaoTarefaTO;



/**
 * Classe que representa o formulario JSP, referenciando os campos
 */
public class AnotacaoTarefaForm extends ValidatorForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String textoAnotacao;
	private String tipoAnotacao;
	private String listaTipoAnotacao;
	private String valoresDatasEtapas="sim";//campo referente ou sim ou não do form
	private int verificaDataPrazo;
	private String anoNumeroNome;
 	private String etapa;
 	private String estado; 	
	
	/**
	 * Cravell
	 * 21/07/2005
	 * Método que seta os valores da TO no formário de exibição da tela.
	 */
	public void setAnotacaoTarefaTO(AnotacaoTarefaTO anotacaoTarefaTO) throws ParseException{

		anotacaoTarefaTO.setTextoAnotacao(getTextoAnotacao());
		anotacaoTarefaTO.setTextoAnotacao(getValoresDatasEtapas());						
		}

	/**
	 * Cravell
	 * 21/07/2005
	 * Método que seta os valores da FORM no formário de exibição da tela.
	 */
	public void setAnotacaoTarefaForm(AnotacaoTarefaTO anotacaoTarefaTO)throws ParseException{
		setTextoAnotacao(anotacaoTarefaTO.getTextoAnotacao());
		setValoresDatasEtapas(anotacaoTarefaTO.getValoresDatasEtapas());
				
	}

	/**
	 * Metodo que seta os valores do form para a TO
	 */
	
	public String getTextoAnotacao() {
		return textoAnotacao;
	}

	public void setTextoAnotacao(String textoAnotacao) {
		this.textoAnotacao = textoAnotacao;
	}

	public String getValoresDatasEtapas() {
		return valoresDatasEtapas;
	}

	public int getVerificaDataPrazo() {
		return verificaDataPrazo;
	}

	public void setVerificaDataPrazo(int verificaDataPrazo) {
		this.verificaDataPrazo = verificaDataPrazo;
	}

	public void setValoresDatasEtapas(String valoresDatasEtapas) {
		this.valoresDatasEtapas = valoresDatasEtapas;
	}
	
	/**
	 * @return Returns the anoNumeroNome.
	 */
	public String getAnoNumeroNome() {
		return anoNumeroNome;
	}

	
	/**
	 * @param anoNumeroNome The anoNumeroNome to set.
	 */
	public void setAnoNumeroNome(String anoNumeroNome) {
		this.anoNumeroNome = anoNumeroNome;
	}

	
	/**
	 * @return Returns the etapa.
	 */
	public String getEtapa() {
		return etapa;
	}

	
	/**
	 * @param etapa The etapa to set.
	 */
	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}

	
	/**
	 * @return Returns the tipoAnotacao.
	 */
	public String getTipoAnotacao() {
		return tipoAnotacao;
	}

	
	/**
	 * @param tipoAnotacao The tipoAnotacao to set.
	 */
	public void setTipoAnotacao(String tipoAnotacao) {
		this.tipoAnotacao = tipoAnotacao;
	}

	
	/**
	 * @return Returns the listaTipoAnotacao.
	 */
	public String getListaTipoAnotacao() {
		return listaTipoAnotacao;
	}

	
	/**
	 * @param listaTipoAnotacao The listaTipoAnotacao to set.
	 */
	public void setListaTipoAnotacao(String listaTipoAnotacao) {
		this.listaTipoAnotacao = listaTipoAnotacao;
	}
	
	public AnotacaoTarefaTO getAnotacaoTarefaTO(TarefaTO tarefaTOAntes){
		AnotacaoTarefaTO anotacaoTO = new AnotacaoTarefaTO();
				
		anotacaoTO.setCodTipoAnotacao(Integer.parseInt(getTipoAnotacao()));
		anotacaoTO.setAnoCriacao(tarefaTOAntes.getAnoCriacao());
		anotacaoTO.setCodTarefa(tarefaTOAntes.getCodigo());
		anotacaoTO.setTextoAnotacao(this.getTextoAnotacao());
		anotacaoTO.setTsAnotacao(new Timestamp(System.currentTimeMillis()));
		anotacaoTO.setCodConfigTarefa(tarefaTOAntes.getCodConfigTarefa());
		
		return anotacaoTO;
	}

	
	/**
	 * @return Returns the estado.
	 */
	public String getEstado() {
		return estado;
	}
	
	/**
	 * @param estado The estado to set.
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

		
}