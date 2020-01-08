<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/c" prefix="c" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>
<%@ taglib uri="/tags/fmt" prefix="fmt" %>
<link rel="stylesheet" type="text/css" media="all" href="<c:out value="${base}"/>/WEB/calendario/css/calendar.css" title="win2k-cold-1" />
<script type="text/javascript" src="<c:out value="${base}"/>/WEB/calendario/js/calendar.js"></script>
<script type="text/javascript" src="<c:out value="${base}"/>/WEB/calendario/js/calendar-en.js"></script>
<script type="text/javascript" src="<c:out value="${base}"/>/WEB/calendario/js/calendar-setup.js"></script>

<script language = "JavaScript">
	function salvar(){	
		if ((document.indicadorForm.ultimoValor.value != "")&&(document.indicadorForm.ultimaData.value != "")){
			if (validarData(document.indicadorForm.ultimaData,'Data')){
				document.indicadorForm.action = "<c:out value="${base}"/>/indicadorFato/manutencao.do?op=incluirIndicadorFato";
				document.indicadorForm.submit();
			}
		}else{
			alert("Os campos valor e data são obrigatórios.");
		}
	}
	
</script>	
<script type="text/javascript" src="<c:out value="${base}"/>/WEB/js/funcoes.js"></script>
<html:html>
	<html:form action="/indicadorFato/manutencao.do?op=incluirIndicadorFato">
		<input type="hidden" name="codMapa" value="<c:out value="${codMapa}"/>">
		<input type="hidden" name="codPerspectiva" value="<c:out value="${codPerspectiva}"/>">
		<table border="0" cellspacing="0" cellpadding="0" width="700px" style="height:20px">
			<tr>
				<td colspan="7" style="border-bottom:thin; font-size:14px;  border-bottom-style:solid;">
					&nbsp;&nbsp;<b><bean:message key="bsc.label.manutencaoValores"/></b>
				</td>
			</tr>
			
			<tr>
			<td height="5px" >&nbsp;
			</td>
				
			</tr>
			<tr>
				<td width="40px" align="right">
					<bean:message key="bsc.campo.data"/>
				</td>
<!-- 			<td width="100px">
					<html:text property="ultimaData" maxlength="10" size="10" onkeydown="formataData(this);" onblur="validarData(this,'Data');"/>
				</td>
 -->
				<td width="110px" colspan="1" align="center"><html:text property="ultimaData" styleId="f_date_c" readonly="false"
										    maxlength="10" size="10" onkeydown="formataData(this);" 
										    onblur="validarData(this,'Data');"/>
					<img src="<c:out value="${base}"/>/WEB/calendario/imagem/calendario.gif" 
						 id="f_trigger_c" style="cursor: pointer; vertical-align: middle;" title="Selecionar a Data"/>
				</td>
				<td width="40px" align="right">
					<bean:message key="bsc.campo.valor"/>
				</td>
				<td width="40px" align="center">
					<html:text property="ultimoValor" maxlength="10" size="10" value=""/>
				</td>
				<td width = "32px" align="right" >
					<button type="button" class="botaoPreto" style="vertical-align: middle; width:32px;height:32px;padding: 2px;" onclick="salvar();">
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" border="0" style="vertical-align: text-bottom">
				</button>
			
				</td>
				<td width = "32px" align = "center"><%@ include file="/jsp/layout/erro.jsp"%></td>
				<td width = "32px" align="left" ><%@ include file = "/jsp/layout/imprimirRelatorioBotao.jsp"%></td>
				
				
			</tr>
			<tr>
			<td height="2px" colspan="7" style="border-bottom:thin;border-bottom-style:solid;">
			&nbsp;
			</td>
				
			</tr>
		</table>
	</html:form>
	<html:javascript formName="indicadorForm" />
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