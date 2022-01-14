package controllers.home;

import com.jfoenix.controls.JFXButton;
import controllers.customer.ProductAnchorPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import modules.tools.GlobalTools;

import java.io.IOException;

public class Message {

    //variables which are used
    GlobalTools globalTools = new GlobalTools();

    public void initialize() throws IOException {

        for (int i = 0; i < 3; i++) {
            //load product anchor pane and control it
            FXMLLoader loader1 = new FXMLLoader(this.getClass().getResource("../../pages/home/messageComponentPage.fxml"));

            Parent root1 = loader1.load(); //load parent
            MessageComponent control1 = loader1.getController(); //get anchor pane controller

            //set data in product anchor pane text fields
//            control1.getDetailsText().setText(productData[5*i]);
//            control1.getPriceText().setText(productData[5*i+2]);
            //set image in product anchor pane image view
//            File file1 = new File(productData[5*i+4]);
//            Image image2 = new Image(file1.toURI().toString());
//            control1.getImageViewProduct().setImage(image2);

            //these are margin variables
            double marginLeft = 2;
            double marginTop = 5;

            //set position for anchor pane
            AnchorPane.setTopAnchor(root1, marginTop + i * (marginTop + control1.getAnchorPane().getPrefHeight()));
            AnchorPane.setLeftAnchor(root1, marginLeft);

            //add this anchor pane in main anchor pane
            messageScrollAnchor.getChildren().add(root1);
        }
    }
    @FXML
    private AnchorPane messageScrollAnchor;

    @FXML
    private JFXButton closeMessageButton;

    @FXML
    private JFXButton deleteMessageButton;

    //this method is close message page
    @FXML
    void closeMessageAction(ActionEvent event) {
        globalTools.closeCurrentPage(closeMessageButton);
    }

    //this method is delete message
    @FXML
    void deleteMessageAction(ActionEvent event) {
        messageScrollAnchor.getChildren().clear();
    }

}

