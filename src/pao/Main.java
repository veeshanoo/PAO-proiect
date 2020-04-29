package pao;

public class Main {
    public static void main(String []args) {
        DatecsDP25 datecs = DatecsDP25.getInstance();

        datecs.createDepartment(new Department(1, "Fruits"));
        datecs.createDepartment(new Department(2, "Mobile Phones"));
        System.out.println(datecs.getDepartmentName(2));

        Receipt rec1 = new Receipt();
        rec1.addProduct(new ReceiptProduct("Apples", 2.0, 4.50, 1, new DiscountByPercent(20.0), new TaxB()));
        rec1.addProduct(new ReceiptProduct("Oranges", 3.0, 6.49, 1, new DiscountByValue(3.0), new TaxA()));
        datecs.newSale(rec1);

        Receipt rec2 = new Receipt();
        rec2.addProduct(new ReceiptProduct("Iphone 11 Pro Max", 1.0, 6399.99, 2, new DiscountByPercent(0.0), new TaxB()));
        datecs.newSale(rec2);

        datecs.printReceipts();

        System.out.println(datecs.calculateTotalSales());

        System.out.println(datecs.calculateTotalDiscount());

        System.out.println(datecs.calculateTotalSalesForDepartment(1));
        System.out.println(datecs.calculateTotalSalesForDepartment(2));
    }
}
