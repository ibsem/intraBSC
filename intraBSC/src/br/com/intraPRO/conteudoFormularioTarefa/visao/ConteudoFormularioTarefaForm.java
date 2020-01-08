package br.com.intraPRO.conteudoFormularioTarefa.visao;

import org.apache.struts.validator.ValidatorForm;

public class ConteudoFormularioTarefaForm extends ValidatorForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private String anoNome;
	
    private int[] numeroOrdem;

    private int[] anoCriacao;    
    
    private int[] codConfigTarefa;    
    
	private String[] textoFormularioTarefa;
	
	private String[] indVigente;

	private String listaOpcaoTipoFormulario;
	
	public String[] getIndVigente() {
		return indVigente;
	}

	public void setIndVigente(String[] indVigente) {
		this.indVigente = indVigente;
	}

	public ConteudoFormularioTarefaForm() {

	}

    /**
     * @return Returns the anoCriacao.
     */
    public int[] getAnoCriacao() {
        return anoCriacao;
    }

    /**
     * @param anoCriacao The anoCriacao to set.
     */
    public void setAnoCriacao(int[] anoCriacao) {
        this.anoCriacao = anoCriacao;
    }

    /**
     * @return Returns the codConfigTarefa.
     */
    public int[] getCodConfigTarefa() {
        return codConfigTarefa;
    }

    /**
     * @param codConfigTarefa The codConfigTarefa to set.
     */
    public void setCodConfigTarefa(int[] codConfigTarefa) {
        this.codConfigTarefa = codConfigTarefa;
    }

    /**
     * @return Returns the numeroOrdem.
     */
    public int[] getNumeroOrdem() {
        return numeroOrdem;
    }

    /**
     * @param numeroOrdem The numeroOrdem to set.
     */
    public void setNumeroOrdem(int[] numeroOrdem) {
        this.numeroOrdem = numeroOrdem;
    }

    /**
     * @return Returns the textoFormularioTarefa.
     */
    public String[] getTextoFormularioTarefa() {
        return textoFormularioTarefa;
    }

    /**
     * @param textoFormularioTarefa The textoFormularioTarefa to set.
     */
    public void setTextoFormularioTarefa(String[] textoFormularioTarefa) {
        this.textoFormularioTarefa = textoFormularioTarefa;
    }

    /**
     * @return Returns the anoNome.
     */
    public String getAnoNome() {
        return anoNome;
    }

    /**
     * @param anoNome The anoNome to set.
     */
    public void setAnoNome(String anoNome) {
        this.anoNome = anoNome;
    }

	public String getListaOpcaoTipoFormulario() {
		return listaOpcaoTipoFormulario;
	}

	public void setListaOpcaoTipoFormulario(String listaOpcaoTipoFormulario) {
		this.listaOpcaoTipoFormulario = listaOpcaoTipoFormulario;
	}

}
