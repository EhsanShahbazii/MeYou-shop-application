package controllers.home;

import com.jfoenix.controls.JFXButton;
import controllers.customer.ProductAnchorPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import modules.tools.GlobalTools;

public class ProductPriceLineChart {

    GlobalTools globalTools = new GlobalTools();

    public void initialize() {
        //set series for area chart and show it
        XYChart.Series<String, Double> series1 = new XYChart.Series<>();

        //set series data for show
        series1.setName(ProductAnchorPane.productName);
        series1.getData().add(new XYChart.Data<>("Jan", 18.0));
        series1.getData().add(new XYChart.Data<>("Feb", 21.0));
        series1.getData().add(new XYChart.Data<>("Mar", 17.0));
        series1.getData().add(new XYChart.Data<>("April", 7.0));
        series1.getData().add(new XYChart.Data<>("May", 18.0));
        series1.getData().add(new XYChart.Data<>("June", 22.0));
        series1.getData().add(new XYChart.Data<>("July", 23.0));
        series1.getData().add(new XYChart.Data<>("Sep", 16.0));

        lineChart.getData().add(series1);
    }

    @FXML
    private JFXButton backServiceButton;

    @FXML
    private AreaChart<String, Double> lineChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    void backServiceAction(ActionEvent event) {
        globalTools.closeCurrentPage(backServiceButton);
    }

}

