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
        adminTable.getColumns().addAll(productCode, productName, productAuthor, productCount, productPrice);

        setDataInTable();
    }



    public void setDataInTable() {
        Person person = new Person();
        ObservableList<Person> data = globalFileTools.tableData();
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
