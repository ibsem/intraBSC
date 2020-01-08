<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/c" prefix="c" %>
<c:if test="${empty applicationScope.base}">
	<c:choose>
		<c:when test="${pageContext.request.contextPath eq '/'}">
			<c:set var="base" value="" scope="application" />
		</c:when>
		<c:otherwise>
			<c:set var="base" value="${pageContext.request.contextPath}" scope="application" />
		</c:otherwise>
	</c:choose>
</c:if>
<table border="0" height="0" cellpadding="0" cellspacing="0" align="center">
	<tr>
		<td width="" height="0px" style="color:#FF0000;font-size: 11px;vertical-align: middle;">
			<logic:present name="org.apache.struts.action.ERROR">
				<img src="<c:out value="${base}"/>/WEB/imagens/comum/erro.gif" border="0">
			</logic:present>
			<html:errors/>
		</td>
		<td width="" align="center">
			<button type="button" onclick="javascript:history.back();" class="botaoPreto" style="vertical-align: middle;width:32px; height: 32px;padding: 2px;">
				<img align="bottom" src="<c:out value="${base}"/>/WEB/imagens/comum/voltar.gif" border="0" align="middle" style="vertical-align: middle">
				
			</button>
		</td>
	 </tr>
</table>

