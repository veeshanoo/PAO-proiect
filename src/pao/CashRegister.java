package pao;

import java.util.List;

public interface CashRegister {
    void newSale(Receipt receipt);
    void printReceipts();
    List<Receipt> getReceipts();
    Receipt getReceiptById(Integer id);
    Double calculateTotalSales();
    Double calculateTotalDiscount();
}
