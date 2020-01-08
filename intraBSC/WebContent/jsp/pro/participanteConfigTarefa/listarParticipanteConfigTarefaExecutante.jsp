<script type="text/javascript">
	function vincularTipoParticipanteExecutante(){
		abrirPopupPesquisa("<c:out value="${base}"/>/executanteConfigTarefa/encaminhar/consulta.do?op=encaminharConsultaParticipante");
	} 	

	function deletarConfigTarefaExecutante(){
		if ((document.configTarefaForm.chaveSelecionadaExecutante.value != null) && (document.configTarefaForm.chaveSelecionadaExecutante.value != "")){
			if(confirm("Deseja realmente excluir o Executante?")){
				document.configTarefaForm.action = "<c:out value="${base}"/>/executanteConfigTarefa/incluir.do?op=excluir&chaveSelecionada="+ document.configTarefaForm.chaveSelecionadaExecutante.value+ "&codigoConfigTarefa=" + document.configTarefaForm.codigoConfigTarefa.value+"&tipoParticipacao=1"
				document.configTarefaForm.submit();
			}
		}else{
			alert("Selecione um Executante a ser Excluído.");	
		}
	}

	function limparTipoParticipanteExecutar(){
		if(confirm("Deseja realmente excluir todos os usuários da execução?")){
			document.configTarefaForm.action = "<c:out value="${base}"/>/executanteConfigTarefa/incluir.do?op=limpar&codigoPeriodica=" + document.configTarefaForm.codigoConfigTarefa.value+"&tipoParticipacao=1"
			document.configTarefaForm.submit();	
		}
	}

	function setaValorSelecionadoTipoParticipanteExe(args,args2){
		if (args2 != -1)
			document.configTarefaForm.chaveSelecionadaExecutante.value = args.options[args2].value;
	}

</script>
<html:hidden property="chaveSelecionadaExecutante" value=""/>
<logic:present name="listaTipoParticipanteExecutante" scope="request">
	<html:select property="executante" style="width:100%" size="4" onclick="setaValorSelecionadoTipoParticipanteExe(this,this.selectedIndex);">
		<html:options collection="listaTipoParticipanteExecutante" property="codUsuario" labelProperty="nome" />	
	</html:select>
</logic:present>
<logic:notPresent name="listaTipoParticipanteExecutante" scope="request">
	<select name="" size="4" style="width:100%">
		<option value=""></option>
	</select>
</logic:notPresent>

<table align="right" widht="100%" border="0">
	<tr>
		<td>
			<button type="button" onclick="javascript: vincularTipoParticipanteExecutante();" class="botaoPreto" style="vertical-align: middle">
				<img src="<c:out value="${base}"/>/WEB/imagens/comum/adicionar.gif" border="0" style="vertical-align: text-bottom">
				<bean:message key="pro.botao.adicionar"/>
			</button>
		</td>
		<logic:notEmpty name="listaTipoParticipanteExecutante">
			<td>
				<button type="button" onclick="deletarConfigTarefaExecutante();" class="botaoPreto" style="vertical-align: middle">
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/excluir.gif" border="0" style="vertical-align: text-bottom">
					<bean:message key="pro.botao.excluir"/>
				</button>
			</td>
			<td>
				<button type="button" onclick="limparTipoParticipanteExecutar();" class="botaoPreto" style="vertical-align: middle">
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/excluir.gif" border="0" style="vertical-align: text-bottom">
					<bean:message key="pro.botao.limpar"/>
				</button>
			</td>
		</logic:notEmpty>
	</tr>
</table>