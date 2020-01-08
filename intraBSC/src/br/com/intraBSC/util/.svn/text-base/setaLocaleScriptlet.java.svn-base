package br.com.intraBSC.util;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import net.sf.jasperreports.engine.JRDefaultScriptlet;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JRScriptletException;

public class setaLocaleScriptlet extends JRDefaultScriptlet
{

    public setaLocaleScriptlet() throws JRException
    {
    	Map parameters = new HashMap();
		Locale locale = new Locale("pt" , "BR");
		parameters.put(JRParameter.REPORT_LOCALE, locale);
        
    }

    
    public void beforeReportInit()
        throws JRScriptletException
    {
    }
}
