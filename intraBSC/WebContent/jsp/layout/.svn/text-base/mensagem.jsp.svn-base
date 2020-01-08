<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
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
<table border="0" height="44" cellpadding="0" cellspacing="0">
	<tr>
		<td width="510px" height="50px" style="color:#0DA007;font-size: 11px;"><b>
			<html:messages id="msg" message="true"> 
			<img align="bottom" src="<c:out value="${base}"/>/WEB/imagens/comum/atencao.gif" border="0">
		
				<bean:write name="msg"/>
			</html:messages></b>
		</td>
	 </tr>
</table>

