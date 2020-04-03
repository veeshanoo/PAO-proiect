package pao;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private Integer receiptId;
    private List<ReceiptProduct> products;
    private Double receiptTotalPrice;
    private Double receiptTotalDiscount;
    private Double receiptTotalVAT;

    public Receipt(Integer receiptId) {
        this.receiptId = receiptId;
        this.products = new ArrayList<>();
    }

    public Integer getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Integer receiptId) {
        this.receiptId = receiptId;
    }

    public List<ReceiptProduct> getProducts() {
        return this.products;
    }
    public Double getReceiptTotalPrice() {
        return receiptTotalPrice;
    }

    public void setReceiptTotalPrice(Double receiptTotalPrice) {
        this.receiptTotalPrice = receiptTotalPrice;
    }

    public Double getReceiptTotalDiscount() {
        return receiptTotalDiscount;
    }

    public void setReceiptTotalDiscount(Double receiptTotalDiscount) {
        this.receiptTotalDiscount = receiptTotalDiscount;
    }

    public Double getReceiptTotalVAT() {
        return receiptTotalVAT;
    }

    public void setReceiptTotalVAT(Double receiptTotalVAT) {
        this.receiptTotalVAT = receiptTotalVAT;
    }

    public void addProduct(ReceiptProduct product) {
        products.add(product);
    }

    public Double calculateTotalPrice() {
        Double total = 0.0;
        for (ReceiptProduct product : products) {
            total += product.calculatePrice();
        }
        this.receiptTotalPrice = total;
        return total;
    }

    public Double calculateTotalDiscount() {
        Double total = 0.0;
        for (ReceiptProduct product : products) {
            total += product.calculateDiscount();
        }
        this.receiptTotalDiscount = total;
        return total;
    }

    public Double calculateTotalVAT() {
        Double total = 0.0;
        for (ReceiptProduct product : products) {
            total += product.calculateVAT();
        }
        this.receiptTotalVAT = total;
        return total;
    }
}
