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

import java.net.URL;
import java.util.ResourceBundle;

public class ShowAllDocuments implements Initializable {

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

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //creating the series
        XYChart.Series series = new XYChart.Series();
//
//        //setting name and the date to the series
        series.setName("Stock Analysis");
        series.getData().add(new XYChart.Data("2009",25));
        series.getData().add(new XYChart.Data("2010",15));
        series.getData().add(new XYChart.Data("2011",68));
        series.getData().add(new XYChart.Data("2012",60));
        series.getData().add(new XYChart.Data("2013",35));
//
//        //adding series to the linechart
        profitLineGraph.getData().add(series);
    }
}

