package br.com.intraBSC.causaEfeito.visao;

import org.apache.struts.validator.ValidatorForm;

import br.com.intraBSC.modelo.CausaEfeitoTO;

public class CausaEfeitoForm extends ValidatorForm{

	/*Referente ao quadro de objetivo*/
	private int causaId;
	private int efeitoId;
	
	/*Referente ao quadro de causa e obejtivo do lado direito da tela de cadastro*/
	private int causa;
	private int efeito;
	
	private String intensidadeCausa;
	private String interacaoCausa;
	
	private String intensidadeEfeito;
	private String interacaoEfeito;
	
	private String nomeObjetivo;
	private int idObjetivo;
		
	
	public void setCausaEfeitoTO(CausaEfeitoTO causaEfeitoTO){
		causaEfeitoTO.setCausaId(getCausaId());
		causaEfeitoTO.setEfeitoId(getEfeitoId());
	}
	
	public int getCausaId() {
		return causaId;
	}
	public void setCausaId(int causaId) {
		this.causaId = causaId;
	}
	public int getEfeitoId() {
		return efeitoId;
	}
	public void setEfeitoId(int efeitoId) {
		this.efeitoId = efeitoId;
	}	
	public void setIdObjetivo(int idObjetivo) {
		this.idObjetivo = idObjetivo;
	}
	public String getNomeObjetivo() {
		return nomeObjetivo;
	}
	public void setNomeObjetivo(String nomeObjetivo) {
		this.nomeObjetivo = nomeObjetivo;
	}

	public String getIntensidadeCausa() {
		return intensidadeCausa;
	}

	public void setIntensidadeCausa(String intensidadeCausa) {
		this.intensidadeCausa = intensidadeCausa;
	}

	public String getIntensidadeEfeito() {
		return intensidadeEfeito;
	}

	public void setIntensidadeEfeito(String intensidadeEfeito) {
		this.intensidadeEfeito = intensidadeEfeito;
	}

	public String getInteracaoCausa() {
		return interacaoCausa;
	}

	public void setInteracaoCausa(String interacaoCausa) {
		this.interacaoCausa = interacaoCausa;
	}

	public String getInteracaoEfeito() {
		return interacaoEfeito;
	}

	public void setInteracaoEfeito(String interacaoEfeito) {
		this.interacaoEfeito = interacaoEfeito;
	}

	public int getIdObjetivo() {
		return idObjetivo;
	}

	public int getCausa() {
		return causa;
	}

	public void setCausa(int causa) {
		this.causa = causa;
	}

	public int getEfeito() {
		return efeito;
	}

	public void setEfeito(int efeito) {
		this.efeito = efeito;
	}


}
