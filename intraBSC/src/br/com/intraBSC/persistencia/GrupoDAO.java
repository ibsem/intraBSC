package br.com.intraBSC.persistencia;

import java.util.Collection;

import br.com.intraBSC.excecoes.ExceptionPersistenciaBSC;
import br.com.intraBSC.modelo.GrupoTO;

public interface GrupoDAO {
	
	public abstract Collection consultarVarios(GrupoTO grupoTO) throws ExceptionPersistenciaBSC;
	
	public abstract GrupoTO consultarUm(GrupoTO grupoTO) throws ExceptionPersistenciaBSC;
	
	public abstract void incluir(GrupoTO grupoTO) throws ExceptionPersistenciaBSC;	
	
	public abstract void alterar(GrupoTO grupoTO) throws ExceptionPersistenciaBSC;
	
	public abstract int consultarMax(GrupoTO grupoTO) throws ExceptionPersistenciaBSC;

}
