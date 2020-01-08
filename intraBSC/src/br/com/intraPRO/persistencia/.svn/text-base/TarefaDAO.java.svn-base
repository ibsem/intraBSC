
package br.com.intraPRO.persistencia;

import java.text.ParseException;
import java.util.Collection;

import net.sf.jasperreports.engine.JasperPrint;

import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.TarefaTO;
import br.com.intraPRO.modelo.ParticipanteTO;

/**
 * interface que possui as assinaturas dos metodos de Tarefa.
 */
public interface TarefaDAO {

	public abstract void incluir(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO;

	public abstract void alterar(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO, ParseException;
	
	public abstract void excluirTarefaIndicador(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO, ParseException;
	
	public abstract void excluirTarefaObjetivo(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO, ParseException;
	
	public abstract void excluirTarefaPerspectiva(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO, ParseException;
	
	public abstract void excluirTarefaMapa(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO, ParseException;

	public abstract void excluirTarefaAtividade(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO, ParseException;
	
	public abstract void excluirTarefaFase(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO, ParseException;
	
	public abstract void excluirTarefaProcesso(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO, ParseException;
		
	public abstract Collection consultarVarios(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO, ParseException;
	
	public abstract Collection consultarTarefaFerramentaConfiguracao(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO, ParseException;

	public abstract TarefaTO consultarUm(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO, ParseException;

	public abstract int consultarMax(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO;

	public abstract Collection visualizar(TarefaTO tarefaTO, ParticipanteTO participanteTO) throws ExceptionPersistenciaPRO, ParseException;

	public abstract Collection consultarTarefa(TarefaTO tarefaTO, ParticipanteTO participanteTO) throws ExceptionPersistenciaPRO;
	
	public abstract void alterarDataAtualizacao(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO;
	
	public abstract Collection consultarArvore(TarefaTO tarefaTO, ParticipanteTO participanteTO) throws ExceptionPersistenciaPRO, ParseException;
	
	public JasperPrint relatorioGrupoTarefa(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO;
	
	public JasperPrint relatorioGMesTarefas(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO;
	
	public JasperPrint imprimirAgenda(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO;
	
	public JasperPrint imprimirTarefa(TarefaTO tarefaTO) throws ExceptionPersistenciaPRO;
}
