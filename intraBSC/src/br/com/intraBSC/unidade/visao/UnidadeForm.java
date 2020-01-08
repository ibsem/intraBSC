package br.com.intraBSC.unidade.visao;

import org.apache.struts.validator.ValidatorForm;

public class UnidadeForm extends ValidatorForm{
	
	private int id;
    private String nome;
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
    
    

}
