package Repository.Entities;

import DTOs.StudentsDTO;
import DTOs.TeachersDTO;

import javax.security.auth.Subject;
import java.util.List;

public class Classrooms {

    int id;

    String name;

    int course;

    Subjects subject;

    Teachers teacher;

    List<StudentInClassroom> students;

    int quantityOfStudents;

    public Classrooms(int id, String name, int course, Subjects subject, Teachers teacher, List<StudentInClassroom> students, int quantityOfStudents) {
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

    public Subjects getSubject() {
        return subject;
    }

    public void setSubject(Subjects subject) {
        this.subject = subject;
    }

    public Teachers getTeacher() {
        return teacher;
    }

    public void setTeacher(Teachers teacher) {
        this.teacher = teacher;
    }

    public List<StudentInClassroom> getStudents() {
        return students;
    }

    public void setStudents(List<StudentInClassroom> students) {
        this.students = students;
    }

    public int getQuantityOfStudents() {
        return quantityOfStudents;
    }

    public void setQuantityOfStudents(int quantityOfStudents) {
        this.quantityOfStudents = quantityOfStudents;
    }
}