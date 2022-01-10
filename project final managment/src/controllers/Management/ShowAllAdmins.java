package controllers.Management;

import com.jfoenix.controls.JFXButton;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modules.object.Person;
import modules.object.Product;
import modules.tools.GlobalFileTools;
import modules.tools.GlobalTools;

public class ShowAllAdmins {

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
        adminTable.getColumns().addAll(productCode, productName, productAuthor, productCount, productPrice);

        setDataInTable();
    }



    public void setDataInTable() {
        Person person = new Person();
        ObservableList<Person> data = globalFileTools.tableDataPersonAdmin();
        adminTable.setItems(data); //set data in cart table
    }

    @FXML
    private JFXButton exitButton;

    @FXML
    private TableView<Person> adminTable;

    @FXML
    void exitAction(ActionEvent event) {

    }

}
