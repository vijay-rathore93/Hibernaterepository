package oneToManyMapping;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity // mandatory
@Table(name = "Role") // optional if not given then class name with small case will be name of table
@Getter
@Setter
@ToString
public class RoleWithForeignKeyWay {

    @Id //mandatory
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleId") //optional
    private Integer roleId;
    private String  roleName;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private UserWithForeignKeyWay user;


}
