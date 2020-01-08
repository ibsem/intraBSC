<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/c" prefix="c" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag"%>
<!-- <%@ taglib uri="/taglibibb" prefix="ibb"%>  -->

<script language="javascript" src="/js/calendar.js"></script>
<script language="javascript" src="/js/calendar-br.js"></script>
<script language="javascript" src="/js/calendar-setup.js"></script>
<script language="javascript" src="/js/utils.js"></script>

<link rel="stylesheet" href="/css/intranet.css">
<link rel="stylesheet" href="/css/calendario.css">



<script language="JavaScript">
	function consultar(){
		if ((validaChave(document.relatorioForm.chaveSolicitante)))	{
			if ((document.relatorioForm.chaveSolicitante.value != "") && (document.relatorioForm.chaveParticipante.value != "")){
				if ((document.relatorioForm.nomeSolicitante.value.trim() != "") && (document.relatorioForm.nomeParticipante.value.trim() != "")){
					abrirPopupRelatorio("<c:out value="${base}"/>/relatorios/final.do?op=ganttTarefa");
				}else{
					alert("Nome é campo obrigatórios.");
				}
			}else if ((document.relatorioForm.chaveSolicitante.value != "") && (document.relatorioForm.chaveParticipante.value == "")){
				if ((document.relatorioForm.nomeSolicitante.value.trim() != "") && (document.relatorioForm.nomeParticipante.value.trim() == "")){
					abrirPopupRelatorio("<c:out value="${base}"/>/relatorios/final.do?op=ganttTarefa");
				}else{
					alert("Nome é campo obrigatórios.");
				}
			}else if ((document.relatorioForm.chaveSolicitante.value == "") && (document.relatorioForm.chaveParticipante.value != "")){
				if ((document.relatorioForm.chaveSolicitante.value.trim() == "") && (document.relatorioForm.chaveParticipante.value.trim() != "")){
					abrirPopupRelatorio("<c:out value="${base}"/>/relatorios/final.do?op=ganttTarefa");
				}else{
					alert("Digite ao menos uma das chaves.");
				}
			}
		}
	}
	
	function consultarSolicitante(){
		<%request.getSession().setAttribute("formAnce","relatorioForm");%>
		abrirPopupPesquisa("<c:out value="${base}"/>/atividade/encaminha/consultaSolicitante.do?op=encaminharConsultaSolicitante&solicitanteRelatorio=solicitante");
	}
	function consultarParticipante(){
		<%request.getSession().setAttribute("formAnce","relatorioForm");%>
		abrirPopupPesquisa("<c:out value="${base}"/>/atividade/encaminha/consultaSolicitante.do?op=encaminharConsultaSolicitante&solicitanteRelatorio=participante");	
	}
	
	function consultarSolicitanteChave(args){
			if (validaChave(document.relatorioForm.chaveSolicitante)){
				if (document.relatorioForm.chaveSolicitante.value != ""){
					document.relatorioForm.action = "<c:out value="${base}"/>/relatorio/consultarSolicitanteGaant.do?op=consultarSolicitanteChave";
					document.relatorioForm.submit();
				}else{
					document.relatorioForm.nomeSolicitante.value = "";
				}
			}
		}
	function consultarParticipanteChave(args){
		if (validaChave(document.relatorioForm.chaveParticipante)){
				if (document.relatorioForm.chaveParticipante.value != ""){
					document.relatorioForm.action = "<c:out value="${base}"/>/relatorio/consultarParticipanteGaant.do?op=consultarParticipanteChave";
					document.relatorioForm.submit();
				}else{
					document.relatorioForm.nomeParticipante.value = "";
				}
			}	
	}
	
	
</script>

<html:form action="/relatorios/final"> 
	<html:hidden property="sucessoSolicitante" value="relatorio"/>
	<html:hidden property="solicitanteRelatorio" value=""/>
	<html:hidden property="op" value="gerenteGeral"/>
	<table border="0" cellpadding="0" cellspacing="0">
		<tr>
	      <td>
			Data Limite de Prazo:&nbsp;<html:text property="dataPrazo" maxlength="10" styleId="idDataPrazo" style="width:70"/>
			<ibb:calendario campoId="idDataPrazo" onClose="function(cal){focalizar(cal);document.body.focus();}"/>
	      </td>
	    </tr>
	</table>
	<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td>
				<bean:message key="pro.relatorio.solicitante" />
			</td>
		</tr>
		<tr>
			<td>
				<html:text property="chaveSolicitante" maxlength="8" size="8%" onblur="consultarSolicitanteChave(this);"/>
			</td>
			<td>	
				<html:text property="nomeSolicitante" maxlength="50" size="50"/>
			</td>
			<td colspan="2" align="right">
				<html:button property="" onclick="consultarSolicitante()">
					<bean:message key="pro.botao.pesquisar" />
				</html:button>
			</td>	
		</tr>
		<tr>
			<td>	
				<bean:message key="pro.relatorio.participante" />
			</td>			
		</tr>
		<tr>
			<td>
				<html:text property="chaveParticipante" maxlength="8" size="8%" onblur="consultarParticipanteChave(this);"/>
			</td>
			<td>
				<html:text property="nomeParticipante" maxlength="50" size="50"/>
			</td>
			<td colspan="2" align="right">
				<html:button property="" onclick="consultarParticipante()">
					<bean:message key="pro.botao.pesquisar" />
				</html:button>
			</td>
		</tr>
		
		<tr>
			<td>
				<!--</br><html:radio style="border:0" name="relatorioForm" property="opcaoResumoAnotacao" value="R"><bean:message key="pro.label.resumo" /></html:radio>-->
			</td>
		</tr>
		<tr>
			<td>
				<!--<html:radio style="border:0" name="relatorioForm" property="opcaoResumoAnotacao" value="H"><bean:message key="pro.label.anotacao" /></html:radio>-->
			</td>
		</tr>
	</table></br>
	<table width="100%">
		<tr>
			<td colspan="2" align="right">
				<html:button property="gerarRelatorio" onclick="consultar();">
					<bean:message key="pro.botao.gerarRelatorio" />
				</html:button>
			</td>
		</tr>
	</table>
</html:form>


<html:javascript formName="relatorioForm" />