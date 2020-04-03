package pao;

public final class TaxB extends VAT {
    @Override
    public String toString() {
        return "VAT{" +
                "percentage: " + this.getVAT() + "}";
    }

    @Override
    public final Double calculateVAT(Double price) {
        return 0.175 * price;
    }

    @Override
    public final Double getVAT() {
        return 0.175;
    }
}
