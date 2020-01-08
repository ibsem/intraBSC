<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<div name="arvore" id="itemmenu">
	<ul>
		<c:if test="${(usuarioBSC.perfil eq 'administrador')}">
			<li><a href="<c:out value="${base}"/>/usuario/encaminhar.do?op=encaminharIncluir"><bean:message key="bsc.botao.incluir"/></a></li>
		</c:if>
		<c:if test="${(usuarioBSC.perfil ne 'administrador')}">
			<li><a href="<c:out value="${base}"/>/usuario/alterarSenha.do?op=encaminharAlterarCadastro"><bean:message key="bsc.botao.alterar"/></a></li>
		</c:if>
	</ul>
</div>