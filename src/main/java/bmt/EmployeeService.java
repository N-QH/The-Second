package bmt;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeService {
    public void insertEmployee(String newName, String newDepartment) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Employee emp = new Employee(newName, newDepartment);
            session.save(emp);

            transaction.commit();

            System.out.println("Employee saved successfully!");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.shutdown();
        }
    }

    public void updateEmployee(int employeeId, String newName, String newDepartment) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            
            // Tìm đối tượng Employee cần cập nhật
            Employee employee = session.get(Employee.class, employeeId);
            if (employee != null) {
                // Sửa các thuộc tính của Employee
                employee.setName(newName);
                employee.setDepartment(newDepartment);
                
                // Hibernate tự động phát hiện thay đổi và thực hiện cập nhật
                session.update(employee);
            } else {
                System.out.println("Employee not found with ID: " + employeeId);
            }

            transaction.commit();
            System.out.println("Employee updated successfully");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteEmployee(int employeeId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            
            // Tìm đối tượng Employee cần xóa
            Employee employee = session.get(Employee.class, employeeId);
            if (employee != null) {
                // Xóa bản ghi Employee
                session.delete(employee);
                System.out.println("Employee deleted successfully");
            } else {
                System.out.println("Employee not found with ID: " + employeeId);
            }

            transaction.commit();
            System.out.println("Employee deleted successfully");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
