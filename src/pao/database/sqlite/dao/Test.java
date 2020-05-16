package pao.database.sqlite.dao;

import pao.entities.Department;
import pao.entities.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Test {
    public static void createProductsTable() {
        String url = "jdbc:sqlite:database/sqlite/test.db";

        String sql = "CREATE TABLE IF NOT EXISTS products (\n"
                + "	product_id integer PRIMARY KEY,\n"
                + "	product_name text NOT NULL,\n"
                + " product_quantity real,\n"
                + " product_price real,\n"
                + " department_id integer\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createDepartmentsTable() {
        String url = "jdbc:sqlite:database/sqlite/test.db";

        String sql = "CREATE TABLE IF NOT EXISTS departments (\n"
                + "	department_id integer PRIMARY KEY,\n"
                + "	department_name text NOT NULL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        createProductsTable();

        ProductDao dao = new ProductDao();

//        dao.insert(new Product(1, "pere", 2.0, 36.0, 2));

//        System.out.println(dao.read(new Product(1, "", 2.0, 3.0, 4)).getQuantity());
//        List<Product> list = dao.readAll();
//
//        for (Product el : list) {
//            System.out.println(el.getName());
//        }
//        dao.update(new Product(2, "", 2.0, 2.0, 2), new Product(2, "asdfa", 3.0, 2.1, 1));
    }
}
