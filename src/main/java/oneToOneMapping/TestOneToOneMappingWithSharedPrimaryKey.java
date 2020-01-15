package oneToOneMapping;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.UtilityClass;

public class TestOneToOneMappingWithSharedPrimaryKey {

    public static void main(String[] args) {
        DoctorSharedPrimaryKey doc = new DoctorSharedPrimaryKey();
        doc.setDoctorName("Test");
        doc.setDoctorDegree("BDS");

        PatientSharedPrimaryKey patient = new PatientSharedPrimaryKey();
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
