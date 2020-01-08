<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/c" prefix="c" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>

<script language="javascript" type="text/javascript">
		function vincularParticipante(){
		
			var selecionado = "nao";
			for (var i=0;i<document.participanteForm.listaIncluir.length;i++){
				if (document.participanteForm.listaIncluir[i].checked){
					selecionado = "sim";
				}
			}
			if (document.participanteForm.listaIncluir.checked){
					selecionado = "sim";
			}
			if (document.participanteForm.listaIncluir.checked){
					selecionado = "sim";
			}
			if (selecionado == "sim"  ){
				document.participanteForm.action = "<c:out value="${base}"/>/executante/incluir.do?op=incluir&tipoParticipacao=1";
				document.participanteForm.submit();
			}else{
				alert("Selecione um Usuário");
			}

		}
		function pesquisarParticipante(){
			if (document.participanteForm.codUsuario.value != ""){
				document.participanteForm.action = "<c:out value="${base}"/>/participante/encaminhar/pesquisa.do?op=consultarParticipanteChave";
				document.participanteForm.submit();
			}else if (document.participanteForm.nomeParticipante.value != ""){
				document.participanteForm.action = "<c:out value="${base}"/>/participante/encaminhar/pesquisa.do?op=consultarParticipanteNome";
				document.participanteForm.submit();
			}else{
				alert("Selecione um dos itens acima para realizar a pesquisa.");
			}
		}

		function verificaSelecao(args){
			if (args.checked){				
				for (var i=0;i<document.participanteForm.listaIncluir.length;i++){
					document.participanteForm.listaIncluir[i].checked = false;
				}
			}
		}

		function desmarcaCampoChave(){
           document.participanteForm.codUsuario.value = "";
        }
		function desmarcaCampoNome(){
           document.participanteForm.nomeParticipante.value = "";
        }
        
        function voltarTarefa(){
	        <%br.com.intraPRO.modelo.TarefaTO tarefaTO = (br.com.intraPRO.modelo.TarefaTO) request.getSession().getAttribute("tarefaTO");%>
			var ano = <%=tarefaTO.getAnoCriacao()%>;
			var codTarefa = <%=tarefaTO.getCodigo()%>;
	        window.opener.location.href = "<c:out value="${base}"/>/tarefa/encaminhar/alterar.do?op=encaminharAlterar&anoCriacao=" + ano + "&codigo=" + codTarefa;
			window.close();
		}

	</script>
<html:form action="/participante/encaminhar/pesquisa">
			<html:hidden property="listaSelecionada" value="" />
			<html:hidden property="nomeSolicitPesq" value=""/>
			<html:hidden property="matricula" />
			</br>	
			<table border="0" width="390px" valign="top" cellpadding="0" cellspacing="0">
			</table>
			<table cellpadding="0" cellspacing="0">
				<tr>
					<td><bean:message key="pro.label.chaveParticipante" /></td>
				</tr>
				<tr>
					<td><html:text property="codUsuario" maxlength="8" value="" size="10" disabled="false" onkeypress="desmarcaCampoNome(this);"/></td>
				</tr>
				<tr>
					<td><bean:message key="pro.label.nomeParticipante" /></td>
				</tr>
				<tr>
					<td colspan="2"><html:text property="nomeParticipante" value="" maxlength="100" size="58" disabled="false"/>
				</tr>
			</table>
			</br>
			<table width="390px" border="0" cellpadding="0" cellspacing="0"> 
				<tr align="right">
					<td width="40%" align="right">
						<button type="button" onclick="javascript: vincularParticipante();" class="botaoPreto" style="vertical-align: middle">
							<img src="<c:out value="${base}"/>/WEB/imagens/comum/adicionar.gif" border="0" style="vertical-align: text-bottom">
							<bean:message key="pro.botao.adicionar"/>
						</button>
					</td>
					<td width="30%" align="center">
						<button type="button" onclick="javascript: pesquisarParticipante();" class="botaoPreto" style="vertical-align: middle">
							<img src="<c:out value="${base}"/>/WEB/imagens/comum/pesquisar.gif" border="0" style="vertical-align: text-bottom">
							<bean:message key="pro.botao.pesquisar"/>
						</button>
					</td>		
					<td width="30%" align="left">
						<button type="button" onclick="voltarTarefa();" class="botaoPreto" style="vertical-align: middle">
							<img src="<c:out value="${base}"/>/WEB/imagens/comum/voltar.gif" border="0" style="vertical-align: text-bottom">
							<bean:message key="pro.botao.fechar"/>
						</button>
					</td>
				</tr>
				<tr>
					<td height="2%"></td>
				</tr>
			</table>
			</br>
			<table border="0" align="center">
				<logic:notEmpty name="listarParticipantes">
				<tr height="4">
					<td colspan="3" >&nbsp;
					</td>
				</tr>
				<tr width="380px">
				
					<td width="20px" align="left">
						<u><bean:message key="bsc.label.codigo"/></u>
					</td>
					<td width="210px" align="left">
						<u><bean:message key="bsc.label.nome"/></u>
					</td>
					<td width="150px" align="left">
						<u><bean:message key="bsc.campo.papel"/></u>
					</td>
				</tr>
			</logic:notEmpty>
			</table>
			<logic:notEmpty name="listarParticipantes">
				<displaytag:table width="370px" name="listarParticipantes" id="part" styleClass="its" requestURI="" pagesize="5" scope="request">
					<displaytag:column>
						<html:multibox name="participanteForm" property="listaIncluir" style="border:0" >
							<bean:write name="part" property="chaveFuncionario" />
						</html:multibox>
					</displaytag:column>
	
					<displaytag:column style="width:15%;" title="">
						<c:out value="${part.chaveFuncionario}" />
					</displaytag:column>
	
					<displaytag:column style="width:65%;" title="">
						<c:out value="${part.nomeFuncionario}" />
					</displaytag:column>
					<displaytag:column style="width:20%;" title="">
					<html:select name="participanteForm" property="codPapel" style="width:100px">
						<html:option value="0" >-- Selecione --</html:option>
						<html:options collection="listaRole" property="id" labelProperty="nome" />
					</html:select>
				</displaytag:column>
					
				</displaytag:table>
			</logic:notEmpty>
</html:form>