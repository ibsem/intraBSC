

package br.com.intraBSC.recurso.visao;

import org.apache.struts.validator.ValidatorForm;

import br.com.intraBSC.modelo.RecursoTO;

public class RecursoForm extends ValidatorForm{
   
	private int id;
	private int idIniciativa;
	private String nome;
	private String descricao;
	
   public RecursoForm(){
    
   }
   
   public void setRecursoTO(RecursoTO recursoTO){
	   recursoTO.setId(getId());
	   recursoTO.setIdIniciativa(getIdIniciativa());
	   recursoTO.setDescricao(getDescricao());
	   recursoTO.setNome(getNome());
   }
   
   public void setRecursoForm(RecursoTO recursoTO){
	   setId(recursoTO.getId());
	   setIdIniciativa(recursoTO.getIdIniciativa());
	   setDescricao(recursoTO.getDescricao());
	   setNome(recursoTO.getNome());
   }
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdIniciativa() {
		return idIniciativa;
	}
	
	public void setIdIniciativa(int idIniciativa) {
		this.idIniciativa = idIniciativa;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
