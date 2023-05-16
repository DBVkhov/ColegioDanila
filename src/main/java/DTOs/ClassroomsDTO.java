package DTOs;

import Repository.Entities.StudentsInClassroom;
import Repository.Entities.Subjects;
import Repository.Entities.Teachers;

import java.util.List;

public class ClassroomsDTO {

    private int id;

    private String name;

    private int course;

    private SubjectsDTO subject;

    private TeachersDTO teacher;

    private List<StudentsInClassroomDTO> students;

    private int quantityOfStudents;

    public ClassroomsDTO(int id, String name, int course, SubjectsDTO subject, TeachersDTO teacher, List<StudentsInClassroomDTO> students, int quantityOfStudents) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.subject = subject;
        this.teacher = teacher;
        this.students = students;
        this.quantityOfStudents = quantityOfStudents;
    }

    public ClassroomsDTO(String name, int course, SubjectsDTO subject, TeachersDTO teacher, List<StudentsInClassroomDTO> students, int quantityOfStudents) {
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

    public SubjectsDTO getSubject() {
        return subject;
    }

    public void setSubject(SubjectsDTO subject) {
        this.subject = subject;
    }

    public TeachersDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeachersDTO teacher) {
        this.teacher = teacher;
    }

    public List<StudentsInClassroomDTO> getStudents() {
        return students;
    }

    public void setStudents(List<StudentsInClassroomDTO> students) {
        this.students = students;
    }

    public int getQuantityOfStudents() {
        return quantityOfStudents;
    }

    public void setQuantityOfStudents(int quantityOfStudents) {
        this.quantityOfStudents = quantityOfStudents;
    }
}
