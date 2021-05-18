package controllers.customer;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class ProductAnchorPane {

    public Text getPriceText() {
        return priceText;
    }

    public void setPriceText(Text priceText) {
        this.priceText = priceText;
    }

    public Text getDetailsText() {
        return detailsText;
    }

    public void setDetailsText(Text detailsText) {
        this.detailsText = detailsText;
    }

    public ImageView getImageViewProduct() {
        return imageViewProduct;
    }

    public void setImageViewProduct(ImageView imageViewProduct) {
        this.imageViewProduct = imageViewProduct;
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }

    @FXML
    public AnchorPane anchorPane;

    @FXML
    private Text priceText;

    @FXML
    private Text detailsText;

    @FXML
    private ImageView imageViewProduct;

}

