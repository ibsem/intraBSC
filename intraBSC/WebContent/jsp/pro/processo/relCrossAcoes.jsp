<%@ taglib uri="/tags/c" prefix="c" %>
<c:if test="${empty applicationScope.base}">
	<c:choose>
		<c:when test="${pageContext.request.contextPath eq '/'}">
			<c:set var="base" value="" scope="application" />
		</c:when>
		<c:otherwise>
			<c:set var="base" value="${pageContext.request.contextPath}" scope="application" />
		</c:otherwise>
	</c:choose>
</c:if>
<script language="JavaScript">
	function alterarProcesso(codProcesso,nomeProcesso){
		window.location="<c:out value="${base}"/>/processo/abrir.do?op=consultarArvoreConfiguracao&codProcesso="+codProcesso+"&nomeProcesso="+nomeProcesso;
	}
	function abrirDetalhado(codProcesso){
		window.location="<c:out value="${base}"/>/processo/detalhar.do?op=processoUsuarioRelatorioDetalha&codProcesso="+codProcesso;
	}
	function abrirCross(){
		window.location="<c:out value="${base}"/>/processo/detalhar.do?op=relatorioProcessoCrossTable";
	}
	function abrirAcoes(){
		window.location="<c:out value="${base}"/>/processo/detalhar.do?op=relatorioProcessoAcoes";
	}
	function abrirCronograma(){
		window.location="<c:out value="${base}"/>/processo/detalhar.do?op=relatorioProcessoCronograma";
	}
	function abrirGrafico(){
		window.location="<c:out value="${base}"/>/processo/detalhar.do?op=relatorioProcessoGrafico";
	}
</script>

<html>
	<form name="relatorio">
		<table width="80px" border="0">
			<tr>
				
				<td  align="center" width="16px">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/processoDetalhado.gif"
						 onclick="abrirDetalhado(<%=request.getSession().getAttribute("codProcessoSelecionado")%>);"
						 onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/processoDetalhadoSobre.gif'"
						 onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/processoDetalhado.gif'"
						 border="0" Title="Processo Detalhado"/>
				</td>
				<td  align="center" width="16px">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/processoDescritivo.gif"
						 onclick="abrirCross();"
						 onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/processoDescritivoSobre.gif'"
						 onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/processoDescritivo.gif'"
						 border="0" Title="Descritivo do Processo"/>
				</td>
				<td align="center" width="16px">
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/processoAcoes.gif"
						 onclick="abrirAcoes();"
						 onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/processoAcoesSobre.gif'"
						 onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/processoAcoes.gif'"
						 border="0" Title="Plano de Ações"/>
				</td>
				<td align="center" width="16px">
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/processoCronograma.gif"
						 onclick="abrirCronograma();"
						 onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/processoCronogramaSobre.gif'"
						 onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/processoCronograma.gif'"
						 border="0" Title="Cronograma"/>
				</td>
				<td align="center" width="16px">
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/processoGrafico.gif"
						 onclick="abrirGrafico();"
						 onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/processoGraficoSobre.gif'"
						 onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/processoGrafico.gif'"
						 border="0" Title="Processo Gráfico"/>
				</td>
				<td align="center" width="24px">
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/alterarProcesso.gif"
					onclick="alterarProcesso(<%=request.getSession().getAttribute("codProcessoSelecionado")%>,<%=request.getSession().getAttribute("codProcessoSelecionado").toString()%>);"
					onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/alterarProcessoSobre.gif'" 
					onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/alterarProcesso.gif'"
					border="0" Title="Alterar Processo"/>
				
				</td>
			</tr>
		</table>
	</form>
</html>