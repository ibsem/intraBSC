<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<%@ taglib uri="/tags/struts-html" prefix="html" %>
	<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
	<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
	<%@ taglib uri="/tags/c" prefix="c"%>
		<script language="JavaScript" type="text/javascript">
			// Dojo configuration
			djConfig = { 
				isDebug: true
			};
	function abrirDetalhado(codMapa){
		window.location="<c:out value="${base}"/>/mapaEstrategico/detalhar.do?op=mapaUsuarioRelatorioDetalha&codMapaEstrategico="+codMapa;
	}
	function abrirAcoes(codMapa){
		window.location="<c:out value="${base}"/>/mapaEstrategico/detalhar.do?op=relatorioMapaAcoes&codMapaEstrategico="+codMapa;
	}
	function incluirPerspectiva(){
		window.location="<c:out value="${base}"/>/perspectiva/encaminha.do?op=encaminhaIncluir";
	}
	function incluirObjetivo(){
		window.location="<c:out value="${base}"/>/objetivo/encaminha.do?op=encaminharIncluir";
	}
	function incluirTema(){
		window.location="<c:out value="${base}"/>/tema/encaminha.do?op=encaminharIncluir";
	}
	function alterarTema(){
		window.location="<c:out value="${base}"/>/tema/consultarVarios.do?op=encaminharConsultar";
	}
	function incluirIndicador(){
		window.location="<c:out value="${base}"/>/indicador/encaminha.do?op=encaminharIncluir";
	}
	function valorIndicador(){
		window.location="<c:out value="${base}"/>/indicadorFato/manutencao.do?op=encaminharListarIndicadorFato&codMapa=0";
	}
			
	</script>
	<script type="text/javascript" src="<c:out value="${base}"/>/WEB/js/dojo.js"></script>
	<script type="text/javascript" src="<c:out value="${base}"/>/WEB/js/html.js"></script>
	<script type="text/javascript" src="<c:out value="${base}"/>/WEB/js/prototype.js"></script>
	<script type="text/javascript" src="<c:out value="${base}"/>/WEB/js/effects.js"></script>
	<script type="text/javascript" src="<c:out value="${base}"/>/WEB/js/dragdrop.js"></script>
	<link rel="stylesheet" type="text/css" href="<c:out value="${base}"/>/WEB/css/menu.css" />
	
	<script type="text/javascript">
		
		dojo.require("dojo.lfx.*");
	
		function testExplode(start,item){
			if (item == 1) {
				dojo.lfx.implode("explodeacao", start, 10).play();
				dojo.lfx.implode("explodeconfig", start, 10).play();
				dojo.lfx.explode(start, "explodeitem", 250).play();
				dojo.lfx.implode("explodegrupo", start, 10).play();
				dojo.lfx.implode("explodeusuario", start, 10).play();
				dojo.lfx.implode("explodetema", start, 10).play();
			}else if (item == 2){
				dojo.lfx.implode("explodeitem", start, 10).play();
				dojo.lfx.implode("explodeconfig", start, 10).play();
				dojo.lfx.explode(start, "explodeacao", 250).play();
				dojo.lfx.implode("explodegrupo", start, 10).play();
				dojo.lfx.implode("explodetema", start, 10).play();
				dojo.lfx.implode("explodeusuario", start, 10).play();
			}else if (item == 4){
				dojo.lfx.implode("explodeitem", start, 10).play();
				dojo.lfx.explode(start,"explodeconfig", 250).play();
				dojo.lfx.implode("explodeacao", start, 10).play();
				dojo.lfx.implode("explodegrupo", start, 10).play();
				dojo.lfx.implode("explodeusuario", start, 10).play();
				dojo.lfx.implode("explodetema", start, 10).play();
			}else if (item == 5){
				dojo.lfx.implode("explodeitem", start, 10).play();
				dojo.lfx.explode(start,"explodegrupo", 250).play();
				dojo.lfx.implode("explodeacao", start, 10).play();
				dojo.lfx.implode("explodeconfig", start, 10).play();
				dojo.lfx.implode("explodeusuario", start, 10).play();
				dojo.lfx.implode("explodetema", start, 10).play();
			}else if (item == 10){
				dojo.lfx.implode("explodeitem", start, 10).play();
				dojo.lfx.implode("explodeconfig", start, 10).play();
				dojo.lfx.implode("explodeacao", start, 10).play();
				dojo.lfx.explode(start,"explodetema", 250).play();
				dojo.lfx.implode("explodegrupo", start, 10).play();
				dojo.lfx.implode("explodeusuario", start, 10).play();
			}else if (item == 15){
				dojo.lfx.implode("explodeitem", start, 10).play();
				dojo.lfx.implode("explodeconfig", start, 10).play();
				dojo.lfx.implode("explodeacao", start, 10).play();
				dojo.lfx.explode(start,"explodeusuario", 250).play();
				dojo.lfx.implode("explodegrupo", start, 10).play();
				dojo.lfx.implode("explodetema", start, 10).play();
			}
		}
	
		function testImplode(start,item){
			if (item == 1) {
				dojo.lfx.implode("explodeitem", start, 10).play();
			}else if (item == 2){
				dojo.lfx.implode("explodeacao", start, 10).play();
			}else if (item == 3){
				dojo.lfx.implode("explodeitem", start, 10).play();
				dojo.lfx.implode("explodeacao", start, 10).play();
				dojo.lfx.implode("explodeconfig", start, 10).play();
				dojo.lfx.implode("explodegrupo", start, 10).play();
				dojo.lfx.implode("explodeusuario", start, 10).play();
			}else if (item == 4){
				dojo.lfx.implode("explodeconfig", start, 10).play();
			}else if (item == 5){
				dojo.lfx.implode("explodegrupo", start, 10).play();
			}else if (item == 10){
				dojo.lfx.implode("explodetema", start, 10).play();
			}else if (item == 15){
				dojo.lfx.implode("explodeusuario", start, 10).play();
			}
		}
	   var myStartEffect = function(element) {
	     element._opacity = Element.getOpacity(element);
	     new Effect.Opacity(element, {duration:0.2, from:element._opacity, to:0.7});
	     new Effect.Highlight(element, {});
	   }
	
	</script>
</head>

	<div id="geral">
		<div id="menu" style="padding:0;margin:0; " align="left">
		<logic:present name="arvoreConfiguracao" scope="session">
		<table>
			<tr>
				<td  align="center">
				<button style="width: 32px; height: 32px;" type="button"
						 onclick="abrirDetalhado(<%=request.getSession().getAttribute("codMapaSelecionadoRetorno")%>);"
						 onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/mapaDetalhadoSobre.gif'"
					     onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/mapaDetalhado.gif'"
						 >
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/mapaDetalhado.gif"
						border="0" align="middle" Title="Mapa Detalhado"/>
				</button>
				</td>
				<td align="center" >
				<button style="width: 32px; height: 32px;" type="button"
				onclick="abrirAcoes(<%=request.getSession().getAttribute("codMapaSelecionadoRetorno")%>);"
						 onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/mapaAcoesSobre.gif'"
						 onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/mapaAcoes.gif'">
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/mapaAcoes.gif"
						 
						 border="0" title="Plano de Ações"/>
				</button>
				</td>
				<td>
				<button style="width: 32px; height: 32px;" type="button"
					onclick="incluirPerspectiva();"
					onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/incluirPerspectivaSobre.gif'"
					onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/incluirPerspectiva.gif'"
					>
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/incluirPerspectiva.gif" 
					border="0" align="middle" title="Incluir Perspectiva" />
				</button>
				</td>
				<td>
				<button style="width: 32px; height: 32px;" type="button"
					onclick="incluirTema();"
					onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/incluirTemaSobre.gif'"
					onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/incluirTema.gif'"
					>
				<img src="<c:out value="${base}"/>/WEB/imagens/comum/incluirTema.gif" 
					border="0" align="middle" title="Incluir Tema" />
				</button>
				</td>
				
				<td>
				<button style="width: 32px; height: 32px;" type="button"
					onclick="alterarTema();"
					onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/alterarTemaSobre.gif'"
					onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/alterarTema.gif'"
					>
				<img src="<c:out value="${base}"/>/WEB/imagens/comum/alterarTema.gif" 
					border="0" align="middle" title="Alterar Tema" />
				</button>
				</td>
				<td>
				<button style="width: 32px; height: 32px;" type="button"
					onclick="incluirObjetivo();"
					onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/incluirObjetivoSobre.gif'"
					onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/incluirObjetivo.gif'"
					>
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/incluirObjetivo.gif" 
					border="0" align="middle" title="Incluir Objetivo" />
				</button>
				</td>
				<td>
				<button style="width: 32px; height: 32px;" type="button"
					onclick="incluirIndicador();"
					onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/incluirIndicadorSobre.gif'"
					onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/incluirIndicador.gif'"
					>
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/incluirIndicador.gif" 
					border="0" align="middle" title="Incluir Indicador" />
				</button>
				</td>
				<td>
				<button style="width: 32px; height: 32px;" type="button">
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/valorIndicador.gif" 
					onclick="valorIndicador();"
					onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/valorIndicadorSobre.gif'"
					onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/valorIndicador.gif'"
					border="0" align="middle" title="Incluir Valores no Indicador" />
				</button>
				</td>
				<td width="" align="center">
					<button type="button" onclick="javascript:history.back();" class="botaoPreto" style="vertical-align: middle; width:32px; height: 32px;padding: 2px;">
					<img align="bottom" src="<c:out value="${base}"/>/WEB/imagens/comum/voltar.gif" border="0" align="middle" style="vertical-align: middle">
				</button>
				</td>
			</tr>
		</table>
	</logic:present>
	</div>
</div>