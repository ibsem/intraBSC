package br.com.intraBSC.persistencia;

import java.util.Collection;

import br.com.intraBSC.excecoes.ExceptionPersistenciaBSC;
import br.com.intraBSC.modelo.IndicadorFatoTO;

public interface IndicadorFatoDAO {

     
   public abstract Collection consultarVarios(IndicadorFatoTO indicadorFatoTO) throws ExceptionPersistenciaBSC;
   
   public abstract Collection consultarVariosIndicador(IndicadorFatoTO indicadorFatoTO) throws ExceptionPersistenciaBSC;
      
   public abstract IndicadorFatoTO consultarUm(IndicadorFatoTO indicadorFatoTO) throws ExceptionPersistenciaBSC;
                    
   public void incluir(IndicadorFatoTO indicadorFatoTO) throws ExceptionPersistenciaBSC;
   
   public void alterar(IndicadorFatoTO indicadorFatoTO) throws ExceptionPersistenciaBSC;
   
   public void excluir(IndicadorFatoTO indicadorFatoTO) throws ExceptionPersistenciaBSC;

   public abstract IndicadorFatoTO consultarUltimoIndicadorFato(IndicadorFatoTO indicadorFatoTO) throws ExceptionPersistenciaBSC;
}
