

package br.com.intraBSC.persistencia;

import br.com.intraBSC.excecoes.ExceptionPersistenciaBSC;
import br.com.intraBSC.modelo.ObjetivoTO;

import java.util.Collection;

import net.sf.jasperreports.engine.JasperPrint;

/**
 * @author Tiago Trindade Stangarlin
 */
public interface ObjetivoDAO{
         
   public Collection consultarVarios(ObjetivoTO objetivoTO) throws ExceptionPersistenciaBSC;
   
   public ObjetivoTO consultarUm(ObjetivoTO objetivoTO) throws ExceptionPersistenciaBSC;
   
   public int consultarMax(ObjetivoTO objetivoTO) throws ExceptionPersistenciaBSC;
   
   public void incluir(ObjetivoTO objetivoTO) throws ExceptionPersistenciaBSC;
   
   public void alterar(ObjetivoTO objetivoTO) throws ExceptionPersistenciaBSC;
   
   public JasperPrint objetivoRelatorioDetalha(ObjetivoTO objetivoTO) throws ExceptionPersistenciaBSC;
   
   public Collection consultarObjetivoMapa(ObjetivoTO objetivoTO) throws ExceptionPersistenciaBSC;
   
   public Integer consultarMapaPorObjetivo(ObjetivoTO objetivoTO) throws ExceptionPersistenciaBSC;

   public Collection consultarObjetivosMapaGrafico(ObjetivoTO objetivoTO) throws ExceptionPersistenciaBSC;
   
}
