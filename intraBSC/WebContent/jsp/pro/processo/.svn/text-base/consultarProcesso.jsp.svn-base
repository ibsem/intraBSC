<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>
<%@ taglib uri="/tags/c" prefix="c" %>
<script language = "JavaScript">
	function consultarVarios(){
		if (validateMapaForm(document.processoForm)){
			document.processoForm.action = "<c:out value="${base}"/>/processo/manutencao.do?op=consultarVarios";
			document.processoForm.submit();
		}else{
			return false;
		}
	}
</script>
<html:html>
	<html:form action="/processo/manutencao.do" onsubmit="return validateProcessoForm(this);">

		<table border="0" cellspacing="0" cellpadding="0">
			<tr height="3">
				<td>&nbsp;</td>
			</tr>
			<tr>
			    <td valign = "center" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="pro.label.alterarprocesso"/></td>  
			</tr>
			
			<tr>
				<td></br><bean:message key="bsc.campo.nome"/></td>
			</tr>
			<tr>
				<td><html:text property="nome" maxlength="100" size="70"/></td>
			</tr>
			<tr>
				<td align="right"></br>
					&nbsp;&nbsp;<html:button property="" onclick="consultarVarios();"><bean:message key="bsc.botao.consultar"/></html:button>
				</td>
			</tr>
		</table></br>
		<c:if test="${ not empty listaProcesso}">
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
		<table>
			<tr>
				<td>
					<displaytag:table width="450px" name="listaProcesso" id="processo" styleClass="its" pagesize="20" requestURI="" scope="request">
						<displaytag:column style="width:5%;" title="" align="left"> 
							<a href="<c:out value="${base}"/>/processo/consultar.do?op=consultarUm&id=<c:out value='${processo.id}'/>">
								<c:out value="${processo.id}"/>
							</a>
						</displaytag:column>
						<displaytag:column style="width:80%;" title="" align="left"> 
							<a href="<c:out value="${base}"/>/processo/consultar.do?op=consultarUm&id=<c:out value='${processo.id}'/>">
								<c:out value="${processo.nome}"/>
							</a>
						</displaytag:column>
					</displaytag:table>
				</td>
			</tr>
		</table>
	</html:form>
	<html:javascript formName="processoForm" />
</html:html>