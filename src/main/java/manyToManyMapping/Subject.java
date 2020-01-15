package manyToManyMapping;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity // mandatory
@Table(name = "Subject") // optional if not given then class name with small case will be name of table
@Getter
@Setter
@ToString
public class Subject {

    @Id // mandatory
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subjectID") // optional
    private Integer subjectID;
    private String subjectName;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy="subject")
    Set<Student> student;

    //mappedby::It means  that relation between entites has already been mapped, so you don't do that twice.
    // You just say "Hey it's done over there" by using mappedBy attribute.(mandatory)
    //if u will miss it then it will create one more table.(parentEntity_childEntity)
}
