package employeeOperation;

import entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.UtilityClass;

import java.io.Serializable;

public class EmployeeOperations {

    public String createEmployeeWithSaveMethod() {
        Employee emp = new Employee();
        emp.setFirstName("Vijay1");
        emp.setLastName("Rathor1");//Transient
        Session session = UtilityClass.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();//Desktop application,@Transaction is Spring annotation not hibernate
        Serializable object = session.save(emp);
        emp.setLastName("XYZ");//Persistance
        tx.commit();
        session.close();//Detached
        Integer status = (Integer) object;
        if (status > 0) return "Created";
        return "not created";
    }

    public void getEmployeeWithGet() {
        Session session = UtilityClass.getSessionFactory().openSession();
        Employee emp = session.get(Employee.class, 1);
        System.out.println("Employee Info::" + emp);
        //if any operation u r performing on null, you will get NullPointerException.
    }

    public void getEmployeeWithLoad() {
        Session session = UtilityClass.getSessionFactory().openSession();
        Employee emp = session.load(Employee.class, 1);
        System.out.println("Employee Info::" + emp);
    }

    public void createEmployeeWithPersistMethod() {
        Employee emp = new Employee();
        emp.setFirstName("Vijay1");
        emp.setLastName("Rathor1");//Transient
        Session session = UtilityClass.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();//Desktop application,@Transaction is Spring annotation not hibernate
        session.persist(emp);
        emp.setLastName("XYZ");//Persistance
        tx.commit();
        session.close();//Detached


    }
}
