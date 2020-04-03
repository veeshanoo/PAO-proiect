package pao;

import java.util.Date;

public class Main {
    public static void main(String []args) {
        DatecsDP25 datecs = new DatecsDP25(0);
        Receipt rec1 = new Receipt();
        rec1.addProduct(new ReceiptProduct("mere", 2.0, 4.50, 1, new DiscountByPercent(20.0), new VAT(17.0)));
        rec1.addProduct(new ReceiptProduct("pere", 3.0, 6.49, 1, new DiscountByValue(3.0), new VAT(23.0)));
        datecs.newSale(rec1);
        Receipt rec2 = new Receipt();
        rec2.addProduct(new ReceiptProduct("iphone 10", 1.0, 4399.99, 2, new DiscountByPercent(0.0), new VAT(23.0)));
        datecs.printReceipts();
    }
}
