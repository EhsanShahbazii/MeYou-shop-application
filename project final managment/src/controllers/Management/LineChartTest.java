package controllers.Management;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
public class LineChartTest extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        //Defining Axis
        final NumberAxis xaxis = new NumberAxis(2008,2018,1);
        final NumberAxis yaxis = new NumberAxis(10,80,5);

        //Defining Label for Axis
        xaxis.setLabel("Year");
        yaxis.setLabel("Price");

        //Creating the instance of linechart with the specified axis
        LineChart linechart = new LineChart(xaxis,yaxis);

        //creating the series
        XYChart.Series series = new XYChart.Series();

        //setting name and the date to the series
        series.setName("Stock Analysis");
        series.getData().add(new XYChart.Data(2009,25));
        series.getData().add(new XYChart.Data(2010,15));
        series.getData().add(new XYChart.Data(2011,68));
        series.getData().add(new XYChart.Data(2012,60));
        series.getData().add(new XYChart.Data(2013,35));
        series.getData().add(new XYChart.Data(2014,55));
        series.getData().add(new XYChart.Data(2015,45));
        series.getData().add(new XYChart.Data(2016,67));
        series.getData().add(new XYChart.Data(2017,78));

        //adding series to the linechart
        linechart.getData().add(series);

        //setting Group and Scene
        Group root = new Group(linechart);
        Scene scene = new Scene(root,600,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("LineChart Example");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
