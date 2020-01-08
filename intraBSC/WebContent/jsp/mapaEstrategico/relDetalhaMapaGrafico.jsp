<%@ page import="net.sf.jasperreports.engine.*" %>
<%@ page import="net.sf.jasperreports.engine.export.*" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag"%>
<%@ taglib uri="/tags/c" prefix="c" %>
<%@ taglib uri="/tags/fmt" prefix="fmt" %>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Collection"%>
<%@ page import="br.com.intraBSC.modelo.ObjetivoTO"%>
<%@ page import="br.com.intraBSC.modelo.PerspectivaTO"%>
<%@ page import="br.com.intraBSC.modelo.CausaEfeitoTO"%>
<html>
<table border="0" width="" align="center" cellpadding="0" cellspacing="0">
	<tr valign="top">
			
			<td width="" align="right">
				<%@ include file = "/jsp/mapaEstrategico/relCrossAcoes.jsp"%>
			</td>
			<td  width="" align="left">
				<%@ include file = "/jsp/layout/imprimirRelatorio.jsp"%>
			</td>
		</tr>
	
		<tr >
			    <td align = "center" class="titulo" colspan="2" >
			    <a name="Mapa Estratégico"/>
			    <a href="../mapaEstrategico/detalhar.do?op=mapaUsuarioRelatorioDetalha&codMapaEstrategico=<%=request.getAttribute("idMapa")%>" >&nbsp;&nbsp;<%=request.getAttribute("nomeMapa")%></a>
			    </td>  
			</tr>
					
</table>
<div style="width: 1000px">
<%Collection listaObj =(Collection)request.getAttribute("listaObjetivos");%>
<%Collection listaPer =(Collection)request.getAttribute("listaPerspectivas");%>
<%Collection listaCau =(Collection)request.getAttribute("listaCausaEfeito");%>
	<applet style="position: absolute; left: 0px; top: 60px;" archive="<c:out value="${base}"/>/WEB/applet/pacoteMapaGrafico.jar"
  			code="br.com.intraBSC.util.MapaGrafico" width="100%" height="2000 ">	
		<%if (listaPer != null){%>
	 	<%Iterator iter = listaPer.iterator();%>
		<%int contador = 0;%>
		<param name="numPersp" value="<%=request.getAttribute("numeroPerspectivas")%>">
		<param name="numCauEfe" value="<%=request.getAttribute("numCauEfe")%>">
		<%while (iter.hasNext()){PerspectivaTO elementP = (PerspectivaTO) iter.next();%>
  		<%contador = contador + 1;%>
  		<param name="per<%=contador%>"   
		       	   value="<%=elementP.getXInicialPerspectiva()%>|<%=elementP.getYInicialPerspectiva()%>|<%=elementP.getXFinalPerspectiva()%>|<%=elementP.getYFinalPerspectiva()%>|<%=elementP.getNome()%>|<%=elementP.getNumeroObjetivos()%>|<%=elementP.getId()%>|<%=elementP.getIdMapa()%>"/>
  			<%}%>
  		<%}%>	
		
		<%if (listaObj != null){%>
	 	<%Iterator iter1 = listaObj.iterator();%>
		<%int contador1 = 0;%>
		<%while (iter1.hasNext()){ObjetivoTO element = (ObjetivoTO) iter1.next();%>
		<%contador1 = contador1 + 1;%>
  		<param name="obj<%=contador1%>"   
		       	   value="<%=element.getXInicialObjetivo()%>|<%=element.getYInicialObjetivo()%>|<%=element.getXFinalObjetivo()%>|<%=element.getYFinalObjetivo()%>|<%=element.getNome()%>|<%=element.getId()%>|<%=element.getXCausaEfeito()%>|<%=element.getYCausaEfeito()%>|<%=element.getCorTema()%>|<%=element.getTamanhoFonte()%>"/>
  			<%}%>
  		<%}%>
  		
  		
  		
  		<%if (listaCau != null){%>
	 	<%Iterator iter = listaCau.iterator();%>
	 	<%int contador2 = 0;%>
		<%while (iter.hasNext()){CausaEfeitoTO element = (CausaEfeitoTO) iter.next();%>
  		<%contador2 = contador2 + 1;%>
  		<param name="cau<%=contador2%>"   
		       	   value="<%=element.getCausaId()%>|<%=element.getEfeitoId()%>|<%=element.getIntensidade()%>|<%=element.getInteracao()%>|<%=element.getNomeObjetivo()%>"/>
  			<%}%>
  		<%}%>
  		
	</applet>
</div>

</html>

