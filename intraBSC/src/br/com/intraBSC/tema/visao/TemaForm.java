//Source file: C:\\Java\\workspace\\IntraBSC\\WEB-INF\\src\\br\\com\\intraBSC\\modelo\\br\\com\\intraBSC\\visao\\form\\TemaForm.java

package br.com.intraBSC.tema.visao;

import org.apache.struts.validator.ValidatorForm;

import br.com.intraBSC.modelo.TemaTO;

public class TemaForm extends ValidatorForm{
   private int idTema;
   private String nomeTema;
   private int responsavel;
   private String descricao;
   
   public TemaForm(){
    
   }
	
   public void setTemaTO(TemaTO temaTO){
	   temaTO.setNomeTema(getNomeTema());
	   temaTO.getUsuario().setIdUsuario(getResponsavel());
	   temaTO.setDescricaoTema(getDescricao());
	   temaTO.setIdTema(getIdTema());
   }
   
   public void setTemaForm(TemaTO temaTO){
	   setNomeTema(temaTO.getNomeTema());
	   setResponsavel(temaTO.getUsuario().getIdUsuario());
	   setDescricao(temaTO.getDescricaoTema());
	   setIdTema(temaTO.getIdTema());
   }
   
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getIdTema() {
		return idTema;
	}
	
	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}
	
	public String getNomeTema() {
		return nomeTema;
	}
	
	public void setNomeTema(String nomeTema) {
		this.nomeTema = nomeTema;
	}
	
	public int getResponsavel() {
		return responsavel;
	}
	
	public void setResponsavel(int responsavel) {
		this.responsavel = responsavel;
	}
	   
	   
}
