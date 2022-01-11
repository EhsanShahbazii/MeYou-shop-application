package controllers.Management;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.text.Text;
import modules.charts.LineChartData;
import modules.charts.PieChartData;
import modules.tools.GlobalTools;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowAllDocuments implements Initializable {

    //variables which are used
    LineChartData lineChartData = new LineChartData();
    PieChartData pieChartData = new PieChartData();
    GlobalTools globalTools = new GlobalTools();

    //implements initialize
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //creating the series
        XYChart.Series series = new XYChart.Series();
        //set name for series
        series.setName("Profit from sales graph");

        //get data from files
        String[] data = lineChartData.lineChartProductData();
        long totalAssets = 0;

        //setting data into line chart
        for (int i = 0; i <data.length/2.5; i = i+2) {
            //convert to needed format
            double price = Double.parseDouble(data[i]);
            int real = (int) Math.round(price);
            totalAssets += real*Long.parseLong(data[i+1]);
            //add data into series
            series.getData().add(new XYChart.Data(Integer.toString(i+2009) + "/" + Integer.toString(i+1),Integer.parseInt(data[i+1])*real));
        }

        //adding series to the lineChart
        profitLineGraph.getData().add(series);

        //setting data into total and taxation fields
        totalAssetsText.setText(String.valueOf(totalAssets*0.8) + "$");
        taxationText.setText(String.valueOf(totalAssets*0.2) + "$");

        //add some attribute for inventory pie graph
        inventoryPieGraph.setLegendSide(Side.LEFT);
        inventoryPieGraph.setTitle("inventory balance graph");
        inventoryPieGraph.setClockwise(false);

        //set data in pie chart
        inventoryPieGraph.setData(pieChartData.PieChartProductData());
    }

    @FXML
    private JFXButton exitButton;

    @FXML
    private LineChart<?, ?> profitLineGraph;

    @FXML
    private PieChart inventoryPieGraph;

    @FXML
    private Text taxationText;

    @FXML
    private Text totalAssetsText;

    //this method close current page(show all document)
    @FXML
    void exitAction(ActionEvent event) {
        globalTools.closeCurrentPage(exitButton);
    }
}

