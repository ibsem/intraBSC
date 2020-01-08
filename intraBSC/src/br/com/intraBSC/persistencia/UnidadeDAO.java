package br.com.intraBSC.persistencia;

import java.util.Collection;

import br.com.intraBSC.excecoes.ExceptionPersistenciaBSC;
import br.com.intraBSC.modelo.UnidadeTO;

public interface UnidadeDAO {
		   
	public abstract Collection consultarVarios(UnidadeTO unidadeTO) throws ExceptionPersistenciaBSC;
	
	public abstract UnidadeTO consultarUm(UnidadeTO unidadeTO) throws ExceptionPersistenciaBSC;
	
	public abstract int consultarMax(UnidadeTO unidadeTO) throws ExceptionPersistenciaBSC;
	
	public abstract void alterar(UnidadeTO unidadeTO) throws ExceptionPersistenciaBSC;
	
	public abstract void incluir(UnidadeTO unidadeTO) throws ExceptionPersistenciaBSC;
}
