package pao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DatecsDP25 implements CashRegister {
    private Integer idGenerator;
    private TreeMap<Integer, Receipt> receipts;

    public DatecsDP25(Integer idGenerator) {
        this.idGenerator = idGenerator;
        this.receipts = new TreeMap<>();
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
    public void printReceipts() {
        for (Map.Entry<Integer, Receipt> entry : receipts.entrySet()) {
            System.out.println(entry.getValue());
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
        for (Map.Entry<Integer, Receipt> entry : receipts.entrySet()) {
            total += entry.getValue().getReceiptTotalPrice();
        }

        return total;
    }

    @Override
    public Double calculateTotalDiscount() {
        Double total = 0.0;
        for (Map.Entry<Integer, Receipt> entry : receipts.entrySet()) {
            total += entry.getValue().getReceiptTotalDiscount();
        }

        return total;
    }

    public Integer genId() {
        Integer cpy = this.idGenerator;
        this.idGenerator++;
        return cpy;
    }
}
