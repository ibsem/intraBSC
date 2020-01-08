<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>
<%@ taglib uri="/tags/c" prefix="c" %>
<script language = "JavaScript">
	function consultarVarios(){
		document.temaForm.action = "<c:out value="${base}"/>/tema/consultarVarios.do?op=consultarVarios";
		document.temaForm.submit();		
	}
</script>
<html:html>
	<body>
		<html:form action="/tema/consultarVarios.do">
			<table border="0" cellspacing="0" cellpadding="0" width="400px">
				<tr height="3">
					<td>&nbsp;</td>
				</tr>
				<tr>
				    <td valign = "center" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="bsc.label.pesquisartema"/></td>  
				</tr>
				
				<tr>
					<td></br><bean:message key="bsc.campo.nome"/></td>
				</tr>
				<tr>
					<td><html:text property="nomeTema" maxlength="100" size="54" style="width:400px"/></td>
				</tr>
				<tr>
				<td>&nbsp;
				</td>
				</tr>
				<tr>
					<td width="400px" align="right">	
						<button type="button" onclick="consultarVarios();" class="botaoPreto" style="vertical-align: middle">
							<img src="<c:out value="${base}"/>/WEB/imagens/comum/pesquisar.gif" border="0" style="vertical-align: text-bottom">
							<bean:message key="pro.botao.pesquisar"/>
						</button>
					</td>
				</tr>
				</table>
			<c:if test="${ not empty listaTemas}">
			<table border="0" cellspacing="0" cellpadding="0" width="400px">
				<tr height="3">
					<td colspan="2" >&nbsp;
					</td>
				</tr>
				<tr>
					<td width="5%" align="left">
						<u><bean:message key="bsc.label.codigo"/></u>
					</td>
					<td width="80%" align="left">
						<u><bean:message key="bsc.label.nome"/></u>
					</td>
				</tr>
			</table>	
			</c:if>			
			<logic:present name="listaTemas" scope="session">
				<displaytag:table width="400px" name="listaTemas" id="tema" styleClass="its" pagesize="20" requestURI="" scope="request">
					<displaytag:column style="width:5%;" title="" align="left"> 
						<a href="<c:out value="${base}"/>/tema/encaminha.do?op=consultarUm&codigo=<c:out value='${tema.idTema}'/>">
							<c:out value="${tema.idTema}"/>
						</a>
					</displaytag:column>
					<displaytag:column style="width:80%;" title="" align="left"> 
						<a href="<c:out value="${base}"/>/tema/encaminha.do?op=consultarUm&codigo=<c:out value='${tema.idTema}'/>">
							<c:out value="${tema.nomeTema}"/>
						</a>
					</displaytag:column>
				</displaytag:table>
			</logic:present>
			</html:form>
		<%@ include file="/jsp/layout/mensagem.jsp"%>
	</body>
</html:html>