package br.com.intraPRO.persistencia;

import java.util.Collection;

import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.ParticipanteConfigTarefaTO;

public interface ParticipanteConfigTarefaDAO {
	
	 
   public abstract void incluir(ParticipanteConfigTarefaTO participanteConfigTarefaTO) throws ExceptionPersistenciaPRO;
      
   public abstract Collection consultarVarios(ParticipanteConfigTarefaTO participanteConfigTarefaTO) throws ExceptionPersistenciaPRO;
      
   public abstract int consultarMax() throws ExceptionPersistenciaPRO;
   
   public abstract void excluir(ParticipanteConfigTarefaTO participanteConfigTarefaTO) throws ExceptionPersistenciaPRO;
   
   public abstract ParticipanteConfigTarefaTO consultarUm(ParticipanteConfigTarefaTO participanteConfigTarefaTO) throws ExceptionPersistenciaPRO;     

}
