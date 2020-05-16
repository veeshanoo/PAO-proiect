package pao.database.sqlite.dao;

import pao.database.sqlite.dao.converter.ProductConverter;
import pao.database.sqlite.statements.ProductStatement;
import pao.entities.Product;

public class ProductDao extends CRUD<Product> {
    public ProductDao() {
        this.converter = new ProductConverter();
        this.sql = new ProductStatement();
    }
}
