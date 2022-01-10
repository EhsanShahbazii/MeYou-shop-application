package modules.object;

public class Discount {

    private String discountName;
    private String dicountAmount;
    private String startDate;
    private String endDate;

    public Discount(String discountName, String dicountAmount, String startDate, String endDate) {
        this.discountName = discountName;
        this.dicountAmount = dicountAmount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Discount() {

    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public String getDicountAmount() {
        return dicountAmount;
    }

    public void setDicountAmount(String dicountAmount) {
        this.dicountAmount = dicountAmount;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
