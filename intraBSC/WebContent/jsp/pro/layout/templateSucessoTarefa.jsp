<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
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
<html:html>
	<body>	
		<form name="sucessoForm" method="post" action="<c:out value="${base}"/>/visualizar/configTarefa/arvore.do?op=consultarArvore">
			<table border="0" height="44" cellpadding="0" cellspacing="0" style="width:395px">
				<tr>
					<td width="440px" height="95px" align="center" >
					
					<b><html:messages id="msg" message="true"> 
							<bean:write name="msg"/>
						</html:messages></b>
					</td>
				</tr>
				<tr>
					</br>
					</br>
					<tr>					
						<td colspan="4" align="right"><input type="submit" value="Avançar"></td>
					</tr>
					<td width="20px">&nbsp;</td>
				 </tr>
			</table>
		</form>	
 </body>
</html:html>

