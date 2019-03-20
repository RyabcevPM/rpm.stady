import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class JpaExample {
    public static void main(String[] args) {
        EntityManagerFactory rpmDB1 = Persistence.createEntityManagerFactory("rpmDB1");
        EntityManager entityManager = rpmDB1.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Student polly = new Student("Polly", 23);
        Student molly = new Student("Molly", 24);
        Student dolly = new Student("Dolly", 24);
        Bachelor dandy = new Bachelor("Dandy", 31, 2500);


        StudentAddress address1 = new StudentAddress("г. Минск ул. Пономорева 1А");
        StudentAddress address2 = new StudentAddress("г. Минск ул. Победы 22");
        polly.setAddress(address1);
        molly.setAddress(address1);
        dolly.setAddress(address2);
        dandy.setAddress(address2);


        Teacher Billy = new Teacher("Billy",31);
        Teacher Willy = new Teacher("Willy",32);
        Teacher Dilly = new Teacher("Dilly",33);
        Teacher Albert = new Teacher("Albert",90);
        ArrayList<Teacher> teachers1 = new ArrayList<>();
        ArrayList<Teacher> teachers2 = new ArrayList<>();
        teachers1.add(Billy);
        teachers1.add(Willy);
        teachers1.add(Albert);
        teachers2.add(Billy);
        teachers2.add(Dilly);
        polly.setTeachers(teachers1);
        molly.setTeachers(teachers1);
        dolly.setTeachers(teachers2);
        dandy.setTeachers(teachers2);


        entityManager.persist(polly);
        entityManager.persist(molly);
        entityManager.persist(dolly);
        entityManager.persist(dandy);

        transaction.commit();
        entityManager.close();
        rpmDB1.close();
    }
}
