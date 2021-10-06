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

    //variables which are used
    GlobalTools globalTools = new GlobalTools();
    GlobalFileTools globalFileTools = new GlobalFileTools();

    //create comboBox data by observableList
    final ObservableList<String> discountAmounts = FXCollections.observableArrayList("10","20","50","85");

    public void initialize() {

        //create discount table columns and give it ids
        TableColumn discountName = new TableColumn("Discount name"); //code column
        discountName.setCellValueFactory(new PropertyValueFactory<>("discountName"));
        TableColumn discountAmount = new TableColumn("Discount amount"); //name column
        discountAmount.setCellValueFactory(new PropertyValueFactory<>("discountAmount"));
        TableColumn discountStartDate = new TableColumn("Discount start date"); //name column
        discountStartDate.setCellValueFactory(new PropertyValueFactory<>("discountStartDate"));
        TableColumn discountEndDate = new TableColumn("Discount end date"); //count column
        discountEndDate.setCellValueFactory(new PropertyValueFactory<>("discountEndDate"));
        //add columns in discount table javafx
        discountTable.getColumns().addAll(discountName, discountAmount, discountStartDate, discountEndDate);

        //set new data of product in product table
        setDataInTable();

        //set discount comboBox items and select default 0
        discountAmountComboBox.setItems(discountAmounts);
        discountAmountComboBox.getSelectionModel().select(0);
    }

    //create object from discount class and set data in discount table
    public void setDataInTable() {
        Discount discount = new Discount();
        ObservableList<Discount> data = globalFileTools.tableDataDiscount();
        discountTable.setItems(data); //set data in discount table
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

    //this method add new discount in discountDetails.txt file
    @FXML
    void addDiscountAction(ActionEvent event) {

        //save discount name and discount amount
        String discountName = discountNameTextField.getText();
        String discountAmount = discountAmountComboBox.getSelectionModel().getSelectedItem();

        //show error if text fields is empty or not choose file
        if ((startDatePicker.getValue().isAfter(discountEndDatePicker.getValue()))){
            //show error if start date is after than end date
            globalTools.AlertShow("please enter right date.");
        } else if (discountName.isEmpty()){
            globalTools.AlertShow("please enter your discount name.");
        }else if (discountAmount.isEmpty()){
            globalTools.AlertShow("please enter your discount Amount.");
        }
        else if (globalFileTools.checkDiscount(discountName)){
            //show error if this discount is available in table
            globalTools.AlertShow("this discount is invalid. please try another one.");
        }
        else {
            //save discount start and end date
            String discountStartDate = startDatePicker.getValue().toString();
            String discountEndDate = discountEndDatePicker.getValue().toString();

            //add new discount details in discountDetails.txt file
            globalFileTools.addNewDiscount(discountName, discountAmount, discountStartDate, discountEndDate);
            globalTools.AlertShowInformation("discount create!"); //show successful alert
        }
    }

    //this method close current page(add new discount)
    @FXML
    void exitAction(ActionEvent event) {
        globalTools.closeCurrentPage(exitButton);
    }
}
