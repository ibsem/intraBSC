

package br.com.intraBSC.perspectiva.visao;

import org.apache.struts.validator.ValidatorForm;

import br.com.intraBSC.modelo.PerspectivaTO;

public class PerspectivaForm extends ValidatorForm {
	   
	private static final long serialVersionUID = 1L;
	
	
	private int id;
	private String nome;
	private String descricao;
	private int ordem;
	private int responsavel;
	private int tipoPerspectiva;
	private String ativo;
	private int codTarefa;
	
	public void setPerspectivaTO(PerspectivaTO perspectivaTO){
		perspectivaTO.setId(getId());
		perspectivaTO.setNome(getNome());
		perspectivaTO.setDescricao(getDescricao());
		perspectivaTO.setResponsavel(getResponsavel());
		perspectivaTO.setOrdem(getOrdem());
		perspectivaTO.setTipoPerspectiva(getTipoPerspectiva());
		perspectivaTO.setAtivo(Integer.parseInt(getAtivo()));
	}
	
	public void setPerspectivaForm(PerspectivaTO perspectivaTO){
		setId(perspectivaTO.getId());
		setNome(perspectivaTO.getNome());
		setDescricao(perspectivaTO.getDescricao());
		setResponsavel(perspectivaTO.getResponsavel());
		setOrdem(perspectivaTO.getOrdem());
		setTipoPerspectiva(perspectivaTO.getTipoPerspectiva());
		setId(perspectivaTO.getId());
		setAtivo(String.valueOf(perspectivaTO.getAtivo()));
	}
	
   public PerspectivaForm(){
    
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
	
	public int getTipoPerspectiva() {
		return tipoPerspectiva;
	}
	
	public void setTipoPerspectiva(int tipoPerspectiva) {
		this.tipoPerspectiva = tipoPerspectiva;
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
