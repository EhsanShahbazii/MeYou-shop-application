package controllers.customer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import modules.tools.GlobalTools;

import java.io.IOException;

public class ProductAnchorPane {

    GlobalTools globalTools = new GlobalTools();

    public static String price, productName;

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
    public Button priceHistoryButton;

    @FXML
    public AnchorPane anchorPane;

    @FXML
    private Text priceText;

    @FXML
    private Text detailsText;

    @FXML
    private ImageView imageViewProduct;

    public void priceLineChartAction(ActionEvent event) throws IOException {
        price = priceText.getText();
        productName = detailsText.getText();
        globalTools.openNewPageWithoutCloseCurrentPage("/pages/home/lineChartProductPage.fxml", "price history", 600, 300);
    }
}

