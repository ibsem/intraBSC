package br.com.intraPRO.persistencia;

import java.util.Collection;

import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.ListaOpcaoItemTO;

public interface ListaOpcaoItemDAO {
	
	public abstract void incluir(ListaOpcaoItemTO listaOpcaoItemTO) throws ExceptionPersistenciaPRO;
	
	public abstract Collection consultarVarios(ListaOpcaoItemTO listaOpcaoItemTO) throws ExceptionPersistenciaPRO;
	
	public abstract void alterar(ListaOpcaoItemTO listaOpcaoItemTO) throws ExceptionPersistenciaPRO;
	
	public abstract int consultarMax() throws ExceptionPersistenciaPRO;
	
	public abstract void excluir(ListaOpcaoItemTO listaOpcaoItemTO) throws ExceptionPersistenciaPRO;

}
