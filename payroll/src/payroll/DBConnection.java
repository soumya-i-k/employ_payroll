package payroll;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/payroll_db",
                "root",
                "Ambabhavani@5151"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
