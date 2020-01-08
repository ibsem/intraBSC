
package br.com.intraPRO.persistencia;

import java.util.Collection;

import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.ParticipanteTO;

/**
Classe que possui as assinaturas de metodos que devem ser implementeados na 
classe IMPL.
*/
public interface ParticipanteDAO{
   
  
   public abstract void incluir(ParticipanteTO participanteTO) throws ExceptionPersistenciaPRO;
   
   public abstract void alterar(ParticipanteTO participanteTO) throws ExceptionPersistenciaPRO;
      
   public abstract Collection consultarVarios(ParticipanteTO participanteTO) throws ExceptionPersistenciaPRO;
   
   public abstract int consultarMax() throws ExceptionPersistenciaPRO;
   
   public abstract void excluir(ParticipanteTO participanteTO) throws ExceptionPersistenciaPRO;
   
   public abstract ParticipanteTO consultarUm(ParticipanteTO participanteTO) throws ExceptionPersistenciaPRO;
   
}
