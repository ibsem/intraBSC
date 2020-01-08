<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/c" prefix="c" %>
<%@ page import="br.com.intraBSC.modelo.CausaEfeitoTO"%>

<script language = "JavaScript">
	function selecionaObjetivoCausa(args,args2){
		if (args2 != -1){
			document.causaEfeitoForm.causaId.value = args.options[args2].value;
			document.causaEfeitoForm.efeitoId.selected.value = "";
		}
	}
	function selecionaCausaExcluir(args,args2){
		if (args2 != -1){
			document.causaEfeitoForm.causaId.value = args.options[args2].value;
			document.causaEfeitoForm.auxCausa.value = args.options[args2].value;
		}
	}
	function selecionaObjetivoEfeito(args,args2){
		if (args2 != -1)
			document.causaEfeitoForm.efeitoId.value = args.options[args2].value;
	}
	function selecionaEfeitoExcluir(args,args2){
		if (args2 != -1){
			document.causaEfeitoForm.efeitoId.value = args.options[args2].value;
			document.causaEfeitoForm.auxEfeito.value = args.options[args2].value;
		}
	}
	
	function salvarCausa(){
		if (document.causaEfeitoForm.causaId.value != ""){
			if (document.causaEfeitoForm.causaId.value != document.causaEfeitoForm.idObjetivo.value){
				document.causaEfeitoForm.efeitoId.value = document.causaEfeitoForm.idObjetivo.value;
				document.causaEfeitoForm.action="<c:out value="${base}"/>/causaEfeito/manutencao.do?op=incluir&efeitoId=0"
				document.causaEfeitoForm.submit();
			}else{
				alert("Opcao invalida.");
			}
		}else{
			alert("Selecione um Objetivo.");
		}
	}	
	function salvarEfeito(){
		if (document.causaEfeitoForm.efeitoId.value != ""){
			if (document.causaEfeitoForm.efeitoId.value != document.causaEfeitoForm.idObjetivo.value){
				document.causaEfeitoForm.causaId.value = document.causaEfeitoForm.idObjetivo.value;	
				document.causaEfeitoForm.action="<c:out value="${base}"/>/causaEfeito/manutencao.do?op=incluir&causaId=0"
				document.causaEfeitoForm.submit();
			}else{
				alert("Opcao invalida.");
			}
		}else{
			alert("Selecione um Objetivo.")
		}
	}
	
	function excluirCausa(){
		if (document.causaEfeitoForm.auxEfeito.value != ""){
			document.causaEfeitoForm.action="<c:out value="${base}"/>/causaEfeito/manutencao.do?op=excluir&efeitoId=0"
			document.causaEfeitoForm.submit();
		}else{
			alert("Selecione um Causa.")
		}
	}
	function excluirEfeito(){
		if (document.causaEfeitoForm.auxEfeito.value != ""){
			document.causaEfeitoForm.action="<c:out value="${base}"/>/causaEfeito/manutencao.do?op=excluir&causaId=0"
			document.causaEfeitoForm.submit();		
		}else{
			alert("Selecione um Efeito.")
		}
	}
	
	function modificaComboCausa(args,args2){
		if (args2 != -1){
			var codSelecionado = args.options[args2].value;
			<%java.util.Collection listaCausa = (java.util.Collection) request.getSession().getAttribute("listaCausa");%>
			<%java.util.Iterator iter = listaCausa.iterator();
			while (iter.hasNext()){
				CausaEfeitoTO element = (CausaEfeitoTO) iter.next();%>
				if (codSelecionado == <%=element.getCausaId()%>){
					document.causaEfeitoForm.intensidadeCausa.value = "<%=element.getIntensidade()%>";
					document.causaEfeitoForm.interacaoCausa.value = "<%=element.getInteracao()%>";
				}
			<%}%>
		}
	}
	
	function modificaComboEfeito(args,args2){
		if (args2 != -1){
			var codSelecionado = args.options[args2].value;
			<%java.util.Collection listaEfeito = (java.util.Collection) request.getSession().getAttribute("listaEfeito");%>
			<%java.util.Iterator itera = listaEfeito.iterator();
			while (itera.hasNext()){
				CausaEfeitoTO element = (CausaEfeitoTO) itera.next();%>
				if (codSelecionado == <%=element.getEfeitoId()%>){
					document.causaEfeitoForm.intensidadeEfeito.value = "<%=element.getIntensidade()%>";
					document.causaEfeitoForm.interacaoEfeito.value = "<%=element.getInteracao()%>";
				}
			<%}%>
		}
	}
	
	function alterarCausa(){
		document.causaEfeitoForm.causa.value = document.causaEfeitoForm.auxCausa.value;
		if (document.causaEfeitoForm.causa.value != ""){
			document.causaEfeitoForm.action="<c:out value="${base}"/>/causaEfeito/manutencao.do?op=alterar&efeitoId=0";
			document.causaEfeitoForm.submit();
		}else{
			alert("Selecione uma Causa no quadro a direita.");
		}
	}
	
	function alterarEfeito(){
		document.causaEfeitoForm.efeito.value = document.causaEfeitoForm.auxEfeito.value;
		if (document.causaEfeitoForm.efeito.value != ""){
			document.causaEfeitoForm.action="<c:out value="${base}"/>/causaEfeito/manutencao.do?op=alterar&causaId=0";
			document.causaEfeitoForm.submit();
		}else{
			alert("Selecione um Efeito no quadro a direita.");
		}
	}
	
</script>

<html:html>
	<html:form action="/causaEfeito/manutencao.do?op=incluir">
		<html:hidden property="idObjetivo"/>
		<html:hidden property="auxEfeito" value=""/>
		<html:hidden property="auxCausa" value=""/>
		<html:hidden property="nomeObjetivo"/>
		<table cellspacing="0" cellpadding="0">
			<tr>
			    <td valign = "center" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="bsc.label.incluircausaefeito"/></td>  
			</tr>
			<tr>
				<td colspan="3"></td>
			</tr>
	  		<tr>
	  			<td colspan="3">
	  				</br><bean:message key="bsc.campo.objetivo"/>&nbsp;:&nbsp;<b><c:out value="${causaEfeitoForm.nomeObjetivo}"/></b>
	  			</td>
	  		</tr>
			<tr>
				<td></br><bean:message key="bsc.campo.causa"/></td>
			</tr>
			<tr>
				<td>
					<html:select property="causaId" size="2" style="width: 205px;height: 90px;" onclick="selecionaObjetivoCausa(this,this.selectedIndex);">
						<logic:present name="listaObjetivoCausaEfeito">
							<html:options collection="listaObjetivoCausaEfeito" property="id" labelProperty="nome" />
						</logic:present>
					</html:select>
				</td>
				<td align="center">
					<button type="button" onclick="javascript:salvarCausa();" class="botaoPreto" style="vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/adicionar.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.add"/>
					</button>
					</br>
					<button type="button" onclick="javascript:excluirCausa();" class="botaoPreto" style="vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/excluir.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.excluir"/>
					</button>
				</td>
				<td>
					<html:select property="causa" size="2" style="width: 205px;height: 90px;" onchange="modificaComboCausa(this,this.selectedIndex);" onclick="selecionaCausaExcluir(this,this.selectedIndex);">
						<logic:present name="listaCausa">
							<html:options collection="listaCausa" property="causaId" labelProperty="nomeObjetivo" />
						</logic:present>
					</html:select>
				</td>
			</tr>
			<tr>
				<td align="right"></br>
					<bean:message key="bsc.campo.interacao"/>
					<html:select property="interacaoCausa" style="width:100">
						<html:option value="positivo"><bean:message key="bsc.option.positivo"/></html:option>
						<html:option value="negativo"><bean:message key="bsc.option.negativo"/></html:option>
					</html:select>
				</td>
				<td></td>		
				<td align="right"></br>
					<bean:message key="bsc.campo.intensidade"/>
					<html:select property="intensidadeCausa" style="width:100">
						<html:option value="fraco"><bean:message key="bsc.option.fraco"/></html:option>
						<html:option value="medio"><bean:message key="bsc.option.medio"/></html:option>
						<html:option value="forte"><bean:message key="bsc.option.forte"/></html:option>
					</html:select>
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" title="Salvar" onclick="alterarCausa();">
				</td>
			</tr>
		</table>
		</br></br>
		<table border="0" cellspacing="0" cellpadding="0">
			<tr>
				<tr>
					<td></br><bean:message key="bsc.campo.efeito"/></td>
				</tr>
				<td>
					<html:select property="efeitoId" size="2" style="width: 205px;height: 90px;"  onclick="selecionaObjetivoEfeito(this,this.selectedIndex);">
						<logic:present name="listaObjetivoCausaEfeito">
							<html:options collection="listaObjetivoCausaEfeito" property="id" labelProperty="nome" />
						</logic:present>
					</html:select>
				</td>
				<td align="center">
					<button type="button" onclick="javascript:salvarEfeito();" class="botaoPreto" style="vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/adicionar.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.add"/>
					</button>
					</br>
					<button type="button" onclick="javascript:excluirEfeito();" class="botaoPreto" style="vertical-align: middle;">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/excluir.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.excluir"/>
					</button>
				</td>
				<td>
					<html:select property="efeito" size="2" style="width: 205px;height: 90px;" onchange="modificaComboEfeito(this,this.selectedIndex);" onclick="selecionaEfeitoExcluir(this,this.selectedIndex);">
						<logic:present name="listaEfeito">
							<html:options collection="listaEfeito" property="efeitoId" labelProperty="nomeObjetivo" />
						</logic:present>
					</html:select>
				</td>
			</tr>
			<tr>
				<td align="right"></br>
					<bean:message key="bsc.campo.interacao"/>
					<html:select property="interacaoEfeito" style="width:100">
						<html:option value="positivo"><bean:message key="bsc.option.positivo"/></html:option>
						<html:option value="negativo"><bean:message key="bsc.option.negativo"/></html:option>
					</html:select>
				</td>
				<td></td>	
				<td align="right"></br>
					<bean:message key="bsc.campo.intensidade"/>
					<html:select property="intensidadeEfeito" style="width:100">
						<html:option value="fraco"><bean:message key="bsc.option.fraco"/></html:option>
						<html:option value="medio"><bean:message key="bsc.option.medio"/></html:option>
						<html:option value="forte"><bean:message key="bsc.option.forte"/></html:option>
					</html:select>
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" title="Salvar" onclick="alterarEfeito()">
				</td>
			</tr>
		</table>		
	</html:form>
</html:html>