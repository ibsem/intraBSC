

package br.com.intraBSC.objetivo.visao;

import org.apache.struts.validator.ValidatorForm;

import br.com.intraBSC.modelo.ObjetivoTO;



public class ObjetivoForm extends ValidatorForm {
	
   
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private int responsavel;
	private String descricao;
	private int idTema;
	private int idPerspectiva;
	private String ativo;
	private int linha;
	private int coluna;
	private int codTarefa;
   
   public ObjetivoForm(){    
   }
	
   
   public void setObjetivoForm(ObjetivoTO objetivoTO){
	   setId(objetivoTO.getId());
	   setNome(objetivoTO.getNome());
	   setResponsavel(objetivoTO.getResponsavel());
	   setDescricao(objetivoTO.getDescricao());
	   setIdTema(objetivoTO.getIdTema());
	   setIdPerspectiva(objetivoTO.getIdPerspectiva());
	   setAtivo(String.valueOf(objetivoTO.getAtivo()));
	   setLinha(objetivoTO.getLinha());
	   setColuna(objetivoTO.getColuna());
   }
   
   public void setObjetivoTO(ObjetivoTO objetivoTO){
	   objetivoTO.setId(getId());
	   objetivoTO.setNome(getNome());
	   objetivoTO.setResponsavel(getResponsavel());
	   objetivoTO.setDescricao(getDescricao());
	   objetivoTO.setIdTema(getIdTema());
	   objetivoTO.setIdPerspectiva(getIdPerspectiva());
	   objetivoTO.setAtivo(Integer.parseInt(getAtivo()));
	   objetivoTO.setLinha(getLinha());
	   objetivoTO.setColuna(getColuna());
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


	public int getIdPerspectiva() {
		return idPerspectiva;
	}


	public void setIdPerspectiva(int idPerspectiva) {
		this.idPerspectiva = idPerspectiva;
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


	public int getLinha() {
		return linha;
	}


	public void setLinha(int linha) {
		this.linha = linha;
	}


	/**
	 * @return the coluna
	 */
	public int getColuna() {
		return coluna;
	}


	/**
	 * @param _coluna the coluna to set
	 */
	public void setColuna(int _coluna) {
		coluna = _coluna;
	}
	   
}
