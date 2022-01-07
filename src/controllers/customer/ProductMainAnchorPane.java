package controllers.customer;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import modules.tools.GlobalFileTools;
import modules.tools.GlobalTools;

public class ProductMainAnchorPane {

    GlobalFileTools globalFileTools = new GlobalFileTools();
    GlobalTools globalTools = new GlobalTools();

    String productCount;

    public void initialize() {
        productCountText.setText("1");
    }

    @FXML
    public ImageView imageViewProduct;

    @FXML
    public Text ProductNameText;

    @FXML
    public Text authorText;

    @FXML
    public Text onlyStockText;

    @FXML
    public Text scoreText;

    @FXML
    public Text countScore;

    @FXML
    private AnchorPane productMainAnchorPane;

    @FXML
    private Text productPriceText;

    @FXML
    private JFXButton productIncreaseCounter;

    @FXML
    private JFXButton productDecreaseCounter;

    @FXML
    private Text productCountText;

    public Text getScoreText() {
        return scoreText;
    }

    public void setScoreText(Text scoreText) {
        this.scoreText = scoreText;
    }

    public Text getCountScore() {
        return countScore;
    }

    public void setCountScore(Text countScore) {
        this.countScore = countScore;
    }

    public Text getAuthorText() {
        return authorText;
    }

    public void setAuthorText(Text authorText) {
        this.authorText = authorText;
    }

    public ImageView getImageViewProduct() {
        return imageViewProduct;
    }

    public void setImageViewProduct(ImageView imageViewProduct) {
        this.imageViewProduct = imageViewProduct;
    }

    public Text getProductNameText() {
        return ProductNameText;
    }

    public Text getOnlyStockText() {
        return onlyStockText;
    }

    public void setOnlyStockText(Text onlyStockText) {
        this.onlyStockText = onlyStockText;
    }

    public void setProductNameText(Text productNameText) {
        ProductNameText = productNameText;
    }

    public AnchorPane getProductMainAnchorPane() {
        return productMainAnchorPane;
    }

    public void setProductMainAnchorPane(AnchorPane productMainAnchorPane) {
        this.productMainAnchorPane = productMainAnchorPane;
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
    private JFXButton buyItButton;

    @FXML
    void buyProduct(ActionEvent event) {

    }

    @FXML
    void productIncreaseCounterAction(ActionEvent event) {
        productCount = globalTools.justDigits(getOnlyStockText().getText());
        int countBefore = Integer.parseInt(productCountText.getText());

        if (countBefore >= 9 || countBefore >= Integer.parseInt(productCount)) {

        }else {
            countBefore++;
        }
        productCountText.setText(String.valueOf(countBefore));
    }

    @FXML
    void productDecreaseCounterAction(ActionEvent event) {
        int countBefore = Integer.parseInt(productCountText.getText());
        if (countBefore <=1) {

        }else {
            countBefore--;
        }
        productCountText.setText(String.valueOf(countBefore));
    }
}

