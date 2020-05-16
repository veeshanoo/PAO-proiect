package pao.database.sqlite.dao;

import pao.database.sqlite.dao.converter.DepartmentConverter;
import pao.database.sqlite.statements.DepartmentStatement;
import pao.entities.Department;

import java.util.List;
import java.util.TreeMap;

public class DepartmentDao extends CRUD<Department> {
    static private final DepartmentDao instance = new DepartmentDao();

    public static DepartmentDao getInstance() {
        return instance;
    }

    private DepartmentDao() {
        this.converter = new DepartmentConverter();
        this.sql = new DepartmentStatement();
    }

    public TreeMap<Integer, Department> loadData() {
        TreeMap<Integer, Department> departments = new TreeMap<>();

        List<Department> depList = this.readAll();
        for (Department department : depList) {
            departments.put(department.getDepartmentId(), department);
        }

        return departments;
    }
}
