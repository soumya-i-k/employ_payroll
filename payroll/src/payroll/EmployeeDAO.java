package payroll;

import payroll.DBConnection;
import java.sql.*;

public class EmployeeDAO {

    public static void addEmployee(String name, String dept, double basic) {
        try {
            Connection con = DBConnection.getConnection();

            double hra = basic * 0.20;
            double da = basic * 0.10;

            String sql =
                "INSERT INTO employee(name,department,basic_salary,hra,da) VALUES(?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, dept);
            ps.setDouble(3, basic);
            ps.setDouble(4, hra);
            ps.setDouble(5, da);

            ps.executeUpdate();
            System.out.println("✅ Employee Added Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewEmployees() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM employee");

            System.out.println("\nID | Name | Dept | Basic | HRA | DA | Net Salary");

            while (rs.next()) {
                double net =
                    rs.getDouble("basic_salary") +
                    rs.getDouble("hra") +
                    rs.getDouble("da");

                System.out.println(
                    rs.getInt("emp_id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("department") + " | " +
                    rs.getDouble("basic_salary") + " | " +
                    rs.getDouble("hra") + " | " +
                    rs.getDouble("da") + " | " +
                    net
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteEmployee(int id) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                con.prepareStatement("DELETE FROM employee WHERE emp_id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("❌ Employee Deleted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
