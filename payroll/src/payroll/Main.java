package payroll;

import payroll.EmployeeDAO;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Employee Payroll System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Delete Employee");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Department: ");
                    String dept = sc.nextLine();
                    System.out.print("Basic Salary: ");
                    double basic = sc.nextDouble();
                    EmployeeDAO.addEmployee(name, dept, basic);
                    break;

                case 2:
                    EmployeeDAO.viewEmployees();
                    break;

                case 3:
                    System.out.print("Employee ID: ");
                    int id = sc.nextInt();
                    EmployeeDAO.deleteEmployee(id);
                    break;

                case 4:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}

