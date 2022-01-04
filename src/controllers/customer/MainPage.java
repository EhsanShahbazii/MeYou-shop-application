package controllers.customer;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import modules.tools.GlobalFileTools;
import modules.tools.GlobalTools;

import java.io.File;
import java.io.IOException;

public class MainPage {

    //variables which are used
    public GlobalFileTools globalFileTools = new GlobalFileTools();
    public GlobalTools globalTools = new GlobalTools();

    final ObservableList<String> walletComboBoxType = FXCollections.observableArrayList("10$", "20$", "50$", "100$", "500$", "Favorite");

    public void initialize() {

        //do this works when login is successful
        if (Login.loginIsDone) {
            //get current customer data from files
            String[] userDataInformation = globalFileTools.returnSpecificUserInformation(Login.customer.getUsername());

            String customerFullName = userDataInformation[0]; //add customerFullName
            String customerUsername = userDataInformation[1]; //add customerUsername
            String customerEmail = userDataInformation[2]; //add customerEmail
            String customerPhoneNumber = userDataInformation[3]; //add customerPhoneNumber
            String customerAddress = userDataInformation[4]; //add customerAddress

            //get customer wallet balance
            String customerWallet = globalFileTools.returnWalletBalance(customerUsername);

            //create refund method of customer
            String customerRefund = globalTools.makeRefund(customerPhoneNumber);

            //set data in own fields in personal information field
            fullNameTextField.setText(customerFullName);
            usernameTextField.setText(customerUsername);
            emailTextField.setText(customerEmail);
            phoneNumberTextField.setText(customerPhoneNumber);
            addressTextArea.setText(customerAddress);
            refundMethodTextField.setText(customerRefund);

            //set wallet balance of customer in field
            walletBalanceTextField.setText(customerWallet);

            //limit text field length
            globalTools.LimitedTextField(fullNameTextField, 20);
            globalTools.LimitedTextField(usernameTextField, 20);
            globalTools.LimitedTextField(emailTextField, 26);
            globalTools.LimitedTextField(phoneNumberTextField, 11);
            globalTools.LimitedTextArea(addressTextArea, 60);

            //set data in comboBox in wallet balance
            chargeComboBox.setItems(walletComboBoxType);
            chargeComboBox.getSelectionModel().select("Favorite");

        }
    }

    public void exceptionForFields() {
        boolean state = false;
        //save text field data in variables
        String fullName = fullNameTextField.getText();
        String username = usernameTextField.getText();
        String email = emailTextField.getText();
        String phoneNumber = phoneNumberTextField.getText();
        String address = addressTextArea.getText();

        //check that the fields are full or not
        if (fullName.isEmpty())
            globalTools.AlertShow("Please enter your full name.");
        else if (email.isEmpty())
            globalTools.AlertShow("Please enter your email.");
        else if (phoneNumber.isEmpty())
            globalTools.AlertShow("Please enter your phone number.");
        else if (address.isEmpty())
            globalTools.AlertShow("Please enter your address.");
        else if (!globalTools.OnlyDigits(phoneNumber))
            globalTools.AlertShow("please enter just number in phone number.");
        else if (phoneNumber.length() < 11)
            globalTools.AlertShow("phone number should be 11 digits.");
        else
            state = true;
    }

    @FXML
    private Tab homeTab;

    @FXML
    private AnchorPane homeAnchorPane;

    @FXML
    private AnchorPane todayDealAnchorPane;

    @FXML
    private AnchorPane mostPopularAnchorPane;

    @FXML
    private Tab categoriesTab;

    @FXML
    private AnchorPane categoriesAnchorPane;

    @FXML
    private AnchorPane scrollCategoriesAnchorPane;

    @FXML
    private Tab cartTab;

    @FXML
    private AnchorPane cartAnchorPane;

    @FXML
    private TableView<?> cartTable;

    @FXML
    private AnchorPane suggestCartAnchorPane;

    @FXML
    private JFXTextField totalAmountCartTextField;

    @FXML
    private JFXTextField discountCartTextField;

    @FXML
    private JFXButton cartPaymentButton;

    @FXML
    private JFXButton deleteCartButton;

    @FXML
    private Tab digiCoinTab;

    @FXML
    private AnchorPane accountAnchorPane1;

    @FXML
    private JFXTextField digiCoinAmountTextField;

    @FXML
    private AnchorPane forMenCategories1121;

    @FXML
    private AnchorPane forMenCategories11211;

    @FXML
    private AnchorPane forMenCategories11212;

    @FXML
    private AnchorPane forMenCategories112111;

    @FXML
    private AnchorPane forMenCategories11213;

    @FXML
    private AnchorPane forMenCategories112112;

    @FXML
    private AnchorPane forMenCategories112121;

    @FXML
    private AnchorPane forMenCategories1121111;

    @FXML
    private JFXTextField digiCoinTicketTextField;

    @FXML
    private AnchorPane accountAnchorPane2;

    @FXML
    private JFXTextArea addressTextArea;

    @FXML
    private JFXButton editInformationButton;

    @FXML
    private JFXTextField walletBalanceTextField;

    @FXML
    private JFXButton chargeBtn;

    @FXML
    private JFXComboBox<String> chargeComboBox;

    @FXML
    private JFXTextField fullNameTextField;

    @FXML
    private JFXTextField phoneNumberTextField;

    @FXML
    private JFXTextField refundMethodTextField;

    @FXML
    private JFXTextField usernameTextField;

    @FXML
    private JFXTextField emailTextField;

    @FXML
    private JFXButton applyGiftButton;

    @FXML
    private JFXButton logoutButton;

    @FXML
    private Button profileImageButton;

    @FXML
    private ImageView imageviewProfile;

    @FXML
    void deleteCartAction(ActionEvent event) {

    }

    @FXML
    void paymentCartAction(ActionEvent event) {

    }

    @FXML
    void applyGiftAction(ActionEvent event) {

    }

    @FXML
    void chargeWalletAction(ActionEvent event) {

    }

    //use for change state of edit button in personal information part
    boolean reAgain = false;
    @FXML
    void editInformationAction(ActionEvent event) {
        if (reAgain) {
            //change button text to edit and change style
            editInformationButton.setText("Edit");
            editInformationButton.setStyle("-fx-background-color: #0CF485; -fx-background-radius: 16px;");

            //text fields are not editable
            fullNameTextField.setEditable(false);
            emailTextField.setEditable(false);
            phoneNumberTextField.setEditable(false);
            addressTextArea.setEditable(false);
            exceptionForFields();
            //change state
            reAgain = false;
        }else {
            //change button text to done and change style
            editInformationButton.setText("Done");
            editInformationButton.setStyle("-fx-background-color: #FFAB0F; -fx-background-radius: 16px;");

            //text fields are editable
            fullNameTextField.setEditable(true);
            emailTextField.setEditable(true);
            phoneNumberTextField.setEditable(true);
            addressTextArea.setEditable(true);
            exceptionForFields();
            //change state
            reAgain = true;
        }
    }

    @FXML
    void logoutAction(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) logoutButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../../pages/customer/LoginPage.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.setX(550);
        primaryStage.setY(250);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.show();
    }

    @FXML
    void changeProfileImageAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();   //create file chooser
        File file = fileChooser.showOpenDialog(null);   //get file(pic) path

        if (file != null){
            String path;
            path = file.getAbsolutePath();
            File files = new File(path);
            Image image = new Image(files.toURI().toString());
            imageviewProfile.setImage(image);
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please Select Picture");   //show Error alert
        }
    }

}
