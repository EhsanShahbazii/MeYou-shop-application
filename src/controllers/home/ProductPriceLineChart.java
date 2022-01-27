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
import modules.objects.Product;
import modules.tools.GlobalTools;
import modules.tools.RandomData;

public class ProductPriceLineChart {

    GlobalTools globalTools = new GlobalTools();
    RandomData randomData = new RandomData();

    public void initialize() {
        //set series for area chart and show it
        XYChart.Series<String, Double> series1 = new XYChart.Series<>();

        double[] array = randomData.create7RandomNumbers();
        double productPrice = Double.parseDouble(ProductAnchorPane.price);

        //set series data for show
        series1.setName(ProductAnchorPane.productName);
        series1.getData().add(new XYChart.Data<>("Jan", productPrice));
        series1.getData().add(new XYChart.Data<>("Feb", productPrice + array[0]));
        series1.getData().add(new XYChart.Data<>("Mar", productPrice + array[1]));
        series1.getData().add(new XYChart.Data<>("April", productPrice + array[2]));
        series1.getData().add(new XYChart.Data<>("May", productPrice + array[3]));
        series1.getData().add(new XYChart.Data<>("June", productPrice + array[4]));
        series1.getData().add(new XYChart.Data<>("July", productPrice + array[5]));
        series1.getData().add(new XYChart.Data<>("Sep", productPrice + array[6]));

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

