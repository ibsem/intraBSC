/*
 * Created on 10
/01/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package br.com.intraBSC.mapaEstrategico.visao;

import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;


/**
 * @author Tiago Trindade Stangarlin
 */
public class MapaEstrategicoForm extends ValidatorForm{
    
    	
	private int id;
	private int ativo;
    private String nome;
    private int idResponsavel;
    private int codTarefa;
    private String missao;
    private String visao;
    private String fatoresSucesso;
    
    private FormFile fileImportar;
   
    
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
	public int getAtivo() {
		return ativo;
	}
	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}
	public int getIdResponsavel() {
		return idResponsavel;
	}
	public void setIdResponsavel(int idResponsavel) {
		this.idResponsavel = idResponsavel;
	}
	public int getCodTarefa() {
		return codTarefa;
	}
	public void setCodTarefa(int codTarefa) {
		this.codTarefa = codTarefa;
	}
	public String getMissao() {
		return missao;
	}
	public void setMissao(String missao) {
		this.missao = missao;
	}
	public String getVisao() {
		return visao;
	}
	public void setVisao(String visao) {
		this.visao = visao;
	}
	public String getFatoresSucesso() {
		return fatoresSucesso;
	}
	public void setFatoresSucesso(String fatoresSucesso) {
		this.fatoresSucesso = fatoresSucesso;
	}
	public void setFileImportar(FormFile fileImportar) {
		this.fileImportar = fileImportar;
	}
	public FormFile getFileImportar() {
		return fileImportar;
	}

    
}
