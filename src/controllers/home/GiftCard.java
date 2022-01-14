package controllers.home;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import modules.tools.GlobalTools;

public class GiftCard {

    //variables which are used
    GlobalTools globalTools = new GlobalTools();

    @FXML
    private JFXButton closeGiftCardAnchor;

    //closeGiftCardAnchor and get back
    @FXML
    void closeGiftCardAnchorAction(ActionEvent event) {
        globalTools.closeCurrentPage(closeGiftCardAnchor);
    }

}

