

package br.com.intraPRO.persistencia;

import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.FaseTO;

import java.util.Collection;

import net.sf.jasperreports.engine.JasperPrint;

public interface FaseDAO{
      
   public Collection consultarVarios(FaseTO faseTO) throws ExceptionPersistenciaPRO;
   
   public Collection consultarVariosProcesso(FaseTO faseTO) throws ExceptionPersistenciaPRO;
   
   public FaseTO consultarUm(FaseTO faseTO) throws ExceptionPersistenciaPRO;
   
   public void incluir(FaseTO faseTO) throws ExceptionPersistenciaPRO;
   
   public void alterar(FaseTO faseTO) throws ExceptionPersistenciaPRO;
   
   public void excluir(FaseTO faseTO) throws ExceptionPersistenciaPRO;
   
   public int consultarMax(FaseTO faseTO) throws ExceptionPersistenciaPRO;
   
   public JasperPrint faseRelatorioDetalha(FaseTO faseTO) throws ExceptionPersistenciaPRO;
   
   public Integer consultarProcessoPorFase(FaseTO faseTO) throws ExceptionPersistenciaPRO;
   
  }
