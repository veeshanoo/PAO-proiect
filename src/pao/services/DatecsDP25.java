package pao.services;

import pao.audit.Auditor;
import pao.database.sqlite.dao.DepartmentDao;
import pao.database.sqlite.dao.ProductDao;
import pao.database.sqlite.dao.ReceiptDao;
import pao.entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DatecsDP25 implements CashRegister {
    private TreeMap<Integer, Product> products;
    private TreeMap<Integer, Receipt> receipts;
    private TreeMap<Integer, Department> departments;
    private Auditor auditor;

    static private final DatecsDP25 instance = new DatecsDP25();

    private DatecsDP25() {
        this.receipts = new TreeMap<>();
        this.departments = new TreeMap<>();
        this.auditor = new Auditor("logs/logs.csv");
    }

    public static DatecsDP25 getInstance() {
        return instance;
    }

    public TreeMap<Integer, Product> getProducts() {
        auditor.logAction("getProducts");
        return products;
    }

    public void setProducts(TreeMap<Integer, Product> products) {
        auditor.logAction("setProducts");
        this.products = products;
    }

    public TreeMap<Integer, Receipt> getReceipts() {
        return receipts;
    }

    public void setReceipts(TreeMap<Integer, Receipt> receipts) {
        this.receipts = receipts;
    }

    public TreeMap<Integer, Department> getDepartments() {
        auditor.logAction("getDepartments");
        return departments;
    }

    public void setDepartments(TreeMap<Integer, Department> departments) {
        this.departments = departments;
        auditor.logAction("setDepartments");
    }

    @Override
    public void addProduct(Product product) {
        auditor.logAction("addProduct");
        products.put(product.getProductId(), product);
        ProductDao.getInstance().insert(product);
    }

    @Override
    public void updateProduct(Product product) {
        auditor.logAction("updateProduct");
        ProductDao.getInstance().update(product, product);
        products.put(product.getProductId(), product);
    }

    @Override
    public void deleteProduct(Product product) {
        auditor.logAction("deleteProduct");
        ProductDao.getInstance().delete(product);
        products.remove(product.getProductId());
    }

    @Override
    public void newSale(Receipt receipt) {
        auditor.logAction("newSale");
        receipt.prepareReceiptForSale();
        receipts.put(receipt.getReceiptId(), receipt);
        ReceiptDao.getInstance().insert(receipt);
    }

    @Override
    public void createDepartment(Department department) {
        auditor.logAction("createDepartment");
        departments.put(department.getDepartmentId(), department);
        DepartmentDao.getInstance().insert(department);
    }

    @Override
    public void updateDepartment(Department department) {
        auditor.logAction("updateDepartment");
        DepartmentDao.getInstance().update(department, department);
        departments.put(department.getDepartmentId(), department);
    }

    @Override
    public void deleteDepartment(Department department) {
        auditor.logAction("deleteDepartment");
        DepartmentDao.getInstance().delete(department);
        departments.remove(department.getDepartmentId());
    }

    @Override
    public void printReceipts() {
        auditor.logAction("printReceipts");
        for (Receipt rec : this.getReceiptsAsList()) {
            System.out.println(rec);
        }
    }

    @Override
    public List<Receipt> getReceiptsAsList() {
        auditor.logAction("getReceipts");
        List<Receipt> lst = new ArrayList<>();
        for (Map.Entry<Integer, Receipt> entry : receipts.entrySet()) {
            lst.add(entry.getValue());
        }

        return lst;
    }

    @Override
    public Receipt getReceiptById(Integer id) {
        auditor.logAction("getReceiptById");
        return receipts.getOrDefault(id, null);
    }

    @Override
    public Double calculateTotalSales() {
        auditor.logAction("calculateTotalSales");
        Double total = 0.0;
        for (Receipt receipt : this.getReceiptsAsList()) {
            total += receipt.getReceiptTotalPrice();
        }

        return total;
    }

    @Override
    public Double calculateTotalDiscount() {
        auditor.logAction("calculateTotalDiscount");
        Double total = 0.0;
        for (Receipt receipt : this.getReceiptsAsList()) {
            total += receipt.getReceiptTotalDiscount();
        }

        return total;
    }

    @Override
    public Double calculateTotalSalesForDepartment(Integer id) {
        auditor.logAction("calculateTotalSalesForDepartment");
        Double total = 0.0;
        for (Receipt receipt : this.getReceiptsAsList()) {
            for (ReceiptProduct product : receipt.getProducts()) {
                if (id.equals(product.getDepartmentId())) {
                    total += product.calculatePrice();
                }
            }
        }

        return total;
    }

    @Override
    public String getDepartmentName(Integer id) {
        auditor.logAction("getDepartmentName");
        return departments.getOrDefault(id, null).getName();
    }
}
