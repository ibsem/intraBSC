

package br.com.intraBSC.persistencia;

import br.com.intraBSC.excecoes.ExceptionPersistenciaBSC;
import br.com.intraBSC.modelo.PerspectivaTO;

import java.util.Collection;

import net.sf.jasperreports.engine.JasperPrint;

public interface PerspectivaDAO{
      
   public Collection consultarVarios(PerspectivaTO perspectivaTO) throws ExceptionPersistenciaBSC;
   
   public Collection consultarVariosMapa(PerspectivaTO perspectivaTO) throws ExceptionPersistenciaBSC;
   
   public PerspectivaTO consultarUm(PerspectivaTO perspectivaTO) throws ExceptionPersistenciaBSC;
   
   public void incluir(PerspectivaTO perspectivaTO) throws ExceptionPersistenciaBSC;
   
   public void alterar(PerspectivaTO perspectivaTO) throws ExceptionPersistenciaBSC;
   
   public void excluir(PerspectivaTO perspectivaTO) throws ExceptionPersistenciaBSC;
   
   public int consultarMax(PerspectivaTO perspectivaTO) throws ExceptionPersistenciaBSC;
   
   public JasperPrint perspectivaRelatorioDetalha(PerspectivaTO perspectivaTO) throws ExceptionPersistenciaBSC;
   
   public Integer consultarMapaPorPerspectiva(PerspectivaTO perspectivaTO) throws ExceptionPersistenciaBSC;
   
  }
