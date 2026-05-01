package dao;

import dto.EmployeeDTO;
import java.util.List;

public interface EmployeeDAO {

    void addEmployee(EmployeeDTO e);

    EmployeeDTO getEmployeeById(int id);

    List<EmployeeDTO> getAllEmployees();

    void updateEmployee(EmployeeDTO e);

    void deleteEmployee(int id);
}
