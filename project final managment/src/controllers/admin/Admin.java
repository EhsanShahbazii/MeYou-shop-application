package controllers.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import controllers.Login.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import modules.tools.GlobalFileTools;
import modules.tools.GlobalTools;

import java.io.File;
import java.io.IOException;

public class Admin {

    GlobalTools globalTools = new GlobalTools();
    GlobalFileTools globalFileTools = new GlobalFileTools();

    public void initialize() {
        getDataFromFile();
    }

    public void getDataFromFile() {
        //get current customer data from files
        String[] userDataInformation = globalFileTools.returnSpecificUserInformation(Login.person.getUsername());

        String customerFullName = userDataInformation[0]; //add customerFullName
        String customerUsername = userDataInformation[1]; //add customerUsername

        //get user profile image path
        String userProfileImagePath = globalFileTools.userImageProfilePath(customerUsername);

        //set data in own fields in personal information field
        fullNameTextField.setText(customerFullName);

        //set user profile image
        File files = new File(userProfileImagePath);
        Image image = new Image(files.toURI().toString());
        //set image format in imageview
        profileImageView.setImage(image);

    }

    @FXML
    public JFXButton logoutButton;

    @FXML
    private JFXButton addProductButton;

    @FXML
    private JFXButton deleteProductButton;

    @FXML
    private JFXButton chargeProductButton;

    @FXML
    private TableView<?> allProductTable;

    @FXML
    private JFXTextField productNewCountTextField;

    @FXML
    private JFXButton showProductButton1;

    @FXML
    private Button changeImageButton;

    @FXML
    private ImageView profileImageView;

    @FXML
    private Text fullNameTextField;

    @FXML
    private Text timeTextField;

    @FXML
    private Text dateTextField;

    @FXML
    void addProductAction(ActionEvent event) {

    }

    @FXML
    void changeProfileImageAction(ActionEvent event) {

    }

    @FXML
    void chargeProductAction(ActionEvent event) {

    }

    @FXML
    void deleteProductAction(ActionEvent event) {

    }

    @FXML
    void showProductAction(ActionEvent event) {

    }

    public void logoutAction(ActionEvent event) throws IOException {
        globalTools.OpenNewPageXY(logoutButton, "/pages/login/LoginPage.fxml", "login", 650, 110);
    }
}
