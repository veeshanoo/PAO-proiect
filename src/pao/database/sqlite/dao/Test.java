package pao.database.sqlite.dao;

import pao.entities.*;
import pao.services.DiscountByPercent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

    public static void createReceiptsTable() {
        String url = "jdbc:sqlite:database/sqlite/test.db";

        String sql = "CREATE TABLE IF NOT EXISTS receipts (\n"
                + "	receipt_id integer PRIMARY KEY,\n"
                + "	receipt_price real,\n"
                + " receipt_discount real,\n"
                + " receipt_vat real\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createReceiptProductsTable() {
        String url = "jdbc:sqlite:database/sqlite/test.db";

        String sql = "CREATE TABLE IF NOT EXISTS receipt_products (\n"
                + " receipt_product_id integer PRIMARY KEY,\n"
                + "	product_id integer,"
                + "	product_name text NOT NULL,\n"
                + " product_quantity real,\n"
                + " product_price real,\n"
                + " department_id integer,\n"
                + " receipt_id integer,\n"
                + " product_discount_type text NOT NULL,\n"
                + " product_discount_value real,\n "
                + " product_vat text NOT NULL"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createTables() {
        createDepartmentsTable();
        createProductsTable();
        createReceiptsTable();
        createReceiptProductsTable();
    }

    public static void main(String[] args) {
        createTables();

//        ReceiptDao dao = new ReceiptDao();
//        dao.insert(new Receipt());

//        Receipt receipt = new Receipt();
//        receipt.setReceiptId(1);
//        Receipt receipt1 = new Receipt();
//        receipt1.setReceiptTotalDiscount(2.0);
//        dao.delete(receipt);

//        ProductReceiptDao dao = new ProductReceiptDao();
//
//        ReceiptProduct receiptProduct = new ReceiptProduct(1, "fructe", 2.0, 1.0, 2, -1, 3, new DiscountByPercent(2.0), new TaxA());
//
//        dao.insert(receiptProduct);
//        dao.insert(receiptProduct);

//        String []filter = new String[1];
//        filter[0] = "2";
//        List<ReceiptProduct> list = dao.readAllFiltered(filter);
//        for (ReceiptProduct product : list) {
//            System.out.println(product.toString());
//        }
    }
}
