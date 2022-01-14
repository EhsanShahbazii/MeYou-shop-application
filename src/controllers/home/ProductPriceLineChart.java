package controllers.home;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class ProductPriceLineChart {

    public void initialize() {
        //set series for area chart and show it
        XYChart.Series<String, Double> series1 = new XYChart.Series<>();

        //set series data for show
        series1.setName("Bitcoin (BTC)");
        series1.getData().add(new XYChart.Data<>("Jan", 40521.0));
        series1.getData().add(new XYChart.Data<>("Feb", 42671.0));
        series1.getData().add(new XYChart.Data<>("Mar", 45785.0));
        series1.getData().add(new XYChart.Data<>("April", 46285.0));
        series1.getData().add(new XYChart.Data<>("May", 49528.0));
        series1.getData().add(new XYChart.Data<>("June", 54528.0));
        series1.getData().add(new XYChart.Data<>("July", 50646.0));
        series1.getData().add(new XYChart.Data<>("Sep", 47646.0));
    }

    @FXML
    private JFXButton backServiceButton;

    @FXML
    private AreaChart<?, ?> lineChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    void backServiceAction(ActionEvent event) {

    }

}

