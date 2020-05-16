package pao.database.sqlite.dao;

import pao.database.sqlite.dao.converter.ReceiptProductConverter;
import pao.database.sqlite.statements.ReceiptProductStatement;
import pao.entities.ReceiptProduct;

public class ReceiptProductDao extends CRUD<ReceiptProduct> {
    static private final ReceiptProductDao instance = new ReceiptProductDao();

    public static ReceiptProductDao getInstance() {
        return instance;
    }

    private ReceiptProductDao() {
        this.converter = new ReceiptProductConverter();
        this.sql = new ReceiptProductStatement();
    }
}