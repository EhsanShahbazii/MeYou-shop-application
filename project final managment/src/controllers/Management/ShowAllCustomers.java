package controllers.Management;

import com.jfoenix.controls.JFXButton;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modules.object.Person;
import modules.tools.GlobalFileTools;
import modules.tools.GlobalTools;

public class ShowAllCustomers {

    GlobalTools globalTools = new GlobalTools();
    GlobalFileTools globalFileTools = new GlobalFileTools();

    public void initialize() {
        //create cart table columns and give it ids
        TableColumn productCode = new TableColumn("Full name"); //code column
        productCode.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        TableColumn productName = new TableColumn("username"); //name column
        productName.setCellValueFactory(new PropertyValueFactory<>("username"));
        TableColumn productAuthor = new TableColumn("email"); //name column
        productAuthor.setCellValueFactory(new PropertyValueFactory<>("email"));
        TableColumn productCount = new TableColumn("phone number"); //count column
        productCount.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        TableColumn productPrice = new TableColumn("address"); //price column
        productPrice.setCellValueFactory(new PropertyValueFactory<>("address"));
        //add columns in cart table javafx
        customerTable.getColumns().addAll(productCode, productName, productAuthor, productCount, productPrice);

        setDataInTable();
    }



    public void setDataInTable() {
        Person person = new Person();
        ObservableList<Person> data = globalFileTools.tableDataPersonCustomer();
        customerTable.setItems(data); //set data in cart table
    }

    @FXML
    private JFXButton exitButton;

    @FXML
    private TableView<Person> customerTable;

    @FXML
    void exitAction(ActionEvent event) {
        globalTools.closeCurrentPage(exitButton, "/pages/managment/showAllCustomerPage.fxml");
    }

}
