package controllers.customer;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import modules.files.SelectAndBuyProduct;
import modules.tools.GlobalTools;

import java.io.FileNotFoundException;

public class ProductMainAnchorPane {

    //variables which are used
    GlobalTools globalTools = new GlobalTools();
    SelectAndBuyProduct selectAndBuyProduct =  new SelectAndBuyProduct();

    //variable for set count of product
    int productCount;

    public void initialize() {
        //set in product count number 1
        productCountText.setText("1");
    }

    @FXML
    public Text newPrice;

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

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public Text getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Text newPrice) {
        this.newPrice = newPrice;
    }

    @FXML
    private JFXButton buyItButton;

    //add to card product and count and price
    @FXML
    void buyProduct(ActionEvent event) throws FileNotFoundException {
        if (productCountText.getText().equals("1")) {
            newPrice.setText(productPriceText.getText());
        }
        //add product information in card files
        selectAndBuyProduct.updateProductToCard(Login.customer.getUsername(), ProductNameText.getText(), productCountText.getText(), globalTools.realPrice(globalTools.justDigits(newPrice.getText())));
        //show success alert and some data
        globalTools.AlertShowInformation("(" + productCountText.getText() +") books named (" + getProductNameText().getText() + ") were added to the shopping cart!");
        productCountText.setText("1");
        newPrice.setText("");
    }

    //increase one step product count until 9 or product count in inventory
    @FXML
    void productIncreaseCounterAction(ActionEvent event) {
        //get product count and save it
        productCount = Integer.parseInt(globalTools.justDigits(getOnlyStockText().getText()));

        //get product count before by text fields
        int countBefore = Integer.parseInt(productCountText.getText());

        //if countBefore bigger than 9 or product count , do nothing
        if (countBefore >= 9 || countBefore >= productCount) {
        }else {
            //show count*price in format ($number)
            String string1 = getProductPriceText().getText();
            String multi1 = getProductCountText().getText();
            double number1 = Double.parseDouble(string1)*(Double.parseDouble(multi1)+1);
            getNewPrice().setText("($" + Double.toString(number1) + ")");
            countBefore++;
        }
        productCountText.setText(String.valueOf(countBefore));
    }

    //decrease one step product count until 9 or product count in inventory
    @FXML
    void productDecreaseCounterAction(ActionEvent event) {
        //get product count and save it
        productCount = Integer.parseInt(globalTools.justDigits(getOnlyStockText().getText()));

        //get product count before by text fields
        int countBefore = Integer.parseInt(productCountText.getText());

        //if countBefore smaller than 1, do nothing
        if (countBefore <=1) {

        }else {
            //show count*price in format ($number)
            String string = getProductPriceText().getText();
            String multi =  getProductCountText().getText();
            double number = Double.parseDouble(string)*(Double.parseDouble(multi)-1);
            getNewPrice().setText("($" + Double.toString(number) + ")");
            countBefore--;
        }
        productCountText.setText(String.valueOf(countBefore));
    }
}

