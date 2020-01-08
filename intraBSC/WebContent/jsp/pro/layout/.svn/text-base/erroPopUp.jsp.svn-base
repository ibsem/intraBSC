<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %> 
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
<script language="javascript" type="text/javascript">
	function fechar(){
		window.close();
	}
	function aumentarJanela(){
		window.resizeTo(400,300);
	}
</script>

<html:html>
  <head>
    <title></title>
  </head>
	<body onload="aumentarJanela();">
	<table border="0" width="400px" height="150" cellpadding="0" cellspacing="0">
		<tr>
			<td width="510px" height="95px" style="color:#FF0000">
				<img src="<c:out value="${base}"/>/WEB/imagens/comum/erro.gif" border="0">
				<html:errors/>
			</td>
		 </tr>
		<tr>
			<td colspan="2" align="right" width="400px"><html:button property="botao" value="&nbsp;&nbsp;Fechar&nbsp;&nbsp;" onclick="fechar();" /></td>
			<td width="40px">&nbsp;</td>
		 </tr>
	</table>
 </body>
</html:html>

