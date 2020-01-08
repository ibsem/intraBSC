package br.com.intraBSC.modelo;

public class UsuarioTO {

	private String perfil;
	private String nome;
	private String email;
	private String login;
	private String senha;
	private int idUsuario;
	private String telefone;
	private String confirmaSenha;
	private int online;
	
	private String senhaAtual;
	
	private GrupoTO grupoTO = new GrupoTO();

	
	public boolean hasRoles(String role){
		if (role.contains(getPerfil())){
			return true;
		}else{
			return false;
		}
	}
		
	public String getConfirmaSenha() {
		return confirmaSenha;
	}
	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getSenhaAtual() {
		return senhaAtual;
	}

	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}

	public GrupoTO getGrupoTO() {
		return grupoTO;
	}

	public void setGrupoTO(GrupoTO grupoTO) {
		this.grupoTO = grupoTO;
	}

	public int getOnline() {
		return online;
	}

	public void setOnline(int online) {
		this.online = online;
	}
	
	
}
