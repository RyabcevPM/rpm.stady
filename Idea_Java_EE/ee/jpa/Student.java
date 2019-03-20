import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "student")
@SequenceGenerator(name = "StudentID", sequenceName = "SEQ_STUDENT", initialValue = 14, allocationSize = 1)
//@Access(AccessType.FIELD)
@DiscriminatorColumn(name = "class_name")
@DiscriminatorValue("S")
@Inheritance(strategy = InheritanceType.JOINED)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "StudentID")
    int id;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    byte[] foto;

    @Basic(optional = false)
    @Column(name = "name", length = 250, nullable = false)
    String name;
    int age;

    @Column(name = "sex")
    @Enumerated(EnumType.STRING)
    StudGender studGender;

    transient Date appFactDate;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "STUDENT_MARKS")
    @Column(name = "FACKT_DATE", columnDefinition = "Date")
    @MapKeyColumn(name = "MARK")
    Map<String, Date> marks = new HashMap<>();


    @OneToOne(cascade = CascadeType.PERSIST)
    StudentAddress address;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_to_teacher")
    List<Teacher> teachers = new ArrayList<>();


    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        appFactDate = new Date();
        studGender = StudGender.ALIEN;
        marks.put("one", new Date());
        marks.put("two", new Date());
        marks.put("three", new Date());
    }

    public Student() {
    }

    @Access(AccessType.PROPERTY)
    public String getName() {
        return "Mr. " + name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentAddress getAddress() {
        return address;
    }

    public void setAddress(StudentAddress address) {
        this.address = address;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }


}

enum StudGender{ALIEN, MAN, WOMAN}


