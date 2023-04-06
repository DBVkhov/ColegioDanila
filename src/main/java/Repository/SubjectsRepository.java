package Repository;

import Repository.Entities.Subjects;
import Repository.Entities.Users;

import static Config.ConfigH2DB.getConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SubjectsRepository {
    private String SUBJECTS = "SUBJECTS";

    public Subjects getSubjectByID(int id) throws SQLException {
        String qr = "SELECT * FROM " + SUBJECTS + " WHERE id = ?";
        PreparedStatement statement = getConnection().prepareStatement(qr);
        statement.setInt(1, id);
        ResultSet resultSet = statement.getResultSet();

        Subjects subject = null;

        while (resultSet.next()){

            int iD = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int course = resultSet.getInt("course");
            String description = resultSet.getString("description");

            subject = new Subjects(iD, name, course, description);
        }

        return subject;

    }

    public List<Subjects> getAllSubjects() throws SQLException {
        String qr = "SELECT * FROM " + SUBJECTS;
        PreparedStatement statement = getConnection().prepareStatement(qr);
        ResultSet resultSet = statement.getResultSet();

        Subjects subject = null;
        List<Subjects> subjects = null;

        while (resultSet.next()){

            int iD = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int course = resultSet.getInt("course");
            String description = resultSet.getString("description");
            subject = new Subjects(iD, name, course, description);
            subjects.add(subject);
        }

        return subjects;

    }

    public void setNewSubjectInDB(Subjects subject){

        try {
            String query = "INSERT INTO "+ SUBJECTS +" (name, course, description) VALUES (?, ?, ?)";
            PreparedStatement statement = getConnection().prepareStatement(query);

            statement.setString(1, subject.getName());
            statement.setInt(2, subject.getCourse());
            statement.setString(3, subject.getDescription());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR in SubjectRepository in setNewSubjectDB");
            throw new RuntimeException(e);
        }

    }

    public void modifySubjectInDB(int id, String name, int course, String description){
        String qr = "UPDATE"+ SUBJECTS +"SET name = ?, course = ?, description = ? WHERE id = ?";
        try{
            PreparedStatement statement = getConnection().prepareStatement(qr);
            statement.setString(1, name);
            statement.setInt(2, course);
            statement.setString(3, description);
            statement.setInt(4, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR in SubjectsRepository in modifySubjectInDB");
        }
    }

    public void deleteSubjectInDB(int id){
        try {

            String query = "DELETE FROM "+ SUBJECTS + " WHERE  id = ?";
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR in SubjectRepository in deleteSubject");
        }
    }

}
