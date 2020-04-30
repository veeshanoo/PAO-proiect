package pao.services;

import pao.services.Discount;

public final class DiscountByPercent implements Discount {
    private final Double percentage;

    public DiscountByPercent(Double percentage) {
        this.percentage = percentage;
    }

    @Override
    public Double getValue() {
        return percentage;
    }

    @Override
    public Double calculateDiscount(Double price) {
        return price * percentage / 100.0;
    }

    @Override
    public String identify() {
        return "P";
    }

    @Override
    public String toString() {
        return "DiscountPercent{" +
                "percentage: " + this.percentage + "}";
    }
}
