package pao;

public final class DiscountByValue implements Discount {
    private final Double value;

    public DiscountByValue(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public Double calculateDiscount(Double price) {
        return Math.max(0.0, value);
    }

    @Override
    public String toString() {
        return "DiscountByValue{" +
                "value: " + this.value + "}";
    }
}
