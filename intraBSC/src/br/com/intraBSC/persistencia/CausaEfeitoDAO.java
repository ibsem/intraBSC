package br.com.intraBSC.persistencia;

import java.util.Collection;

import br.com.intraBSC.excecoes.ExceptionPersistenciaBSC;
import br.com.intraBSC.modelo.CausaEfeitoTO;

public interface CausaEfeitoDAO {
	
	public abstract Collection consultarVarios(CausaEfeitoTO causaEfeitoTO) throws ExceptionPersistenciaBSC;
	
	public abstract CausaEfeitoTO consultarUm(CausaEfeitoTO causaEfeitoTO) throws ExceptionPersistenciaBSC;
	
	public abstract void incluir(CausaEfeitoTO causaEfeitoTO) throws ExceptionPersistenciaBSC;	
	
	public abstract void alterar(CausaEfeitoTO causaEfeitoTO) throws ExceptionPersistenciaBSC;
	
	public abstract void excluir(CausaEfeitoTO causaEfeitoTO) throws ExceptionPersistenciaBSC;
	
	public abstract int consultarMax(CausaEfeitoTO causaEfeitoTO) throws ExceptionPersistenciaBSC;
	


}
