package pao;

import pao.database.sqlite.dao.DepartmentDao;
import pao.database.sqlite.dao.ProductDao;
import pao.database.sqlite.dao.ReceiptDao;
import pao.entities.Product;
import pao.services.DatecsDP25;

public class Main {
    public static void main(String []args) {
        // we load data first
        DatecsDP25 datecs = DatecsDP25.getInstance();
        try {
            datecs.setProducts(ProductDao.getInstance().loadData());
            datecs.setDepartments(DepartmentDao.getInstance().loadData());
            datecs.setReceipts(ReceiptDao.getInstance().loadData());
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        System.out.println(datecs.getReceiptById(2).toString());

//        try {
//            datecs.setProductIdGenerator(IdGeneratorIO.getInstance().loadData("csv/id_gen1.csv"));
//            datecs.setReceiptIdGenerator(IdGeneratorIO.getInstance().loadData("csv/id_gen2.csv"));
//            datecs.setProducts(ProductIO.getInstance().loadData("csv/products.csv"));
//            datecs.setReceipts(ReceiptIO.getInstance().loadData("csv/receipts.csv"));
//            datecs.setDepartments(DepartmentIO.getInstance().loadData("csv/departments.csv"));
//        } catch (Exception e) {
//            e.printStackTrace();
//            return;
//        }
//
//
//        datecs.createDepartment(new Department(3, "Furniture"));
//        datecs.createDepartment(new Department(4, "Food"));
//        System.out.println(datecs.getDepartmentName(4));
//
//        Receipt rec = new Receipt();
//        rec.addProduct(new ReceiptProduct(0, "Apples", 2.0, 4.50, 0, new DiscountByPercent(20.0), new TaxB()));
//        rec.addProduct(new ReceiptProduct(1, "Cucumbers", 3.0, 6.49, 1, new DiscountByValue(3.0), new TaxA()));
//        datecs.newSale(rec);
//
//        datecs.printReceipts();
//
//        System.out.println(datecs.calculateTotalSales());
//
//        System.out.println(datecs.calculateTotalDiscount());
//
//        System.out.println(datecs.calculateTotalSalesForDepartment(1));
//        System.out.println(datecs.calculateTotalSalesForDepartment(2));
//
//        // we save data here
//        try {
//            IdGeneratorIO.getInstance().updateData("csv/id_gen1.csv", datecs.getProductIdGenerator());
//            IdGeneratorIO.getInstance().updateData("csv/id_gen2.csv", datecs.getReceiptIdGenerator());
//            ProductIO.getInstance().updateData("csv/products.csv", datecs.getProducts());
//            ReceiptIO.getInstance().updateData("csv/receipts.csv", datecs.getReceipts());
//            DepartmentIO.getInstance().updateData("csv/departments.csv", datecs.getDepartments());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
