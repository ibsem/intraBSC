<%@ page import="net.sf.jasperreports.engine.*" %>
<%@ page import="net.sf.jasperreports.engine.JasperPrint.*" %>
<%@ page import="net.sf.jasperreports.engine.util.*" %>
<%@ page import="net.sf.jasperreports.engine.export.*" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>



<%

	// Executa o relatório
	JasperPrint jasperPrint = (JasperPrint) request.getSession().getAttribute("RELATORIO");

	if (jasperPrint == null) {
	%>jasperPrint é nulo<%
	}
	else
	{

	// Exporta relatório para o formato HTML
	JRHtmlExporter exporter = new JRHtmlExporter();
	StringBuffer sbuffer = new StringBuffer();

	Map imagesMap = new HashMap();
	session.setAttribute("IMAGES_MAP", imagesMap);
	exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
	exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, out);
	exporter.setParameter(JRHtmlExporterParameter.HTML_HEADER,"<div id='imprimir'>");
	exporter.setParameter(JRHtmlExporterParameter.HTML_FOOTER,"</div>");
	exporter.setParameter(JRHtmlExporterParameter.IMAGES_MAP, imagesMap);
	exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, "../jsp/relatorio/image.jsp?image=");
	exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, new Boolean(false));
    exporter.exportReport();
    }
%>

<table width="100%">
	<tr>
		<td align="left">
			<html:button property="" onclick="ativarPopupImpressao('imprimir');">
				<bean:message key="pro.botao.imprimir" />
			</html:button>
		</td>
	</tr>
</table>