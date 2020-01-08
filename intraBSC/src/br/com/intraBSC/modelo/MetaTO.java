

package br.com.intraBSC.modelo;


public class MetaTO{
			
	private int id;
	private String nome;
	private String descricao;
	//private double valorAtual;
	private String ativo;
	private int idIndicador;
	private String nomeIndicador;
	private int inversaoSinal;
   	private double limiteInferior;
   	private double limiteSuperior;
   	
   	private int responsavel;
   	
   	
   	
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
