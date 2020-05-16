package pao.database.sqlite.dao;

import pao.database.sqlite.dao.converter.ReceiptConverter;
import pao.database.sqlite.statements.ReceiptStatement;
import pao.entities.Receipt;
import pao.entities.ReceiptProduct;

import javax.print.DocFlavor;
import java.util.List;
import java.util.TreeMap;

public class ReceiptDao extends CRUD<Receipt> {
    static private final ReceiptDao instance = new ReceiptDao();

    public static ReceiptDao getInstance() {
        return instance;
    }

    private ReceiptDao() {
        this.converter = new ReceiptConverter();
        this.sql = new ReceiptStatement();
    }

    @Override
    public List<Receipt> readAll() {
        List<Receipt> list = super.readAll();

        for (Receipt receipt : list) {
            String[] filters = new String[1];
            filters[0] = Integer.toString(receipt.getReceiptId());

            List<ReceiptProduct> products = ReceiptProductDao.getInstance().readAllFiltered(filters);
            for (ReceiptProduct product : products) {
                receipt.addProduct(product);
            }
        }

        return list;
    }

    @Override
    public void insert(Receipt element) {
        super.insert(element);

        for (ReceiptProduct product : element.getProducts()) {
            ReceiptProductDao.getInstance().insert(product);
        }
    }

    public TreeMap<Integer, Receipt> loadData() {
        TreeMap<Integer, Receipt> receipts = new TreeMap<>();

        List<Receipt> recList = this.readAll();
        for (Receipt receipt : recList) {
            receipts.put(receipt.getReceiptId(), receipt);
        }

        return receipts;
    }
}
