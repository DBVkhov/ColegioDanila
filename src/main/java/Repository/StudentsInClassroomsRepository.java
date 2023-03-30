package Repository;

import Repository.Entities.Classrooms;
import Repository.Entities.StudentsInClassroom;
import Repository.Entities.Students;
import Repository.Entities.Subjects;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static Config.ConfigH2DB.getConnection;

public class StudentsInClassroomsRepository {

    String STUDENTSINCLASSROOMS = "STUDENTSINCLASSROOMS";

    private final StudentsRepository studentsRepository = new StudentsRepository();
    private final ClassroomsRepository classroomsRepository = new ClassroomsRepository();

    public List<StudentsInClassroom> getStudentsClassroomsByStudentIDFromDB(int id) throws SQLException {
        String qr = "SELECT * FROM " + STUDENTSINCLASSROOMS + " WHERE idstud = ?";
        PreparedStatement statement = getConnection().prepareStatement(qr);

        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        StudentsInClassroom studentInClassroom = null;
        List<StudentsInClassroom> studentInClassrooms = null;

        while(resultSet.next()){
            int iD = resultSet.getInt("id");
            Students student = studentsRepository.getStudentByIDFromDB(resultSet.getInt("idstud"));
            Classrooms classroom = classroomsRepository.getClassroomByIDFromDB(resultSet.getInt("idcr"));
            studentInClassroom = new StudentsInClassroom(iD, student, classroom);
            studentInClassrooms.add(studentInClassroom);
        }

        return studentInClassrooms;

    }

    public List<StudentsInClassroom> getStudentsClassroomsByClassroomIDFromDB(int id) throws SQLException {
        String qr = "SELECT * FROM " + STUDENTSINCLASSROOMS + " WHERE idcr = ?";
        PreparedStatement statement = getConnection().prepareStatement(qr);

        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        StudentsInClassroom studentInClassroom = null;
        List<StudentsInClassroom> studentInClassrooms = null;

        while(resultSet.next()){
            int iD = resultSet.getInt("id");
            Students student = studentsRepository.getStudentByIDFromDB(resultSet.getInt("idstud"));
            Classrooms classroom = classroomsRepository.getClassroomByIDFromDB(resultSet.getInt("idcr"));
            studentInClassroom = new StudentsInClassroom(iD, student, classroom);
            studentInClassrooms.add(studentInClassroom);
        }

        return studentInClassrooms;

    }

    public void setNewStudentInClassroomInDB(Students student, Classrooms classroom){
        try {
            String query = "INSERT INTO "+ STUDENTSINCLASSROOMS +" (idstud, idcr) VALUES (?, ?)";
            PreparedStatement statement = getConnection().prepareStatement(query);

            statement.setInt(1, student.getId());
            statement.setInt(2, classroom.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR in StudentsInClassroomsRepository in setNewStudentInClassroomInDB");
            throw new RuntimeException(e);
        }
    }

    public void deleteStudentInAClassroomInDB(int id){
        try {

            String query = "DELETE FROM "+ STUDENTSINCLASSROOMS + " WHERE  id = ?";
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR in StudentInClassroomRepository in deleteStudentInAClassroomInDB");
        }
    }

}
