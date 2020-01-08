package br.com.intraBSC.usuario.visao;

import org.apache.struts.validator.ValidatorForm;

import br.com.intraBSC.modelo.UsuarioTO;

public class UsuarioForm extends ValidatorForm{

	private static final long serialVersionUID = 1L;
	private String login;
	private String senha;
	private String confirmaSenha;
	private String nome;
	private String email;
	private String telefone;
	private String perfil;
	private int idUsuario;
	private int idGrupo;
	
	/*Caso for alterar dados ? necessario digitar a senha atual*/
	private String senhaAtual;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void setUsuarioTO(UsuarioTO usuarioTO){
		usuarioTO.setLogin(getLogin());
		usuarioTO.setSenha(getSenha());
		usuarioTO.setSenhaAtual(getSenhaAtual());
		usuarioTO.setNome(getNome());
		usuarioTO.setConfirmaSenha(getConfirmaSenha());
		usuarioTO.setEmail(getEmail());
		usuarioTO.setTelefone(getTelefone());
		usuarioTO.setPerfil(getPerfil());
		usuarioTO.getGrupoTO().setCodigo(getIdGrupo());
	}
	
	public void setUsuarioForm(UsuarioTO usuarioTO){
		setLogin(usuarioTO.getLogin());
		setSenha(usuarioTO.getSenha());
		setSenhaAtual(usuarioTO.getSenhaAtual());
		setNome(usuarioTO.getNome());
		setConfirmaSenha(usuarioTO.getConfirmaSenha());
		setEmail(usuarioTO.getEmail());
		setTelefone(usuarioTO.getTelefone());
		setPerfil(usuarioTO.getPerfil());
		setIdGrupo(usuarioTO.getGrupoTO().getCodigo());
		setIdUsuario(usuarioTO.getIdUsuario());
	}
	
	public String getConfirmaSenha() {
		return confirmaSenha;
	}
	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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
	public int getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}
	
}
