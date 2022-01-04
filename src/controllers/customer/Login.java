package controllers.customer;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import modules.files.LoginCustomer;
import modules.objects.Customer;
import modules.tools.GlobalFileTools;
import modules.tools.GlobalTools;

import java.io.IOException;
import java.util.Arrays;

public class Login {

    //variables which are used
    public static Customer customer = new Customer();
    public LoginCustomer loginCustomer = new LoginCustomer();
    public GlobalTools globalTools = new GlobalTools();
    String username, password;

    public void initialize() {
        //limit text field length
        globalTools.LimitedTextField(passwordTextField, 20);
        globalTools.LimitedTextField(userNameTextField, 20);
    }

    @FXML
    private JFXTextField userNameTextField;

    @FXML
    private JFXButton LoginButton;

    @FXML
    private JFXPasswordField passwordTextField;

    @FXML
    private JFXButton createNewAccountButton;

    //open sign in pages and close current page
    @FXML
    void createNewAccount(ActionEvent event) throws IOException {
        //open new sign in page and close login pages
        globalTools.OpenNewPage(LoginButton, "../../pages/customer/SigninPage.fxml", "Sign in");
    }

    //add login logic in below
    @FXML
    void login(ActionEvent event) throws IOException {

        //save text field data in variables
        username = userNameTextField.getText();
        password = passwordTextField.getText();

        // show error if fields are empty
        if (userNameTextField.getText().isEmpty())
           globalTools.AlertShow("please enter your username.");
        else if (passwordTextField.getText().isEmpty())
            globalTools.AlertShow("please enter your password.");
        else if (!loginCustomer.loginCheck(username, password)) {
            //checkToLogin() method checks is username and password are right or not
            globalTools.AlertShow("your username or password is incorrect.");
        } else {
            //set username and password of current customer
            customer.setUsername(username);
            customer.setPassword(password);

            //open new main page and close login pages
            globalTools.OpenNewPageXY(LoginButton, "../../pages/customer/MainPage.fxml", "You and Me", 450, 100);
        }
    }
}

