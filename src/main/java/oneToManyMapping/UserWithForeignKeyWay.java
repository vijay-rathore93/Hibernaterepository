package oneToManyMapping;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity // mandatory
@Table(name = "User") // optional if not given then class name with small case will be name of table
@Getter
@Setter
@ToString
public class UserWithForeignKeyWay {

    @Id // mandatory
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID") // optional
    private Integer userID;
    private String userName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<RoleWithForeignKeyWay> role;
}
