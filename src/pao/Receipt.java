package pao;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private Integer receiptId;
    private List<ReceiptProduct> products;
    private Double receiptTotalPrice;
    private Double receiptTotalDiscount;
    private Double receiptTotalVAT;

    public Receipt() {
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

    public void prepareReceiptForSale() {
        this.calculateTotalPrice();
        this.calculateTotalDiscount();
        this.calculateTotalVAT();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Receipt{");
        str.append("receiptId: ").append(this.receiptId).append(", ");
        str.append("[");
        for (ReceiptProduct product : products)
            str.append(product.toString()).append(", ");
        str.append("receiptTotalPrice: ").append(this.receiptTotalPrice).append(", ");
        str.append("receiptTotalDiscount: ").append(this.receiptTotalDiscount).append(", ");
        str.append("receiptTotalVAT: ").append(this.receiptTotalVAT);
        str.append("]");
        str.append("}");
        return str.toString();
    }
}
