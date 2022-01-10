package controllers.Management;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import modules.object.Product;
import modules.tools.GlobalFileTools;
import modules.tools.GlobalTools;

public class ShowAllProducts {

    GlobalTools globalTools = new GlobalTools();
    GlobalFileTools globalFileTools = new GlobalFileTools();

    @FXML
    private JFXButton exitButton;

    @FXML
    private TableView<Product> productTable;

    @FXML
    void exitAction(ActionEvent event) {

    }

}
