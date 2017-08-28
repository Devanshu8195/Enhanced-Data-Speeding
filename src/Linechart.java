import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Linechart extends JFrame 
{
    public Linechart() 
    {
        JPanel chartPanel = createChartPanel();
      
        add(chartPanel, BorderLayout.CENTER);
 
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
 
    private JPanel createChartPanel() 
    {
        String chartTitle = "SIMPLE LINE CHART";
        String xAxis = "Time";
        String yAxis = "Temperature";
        boolean showLegend = true;
        boolean createURL = true;
        boolean createTooltip = true;
       
        XYDataset dataset = createDataset();
 
        JFreeChart chart = ChartFactory.createXYLineChart(chartTitle,
        xAxis, yAxis, dataset,
        PlotOrientation.VERTICAL, showLegend, createTooltip, createURL);
        
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        plot.setRenderer(renderer);
        
        return new ChartPanel(chart);
    }
 
    private XYDataset createDataset() 
    {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series1 = new XYSeries("Object 1");
        Vector<TemraturePlotPoint> v = getAllTempratureDataOfT1();
        for (int i = 0; i < v.size(); i++) {
            TemraturePlotPoint p = v.elementAt(i);
            System.out.println("p" + p);
            series1.add(p.x, p.y);
            
        }
 
        dataset.addSeries(series1);
  
        return dataset;
    }
    
    Vector getAllTempratureDataOfT1()
    {
        Vector<TemraturePlotPoint> v = new Vector<TemraturePlotPoint>();
    
        try {
            System.out.println("try");
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tempraturedb", "root", "");
            System.out.println("connection");
//            for (double j = 0; j < 1000; j++) {
                String squery = "SELECT tmp_time, t1 from temp_tb1 limit 10,15 ";
                PreparedStatement  pst = cn.prepareStatement(squery);
                ResultSet rs = pst.executeQuery();
                
                while(rs.next())
                {
                    TemraturePlotPoint tp = new TemraturePlotPoint(rs.getDouble("tmp_time"),rs.getFloat("t1"));
                    v.add(tp);
                }
                
                cn.close();
                pst.close();
                rs.close();
                
//            }
        } catch (Exception e) {
            System.out.println("Error : "+ e + e.getMessage());
        }  
        return v;
    
    }
 
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            @Override
            public void run()
            {
                new Linechart().setVisible(true);
            }
        });
    }
}

class TemraturePlotPoint
{
    double x;
    float y;

    public TemraturePlotPoint(double x, float y) {
        this.x = x;
        this.y = y;
    }

    public String toString()
    {
        return "TemraturePlotPoint x = "+x + " y =" + y;
    }
}