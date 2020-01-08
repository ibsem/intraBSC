
package br.com.intraPRO.modelo;


/**
Classe responsavel pela transferencias dos dados entre as camadas, 
representando Fracao de Anexo de tarefa.
*/
public class FracaoAnexoTO{
   
    private String anoCriacao;
    private int numeroSequencialTarefa;
    private int numeroSequencialArquivoAnexo;
    private int numeroFracaoAnexoTarefa;
    private String conteudoFracaoAnexo;    
   
	public String getAnoCriacao() {
	    return anoCriacao;
	}
	public void setAnoCriacao(String anoCriacao) {
	    this.anoCriacao = anoCriacao;
	}
	public String getConteudoFracaoAnexo() {
	    return conteudoFracaoAnexo;
	}
	public void setConteudoFracaoAnexo(String conteudoFracaoAnexo) {
	    this.conteudoFracaoAnexo = conteudoFracaoAnexo;
	}
	public int getNumeroFracaoAnexoTarefa() {
	    return numeroFracaoAnexoTarefa;
	}
	public void setNumeroFracaoAnexoTarefa(int numeroFracaoAnexoTarefa) {
	    this.numeroFracaoAnexoTarefa = numeroFracaoAnexoTarefa;
	}
	public int getNumeroSequencialArquivoAnexo() {
	    return numeroSequencialArquivoAnexo;
	}
	public void setNumeroSequencialArquivoAnexo(int numeroSequencialArquivoAnexo) {
	    this.numeroSequencialArquivoAnexo = numeroSequencialArquivoAnexo;
	}
	public int getNumeroSequencialTarefa() {
	    return numeroSequencialTarefa;
	}
	public void setNumeroSequencialTarefa(int numeroSequencialTarefa) {
	    this.numeroSequencialTarefa = numeroSequencialTarefa;
	}
    
}
