package modules.object;

public class Discount {

    private String discountName;
    private String discountAmount;
    private String discountStartDate;
    private String discountEndDate;

    public Discount(String discountName, String discountAmount, String discountStartDate, String discountEndDate) {
        this.discountName = discountName;
        this.discountAmount = discountAmount;
        this.discountStartDate = discountStartDate;
        this.discountEndDate = discountEndDate;
    }

    public Discount() {

    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getDiscountStartDate() {
        return discountStartDate;
    }

    public void setDiscountStartDate(String discountStartDate) {
        this.discountStartDate = discountStartDate;
    }

    public String getDiscountEndDate() {
        return discountEndDate;
    }

    public void setDiscountEndDate(String discountEndDate) {
        this.discountEndDate = discountEndDate;
    }
}
