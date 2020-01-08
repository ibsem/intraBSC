<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>
<%@ taglib uri="/tags/c" prefix="c" %>

<HTML>
	<HEAD>
		<link rel="stylesheet" href="<c:out value="${base}"/>/WEB/css/IntraBSC.css" type="text/css">
	</HEAD>
	<table border="0" style="position:absolute;top:0px;left:0px;"  width="400" height="300" cellpadding="0" cellspacing="0" bgcolor="#E6F0FD">
		<tr>
			<td>
         		<table border="0" bgcolor="#E6F0FD" height="294" width="100%" cellspacing="0" cellpadding="0">
					<tr>						
						<td align="left" valign="top" height="280">
							<div id="corpoImpressao">
								<tiles:insert attribute="corpo"/>
							</div>
						</td>						
					</tr>
		   		</table>
		  	</td>
		 </tr>
	</table>
	</BODY>
</HTML>