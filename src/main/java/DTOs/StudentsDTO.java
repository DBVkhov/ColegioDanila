package DTOs;

import Repository.Entities.StudentsInClassroom;

import java.util.Date;
import java.util.List;

public class StudentsDTO {

    private int id;

    private String dni;

    private String name;

    private Date age;

    private int course;

    private List<StudentsInClassroomDTO> classrooms;

    public StudentsDTO(int id, String dni, String name, Date age, int course, List<StudentsInClassroomDTO> classrooms) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.age = age;
        this.course = course;
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

    public List<StudentsInClassroomDTO> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(List<StudentsInClassroomDTO> classrooms) {
        this.classrooms = classrooms;
    }
}