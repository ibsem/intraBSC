

/*
 * Created on 15/02/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package br.com.intraPRO.persistencia;

import java.util.Collection;

import net.sf.jasperreports.engine.JasperPrint;

import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.ProcessoTO;



/**
 * @author Tiago
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface ProcessoDAO{
   
   public abstract Collection consultarVarios(ProcessoTO processoTO) throws ExceptionPersistenciaPRO;
   
   public abstract Collection consultarProcessoUsuario(ProcessoTO processoTO) throws ExceptionPersistenciaPRO;
    
   public abstract ProcessoTO consultarUm(ProcessoTO processoTO) throws ExceptionPersistenciaPRO;
   
   public abstract void incluir(ProcessoTO processoTO) throws ExceptionPersistenciaPRO;
   
   public void alterar(ProcessoTO processoTO) throws ExceptionPersistenciaPRO;   
   
   public void excluir(ProcessoTO processoTO) throws ExceptionPersistenciaPRO;
   
   public int consultarMax(ProcessoTO processoTO) throws ExceptionPersistenciaPRO;
   
   public JasperPrint processoRelatorioDetalha(ProcessoTO processoTO) throws ExceptionPersistenciaPRO;
   
   public Collection consultarArvoreConfiguracao(ProcessoTO processoTO) throws ExceptionPersistenciaPRO;

   public ProcessoTO contarFases(ProcessoTO processoTO) throws ExceptionPersistenciaPRO;

   public Collection contarAtividades(ProcessoTO processoTO) throws ExceptionPersistenciaPRO;
}

