package controllers.Management;

import com.jfoenix.controls.JFXButton;
import controllers.Login.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import modules.tools.DigitalClock;
import modules.tools.GlobalFileTools;
import modules.tools.GlobalTools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Management {

    //variables which are used
    GlobalTools globalTools = new GlobalTools();
    GlobalFileTools globalFileTools = new GlobalFileTools();

    public void initialize() {
        getDataFromFile();

    }

    public void getDataFromFile() {
        //get current admin data from files
//        String[] userDataInformation = globalFileTools.returnSpecificUserInformation(Login.person.getUsername());
        String[] userDataInformation = {"Thomas Shelby", "m"};

        String customerFullName = userDataInformation[0]; //add adminFullName
        String customerUsername = userDataInformation[1]; //add customerUsername

        //get user profile image path
        String userProfileImagePath = globalFileTools.userImageProfilePath(customerUsername);

        //set data in own fields in personal information field
        fullNameTextField.setText(customerFullName);

        //get current date from DateTimeFormatter and LocalDateTime
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();

        DigitalClock digitalClock = new DigitalClock();
        digitalClock.LiveDateSwing(timeTextField);

        //set current date adn show it
        dateTextField.setText(dtf.format(now));

        //set user profile image
        File files = new File(userProfileImagePath);
        Image image = new Image(files.toURI().toString());
        //set image format in imageview
        profileImageView.setImage(image);
    }

    @FXML
    private JFXButton logoutButton;

    @FXML
    private JFXButton showAllCustomersButton;

    @FXML
    private JFXButton showAllAdminsButton;

    @FXML
    private JFXButton showAllDocumentButton;

    @FXML
    private JFXButton addNewDiscountButton;

    @FXML
    private JFXButton addNewAdminButton;

    @FXML
    private JFXButton showAllProductButton;

    @FXML
    private LineChart<?, ?> lineChart;

    @FXML
    private PieChart pieChart;

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
    void addNewAdminAction(ActionEvent event) {

    }

    @FXML
    void addNewDiscountAction(ActionEvent event) {

    }

    @FXML
    void changeProfileImageAction(ActionEvent event) throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser(); //create file chooser
        File file = fileChooser.showOpenDialog(null); //get file(pic) path

        if (file != null){
            String path;
            path = file.getAbsolutePath(); //take file path which is choose
            File files = new File(path); //convert path to file format
            //update new profile image path current customer
            globalFileTools.updateUserProfileImage(Login.person.getUsername(), path);
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please Select Picture"); //show Error alert
        }
    }

    @FXML
    void showAllAdminsAction(ActionEvent event) {

    }

    @FXML
    void showAllCustomersButton(ActionEvent event) {

    }

    @FXML
    void showAllDocumentButton(ActionEvent event) {

    }

    @FXML
    void showAllProductAction(ActionEvent event) {

    }

    public void logoutAction(ActionEvent event) throws IOException {
        globalTools.OpenNewPageXY(logoutButton, "/pages/login/LoginPage.fxml", "login", 650, 110);
    }
}
