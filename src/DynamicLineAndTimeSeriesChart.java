 import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.Timer;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * An example to show how we can create a dynamic chart.
*/
public class DynamicLineAndTimeSeriesChart extends ApplicationFrame implements ActionListener {
    
    int count = 0;
    int maxTempId;
    int maxCount = 100;
    Vector<Double> v;
    /** The time series data. */
    private TimeSeries series;

    /** The most recent value added. */
    private double lastValue = 100.0;
   
    /** Timer to refresh graph after every 1/4th of a second */
    private Timer timer = new Timer(1, this);
    int i = 0;
    DynamicLineAndTimeSeriesChart w;
   
    /**
     * Constructs a new dynamic chart application.
     *
     * @param title  the frame title.
     */
    public DynamicLineAndTimeSeriesChart(final String title) {
        

        super(title);
        w = this;
        setUpData();
        this.series = new TimeSeries("Random Data", Millisecond.class);
       
        final TimeSeriesCollection dataset = new TimeSeriesCollection(this.series);
        final JFreeChart chart = createChart(dataset);
       
        timer.setInitialDelay(1);
       
        //Sets background color of chart
        chart.setBackgroundPaint(Color.LIGHT_GRAY);
       
        //Created JPanel to show graph on screen
        final JPanel content = new JPanel(new BorderLayout());
       
        //Created Chartpanel for chart area
        final ChartPanel chartPanel = new ChartPanel(chart);
       
        //Added chartpanel to main panel
        content.add(chartPanel);
        
        //Sets the size of whole window (JPanel)
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 500));
       
        //Puts the whole content on a Frame
        setContentPane(content);
       
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                w.setVisible(false);
            }
            
});
        timer.start();

    }
    
    void setUpData() {
        v = new Vector<Double>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tempraturedb", "root", "");
//            for (double j = 0; j < 1000; j++) {
            String squery = "select max(temp_id) from temp_tb1";

            PreparedStatement pst = cn.prepareStatement(squery);
            ResultSet rs = pst.executeQuery();
            rs.next();
            maxTempId = rs.getInt(1);
            pst.close();
            rs.close();

            int firstValue = (maxTempId - maxCount);

            String topTemsQuery = "select t1 from temp_tb1 where temp_id<=" + maxTempId + " AND temp_id>" + firstValue + " ";
            PreparedStatement pst2 = cn.prepareStatement(topTemsQuery);
            ResultSet rs2 = pst2.executeQuery();
            while (rs2.next()) {
                double d = rs2.getDouble(1);
                v.add(d);
            }
            pst2.close();
            rs2.close();
            cn.close();

//            }
        } catch (Exception e) {
            System.out.println("Error : " + e + e.getMessage());
        }

    }

    /**
     * Creates a sample chart.
     *
     * @param dataset  the dataset.
     *
     * @return A sample chart.
     */
    private JFreeChart createChart(final XYDataset dataset) {
        final JFreeChart result = ChartFactory.createTimeSeriesChart(
            "Dynamic Line And TimeSeries Chart",
            "Time",
            "Temperature Reading",
            dataset,
            true,
            true,
            false
        );
       
        final XYPlot plot = result.getXYPlot();
       
        plot.setBackgroundPaint(new Color(0xffffe0));
        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.lightGray);
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.lightGray);
                
        ValueAxis xaxis = plot.getDomainAxis();
        xaxis.setAutoRange(true);
       
        //Domain axis would show data of 60 seconds for a time
        xaxis.setFixedAutoRange(60000.0);  // 60 seconds
        xaxis.setVerticalTickLabels(true);
       
        ValueAxis yaxis = plot.getRangeAxis();
        yaxis.setRange(0.0, 300.0);
       
        return result;
    }
    /**
     * Generates an random entry for a particular call made by time for every 1/4th of a second.
     *
     * @param e  the action event.
     */
    public void actionPerformed(final ActionEvent e) {
       
        final double factor = 0.9 + 0.2*Math.random();
        this.lastValue = this.lastValue * factor;
       
        final Millisecond now = new Millisecond();
        if(i <v.size())
            this.series.add(new Millisecond(), v.elementAt(i));
       
        System.out.println("Current Time in Milliseconds = " + now.toString()+", Current Value : "+this.lastValue);
    }

    /**
     * Starting point for the dynamic graph application.
     *
     * @param args  ignored.
     */
    public static void main(final String[] args) {

        final DynamicLineAndTimeSeriesChart demo = new DynamicLineAndTimeSeriesChart("Dynamic Line And TimeSeries Chart");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

}   