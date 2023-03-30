package Repository.Entities;

import java.util.Date;
import java.util.List;

public class Students {

    int id;

    String dni;

    String name;

    Date age;

    int course;

    List<StudentInClassroom> classrooms;

    public Students(int id, String dni, String name, Date age, int course, List<StudentInClassroom> classrooms) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.age = age;
        this.course = course;
        this.classrooms = classrooms;
    }

    public List<StudentInClassroom> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(List<StudentInClassroom> classrooms) {
        this.classrooms = classrooms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

}
