package br.com.intraBSC.papel.visao;

import org.apache.struts.validator.ValidatorForm;

public class PapelForm extends ValidatorForm{
	
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
