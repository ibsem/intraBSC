<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/c" prefix="c" %>

<script language = "JavaScript">
	function salvar(){
		if (validateTipoPerspectivaForm(document.tipoPerspectivaForm)){
			document.tipoPerspectivaForm.submit();
		}
	}
	function consultar(){
		document.tipoPerspectivaForm.action = "<c:out value="${base}"/>/tipoPerspectiva/consultar.do?op=consultarVarios";
		document.tipoPerspectivaForm.submit();
	}
</script>

<html:html>
	<html:form action="/tipoPerspectiva/manutencao.do?op=incluir" onsubmit="return validateTipoPerspectivaForm(this);">

		<table border="0" cellspacing="0" cellpadding="0">
			<tr height="3">
				<td>&nbsp;</td>
			</tr>
			<tr>
			    <td valign = "center" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="bsc.label.incluirtipoperspectiva"/></td>  
			</tr>
			
			<tr>
				<td></br><bean:message key="bsc.campo.nome"/></td>
			</tr>
			<tr>
				<td><html:text property="nome" maxlength="100" size="58"/></td>
			</tr>
			<tr>
				<td></br><bean:message key="bsc.campo.descricao"/></td>
			</tr>
			<tr>
				<td><html:textarea name="tipoPerspectivaForm" property="descricao" cols="65" rows="5"/></td>
			</tr>
			<tr>
				<td align="right"></br>
					<button type="button" onclick="salvar();" class="botaoPreto" style="vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.salvar"/>
					</button>

				</td>
			</tr>
		</table>		
	</html:form>
	<html:javascript formName="tipoPerspectivaForm" />
</html:html>