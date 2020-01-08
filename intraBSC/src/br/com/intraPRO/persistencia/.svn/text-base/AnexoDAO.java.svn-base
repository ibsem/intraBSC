
package br.com.intraPRO.persistencia;

import java.util.Collection;

import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.AnexoTO;


/**
Interface que possue as assinaturas dos metodos que devem ser implementados na 
DAOIMPL de Anexo.
*/
public interface AnexoDAO{
      
   public abstract boolean incluir(AnexoTO anexoTO) throws ExceptionPersistenciaPRO;
      
   public abstract AnexoTO consultarUm(AnexoTO anexoTO) throws ExceptionPersistenciaPRO;
     
   public abstract Collection consultarVarios(AnexoTO anexoTO) throws ExceptionPersistenciaPRO;
   
   public abstract void excluir(AnexoTO anexoTO) throws ExceptionPersistenciaPRO;
   
   public abstract int consultarMax(AnexoTO anexoTO) throws ExceptionPersistenciaPRO;
   
   public abstract byte[] download(AnexoTO anexoTO) throws ExceptionPersistenciaPRO;
}

