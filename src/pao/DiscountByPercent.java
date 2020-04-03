package pao;

public class DiscountByPercent implements Discount {
    private final Double percentage;

    public DiscountByPercent(Double percentage) {
        this.percentage = percentage;
    }

    public Double getPercentage() {
        return percentage;
    }

    @Override
    public Double calculateDiscount(Double price) {
        return price * percentage / 100.0;
    }

    @Override
    public String toString() {
        return "DiscountPercent{" +
                "percentage: " + this.percentage + "}";
    }
}
