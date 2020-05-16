package pao.database.sqlite.dao;

import pao.database.sqlite.dao.converter.ProductConverter;
import pao.database.sqlite.statements.ProductStatement;
import pao.entities.Product;

import java.util.List;
import java.util.TreeMap;

public class ProductDao extends CRUD<Product> {
    static private final ProductDao instance = new ProductDao();

    public static ProductDao getInstance() {
        return instance;
    }

    private ProductDao() {
        this.converter = new ProductConverter();
        this.sql = new ProductStatement();
    }

    public TreeMap<Integer, Product> loadData() {
        TreeMap<Integer, Product> products = new TreeMap<>();

        List<Product> prodList = this.readAll();
        for (Product product : prodList) {
            products.put(product.getProductId(), product);
        }

        return products;
    }
}
