package Repository;

import Repository.Entities.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Config.ConfigH2DB.getConnection;

public class ClassroomsRepository {

    private final String CLASSROOMS = "CLASSROOMS";

    private final SubjectsRepository subjectsRepository = new SubjectsRepository();
    private final TeachersRepository teachersRepository = new TeachersRepository();

    private final StudentsInClassroomsRepository studentsInClassroomsRepository = new StudentsInClassroomsRepository();

    public Classrooms getClassroomByIDFromDB(int id){


        try {
            String query = "SELECT * FROM "+ CLASSROOMS +" WHERE id = ?";
            PreparedStatement statement = getConnection().prepareStatement(query);

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Classrooms classrooms = null;
            List<StudentInClassroom> liststudent;

            while (resultSet.next()) {

                int iD = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int course = resultSet.getInt("course");
                Subjects subject = subjectsRepository.getSubjectByID(resultSet.getInt("idsub"));
                Teachers teacher = teachersRepository.getTeacherByIDFromDB(resultSet.getInt("idteach"));
                int qstudents = resultSet.getInt("qstudents");
                liststudent = studentsInClassroomsRepository.getStudentsClassroomsByClassroomIDFromDB(resultSet.getInt("idcr"));
                classrooms = new Classrooms(iD, name, course, subject, teacher, liststudent, qstudents);
            }
            return classrooms;

        } catch (SQLException e) {
            System.out.println("ERROR in ClassroomRepository in getByID");
            throw new RuntimeException(e);
        }

    }

    public List<Classrooms> getAllClassroomsFromDB(){
        try {
            String query = "SELECT * FROM "+ CLASSROOMS;
            PreparedStatement statement = getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            Classrooms classroom;
            List<Classrooms> classrooms = null;
            List<StudentInClassroom> liststudent;

            while (resultSet.next()) {

                int iD = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int course = resultSet.getInt("course");
                Subjects subject = subjectsRepository.getSubjectByID(resultSet.getInt("idsub"));
                Teachers teacher = teachersRepository.getTeacherByIDFromDB(resultSet.getInt("idteach"));
                int qstudents = resultSet.getInt("qstudents");
                liststudent = studentsInClassroomsRepository.getStudentsClassroomsByClassroomIDFromDB(resultSet.getInt("idcr"));
                classroom = new Classrooms(iD, name, course, subject, teacher, liststudent, qstudents);
                classrooms.add(classroom);
            }
            return classrooms;

        } catch (SQLException e) {
            System.out.println("ERROR in ClassroomRepository in getAllClassroomFromDB");
            throw new RuntimeException(e);
        }
    }

    public void setNewClassroomInDB(Classrooms classroom){

        try {
            String query = "INSERT INTO "+ CLASSROOMS +" (id, ) VALUES (?, ?)";
            PreparedStatement statement = getConnection().prepareStatement(query);

            statement.setInt(1, classroom.getId());
            statement.setString(2, classroom.getPassword());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR in ClassroomRepository in setNewClassroomDB");
            throw new RuntimeException(e);
        }

    }

    public void modifyPasswordClassroomInDB(int id, String password){
        String qr = "UPDATE"+ CLASSROOMS +"SET password = ? WHERE id = ?";
        try{
            PreparedStatement statement = getConnection().prepareStatement(qr);
            statement.setString(1, password);
            statement.setInt(2, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR in ClassroomRepository in modifyPasswordClassroom");
        }
    }

    public void deleteClassroomInDB(int id){
        try {

            String query = "DELETE FROM "+ CLASSROOMS + " WHERE  id = ?";
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR in ClassroomRepository in deleteClassroom");
        }
    }

}
