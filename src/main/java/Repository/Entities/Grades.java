package Repository.Entities;

public class Grades {

    int id;

    boolean itsfinal;

    Students student;

    Subjects subject;

    int course;

    int grade;

    String description;

    public Grades(int id, boolean itsfinal, Students student, Subjects subject, int course, int grade, String description) {
        this.id = id;
        this.itsfinal = itsfinal;
        this.student = student;
        this.subject = subject;
        this.course = course;
        this.grade = grade;
        this.description = description;
    }

    public Grades(boolean itsfinal, Students student, Subjects subject, int course, int grade, String description) {
        this.itsfinal = itsfinal;
        this.student = student;
        this.subject = subject;
        this.course = course;
        this.grade = grade;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isItsfinal() {
        return itsfinal;
    }

    public void setItsfinal(boolean itsfinal) {
        this.itsfinal = itsfinal;
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    public Subjects getSubject() {
        return subject;
    }

    public void setSubject(Subjects subject) {
        this.subject = subject;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
