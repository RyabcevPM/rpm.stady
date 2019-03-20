import javax.persistence.*;

@Entity
@Table(name = "teacher")
@SequenceGenerator(name = "teacherID", sequenceName = "seq_teacher", initialValue = 1, allocationSize = 1)
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacherID")
    int id;

    String name;

    int age;

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Teacher() {
    }
}
