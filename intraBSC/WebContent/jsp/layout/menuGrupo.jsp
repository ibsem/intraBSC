<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<div name="arvore" id="itemmenu">
	<ul>
		<li><a href="<c:out value="${base}"/>/grupo/encaminhar/incluir.do?op=encaminharIncluir"><bean:message key="bsc.botao.incluir"/></a></li>
		<li><a href="<c:out value="${base}"/>/grupo/encaminhar/consultar.do?op=encaminharConsultar"><bean:message key="bsc.botao.alterar"/></a></li>							
		<li><a href="<c:out value="${base}"/>/unidade/encaminha/incluir.do?op=encaminharIncluir"><bean:message key="bsc.campo.unidade"/></a></li>
		<li><a href="<c:out value="${base}"/>/periodicidade/encaminha/incluir.do?op=encaminharIncluir" title="Periodicidade"><bean:message key="bsc.label.periodicidade"/></a></li>
		<li><a href="<c:out value="${base}"/>/tipoPerspectiva/encaminha/incluir.do?op=encaminharIncluir" title="TipoPerspectiva"><bean:message key="bsc.campo.tipoPerspectiva"/></a></li>	
	</ul>
</div>