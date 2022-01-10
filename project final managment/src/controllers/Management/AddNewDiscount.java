package controllers.Management;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modules.object.Discount;
import modules.tools.GlobalFileTools;
import modules.tools.GlobalTools;

public class AddNewDiscount {

    GlobalTools globalTools = new GlobalTools();
    GlobalFileTools globalFileTools = new GlobalFileTools();

    final ObservableList<String> discountAmounts = FXCollections.observableArrayList("10","20","50","85");

    public void initialize() {
        //create cart table columns and give it ids
        TableColumn productCode = new TableColumn("Discount name"); //code column
        productCode.setCellValueFactory(new PropertyValueFactory<>("discountName"));
        TableColumn productName = new TableColumn("Discount amount"); //name column
        productName.setCellValueFactory(new PropertyValueFactory<>("discountAmount"));
        TableColumn productAuthor = new TableColumn("Discount start date"); //name column
        productAuthor.setCellValueFactory(new PropertyValueFactory<>("discountStartDate"));
        TableColumn productCount = new TableColumn("Discount end date"); //count column
        productCount.setCellValueFactory(new PropertyValueFactory<>("discountEndDate"));
        //add columns in cart table javafx
        discountTable.getColumns().addAll(productCode, productName, productAuthor, productCount);

        setDataInTable();

        discountAmountComboBox.setItems(discountAmounts);
        discountAmountComboBox.getSelectionModel().select(0);
    }



    public void setDataInTable() {
        Discount discount = new Discount();
        ObservableList<Discount> data = globalFileTools.tableDataDiscount();
        discountTable.setItems(data); //set data in cart table
    }


    @FXML
    private TableView<Discount> discountTable;

    @FXML
    private JFXTextField discountNameTextField;

    @FXML
    private JFXComboBox<String> discountAmountComboBox;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private DatePicker discountEndDatePicker;

    @FXML
    private JFXButton addDiscountButton;

    @FXML
    private JFXButton exitButton;

    @FXML
    void addDiscountAction(ActionEvent event) {

        String discountName = discountNameTextField.getText();
        String discountAmount = discountAmountComboBox.getItems().toString();

        if ((startDatePicker.getValue().isAfter(discountEndDatePicker.getValue()))){
            globalTools.AlertShow("please enter right date.");
        } else if (discountName.isEmpty()){
            globalTools.AlertShow("please enter your discount name.");
        }else if (discountAmount.isEmpty()){
            globalTools.AlertShow("please enter your discount Amount.");
        }
        else if (globalFileTools.checkDiscount(discountName)){
            globalTools.AlertShow("this discount is invalid. please try another one.");
        }
        else {
            String discountStartDate = startDatePicker.getValue().toString();
            String discountEndDate = discountEndDatePicker.getValue().toString();
            globalFileTools.addNewDiscount(discountName, discountAmount, discountStartDate, discountEndDate);
            globalTools.AlertShowInformation("discount create!");
        }

    }

    @FXML
    void exitAction(ActionEvent event) {
        globalTools.closeCurrentPage(exitButton, "/pages/managment/addNewDiscountPage.fxml");
    }

}
