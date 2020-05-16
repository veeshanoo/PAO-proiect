package pao.database.sqlite.dao.converter;

import pao.entities.Product;
import pao.entities.Receipt;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceiptConverter implements Converter<Receipt> {
    @Override
    public Receipt convert(ResultSet rs) {
        Receipt receipt = null;
        try {
            receipt = new Receipt();
            receipt.setReceiptId(rs.getInt("receipt_id"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return receipt;
    }
}
