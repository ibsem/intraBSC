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
	function alterarMapa(codMapa,nomeMapa){
		window.location="<c:out value="${base}"/>/mapaEstrategico/abrir.do?op=consultarArvoreConfiguracao&codMapa="+codMapa+"&nomeMapa="+nomeMapa;
	}
	function abrirDetalhado(codMapa){
		window.location="<c:out value="${base}"/>/mapaEstrategico/detalhar.do?op=mapaUsuarioRelatorioDetalha&codMapaEstrategico="+codMapa;
	}
	function abrirDesempenho(codMapa){
		window.location="<c:out value="${base}"/>/mapaEstrategico/detalhar.do?op=mapaDesempenho&codMapaEstrategico="+codMapa;
	}
	function abrirDesempenhoNoMes(codMapa){
		window.location="<c:out value="${base}"/>/mapaEstrategico/detalhar.do?op=mapaDesempenhoNoMes&codMapaEstrategico="+codMapa;
	}
	function abrirCross(){
		window.location="<c:out value="${base}"/>/mapaEstrategico/detalhar.do?op=relatorioMapaCrossTable";
	}
	function abrirAcoes(codMapa){
		window.location="<c:out value="${base}"/>/mapaEstrategico/detalhar.do?op=relatorioMapaAcoes&codMapaEstrategico="+codMapa;
	}
	function abrirCronograma(){
		window.location="<c:out value="${base}"/>/mapaEstrategico/detalhar.do?op=relatorioMapaCronograma";
	}
	function abrirGrafico(){
		window.location="<c:out value="${base}"/>/mapaEstrategico/detalhar.do?op=relatorioMapaGrafico";
	}
</script>

<html>
	<form name="relatorio">
		<table width="288px" border="0" cellpadding="0" cellspacing="0" >
			<tr>
				
				<td  align="center">
				<button style="width: 32px; height: 32px;" type="button"
						 onclick="abrirDetalhado(<%=request.getSession().getAttribute("codMapaSelecionado")%>);"
						 onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/mapaDetalhadoSobre.gif'"
						 onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/mapaDetalhado.gif'"
						 Title="Mapa Detalhado">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/mapaDetalhado.gif"
						 border="0" Title="Mapa Detalhado"/>
				</button>
				</td>
				<td  align="center" >
				<button style="width: 32px; height: 32px;" type="button"
						 onclick="abrirCross();"
						 onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/mapaDescritivoSobre.gif'"
						 onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/mapaDescritivo.gif'"
						 Title="Descritivo do Mapa">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/mapaDescritivo.gif"
						 border="0" Title="Descritivo do Mapa"/>
				
				</button>
				</td>
								<td  align="center">
				<button style="width: 32px; height: 32px;" type="button"
						 onclick="abrirDesempenho(<%=request.getSession().getAttribute("codMapaSelecionado")%>);"
						 onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/mapaDesempenhoSobre.gif'"
						 onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/mapaDesempenho.gif'"
						 Title="Mapa Desempenho">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/mapaDesempenho.gif"
						 border="0" Title="Mapa Desempenho"/>
				</button>
				</td>				<td  align="center">
				<button style="width: 32px; height: 32px;" type="button"
						 onclick="abrirDesempenhoNoMes(<%=request.getSession().getAttribute("codMapaSelecionado")%>);"
						 onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/mapaDesempenhoNoMesSobre.gif'"
						 onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/mapadesempenhoNoMes.gif'"
						 Title="Mapa Desempenho no Mês">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/mapaDesempenhoNoMes.gif"
						 border="0" Title="Mapa Desempenho no Mês"/>
				</button>
				</td>
				<td align="center" >
				<button style="width: 32px; height: 32px;" type="button"
				onclick="abrirAcoes(<%=request.getSession().getAttribute("codMapaSelecionado")%>);"
						 onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/mapaAcoesSobre.gif'"
						 onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/mapaAcoes.gif'"
						 Title="Plano de Ações">
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/mapaAcoes.gif"
						 
						 border="0" Title="Plano de Ações"/>
				</button>
				</td>
				<td align="center" >
				<button style="width: 32px; height: 32px;" type="button"
						 onclick="abrirCronograma();"
						 onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/mapaCronogramaSobre.gif'"
						 onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/mapaCronograma.gif'"
						 Title="Cronograma" >
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/mapaCronograma.gif"
						 border="0" Title="Cronograma"/>
				</button>
				</td>
				<td align="center" >
				<button style="width: 32px; height: 32px;" type="button"
						 onclick="abrirGrafico();"
						 onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/mapaGraficoSobre.gif'"
						 onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/mapaGrafico.gif'"
						 Title="Mapa Gráfico" >
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/mapaGrafico.gif"
						 border="0" Title="Mapa Gráfico"/>
				</button>
				</td>
				<td align="center" >
				<button style="width: 32px; height: 32px;" type="button"
						onclick="alterarMapa(<%=request.getSession().getAttribute("codMapaSelecionado")%>,<%=request.getSession().getAttribute("codMapaSelecionado").toString()%>);"
						onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/alterarMapaSobre.gif'" 
						onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/alterarMapa.gif'"
					title="Alterar Mapa" >
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/alterarMapa.gif"
					border="0" Title="Alterar Mapa"/>
				</button>
				</td>
				<td width="" align="right">
				<button type="button" onclick="javascript:history.back();" class="botaoPreto" style="vertical-align: middle; width:32px; height: 32px;padding: 2px;">
				<img align="bottom" src="<c:out value="${base}"/>/WEB/imagens/comum/voltar.gif" border="0" align="middle" style="vertical-align: middle">
				
			</button>
		</td>
			</tr>
		</table>
	</form>
</html>