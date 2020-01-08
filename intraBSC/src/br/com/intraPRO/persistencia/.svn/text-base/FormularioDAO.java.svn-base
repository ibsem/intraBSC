
package br.com.intraPRO.persistencia;

import java.util.Collection;

import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.FormularioTO;

/**
Classe que contem as asssinaturas dos metodos do Formulario.
*/
public interface FormularioDAO {
   
   public abstract void incluir(FormularioTO formularioTO) throws ExceptionPersistenciaPRO;
      
   public abstract void alterar(FormularioTO formularioTO) throws ExceptionPersistenciaPRO;
   
   public abstract Collection consultarVarios(FormularioTO formularioTO) throws ExceptionPersistenciaPRO;
         
   public abstract FormularioTO consultarUm(FormularioTO formularioTO) throws ExceptionPersistenciaPRO;
      
   public abstract int consultarMaxNumeroOrdem(FormularioTO formularioTO) throws ExceptionPersistenciaPRO;
   
   public abstract Collection consultaFormularioConfigTarefa(FormularioTO formularioTO) throws ExceptionPersistenciaPRO;
}
