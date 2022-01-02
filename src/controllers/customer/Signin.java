package controllers.customer;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Signin {

    @FXML
    private JFXTextField emailTextField;

    @FXML
    private JFXButton createAccountButton;

    @FXML
    private JFXTextField phoneNumberTextField;

    @FXML
    private JFXTextField fullNameTextField;

    @FXML
    private JFXTextField usernameTextField;

    @FXML
    private JFXPasswordField passwordTextField;

    @FXML
    private JFXPasswordField repeatPasswordTextField;

    @FXML
    private JFXTextArea addressTextArea;

    @FXML
    private JFXButton backToLogin;

    @FXML
    void backToLogin(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) backToLogin.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../../pages/customer/LoginPage.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.show();
    }

    @FXML
    void createAccount(ActionEvent event) {

    }

}

