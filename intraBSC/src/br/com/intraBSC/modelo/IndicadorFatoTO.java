package br.com.intraBSC.modelo;

import java.sql.Date;
import java.util.List;

public class IndicadorFatoTO {

	private int id;
	private Date data;
	private String strData;
	private float valor;
	private String nome;
	
	/*Variavel utilizada na tela que monta uma lista de valores para serem alterados ou excluidos*/
	private List listaValores;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List getListaValores() {
		return listaValores;
	}

	public void setListaValores(List listaValores) {
		this.listaValores = listaValores;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getStrData() {
		return strData;
	}

	public void setStrData(String strData) {
		this.strData = strData;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	


}
