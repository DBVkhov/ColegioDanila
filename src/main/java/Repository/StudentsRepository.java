package Repository;

import Repository.Entities.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static Config.ConfigH2DB.getConnection;

public class StudentsRepository {

    private final String STUDENTS = "STUDENTS";

    private final String STUDENTSINCLASSROOMS = "STUDENTSINCLASSROOMS";

    private final SubjectsRepository subjectsRepository = new SubjectsRepository();

    public StudentInClassroom getStudentsClassroomsByStudentIDFromDB(int id) throws SQLException {
        String qr = "SELECT * FROM " + STUDENTSINCLASSROOMS + " WHERE idstud = ?";
        PreparedStatement statement = getConnection().prepareStatement(qr);

        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()){
            int iD = resultSet.getInt("id");
            Students student = getStudentByIDFromDB(resultSet.getInt("idstud"));
            Classrooms classroom = get
        }

    }

    public Students getStudentByIDFromDB(int id) throws SQLException {

        String qr = "SELECT * FROM " + STUDENTS + " WHERE id = ?";
        PreparedStatement statement = getConnection().prepareStatement(qr);

        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        Students student = null;

        while(resultSet.next()){
            int iD = resultSet.getInt("id");
            String dni = resultSet.getString("dni");
            String name = resultSet.getString("name");
            Date age = resultSet.getDate("age");
            int course = resultSet.getInt("course");
            student = new Students(iD, dni, name, age, course);
        }

        return student;
    }

    public List<Students> getAllStudentsFromDB() throws SQLException {

        String qr = "SELECT * FROM " + STUDENTS;
        PreparedStatement statement = getConnection().prepareStatement(qr);
        ResultSet resultSet = statement.executeQuery();

        Students student = null;
        List<Students> students = new ArrayList<Students>();

        while(resultSet.next()){
            int iD = resultSet.getInt("id");
            String dni = resultSet.getString("dni");
            String name = resultSet.getString("name");
            Date age = resultSet.getDate("age");
            int course = resultSet.getInt("course");
            student = new Students(iD, dni, name, age, course);
            students.add(student);
        }
        return students;
    }

    public void setNewStudentInDB(Students student){

        try {
            String query = "INSERT INTO "+ STUDENTS +" (id, dni, name, age, course) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = getConnection().prepareStatement(query);

            statement.setInt(1, student.getId());
            statement.setString(2, student.getDni());
            statement.setString(3, student.getName());
            statement.setDate(4, (java.sql.Date) student.getAge());
            statement.setInt(5, student.getCourse());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR in StudentRepository in setNewStudentInDB");
            throw new RuntimeException(e);
        }

    }

    public void modifyStudentInDB(int id, String dni, String name, Date age, int course){
        String qr = "UPDATE "+ STUDENTS +" SET name = ?, dni = ?, age = ?, course = ? WHERE id = ?";
        try{
            PreparedStatement statement = getConnection().prepareStatement(qr);
            statement.setString(1, name);
            statement.setString(2, dni);
            statement.setDate(3, (java.sql.Date) age);
            statement.setInt(4, course);
            statement.setInt(5, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR in StudentRepository in modifyStudentInDB");
        }
    }

    public void deleteStudentInDB(int id){
        try {

            String query = "DELETE FROM "+ STUDENTS +" WHERE  id = ?";
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR in StudentsRepository in deleteStudent");
        }
    }



}
