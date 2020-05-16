package pao.database.sqlite.statements;

import pao.entities.Department;

public class DepartmentStatement implements Statement<Department> {
    @Override
    public String readAllStatement() {
        return "SELECT * FROM departments;";
    }

    @Override
    public String readStatement(Department filter) {
        return String.format("SELECT * FROM departments WHERE department_id = %d;", filter.getDepartmentId());
    }

    @Override
    public String insertStatement(Department element) {
        return String.format("INSERT INTO departments(department_name) VALUES('%s');", element.getName());
    }

    @Override
    public String updateStatement(Department filter, Department update) {
        return String.format("UPDATE departments SET department_name = '%s' WHERE department_id = %d;", update.getName(), filter.getDepartmentId());
    }

    @Override
    public String deleteStatement(Department filter) {
        return String.format("DELETE FROM departments WHERE department_id = %d;", filter.getDepartmentId());
    }
}
