<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<table border="0" height="44" cellpadding="0" cellspacing="0">
	<tr>
		<td width="510px" height="40px" style="color:#0DA007" >	
			<b><html:messages id="msg" message="true"> 
				<img align="bottom" src="<c:out value="${base}"/>/WEB/imagens/comum/atencao.gif" border="0">
				<bean:write name="msg"/>
			</html:messages></b>
		</td>
	 </tr>
</table>

