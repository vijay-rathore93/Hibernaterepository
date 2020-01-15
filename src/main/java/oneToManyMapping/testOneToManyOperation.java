package oneToManyMapping;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.UtilityClass;

import java.util.HashSet;
import java.util.Set;

public class testOneToManyOperation {

    public static void main(String[] args) {

        Set<RoleWithForeignKeyWay> roleWithForeignKeyWaySet = new HashSet<RoleWithForeignKeyWay>();
        UserWithForeignKeyWay userWithForeignKeyWay = new UserWithForeignKeyWay();

        userWithForeignKeyWay.setUserName("rathorvijay529@gmail.com");

        RoleWithForeignKeyWay roleWithForeignKeyWay = new RoleWithForeignKeyWay();
        RoleWithForeignKeyWay roleWithForeignKeyWay1 = new RoleWithForeignKeyWay();

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
