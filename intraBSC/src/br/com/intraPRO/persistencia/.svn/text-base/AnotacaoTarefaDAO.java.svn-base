
package br.com.intraPRO.persistencia;

import java.util.Collection;

import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.AnotacaoTarefaTO;


/**
Classe que possue as assinaturas dos metodos que devem ser implementados na 
DAOIMPL
*/
public interface AnotacaoTarefaDAO{
   
   
   public abstract void incluir(AnotacaoTarefaTO historicaTarefaTO) throws ExceptionPersistenciaPRO;
      
   public abstract Collection consultarVarios(AnotacaoTarefaTO anotacaoTO) throws ExceptionPersistenciaPRO;
   
   public abstract  AnotacaoTarefaTO consultarUltAnotacao(AnotacaoTarefaTO historicaTarefaTO) throws ExceptionPersistenciaPRO;
}
