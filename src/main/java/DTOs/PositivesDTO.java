package DTOs;

import Repository.Entities.Students;
import Repository.Entities.Subjects;

import java.sql.Date;

public class PositivesDTO {

    private int id;
    private Students student;
    private Subjects subject;
    private boolean positive;
    private String description;
    private Date dateadded;

    public PositivesDTO(int id, Students student, Subjects subject, boolean positive, String description, Date dateadded) {
        this.id = id;
        this.student = student;
        this.subject = subject;
        this.positive = positive;
        this.description = description;
        this.dateadded = dateadded;
    }

    public PositivesDTO(Students student, Subjects subject, boolean positive, String description, Date dateadded) {
        this.student = student;
        this.subject = subject;
        this.positive = positive;
        this.description = description;
        this.dateadded = dateadded;
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

    public Subjects getSubject() {
        return subject;
    }

    public void setSubject(Subjects subject) {
        this.subject = subject;
    }

    public boolean isPositive() {
        return positive;
    }

    public void setPositive(boolean positive) {
        this.positive = positive;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateadded() {
        return dateadded;
    }

    public void setDateadded(Date dateadded) {
        this.dateadded = dateadded;
    }

}
