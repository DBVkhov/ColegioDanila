package Repository.Entities;

public class StudentInClassroom {

    int id;

    Students student;

    Classrooms classroom;

    Subjects subject;

    public StudentInClassroom(int id, Students student, Classrooms classroom, Subjects subject) {
        this.id = id;
        this.student = student;
        this.classroom = classroom;
        this.subject = subject;
    }

    public Subjects getSubject() {
        return subject;
    }

    public void setSubject(Subjects subject) {
        this.subject = subject;
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
