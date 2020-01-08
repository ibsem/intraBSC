<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<div name="arvore" id="itemmenu">
	<ul>
		<li><a href="<c:out value="${base}"/>/tarefa/encaminhar/consultar.do?op=encaminharConsultar"><bean:message key="pro.botao.pesquisar"/></a></li>
		<li><a href="<c:out value="${base}"/>/tarefa/encaminhar/incluir.do?op=encaminharInclusao"><bean:message key="pro.botao.incluir"/></a></li>
		<li><a href="<c:out value="${base}"/>/tarefa/relatorioGrupoTarefa.do?op=relatorioGrupoTarefa"><bean:message key="bsc.campo.relatoriogrupo"/></a></li>
		<li><a href="<c:out value="${base}"/>/tarefa/relatorioGrupoTarefa.do?op=relatorioGMesTarefas"><bean:message key="pro.label.tarefasmes"/></a></li>
	</ul>
</div>

