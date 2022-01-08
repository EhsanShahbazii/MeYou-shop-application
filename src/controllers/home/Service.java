package controllers.home;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import modules.tools.GlobalTools;

public class Service {

    GlobalTools globalTools = new GlobalTools();

    @FXML
    private JFXButton backServiceButton;

    @FXML
    void backServiceAction(ActionEvent event) {
        globalTools.closeCurrentPage(backServiceButton, "/pages/home/sevicePage.fxml");
    }

}
