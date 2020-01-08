<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>
<%@ taglib uri="/tags/c" prefix="c" %>
<script language = "JavaScript">
	function consultarVarios(){
		if (document.tipoPerspectivaForm.nome.value != ""){
			document.tipoPerspectivaForm.action = "<c:out value="${base}"/>/tipoPerspectiva/consultar.do?op=consultarVarios";
			document.tipoPerspectivaForm.submit();
		}else{
			alert("Campo Nome Obrigatorio");
		}
	}
</script>
<html:html>
	<html:form action="/tipoPerspectiva/manutencao.do" onsubmit="return validateTipoPerspectivaForm(this);">

		<table width="400px" border="0" cellspacing="0" cellpadding="0">
			<tr height="3">
				<td>&nbsp;</td>
			</tr>
			<tr>
			    <td valign = "center" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="bsc.label.pesquisartipoperspectiva"/></td>  
			</tr>
						
			<tr>
				<td></br><bean:message key="bsc.campo.nome"/></td>
			</tr>
			<tr>
				<td><html:text property="nome" maxlength="100" size="70"/></td>
			</tr>
			<tr>
				<td align="right"></br>
					<html:button  property="" onclick="consultarVarios();">
					
					<bean:message key="pro.botao.pesquisar"/>
					</html:button>
				</td>
			</tr>
		</table></br>
		<table width="400px">
		<logic:notEmpty name="listaTipoPerspectiva">
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
		<table width="400px">
			<tr>
				<td colspan="2">
					<displaytag:table width="400px" name="listaTipoPerspectiva" id="tipoPerspectiva" styleClass="its" pagesize="20" requestURI="" scope="request">
						<displaytag:column style="width:15%;" title="" align="center"> 
							<a href="<c:out value="${base}"/>/tipoPerspectiva/consultar.do?op=consultarUm&id=<c:out value='${tipoPerspectiva.id}'/>">
								<c:out value="${tipoPerspectiva.id}"/>
							</a>
						</displaytag:column>
						<displaytag:column style="width:85%;" title="" align="left"> 
							<a href="<c:out value="${base}"/>/tipoPerspectiva/consultar.do?op=consultarUm&id=<c:out value='${tipoPerspectiva.id}'/>">
								<c:out value="${tipoPerspectiva.nome}"/>
							</a>
						</displaytag:column>
					</displaytag:table>
				</td>
			</tr>
		</table>		
	</html:form>
	<html:javascript formName="tipoPerspectivaForm" />
</html:html>