package pao.database.sqlite.dao;

import pao.database.sqlite.dao.converter.DepartmentConverter;
import pao.database.sqlite.statements.DepartmentStatement;
import pao.entities.Department;

public class DepartmentDao extends CRUD<Department> {
    public DepartmentDao() {
        this.converter = new DepartmentConverter();
        this.sql = new DepartmentStatement();
    }
}
