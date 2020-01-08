

package br.com.intraBSC.modelo;

import net.sf.jasperreports.engine.JasperReport;

public class PerspectivaTO {
	
	
	private int id;
	private String nome;
	private String descricao;
	private int ordem;
	private int responsavel;
	private int tipoPerspectiva;
	private int ativo;
	
	private JasperReport jasperReport;
	private String baseDir;
	private String caminhoRel;
	
	private String nomeMapa;
	
	private int xInicialPerspectiva;
	private int yInicialPerspectiva;
	private int xFinalPerspectiva;
	private int yFinalPerspectiva;
	private int numeroObjetivos;
   
	
	/*Variavel utiliza para pesquisa de perspectiva, consultar todas as perspectivas de um MAPA*/
	private int idMapa;
	
	/*varivel que guarda o valor do comprimento que a TD deve ter na tela principal de perspecriva
	 * Este calcula esta sendo feito na action de perspectiva*/
	private int widthObjetivo;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getIdMapa() {
		return idMapa;
	}

	public void setIdMapa(int idMapa) {
		this.idMapa = idMapa;
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
	
	public int getWidthObjetivo() {
		return widthObjetivo;
	}
	public void setWidthObjetivo(int widthObjetivo) {
		this.widthObjetivo = widthObjetivo;
	}

	public String getNomeMapa() {
		return nomeMapa;
	}

	public void setNomeMapa(String nomeMapa) {
		this.nomeMapa = nomeMapa;
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

	public String getCaminhoRel() {
		return caminhoRel;
	}

	public void setCaminhoRel(String caminhoRel) {
		this.caminhoRel = caminhoRel;
	}

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

	public int getXFinalPerspectiva() {
		return xFinalPerspectiva;
	}

	public void setXFinalPerspectiva(int finalPerspectiva) {
		xFinalPerspectiva = finalPerspectiva;
	}

	public int getXInicialPerspectiva() {
		return xInicialPerspectiva;
	}

	public void setXInicialPerspectiva(int inicialPerspectiva) {
		xInicialPerspectiva = inicialPerspectiva;
	}

	public int getYFinalPerspectiva() {
		return yFinalPerspectiva;
	}

	public void setYFinalPerspectiva(int finalPerspectiva) {
		yFinalPerspectiva = finalPerspectiva;
	}

	public int getYInicialPerspectiva() {
		return yInicialPerspectiva;
	}

	public void setYInicialPerspectiva(int inicialPerspectiva) {
		yInicialPerspectiva = inicialPerspectiva;
	}

	public int getNumeroObjetivos() {
		return numeroObjetivos;
	}

	public void setNumeroObjetivos(int numeroObjetivos) {
		this.numeroObjetivos = numeroObjetivos;
	}
}
