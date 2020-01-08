package br.com.intraBSC.util;


import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import br.com.intraBSC.controle.DispatchActionBSC;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;


public class ImprimirRelatorioAction extends DispatchActionBSC {

	
	public void imprimiJasper(JasperPrint relatorio, HttpServletResponse response) throws IOException, JRException{
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition","attachment;filename="+relatorio.getName()+".pdf"); 
		ServletOutputStream out = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream( relatorio, out);
	}
	
	public ActionForward imprimirMapa(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
		JasperPrint imprimir = (JasperPrint) request.getSession().getAttribute("relatorio");
		imprimiJasper(imprimir,response);
		return mapping.findForward(null);	
	}

	
}
