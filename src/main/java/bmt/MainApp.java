package bmt;

public class MainApp {
    public static void main(String[] args) {

        EmployeeService employeeService = new EmployeeService();
        employeeService.insertEmployee("Hoa hoa hoa", "Sales"); // Xóa Employee có ID = 1
        // employeeService.updateEmployee(1, "Nguyen Van B", "Marketing");
        // employeeService.deleteEmployee(3); // Xóa Employee có ID = 3
    }
}
