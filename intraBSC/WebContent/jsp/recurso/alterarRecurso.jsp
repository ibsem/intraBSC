<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>
<%@ taglib uri="/tags/c" prefix="c" %>

<script language = "JavaScript">
	function consultar(){
		document.recursoForm.action = "<c:out value="${base}"/>/recurso/encaminha.do?op=encaminhaConsultarVarios&codIniciativa="+document.recursoForm.idIniciativa.value;
		document.recursoForm.submit();
	}
	function excluir(){
		document.recursoForm.action = "<c:out value="${base}"/>/recurso/manutencao.do?op=excluir&codIniciativa="+document.recursoForm.idIniciativa.value;
		document.recursoForm.submit();
	}
</script>

<html:html>
	<html:form action="/recurso/manutencao.do?op=alterar" onsubmit="return validateRecursoForm(this);">
	<html:hidden property="idIniciativa"/>
		<table border="0" cellspacing="0" cellpadding="0">
<tr height="3">
				<td>&nbsp;</td>
			</tr>
			<tr>
			    <td valign = "center" class="titulo" style="border-bottom:thin; border-bottom-style:solid;">Alterar Recurso</td>  
			</tr>
			
			<tr>
				<td colspan="2"><bean:message key="bsc.campo.nome"/></td>
			</tr>
			<tr>
				<td colspan="2"><html:text property="nome" maxlength="100" size="54"/></td>
			</tr>			
			<tr>
				<td colspan="2"><bean:message key="bsc.campo.descricao"/></td>
			</tr>
			<tr>
				<td colspan="2"><html:textarea name="recursoForm" property="descricao" cols="61" rows="5"/></td>
			</tr>
			<tr>
				<td colspan="2" align="right" width="250px"></br>
					<html:submit><bean:message key="bsc.botao.salvar"/></html:submit>
					<html:button property="" onclick="consultar();"><bean:message key="bsc.botao.consultar"/></html:button>
					<html:button property="" onclick="excluir();"><bean:message key="bsc.botao.excluir"/></html:button>
				</td>
			</tr>
		</table>
	</html:form>
	<html:javascript formName="recursoForm" />
</html:html>