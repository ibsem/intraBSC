<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<div name="arvore" id="itemmenu">
	<ul>
		<li><a href="<c:out value="${base}"/>/tema/encaminha.do?op=encaminharIncluir"><bean:message key="bsc.botao.incluir"/></a></li>
		<li><a href="<c:out value="${base}"/>/tema/consultarVarios.do?op=encaminharConsultar"><bean:message key="bsc.botao.alterar"/></a></li>							
	</ul>
</div>