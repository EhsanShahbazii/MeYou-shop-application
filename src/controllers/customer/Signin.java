package controllers.customer;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import modules.files.SigninCustomer;
import modules.tools.GlobalTools;

import javax.swing.*;
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

        String fullName = fullNameTextField.getText();
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        String repeatPassword = repeatPasswordTextField.getText();
        String email = emailTextField.getText();
        String phoneNumber = phoneNumberTextField.getText();
        String address = addressTextArea.getText();

        //check that the fields are full or not
        if (fullName.isEmpty())
            globalTools.AlertShow("Please enter your full name.");
        else if (username.isEmpty())
            globalTools.AlertShow("Please enter your username.");
        else if (password.isEmpty())
            globalTools.AlertShow("Please enter your password.");
        else if (repeatPassword.isEmpty())
            globalTools.AlertShow("Please repeat your password.");
        else if (email.isEmpty())
            globalTools.AlertShow("Please enter your email.");
        else if (phoneNumber.isEmpty())
            globalTools.AlertShow("Please enter your phone number.");
        else if (address.isEmpty())
            globalTools.AlertShow("Please enter your address.");
        else if (!password.equals(repeatPassword))
            globalTools.AlertShow("password and repeat password not equals.");
        else if (!globalTools.OnlyDigits(phoneNumber))
            globalTools.AlertShow("please enter just number in phone number.");
        else if (phoneNumber.length() < 11)
            globalTools.AlertShow("phone number should be 11 digits.");
        else if (signinCustomer.checkSameUserOrNot(username)) {
            //checkSameUserOrNot() methods check it username is repetitious or not
            globalTools.AlertShow("this username in invalid. try another.");
        }else {
            signinCustomer.usernameAndPasswordOfNewCustomer(username, password);
            signinCustomer.signinNewCustomer(fullName, username, password, email, phoneNumber, address);
            JOptionPane.showMessageDialog(null, "Registration was successful!", "Registration", JOptionPane.INFORMATION_MESSAGE);

            globalTools.clearFields(fullNameTextField, usernameTextField, emailTextField, phoneNumberTextField, addressTextArea, passwordTextField, repeatPasswordTextField);
        }
    }
}

