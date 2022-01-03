package controllers.customer;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import modules.files.SigninCustomer;
import modules.tools.GlobalTools;

import java.io.IOException;

public class Signin {

    SigninCustomer signinCustomer = new SigninCustomer();
    GlobalTools globalTools = new GlobalTools();

    public void initialize() {
        globalTools.LimitedTextField(fullNameTextField, 20);
        globalTools.LimitedTextField(usernameTextField, 20);
        globalTools.LimitedTextField(passwordTextField, 20);
        globalTools.LimitedTextField(repeatPasswordTextField, 20);
        globalTools.LimitedTextField(emailTextField, 26);
        globalTools.LimitedTextField(phoneNumberTextField, 11);
        globalTools.LimitedTextArea(addressTextArea, 60);
    }

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
        globalTools.OpenNewPage(backToLogin, "../../pages/customer/LoginPage.fxml", "Login");
    }

    @FXML
    void createAccount(ActionEvent event) {

        //check that the fields are full or not
        if (fullNameTextField.getText().isEmpty())
            globalTools.AlertShow("Please enter your full name.");
        else if (usernameTextField.getText().isEmpty())
            globalTools.AlertShow("Please enter your username.");
        else if (passwordTextField.getText().isEmpty())
            globalTools.AlertShow("Please enter your password.");
        else if (repeatPasswordTextField.getText().isEmpty())
            globalTools.AlertShow("Please repeat your password.");
        else if (emailTextField.getText().isEmpty())
            globalTools.AlertShow("Please enter your email.");
        else if (phoneNumberTextField.getText().isEmpty())
            globalTools.AlertShow("Please enter your phone number.");
        else if (addressTextArea.getText().isEmpty())
            globalTools.AlertShow("Please enter your address.");
        else if (!(passwordTextField.getText().equals(repeatPasswordTextField.getText())))
            globalTools.AlertShow("password and repeat password not equals.");
        else if (!globalTools.OnlyDigits(phoneNumberTextField.getText()))
            globalTools.AlertShow("please enter just number in phone number.");
        else if (phoneNumberTextField.getText().length() < 11)
            globalTools.AlertShow("phone number should be 11 digits.");
        else if (signinCustomer.checkSameUserOrNot(usernameTextField.getText())) {
            //checkSameUserOrNot() methods check it username is repetitious or not
            globalTools.AlertShow("this username in invalid. try another.");
        }else {
            signinCustomer.usernameAndPasswordOfNewCustomer(usernameTextField.getText(), passwordTextField.getText());
            

            globalTools.clearFields(fullNameTextField, usernameTextField, emailTextField, phoneNumberTextField, addressTextArea, passwordTextField, repeatPasswordTextField);
        }
    }
}

