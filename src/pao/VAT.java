package pao;

public class VAT {
    private Double percentage;

    public VAT(Double percentage) {
        this.percentage = percentage;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Double calculateVAT(Double price) {
        return price * percentage / 100.0;
    }
}
