package pao.services;

import pao.entities.Department;
import pao.entities.Product;
import pao.entities.Receipt;

import java.util.List;

public interface CashRegister {
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Product product);
    void newSale(Receipt receipt);
    void createDepartment(Department department);
    void updateDepartment(Department department);
    void deleteDepartment(Department department);
    void printReceipts();
    List<Receipt> getReceiptsAsList();
    Receipt getReceiptById(Integer id);
    Double calculateTotalSales();
    Double calculateTotalDiscount();
    Double calculateTotalSalesForDepartment(Integer id);
    String getDepartmentName(Integer id);
}
