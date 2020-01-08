

package br.com.intraPRO.fase.visao;

import org.apache.struts.validator.ValidatorForm;

import br.com.intraPRO.modelo.FaseTO;

public class FaseForm extends ValidatorForm {
	   
	private static final long serialVersionUID = 1L;
	
	
	private int id;
	private String nome;
	private String descricao;
	private int ordem;
	private int responsavel;
	private int tipoFase;
	private String ativo;
	private int codTarefa;
	
	public void setFaseTO(FaseTO faseTO){
		faseTO.setId(getId());
		faseTO.setNome(getNome());
		faseTO.setDescricao(getDescricao());
		faseTO.setResponsavel(getResponsavel());
		faseTO.setOrdem(getOrdem());
		faseTO.setTipoFase(getTipoFase());
		faseTO.setAtivo(Integer.parseInt(getAtivo()));
	}
	
	public void setFaseForm(FaseTO faseTO){
		setId(faseTO.getId());
		setNome(faseTO.getNome());
		setDescricao(faseTO.getDescricao());
		setResponsavel(faseTO.getResponsavel());
		setOrdem(faseTO.getOrdem());
		setTipoFase(faseTO.getTipoFase());
		setId(faseTO.getId());
		setAtivo(String.valueOf(faseTO.getAtivo()));
	}
	
   public FaseForm(){
    
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
	
	public int getOrdem() {
		return ordem;
	}
	
	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}
	
	public int getResponsavel() {
		return responsavel;
	}
	
	public void setResponsavel(int responsavel) {
		this.responsavel = responsavel;
	}
	
	public int getTipoFase() {
		return tipoFase;
	}
	
	public void setTipoFase(int tipoFase) {
		this.tipoFase = tipoFase;
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
