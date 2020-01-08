

package br.com.intraBSC.meta.visao;

import org.apache.struts.validator.ValidatorForm;

import br.com.intraBSC.modelo.MetaTO;

public class MetaForm extends ValidatorForm {
	

	private static final long serialVersionUID = 1L;
	
	private String descricao;
	private int id;
	private int idIndicador;
	private String nomeIndicador;
	private int inversaoSinal;
   	private double limiteInferior;
   	private double limiteSuperior;
   	private String nome;
   	private int responsavel;
   	private double valorAtual;
   	private String ativo;
   	
   	public void setMetaTO(MetaTO metaTO){
   		metaTO.setAtivo(getAtivo());
   		metaTO.setDescricao(getDescricao());
   		metaTO.setIdIndicador(getIdIndicador());
   		metaTO.setInversaoSinal(getInversaoSinal());
   		metaTO.setLimiteInferior(getLimiteInferior());
   		metaTO.setLimiteSuperior(getLimiteSuperior());
   		metaTO.setNome(getNome());
   		metaTO.setResponsavel(getResponsavel());
   	}
   	
   	public void setMetaForm(MetaTO metaTO){
   		setDescricao(metaTO.getDescricao());
   		setId(metaTO.getId());
   		setIdIndicador(metaTO.getIdIndicador());
   		setInversaoSinal(metaTO.getInversaoSinal());
   		setLimiteInferior(metaTO.getLimiteInferior());
   		setLimiteSuperior(metaTO.getLimiteSuperior());
   		setNome(metaTO.getNome());
   		setResponsavel(metaTO.getResponsavel());
   		setAtivo(metaTO.getAtivo());
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
	
	public int getInversaoSinal() {
		return inversaoSinal;
	}
	public void setInversaoSinal(int inversaoSinal) {
		this.inversaoSinal = inversaoSinal;
	}
	public double getLimiteInferior() {
		return limiteInferior;
	}
	public void setLimiteInferior(double limiteInferior) {
		this.limiteInferior = limiteInferior;
	}
	public double getLimiteSuperior() {
		return limiteSuperior;
	}
	public void setLimiteSuperior(double limiteSuperior) {
		this.limiteSuperior = limiteSuperior;
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
	public double getValorAtual() {
		return valorAtual;
	}
	public void setValorAtual(double valorAtual) {
		this.valorAtual = valorAtual;
	}
	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	public int getIdIndicador() {
		return idIndicador;
	}
	public void setIdIndicador(int idIndicador) {
		this.idIndicador = idIndicador;
	}
	public String getNomeIndicador() {
		return nomeIndicador;
	}
	public void setNomeIndicador(String nomeIndicador) {
		this.nomeIndicador = nomeIndicador;
	}

  
}
