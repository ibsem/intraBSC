package br.com.intraPRO.persistencia;



import net.sf.jasperreports.engine.JasperPrint;

import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.RelatorioTO;

public interface RelatorioDAO {

	
	public abstract JasperPrint listaTarefa(RelatorioTO relatorioTO) throws ExceptionPersistenciaPRO;
	
	public abstract JasperPrint listaTarefaExecutante(RelatorioTO relatorioTO) throws ExceptionPersistenciaPRO;
	
	public abstract JasperPrint listaTarefaParticipante(RelatorioTO relatorioTO) throws ExceptionPersistenciaPRO;
	
	public abstract JasperPrint agendaTarefa(RelatorioTO relatorioTO) throws ExceptionPersistenciaPRO;
	
	public abstract JasperPrint ganttTarefa(RelatorioTO relatorioTO) throws ExceptionPersistenciaPRO;
}
