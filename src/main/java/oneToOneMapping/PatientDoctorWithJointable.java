package oneToOneMapping;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
@Entity // mandatory
@Table(name = "PatientDoctorWithJointable") // optional if not given then class name with small case will be name of table
@Getter
@Setter
@ToString
public class PatientDoctorWithJointable {

    @Id // mandatory
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientID;
    private String patientName;
    private String patientProblem;

    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
    private DoctorWithJointable doctor;


}
