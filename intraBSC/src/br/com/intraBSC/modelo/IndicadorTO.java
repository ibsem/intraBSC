

package br.com.intraBSC.modelo;


import java.sql.Date;

import net.sf.jasperreports.engine.JasperReport;


/**
 * @author Ibsem
 */
public class IndicadorTO{
   private int id;
   private int idObjetivo;
   private String nomeObjetivo;
   private int responsavelIndicador;
   private String nomeResponsavel;
   private String nome;
   private int periodicidade;
   private int unidade;
   private String descricao;
   private int ativo;
   private float ultimoValor;
   private float limiteInferior;
   private float limiteSuperior;
   private String nomeUnidade;
   private int sinal;
   private int inversaoLimite;
   private float desvio;
   
   private Date ultimaData; 
   
   /*variavel utilizada para entidade de MEASUREDIMENSION*/
   private int idDimensao;
   
   private JasperReport jasperReport;
   private String baseDir;
   private String caminhoRel;
   
   private int idMapa;
   private String nomeMapa;
   private int ordemPerspectiva;
   private int idPerspectiva;
   private String nomePerspectiva;
   
   public IndicadorTO(){    
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
	
	public int getIdMapa() {
		return idMapa;
	}
	
	public void setIdMapa(int idMapa) {
		this.idMapa = idMapa;
	}
	
	public int getIdObjetivo() {
		return idObjetivo;
	}
	
	public void setIdObjetivo(int idObjetivo) {
		this.idObjetivo = idObjetivo;
	}
	
	public int getIdPerspectiva() {
		return idPerspectiva;
	}
	
	public void setIdPerspectiva(int idPerspectiva) {
		this.idPerspectiva = idPerspectiva;
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
	
	public int getResponsavelIndicador() {
		return responsavelIndicador;
	}
	
	public void setResponsavelIndicador(int responsavelIndicador) {
		this.responsavelIndicador = responsavelIndicador;
	}
	
	public int getUnidade() {
		return unidade;
	}
	
	public void setUnidade(int unidade) {
		this.unidade = unidade;
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

	public String getNomeMapa() {
		return nomeMapa;
	}

	public void setNomeMapa(String nomeMapa) {
		this.nomeMapa = nomeMapa;
	}

	public String getNomeObjetivo() {
		return nomeObjetivo;
	}

	public void setNomeObjetivo(String nomeObjetivo) {
		this.nomeObjetivo = nomeObjetivo;
	}

	public String getNomePerspectiva() {
		return nomePerspectiva;
	}

	public void setNomePerspectiva(String nomePerspectiva) {
		this.nomePerspectiva = nomePerspectiva;
	}

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

	public Date getUltimaData() {
		return ultimaData;
	}

	public void setUltimaData(Date ultimaData) {
		this.ultimaData = ultimaData;
	}

	public int getIdDimensao() {
		return idDimensao;
	}

	public void setIdDimensao(int idDimensao) {
		this.idDimensao = idDimensao;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public int getOrdemPerspectiva() {
		return ordemPerspectiva;
	}

	public void setOrdemPerspectiva(int ordemPerspectiva) {
		this.ordemPerspectiva = ordemPerspectiva;
	}

	public float getUltimoValor() {
		return ultimoValor;
	}

	public void setUltimoValor(float ultimoValor) {
		this.ultimoValor = ultimoValor;
	}

	public float getLimiteInferior() {
		return limiteInferior;
	}

	public void setLimiteInferior(float limiteInferior) {
		this.limiteInferior = limiteInferior;
	}

	public float getLimiteSuperior() {
		return limiteSuperior;
	}

	public void setLimiteSuperior(float limiteSuperior) {
		this.limiteSuperior = limiteSuperior;
	}

	public String getNomeUnidade() {
		return nomeUnidade;
	}

	public void setNomeUnidade(String nomeUnidade) {
		this.nomeUnidade = nomeUnidade;
	}

	public int getSinal() {
		return sinal;
	}

	public void setSinal(int sinal) {
		this.sinal = sinal;
	}

	public int getInversaoLimite() {
		return inversaoLimite;
	}

	public void setInversaoLimite(int inversaoLimite) {
		this.inversaoLimite = inversaoLimite;
	}

	public float getDesvio() {
		return desvio;
	}

	public void setDesvio(float desvio) {
		this.desvio = desvio;
	}

	
}
