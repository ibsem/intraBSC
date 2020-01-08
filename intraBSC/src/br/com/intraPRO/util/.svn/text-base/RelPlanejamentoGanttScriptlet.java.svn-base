package br.com.intraPRO.util;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RelatorioGanttTarefaScriptlet.java

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.jasperreports.engine.JRDefaultScriptlet;
import net.sf.jasperreports.engine.JRScriptletException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.data.time.SimpleTimePeriod;



public class RelPlanejamentoGanttScriptlet extends JRDefaultScriptlet
{

    private int linhas;

     
	public RelPlanejamentoGanttScriptlet()
    {
    }

    public JFreeChart createChart(IntervalCategoryDataset intervalcategorydataset)
    {
        Font novaFonte = new Font("Arial", 0, 8);
        TextTitle textoTitulo = new TextTitle();
        textoTitulo.setFont(novaFonte);
        textoTitulo.setText("");
        JFreeChart jfreechart = ChartFactory.createGanttChart(textoTitulo.getText(), "Tarefa", "Período", intervalcategorydataset, true, true, false);
        jfreechart.setBackgroundPaint(new Color(255, 255, 255));
        jfreechart.isBorderVisible();
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.getDomainAxis().setMaximumCategoryLabelWidthRatio(10F);
        CategoryItemRenderer categoryitemrenderer = categoryplot.getRenderer();
        categoryitemrenderer.setSeriesPaint(0, Color.blue);
                
        
        return jfreechart;
    }

    public long getDiferencaEmDias(Date dtMenor, Date dtMaior)
    {
        return (dtMaior.getTime() - dtMenor.getTime()) / ( 1000*60*60*24 );
    }
    

    public TaskSeriesCollection createDataset()
        throws JRScriptletException
          {
    		Date dataParametro = null;
    		String dataParametroFinal = null;
    		String filtro = null;
    		String etapa = null;
    		SimpleDateFormat dataVirada = new SimpleDateFormat("MM/dd/yyyy");
    		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
    		try {
				dataParametro = dataVirada.parse((String) getParameterValue("dataPrazo"));
				dataParametroFinal = data.format(dataParametro);
								
			} catch (JRScriptletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		
    		Connection conexao = (Connection)getParameterValue("REPORT_CONNECTION");
    		JDBCCategoryDataset dataset = new JDBCCategoryDataset(conexao);
    		if ((!getParameterValue("chaveSolicitante").equals("")) && (getParameterValue("chaveParticipante").equals("")))
   				filtro = " and ATVD.CD_USU_SLTT_ATVD = '" + getParameterValue("chaveSolicitante");
   			else if ((getParameterValue("chaveSolicitante").equals("")) && (!getParameterValue("chaveParticipante").equals("")))
   				filtro = " and ATVD.CD_USU_SLTT_ATVD = '" + getParameterValue("chaveParticipante"); 	
   			else if ((!getParameterValue("chaveSolicitante").equals("")) && (!getParameterValue("chaveParticipante").equals("")))
   				filtro = " and ATVD.CD_USU_SLTT_ATVD = '" + getParameterValue("chaveSolicitante") +
        		"' and PA.CD_USU= '" + getParameterValue("chaveParticipante") ;
    		
    		
    		try{ 
	  		dataset.executeQuery("SELECT PA.cd_usu || '-' || rTRIM(char(atvd.nr_seql_ATVD)) ||'-' || rTRIM(nm_ATVD) as tarefa , " +
            		"value(ATVD.DT_INC_ATVD, current date) as datainicio, ATVD.DT_LIM_FIN_ATVD as prazo " +
            		"FROM DB2ATV.ATVD ATVD " +
            		"left outer join DB2ATV.TIP_ATVD  T " + 
            		"ON T.CD_TIP_ATVD= ATVD.CD_TIP_ATVD and " +
            		"T.TX_TIP_ATVD<>'Contratos Ortad' and " +
            		"T.TX_TIP_ATVD<>'Acompanhamento de Fornecedores' "+
            		"INNER JOIN DB2ATV.PCT_ATVD PA " +
     				"ON PA.NR_SEQL_ATVD = ATVD.NR_SEQL_ATVD " +
     	            "and PA.AA_CRIC_ATVD = ATVD.AA_CRIC_ATVD " +
     	            "AND PA.CD_TIP_PRTC = 1 " +
                	"WHERE ATVD.DT_LIM_FIN_ATVD < '" + dataParametroFinal +
                	"' and ATVD.CD_EST_ATVD <> 5 and "+
            		"ATVD.CD_EST_ATVD <> 4 " + filtro +
                   	"' order by pa.cd_usu, ATVD.DT_LIM_FIN_ATVD" );    
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        TaskSeries taskseries = new TaskSeries("Cronograma Previsto");
        linhas = dataset.getColumnCount();
        linhas = linhas + (linhas/10*-1);
        for(int col = 0; col < linhas; col++)
        {
            etapa = (String)dataset.getColumnKey(col);
            Date dataInicio = new Date(dataset.getValue(0, col).longValue());
            Date dataFim = new Date(dataset.getValue(1, col).longValue());
            if (dataInicio.after(dataFim) )
            {
                dataInicio = dataFim; 	 
            }
            
            Task task = new Task(etapa.trim(),  new SimpleTimePeriod (dataInicio, dataFim));
            taskseries.add(task);
           
        }

        //StringBuffer sbuffer = new StringBuffer();
        //sbuffer.append(totalDiasPrevistos);
        //setVariableValue("diasPrevistosTarefa", sbuffer.toString());
        TaskSeriesCollection taskseriescollection = new TaskSeriesCollection();
        taskseriescollection.add(taskseries);
        return taskseriescollection;
    }

    public void afterReportInit()
        throws JRScriptletException
    {
    	
        IntervalCategoryDataset intervalcategorydataset = createDataset();
        JFreeChart chart = createChart(intervalcategorydataset);
        if (linhas < 10){
        	setVariableValue("Chart", new JCommonDrawableRenderer(chart, 100 + 12*linhas));	
        }else{
        	setVariableValue("Chart", new JCommonDrawableRenderer(chart, 20 *linhas));
        }
        
    }
    
    public void beforePageInit() throws JRScriptletException
    {
    	
    }
}
