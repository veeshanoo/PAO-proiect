package pao;

public class DiscountByValue implements Discount {
    private final Double value;

    public DiscountByValue(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public Double calculateDiscount(Double price) {
        return Math.max(0.0, price - value);
    }
}
