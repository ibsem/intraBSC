<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag"%>
<%@ taglib uri="/tags/c" prefix="c" %>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Collection"%>
<%@ page import="br.com.intraBSC.modelo.PerspectivaTO"%>

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
		
		<%Collection lista = (Collection)request.getSession().getAttribute("listaPerspectiva");%>
		<table  border="0" cellspacing="2" cellpadding="2" width="100%">
			<tr>
				<td>
					<div name="perspectiva" id="perspectiva">
						<script language = "JavaScript">
							 a = new dTree('a');
					         a.add(0,-1,"<a href='javascript:a.aNodes[0]._io=!a.aNodes[0]._io;a.oAll(a.aNodes[0]._io);'><b>Mapas</b>&nbsp;&nbsp;&nbsp;<img src='<c:out value="${base}"/>/WEB/imagens/arvore/maisMenos.gif'/></a>",'','');
					         a.add("MAPA", "0" , "&nbsp;<b>Mapa Estrategico</b>","","","","","");
			
					         <%Iterator iter = lista.iterator();
					         int antMapa = 0;%>
				             <%while (iter.hasNext()){
	        			     	PerspectivaTO element = (PerspectivaTO) iter.next();	        			     	
	        			     	if ((antMapa != element.getIdMapa())){%>
	        			     		a.add("MAPA_<%=element.getIdMapa()%>","0",
	        			     		"&nbsp;<a href=<c:out value="${base}"/>/mapaEstrategico/detalhar.do?"+
	        			     		"op=mapaUsuarioRelatorioDetalha&codMapaEstrategico=<%=element.getId()%>><%=element.getNomeMapa()%></a>","","","",
	        			     		"<c:out value="${base}"/>/WEB/imagens/arvore/pasta.gif","<c:out value="${base}"/>/WEB/imagens/arvore/pasta.gif");
	        			     	<%}%>
	        			     	a.add("PERSPEC_<%=element.getId()%>","MAPA_<%=element.getIdMapa()%>",
	        			     	"&nbsp;<a href=<c:out value="${base}"/>/perspectiva/detalhar.do?op=perspectivaRelatorioDetalha&codMapa="+
								"<%=element.getIdMapa()%>&codPerspectiva=<%=element.getId()%>>"+
								"<%=element.getNome()%></a>","","","","<c:out value="${base}"/>/WEB/imagens/arvore/file.gif",
								"<c:out value="${base}"/>/WEB/imagens/arvore/file.gif");
					         <%antMapa = element.getIdMapa();}%>
							 perspectiva.innerHTML = a;
						</script>
					</div>
				</td>
			</tr>
		</table>
		
	</body>
</html:html>