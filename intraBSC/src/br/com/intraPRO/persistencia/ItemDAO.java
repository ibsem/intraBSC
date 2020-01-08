
package br.com.intraPRO.persistencia;

import java.util.Collection;

import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.ItemTO;

/**
Classe que contem as asssinaturas dos metodos do Item.
*/
public interface ItemDAO {
   
   public abstract void incluir(ItemTO itemTO) throws ExceptionPersistenciaPRO;
      
   public abstract void alterar(ItemTO itemTO) throws ExceptionPersistenciaPRO;
   
   public abstract Collection consultarVarios(ItemTO itemTO) throws ExceptionPersistenciaPRO;
         
   public abstract ItemTO consultarUm(ItemTO itemTO) throws ExceptionPersistenciaPRO;
      
   public abstract int consultarMaxNumeroOrdem(ItemTO itemTO) throws ExceptionPersistenciaPRO;
   
   public abstract Collection consultaItemConfigTarefa(ItemTO itemTO) throws ExceptionPersistenciaPRO;
}
