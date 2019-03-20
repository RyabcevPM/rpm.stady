import javax.persistence.*;

@Entity
@DiscriminatorColumn(name = "class_name")
@DiscriminatorValue("B")
@Inheritance(strategy = InheritanceType.JOINED)
public class Bachelor extends Student{
    int salary;

    public Bachelor(String name, int age, int salary) {
        super(name, age);
        this.salary = salary;
    }

    public Bachelor(int salary) {
        this.salary = salary;
    }

    public Bachelor() {
    }
}
