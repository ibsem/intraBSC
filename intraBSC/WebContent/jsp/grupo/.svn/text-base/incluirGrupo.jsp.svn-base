<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/c" prefix="c" %>
<%@ taglib uri="/tags/fmt" prefix="fmt" %>
<script language = "JavaScript">
	function salvar(){
		if (validateGrupoForm(document.grupoForm)){
			document.grupoForm.submit();
		}else{
			return false;
		}
	}
</script>

  <link rel="stylesheet" type="text/css" media="all" href="<c:out value="${base}"/>/WEB/calendario/css/calendar.css" title="win2k-cold-1" />
  <script type="text/javascript" src="<c:out value="${base}"/>/WEB/calendario/js/calendar.js"></script>
  <script type="text/javascript" src="<c:out value="${base}"/>/WEB/calendario/js/calendar-en.js"></script>
  <script type="text/javascript" src="<c:out value="${base}"/>/WEB/calendario/js/calendar-setup.js"></script>
  
<html:html>
	<html:form action="/grupo/incluir.do?op=incluir" onsubmit="return validateGrupoForm(this);">
		<table border="0" cellspacing="0" cellpadding="0">
			<tr height="3">
				<td colspan="2">&nbsp;</td>
			</tr>
			<tr>
			    <td colspan="2" valign = "center" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="titulo.grupo.incluir"/></td>  
			</tr>
			<tr>
				<td colspan="2"></br><bean:message key="bsc.campo.descricao"/></td>
			</tr>
			<tr>
				<td colspan="2"><html:text property="descricao" maxlength="100" size="60" value=""/></td>
			</tr>
			<tr>
				<td class="txtPreto" align="left"><bean:message key="bsc.campo.ativo"/></td>
				<td class="txtPreto" align="left"><bean:message key="bsc.campo.datacontrato"/></td>
			</tr>
			<tr>
				<td>
					<html:select property="ativo" style="width:100px">
						<html:option value="1"><bean:message key="bsc.label.sim"/></html:option>
						<html:option value="2"><bean:message key="bsc.label.nao"/></html:option>
					</html:select>
				</td>
				<td colspan="2"><html:text property="dataUso" styleId="f_date_c" readonly="false" value="" 
											onkeypress="return restringeCampoNumerico(this);" 
											maxlength="10" size="10" onkeydown="formataData(this);" 
										    onblur="validarData(this,'Data');"/>
					<img src="<c:out value="${base}"/>/WEB/calendario/imagem/calendario.gif" 
						 id="f_trigger_c" style="cursor: pointer; vertical-align: bottom;" title="Selecionar a Data"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right"></br>
					<button type="button" onclick="salvar();" class="botaoPreto">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.salvar"/>
					</button>
				</td>
			</tr>
		</table>
		<table border="0" height="44" cellpadding="0" cellspacing="0">
			<tr>
				<td width="380px" height="40px" style="color:#0DA007" >	
					<b><html:messages id="msg" message="true"> 
						<img align="bottom" src="<c:out value="${base}"/>/WEB/imagens/comum/atencao.gif" border="0">
						<bean:write name="msg"/>
					</html:messages></b>
				</td>
			 </tr>
		</table>
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