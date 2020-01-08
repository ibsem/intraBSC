<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/estrutura/tmpl" prefix="tmpl" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>
<%@ taglib uri="/tags/c" prefix="c" %>

<HTML>
	<HEAD>
	    <title><tiles:getAsString name="intrapro"/></title>
		<link rel="stylesheet" href="<c:out value="${base}"/>/WEB/css/intraBSC.css" type="text/css">
		<script type="text/javascript" src="<c:out value="${base}"/>/WEB/imagens/js/funcoes.js"></script>
		<script type="text/javascript" src="<c:out value="${base}"/>/WEB/imagens/js/dtree.js"></script>
		<link rel="stylesheet" href="<c:out value="${base}"/>/WEB/css/displaytag.css" type="text/css">
	</HEAD>
	<table border="0" style="position:absolute;top:0px;left:0px;" cellpadding="0" border="0" width="100%" height="300" cellspacing="0">
		<tr valign="top">
			<td valign="top">
				<table border="0" width="100%" valign="top" cellspacing="0" cellpadding="0">
					<tr>
						<td width="18">&nbsp;</td>
						<td align="left" valign="top" height="100%"><div id="corpoImpressao"><tiles:insert attribute="corpo"/></div></td>						
					</tr>
		   		</table>
		  	</td>
		 </tr>
	</table>
</HTML>