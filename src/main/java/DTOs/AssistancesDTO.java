package DTOs;

import Repository.Entities.Students;
import Repository.Entities.Subjects;

import java.sql.Date;

public class AssistancesDTO {

    private int id;
    private Students student;
    private Subjects subject;
    private boolean assistance;
    private Date dateassistance;

    public AssistancesDTO(int id, Students student, Subjects subject, boolean assistance, Date dateassistance) {
        this.id = id;
        this.student = student;
        this.subject = subject;
        this.assistance = assistance;
        this.dateassistance = dateassistance;
    }

    public AssistancesDTO(Students student, Subjects subject, boolean assistance, Date dateassistance) {
        this.student = student;
        this.subject = subject;
        this.assistance = assistance;
        this.dateassistance = dateassistance;
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

    public boolean isAssistance() {
        return assistance;
    }

    public void setAssistance(boolean assistance) {
        this.assistance = assistance;
    }

    public Date getDateassistance() {
        return dateassistance;
    }

    public void setDateassistance(Date dateassistance) {
        this.dateassistance = dateassistance;
    }

}
