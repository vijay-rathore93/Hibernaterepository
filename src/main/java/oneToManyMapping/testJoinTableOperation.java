package oneToManyMapping;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.UtilityClass;

import java.util.HashSet;
import java.util.Set;

public class testJoinTableOperation {

    public static void main(String[] args) {

        Set<RoleWithJoinTable> roleWithForeignKeyWaySet = new HashSet<RoleWithJoinTable>();
        UserWithJoinTable userWithForeignKeyWay = new UserWithJoinTable();

        userWithForeignKeyWay.setUserName("rathorvijay529@gmail.com");

        RoleWithJoinTable roleWithForeignKeyWay = new RoleWithJoinTable();
        RoleWithJoinTable roleWithForeignKeyWay1 = new RoleWithJoinTable();

        roleWithForeignKeyWay.setRoleName("ADMIN");
        roleWithForeignKeyWay.setUser(userWithForeignKeyWay);
        roleWithForeignKeyWay1.setRoleName("USER");
        roleWithForeignKeyWay1.setUser(userWithForeignKeyWay);
        roleWithForeignKeyWaySet.add(roleWithForeignKeyWay);
        roleWithForeignKeyWaySet.add(roleWithForeignKeyWay1);
        userWithForeignKeyWay.setRole(roleWithForeignKeyWaySet);

        Session session = UtilityClass.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(userWithForeignKeyWay);
        tx.commit();
        session.close();
    }
}
