package controllers.Management;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class ShowAllCustomers {

    // D:\project final\src\files\data\userInformation.txt

    @FXML
    private JFXButton exitButton;

    @FXML
    private TableView<?> customerTable;

    @FXML
    void exitAction(ActionEvent event) {
        globalTools.closeCurrentPage(exitButton, "/pages/managment/showAllCustomerPage.fxml");
    }

}
