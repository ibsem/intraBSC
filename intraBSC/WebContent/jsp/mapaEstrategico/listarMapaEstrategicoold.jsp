<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag"%>
<%@ taglib uri="/tags/c" prefix="c" %>
<%@ taglib uri="/tags/fmt" prefix="fmt" %>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Collection"%>
<%@ page import="br.com.intraBSC.modelo.MapaEstrategicoTO"%>


<head>
	<link type="text/css" href="<c:out value="${base}"/>/WEB/css/redmond/jquery-ui-1.8.9.custom.css" rel="stylesheet">	
	<script type="text/javascript" src="<c:out value="${base}"/>/WEB/js/ajaxfileupload/jquery.js"></script>
	<script type="text/javascript" src="<c:out value="${base}"/>/WEB/js/jquery/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="<c:out value="${base}"/>/WEB/js/ajaxfileupload/ajaxfileupload.js"></script>
	<script type="text/javascript" src="<c:out value="${base}"/>/WEB/js/jquery/jquery-ui-1.8.9.custom.min.js"></script>
	<style type="text/css">
		#dialog_link {padding: .4em 1em .4em 20px;text-decoration: none;position: relative;}
		#dialog_link span.ui-icon {margin: 0 5px 0 0;position: absolute;left: .2em;top: 50%;margin-top: -8px;}
	</style>	
</head>
<script type="text/javascript">
	$(function(){			
		$('#dialog').dialog({
			autoOpen: false,
			width: 550,
			resizable:false,
			title:'Importar',
			height:150,
			buttons: {
				"Executar Importacao": function() {
					ajaxFileUpload();
					/*var form = document.getElementById("formImportarXml");
					form.submit();
					*/
					$(this).dialog("close"); 
				}, 
				"Cancelar": function() { 
					$(this).dialog("close"); 
				} 
			}
		});
		
		// Dialog Link
		$('#dialog_link').click(function(){
			$('#dialog').dialog('open');
			return false;
		});

		$('#loading').dialog({
			autoOpen: false,
			width: 70,
			resizable:false,
			title:'Aguardar',
			modal:true,
			height:80
		});
		
	});
	
	function ajaxFileUpload() {
		$("#loading_p").ajaxStart(function(){
			$('#loading').dialog('open');
			return false;
		})
		.ajaxComplete(function(){
			$('#loading').dialog('close');
		});
		$.ajaxFileUpload({
			url:'mapaEstrategico/importar.do?op=importarXml', 
			secureuri:false,
			fileElementId:'fileImportar',
			dataType: 'json',
			beforeSend:function() {
				//document.getElementById("loading")
				$('#loading').dialog('open');
				return false;
			},
			complete:function(){
				$('#loading').dialog('close');
				document.getElementById("loading").innerHTML = "Importação realizada com sucesso";
				$('#loading').dialog('open');
			},
			success: function (data, status){
				if(typeof(data.error) != 'undefined'){
					if(data.error != '') {
						document.getElementById("loading").innerHTML = "Importação realizada com sucesso";
						$('#loading').dialog('open');
					} else {
						document.getElementById("loading").innerHTML = "Importação realizada com sucesso";
					}
				}
			},
			error: function (data, status, e){
				document.getElementById("loading").innerHTML = "Importação realizada com sucesso";
			}
		});
		return false;
	}  
		
</script>

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
			 	scope="request" pagesize="5" 
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
		
		<p style="float: right;padding-top:5px;"><a href="#" id="dialog_link" class="ui-state-default ui-corner-all"><span class="ui-icon ui-icon-newwin"></span>Importar XML Mapa</a></p>
		<div id="dialog" style="display: none;">
			<html:form action="/mapaEstrategico/importar.do?op=importarXml" styleId="formImportarXml" enctype="multipart/form-data">
				<input type="file" size="50" name="fileImportar" id="fileImportar"/>
			</html:form>
		</div>