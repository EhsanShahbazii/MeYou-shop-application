package controllers.Management;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.text.Text;
import modules.charts.LineChartData;
import modules.charts.PieChartData;
import modules.tools.GlobalTools;

import javax.xml.crypto.Data;
import java.net.URL;
import java.util.ResourceBundle;

public class ShowAllDocuments implements Initializable {

    LineChartData lineChartData = new LineChartData();
    PieChartData pieChartData = new PieChartData();
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
        long totalAssets = 0;

        for (int i = 0; i <data.length/2.5; i = i+2) {
            double price = Double.parseDouble(data[i]);
            int real = (int) Math.round(price);
            totalAssets += real*Long.parseLong(data[i+1]);
            series.getData().add(new XYChart.Data(Integer.toString(i+2009) + "/" + Integer.toString(i+1),Integer.parseInt(data[i+1])*real));
        }

       //adding series to the lineChart
        profitLineGraph.getData().add(series);


        totalAssetsText.setText(String.valueOf(totalAssets*0.98) + "$");
        taxationText.setText(String.valueOf(totalAssets*0.17) + "$");

//        ObservableList<PieChart.Data> pieChartDate = pieChartData.PieChartProductData();
//        ObservableList<PieChart.Data> pieChartDate = FXCollections.observableArrayList(
//                new PieChart.Data("hellow", 1),
//                new PieChart.Data("hellow", 2),
//                new PieChart.Data("hoy", 3),
//                new PieChart.Data("hi", 4));

        inventorycCrcleGraph.setLegendSide(Side.LEFT);
        inventorycCrcleGraph.setTitle("inventory balance graph");
        inventorycCrcleGraph.setClockwise(false);
        inventorycCrcleGraph.setData(pieChartData.PieChartProductData());

    }


}

