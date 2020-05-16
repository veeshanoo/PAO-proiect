package pao.database.sqlite.statements;

import pao.entities.Receipt;

public class ReceiptStatement implements Statement<Receipt> {
    @Override
    public String readAllStatement() {
        return "SELECT * FROM receipts;";
    }

    @Override
    public String readAllFilteredStatement(String[] filters) {
        return null;
    }

    @Override
    public String readStatement(Receipt filter) {
        return String.format("SELECT * FROM receipts WHERE receipt_id = %d;", filter.getReceiptId());
    }

    @Override
    public String insertStatement(Receipt element) {
        return String.format("INSERT INTO receipts(receipt_price, receipt_discount, receipt_vat) " +
                "VALUES(%.2f, %.2f, %.2f);",
                element.getReceiptTotalPrice(),
                element.getReceiptTotalDiscount(),
                element.getReceiptTotalVAT());
    }

    @Override
    public String updateStatement(Receipt filter, Receipt update) {
        return String.format("UPDATE receipts SET " +
                "receipt_price = %.2f, " +
                "receipt_discount = %.2f, " +
                "receipt_vat = %.2f WHERE receipt_id = %d;",
                update.getReceiptTotalPrice(),
                update.getReceiptTotalDiscount(),
                update.getReceiptTotalVAT(),
                filter.getReceiptId());
    }

    @Override
    public String deleteStatement(Receipt filter) {
        return String.format("DELETE FROM receipts WHERE receipt_id = %d;", filter.getReceiptId());
    }
}
