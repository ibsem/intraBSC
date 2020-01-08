<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag"%>
<%@ taglib uri="/tags/c" prefix="c" %>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Collection"%>
<%@ page import="br.com.intraBSC.modelo.IndicadorTO"%>

<style>
	TABLE {FONT-SIZE: 12px; COLOR: #000000; FONT-FAMILY: Arial, Helvetica, sans-serif}
	.dtree{FONT-SIZE:11px; COLOR: #070d5b; FONT-FAMILY: Arial, Helvetica, sans-serif;left:50%;white-space: nowrap;border:thin}
	.dtree img{border: 0px;vertical-align: middle;}
	.dtree a{FONT-SIZE: 12px; COLOR: #000000; FONT-FAMILY: Arial, Helvetica, sans-serif; FONT-WEIGHT: normal; text-decoration: none;}
	.dtree a.node, .dtree a.nodeSel{white-space: nowrap;padding: 1px 2px 1px 2px;}
	.dtree a.node:hover, .dtree a.nodeSel:hover{color: #333;text-decoration: none;}
	.dtree a.nodeSel{background-color: #c0d2ec;}
	.dtree .clip{overflow: hidden;}
	.linkunderline {FONT-SIZE: 12px; COLOR: #000000; FONT-FAMILY: Arial, Helvetica, sans-serif; FONT-WEIGHT: normal; text-decoration: underline;}
</style>
	
<html:html>
	<body>
		<html:hidden property="op" value="consultarVarios"/>		
		<%Collection lista = (Collection)request.getSession().getAttribute("listaIndicador");%>	
		
		<table  border="0" cellspacing="2" cellpadding="2" width="100%">
			<tr>
				<td>
					<div name="indicador" id="indicador">
						<script language = "JavaScript">
							 a = new dTree('a');
					         a.add(0,-1,"<a href='javascript:a.aNodes[0]._io=!a.aNodes[0]._io;a.oAll(a.aNodes[0]._io);'><b>Mapas</b>&nbsp;&nbsp;&nbsp;<img src='<c:out value="${base}"/>/WEB/imagens/arvore/maisMenos.gif'/></a>",'','');
					         a.add("MAPA", "0" , "&nbsp;<b>Mapa Estrategico</b>","","","","","");
			
					         <%Iterator iter = lista.iterator();
					         int antMapa = 0;
					         int antPers = 0;
					         int antObj = 0;%>
				             <%while (iter.hasNext()){
	        			     	IndicadorTO element = (IndicadorTO) iter.next();	        			     	
	        			     	if ((antMapa != element.getIdMapa())){%>
	        			     		a.add("MAPA_<%=element.getIdMapa()%>","0",
	        			     		"&nbsp;<a href=<c:out value="${base}"/>/mapaEstrategico/detalhar.do?"+
	        			     		"op=mapaUsuarioRelatorioDetalha&codMapaEstrategico=<%=element.getId()%>><%=element.getNomeMapa()%></a>","","","",
	        			     		"<c:out value="${base}"/>/WEB/imagens/arvore/pasta.gif","<c:out value="${base}"/>/WEB/imagens/arvore/pasta.gif");
	        			     	<%}
	        			     	if ((antPers != element.getIdPerspectiva())){%>
	        			     		a.add("PERSPEC_<%=element.getIdPerspectiva()%>","MAPA_<%=element.getIdMapa()%>",
	        			     		"&nbsp;<a href=<c:out value="${base}"/>/perspectiva/detalhar.do?op=perspectivaRelatorioDetalha&codMapa="+
									"<%=element.getIdMapa()%>&codPerspectiva=<%=element.getIdPerspectiva()%>>"+
									"<%=element.getNomePerspectiva()%></a>","","","","<c:out value="${base}"/>/WEB/imagens/arvore/file.gif",
									"<c:out value="${base}"/>/WEB/imagens/arvore/file.gif");
								<%}
								if ((antObj != element.getIdObjetivo())){%>
									a.add("OBJ_<%=element.getIdObjetivo()%>","PERSPEC_<%=element.getIdPerspectiva()%>",
	        			     		"&nbsp;<a href=<c:out value="${base}"/>/objetivo/detalhar.do?op=objetivoRelatorioDetalha&codMapa="+
	        			     		"<%=element.getIdMapa()%>&codObjetivo=<%=element.getIdObjetivo()%>>"+
	        			     		"<%=element.getNomeObjetivo()%></a>","","","","<c:out value="${base}"/>/WEB/imagens/arvore/config.gif",
									"<c:out value="${base}"/>/WEB/imagens/arvore/config.gif");
								<%}%>
									a.add("IND_<%=element.getId()%>","OBJ_<%=element.getIdObjetivo()%>",
	        			     		"&nbsp;<a href=<c:out value="${base}"/>/indicador/detalhar.do?op=indicadorRelatorioDetalha"+
	        			     		"&codMapa=<%=element.getIdMapa()%>&codPerspectiva=<%=element.getIdPerspectiva()%>"+
	        			     		"&codIndicador=<%=element.getId()%>>"+
	        			     		"<%=element.getNome()%></a>","","","","<c:out value="${base}"/>/WEB/imagens/arvore/indicador.gif",
									"<c:out value="${base}"/>/WEB/imagens/arvore/indicador.gif");	        			     		
					         <%antMapa = element.getIdMapa();
					           antPers = element.getIdPerspectiva();
					           antObj = element.getIdObjetivo();}%>
							 indicador.innerHTML = a;
						</script>
					</div>
				</td>
			</tr>
		</table>
	</body>
</html:html>
