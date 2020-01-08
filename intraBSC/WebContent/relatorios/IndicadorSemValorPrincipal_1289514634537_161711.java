/*
 * Generated by JasperReports - 11/11/10 20:30
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
public class IndicadorSemValorPrincipal_1289514634537_161711 extends JREvaluator
{


    /**
     *
     */
    private JRFillParameter parameter_REPORT_LOCALE = null;
    private JRFillParameter parameter_REPORT_VIRTUALIZER = null;
    private JRFillParameter parameter_REPORT_SCRIPTLET = null;
    private JRFillParameter parameter_REPORT_PARAMETERS_MAP = null;
    private JRFillParameter parameter_REPORT_CONNECTION = null;
    private JRFillParameter parameter_REPORT_CLASS_LOADER = null;
    private JRFillParameter parameter_REPORT_DATA_SOURCE = null;
    private JRFillParameter parameter_REPORT_URL_HANDLER_FACTORY = null;
    private JRFillParameter parameter_IS_IGNORE_PAGINATION = null;
    private JRFillParameter parameter_baseDir = null;
    private JRFillParameter parameter_indicador = null;
    private JRFillParameter parameter_REPORT_MAX_COUNT = null;
    private JRFillParameter parameter_bsc = null;
    private JRFillParameter parameter_perspectiva = null;
    private JRFillParameter parameter_REPORT_RESOURCE_BUNDLE = null;
    private JRFillField field_Datas = null;
    private JRFillField field_nameObjective = null;
    private JRFillField field_Valores = null;
    private JRFillField field_namebsc = null;
    private JRFillField field_targetvaluedown = null;
    private JRFillField field_nameOwner = null;
    private JRFillField field_targetvalueup = null;
    private JRFillField field_nameMeasure = null;
    private JRFillField field_namePerspective = null;
    private JRFillField field_unidade = null;
    private JRFillVariable variable_PAGE_NUMBER = null;
    private JRFillVariable variable_COLUMN_NUMBER = null;
    private JRFillVariable variable_REPORT_COUNT = null;
    private JRFillVariable variable_PAGE_COUNT = null;
    private JRFillVariable variable_COLUMN_COUNT = null;
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
        parameter_REPORT_SCRIPTLET = (JRFillParameter)pm.get("REPORT_SCRIPTLET");
        parameter_REPORT_PARAMETERS_MAP = (JRFillParameter)pm.get("REPORT_PARAMETERS_MAP");
        parameter_REPORT_CONNECTION = (JRFillParameter)pm.get("REPORT_CONNECTION");
        parameter_REPORT_CLASS_LOADER = (JRFillParameter)pm.get("REPORT_CLASS_LOADER");
        parameter_REPORT_DATA_SOURCE = (JRFillParameter)pm.get("REPORT_DATA_SOURCE");
        parameter_REPORT_URL_HANDLER_FACTORY = (JRFillParameter)pm.get("REPORT_URL_HANDLER_FACTORY");
        parameter_IS_IGNORE_PAGINATION = (JRFillParameter)pm.get("IS_IGNORE_PAGINATION");
        parameter_baseDir = (JRFillParameter)pm.get("baseDir");
        parameter_indicador = (JRFillParameter)pm.get("indicador");
        parameter_REPORT_MAX_COUNT = (JRFillParameter)pm.get("REPORT_MAX_COUNT");
        parameter_bsc = (JRFillParameter)pm.get("bsc");
        parameter_perspectiva = (JRFillParameter)pm.get("perspectiva");
        parameter_REPORT_RESOURCE_BUNDLE = (JRFillParameter)pm.get("REPORT_RESOURCE_BUNDLE");
    }


    /**
     *
     */
    private void initFields(Map fm)
    {
        field_Datas = (JRFillField)fm.get("Datas");
        field_nameObjective = (JRFillField)fm.get("nameObjective");
        field_Valores = (JRFillField)fm.get("Valores");
        field_namebsc = (JRFillField)fm.get("namebsc");
        field_targetvaluedown = (JRFillField)fm.get("targetvaluedown");
        field_nameOwner = (JRFillField)fm.get("nameOwner");
        field_targetvalueup = (JRFillField)fm.get("targetvalueup");
        field_nameMeasure = (JRFillField)fm.get("nameMeasure");
        field_namePerspective = (JRFillField)fm.get("namePerspective");
        field_unidade = (JRFillField)fm.get("unidade");
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
                value = (java.lang.String)(((java.lang.String)field_namebsc.getValue()));
                break;
            }
            case 9 : 
            {
                value = (java.lang.String)("Mapa Estratégico");
                break;
            }
            case 10 : 
            {
                value = (java.lang.String)("../mapaEstrategico/detalhar.do?op=mapaUsuarioRelatorioDetalha&codMapaEstrategico=" + ((java.lang.Integer)parameter_bsc.getValue()));
                break;
            }
            case 11 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)parameter_indicador.getValue()));
                break;
            }
            case 12 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)parameter_bsc.getValue()));
                break;
            }
            case 13 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)parameter_perspectiva.getValue()));
                break;
            }
            case 14 : 
            {
                value = (java.sql.Connection)(((java.sql.Connection)parameter_REPORT_CONNECTION.getValue()));
                break;
            }
            case 15 : 
            {
                value = (java.io.File)(new File(((java.lang.String)parameter_baseDir.getValue()),"//relatorios//IndicadorSemValorSubValor.jasper"));
                break;
            }
            case 16 : 
            {
                value = (java.util.Date)(new java.util.Date());
                break;
            }
            case 17 : 
            {
                value = (java.lang.String)(str("bsc.report.indicador"));
                break;
            }
            case 18 : 
            {
                value = (java.lang.String)(new String(((java.lang.String)parameter_baseDir.getValue())+"//WEB//imagens//arvore//basepro.gif"));
                break;
            }
            case 19 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)parameter_indicador.getValue()));
                break;
            }
            case 20 : 
            {
                value = (java.sql.Connection)(((java.sql.Connection)parameter_REPORT_CONNECTION.getValue()));
                break;
            }
            case 21 : 
            {
                value = (java.io.File)(new File(((java.lang.String)parameter_baseDir.getValue()),"//relatorios//IndicadorSubTasks.jasper"));
                break;
            }
            case 22 : 
            {
                value = (java.lang.String)(str("bsc.report.tarefas"));
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
                value = (java.lang.String)(((java.lang.String)field_namebsc.getOldValue()));
                break;
            }
            case 9 : 
            {
                value = (java.lang.String)("Mapa Estratégico");
                break;
            }
            case 10 : 
            {
                value = (java.lang.String)("../mapaEstrategico/detalhar.do?op=mapaUsuarioRelatorioDetalha&codMapaEstrategico=" + ((java.lang.Integer)parameter_bsc.getValue()));
                break;
            }
            case 11 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)parameter_indicador.getValue()));
                break;
            }
            case 12 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)parameter_bsc.getValue()));
                break;
            }
            case 13 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)parameter_perspectiva.getValue()));
                break;
            }
            case 14 : 
            {
                value = (java.sql.Connection)(((java.sql.Connection)parameter_REPORT_CONNECTION.getValue()));
                break;
            }
            case 15 : 
            {
                value = (java.io.File)(new File(((java.lang.String)parameter_baseDir.getValue()),"//relatorios//IndicadorSemValorSubValor.jasper"));
                break;
            }
            case 16 : 
            {
                value = (java.util.Date)(new java.util.Date());
                break;
            }
            case 17 : 
            {
                value = (java.lang.String)(str("bsc.report.indicador"));
                break;
            }
            case 18 : 
            {
                value = (java.lang.String)(new String(((java.lang.String)parameter_baseDir.getValue())+"//WEB//imagens//arvore//basepro.gif"));
                break;
            }
            case 19 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)parameter_indicador.getValue()));
                break;
            }
            case 20 : 
            {
                value = (java.sql.Connection)(((java.sql.Connection)parameter_REPORT_CONNECTION.getValue()));
                break;
            }
            case 21 : 
            {
                value = (java.io.File)(new File(((java.lang.String)parameter_baseDir.getValue()),"//relatorios//IndicadorSubTasks.jasper"));
                break;
            }
            case 22 : 
            {
                value = (java.lang.String)(str("bsc.report.tarefas"));
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
                value = (java.lang.String)(((java.lang.String)field_namebsc.getValue()));
                break;
            }
            case 9 : 
            {
                value = (java.lang.String)("Mapa Estratégico");
                break;
            }
            case 10 : 
            {
                value = (java.lang.String)("../mapaEstrategico/detalhar.do?op=mapaUsuarioRelatorioDetalha&codMapaEstrategico=" + ((java.lang.Integer)parameter_bsc.getValue()));
                break;
            }
            case 11 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)parameter_indicador.getValue()));
                break;
            }
            case 12 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)parameter_bsc.getValue()));
                break;
            }
            case 13 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)parameter_perspectiva.getValue()));
                break;
            }
            case 14 : 
            {
                value = (java.sql.Connection)(((java.sql.Connection)parameter_REPORT_CONNECTION.getValue()));
                break;
            }
            case 15 : 
            {
                value = (java.io.File)(new File(((java.lang.String)parameter_baseDir.getValue()),"//relatorios//IndicadorSemValorSubValor.jasper"));
                break;
            }
            case 16 : 
            {
                value = (java.util.Date)(new java.util.Date());
                break;
            }
            case 17 : 
            {
                value = (java.lang.String)(str("bsc.report.indicador"));
                break;
            }
            case 18 : 
            {
                value = (java.lang.String)(new String(((java.lang.String)parameter_baseDir.getValue())+"//WEB//imagens//arvore//basepro.gif"));
                break;
            }
            case 19 : 
            {
                value = (java.lang.Object)(((java.lang.Integer)parameter_indicador.getValue()));
                break;
            }
            case 20 : 
            {
                value = (java.sql.Connection)(((java.sql.Connection)parameter_REPORT_CONNECTION.getValue()));
                break;
            }
            case 21 : 
            {
                value = (java.io.File)(new File(((java.lang.String)parameter_baseDir.getValue()),"//relatorios//IndicadorSubTasks.jasper"));
                break;
            }
            case 22 : 
            {
                value = (java.lang.String)(str("bsc.report.tarefas"));
                break;
            }
           default :
           {
           }
        }
        
        return value;
    }


}
