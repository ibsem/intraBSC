package br.com.intraBSC.persistencia;

import java.util.Collection;

import br.com.intraBSC.excecoes.ExceptionPersistenciaBSC;
import br.com.intraBSC.modelo.PapelTO;

public interface PapelDAO {
		   
	public abstract Collection consultarVarios(PapelTO papelTO) throws ExceptionPersistenciaBSC;
	
	public abstract PapelTO consultarUm(PapelTO papelTO) throws ExceptionPersistenciaBSC;
	
	public abstract int consultarMax(PapelTO papelTO) throws ExceptionPersistenciaBSC;
	
	public abstract void alterar(PapelTO papelTO) throws ExceptionPersistenciaBSC;
	
	public abstract void incluir(PapelTO papelTO) throws ExceptionPersistenciaBSC;
}
