package oneToOneMapping;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.UtilityClass;

public class TestOneToOneMappingWithForeignKey {
    public static void main(String[] args) {
        DoctorWithForeignKey doc = new DoctorWithForeignKey();
        doc.setDoctorName("Test");
        doc.setDoctorDegree("BDS");

        PatientWithForeignKey patient = new PatientWithForeignKey();
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
