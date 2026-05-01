package ui;

import javax.swing.*;
import service.EmployeeService;
import dto.EmployeeDTO;
import java.util.List;

public class EmployeeUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Payroll Management System");
        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        EmployeeService service = new EmployeeService();

        JButton addBtn = new JButton("Add Employee");
        addBtn.setBounds(150, 80, 200, 30);

        JButton viewBtn = new JButton("View Employees");
        viewBtn.setBounds(150, 130, 200, 30);

        JButton deleteBtn = new JButton("Delete Employee");
        deleteBtn.setBounds(150, 180, 200, 30);

        frame.add(addBtn);
        frame.add(viewBtn);
        frame.add(deleteBtn);

        frame.setVisible(true);

        // ADD
        addBtn.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter Name:");
            String dept = JOptionPane.showInputDialog("Enter Department:");
            double salary = Double.parseDouble(JOptionPane.showInputDialog("Enter Salary:"));

            service.addEmployee(new EmployeeDTO(0, name, dept, salary));
            JOptionPane.showMessageDialog(null, "Employee Added!");
        });

        // VIEW
        viewBtn.addActionListener(e -> {
            List<EmployeeDTO> list = service.getAllEmployees();

            String[] cols = {"ID", "Name", "Department", "Salary"};
            String[][] data = new String[list.size()][4];

            for (int i = 0; i < list.size(); i++) {
                EmployeeDTO emp = list.get(i);
                data[i][0] = String.valueOf(emp.getId());
                data[i][1] = emp.getName();
                data[i][2] = emp.getDepartment();
                data[i][3] = String.valueOf(emp.getSalary());
            }

            JTable table = new JTable(data, cols);
            JOptionPane.showMessageDialog(null, new JScrollPane(table));
        });

        // DELETE
        deleteBtn.addActionListener(e -> {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID:"));
            service.deleteEmployee(id);
            JOptionPane.showMessageDialog(null, "Deleted!");
        });
    }
}
