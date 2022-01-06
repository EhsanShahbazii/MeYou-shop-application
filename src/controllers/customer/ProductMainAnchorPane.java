package controllers.customer;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class ProductMainAnchorPane {

    @FXML
    private AnchorPane productMainAnchorPane;

    public AnchorPane getProductMainAnchorPane() {
        return productMainAnchorPane;
    }

    public void setProductMainAnchorPane(AnchorPane productMainAnchorPane) {
        this.productMainAnchorPane = productMainAnchorPane;
    }

    public ImageView getTe() {
        return te;
    }

    public void setTe(ImageView te) {
        this.te = te;
    }

    public Text getPri() {
        return pri;
    }

    public void setPri(Text pri) {
        this.pri = pri;
    }

    public Text getProductPriceText() {
        return productPriceText;
    }

    public void setProductPriceText(Text productPriceText) {
        this.productPriceText = productPriceText;
    }

    public JFXButton getProductIncreaseCounter() {
        return productIncreaseCounter;
    }

    public void setProductIncreaseCounter(JFXButton productIncreaseCounter) {
        this.productIncreaseCounter = productIncreaseCounter;
    }

    public JFXButton getProductDecreaseCounter() {
        return productDecreaseCounter;
    }

    public void setProductDecreaseCounter(JFXButton productDecreaseCounter) {
        this.productDecreaseCounter = productDecreaseCounter;
    }

    public Text getProductCountText() {
        return productCountText;
    }

    public void setProductCountText(Text productCountText) {
        this.productCountText = productCountText;
    }

    public JFXButton getBuyItButton() {
        return buyItButton;
    }

    public void setBuyItButton(JFXButton buyItButton) {
        this.buyItButton = buyItButton;
    }

    @FXML
    private ImageView te;

    @FXML
    private Text pri;

    @FXML
    private Text productPriceText;

    @FXML
    private JFXButton productIncreaseCounter;

    @FXML
    private JFXButton productDecreaseCounter;

    @FXML
    private Text productCountText;

    @FXML
    private JFXButton buyItButton;

    @FXML
    void buyProduct(ActionEvent event) {

    }

    @FXML
    void productIncreaseCounterAction(ActionEvent event) {

    }

    @FXML
    void productecreaseCounterAction(ActionEvent event) {

    }

}

