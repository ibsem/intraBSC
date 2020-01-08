package br.com.intraBSC.persistencia;

import java.util.Collection;

import br.com.intraBSC.excecoes.ExceptionPersistenciaBSC;
import br.com.intraBSC.modelo.PeriodicidadeTO;

public interface PeriodicidadeDAO {

	public abstract Collection consultarVarios(PeriodicidadeTO periodicidadeTO) throws ExceptionPersistenciaBSC;
	
	public abstract PeriodicidadeTO consultarUm(PeriodicidadeTO periodicidadeTO) throws ExceptionPersistenciaBSC;
	
	public abstract int consultarMax(PeriodicidadeTO periodicidadeTO) throws ExceptionPersistenciaBSC;
	
	public abstract void alterar(PeriodicidadeTO periodicidadeTO) throws ExceptionPersistenciaBSC;
	
	public abstract void incluir(PeriodicidadeTO periodicidadeTO) throws ExceptionPersistenciaBSC;
}
