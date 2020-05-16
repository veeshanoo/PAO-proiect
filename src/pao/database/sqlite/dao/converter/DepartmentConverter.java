package pao.database.sqlite.dao.converter;

import pao.entities.Department;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentConverter implements Converter<Department> {
    @Override
    public Department convert(ResultSet rs) {
        Department department = null;
        try {
            department = new Department(rs.getInt("department_id"), rs.getString("department_name"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return department;
    }
}
