package MVC;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.sql.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


public class MyModel {

    private Connection direct_connect;

    private Connection connect1;

    private static final String GET_RANDOM_STUDENT = "select t.*, t.rowid from STUDENT t ORDER BY dbms_random.value FETCH FIRST ROWS ONLY";

    private int cnt;

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }


    public Student getStudent() throws SQLException, ClassNotFoundException {
        if (connect1 == null){
            connect1 = ConnectProducer.getOraDBConnection1();
        }

        ResultSet resultSet = connect1.createStatement().executeQuery(GET_RANDOM_STUDENT);
        resultSet.next();

        Student student = new Student();
        student.setName(resultSet.getString("name"));
        student.setAge(resultSet.getInt("age"));
        return student;
    }
}



class ConnectProducer {

    static public Connection getOraDBConnection1(){
        System.out.println("ConnectProducer.getConnection() #OraDB1");
        String url = "jdbc:oracle:thin:@//scomplat.scx:1521/komplat";
        String username = "rpm_test";
        String password = "rpm_test";
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Драйвер не найден");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Подключиься к БД не удалось");
        }
        return conn;
    }

}
