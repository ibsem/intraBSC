package br.com.intraPRO.modelo;

public class ParticipanteConfigTarefaTO {
   private int anoCriacao;
   private int codTarefa;
   private int codigo;
   private int codTipoParticipacao;
   private int codConfigTarefa;
   private String emailAdress;
   private String login;
   private int codUsuario;   
   private int[] listaParticipante;
   private String nomeUsuario;
   private String nomeParticipante;
   private String nome;
   private int codPapel;
	
   public int getCodPapel() {
	return codPapel;
}
public void setCodPapel(int codPapel) {
	this.codPapel = codPapel;
}
public int getAnoCriacao() {
		return anoCriacao;
	}
	public void setAnoCriacao(int anoCriacao) {
		this.anoCriacao = anoCriacao;
	}
	public int getCodTarefa() {
		return codTarefa;
	}
	public void setCodTarefa(int codTarefa) {
		this.codTarefa = codTarefa;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodTipoParticipacao() {
		return codTipoParticipacao;
	}
	public void setCodTipoParticipacao(int codTipoParticipacao) {
		this.codTipoParticipacao = codTipoParticipacao;
	}
	public String getEmailAdress() {
		return emailAdress;
	}
	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public int getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}
	public int[] getListaParticipante() {
		return listaParticipante;
	}
	public void setListaParticipante(int[] listaParticipante) {
		this.listaParticipante = listaParticipante;
	}
	public int getCodConfigTarefa() {
		return codConfigTarefa;
	}
	public void setCodConfigTarefa(int codConfigTarefa) {
		this.codConfigTarefa = codConfigTarefa;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getNomeParticipante() {
		return nomeParticipante;
	}
	public void setNomeParticipante(String nomeParticipante) {
		this.nomeParticipante = nomeParticipante;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
