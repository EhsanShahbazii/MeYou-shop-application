package controllers.Management;

import com.jfoenix.controls.JFXButton;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modules.object.Product;
import modules.tools.GlobalFileTools;
import modules.tools.GlobalTools;

public class ShowAllProducts {

    //variables which are used
    GlobalTools globalTools = new GlobalTools();
    GlobalFileTools globalFileTools = new GlobalFileTools();

    public void initialize() {
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
        productTable.getColumns().addAll(productCode, productName, productAuthor, productCount, productPrice);

        //set new data of product in product table
        setDataInTable();
    }

    //create object from Product class and set data in product table
    public void setDataInTable() {
        Product product = new Product();
        ObservableList<Product> data = globalFileTools.tableData();
        productTable.setItems(data); //set data in product table
    }

    @FXML
    private JFXButton exitButton;

    @FXML
    private TableView<Product> productTable;

    //this method close current page(show all products)
    @FXML
    void exitAction(ActionEvent event) {
        globalTools.closeCurrentPage(exitButton, "/pages/admin/showAllProductPage.fxml");
    }

}
