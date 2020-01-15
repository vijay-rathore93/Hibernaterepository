package manyToManyMapping;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.UtilityClass;

import java.util.HashSet;
import java.util.Set;

public class TestManyToMany {

    public static void main(String[] args) {

        Set<Student> studentSet = new HashSet<Student>();
        Set<Subject> subjectSet = new HashSet<Subject>();

        Student student = new Student();
        student.setStudentName("Vijay");
        student.setSubject(subjectSet);

        Student student1 = new Student();
        student1.setStudentName("Payal");
        student1.setSubject(subjectSet);

        Subject subject = new Subject();
        Subject subject1 = new Subject();
        subject.setSubjectName("maths");
        subject.setStudent(studentSet);
        subject1.setSubjectName("Physics");
        subject.setStudent(studentSet);

//adding the value in set for manyToMny mapping.
        studentSet.add(student);
        studentSet.add(student1);
//adding the value in set for manyToMny mapping.
        subjectSet.add(subject);
        subjectSet.add(subject1);


        Session session = UtilityClass.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(student);
        session.save(student1);
        tx.commit();
        session.close();
    }
}
