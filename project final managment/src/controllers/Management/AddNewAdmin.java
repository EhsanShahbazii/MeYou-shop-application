package controllers.Management;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import modules.files.SigninAdmin;
import modules.tools.GlobalFileTools;
import modules.tools.GlobalTools;

import javax.swing.*;
import java.io.FileNotFoundException;

public class AddNewAdmin {

    //variables which are used
    GlobalTools globalTools = new GlobalTools();
    GlobalFileTools globalFileTools = new GlobalFileTools();
    SigninAdmin signinAdmin = new SigninAdmin();

    public void initialize() {

        //limit text field length
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
    private JFXButton addAdminButton;

    @FXML
    private JFXButton exitButton;

    @FXML
    private JFXTextField phoneNumberTextField;

    @FXML
    private JFXTextField usernameTextField;

    @FXML
    private JFXTextField fullNameTextField;

    @FXML
    private JFXTextArea addressTextArea;

    @FXML
    private JFXPasswordField passwordTextField;

    @FXML
    private JFXPasswordField repeatPasswordTextField;

    //this method add new admin in adminProfile.txt file
    @FXML
    void addAdminAction(ActionEvent event) throws FileNotFoundException {

        //save text field data in variables
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
        else if (signinAdmin.checkSameUserOrNot(username)) {
            //checkSameUserOrNot() methods check it username is repetitious or not
            globalTools.AlertShow("this admin is invalid. try another.");
        }else {
            //write all information of admin in adminProfile.txt file
            signinAdmin.signinNewCustomer(fullName, username, password, email, phoneNumber, address);

            //add default image path in new admin
            globalFileTools.addNewUserProfileImage(username);

            //show message when the register logic is not problem
            JOptionPane.showMessageDialog(null, "Registration was successful!", "Registration", JOptionPane.INFORMATION_MESSAGE);

            //clear text fields when register was successful
            globalTools.clearFields(fullNameTextField, usernameTextField, passwordTextField, repeatPasswordTextField, emailTextField, phoneNumberTextField, addressTextArea);
        }
    }

    //this method close current page(add new admin)
    @FXML
    void exitAction(ActionEvent event) {
        globalTools.closeCurrentPage(exitButton, "/pages/admin/showAllProductPage.fxml");
    }
}
