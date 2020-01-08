package br.com.intraBSC.util;


import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.jasperreports.engine.JRDefaultScriptlet;
import net.sf.jasperreports.engine.JRScriptletException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.jdbc.JDBCXYDataset;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.Layer;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.TextAnchor;



public class IndicadorSubHistoricoGraficoLinhaScriptlet extends JRDefaultScriptlet{
	private SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yy");

    public IndicadorSubHistoricoGraficoLinhaScriptlet(){
    }

    public JFreeChart createChart(DefaultCategoryDataset categorydataset) throws JRScriptletException
    {
           	
    	// Objetos da classe exemplo LineChartDemo8
    	TextTitle texttitle = new TextTitle("Hist�rico do Indicador");
    	Font novaFonte = new Font("Arial", 0,8);
    	texttitle.setFont(novaFonte);
    	JFreeChart jfreechart = ChartFactory.createLineChart("", "", "valor", categorydataset, PlotOrientation.VERTICAL, false, false, false);
    	texttitle.setPosition(RectangleEdge.BOTTOM);
        texttitle.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        jfreechart.setBackgroundPaint(Color.black);
        jfreechart.setBorderPaint(Color.black);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.setBackgroundPaint(Color.white);
        categoryplot.setRangeGridlinePaint(Color.black);
        categoryplot.setOutlinePaint(Color.black);
        NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
   //     numberaxis.setAutoRangeIncludesZero(false);
        numberaxis.setUpperBound(superior.doubleValue()*1.9);
        LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer)categoryplot.getRenderer();
        lineandshaperenderer.setShapesVisible(true);
        lineandshaperenderer.setItemLabelsVisible(true);
        lineandshaperenderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        lineandshaperenderer.setDrawOutlines(true);
        lineandshaperenderer.setUseFillPaint(true);
        lineandshaperenderer.setBaseItemLabelsVisible(true);
        lineandshaperenderer.setSeriesFillPaint(0,Color.black,true);
        lineandshaperenderer.setBaseFillPaint(Color.black);
        lineandshaperenderer.setFillPaint(Color.white);
        lineandshaperenderer.setSeriesPaint(0,Color.black,true);
       
        
        // Marca os range inferior
        IntervalMarker intervalmarkerdown = new IntervalMarker( valor.doubleValue()*0.1 , inferior.doubleValue());
        intervalmarkerdown.setLabel("Vermelho");
        intervalmarkerdown.setPaint(Color.red);
        if (inversao.intValue() == 1){
            intervalmarkerdown.setLabel("Verde");
            intervalmarkerdown.setPaint(Color.green);
         }	
        intervalmarkerdown.setLabelFont(new Font("Arial", 2, 8));
        intervalmarkerdown.setLabelAnchor(RectangleAnchor.CENTER);
        intervalmarkerdown.setLabelTextAnchor(TextAnchor.CENTER);
        categoryplot.addRangeMarker(intervalmarkerdown, Layer.BACKGROUND);
        
        // Marca os range intermediario
        IntervalMarker intervalmarkermidle = new IntervalMarker( inferior.doubleValue(), superior.doubleValue() );
        intervalmarkermidle.setLabel("Amarelo");
        intervalmarkermidle.setLabelFont(new Font("Arial", 2, 8));
        intervalmarkermidle.setLabelAnchor(RectangleAnchor.CENTER);
        intervalmarkermidle.setLabelTextAnchor(TextAnchor.CENTER);
        intervalmarkermidle.setPaint(Color.yellow);
        categoryplot.addRangeMarker(intervalmarkermidle, Layer.BACKGROUND);
        
        // Marca os range superior
        IntervalMarker intervalmarkerup = new IntervalMarker( superior.doubleValue(), superior.doubleValue()*1.30);
        intervalmarkerup.setLabel("Verde");
        intervalmarkerup.setPaint(Color.green);
        if (inversao.intValue() == 1){
           intervalmarkerup.setLabel("Vermelho");
           intervalmarkerup.setPaint(Color.red);
        }	
        intervalmarkerup.setLabelFont(new Font("Arial", 2, 8));
        intervalmarkerup.setLabelAnchor(RectangleAnchor.CENTER);
        intervalmarkerup.setLabelTextAnchor(TextAnchor.CENTER);
        categoryplot.addRangeMarker(intervalmarkerup, Layer.BACKGROUND);
      
        return jfreechart;
    }

 
    public DefaultCategoryDataset createDataset()
        throws JRScriptletException, SQLException, NullPointerException
    {        
        Connection conexao = (Connection)getParameterValue("REPORT_CONNECTION");
        JDBCXYDataset dataset;
					dataset = new JDBCXYDataset(conexao);
     		
        	dataset.executeQuery(        
        		"SELECT MEAFACT.DATE AS DATAS, "+
        		"MEAFACT.VALUE AS VALORES, " +
        		"TAR.TARGETVALUEDOWN AS TARGETDOWN, " +
        		"TAR.TARGETVALUEUP AS TARGETUP, "+
        		"TAR.INVERT AS INVERTER "+
        		"FROM UNIDADE AS UNID, RELPERSPECTIVE AS RELPER, "+
        		"BSC AS BSC,PERSPECTIVE AS PER,OBJECTIVE AS OBJ "+  
        		"LEFT OUTER JOIN MEASURE AS MEA ON MEA.OBJECTIVE_ID = OBJ.ID "+
        		"LEFT OUTER JOIN MEASUREFACT AS MEAFACT ON MEAFACT.ID_MEASURE = MEA.ID "+      
        		"LEFT OUTER JOIN TARGET AS TAR ON TAR.MEASURE_ID = MEA.ID AND TAR.ACTIVE = 1 "+
        		"LEFT OUTER JOIN OWNER AS OWN ON MEA.OWNER_ID = OWN.ID "+
        		"WHERE BSC.ID=" + getParameterValue("bsc") + " AND PER.ID =" + getParameterValue("perspectiva") + " AND MEA.ID =" + getParameterValue("indicador") + " AND RELPER.PERSPECTIVE_ID = PER.ID "+
        		"AND RELPER.OBJECTIVE_ID = OBJ.ID AND UNID.ID = MEA.UNITS "+
        		"ORDER BY MEAFACT.DATE ASC");
        		
        	
        	
 
        
       
        	
            DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
            //dataset.setTimeSeries(true);
            for( lin = 0; lin < dataset.getItemCount(0); lin++){
               Long data = (Long) dataset.getX(0, lin);
               valor = dataset.getY(0, lin);
               String formatData = sdf2.format(new Date(data.longValue()));
               defaultcategorydataset.addValue(valor.floatValue(),"0", formatData);
               inferior = (Number) dataset.getY(1,lin);
               superior = (Number) dataset.getY(2,lin);
               inversao = (Integer) dataset.getY(3,lin);           
            }
            
       
       return defaultcategorydataset;
       
    }
    public void afterReportInit()
        throws JRScriptletException
    {
    	DefaultCategoryDataset defaultdataset;
    	try {
    		defaultdataset = createDataset();
			JFreeChart chart = createChart(defaultdataset);
	        chart.setBackgroundPaint(Color.white);
	        setVariableValue("Chart2", new JCommonDrawableRenderer(chart));	
		        		
		} catch (JRScriptletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e){
        //System.out.println("--------------------");	
		//setVariableValue("teste", "vazio");
		}
    }
   
   public String contadorcoluna = "";
   public Number inferior = 0;
   public Number superior = 0;
   public Number valor = 0;
   public Number inferiorTroca = 0;
   public Integer inversao = 0;
   public int lin = 0;
}
