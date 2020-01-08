<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/displaytag" prefix="displaytag"%>
<%@ taglib uri="/tags/c" prefix="c" %>
<%@ taglib uri="/tags/fmt" prefix="fmt" %>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Collection"%>
<%@ page import="br.com.intraBSC.modelo.IndicadorTO"%>

<script language="JavaScript">
	function visualizarIndicador(codMapa,codPerspectiva,codIndicador){
		window.location="<c:out value="${base}"/>/indicador/detalhar.do?op=indicadorRelatorioDetalha&codMapa="+codMapa+"&codPerspectiva="+codPerspectiva+"&codIndicador="+codIndicador;
	}
	function incluirTarefa(codMapa,codPerspectiva,codObjetivo,codIndicador){
	    window.location="<c:out value="${base}"/>/tarefa/encaminhar/incluir.do?op=encaminharInclusaoMapa&codMapa="+codMapa+"&codPerspectiva="+codPerspectiva+"&codObjetivo="+codObjetivo+"&codIndicador="+codIndicador;	
	}
	function alterarIndicador(codIndicador,itemSelecionado){
		window.location="<c:out value="${base}"/>/indicador/encaminha.do?op=encaminharAlterar&codIndicador="+codIndicador+"&itemSelecionado="+itemSelecionado;
	}
	function incluirIndicador(codMapa){
		window.location="<c:out value="${base}"/>/indicador/encaminha.do?op=encaminharIncluir&codMapa="+codMapa;
	}
	function valorIndicador(codMapa){
		window.location="<c:out value="${base}"/>/indicadorFato/manutencao.do?op=encaminharListarIndicadorFato&codMapa="+codMapa;
	}
</script>
	<html:hidden property="op" value="consultarIndicadorUsuario"/>
	
	
	<%Collection lista =(Collection)request.getSession().getAttribute("listaIndicador");%>
	<% request.setAttribute("listaFinal", request.getSession().getAttribute("listaIndicador"));%>
		<%if (lista.size() > 0){%>
			<table border="0" cellspacing="0" cellpadding="0" width="715px">
			<tr>
			    <td align = "left" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="bsc.report.meusindicadores"/></td>  
			</tr>
			</table>
			<table border="0" cellspacing="0" cellpadding="0" width="715px">
			<tr >
			<td>
			<displaytag:table id="tabela" name="listaFinal"   
				class="its" requestURI="" 
			 	scope="request" pagesize="15" 
			 	style="border:none;border-color:black;width:715px">
				<displaytag:column  style="width:16px;align:right;" >
						<c:if test="${tabela.sinal == -1 and tabela.limiteInferior != 0 and tabela.limiteSuperior != 0 }">
						<img src="<c:out value="${base}"/>/WEB/imagens/relatorio/velocimetroAmarelo.gif"
						 border="0" />
						</c:if>
						<c:if test="${tabela.sinal == 0 and tabela.inversaoLimite == 2}">
						<img src="<c:out value="${base}"/>/WEB/imagens/relatorio/velocimetroVermelho.gif"
						 border="0" />
						</c:if>
						<c:if test="${tabela.sinal == 1 and tabela.inversaoLimite == 2}">
						<img src="<c:out value="${base}"/>/WEB/imagens/relatorio/velocimetroVerde.gif"
						 border="0" />
						</c:if> 
						<c:if test="${tabela.sinal == 0 and tabela.inversaoLimite == 1}">
						<img src="<c:out value="${base}"/>/WEB/imagens/relatorio/velocimetroVerde.gif"
						 border="0" />
						</c:if>
						<c:if test="${tabela.sinal == 1 and tabela.inversaoLimite == 1}">
						<img src="<c:out value="${base}"/>/WEB/imagens/relatorio/velocimetroVermelho.gif"
						 border="0" />
						</c:if>
				</displaytag:column>
				<displaytag:column style="width:300px;align:left;" title="">
							<a href="#" onclick="visualizarIndicador(<c:out value='${tabela.idMapa}'/>,<c:out value='${tabela.idPerspectiva}'/>,<c:out value='${tabela.id}'/>)" 
							title="Visualizar Indicador">
								<c:out value="${tabela.nome}"/>
							</a>
				</displaytag:column>
				
				
				<displaytag:column style="width:70px;text-align:center;" title="">
							<a href="#" onclick="visualizarIndicador(<c:out value='${tabela.idMapa}'/>,<c:out value='${tabela.idPerspectiva}'/>,<c:out value='${tabela.id}'/>)" 
							align="right" title="Data do Cadastro">
								<c:out value="${tabela.ultimaData}"/>
							</a>
				</displaytag:column>
				<displaytag:column style="width:70px;text-align:right;" title="">
							<a href="#" onclick="visualizarIndicador(<c:out value='${tabela.idMapa}'/>,<c:out value='${tabela.idPerspectiva}'/>,<c:out value='${tabela.id}'/>)" 
							align="right" title="Último Valor Cadastrado">
								<c:out value="${tabela.ultimoValor}"/>
							</a>
				</displaytag:column>
				<displaytag:column style="width:65px;text-align:center;" title="">
							<a href="#" onclick="visualizarIndicador(<c:out value='${tabela.idMapa}'/>,<c:out value='${tabela.idPerspectiva}'/>,<c:out value='${tabela.id}'/>)" 
							 title="Unidade de medida">
							<c:out value="${tabela.nomeUnidade}"/>
							</a>
				</displaytag:column>
								
				<displaytag:column  style="width:24px;align:center;" >
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/incluirIndicador.gif"
						onclick="incluirIndicador('<c:out value='${tabela.idMapa}'/>');"
						 onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/incluirIndicadorSobre.gif'" 
						 onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/incluirIndicador.gif'"
						  border="0" Title="Incluir Indicador"/>
				</displaytag:column>
				<displaytag:column  style="width:24px;align:center;" >
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/alterarIndicador.gif"
						onclick="alterarIndicador(<c:out value='${tabela.id}'/>,<c:out value='${tabela.id}'/>);"
						onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/alterarIndicadorSobre.gif'" 
						onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/alterarIndicador.gif'"
						border="0" Title="Alterar Indicador"/>
				</displaytag:column>
				<displaytag:column  style="width:27px;align:left;" >
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/valorIndicador.gif"
						onclick="valorIndicador(<c:out value='${tabela.idMapa}'/>);"
						onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/valorIndicadorSobre.gif'" 
						onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/valorIndicador.gif'" 
						 border="0" Title="Valores para o Indicador"/>
				</displaytag:column>
				<displaytag:column  style="width:27px;align:left;" >
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/incluirTarefa.gif"
						onclick="incluirTarefa(<c:out value='${tabela.idMapa}'/>,<c:out value='${tabela.idPerspectiva}'/>,<c:out value='${tabela.idObjetivo}'/>,<c:out value='${tabela.id}'/>);"
						onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/incluirTarefaSobre.gif'" 
						onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/incluirTarefa.gif'" 
						 border="0" Title="Incluir Tarefa para o Indicador"/>
				</displaytag:column>				
			</displaytag:table>
			</td>
		</tr>
	</table>

	<%} else {%>
		<span style="color: blue;font-weight:bold;position:absolute;overflow:auto;top:100px;left:100px">
			<bean:message key="msg.mapaEstrategico.usuarioSemIndicador"/>
		</span>
	<%}%>