
package br.com.intraPRO.persistencia;

import java.util.Collection;

import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.ConteudoItemTarefaTO;

/**
Classe com as assinaturas dos metodos que devem ser implementados na classe da DAOIMPL.
*/
public interface ConteudoItemTarefaDAO{
   
   public abstract void alterar(ConteudoItemTarefaTO conteudoItemTarefaTO) throws ExceptionPersistenciaPRO;
	
   public abstract void incluir(ConteudoItemTarefaTO conteudoItemTarefaTO) throws ExceptionPersistenciaPRO;
   
   public abstract void incluirItemTarefa(ConteudoItemTarefaTO conteudoItemTarefaTO) throws ExceptionPersistenciaPRO;   
   
   public abstract void excluirItemTarefa(ConteudoItemTarefaTO conteudoItemTarefaTO) throws ExceptionPersistenciaPRO;   
   
   public Collection consultarItems(ConteudoItemTarefaTO conteudoItemTarefaTO) throws ExceptionPersistenciaPRO;
   
   //public abstract Collection consultarItemCriticos(ConteudoItemTarefaTO conteudoItemTarefaTO) throws ExceptionPersistenciaPRO;
   
   public abstract Collection consultarItemCritico(ConteudoItemTarefaTO conteudoItemTarefaTO) throws ExceptionPersistenciaPRO;
}
