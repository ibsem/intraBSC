

package br.com.intraBSC.modelo;

import net.sf.jasperreports.engine.JasperReport;


/**
 * Retorna o tema
 * 
 * @author ibsem@uol.com.br
 */
public class TemaTO 
{
   private int idTema;
   private String nomeTema;
   private UsuarioTO usuario = new UsuarioTO();
   private String descricaoTema;
   private int idMapa;
   private String nomeMapa;
   private int idObjetivo;
   private String nomeObjetivo;
   private String baseDir;
   private String caminhoRel;
   private JasperReport jasperReport;
	/**
	 * @return Returns the descricaoTema.
	 */
	public String getDescricaoTema() {
	    return descricaoTema;
	}
	/**
	 * @param descricaoTema The descricaoTema to set.
	 */
	public void setDescricaoTema(String descricaoTema) {
	    this.descricaoTema = descricaoTema;
	}
	/**
	 * @return Returns the idTema.
	 */
	public int getIdTema() {
	    return idTema;
	}
	/**
	 * @param idTema The idTema to set.
	 */
	public void setIdTema(int idTema) {
	    this.idTema = idTema;
	}
	/**
	 * @return Returns the nomeTema.
	 */
	public String getNomeTema() {
	    return nomeTema;
	}
	/**
	 * @param nomeTema The nomeTema to set.
	 */
	public void setNomeTema(String nomeTema) {
	    this.nomeTema = nomeTema;
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
	public UsuarioTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioTO usuario) {
		this.usuario = usuario;
	}

}
