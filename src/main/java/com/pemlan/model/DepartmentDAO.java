package com.pemlan.model;

import com.pemlan.db.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {

    public List<String> getAllDepartmentNames() {
        List<String> departmentNames = new ArrayList<>();
        String sql = "SELECT dept_name FROM department ORDER BY dept_name";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                departmentNames.add(rs.getString("dept_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departmentNames;
    }

    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<>();
        String sql = "SELECT dept_name, building, budget FROM department ORDER BY dept_name";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                departments.add(new Department(rs.getString("dept_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }
}