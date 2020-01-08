package br.com.intraPRO.persistencia;

import java.util.Collection;

import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.TransicaoTO;

public interface TransicaoDAO {
	
	public abstract Collection consultarVarios(TransicaoTO causaEfeitoTO) throws ExceptionPersistenciaPRO;
	
	public abstract TransicaoTO consultarUm(TransicaoTO causaEfeitoTO) throws ExceptionPersistenciaPRO;
	
	public abstract void incluir(TransicaoTO causaEfeitoTO) throws ExceptionPersistenciaPRO;	
	
	public abstract void alterar(TransicaoTO causaEfeitoTO) throws ExceptionPersistenciaPRO;
	
	public abstract void excluir(TransicaoTO causaEfeitoTO) throws ExceptionPersistenciaPRO;
	
	public abstract int consultarMax(TransicaoTO causaEfeitoTO) throws ExceptionPersistenciaPRO;
	


}
