

package br.com.intraBSC.modelo;


public class RecursoTO {
	private int id;
	private int idIniciativa;
	private String nome;
	private String descricao;
	
	
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
