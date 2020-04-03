package pao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DatecsDP25 implements CashRegister {
    private Integer idGenerator; // used for receipts
    private TreeMap<Integer, Receipt> receipts;
    private TreeMap<Integer, Department> departments;

    static private final DatecsDP25 instance = new DatecsDP25(0);

    private DatecsDP25(Integer idGenerator) {
        this.idGenerator = idGenerator;
        this.receipts = new TreeMap<>();
        this.departments = new TreeMap<>();
    }

    public static DatecsDP25 getInstance() {
        return instance;
    }

    public Integer getIdGenerator() {
        return idGenerator;
    }

    public void setIdGenerator(Integer idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public void newSale(Receipt receipt) {
        receipt.setReceiptId(this.genId());
        receipt.prepareReceiptForSale();
        receipts.put(receipt.getReceiptId(), receipt);
    }

    @Override
    public void createDepartment(Department department) {
        departments.put(department.getDepartmentId(), department);
    }

    @Override
    public void printReceipts() {
        for (Receipt rec : this.getReceipts()) {
            System.out.println(rec);
        }
    }

    @Override
    public List<Receipt> getReceipts() {
        List<Receipt> lst = new ArrayList<>();
        for (Map.Entry<Integer, Receipt> entry : receipts.entrySet()) {
            lst.add(entry.getValue());
        }

        return lst;
    }

    @Override
    public Receipt getReceiptById(Integer id) {
        return receipts.getOrDefault(id, null);
    }

    @Override
    public Double calculateTotalSales() {
        Double total = 0.0;
        for (Receipt receipt : this.getReceipts()) {
            total += receipt.getReceiptTotalPrice();
        }

        return total;
    }

    @Override
    public Double calculateTotalDiscount() {
        Double total = 0.0;
        for (Receipt receipt : this.getReceipts()) {
            total += receipt.getReceiptTotalDiscount();
        }

        return total;
    }

    @Override
    public Double calculateTotalSalesForDepartment(Integer id) {
        Double total = 0.0;
        for (Receipt receipt : this.getReceipts()) {
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
        return departments.getOrDefault(id, null).getName();
    }

    public Integer genId() {
        Integer cpy = this.idGenerator;
        this.idGenerator++;
        return cpy;
    }
}
