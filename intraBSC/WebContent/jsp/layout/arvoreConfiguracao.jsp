<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ page import="java.util.Iterator"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ page import="java.util.Collection"%>
<%@ page import="br.com.intraBSC.modelo.MapaEstrategicoTO"%>
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
<html:html>
	<html:hidden property="op" value="consultarVarios"/>
	<script type="text/javascript" src="<c:out value="${base}"/>/WEB/js/dtree.js"></script>
	<logic:present name="arvoreConfiguracao" scope="session">
		<%Collection lista = (Collection)request.getSession().getAttribute("arvoreConfiguracao");%>						
		 <div name="arvoreConfig" id="arvoreConfig">			
			<% if (lista == null) {%>
			<%}	else if (lista != null){%>
				<script language = "JavaScript">
					 a = new dTree('a');
			         a.add(0,-1,"<a href='javascript:a.aNodes[0]._io=!a.aNodes[0]._io;a.oAll(a.aNodes[0]._io);'><b><bean:message key="bsc.label.mapa"/></b>&nbsp;&nbsp;&nbsp;<img src='<c:out value="${base}"/>/WEB/imagens/arvore/maisMenos.gif'/></a>",'','');
			         <%Iterator iter = lista.iterator();
			         int antMapa = 0;
			         int antPers = 0;
			         int antObj = 0;
			         int contSelecionado = 1;%>
		             <%while (iter.hasNext()){
				     	MapaEstrategicoTO element = (MapaEstrategicoTO) iter.next();	        			     	
				     	if ((antMapa != element.getId())){%>
				     		a.add("MAPA_<%=element.getId()%>","0",
				     		"&nbsp;<a href=<c:out value="${base}"/>/mapaEstrategico/consultar.do?op=consultarUm&id="+
				     		"<%=element.getId()%>&itemSelecionado=<%=contSelecionado%>><%=element.getNome()%></a>","","","",
				     		<%if (element.getAtivo() == 1){%>
				     			"<c:out value="${base}"/>/WEB/imagens/arvore/pasta.gif",
				     			"<c:out value="${base}"/>/WEB/imagens/arvore/pasta.gif");
				     		<%}else{%>
								"<c:out value="${base}"/>/WEB/imagens/arvore/pastaInativo.gif",
								"<c:out value="${base}"/>/WEB/imagens/arvore/pastaInativo.gif");
							<%}%>	
				     	<%}
				     	if ((antPers != element.getIdPerspectiva())){
				     		contSelecionado++;%>
				     		a.add("PERSPEC_<%=element.getIdPerspectiva()%>","MAPA_<%=element.getId()%>",
				     		"&nbsp;<a href=<c:out value="${base}"/>/perspectiva/encaminha.do?op=encaminhaAlterar&codPerspectiva=<%=element.getIdPerspectiva()%>&itemSelecionado=<%=contSelecionado%>>"+
							"<%=element.getNomePerspectiva()%></a>","","","",
							<%if (element.getAtivoPers() == 1){%>
								"<c:out value="${base}"/>/WEB/imagens/arvore/file.gif",
								"<c:out value="${base}"/>/WEB/imagens/arvore/file.gif");
							<%}else{%>
								"<c:out value="${base}"/>/WEB/imagens/arvore/fileInativo.gif",
								"<c:out value="${base}"/>/WEB/imagens/arvore/fileInativo.gif");
							<%}%>
						<%}
						if ((antObj != element.getIdObjetivo())){
							contSelecionado++;%>
							<%if (element.getNomeObjetivo() != null){%>
								a.add("OBJ_<%=element.getIdObjetivo()%>","PERSPEC_<%=element.getIdPerspectiva()%>",
					     		"&nbsp;<a href=<c:out value="${base}"/>/objetivo/encaminha.do?op=encaminharAlterar&codObjetivo=<%=element.getIdObjetivo()%>&itemSelecionado=<%=contSelecionado%>>"+
					     		"<%=element.getColuna()%>" + "-" + "<%=element.getNomeObjetivo()%></a>","","","",
					     		<%if (element.getAtivoObj() == 1){%>
									"<c:out value="${base}"/>/WEB/imagens/arvore/config.gif",
									"<c:out value="${base}"/>/WEB/imagens/arvore/config.gif");
								<%}else{%>
									"<c:out value="${base}"/>/WEB/imagens/arvore/configInativo.gif",
									"<c:out value="${base}"/>/WEB/imagens/arvore/configInativo.gif");
								<%}%>
							<%}%>		
						<%}%>
						<%if (element.getIdIndicador() != 0){
							contSelecionado++;%>
							a.add("IND_<%=element.getIdIndicador()%>","OBJ_<%=element.getIdObjetivo()%>",
				     		"&nbsp;<a href=<c:out value="${base}"/>/indicador/encaminha.do?op=encaminharAlterar"+
				     		"&codIndicador=<%=element.getIdIndicador()%>&itemSelecionado=<%=contSelecionado%>>"+
				     		"<%=element.getNomeIndicador()%></a>","","","",
				     		<%if (element.getAtivoInd() == 1){%>
								"<c:out value="${base}"/>/WEB/imagens/arvore/indicador.gif",
							"<c:out value="${base}"/>/WEB/imagens/arvore/indicador.gif");	 
							<%}else{%>
								"<c:out value="${base}"/>/WEB/imagens/arvore/indicadorInativo.gif",
								"<c:out value="${base}"/>/WEB/imagens/arvore/indicadorInativo.gif");	 
							<%}%>
						<%}%>
			         <%antMapa = element.getId();
			           antPers = element.getIdPerspectiva();
			           antObj = element.getIdObjetivo();}%>
					 document.getElementById("arvoreConfig").innerHTML = a;
					 a.openTo(<c:out value="${itemArvoreMarcado}"/>,false,true);
				</script>					
			<%};  %>	
		<!-- 	</div>  -->
		</logic:present>
</html:html>
