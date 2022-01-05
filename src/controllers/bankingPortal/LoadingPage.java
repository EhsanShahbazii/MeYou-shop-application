package controllers.bankingPortal;

import com.jfoenix.controls.JFXSpinner;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.File;

public class LoadingPage {

    public void initialize() {
        File file = new File("C:\\Users\\Espino notebook\\Downloads\\Spinner-1s-200px.gif");
        Image image = new Image(file.toURI().toString());
        imageview.setImage(image);
    }

    @FXML
    public ImageView imageview;

    @FXML
    private AnchorPane loadingAnchor;

    @FXML
    private Text loadingText;

}
