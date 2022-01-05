package modules.tools;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class GlobalTools {

    //refund method for personal information field
    public String makeRefund(String phoneNumber) {
        long number = Long.parseLong(phoneNumber);
        number*=7;
        //create refund and format is IR12345667894
        String refund = "IR0010" + Long.toString(number);
        return refund;
    }

    private final Alert alert = new Alert(Alert.AlertType.ERROR);
    //set ERROR Alert with content
    public void AlertShow(String content) {
        //set header text of alerts
        alert.setHeaderText("Me and You app says:");
        alert.setContentText(content);
        alert.show();
    }

    //Check that parameter is a digit
    public boolean OnlyDigits(String n) {
        for (int i = 0; i < n.length(); i++) {
            if (!Character.isDigit(n.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    //this method move focus area when characters limited in int
    public void moveToNextFieldByLimited(TextField textField1, TextField textField2, int length) {
        textField1.textProperty().addListener((obs, oldText, newText) -> {
            if (oldText.length() < length && newText.length() >= length) {
                textField2.requestFocus();
            }
        });
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

    //this method used for limited characters in textArea
    public void LimitedTextArea(TextArea textArea, int maxLength){

        textArea.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (textArea.getText().length() > maxLength) {
                    String string = textArea.getText().substring(0, maxLength);
                    textArea.setText(string);
                }
            }
        });
    }

    //open new page and close current pages
    public void OpenNewPage(Button button, String roots, String title) throws IOException {
        Stage primaryStage = (Stage) button.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(roots));
        Scene scene = new Scene(root);
        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.show();
    }

    //open new page and close current pages
    public void OpenNewPageXY(Button button, String roots, String title, double X, double Y) throws IOException {
        Stage primaryStage = (Stage) button.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(roots));
        Scene scene = new Scene(root);
        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
        primaryStage.setX(X);
        primaryStage.setY(Y);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.show();
    }

    public void clearFields(TextField textField1, TextField textField2, TextField textField3, TextField textField4, TextArea textArea, PasswordField passwordField1, PasswordField passwordField2) {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textArea.setText("");
        passwordField1.setText("");
        passwordField2.setText("");
    }

}
