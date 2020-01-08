package br.com.intraBSC.persistencia;

import java.util.Collection;

import br.com.intraBSC.excecoes.ExceptionPersistenciaBSC;
import br.com.intraBSC.modelo.PerspectivaTO;
import br.com.intraBSC.modelo.UsuarioTO;


public interface UsuarioDAO {
	public abstract UsuarioTO consultarUm(UsuarioTO usuarioTO) throws ExceptionPersistenciaBSC;
	
	public abstract UsuarioTO consultarLogon(UsuarioTO usuarioTO) throws ExceptionPersistenciaBSC;
	
	public abstract Collection consultarVarios(UsuarioTO usuarioTO) throws ExceptionPersistenciaBSC;
	
	public abstract Collection consultarUsuarioGrupo(UsuarioTO usuarioTO) throws ExceptionPersistenciaBSC;
	
	public abstract void incluir(UsuarioTO usuarioTO) throws ExceptionPersistenciaBSC;
	
	public abstract void excluir(UsuarioTO usuarioTO) throws ExceptionPersistenciaBSC;
	
	public abstract void alterar(UsuarioTO usuarioTO) throws ExceptionPersistenciaBSC;
	
	public abstract void alterarOnline(UsuarioTO usuarioTO) throws ExceptionPersistenciaBSC;
	
	public void incluirXml(UsuarioTO usuarioTO) throws ExceptionPersistenciaBSC;
	
	public int consultarMax(UsuarioTO usuarioTO) throws ExceptionPersistenciaBSC;
		
}
