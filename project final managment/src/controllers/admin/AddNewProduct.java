package controllers.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import modules.tools.GlobalFileTools;
import modules.tools.GlobalTools;

import javax.swing.*;
import java.io.File;

public class AddNewProduct {

    //variables which are used
    GlobalTools globalTools = new GlobalTools();
    GlobalFileTools globalFileTools = new GlobalFileTools();

    public void initialize() {

        //limit text field length
        globalTools.LimitedTextField(productNameTextField, 20);
        globalTools.LimitedTextField(authorTextField, 20);
        globalTools.LimitedTextField(countTextField, 4);
        globalTools.LimitedTextField(priceTextField, 5);
    }

    @FXML
    private JFXTextField imageTextField;

    @FXML
    private JFXButton addProductButton;

    @FXML
    private JFXButton exitButton;

    @FXML
    private JFXTextField authorTextField;

    @FXML
    private JFXTextField productNameTextField;

    @FXML
    private JFXTextArea detailTextArea;

    @FXML
    private JFXTextField countTextField;

    @FXML
    private JFXTextField priceTextField;

    @FXML
    private JFXButton chooseImageButton;

    //thi method added new product in product information file
    @FXML
    void addProductAction(ActionEvent event) {
        //save text field data in variables
        String productName = productNameTextField.getText();
        String productAuthor = authorTextField.getText();
        String productCount = countTextField.getText();
        String productPrice = priceTextField.getText();
        String productImage = imageTextField.getText();
        String productDetail = detailTextArea.getText();

        //check that the fields are full or not
        if (productName.isEmpty())
            globalTools.AlertShow("Please enter product name.");
        else if (productAuthor.isEmpty())
            globalTools.AlertShow("Please enter product author.");
        else if (productCount.isEmpty())
            globalTools.AlertShow("Please enter product count.");
        else if (productPrice.isEmpty())
            globalTools.AlertShow("Please repeat product price.");
        else if (productImage.isEmpty())
            globalTools.AlertShow("Please choose product image.");
        else if (productDetail.isEmpty())
            globalTools.AlertShow("Please enter product detail.");
        else if (!globalTools.OnlyDigits(productCount))
            globalTools.AlertShow("please enter just number in product count.");
        else if (!globalTools.OnlyDigits(productPrice))
            globalTools.AlertShow("please enter just number in product price.");
        else if (globalFileTools.checkProductAvailable(productName)) {
            //checkSameProductOrNot() methods check it new product is repetitious or not
            globalTools.AlertShow("This product is available in stock.");
        }else {

            //casting product price to double format
            double formatPrice = Double.parseDouble(productPrice);

            //write all information of new product in productInformation.txt file
            globalFileTools.addNewProduct(productName, productAuthor, Double.toString(formatPrice), productCount, productImage);

            //show message when the register logic is not problem
            JOptionPane.showMessageDialog(null, "product add is successful!", "Registration", JOptionPane.INFORMATION_MESSAGE);

            //clear text fields when register was successful
            globalTools.clearFields(productNameTextField, authorTextField, countTextField, priceTextField, imageTextField, detailTextArea);
        }
    }

    //this method open directory and admin can choose product image
    @FXML
    void chooseImageAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser(); //create file chooser
        File file = fileChooser.showOpenDialog(null); //get file(pic) path

        if (file != null){
            String path;
            path = file.getAbsolutePath(); //take file path which is choose
            File files = new File(path); //convert path to file format
            //update new profile image path current customer
            imageTextField.setText(files.toString());
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please Select Picture"); //show Error alert
        }
    }

    //this method close current page(add new product)
    @FXML
    void exitAction(ActionEvent event) {
        globalTools.closeCurrentPage(exitButton);
    }

}

