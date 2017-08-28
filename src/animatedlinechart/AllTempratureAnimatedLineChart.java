package animatedlinechart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javafx.application.Platform;
import javax.swing.JOptionPane;

public class AllTempratureAnimatedLineChart extends Application{
    static Stage s;
    public static String selectTemp;
    int count = 0;
    int maxTempId;
    int maxCount = 500;
    Vector<Double> v;

    private static final int MAX_DATA_POINTS = 5;
    private int xSeriesData = 0;
    private XYChart.Series<Number, Number> series1 = new XYChart.Series<>();
//    private XYChart.Series<Number, Number> series2 = new XYChart.Series<>();
//    private XYChart.Series<Number, Number> series3 = new XYChart.Series<>();
    private ExecutorService executor;
    private ConcurrentLinkedQueue<Number> dataQ1 = new ConcurrentLinkedQueue<>();
//    private ConcurrentLinkedQueue<Number> dataQ2 = new ConcurrentLinkedQueue<>();
//    private ConcurrentLinkedQueue<Number> dataQ3 = new ConcurrentLinkedQueue<>();

    private NumberAxis xAxis;

    public AllTempratureAnimatedLineChart() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public AllTempratureAnimatedLineChart(String selectTemp)
    {
        this.selectTemp = selectTemp;
    }

    
    public void getnumber()
    {
        System.out.println(""+selectTemp);
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

            System.out.println("value is "+selectTemp+"");
            
            String topTemsQueryy = "select t"+selectTemp+" from temp_tb1 where temp_id<=" + maxTempId + " AND temp_id>" + firstValue + " ";
            String topTemsQuery = topTemsQueryy; //"select t10 from temp_tb1 where temp_id<=" + maxTempId + " AND temp_id>" + firstValue + " ";
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

    private void init(Stage primaryStage) {
        setUpData();
        xAxis = new NumberAxis(0, MAX_DATA_POINTS, MAX_DATA_POINTS / 10);
        xAxis.setForceZeroInRange(false);
        xAxis.setAutoRanging(false);
        xAxis.setTickLabelsVisible(false);
        xAxis.setTickMarkVisible(false);
        xAxis.setMinorTickVisible(false);

        NumberAxis yAxis = new NumberAxis();

        // Create a LineChart
        final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis) {
            // Override to remove symbols on each data point
            @Override
            protected void dataItemAdded(Series<Number, Number> series, int itemIndex, Data<Number, Number> item) {
            }
        };

        lineChart.setAnimated(false);
        lineChart.setTitle("Animated Line Chart");
        lineChart.setHorizontalGridLinesVisible(true);

        // Set Name for Series
        series1.setName("Temrature - 1");
//        series2.setName("Series 2");
//        series3.setName("Series 3");

        // Add Chart Series
        lineChart.getData().addAll(series1);

        primaryStage.setScene(new Scene(lineChart));
    }

    @Override
    public void start(Stage stage) {
        this.s = stage;
        stage.setTitle("Animated Line Chart Sample");
        init(stage);
        stage.show();

        executor = Executors.newCachedThreadPool(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setDaemon(true);
                return thread;
            }
        });

        AddToQueue addToQueue = new AddToQueue();
        executor.execute(addToQueue);
        //-- Prepare Timeline
        prepareTimeline();
    }

    @Override
    public void stop() throws Exception {
        super.stop(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Stop callled");
        Platform.exit();
        System.out.println("After callled");
    }

    
    public void setTemp(String sTemp)
    {
    
    selectTemp = sTemp;
    System.out.println(sTemp);
    }

    private class AddToQueue implements Runnable {

        public void run() {
            try {
                // add a item of random data to queue
                if (count < v.size()) {
                    dataQ1.add(v.elementAt(count));
                    count++;
                }
//                dataQ2.add(Math.random());
//                dataQ3.add(Math.random());

                Thread.sleep(100);
                executor.execute(this);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    //-- Timeline gets called in the JavaFX Main thread
    private void prepareTimeline() {
        // Every frame to take any data from queue and add to chart
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                addDataToSeries();
            }
        }.start();
    }

    private void addDataToSeries() {
        for (int i = 0; i < 20; i++) { //-- add 20 numbers to the plot+
            if (dataQ1.isEmpty()) {
                break;
            }
            series1.getData().add(new XYChart.Data<>(xSeriesData++, dataQ1.remove()));
//            series2.getData().add(new XYChart.Data<>(xSeriesData++, dataQ2.remove()));
//            series3.getData().add(new XYChart.Data<>(xSeriesData++, dataQ3.remove()));
        }
        // remove points to keep us at no more than MAX_DATA_POINTS
        if (series1.getData().size() > MAX_DATA_POINTS) {
            series1.getData().remove(0, series1.getData().size() - MAX_DATA_POINTS);
        }
//        if (series2.getData().size() > MAX_DATA_POINTS) {
//            series2.getData().remove(0, series2.getData().size() - MAX_DATA_POINTS);
//        }
//        if (series3.getData().size() > MAX_DATA_POINTS) {
//            series3.getData().remove(0, series3.getData().size() - MAX_DATA_POINTS);
//        }
        // update
        xAxis.setLowerBound(xSeriesData - MAX_DATA_POINTS);
        xAxis.setUpperBound(xSeriesData - 1);
        
    }

    public static void main(String[] args) {
        launch(args);        
    }
}
