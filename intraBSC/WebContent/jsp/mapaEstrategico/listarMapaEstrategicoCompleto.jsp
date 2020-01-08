<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag"%>
<%@ taglib uri="/tags/c" prefix="c" %>
<%@ taglib uri="/tags/fmt" prefix="fmt" %>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Collection"%>
<%@ page import="br.com.intraBSC.modelo.MapaEstrategicoTO"%>


<script language="JavaScript">
	function abrirMapa(codMapa){
		window.location="<c:out value="${base}"/>/mapaEstrategico/detalhar.do?op=mapaUsuarioRelatorioDetalha&codMapaEstrategico="+codMapa;
	}
	function alterarMapa(codMapa,nomeMapa){
		window.location="<c:out value="${base}"/>/mapaEstrategico/abrir.do?op=consultarArvoreConfiguracao&codMapa="+codMapa+"&nomeMapa="+nomeMapa;
	}
	
	function exportarMapa(id) {
		window.location="<c:out value="${base}"/>/mapaEstrategico/exportar.do?op=exportarXml&id="+id;
	}
</script>

	<html:hidden property="op" value="consultarVarios"/>
		<%Collection lista =(Collection)request.getSession().getAttribute("listaMapaEstrategico");%>
		<% request.setAttribute("listaMapa", request.getSession().getAttribute("listaMapaEstrategico"));%>
		<%if (lista != null){%>
					
			<table border="0" width="515px">
			<tr >
			    <td align = "left" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="bsc.label.mapas"/></td>  
			</tr>
						
			</table>
			<table border="0" cellspacing="0" cellpadding="0" width="515px">
			<tr>
			<td>
			<displaytag:table id="tabela" name="listaMapa"    
				class="its" requestURI="" 
			 	scope="request" pagesize="20" 
			 	style="width:515px">
			<c:if test="${tabela.ativo == 1}">
				<displaytag:column  style="width:16px;align:right;" >
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/mapaDetalhado.gif"
						 border="0" Title="Mapa Detalhado"/>
				</displaytag:column>
				<displaytag:column style="width:405px;align:left;" title="">
							<a href="#" onclick="abrirMapa(<c:out value='${tabela.id}' />)" title="Visualizar Mapa">
								<c:out value="${tabela.nome}"/>
							</a>
				</displaytag:column>

				<displaytag:column  style="width:24px;align:center;" >
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/alterarMapa.gif"
						onclick="alterarMapa(<c:out value='${tabela.id}'/>,'<c:out value='${tabela.nome}'/>');"
						onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/alterarMapaSobre.gif'" 
						onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/alterarMapa.gif'"
						border="0" Title="Alterar Mapa"/>
				</displaytag:column>
				<displaytag:column  style="width:23px;align:left;" >
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/exportarMapa.gif"
						onclick="exportarMapa(<c:out value='${tabela.id}'/>);"
						onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/exportarMapaSobre.gif'" 
						onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/exportarMapa.gif'"
						border="0" Title="Exportar Mapa"/>
				</displaytag:column>
			</c:if>
			</displaytag:table>
			</td>
			</tr>
			</table>
			<%} else {%>
		<span style="color: blue;font-weight:bold;position:absolute;overflow:auto;top:100px;left:100px">
			<bean:message key="bsc.mapaEstrategico.vazio"/>
		</span>
			<%}%>