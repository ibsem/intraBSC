

package br.com.intraBSC.persistencia;

import br.com.intraBSC.excecoes.ExceptionPersistenciaBSC;
import br.com.intraBSC.modelo.MetaTO;

import java.util.Collection;

/**
 * @author Tiago Trindade Stangarlin
 */
public interface MetaDAO {
   
   
	public abstract void incluir(MetaTO metaTO) throws ExceptionPersistenciaBSC;
	
	public abstract void excluir(MetaTO metaTO) throws ExceptionPersistenciaBSC;
	
	public abstract void alterar(MetaTO metaTO) throws ExceptionPersistenciaBSC;
	
	public abstract int consultarMax(MetaTO metaTO) throws ExceptionPersistenciaBSC;
      
	public abstract MetaTO consultarUm(MetaTO metaTO) throws ExceptionPersistenciaBSC;
   
	public abstract Collection consultarVarios(MetaTO metaTO) throws ExceptionPersistenciaBSC;
      
}
