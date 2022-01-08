package controllers.home;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import modules.tools.GlobalTools;

public class Message {

    GlobalTools globalTools = new GlobalTools();

    @FXML
    private AnchorPane messageScrollAnchor;

    @FXML
    private JFXButton closeMessageButton;

    @FXML
    private JFXButton deleteMessageButton;

    @FXML
    void closeMessageAction(ActionEvent event) {
        globalTools.closeCurrentPage(closeMessageButton, "/pages/home/messagePage.fxml");
    }

    @FXML
    void deleteMessageAction(ActionEvent event) {

    }

}

