

package br.com.intraPRO.modelo;

import net.sf.jasperreports.engine.JasperReport;

public class FaseTO {
	
	
	private int id;
	private String nome;
	private String descricao;
	private int ordem;
	private int responsavel;
	private int tipoFase;
	private int ativo;
	
	private JasperReport jasperReport;
	private String baseDir;
	private String transicaoRel;
	
	private String nomeProcesso;
	
	private int xInicialFase;
	private int yInicialFase;
	private int xFinalFase;
	private int yFinalFase;
	private int numeroAtividades;
   
	
	/*Variavel utiliza para pesquisa de fase, consultar todas as fases de um MAPA*/
	private int idProcesso;
	
	/*varivel que guarda o valor do comprimento que a TD deve ter na tela principal de perspecriva
	 * Este calcula esta sendo feito na action de fase*/
	private int widthObjetivo;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getIdProcesso() {
		return idProcesso;
	}

	public void setIdProcesso(int idProcesso) {
		this.idProcesso = idProcesso;
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
	
	public int getWidthObjetivo() {
		return widthObjetivo;
	}
	public void setWidthObjetivo(int widthObjetivo) {
		this.widthObjetivo = widthObjetivo;
	}

	public String getNomeProcesso() {
		return nomeProcesso;
	}

	public void setNomeProcesso(String nomeProcesso) {
		this.nomeProcesso = nomeProcesso;
	}

	public JasperReport getJasperReport() {
		return jasperReport;
	}

	public void setJasperReport(JasperReport jasperReport) {
		this.jasperReport = jasperReport;
	}

	public String getBaseDir() {
		return baseDir;
	}

	public void setBaseDir(String baseDir) {
		this.baseDir = baseDir;
	}

	public String getTransicaoRel() {
		return transicaoRel;
	}

	public void setTransicaoRel(String transicaoRel) {
		this.transicaoRel = transicaoRel;
	}

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

	public int getXFinalFase() {
		return xFinalFase;
	}

	public void setXFinalFase(int finalFase) {
		xFinalFase = finalFase;
	}

	public int getXInicialFase() {
		return xInicialFase;
	}

	public void setXInicialFase(int inicialFase) {
		xInicialFase = inicialFase;
	}

	public int getYFinalFase() {
		return yFinalFase;
	}

	public void setYFinalFase(int finalFase) {
		yFinalFase = finalFase;
	}

	public int getYInicialFase() {
		return yInicialFase;
	}

	public void setYInicialFase(int inicialFase) {
		yInicialFase = inicialFase;
	}

	public int getNumeroAtividades() {
		return numeroAtividades;
	}

	public void setNumeroAtividades(int numeroAtividades) {
		this.numeroAtividades = numeroAtividades;
	}
}
