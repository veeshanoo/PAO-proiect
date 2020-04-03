package pao;

public class ReceiptProduct extends Product {
    private Discount discount;
    private VAT vat;

    public ReceiptProduct(String name, Double quantity, Double price, Integer departmentId, Discount discount, VAT vat) {
        super(name, quantity, price, departmentId);
        this.discount = discount;
        this.vat = vat;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public VAT getVat() {
        return vat;
    }

    public void setVat(VAT vat) {
        this.vat = vat;
    }

    @Override
    public String toString() {
        return "ReceiptProduct{" +
                "Product: " + super.toString() + "," +
                "Discount: " + this.discount + ", " +
                "VAT: " + this.vat + "}";
    }

    @Override
    public Double calculatePrice() {
        Double price = super.calculatePrice();
        price -= discount.calculateDiscount(price);
        return price;
    }

    public Double calculateDiscount() {
        return discount.calculateDiscount(super.calculatePrice());
    }

    public Double calculateVAT() {
        return vat.calculateVAT(this.calculatePrice());
    }
}
