package oneToOneMapping;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity // mandatory
@Table(name = "DoctorWithForeignKey") // optional if not given then class name with small case will be name of table
@Getter
@Setter
@ToString
public class DoctorWithForeignKey {

    @Id // mandatory
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "docID") // optional
    private Integer docID;
    private String doctorName;
    private String doctorDegree;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "columnWhichTellPrimaryKeyOfAssociatedtable")
    private PatientWithForeignKey patient;
}
