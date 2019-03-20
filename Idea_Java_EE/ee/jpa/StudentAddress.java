import javax.persistence.*;

@Entity
@Table(name = "student_address")
@SequenceGenerator(name = "AddrID", sequenceName = "SEQ_ADDRESS", initialValue = 1, allocationSize = 1)
public class StudentAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AddrID")
    int id;

    String address;

    public StudentAddress(String address) {
        this.address = address;
    }

    public StudentAddress() {
    }
}
