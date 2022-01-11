package controllers.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import controllers.Login.Login;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import modules.object.Product;
import modules.tools.DigitalTime;
import modules.tools.GlobalFileTools;
import modules.tools.GlobalTools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Admin {

    //variables which are used
    GlobalTools globalTools = new GlobalTools();
    GlobalFileTools globalFileTools = new GlobalFileTools();
    DigitalTime digitalTime = new DigitalTime();

    public void initialize() {

        //get admin some data from userInformation.txt file
        getDataFromFile();

        //create product table columns and give it ids
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
        //add columns in product table javafx
        allProductTable.getColumns().addAll(productCode, productName, productAuthor, productCount, productPrice);

        //refresh table data and show it
        setDataInTable();

        //set live time and date data in fields
        digitalTime.LiveTimeDate(timeTextField, dateTextField);
    }

    /*get admin fullName, username and some other data
     like user image path and set it in imageview*/
    public void getDataFromFile() {
        //get current admin data from files
        String[] AdminDataInformation = globalFileTools.returnSpecificUserInformation(Login.person.getUsername());

        String adminFullName = AdminDataInformation[0]; //add adminFullName
        String adminUsername = AdminDataInformation[1]; //add adminUsername

        //get admin profile image path
        String userProfileImagePath = globalFileTools.userImageProfilePath(adminUsername);

        //set admin full name in fullNameTextField
        fullNameTextField.setText(adminFullName);

        //set admin profile image and show it
        File files = new File(userProfileImagePath);
        Image image = new Image(files.toURI().toString());
        //set image format in imageview
        profileImageView.setImage(image);
    }

    //this method refresh all product table data
    public void setDataInTable() {
        Product product = new Product();
        ObservableList<Product> data = globalFileTools.tableData();
        allProductTable.setItems(data); //set data in product table
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

    //this method open a page and adding new product in file
    @FXML
    void addProductAction(ActionEvent event) throws IOException {
        globalTools.openNewPageWithoutCloseCurrentPage("/pages/admin/addNewProductPage.fxml", "add new product");
    }

    //this method changing profile image
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

    //this method charge product count in store
    @FXML
    void chargeProductAction(ActionEvent event) throws FileNotFoundException {
        //show error if admin isn't set product count in field
        if (productNewCountTextField.getText().isEmpty()) {
            globalTools.AlertShow("Please enter new product count");
        }else {
            //get selected product and get name of it
            Product selectItem = allProductTable.getSelectionModel().getSelectedItem();
            String productName = selectItem.getProductName();
            //charge new product count and show it
            globalFileTools.chargeProductCount(productName, productNewCountTextField.getText());
            productNewCountTextField.setText(""); //clear product new count field
            globalTools.AlertShowInformation("Product(" + productName + ") charge successful.");
        }
    }

    //delete product witch select by admin
    @FXML
    void deleteProductAction(ActionEvent event) throws FileNotFoundException {
        //get selected product in table
        Product selectItem = allProductTable.getSelectionModel().getSelectedItem();
        allProductTable.getItems().remove(selectItem); //remove it in table
        //delete it in productInformation file
        globalFileTools.removeProduct(selectItem.getProductName());
    }

    //this method open a page and show all product
    @FXML
    void showProductAction(ActionEvent event) throws IOException {
        globalTools.openNewPageWithoutCloseCurrentPage("/pages/admin/showAllProductPage.fxml", "show all product");
    }

    //this method close current page and open login page
    @FXML
    public void logoutAction(ActionEvent event) throws IOException {
        globalTools.OpenNewPageXY(logoutButton, "/pages/login/LoginPage.fxml", "login", 650, 110);
    }
}
