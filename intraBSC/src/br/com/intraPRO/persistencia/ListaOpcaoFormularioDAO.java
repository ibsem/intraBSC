package br.com.intraPRO.persistencia;

import java.util.Collection;

import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.ListaOpcaoFormularioTO;

public interface ListaOpcaoFormularioDAO {
	
	public abstract void incluir(ListaOpcaoFormularioTO listaOpcaoFormularioTO) throws ExceptionPersistenciaPRO;
	
	public abstract Collection consultarVarios(ListaOpcaoFormularioTO listaOpcaoFormularioTO) throws ExceptionPersistenciaPRO;
	
	public abstract void alterar(ListaOpcaoFormularioTO listaOpcaoFormularioTO) throws ExceptionPersistenciaPRO;
	
	public abstract int consultarMax() throws ExceptionPersistenciaPRO;
	
	public abstract void excluir(ListaOpcaoFormularioTO listaOpcaoFormularioTO) throws ExceptionPersistenciaPRO;

}
