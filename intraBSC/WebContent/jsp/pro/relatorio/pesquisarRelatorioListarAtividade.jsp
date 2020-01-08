<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/c" prefix="c" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag"%>

<script language="JavaScript">
	function consultar(){
		if ((validaChave(document.relatorioForm.chaveSolicitante)))	{
			if ((document.relatorioForm.chaveSolicitante.value != "") && (document.relatorioForm.chaveParticipante.value != "")){
				if ((document.relatorioForm.nomeSolicitante.value.trim() != "") && (document.relatorioForm.nomeParticipante.value.trim() != "")){
					abrirPopupRelatorio("<c:out value="${base}"/>/relatorios/final.do?op=listaTarefa");
				}else{
					alert("Nome é campo obrigatórios.");
				}
			}else if ((document.relatorioForm.chaveSolicitante.value != "") && (document.relatorioForm.chaveParticipante.value == "")){
				if ((document.relatorioForm.nomeSolicitante.value.trim() != "") && (document.relatorioForm.nomeParticipante.value.trim() == "")){
					abrirPopupRelatorio("<c:out value="${base}"/>/relatorios/final.do?op=listaTarefaExecutante");
				}else{
					alert("Nome é campo obrigatórios.");
				}
			}else if ((document.relatorioForm.chaveSolicitante.value == "") && (document.relatorioForm.chaveParticipante.value != "")){
				if ((document.relatorioForm.chaveSolicitante.value.trim() == "") && (document.relatorioForm.chaveParticipante.value.trim() != "")){
					abrirPopupRelatorio("<c:out value="${base}"/>/relatorios/final.do?op=listaTarefaParticipante");
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
					document.relatorioForm.action = "<c:out value="${base}"/>/relatorio/consultarSolicitanteChaveResumo.do?op=consultarSolicitanteChave";
					document.relatorioForm.submit();
				}else{
					document.relatorioForm.nomeSolicitante.value = "";
				}
			}
		}
	function consultarParticipanteChave(args){
		if (validaChave(document.relatorioForm.chaveParticipante)){
				if (document.relatorioForm.chaveParticipante.value != ""){
					document.relatorioForm.action = "<c:out value="${base}"/>/relatorio/consultarParticipanteChaveResumo.do?op=consultarParticipanteChave";
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