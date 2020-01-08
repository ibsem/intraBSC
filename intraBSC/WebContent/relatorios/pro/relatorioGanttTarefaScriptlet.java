// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RelatorioGanttAtividadeScriptlet.java

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.renderers.JCommonDrawableRenderer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.*;
import org.jfree.data.jdbc.JDBCCategoryDataset;

public class RelatorioGanttAtividadeScriptlet extends JRDefaultScriptlet
{

    public RelatorioGanttAtividadeScriptlet()
    {
    }

    public JFreeChart createChart(IntervalCategoryDataset intervalcategorydataset)
    {
        Font novaFonte = new Font("Arial", 0, 10);
        TextTitle textoTitulo = new TextTitle();
        textoTitulo.setFont(novaFonte);
        textoTitulo.setText("");
        JFreeChart jfreechart = ChartFactory.createGanttChart(textoTitulo.getText(), "Etapa", "Data", intervalcategorydataset, true, true, false);
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
        return (dtMaior.getTime() - dtMenor.getTime()) / 0x5265c00L;
    }

    public TaskSeriesCollection createDataset()
        throws JRScriptletException
    {
        String etapa = null;
        int lin = 0;
        int colant = 0;
        long totalDiasPrevistos = 0L;
        Connection conexao = (Connection)getParameterValue("REPORT_CONNECTION");
        JDBCCategoryDataset dataset = new JDBCCategoryDataset(conexao);
        try
        {
            dataset.executeQuery(" select  intraprobra.ETP_TIP_ATVD.NM_ETP as nomeEtapa, intraprobra.CTU_ETP_ATVD.DT_PRV_INC_ETP as previsaoFim, Value(intraprobra.CTU_ETP_ATVD.DT_INC_ETP,CURRENT DATE + 1 day) as inicioEtapa, Value(intraprobra.CTU_ETP_ATVD.DT_FIM_ETP,CURRENT DATE + 1 day) as fimEtapa, Value(intraprobra.ATVD.DT_INC_ATVD,CURRENT DATE + 1 day) as inicioaAtividade from\tintraprobra.ATVD,intraprobra.CTU_ETP_ATVD,intraprobra.ETP_TIP_ATVD where \tintraprobra.ATVD.AA_CRIC_ATVD = 2005\tAND intraprobra.ATVD.NR_SEQL_ATVD = 56832 AND intraprobra.ATVD.CD_TIP_ATVD = intraprobra.CTU_ETP_ATVD.CD_TIP_ATVD AND intraprobra.ATVD.AA_CRIC_ATVD = intraprobra.CTU_ETP_ATVD.AA_CRIC_ATVD AND intraprobra.ATVD.NR_SEQL_ATVD = intraprobra.CTU_ETP_ATVD.NR_SEQL_ATVD AND intraprobra.CTU_ETP_ATVD.CD_TIP_ATVD = intraprobra.ETP_TIP_ATVD.CD_TIP_ATVD AND intraprobra.CTU_ETP_ATVD.NR_ORD_ETP = intraprobra.ETP_TIP_ATVD.NR_ORD_ETP");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        TaskSeries taskseries = new TaskSeries("Cronograma Previsto");
        for(int col = 0; col < dataset.getColumnCount(); col++)
        {
            etapa = (String)dataset.getColumnKey(col);
            if(col == 0)
            {
                lin = 3;
                colant = col;
            } else
            {
                lin = 0;
                colant = col - 1;
            }
            Date dataPrevInicio = new Date(dataset.getValue(lin, colant).longValue());
            Date dataPrevFim = new Date(dataset.getValue(0, col).longValue());
            Date dataInicio = new Date(dataset.getValue(1, col).longValue());
            Date dataFim = new Date(dataset.getValue(2, col).longValue());
            long diasExecutados = getDiferencaEmDias(dataInicio, dataFim);
            long diasPrevistos = getDiferencaEmDias(dataPrevInicio, dataPrevFim);
            totalDiasPrevistos += diasPrevistos;
            double percentualEtapa = (double)diasExecutados / (double)diasPrevistos;
            Task task = new Task(etapa.trim(), dataPrevInicio, dataPrevFim);
            task.setPercentComplete(percentualEtapa);
            taskseries.add(task);
        }

        StringBuffer sbuffer = new StringBuffer();
        sbuffer.append(totalDiasPrevistos);
        setVariableValue("diasPrevistosAtividade", sbuffer.toString());
        TaskSeriesCollection taskseriescollection = new TaskSeriesCollection();
        taskseriescollection.add(taskseries);
        return taskseriescollection;
    }

    public void afterReportInit()
        throws JRScriptletException
    {
        IntervalCategoryDataset intervalcategorydataset = createDataset();
        JFreeChart chart = createChart(intervalcategorydataset);
        setVariableValue("Chart", new JCommonDrawableRenderer(chart));
    }
}
