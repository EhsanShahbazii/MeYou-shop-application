package controllers.customer;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Login {

    public void initialize() {

    }

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
        Stage primaryStage = (Stage) createNewAccountButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../../pages/customer/MainPage.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("You and Me");
        primaryStage.setScene(scene);
        primaryStage.setX(450);
        primaryStage.setY(100);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.show();
    }

    //this method used for limited characters in textField
    public void LimitedTextField(TextField textField, int maxLength){

        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (textField.getText().length() > maxLength) {
                    String s = textField.getText().substring(0, maxLength);
                    textField.setText(s);
                }
            }
        });
    }
}

