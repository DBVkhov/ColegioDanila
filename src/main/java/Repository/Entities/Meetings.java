package Repository.Entities;

import java.sql.Date;

public class Meetings {

    private int id;
    private Students student;
    private Teachers teacher;
    private Date datemeeting;
    private String description;

    public Meetings(int id, Students student, Teachers teacher, Date datemeeting, String description) {
        this.id = id;
        this.student = student;
        this.teacher = teacher;
        this.datemeeting = datemeeting;
        this.description = description;
    }

    public Meetings(Students student, Teachers teacher, Date datemeeting, String description) {
        this.student = student;
        this.teacher = teacher;
        this.datemeeting = datemeeting;
        this.description = description;
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

    public Teachers getTeacher() {
        return teacher;
    }

    public void setTeacher(Teachers teacher) {
        this.teacher = teacher;
    }

    public Date getDatemeeting() {
        return datemeeting;
    }

    public void setDatemeeting(Date datemeeting) {
        this.datemeeting = datemeeting;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
