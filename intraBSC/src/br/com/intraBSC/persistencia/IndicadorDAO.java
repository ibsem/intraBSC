

package br.com.intraBSC.persistencia;

import java.sql.Date;
import java.util.Collection;

import net.sf.jasperreports.engine.JasperPrint;
import br.com.intraBSC.excecoes.ExceptionPersistenciaBSC;
import br.com.intraBSC.modelo.IndicadorTO;

/**
 * @author Tiago Trindade Stangarlin
 */
public interface IndicadorDAO {
      
         
   public abstract Collection consultarVarios(IndicadorTO IndicadorTO) throws ExceptionPersistenciaBSC;
      
   public abstract IndicadorTO consultarUm(IndicadorTO indicadorTO) throws ExceptionPersistenciaBSC;
   
   public abstract int consultarMax(IndicadorTO indicadorTO) throws ExceptionPersistenciaBSC;
   
   public abstract Date consultarUltimaData(IndicadorTO indicadorTO) throws ExceptionPersistenciaBSC;
   
   public abstract JasperPrint indicadorRelatorioDetalha(IndicadorTO indicadorTO) throws ExceptionPersistenciaBSC;
   
   public abstract JasperPrint indicadorRelatorioDetalhaSemValor(IndicadorTO indicadorTO) throws ExceptionPersistenciaBSC;
   
   public abstract JasperPrint meusIndicadoresRelatorioDetalha(IndicadorTO indicadorTO) throws ExceptionPersistenciaBSC;
   
   public Collection consultarArvoreVisualizacao(IndicadorTO indicadorTO) throws ExceptionPersistenciaBSC;
   
   public abstract Collection consultarIndicadorUsuario(IndicadorTO indicadorTO) throws ExceptionPersistenciaBSC;
   
   public void incluir(IndicadorTO indicadorTO) throws ExceptionPersistenciaBSC;
   
   public void incluirDimensao(IndicadorTO indicadorTO) throws ExceptionPersistenciaBSC;
   
   public void alterar(IndicadorTO indicadorTO) throws ExceptionPersistenciaBSC;
   
   public Integer consultarMapaPorIndicador(IndicadorTO indicadorTO) throws ExceptionPersistenciaBSC;
      
}
