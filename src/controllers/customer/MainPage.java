package controllers.customer;

import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modules.files.SelectAndBuyProduct;
import modules.objects.Product;
import modules.tools.GlobalFileTools;
import modules.tools.GlobalTools;
import modules.tools.RandomData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainPage {

    //variables which are used
    public GlobalFileTools globalFileTools = new GlobalFileTools();
    public GlobalTools globalTools = new GlobalTools();
    public RandomData randomData = new RandomData();
    public SelectAndBuyProduct selectAndBuyProduct = new SelectAndBuyProduct();

    //static variables
    public static String chargeAmount = "0$";
    public static String refundMethod;
    public static String usernames, fullName, email, phoneNumber, address;

    //this list use for items of charge wallet combo box
    final ObservableList<String> walletComboBoxType = FXCollections.observableArrayList("10$", "20$", "50$", "100$", "500$", "Favorite");

    public void initialize() throws IOException {

        XYChart.Series<String, Double> series1 = new XYChart.Series<>();

        series1.setName("Bitcoin (BTC)");
        series1.getData().add(new XYChart.Data<>("Jan", 40521.0));
        series1.getData().add(new XYChart.Data<>("Feb", 42671.0));
        series1.getData().add(new XYChart.Data<>("Mar", 45785.0));
        series1.getData().add(new XYChart.Data<>("April", 46285.0));
        series1.getData().add(new XYChart.Data<>("May", 49528.0));
        series1.getData().add(new XYChart.Data<>("June", 54528.0));
        series1.getData().add(new XYChart.Data<>("July", 50646.0));
        series1.getData().add(new XYChart.Data<>("Sep", 47646.0));

        XYChart.Series<String, Double> series2 = new XYChart.Series<>();

        series2.setName("Ethereum (ETH)");
        series2.getData().add(new XYChart.Data<>("Jan", 34467.0));
        series2.getData().add(new XYChart.Data<>("Feb", 35867.0));
        series2.getData().add(new XYChart.Data<>("Mar", 36467.0));
        series2.getData().add(new XYChart.Data<>("April", 38467.0));
        series2.getData().add(new XYChart.Data<>("May", 34467.0));
        series2.getData().add(new XYChart.Data<>("June", 34117.0));
        series2.getData().add(new XYChart.Data<>("July", 34967.0));
        series2.getData().add(new XYChart.Data<>("Sep", 31967.0));

        XYChart.Series<String, Double> series3 = new XYChart.Series<>();

        series3.setName("Solana (SOL)");
        series3.getData().add(new XYChart.Data<>("Jan", 18575.0));
        series3.getData().add(new XYChart.Data<>("Feb", 19275.0));
        series3.getData().add(new XYChart.Data<>("Mar", 19975.0));
        series3.getData().add(new XYChart.Data<>("April", 22975.0));
        series3.getData().add(new XYChart.Data<>("May", 19575.0));
        series3.getData().add(new XYChart.Data<>("June", 18575.0));
        series3.getData().add(new XYChart.Data<>("July", 20575.0));
        series3.getData().add(new XYChart.Data<>("Sep", 27575.0));

        XYChart.Series<String, Double> series4 = new XYChart.Series<>();

        series4.setName("Solana (SOL)");
        series4.getData().add(new XYChart.Data<>("Jan", 8575.0));
        series4.getData().add(new XYChart.Data<>("Feb", 9275.0));
        series4.getData().add(new XYChart.Data<>("Mar", 9975.0));
        series4.getData().add(new XYChart.Data<>("April", 2975.0));
        series4.getData().add(new XYChart.Data<>("May", 3575.0));
        series4.getData().add(new XYChart.Data<>("June", 5575.0));
        series4.getData().add(new XYChart.Data<>("July", 13575.0));
        series4.getData().add(new XYChart.Data<>("Sep", 17575.0));

        currencyChart.getData().add(series1);
        currencyChart.getData().add(series2);
        currencyChart.getData().add(series3);
        currencyChart.getData().add(series4);



        //do this works when login is successful
        if (Login.loginIsDone) {
            //get personal information data from file
            getDataFromFile();

            //limit text field length
            globalTools.LimitedTextField(fullNameTextField, 20);
            globalTools.LimitedTextField(usernameTextField, 20);
            globalTools.LimitedTextField(emailTextField, 26);
            globalTools.LimitedTextField(phoneNumberTextField, 11);
            globalTools.LimitedTextArea(addressTextArea, 60);

            //set data in comboBox in wallet balance
            chargeComboBox.setItems(walletComboBoxType);
            chargeComboBox.getSelectionModel().select("Favorite");

            //get and save information in values
            usernames = Login.customer.getUsername();
            fullName = fullNameTextField.getText();
            email = emailTextField.getText();
            phoneNumber = phoneNumberTextField.getText();
            address = addressTextArea.getText();

            AdigitalField.setText(Double.toString(Double.parseDouble(walletBalanceTextField.getText())*0.000002));
            BitdigitalField.setText(Double.toString(Double.parseDouble(walletBalanceTextField.getText())*0.0007));
            CDigitalField.setText(Double.toString(Double.parseDouble(walletBalanceTextField.getText())*0.02));
            DdigitalField.setText(Double.toString(Double.parseDouble(walletBalanceTextField.getText())*0.000015));

            //read product information for set it in parts of suggest
            String[] productData = globalFileTools.fileAllRead("D:\\project final\\src\\files\\data\\ProductInformation.txt");

            //add product components in most popular anchorPane
            showProductDivs(productData, mostPopularAnchorPane, 0);

            //add product components in most todayDeal anchorPane
            showProductDivs(productData, todayDealAnchorPane, 20);

            //add product components in most suggest anchorPane
            showProductDivs(productData, suggestCartAnchorPane, 30);

            //add product component with add data in scroll pane
            showProductMain(productData, thisIsScroll);

            //create cart table columns and give it ids
            TableColumn productCode = new TableColumn("Code"); //code column
            productCode.setCellValueFactory(new PropertyValueFactory<>("productCode"));
            TableColumn productName = new TableColumn("Product Name"); //name column
            productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
            TableColumn productCount = new TableColumn("Count"); //count column
            productCount.setCellValueFactory(new PropertyValueFactory<>("productCount"));
            TableColumn productPrice = new TableColumn("Price"); //price column
            productPrice.setCellValueFactory(new PropertyValueFactory<>("productPrice"));

            //add columns in cart table javafx
            cartTable.getColumns().addAll(productCode, productName, productCount, productPrice);

            //add setOnSelectionChange refresh method for refresh cart data
            cartTab.setOnSelectionChanged(new EventHandler<Event>() {
                @Override
                public void handle(Event event) {
                    if (cartTab.isSelected()) {
                        try {
                            //refresh table data and show it
                            cartTable.getItems().clear();
                            refreshTable();
                        } catch (Exception exception) {
                            System.out.println(exception.toString());
                        }
                    }
                }
            });

            //add setOnSelectionChange refresh method for refresh wallet balance text
            dashboardTab.setOnSelectionChanged(new EventHandler<Event>() {
                @Override
                public void handle(Event event) {
                    if (dashboardTab.isSelected()) {
                        try {
                            //get personal information data from file
                            getDataFromFile();

                            //set wallet balance of customer in field
                            walletBalanceTextField.setText(globalFileTools.returnWalletBalance(usernames));

                            //get user profile image path
                            String userProfileImagePath = globalFileTools.userImageProfilePath(usernames);

                            //set user profile image
                            File files = new File(userProfileImagePath);
                            Image image = new Image(files.toURI().toString());
                            //set image format in imageview
                            imageviewProfile.setImage(image);
                        } catch (Exception exception) {
                            System.out.println(exception.toString());
                        }
                    }
                }
            });
        }
    }

    public void getDataFromFile() {
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

        //get user profile image path
        String userProfileImagePath = globalFileTools.userImageProfilePath(customerUsername);

        //set data in own fields in personal information field
        fullNameTextField.setText(customerFullName);
        usernameTextField.setText(customerUsername);
        emailTextField.setText(customerEmail);
        phoneNumberTextField.setText(customerPhoneNumber);
        addressTextArea.setText(customerAddress);
        refundMethodTextField.setText(customerRefund);

        //set wallet balance of customer in field
        walletBalanceTextField.setText(customerWallet);

        //set user profile image
        File files = new File(userProfileImagePath);
        Image image = new Image(files.toURI().toString());
        //set image format in imageview
        imageviewProfile.setImage(image);

    }

    //this method refresh cart table data
    public void refreshTable() {
        Product product = new Product();
        ObservableList<Product> data = selectAndBuyProduct.tableData(Login.customer.getUsername());
        //set amount of total price in amount text field
        totalAmountCartTextField.setText(selectAndBuyProduct.totalAmount(usernames));

        cartTable.setItems(data); //set data in cart table
    }

    //this is Exception methods for text field if they are empty or invalid
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

    //this is show product component in main part and suggest part
    public void showProductDivs(String[] productData, AnchorPane anchorPane, int type) throws IOException {

        for (int i = 0; i < 4; i++) {
            //load product anchor pane and control it
            FXMLLoader loader1 = new FXMLLoader(this.getClass().getResource("../../pages/customer/productAnchorPane.fxml"));

            Parent root1 = loader1.load(); //load parent
            ProductAnchorPane control1 = loader1.getController(); //get anchor pane controller

            //set data in product anchor pane text fields
            control1.getDetailsText().setText(productData[5*i + type]);
            control1.getPriceText().setText(productData[5*i+2 + type]);
            //set image in product anchor pane image view
            File file1 = new File(productData[5*i+4 + type]);
            Image image2 = new Image(file1.toURI().toString());
            control1.getImageViewProduct().setImage(image2);

            //these are margin variables
            double marginLeft = 45;
            double marginTop = 15;

            //set position for anchor pane
            AnchorPane.setLeftAnchor(root1, marginLeft + i * (marginLeft + control1.getAnchorPane().getPrefWidth()));
            AnchorPane.setTopAnchor(root1, marginTop);

            //add this anchor pane in main anchor pane
            anchorPane.getChildren().add(root1);
        }
    }

    //this method add all products in main page for showing
    public void showProductMain(String[] productData, AnchorPane anchorPane) throws IOException {

        int fileLength = globalFileTools.fileLengthCounter("D:\\project final\\src\\files\\data\\ProductInformation.txt");

        for (int i = 0; i < fileLength/5; i++) {
            //load product anchor pane and control it
            FXMLLoader loader1 = new FXMLLoader(this.getClass().getResource("../../pages/customer/productMainAnchorPane.fxml"));

            Parent root1 = loader1.load(); //load parent
            ProductMainAnchorPane control1 = loader1.getController(); //get anchor pane controller

            control1.getProductNameText().setText(productData[5*i]); //set product name
            control1.getAuthorText().setText(productData[5*i+1]); //set product  product author
            control1.getProductPriceText().setText(productData[5*i+2]); //set product price
            control1.getScoreText().setText(randomData.randomNumberCreatorRound(0, 5, 2));  //set product score
            control1.getCountScore().setText(randomData.randomNumberCreator(1,2000)); //set product count of vote

            //check it if product is unavailable or not
            if (productData[5*i+3].equals("0")){
                control1.getOnlyStockText().setText("Currently unavailable");
            }else {
                control1.getOnlyStockText().setText("Only " + productData[5*i+3] + " left in stock(more on the way)");
            }
            //set image in product anchor pane image view
            File file1 = new File(productData[5*i+4]);
            Image image2 = new Image(file1.toURI().toString());
            control1.getImageViewProduct().setImage(image2);

            //these are margin variables
//            double marginLeft = 15;
            double marginTop = 15;

            //set position for anchor pane
            AnchorPane.setTopAnchor(root1, marginTop + i * (marginTop + control1.getProductMainAnchorPane().getPrefHeight()));
            AnchorPane.setLeftAnchor(root1, 0.0);

            //add this anchor pane in main anchor pane
            anchorPane.getChildren().add(root1);
        }
    }

    @FXML
    public JFXTextField AdigitalField;

    @FXML
    public JFXTextField CDigitalField;

    @FXML
    public JFXTextField DdigitalField;

    @FXML
    public JFXTextField BitdigitalField;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    public AreaChart currencyChart;

    @FXML
    public JFXButton serviceButton;

    @FXML
    public JFXButton giftCardButton;

    @FXML
    public Button messageButton;

    @FXML
    public Button notificationButton;

    @FXML
    public Tab dashboardTab;

    @FXML
    public AnchorPane thisIsScroll;

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
    private TableView<Product> cartTable;

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
    public JFXToggleButton darkModeToggle;

    @FXML
    public void showServiceAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader();
        fxmlLoader1.setLocation(getClass().getResource("/pages/home/sevicePage.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load());
        scene1.setFill(Color.TRANSPARENT);
        Stage stage1 = new Stage();
        stage1.setTitle("message");
        stage1.setScene(scene1);
        stage1.initStyle(StageStyle.TRANSPARENT);
        stage1.setX(600);
        stage1.setY(300);
        stage1.show();
    }

    @FXML
    public void giftCardAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader();
        fxmlLoader1.setLocation(getClass().getResource("/pages/home/giftCardPage.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load());
        scene1.setFill(Color.TRANSPARENT);
        Stage stage1 = new Stage();
        stage1.setTitle("message");
        stage1.setScene(scene1);
        stage1.initStyle(StageStyle.TRANSPARENT);
        stage1.setX(640);
        stage1.setY(240);
        stage1.show();
    }

    @FXML
    public void showMessageAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader();
        fxmlLoader1.setLocation(getClass().getResource("/pages/home/messagePage.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load());
        scene1.setFill(Color.TRANSPARENT);
        Stage stage1 = new Stage();
        stage1.setTitle("message");
        stage1.setScene(scene1);
        stage1.initStyle(StageStyle.TRANSPARENT);
        stage1.setX(1050);
        stage1.setY(179);
        stage1.show();
    }

    @FXML
    public void showNotificationAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader();
        fxmlLoader1.setLocation(getClass().getResource("/pages/home/notificationPage.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load());
        scene1.setFill(Color.TRANSPARENT);
        Stage stage1 = new Stage();
        stage1.setTitle("notification");
        stage1.setScene(scene1);
        stage1.initStyle(StageStyle.TRANSPARENT);
        stage1.setX(1000);
        stage1.setY(179);
        stage1.show();
    }

    //dark mode toggle operations
    @FXML
    public void setToDarkMode(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) darkModeToggle.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/pages/customer/MainPage.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("./pages/css/darkMode.css");
        primaryStage.setTitle("Me and You");
        primaryStage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.show();
    }

    @FXML
    void deleteCartAction(ActionEvent event) throws FileNotFoundException {
        Product selectItem = cartTable.getSelectionModel().getSelectedItem();
        cartTable.getItems().remove(selectItem);
        selectAndBuyProduct.removeProductToCard(Login.customer.getUsername(), selectItem.getProductName());
    }

    @FXML
    void paymentCartAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader();
        fxmlLoader1.setLocation(getClass().getResource("/pages/bankingPortal/finalPaymentPage.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load());
        scene1.setFill(Color.TRANSPARENT);
        Stage stage1 = new Stage();
        stage1.setTitle("final payment");
        stage1.setScene(scene1);
        stage1.initStyle(StageStyle.TRANSPARENT);
        stage1.setX(650);
        stage1.setY(130);
        stage1.show();
    }

    @FXML
    void applyGiftAction(ActionEvent event) {

    }

    //use for charge wallet balance
    @FXML
    void chargeWalletAction(ActionEvent event) throws IOException {
        //set combo box select data and sent refund method
        chargeAmount = chargeComboBox.getValue();
        refundMethod = refundMethodTextField.getText();
        if (chargeAmount.equals("Favorite")) {
            globalTools.AlertShow("Please select your favorite amount");
        }else {
            //connect to banking portal
            globalTools.connectToBankingPortal();
        }
    }

    //use for change state of edit button in personal information part
    boolean reAgain = false;
    @FXML
    void editInformationAction(ActionEvent event) throws FileNotFoundException {
        if (reAgain) {
            //change button text to edit and change style
            editInformationButton.setText("Edit");
            //change color of edit button
            editInformationButton.setStyle("-fx-background-color: #0CF485; -fx-background-radius: 16px;");

            //text fields are not editable
            fullNameTextField.setEditable(false);
            emailTextField.setEditable(false);
            phoneNumberTextField.setEditable(false);
            addressTextArea.setEditable(false);
            exceptionForFields();
            reAgain = false; //change state
        }else {
            //change button text to done and change style
            editInformationButton.setText("Done");
            //change color of done button
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
        //post new data personal information for userInformation.txt files
        globalFileTools.updatePersonalInformation(usernames, fullNameTextField.getText(), emailTextField.getText(), phoneNumberTextField.getText(), addressTextArea.getText());
        globalTools.AlertShowInformation("Edit information is successful!"); //show successful alert
    }

    //close main page and open new login page
    @FXML
    void logoutAction(ActionEvent event) throws IOException {
        globalTools.OpenNewPageXY(chargeBtn, "../../pages/customer/LoginPage.fxml", "Login", 550, 250);
    }

    //change profile image by click on image view in profile
    @FXML
    void changeProfileImageAction(ActionEvent event) throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser(); //create file chooser
        File file = fileChooser.showOpenDialog(null); //get file(pic) path

        if (file != null){
            String path;
            path = file.getAbsolutePath(); //take file path which is choose
            File files = new File(path); //convert path to file format
            //update new profile image path current customer
            globalFileTools.updateUserProfileImage(usernameTextField.getText(), path);
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please Select Picture"); //show Error alert
        }
    }

}
