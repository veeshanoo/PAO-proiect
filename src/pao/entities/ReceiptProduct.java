package pao.entities;

import pao.services.Discount;

public class ReceiptProduct extends Product {
    private Integer receiptProductId;
    private Integer receiptId;
    private Discount discount;
    private VAT vat;    

    public ReceiptProduct(Integer productId, String name, Double quantity, Double price, Integer departmentId, Integer receiptProductId, Integer receiptId, Discount discount, VAT vat) {
        super(productId, name, quantity, price, departmentId);
        this.receiptProductId = receiptProductId;
        this.receiptId = receiptId;
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

    public Integer getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Integer receiptId) {
        this.receiptId = receiptId;
    }

    public Integer getReceiptProductId() {
        return receiptProductId;
    }

    public void setReceiptProductId(Integer receiptProductId) {
        this.receiptProductId = receiptProductId;
    }
}
