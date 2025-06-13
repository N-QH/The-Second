package test_DAO;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        // Thêm mới Employee
        Employee newEmployee = new Employee();
        newEmployee.setName("Nguyen Van C");
        newEmployee.setDepartment("IT");
        employeeDAO.saveEmployee(newEmployee);

        // Lấy Employee theo ID
        Employee employee = employeeDAO.getEmployee(1);
        if (employee != null) {
            System.out.println("Employee Found: " + employee.getName());
        }

        // Cập nhật Employee
        employee.setDepartment("Finance");
        employeeDAO.updateEmployee(employee);

        // Xóa Employee
        employeeDAO.deleteEmployee(1);

        // Lấy tất cả Employee
        List<Employee> employees = employeeDAO.getAllEmployees();
        employees.forEach(emp -> System.out.println("Employee: " + emp.getName()));
    }
}
