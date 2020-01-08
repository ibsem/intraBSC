
package br.com.intraBSC.persistencia;

import br.com.intraBSC.excecoes.ExceptionPersistenciaBSC;
import br.com.intraBSC.modelo.RelacionamentosTO;
import br.com.intraPRO.modelo.ConfigTarefaTO;

import java.util.Collection;

/**
 * @author Tiago Trindade Stangarlin
 */
public interface RelacionamentosDAO{
      
	public abstract void incluirBSC(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaBSC;
   
	public abstract void incluirPERS(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaBSC;
   
	public abstract void incluirTHEME(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaBSC;
   
	public abstract void alterarBSC(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaBSC;
   
	public abstract void alterarPERS(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaBSC;
   
	public abstract void alterarTHEME(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaBSC;
   
	public abstract void excluir(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaBSC;
        
	public abstract RelacionamentosTO consultarUmBSC(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaBSC;
   
	public abstract RelacionamentosTO consultarUmPERS(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaBSC;
   
	public abstract RelacionamentosTO consultarUmTHEME(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaBSC;
      
	public abstract Collection consultarVariosBSC(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaBSC;
   
	public abstract Collection consultarVariosPERS(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaBSC;
   
	public abstract Collection consultarVariosTHEME(RelacionamentosTO relacionamentosTO) throws ExceptionPersistenciaBSC;
	
	public abstract void incluirRelCONFIGTASKOWNER(ConfigTarefaTO configTarefaTO) throws ExceptionPersistenciaBSC;
	
	public abstract void alterarRelCONFIGTASKOWNER(ConfigTarefaTO configTarefaTO) throws ExceptionPersistenciaBSC;
}