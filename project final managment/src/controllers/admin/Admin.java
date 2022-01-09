package controllers.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import controllers.Login.Login;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modules.object.Product;
import modules.tools.DigitalClock;
import modules.tools.GlobalFileTools;
import modules.tools.GlobalTools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Admin {

    GlobalTools globalTools = new GlobalTools();
    GlobalFileTools globalFileTools = new GlobalFileTools();

    public void initialize() {
        getDataFromFile();

        //create cart table columns and give it ids
        TableColumn productCode = new TableColumn("Code"); //code column
        productCode.setCellValueFactory(new PropertyValueFactory<>("productCode"));
        TableColumn productName = new TableColumn("Product Name"); //name column
        productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        TableColumn productAuthor = new TableColumn("Product Author"); //name column
        productAuthor.setCellValueFactory(new PropertyValueFactory<>("productAuthor"));
        TableColumn productCount = new TableColumn("Price"); //count column
        productCount.setCellValueFactory(new PropertyValueFactory<>("productCount"));
        TableColumn productPrice = new TableColumn("Count"); //price column
        productPrice.setCellValueFactory(new PropertyValueFactory<>("productPrice"));
        //add columns in cart table javafx
        allProductTable.getColumns().addAll(productCode, productName, productAuthor, productCount, productPrice);

        setDataInTable();
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

    public void setDataInTable() {
        Product product = new Product();
        ObservableList<Product> data = globalFileTools.tableData();
        allProductTable.setItems(data); //set data in cart table
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
    private TableView<Product> allProductTable;

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
    void addProductAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader();
        fxmlLoader1.setLocation(getClass().getResource("/pages/admin/addNewProductPage.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load());
        scene1.setFill(Color.TRANSPARENT);
        Stage stage1 = new Stage();
        stage1.setTitle("add new product");
        stage1.setScene(scene1);
        stage1.initStyle(StageStyle.TRANSPARENT);
        stage1.setX(530);
        stage1.setY(120);
        stage1.show();
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
    void chargeProductAction(ActionEvent event) throws FileNotFoundException {
        if (productNewCountTextField.getText().isEmpty()) {
            globalTools.AlertShow("Please enter new product count");
        }else {
            Product selectItem = allProductTable.getSelectionModel().getSelectedItem();
            String productName = selectItem.getProductName();
            globalFileTools.chargeProductCount(productName, productNewCountTextField.getText());
            productNewCountTextField.setText("");
            globalTools.AlertShowInformation("Product(" + productName + ") charge successful.");
        }
    }

    @FXML
    void deleteProductAction(ActionEvent event) throws FileNotFoundException {
        Product selectItem = allProductTable.getSelectionModel().getSelectedItem();
        allProductTable.getItems().remove(selectItem);
        globalFileTools.removeProduct(selectItem.getProductName());
    }

    @FXML
    void showProductAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader();
        fxmlLoader1.setLocation(getClass().getResource("/pages/admin/showAllProductPage.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load());
        scene1.setFill(Color.TRANSPARENT);
        Stage stage1 = new Stage();
        stage1.setTitle("show all product");
        stage1.setScene(scene1);
        stage1.initStyle(StageStyle.TRANSPARENT);
        stage1.setX(530);
        stage1.setY(120);
        stage1.show();
    }

    public void logoutAction(ActionEvent event) throws IOException {
        globalTools.OpenNewPageXY(logoutButton, "/pages/login/LoginPage.fxml", "login", 650, 110);
    }
}
