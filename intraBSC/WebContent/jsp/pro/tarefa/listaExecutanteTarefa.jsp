<script type="text/javascript">
	var participanteEstado = "fechado";
	function abreFechaParticipante(){
		var participante = document.getElementById('participante');
		if (participante != null){
			if ((participanteEstado == "fechado")){
				dojo.lfx.html.wipeOut(participante, 400).play();
				participanteEstado = "aberto";
			}else{
				dojo.lfx.html.wipeIn(document.getElementById('participante'), 400).play();
				participanteEstado = "fechado";
			}
		}
	}
	
	function vincularExecutante(){
		var nomeP =document.tarefaForm.nome.value;
		var dtPrazoP =document.tarefaForm.dtLimitePrazo.value;
		var codEstadoP =document.tarefaForm.codEstado.value;
		var codCriticidadeP =document.tarefaForm.codCriticidade.value;
		var dtInicioP =document.tarefaForm.dtInicio.value;
		var dtFimP =document.tarefaForm.dtFim.value;
		var txtDescricaoP =document.tarefaForm.textoSolicitacao.value;
		abrirPopupPesquisa("<c:out value="${base}"/>/participante/encaminhar/pesquisa.do?op=encaminharConsulta&nome="+nomeP+"&dtPrazo="+dtPrazoP+"&codEstado="+codEstadoP+"&codCriticidade="+codCriticidadeP+"&dtInicio="+dtInicioP+"&dtFim="+dtFimP+"&txtDescricao="+txtDescricaoP);	
	}
	
	function excluirExecutante(){
		if (document.tarefaForm.chaveSelecionadaExecutante.value != ""){
			if(confirm("Deseja realmente excluir o Executante?")){
				var nomeP =document.tarefaForm.nome.value;
				var dtPrazoP =document.tarefaForm.dtLimitePrazo.value;
				var codEstadoP =document.tarefaForm.codEstado.value;
				var codCriticidadeP =document.tarefaForm.codCriticidade.value;
				var dtInicioP =document.tarefaForm.dtInicio.value;
				var dtFimP =document.tarefaForm.dtFim.value;
				var txtDescricaoP =document.tarefaForm.textoSolicitacao.value;
				document.tarefaForm.action = "<c:out value="${base}"/>/executante/excluir.do?op=excluir&executante="+document.tarefaForm.execucao.value+"&tipoParticipacao=1&chaveSelecionada="+ document.tarefaForm.chaveSelecionadaExecutante.value+"&nome="+nomeP+"&dtPrazo="+dtPrazoP+"&codEstado="+codEstadoP+"&codCriticidade="+codCriticidadeP+"&dtInicio="+dtInicioP+"&dtFim="+dtFimP+"&txtDescricao="+txtDescricaoP;	
				document.tarefaForm.submit();
			}
		}else{
			alert("Selecione um Usuário");
		}
				
	}
	function limparExecutante(){
		if(confirm("Deseja realmente excluir todos os usuários da execução?")){
			var nomeP =document.tarefaForm.nome.value;
			var dtPrazoP =document.tarefaForm.dtLimitePrazo.value;
			var codEstadoP =document.tarefaForm.codEstado.value;
			var codCriticidadeP =document.tarefaForm.codCriticidade.value;
			var dtInicioP =document.tarefaForm.dtInicio.value;
			var dtFimP =document.tarefaForm.dtFim.value;
			var txtDescricaoP =document.tarefaForm.textoSolicitacao.value;
			document.tarefaForm.action = "<c:out value="${base}"/>/executante/incluir.do?op=limpar&tipoParticipacao=1&nome="+nomeP+"&dtPrazo="+dtPrazoP+"&codEstado="+codEstadoP+"&codCriticidade="+codCriticidadeP+"&dtInicio="+dtInicioP+"&dtFim="+dtFimP+"&txtDescricao="+txtDescricaoP;	
			document.tarefaForm.submit();
		}
	}
	function setaValorSelecionadoExecutante(args,args2){		
		if (args2 != -1)
			document.tarefaForm.chaveSelecionadaExecutante.value = args.options[args2].value;
	}
</script>
<div id="participante">
	<table border="0" width="100%"  cellpadding="0" cellspacing="0">
		<input type="hidden" name="chaveSelecionadaExecutante" value""/>
		<input type=hidden name="tipoParticipacao" value=""/>
		<tr valign="top" >
			<td colspan="3">	
				<html:select property="execucao" size="2" style="width:100%;height:100px;" onclick="javascript: setaValorSelecionadoExecutante(this,this.selectedIndex);">
					<html:options collection="executantes" property="codUsuario" labelProperty="nome" />
				</html:select>
			</td>
		</tr>
		<tr align="right">
			<td style="width:85%">
				<button type="button" onclick="javascript:vincularExecutante();" class="botaoPreto" style="vertical-align: middle">
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/adicionar.gif" border="0" style="vertical-align: text-bottom">
					<bean:message key="pro.botao.adicionar"/>
				</button>
			</td>
			<logic:notEmpty name="executantes">
				<td width="15%">
				<button type="button" onclick="javascript:excluirExecutante();" class="botaoPreto" style="vertical-align: middle">
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/excluir.gif" border="0" style="vertical-align: text-bottom">
					<bean:message key="pro.botao.excluir"/>
				</button>
			<%-- </td>
				<td width="90px">
				<button type="button" onclick="javascript:limparExecutante();" class="botaoPreto" style="vertical-align: middle">
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/excluir.gif" border="0" style="vertical-align: text-bottom">
					<bean:message key="pro.botao.limpar"/>
				</button>
			</td>--%>			
			</logic:notEmpty>
		</tr>
	</table>
</div>