package controllers.Management;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import modules.tools.GlobalTools;

import java.io.IOException;

public class Management {

    GlobalTools globalTools = new GlobalTools();

    @FXML
    private JFXButton logoutButton;

    @FXML
    private JFXButton showAllCustomersButton;

    @FXML
    private JFXButton showAllAdminsButton;

    @FXML
    private JFXButton showAllDocumentButton;

    @FXML
    private JFXButton addNewDiscountButton;

    @FXML
    private JFXButton addNewAdminButton;

    @FXML
    private JFXButton showAllProductButton;

    @FXML
    private LineChart<?, ?> lineChart;

    @FXML
    private PieChart pieChart;

    @FXML
    private Button changeImageButton;

    @FXML
    private ImageView profileImageView;

    @FXML
    private Text fullNameTextField;

    @FXML
    private Text timeTextField;

    @FXML
    private Text dateTextField;

    @FXML
    void addNewAdminAction(ActionEvent event) {

    }

    @FXML
    void addNewDiscountAction(ActionEvent event) {

    }

    @FXML
    void changeProfileImageAction(ActionEvent event) {

    }

    @FXML
    void showAllAdminsAction(ActionEvent event) {

    }

    @FXML
    void showAllCustomersButton(ActionEvent event) {

    }

    @FXML
    void showAllDocumentButton(ActionEvent event) {

    }

    @FXML
    void showAllProductAction(ActionEvent event) {

    }

    public void logoutAction(ActionEvent event) throws IOException {
        globalTools.OpenNewPageXY(logoutButton, "/pages/login/LoginPage.fxml", "login", 650, 110);
    }
}
