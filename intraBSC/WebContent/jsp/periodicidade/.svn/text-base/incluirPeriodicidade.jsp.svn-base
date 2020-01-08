<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/c" prefix="c" %>

<script language = "JavaScript">
	function salvar(){
		if (validatePeriodicidadeForm(document.periodicidadeForm)){
			document.periodicidadeForm.submit();
		}
	}
	function consultar(){
		document.periodicidadeForm.action = "<c:out value="${base}"/>/periodicidade/consultar.do?op=consultarVarios";
		document.periodicidadeForm.submit();
	}
</script>

<html:html>
	<html:form action="/periodicidade/manutencao.do?op=incluir" onsubmit="return validatePeriodicidadeForm(this);">

		<table border="0" cellspacing="0" cellpadding="0">
			<tr height="3">
				<td>&nbsp;</td>
			</tr>
			<tr>
			    <td valign = "center" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="bsc.label.incluirperiodicidade"/></td>  
			</tr>
			
			<tr>
				<td></br><bean:message key="bsc.campo.nome"/></td>
			</tr>
			<tr>
				<td><html:text property="nome" maxlength="100" size="70"/></td>
			</tr>
			<tr>
				<td align="right"></br>
					<button type="button" onclick="salvar();" class="botaoPreto">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" border="0" style="vertical-align: text-bottom"/>
						<bean:message key="pro.botao.salvar"/>
					</button>
					&nbsp;&nbsp;
					<button type="button" onclick="consultar();" class="botaoPreto">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/pesquisar.gif" border="0" style="vertical-align: text-bottom"/>
						<bean:message key="pro.botao.pesquisar"/>
					</button>
				</td>
			</tr>
		</table>		
	</html:form>
	<html:javascript formName="periodicidadeForm" />
</html:html>