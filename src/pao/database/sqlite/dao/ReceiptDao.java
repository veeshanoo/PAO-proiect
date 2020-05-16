package pao.database.sqlite.dao;

import pao.database.sqlite.dao.converter.ReceiptConverter;
import pao.database.sqlite.statements.ReceiptStatement;
import pao.entities.Receipt;

public class ReceiptDao extends CRUD<Receipt> {
    ReceiptDao() {
        this.converter = new ReceiptConverter();
        this.sql = new ReceiptStatement();
    }
}
