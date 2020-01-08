

package br.com.intraPRO.persistencia;

import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.AtividadeTO;

import java.util.Collection;

import net.sf.jasperreports.engine.JasperPrint;

/**
 * @author Tiago Trindade Stangarlin
 */
public interface AtividadeDAO{
         
   public Collection consultarVarios(AtividadeTO atividadeTO) throws ExceptionPersistenciaPRO;
   
   public AtividadeTO consultarUm(AtividadeTO atividadeTO) throws ExceptionPersistenciaPRO;
   
   public int consultarMax(AtividadeTO atividadeTO) throws ExceptionPersistenciaPRO;
   
   public void incluir(AtividadeTO atividadeTO) throws ExceptionPersistenciaPRO;
   
   public void alterar(AtividadeTO atividadeTO) throws ExceptionPersistenciaPRO;
   
   public JasperPrint atividadeRelatorioDetalha(AtividadeTO atividadeTO) throws ExceptionPersistenciaPRO;
   
   public Collection consultarAtividadeProcesso(AtividadeTO atividadeTO) throws ExceptionPersistenciaPRO;
   
   public Integer consultarProcessoPorAtividade(AtividadeTO atividadeTO) throws ExceptionPersistenciaPRO;

   public Collection consultarAtividadesProcessoGrafico(AtividadeTO atividadeTO) throws ExceptionPersistenciaPRO;
   
}
