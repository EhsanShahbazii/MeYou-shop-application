package controllers.home;

import controllers.customer.ProductAnchorPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;

public class MessageComponent {

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private Text messageHeaderTextField;

    @FXML
    private Text messageBodyTextField;

    public AnchorPane getAnchorpane() {
        return anchorpane;
    }

    public void setAnchorpane(AnchorPane anchorpane) {
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
