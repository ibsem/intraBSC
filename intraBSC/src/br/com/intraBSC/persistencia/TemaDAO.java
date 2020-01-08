
package br.com.intraBSC.persistencia;

import br.com.intraBSC.excecoes.ExceptionPersistenciaBSC;
import br.com.intraBSC.modelo.TemaTO;

import java.util.Collection;

import net.sf.jasperreports.engine.JasperPrint;

public interface TemaDAO{
      
   public TemaTO consultarUm(TemaTO temaTO) throws ExceptionPersistenciaBSC;
      
   public Collection consultarVariosMapa(TemaTO temaTO) throws ExceptionPersistenciaBSC;
   
   public Collection consultarVarios(TemaTO temaTO) throws ExceptionPersistenciaBSC;
   
   public int consultarMax(TemaTO temaTO) throws ExceptionPersistenciaBSC;
   
   public void alterar(TemaTO temaTO) throws ExceptionPersistenciaBSC;
   
   public TemaTO consultarUmPorObjetivo(TemaTO temaTO) throws ExceptionPersistenciaBSC;
   
   public void incluir(TemaTO temaTO) throws ExceptionPersistenciaBSC;
   
   public void excluir(TemaTO temaTO) throws ExceptionPersistenciaBSC;
  
   public JasperPrint temaRelatorioDetalha(TemaTO temaTO) throws ExceptionPersistenciaBSC;
}
