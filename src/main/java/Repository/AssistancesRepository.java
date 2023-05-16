package Repository;

import Repository.Entities.Assistances;
import Repository.Entities.Students;
import Repository.Entities.Subjects;
import Repository.Entities.Teachers;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Config.ConfigH2DB.getConnection;

public class AssistancesRepository {

    private final String ASSISTANCES = "ASSISTANCES";

    private final StudentsRepository studentsRepository = new StudentsRepository();
    private final SubjectsRepository subjectsRepository = new SubjectsRepository();

    public Assistances getAssistanceByID(int id) throws SQLException {
        String qr = "SELECT * FROM " + ASSISTANCES + " WHERE id = ?";
        PreparedStatement statement = getConnection().prepareStatement(qr);

        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        Assistances assistance = null;

        while(resultSet.next()){
            int iD = resultSet.getInt("id");
            Students student = studentsRepository.getStudentByIDFromDB(resultSet.getInt("idstud"));
            Subjects subject = subjectsRepository.getSubjectByID(resultSet.getInt("idsub"));
            boolean studentAssisted = resultSet.getBoolean("assistance");
            Date dateAssistance = resultSet.getDate("dateassistance");
            assistance = new Assistances(iD, student, subject, studentAssisted, dateAssistance);
        }

        return assistance;
    }

    public List<Assistances> getAssistancesByStudentIDFromDB(Students studt, Subjects subjt) throws SQLException {
        String qr = "SELECT * FROM " + ASSISTANCES + " WHERE idstud = ? AND idsub = ?";
        PreparedStatement statement = getConnection().prepareStatement(qr);
        ResultSet resultSet = statement.executeQuery();

        statement.setInt(1, studt.getId());
        statement.setInt(2, subjt.getId());
        Assistances assistance;
        List<Assistances> assistances = new ArrayList<>();

        while(resultSet.next()){
            int iD = resultSet.getInt("id");
            Students student = studentsRepository.getStudentByIDFromDB(resultSet.getInt("idstud"));
            Subjects subject = subjectsRepository.getSubjectByID(resultSet.getInt("idsub"));
            boolean studentAssisted = resultSet.getBoolean("assistance");
            Date dateAssistance = resultSet.getDate("dateassistance");
            assistance = new Assistances(iD, student, subject, studentAssisted, dateAssistance);
            assistances.add(assistance);
        }

        return assistances;
    }

    public void setNewAssistanceInDB(Assistances assistance){
        try {
            String query = "INSERT INTO "+ ASSISTANCES +" (id, idstud, idsub, assistance, dateassistance) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = getConnection().prepareStatement(query);

            statement.setInt(1, assistance.getId());
            statement.setInt(2, assistance.getStudent().getId());
            statement.setInt(3, assistance.getSubject().getId());
            statement.setBoolean(4, assistance.isAssistance());
            statement.setDate(5, assistance.getDateassistance());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR in AssistancesRepository in setNewAssistanceInDB");
            throw new RuntimeException(e);
        }
    }

    public void modifyAssistanceInDB(Assistances assistance){
        try{
            String qr = "UPDATE "+ ASSISTANCES +" SET idstud = ?, dni = ?, age = ?, idsub = ? WHERE id = ?";
            PreparedStatement statement = getConnection().prepareStatement(qr);
            statement.setString(1, name);
            statement.setString(2, dni);
            statement.setDate(3, (java.sql.Date) age);
            statement.setInt(4, subject.getId());
            statement.setInt(5, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR in TeacherRepository in modifyTeacherInDB");
        }
    }

}
