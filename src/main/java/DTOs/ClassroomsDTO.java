package DTOs;

import javax.security.auth.Subject;
import java.util.List;

public class ClassroomsDTO {

    int id;

    String name;

    int course;

    Subject subject;

    TeachersDTO teacher;

    List<StudentsDTO> students;

    int quantityOfStudents;

    public ClassroomsDTO(int id, String name, int course, Subject subject, TeachersDTO teacher, List<StudentsDTO> students, int quantityOfStudents) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.subject = subject;
        this.teacher = teacher;
        this.students = students;
        this.quantityOfStudents = quantityOfStudents;
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

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public TeachersDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeachersDTO teacher) {
        this.teacher = teacher;
    }

    public List<StudentsDTO> getStudents() {
        return students;
    }

    public void setStudents(List<StudentsDTO> students) {
        this.students = students;
    }

    public int getQuantityOfStudents() {
        quantityOfStudents = getStudents().size();
        return quantityOfStudents;
    }
}
