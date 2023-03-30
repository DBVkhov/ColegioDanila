package Repository.Entities;

public class StudentsInClassroom {

    int id;

    Students student;

    Classrooms classroom;

    public StudentsInClassroom(int id, Students student, Classrooms classroom) {
        this.id = id;
        this.student = student;
        this.classroom = classroom;
    }

    public StudentsInClassroom(Students student, Classrooms classroom) {
        this.student = student;
        this.classroom = classroom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    public Classrooms getClassroom() {
        return classroom;
    }

    public void setClassroom(Classrooms classroom) {
        this.classroom = classroom;
    }
}
