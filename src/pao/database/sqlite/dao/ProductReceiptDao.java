package pao.database.sqlite.dao;

import pao.database.sqlite.dao.converter.ReceiptProductConverter;
import pao.database.sqlite.statements.ReceiptProductStatement;
import pao.entities.ReceiptProduct;

public class ProductReceiptDao extends CRUD<ReceiptProduct> {
    ProductReceiptDao() {
        this.converter = new ReceiptProductConverter();
        this.sql = new ReceiptProductStatement();
    }
}