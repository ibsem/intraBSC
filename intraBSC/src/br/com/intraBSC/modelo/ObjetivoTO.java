//Source file: C:\\Java\\workspace\\IntraBSC\\WEB-INF\\src\\br\\com\\intraBSC\\modelo\\br\\com\\intraBSC\\modelo\\ObjetivoTO.java

package br.com.intraBSC.modelo;


import net.sf.jasperreports.engine.JasperReport;


public class ObjetivoTO {
	

   private int id;
   private String nome;
   private int responsavel;
   private String descricao;
   private int idTema;
   private int ativo;
   
   /*Variavel utiliza para pesquisa de perspectiva, consultar todas as perspectivas de um MAPA*/
	private int idMapa;
	private String nomeMapa;
	
	/*Variavel utilizada para guardar o identificador da perspectiva de cada objetivo*/	
	private int idPerspectiva;
	private String nomePerspectiva;
		

	private JasperReport jasperReport;
	private String baseDir;
	private String caminhoRel;
	
	// Coordenadas do objetivo para o mapa Gráfico
	private int xInicialObjetivo;
	private int yInicialObjetivo;
	private int xFinalObjetivo;
	private int yFinalObjetivo;
	private int xCausaEfeito;
	private int yCausaEfeito;
	private int corTema;
	private int linha;
	private int tamanhoFonte;
	private int coluna;
	
	public int getTamanhoFonte() {
		return tamanhoFonte;
	}
	public void setTamanhoFonte(int tamanhoFonte) {
		this.tamanhoFonte = tamanhoFonte;
	}
	public int getCorTema() {
		return corTema;
	}
	public void setCorTema(int corTema) {
		this.corTema = corTema;
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
	public int getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(int responsavel) {
		this.responsavel = responsavel;
	}
	public int getIdMapa() {
		return idMapa;
	}
	public void setIdMapa(int idMapa) {
		this.idMapa = idMapa;
	}
	public int getIdPerspectiva() {
		return idPerspectiva;
	}
	public void setIdPerspectiva(int idPerspectiva) {
		this.idPerspectiva = idPerspectiva;
	}
	public String getNomePerspectiva() {
		return nomePerspectiva;
	}
	public void setNomePerspectiva(String nomePerspectiva) {
		this.nomePerspectiva = nomePerspectiva;
	}
	public String getNomeMapa() {
		return nomeMapa;
	}
	public void setNomeMapa(String nomeMapa) {
		this.nomeMapa = nomeMapa;
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
	public JasperReport getJasperReport() {
		return jasperReport;
	}
	public void setJasperReport(JasperReport jasperReport) {
		this.jasperReport = jasperReport;
	}
	public int getIdTema() {
		return idTema;
	}
	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}
	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}
	public int getXFinalObjetivo() {
		return xFinalObjetivo;
	}
	public void setXFinalObjetivo(int finalObjetivo) {
		xFinalObjetivo = finalObjetivo;
	}
	public int getXInicialObjetivo() {
		return xInicialObjetivo;
	}
	public void setXInicialObjetivo(int inicialObjetivo) {
		xInicialObjetivo = inicialObjetivo;
	}
	public int getYFinalObjetivo() {
		return yFinalObjetivo;
	}
	public void setYFinalObjetivo(int finalObjetivo) {
		yFinalObjetivo = finalObjetivo;
	}
	public int getYInicialObjetivo() {
		return yInicialObjetivo;
	}
	public void setYInicialObjetivo(int inicialObjetivo) {
		yInicialObjetivo = inicialObjetivo;
	}
	public int getXCausaEfeito() {
		return xCausaEfeito;
	}
	public void setXCausaEfeito(int causaEfeito) {
		xCausaEfeito = causaEfeito;
	}
	public int getYCausaEfeito() {
		return yCausaEfeito;
	}
	public void setYCausaEfeito(int causaEfeito) {
		yCausaEfeito = causaEfeito;
	}
	public int getLinha() {
		return linha;
	}
	public void setLinha(int linha) {
		this.linha = linha;
	}
	/**
	 * @return the coluna
	 */
	public int getColuna() {
		return coluna;
	}
	/**
	 * @param _coluna the coluna to set
	 */
	public void setColuna(int _coluna) {
		coluna = _coluna;
	}
   
   
}
