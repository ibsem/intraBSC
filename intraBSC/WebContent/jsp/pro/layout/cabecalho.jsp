<%@ taglib uri="/tags/c" prefix="c"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<table  cellpadding="0" background="<c:out value="${base}"/>/WEB/imagens/comum/testeiradireitaCesusc.jpg" border="0" style="position: relative;" cellspacing="0" width="100%" align="center" >
	<tr>
		<td width="797px" cellspacing="0"><img width="797" height="104px" align="left"  src="<c:out value="${base}"/>/WEB/imagens/comum/testeiraCesusc.jpg" border="0">	</td>
	</tr>
</table>
  <!-- Corpo style="position:absolute;top:80px;left:0px;width:800px;" -->
  
<div id="cabecalho" align="center" style="position:relative;top:-30px;" >
	<table cellpadding="0" border="0" cellspacing="0" width="100%">
		<tr>
			<td align="right" width="100%">
			<c:if test="${!empty usuarioBSC.nome}">
				<b><bean:message key="bsc.label.bemvindo"/>:&nbsp;&nbsp;<c:out value="${usuarioBSC.nome}"/>&nbsp;&nbsp;</b>
			</c:if>
			</td>
		</tr>
	</table>
</div>