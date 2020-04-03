package pao;

import java.util.List;

public interface CashRegister {
    void newSale(Receipt receipt);
    void createDepartment(Department department);
    void printReceipts();
    List<Receipt> getReceipts();
    Receipt getReceiptById(Integer id);
    Double calculateTotalSales();
    Double calculateTotalDiscount();
    Double calculateTotalSalesForDepartment(Integer id);
    String getDepartmentName(Integer id);
}
