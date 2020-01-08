<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Collection"%>
<%@ page import="br.com.intraBSC.modelo.IndicadorTO"%>

<html:html>
	<html:hidden property="op" value="consultarVarios"/>
	<logic:present name="listaIndicador" scope="session">
		<%Collection lista = (Collection)request.getSession().getAttribute("listaIndicador");%>						
			<div id="fecha" style="position:absolute;top:15px; 
								   left:335px; background:white;
								   border-style:outset;
								   border-width:2px;
								   border-color:silver">
				<a href="javascript:;"  onclick="testImplode(this)">&nbsp;<b>Fechar</b>&nbsp;</a>
			</div>
			<div name="arvore" id="arvore" style="position:absolute;top:15px;left:15px;" >
				<script language = "JavaScript">
					 a = new dTree('a');
			         a.add(0,-1,"<a href='javascript:a.aNodes[0]._io=!a.aNodes[0]._io;a.oAll(a.aNodes[0]._io);'><b>Mapa em Uso</b>&nbsp;&nbsp;&nbsp;<img src='<c:out value="${base}"/>/WEB/imagens/arvore/maisMenos.gif'/></a>",'','');
			         //a.add("MAPA", "0" , "&nbsp;<b>Mapa Estrategico</b>","","","","","");
	
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
					 document.getElementById("arvore").innerHTML = a;
				</script>					
			</div>
		</logic:present>
</html:html>
