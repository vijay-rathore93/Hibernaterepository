import employeeOperation.EmployeeOperations;
import entity.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class TestConcept {
    public static void main(String[] args) {

        EmployeeOperations emp = new EmployeeOperations();
       /* emp.createEmployeeWithSaveMethod();
        emp.getEmployeeWithGet();
        emp.getEmployeeWithLoad();*/
       emp.createEmployeeWithPersistMethod();

    }
}
