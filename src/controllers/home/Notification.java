package controllers.home;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import modules.tools.GlobalTools;

public class Notification {

    GlobalTools globalTools = new GlobalTools();

    @FXML
    private AnchorPane notificationScrollAnchor;

    @FXML
    private JFXButton closeNotificationButton;

    @FXML
    private JFXButton deleteNotificationButton;

    @FXML
    void closeNotificationAction(ActionEvent event) {
        globalTools.closeCurrentPage(closeNotificationButton, "/pages/home/notificationPage.fxml");
    }

    @FXML
    void deleteNotificationAction(ActionEvent event) {

    }

}
