package Repository.Entities;
import java.util.Date;

public class Teachers {

    private int id;

    private String name;

    private String dni;

    private Date age;

    private Subjects subject;

    public Teachers(int id, String name, String dni, Date age, Subjects subject) {
        this.id = id;
        this.name = name;
        this.dni = dni;
        this.age = age;
        this.subject = subject;
    }

    public Teachers(String name, String dni, Date age, Subjects subject) {
        this.name = name;
        this.dni = dni;
        this.age = age;
        this.subject = subject;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public Subjects getSubject() {
        return subject;
    }

    public void setSubject(Subjects subject) {
        this.subject = subject;
    }

}
