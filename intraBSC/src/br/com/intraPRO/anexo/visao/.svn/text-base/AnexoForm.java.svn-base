
package br.com.intraPRO.anexo.visao;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

import br.com.intraPRO.modelo.AnexoTO;


public class AnexoForm extends ValidatorForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AnexoForm() {

	}

	private FormFile arquivo;

	private String anoCriacao;

	private String nome;

	private String codUsuario;

	private String textoTipoConteudo;

	private int quantBytesAnexo;

	private String tsCriacaoAnexo;

	private int quantFracaoAnexo;

	private byte[] byteAnexo;

	private int numeroSequencialArquivo;

	private int numeroSequencialTarefa;

	private String nomeTarefa;

	private String capacidadeDisponivel;

	private int[] listaExcluir;

	private String numeroNomeTarefa;

	private String estado;


	public void setAnexoTO(AnexoTO anexoTO) throws Exception {
		if (this.getArquivo() != null)
			anexoTO.setArquivo(this.getArquivo());
		if (this.getAnoCriacao() != null)
			anexoTO.setAnoCriacao(this.getAnoCriacao());
		if (this.getNome() != null)
			anexoTO.setNome(this.getNome());
		if (this.getTextoTipoConteudo() != null)
			anexoTO.setTextoTipoConteudo(this.getTextoTipoConteudo());
		anexoTO.setQuantByteAnexo(this.getQuantBytesAnexo());
		anexoTO.setQuantFracaoAnexo(this.getQuantFracaoAnexo());
		if (this.getByteAnexo() != null)
			anexoTO.setByteAnexo(this.getArquivo().getFileData());
		anexoTO.setNumeroSequencialArquivo(this.getNumeroSequencialArquivo());
		anexoTO.setNumeroSequencialTarefa(this.getNumeroSequencialTarefa());
		if (this.getNomeTarefa() != null)
			anexoTO.setNomeTarefa(this.getNomeTarefa());
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors erros = new ActionErrors();
		return erros;
	}

	public void setItemForm(AnexoTO itemTO) {
	}

	public FormFile getArquivo() {
		return arquivo;
	}

	public void setArquivo(FormFile aArquivo) {
		arquivo = aArquivo;
	}

	public String getAnoCriacao() {
		return anoCriacao;
	}

	public void setAnoCriacao(String anoCriacao) {
		this.anoCriacao = anoCriacao;
	}

	public int getQuantFracaoAnexo() {
		return quantFracaoAnexo;
	}

	public void setQuantFracaoAnexo(int auntFracaoAnexo) {
		this.quantFracaoAnexo = auntFracaoAnexo;
	}

	public byte[] getByteAnexo() {
		return byteAnexo;
	}

	public void setByteAnexo(byte[] byteAnexo) {
		this.byteAnexo = byteAnexo;
	}

	public String getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantBytesAnexo() {
		return quantBytesAnexo;
	}

	public void setQuantBytesAnexo(int quantBytesAnexo) {
		this.quantBytesAnexo = quantBytesAnexo;
	}

	public String getTextoTipoConteudo() {
		return textoTipoConteudo;
	}

	public void setTextoTipoConteudo(String textoTipoConteudo) {
		this.textoTipoConteudo = textoTipoConteudo;
	}

	public String getTsCriacaoAnexo() {
		return tsCriacaoAnexo;
	}

	public void setTsCriacaoAnexo(String tsCriacaoAnexo) {
		this.tsCriacaoAnexo = tsCriacaoAnexo;
	}

	public int getNumeroSequencialArquivo() {
		return numeroSequencialArquivo;
	}

	public void setNumeroSequencialArquivo(int numeroSequencialArquivo) {
		this.numeroSequencialArquivo = numeroSequencialArquivo;
	}

	public int getNumeroSequencialTarefa() {
		return numeroSequencialTarefa;
	}

	public void setNumeroSequencialTarefa(int numeroSequencialTarefa) {
		this.numeroSequencialTarefa = numeroSequencialTarefa;
	}

	public String getNomeTarefa() {
		return nomeTarefa;
	}

	public void setNomeTarefa(String nomeTarefa) {
		this.nomeTarefa = nomeTarefa;
	}

	public String getCapacidadeDisponivel() {
		return capacidadeDisponivel;
	}

	public void setCapacidadeDisponivel(String capacidadeDisponivel) {
		this.capacidadeDisponivel = capacidadeDisponivel;
	}

	public int[] getListaExcluir() {
		return listaExcluir;
	}

	public void setListaExcluir(int[] listaExcluir) {
		this.listaExcluir = listaExcluir;
	}

	public String getNumeroNomeTarefa() {
		return numeroNomeTarefa;
	}

	public void setNumeroNomeTarefa(String numeroNomeTarefa) {
		this.numeroNomeTarefa = numeroNomeTarefa;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}