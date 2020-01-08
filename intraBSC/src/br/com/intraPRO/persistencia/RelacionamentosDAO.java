
package br.com.intraPRO.persistencia;

import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.RelacionamentosTO;
import br.com.intraPRO.modelo.ConfigTarefaTO;

import java.util.Collection;

/**
 * @author Tiago Trindade Stangarlin
 */
public interface RelacionamentosDAO{
      
	public abstract void incluirPRO(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaPRO;
   
	public abstract void incluirFAS(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaPRO;
   	  
	public abstract void alterarPRO(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaPRO;
   
	public abstract void alterarFAS(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaPRO;
   
	public abstract void excluir(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaPRO;
        
	public abstract RelacionamentosTO consultarUmPRO(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaPRO;
   
	public abstract RelacionamentosTO consultarUmFAS(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaPRO;
   
	public abstract Collection consultarVariosPRO(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaPRO;
   
	public abstract Collection consultarVariosFAS(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaPRO;
   	
	public abstract void incluirRelCONFIGTASKOWNER(ConfigTarefaTO configTarefaTO) throws ExceptionPersistenciaPRO;
	
	public abstract void alterarRelCONFIGTASKOWNER(ConfigTarefaTO configTarefaTO) throws ExceptionPersistenciaPRO;
}