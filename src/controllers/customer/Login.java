package controllers.customer;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Login {

    @FXML
    private JFXTextField userNameTextField;

    @FXML
    private JFXButton LoginButton;

    @FXML
    private JFXPasswordField passwordTextField;

    @FXML
    private JFXButton createNewAccountButton;

    @FXML
    void createNewAccount(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) createNewAccountButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../../pages/customer/SigninPage.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Sign in");
        primaryStage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.show();
    }

    @FXML
    void login(ActionEvent event) throws IOException {

    }

}

