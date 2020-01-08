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
<table border="0" width="799px" align="left">
	<tr valign="top">
			<td>
				&nbsp;
			</td>
			<td width="80px" align="left">
				<%@ include file = "/jsp/pro/processo/relCrossAcoes.jsp"%>
			</td>
			<td  width="709px" align="left">
				<%@ include file = "/jsp/layout/imprimirRelatorio.jsp"%>
			</td>
		</tr>
		<tr >
			    <td align = "left" class="titulo" colspan="3" style="border-bottom:thin; border-bottom-style:solid;">
			    <a name="Processo Estratégico"/>
			    <a href="../processo/detalhar.do?op=processoUsuarioRelatorioDetalha&codProcesso=<%=request.getAttribute("idProcesso")%>" >&nbsp;&nbsp;<%=request.getAttribute("nomeProcesso")%></a>
			    </td>  
			</tr>
					
</table>

<%Collection listaObj =(Collection)request.getAttribute("listaObjetivos");%>
<%Collection listaPer =(Collection)request.getAttribute("listaPerspectivas");%>
<%Collection listaCau =(Collection)request.getAttribute("listaCausaEfeito");%>
	<applet archive="<c:out value="${base}"/>/WEB/applet/pacoteProcessoGrafico.jar"
  			code="br.com.intraBSC.util.ProcessoGrafico" width="100%" height="501">	
		<%if (listaPer != null){%>
	 	<%Iterator iter = listaPer.iterator();%>
		<%int contador = 0;%>
		<param name="numPersp" value="<%=request.getAttribute("numeroPerspectivas")%>">
		<param name="numCauEfe" value="<%=request.getAttribute("numCauEfe")%>">
		<%while (iter.hasNext()){PerspectivaTO elementP = (PerspectivaTO) iter.next();%>
  		<%contador = contador + 1;%>
  		<param name="per<%=contador%>"   
		       	   value="<%=elementP.getXInicialPerspectiva()%>|<%=elementP.getYInicialPerspectiva()%>|<%=elementP.getXFinalPerspectiva()%>|<%=elementP.getYFinalPerspectiva()%>|<%=elementP.getNome()%>|<%=elementP.getNumeroObjetivos()%>|<%=elementP.getId()%>"/>
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
	
	

</html>

