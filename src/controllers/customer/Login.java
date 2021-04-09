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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modules.objects.Customer;

import java.io.IOException;

public class Login {

    //variables which are used
    public static Customer customer = new Customer();
    private final Alert alert = new Alert(Alert.AlertType.ERROR);

    public void initialize() {
        LimitedTextField(passwordTextField, 20);
        LimitedTextField(userNameTextField, 20);
        alert.setHeaderText("Me and You app says:");
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

        if (userNameTextField.getText().isEmpty()) {
           AlertShow("please enter your username.");
        }else if (passwordTextField.getText().isEmpty()) {
            AlertShow("please enter your password.");
        }
//        else if (checkToLogin() == false) {
//            //checkToLogin method checks is username and password are right or not
//            AlertShow("your username or password is incorrect.");
//        }
        else {
            //set username and password of current customer
            customer.setUsername(userNameTextField.getText());
            customer.setPassword(passwordTextField.getText());

            //open new main page and close login pages
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

    }

    //set ERROR Alert with content
    public void AlertShow(String content) {
        alert.setContentText(content);
        alert.show();
    }

    //this method used for limited characters in textField
    public void LimitedTextField(TextField textField, int maxLength){

        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (textField.getText().length() > maxLength) {
                    String string = textField.getText().substring(0, maxLength);
                    textField.setText(string);
                }
            }
        });
    }
}

