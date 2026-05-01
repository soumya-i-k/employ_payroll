/*************************************************************
- Main class is the user interface layer (CLI version).
- It takes input using Scanner.
- It calls service layer, not DAO directly.
- Useful for testing and record submission.
***************************************************************/

import service.EmployeeService;
import dto.EmployeeDTO;

import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        EmployeeService service = new EmployeeService();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Payroll Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Get Employee By ID");
            System.out.println("3. Get All Employees");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.next();

                    System.out.print("Enter Department: ");
                    String dept = sc.next();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    service.addEmployee(new EmployeeDTO(0, name, dept, salary));
                    break;

                case 2:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();

                    EmployeeDTO emp = service.getEmployee(id);

                    if (emp != null) {
                        System.out.println(
                                emp.getId() + " " +
                                emp.getName() + " " +
                                emp.getDepartment() + " " +
                                emp.getSalary()
                        );
                    } else {
                        System.out.println("Employee not found");
                    }
                    break;

                case 3:
                    List<EmployeeDTO> list = service.getAllEmployees();

                    if (list.isEmpty()) {
                        System.out.println("No records found");
                    } else {
                        list.forEach(e ->
                                System.out.println(
                                        e.getId() + " " +
                                        e.getName() + " " +
                                        e.getDepartment() + " " +
                                        e.getSalary()
                                )
                        );
                    }
                    break;

                case 4:
                    System.out.print("Enter Employee ID: ");
                    int uid = sc.nextInt();

                    System.out.print("Enter New Name: ");
                    String newName = sc.next();

                    System.out.print("Enter New Department: ");
                    String newDept = sc.next();

                    System.out.print("Enter New Salary: ");
                    double newSalary = sc.nextDouble();

                    service.updateEmployee(
                            new EmployeeDTO(uid, newName, newDept, newSalary)
                    );
                    break;

                case 5:
                    System.out.print("Enter Employee ID: ");
                    int did = sc.nextInt();
                    service.deleteEmployee(did);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
