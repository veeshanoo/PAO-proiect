package pao.database.sqlite.dao;

import pao.database.sqlite.dao.converter.Converter;
import pao.database.sqlite.statements.Statement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUD<T> implements Dao<T> {
    protected Statement<T> sql;
    protected Converter<T> converter;

    private Connection connect() {
        String url = "jdbc:sqlite:database/sqlite/test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    @Override
    public List<T> readAll() {
        String sql = this.sql.readAllStatement();

        List<T> list = new ArrayList<>();
        try (
            Connection conn = this.connect();
            java.sql.Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)
        ) {
            while (rs.next()) {
                list.add(this.converter.convert(rs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    @Override
    public T read(T filter) {
        String sql = this.sql.readStatement(filter);

        T t = null;
        try (
            Connection conn = this.connect();
            java.sql.Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)
        ) {
            while (rs.next()) {
                t = this.converter.convert(rs);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return t;
    }

    @Override
    public void insert(T element) {
        String sql = this.sql.insertStatement(element);

        try (
            Connection conn = this.connect();
            PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(T filter, T update) {
        String sql = this.sql.updateStatement(filter, update);

        try (
            Connection conn = this.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(T filter) {
        String sql = this.sql.deleteStatement(filter);

        try (
            Connection conn = this.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
