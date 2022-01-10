package modules.tools;

import com.jfoenix.controls.JFXTextField;
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

    //show alert type of error
    private final Alert alert = new Alert(Alert.AlertType.ERROR);
    //set ERROR Alert with content
    public void AlertShow(String content) {
        //set header text of alerts
        alert.setHeaderText("Me and You app says:");
        alert.setContentText(content);
        alert.show();
    }

    //show alert type of information
    private final Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
    //set ERROR Alert with content
    public void AlertShowInformation(String content) {
        //set header text of alerts
        alert1.setHeaderText("Me and You app says:");
        alert1.setContentText(content);
        alert1.show();
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

    //Check that parameter is a digit
    public boolean OnlyDigits(String n) {
        for (int i = 0; i < n.length(); i++) {
            if (!Character.isDigit(n.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public void clearFields(JFXTextField textField, TextField textField1, TextField textField2, TextField textField3, TextField textField4, TextArea textArea) {
        textField.setText("");
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textArea.setText("");
    }

    public void clearFields(JFXTextField textField, TextField textField1, PasswordField textField2, PasswordField textField3, TextField textField4, TextField textField5, TextArea textArea) {
        textField.setText("");
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
        textArea.setText("");
    }

    //open new page and close current pages
    public void OpenNewPage(Button button, String roots, String title) throws IOException {
        Stage primaryStage = (Stage) button.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(roots));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("./pages/css/loginStyle.css");
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
        scene.getStylesheets().add("./pages/css/loginStyle.css");
        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
        primaryStage.setX(X);
        primaryStage.setY(Y);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.show();
    }

    //this method close page without closing previous pages
    public void closeCurrentPage(Button button, String currentPagePath) {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }

}
