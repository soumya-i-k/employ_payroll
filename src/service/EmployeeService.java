package service;

import dao.*;
import dto.EmployeeDTO;
import java.util.List;

public class EmployeeService {

    private EmployeeDAO dao = new EmployeeDAOImpl();

    public void addEmployee(EmployeeDTO e) {

        if (e.getName() == null || e.getName().isEmpty()) {
            System.out.println("Name cannot be empty");
            return;
        }

        if (e.getSalary() < 0) {
            System.out.println("Salary cannot be negative");
            return;
        }

        dao.addEmployee(e);
    }

    public EmployeeDTO getEmployee(int id) {
        return dao.getEmployeeById(id);
    }

    public List<EmployeeDTO> getAllEmployees() {
        return dao.getAllEmployees();
    }

    public void updateEmployee(EmployeeDTO e) {
        dao.updateEmployee(e);
    }

    public void deleteEmployee(int id) {
        dao.deleteEmployee(id);
    }
}
