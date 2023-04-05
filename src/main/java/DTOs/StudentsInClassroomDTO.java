package DTOs;

import Repository.Entities.Classrooms;
import Repository.Entities.Students;

public class StudentsInClassroomDTO {

    int id;

    StudentsDTO student;

    ClassroomsDTO classroom;

    public StudentsInClassroomDTO(StudentsDTO student, ClassroomsDTO classroom) {
        this.student = student;
        this.classroom = classroom;
    }

    public StudentsInClassroomDTO(int id, StudentsDTO student, ClassroomsDTO classroom) {
        this.id = id;
        this.student = student;
        this.classroom = classroom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StudentsDTO getStudent() {
        return student;
    }

    public void setStudent(StudentsDTO student) {
        this.student = student;
    }

    public ClassroomsDTO getClassroom() {
        return classroom;
    }

    public void setClassroom(ClassroomsDTO classroom) {
        this.classroom = classroom;
    }
}