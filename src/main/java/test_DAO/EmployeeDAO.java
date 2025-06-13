package test_DAO;

import java.util.List;

public interface EmployeeDAO {
    void saveEmployee(Employee employee);        // Thêm mới Employee
    Employee getEmployee(int id);                // Lấy Employee theo ID
    void updateEmployee(Employee employee);      // Cập nhật Employee
    void deleteEmployee(int id);                 // Xóa Employee theo ID
    List<Employee> getAllEmployees();            // Lấy tất cả Employee
}