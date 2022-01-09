package controllers.Login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import modules.files.LoginCheck;
import modules.object.Person;
import modules.tools.GlobalTools;

import java.io.IOException;

public class Login {

    public static Person person = new Person();
    public GlobalTools globalTools = new GlobalTools();
    public LoginCheck loginCheck = new LoginCheck();
    String username, password, toggle = "management";
    public static boolean loginIsDone = false;

    public void initialize() {
        //limit text field length
        globalTools.LimitedTextField(passwordTextField, 20);
        globalTools.LimitedTextField(usernameTextField, 20);
    }

    @FXML
    private JFXToggleButton chooseToggle;

    @FXML
    private JFXTextField usernameTextField;

    @FXML
    private JFXPasswordField passwordTextField;

    @FXML
    private JFXButton loginButton;

    @FXML
    void LoginAction(ActionEvent event) throws IOException {

        //save text field data in variables
        username = usernameTextField.getText();
        password = passwordTextField.getText();

        // show error if fields are empty
        if (usernameTextField.getText().isEmpty())
            globalTools.AlertShow("please enter your username.");
        else if (passwordTextField.getText().isEmpty())
            globalTools.AlertShow("please enter your password.");
        else if (!loginCheck.loginCheck(username, password, toggle)) {
            //checkToLogin() method checks is username and password  and toggle are right or not
            globalTools.AlertShow("your username or password is incorrect.");
        } else {
            //set username and password of current customer
            person.setUsername(username);
            person.setPassword(password);
            person.setToggle(toggle);
            loginIsDone = true;
            if (toggle.equals("management")) {
                //open new management page and close login pages
                globalTools.OpenNewPageXY(loginButton, "/pages/managment/managementPage.fxml", "management", 450, 110);
            } else {
                //open new admin page and close login pages
                globalTools.OpenNewPageXY(loginButton, "/pages/admin/adminPage.fxml", "admin", 450, 110);
            }
        }
    }

    @FXML
    void toggleAction(ActionEvent event) {
        if (chooseToggle.isSelected()) {
            toggle = "admin";
        }else {
            toggle = "management";
        }

    }

}
