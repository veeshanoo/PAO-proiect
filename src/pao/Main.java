package pao;

import pao.IO.DepartmentIO;
import pao.IO.IdGeneratorIO;
import pao.IO.ProductIO;
import pao.IO.ReceiptIO;
import pao.entities.*;
import pao.services.DatecsDP25;
import pao.services.DiscountByPercent;
import pao.services.DiscountByValue;

public class Main {
    public static void main(String []args) {
        // we load data first
        DatecsDP25 datecs = DatecsDP25.getInstance();
        try {
            datecs.setProductIdGenerator(IdGeneratorIO.getInstance().loadData("csv/id_gen1.csv"));
            datecs.setReceiptIdGenerator(IdGeneratorIO.getInstance().loadData("csv/id_gen2.csv"));
            datecs.setProducts(ProductIO.getInstance().loadData("csv/products.csv"));
            datecs.setReceipts(ReceiptIO.getInstance().loadData("csv/receipts.csv"));
            datecs.setDepartments(DepartmentIO.getInstance().loadData("csv/departments.csv"));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }


        datecs.createDepartment(new Department(3, "Furniture"));
        datecs.createDepartment(new Department(4, "Food"));
        System.out.println(datecs.getDepartmentName(4));

        Receipt rec = new Receipt();
        rec.addProduct(new ReceiptProduct(0, "Apples", 2.0, 4.50, 0, new DiscountByPercent(20.0), new TaxB()));
        rec.addProduct(new ReceiptProduct(1, "Cucumbers", 3.0, 6.49, 1, new DiscountByValue(3.0), new TaxA()));
        datecs.newSale(rec);

        datecs.printReceipts();

        System.out.println(datecs.calculateTotalSales());

        System.out.println(datecs.calculateTotalDiscount());

        System.out.println(datecs.calculateTotalSalesForDepartment(1));
        System.out.println(datecs.calculateTotalSalesForDepartment(2));

        // we save data here
        try {
            IdGeneratorIO.getInstance().updateData("csv/id_gen1.csv", datecs.getProductIdGenerator());
            IdGeneratorIO.getInstance().updateData("csv/id_gen2.csv", datecs.getReceiptIdGenerator());
            ProductIO.getInstance().updateData("csv/products.csv", datecs.getProducts());
            ReceiptIO.getInstance().updateData("csv/receipts.csv", datecs.getReceipts());
            DepartmentIO.getInstance().updateData("csv/departments.csv", datecs.getDepartments());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
