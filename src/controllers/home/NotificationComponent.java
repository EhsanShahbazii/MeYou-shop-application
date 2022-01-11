package controllers.home;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class NotificationComponent {

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private ImageView imageView;

    @FXML
    private Text notificationHeaderTextField;

    @FXML
    private Text notificationBodyTextField;

    public AnchorPane getAnchorpane() {
        return anchorpane;
    }

    public void setAnchorpane(AnchorPane anchorpane) {
        this.anchorpane = anchorpane;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public Text getNotificationHeaderTextField() {
        return notificationHeaderTextField;
    }

    public void setNotificationHeaderTextField(Text notificationHeaderTextField) {
        this.notificationHeaderTextField = notificationHeaderTextField;
    }

    public Text getNotificationBodyTextField() {
        return notificationBodyTextField;
    }

    public void setNotificationBodyTextField(Text notificationBodyTextField) {
        this.notificationBodyTextField = notificationBodyTextField;
    }
}

