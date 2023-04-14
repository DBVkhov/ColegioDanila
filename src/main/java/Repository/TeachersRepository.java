package Repository;
import static Config.ConfigH2DB.getConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import Repository.Entities.Subjects;
import Repository.Entities.Teachers;

import java.util.List;

public class TeachersRepository {

    private final String TEACHERS = "TEACHERS";

    private final SubjectsRepository subjectsRepository = new SubjectsRepository();

    public Teachers getTeacherByIDFromDB(int id) throws SQLException {

        String qr = "SELECT * FROM " + TEACHERS + " WHERE id = ?";
        PreparedStatement statement = getConnection().prepareStatement(qr);

        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        Teachers teacher = null;

        while(resultSet.next()){
            int iD = resultSet.getInt("id");
            String dni = resultSet.getString("dni");
            String name = resultSet.getString("name");
            Date age = resultSet.getDate("age");
            Subjects subject = subjectsRepository.getSubjectByID(resultSet.getInt("idsub"));
            teacher = new Teachers(iD, dni, name, age, subject);
        }

        return teacher;
    }

    public List<Teachers> getAllTeachersFromDB() throws SQLException {

        String qr = "SELECT * FROM " + TEACHERS;
        PreparedStatement statement = getConnection().prepareStatement(qr);
        ResultSet resultSet = statement.executeQuery();

        Teachers teacher = null;
        List<Teachers> teachers = new ArrayList<>();

        while(resultSet.next()){
            int iD = resultSet.getInt("id");
            String dni = resultSet.getString("dni");
            String name = resultSet.getString("name");
            Date age = resultSet.getDate("age");
            Subjects subject = subjectsRepository.getSubjectByID(resultSet.getInt("idsub"));
            teacher = new Teachers(iD, dni, name, age, subject);
            teachers.add(teacher);
        }
        return teachers;
    }

    public void setNewTeacherInDB(Teachers teacher){

        try {
            String query = "INSERT INTO "+ TEACHERS +" (id, dni, name, age, idsub) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = getConnection().prepareStatement(query);

            statement.setInt(1, teacher.getId());
            statement.setString(2, teacher.getDni());
            statement.setString(3, teacher.getName());
            statement.setDate(4, (java.sql.Date) teacher.getAge());
            statement.setInt(5, teacher.getSubject().getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR in TeacherRepository in setNewTeacherInDB");
            throw new RuntimeException(e);
        }

    }

    public void modifyTeacherInDB(int id, String dni, String name, Date age, Subjects subject){
        String qr = "UPDATE "+ TEACHERS +" SET name = ?, dni = ?, age = ?, idsub = ? WHERE id = ?";
        try{
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

    public void deleteTeacherInDB(int id){
        try {

            String query = "DELETE FROM "+ TEACHERS +" WHERE  id = ?";
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR in TeachersRepository in deleteTeacher");
        }
    }

}
