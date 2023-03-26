package DTOs;

import javax.security.auth.Subject;
import java.util.Date;

public class TeachersDTO {

    int id;

    String name;

    String dni;

    Date age;

    SubjectsDTO subject;

    public TeachersDTO(int id, String name, String dni, Date age, SubjectsDTO subject) {
        this.id = id;
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

    public SubjectsDTO getSubject() {
        return subject;
    }

    public void setSubject(SubjectsDTO subject) {
        this.subject = subject;
    }
}
