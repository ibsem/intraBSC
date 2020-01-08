<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>
<%@ taglib uri="/tags/c" prefix="c" %>
<html:html>
	<html:form action="/tema/manutencao.do?op=incluir" onsubmit="return validateTemaForm(this);">
		<table border="0" cellspacing="0" cellpadding="0">
			<tr height="3">
				<td>&nbsp;</td>
			</tr>
			<tr>
			    <td valign = "center" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="bsc.label.incluirtema"/></td>  
			</tr>
			<tr>
				<td colspan="2"><bean:message key="bsc.campo.nome"/></td>
			</tr>
			<tr>
				<td colspan="2"><html:text property="nomeTema" maxlength="50" size="50" style="width:400px"/></td>
			</tr>			
			<tr>
				<td colspan="2"><bean:message key="bsc.campo.descricao"/></td>
			</tr>
			<tr>
				<td colspan="2"><html:textarea name="temaForm" property="descricao" cols="61" rows="5" style="width:400px"/></td>
			</tr>
			<tr>
				<td colspan="2"><bean:message key="bsc.campo.responsavel"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<html:select property="responsavel" style="width:400px">
						<html:option value=""></html:option>
						<html:options collection="listaResponsavel" property="idUsuario" labelProperty="nome" />
					</html:select>
				</td>
			</tr>
			<tr>
				<td align="right" colspan="2"></br>
					<button type="submit" class="botaoPreto" style="vertical-align: middle">
							<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" border="0" style="vertical-align: text-bottom">
							<bean:message key="pro.botao.salvar"/>
					</button>
				</td>
			</tr>
		</table>
	</html:form>
	<html:javascript formName="temaForm" />
</html:html>