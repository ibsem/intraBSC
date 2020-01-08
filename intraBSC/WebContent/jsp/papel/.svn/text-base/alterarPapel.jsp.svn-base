<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>
<%@ taglib uri="/tags/c" prefix="c" %>
<html:html>
	<html:form action="/papel/manutencao.do?op=alterar" onsubmit="return validatePapelForm(this);">
		<input type="hidden" name="id" value="<c:out value='${alterarPapel.id}'/>"/>
		<table border="0" cellspacing="0" cellpadding="0">
			<tr height="3">
				<td>&nbsp;</td>
			</tr>
			<tr>
			    <td valign = "center" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="bsc.label.alterarpapel"/></td>  
			</tr>
						
			<tr>
				<td></br><bean:message key="bsc.campo.nome"/></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" maxlength="100" size="70" value="<c:out value='${alterarPapel.nome}'/>"/></td>
			</tr>
			<tr>
				<td align="right"></br>
					<button type="submit" class="botaoPreto">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.salvar"/>
					</button>
				</td>
			</tr>
		</table>
	</html:form>
	<html:javascript formName="papelForm" />
</html:html>