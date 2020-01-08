<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/c" prefix="c" %>

<html:html>
	<html:form action="/mapaEstrategico/manutencao.do?op=incluir" onsubmit="return validateMapaEstrategicoForm(this);">

		<table border="0" cellspacing="0" cellpadding="0" width="400px">
			<tr height="3">
				<td colspan="2">&nbsp;</td>
			</tr>
			<tr>
			    <td colspan="2" valign="center" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="bsc.label.incluirmapaestrategico"/></td>  
			</tr>
			
			<tr>
				<td><bean:message key="bsc.campo.nome"/></td>
				<td><bean:message key="bsc.campo.ativo"/></td>
			</tr>
			<tr>
				<td><html:text property="nome" maxlength="50" size="50"/></td>
				<td colspan="2">
					<html:select property="ativo" style="width:50px">
						<html:option value="1"><bean:message key="bsc.label.sim"/></html:option>
						<html:option value="2"><bean:message key="bsc.label.nao"/></html:option>
					</html:select>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<bean:message key="bsc.campo.responsavel"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<html:select property="idResponsavel" style="width:400px">
						<html:option value=""></html:option>
						<html:options collection="listaResponsavel" property="idUsuario" labelProperty="nome" />
					</html:select>
				</td>
			</tr>
			<tr>
				<td colspan="2"><bean:message key="bsc.campo.missao"/></td>
			</tr>
			<tr>
				<td colspan="2" widht="100%"><html:textarea property="missao" cols="72" rows="4" 
				style="width:400px"/></td>
			</tr>
			<tr>
				<td colspan="2"><bean:message key="bsc.campo.visao"/></td>
			</tr>
			<tr>
				<td colspan="2" widht="100%"><html:textarea property="visao" cols="72" rows="4"
				style="width:400px"/></td>
			</tr>
			<tr>
				<td colspan="2"><bean:message key="bsc.campo.fatorescriticos"/></td>
			</tr>
			<tr>
				<td colspan="2" widht="100%"><html:textarea property="fatoresSucesso" cols="72" rows="4" 
				style="width:400px"/></td>
			</tr>
			<tr>
				<td colspan="2" align="right"></br>
				<button type="submit" property="" class="botaoPreto" style="vertical-align: middle">
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" border="0" style="vertical-align: text-bottom">
					<bean:message key="bsc.botao.salvar"/>
				</button>
				
				</td>
			</tr>
		</table>		
	</html:form>
	<html:javascript formName="mapaEstrategicoForm" />
</html:html>