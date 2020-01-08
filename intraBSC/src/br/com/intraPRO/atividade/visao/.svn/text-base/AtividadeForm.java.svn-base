

package br.com.intraPRO.atividade.visao;

import org.apache.struts.validator.ValidatorForm;

import br.com.intraPRO.modelo.AtividadeTO;



public class AtividadeForm extends ValidatorForm {
	
   
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private int responsavel;
	private String descricao;
	private int idTema;
	private int idFase;
	private String ativo;
	private int codTarefa;
   
   public AtividadeForm(){    
   }
	
   
   public void setAtividadeForm(AtividadeTO atividadeTO){
	   setId(atividadeTO.getId());
	   setNome(atividadeTO.getNome());
	   setResponsavel(atividadeTO.getResponsavel());
	   setDescricao(atividadeTO.getDescricao());
	   setIdFase(atividadeTO.getIdFase());
	   setAtivo(String.valueOf(atividadeTO.getAtivo()));
	
   }
   
   public void setAtividadeTO(AtividadeTO atividadeTO){
	   atividadeTO.setId(getId());
	   atividadeTO.setNome(getNome());
	   atividadeTO.setResponsavel(getResponsavel());
	   atividadeTO.setDescricao(getDescricao());
	   atividadeTO.setIdFase(getIdFase());
	   atividadeTO.setAtivo(Integer.parseInt(getAtivo()));
	
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
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getResponsavel() {
		return responsavel;
	}
	
	public void setResponsavel(int responsavel) {
		this.responsavel = responsavel;
	}


	public int getIdFase() {
		return idFase;
	}


	public void setIdFase(int idFase) {
		this.idFase = idFase;
	}


	public int getIdTema() {
		return idTema;
	}


	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}


	public String getAtivo() {
		return ativo;
	}


	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}


	public int getCodTarefa() {
		return codTarefa;
	}


	public void setCodTarefa(int codTarefa) {
		this.codTarefa = codTarefa;
	}

	   
}
