package pao.database.sqlite.dao.converter;

import pao.entities.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductConverter implements Converter<Product> {
    @Override
    public Product convert(ResultSet rs) {
        Product product = null;
        try {
            product = new Product(rs.getInt("product_id"),
                    rs.getString("product_name"),
                    rs.getDouble("product_quantity"),
                    rs.getDouble("product_price"),
                    rs.getInt("department_id"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return product;
    }
}
