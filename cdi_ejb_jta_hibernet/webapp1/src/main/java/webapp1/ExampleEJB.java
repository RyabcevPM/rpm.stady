package webapp1;

import javax.ejb.Stateless;
import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ExampleEJB {

    @PersistenceContext(unitName = "OracleDB")
    private EntityManager entityManager;

    public boolean checkPassword(String login, String password) {
        System.out.println(String.format(">>>>> %S(%S,%S)", "checkPassword", login, password));
        System.out.println(login);
        System.out.println(password);

        if (login == null || password == null) {
            return false;
        }
        UserEntity userEntity = entityManager.find(UserEntity.class, login);
        if (userEntity != null) {
            return password.equals(userEntity.getPassword());
        }
        return false;
    }

    public boolean createUser(String login, String password) {
        System.out.println(String.format(">>>>> %S(%S,%S)", "createUser", login, password));
        System.out.println(login);
        System.out.println(password);

        if (login == null || password == null) {
            return false;
        }

        UserEntity userEntity = entityManager.find(UserEntity.class, login);
        if (userEntity != null) {
            return false;
        }

        userEntity = new UserEntity();
        userEntity.setLogin(login);
        userEntity.setPassword(password);
        entityManager.persist(userEntity);

        return true;
    }
}
