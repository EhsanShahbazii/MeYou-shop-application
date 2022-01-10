package controllers.Management;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import modules.tools.GlobalFileTools;
import modules.tools.GlobalTools;

public class AddNewAdmin {

    //variables which are used
    GlobalTools globalTools = new GlobalTools();
    GlobalFileTools globalFileTools = new GlobalFileTools();

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

    @FXML
    void addAdminAction(ActionEvent event) {

    }

    @FXML
    void exitAction(ActionEvent event) {
        globalTools.closeCurrentPage(exitButton, "/pages/admin/showAllProductPage.fxml");
    }

}
