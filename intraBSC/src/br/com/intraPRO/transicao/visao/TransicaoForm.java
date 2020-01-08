package br.com.intraPRO.transicao.visao;

import org.apache.struts.validator.ValidatorForm;

import br.com.intraPRO.modelo.TransicaoTO;

public class TransicaoForm extends ValidatorForm{

	/*Referente ao quadro de objetivo*/
	private int preCondicaoId;
	private int posCondicaoId;
	
	/*Referente ao quadro de preCondicao e obejtivo do lado direito da tela de cadastro*/
	private int preCondicao;
	private int posCondicao;
	
	private String intensidadePreCondicao;
	private String interacaoPreCondicao;
	
	private String intensidadePosCondicao;
	private String interacaoPosCondicao;
	
	private String nomeAtividade;
	private int idAtividade;
		
	
	public void setTransicaoTO(TransicaoTO transicaoTO){
		transicaoTO.setPreCondicaoId(getPreCondicaoId());
		transicaoTO.setPosCondicaoId(getPosCondicaoId());
	}
	
	public int getPreCondicaoId() {
		return preCondicaoId;
	}
	public void setPreCondicaoId(int preCondicaoId) {
		this.preCondicaoId = preCondicaoId;
	}
	public int getPosCondicaoId() {
		return posCondicaoId;
	}
	public void setPosCondicaoId(int posCondicaoId) {
		this.posCondicaoId = posCondicaoId;
	}	
	public void setIdAtividade(int idAtividade) {
		this.idAtividade = idAtividade;
	}
	public String getNomeAtividade() {
		return nomeAtividade;
	}
	public void setNomeAtividade(String nomeAtividade) {
		this.nomeAtividade = nomeAtividade;
	}

	public String getIntensidadePreCondicao() {
		return intensidadePreCondicao;
	}

	public void setIntensidadePreCondicao(String intensidadePreCondicao) {
		this.intensidadePreCondicao = intensidadePreCondicao;
	}

	public String getIntensidadePosCondicao() {
		return intensidadePosCondicao;
	}

	public void setIntensidadePosCondicao(String intensidadePosCondicao) {
		this.intensidadePosCondicao = intensidadePosCondicao;
	}

	public String getInteracaoPreCondicao() {
		return interacaoPreCondicao;
	}

	public void setInteracaoPreCondicao(String interacaoPreCondicao) {
		this.interacaoPreCondicao = interacaoPreCondicao;
	}

	public String getInteracaoPosCondicao() {
		return interacaoPosCondicao;
	}

	public void setInteracaoPosCondicao(String interacaoPosCondicao) {
		this.interacaoPosCondicao = interacaoPosCondicao;
	}

	public int getIdAtividade() {
		return idAtividade;
	}

	public int getPreCondicao() {
		return preCondicao;
	}

	public void setPreCondicao(int preCondicao) {
		this.preCondicao = preCondicao;
	}

	public int getPosCondicao() {
		return posCondicao;
	}

	public void setPosCondicao(int posCondicao) {
		this.posCondicao = posCondicao;
	}


}
