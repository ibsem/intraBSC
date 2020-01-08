package br.com.intraPRO.persistencia;

import java.util.Collection;

import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.TarefaTO;
import br.com.intraPRO.modelo.ConfigTarefaTO;
import br.com.intraPRO.modelo.ParticipanteTO;


public interface ConfigTarefaDAO{
   
  
   public abstract void incluir(ConfigTarefaTO configTarefaTO) throws ExceptionPersistenciaPRO;
   
   public abstract Collection consultarVarios(ConfigTarefaTO configTarefaTO) throws ExceptionPersistenciaPRO;
   
   public abstract Collection consultarVariosPorGrupo(ConfigTarefaTO configTarefaTO) throws ExceptionPersistenciaPRO;
   
   public abstract ConfigTarefaTO consultarUm(ConfigTarefaTO configTarefaTO) throws ExceptionPersistenciaPRO;
   
   public abstract int consultarMax() throws ExceptionPersistenciaPRO;
   
   public abstract void alterar(ConfigTarefaTO configTarefaTO) throws ExceptionPersistenciaPRO;
      
   public abstract Collection consultarTiposPorTarefa(TarefaTO tarefaTO, ParticipanteTO participanteTO) throws ExceptionPersistenciaPRO;
   
   public abstract Collection consultarVariosVisivel(ConfigTarefaTO configTarefaTO)throws ExceptionPersistenciaPRO;
 
}
