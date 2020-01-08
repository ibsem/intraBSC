<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>
<%@ taglib uri="/tags/c" prefix="c" %>
<html:html>
	<html:form action="/objetivo/manutencao.do?op=incluir" onsubmit="return validateObjetivoForm(this);">
		<table border="0" cellspacing="0" cellpadding="0">
			<tr height="3">
				<td>&nbsp;</td>
			</tr>
			<tr>
			    <td class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="bsc.label.incluirobjetivo"/></td>  
			</tr>
			<tr>
				<td colspan="2"><bean:message key="bsc.campo.nome"/></td>
			</tr>
			<tr>
				<td colspan="2"><html:text property="nome" maxlength="100" size="54" style="width:400px"/></td>
			</tr>			
			<tr>
				<td colspan="2"><bean:message key="bsc.campo.descricao"/></td>
			</tr>
			<tr>
				<td colspan="2"><html:textarea name="objetivoForm" property="descricao" cols="61" rows="5" style="width:400px"/></td>
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
				<td ><bean:message key="bsc.campo.tema"/></td>
				<td><bean:message key="bsc.campo.coluna"/></td>
			</tr>
			<tr>
				<td >
					<html:select property="idTema" style="width:330px;height:18px;">
						<html:option value=""></html:option>
						<html:options collection="listaTema" property="idTema" labelProperty="nomeTema" />
					</html:select>
				</td>
				<td><html:text property="coluna" maxlength="2" size="10" style="width:50px"/></td>
			</tr>
		</table>
		<table border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td><bean:message key="bsc.campo.perspectiva"/></td>
				<td><bean:message key="bsc.campo.ativo"/></td>
				<td><bean:message key="bsc.campo.linha"/></td>
			</tr>
			<tr>
				<td>
					<html:select property="idPerspectiva" style="width:300px;height:18px;">
						<html:option value=""></html:option>
						<html:options collection="listaPerspectiva" property="id" labelProperty="nome" />
					</html:select>
				</td>
				<td>
					<html:select property="ativo" style="width:50px">
						<html:option value="1"><bean:message key="bsc.label.sim"/></html:option>
						<html:option value="2"><bean:message key="bsc.label.nao"/></html:option>
					</html:select>
				</td>
				<td>
					<html:select property="linha" style="width:50px">
						<html:option value="-6"><bean:message key="bsc.label.menosseis"/></html:option>
					    <html:option value="-5"><bean:message key="bsc.label.menoscinco"/></html:option>
					   	<html:option value="-4"><bean:message key="bsc.label.menosquatro"/></html:option>
					    <html:option value="-3"><bean:message key="bsc.label.menostres"/></html:option>
						<html:option value="-2"><bean:message key="bsc.label.menosdois"/></html:option>
						<html:option value="-1"><bean:message key="bsc.label.menosum"/></html:option>
						<html:option value="0"><bean:message key="bsc.label.zero"/></html:option>
						<html:option value="1"><bean:message key="bsc.label.um"/></html:option>
						<html:option value="2"><bean:message key="bsc.label.dois"/></html:option>
						<html:option value="3"><bean:message key="bsc.label.tres"/></html:option>
						<html:option value="4"><bean:message key="bsc.label.quatro"/></html:option>
						<html:option value="5"><bean:message key="bsc.label.cinco"/></html:option>
						<html:option value="6"><bean:message key="bsc.label.seis"/></html:option>
					</html:select>
				</td>
			</tr>
			<tr>
				<td colspan="3" align="right" width="400px"><br />
					<button type="submit" class="botaoPreto" style="vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.salvar"/>
					</button>
				</td>
			</tr>
		</table>
	</html:form>
	<html:javascript formName="objetivoForm" />
</html:html>