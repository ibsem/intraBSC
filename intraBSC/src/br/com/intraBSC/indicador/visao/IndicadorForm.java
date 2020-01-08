package br.com.intraBSC.indicador.visao;


import org.apache.struts.validator.ValidatorForm;

import br.com.intraBSC.modelo.IndicadorTO;

public class IndicadorForm extends ValidatorForm{
	
	
	private int idIndicador;
	private int idObjetivo;
	private int idResponsavel;
	private String nome;
	private int periodicidade;
	private int unidade;
	private String descricao;
	private double valorIndicador;
	private float ultimoValor;
	private String ultimaData;
	private String ativo;
	private int idPerspectiva;
	private int codTarefa;
   
	/*Variavel utilizada na tela que monta uma lista de valores para serem alterados ou excluidos*/
	private String[] listaValores;
	private String[] listaDatas;
	private String[] listaId;
	  
	public void setIndicadorTO(IndicadorTO indicadorTO){
		indicadorTO.setDescricao(getDescricao());
		indicadorTO.setNome(getNome());
		indicadorTO.setIdObjetivo(getIdObjetivo());
		indicadorTO.setPeriodicidade(getPeriodicidade());
		indicadorTO.setUnidade(getUnidade());
		indicadorTO.setResponsavelIndicador(getIdResponsavel());
		indicadorTO.setAtivo(Integer.parseInt(getAtivo()));
	}
	
	public void setIndicadorForm(IndicadorTO indicadorTO){
		setIdIndicador(indicadorTO.getId());
		setDescricao(indicadorTO.getDescricao());
		setNome(indicadorTO.getNome());
		setIdObjetivo(indicadorTO.getIdObjetivo());
		setPeriodicidade(indicadorTO.getPeriodicidade());
		setUnidade(indicadorTO.getUnidade());		
		setIdResponsavel(indicadorTO.getResponsavelIndicador());
		setAtivo(String.valueOf(indicadorTO.getAtivo()));
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getIdIndicador() {
		return idIndicador;
	}
	public void setIdIndicador(int idIndicador) {
		this.idIndicador = idIndicador;
	}
	public int getIdObjetivo() {
		return idObjetivo;
	}
	public void setIdObjetivo(int idObjetivo) {
		this.idObjetivo = idObjetivo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPeriodicidade() {
		return periodicidade;
	}
	public void setPeriodicidade(int periodicidade) {
		this.periodicidade = periodicidade;
	}
	public int getUnidade() {
		return unidade;
	}
	public void setUnidade(int unidade) {
		this.unidade = unidade;
	}
	public double getValorIndicador() {
		return valorIndicador;
	}
	public void setValorIndicador(short valorIndicador) {
		this.valorIndicador = valorIndicador;
	}
	public int getIdResponsavel() {
		return idResponsavel;
	}
	public void setIdResponsavel(int idResponsavel) {
		this.idResponsavel = idResponsavel;
	}

	public String getUltimaData() {
		return ultimaData;
	}

	public void setUltimaData(String ultimaData) {
		this.ultimaData = ultimaData;
	}

	public float getUltimoValor() {
		return ultimoValor;
	}

	public void setUltimoValor(float ultimoValor) {
		this.ultimoValor = ultimoValor;
	}

	public void setValorIndicador(double valorIndicador) {
		this.valorIndicador = valorIndicador;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public String[] getListaValores() {
		return listaValores;
	}

	public void setListaValores(String[] listaValores) {
		this.listaValores = listaValores;
	}

	public String[] getListaDatas() {
		return listaDatas;
	}

	public void setListaDatas(String[] listaDatas) {
		this.listaDatas = listaDatas;
	}

	public String[] getListaId() {
		return listaId;
	}

	public void setListaId(String[] listaId) {
		this.listaId = listaId;
	}

	public int getIdPerspectiva() {
		return idPerspectiva;
	}

	public void setIdPerspectiva(int idPerspectiva) {
		this.idPerspectiva = idPerspectiva;
	}

	public int getCodTarefa() {
		return codTarefa;
	}

	public void setCodTarefa(int codTarefa) {
		this.codTarefa = codTarefa;
	}  
}
