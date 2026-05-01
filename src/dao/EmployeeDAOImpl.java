package dao;

import dto.EmployeeDTO;
import java.sql.*;
import java.util.*;

public class EmployeeDAOImpl implements EmployeeDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/rnsitdb";
    private static final String USER = "root";
    private static final String PASS = "Kani1290@Hele";

    @Override
    public void addEmployee(EmployeeDTO e) {
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            String sql = "INSERT INTO employees(name, department, salary) VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, e.getName());
            pst.setString(2, e.getDepartment());
            pst.setDouble(3, e.getSalary());

            pst.executeUpdate();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public EmployeeDTO getEmployeeById(int id) {
        EmployeeDTO e = null;
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            String sql = "SELECT * FROM employees WHERE id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                e = new EmployeeDTO(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getDouble("salary")
                );
            }

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return e;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeDTO> list = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            String sql = "SELECT * FROM employees";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                list.add(new EmployeeDTO(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getDouble("salary")
                ));
            }

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public void updateEmployee(EmployeeDTO e) {
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            String sql = "UPDATE employees SET name=?, department=?, salary=? WHERE id=?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, e.getName());
            pst.setString(2, e.getDepartment());
            pst.setDouble(3, e.getSalary());
            pst.setInt(4, e.getId());

            pst.executeUpdate();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            String sql = "DELETE FROM employees WHERE id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);

            pst.executeUpdate();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
