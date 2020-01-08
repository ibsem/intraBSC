package br.com.intraBSC.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;

import net.sf.jasperreports.engine.JRDefaultScriptlet;
import net.sf.jasperreports.engine.JRScriptletException;

import org.apache.poi.util.SystemOutLogger;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.DialShape;
import org.jfree.chart.plot.MeterInterval;
import org.jfree.chart.plot.MeterPlot;
import org.jfree.data.Range;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.general.ValueDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;


public class IndicadorScriptlet extends JRDefaultScriptlet
{

    public IndicadorScriptlet()
    {
    }

 	public JFreeChart createChart(ValueDataset valuedataset) throws JRScriptletException
    {
        MeterPlot meterplot = new MeterPlot(valuedataset);
        double teto = 100;
        double piso = 0;
        String titulo = valuedataset.getValue().toString();
        if (valor > superior){
        	teto = valor * 1.30; 
            piso = inferior * 0.70;	
        }else if (valor < inferior){
        	teto = superior * 1.30 ; 
            piso = valor * 0.70;
        }else if (valor >= inferior && valor <= superior){
        	teto = superior * 1.30; 
            piso = inferior * 0.70;
        }
        
        meterplot.setRange(new Range(piso, teto));	
        String labelInferior = "Vermelho";
        String labelSuperior = "Verde";
        Color corInferior = Color.red.brighter();
        Color corSuperior = Color.green.brighter();
        
        
        if (inversao.intValue() == 1)
        {labelInferior = "Verde";
         labelSuperior = "Vermelho";
         corInferior = Color.green.brighter();
         corSuperior = Color.red.brighter();
         
        };
        meterplot.addInterval(new MeterInterval(labelInferior, new Range(piso,inferior), Color.black, new BasicStroke(1.0F), corInferior));
        meterplot.addInterval(new MeterInterval("Amarelo", new Range(inferior,superior), Color.black, new BasicStroke(1.0F), Color.yellow.brighter()));
        meterplot.addInterval(new MeterInterval(labelSuperior, new Range(superior,teto), Color.black, new BasicStroke(1.0F), corSuperior));
        meterplot.setNeedlePaint(Color.black);
        meterplot.setDialBackgroundPaint(Color.white);
        meterplot.setDialOutlinePaint(Color.black);
        meterplot.setDialShape(DialShape.PIE);
        meterplot.setMeterAngle(260);
        meterplot.setTickLabelsVisible(true);
        meterplot.setTickLabelFont(new Font("Arial", 0, 12));
        meterplot.setTickLabelPaint(Color.black);
        meterplot.setTickSize(5D);
        meterplot.setTickPaint(Color.black);
        meterplot.setUnits("");
        meterplot.setValuePaint(Color.white);
        meterplot.setValueFont(new Font("Arial", 1,6));
        JFreeChart jfreechart = new JFreeChart(titulo, JFreeChart.DEFAULT_TITLE_FONT, meterplot, false);
        return jfreechart;
    }

 
    public DefaultValueDataset createDataset()
        throws JRScriptletException
    {        
        Connection conexao = (Connection)getParameterValue("REPORT_CONNECTION");
        JDBCCategoryDataset datasetJdbc = new JDBCCategoryDataset(conexao);
        try
        { datasetJdbc.executeQuery(        
            	"SELECT PER.NAME AS NAMEPERSPECTIVE,OBJ.NAME AS NAMEOBJECTIVE, "+
                "MEA.NAME AS NAMEMEASURE," +
                "TAR.TARGETVALUEUP AS TARGETVALUEUP, "+
                "CASE WHEN MEAFACT.VALUE IS NULL THEN 1 ELSE MEAFACT.VALUE END AS ULTIMOVALOR," +
                "TAR.TARGETVALUEDOWN AS TARGETVALUEDOWN, "+
            	"OWN.NAME AS NAMEOWNER, "+
            	"TAR.INVERT AS INVERTER "+
            	"FROM UNIDADE AS UNID, RELPERSPECTIVE AS RELPER,BSC AS BSC,PERSPECTIVE AS PER, "+
            	"OBJECTIVE AS OBJ "+  
            	"LEFT OUTER JOIN MEASURE AS MEA ON MEA.OBJECTIVE_ID = OBJ.ID "+
            	"LEFT OUTER JOIN MEASUREFACT AS MEAFACT ON MEAFACT.ID_MEASURE = MEA.ID  AND MEAFACT.DATE = MEA.LAST_DATE "+      
            	"LEFT OUTER JOIN TARGET AS TAR ON TAR.MEASURE_ID = MEA.ID AND TAR.ACTIVE = 1 "+
            	"LEFT OUTER JOIN OWNER AS OWN ON MEA.OWNER_ID = OWN.ID " +
            	"WHERE BSC.ID=" + getParameterValue("bsc") + " AND PER.ID =" + getParameterValue("perspectiva") + " AND " +
            	"MEA.ID = " + getParameterValue("indicador") + " AND RELPER.PERSPECTIVE_ID = PER.ID "+
            	"AND RELPER.OBJECTIVE_ID = OBJ.ID AND UNID.ID = MEA.UNITS " +
            	"ORDER BY MEAFACT.DATE DESC "); 
     
    	 }
        catch(SQLException e)
        {
        	e.printStackTrace();  
        }
        if(datasetJdbc.getValue(2,0)==null){
        dataset = null;
        }else{
        inferior = datasetJdbc.getValue(2,0).doubleValue();
        superior = datasetJdbc.getValue(0,0).doubleValue();
        inversao = (Integer)datasetJdbc.getValue(3,0);
        dataset = new DefaultValueDataset(datasetJdbc.getValue(1,0));
        valor = dataset.getValue().doubleValue();
    	//Float ultimoValor = (Float) getParameterValue("ultimoValor"); 
    	//dataset = new DefaultValueDataset(ultimoValor.doubleValue());
        }
       return dataset;
       
    }
    public void afterReportInit()
        throws JRScriptletException
    {
    	DefaultValueDataset defaultdataset = createDataset();
    	if (defaultdataset==null){
    	setVariableValue("Chart", null);	
    	}else{
    	JFreeChart chart = createChart(defaultdataset);
        chart.setBackgroundPaint(Color.white);
        setVariableValue("Chart", new JCommonDrawableRenderer(chart));}
    }
    private static DefaultValueDataset dataset;
    public double valor;
    public double inferior;
    public double superior;
    public Integer inversao;
}
