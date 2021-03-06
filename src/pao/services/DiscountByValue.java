package pao.services;

import pao.services.Discount;

public final class DiscountByValue implements Discount {
    private final Double value;

    public DiscountByValue(Double value) {
        this.value = value;
    }

    @Override
    public Double getValue() {
        return value;
    }

    @Override
    public Double calculateDiscount(Double price) {
        return Math.max(0.0, value);
    }

    @Override
    public String identify() {
        return "V";
    }

    @Override
    public String toString() {
        return "DiscountByValue{" +
                "value: " + this.value + "}";
    }
}
