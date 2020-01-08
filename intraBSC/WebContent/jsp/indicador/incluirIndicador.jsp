<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>
<%@ taglib uri="/tags/c" prefix="c" %>
<html:html>
	<html:form action="/indicador/manutencao.do?op=incluir" onsubmit="return validateIndicadorForm(this);">
		<table border="0" cellspacing="0" cellpadding="0">
			<tr height="3">
				<td>&nbsp;</td>
			</tr>
			<tr>
			    <td colspan="3" valign="center" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="bsc.label.incluirindicador"/></td>  
			</tr>
			<tr>
				<td colspan="3"><bean:message key="bsc.campo.nome"/></td>
			</tr>
			<tr>
				<td colspan="3"><html:text property="nome" maxlength="100" size="60" style="width:400px"/></td>
			</tr>			
			<tr>
				<td colspan="3"><bean:message key="bsc.campo.descricao"/></td>
			</tr>
			<tr>
				<td colspan="3"><html:textarea name="indicadorForm" property="descricao" cols="67" rows="5" style="width:400px"/></td>
			</tr>
			<tr>
				<td colspan="3"><bean:message key="bsc.campo.responsavel"/></td>
			</tr>
			<tr>
				<td colspan="3">
					<html:select property="idResponsavel" style="width:400px">
						<html:option value=""></html:option>
						<html:options collection="listaResponsavel" property="idUsuario" labelProperty="nome" />
					</html:select>
				</td>
			</tr>
			<tr>
				<td colspan="3"><bean:message key="bsc.campo.objetivo"/></td>
			</tr>
			<tr>
				<td colspan="3">
					<html:select property="idObjetivo" style="width:400px">
						<html:option value=""></html:option>
						<html:options collection="listaObjetivo" property="id" labelProperty="nome" />
					</html:select>
				</td>
			</tr>
			<tr>
				<td><bean:message key="bsc.campo.unidade"/></td>
				<td><bean:message key="bsc.campo.periodicidade"/></td>
				<td><bean:message key="bsc.campo.ativo"/></td>
			</tr>
			<tr>
				<td>
					<html:select property="unidade" style="width:175px">
						<html:option value=""></html:option>
						<html:options collection="listaUnidade" property="id" labelProperty="nome" />
					</html:select>
				</td>
				<td>
					<html:select property="periodicidade" style="width:175">
						<html:option value=""></html:option>
						<html:options collection="listaPeriodicidade" property="id" labelProperty="nome" />
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
				<td align="right" width="400px" colspan="3"></br>
					<button type="submit" class="botaoPreto" style="vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.salvar"/>
					</button>
				</td>
			</tr>
		</table>
	</html:form>
	<html:javascript formName="indicadorForm" />
</html:html>