package entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity // mandatory
@Table(name = "Employee") // optional if not given then class name with small case will be name of table
@Getter
@Setter
@ToString
public class Employee {
    @Id // mandatory
    @GeneratedValue(strategy = GenerationType.IDENTITY) // mandatory
    @Column(name = "emp_ID") // optional
    private Integer empID;
    @Column(name = "firstName") // optional
    private String firstName;
    @Column(name = "lastName") // optional
    private String lastName;
  /*  @Transient//never participate in Table creation
    @Column(name = "test") // optional
    private String test;
*/

}
