<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>
<%@ taglib uri="/tags/c" prefix="c" %>
<script language = "JavaScript">
	function consultarVarios(){
		document.processoForm.action = "<c:out value="${base}"/>/processo/abrir.do?op=consultarVarios";
		document.processoForm.submit();		
	}
</script>
<html:html>
	<html:form action="/processo/manutencao.do">

		<table border="0" cellspacing="0" cellpadding="0" width="350px">
			<tr height="3">
				<td>&nbsp;</td>
			</tr>
			<tr>
			    <td  colspan="2" valign = "center" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="pro.label.pesquisarprocesso"/></td>  
			</tr>
			
			<tr>
				<td><bean:message key="bsc.campo.nome"/></td>
				<td><bean:message key="bsc.campo.ativo"/></td>
			</tr>
			<tr>
				<td><html:text property="nome" maxlength="100" size="45"/></td>
				<td>
					<html:select property="ativo" style="width:50px">
						<html:option value="1"><bean:message key="bsc.label.sim"/></html:option>
						<html:option value="2"><bean:message key="bsc.label.nao"/></html:option>
					</html:select>
				</td>
			</tr>
			<tr>
				<td colspan="2" width="350px" align="right"></br>
					&nbsp;&nbsp;
				<button type="button" onclick="consultarVarios();" class="botaoPreto">
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/pesquisar.gif" border="0" style="vertical-align: text-bottom"/>
					<bean:message key="pro.botao.pesquisar"/>
				</button>
				</td>
			</tr>
		</table></br>
		<c:if test="${ not empty listaProcesso}">
			<table border="0" cellspacing="0" cellpadding="0" width="350px">
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
		<table >
			<tr>
				<td>
					<logic:present name="listaProcesso">
						<displaytag:table width="350px" name="listaProcesso" id="processo" styleClass="its" pagesize="20" requestURI="" scope="request">
							<displaytag:column style="width:5%;" title="" align="left"> 
								<a href="<c:out value="${base}"/>/processo/abrir.do?op=consultarArvoreConfiguracao&codProcesso=<c:out value='${processo.id}'/>&nomeProcesso=<c:out value='${processo.nome}'/>">
									<c:out value="${processo.id}"/>
								</a>
							</displaytag:column>
							<displaytag:column style="width:80%;" title="" align="left"> 
								<a href="<c:out value="${base}"/>/processo/abrir.do?op=consultarArvoreConfiguracao&codProcesso=<c:out value='${processo.id}'/>&nomeProcesso=<c:out value='${processo.nome}'/>">
									<c:out value="${processo.nome}"/>
								</a>
							</displaytag:column>
						</displaytag:table>
					</logic:present>
				</td>
			</tr>
		
		</table>		
	</html:form>
	<html:javascript formName="processoForm" />
</html:html>