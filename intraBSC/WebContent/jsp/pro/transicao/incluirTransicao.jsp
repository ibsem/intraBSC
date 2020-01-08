<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/c" prefix="c" %>
<%@ page import="br.com.intraPRO.modelo.TransicaoTO"%>

<script language = "JavaScript">
	function selecionaAtividadePreCondicao(args,args2){
		if (args2 != -1){
			document.transicaoForm.causaId.value = args.options[args2].value;
			document.transicaoForm.posCondicaoId.selected.value = "";
		}
	}
	function selecionaPreCondicaoExcluir(args,args2){
		if (args2 != -1){
			document.transicaoForm.causaId.value = args.options[args2].value;
			document.transicaoForm.auxPreCondicao.value = args.options[args2].value;
		}
	}
	function selecionaAtividadePosCondicao(args,args2){
		if (args2 != -1)
			document.transicaoForm.posCondicaoId.value = args.options[args2].value;
	}
	function selecionaPosCondicaoExcluir(args,args2){
		if (args2 != -1){
			document.transicaoForm.posCondicaoId.value = args.options[args2].value;
			document.transicaoForm.auxPosCondicao.value = args.options[args2].value;
		}
	}
	
	function salvarPreCondicao(){
		if (document.transicaoForm.causaId.value != ""){
			if (document.transicaoForm.causaId.value != document.transicaoForm.idAtividade.value){
				document.transicaoForm.posCondicaoId.value = document.transicaoForm.idAtividade.value;
				document.transicaoForm.action="<c:out value="${base}"/>/transicao/manutencao.do?op=incluir&posCondicaoId=0"
				document.transicaoForm.submit();
			}else{
				alert("Opcao invalida.");
			}
		}else{
			alert("Selecione um Atividade.");
		}
	}	
	function salvarPosCondicao(){
		if (document.transicaoForm.posCondicaoId.value != ""){
			if (document.transicaoForm.posCondicaoId.value != document.transicaoForm.idAtividade.value){
				document.transicaoForm.causaId.value = document.transicaoForm.idAtividade.value;	
				document.transicaoForm.action="<c:out value="${base}"/>/transicao/manutencao.do?op=incluir&causaId=0"
				document.transicaoForm.submit();
			}else{
				alert("Opcao invalida.");
			}
		}else{
			alert("Selecione um Atividade.")
		}
	}
	
	function excluirPreCondicao(){
		if (document.transicaoForm.auxPosCondicao.value != ""){
			document.transicaoForm.action="<c:out value="${base}"/>/transicao/manutencao.do?op=excluir&posCondicaoId=0"
			document.transicaoForm.submit();
		}else{
			alert("Selecione um PreCondicao.")
		}
	}
	function excluirPosCondicao(){
		if (document.transicaoForm.auxPosCondicao.value != ""){
			document.transicaoForm.action="<c:out value="${base}"/>/transicao/manutencao.do?op=excluir&causaId=0"
			document.transicaoForm.submit();		
		}else{
			alert("Selecione um PosCondicao.")
		}
	}
	
	function modificaComboPreCondicao(args,args2){
		if (args2 != -1){
			var codSelecionado = args.options[args2].value;
			<%java.util.Collection listaPreCondicao = (java.util.Collection) request.getSession().getAttribute("listaPreCondicao");%>
			<%java.util.Iterator iter = listaPreCondicao.iterator();
			while (iter.hasNext()){
				TransicaoTO element = (TransicaoTO) iter.next();%>
				if (codSelecionado == <%=element.getPreCondicaoId()%>){
					document.transicaoForm.intensidadePreCondicao.value = "<%=element.getIntensidade()%>";
					document.transicaoForm.interacaoPreCondicao.value = "<%=element.getInteracao()%>";
				}
			<%}%>
		}
	}
	
	function modificaComboPosCondicao(args,args2){
		if (args2 != -1){
			var codSelecionado = args.options[args2].value;
			<%java.util.Collection listaPosCondicao = (java.util.Collection) request.getSession().getAttribute("listaPosCondicao");%>
			<%java.util.Iterator itera = listaPosCondicao.iterator();
			while (itera.hasNext()){
				TransicaoTO element = (TransicaoTO) itera.next();%>
				if (codSelecionado == <%=element.getPosCondicaoId()%>){
					document.transicaoForm.intensidadePosCondicao.value = "<%=element.getIntensidade()%>";
					document.transicaoForm.interacaoPosCondicao.value = "<%=element.getInteracao()%>";
				}
			<%}%>
		}
	}
	
	function alterarPreCondicao(){
		document.transicaoForm.causa.value = document.transicaoForm.auxPreCondicao.value;
		if (document.transicaoForm.causa.value != ""){
			document.transicaoForm.action="<c:out value="${base}"/>/transicao/manutencao.do?op=alterar&posCondicaoId=0";
			document.transicaoForm.submit();
		}else{
			alert("Selecione uma PreCondicao no quadro a direita.");
		}
	}
	
	function alterarPosCondicao(){
		document.transicaoForm.posCondicao.value = document.transicaoForm.auxPosCondicao.value;
		if (document.transicaoForm.posCondicao.value != ""){
			document.transicaoForm.action="<c:out value="${base}"/>/transicao/manutencao.do?op=alterar&causaId=0";
			document.transicaoForm.submit();
		}else{
			alert("Selecione um PosCondicao no quadro a direita.");
		}
	}
	
</script>

<html:html>
	<html:form action="/transicao/manutencao.do?op=incluir">
		<html:hidden property="idAtividade"/>
		<html:hidden property="auxPosCondicao" value=""/>
		<html:hidden property="auxPreCondicao" value=""/>
		<html:hidden property="nomeAtividade"/>
		<table cellspacing="0" cellpadding="0">
			<tr>
			    <td valign = "center" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="bsc.label.incluircausaposCondicao"/></td>  
			</tr>
			<tr>
				<td colspan="3"></td>
			</tr>
	  		<tr>
	  			<td colspan="3">
	  				</br><bean:message key="bsc.campo.atividade"/>&nbsp;:&nbsp;<b><c:out value="${transicaoForm.nomeAtividade}"/></b>
	  			</td>
	  		</tr>
			<tr>
				<td></br><bean:message key="bsc.campo.preCondicao"/></td>
			</tr>
			<tr>
				<td>
					<html:select property="preCondicaoId" size="2"style="width: 205px;height: 90px;" onclick="selecionaAtividadePreCondicao(this,this.selectedIndex);">
						<logic:present name="listaAtividadePreCondicaoPosCondicao">
							<html:options collection="listaAtividadePreCondicaoPosCondicao" property="id" labelProperty="nome" />
						</logic:present>
					</html:select>
				</td>
				<td align="center">
					<button type="button" onclick="javascript:salvarPreCondicao();" class="botaoPreto" style="vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/adicionar.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.add"/>
					</button>
					</br>
					<button type="button" onclick="javascript:excluirPreCondicao();" class="botaoPreto" style="vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/excluir.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.excluir"/>
					</button>
				</td>
				<td>
					<html:select property="preCondicao" size="2"style="width: 205px;height: 90px;" onchange="modificaComboPreCondicao(this,this.selectedIndex);" onclick="selecionaPreCondicaoExcluir(this,this.selectedIndex);">
						<logic:present name="listaPreCondicao">
							<html:options collection="listaPreCondicao" property="preCondicaoId" labelProperty="nomeAtividade" />
						</logic:present>
					</html:select>
				</td>
			</tr>
			<tr>
				<td align="right"></br>
					<bean:message key="bsc.campo.interacao"/>
					<html:select property="interacaoPreCondicao" style="width:100">
						<html:option value="positivo"><bean:message key="bsc.option.positivo"/></html:option>
						<html:option value="negativo"><bean:message key="bsc.option.negativo"/></html:option>
					</html:select>
				</td>
				<td></td>		
				<td align="right"></br>
					<bean:message key="bsc.campo.intensidade"/>
					<html:select property="intensidadePreCondicao" style="width:100">
						<html:option value="fraco"><bean:message key="bsc.option.fraco"/></html:option>
						<html:option value="medio"><bean:message key="bsc.option.medio"/></html:option>
						<html:option value="forte"><bean:message key="bsc.option.forte"/></html:option>
					</html:select>
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" title="Salvar" onclick="alterarPreCondicao();">
				</td>
			</tr>
		</table>
		</br></br>
		<table border="0" cellspacing="0" cellpadding="0">
			<tr>
				<tr>
					<td></br><bean:message key="bsc.campo.posCondicao"/></td>
				</tr>
				<td>
					<html:select property="posCondicaoId" size="2"style="width: 205px;height: 90px;"  onclick="selecionaAtividadePosCondicao(this,this.selectedIndex);">
						<logic:present name="listaAtividadePreCondicaoPosCondicao">
							<html:options collection="listaAtividadePreCondicaoPosCondicao" property="id" labelProperty="nome" />
						</logic:present>
					</html:select>
				</td>
				<td align="center">
					<button type="button" onclick="javascript:salvarPosCondicao();" class="botaoPreto" style="vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/adicionar.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.add"/>
					</button>
					</br>
					<button type="button" onclick="javascript:excluirPosCondicao();" class="botaoPreto" style="vertical-align: middle;">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/excluir.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.excluir"/>
					</button>
				</td>
				<td>
					<html:select property="posCondicao" size="2"style="width: 205px;height: 90px;" onchange="modificaComboPosCondicao(this,this.selectedIndex);" onclick="selecionaPosCondicaoExcluir(this,this.selectedIndex);">
						<logic:present name="listaPosCondicao">
							<html:options collection="listaPosCondicao" property="posCondicaoId" labelProperty="nomeAtividade" />
						</logic:present>
					</html:select>
				</td>
			</tr>
			<tr>
				<td align="right"></br>
					<bean:message key="bsc.campo.interacao"/>
					<html:select property="interacaoPosCondicao" style="width:100">
						<html:option value="positivo"><bean:message key="bsc.option.positivo"/></html:option>
						<html:option value="negativo"><bean:message key="bsc.option.negativo"/></html:option>
					</html:select>
				</td>
				<td></td>	
				<td align="right"></br>
					<bean:message key="bsc.campo.intensidade"/>
					<html:select property="intensidadePosCondicao" style="width:100">
						<html:option value="fraco"><bean:message key="bsc.option.fraco"/></html:option>
						<html:option value="medio"><bean:message key="bsc.option.medio"/></html:option>
						<html:option value="forte"><bean:message key="bsc.option.forte"/></html:option>
					</html:select>
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" title="Salvar" onclick="alterarPosCondicao()">
				</td>
			</tr>
		</table>		
	</html:form>
</html:html>