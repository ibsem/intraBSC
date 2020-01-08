<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag"%>
<%@ taglib uri="/tags/c" prefix="c" %>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Collection"%>
<%@ page import="br.com.intraPRO.modelo.FaseTO"%>

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
		
		<%Collection lista = (Collection)request.getSession().getAttribute("listaFase");%>
		<table  border="0" cellspacing="2" cellpadding="2" width="100%">
			<tr>
				<td>
					<div name="fase" id="fase">
						<script language = "JavaScript">
							 a = new dTree('a');
					         a.add(0,-1,"<a href='javascript:a.aNodes[0]._io=!a.aNodes[0]._io;a.oAll(a.aNodes[0]._io);'><b>Processos</b>&nbsp;&nbsp;&nbsp;<img src='<c:out value="${base}"/>/WEB/imagens/arvore/maisMenos.gif'/></a>",'','');
					         a.add("MAPA", "0" , "&nbsp;<b>Processo Estrategico</b>","","","","","");
			
					         <%Iterator iter = lista.iterator();
					         int antProcesso = 0;%>
				             <%while (iter.hasNext()){
	        			     	FaseTO element = (FaseTO) iter.next();	        			     	
	        			     	if ((antProcesso != element.getIdProcesso())){%>
	        			     		a.add("PROCESSO_<%=element.getIdProcesso()%>","0",
	        			     		"&nbsp;<a href=<c:out value="${base}"/>/processoEstrategico/detalhar.do?"+
	        			     		"op=processoUsuarioRelatorioDetalha&codProcessoEstrategico=<%=element.getId()%>><%=element.getNomeProcesso()%></a>","","","",
	        			     		"<c:out value="${base}"/>/WEB/imagens/arvore/pasta.gif","<c:out value="${base}"/>/WEB/imagens/arvore/pasta.gif");
	        			     	<%}%>
	        			     	a.add("FASE_<%=element.getId()%>","PROCESSO_<%=element.getIdProcesso()%>",
	        			     	"&nbsp;<a href=<c:out value="${base}"/>/fase/detalhar.do?op=faseRelatorioDetalha&codProcesso="+
								"<%=element.getIdProcesso()%>&codFase=<%=element.getId()%>>"+
								"<%=element.getNome()%></a>","","","","<c:out value="${base}"/>/WEB/imagens/arvore/file.gif",
								"<c:out value="${base}"/>/WEB/imagens/arvore/file.gif");
					         <%antProcesso = element.getIdProcesso();}%>
							 fase.innerHTML = a;
						</script>
					</div>
				</td>
			</tr>
		</table>
		
	</body>
</html:html>