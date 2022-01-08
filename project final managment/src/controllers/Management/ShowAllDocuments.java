package controllers.Management;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.text.Text;

public class ShowAllDocuments {

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
}

