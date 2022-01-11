package modules.object;

public class Product {

    private String productCode;
    private String productName;
    private String productCount;
    private String productPrice;
    private String productAuthor;

    public Product(String productName, String productAuthor, String productCount, String productPrice, String productCode) {
        this.productCode = productCode;
        this.productName = productName;
        this.productAuthor = productAuthor;
        this.productCount = productCount;
        this.productPrice = productPrice;
    }

    public Product() {

    }

    public String getProductAuthor() {
        return productAuthor;
    }

    public void setProductAuthor(String productAuthor) {
        this.productAuthor = productAuthor;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCount() {
        return productCount;
    }

    public void setProductCount(String productCount) {
        this.productCount = productCount;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
