package pao.database.sqlite.statements;

import pao.entities.ReceiptProduct;

public class ReceiptProductStatement implements Statement<ReceiptProduct> {
    @Override
    public String readAllStatement() {
        return "SELECT * FROM receipt_products;";
    }

    @Override
    public String readAllFilteredStatement(String[] filters) {
        return String.format("SELECT * FROM receipt_products WHERE receipt_id = %d;", Integer.parseInt(filters[0]));
    }

    @Override
    public String readStatement(ReceiptProduct filter) {
        return String.format("SELECT * FROM products WHERE product_id = %d;", filter.getProductId());
    }

    @Override
    public String insertStatement(ReceiptProduct element) {
        return String.format("INSERT INTO receipt_products" +
                        "(product_id, product_name, product_quantity, product_price, department_id, receipt_id, product_discount_type, product_discount_value, product_vat) " +
                        "VALUES('%s', '%s', %.2f, %.2f, %d, %d, '%s', %.2f, '%s');",
                        element.getProductId(),
                        element.getName(),
                        element.getQuantity(),
                        element.getPrice(),
                        element.getDepartmentId(),
                        element.getReceiptId(),
                        element.getDiscount().identify(),
                        element.getDiscount().getValue(),
                        element.getVat().identify());
    }

    @Override
    public String updateStatement(ReceiptProduct filter, ReceiptProduct update) {
        return null;
    }

    @Override
    public String deleteStatement(ReceiptProduct filter) {
        return String.format("DELETE FROM receipt_products WHERE receipt_product_id = %d;", filter.getReceiptProductId());
    }
}
