<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/c" prefix="c" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>

<script language="javascript" type="text/javascript">	
	function vincularExecutanteConfigTarefa(){
		var selecionado = "nao";
		if (document.participanteConfigTarefaForm.listaIncluir != null){
			for (var i=0;i<document.participanteConfigTarefaForm.listaIncluir.length;i++){
				if (document.participanteConfigTarefaForm.listaIncluir[i].checked){
					selecionado = "sim";
				}
			} 
			if (document.participanteConfigTarefaForm.listaIncluir.checked){
				selecionado = "sim";
			}
		}
		if (selecionado == "sim"){
			document.participanteConfigTarefaForm.action = "<c:out value="${base}"/>/executanteConfigTarefa/incluir.do?op=incluir&tipoParticipacao=1";
			document.participanteConfigTarefaForm.submit();
		}else{
				alert("Selecione um usuário(s) para vincular.");
		}
	}

		function pesquisarExecutanteConfigTarefa(){
			if (document.participanteConfigTarefaForm.nomeParticipante.value != ""){
				document.participanteConfigTarefaForm.action = "<c:out value="${base}"/>/executanteConfigTarefa/consultar.do?op=consultarParticipanteNome";
				document.participanteConfigTarefaForm.submit();
			}else if (document.participanteConfigTarefaForm.codUsuario.value != ""){
				document.participanteConfigTarefaForm.action = "<c:out value="${base}"/>/executanteConfigTarefa/consultar.do?op=consultarParticipanteChave";
				document.participanteConfigTarefaForm.submit();
			}else{
				alert("Digite algum dado para realizar a pesquisa.");
			}
		}

		function verificaSelecao(args){			
			if (document.participanteConfigTarefaForm.listaIncluir != null){
				if (args.checked){
					for (var i=0;i<document.participanteConfigTarefaForm.listaIncluir.length;i++){
						document.participanteConfigTarefaForm.listaIncluir[i].checked = false;
					}
				}
				if (document.participanteConfigTarefaForm.listaIncluir.length == null){
					if (args.checked){
						document.participanteConfigTarefaForm.listaIncluir.checked = false;	
					}
				}
			}
		}		
		
		function desmarcaCampoNome(){
           document.participanteConfigTarefaForm.nomeParticipante.value = "";
        }
	
		function voltarConfigTarefa(){
			<%br.com.intraPRO.configTarefa.visao.ConfigTarefaForm configTarefaForm = (br.com.intraPRO.configTarefa.visao.ConfigTarefaForm) request.getSession().getAttribute("configTarefaForm");%>
			var codTipo = <%=configTarefaForm.getCodigoConfigTarefa()%>;
			window.opener.location.href = "<c:out value="${base}"/>/configTarefa/consultarUm.do?op=consultarUm&codigoConfigTarefa="+codTipo;
			window.close();
		}

	</script>
	<html:form action="/executanteConfigTarefa/consultar">
		<html:hidden property="op" value="incluir"/>
		<table border="0" width="350px"  style="cellpadding:0; cellspacing:0">
			<tr>
				<td><bean:message key="pro.label.chaveParticipante" /></td>
			</tr>
			<tr>
				<td>
					<html:text property="codUsuario" value="" maxlength="8" size="10" onkeypress="desmarcaCampoNome();"/>
				</td>				 
			</tr> 
			<tr>
				<td><bean:message key="pro.label.nomeParticipante" /></td>
			</tr> 
			<tr>
 				<td colspan="5">
 					<html:text property="nomeParticipante" value="" maxlength="100" size="52" disabled="false"/>
 				</td>
			</tr>
		</table>
		</br>
		<table width="350px" border="0">
			<tr>
				<td align="right">
				<button type="button" property="" onclick="pesquisarExecutanteConfigTarefa();" class="botaoPreto" style="vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/pesquisar.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.pesquisar"/>
				</button>
				
				<button type="button" property="" onclick="vincularExecutanteConfigTarefa();" class="botaoPreto" style="vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.salvar"/>
				</button>
				
				<button type="button" property="botao" onclick="voltarConfigTarefa();" class="botaoPreto" style="vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/voltar.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.voltar"/>
				</button>
				</td>
			</tr>
		</table>
		<table border="0" align="center">
				<logic:notEmpty name="listarParticipantes">
				<tr height="4">
					<td colspan="3" >&nbsp;
					</td>
				</tr>
				<tr width="350px">
					<td width="0%" align="left">
						
					</td>
					
					<td width="15%" align="left">
						<u><bean:message key="bsc.label.codigo" /></u>
					</td><td width="85%" align="left">
						<u><bean:message key="bsc.label.nome"/></u>
					</td>
					
				</tr>
			</logic:notEmpty>
			</table>
		<logic:notEmpty name="listarParticipantes">
			<displaytag:table width="350px" name="listarParticipantes" id="participante" styleClass="its" requestURI="" pagesize="5" scope="request">
				<displaytag:column>
					<html:multibox name="participanteConfigTarefaForm" property="listaIncluir" style="border:0" >
						<bean:write name="participante" property="chaveFuncionario" />
					</html:multibox>
				</displaytag:column>

				<displaytag:column style="width:15%;" title="">
					<c:out value="${participante.chaveFuncionario}" />
				</displaytag:column>

				<displaytag:column style="width:65%;" title="">
					<c:out value="${participante.nomeFuncionario}" />
				</displaytag:column>
				
				<displaytag:column style="width:20%;" title="">
					<html:select name="participanteConfigTarefaForm" property="codPapel" style="width:100px">
						<html:option value="0">-- Selecione --</html:option>
						<html:options collection="listaRole" property="id" labelProperty="nome" />
					</html:select>
				</displaytag:column>
			</displaytag:table>
		</logic:notEmpty>
			

</html:form>
