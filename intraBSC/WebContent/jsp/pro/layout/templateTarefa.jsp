<html xmlns="http://www.w3.org/2006/xhtml">
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>
<%@ taglib uri="/tags/c" prefix="c" %>
<%@ include file="/jsp/layout/definicaoMenuPerfil.jsp"%>
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
<html>
	<head>
	    <title><tiles:getAsString name="intrapro"/></title>
		<script type="text/javascript" src="<c:out value="${base}"/>/WEB/js/funcoes.js"></script>
		<script type="text/javascript" src="<c:out value="${base}"/>/WEB/js/dtree.js"></script>
		<link rel="stylesheet" href="<c:out value="${base}"/>/WEB/css/intraBSC.css" type="text/css">
		<link rel="stylesheet" href="<c:out value="${base}"/>/WEB/css/displaytag.css" type="text/css">
	</head>
	<body>
	<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
		<tr colspan="2">
  			<td width="100%" border="0" align="center">
  				<tiles:insert attribute="cabecalho"/>
  			</td>
  		</tr>
	</table>
	<!-- Corpo -->
	<div align="center"  style="position:relative;top:-50px;width:100%;height:450px;">
	<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="2" width="100%" valign="top"><tiles:insert attribute="menu"/></td>
		</tr>
		<tr>
			<td valign="top">
			<div id="tarefaArvoreLista" style="position:relative;top:8px;left:8px;width:400px;vertical-align: top">
				<table border="0" valign="top" ><tr><td valign="top"><tiles:insert attribute="tarefaArvore"/></td></tr></table>
			</div>
			</td>
			<td valign="top">	
			<div id="conteudo" style="position:relative;top:10px;left:20px;overflow:none;width:500px;border-style:none; vertical-align: top;">
			<div id="sucesso" style="position:relative;top:0px;left:20px;overflow:auto;width:290px;">
			<table><tr><td style="color:#0DA007"><b><html:messages id="msg" message="true"> 
			<img align="bottom" src="<c:out value="${base}"/>/WEB/imagens/comum/atencao.gif" border="0">
			<bean:write name="msg"/>
			</html:messages></b></td></tr></table>
			</div>
					<table border="0"><tr><td><tiles:insert attribute="corpo"/></td></tr></table>
			</div>
			</td>
		</tr>
	</table>
	</div>  
		<div id="explodeitem" style="position:relative;top:0px;left:<c:out value="${leftMenuConfigTarefa}"/>;width:117px;height:47px">
			<%@ include file="/jsp/pro/layout/menuConfigTarefa.jsp"%>
		</div>
		<div id="explodeacao" style="position:relative;top:0px;left:275px;width:116px;height:110px">
			<%@ include file="/jsp/pro/layout/menuTarefas.jsp"%>
		</div>
		<div id="explodeconfig" style="position:relative;top:0px;left:<c:out value="${leftMenuCongifMapa}"/>;width:118px;height:109px">
			<%@ include file="/jsp/layout/menuMapaConfiguracao.jsp"%>
		</div>
		<div id="explodegrupo" style="position:absolute;top:125px;left:10px;width:156px;height:425px">
			<%@ include file="/jsp/layout/menuAdministracao.jsp"%>
		</div>
		<div id="explodeusuario" style="position:relative;top:0px;left:<c:out value="${leftMenuCongifUsuario}"/>;width:<c:out value="${widthMenuCongifUsuario}"/>;height:<c:out value="${heightMenuCongifUsuario}"/>">
			<%@ include file="/jsp/layout/menuUsuario.jsp"%>
		</div>
   </body>
</html>