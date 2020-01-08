<%@ page import="net.sf.jasperreports.engine.*" %>
<%@ page import="net.sf.jasperreports.engine.export.*" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>

<html>
	<form name="relatorioForm">

<table border="0" width="" cellpadding="0" cellspacing="0" >
	<tr>
			<td>
				&nbsp;
			</td>
			<td width="" align="right">
				<%@ include file = "/jsp/mapaEstrategico/relCrossAcoes.jsp"%>
			</td>

			<td width="" align="left">
				<%@ include file = "/jsp/layout/imprimirRelatorio.jsp"%>
			</td>
		</tr>
	</table>
	<%
		// Executa o relat�rio
		JasperPrint jasperPrint = (JasperPrint) request.getSession().getAttribute("relatorio");
	
		if (jasperPrint == null) {
		%>jasperPrint � nulo<%
		}else{
			// Exporta relat�rio para o formato HTML
			JRHtmlExporter exporter = new JRHtmlExporter();
			StringBuffer sbuffer = new StringBuffer();
		
			Map imagesMap = new HashMap();
			session.setAttribute("IMAGES_MAP", imagesMap);
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, out);
			exporter.setParameter(JRHtmlExporterParameter.HTML_HEADER,"<div id='imprimi'>" );
			exporter.setParameter(JRHtmlExporterParameter.HTML_FOOTER,"</div>" );
			exporter.setParameter(JRHtmlExporterParameter.IMAGES_MAP, imagesMap);
			exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, "../jsp/image.jsp?image=");
			exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, new Boolean(false));
		    exporter.exportReport();
	    }
	%>


	</form>
</html>
