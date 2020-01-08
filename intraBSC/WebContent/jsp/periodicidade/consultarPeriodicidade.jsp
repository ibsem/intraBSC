<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>
<%@ taglib uri="/tags/c" prefix="c" %>
<script language = "JavaScript">
	function consultarVarios(){
		document.periodicidadeForm.action = "<c:out value="${base}"/>/periodicidade/consultar.do?op=consultarVarios";
		document.periodicidadeForm.submit();		
	}
</script>
<html:html>
	<html:form action="/periodicidade/consultar.do">

		<table border="0" cellspacing="0" cellpadding="0" width="250px">
			<tr height="3">
				<td>&nbsp;</td>
			</tr>
			<tr>
			    <td valign = "center" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="bsc.label.pesquisarperiodicidade"/></td>  
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
					<button type="submit" onclick="consultarVarios();" class="botaoPreto">
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/pesquisar.gif" border="0" style="vertical-align: text-bottom"/>
					<bean:message key="pro.botao.pesquisar"/>
					</button>				
				</td>
			</tr>
		</table></br>
		<table width="250px">
			<logic:notEmpty name="listaPeriodicidade">
			<tr height="4">
					<td colspan="2" >&nbsp;
					</td>
				</tr>
				<tr>
					<td width="15%" align="center">
						<u><bean:message key="bsc.label.codigo"/></u>
					</td>
					<td width="85%" align="left">
						<u><bean:message key="bsc.label.nome"/></u>
					</td>
				</tr>
			</logic:notEmpty>
			</table>
			<table width="250px">
			<tr>
				<td colspan="2">
					<displaytag:table width="250px" name="listaPeriodicidade" id="periodicidade" styleClass="its" pagesize="20" requestURI="" scope="request">
						<displaytag:column style="width:15%;" title="" align="center"> 
							<a href="<c:out value="${base}"/>/periodicidade/consultar.do?op=consultarUm&id=<c:out value='${periodicidade.id}'/>">
								<c:out value="${periodicidade.id}"/>
							</a>
						</displaytag:column>
						<displaytag:column style="width:85%;" title="" align="left"> 
							<a href="<c:out value="${base}"/>/periodicidade/consultar.do?op=consultarUm&id=<c:out value='${periodicidade.id}'/>">
								<c:out value="${periodicidade.nome}"/>
							</a>
						</displaytag:column>
					</displaytag:table>
				</td>
			</tr>
		</table>		
	</html:form>
	<html:javascript formName="periodicidadeForm" />
</html:html>