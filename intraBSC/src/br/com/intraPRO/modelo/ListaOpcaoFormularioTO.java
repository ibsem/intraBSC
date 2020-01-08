package br.com.intraPRO.modelo;

public class ListaOpcaoFormularioTO {
	
	private int codConfigTarefa;
	private int numeroOrdem;
	private	String texto;
	private int codigo;
	
	public int getNumeroOrdem() {
		return numeroOrdem;
	}
	public void setNumeroOrdem(int numeroOrdem) {
		this.numeroOrdem = numeroOrdem;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodConfigTarefa() {
		return codConfigTarefa;
	}
	public void setCodConfigTarefa(int codConfigTarefa) {
		this.codConfigTarefa = codConfigTarefa;
	}


}
