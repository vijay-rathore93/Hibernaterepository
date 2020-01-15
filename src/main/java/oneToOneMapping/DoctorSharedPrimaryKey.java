package oneToOneMapping;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity // mandatory
@Table(name = "DoctorSharedPrimaryKey") // optional if not given then class name with small case will be name of table
@Getter
@Setter
@ToString
public class DoctorSharedPrimaryKey {

    @Id // mandatory
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "docID") // optional
    private Integer docID;
    private String doctorName;
    private String doctorDegree;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private PatientSharedPrimaryKey patient;
}
//unidirectional
//Onetoone has 3 ways:
//1.primary key
//2.foreign key
////3.join table