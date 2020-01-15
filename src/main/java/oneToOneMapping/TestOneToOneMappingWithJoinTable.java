package oneToOneMapping;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.UtilityClass;

public class TestOneToOneMappingWithJoinTable {
    public static void main(String[] args) {
        DoctorWithJointable doc = new DoctorWithJointable();
        doc.setDoctorName("Test");
        doc.setDoctorDegree("BDS");

        PatientDoctorWithJointable patient = new PatientDoctorWithJointable();
        patient.setPatientName("patient1");
        patient.setPatientProblem("GeneralProblem");
        patient.setDoctor(doc);
        doc.setPatient(patient);

        Session session = UtilityClass.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(doc);
        tx.commit();
        session.close();
    }
}
