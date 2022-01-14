package controllers.home;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;

public class ProductPriceLineChart {

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

