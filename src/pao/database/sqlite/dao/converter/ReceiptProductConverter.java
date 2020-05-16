package pao.database.sqlite.dao.converter;

import pao.entities.*;
import pao.services.Discount;
import pao.services.DiscountByPercent;
import pao.services.DiscountByValue;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceiptProductConverter implements Converter<ReceiptProduct> {
    @Override
    public ReceiptProduct convert(ResultSet rs) {
        ReceiptProduct receiptProduct = null;
        try {
            Discount discount = this.discountType(
                    rs.getString("product_discount_type"),
                    rs.getDouble("product_discount_value"));

            VAT vat = this.vatType(rs.getString("product_vat"));

            receiptProduct = new ReceiptProduct(
                    rs.getInt("product_id"),
                    rs.getString("product_name"),
                    rs.getDouble("product_quantity"),
                    rs.getDouble("product_price"),
                    rs.getInt("department_id"),
                    rs.getInt("receipt_product_id"),
                    rs.getInt("receipt_id"),
                    discount,
                    vat);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return receiptProduct;
    }

    private Discount discountType(String ch, Double value) {
        if (ch.equals("V")) {
            return new DiscountByValue(value);
        } else if (ch.equals("P")) {
            return new DiscountByPercent(value);
        } else {
            return null;
        }
    }

    private VAT vatType(String ch) {
        if (ch.equals("A")) {
            return new TaxA();
        } else if (ch.equals("B")) {
            return new TaxB();
        } else {
            return null;
        }
    }
}
