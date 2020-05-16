package pao.database.sqlite.statements;

import pao.entities.Product;

public class ProductStatement implements Statement<Product> {
    @Override
    public String readAllStatement() {
        return "SELECT * FROM products;";
    }

    @Override
    public String readAllFilteredStatement(String[] filters) {
        return null;
    }

    @Override
    public String readStatement(Product filter) {
        return String.format("SELECT * FROM products WHERE product_id = %d;", filter.getProductId());
    }

    @Override
    public String insertStatement(Product element) {
        return String.format("INSERT INTO products(product_name, product_quantity, product_price, department_id) " +
                "VALUES('%s', %.2f, %.2f, %d);",
                element.getName(), element.getQuantity(), element.getPrice(), element.getDepartmentId());
    }

    @Override
    public String updateStatement(Product filter, Product update) {
        return String.format("UPDATE products SET " +
                "product_name = '%s', " +
                "product_quantity = %.2f, " +
                "product_price = %.2f, " +
                "department_id = %d WHERE product_id = %d;",
                update.getName(), update.getQuantity(), update.getPrice(), update.getDepartmentId(), filter.getProductId());
    }

    @Override
    public String deleteStatement(Product filter) {
        return String.format("DELETE FROM products WHERE product_id = %d;", filter.getProductId());
    }
}
