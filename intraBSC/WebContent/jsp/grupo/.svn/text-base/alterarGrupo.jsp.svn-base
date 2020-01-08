<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>
<%@ taglib uri="/tags/c" prefix="c" %>
<%@ taglib uri="/tags/fmt" prefix="fmt" %>

  <link rel="stylesheet" type="text/css" media="all" href="<c:out value="${base}"/>/WEB/calendario/css/calendar.css" title="win2k-cold-1" />
  <script type="text/javascript" src="<c:out value="${base}"/>/WEB/calendario/js/calendar.js"></script>
  <script type="text/javascript" src="<c:out value="${base}"/>/WEB/calendario/js/calendar-en.js"></script>
  <script type="text/javascript" src="<c:out value="${base}"/>/WEB/calendario/js/calendar-setup.js"></script>
  
<html:html>
	<html:form action="/grupo/alterar.do?op=alterar" onsubmit="return validateGrupoForm(this);">
		<input type="hidden" name="codigo" value="<c:out value='${grupoForm.codigo}'/>"/>
		<table border="0" cellspacing="0" cellpadding="0">
			<tr height="3">
				<td colspan="2">&nbsp;</td>
			</tr>
			<tr style="border-bottom:thin; border-bottom-style:solid;">
			    <td colspan="2" valign="center" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="titulo.grupo.alterar"/></td>  
			</tr>
			
			
			<tr>
				<td colspan="2"></br><bean:message key="bsc.campo.descricao"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="text" name="descricao" maxlength="100" size="70" value="<c:out value='${grupoForm.descricao}'/>"/></td>
			</tr>
			<tr>
				<td class="txtPreto" align="left"><bean:message key="bsc.campo.ativo"/></td>
				<td colspan="1" class="txtPreto" align="left"><bean:message key="bsc.campo.datacontrato"/></td>
			</tr>
			<tr>
				<td>
					<html:select property="ativo" style="width:100px">
						<html:option value="1"><bean:message key="bsc.label.sim"/></html:option>
						<html:option value="1"><bean:message key="bsc.label.nao"/></html:option>
					</html:select>
				</td>
				<td colspan="1"><html:text property="dataUso" styleId="f_date_c" readonly="false"
										    maxlength="10" size="10" onkeydown="formataData(this);" 
										    onblur="validarData(this,'Data');"/>
					<img src="<c:out value="${base}"/>/WEB/calendario/imagem/calendario.gif" 
						 id="f_trigger_c" style="cursor: pointer; vertical-align: bottom;" title="Selecionar a Data"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right"></br>
					<button type="submit" class="botaoPreto">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.salvar"/>
					</button>
				</td>
			</tr>
		</table>
		<%@ include file="/jsp/pro/layout/mensagem.jsp"%>
	</html:form>
	<html:javascript formName="grupoForm" />
		<script type="text/javascript">
	    Calendar.setup({
	        inputField     :    "f_date_c",     // id of the input field
			ifFormat       :    "%d/%m/%Y",
	        button         :    "f_trigger_c",  // trigger for the calendar (button ID)
	        align          :    "Tl",           // alignment (defaults to "Bl")
	        singleClick    :    true
	    });
	</script>
</html:html>