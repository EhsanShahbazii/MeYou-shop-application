package controllers.customer;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import modules.tools.GlobalFileTools;
import modules.tools.GlobalTools;

import java.io.IOException;

public class MainPage {

    public GlobalFileTools globalFileTools = new GlobalFileTools();
    public GlobalTools globalTools = new GlobalTools();

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

            //create refund method of customer
            String customerRefund = globalTools.makeRefund(customerPhoneNumber);

            //set data in own fields in personal information field
            fullNameTextField.setText(customerFullName);
            usernameTextField.setText(customerUsername);
            emailTextField.setText(customerEmail);
            phoneNumberTextField.setText(customerPhoneNumber);
            addressTextArea.setText(customerAddress);
            refundMethodTextField.setText(customerRefund);
        }
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
    private JFXComboBox<?> chargeComboBox;

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
    void applyGiftAction(ActionEvent event) {

    }

    @FXML
    void chargeWalletAction(ActionEvent event) {

    }

    @FXML
    void deleteCartAcion(ActionEvent event) {

    }

    boolean reAgain = false;
    @FXML
    void editInformationAction(ActionEvent event) {
        if (reAgain) {
            editInformationButton.setText("Edit");
            editInformationButton.setStyle("-fx-background-color: #0CF485; -fx-background-radius: 16px;");

            fullNameTextField.setEditable(false);
            emailTextField.setEditable(false);
            phoneNumberTextField.setEditable(false);
            addressTextArea.setEditable(false);
            reAgain = false;
        }else {
            editInformationButton.setText("Done");
            editInformationButton.setStyle("-fx-background-color: #FFAB0F; -fx-background-radius: 16px;");

            fullNameTextField.setEditable(true);
            emailTextField.setEditable(true);
            phoneNumberTextField.setEditable(true);
            addressTextArea.setEditable(true);
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
    void paymentCartAction(ActionEvent event) {

    }

}
