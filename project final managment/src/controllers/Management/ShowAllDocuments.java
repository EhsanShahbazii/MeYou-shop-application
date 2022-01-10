package controllers.Management;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.text.Text;
import modules.charts.LineChartData;
import modules.tools.GlobalTools;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowAllDocuments implements Initializable {

    LineChartData lineChartData = new LineChartData();
    GlobalTools globalTools = new GlobalTools();

    @FXML
    private JFXButton exitButton;

    @FXML
    private LineChart<?, ?> profitLineGraph;

    @FXML
    private PieChart inventorycCrcleGraph;

    @FXML
    private Text taxationText;

    @FXML
    private Text totalAssetsText;

    @FXML
    void exitAction(ActionEvent event) {
        globalTools.closeCurrentPage(exitButton, "/pages/managment/showAllDocumentPage.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //creating the series
        XYChart.Series series = new XYChart.Series();
        series.setName("Profit from sales graph");

        String[] data = lineChartData.lineChartProductData();

        for (int i = 0; i <data.length/2.5; i = i+2) {
            double price = Double.parseDouble(data[i]);
            int real = (int) Math.round(price);
            series.getData().add(new XYChart.Data(Integer.toString(i+2009) + "/" + Integer.toString(i+1),Integer.parseInt(data[i+1])*real));
        }

       //adding series to the lineChart
        profitLineGraph.getData().add(series);
    }
}

