package controllers.home;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class MessageComponent {

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private Text messageHeaderTextField;

    @FXML
    private Text messageBodyTextField;

    public AnchorPane getAnchorPane() {
        return anchorpane;
    }

    public void setAnchorPane(AnchorPane anchorpane) {
        this.anchorpane = anchorpane;
    }

    public Text getMessageHeaderTextField() {
        return messageHeaderTextField;
    }

    public void setMessageHeaderTextField(Text messageHeaderTextField) {
        this.messageHeaderTextField = messageHeaderTextField;
    }

    public Text getMessageBodyTextField() {
        return messageBodyTextField;
    }

    public void setMessageBodyTextField(Text messageBodyTextField) {
        this.messageBodyTextField = messageBodyTextField;
    }
}
