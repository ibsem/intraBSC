package br.com.intraPRO.item.visao;

import org.apache.struts.validator.ValidatorForm;

import br.com.intraPRO.modelo.ListaOpcaoItemTO;

public class ListaOpcaoItemForm extends ValidatorForm{
	
	private int codConfigTarefa;
	private int numeroOrdem;
	private	String texto;
	private int codigo;
	
	/*Esta variavel é utilizado para a exclusao de um tipo, exclusivamente para o campo do tipo COMBO*/
	private	String comboSelecionado;
	
	
	public void setListaOpcaoItemTO(ListaOpcaoItemTO listaOpcaoItemTO){
		listaOpcaoItemTO.setCodConfigTarefa(getCodConfigTarefa());
		listaOpcaoItemTO.setNumeroOrdem(getNumeroOrdem());
		listaOpcaoItemTO.setTexto(getTexto());
		listaOpcaoItemTO.setCodigo(getCodigo());
	}
	
	public int getCodConfigTarefa() {
		return codConfigTarefa;
	}
	public void setCodConfigTarefa(int codConfigTarefa) {
		this.codConfigTarefa = codConfigTarefa;
	}
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

	public String getComboSelecionado() {
		return comboSelecionado;
	}

	public void setComboSelecionado(String comboSelecionado) {
		this.comboSelecionado = comboSelecionado;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}	

}
