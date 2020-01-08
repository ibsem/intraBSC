<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/c" prefix="c" %>

<script type="text/javascript" src="<c:out value="${base}"/>/WEB/js/dojo.js"></script>

<script language="JavaScript">
	<%java.util.Collection lista = (java.util.Collection) request.getSession().getAttribute("listaOpcaoFormulario");%>
	<%String codTipo = (String)request.getSession().getAttribute("codConfigTarefa");%>
	
	function voltarConfigTarefa(){
		document.formularioForm.action = "<c:out value="${base}"/>/configTarefa/consultarUm.do?op=consultarUm&codigoConfigTarefa="+document.formularioForm.codConfigTarefa.value;
		document.formularioForm.submit();
	}
	
	function habilitaCombo(){
		if (document.formularioForm.codigoDadoFormulario.value == "4"){
			dojo.lfx.html.wipeIn(document.getElementById('wiper'), 400).play();
			window.resizeTo(450,450);
		}else{
			dojo.lfx.html.wipeOut(document.getElementById('wiper'), 400).play();
			window.resizeTo(450,300);
		}
	}
	function setaValorSelecionado(args,args2){
		if (args2 != -1)
			document.formularioForm.codigoSelecionadoExcluir.value = args.options[args2].value;
	}
	
	function excluirLista(){
		var codSel = document.formularioForm.codigoSelecionadoExcluir.value;
		if (codSel != null){
			if(confirm("Deseja realmente excluir o textos do Combo?")){
				document.formularioForm.action = "<c:out value="${base}"/>/listaOpcao/formulario.do?op=excluirListaOpcao&codListaOpcao="+codSel;
				document.formularioForm.submit();
			}
		}else{
			alert("Selecione uma opção para ser excluída.");
		}
	}
	
	function incluirLista(){
		if (document.formularioForm.nomeTextoCombo.value != ""){
			document.formularioForm.action = "<c:out value="${base}"/>/listaOpcao/formulario.do?op=incluirListaOpcao&codigoDadoFormulario=4";
			document.formularioForm.submit();
		}else{
			alert("Campo Lista de Opções para o Combo é obrigatório.");
		}
	}
	
	function limparLista(){
		<%if (!lista.isEmpty()){%>
			if(confirm("Deseja realmente excluir todos os textos do Combo?")){
				document.formularioForm.action = "<c:out value="${base}"/>/listaOpcao/formulario.do?op=limparListaOpcao";
				document.formularioForm.submit();
			}
		<%}else{%>
			alert("Não existe infomação para ser excluída.");
		<%}%>
	}
	
	function voltarConfigTarefa(){
		window.close();
	}
			
	function alterar(){
		<%br.com.intraPRO.configTarefa.visao.ConfigTarefaForm configTarefaForm = (br.com.intraPRO.configTarefa.visao.ConfigTarefaForm) request.getSession().getAttribute("configTarefaForm");%>
		var codTipo = <%=configTarefaForm.getCodigoConfigTarefa()%>;
		document.formularioForm.action = "<c:out value="${base}"/>/formulario/alterar.do?op=alterar&tipoParticipacao=1&formAnce=configTarefaForm&acao=<c:out value="${base}"/>/configTarefa/consultarUm.do?op=consultarUm$codigoConfigTarefa="+codTipo;
		document.formularioForm.submit();		
	}
	
</script>
<body onload="habilitaCombo();"></body>
<html:form action="/formulario/alterar" onsubmit="return validateFormularioForm(this);">
		<html:hidden property="op" value="alterar"/>
		<html:hidden property="codListaOpcao" value=""/>
		<input type=hidden name="codigoSelecionadoExcluir" value=""/>
		
		<html:hidden property="codConfigTarefa" value="<%=codTipo%>"/>
		<table border="0" width="380px" cellpadding="0" cellspacing="0">
			<tr>
				<td colspan="3">
					<bean:message key="pro.label.configTarefa" />
				</td> 
			</tr>			
			<tr>
				<td colspan="3">
					<html:select property="codConfigTarefa" value="<%=codTipo%>" disabled="true" onclick="javascript: setaValorSelecionado(this,this.selectedIndex)" style="width=380px">
						<html:option value=""></html:option>
						<html:options collection="listaConfigTarefa" property="codigoConfigTarefa" labelProperty="textoConfigTarefa"/>
					</html:select>
				</td>
			</tr>
			<tr><td height="7"></td></tr>
			<tr>
				<td colspan="3">
					<bean:message key="pro.label.nomeCampoInformacao" />
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<html:text property="nome" size="59" maxlength="100" />
				</td>
			</tr>
			<tr><td height="5"></td></tr>
			<tr>
				<td widht="50%">
					<bean:message key="pro.label.numeroInformacao" />
				</td>
				<td  widht="50%">
					<bean:message key="pro.label.vigente" /> 
				</td>
				<td widht="50%">
					<bean:message key="pro.label.Tipo" /> 
				</td>
			</tr>
			<tr>	
				<td widht="50%">
					<input type="hidden" name="numOrdemAnterior" value="<c:out value="${formularioForm.numeroOrdem}"/>">
					<html:text property="numeroOrdem" size="21" disabled="false" maxlength="3" />
				</td>
				<td widht="30%">					
					<html:select property="indFormularioVigente" >
						<html:option value="S"><bean:message key="pro.label.option.sim"/></html:option>
						<html:option value="N"><bean:message key="pro.label.option.nao"/></html:option>
					</html:select>
				</td>
				<td widht="20%" align="right" >
					<html:select property="codigoDadoFormulario" onchange="habilitaCombo();">
							<html:option value="1"><bean:message key="pro.label.Texto" /></html:option>
							<html:option value="2"><bean:message key="pro.label.numero" /></html:option>
							<html:option value="3"><bean:message key="pro.label.data" /></html:option>
							<html:option value="4"><bean:message key="pro.label.combo" /></html:option>
					</html:select>
				</td>
			</tr>
			<tr><td height="10"></td>
			</tr>
		</table>
		<div id="wiper">
		<table border="0" width="385px" cellpadding="0" cellspacing="0">			
				<tr>
					<td colspan="2"><bean:message key="pro.label.formulario.opcoes.combo" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<html:text property="nomeTextoCombo" size="59" maxlength="100"   disabled="false"/>
					</td>
				</tr>
				<tr>	
				<td align="right">
					<button type="button" onclick="incluirLista();" class="botaoPreto" style="vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/adicionar.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.adicionar"/>
					</button>
					<button type="button" onclick="excluirLista();" class="botaoPreto" style="vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/excluir.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.excluir"/>
					</button>
				</td>
				</tr>
				<tr>
					<td colspan="2">
						<html:select property="listaTextoCombo"   size="2" style="width: 380px;height: 80px;" onclick="javascript: setaValorSelecionado(this,this.selectedIndex);">
							<logic:present name="listaOpcaoFormulario">
								<html:options collection="listaOpcaoFormulario" property="codigo" labelProperty="texto" />
							</logic:present>
						</html:select>
					</td>
				</tr>
			</table>
		</div>
		<table border="0" width="389px" cellpadding="0" cellspacing="0">
			<tr>
				<td align="right">
					<button type="button" onclick="alterar();" class="botaoPreto" style="vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.salvar"/>
					</button>
					<button type="button" onclick="voltarConfigTarefa();" class="botaoPreto" style="vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/voltar.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.voltar"/>
					</button>
				</td>
			</tr>
		</table>
	
	<html:javascript formName="formularioForm" />
	<script>habilitaCombo();</script>
</html:form>
