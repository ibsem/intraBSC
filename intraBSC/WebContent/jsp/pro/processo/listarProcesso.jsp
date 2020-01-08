<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag"%>
<%@ taglib uri="/tags/c" prefix="c" %>
<%@ taglib uri="/tags/fmt" prefix="fmt" %>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Collection"%>
<%@ page import="br.com.intraPRO.modelo.ProcessoTO"%>

<script language="JavaScript">
	function abrirProcesso(codProcesso){
		window.location="<c:out value="${base}"/>/processo/detalhar.do?op=processoUsuarioRelatorioDetalha&codProcesso="+codProcesso;
	}
	function alterarProcesso(codProcesso,nomeProcesso){
		window.location="<c:out value="${base}"/>/processo/abrir.do?op=consultarArvoreConfiguracao&codProcesso="+codProcesso+"&nomeProcesso="+nomeProcesso;
	}
	function incluirProcesso(){
		window.location="<c:out value="${base}"/>/processo/encaminha/incluir.do?op=encaminhaIncluir";
	}
	function exportarProcesso(id) {
		window.location="<c:out value="${base}"/>/processo/exportar.do?op=exportarXml&id="+id;
	}
</script>

	<html:hidden property="op" value="consultarVarios"/>
		<%Collection lista =(Collection)request.getSession().getAttribute("listaProcesso");%>
		<% request.setAttribute("listaProcesso", request.getSession().getAttribute("listaProcesso"));%>
		<%if (lista != null){%>
					
			<table border="0" width="515px">
			<tr >
			    <td align = "left" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="bsc.label.processos"/></td>  
			</tr>
						
			</table>
			<table border="0" cellspacing="0" cellpadding="0" width="515px">
			<tr>
			<td>
			<displaytag:table id="tabela" name="listaProcesso"    
				class="its" requestURI="" 
			 	scope="request" pagesize="5" 
			 	style="width:515px">
			<c:if test="${tabela.ativo == 1}">
				<displaytag:column  style="width:16px;align:right;" >
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/processoDetalhado.gif"
						 border="0" Title="Processo Detalhado"/>
				</displaytag:column>
				<displaytag:column style="width:405px;align:left;" title="">
							<a href="#" onclick="abrirProcesso(<c:out value='${tabela.id}' />)" title="Visualizar Processo">
								<c:out value="${tabela.nome}"/>
							</a>
				</displaytag:column>
				<displaytag:column  style="width:24px;align:center;" >
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/incluirProcesso.gif"
						onclick="incluirProcesso(<c:out value='${tabela.id}'/>,'<c:out value='${tabela.nome}'/>');"
						 onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/incluirProcessoSobre.gif'" 
						 onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/incluirProcesso.gif'"
						  border="0" Title="Incluir Processo"/>
				</displaytag:column>
				<displaytag:column  style="width:24px;align:center;" >
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/alterarProcesso.gif"
						onclick="alterarProcesso(<c:out value='${tabela.id}'/>,'<c:out value='${tabela.nome}'/>');"
						onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/alterarProcessoSobre.gif'" 
						onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/alterarProcesso.gif'"
						border="0" Title="Alterar Processo"/>
				</displaytag:column>
				<displaytag:column  style="width:24px;align:left;" >
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/importarProcesso.gif"
						onclick="importarProcesso(<c:out value='${tabela.id}'/>,'<c:out value='${tabela.nome}'/>');"
						onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/importarProcessoSobre.gif'" 
						onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/importarProcesso.gif'" 
						 border="0" Title="Importar Processo"/>
				</displaytag:column>
				<displaytag:column  style="width:23px;align:left;" >
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/exportarProcesso.gif"
						onclick="exportarProcesso(<c:out value='${tabela.id}'/>);"
						onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/exportarProcessoSobre.gif'" 
						onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/exportarProcesso.gif'"
						border="0" Title="Exportar Processo"/>
				</displaytag:column>
			</c:if>
			</displaytag:table>
			</td>
			</tr>
			</table>
			<%} else {%>
		<span style="color: blue;font-weight:bold;position:absolute;overflow:auto;top:100px;left:100px">
			<bean:message key="bsc.processo.vazio"/>
		</span>
		<%}%>