package manyToManyMapping;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity // mandatory
@Table(name = "Student") // optional if not given then class name with small case will be name of table
@Getter
@Setter
@ToString
public class Student {
    @Id // mandatory
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stdID") // optional
    private Integer stdID;
    private String StudentName;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name="ManyToManyCommonTable", joinColumns={@JoinColumn(referencedColumnName="stdID")}
            , inverseJoinColumns={@JoinColumn(referencedColumnName="subjectID")})
    Set<Subject> subject;
}
