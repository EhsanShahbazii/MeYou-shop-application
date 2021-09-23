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

    //variables which are used
    GlobalTools globalTools = new GlobalTools();
    GlobalFileTools globalFileTools = new GlobalFileTools();

    public void initialize() {

        //create customer table columns and give it ids
        TableColumn fullName = new TableColumn("Full name"); //code column
        fullName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        TableColumn username = new TableColumn("username"); //name column
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        TableColumn email = new TableColumn("email"); //name column
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        TableColumn phoneNumber = new TableColumn("phone number"); //count column
        phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        TableColumn address = new TableColumn("address"); //price column
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        //add columns in customer table javafx
        customerTable.getColumns().addAll(fullName, username, email, phoneNumber, address);

        //set new data of customer in customer table
        setDataInTable();
    }

    //create object from Person class and set data in customer table
    public void setDataInTable() {
        Person person = new Person();
        ObservableList<Person> data = globalFileTools.tableDataPersonCustomer();
        customerTable.setItems(data); //set data in customer table
    }

    @FXML
    private JFXButton exitButton;

    @FXML
    private TableView<Person> customerTable;

    //this method close current page(show all product)
    @FXML
    void exitAction(ActionEvent event) {
        globalTools.closeCurrentPage(exitButton, "/pages/managment/showAllCustomerPage.fxml");
    }
}
