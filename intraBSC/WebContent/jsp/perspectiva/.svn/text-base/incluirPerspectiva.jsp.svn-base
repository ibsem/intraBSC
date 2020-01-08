<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>
<%@ taglib uri="/tags/c" prefix="c" %>
<html:html>
	<html:form action="/perspectiva/manutencao.do?op=incluir" onsubmit="return validatePerspectivaForm(this);">
		<table width="400px" border="0" cellspacing="0" cellpadding="0" >
			<tr height="3">
				<td>&nbsp;</td>
			</tr>
			<tr>
			    <td colspan="2" valign = "center" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="bsc.label.incluirperspectiva"/></td>  
			</tr>
			
			<tr>
				<td colspan="2"><bean:message key="bsc.campo.nome"/></td>
			</tr>
			<tr>
				<td colspan="2"><html:text property="nome" maxlength="100" size="60" style="width:400px"/></td>
			</tr>
			<tr>
				<td><bean:message key="bsc.campo.numeroOrdem"/></td>
				<td><bean:message key="bsc.campo.tipoPerspectiva"/></td>
			</tr>
			<tr>
				<td><html:text property="ordem" maxlength="3" size="10" value=""/></td>
				<td>
					<html:select property="tipoPerspectiva" style="width:316px;height:18px;">
						<html:option value=""></html:option>
						<html:options collection="listaTipoPerspectiva" property="id" labelProperty="nome" />
					</html:select>
				</td>
			</tr>
			<tr>
				<td colspan="2"><bean:message key="bsc.campo.descricao"/></td>
			</tr>
			<tr>
				<td colspan="2"><html:textarea name="perspectivaForm" property="descricao" cols="68" rows="5" style="width:400px"/></td>
		</table>
		<table width="350px" border="0" cellspacing="0" cellpadding="0">
			</tr>
				<td><bean:message key="bsc.campo.responsavel"/></td>
				<td><bean:message key="bsc.campo.ativo"/></td>
			</tr>
			<tr>
				<td>
					<html:select property="responsavel" style="width:350px">
						<html:option value=""></html:option>
						<html:options collection="listaResponsavel" property="idUsuario" labelProperty="nome" />
					</html:select>
				</td>
				<td>
					<html:select property="ativo" style="width:50px">
						<html:option value="1"><bean:message key="bsc.label.sim"/></html:option>
						<html:option value="2"><bean:message key="bsc.label.nao"/></html:option>
					</html:select>
				</td>
			</tr>
			<tr>
				<td align="right" colspan="2"></br>
					<button type="submit" property="" class="botaoPreto" style="vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="bsc.botao.salvar"/>
					</button>
				</td>
			</tr>
		</table>
	</html:form>
	<html:javascript formName="perspectivaForm" />
</html:html>