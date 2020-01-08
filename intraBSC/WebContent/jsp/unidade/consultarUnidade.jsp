<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>
<%@ taglib uri="/tags/c" prefix="c" %>
<script language = "JavaScript">
	function consultarVarios(){
		document.unidadeForm.action = "<c:out value="${base}"/>/unidade/consultar.do?op=consultarVarios";
		document.unidadeForm.submit();
	}
</script>
<html:html>
	<html:form action="/unidade/consultar.do">

		<table border="0" cellspacing="0" cellpadding="0">
			<tr height="3">
				<td>&nbsp;</td>
			</tr>
			<tr>
			    <td valign = "center" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="bsc.label.pesquisarunidade"/></td>  
			</tr>
			
			<tr>
				<td></br><bean:message key="bsc.campo.nome"/></td>
			</tr>
			<tr>
				<td><html:text property="nome" maxlength="100" size="70"/></td>
			</tr>
			<tr>
				<td align="right"></br>
					&nbsp;&nbsp;
					<button type="button"  onclick="consultarVarios();" class="botaoPreto">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/pesquisar.gif" border="0" style="vertical-align: text-bottom"/>
						<bean:message key="pro.botao.pesquisar"/>
					</button>
				</td>
			</tr>
		</table></br>
		<table border="0" cellspacing="0" cellpadding="0">
		<logic:notEmpty name="listaUnidade">
			<tr height="4">
					<td colspan="2" >&nbsp;
					</td>
				</tr>
				<tr>
					<td width="50px" align="left">
						<u><bean:message key="bsc.label.codigo"/></u>
					</td>
					<td width="350px" align="left">
						<u><bean:message key="bsc.label.nome"/></u>
					</td>
				</tr>
			</logic:notEmpty>
		
			<tr>
				<td colspan="2">
					<displaytag:table width="400px" name="listaUnidade" id="unidade" styleClass="its" pagesize="20" requestURI="" scope="request">
						<displaytag:column style="width:50px;" title="" align="left"> 
							<a href="<c:out value="${base}"/>/unidade/consultar.do?op=consultarUm&id=<c:out value='${unidade.id}'/>">
								<c:out value="${unidade.id}"/>
							</a>
						</displaytag:column>
						<displaytag:column style="width:350px;" title="" align="left"> 
							<a href="<c:out value="${base}"/>/unidade/consultar.do?op=consultarUm&id=<c:out value='${unidade.id}'/>">
								<c:out value="${unidade.nome}"/>
							</a>
						</displaytag:column>
					</displaytag:table>
				</td>
			</tr>
		</table>		
	</html:form>
</html:html>