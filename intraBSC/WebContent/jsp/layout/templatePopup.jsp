<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>
<%@ taglib uri="/estrutura/tmpl" prefix="tmpl" %>
<%@ taglib uri="/tags/c" prefix="c" %>
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
<HTML>
	<HEAD>
	<style>
		TABLE {FONT-SIZE: 12px; COLOR: #000000; FONT-FAMILY: Arial, Helvetica, sans-serif}
		.dtree{FONT-SIZE:11px; COLOR: #070d5b; FONT-FAMILY: Arial, Helvetica, sans-serif;left:50%;white-space: nowrap;border:thin}
		.dtree img{border: 0px;vertical-align: middle;}
		.dtree a{FONT-SIZE: 12px; COLOR: #000000; FONT-FAMILY: Arial, Helvetica, sans-serif; FONT-WEIGHT: normal; text-decoration: none;}
		.dtree a.node, .dtree a.nodeSel{white-space: nowrap;padding: 1px 2px 1px 2px;}
		.dtree a.node:hover, .dtree a.nodeSel:hover{color: #333;text-decoration: none;}
		.dtree a.nodeSel{background-color: #c0d2ec;}
		.dtree .clip{overflow: hidden;}
		.linkunderline {FONT-SIZE: 12px; COLOR: #000000; FONT-FAMILY: Arial, Helvetica, sans-serif; FONT-WEIGHT: normal; text-decoration: underline;}
	</style>
	    <title><tiles:getAsString name="intrabsc"/></title>
	    
		
		<link rel="stylesheet" href="<c:out value="${base}"/>/WEB/css/intraBSC.css" type="text/css">
		<script type="text/javascript" src="<c:out value="${base}"/>/WEB/js/funcoes.js"></script>
		<script type="text/javascript" src="<c:out value="${base}"/>/WEB/js/dtree.js"></script>
		
	</HEAD>
    
	<table border="0" style="position:absolute;top:0px;left:0px;" cellpadding="0" border="1" width="100%" height="100%" cellspacing="0" bgcolor="#E6F0FD">
		<tr valign="top">
			<td valign="top">
				<table border="0" bgcolor="#E6F0FD" width="100%" valign="top" cellspacing="0" cellpadding="0">
					<tr>
						<td width="18">&nbsp;</td>					
						<td class="txtAzulEscuro">
							 <tiles:getAsString name="tituloPagina"/>
						</td>	
					</tr>
					<tr>
						<td width="18">&nbsp;</td>
						<td align="left" valign="top" height="100%"><div id="corpoImpressao"><tiles:insert attribute="corpo"/></div></td>						
					</tr>
		   		</table>
		  	</td>
		 </tr>
	</table>
</HTML>