/*
 * Generated by JasperReports - 11/11/10 21:45
 */
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.fill.*;

import java.util.*;
import java.math.*;
import java.text.*;
import java.io.*;
import java.net.*;

import net.sf.jasperreports.engine.*;
import java.util.*;
import net.sf.jasperreports.engine.data.*;


/**
 *
 */
public class ObjetivoPrincipal_1289519150907_711772 extends JREvaluator
{


    /**
     *
     */
    private JRFillParameter parameter_REPORT_LOCALE = null;
    private JRFillParameter parameter_REPORT_VIRTUALIZER = null;
    private JRFillParameter parameter_objetivo = null;
    private JRFillParameter parameter_REPORT_SCRIPTLET = null;
    private JRFillParameter parameter_REPORT_PARAMETERS_MAP = null;
    private JRFillParameter parameter_REPORT_CONNECTION = null;
    private JRFillParameter parameter_REPORT_CLASS_LOADER = null;
    private JRFillParameter parameter_REPORT_DATA_SOURCE = null;
    private JRFillParameter parameter_REPORT_URL_HANDLER_FACTORY = null;
    private JRFillParameter parameter_IS_IGNORE_PAGINATION = null;
    private JRFillParameter parameter_baseDir = null;
    private JRFillParameter parameter_REPORT_MAX_COUNT = null;
    private JRFillParameter parameter_bsc = null;
    private JRFillParameter parameter_REPORT_RESOURCE_BUNDLE = null;
    private JRFillField field_idMapa = null;
    private JRFillField field_nameObjective = null;
    private JRFillField field_namebsc = null;
    private JRFillVariable variable_PAGE_NUMBER = null;
    private JRFillVariable variable_COLUMN_NUMBER = null;
    private JRFillVariable variable_REPORT_COUNT = null;
    private JRFillVariable variable_PAGE_COUNT = null;
    private JRFillVariable variable_COLUMN_COUNT = null;
    private JRFillVariable variable_Efeitos_COUNT = null;
    private JRFillVariable variable_Chart = null;


    /**
     *
     */
    public void customizedInit(
        Map pm,
        Map fm,
        Map vm
        )
    {
        initParams(pm);
        initFields(fm);
        initVars(vm);
    }


    /**
     *
     */
    private void initParams(Map pm)
    {
        parameter_REPORT_LOCALE = (JRFillParameter)pm.get("REPORT_LOCALE");
        parameter_REPORT_VIRTUALIZER = (JRFillParameter)pm.get("REPORT_VIRTUALIZER");
        parameter_objetivo = (JRFillParameter)pm.get("objetivo");
        parameter_REPORT_SCRIPTLET = (JRFillParameter)pm.get("REPORT_SCRIPTLET");
        parameter_REPORT_PARAMETERS_MAP = (JRFillParameter)pm.get("REPORT_PARAMETERS_MAP");
        parameter_REPORT_CONNECTION = (JRFillParameter)pm.get("REPORT_CONNECTION");
        parameter_REPORT_CLASS_LOADER = (JRFillParameter)pm.get("REPORT_CLASS_LOADER");
        parameter_REPORT_DATA_SOURCE = (JRFillParameter)pm.get("REPORT_DATA_SOURCE");
        parameter_REPORT_URL_HANDLER_FACTORY = (JRFillParameter)pm.get("REPORT_URL_HANDLER_FACTORY");
        parameter_IS_IGNORE_PAGINATION = (JRFillParameter)pm.get("IS_IGNORE_PAGINATION");
        parameter_baseDir = (JRFillParameter)pm.get("baseDir");
        parameter_REPORT_MAX_COUNT = (JRFillParameter)pm.get("REPORT_MAX_COUNT");
        parameter_bsc = (JRFillParameter)pm.get("bsc");
        parameter_REPORT_RESOURCE_BUNDLE = (JRFillParameter)pm.get("REPORT_RESOURCE_BUNDLE");
    }


    /**
     *
     */
    private void initFields(Map fm)
    {
        field_idMapa = (JRFillField)fm.get("idMapa");
        field_nameObjective = (JRFillField)fm.get("nameObjective");
        field_namebsc = (JRFillField)fm.get("namebsc");
    }


    /**
     *
     */
    private void initVars(Map vm)
    {
        variable_PAGE_NUMBER = (JRFillVariable)vm.get("PAGE_NUMBER");
        variable_COLUMN_NUMBER = (JRFillVariable)vm.get("COLUMN_NUMBER");
        variable_REPORT_COUNT = (JRFillVariable)vm.get("REPORT_COUNT");
        variable_PAGE_COUNT = (JRFillVariable)vm.get("PAGE_COUNT");
        variable_COLUMN_COUNT = (JRFillVariable)vm.get("COLUMN_COUNT");
        variable_Efeitos_COUNT = (JRFillVariable)vm.get("Efeitos_COUNT");
        variable_Chart = (JRFillVariable)vm.get("Chart");
    }


    /**
     *
     */
    public Object evaluate(int id) throws Throwable
    {
        Object value = null;

        switch (id)
        {
            case 0 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 1 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 2 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 3 : 
            {
                value = (java.lang.Integer)(new Integer(0));
                break;
            }
            case 4 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 5 : 
            {
                value = (java.lang.Integer)(new Integer(0));
                break;
            }
            case 6 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 7 : 
            {
                value = (java.lang.Integer)(new Integer(0));
                break;
            }
            case 8 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 9 : 
            {
                value = (java.lang.Integer)(new Integer(0));
                break;
            }
            case 10 : 
            {
                value = (java.lang.Object)(null);
                break;
            }
            case 11 : 
            {
                value = (java.lang.Object)(((java.lang.String)parameter_baseDir.getValue()));
                break;
            }
            case 12 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)parameter_objetivo.getValue()));
                break;
            }
            case 13 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)parameter_bsc.getValue()));
                break;
            }
            case 14 : 
            {
                value = (java.sql.Connection)(((java.sql.Connection)parameter_REPORT_CONNECTION.getValue()));
                break;
            }
            case 15 : 
            {
                value = (java.io.File)(new File(((java.lang.String)parameter_baseDir.getValue()),"//relatorios//ObjetivoSubLinkage.jasper"));
                break;
            }
            case 16 : 
            {
                value = (java.lang.String)(((java.lang.String)field_namebsc.getValue()));
                break;
            }
            case 17 : 
            {
                value = (java.lang.String)("Mapa Estratégico");
                break;
            }
            case 18 : 
            {
                value = (java.lang.String)("../mapaEstrategico/detalhar.do?op=mapaUsuarioRelatorioDetalha&codMapaEstrategico=" + ((java.lang.String)field_idMapa.getValue()));
                break;
            }
            case 19 : 
            {
                value = (java.util.Date)(new java.util.Date());
                break;
            }
            case 20 : 
            {
                value = (java.lang.String)(new String(((java.lang.String)parameter_baseDir.getValue())+"//WEB//imagens//arvore//config.gif"));
                break;
            }
            case 21 : 
            {
                value = (java.lang.String)(((java.lang.String)field_nameObjective.getValue()));
                break;
            }
            case 22 : 
            {
                value = (java.lang.String)(null);
                break;
            }
            case 23 : 
            {
                value = (java.lang.String)(str("bsc.report.objetivo"));
                break;
            }
            case 24 : 
            {
                value = (java.lang.Object)(((java.lang.String)parameter_baseDir.getValue()));
                break;
            }
            case 25 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)parameter_objetivo.getValue()));
                break;
            }
            case 26 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)parameter_bsc.getValue()));
                break;
            }
            case 27 : 
            {
                value = (java.sql.Connection)(((java.sql.Connection)parameter_REPORT_CONNECTION.getValue()));
                break;
            }
            case 28 : 
            {
                value = (java.io.File)(new File(((java.lang.String)parameter_baseDir.getValue()),"//relatorios//ObjetivoSubEspecificacao.jasper"));
                break;
            }
            case 29 : 
            {
                value = (java.lang.Object)(((java.lang.String)parameter_baseDir.getValue()));
                break;
            }
            case 30 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)parameter_objetivo.getValue()));
                break;
            }
            case 31 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)parameter_bsc.getValue()));
                break;
            }
            case 32 : 
            {
                value = (java.sql.Connection)(((java.sql.Connection)parameter_REPORT_CONNECTION.getValue()));
                break;
            }
            case 33 : 
            {
                value = (java.io.File)(new File(((java.lang.String)parameter_baseDir.getValue()), "//relatorios//ObjetivoSubIndicadores.jasper"));
                break;
            }
           default :
           {
           }
        }
        
        return value;
    }


    /**
     *
     */
    public Object evaluateOld(int id) throws Throwable
    {
        Object value = null;

        switch (id)
        {
            case 0 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 1 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 2 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 3 : 
            {
                value = (java.lang.Integer)(new Integer(0));
                break;
            }
            case 4 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 5 : 
            {
                value = (java.lang.Integer)(new Integer(0));
                break;
            }
            case 6 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 7 : 
            {
                value = (java.lang.Integer)(new Integer(0));
                break;
            }
            case 8 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 9 : 
            {
                value = (java.lang.Integer)(new Integer(0));
                break;
            }
            case 10 : 
            {
                value = (java.lang.Object)(null);
                break;
            }
            case 11 : 
            {
                value = (java.lang.Object)(((java.lang.String)parameter_baseDir.getValue()));
                break;
            }
            case 12 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)parameter_objetivo.getValue()));
                break;
            }
            case 13 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)parameter_bsc.getValue()));
                break;
            }
            case 14 : 
            {
                value = (java.sql.Connection)(((java.sql.Connection)parameter_REPORT_CONNECTION.getValue()));
                break;
            }
            case 15 : 
            {
                value = (java.io.File)(new File(((java.lang.String)parameter_baseDir.getValue()),"//relatorios//ObjetivoSubLinkage.jasper"));
                break;
            }
            case 16 : 
            {
                value = (java.lang.String)(((java.lang.String)field_namebsc.getOldValue()));
                break;
            }
            case 17 : 
            {
                value = (java.lang.String)("Mapa Estratégico");
                break;
            }
            case 18 : 
            {
                value = (java.lang.String)("../mapaEstrategico/detalhar.do?op=mapaUsuarioRelatorioDetalha&codMapaEstrategico=" + ((java.lang.String)field_idMapa.getOldValue()));
                break;
            }
            case 19 : 
            {
                value = (java.util.Date)(new java.util.Date());
                break;
            }
            case 20 : 
            {
                value = (java.lang.String)(new String(((java.lang.String)parameter_baseDir.getValue())+"//WEB//imagens//arvore//config.gif"));
                break;
            }
            case 21 : 
            {
                value = (java.lang.String)(((java.lang.String)field_nameObjective.getOldValue()));
                break;
            }
            case 22 : 
            {
                value = (java.lang.String)(null);
                break;
            }
            case 23 : 
            {
                value = (java.lang.String)(str("bsc.report.objetivo"));
                break;
            }
            case 24 : 
            {
                value = (java.lang.Object)(((java.lang.String)parameter_baseDir.getValue()));
                break;
            }
            case 25 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)parameter_objetivo.getValue()));
                break;
            }
            case 26 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)parameter_bsc.getValue()));
                break;
            }
            case 27 : 
            {
                value = (java.sql.Connection)(((java.sql.Connection)parameter_REPORT_CONNECTION.getValue()));
                break;
            }
            case 28 : 
            {
                value = (java.io.File)(new File(((java.lang.String)parameter_baseDir.getValue()),"//relatorios//ObjetivoSubEspecificacao.jasper"));
                break;
            }
            case 29 : 
            {
                value = (java.lang.Object)(((java.lang.String)parameter_baseDir.getValue()));
                break;
            }
            case 30 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)parameter_objetivo.getValue()));
                break;
            }
            case 31 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)parameter_bsc.getValue()));
                break;
            }
            case 32 : 
            {
                value = (java.sql.Connection)(((java.sql.Connection)parameter_REPORT_CONNECTION.getValue()));
                break;
            }
            case 33 : 
            {
                value = (java.io.File)(new File(((java.lang.String)parameter_baseDir.getValue()), "//relatorios//ObjetivoSubIndicadores.jasper"));
                break;
            }
           default :
           {
           }
        }
        
        return value;
    }


    /**
     *
     */
    public Object evaluateEstimated(int id) throws Throwable
    {
        Object value = null;

        switch (id)
        {
            case 0 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 1 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 2 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 3 : 
            {
                value = (java.lang.Integer)(new Integer(0));
                break;
            }
            case 4 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 5 : 
            {
                value = (java.lang.Integer)(new Integer(0));
                break;
            }
            case 6 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 7 : 
            {
                value = (java.lang.Integer)(new Integer(0));
                break;
            }
            case 8 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 9 : 
            {
                value = (java.lang.Integer)(new Integer(0));
                break;
            }
            case 10 : 
            {
                value = (java.lang.Object)(null);
                break;
            }
            case 11 : 
            {
                value = (java.lang.Object)(((java.lang.String)parameter_baseDir.getValue()));
                break;
            }
            case 12 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)parameter_objetivo.getValue()));
                break;
            }
            case 13 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)parameter_bsc.getValue()));
                break;
            }
            case 14 : 
            {
                value = (java.sql.Connection)(((java.sql.Connection)parameter_REPORT_CONNECTION.getValue()));
                break;
            }
            case 15 : 
            {
                value = (java.io.File)(new File(((java.lang.String)parameter_baseDir.getValue()),"//relatorios//ObjetivoSubLinkage.jasper"));
                break;
            }
            case 16 : 
            {
                value = (java.lang.String)(((java.lang.String)field_namebsc.getValue()));
                break;
            }
            case 17 : 
            {
                value = (java.lang.String)("Mapa Estratégico");
                break;
            }
            case 18 : 
            {
                value = (java.lang.String)("../mapaEstrategico/detalhar.do?op=mapaUsuarioRelatorioDetalha&codMapaEstrategico=" + ((java.lang.String)field_idMapa.getValue()));
                break;
            }
            case 19 : 
            {
                value = (java.util.Date)(new java.util.Date());
                break;
            }
            case 20 : 
            {
                value = (java.lang.String)(new String(((java.lang.String)parameter_baseDir.getValue())+"//WEB//imagens//arvore//config.gif"));
                break;
            }
            case 21 : 
            {
                value = (java.lang.String)(((java.lang.String)field_nameObjective.getValue()));
                break;
            }
            case 22 : 
            {
                value = (java.lang.String)(null);
                break;
            }
            case 23 : 
            {
                value = (java.lang.String)(str("bsc.report.objetivo"));
                break;
            }
            case 24 : 
            {
                value = (java.lang.Object)(((java.lang.String)parameter_baseDir.getValue()));
                break;
            }
            case 25 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)parameter_objetivo.getValue()));
                break;
            }
            case 26 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)parameter_bsc.getValue()));
                break;
            }
            case 27 : 
            {
                value = (java.sql.Connection)(((java.sql.Connection)parameter_REPORT_CONNECTION.getValue()));
                break;
            }
            case 28 : 
            {
                value = (java.io.File)(new File(((java.lang.String)parameter_baseDir.getValue()),"//relatorios//ObjetivoSubEspecificacao.jasper"));
                break;
            }
            case 29 : 
            {
                value = (java.lang.Object)(((java.lang.String)parameter_baseDir.getValue()));
                break;
            }
            case 30 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)parameter_objetivo.getValue()));
                break;
            }
            case 31 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)parameter_bsc.getValue()));
                break;
            }
            case 32 : 
            {
                value = (java.sql.Connection)(((java.sql.Connection)parameter_REPORT_CONNECTION.getValue()));
                break;
            }
            case 33 : 
            {
                value = (java.io.File)(new File(((java.lang.String)parameter_baseDir.getValue()), "//relatorios//ObjetivoSubIndicadores.jasper"));
                break;
            }
           default :
           {
           }
        }
        
        return value;
    }


}
