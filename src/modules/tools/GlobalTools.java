package modules.tools;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class GlobalTools {

    //remove word from string and return just numbers
    public String justDigits(String string) {
        StringBuilder result= new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) >= '0' && string.charAt(i) <= '9') {
                result.append(string.charAt(i));
            }
        }
        return result.toString();
    }

    //convert number format 240 to 24.0
    public String realPrice(String string) {
        return string.substring(0, string.length()-1) + ".0";
    }

    //refund method for personal information field
    public String makeRefund(String phoneNumber) {
        long number = Long.parseLong(phoneNumber);
        number*=7;
        String result = "IR0010" + Long.toString(number);
        //create refund and format is IR12345667894
        return result;
    }

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
        scene.getStylesheets().add("./pages/css/homePageStyle.css");
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
        scene.getStylesheets().add("./pages/css/homePageStyle.css");
        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
        primaryStage.setX(X);
        primaryStage.setY(Y);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.show();
    }

    //this method clearFields and set ""
    public void clearFields(TextField textField1, TextField textField2, TextField textField3, TextField textField4, TextArea textArea, PasswordField passwordField1, PasswordField passwordField2) {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textArea.setText("");
        passwordField1.setText("");
        passwordField2.setText("");
    }

    //this method close page without closing previous pages
    public void closeCurrentPage(Button button) {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }

    //this method connect to bankingPortal
    public void connectToBankingPortal() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader();
        fxmlLoader1.setLocation(getClass().getResource("/pages/bankingPortal/bankingPortal.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load());
        scene1.setFill(Color.TRANSPARENT);
        Stage stage1 = new Stage();
        stage1.setTitle("loading page");
        stage1.setScene(scene1);
        stage1.initStyle(StageStyle.TRANSPARENT);
        stage1.setX(650);
        stage1.setY(130);
        stage1.show();
    }
}
