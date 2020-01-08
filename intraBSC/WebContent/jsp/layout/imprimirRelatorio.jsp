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
<script language="JavaScript">
	function imprimir(){
		window.location="<c:out value="${base}"/>/imprimirRelatorio.do?op=imprimirMapa";
	}
</script>

	<form name="imprimirForm">
		<table width="" border="0"  style="" cellpadding="0" cellspacing="0">
			<tr>
			 	<td align="left" valign="middle">
					<button style="width:32px; height: 32px; padding: 0px" type="button" onclick="imprimir();" class="botaoPreto" style="  vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/pdf.jpg" border="0" style="vertical-align: middle">
					</button>
				
				</td>	
			</tr>
		</table>
	</form>
